// generated with ast extension for cup
// version 0.8
// 25/0/2022 15:20:11


package rs.ac.bg.etf.pp1.ast;

public class FactorDsgnCall extends Factor {

    private FactorDesignator FactorDesignator;
    private CopyDsgn CopyDsgn;
    private ActPars ActPars;

    public FactorDsgnCall (FactorDesignator FactorDesignator, CopyDsgn CopyDsgn, ActPars ActPars) {
        this.FactorDesignator=FactorDesignator;
        if(FactorDesignator!=null) FactorDesignator.setParent(this);
        this.CopyDsgn=CopyDsgn;
        if(CopyDsgn!=null) CopyDsgn.setParent(this);
        this.ActPars=ActPars;
        if(ActPars!=null) ActPars.setParent(this);
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

    public ActPars getActPars() {
        return ActPars;
    }

    public void setActPars(ActPars ActPars) {
        this.ActPars=ActPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FactorDesignator!=null) FactorDesignator.accept(visitor);
        if(CopyDsgn!=null) CopyDsgn.accept(visitor);
        if(ActPars!=null) ActPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FactorDesignator!=null) FactorDesignator.traverseTopDown(visitor);
        if(CopyDsgn!=null) CopyDsgn.traverseTopDown(visitor);
        if(ActPars!=null) ActPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FactorDesignator!=null) FactorDesignator.traverseBottomUp(visitor);
        if(CopyDsgn!=null) CopyDsgn.traverseBottomUp(visitor);
        if(ActPars!=null) ActPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDsgnCall(\n");

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

        if(ActPars!=null)
            buffer.append(ActPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDsgnCall]");
        return buffer.toString();
    }
}
