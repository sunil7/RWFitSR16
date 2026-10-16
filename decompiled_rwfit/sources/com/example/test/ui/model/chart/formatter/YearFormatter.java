package com.example.test.ui.model.chart.formatter;

import android.content.Context;
import com.example.baselibrary.R$array;
import kotlin.jvm.internal.e;
import n7.a;
import p7.b;

/* loaded from: classes.dex */
public class YearFormatter implements b {
    private Context context;

    public YearFormatter(Context context) {
        this.context = context;
    }

    @Override // p7.b
    public String getFormattedValue(float f2, a aVar) {
        Context context = this.context;
        e.f(context, "context");
        String[] stringArray = context.getResources().getStringArray(R$array.month_string_array);
        e.e(stringArray, "getStringArray(...)");
        String str = stringArray[(int) f2];
        e.e(str, "get(...)");
        return str;
    }
}
