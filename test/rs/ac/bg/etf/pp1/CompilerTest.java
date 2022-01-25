package rs.ac.bg.etf.pp1;

import java.io.*;

import rs.ac.bg.etf.pp1.ast.Program;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import java_cup.runtime.Symbol;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Scope;
import rs.etf.pp1.symboltable.visitors.SymbolTableVisitor;


public class CompilerTest {

    static {
        DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
        Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
    }

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    private static SymbolTableVisitor visitor;

    public static void tsdump(){
        System.out.println(ANSI_BLUE+"=====================SYMBOL TABLE DUMP========================="+ANSI_RESET);
        if (visitor == null)
            visitor = new MySymbolTableVisitor();
        for (Scope s = Tab.currentScope(); s != null; s = s.getOuter()) {
            s.accept(visitor);
        }
        System.out.println(visitor.getOutput());
    }

    public static void main(String[] args) throws Exception {

        Logger log = Logger.getLogger(MJParserTest.class);

        Reader br = null;
        try {
            File sourceCode = new File(args[0]);
            log.info("Compiling source file: " + sourceCode.getAbsolutePath());

            br = new BufferedReader(new FileReader(sourceCode));
            Yylex lexer = new Yylex(br);

            MJParser p = new MJParser(lexer);
            Symbol s = p.parse();  //pocetak parsiranja

            Program prog = (Program) (s.value);


            // ispis sintaksnog stabla
            log.info(prog.toString(""));

            System.out.println(ANSI_BLUE+"=====================OPORAVAK OD GRESKE========================="+ANSI_RESET);

            ErrorRecovery errorRec=new ErrorRecovery();
            prog.traverseBottomUp(errorRec);

            System.out.println(ANSI_BLUE+"=====================SEMANTICKA OBRADA========================="+ANSI_RESET);

            // ispis prepoznatih programskih konstrukcija
            SemanticAnalyser v = new SemanticAnalyser();
            v.init();
            prog.traverseBottomUp(v);
//            System.out.println(ANSI_BLUE+"=====================SINTAKSNA ANALIZA========================="+ANSI_RESET);
//
////            log.info(" Print count calls = " + v.printCallCount);
////
//            System.out.println(v.constDeclCount +" global constants");
//            System.out.println(v.varDeclCount+" global variables");
//            System.out.println(v.varDeclCountArray +" global arrays");
//            System.out.println(v.methodDeclCountGlobal +" global methods");
//            System.out.println(v.classDeclCount +" inner classes");
//            System.out.println(v.recordDeclCount +" records");
//            System.out.println(v.mainCount +" main method");
            tsdump();
            if(!v.errorDetected&&!p.errorDetected&&v.mainCount>0){
                File objFile = new File(args[1]);
                if(objFile.exists()) objFile.delete();
                CodeGenerator generator=new CodeGenerator(v.nVars);
                prog.traverseBottomUp(generator);
                Code.mainPc=generator.getMainPC();
                Code.write(new FileOutputStream(objFile));
                System.out.println(ANSI_BLUE+"=====================USPESNO========================="+ANSI_RESET);
            }
            else{
                System.out.println(ANSI_RED+"=====================NEUSPESNO=========================");
                if(p.errorDetected) System.out.println("Detektovane su sintaksne greske!");
                if(v.errorDetected) System.out.println("Detektovane su semanticke greske!");
                if(v.mainCount==0) System.out.println("Ne postoji metoda main!"+ANSI_RESET);
            }

        }
        finally {
            if (br != null) try { br.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
        }

    }


}
