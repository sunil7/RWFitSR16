package com.amap.api.col.p0003sl;

import android.graphics.Point;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* loaded from: classes.dex */
public class k1 extends AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public void runCameraUpdate(IGLMapState iGLMapState) {
        float f2 = this.xPixel;
        float f10 = (this.width / 2.0f) + f2;
        float f11 = (this.height / 2.0f) + this.yPixel;
        iGLMapState.screenToP20Point((int) f10, (int) f11, new Point());
        iGLMapState.setMapGeoCenter(r1.x, r1.y);
    }
}
