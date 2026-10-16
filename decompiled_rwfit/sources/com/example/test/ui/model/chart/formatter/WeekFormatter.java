package com.example.test.ui.model.chart.formatter;

import android.content.Context;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import n7.a;
import p7.b;

/* loaded from: classes.dex */
public class WeekFormatter implements b {
    private Context context;

    public WeekFormatter(Context context) {
        this.context = context;
    }

    @Override // p7.b
    public String getFormattedValue(float f2, a aVar) {
        return ca.g(this.context, f2);
    }
}
