// generated with ast extension for cup
// version 0.8
// 3/0/2022 0:18:54


package compiler.pp1.ast;

public class FactorDsgnCallEmpty extends Factor {

    private FactorDesignator FactorDesignator;
    private CopyDsgn CopyDsgn;

    public FactorDsgnCallEmpty (FactorDesignator FactorDesignator, CopyDsgn CopyDsgn) {
        this.FactorDesignator=FactorDesignator;
        if(FactorDesignator!=null) FactorDesignator.setParent(this);
        this.CopyDsgn=CopyDsgn;
        if(CopyDsgn!=null) CopyDsgn.setParent(this);
    }

    public FactorDesignator getFactorDesignator() {
        return FactorDesignator;
    }

    public void setFactorDesignator(FactorDesignator FactorDesignator) {
        this.FactorDesignator=FactorDesignator;
    }

    public CopyDsgn getCopyDsgn() {
        return CopyDsgn;
    }

    public void setCopyDsgn(CopyDsgn CopyDsgn) {
        this.CopyDsgn=CopyDsgn;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FactorDesignator!=null) FactorDesignator.accept(visitor);
        if(CopyDsgn!=null) CopyDsgn.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FactorDesignator!=null) FactorDesignator.traverseTopDown(visitor);
        if(CopyDsgn!=null) CopyDsgn.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FactorDesignator!=null) FactorDesignator.traverseBottomUp(visitor);
        if(CopyDsgn!=null) CopyDsgn.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDsgnCallEmpty(\n");

        if(FactorDesignator!=null)
            buffer.append(FactorDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(CopyDsgn!=null)
            buffer.append(CopyDsgn.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDsgnCallEmpty]");
        return buffer.toString();
    }
}
