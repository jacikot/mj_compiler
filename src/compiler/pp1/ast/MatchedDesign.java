// generated with ast extension for cup
// version 0.8
// 27/11/2021 15:53:21


package compiler.pp1.ast;

public class MatchedDesign extends Matched {

    private DesignStatement DesignStatement;

    public MatchedDesign (DesignStatement DesignStatement) {
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
        buffer.append("MatchedDesign(\n");

        if(DesignStatement!=null)
            buffer.append(DesignStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MatchedDesign]");
        return buffer.toString();
    }
}
