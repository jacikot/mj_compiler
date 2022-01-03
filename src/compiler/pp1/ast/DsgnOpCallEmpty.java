// generated with ast extension for cup
// version 0.8
// 3/0/2022 11:20:14


package compiler.pp1.ast;

public class DsgnOpCallEmpty extends DesignStatement {

    private CallName CallName;
    private CopyDsgn CopyDsgn;

    public DsgnOpCallEmpty (CallName CallName, CopyDsgn CopyDsgn) {
        this.CallName=CallName;
        if(CallName!=null) CallName.setParent(this);
        this.CopyDsgn=CopyDsgn;
        if(CopyDsgn!=null) CopyDsgn.setParent(this);
    }

    public CallName getCallName() {
        return CallName;
    }

    public void setCallName(CallName CallName) {
        this.CallName=CallName;
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
        if(CallName!=null) CallName.accept(visitor);
        if(CopyDsgn!=null) CopyDsgn.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CallName!=null) CallName.traverseTopDown(visitor);
        if(CopyDsgn!=null) CopyDsgn.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CallName!=null) CallName.traverseBottomUp(visitor);
        if(CopyDsgn!=null) CopyDsgn.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DsgnOpCallEmpty(\n");

        if(CallName!=null)
            buffer.append(CallName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CopyDsgn!=null)
            buffer.append(CopyDsgn.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DsgnOpCallEmpty]");
        return buffer.toString();
    }
}
