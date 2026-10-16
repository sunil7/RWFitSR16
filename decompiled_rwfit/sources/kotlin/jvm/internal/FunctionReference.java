package kotlin.jvm.internal;

/* loaded from: classes2.dex */
public class FunctionReference extends CallableReference implements d, uh.e {
    private final int arity;
    private final int flags;

    public FunctionReference(int i3) {
        this(i3, CallableReference.NO_RECEIVER, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public uh.b computeReflected() {
        g.f15651a.getClass();
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            return getName().equals(functionReference.getName()) && getSignature().equals(functionReference.getSignature()) && this.flags == functionReference.flags && this.arity == functionReference.arity && e.a(getBoundReceiver(), functionReference.getBoundReceiver()) && e.a(getOwner(), functionReference.getOwner());
        }
        if (obj instanceof uh.e) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.d
    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    @Override // uh.e
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // uh.e
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // uh.e
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // uh.e
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.CallableReference, uh.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        uh.b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    public FunctionReference(int i3, Object obj) {
        this(i3, obj, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public uh.e getReflected() {
        return (uh.e) super.getReflected();
    }

    public FunctionReference(int i3, Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, (i10 & 1) == 1);
        this.arity = i3;
        this.flags = i10 >> 1;
    }
}
