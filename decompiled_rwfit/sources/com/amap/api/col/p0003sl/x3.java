package com.amap.api.col.p0003sl;

/* loaded from: classes.dex */
public enum x3 {
    STYLE_ELEMENT_LABELFILL_OLD("labels.text.fill", 0),
    STYLE_ELEMENT_LABELSTROKE_OLD("labels.text.stroke", 1),
    STYLE_ELEMENT_GEOMETRYSTROKE_OLD("geometry.stroke", 2),
    STYLE_ELEMENT_GEOMETRYFILL_OLD("geometry.fill", 3),
    STYLE_ELEMENT_LABELFILL("textFillColor", 0),
    STYLE_ELEMENT_LABELSTROKE("textStrokeColor", 1),
    STYLE_ELEMENT_GEOMETRYSTROKE("strokeColor", 2),
    STYLE_ELEMENT_GEOMETRYFILL("fillColor", 3),
    STYLE_ELEMENT_GEOMETRYFILL1("color", 3),
    STYLE_ELEMENT_GEOMETRYFILL2("textureName", 3),
    STYLE_ELEMENT_BACKGROUNDFILL("backgroundColor", 4),
    STYLE_ELEMENT_VISIBLE("visible", 5);


    /* renamed from: a, reason: collision with root package name */
    private String f5330a;

    /* renamed from: b, reason: collision with root package name */
    private int f5331b;

    x3(String str, int i3) {
        this.f5330a = str;
        this.f5331b = i3;
    }

    public static int a(String str) {
        x3[] values = values();
        for (int i3 = 0; i3 < 12; i3++) {
            x3 x3Var = values[i3];
            if (x3Var.f5330a.equals(str)) {
                return x3Var.f5331b;
            }
        }
        return -1;
    }
}
