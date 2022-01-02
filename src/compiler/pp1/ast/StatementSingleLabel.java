// generated with ast extension for cup
// version 0.8
// 3/0/2022 0:18:54


package compiler.pp1.ast;

public class StatementSingleLabel extends Statement {

    private LabelDef LabelDef;
    private SingleStatement SingleStatement;

    public StatementSingleLabel (LabelDef LabelDef, SingleStatement SingleStatement) {
        this.LabelDef=LabelDef;
        if(LabelDef!=null) LabelDef.setParent(this);
        this.SingleStatement=SingleStatement;
        if(SingleStatement!=null) SingleStatement.setParent(this);
    }

    public LabelDef getLabelDef() {
        return LabelDef;
    }

    public void setLabelDef(LabelDef LabelDef) {
        this.LabelDef=LabelDef;
    }

    public SingleStatement getSingleStatement() {
        return SingleStatement;
    }

    public void setSingleStatement(SingleStatement SingleStatement) {
        this.SingleStatement=SingleStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(LabelDef!=null) LabelDef.accept(visitor);
        if(SingleStatement!=null) SingleStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(LabelDef!=null) LabelDef.traverseTopDown(visitor);
        if(SingleStatement!=null) SingleStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(LabelDef!=null) LabelDef.traverseBottomUp(visitor);
        if(SingleStatement!=null) SingleStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementSingleLabel(\n");

        if(LabelDef!=null)
            buffer.append(LabelDef.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SingleStatement!=null)
            buffer.append(SingleStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementSingleLabel]");
        return buffer.toString();
    }
}
