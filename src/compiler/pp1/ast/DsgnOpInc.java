// generated with ast extension for cup
// version 0.8
// 21/11/2021 0:4:57


package compiler.pp1.ast;

public class DsgnOpInc extends DsgnOp {

    public DsgnOpInc () {
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
        buffer.append("DsgnOpInc(\n");

        buffer.append(tab);
        buffer.append(") [DsgnOpInc]");
        return buffer.toString();
    }
}
