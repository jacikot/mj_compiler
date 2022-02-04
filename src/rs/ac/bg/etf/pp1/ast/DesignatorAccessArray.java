// generated with ast extension for cup
// version 0.8
// 27/0/2022 6:50:47


package rs.ac.bg.etf.pp1.ast;

public class DesignatorAccessArray extends Designator {

    private BaseDsgn BaseDsgn;
    private Expr Expr;

    public DesignatorAccessArray (BaseDsgn BaseDsgn, Expr Expr) {
        this.BaseDsgn=BaseDsgn;
        if(BaseDsgn!=null) BaseDsgn.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public BaseDsgn getBaseDsgn() {
        return BaseDsgn;
    }

    public void setBaseDsgn(BaseDsgn BaseDsgn) {
        this.BaseDsgn=BaseDsgn;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(BaseDsgn!=null) BaseDsgn.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BaseDsgn!=null) BaseDsgn.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BaseDsgn!=null) BaseDsgn.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorAccessArray(\n");

        if(BaseDsgn!=null)
            buffer.append(BaseDsgn.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorAccessArray]");
        return buffer.toString();
    }
}