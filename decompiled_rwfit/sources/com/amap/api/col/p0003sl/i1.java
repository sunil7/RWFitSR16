package com.amap.api.col.p0003sl;

import android.graphics.Point;
import android.util.Pair;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;

/* loaded from: classes.dex */
public class i1 extends AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public void runCameraUpdate(IGLMapState iGLMapState) {
        IMapConfig iMapConfig = this.mapConfig;
        int i3 = v4.f5181b;
        Pair<Float, IPoint> a3 = v4.a(iMapConfig, Math.max(this.paddingLeft, 1), Math.max(this.paddingRight, 1), Math.max(this.paddingTop, 1), Math.max(this.paddingBottom, 1), this.bounds, this.width, this.height);
        if (a3 == null) {
            return;
        }
        iGLMapState.setMapZoomer(((Float) a3.first).floatValue());
        IPoint iPoint = (IPoint) a3.second;
        iGLMapState.setMapGeoCenter(((Point) iPoint).x, ((Point) iPoint).y);
        iGLMapState.setCameraDegree(0.0f);
        iGLMapState.setMapAngle(0.0f);
    }
}
