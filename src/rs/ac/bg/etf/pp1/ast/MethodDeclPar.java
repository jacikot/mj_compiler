// generated with ast extension for cup
// version 0.8
// 27/0/2022 6:50:47


package rs.ac.bg.etf.pp1.ast;

public class MethodDeclPar extends MethodDecl {

    private MethodDeclChecker MethodDeclChecker;
    private FormParList FormParList;
    private InnerVarDeclList InnerVarDeclList;
    private StatementList StatementList;

    public MethodDeclPar (MethodDeclChecker MethodDeclChecker, FormParList FormParList, InnerVarDeclList InnerVarDeclList, StatementList StatementList) {
        this.MethodDeclChecker=MethodDeclChecker;
        if(MethodDeclChecker!=null) MethodDeclChecker.setParent(this);
        this.FormParList=FormParList;
        if(FormParList!=null) FormParList.setParent(this);
        this.InnerVarDeclList=InnerVarDeclList;
        if(InnerVarDeclList!=null) InnerVarDeclList.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public MethodDeclChecker getMethodDeclChecker() {
        return MethodDeclChecker;
    }

    public void setMethodDeclChecker(MethodDeclChecker MethodDeclChecker) {
        this.MethodDeclChecker=MethodDeclChecker;
    }

    public FormParList getFormParList() {
        return FormParList;
    }

    public void setFormParList(FormParList FormParList) {
        this.FormParList=FormParList;
    }

    public InnerVarDeclList getInnerVarDeclList() {
        return InnerVarDeclList;
    }

    public void setInnerVarDeclList(InnerVarDeclList InnerVarDeclList) {
        this.InnerVarDeclList=InnerVarDeclList;
    }

    public StatementList getStatementList() {
        return StatementList;
    }

    public void setStatementList(StatementList StatementList) {
        this.StatementList=StatementList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDeclChecker!=null) MethodDeclChecker.accept(visitor);
        if(FormParList!=null) FormParList.accept(visitor);
        if(InnerVarDeclList!=null) InnerVarDeclList.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDeclChecker!=null) MethodDeclChecker.traverseTopDown(visitor);
        if(FormParList!=null) FormParList.traverseTopDown(visitor);
        if(InnerVarDeclList!=null) InnerVarDeclList.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDeclChecker!=null) MethodDeclChecker.traverseBottomUp(visitor);
        if(FormParList!=null) FormParList.traverseBottomUp(visitor);
        if(InnerVarDeclList!=null) InnerVarDeclList.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclPar(\n");

        if(MethodDeclChecker!=null)
            buffer.append(MethodDeclChecker.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParList!=null)
            buffer.append(FormParList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(InnerVarDeclList!=null)
            buffer.append(InnerVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementList!=null)
            buffer.append(StatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDeclPar]");
        return buffer.toString();
    }
}
