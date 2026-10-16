package com.autonavi.base.ae.gmap.gloverlay;

/* loaded from: classes.dex */
public class GLOverlayTexture {
    public int mAnchor;
    public float mAnchorXRatio;
    public float mAnchorYRatio;
    public int mHeight;
    public int mResHeight;
    public int mResId;
    public int mResWidth;
    public int mWidth;

    public GLOverlayTexture(int i3, int i10, int i11, int i12) {
        this.mResId = i3;
        this.mWidth = i11;
        this.mHeight = i12;
        this.mResWidth = i11;
        this.mResHeight = i12;
        this.mAnchor = i10;
    }

    public GLOverlayTexture(int i3, int i10, float f2, float f10, int i11, int i12) {
        this.mResId = i3;
        this.mWidth = i11;
        this.mHeight = i12;
        this.mResWidth = i11;
        this.mResHeight = i12;
        this.mAnchor = i10;
        this.mAnchorXRatio = f2;
        this.mAnchorYRatio = f10;
    }
}
