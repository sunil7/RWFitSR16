package com.github.mikephil.charting.components;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class Legend$LegendHorizontalAlignment {
    public static final Legend$LegendHorizontalAlignment CENTER;
    public static final Legend$LegendHorizontalAlignment LEFT;
    public static final Legend$LegendHorizontalAlignment RIGHT;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Legend$LegendHorizontalAlignment[] f8819a;

    static {
        Legend$LegendHorizontalAlignment legend$LegendHorizontalAlignment = new Legend$LegendHorizontalAlignment("LEFT", 0);
        LEFT = legend$LegendHorizontalAlignment;
        Legend$LegendHorizontalAlignment legend$LegendHorizontalAlignment2 = new Legend$LegendHorizontalAlignment("CENTER", 1);
        CENTER = legend$LegendHorizontalAlignment2;
        Legend$LegendHorizontalAlignment legend$LegendHorizontalAlignment3 = new Legend$LegendHorizontalAlignment("RIGHT", 2);
        RIGHT = legend$LegendHorizontalAlignment3;
        f8819a = new Legend$LegendHorizontalAlignment[]{legend$LegendHorizontalAlignment, legend$LegendHorizontalAlignment2, legend$LegendHorizontalAlignment3};
    }

    public static Legend$LegendHorizontalAlignment valueOf(String str) {
        return (Legend$LegendHorizontalAlignment) Enum.valueOf(Legend$LegendHorizontalAlignment.class, str);
    }

    public static Legend$LegendHorizontalAlignment[] values() {
        return (Legend$LegendHorizontalAlignment[]) f8819a.clone();
    }
}
