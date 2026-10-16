package kotlin.jvm.internal;

import uh.k;

/* loaded from: classes2.dex */
public abstract class PropertyReference extends CallableReference implements k {
    private final boolean syntheticJavaProperty;

    public PropertyReference() {
        this.syntheticJavaProperty = false;
    }

    @Override // kotlin.jvm.internal.CallableReference
    public uh.b compute() {
        return this.syntheticJavaProperty ? this : super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return getOwner().equals(propertyReference.getOwner()) && getName().equals(propertyReference.getName()) && getSignature().equals(propertyReference.getSignature()) && e.a(getBoundReceiver(), propertyReference.getBoundReceiver());
        }
        if (obj instanceof k) {
            return obj.equals(compute());
        }
        return false;
    }

    public abstract /* synthetic */ uh.i getGetter();

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    @Override // uh.k
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // uh.k
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        uh.b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public k getReflected() {
        if (this.syntheticJavaProperty) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
        }
        return (k) super.getReflected();
    }

    public PropertyReference(Object obj) {
        super(obj);
        this.syntheticJavaProperty = false;
    }

    public PropertyReference(Object obj, Class cls, String str, String str2, int i3) {
        super(obj, cls, str, str2, (i3 & 1) == 1);
        this.syntheticJavaProperty = (i3 & 2) == 2;
    }
}
