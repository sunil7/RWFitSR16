package com.example.test.ui.view.divider;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class FlexibleDividerDecoration$DividerType {
    public static final FlexibleDividerDecoration$DividerType COLOR;
    public static final FlexibleDividerDecoration$DividerType DRAWABLE;
    public static final FlexibleDividerDecoration$DividerType PAINT;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlexibleDividerDecoration$DividerType[] f8685a;

    static {
        FlexibleDividerDecoration$DividerType flexibleDividerDecoration$DividerType = new FlexibleDividerDecoration$DividerType("DRAWABLE", 0);
        DRAWABLE = flexibleDividerDecoration$DividerType;
        FlexibleDividerDecoration$DividerType flexibleDividerDecoration$DividerType2 = new FlexibleDividerDecoration$DividerType("PAINT", 1);
        PAINT = flexibleDividerDecoration$DividerType2;
        FlexibleDividerDecoration$DividerType flexibleDividerDecoration$DividerType3 = new FlexibleDividerDecoration$DividerType("COLOR", 2);
        COLOR = flexibleDividerDecoration$DividerType3;
        f8685a = new FlexibleDividerDecoration$DividerType[]{flexibleDividerDecoration$DividerType, flexibleDividerDecoration$DividerType2, flexibleDividerDecoration$DividerType3};
    }

    public static FlexibleDividerDecoration$DividerType valueOf(String str) {
        return (FlexibleDividerDecoration$DividerType) Enum.valueOf(FlexibleDividerDecoration$DividerType.class, str);
    }

    public static FlexibleDividerDecoration$DividerType[] values() {
        return (FlexibleDividerDecoration$DividerType[]) f8685a.clone();
    }
}
