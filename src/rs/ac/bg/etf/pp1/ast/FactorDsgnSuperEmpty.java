// generated with ast extension for cup
// version 0.8
// 27/0/2022 6:50:47


package rs.ac.bg.etf.pp1.ast;

public class FactorDsgnSuperEmpty extends Factor {

    private SuperDsgn SuperDsgn;
    private CopyDsgn CopyDsgn;

    public FactorDsgnSuperEmpty (SuperDsgn SuperDsgn, CopyDsgn CopyDsgn) {
        this.SuperDsgn=SuperDsgn;
        if(SuperDsgn!=null) SuperDsgn.setParent(this);
        this.CopyDsgn=CopyDsgn;
        if(CopyDsgn!=null) CopyDsgn.setParent(this);
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

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SuperDsgn!=null) SuperDsgn.accept(visitor);
        if(CopyDsgn!=null) CopyDsgn.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SuperDsgn!=null) SuperDsgn.traverseTopDown(visitor);
        if(CopyDsgn!=null) CopyDsgn.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SuperDsgn!=null) SuperDsgn.traverseBottomUp(visitor);
        if(CopyDsgn!=null) CopyDsgn.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDsgnSuperEmpty(\n");

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

        buffer.append(tab);
        buffer.append(") [FactorDsgnSuperEmpty]");
        return buffer.toString();
    }
}
