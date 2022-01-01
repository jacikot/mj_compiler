// generated with ast extension for cup
// version 0.8
// 1/0/2022 16:58:32


package compiler.pp1.ast;

public class AccessDsgnField extends AccessDsgn {

    private String field;

    public AccessDsgnField (String field) {
        this.field=field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field=field;
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
        buffer.append("AccessDsgnField(\n");

        buffer.append(" "+tab+field);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [AccessDsgnField]");
        return buffer.toString();
    }
}
