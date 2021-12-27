// generated with ast extension for cup
// version 0.8
// 27/11/2021 15:53:21


package compiler.pp1.ast;

public class ClassDeclError extends ClassDecl {

    private String className;
    private ExtendsDecl ExtendsDecl;
    private InnerMethodBlock InnerMethodBlock;

    public ClassDeclError (String className, ExtendsDecl ExtendsDecl, InnerMethodBlock InnerMethodBlock) {
        this.className=className;
        this.ExtendsDecl=ExtendsDecl;
        if(ExtendsDecl!=null) ExtendsDecl.setParent(this);
        this.InnerMethodBlock=InnerMethodBlock;
        if(InnerMethodBlock!=null) InnerMethodBlock.setParent(this);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className=className;
    }

    public ExtendsDecl getExtendsDecl() {
        return ExtendsDecl;
    }

    public void setExtendsDecl(ExtendsDecl ExtendsDecl) {
        this.ExtendsDecl=ExtendsDecl;
    }

    public InnerMethodBlock getInnerMethodBlock() {
        return InnerMethodBlock;
    }

    public void setInnerMethodBlock(InnerMethodBlock InnerMethodBlock) {
        this.InnerMethodBlock=InnerMethodBlock;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExtendsDecl!=null) ExtendsDecl.accept(visitor);
        if(InnerMethodBlock!=null) InnerMethodBlock.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExtendsDecl!=null) ExtendsDecl.traverseTopDown(visitor);
        if(InnerMethodBlock!=null) InnerMethodBlock.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExtendsDecl!=null) ExtendsDecl.traverseBottomUp(visitor);
        if(InnerMethodBlock!=null) InnerMethodBlock.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclError(\n");

        buffer.append(" "+tab+className);
        buffer.append("\n");

        if(ExtendsDecl!=null)
            buffer.append(ExtendsDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(InnerMethodBlock!=null)
            buffer.append(InnerMethodBlock.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclError]");
        return buffer.toString();
    }
}
