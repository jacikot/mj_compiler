// generated with ast extension for cup
// version 0.8
// 25/0/2022 15:20:11


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclsMethods extends ClassDeclList {

    private InnerMethodBlock InnerMethodBlock;

    public ClassDeclsMethods (InnerMethodBlock InnerMethodBlock) {
        this.InnerMethodBlock=InnerMethodBlock;
        if(InnerMethodBlock!=null) InnerMethodBlock.setParent(this);
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
        if(InnerMethodBlock!=null) InnerMethodBlock.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(InnerMethodBlock!=null) InnerMethodBlock.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(InnerMethodBlock!=null) InnerMethodBlock.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclsMethods(\n");

        if(InnerMethodBlock!=null)
            buffer.append(InnerMethodBlock.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclsMethods]");
        return buffer.toString();
    }
}
