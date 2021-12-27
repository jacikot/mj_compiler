// generated with ast extension for cup
// version 0.8
// 27/11/2021 15:24:34


package compiler.pp1.ast;

public class ExtendsDeclError extends ExtendsDecl {

    public ExtendsDeclError () {
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
        buffer.append("ExtendsDeclError(\n");

        buffer.append(tab);
        buffer.append(") [ExtendsDeclError]");
        return buffer.toString();
    }
}
