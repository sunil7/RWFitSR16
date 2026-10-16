package com.autonavi.base.amap.mapcore.message;

import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.AbstractMapMessage;
import com.autonavi.base.ae.gmap.GLMapState;

/* loaded from: classes.dex */
public abstract class AbstractGestureMapMessage extends AbstractMapMessage {
    public int anchorX;
    public int anchorY;
    private int state;
    public int width = 0;
    public int height = 0;
    public boolean isGestureScaleByMapCenter = false;
    public boolean isUseAnchor = false;

    public AbstractGestureMapMessage(int i3) {
        this.state = i3;
    }

    public IPoint getAnchorGeoPoint(GLMapState gLMapState, int i3, int i10) {
        IPoint obtain = IPoint.obtain();
        gLMapState.screenToP20Point(i3, i10, obtain);
        return obtain;
    }

    public int getMapGestureState() {
        return this.state;
    }

    @Override // com.autonavi.base.ae.gmap.AbstractMapMessage
    public abstract int getType();

    public void reset() {
        this.width = 0;
        this.height = 0;
        this.state = 0;
        this.isGestureScaleByMapCenter = false;
        this.isUseAnchor = false;
        this.anchorX = 0;
        this.anchorY = 0;
    }

    public abstract void runCameraUpdate(GLMapState gLMapState);

    public void setState(int i3) {
        this.state = i3;
    }

    public void win2geo(GLMapState gLMapState, int i3, int i10, IPoint iPoint) {
        gLMapState.screenToP20Point(i3, i10, iPoint);
    }
}
