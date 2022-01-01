// generated with ast extension for cup
// version 0.8
// 1/0/2022 14:23:11


package compiler.pp1.ast;

public class FormParsMultiple extends FormParList {

    private FormParList FormParList;
    private Type Type;
    private String parName;
    private ArrayBracks ArrayBracks;

    public FormParsMultiple (FormParList FormParList, Type Type, String parName, ArrayBracks ArrayBracks) {
        this.FormParList=FormParList;
        if(FormParList!=null) FormParList.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.parName=parName;
        this.ArrayBracks=ArrayBracks;
        if(ArrayBracks!=null) ArrayBracks.setParent(this);
    }

    public FormParList getFormParList() {
        return FormParList;
    }

    public void setFormParList(FormParList FormParList) {
        this.FormParList=FormParList;
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

    public ArrayBracks getArrayBracks() {
        return ArrayBracks;
    }

    public void setArrayBracks(ArrayBracks ArrayBracks) {
        this.ArrayBracks=ArrayBracks;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParList!=null) FormParList.accept(visitor);
        if(Type!=null) Type.accept(visitor);
        if(ArrayBracks!=null) ArrayBracks.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParList!=null) FormParList.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ArrayBracks!=null) ArrayBracks.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParList!=null) FormParList.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ArrayBracks!=null) ArrayBracks.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsMultiple(\n");

        if(FormParList!=null)
            buffer.append(FormParList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+parName);
        buffer.append("\n");

        if(ArrayBracks!=null)
            buffer.append(ArrayBracks.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsMultiple]");
        return buffer.toString();
    }
}
