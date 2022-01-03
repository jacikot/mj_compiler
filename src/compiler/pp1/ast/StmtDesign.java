// generated with ast extension for cup
// version 0.8
// 3/0/2022 11:44:52


package compiler.pp1.ast;

public class StmtDesign extends SingleStatement {

    private DesignStatement DesignStatement;

    public StmtDesign (DesignStatement DesignStatement) {
        this.DesignStatement=DesignStatement;
        if(DesignStatement!=null) DesignStatement.setParent(this);
    }

    public DesignStatement getDesignStatement() {
        return DesignStatement;
    }

    public void setDesignStatement(DesignStatement DesignStatement) {
        this.DesignStatement=DesignStatement;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignStatement!=null) DesignStatement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignStatement!=null) DesignStatement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignStatement!=null) DesignStatement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StmtDesign(\n");

        if(DesignStatement!=null)
            buffer.append(DesignStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StmtDesign]");
        return buffer.toString();
    }
}
