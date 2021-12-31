// generated with ast extension for cup
// version 0.8
// 31/11/2021 13:34:7


package compiler.pp1.ast;

public class MulopMul extends Mulop {

    public MulopMul () {
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
        buffer.append("MulopMul(\n");

        buffer.append(tab);
        buffer.append(") [MulopMul]");
        return buffer.toString();
    }
}
