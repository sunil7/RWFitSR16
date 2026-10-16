package oe;

import com.littlejerk.rvdivider.DividerHelper$DividerType;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f16921a;

    static {
        int[] iArr = new int[DividerHelper$DividerType.values().length];
        f16921a = iArr;
        try {
            iArr[DividerHelper$DividerType.LINEAR_HORIZONTAL.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f16921a[DividerHelper$DividerType.LINEAR_VERTICAL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f16921a[DividerHelper$DividerType.GRID_VERTICAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f16921a[DividerHelper$DividerType.GRID_HORIZONTAL.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f16921a[DividerHelper$DividerType.STAGGERED_GRID_HORIZONTAL.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f16921a[DividerHelper$DividerType.STAGGERED_GRID_VERTICAL.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f16921a[DividerHelper$DividerType.UNKNOWN.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
