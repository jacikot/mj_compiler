// generated with ast extension for cup
// version 0.8
// 25/0/2022 19:28:44


package rs.ac.bg.etf.pp1.ast;

public class DesignatorFirst extends Designator {

    private String dsgnName;

    public DesignatorFirst (String dsgnName) {
        this.dsgnName=dsgnName;
    }

    public String getDsgnName() {
        return dsgnName;
    }

    public void setDsgnName(String dsgnName) {
        this.dsgnName=dsgnName;
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
        buffer.append("DesignatorFirst(\n");

        buffer.append(" "+tab+dsgnName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorFirst]");
        return buffer.toString();
    }
}
