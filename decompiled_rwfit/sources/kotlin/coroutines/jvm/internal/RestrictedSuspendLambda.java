package kotlin.coroutines.jvm.internal;

import gh.a;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* loaded from: classes2.dex */
public abstract class RestrictedSuspendLambda extends RestrictedContinuationImpl implements d {
    private final int arity;

    public RestrictedSuspendLambda(int i3, a<Object> aVar) {
        super(aVar);
        this.arity = i3;
    }

    @Override // kotlin.jvm.internal.d
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        g.f15651a.getClass();
        String obj = getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            obj = obj.substring(21);
        }
        e.e(obj, "renderLambdaToString(this)");
        return obj;
    }

    public RestrictedSuspendLambda(int i3) {
        this(i3, null);
    }
}
