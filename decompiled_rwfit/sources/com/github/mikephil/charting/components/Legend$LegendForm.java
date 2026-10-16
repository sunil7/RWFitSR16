package com.github.mikephil.charting.components;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class Legend$LegendForm {
    public static final Legend$LegendForm CIRCLE;
    public static final Legend$LegendForm DEFAULT;
    public static final Legend$LegendForm EMPTY;
    public static final Legend$LegendForm LINE;
    public static final Legend$LegendForm NONE;
    public static final Legend$LegendForm SQUARE;

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Legend$LegendForm[] f8818a;

    static {
        Legend$LegendForm legend$LegendForm = new Legend$LegendForm("NONE", 0);
        NONE = legend$LegendForm;
        Legend$LegendForm legend$LegendForm2 = new Legend$LegendForm("EMPTY", 1);
        EMPTY = legend$LegendForm2;
        Legend$LegendForm legend$LegendForm3 = new Legend$LegendForm("DEFAULT", 2);
        DEFAULT = legend$LegendForm3;
        Legend$LegendForm legend$LegendForm4 = new Legend$LegendForm("SQUARE", 3);
        SQUARE = legend$LegendForm4;
        Legend$LegendForm legend$LegendForm5 = new Legend$LegendForm("CIRCLE", 4);
        CIRCLE = legend$LegendForm5;
        Legend$LegendForm legend$LegendForm6 = new Legend$LegendForm("LINE", 5);
        LINE = legend$LegendForm6;
        f8818a = new Legend$LegendForm[]{legend$LegendForm, legend$LegendForm2, legend$LegendForm3, legend$LegendForm4, legend$LegendForm5, legend$LegendForm6};
    }

    public static Legend$LegendForm valueOf(String str) {
        return (Legend$LegendForm) Enum.valueOf(Legend$LegendForm.class, str);
    }

    public static Legend$LegendForm[] values() {
        return (Legend$LegendForm[]) f8818a.clone();
    }
}
