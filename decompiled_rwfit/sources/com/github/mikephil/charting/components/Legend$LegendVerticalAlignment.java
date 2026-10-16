package com.github.mikephil.charting.components;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class Legend$LegendVerticalAlignment {
    public static final Legend$LegendVerticalAlignment BOTTOM;
    public static final Legend$LegendVerticalAlignment CENTER;
    public static final Legend$LegendVerticalAlignment TOP;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Legend$LegendVerticalAlignment[] f8821a;

    static {
        Legend$LegendVerticalAlignment legend$LegendVerticalAlignment = new Legend$LegendVerticalAlignment("TOP", 0);
        TOP = legend$LegendVerticalAlignment;
        Legend$LegendVerticalAlignment legend$LegendVerticalAlignment2 = new Legend$LegendVerticalAlignment("CENTER", 1);
        CENTER = legend$LegendVerticalAlignment2;
        Legend$LegendVerticalAlignment legend$LegendVerticalAlignment3 = new Legend$LegendVerticalAlignment("BOTTOM", 2);
        BOTTOM = legend$LegendVerticalAlignment3;
        f8821a = new Legend$LegendVerticalAlignment[]{legend$LegendVerticalAlignment, legend$LegendVerticalAlignment2, legend$LegendVerticalAlignment3};
    }

    public static Legend$LegendVerticalAlignment valueOf(String str) {
        return (Legend$LegendVerticalAlignment) Enum.valueOf(Legend$LegendVerticalAlignment.class, str);
    }

    public static Legend$LegendVerticalAlignment[] values() {
        return (Legend$LegendVerticalAlignment[]) f8821a.clone();
    }
}
