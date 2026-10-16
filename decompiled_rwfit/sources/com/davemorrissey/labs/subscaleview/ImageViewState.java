package com.davemorrissey.labs.subscaleview;

import android.graphics.PointF;
import java.io.Serializable;

/* loaded from: classes.dex */
public class ImageViewState implements Serializable {
    private final float centerX;
    private final float centerY;
    private final int orientation;
    private final float scale;

    public ImageViewState(float f2, PointF pointF, int i3) {
        this.scale = f2;
        this.centerX = pointF.x;
        this.centerY = pointF.y;
        this.orientation = i3;
    }

    public PointF getCenter() {
        return new PointF(this.centerX, this.centerY);
    }

    public int getOrientation() {
        return this.orientation;
    }

    public float getScale() {
        return this.scale;
    }
}
