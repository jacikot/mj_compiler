// generated with ast extension for cup
// version 0.8
// 1/0/2022 23:20:12


package compiler.pp1.ast;

public class StmtBreak extends SingleStatement {

    public StmtBreak () {
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
        buffer.append("StmtBreak(\n");

        buffer.append(tab);
        buffer.append(") [StmtBreak]");
        return buffer.toString();
    }
}