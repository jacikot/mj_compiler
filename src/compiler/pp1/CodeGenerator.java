package compiler.pp1;

import compiler.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

import java.util.*;
import java.util.stream.Collectors;

public class CodeGenerator extends VisitorAdaptor {

    private int mainPC;
    private int varCnt;

    public CodeGenerator(int cnt){
        varCnt=cnt;
    }

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
        Designator d=dsgn.getFactorDesignator().getDesignator();
        if(d instanceof DesignatorAccessField){
            //base adresa je na steku, argumenata nema
            Code.put(Code.getfield);
            Code.put2(0);
            Code.put(Code.invokevirtual);
            String name=((DesignatorAccessField)d).getField();
            for(int i=0;i<name.length();i++){
                Code.put4(name.charAt(i));
            }
            Code.put4(-1);
        }
        else{
            int offset=dsgn.getFactorDesignator().getDesignator().obj.getAdr()-Code.pc;
            Code.put(Code.call);
            Code.put2(offset);
        }

        //return je vec stavljeno na stack preko expr
    }
    @Override
    public void visit(FactorDsgnCall dsgn) {
        //svi act params su vec na steku
        Designator d=dsgn.getFactorDesignator().getDesignator();
        if(d instanceof DesignatorAccessField){
            d.traverseBottomUp(this);
            //base adresa je na steku sad nakon argumenata
            Code.put(Code.getfield);
            Code.put2(0);
            Code.put(Code.invokevirtual);
            String name=((DesignatorAccessField)d).getField();
            for(int i=0;i<name.length();i++){
                Code.put4(name.charAt(i));
            }
            Code.put4(-1);
            //ocisti staru base adresu

        }
        else{
            int offset=dsgn.getFactorDesignator().getDesignator().obj.getAdr()-Code.pc;
            Code.put(Code.call);
            Code.put2(offset);
        }


        //return je vec stavljeno na stack preko expr
    }

    @Override
    public void visit(DsgnOpCallPars dsgn) {
        //svi act params su vec na steku
        Designator d=dsgn.getCallName().getDesignator();
        if(d instanceof DesignatorAccessField){
            d.traverseBottomUp(this);
            //base adresa je na steku sad nakon argumenata, ona prethodna je this
            Code.put(Code.getfield);
            Code.put2(0);
            Code.put(Code.invokevirtual);
            String name=((DesignatorAccessField)d).getField();
            for(int i=0;i<name.length();i++){
                Code.put4(name.charAt(i));
            }
            Code.put4(-1);
        }
        else {
            int offset=dsgn.getCallName().getDesignator().obj.getAdr()-Code.pc;
            Code.put(Code.call);
            Code.put2(offset);

        }

        if(!dsgn.getCallName().getDesignator().obj.getType().equals(Tab.noType)){
            Code.put(Code.pop);
        }
    }
    @Override
    public void visit(DsgnOpCallEmpty dsgn) {
        //svi act params su vec na steku
        Designator d=dsgn.getCallName().getDesignator();
        if(d instanceof DesignatorAccessField){
            //base adresa je na steku
            Code.put(Code.getfield);
            Code.put2(0);
            Code.put(Code.invokevirtual);
            String name=((DesignatorAccessField)d).getField();
            for(int i=0;i<name.length();i++){
                Code.put4(name.charAt(i));
            }
            Code.put4(-1);
        }
        else{
            int offset=dsgn.getCallName().getDesignator().obj.getAdr()-Code.pc;
            Code.put(Code.call);
            Code.put2(offset);
        }
        if(!dsgn.getCallName().getDesignator().obj.getType().equals(Tab.noType)){
            Code.put(Code.pop);
        }
    }

    @Override
    public void visit(DsgnOpInc dsgn) {
        if(dsgn.getCallName().getDesignator().obj.getKind()==Obj.Elem){
            //posto za inc treba i load i store fali nam index i adresa jos jednom
            Code.put(Code.dup2);
        }
        if(dsgn.getCallName().getDesignator().obj.getKind()==Obj.Fld){
            Code.put(Code.dup);
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
        if(dsgn.getCallName().getDesignator().obj.getKind()==Obj.Elem){
            Code.put(Code.dup2);
        }
        if(dsgn.getCallName().getDesignator().obj.getKind()==Obj.Fld){
            Code.put(Code.dup);
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

    int relop=0;


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
            initVTP();
        }

        Counter.FormParamCounter fpc=new Counter.FormParamCounter();
        method.getParent().getParent().traverseTopDown(fpc);

        Counter.LocalVarCounter lvc=new Counter.LocalVarCounter();
        method.getParent().getParent().traverseTopDown(lvc);


        Code.put(Code.enter);
        Code.put(fpc.getCnt()+((currentType!=null)?1:0));
        Code.put(fpc.getCnt()+lvc.getCnt()+((currentType!=null)?1:0));
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
        if(object.obj.getFpPos()==SemanticAnalyser.RECORD_TYPE) return; //nemaju vtp
        Code.put(Code.dup); //dupliram adresu za potrebe uciatavanja vtp
        if(vtAddresses.get(object.obj.getName())==null){
            if(newAdvance.get(object.obj.getName())==null){
                newAdvance.put(object.obj.getName(),new ArrayList<>());
            }
            newAdvance.get(object.obj.getName()).add(Code.pc+1);
            Code.loadConst(6); //jer ne znamo kolika ce konstanta biti - duzi oblik consta
        }
        else{
            Code.loadConst(vtAddresses.get(object.obj.getName()));
        }
        Code.put(Code.putfield);
        Code.put2(0);
    }



    public void visit(BaseDsgn base){
        Code.load(base.getDesignator().obj);
    }
    public void visit(DesignatorFirst base){
        if(currentType!=null){ //implicinti this
            if(currentType.getType().getMembers().stream().filter(e->{
                return e.getName().equals(base.getDsgnName());
            }).count()>0){
                Code.put(Code.load_n);
            }
        }
    }

    private Map<String,List<Integer>> map=null;
    public Stack<Map<String,List<Integer>>> mapStack=new Stack<>();
    private Stack<Integer> thens=new Stack<>();

    private void jmp(String where,int adr){
        if(map.get(where)==null){
            map.put(where,new ArrayList<>());
        }
        map.get(where).add(adr);
    }


    private void jmpFirstWhile(String where,int adr){
        for(int i=thens.size()-1;i>=0;i--){
            if(thens.get(i)!=-1){
                if(i==thens.size()-1){
                    jmp(where,adr);
                }
                else{
                    if(mapStack.get(i).get(where)==null){
                        mapStack.get(i).put(where,new ArrayList<>());
                    }
                    mapStack.get(i).get(where).add(adr);
                }
                return;
            }
        }
    }

    public void visit(DoStart init){
        if(map!=null){
            mapStack.push(map);
        }
        map=new HashMap<>();
        thens.push(Code.pc);
    }

    public void visit(StmtDoWhile init){
        if(map.get("else")==null) return;
        for(Integer adr:map.remove("else")){
            Code.fixup(adr);
        }
        thens.pop();
        map=(!mapStack.empty())?mapStack.pop():null;
    }
    public void visit(IfInit init){
        if(map!=null){
            mapStack.push(map);
        }
        map=new HashMap<>();
        thens.push(-1);
    }

    public void visit(CondOr or){
        if(map.get("or")==null) return;
        for(Integer adr:map.remove("or")){
            Code.fixup(adr);
        }
    }

    public void visit(IfCond then){
        if(map.get("then")==null) return;
        for(Integer adr:map.remove("then")){
            Code.fixup(adr);
        }
    }

    public void visit(ElseCond elseCond){
        map.put("end",new ArrayList<>());
        map.get("end").add(Code.pc+1);
        Code.putJump(0);
        if(map.get("else")==null) return;
        for(Integer adr:map.remove("else")){
            Code.fixup(adr);
        }
    }

    public void visit(StmtIf elseCond){
        if(map.get("else")==null) return;
        for(Integer adr:map.remove("else")){
            Code.fixup(adr);
        }
        map=(!mapStack.empty())?mapStack.pop():null;
        thens.pop();
    }
    public void visit(StmtIfElse elseCond){
        if(map.get("end")==null) return;
        for(Integer adr:map.remove("end")){
            Code.fixup(adr);
        }
        map=(!mapStack.empty())?mapStack.pop():null;
        thens.pop();
    }
    public void visit(WhileCheck check){
        if(map.get("check")==null) return;
        for(Integer adr:map.remove("check")){
            Code.fixup(adr);
        }
    }



    @Override
    public void visit(CondFactMultiple cond) {
        Counter.RelOperationSolver solver=new Counter.RelOperationSolver();
        cond.getRelop().traverseTopDown(solver);
        if(cond.getParent().getParent().getClass()==CondTermMultiple.class){
            //iza njega se nalazi and, expr su vec na steku
            Code.put(Code.jcc+Code.inverse[solver.getCnt()]); //proveri
            SyntaxNode parent=cond.getParent().getParent();
            while(parent instanceof CondTermMultiple) parent=parent.getParent();
            if(parent.getParent().getClass()==CondMultiple.class){
                //iza niza and se nalazi or
                jmp("or",Code.pc);
                Code.put2(0);
            }
            else{
                //iza niza and se nalazi kraj uslova
                jmp("else",Code.pc);
                Code.put2(0);
            }
        }
        else{
            if(thens.size()>0 && thens.peek()>0){ //do while
                Code.put(Code.jcc+solver.getCnt());
                Code.put2(thens.peek()-Code.pc+1);
                return;
            }
            if(cond.getParent().getParent().getParent().getClass()==CondMultiple.class){
                Code.put(Code.jcc+solver.getCnt()); //proveri
                jmp("then",Code.pc);
                Code.put2(0);
            }
            else{
                Code.put(Code.jcc+Code.inverse[solver.getCnt()]); //proveri
                jmp("else",Code.pc);
                Code.put2(0);
            }

        }
    }

    public void visit(StmtBreak breakstmt){
        Code.put(Code.jmp);
        jmpFirstWhile("else", Code.pc);
        Code.put2(0);
    }
    public void visit(StmtContinue cont){
        Code.put(Code.jmp);
        jmpFirstWhile("check", Code.pc);
        Code.put2(0);
    }



    @Override
    public void visit(CondFactMultipleEq cond) {
        Counter.RelOperationSolver solver=new Counter.RelOperationSolver();
        cond.getRelopEq().traverseTopDown(solver);
        if(cond.getParent().getParent().getClass()==CondTermMultiple.class){
            //iza njega se nalazi and, expr su vec na steku
            Code.put(Code.jcc+Code.inverse[solver.getCnt()]); //proveri
            SyntaxNode parent=cond.getParent().getParent();
            while(parent instanceof CondTermMultiple) parent=parent.getParent();
            if(parent.getParent().getClass()==CondMultiple.class){
                //iza niza and se nalazi or
                jmp("or",Code.pc);
                Code.put2(0);
            }
            else{
                //iza niza and se nalazi kraj uslova
                jmp("else",Code.pc);
                Code.put2(0);
            }
        }
        else{
            if(thens.size()>0&& thens.peek()>0){ //do while
                Code.put(Code.jcc+solver.getCnt());
                Code.put2(thens.peek()-Code.pc+1);
                return;
            }
            if(cond.getParent().getParent().getParent().getClass()==CondMultiple.class){
                Code.put(Code.jcc+solver.getCnt()); //proveri
                jmp("then",Code.pc);
                Code.put2(0);
            }
            else{
                Code.put(Code.jcc+Code.inverse[solver.getCnt()]); //proveri
                jmp("else",Code.pc);
                Code.put2(0);
            }

        }
    }
    @Override
    public void visit(CondFactSingle cond) {
        Code.loadConst(0);
        if(cond.getParent().getParent().getClass()==CondTermMultiple.class){
            //iza njega se nalazi and, expr su vec na steku
            Code.put(Code.jcc+Code.inverse[Code.ne]);
            SyntaxNode parent=cond.getParent().getParent();
            while(parent instanceof CondTermMultiple) parent=parent.getParent();
            if(parent.getParent().getClass()==CondMultiple.class){
                //iza niza and se nalazi or
                jmp("or",Code.pc);
                Code.put2(0);
            }
            else{
                //iza niza and se nalazi kraj uslova
                jmp("else",Code.pc);
                Code.put2(0);
            }
        }
        else{
            if(thens.size()>0 && thens.peek()>0){ //do while
                Code.put(Code.jcc+Code.ne);
                Code.put2(thens.peek()-Code.pc+1);
                return;
            }
            if(cond.getParent().getParent().getParent().getClass()==CondMultiple.class){
                //iza se nalazi ||
                Code.put(Code.jcc+Code.ne); //proveri
                jmp("then",Code.pc);
                Code.put2(0);
            }
            else{
                Code.put(Code.jcc+Code.inverse[Code.ne]); //proveri
                jmp("else",Code.pc);
                Code.put2(0);
            }

        }
    }

    private Map<String, Integer> vtAddresses=new HashMap<>();
    private Map<String, List<Integer>> newAdvance=new HashMap<>();

    @Override
    public void visit(ClassName className) {
        currentType=className.obj;
        Obj currentTypeDef=className.obj;
        Struct base=currentTypeDef.getType().getElemType();
        List<Obj> list=currentTypeDef.getType().getMembers().stream().filter(e->{
            return e.getKind()==Obj.Meth && (e.getFpPos()&SemanticAnalyser.EXTENDS_TYPE)!=0;
        }).collect(Collectors.toList());
        for(Obj method:list){
            Obj baseMeth=base.getMembers().stream().filter(e->{
                return e.getName().equals(method.getName());
            }).findFirst().orElse(null);
            method.setAdr(baseMeth.getAdr());
        }
    }

    private void fillStaticIput(int content){
        Code.loadConst(content);
        Code.put(Code.putstatic);
        Code.put2(varCnt++);
    }

    private void addVtAddressToMap(Obj cls){
        vtAddresses.put(cls.getName(),varCnt);
        if(newAdvance.get(cls.getName())==null) return;
        for(Integer adr:newAdvance.remove(cls.getName())){
            Code.put2(adr,varCnt>>16);
            Code.put2(adr+2,varCnt);
        }
    }

    private Obj program=null;

    private void initVTP(){
        List<Obj> classes=program.getLocalSymbols().stream().filter(e->{
            return e.getKind()==Obj.Type && e.getFpPos()==SemanticAnalyser.CLASS_TYPE;
        }).collect(Collectors.toList());
        for(Obj cls:classes){
            addVtAddressToMap(cls);
            List<Obj> list=cls.getType().getMembers().stream().filter(e->{
                return e.getKind()==Obj.Meth;
            }).collect(Collectors.toList());
            for(Obj method:list){
                String name=method.getName();
                for(int i=0;i<name.length();i++){
                    fillStaticIput(name.charAt(i));
                }
                fillStaticIput(-1);
                fillStaticIput(method.getAdr());
            }
            fillStaticIput(-2);
        }
        Code.dataSize=varCnt;
    }

    @Override
    public void visit(InitVTP init) {
        program=((Program)init.getParent()).getProgramName().obj;
    }

    private Obj currentType=null;
    @Override
    public void visit(ClassDecl ClassDecl) {
        currentType=null;
    }
}
