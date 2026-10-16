package com.autonavi.base.ae.gmap.glyph;

/* loaded from: classes.dex */
public class FontMetrics {
    public boolean bSuccess;
    public float fAscent;
    public float fDescent;
    public float fHeight;
    public float fLeading;

    public FontMetrics() {
        this.bSuccess = false;
        this.fAscent = 0.0f;
        this.fDescent = 0.0f;
        this.fLeading = 0.0f;
        this.fHeight = 0.0f;
    }

    public FontMetrics(float f2, float f10, float f11, float f12) {
        this.bSuccess = false;
        this.fAscent = f2;
        this.fDescent = f10;
        this.fLeading = f11;
        this.fHeight = f12;
    }
}
