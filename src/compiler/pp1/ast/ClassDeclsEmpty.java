// generated with ast extension for cup
// version 0.8
// 2/0/2022 16:48:30


package compiler.pp1.ast;

public class ClassDeclsEmpty extends ClassDeclList {

    public ClassDeclsEmpty () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclsEmpty(\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclsEmpty]");
        return buffer.toString();
    }
}
