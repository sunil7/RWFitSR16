package com.autonavi.base.amap.mapcore;

/* loaded from: classes.dex */
public class FPoint3 extends FPoint {
    public int colorIndex;

    public FPoint3() {
        this.colorIndex = -1;
    }

    public void setColorIndex(int i3) {
        this.colorIndex = i3;
    }

    public FPoint3(float f2, float f10, int i3) {
        super(f2, f10);
        this.colorIndex = i3;
    }
}
