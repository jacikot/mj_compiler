// generated with ast extension for cup
// version 0.8
// 2/0/2022 15:46:54


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
