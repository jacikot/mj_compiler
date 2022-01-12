package compiler.pp1;

import compiler.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;

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
    public static class RelOperationSolver extends Counter {

        public void visit(RelopGrt var1) {
            cnt= Code.gt;
        }
        public void visit(RelopGre var1) {
            cnt=Code.ge;
        }
        public void visit(RelopLes var1) {
            cnt=Code.lt;
        }
        public void visit(RelopLee var1) {
            cnt=Code.le;
        }
        public void visit(RelopEqu var1) {
            cnt=Code.eq;
        }
        public void visit(RelopNeq var1) {
            cnt=Code.ne;
        }

    }


}
