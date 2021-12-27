// generated with ast extension for cup
// version 0.8
// 27/11/2021 15:53:21


package compiler.pp1.ast;

public class FactorChar extends Factor {

    private String operand;

    public FactorChar (String operand) {
        this.operand=operand;
    }

    public String getOperand() {
        return operand;
    }

    public void setOperand(String operand) {
        this.operand=operand;
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
        buffer.append("FactorChar(\n");

        buffer.append(" "+tab+operand);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorChar]");
        return buffer.toString();
    }
}
