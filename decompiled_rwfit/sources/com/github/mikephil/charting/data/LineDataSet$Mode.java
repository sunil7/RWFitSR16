package com.github.mikephil.charting.data;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class LineDataSet$Mode {
    public static final LineDataSet$Mode CUBIC_BEZIER;
    public static final LineDataSet$Mode HORIZONTAL_BEZIER;
    public static final LineDataSet$Mode LINEAR;
    public static final LineDataSet$Mode STEPPED;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LineDataSet$Mode[] f8830a;

    static {
        LineDataSet$Mode lineDataSet$Mode = new LineDataSet$Mode("LINEAR", 0);
        LINEAR = lineDataSet$Mode;
        LineDataSet$Mode lineDataSet$Mode2 = new LineDataSet$Mode("STEPPED", 1);
        STEPPED = lineDataSet$Mode2;
        LineDataSet$Mode lineDataSet$Mode3 = new LineDataSet$Mode("CUBIC_BEZIER", 2);
        CUBIC_BEZIER = lineDataSet$Mode3;
        LineDataSet$Mode lineDataSet$Mode4 = new LineDataSet$Mode("HORIZONTAL_BEZIER", 3);
        HORIZONTAL_BEZIER = lineDataSet$Mode4;
        f8830a = new LineDataSet$Mode[]{lineDataSet$Mode, lineDataSet$Mode2, lineDataSet$Mode3, lineDataSet$Mode4};
    }

    public static LineDataSet$Mode valueOf(String str) {
        return (LineDataSet$Mode) Enum.valueOf(LineDataSet$Mode.class, str);
    }

    public static LineDataSet$Mode[] values() {
        return (LineDataSet$Mode[]) f8830a.clone();
    }
}
