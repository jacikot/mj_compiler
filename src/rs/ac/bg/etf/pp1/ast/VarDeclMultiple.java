// generated with ast extension for cup
// version 0.8
// 25/0/2022 19:28:44


package rs.ac.bg.etf.pp1.ast;

public class VarDeclMultiple extends VarDeclList {

    private VarDeclList VarDeclList;
    private VarDeclElem VarDeclElem;

    public VarDeclMultiple (VarDeclList VarDeclList, VarDeclElem VarDeclElem) {
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
        this.VarDeclElem=VarDeclElem;
        if(VarDeclElem!=null) VarDeclElem.setParent(this);
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public VarDeclElem getVarDeclElem() {
        return VarDeclElem;
    }

    public void setVarDeclElem(VarDeclElem VarDeclElem) {
        this.VarDeclElem=VarDeclElem;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclList!=null) VarDeclList.accept(visitor);
        if(VarDeclElem!=null) VarDeclElem.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
        if(VarDeclElem!=null) VarDeclElem.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        if(VarDeclElem!=null) VarDeclElem.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclMultiple(\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclElem!=null)
            buffer.append(VarDeclElem.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclMultiple]");
        return buffer.toString();
    }
}
