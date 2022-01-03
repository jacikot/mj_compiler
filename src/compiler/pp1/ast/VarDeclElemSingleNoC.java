// generated with ast extension for cup
// version 0.8
// 3/0/2022 11:44:52


package compiler.pp1.ast;

public class VarDeclElemSingleNoC extends VarDeclElemNoC {

    private String varName;

    public VarDeclElemSingleNoC (String varName) {
        this.varName=varName;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclElemSingleNoC(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclElemSingleNoC]");
        return buffer.toString();
    }
}
