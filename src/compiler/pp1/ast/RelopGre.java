// generated with ast extension for cup
// version 0.8
// 3/0/2022 9:58:45


package compiler.pp1.ast;

public class RelopGre extends Relop {

    public RelopGre () {
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
        buffer.append("RelopGre(\n");

        buffer.append(tab);
        buffer.append(") [RelopGre]");
        return buffer.toString();
    }
}
