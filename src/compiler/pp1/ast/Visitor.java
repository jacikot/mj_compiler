// generated with ast extension for cup
// version 0.8
// 3/0/2022 11:20:14


package compiler.pp1.ast;

public interface Visitor { 

    public void visit(VarDeclListNoC VarDeclListNoC);
    public void visit(VarDeclGlobal VarDeclGlobal);
    public void visit(Unmatched Unmatched);
    public void visit(Xx Xx);
    public void visit(Mulop Mulop);
    public void visit(MethodDecl MethodDecl);
    public void visit(FormParList FormParList);
    public void visit(VarDeclElem VarDeclElem);
    public void visit(Matched Matched);
    public void visit(Relop Relop);
    public void visit(DesignStatement DesignStatement);
    public void visit(ConstLit ConstLit);
    public void visit(DsgnOp DsgnOp);
    public void visit(StatementList StatementList);
    public void visit(ClassVarDecl ClassVarDecl);
    public void visit(Addop Addop);
    public void visit(IfElseBlock IfElseBlock);
    public void visit(Factor Factor);
    public void visit(PrintSize PrintSize);
    public void visit(CondTerm CondTerm);
    public void visit(AccessDsgn AccessDsgn);
    public void visit(DeclList DeclList);
    public void visit(Designator Designator);
    public void visit(Term Term);
    public void visit(RetType RetType);
    public void visit(VarDeclCheck VarDeclCheck);
    public void visit(Statements Statements);
    public void visit(VarDeclElemNoC VarDeclElemNoC);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(ActParsList ActParsList);
    public void visit(InnerVarDeclList InnerVarDeclList);
    public void visit(ExtendsDecl ExtendsDecl);
    public void visit(RelopEq RelopEq);
    public void visit(VarDeclList VarDeclList);
    public void visit(Expr Expr);
    public void visit(Cond Cond);
    public void visit(ActPars ActPars);
    public void visit(ClassDeclList ClassDeclList);
    public void visit(Statement Statement);
    public void visit(ConstDecl ConstDecl);
    public void visit(CondFact CondFact);
    public void visit(MethodDeclList MethodDeclList);
    public void visit(InnerMethodBlock InnerMethodBlock);
    public void visit(ConstDeclElem ConstDeclElem);
    public void visit(SingleStatement SingleStatement);
    public void visit(Label Label);
    public void visit(FactorBlock FactorBlock);
    public void visit(FactorArray FactorArray);
    public void visit(FactorObject FactorObject);
    public void visit(FactorBool FactorBool);
    public void visit(FactorChar FactorChar);
    public void visit(FactorNumber FactorNumber);
    public void visit(FactorDsgnSuperEmpty FactorDsgnSuperEmpty);
    public void visit(FactorDsgnSuper FactorDsgnSuper);
    public void visit(FactorDsgnCallEmpty FactorDsgnCallEmpty);
    public void visit(FactorDsgnCall FactorDsgnCall);
    public void visit(FactorDsgn FactorDsgn);
    public void visit(CopyDsgn CopyDsgn);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(TermSingle TermSingle);
    public void visit(TermMultiple TermMultiple);
    public void visit(ExprSingleMinus ExprSingleMinus);
    public void visit(ExprSingle ExprSingle);
    public void visit(ExprMultiple ExprMultiple);
    public void visit(MulopMod MulopMod);
    public void visit(MulopDiv MulopDiv);
    public void visit(MulopMul MulopMul);
    public void visit(AddopMinus AddopMinus);
    public void visit(AddopPlus AddopPlus);
    public void visit(RelopLee RelopLee);
    public void visit(RelopLes RelopLes);
    public void visit(RelopGre RelopGre);
    public void visit(RelopGrt RelopGrt);
    public void visit(RelopNeq RelopNeq);
    public void visit(RelopEqu RelopEqu);
    public void visit(CondFactSingle CondFactSingle);
    public void visit(CondFactMultipleEq CondFactMultipleEq);
    public void visit(CondFactMultiple CondFactMultiple);
    public void visit(CondTermSingle CondTermSingle);
    public void visit(CondTermMultiple CondTermMultiple);
    public void visit(CondSingle CondSingle);
    public void visit(CondMultiple CondMultiple);
    public void visit(ActParsSingle ActParsSingle);
    public void visit(ActParsMultiple ActParsMultiple);
    public void visit(Assignop Assignop);
    public void visit(CallName CallName);
    public void visit(SuperDsgn SuperDsgn);
    public void visit(DsgnOpDec DsgnOpDec);
    public void visit(DsgnOpInc DsgnOpInc);
    public void visit(DsgnSuperEmpty DsgnSuperEmpty);
    public void visit(DsgnSuperPars DsgnSuperPars);
    public void visit(DsgnOpCallEmpty DsgnOpCallEmpty);
    public void visit(DsgnOpCallPars DsgnOpCallPars);
    public void visit(DsgnOpAssignError DsgnOpAssignError);
    public void visit(DsgnOpAssign DsgnOpAssign);
    public void visit(DesignatorThis DesignatorThis);
    public void visit(DesignatorFirst DesignatorFirst);
    public void visit(DesignatorAccessArray DesignatorAccessArray);
    public void visit(DesignatorAccessField DesignatorAccessField);
    public void visit(DoStart DoStart);
    public void visit(StmtGoto StmtGoto);
    public void visit(StmtPrint StmtPrint);
    public void visit(StmtPrintSize StmtPrintSize);
    public void visit(StmtRead StmtRead);
    public void visit(StmtReturnVoid StmtReturnVoid);
    public void visit(StmtReturn StmtReturn);
    public void visit(StmtContinue StmtContinue);
    public void visit(StmtBreak StmtBreak);
    public void visit(StmtDoWhile StmtDoWhile);
    public void visit(StmtDesign StmtDesign);
    public void visit(StmtIfError StmtIfError);
    public void visit(StmtIf StmtIf);
    public void visit(StmtIfElseError StmtIfElseError);
    public void visit(StmtIfElse StmtIfElse);
    public void visit(StatementsBlock StatementsBlock);
    public void visit(LabelDef LabelDef);
    public void visit(StatementMultiple StatementMultiple);
    public void visit(StatementSingleLabel StatementSingleLabel);
    public void visit(StatementSingle StatementSingle);
    public void visit(StatementsEmpty StatementsEmpty);
    public void visit(StatementsList StatementsList);
    public void visit(FormParsSingleError FormParsSingleError);
    public void visit(FormParsSingle FormParsSingle);
    public void visit(FormParsSingleArray FormParsSingleArray);
    public void visit(FormParsError FormParsError);
    public void visit(FormParsMultiple FormParsMultiple);
    public void visit(FormParsMultipleArray FormParsMultipleArray);
    public void visit(MethodName MethodName);
    public void visit(RetTypeVoid RetTypeVoid);
    public void visit(RetTypeType RetTypeType);
    public void visit(MethodDeclChecker MethodDeclChecker);
    public void visit(MethodDeclNoPar MethodDeclNoPar);
    public void visit(MethodDeclPar MethodDeclPar);
    public void visit(MethodDeclsEmpty MethodDeclsEmpty);
    public void visit(MethodDecls MethodDecls);
    public void visit(ConstructorName ConstructorName);
    public void visit(ConstructorDecl ConstructorDecl);
    public void visit(RecordName RecordName);
    public void visit(RecordDecl RecordDecl);
    public void visit(InnerMethodBlockNoConstr InnerMethodBlockNoConstr);
    public void visit(InnerMethodBlockAll InnerMethodBlockAll);
    public void visit(ClassDeclsEmpty ClassDeclsEmpty);
    public void visit(ClassDeclsMethodsError ClassDeclsMethodsError);
    public void visit(ClassDeclsMethods ClassDeclsMethods);
    public void visit(ClassVarDeclsError ClassVarDeclsError);
    public void visit(ClassVarDecls ClassVarDecls);
    public void visit(InnerVarDeclsEmpty InnerVarDeclsEmpty);
    public void visit(InnerVarDecls InnerVarDecls);
    public void visit(ExtendsDeclEmpty ExtendsDeclEmpty);
    public void visit(ExtendsDeclError ExtendsDeclError);
    public void visit(ExtendsDeclType ExtendsDeclType);
    public void visit(ClassName ClassName);
    public void visit(ClassDecl ClassDecl);
    public void visit(VarDeclError VarDeclError);
    public void visit(VarDeclElemSingle VarDeclElemSingle);
    public void visit(VarDeclElemArray VarDeclElemArray);
    public void visit(VarDeclElemSingleNoC VarDeclElemSingleNoC);
    public void visit(VarDeclElemArrayNoC VarDeclElemArrayNoC);
    public void visit(VarDeclSingle VarDeclSingle);
    public void visit(VarDeclMultiple VarDeclMultiple);
    public void visit(VarDeclSingleNoC VarDeclSingleNoC);
    public void visit(VarDeclMultipleNoC VarDeclMultipleNoC);
    public void visit(VarDeclsCorrect VarDeclsCorrect);
    public void visit(VarDecl VarDecl);
    public void visit(VarDeclGlobalError VarDeclGlobalError);
    public void visit(VarDeclGlobalCorrect VarDeclGlobalCorrect);
    public void visit(Type Type);
    public void visit(ConstLitChar ConstLitChar);
    public void visit(ConstLitBool ConstLitBool);
    public void visit(ConstLitNum ConstLitNum);
    public void visit(ConstDeclElemError ConstDeclElemError);
    public void visit(ConstDeclElemCorrect ConstDeclElemCorrect);
    public void visit(ConstDeclSingle ConstDeclSingle);
    public void visit(ConstDeclMultiple ConstDeclMultiple);
    public void visit(ConstDeclError ConstDeclError);
    public void visit(DeclConst DeclConst);
    public void visit(DeclListEmpty DeclListEmpty);
    public void visit(DeclListRecord DeclListRecord);
    public void visit(DeclListClass DeclListClass);
    public void visit(DeclListVar DeclListVar);
    public void visit(DeclListConst DeclListConst);
    public void visit(ProgramName ProgramName);
    public void visit(Program Program);

}
