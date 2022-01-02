package compiler.pp1;


import org.apache.log4j.Logger;
import compiler.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

import java.util.*;

public class SemanticAnalyser extends VisitorAdaptor {

    static final int RECORD_TYPE=1,CLASS_TYPE=0, CONSTRUCTOR_TYPE=2, METHOD_TYPE=3, EXTENDS_TYPE=4;

    int varDeclCount = 0;
    int varDeclCountArray = 0;
    int constDeclCount=0;
    int classDeclCount=0;
    int recordDeclCount=0;
    int methodDeclCountGlobal=0;
    int mainCount=0;
    boolean errorDetected = false;
    int returnCounter = 0;
    Obj methodDecl=null;
    Obj overriding=null;
    int nVars;
    Type currentType=null;
    Obj retType=null;
    Obj currentTypeDefinition=null;
    Obj thisElem=null;
    MJParser parser;
    int paramsCounter=1;

    Logger log = Logger.getLogger(getClass());


    public void init(){
        Tab.init();
        Obj o=Tab.insert(Obj.Type,"bool",new Struct(Struct.Bool));
        o.setAdr(-1);
        o.setLevel(-1);
        o=Tab.insert(Obj.Type,"void",Tab.noType);
        o.setAdr(-1);
        o.setLevel(-1);
        o=Tab.insert(Obj.Var,"null",Tab.nullType);

    }


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


    @Override
    public void visit(ProgramName name) {
        name.obj= Tab.insert(Obj.Prog,name.getName(), Tab.noType);
        report_info("Pronadjen simbol: "+name.getName(),name);
        Tab.openScope();
    }

    @Override
    public void visit(Program prog) {
        nVars = Tab.currentScope.getnVars();
        Tab.chainLocalSymbols(prog.getProgramName().obj);
        Tab.closeScope();
    }

    @Override
    public void visit(Type type) {
        type.obj = Tab.find(type.getTypeName());
        if(type.obj == Tab.noObj){
            report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola! ", null);
        }else{
            if(Obj.Type == type.obj.getKind()){
                currentType=type;
            }else{
                report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
                type.obj = Tab.noObj;
            }
        }
    }

    public void visit(ConstDeclElemCorrect elem){
        if(currentType==null) return; //vec je greska ispisana
        if(!Tab.find(elem.getVarName()).equals(Tab.noObj)){
            //vec postoji simbol
            report_error("Simbol: Ime " + elem.getVarName() + " je vec deklarisan!", elem);
        }
        else{
            if(elem.getConstLit().obj.getType().assignableTo(currentType.obj.getType())){
                Obj node=Tab.insert(Obj.Con,elem.getVarName(),currentType.obj.getType());
                report_info("Pronadjen simbol: "+elem.getVarName(),elem);
                node.setAdr(elem.getConstLit().obj.getFpPos());
                constDeclCount++;
            }
            else{
                report_error("Greska na liniji "+ elem.getLine()+" : nekompatibilni tipovi pri dodeli vrednosti.", null);
            }
        }

    }

    @Override
    public void visit(DeclConst b) {
        currentType=null;
    }
    @Override
    public void visit(ConstLitNum b) {
        b.obj=new Obj(Obj.Type,"int",Tab.intType);
        b.obj.setFpPos(b.getValue());
    }
    @Override
    public void visit(ConstLitBool b) {
        b.obj=new Obj(Obj.Type,"bool",Tab.find("bool").getType());
        b.obj.setFpPos(b.getValue());
    }
    @Override
    public void visit(ConstLitChar b) {
        b.obj=new Obj(Obj.Type,"char",Tab.charType);
        b.obj.setFpPos(b.getValue().charAt(1));
    }


    @Override
    public void visit(VarDeclGlobalCorrect b) {
        currentType=null;
    }

    @Override
    public void visit(VarDecl b) {
        currentType=null;
    }

    @Override
    public void visit(VarDeclElemArray elem) {
        if(currentType==null) return; //vec je greska ispisana
        if(Tab.currentScope().findSymbol(elem.getVarName())!=null){
            //vec postoji simbol
            report_error("Simbol: Ime " + elem.getVarName() + " je vec deklarisan!", elem);
        }
        else{
            Struct arrayType=new Struct(Struct.Array,currentType.obj.getType());
            Tab.insert(Obj.Var,elem.getVarName(),arrayType);
            report_info("Pronadjen simbol: "+elem.getVarName(),elem);
            varDeclCountArray++;
        }
    }

    @Override
    public void visit(VarDeclElemSingle elem) {
        if(currentType==null) return; //vec je greska ispisana
        if(Tab.currentScope().findSymbol(elem.getVarName())!=null){
            //vec postoji simbol
            report_error("Simbol: Ime " + elem.getVarName() + " je vec deklarisan!", elem);
        }
        else{
            Tab.insert(Obj.Var,elem.getVarName(),currentType.obj.getType());
            report_info("Pronadjen simbol: "+elem.getVarName(),elem);
            varDeclCount++;
        }
    }

    @Override
    public void visit(VarDeclElemArrayNoC elem) {
        if(currentType==null) return; //vec je greska ispisana
        if(Tab.currentScope().findSymbol(elem.getVarName())!=null){
            //vec postoji simbol
            report_error("Simbol: Ime " + elem.getVarName() + " je vec deklarisan!", elem);
        }
        else{
            Struct arrayType=new Struct(Struct.Array,currentType.obj.getType());
            if(methodDecl==null) Tab.insert(Obj.Fld,elem.getVarName(),arrayType);
            else Tab.insert(Obj.Var,elem.getVarName(),arrayType);
            report_info("Pronadjen simbol: "+elem.getVarName(),elem);
            varDeclCountArray++;
        }
    }

    @Override
    public void visit(VarDeclElemSingleNoC elem) {
        if(currentType==null) return; //vec je greska ispisana
        if(Tab.currentScope().findSymbol(elem.getVarName())!=null){
            //vec postoji simbol
            report_error("Simbol: Ime " + elem.getVarName() + " je vec deklarisan!", elem);
        }
        else{
            if(methodDecl==null) Tab.insert(Obj.Fld,elem.getVarName(),currentType.obj.getType());
            else Tab.insert(Obj.Var,elem.getVarName(),currentType.obj.getType());
            report_info("Pronadjen simbol: "+elem.getVarName(),elem);
            varDeclCount++;
        }
    }

    @Override
    public void visit(RecordName name) {
        if(!Tab.find(name.getRecordName()).equals(Tab.noObj)){
            report_error("Simbol: Ime " + name.getRecordName() + " je vec deklarisan!", name);
            name.obj=Tab.noObj;
            Tab.openScope();
            return;
        }
        recordDeclCount++;
        Struct struct=new Struct(Struct.Class);
        name.obj= Tab.insert(Obj.Type,name.getRecordName(), struct);
        currentTypeDefinition=name.obj;
        name.obj.setFpPos(RECORD_TYPE);
        report_info("Pronadjen simbol: "+name.getRecordName(),name);
        Tab.openScope();
    }

    @Override
    public void visit(ClassName name) {
        if(!Tab.find(name.getName()).equals(Tab.noObj)){
            report_error("Simbol: Ime " + name.getName() + " je vec deklarisan!", name);
            name.obj=Tab.noObj;
            Tab.openScope();
            return;
        }
        classDeclCount++;
        Struct struct=new Struct(Struct.Class);
        name.obj= Tab.insert(Obj.Type,name.getName(), struct);
        currentTypeDefinition=name.obj;
        name.obj.setFpPos(CLASS_TYPE);
        report_info("Pronadjen simbol: "+name.getName(),name);
        Tab.openScope();
    }

    @Override
    public void visit(ConstructorName name) {
        if(currentTypeDefinition==null||!name.getName().equals(currentTypeDefinition.getName())){
            report_error("Simbol: Ime " + name.getName() + " nije validno ime konstruktora! ", name);
            Tab.openScope();
            name.obj=Tab.noObj;
            return;
        }
        name.obj= Tab.insert(Obj.Meth,"__"+name.getName(), Tab.noType);
        name.obj.setFpPos(CONSTRUCTOR_TYPE);
        report_info("Pronadjen simbol: "+name.getName(),name);
        Tab.openScope();
        Obj o=Tab.insert(Obj.Var,"this",currentTypeDefinition.getType());
        o.setFpPos(0);
        methodDecl=name.obj;
    }

    @Override
    public void visit(ConstructorDecl decl) {
        if(decl.getConstructorName().obj.equals(Tab.noObj)){
            Tab.closeScope();
            return;
        }
        Tab.chainLocalSymbols(decl.getConstructorName().obj);
        Tab.closeScope();
        if(returnCounter==0 && !methodDecl.getType().equals(Tab.noType)){
            report_error("Metoda: " + decl.getConstructorName().getName()+" nema return naredbu", decl);
        }
        returnCounter=0;
        methodDecl=null;
    }

    @Override
    public void visit(ClassDecl d) {
        if(!d.getClassName().obj.equals(Tab.noObj))Tab.chainLocalSymbols(d.getClassName().obj.getType());
        Tab.closeScope();
        currentTypeDefinition=null;
    }

    private void copyContent(Obj from, Obj to){
        Tab.openScope();
        Collection<Obj> members=from.getLocalSymbols();
        for(Obj o:members){
            Obj newO=Tab.insert(o.getKind(),o.getName(),o.getType());
            newO.setFpPos(o.getFpPos());
        }
        Tab.chainLocalSymbols(to);
        Tab.closeScope();
    }

    @Override
    public void visit(ExtendsDeclType elem) {
        if(currentType==null) return; //vec je greska ispisana
        if(currentType.obj.equals(currentTypeDefinition)){
            report_error("Rekurzija tipova: " + currentType.getTypeName(), elem);
            return;
        }
        if(currentType.obj.getType().getKind()!=Struct.Class || currentType.obj.getFpPos()==RECORD_TYPE){
            report_error("Izvodjenje iz tipa: " + currentType.getTypeName() +" nije moguce! ", elem);
            return;
        }
        currentTypeDefinition.getType().setElementType(currentType.obj.getType());
        Collection<Obj> members=currentType.obj.getType().getMembers();
        for(Obj member:members){
            if(member.getKind()==Obj.Fld){
                Tab.insert(Obj.Fld,member.getName(),member.getType());
            }
            if(member.getKind()==Obj.Meth && (member.getFpPos()&METHOD_TYPE)==METHOD_TYPE){
                Obj o=Tab.insert(Obj.Meth,member.getName(),member.getType());
                o.setFpPos(member.getFpPos()|EXTENDS_TYPE);
                copyContent(member,o);
            }
            if(member.getKind()==Obj.Meth && (member.getFpPos()==CONSTRUCTOR_TYPE)){
                Obj o=Tab.insert(Obj.Meth,"super",member.getType());
                o.setFpPos(member.getFpPos()|EXTENDS_TYPE);
                copyContent(member,o);
            }
        }
        currentType=null;
    }


    @Override
    public void visit(RecordDecl record) {
        if(!record.getRecordName().obj.equals(Tab.noObj)) Tab.chainLocalSymbols(record.getRecordName().obj.getType());
        Tab.closeScope();
        currentTypeDefinition=null;
    }

    @Override
    public void visit(MethodName name) {
        if(retType==null) return; //vec je greska ispisana
        Obj symbol=Tab.currentScope().findSymbol(name.getMethodName());
        if(symbol!=null){
            if(currentTypeDefinition!=null && (symbol.getFpPos()&EXTENDS_TYPE)!=0){ //override metode
                symbol.setFpPos(METHOD_TYPE);
                Tab.openScope();
                paramsCounter=1;
                report_info("Pronadjen simbol: "+name.getMethodName(),name);
                methodDecl=symbol;
                overriding=symbol;
                name.obj=symbol;
                Obj o=Tab.insert(Obj.Var,"this",currentTypeDefinition.getType());
                o.setFpPos(paramsCounter++);
            }
            else{
                report_error("Simbol: Ime " + name.getMethodName() + " je vec deklarisan!", name);
                name.obj=Tab.noObj;
                Tab.openScope();
            }

        }
        else{
            name.obj=Tab.insert(Obj.Meth,name.getMethodName(),retType.getType());
            name.obj.setFpPos(METHOD_TYPE);
            Tab.openScope();
            paramsCounter=1;
            if(currentTypeDefinition!=null){
                Obj o=Tab.insert(Obj.Var,"this",currentTypeDefinition.getType());
                o.setFpPos(paramsCounter++);
                thisElem=o;
            }
            else methodDeclCountGlobal++;
            report_info("Pronadjen simbol: "+name.getMethodName(),name);
            methodDecl=name.obj;
        }
    }


    @Override
    public void visit(FormParsMultipleArray pars) {
        if(currentType==null) return; //vec je greska ispisana
        if(Tab.currentScope().findSymbol(pars.getParName())!=null){
            //vec postoji simbol
            report_error("Simbol: Ime " + pars.getParName() + " je vec deklarisan!", pars);
        }
        else{
            Struct arrayType=new Struct(Struct.Array,currentType.obj.getType());
            if(overriding!=null){
                if(!overriding.getLocalSymbols().stream().anyMatch(e->{
                    return e.getFpPos()==paramsCounter && e.getType().equals(arrayType);
                })){
                    report_error("Tip parametra " + pars.getParName() + " nije jednak tipu parametra base metode!", pars);
                    return;
                }
            }
            Obj arg=Tab.insert(Obj.Var,pars.getParName(),arrayType);
            arg.setFpPos(paramsCounter++);
            report_info("Pronadjen simbol: "+pars.getParName(),pars);

        }
    }

    @Override
    public void visit(FormParsSingleArray pars) {
        if(currentType==null) return; //vec je greska ispisana
        if(Tab.currentScope().findSymbol(pars.getParName())!=null){
            //vec postoji simbol
            report_error("Simbol: Ime " + pars.getParName() + " je vec deklarisan!", pars);
        }
        else{
            Struct arrayType=new Struct(Struct.Array,currentType.obj.getType());
            if(overriding!=null){
                if(!overriding.getLocalSymbols().stream().anyMatch(e->{
                   return e.getFpPos()==paramsCounter && e.getType().equals(arrayType);
                })){
                    report_error("Tip parametra " + pars.getParName() + " nije jednak tipu parametra base metode!", pars);
                    return;
                }
            }
            Obj arg=Tab.insert(Obj.Var,pars.getParName(),arrayType);
            arg.setFpPos(paramsCounter++);
            report_info("Pronadjen simbol: "+pars.getParName(),pars);

        }
    }

    @Override
    public void visit(FormParsMultiple pars) {
        if(currentType==null) return; //vec je greska ispisana
        if(Tab.currentScope().findSymbol(pars.getParName())!=null){
            //vec postoji simbol
            report_error("Simbol: Ime " + pars.getParName() + " je vec deklarisan!", pars);
        }
        else{
            if(overriding!=null){
                if(!overriding.getLocalSymbols().stream().anyMatch(e->{
                    return e.getFpPos()==paramsCounter && e.getType().equals(currentType.obj.getType());
                })){
                    report_error("Tip parametra " + pars.getParName() + " nije jednak tipu parametra base metode!", pars);
                    return;
                }
            }
            Obj arg=Tab.insert(Obj.Var,pars.getParName(),currentType.obj.getType());
            arg.setFpPos(paramsCounter++);
            report_info("Pronadjen simbol: "+pars.getParName(),pars);
        }
    }
    @Override
    public void visit(FormParsSingle pars) {
        if(currentType==null) return; //vec je greska ispisana
        if(Tab.currentScope().findSymbol(pars.getParName())!=null){
            //vec postoji simbol
            report_error("Simbol: Ime " + pars.getParName() + " je vec deklarisan!", pars);
        }
        else{
            if(overriding!=null){
                if(!overriding.getLocalSymbols().stream().anyMatch(e->{
                    return e.getFpPos()==paramsCounter && e.getType().equals(currentType.obj.getType());
                })){
                    report_error("Tip parametra " + pars.getParName() + " nije jednak tipu parametra base metode!", pars);
                    return;
                }
            }
            Obj arg=Tab.insert(Obj.Var,pars.getParName(),currentType.obj.getType());
            arg.setFpPos(paramsCounter++);
            report_info("Pronadjen simbol: "+pars.getParName(),pars);

        }
    }

    @Override
    public void visit(MethodDeclChecker m) {
        m.obj=m.getMethodName().obj;
        if(overriding!=null && !m.obj.equals(Tab.noObj)){
            if(!m.getRetType().obj.getType().compatibleWith(overriding.getType())){
                report_error("Tip metode " + m.getMethodName().getMethodName() + " nije kompatibilan sa povratnim tipom base metode!", m);
            }
        }
        if(m.getMethodName().getMethodName().equals("main") && m.getRetType().obj.getName().equals("void")){
            mainCount++;
        }
    }

    @Override
    public void visit(MethodDeclPar m) {
        retType=null;
        currentType=null;
        if(returnCounter==0 && !methodDecl.getType().equals(Tab.noType)){
            report_error("Metoda: " + m.getMethodDeclChecker().getMethodName().getMethodName()+" nema return naredbu", m);
        }
        returnCounter=0;
        methodDecl=null;
        overriding=null;
        if(!m.getMethodDeclChecker().obj.equals(Tab.noObj)) Tab.chainLocalSymbols(m.getMethodDeclChecker().obj);
        for(List<StmtGoto> unresolved:labelsSearched.values()){
            for(StmtGoto stmt:unresolved){
                report_error("Simbol: Ime " + stmt.getLabel().getLabelName() + " nije deklarisan!", stmt);
            }
        }
        labelsSearched.clear();
        Tab.closeScope();
    }

    @Override
    public void visit(MethodDeclNoPar m) {
        retType=null;
        currentType=null;
        if(returnCounter==0 && !methodDecl.getType().equals(Tab.noType)){
            report_error("Metoda: " + m.getMethodDeclChecker().getMethodName().getMethodName()+" nema return naredbu", m);
        }
        returnCounter=0;
        methodDecl=null;
        overriding=null;
        if(!m.getMethodDeclChecker().obj.equals(Tab.noObj)) Tab.chainLocalSymbols(m.getMethodDeclChecker().obj);
        for(List<StmtGoto> unresolved:labelsSearched.values()){
            for(StmtGoto stmt:unresolved){
                report_error("Simbol: Ime " + stmt.getLabel().getLabelName() + " nije deklarisan!", stmt);
            }
        }
        labelsSearched.clear();
        Tab.closeScope();
    }

    @Override
    public void visit(RetTypeType type) {
        type.obj=type.getType().obj;
        retType=type.obj;
    }

    @Override
    public void visit(RetTypeVoid type) {
        type.obj=Tab.find("void");
        retType=type.obj;
    }

    @Override
    public void visit(LabelDef label) {
        if(!Tab.find(label.getLabel().getLabelName()).equals(Tab.noObj)){
            report_error("Simbol: Ime " + label.getLabel().getLabelName() + " je vec deklarisan!", label);
            return;
        }
        Struct struct=new Struct(Struct.Class);
        Tab.insert(Obj.Con,label.getLabel().getLabelName(), Tab.noType);
        report_info("Pronadjen simbol: "+label.getLabel().getLabelName(),label);
        if(labelsSearched.containsKey(label.getLabel().getLabelName())){
            for(StmtGoto stmt:labelsSearched.remove(label.getLabel().getLabelName())){
                report_info("Upotreba simbola: "+stmt.getLabel().getLabelName()+" prihvacena",stmt);
            }
        }
    }

    private Map<String, List<StmtGoto>> labelsSearched=new HashMap<>();

    @Override
    public void visit(StmtGoto stmt) {
        Obj o=Tab.find(stmt.getLabel().getLabelName());
        if(o.equals(Tab.noObj)){
            //report_error("Simbol: Ime " + stmt.getLabel().getLabelName() + " nije deklarisan!", stmt);
            List<StmtGoto> list=new ArrayList<>();
            list.add(stmt);
            if(!labelsSearched.containsKey(stmt.getLabel().getLabelName()))labelsSearched.put(stmt.getLabel().getLabelName(),list);
            else labelsSearched.get(stmt.getLabel().getLabelName()).add(stmt);
        }
        else{
            if(o.getKind()==Obj.Con && o.getType().equals(Tab.noType)){
                report_info("Upotreba simbola: "+stmt.getLabel().getLabelName(),stmt);
            }
            else{
                report_error("Simbol: Ime " + stmt.getLabel().getLabelName() + " se ne moze koristiti kao labela!", stmt);
            }
        }

    }

    @Override
    public void visit(FactorBool b) {
        b.obj=new Obj(Obj.Type,"bool",Tab.find("bool").getType());
        b.obj.setFpPos(b.getOperand()); //tu je vrednost
    }
    @Override
    public void visit(FactorChar b) {
        b.obj=new Obj(Obj.Type,"char",Tab.charType);
        b.obj.setFpPos(b.getOperand().charAt(1));
    }
    @Override
    public void visit(FactorNumber b) {
        b.obj=new Obj(Obj.Type,"int",Tab.intType);
        b.obj.setFpPos(b.getOperand());
    }
    @Override
    public void visit(FactorObject b) {
        b.obj=Tab.noObj;
        if(b.getType().obj.equals(Tab.noObj)) return;
        if(b.getType().obj.getType().getKind()==Struct.Class){
            b.obj=b.getType().obj;
        }
        else{
            report_error("Tip " + b.getType().getTypeName() + " nije korisnicki definisan tip!", b);
        }
    }
    @Override
    public void visit(FactorArray b) {
        b.obj=Tab.noObj;
        if(b.getType().obj.equals(Tab.noObj)) return;
        if(!b.getExpr().obj.getType().equals(Tab.intType)){
            report_error("Tip " + b.getExpr().obj.getName() + " nije tip int!", b);
        }
        else{
            Struct type=new Struct(Struct.Array,b.getType().obj.getType());
            b.obj=new Obj(Obj.Type,"array",type);
            b.obj.setFpPos(b.getExpr().obj.getFpPos()); //fppos - velicina niza
        }


    }
    @Override
    public void visit(TermSingle b) {
        b.obj=b.getFactor().obj;
    }
    @Override
    public void visit(ExprSingle b) {
        b.obj=b.getTerm().obj;
    }
    @Override
    public void visit(ExprSingleMinus b) {
        b.obj=Tab.noObj;
        if(b.getTerm().obj.getType().equals(Tab.intType)){
            b.obj=b.getTerm().obj;
            b.obj.setFpPos(-b.getTerm().obj.getFpPos());
        }
        else{
            report_error("Operand operatora - nije tipa int!", b);
        }
    }
    @Override
    public void visit(ExprMultiple b) {
        b.obj=Tab.noObj;
        if(b.getExpr().obj.getType().equals(Tab.intType) && b.getTerm().obj.getType().equals(Tab.intType)){
            b.obj=b.getExpr().obj;
            b.obj.setFpPos(b.getExpr().obj.getFpPos()+b.getTerm().obj.getFpPos());
        }
        else{
            report_error("Operandi operatora + nisu tipa int!", b);
        }
    }

    @Override
    public void visit(TermMultiple b) {
        b.obj=Tab.noObj;
        if(b.getFactor().obj.getType().equals(Tab.intType) && b.getTerm().obj.getType().equals(Tab.intType)){
            b.obj=b.getFactor().obj;
            b.obj.setFpPos(b.getFactor().obj.getFpPos()*b.getTerm().obj.getFpPos());
        }
        else{
            report_error("Operandi operatora * nisu tipa int!", b);
        }
    }
    @Override
    public void visit(CondFactMultiple b) {
        b.obj=Tab.noObj;
        int exprKind=b.getExpr().obj.getType().getKind();
        int expr1Kind=b.getExpr1().obj.getType().getKind();
        if(exprKind!=Struct.Class && exprKind!=Struct.Array && exprKind!=Struct.None
                && expr1Kind!=Struct.Class && expr1Kind!=Struct.Array && expr1Kind!=Struct.None
                && b.getExpr().obj.getType().compatibleWith(b.getExpr1().obj.getType())

        ){
            Struct boolstruct=Tab.find("bool").getType();
            b.obj=new Obj(Obj.Type,"bool",boolstruct);
        }
        else{
            if(!b.getExpr().obj.getType().compatibleWith(b.getExpr1().obj.getType()))
                report_error("Operandi nisu kompatibilni!", b);
            else
                report_error("Relacioni operator nije moguce primeniti na korisnicke tipove i nizove!", b);
        }
    }

    @Override
    public void visit(CondFactMultipleEq b) {
        b.obj=Tab.noObj;
        if( b.getExpr().obj.getType().compatibleWith(b.getExpr1().obj.getType())){
            Struct boolstruct=Tab.find("bool").getType();
            b.obj=new Obj(Obj.Type,"bool",boolstruct);
        }
        else{
            report_error("Operandi nisu kompatibilni!", b);
        }
    }
    @Override
    public void visit(CondFactSingle b) {
        b.obj=Tab.noObj;
        if( b.getExpr().obj.getType().equals(Tab.find("bool").getType())){
            Struct boolstruct=Tab.find("bool").getType();
            b.obj=new Obj(Obj.Type,"bool",boolstruct);
        }
        else{
            report_error("Condition mora da bude tipa bool!", b);
        }
    }
    @Override
    public void visit(CondTermMultiple b) {
        if(b.getCondFact().obj.getType().equals(b.getCondTerm().obj.getType()))
            b.obj=b.getCondFact().obj;
        else b.obj=Tab.noObj;
    }
    @Override
    public void visit(CondTermSingle b) {
        b.obj=b.getCondFact().obj;
    }
    @Override
    public void visit(CondMultiple b) {
        if(b.getCond().obj.getType().equals(b.getCondTerm().obj.getType()))
            b.obj=b.getCondTerm().obj;
        else b.obj=Tab.noObj;
    }
    @Override
    public void visit(CondSingle b) {
        b.obj=b.getCondTerm().obj;
    }


    @Override
    public void visit(StmtPrint b) {
        Struct type=b.getExpr().obj.getType();
        if( type.equals(Tab.find("bool").getType())
                || type.equals(Tab.intType) || type.equals(Tab.charType)
        ){
            //sve ok
        }
        else{
            report_error("Argument print naredbe mora da bude int, char ili bool!", b);
        }
    }
    @Override
    public void visit(StmtPrintSize b) {
        Struct type=b.getExpr().obj.getType();
        if( type.equals(Tab.find("bool").getType())
                || type.equals(Tab.intType) || type.equals(Tab.charType)
        ){
            //sve ok
        }
        else{
            report_error("Argument print naredbe mora da bude int, char ili bool!", b);
        }
    }
    @Override
    public void visit(StmtReturn b) {
        Struct type=b.getExpr().obj.getType();
        if(methodDecl!=null && type.equals(methodDecl.getType())){
            returnCounter++;
        }
        else{
            if(methodDecl!=null) report_error("Tip izraza return naredbe nije jednak tipu fje: "+methodDecl.getName()+"!", b);
            else  report_error("Return naredba ne sme postojati izvan funkcije!", b);
        }
    }

    @Override
    public void visit(StmtReturnVoid b) {
        Struct type=Tab.noType;
        if(methodDecl!=null && type.equals(methodDecl.getType())){
            returnCounter++;
        }
        else{
            if(methodDecl!=null) report_error("Tip izraza return naredbe nije jednak tipu fje: "+methodDecl.getName()+"!", b);
            else  report_error("Return naredba ne sme postojati izvan funkcije!", b);
        }
    }


    @Override
    public void visit(ConstDeclError b) {
        report_error("Izvrsen oporavak od greske. ",b);
    }
    @Override
    public void visit(ConstDeclElemError b) {
        report_error("Izvrsen oporavak od greske. ",b);
    }

    @Override
    public void visit(VarDeclGlobalError b) {
        report_error("Izvrsen oporavak od greske. ",b);
    }

    @Override
    public void visit(VarDeclError b) {
        report_error("Izvrsen oporavak od greske. ",b);
    }
    @Override
    public void visit(ClassVarDeclsError b) {
        report_error("Izvrsen oporavak od greske. ",b);
    }
    @Override
    public void visit(ClassDeclsMethodsError b) {
        report_error("Izvrsen oporavak od greske. ",b);
    }

    @Override
    public void visit(ExtendsDeclError b) {
        report_error("Izvrsen oporavak od greske. ",b);
    }

    @Override
    public void visit(FormParsError b) {
        report_error("Izvrsen oporavak od greske. ",b);
    }
    @Override
    public void visit(FormParsSingleError b) {
        report_error("Izvrsen oporavak od greske. ",b);
    }



}