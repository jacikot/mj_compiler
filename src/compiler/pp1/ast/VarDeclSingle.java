// generated with ast extension for cup
// version 0.8
// 21/11/2021 0:4:57


package compiler.pp1.ast;

public class VarDeclSingle extends VarDeclList {

    private String varName;
    private ArrayBrackets ArrayBrackets;

    public VarDeclSingle (String varName, ArrayBrackets ArrayBrackets) {
        this.varName=varName;
        this.ArrayBrackets=ArrayBrackets;
        if(ArrayBrackets!=null) ArrayBrackets.setParent(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public ArrayBrackets getArrayBrackets() {
        return ArrayBrackets;
    }

    public void setArrayBrackets(ArrayBrackets ArrayBrackets) {
        this.ArrayBrackets=ArrayBrackets;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ArrayBrackets!=null) ArrayBrackets.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ArrayBrackets!=null) ArrayBrackets.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ArrayBrackets!=null) ArrayBrackets.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclSingle(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(ArrayBrackets!=null)
            buffer.append(ArrayBrackets.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclSingle]");
        return buffer.toString();
    }
}
