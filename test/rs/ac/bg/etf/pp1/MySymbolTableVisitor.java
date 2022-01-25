package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Scope;
import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;
import rs.etf.pp1.symboltable.visitors.SymbolTableVisitor;

public class MySymbolTableVisitor extends DumpSymbolTableVisitor {

    private boolean isType=false;

    @Override
    public void visitObjNode(Obj objToVisit) {
        //output.append("[");
        output.append(currentIndent.toString());
        switch (objToVisit.getKind()) {
            case Obj.Con:  output.append("Con "); break;
            case Obj.Var:  output.append("Var "); break;
            case Obj.Type: output.append("Type "); break;
            case Obj.Meth: output.append("Meth "); break;
            case Obj.Fld:  output.append("Fld "); break;
            case Obj.Prog: output.append("Prog "); break;
        }

        output.append(objToVisit.getName());
        output.append(": ");

        if(objToVisit.getKind()==Obj.Type){
            isType=true;
        }

        objToVisit.getType().accept(this);

        output.append(", ");
        output.append(objToVisit.getAdr());
        output.append(", ");
        output.append(objToVisit.getLevel());

        if (objToVisit.getKind() == Obj.Prog || objToVisit.getKind() == Obj.Meth) {
            output.append("\n");
            nextIndentationLevel();
        }

        for (Obj o : objToVisit.getLocalSymbols()) {
            //output.append(currentIndent.toString());
            o.accept(this);
            output.append("\n");
        }

        if(objToVisit.getKind()==Obj.Type && objToVisit.getType().getKind()==Struct.Class){
            output.append("\n");
        }

        if (objToVisit.getKind() == Obj.Prog || objToVisit.getKind() == Obj.Meth)
            previousIndentationLevel();


        //output.append("]");

    }



    @Override
    public void visitStructNode(Struct structToVisit) {
        switch (structToVisit.getKind()) {
            case Struct.None:
                output.append("void");
                break;
            case Struct.Int:
                output.append("int");
                break;
            case Struct.Char:
                output.append("char");
                break;
            case Struct.Bool:
                output.append("bool");
                break;
            case Struct.Array:
                output.append("Arr of ");

                switch (structToVisit.getElemType().getKind()) {
                    case Struct.None:
                        output.append("void");
                        break;
                    case Struct.Int:
                        output.append("int");
                        break;
                    case Struct.Char:
                        output.append("char");
                        break;
                    case Struct.Bool:
                        output.append("bool");
                        break;
                    case Struct.Class:
                        output.append("Class ");
                        Obj scope=new Obj(Obj.Type,"curr_scope",Tab.noType);
                        Tab.chainLocalSymbols(scope);
                        Obj prog=scope.getLocalSymbols().stream().filter(e->{
                            return e.getKind()==Obj.Prog;
                        }).findFirst().orElse(null);
                        if(prog==null) return;
                        for(Obj o:prog.getLocalSymbols()){
                            if(o.getType().equals(structToVisit)){
                                output.append(o.getName());
                                break;
                            }
                        }
                        break;
                }
                break;
            case Struct.Class:
                if(isType){
                    output.append("Class [\n");
                    nextIndentationLevel();
                    isType=false;
                    for (Obj obj : structToVisit.getMembers()) {
                        obj.accept(this);
                        output.append("\n");
                    }
                    previousIndentationLevel();
                    output.append(currentIndent);
                    output.append("]");
                }
                else{
                    output.append("Class ");
                    Obj scope=new Obj(Obj.Type,"curr_scope",Tab.noType);
                    Tab.chainLocalSymbols(scope);
                    Obj prog=scope.getLocalSymbols().stream().filter(e->{
                       return e.getKind()==Obj.Prog;
                    }).findFirst().orElse(null);
                    if(prog==null) return;
                    for(Obj o:prog.getLocalSymbols()){
                        if(o.getType().equals(structToVisit)){
                            output.append(o.getName());
                            break;
                        }
                    }
                }

                break;
        }
    }

    @Override
    public String getOutput() {
        return output.toString();
    }
}
