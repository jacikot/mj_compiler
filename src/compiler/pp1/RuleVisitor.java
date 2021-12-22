package compiler.pp1;


import org.apache.log4j.Logger;
import compiler.pp1.ast.*;

public class RuleVisitor extends VisitorAdaptor {

    int printCallCount = 0;
    int varDeclCount = 0;

    Logger log = Logger.getLogger(getClass());

    public void visit(VarDecl vardecl){
        varDeclCount++;
    }

    public void visit(Unmatched Unmatched) {
        log.info(Unmatched.getClass());
    }
    public void visit(Mulop Mulop) {
        log.info(Mulop.getClass());
    }
    public void visit(FormParList FormParList) {
        log.info(FormParList.getClass());
    }
    public void visit(Matched Matched) {
        log.info(Matched.getClass());
    }
    public void visit(Relop Relop) {
        log.info(Relop.getClass());
    }
    public void visit(DesignStatement DesignStatement) {
        log.info(DesignStatement.getClass());
    }
    public void visit(ConstLit ConstLit) {
        log.info(ConstLit.getClass());
    }
    public void visit(DsgnOp DsgnOp) {
        log.info(DsgnOp.getClass());
    }
    public void visit(StatementList StatementList) {
        log.info(StatementList.getClass());
    }
    public void visit(Addop Addop) {
        log.info(Addop.getClass());
    }
    public void visit(Factor Factor) {
        log.info(Factor.getClass());
    }
    public void visit(PrintSize PrintSize) {
        log.info(PrintSize.getClass());
    }
    public void visit(CondTerm CondTerm) {
        log.info(CondTerm.getClass());
    }
    public void visit(AccessDsgn AccessDsgn) {
        log.info(AccessDsgn.getClass());
    }
    public void visit(DeclList DeclList) {
        log.info(DeclList.getClass());
    }
    public void visit(Designator Designator) {
        log.info(Designator.getClass());
    }
    public void visit(Term Term) {
        log.info(Term.getClass());
    }
    public void visit(RetType RetType) {
        log.info(RetType.getClass());
    }
    public void visit(Statements Statements) {
        log.info(Statements.getClass());
    }
    public void visit(ConstDeclList ConstDeclList) {
        log.info(ConstDeclList.getClass());
    }
    public void visit(ActParsList ActParsList) {
        log.info(ActParsList.getClass());
    }
    public void visit(InnerVarDeclList InnerVarDeclList) {
        log.info(InnerVarDeclList.getClass());
    }
    public void visit(ExtendsDecl ExtendsDecl) {
        log.info(ExtendsDecl.getClass());
    }
    public void visit(ArrayBracks ArrayBracks) {
        log.info(ArrayBracks.getClass());
    }
    public void visit(VarDeclList VarDeclList) {
        log.info(VarDeclList.getClass());
    }
    public void visit(Expr Expr) {
        log.info(Expr.getClass());
    }
    public void visit(Cond Cond) {
        log.info(Cond.getClass());
    }
    public void visit(ActPars ActPars) {
        log.info(ActPars.getClass());
    }
    public void visit(Statement Statement) {
        log.info(Statement.getClass());
    }
    public void visit(ConstDecl ConstDecl) {
        log.info(ConstDecl.getClass());
    }
    public void visit(CondFact CondFact) {
        log.info(CondFact.getClass());
    }
    public void visit(MethodDeclList MethodDeclList) {
        log.info(MethodDeclList.getClass());
    }
    public void visit(InnerMethodBlock InnerMethodBlock) {
        log.info(InnerMethodBlock.getClass());
    }
    public void visit(SingleStatement SingleStatement) {
        log.info(SingleStatement.getClass());
    }
    public void visit(Label Label) { 
        log.info(Label.getClass());}
    public void visit(FactorBlock FactorBlock) {
        log.info(FactorBlock.getClass());
         }
    public void visit(FactorArray FactorArray) { log.info(FactorArray.getClass()); }
    public void visit(FactorObject FactorObject) { log.info(FactorObject.getClass()); }
    public void visit(FactorBool FactorBool) { log.info(FactorBool.getClass()); }
    public void visit(FactorChar FactorChar) { log.info(FactorChar.getClass()); }
    public void visit(FactorNumber FactorNumber) { log.info(FactorNumber.getClass()); }
    public void visit(FactorDsgnCall FactorDsgnCall) { log.info(FactorDsgnCall.getClass()); }
    public void visit(FactorDsgn FactorDsgn) { log.info(FactorDsgn.getClass()); }
    public void visit(TermSingle TermSingle) { log.info(TermSingle.getClass()); }
    public void visit(TermMultiple TermMultiple) { log.info(TermMultiple.getClass()); }
    public void visit(ExprSingleMinus ExprSingleMinus) { log.info(ExprSingleMinus.getClass()); }
    public void visit(ExprSingle ExprSingle) { log.info(ExprSingle.getClass()); }
    public void visit(ExprMultiple ExprMultiple) { log.info(ExprMultiple.getClass()); }
    public void visit(MulopMod MulopMod) { log.info(MulopMod.getClass()); }
    public void visit(MulopDiv MulopDiv) { log.info(MulopDiv.getClass()); }
    public void visit(MulopMul MulopMul) { log.info(MulopMul.getClass()); }
    public void visit(AddopMinus AddopMinus) { log.info(AddopMinus.getClass()); }
    public void visit(AddopPlus AddopPlus) { log.info(AddopPlus.getClass()); }
    public void visit(RelopLee RelopLee) { log.info(RelopLee.getClass()); }
    public void visit(RelopLes RelopLes) { log.info(RelopLes.getClass()); }
    public void visit(RelopGre RelopGre) { log.info(RelopGre.getClass()); }
    public void visit(RelopGrt RelopGrt) { log.info(RelopGrt.getClass()); }
    public void visit(RelopNeq RelopNeq) { log.info(RelopNeq.getClass()); }
    public void visit(RelopEqu RelopEqu) { log.info(RelopEqu.getClass()); }
    public void visit(CondFactSingle CondFactSingle) { log.info(CondFactSingle.getClass()); }
    public void visit(CondFactMultiple CondFactMultiple) { log.info(CondFactMultiple.getClass()); }
    public void visit(CondTermSingle CondTermSingle) { log.info(CondTermSingle.getClass()); }
    public void visit(CondTermMultiple CondTermMultiple) { log.info(CondTermMultiple.getClass()); }
    public void visit(CondSingle CondSingle) { log.info(CondSingle.getClass()); }
    public void visit(CondMultiple CondMultiple) { log.info(CondMultiple.getClass()); }
    public void visit(ActParsSingle ActParsSingle) { log.info(ActParsSingle.getClass()); }
    public void visit(ActParsMultiple ActParsMultiple) { log.info(ActParsMultiple.getClass()); }
    public void visit(Assignop Assignop) { log.info(Assignop.getClass()); }
    public void visit(DsgnOpDec DsgnOpDec) { log.info(DsgnOpDec.getClass()); }
    public void visit(DsgnOpInc DsgnOpInc) { log.info(DsgnOpInc.getClass()); }
    public void visit(DsgnOpCallEmpty DsgnOpCallEmpty) { log.info(DsgnOpCallEmpty.getClass()); }
    public void visit(DsgnOpCallPars DsgnOpCallPars) { log.info(DsgnOpCallPars.getClass()); }
    public void visit(DsgnOpAssign DsgnOpAssign) { log.info(DsgnOpAssign.getClass()); }
    public void visit(AccessDsgnArray AccessDsgnArray) { log.info(AccessDsgnArray.getClass()); }
    public void visit(AccessDsgnField AccessDsgnField) { log.info(AccessDsgnField.getClass()); }
    public void visit(DesignatorFirst DesignatorFirst) { log.info(DesignatorFirst.getClass()); }
    public void visit(DesignatorAccess DesignatorAccess) { log.info(DesignatorAccess.getClass()); }
    public void visit(DesignStmt DesignStmt) { log.info(DesignStmt.getClass()); }
    public void visit(MatchedGoto MatchedGoto) { log.info(MatchedGoto.getClass()); }
    public void visit(MatchedPrint MatchedPrint) { log.info(MatchedPrint.getClass()); }
    public void visit(MatchedPrintSize MatchedPrintSize) { log.info(MatchedPrintSize.getClass()); }
    public void visit(MatchedRead MatchedRead) { log.info(MatchedRead.getClass()); }
    public void visit(MatchedReturn MatchedReturn) { log.info(MatchedReturn.getClass()); }
    public void visit(MatchedContinue MatchedContinue) { log.info(MatchedContinue.getClass()); }
    public void visit(MatchedBreak MatchedBreak) { log.info(MatchedBreak.getClass()); }
    public void visit(MatchedDoWhile MatchedDoWhile) { log.info(MatchedDoWhile.getClass()); }
    public void visit(MatchedDesign MatchedDesign) { log.info(MatchedDesign.getClass()); }
    public void visit(MatchedIfElse MatchedIfElse) { log.info(MatchedIfElse.getClass()); }
    public void visit(UnmatchedIfElse UnmatchedIfElse) { log.info(UnmatchedIfElse.getClass()); }
    public void visit(UnmatchedIf UnmatchedIf) { log.info(UnmatchedIf.getClass()); }
    public void visit(StatementUnmatched StatementUnmatched) { log.info(StatementUnmatched.getClass()); }
    public void visit(StatementMatched StatementMatched) { log.info(StatementMatched.getClass()); }
    public void visit(StatementsBlock StatementsBlock) { log.info(StatementsBlock.getClass()); }
    public void visit(StatementMultiple StatementMultiple) { log.info(StatementMultiple.getClass()); }
    public void visit(StatementSingleLabel StatementSingleLabel) { log.info(StatementSingleLabel.getClass()); }
    public void visit(StatementSingle StatementSingle) { log.info(StatementSingle.getClass()); }
    public void visit(StatementsEmpty StatementsEmpty) { log.info(StatementsEmpty.getClass()); }
    public void visit(StatementsList StatementsList) { log.info(StatementsList.getClass()); }
    public void visit(FormParsSingle FormParsSingle) { log.info(FormParsSingle.getClass()); }
    public void visit(FormParsMultiple FormParsMultiple) { log.info(FormParsMultiple.getClass()); }
    public void visit(RetTypeVoid RetTypeVoid) { log.info(RetTypeVoid.getClass()); }
    public void visit(RetTypeType RetTypeType) { log.info(RetTypeType.getClass()); }
    public void visit(MethodDecl MethodDecl) { log.info(MethodDecl.getClass()); }
    public void visit(MethodDeclsEmpty MethodDeclsEmpty) { log.info(MethodDeclsEmpty.getClass()); }
    public void visit(MethodDecls MethodDecls) { log.info(MethodDecls.getClass()); }
    public void visit(ConstructorDecl ConstructorDecl) { log.info(ConstructorDecl.getClass()); }
    public void visit(RecordDecl RecordDecl) { log.info(RecordDecl.getClass()); }
    public void visit(InnerMethodBlockEmpty InnerMethodBlockEmpty) { log.info(InnerMethodBlockEmpty.getClass()); }
    public void visit(InnerMethodBlockNoConstr InnerMethodBlockNoConstr) { log.info(InnerMethodBlockNoConstr.getClass()); }
    public void visit(InnerMethodBlockAll InnerMethodBlockAll) { log.info(InnerMethodBlockAll.getClass()); }
    public void visit(InnerVarDeclsEmpty InnerVarDeclsEmpty) { log.info(InnerVarDeclsEmpty.getClass()); }
    public void visit(InnerVarDecls InnerVarDecls) { log.info(InnerVarDecls.getClass()); }
    public void visit(ExtendsDeclEmpty ExtendsDeclEmpty) { log.info(ExtendsDeclEmpty.getClass()); }
    public void visit(ExtendsDeclType ExtendsDeclType) { log.info(ExtendsDeclType.getClass()); }
    public void visit(ClassDecl ClassDecl) { log.info(ClassDecl.getClass()); }
    public void visit(BracksEmpty BracksEmpty) { log.info(BracksEmpty.getClass()); }
    public void visit(Bracks Bracks) { log.info(Bracks.getClass()); }
    public void visit(VarDeclSingle VarDeclSingle) { log.info(VarDeclSingle.getClass()); }
    public void visit(VarDeclMultiple VarDeclMultiple) { log.info(VarDeclMultiple.getClass()); }
    public void visit(Type Type) { log.info(Type.getClass()); }
    public void visit(ConstLitChar ConstLitChar) { log.info(ConstLitChar.getClass()); }
    public void visit(ConstLitBool ConstLitBool) { log.info(ConstLitBool.getClass()); }
    public void visit(ConstLitNum ConstLitNum) { log.info(ConstLitNum.getClass()); }
    public void visit(ConstDeclSingle ConstDeclSingle) { log.info(ConstDeclSingle.getClass()); }
    public void visit(ConstDeclMultiple ConstDeclMultiple) { log.info(ConstDeclMultiple.getClass()); }
    public void visit(DeclConst DeclConst) { log.info(DeclConst.getClass()); }
    public void visit(DeclListEmpty DeclListEmpty) { log.info(DeclListEmpty.getClass()); }
    public void visit(DeclListRecord DeclListRecord) { log.info(DeclListRecord.getClass()); }
    public void visit(DeclListClass DeclListClass) { log.info(DeclListClass.getClass()); }
    public void visit(DeclListVar DeclListVar) { log.info(DeclListVar.getClass()); }
    public void visit(DeclListConst DeclListConst) { log.info(DeclListConst.getClass()); }
    public void visit(Program Program) { log.info(Program.getClass()); }

}