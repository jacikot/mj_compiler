// generated with ast extension for cup
// version 0.8
// 25/0/2022 15:20:11


package rs.ac.bg.etf.pp1.ast;

public class FactorBool extends Factor {

    private Integer operand;

    public FactorBool (Integer operand) {
        this.operand=operand;
    }

    public Integer getOperand() {
        return operand;
    }

    public void setOperand(Integer operand) {
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
        buffer.append("FactorBool(\n");

        buffer.append(" "+tab+operand);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorBool]");
        return buffer.toString();
    }
}
