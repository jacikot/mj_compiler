// generated with ast extension for cup
// version 0.8
// 21/11/2021 0:4:57


package compiler.pp1.ast;

public class MatchedIfElse extends Matched {

    private Cond Cond;
    private Matched Matched;
    private Matched Matched1;

    public MatchedIfElse (Cond Cond, Matched Matched, Matched Matched1) {
        this.Cond=Cond;
        if(Cond!=null) Cond.setParent(this);
        this.Matched=Matched;
        if(Matched!=null) Matched.setParent(this);
        this.Matched1=Matched1;
        if(Matched1!=null) Matched1.setParent(this);
    }

    public Cond getCond() {
        return Cond;
    }

    public void setCond(Cond Cond) {
        this.Cond=Cond;
    }

    public Matched getMatched() {
        return Matched;
    }

    public void setMatched(Matched Matched) {
        this.Matched=Matched;
    }

    public Matched getMatched1() {
        return Matched1;
    }

    public void setMatched1(Matched Matched1) {
        this.Matched1=Matched1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Cond!=null) Cond.accept(visitor);
        if(Matched!=null) Matched.accept(visitor);
        if(Matched1!=null) Matched1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Cond!=null) Cond.traverseTopDown(visitor);
        if(Matched!=null) Matched.traverseTopDown(visitor);
        if(Matched1!=null) Matched1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Cond!=null) Cond.traverseBottomUp(visitor);
        if(Matched!=null) Matched.traverseBottomUp(visitor);
        if(Matched1!=null) Matched1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MatchedIfElse(\n");

        if(Cond!=null)
            buffer.append(Cond.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Matched!=null)
            buffer.append(Matched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Matched1!=null)
            buffer.append(Matched1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MatchedIfElse]");
        return buffer.toString();
    }
}
