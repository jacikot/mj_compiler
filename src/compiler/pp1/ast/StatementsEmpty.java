// generated with ast extension for cup
// version 0.8
// 3/0/2022 9:58:45


package compiler.pp1.ast;

public class StatementsEmpty extends StatementList {

    public StatementsEmpty () {
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
        buffer.append("StatementsEmpty(\n");

        buffer.append(tab);
        buffer.append(") [StatementsEmpty]");
        return buffer.toString();
    }
}
