package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import q7.g;

@SuppressLint({"ParcelCreator"})
/* loaded from: classes.dex */
public class BarEntry extends Entry {
    private float mNegativeSum;
    private float mPositiveSum;
    private g[] mRanges;
    private float[] mYVals;

    public final float l() {
        return this.mNegativeSum;
    }

    public final float m() {
        return this.mPositiveSum;
    }

    public final g[] n() {
        return this.mRanges;
    }

    public final float[] o() {
        return this.mYVals;
    }

    public final boolean p() {
        return this.mYVals != null;
    }
}
