// generated with ast extension for cup
// version 0.8
// 25/0/2022 15:20:11


package rs.ac.bg.etf.pp1.ast;

public class FactorDsgn extends Factor {

    private FactorDesignator FactorDesignator;

    public FactorDsgn (FactorDesignator FactorDesignator) {
        this.FactorDesignator=FactorDesignator;
        if(FactorDesignator!=null) FactorDesignator.setParent(this);
    }

    public FactorDesignator getFactorDesignator() {
        return FactorDesignator;
    }

    public void setFactorDesignator(FactorDesignator FactorDesignator) {
        this.FactorDesignator=FactorDesignator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FactorDesignator!=null) FactorDesignator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FactorDesignator!=null) FactorDesignator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FactorDesignator!=null) FactorDesignator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDsgn(\n");

        if(FactorDesignator!=null)
            buffer.append(FactorDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDsgn]");
        return buffer.toString();
    }
}
