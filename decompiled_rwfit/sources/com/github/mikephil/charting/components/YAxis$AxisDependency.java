package com.github.mikephil.charting.components;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class YAxis$AxisDependency {
    public static final YAxis$AxisDependency LEFT;
    public static final YAxis$AxisDependency RIGHT;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ YAxis$AxisDependency[] f8826a;

    static {
        YAxis$AxisDependency yAxis$AxisDependency = new YAxis$AxisDependency("LEFT", 0);
        LEFT = yAxis$AxisDependency;
        YAxis$AxisDependency yAxis$AxisDependency2 = new YAxis$AxisDependency("RIGHT", 1);
        RIGHT = yAxis$AxisDependency2;
        f8826a = new YAxis$AxisDependency[]{yAxis$AxisDependency, yAxis$AxisDependency2};
    }

    public static YAxis$AxisDependency valueOf(String str) {
        return (YAxis$AxisDependency) Enum.valueOf(YAxis$AxisDependency.class, str);
    }

    public static YAxis$AxisDependency[] values() {
        return (YAxis$AxisDependency[]) f8826a.clone();
    }
}
