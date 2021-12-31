// generated with ast extension for cup
// version 0.8
// 31/11/2021 13:34:7


package compiler.pp1.ast;

public class VarDeclsCorrect extends ClassVarDecl {

    private Type Type;
    private VarDeclListNoC VarDeclListNoC;

    public VarDeclsCorrect (Type Type, VarDeclListNoC VarDeclListNoC) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.VarDeclListNoC=VarDeclListNoC;
        if(VarDeclListNoC!=null) VarDeclListNoC.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public VarDeclListNoC getVarDeclListNoC() {
        return VarDeclListNoC;
    }

    public void setVarDeclListNoC(VarDeclListNoC VarDeclListNoC) {
        this.VarDeclListNoC=VarDeclListNoC;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(VarDeclListNoC!=null) VarDeclListNoC.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(VarDeclListNoC!=null) VarDeclListNoC.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(VarDeclListNoC!=null) VarDeclListNoC.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclsCorrect(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclListNoC!=null)
            buffer.append(VarDeclListNoC.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclsCorrect]");
        return buffer.toString();
    }
}
