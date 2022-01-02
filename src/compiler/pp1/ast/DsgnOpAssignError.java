// generated with ast extension for cup
// version 0.8
// 2/0/2022 19:14:48


package compiler.pp1.ast;

public class DsgnOpAssignError extends DesignStatement {

    private CallName CallName;
    private Assignop Assignop;

    public DsgnOpAssignError (CallName CallName, Assignop Assignop) {
        this.CallName=CallName;
        if(CallName!=null) CallName.setParent(this);
        this.Assignop=Assignop;
        if(Assignop!=null) Assignop.setParent(this);
    }

    public CallName getCallName() {
        return CallName;
    }

    public void setCallName(CallName CallName) {
        this.CallName=CallName;
    }

    public Assignop getAssignop() {
        return Assignop;
    }

    public void setAssignop(Assignop Assignop) {
        this.Assignop=Assignop;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CallName!=null) CallName.accept(visitor);
        if(Assignop!=null) Assignop.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CallName!=null) CallName.traverseTopDown(visitor);
        if(Assignop!=null) Assignop.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CallName!=null) CallName.traverseBottomUp(visitor);
        if(Assignop!=null) Assignop.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DsgnOpAssignError(\n");

        if(CallName!=null)
            buffer.append(CallName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Assignop!=null)
            buffer.append(Assignop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DsgnOpAssignError]");
        return buffer.toString();
    }
}
