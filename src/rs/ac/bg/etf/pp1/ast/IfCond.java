// generated with ast extension for cup
// version 0.8
// 25/0/2022 15:20:11


package rs.ac.bg.etf.pp1.ast;

public class IfCond implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private IfInit IfInit;
    private Cond Cond;

    public IfCond (IfInit IfInit, Cond Cond) {
        this.IfInit=IfInit;
        if(IfInit!=null) IfInit.setParent(this);
        this.Cond=Cond;
        if(Cond!=null) Cond.setParent(this);
    }

    public IfInit getIfInit() {
        return IfInit;
    }

    public void setIfInit(IfInit IfInit) {
        this.IfInit=IfInit;
    }

    public Cond getCond() {
        return Cond;
    }

    public void setCond(Cond Cond) {
        this.Cond=Cond;
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
        if(IfInit!=null) IfInit.accept(visitor);
        if(Cond!=null) Cond.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfInit!=null) IfInit.traverseTopDown(visitor);
        if(Cond!=null) Cond.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfInit!=null) IfInit.traverseBottomUp(visitor);
        if(Cond!=null) Cond.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfCond(\n");

        if(IfInit!=null)
            buffer.append(IfInit.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Cond!=null)
            buffer.append(Cond.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfCond]");
        return buffer.toString();
    }
}
