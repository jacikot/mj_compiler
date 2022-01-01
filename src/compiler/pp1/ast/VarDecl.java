// generated with ast extension for cup
// version 0.8
// 1/0/2022 23:20:12


package compiler.pp1.ast;

public class VarDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Type Type;
    private VarDeclListNoC VarDeclListNoC;

    public VarDecl (Type Type, VarDeclListNoC VarDeclListNoC) {
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

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
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
        buffer.append("VarDecl(\n");

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
        buffer.append(") [VarDecl]");
        return buffer.toString();
    }
}
