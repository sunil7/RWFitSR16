package com.github.mikephil.charting.components;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class Legend$LegendOrientation {
    public static final Legend$LegendOrientation HORIZONTAL;
    public static final Legend$LegendOrientation VERTICAL;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Legend$LegendOrientation[] f8820a;

    static {
        Legend$LegendOrientation legend$LegendOrientation = new Legend$LegendOrientation("HORIZONTAL", 0);
        HORIZONTAL = legend$LegendOrientation;
        Legend$LegendOrientation legend$LegendOrientation2 = new Legend$LegendOrientation("VERTICAL", 1);
        VERTICAL = legend$LegendOrientation2;
        f8820a = new Legend$LegendOrientation[]{legend$LegendOrientation, legend$LegendOrientation2};
    }

    public static Legend$LegendOrientation valueOf(String str) {
        return (Legend$LegendOrientation) Enum.valueOf(Legend$LegendOrientation.class, str);
    }

    public static Legend$LegendOrientation[] values() {
        return (Legend$LegendOrientation[]) f8820a.clone();
    }
}
