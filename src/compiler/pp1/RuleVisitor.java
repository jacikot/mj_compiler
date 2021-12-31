package compiler.pp1;


import org.apache.log4j.Logger;
import compiler.pp1.ast.*;

public class RuleVisitor extends VisitorAdaptor {

    int printCallCount = 0;
    int varDeclCount = 0;
    boolean errorDetected = false;

    Logger log = Logger.getLogger(getClass());


    public void report_error(String message, SyntaxNode info) {
        errorDetected = true;
        StringBuilder msg = new StringBuilder(message);
        int line = (info == null) ? 0: info.getLine();
        if (line != 0)
            msg.append (" na liniji ").append(line);
        log.error(msg.toString());
    }

    public void report_info(String message, SyntaxNode info) {
        StringBuilder msg = new StringBuilder(message);
        int line = (info == null) ? 0: info.getLine();
        if (line != 0)
            msg.append (" na liniji ").append(line);
        log.info(msg.toString());
    }

    public void visit(VarDeclMultiple vardecl){
        varDeclCount++;
    }

    public void visit(VarDeclSingle vardecl){
        varDeclCount++;
    }

    public void visit(VarDeclMultipleNoC vardecl){
        varDeclCount++;
    }

    public void visit(VarDeclSingleNoC vardecl){
        varDeclCount++;
    }




//    public void visit(VarDeclGlobalCorrect vardecl){
//        varDeclCount++;
//    }


}