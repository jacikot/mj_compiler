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
            log.info("===================================");

            // ispis prepoznatih programskih konstrukcija
            SemanticAnalyser v = new SemanticAnalyser();
            v.init();
            prog.traverseBottomUp(v);

//            log.info(" Print count calls = " + v.printCallCount);
//
            log.info(" Deklarisanih promenljivih ima = " + v.varDeclCount);
            Tab.dump();
        }
        finally {
            if (br != null) try { br.close(); } catch (IOException e1) { log.error(e1.getMessage(), e1); }
        }

    }


}
