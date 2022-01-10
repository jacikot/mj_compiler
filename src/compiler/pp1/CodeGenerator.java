package compiler.pp1;

import compiler.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;

public class CodeGenerator extends VisitorAdaptor {

    private int mainPC;

    public int getMainPC() {
        return mainPC;
    }


    @Override
    public void visit(StmtRead fchar) {
        Code.put(Code.read);
        Code.store(fchar.getDesignator().obj);
    }

    @Override
    public void visit(StmtPrint stmt) {
        if(stmt.getExpr().obj.getType().equals(Tab.charType)){
            Code.loadConst(1);
            Code.put(Code.print);
        }
        else {
            Code.loadConst(5);
            Code.put(Code.print);
        }
    }
    @Override
    public void visit(FactorDsgn dsgn) {
        Code.load(dsgn.getFactorDesignator().getDesignator().obj);
    }

    @Override
    public void visit(FactorDsgnCallEmpty dsgn) {
        int offset=dsgn.getFactorDesignator().getDesignator().obj.getAdr()-Code.pc;
        Code.put(Code.call);
        Code.put2(offset);

        //return je vec stavljeno na stack preko expr
    }
    @Override
    public void visit(FactorDsgnCall dsgn) {
        //svi act params su vec na steku
        int offset=dsgn.getFactorDesignator().getDesignator().obj.getAdr()-Code.pc;
        Code.put(Code.call);
        Code.put2(offset);

        //return je vec stavljeno na stack preko expr
    }



    @Override
    public void visit(TermMultiple term) {
        Counter.OperationSolver solver=new Counter.OperationSolver();
        term.getMulop().traverseTopDown(solver);
        //vec su na steku oba operanda
        switch (solver.getCnt()){
            case 0:
                Code.put(Code.mul);
                break;
            case 1:
                Code.put(Code.div);
                break;
            case 2:
                Code.put(Code.rem);
                break;
        }
    }

    @Override
    public void visit(ExprMultiple term) {
        Counter.OperationSolver solver=new Counter.OperationSolver();
        term.getAddop().traverseTopDown(solver);
        //vec su na steku oba operanda
        switch (solver.getCnt()){
            case 3:
                Code.put(Code.add);
                break;
            case 4:
                Code.put(Code.sub);
                break;
        }
    }
    @Override
    public void visit(ExprSingleMinus term) {
        Code.put(Code.neg);
    }
    @Override
    public void visit(DsgnOpAssign term) {
        Code.store(term.getCallName().getDesignator().obj);
    }


    @Override
    public void visit(FactorNumber num) {
        Obj constant=new Obj(Obj.Con,"x",num.obj.getType());
        constant.setAdr(num.getOperand());
        Code.load(constant);
    }

    @Override
    public void visit(FactorChar fchar) {
        Obj constant=new Obj(Obj.Con,"x",fchar.obj.getType());
        constant.setAdr(fchar.obj.getFpPos());
        Code.load(constant);
    }

    @Override
    public void visit(FactorBool fchar) {
        Obj constant=new Obj(Obj.Con,"x",fchar.obj.getType());
        constant.setAdr(fchar.obj.getFpPos());
        Code.load(constant);
    }


    @Override
    public void visit(MethodName method) {
        method.obj.setAdr(Code.pc);
        if(method.getMethodName().equals("main")){
            mainPC=Code.pc;
        }

        Counter.FormParamCounter fpc=new Counter.FormParamCounter();
        method.getParent().getParent().traverseTopDown(fpc);

        Counter.LocalVarCounter lvc=new Counter.LocalVarCounter();
        method.getParent().getParent().traverseTopDown(lvc);

        Code.put(Code.enter);
        Code.put(fpc.getCnt());
        Code.put(fpc.getCnt()+lvc.getCnt());
    }

    public void visit(MethodDeclPar methodDecl){
        Code.put(Code.exit);
        Code.put(Code.return_);
    }
    public void visit(MethodDeclNoPar methodDecl){
        Code.put(Code.exit);
        Code.put(Code.return_);
    }
}
