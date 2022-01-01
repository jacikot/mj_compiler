package compiler.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import compiler.pp1.ast.Program;
import compiler.pp1.util.Log4JUtils;
import java_cup.runtime.Symbol;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import rs.etf.pp1.symboltable.Tab;


public class MJSemanticAnalysisTest {

    static {
        DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
        Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
    }

    public static void main(String[] args) throws Exception {

        Logger log = Logger.getLogger(MJParserTest.class);

        Reader br = null;
        try {
            File sourceCode = new File("test/program_original.mj");
            log.info("Compiling source file: " + sourceCode.getAbsolutePath());

            br = new BufferedReader(new FileReader(sourceCode));
            Yylex lexer = new Yylex(br);

            MJParser p = new MJParser(lexer);
            Symbol s = p.parse();  //pocetak parsiranja

            Program prog = (Program) (s.value);


            // ispis sintaksnog stabla
            log.info(prog.toString(""));
            System.out.println("=====================SEMANTICKA OBRADA=========================");

            // ispis prepoznatih programskih konstrukcija
            SemanticAnalyser v = new SemanticAnalyser();
            v.init();
            prog.traverseBottomUp(v);
            System.out.println("=====================SINTAKSNA ANALIZA=========================");

//            log.info(" Print count calls = " + v.printCallCount);
//
            System.out.println(v.constDeclCount +" global constants");
            System.out.println(v.varDeclCount+" global variables");
            System.out.println(v.varDeclCountArray +" global arrays");
            System.out.println(v.methodDeclCountGlobal +" global methods");
            System.out.println(v.classDeclCount +" inner classes");
            System.out.println(v.recordDeclCount +" records");
            System.out.println(v.mainCount +" main method");
            Tab.dump();
            if(!v.errorDetected&&!p.errorDetected&&v.mainCount>0)
                System.out.println("=====================USPESNO=========================");
            else{
                System.err.println("=====================NEUSPESNO=========================");
                if(p.errorDetected) System.err.println("Detektovane su sintaksne greske!");
                if(v.errorDetected) System.err.println("Detektovane su semanticke greske!");
                if(v.mainCount==0) System.err.println("Ne postoji metoda main!");
            }

        }
        finally {
            if (br != null) try { br.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
        }

    }


}
