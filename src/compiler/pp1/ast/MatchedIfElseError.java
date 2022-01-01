// generated with ast extension for cup
// version 0.8
// 1/0/2022 14:23:11


package compiler.pp1.ast;

public class MatchedIfElseError extends Matched {

    private IfElseBlock IfElseBlock;
    private IfElseBlock IfElseBlock1;

    public MatchedIfElseError (IfElseBlock IfElseBlock, IfElseBlock IfElseBlock1) {
        this.IfElseBlock=IfElseBlock;
        if(IfElseBlock!=null) IfElseBlock.setParent(this);
        this.IfElseBlock1=IfElseBlock1;
        if(IfElseBlock1!=null) IfElseBlock1.setParent(this);
    }

    public IfElseBlock getIfElseBlock() {
        return IfElseBlock;
    }

    public void setIfElseBlock(IfElseBlock IfElseBlock) {
        this.IfElseBlock=IfElseBlock;
    }

    public IfElseBlock getIfElseBlock1() {
        return IfElseBlock1;
    }

    public void setIfElseBlock1(IfElseBlock IfElseBlock1) {
        this.IfElseBlock1=IfElseBlock1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfElseBlock!=null) IfElseBlock.accept(visitor);
        if(IfElseBlock1!=null) IfElseBlock1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfElseBlock!=null) IfElseBlock.traverseTopDown(visitor);
        if(IfElseBlock1!=null) IfElseBlock1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfElseBlock!=null) IfElseBlock.traverseBottomUp(visitor);
        if(IfElseBlock1!=null) IfElseBlock1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MatchedIfElseError(\n");

        if(IfElseBlock!=null)
            buffer.append(IfElseBlock.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(IfElseBlock1!=null)
            buffer.append(IfElseBlock1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MatchedIfElseError]");
        return buffer.toString();
    }
}
