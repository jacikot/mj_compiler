// generated with ast extension for cup
// version 0.8
// 31/11/2021 22:38:35


package compiler.pp1.ast;

public class VarDeclGlobalError extends VarDeclGlobal {

    public VarDeclGlobalError () {
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
        buffer.append("VarDeclGlobalError(\n");

        buffer.append(tab);
        buffer.append(") [VarDeclGlobalError]");
        return buffer.toString();
    }
}
