package compiler.pp1;

import compiler.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void visit(DsgnOpCallPars dsgn) {
        //svi act params su vec na steku
        int offset=dsgn.getCallName().getDesignator().obj.getAdr()-Code.pc;
        Code.put(Code.call);
        Code.put2(offset);

        if(!dsgn.getCallName().getDesignator().obj.getType().equals(Tab.noType)){
            Code.put(Code.pop);
        }
    }
    @Override
    public void visit(DsgnOpCallEmpty dsgn) {
        //svi act params su vec na steku
        int offset=dsgn.getCallName().getDesignator().obj.getAdr()-Code.pc;
        Code.put(Code.call);
        Code.put2(offset);

        if(!dsgn.getCallName().getDesignator().obj.getType().equals(Tab.noType)){
            Code.put(Code.pop);
        }
    }

    @Override
    public void visit(DsgnOpInc dsgn) {
        if(dsgn.getCallName().getDesignator().obj.getKind()==Obj.Elem || dsgn.getCallName().getDesignator().obj.getKind()==Obj.Fld){
            //posto za inc treba i load i store fali nam index i adresa jos jednom
            dsgn.getCallName().getDesignator().traverseBottomUp(this);
        }
        if(dsgn.getCallName().getDesignator().obj.getLevel()==0 ||
                dsgn.getCallName().getDesignator().obj.getKind()==Obj.Elem ||
                dsgn.getCallName().getDesignator().obj.getKind()==Obj.Fld
        ){
            Code.load(dsgn.getCallName().getDesignator().obj);
            Code.loadConst(1);
            Code.put(Code.add);
            Code.store(dsgn.getCallName().getDesignator().obj);
        }
        else{
            Code.put(Code.inc); //ne radi za globalne
            Code.put(dsgn.getCallName().getDesignator().obj.getAdr());
            Code.put(1);
        }

    }

    @Override
    public void visit(DsgnOpDec dsgn) {
        if(dsgn.getCallName().getDesignator().obj.getKind()==Obj.Elem || dsgn.getCallName().getDesignator().obj.getKind()==Obj.Fld){
            //posto za inc treba i load i store fali nam index i adresa jos jednom
            dsgn.getCallName().getDesignator().traverseBottomUp(this);
        }
        if(dsgn.getCallName().getDesignator().obj.getLevel()==0||
                dsgn.getCallName().getDesignator().obj.getKind()==Obj.Elem ||
                dsgn.getCallName().getDesignator().obj.getKind()==Obj.Fld){
            Code.load(dsgn.getCallName().getDesignator().obj);
            Code.loadConst(1);
            Code.put(Code.sub);
            Code.store(dsgn.getCallName().getDesignator().obj);
        }
        else{
            Code.put(Code.inc); //ne radi za globalne
            Code.put(dsgn.getCallName().getDesignator().obj.getAdr());
            Code.put(-1);
        }

    }

    private Map<String,List<Integer>> gotoAdvance=new HashMap<>();


    @Override
    public void visit(LabelDef dsgn) {
        dsgn.getLabel().obj.setAdr(Code.pc);
        if(gotoAdvance.get(dsgn.getLabel().getLabelName())!=null){
            for(Integer adr:gotoAdvance.remove(dsgn.getLabel().getLabelName())){
                Code.fixup(adr);
            }
        }
    }

    @Override
    public void visit(StmtGoto stmt) {
        Code.put(Code.jmp);
        if(stmt.getLabel().obj.getAdr()==-1){
            if(gotoAdvance.get(stmt.getLabel().getLabelName())==null){
                ArrayList<Integer>list=new ArrayList<>();
                list.add(Code.pc);
                gotoAdvance.put(stmt.getLabel().getLabelName(),list);
            }
            else gotoAdvance.get(stmt.getLabel().getLabelName()).add(Code.pc);
            Code.put2(0);
        }
        else{
            int offset=stmt.getLabel().obj.getAdr()-Code.pc+1;
            Code.put2(offset);
        }

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


    public void visit(FactorArray factorArray){
        Code.put(Code.newarray);
        if(factorArray.obj.getType().getElemType().equals(Tab.charType) ||
        factorArray.obj.getType().getElemType().equals(Tab.find("bool").getType())
        ){
            Code.put(0);
        }
        else{
            Code.put(1);
        }
    }
    public void visit(FactorObject object){
        Code.put(Code.new_);
        Code.put2(object.obj.getType().getNumberOfFields()*4);
    }

    public void visit(BaseDsgn base){
        Code.load(base.getDesignator().obj);
    }


}
