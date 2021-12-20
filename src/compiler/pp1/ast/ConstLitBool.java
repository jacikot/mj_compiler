// generated with ast extension for cup
// version 0.8
// 21/11/2021 0:4:57


package compiler.pp1.ast;

public class ConstLitBool extends ConstLit {

    private Boolean value;

    public ConstLitBool (Boolean value) {
        this.value=value;
        if(value!=null) value.setParent(this);
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value=value;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(value!=null) value.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(value!=null) value.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(value!=null) value.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstLitBool(\n");

        if(value!=null)
            buffer.append(value.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstLitBool]");
        return buffer.toString();
    }
}
