// generated with ast extension for cup
// version 0.8
// 27/0/2022 6:50:47


package rs.ac.bg.etf.pp1.ast;

public class DsgnOpDec extends DesignStatement {

    private CallName CallName;

    public DsgnOpDec (CallName CallName) {
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
        buffer.append("DsgnOpDec(\n");

        if(CallName!=null)
            buffer.append(CallName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DsgnOpDec]");
        return buffer.toString();
    }
}
