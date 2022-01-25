// generated with ast extension for cup
// version 0.8
// 25/0/2022 15:20:11


package rs.ac.bg.etf.pp1.ast;

public class DesignatorAccessField extends Designator {

    private BaseDsgn BaseDsgn;
    private String field;

    public DesignatorAccessField (BaseDsgn BaseDsgn, String field) {
        this.BaseDsgn=BaseDsgn;
        if(BaseDsgn!=null) BaseDsgn.setParent(this);
        this.field=field;
    }

    public BaseDsgn getBaseDsgn() {
        return BaseDsgn;
    }

    public void setBaseDsgn(BaseDsgn BaseDsgn) {
        this.BaseDsgn=BaseDsgn;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field=field;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(BaseDsgn!=null) BaseDsgn.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BaseDsgn!=null) BaseDsgn.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BaseDsgn!=null) BaseDsgn.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorAccessField(\n");

        if(BaseDsgn!=null)
            buffer.append(BaseDsgn.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+field);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorAccessField]");
        return buffer.toString();
    }
}
