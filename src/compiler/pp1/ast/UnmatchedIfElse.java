// generated with ast extension for cup
// version 0.8
// 31/11/2021 22:38:35


package compiler.pp1.ast;

public class UnmatchedIfElse extends Unmatched {

    private Cond Cond;
    private IfElseBlock IfElseBlock;
    private Unmatched Unmatched;

    public UnmatchedIfElse (Cond Cond, IfElseBlock IfElseBlock, Unmatched Unmatched) {
        this.Cond=Cond;
        if(Cond!=null) Cond.setParent(this);
        this.IfElseBlock=IfElseBlock;
        if(IfElseBlock!=null) IfElseBlock.setParent(this);
        this.Unmatched=Unmatched;
        if(Unmatched!=null) Unmatched.setParent(this);
    }

    public Cond getCond() {
        return Cond;
    }

    public void setCond(Cond Cond) {
        this.Cond=Cond;
    }

    public IfElseBlock getIfElseBlock() {
        return IfElseBlock;
    }

    public void setIfElseBlock(IfElseBlock IfElseBlock) {
        this.IfElseBlock=IfElseBlock;
    }

    public Unmatched getUnmatched() {
        return Unmatched;
    }

    public void setUnmatched(Unmatched Unmatched) {
        this.Unmatched=Unmatched;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Cond!=null) Cond.accept(visitor);
        if(IfElseBlock!=null) IfElseBlock.accept(visitor);
        if(Unmatched!=null) Unmatched.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Cond!=null) Cond.traverseTopDown(visitor);
        if(IfElseBlock!=null) IfElseBlock.traverseTopDown(visitor);
        if(Unmatched!=null) Unmatched.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Cond!=null) Cond.traverseBottomUp(visitor);
        if(IfElseBlock!=null) IfElseBlock.traverseBottomUp(visitor);
        if(Unmatched!=null) Unmatched.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("UnmatchedIfElse(\n");

        if(Cond!=null)
            buffer.append(Cond.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IfElseBlock!=null)
            buffer.append(IfElseBlock.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Unmatched!=null)
            buffer.append(Unmatched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [UnmatchedIfElse]");
        return buffer.toString();
    }
}
