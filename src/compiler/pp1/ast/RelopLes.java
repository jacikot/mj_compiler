// generated with ast extension for cup
// version 0.8
// 31/11/2021 17:55:52


package compiler.pp1.ast;

public class RelopLes extends Relop {

    public RelopLes () {
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
        buffer.append("RelopLes(\n");

        buffer.append(tab);
        buffer.append(") [RelopLes]");
        return buffer.toString();
    }
}
