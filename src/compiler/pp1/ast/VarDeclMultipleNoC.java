// generated with ast extension for cup
// version 0.8
// 31/11/2021 19:56:22


package compiler.pp1.ast;

public class VarDeclMultipleNoC extends VarDeclListNoC {

    private VarDeclListNoC VarDeclListNoC;
    private String varName;
    private ArrayBracks ArrayBracks;

    public VarDeclMultipleNoC (VarDeclListNoC VarDeclListNoC, String varName, ArrayBracks ArrayBracks) {
        this.VarDeclListNoC=VarDeclListNoC;
        if(VarDeclListNoC!=null) VarDeclListNoC.setParent(this);
        this.varName=varName;
        this.ArrayBracks=ArrayBracks;
        if(ArrayBracks!=null) ArrayBracks.setParent(this);
    }

    public VarDeclListNoC getVarDeclListNoC() {
        return VarDeclListNoC;
    }

    public void setVarDeclListNoC(VarDeclListNoC VarDeclListNoC) {
        this.VarDeclListNoC=VarDeclListNoC;
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
        if(VarDeclListNoC!=null) VarDeclListNoC.accept(visitor);
        if(ArrayBracks!=null) ArrayBracks.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclListNoC!=null) VarDeclListNoC.traverseTopDown(visitor);
        if(ArrayBracks!=null) ArrayBracks.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclListNoC!=null) VarDeclListNoC.traverseBottomUp(visitor);
        if(ArrayBracks!=null) ArrayBracks.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclMultipleNoC(\n");

        if(VarDeclListNoC!=null)
            buffer.append(VarDeclListNoC.toString("  "+tab));
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
        buffer.append(") [VarDeclMultipleNoC]");
        return buffer.toString();
    }
}
