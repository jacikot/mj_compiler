// generated with ast extension for cup
// version 0.8
// 27/11/2021 15:53:21


package compiler.pp1.ast;

public class MethodDeclNoPar extends MethodDecl {

    private RetType RetType;
    private String methodName;
    private InnerVarDeclList InnerVarDeclList;
    private StatementList StatementList;

    public MethodDeclNoPar (RetType RetType, String methodName, InnerVarDeclList InnerVarDeclList, StatementList StatementList) {
        this.RetType=RetType;
        if(RetType!=null) RetType.setParent(this);
        this.methodName=methodName;
        this.InnerVarDeclList=InnerVarDeclList;
        if(InnerVarDeclList!=null) InnerVarDeclList.setParent(this);
        this.StatementList=StatementList;
        if(StatementList!=null) StatementList.setParent(this);
    }

    public RetType getRetType() {
        return RetType;
    }

    public void setRetType(RetType RetType) {
        this.RetType=RetType;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName=methodName;
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
        if(RetType!=null) RetType.accept(visitor);
        if(InnerVarDeclList!=null) InnerVarDeclList.accept(visitor);
        if(StatementList!=null) StatementList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RetType!=null) RetType.traverseTopDown(visitor);
        if(InnerVarDeclList!=null) InnerVarDeclList.traverseTopDown(visitor);
        if(StatementList!=null) StatementList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RetType!=null) RetType.traverseBottomUp(visitor);
        if(InnerVarDeclList!=null) InnerVarDeclList.traverseBottomUp(visitor);
        if(StatementList!=null) StatementList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDeclNoPar(\n");

        if(RetType!=null)
            buffer.append(RetType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+methodName);
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
        buffer.append(") [MethodDeclNoPar]");
        return buffer.toString();
    }
}
