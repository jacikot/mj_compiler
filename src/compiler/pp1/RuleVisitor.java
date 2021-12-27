package compiler.pp1;


import org.apache.log4j.Logger;
import compiler.pp1.ast.*;

public class RuleVisitor extends VisitorAdaptor {

    int printCallCount = 0;
    int varDeclCount = 0;

    Logger log = Logger.getLogger(getClass());

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