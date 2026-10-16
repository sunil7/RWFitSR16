package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.util.Log;

@SuppressLint({"ParcelCreator"})
/* loaded from: classes.dex */
public class PieEntry extends Entry {
    private String label;

    @Override // com.github.mikephil.charting.data.Entry
    public final float j() {
        Log.i("DEPRECATED", "Pie entries do not have x values");
        return super.j();
    }

    @Override // com.github.mikephil.charting.data.Entry
    public final void k(float f2) {
        throw null;
    }
}
