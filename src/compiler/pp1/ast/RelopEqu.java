// generated with ast extension for cup
// version 0.8
// 1/0/2022 21:15:39


package compiler.pp1.ast;

public class RelopEqu extends Relop {

    public RelopEqu () {
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
        buffer.append("RelopEqu(\n");

        buffer.append(tab);
        buffer.append(") [RelopEqu]");
        return buffer.toString();
    }
}
