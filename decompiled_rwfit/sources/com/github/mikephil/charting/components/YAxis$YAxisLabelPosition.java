package com.github.mikephil.charting.components;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class YAxis$YAxisLabelPosition {
    public static final YAxis$YAxisLabelPosition INSIDE_CHART;
    public static final YAxis$YAxisLabelPosition OUTSIDE_CHART;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ YAxis$YAxisLabelPosition[] f8827a;

    static {
        YAxis$YAxisLabelPosition yAxis$YAxisLabelPosition = new YAxis$YAxisLabelPosition("OUTSIDE_CHART", 0);
        OUTSIDE_CHART = yAxis$YAxisLabelPosition;
        YAxis$YAxisLabelPosition yAxis$YAxisLabelPosition2 = new YAxis$YAxisLabelPosition("INSIDE_CHART", 1);
        INSIDE_CHART = yAxis$YAxisLabelPosition2;
        f8827a = new YAxis$YAxisLabelPosition[]{yAxis$YAxisLabelPosition, yAxis$YAxisLabelPosition2};
    }

    public static YAxis$YAxisLabelPosition valueOf(String str) {
        return (YAxis$YAxisLabelPosition) Enum.valueOf(YAxis$YAxisLabelPosition.class, str);
    }

    public static YAxis$YAxisLabelPosition[] values() {
        return (YAxis$YAxisLabelPosition[]) f8827a.clone();
    }
}
