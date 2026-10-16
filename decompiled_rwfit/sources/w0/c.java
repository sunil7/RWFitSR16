package w0;

import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;

/* loaded from: classes.dex */
public abstract /* synthetic */ class c {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f19292a;

    static {
        int[] iArr = new int[ConstraintWidget$DimensionBehaviour.values().length];
        f19292a = iArr;
        try {
            iArr[ConstraintWidget$DimensionBehaviour.FIXED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f19292a[ConstraintWidget$DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f19292a[ConstraintWidget$DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f19292a[ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
