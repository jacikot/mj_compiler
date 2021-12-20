// generated with ast extension for cup
// version 0.8
// 21/11/2021 0:4:57


package compiler.pp1.ast;

public class FactorBool extends Factor {

    private Boolean operand;

    public FactorBool (Boolean operand) {
        this.operand=operand;
        if(operand!=null) operand.setParent(this);
    }

    public Boolean getOperand() {
        return operand;
    }

    public void setOperand(Boolean operand) {
        this.operand=operand;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(operand!=null) operand.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(operand!=null) operand.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(operand!=null) operand.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorBool(\n");

        if(operand!=null)
            buffer.append(operand.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorBool]");
        return buffer.toString();
    }
}
