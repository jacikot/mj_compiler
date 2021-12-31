// generated with ast extension for cup
// version 0.8
// 31/11/2021 23:6:23


package compiler.pp1.ast;

public class DesignStmt extends DesignStatement {

    private Designator Designator;
    private DsgnOp DsgnOp;

    public DesignStmt (Designator Designator, DsgnOp DsgnOp) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.DsgnOp=DsgnOp;
        if(DsgnOp!=null) DsgnOp.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public DsgnOp getDsgnOp() {
        return DsgnOp;
    }

    public void setDsgnOp(DsgnOp DsgnOp) {
        this.DsgnOp=DsgnOp;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(DsgnOp!=null) DsgnOp.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(DsgnOp!=null) DsgnOp.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(DsgnOp!=null) DsgnOp.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignStmt(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DsgnOp!=null)
            buffer.append(DsgnOp.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignStmt]");
        return buffer.toString();
    }
}
