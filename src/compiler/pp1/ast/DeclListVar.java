// generated with ast extension for cup
// version 0.8
// 2/0/2022 16:48:30


package compiler.pp1.ast;

public class DeclListVar extends DeclList {

    private DeclList DeclList;
    private VarDeclGlobal VarDeclGlobal;

    public DeclListVar (DeclList DeclList, VarDeclGlobal VarDeclGlobal) {
        this.DeclList=DeclList;
        if(DeclList!=null) DeclList.setParent(this);
        this.VarDeclGlobal=VarDeclGlobal;
        if(VarDeclGlobal!=null) VarDeclGlobal.setParent(this);
    }

    public DeclList getDeclList() {
        return DeclList;
    }

    public void setDeclList(DeclList DeclList) {
        this.DeclList=DeclList;
    }

    public VarDeclGlobal getVarDeclGlobal() {
        return VarDeclGlobal;
    }

    public void setVarDeclGlobal(VarDeclGlobal VarDeclGlobal) {
        this.VarDeclGlobal=VarDeclGlobal;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DeclList!=null) DeclList.accept(visitor);
        if(VarDeclGlobal!=null) VarDeclGlobal.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DeclList!=null) DeclList.traverseTopDown(visitor);
        if(VarDeclGlobal!=null) VarDeclGlobal.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DeclList!=null) DeclList.traverseBottomUp(visitor);
        if(VarDeclGlobal!=null) VarDeclGlobal.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DeclListVar(\n");

        if(DeclList!=null)
            buffer.append(DeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclGlobal!=null)
            buffer.append(VarDeclGlobal.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DeclListVar]");
        return buffer.toString();
    }
}
