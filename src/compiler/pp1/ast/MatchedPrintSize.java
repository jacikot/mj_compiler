// generated with ast extension for cup
// version 0.8
// 21/11/2021 0:4:57


package compiler.pp1.ast;

public class MatchedPrintSize extends Matched {

    private Expr Expr;
    private Integer size;

    public MatchedPrintSize (Expr Expr, Integer size) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.size=size;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size=size;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MatchedPrintSize(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+size);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MatchedPrintSize]");
        return buffer.toString();
    }
}
