// generated with ast extension for cup
// version 0.8
// 1/0/2022 19:55:36


package compiler.pp1.ast;

public class ConstDeclSingle extends ConstDeclList {

    private ConstDeclElem ConstDeclElem;

    public ConstDeclSingle (ConstDeclElem ConstDeclElem) {
        this.ConstDeclElem=ConstDeclElem;
        if(ConstDeclElem!=null) ConstDeclElem.setParent(this);
    }

    public ConstDeclElem getConstDeclElem() {
        return ConstDeclElem;
    }

    public void setConstDeclElem(ConstDeclElem ConstDeclElem) {
        this.ConstDeclElem=ConstDeclElem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclElem!=null) ConstDeclElem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclElem!=null) ConstDeclElem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclElem!=null) ConstDeclElem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclSingle(\n");

        if(ConstDeclElem!=null)
            buffer.append(ConstDeclElem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclSingle]");
        return buffer.toString();
    }
}
