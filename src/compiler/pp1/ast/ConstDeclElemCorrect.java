// generated with ast extension for cup
// version 0.8
// 31/11/2021 19:56:22


package compiler.pp1.ast;

public class ConstDeclElemCorrect extends ConstDeclElem {

    private String varName;
    private ConstLit ConstLit;

    public ConstDeclElemCorrect (String varName, ConstLit ConstLit) {
        this.varName=varName;
        this.ConstLit=ConstLit;
        if(ConstLit!=null) ConstLit.setParent(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public ConstLit getConstLit() {
        return ConstLit;
    }

    public void setConstLit(ConstLit ConstLit) {
        this.ConstLit=ConstLit;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstLit!=null) ConstLit.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstLit!=null) ConstLit.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstLit!=null) ConstLit.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclElemCorrect(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(ConstLit!=null)
            buffer.append(ConstLit.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclElemCorrect]");
        return buffer.toString();
    }
}
