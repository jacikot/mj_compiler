// generated with ast extension for cup
// version 0.8
// 2/0/2022 19:14:48


package compiler.pp1.ast;

public class DsgnOpCallEmpty extends DesignStatement {

    private CallName CallName;

    public DsgnOpCallEmpty (CallName CallName) {
        this.CallName=CallName;
        if(CallName!=null) CallName.setParent(this);
    }

    public CallName getCallName() {
        return CallName;
    }

    public void setCallName(CallName CallName) {
        this.CallName=CallName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(CallName!=null) CallName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(CallName!=null) CallName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(CallName!=null) CallName.traverseBottomUp(visitor);
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

        buffer.append(tab);
        buffer.append(") [DsgnOpCallEmpty]");
        return buffer.toString();
    }
}
