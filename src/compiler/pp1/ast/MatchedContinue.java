// generated with ast extension for cup
// version 0.8
// 1/0/2022 20:18:11


package compiler.pp1.ast;

public class MatchedContinue extends Matched {

    public MatchedContinue () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MatchedContinue(\n");

        buffer.append(tab);
        buffer.append(") [MatchedContinue]");
        return buffer.toString();
    }
}
