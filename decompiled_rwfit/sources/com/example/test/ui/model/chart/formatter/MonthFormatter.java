package com.example.test.ui.model.chart.formatter;

import android.content.Context;
import n7.a;
import p7.b;

/* loaded from: classes.dex */
public class MonthFormatter implements b {
    private Context context;

    public MonthFormatter(Context context) {
        this.context = context;
    }

    @Override // p7.b
    public String getFormattedValue(float f2, a aVar) {
        return String.valueOf(((int) f2) + 1);
    }
}
