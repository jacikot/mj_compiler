// generated with ast extension for cup
// version 0.8
// 27/11/2021 15:24:34


package compiler.pp1.ast;

public class FormParsSingleError extends FormParList {

    public FormParsSingleError () {
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
        buffer.append("FormParsSingleError(\n");

        buffer.append(tab);
        buffer.append(") [FormParsSingleError]");
        return buffer.toString();
    }
}
