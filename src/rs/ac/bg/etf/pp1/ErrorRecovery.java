package rs.ac.bg.etf.pp1;


import rs.ac.bg.etf.pp1.ast.*;

public class ErrorRecovery extends VisitorAdaptor {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    boolean errorDetected = false;

    public void report_error(String message, SyntaxNode info) {
        errorDetected = true;
        StringBuilder msg = new StringBuilder();
        int line = (info == null) ? 0: info.getLine();
        if (line != 0)
            msg.append (" na liniji ").append(line).append(": ");
        msg.append(message);

        System.out.println(ANSI_RED+msg.toString()+ANSI_RESET);

    }

    @Override
    public void visit(ConstDeclError b) {
        report_error("Izvrsen oporavak od greske. ",b);
    }

    @Override
    public void visit(DsgnOpAssignError b) {
        report_error("Izvrsen oporavak od greske. ",b);
    }
    @Override
    public void visit(ConstDeclElemError b) {
        report_error("Izvrsen oporavak od greske. ",b.getParent());
    }

    @Override
    public void visit(VarDeclGlobalError b) {
        report_error("Izvrsen oporavak od greske. ",b);
    }

    @Override
    public void visit(VarDeclError b) {
        report_error("Izvrsen oporavak od greskes. ",b.getParent());
    }
    @Override
    public void visit(ClassVarDeclsError b) {
        report_error("Izvrsen oporavak od greske. ",b);
    }
    @Override
    public void visit(ClassDeclsMethodsError b) {
        report_error("Izvrsen oporavak od greske. ",b);
    }

    @Override
    public void visit(ExtendsDeclError b) {
        report_error("Izvrsen oporavak od greske. ",b.getParent());
    }

    @Override
    public void visit(FormParsError b) {
        report_error("Izvrsen oporavak od greske. ",b);
    }
    @Override
    public void visit(FormParsSingleError b) {
        report_error("Izvrsen oporavak od greske. ",b.getParent());
    }

}
