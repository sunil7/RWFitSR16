package com.github.mikephil.charting.components;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class XAxis$XAxisPosition {
    public static final XAxis$XAxisPosition BOTH_SIDED;
    public static final XAxis$XAxisPosition BOTTOM;
    public static final XAxis$XAxisPosition BOTTOM_INSIDE;
    public static final XAxis$XAxisPosition TOP;
    public static final XAxis$XAxisPosition TOP_INSIDE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XAxis$XAxisPosition[] f8825a;

    static {
        XAxis$XAxisPosition xAxis$XAxisPosition = new XAxis$XAxisPosition("TOP", 0);
        TOP = xAxis$XAxisPosition;
        XAxis$XAxisPosition xAxis$XAxisPosition2 = new XAxis$XAxisPosition("BOTTOM", 1);
        BOTTOM = xAxis$XAxisPosition2;
        XAxis$XAxisPosition xAxis$XAxisPosition3 = new XAxis$XAxisPosition("BOTH_SIDED", 2);
        BOTH_SIDED = xAxis$XAxisPosition3;
        XAxis$XAxisPosition xAxis$XAxisPosition4 = new XAxis$XAxisPosition("TOP_INSIDE", 3);
        TOP_INSIDE = xAxis$XAxisPosition4;
        XAxis$XAxisPosition xAxis$XAxisPosition5 = new XAxis$XAxisPosition("BOTTOM_INSIDE", 4);
        BOTTOM_INSIDE = xAxis$XAxisPosition5;
        f8825a = new XAxis$XAxisPosition[]{xAxis$XAxisPosition, xAxis$XAxisPosition2, xAxis$XAxisPosition3, xAxis$XAxisPosition4, xAxis$XAxisPosition5};
    }

    public static XAxis$XAxisPosition valueOf(String str) {
        return (XAxis$XAxisPosition) Enum.valueOf(XAxis$XAxisPosition.class, str);
    }

    public static XAxis$XAxisPosition[] values() {
        return (XAxis$XAxisPosition[]) f8825a.clone();
    }
}
