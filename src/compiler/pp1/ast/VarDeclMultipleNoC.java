// generated with ast extension for cup
// version 0.8
// 2/0/2022 17:46:42


package compiler.pp1.ast;

public class VarDeclMultipleNoC extends VarDeclListNoC {

    private VarDeclListNoC VarDeclListNoC;
    private VarDeclElemNoC VarDeclElemNoC;

    public VarDeclMultipleNoC (VarDeclListNoC VarDeclListNoC, VarDeclElemNoC VarDeclElemNoC) {
        this.VarDeclListNoC=VarDeclListNoC;
        if(VarDeclListNoC!=null) VarDeclListNoC.setParent(this);
        this.VarDeclElemNoC=VarDeclElemNoC;
        if(VarDeclElemNoC!=null) VarDeclElemNoC.setParent(this);
    }

    public VarDeclListNoC getVarDeclListNoC() {
        return VarDeclListNoC;
    }

    public void setVarDeclListNoC(VarDeclListNoC VarDeclListNoC) {
        this.VarDeclListNoC=VarDeclListNoC;
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
        if(VarDeclListNoC!=null) VarDeclListNoC.accept(visitor);
        if(VarDeclElemNoC!=null) VarDeclElemNoC.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclListNoC!=null) VarDeclListNoC.traverseTopDown(visitor);
        if(VarDeclElemNoC!=null) VarDeclElemNoC.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclListNoC!=null) VarDeclListNoC.traverseBottomUp(visitor);
        if(VarDeclElemNoC!=null) VarDeclElemNoC.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclMultipleNoC(\n");

        if(VarDeclListNoC!=null)
            buffer.append(VarDeclListNoC.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclElemNoC!=null)
            buffer.append(VarDeclElemNoC.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclMultipleNoC]");
        return buffer.toString();
    }
}
