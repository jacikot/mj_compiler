// generated with ast extension for cup
// version 0.8
// 31/11/2021 17:55:52


package compiler.pp1.ast;

public class VarDeclMultiple extends VarDeclList {

    private VarDeclCheck VarDeclCheck;
    private String varName;
    private ArrayBracks ArrayBracks;

    public VarDeclMultiple (VarDeclCheck VarDeclCheck, String varName, ArrayBracks ArrayBracks) {
        this.VarDeclCheck=VarDeclCheck;
        if(VarDeclCheck!=null) VarDeclCheck.setParent(this);
        this.varName=varName;
        this.ArrayBracks=ArrayBracks;
        if(ArrayBracks!=null) ArrayBracks.setParent(this);
    }

    public VarDeclCheck getVarDeclCheck() {
        return VarDeclCheck;
    }

    public void setVarDeclCheck(VarDeclCheck VarDeclCheck) {
        this.VarDeclCheck=VarDeclCheck;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public ArrayBracks getArrayBracks() {
        return ArrayBracks;
    }

    public void setArrayBracks(ArrayBracks ArrayBracks) {
        this.ArrayBracks=ArrayBracks;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclCheck!=null) VarDeclCheck.accept(visitor);
        if(ArrayBracks!=null) ArrayBracks.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclCheck!=null) VarDeclCheck.traverseTopDown(visitor);
        if(ArrayBracks!=null) ArrayBracks.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclCheck!=null) VarDeclCheck.traverseBottomUp(visitor);
        if(ArrayBracks!=null) ArrayBracks.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclMultiple(\n");

        if(VarDeclCheck!=null)
            buffer.append(VarDeclCheck.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(ArrayBracks!=null)
            buffer.append(ArrayBracks.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclMultiple]");
        return buffer.toString();
    }
}
