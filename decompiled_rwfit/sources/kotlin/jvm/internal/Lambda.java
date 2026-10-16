package kotlin.jvm.internal;

import java.io.Serializable;

/* loaded from: classes2.dex */
public abstract class Lambda<R> implements d, Serializable {
    private final int arity;

    public Lambda(int i3) {
        this.arity = i3;
    }

    @Override // kotlin.jvm.internal.d
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        g.f15651a.getClass();
        String obj = getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            obj = obj.substring(21);
        }
        e.e(obj, "renderLambdaToString(this)");
        return obj;
    }
}
