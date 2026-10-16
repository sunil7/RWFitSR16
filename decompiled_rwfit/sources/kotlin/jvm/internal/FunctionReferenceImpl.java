package kotlin.jvm.internal;

/* loaded from: classes2.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i3, uh.d dVar, String str, String str2) {
        super(i3, CallableReference.NO_RECEIVER, ((a) dVar).a(), str, str2, !(dVar instanceof uh.c) ? 1 : 0);
    }

    public FunctionReferenceImpl(int i3, Class cls, String str, String str2, int i10) {
        super(i3, CallableReference.NO_RECEIVER, cls, str, str2, i10);
    }

    public FunctionReferenceImpl(int i3, Object obj, Class cls, String str, String str2, int i10) {
        super(i3, obj, cls, str, str2, i10);
    }
}
