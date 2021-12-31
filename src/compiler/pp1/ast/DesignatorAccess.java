// generated with ast extension for cup
// version 0.8
// 31/11/2021 23:6:23


package compiler.pp1.ast;

public class DesignatorAccess extends Designator {

    private Designator Designator;
    private AccessDsgn AccessDsgn;

    public DesignatorAccess (Designator Designator, AccessDsgn AccessDsgn) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.AccessDsgn=AccessDsgn;
        if(AccessDsgn!=null) AccessDsgn.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public AccessDsgn getAccessDsgn() {
        return AccessDsgn;
    }

    public void setAccessDsgn(AccessDsgn AccessDsgn) {
        this.AccessDsgn=AccessDsgn;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(AccessDsgn!=null) AccessDsgn.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(AccessDsgn!=null) AccessDsgn.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(AccessDsgn!=null) AccessDsgn.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorAccess(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AccessDsgn!=null)
            buffer.append(AccessDsgn.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorAccess]");
        return buffer.toString();
    }
}
