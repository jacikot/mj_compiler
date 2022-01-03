// generated with ast extension for cup
// version 0.8
// 3/0/2022 11:20:14


package compiler.pp1.ast;

public class FormParsSingleArray extends FormParList {

    private Type Type;
    private String parName;

    public FormParsSingleArray (Type Type, String parName) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.parName=parName;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getParName() {
        return parName;
    }

    public void setParName(String parName) {
        this.parName=parName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsSingleArray(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+parName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsSingleArray]");
        return buffer.toString();
    }
}
