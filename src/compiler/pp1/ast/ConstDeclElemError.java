// generated with ast extension for cup
// version 0.8
// 3/0/2022 0:18:54


package compiler.pp1.ast;

public class ConstDeclElemError extends ConstDeclElem {

    public ConstDeclElemError () {
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
        buffer.append("ConstDeclElemError(\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclElemError]");
        return buffer.toString();
    }
}
