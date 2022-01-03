// generated with ast extension for cup
// version 0.8
// 3/0/2022 11:44:52


package compiler.pp1.ast;

public class DsgnSuperEmpty extends DesignStatement {

    private SuperDsgn SuperDsgn;
    private CopyDsgn CopyDsgn;

    public DsgnSuperEmpty (SuperDsgn SuperDsgn, CopyDsgn CopyDsgn) {
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
        buffer.append("DsgnSuperEmpty(\n");

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
        buffer.append(") [DsgnSuperEmpty]");
        return buffer.toString();
    }
}
