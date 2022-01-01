// generated with ast extension for cup
// version 0.8
// 1/0/2022 14:23:11


package compiler.pp1.ast;

public abstract class VisitorAdaptor implements Visitor { 

    public void visit(VarDeclListNoC VarDeclListNoC) { }
    public void visit(VarDeclGlobal VarDeclGlobal) { }
    public void visit(Unmatched Unmatched) { }
    public void visit(Xx Xx) { }
    public void visit(Mulop Mulop) { }
    public void visit(MethodDecl MethodDecl) { }
    public void visit(FormParList FormParList) { }
    public void visit(VarDeclElem VarDeclElem) { }
    public void visit(Matched Matched) { }
    public void visit(Relop Relop) { }
    public void visit(DesignStatement DesignStatement) { }
    public void visit(ConstLit ConstLit) { }
    public void visit(DsgnOp DsgnOp) { }
    public void visit(StatementList StatementList) { }
    public void visit(ClassVarDecl ClassVarDecl) { }
    public void visit(Addop Addop) { }
    public void visit(IfElseBlock IfElseBlock) { }
    public void visit(Factor Factor) { }
    public void visit(PrintSize PrintSize) { }
    public void visit(CondTerm CondTerm) { }
    public void visit(AccessDsgn AccessDsgn) { }
    public void visit(DeclList DeclList) { }
    public void visit(Designator Designator) { }
    public void visit(Term Term) { }
    public void visit(VarDeclCheck VarDeclCheck) { }
    public void visit(RetType RetType) { }
    public void visit(Statements Statements) { }
    public void visit(VarDeclElemNoC VarDeclElemNoC) { }
    public void visit(ConstDeclList ConstDeclList) { }
    public void visit(ActParsList ActParsList) { }
    public void visit(InnerVarDeclList InnerVarDeclList) { }
    public void visit(ExtendsDecl ExtendsDecl) { }
    public void visit(ArrayBracks ArrayBracks) { }
    public void visit(VarDeclList VarDeclList) { }
    public void visit(Expr Expr) { }
    public void visit(Cond Cond) { }
    public void visit(ActPars ActPars) { }
    public void visit(ClassDeclList ClassDeclList) { }
    public void visit(Statement Statement) { }
    public void visit(ConstDecl ConstDecl) { }
    public void visit(CondFact CondFact) { }
    public void visit(MethodDeclList MethodDeclList) { }
    public void visit(InnerMethodBlock InnerMethodBlock) { }
    public void visit(ConstDeclElem ConstDeclElem) { }
    public void visit(SingleStatement SingleStatement) { }
    public void visit(Label Label) { visit(); }
    public void visit(FactorBlock FactorBlock) { visit(); }
    public void visit(FactorArray FactorArray) { visit(); }
    public void visit(FactorObject FactorObject) { visit(); }
    public void visit(FactorBool FactorBool) { visit(); }
    public void visit(FactorChar FactorChar) { visit(); }
    public void visit(FactorNumber FactorNumber) { visit(); }
    public void visit(FactorDsgnCall FactorDsgnCall) { visit(); }
    public void visit(FactorDsgn FactorDsgn) { visit(); }
    public void visit(TermSingle TermSingle) { visit(); }
    public void visit(TermMultiple TermMultiple) { visit(); }
    public void visit(ExprSingleMinus ExprSingleMinus) { visit(); }
    public void visit(ExprSingle ExprSingle) { visit(); }
    public void visit(ExprMultiple ExprMultiple) { visit(); }
    public void visit(MulopMod MulopMod) { visit(); }
    public void visit(MulopDiv MulopDiv) { visit(); }
    public void visit(MulopMul MulopMul) { visit(); }
    public void visit(AddopMinus AddopMinus) { visit(); }
    public void visit(AddopPlus AddopPlus) { visit(); }
    public void visit(RelopLee RelopLee) { visit(); }
    public void visit(RelopLes RelopLes) { visit(); }
    public void visit(RelopGre RelopGre) { visit(); }
    public void visit(RelopGrt RelopGrt) { visit(); }
    public void visit(RelopNeq RelopNeq) { visit(); }
    public void visit(RelopEqu RelopEqu) { visit(); }
    public void visit(CondFactSingle CondFactSingle) { visit(); }
    public void visit(CondFactMultiple CondFactMultiple) { visit(); }
    public void visit(CondTermSingle CondTermSingle) { visit(); }
    public void visit(CondTermMultiple CondTermMultiple) { visit(); }
    public void visit(CondSingle CondSingle) { visit(); }
    public void visit(CondMultiple CondMultiple) { visit(); }
    public void visit(ActParsSingle ActParsSingle) { visit(); }
    public void visit(ActParsMultiple ActParsMultiple) { visit(); }
    public void visit(Assignop Assignop) { visit(); }
    public void visit(DsgnOpDec DsgnOpDec) { visit(); }
    public void visit(DsgnOpInc DsgnOpInc) { visit(); }
    public void visit(DsgnOpCallEmpty DsgnOpCallEmpty) { visit(); }
    public void visit(DsgnOpCallPars DsgnOpCallPars) { visit(); }
    public void visit(DsgnOpAssignError DsgnOpAssignError) { visit(); }
    public void visit(DsgnOpAssign DsgnOpAssign) { visit(); }
    public void visit(AccessDsgnArray AccessDsgnArray) { visit(); }
    public void visit(AccessDsgnField AccessDsgnField) { visit(); }
    public void visit(DesignatorFirst DesignatorFirst) { visit(); }
    public void visit(DesignatorAccess DesignatorAccess) { visit(); }
    public void visit(DesignStmt DesignStmt) { visit(); }
    public void visit(IfElseBlockMultiple IfElseBlockMultiple) { visit(); }
    public void visit(IfElseBlockSingle IfElseBlockSingle) { visit(); }
    public void visit(MatchedGoto MatchedGoto) { visit(); }
    public void visit(MatchedPrint MatchedPrint) { visit(); }
    public void visit(MatchedPrintSize MatchedPrintSize) { visit(); }
    public void visit(MatchedRead MatchedRead) { visit(); }
    public void visit(MatchedReturn MatchedReturn) { visit(); }
    public void visit(MatchedContinue MatchedContinue) { visit(); }
    public void visit(MatchedBreak MatchedBreak) { visit(); }
    public void visit(MatchedDoWhile MatchedDoWhile) { visit(); }
    public void visit(MatchedDesign MatchedDesign) { visit(); }
    public void visit(MatchedIfElseError MatchedIfElseError) { visit(); }
    public void visit(MatchedIfElse MatchedIfElse) { visit(); }
    public void visit(UnmatchedIfElseError UnmatchedIfElseError) { visit(); }
    public void visit(UnmatchedIfElse UnmatchedIfElse) { visit(); }
    public void visit(UnmatchedIfError UnmatchedIfError) { visit(); }
    public void visit(UnmatchedIf UnmatchedIf) { visit(); }
    public void visit(StatementUnmatched StatementUnmatched) { visit(); }
    public void visit(StatementMatched StatementMatched) { visit(); }
    public void visit(StatementsBlock StatementsBlock) { visit(); }
    public void visit(StatementMultiple StatementMultiple) { visit(); }
    public void visit(StatementSingleLabel StatementSingleLabel) { visit(); }
    public void visit(StatementSingle StatementSingle) { visit(); }
    public void visit(StatementsEmpty StatementsEmpty) { visit(); }
    public void visit(StatementsList StatementsList) { visit(); }
    public void visit(FormParsSingleError FormParsSingleError) { visit(); }
    public void visit(FormParsSingle FormParsSingle) { visit(); }
    public void visit(FormParsError FormParsError) { visit(); }
    public void visit(FormParsMultiple FormParsMultiple) { visit(); }
    public void visit(RetTypeVoid RetTypeVoid) { visit(); }
    public void visit(RetTypeType RetTypeType) { visit(); }
    public void visit(MethodDeclNoPar MethodDeclNoPar) { visit(); }
    public void visit(MethodDeclPar MethodDeclPar) { visit(); }
    public void visit(MethodDeclsEmpty MethodDeclsEmpty) { visit(); }
    public void visit(MethodDecls MethodDecls) { visit(); }
    public void visit(ConstructorName ConstructorName) { visit(); }
    public void visit(ConstructorDecl ConstructorDecl) { visit(); }
    public void visit(RecordName RecordName) { visit(); }
    public void visit(RecordDecl RecordDecl) { visit(); }
    public void visit(InnerMethodBlockNoConstr InnerMethodBlockNoConstr) { visit(); }
    public void visit(InnerMethodBlockAll InnerMethodBlockAll) { visit(); }
    public void visit(ClassDeclsEmpty ClassDeclsEmpty) { visit(); }
    public void visit(ClassDeclsMethodsError ClassDeclsMethodsError) { visit(); }
    public void visit(ClassDeclsMethods ClassDeclsMethods) { visit(); }
    public void visit(ClassVarDeclsError ClassVarDeclsError) { visit(); }
    public void visit(ClassVarDecls ClassVarDecls) { visit(); }
    public void visit(InnerVarDeclsEmpty InnerVarDeclsEmpty) { visit(); }
    public void visit(InnerVarDecls InnerVarDecls) { visit(); }
    public void visit(ExtendsDeclEmpty ExtendsDeclEmpty) { visit(); }
    public void visit(ExtendsDeclError ExtendsDeclError) { visit(); }
    public void visit(ExtendsDeclType ExtendsDeclType) { visit(); }
    public void visit(ClassName ClassName) { visit(); }
    public void visit(ClassDecl ClassDecl) { visit(); }
    public void visit(BracksEmpty BracksEmpty) { visit(); }
    public void visit(Bracks Bracks) { visit(); }
    public void visit(VarDeclError VarDeclError) { visit(); }
    public void visit(VarDeclElemSingle VarDeclElemSingle) { visit(); }
    public void visit(VarDeclElemArray VarDeclElemArray) { visit(); }
    public void visit(VarDeclElemSingleNoC VarDeclElemSingleNoC) { visit(); }
    public void visit(VarDeclElemArrayNoC VarDeclElemArrayNoC) { visit(); }
    public void visit(VarDeclSingle VarDeclSingle) { visit(); }
    public void visit(VarDeclMultiple VarDeclMultiple) { visit(); }
    public void visit(VarDeclSingleNoC VarDeclSingleNoC) { visit(); }
    public void visit(VarDeclMultipleNoC VarDeclMultipleNoC) { visit(); }
    public void visit(VarDeclsCorrect VarDeclsCorrect) { visit(); }
    public void visit(VarDecl VarDecl) { visit(); }
    public void visit(VarDeclGlobalError VarDeclGlobalError) { visit(); }
    public void visit(VarDeclGlobalCorrect VarDeclGlobalCorrect) { visit(); }
    public void visit(Type Type) { visit(); }
    public void visit(ConstLitChar ConstLitChar) { visit(); }
    public void visit(ConstLitBool ConstLitBool) { visit(); }
    public void visit(ConstLitNum ConstLitNum) { visit(); }
    public void visit(ConstDeclElemError ConstDeclElemError) { visit(); }
    public void visit(ConstDeclElemCorrect ConstDeclElemCorrect) { visit(); }
    public void visit(ConstDeclSingle ConstDeclSingle) { visit(); }
    public void visit(ConstDeclMultiple ConstDeclMultiple) { visit(); }
    public void visit(ConstDeclError ConstDeclError) { visit(); }
    public void visit(DeclConst DeclConst) { visit(); }
    public void visit(DeclListEmpty DeclListEmpty) { visit(); }
    public void visit(DeclListRecord DeclListRecord) { visit(); }
    public void visit(DeclListClass DeclListClass) { visit(); }
    public void visit(DeclListVar DeclListVar) { visit(); }
    public void visit(DeclListConst DeclListConst) { visit(); }
    public void visit(ProgramName ProgramName) { visit(); }
    public void visit(Program Program) { visit(); }


    public void visit() { }
}
