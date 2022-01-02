// generated with ast extension for cup
// version 0.8
// 2/0/2022 17:46:42


package compiler.pp1.ast;

public class VarDeclSingleNoC extends VarDeclListNoC {

    private VarDeclElemNoC VarDeclElemNoC;

    public VarDeclSingleNoC (VarDeclElemNoC VarDeclElemNoC) {
        this.VarDeclElemNoC=VarDeclElemNoC;
        if(VarDeclElemNoC!=null) VarDeclElemNoC.setParent(this);
    }

    public VarDeclElemNoC getVarDeclElemNoC() {
        return VarDeclElemNoC;
    }

    public void setVarDeclElemNoC(VarDeclElemNoC VarDeclElemNoC) {
        this.VarDeclElemNoC=VarDeclElemNoC;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclElemNoC!=null) VarDeclElemNoC.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclElemNoC!=null) VarDeclElemNoC.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclElemNoC!=null) VarDeclElemNoC.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclSingleNoC(\n");

        if(VarDeclElemNoC!=null)
            buffer.append(VarDeclElemNoC.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclSingleNoC]");
        return buffer.toString();
    }
}
