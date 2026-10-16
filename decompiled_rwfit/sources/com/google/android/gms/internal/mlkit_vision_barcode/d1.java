package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import com.autonavi.base.ae.gmap.glyph.FontStyle;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class d1 {
    public d1() {
        new ConcurrentHashMap();
    }

    public abstract Typeface a(Context context, b1.f fVar, Resources resources, int i3);

    public abstract Typeface b(Context context, i1.f[] fVarArr, int i3);

    public Typeface c(Context context, Resources resources, int i3, String str, int i10) {
        File d5 = e1.d(context);
        if (d5 == null) {
            return null;
        }
        try {
            if (e1.b(d5, resources, i3)) {
                return Typeface.createFromFile(d5.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            d5.delete();
        }
    }

    public i1.f d(i1.f[] fVarArr, int i3) {
        new ec.a(3);
        int i10 = (i3 & 1) == 0 ? 400 : FontStyle.WEIGHT_BOLD;
        boolean z5 = (i3 & 2) != 0;
        i1.f fVar = null;
        int i11 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        for (i1.f fVar2 : fVarArr) {
            int abs = (Math.abs(fVar2.f14346c - i10) * 2) + (fVar2.f14347d == z5 ? 0 : 1);
            if (fVar == null || i11 > abs) {
                fVar = fVar2;
                i11 = abs;
            }
        }
        return fVar;
    }
}
