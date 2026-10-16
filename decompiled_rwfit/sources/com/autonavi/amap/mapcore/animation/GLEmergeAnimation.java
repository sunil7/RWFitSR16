package com.autonavi.amap.mapcore.animation;

import com.amap.api.maps.model.LatLng;

/* loaded from: classes.dex */
public class GLEmergeAnimation extends GLAnimation {
    public LatLng mStartPoint;

    public GLEmergeAnimation(LatLng latLng) {
        this.mStartPoint = latLng;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f2, GLTransformation gLTransformation) {
    }
}
