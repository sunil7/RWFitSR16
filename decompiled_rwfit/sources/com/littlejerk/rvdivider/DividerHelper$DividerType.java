package com.littlejerk.rvdivider;

import com.tencent.connect.common.Constants;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class DividerHelper$DividerType {
    public static final DividerHelper$DividerType GRID_HORIZONTAL;
    public static final DividerHelper$DividerType GRID_VERTICAL;
    public static final DividerHelper$DividerType LINEAR_HORIZONTAL;
    public static final DividerHelper$DividerType LINEAR_VERTICAL;
    public static final DividerHelper$DividerType STAGGERED_GRID_HORIZONTAL;
    public static final DividerHelper$DividerType STAGGERED_GRID_VERTICAL;
    public static final DividerHelper$DividerType UNKNOWN;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DividerHelper$DividerType[] f11393a;

    static {
        DividerHelper$DividerType dividerHelper$DividerType = new DividerHelper$DividerType("LINEAR_VERTICAL", 0);
        LINEAR_VERTICAL = dividerHelper$DividerType;
        DividerHelper$DividerType dividerHelper$DividerType2 = new DividerHelper$DividerType("LINEAR_HORIZONTAL", 1);
        LINEAR_HORIZONTAL = dividerHelper$DividerType2;
        DividerHelper$DividerType dividerHelper$DividerType3 = new DividerHelper$DividerType("GRID_VERTICAL", 2);
        GRID_VERTICAL = dividerHelper$DividerType3;
        DividerHelper$DividerType dividerHelper$DividerType4 = new DividerHelper$DividerType("GRID_HORIZONTAL", 3);
        GRID_HORIZONTAL = dividerHelper$DividerType4;
        DividerHelper$DividerType dividerHelper$DividerType5 = new DividerHelper$DividerType("STAGGERED_GRID_VERTICAL", 4);
        STAGGERED_GRID_VERTICAL = dividerHelper$DividerType5;
        DividerHelper$DividerType dividerHelper$DividerType6 = new DividerHelper$DividerType("STAGGERED_GRID_HORIZONTAL", 5);
        STAGGERED_GRID_HORIZONTAL = dividerHelper$DividerType6;
        DividerHelper$DividerType dividerHelper$DividerType7 = new DividerHelper$DividerType(Constants.APP_VERSION_UNKNOWN, 6);
        UNKNOWN = dividerHelper$DividerType7;
        f11393a = new DividerHelper$DividerType[]{dividerHelper$DividerType, dividerHelper$DividerType2, dividerHelper$DividerType3, dividerHelper$DividerType4, dividerHelper$DividerType5, dividerHelper$DividerType6, dividerHelper$DividerType7};
    }

    public static DividerHelper$DividerType valueOf(String str) {
        return (DividerHelper$DividerType) Enum.valueOf(DividerHelper$DividerType.class, str);
    }

    public static DividerHelper$DividerType[] values() {
        return (DividerHelper$DividerType[]) f11393a.clone();
    }
}
