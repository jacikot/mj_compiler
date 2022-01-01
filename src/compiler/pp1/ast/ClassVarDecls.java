// generated with ast extension for cup
// version 0.8
// 1/0/2022 16:58:32


package compiler.pp1.ast;

public class ClassVarDecls extends ClassDeclList {

    private ClassVarDecl ClassVarDecl;
    private ClassDeclList ClassDeclList;

    public ClassVarDecls (ClassVarDecl ClassVarDecl, ClassDeclList ClassDeclList) {
        this.ClassVarDecl=ClassVarDecl;
        if(ClassVarDecl!=null) ClassVarDecl.setParent(this);
        this.ClassDeclList=ClassDeclList;
        if(ClassDeclList!=null) ClassDeclList.setParent(this);
    }

    public ClassVarDecl getClassVarDecl() {
        return ClassVarDecl;
    }

    public void setClassVarDecl(ClassVarDecl ClassVarDecl) {
        this.ClassVarDecl=ClassVarDecl;
    }

    public ClassDeclList getClassDeclList() {
        return ClassDeclList;
    }

    public void setClassDeclList(ClassDeclList ClassDeclList) {
        this.ClassDeclList=ClassDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassVarDecl!=null) ClassVarDecl.accept(visitor);
        if(ClassDeclList!=null) ClassDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassVarDecl!=null) ClassVarDecl.traverseTopDown(visitor);
        if(ClassDeclList!=null) ClassDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassVarDecl!=null) ClassVarDecl.traverseBottomUp(visitor);
        if(ClassDeclList!=null) ClassDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassVarDecls(\n");

        if(ClassVarDecl!=null)
            buffer.append(ClassVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ClassDeclList!=null)
            buffer.append(ClassDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassVarDecls]");
        return buffer.toString();
    }
}
