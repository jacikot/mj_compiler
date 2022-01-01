package compiler.pp1;


import org.apache.log4j.Logger;
import compiler.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

import java.util.Collection;

public class SemanticAnalyser extends VisitorAdaptor {

    static final int RECORD_TYPE=1,CLASS_TYPE=0, CONSTRUCTOR_TYPE=2, METHOD_TYPE=3, EXTENDS_TYPE=4;
    int printCallCount = 0;
    int varDeclCount = 0;
    int varDeclCountArray = 0;
    int constDeclCount=0;
    boolean errorDetected = false;
    boolean methodDeclActive=false;
    boolean overriding=false;
    int nVars;
    Type currentType=null;
    Obj retType=null;
    Obj currentTypeDefinition=null;
    Obj thisElem=null;
    MJParser parser;
    int paramsCounter=0;

    Logger log = Logger.getLogger(getClass());


    public void init(){
        Tab.init();
        Obj o=Tab.insert(Obj.Type,"bool",new Struct(Struct.Bool));
        o.setAdr(-1);
        o.setLevel(-1);
        o=Tab.insert(Obj.Type,"void",Tab.noType);
        o.setAdr(-1);
        o.setLevel(-1);
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
        b.obj=Tab.find("int");
        b.obj.setFpPos(b.getValue());
    }
    @Override
    public void visit(ConstLitBool b) {
        b.obj=Tab.find("bool");
        b.obj.setFpPos(b.getValue());
    }
    @Override
    public void visit(ConstLitChar b) {
        b.obj=Tab.find("char");
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
            if(!methodDeclActive) Tab.insert(Obj.Fld,elem.getVarName(),arrayType);
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
            if(!methodDeclActive) Tab.insert(Obj.Fld,elem.getVarName(),currentType.obj.getType());
            else Tab.insert(Obj.Var,elem.getVarName(),currentType.obj.getType());
            report_info("Pronadjen simbol: "+elem.getVarName(),elem);
            varDeclCount++;
        }
    }

    @Override
    public void visit(RecordName name) {
        if(!Tab.find(name.getRecordName()).equals(Tab.noObj)){
            report_error("Simbol: Ime " + name.getRecordName() + " je vec deklarisan!", name);
        }
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
        }
        Struct struct=new Struct(Struct.Class);
        name.obj= Tab.insert(Obj.Type,name.getName(), struct);
        currentTypeDefinition=name.obj;
        name.obj.setFpPos(CLASS_TYPE);
        report_info("Pronadjen simbol: "+name.getName(),name);
        Tab.openScope();
    }

    @Override
    public void visit(ConstructorName name) {
        name.obj= Tab.insert(Obj.Meth,"__"+name.getName(), Tab.noType);
        name.obj.setFpPos(CONSTRUCTOR_TYPE);
        report_info("Pronadjen simbol: "+name.getName(),name);
        Tab.openScope();
        Obj o=Tab.insert(Obj.Var,"this",currentTypeDefinition.getType());
        o.setFpPos(0);
        methodDeclActive=true;
    }

    @Override
    public void visit(ConstructorDecl decl) {
        Tab.chainLocalSymbols(decl.getConstructorName().obj);
        Tab.closeScope();
        methodDeclActive=false;
    }

    @Override
    public void visit(ClassDecl d) {
        Tab.chainLocalSymbols(d.getClassName().obj.getType());
        Tab.closeScope();
        currentTypeDefinition=null;
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
            if(member.getKind()==Obj.Meth){
                Obj o=Tab.insert(Obj.Meth,member.getName(),member.getType());
                o.setFpPos(member.getFpPos()|EXTENDS_TYPE);
            }
        }
        currentType=null;
    }


    @Override
    public void visit(RecordDecl record) {
        Tab.chainLocalSymbols(record.getRecordName().obj.getType());
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
                paramsCounter=0;
                report_info("Pronadjen simbol: "+name.getMethodName(),name);
                methodDeclActive=true;
                overriding=true;
                name.obj=symbol;
                Obj o=Tab.insert(Obj.Var,"this",currentTypeDefinition.getType());
                o.setFpPos(paramsCounter++);
            }
            else{
                report_error("Simbol: Ime " + name.getMethodName() + " je vec deklarisan!", name);
            }

        }
        else{
            name.obj=Tab.insert(Obj.Meth,name.getMethodName(),retType.getType());
            name.obj.setFpPos(METHOD_TYPE);
            Tab.openScope();
            paramsCounter=0;
            if(currentTypeDefinition!=null){
                Obj o=Tab.insert(Obj.Var,"this",currentTypeDefinition.getType());
                o.setFpPos(paramsCounter++);
                thisElem=o;
            }
            report_info("Pronadjen simbol: "+name.getMethodName(),name);
            methodDeclActive=true;
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
            Obj arg=Tab.insert(Obj.Var,pars.getParName(),currentType.obj.getType());
            arg.setFpPos(paramsCounter++);
            report_info("Pronadjen simbol: "+pars.getParName(),pars);

        }
    }


    @Override
    public void visit(MethodDeclPar m) {
        retType=null;
        currentType=null;
        methodDeclActive=false;
        overriding=false;
        Tab.chainLocalSymbols(m.getMethodName().obj);
        Tab.closeScope();
    }

    @Override
    public void visit(MethodDeclNoPar m) {
        retType=null;
        currentType=null;
        methodDeclActive=false;
        overriding=false;
        Tab.chainLocalSymbols(m.getMethodName().obj);
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