// generated with ast extension for cup
// version 0.8
// 25/0/2022 19:28:44


package rs.ac.bg.etf.pp1.ast;

public class DsgnSuperPars extends DesignStatement {

    private SuperDsgn SuperDsgn;
    private CopyDsgn CopyDsgn;
    private ActPars ActPars;

    public DsgnSuperPars (SuperDsgn SuperDsgn, CopyDsgn CopyDsgn, ActPars ActPars) {
        this.SuperDsgn=SuperDsgn;
        if(SuperDsgn!=null) SuperDsgn.setParent(this);
        this.CopyDsgn=CopyDsgn;
        if(CopyDsgn!=null) CopyDsgn.setParent(this);
        this.ActPars=ActPars;
        if(ActPars!=null) ActPars.setParent(this);
    }

    public SuperDsgn getSuperDsgn() {
        return SuperDsgn;
    }

    public void setSuperDsgn(SuperDsgn SuperDsgn) {
        this.SuperDsgn=SuperDsgn;
    }

    public CopyDsgn getCopyDsgn() {
        return CopyDsgn;
    }

    public void setCopyDsgn(CopyDsgn CopyDsgn) {
        this.CopyDsgn=CopyDsgn;
    }

    public ActPars getActPars() {
        return ActPars;
    }

    public void setActPars(ActPars ActPars) {
        this.ActPars=ActPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SuperDsgn!=null) SuperDsgn.accept(visitor);
        if(CopyDsgn!=null) CopyDsgn.accept(visitor);
        if(ActPars!=null) ActPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SuperDsgn!=null) SuperDsgn.traverseTopDown(visitor);
        if(CopyDsgn!=null) CopyDsgn.traverseTopDown(visitor);
        if(ActPars!=null) ActPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SuperDsgn!=null) SuperDsgn.traverseBottomUp(visitor);
        if(CopyDsgn!=null) CopyDsgn.traverseBottomUp(visitor);
        if(ActPars!=null) ActPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DsgnSuperPars(\n");

        if(SuperDsgn!=null)
            buffer.append(SuperDsgn.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CopyDsgn!=null)
            buffer.append(CopyDsgn.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActPars!=null)
            buffer.append(ActPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DsgnSuperPars]");
        return buffer.toString();
    }
}
