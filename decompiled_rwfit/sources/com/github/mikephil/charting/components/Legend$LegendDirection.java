package com.github.mikephil.charting.components;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class Legend$LegendDirection {
    public static final Legend$LegendDirection LEFT_TO_RIGHT;
    public static final Legend$LegendDirection RIGHT_TO_LEFT;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Legend$LegendDirection[] f8817a;

    static {
        Legend$LegendDirection legend$LegendDirection = new Legend$LegendDirection("LEFT_TO_RIGHT", 0);
        LEFT_TO_RIGHT = legend$LegendDirection;
        Legend$LegendDirection legend$LegendDirection2 = new Legend$LegendDirection("RIGHT_TO_LEFT", 1);
        RIGHT_TO_LEFT = legend$LegendDirection2;
        f8817a = new Legend$LegendDirection[]{legend$LegendDirection, legend$LegendDirection2};
    }

    public static Legend$LegendDirection valueOf(String str) {
        return (Legend$LegendDirection) Enum.valueOf(Legend$LegendDirection.class, str);
    }

    public static Legend$LegendDirection[] values() {
        return (Legend$LegendDirection[]) f8817a.clone();
    }
}
