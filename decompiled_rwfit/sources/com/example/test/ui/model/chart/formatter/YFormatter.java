package com.example.test.ui.model.chart.formatter;

import android.content.Context;
import n7.a;
import p7.b;

/* loaded from: classes.dex */
public class YFormatter implements b {
    private Context context;

    public YFormatter(Context context) {
        this.context = context;
    }

    @Override // p7.b
    public String getFormattedValue(float f2, a aVar) {
        return (f2 == 0.0f || f2 % 1.0f == 0.0f) ? r5.a.e(new StringBuilder(), (int) f2, "") : "";
    }
}
