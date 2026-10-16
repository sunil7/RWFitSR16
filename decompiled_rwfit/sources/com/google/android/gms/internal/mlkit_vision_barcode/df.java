package com.google.android.gms.internal.mlkit_vision_barcode;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/* loaded from: classes.dex */
public abstract class df {
    public static int a(long j4) {
        if (j4 > 2147483647L) {
            return SubsamplingScaleImageView.TILE_SIZE_AUTO;
        }
        if (j4 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j4;
    }
}
