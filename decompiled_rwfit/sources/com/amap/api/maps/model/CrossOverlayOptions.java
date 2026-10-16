package com.amap.api.maps.model;

import android.graphics.Bitmap;
import com.autonavi.base.ae.gmap.gloverlay.AVectorCrossAttr;

/* loaded from: classes.dex */
public class CrossOverlayOptions {

    /* renamed from: a, reason: collision with root package name */
    AVectorCrossAttr f5730a = null;
    private Bitmap bitmapDescriptor = null;

    public AVectorCrossAttr getAttribute() {
        return this.f5730a;
    }

    public Bitmap getRes() {
        return this.bitmapDescriptor;
    }

    public CrossOverlayOptions setAttribute(AVectorCrossAttr aVectorCrossAttr) {
        this.f5730a = aVectorCrossAttr;
        return this;
    }

    public CrossOverlayOptions setRes(Bitmap bitmap) {
        this.bitmapDescriptor = bitmap;
        return this;
    }
}
