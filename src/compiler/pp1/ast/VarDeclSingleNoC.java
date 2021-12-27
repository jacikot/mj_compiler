// generated with ast extension for cup
// version 0.8
// 27/11/2021 15:53:21


package compiler.pp1.ast;

public class VarDeclSingleNoC extends VarDeclListNoC {

    private String varName;
    private ArrayBracks ArrayBracks;

    public VarDeclSingleNoC (String varName, ArrayBracks ArrayBracks) {
        this.varName=varName;
        this.ArrayBracks=ArrayBracks;
        if(ArrayBracks!=null) ArrayBracks.setParent(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public ArrayBracks getArrayBracks() {
        return ArrayBracks;
    }

    public void setArrayBracks(ArrayBracks ArrayBracks) {
        this.ArrayBracks=ArrayBracks;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ArrayBracks!=null) ArrayBracks.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ArrayBracks!=null) ArrayBracks.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ArrayBracks!=null) ArrayBracks.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclSingleNoC(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(ArrayBracks!=null)
            buffer.append(ArrayBracks.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclSingleNoC]");
        return buffer.toString();
    }
}
