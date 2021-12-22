// generated with ast extension for cup
// version 0.8
// 22/11/2021 12:56:4


package compiler.pp1.ast;

public class ExtendsDeclEmpty extends ExtendsDecl {

    public ExtendsDeclEmpty () {
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
        buffer.append("ExtendsDeclEmpty(\n");

        buffer.append(tab);
        buffer.append(") [ExtendsDeclEmpty]");
        return buffer.toString();
    }
}
