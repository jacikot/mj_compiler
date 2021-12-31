package compiler.pp1;


import org.apache.log4j.Logger;
import compiler.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticAnalyser extends VisitorAdaptor {

    int printCallCount = 0;
    int varDeclCount = 0;
    boolean errorDetected = false;
    int nVars;
    Type currentType=null;

    Logger log = Logger.getLogger(getClass());

    public void init(){
        Tab.init();
        Obj o=Tab.insert(Obj.Type,"bool",new Struct(Struct.Bool));
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

    @Override
    public void visit(ProgramName name) {
        name.obj= Tab.insert(Obj.Prog,name.getName(), Tab.noType);
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
        Obj typeNode = Tab.find(type.getTypeName());
        if(typeNode == Tab.noObj){
            report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola! ", null);
            type.struct = Tab.noType;
        }else{
            if(Obj.Type == typeNode.getKind()){
                type.struct = typeNode.getType();
                currentType=type;
            }else{
                report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip!", type);
                type.struct = Tab.noType;
            }
        }
    }

    public void visit(ConstDeclElemCorrect elem){
        if(currentType==null) return; //vec je greska ispisana
        if(Tab.find(elem.getVarName())!=Tab.noObj){
            //vec postoji simbol
            report_error("Simbol: Ime " + elem.getVarName() + " je vec deklarisan!", elem);
        }
        else{
            if(elem.getConstLit().obj.getType().assignableTo(currentType.struct)){
                Obj node=Tab.insert(Obj.Con,elem.getVarName(),currentType.struct);
                node.setAdr(elem.getConstLit().obj.getFpPos());
            }
            else{
                report_error("Greska na liniji "+ elem.getLine()+" : nekompatibilni tipovi pri dodeli vrednosti.", null);
            }
        }

    }

    @Override
    public void visit(ConstDecl b) {
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

}