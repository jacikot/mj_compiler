// generated with ast extension for cup
// version 0.8
// 25/0/2022 19:28:44


package rs.ac.bg.etf.pp1.ast;

public class StmtIfElseError extends SingleStatement {

    private IfInit IfInit;
    private Statement Statement;
    private ElseCond ElseCond;
    private Statement Statement1;

    public StmtIfElseError (IfInit IfInit, Statement Statement, ElseCond ElseCond, Statement Statement1) {
        this.IfInit=IfInit;
        if(IfInit!=null) IfInit.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.ElseCond=ElseCond;
        if(ElseCond!=null) ElseCond.setParent(this);
        this.Statement1=Statement1;
        if(Statement1!=null) Statement1.setParent(this);
    }

    public IfInit getIfInit() {
        return IfInit;
    }

    public void setIfInit(IfInit IfInit) {
        this.IfInit=IfInit;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public ElseCond getElseCond() {
        return ElseCond;
    }

    public void setElseCond(ElseCond ElseCond) {
        this.ElseCond=ElseCond;
    }

    public Statement getStatement1() {
        return Statement1;
    }

    public void setStatement1(Statement Statement1) {
        this.Statement1=Statement1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfInit!=null) IfInit.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(ElseCond!=null) ElseCond.accept(visitor);
        if(Statement1!=null) Statement1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfInit!=null) IfInit.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(ElseCond!=null) ElseCond.traverseTopDown(visitor);
        if(Statement1!=null) Statement1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfInit!=null) IfInit.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(ElseCond!=null) ElseCond.traverseBottomUp(visitor);
        if(Statement1!=null) Statement1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StmtIfElseError(\n");

        if(IfInit!=null)
            buffer.append(IfInit.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ElseCond!=null)
            buffer.append(ElseCond.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement1!=null)
            buffer.append(Statement1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StmtIfElseError]");
        return buffer.toString();
    }
}
