// generated with ast extension for cup
// version 0.8
// 31/11/2021 13:25:58


package compiler.pp1.ast;

public class RecordDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String recordName;
    private InnerVarDeclList InnerVarDeclList;

    public RecordDecl (String recordName, InnerVarDeclList InnerVarDeclList) {
        this.recordName=recordName;
        this.InnerVarDeclList=InnerVarDeclList;
        if(InnerVarDeclList!=null) InnerVarDeclList.setParent(this);
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName=recordName;
    }

    public InnerVarDeclList getInnerVarDeclList() {
        return InnerVarDeclList;
    }

    public void setInnerVarDeclList(InnerVarDeclList InnerVarDeclList) {
        this.InnerVarDeclList=InnerVarDeclList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(InnerVarDeclList!=null) InnerVarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(InnerVarDeclList!=null) InnerVarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(InnerVarDeclList!=null) InnerVarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("RecordDecl(\n");

        buffer.append(" "+tab+recordName);
        buffer.append("\n");

        if(InnerVarDeclList!=null)
            buffer.append(InnerVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [RecordDecl]");
        return buffer.toString();
    }
}
