// generated with ast extension for cup
// version 0.8
// 3/0/2022 11:44:52


package compiler.pp1.ast;

public class DsgnOpCallPars extends DesignStatement {

    private CallName CallName;
    private CopyDsgn CopyDsgn;
    private ActPars ActPars;

    public DsgnOpCallPars (CallName CallName, CopyDsgn CopyDsgn, ActPars ActPars) {
        this.CallName=CallName;
        if(CallName!=null) CallName.setParent(this);
        this.CopyDsgn=CopyDsgn;
        if(CopyDsgn!=null) CopyDsgn.setParent(this);
        this.ActPars=ActPars;
        if(ActPars!=null) ActPars.setParent(this);
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
        if(CallName!=null) CallName.accept(visitor);
        if(CopyDsgn!=null) CopyDsgn.accept(visitor);
        if(ActPars!=null) ActPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CallName!=null) CallName.traverseTopDown(visitor);
        if(CopyDsgn!=null) CopyDsgn.traverseTopDown(visitor);
        if(ActPars!=null) ActPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CallName!=null) CallName.traverseBottomUp(visitor);
        if(CopyDsgn!=null) CopyDsgn.traverseBottomUp(visitor);
        if(ActPars!=null) ActPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DsgnOpCallPars(\n");

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

        if(ActPars!=null)
            buffer.append(ActPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DsgnOpCallPars]");
        return buffer.toString();
    }
}
