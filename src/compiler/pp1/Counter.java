package compiler.pp1;

import compiler.pp1.ast.*;

public class Counter extends VisitorAdaptor {
    protected int cnt;

    public int getCnt() {
        return cnt;
    }

    public static class LocalVarCounter extends Counter {

        public void visit(VarDecl var1) {
            cnt++;
        }
    }

    public static class FormParamCounter extends Counter {

        public void visit(FormParsMultipleArray var1) {
            cnt++;
        }
        public void visit(FormParsMultiple var1) {
            cnt++;
        }
        public void visit(FormParsSingleArray var1) {
            cnt++;
        }
        public void visit(FormParsSingle var1) {
            cnt++;
        }
    }

    public static class OperationSolver extends Counter {

        public void visit(MulopMul var1) {
            cnt=0;
        }
        public void visit(MulopDiv var1) {
            cnt=1;
        }
        public void visit(MulopMod var1) {
            cnt=2;
        }
        public void visit(AddopPlus var1) {
            cnt=3;
        }
        public void visit(AddopMinus var1) {
            cnt=4;
        }
    }


}
