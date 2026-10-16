package com.autonavi.base.amap.mapcore.message;

import android.graphics.Point;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* loaded from: classes.dex */
public class ScaleGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<ScaleGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(256);
    public int pivotX;
    public int pivotY;
    public float scaleDelta;

    public ScaleGestureMapMessage(int i3, float f2, int i10, int i11) {
        super(i3);
        this.scaleDelta = 0.0f;
        this.pivotX = 0;
        this.pivotY = 0;
        setParams(i3, f2, i10, i11);
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static ScaleGestureMapMessage obtain(int i3, float f2, int i10, int i11) {
        ScaleGestureMapMessage acquire = M_POOL.acquire();
        if (acquire == null) {
            return new ScaleGestureMapMessage(i3, f2, i10, i11);
        }
        acquire.reset();
        acquire.setParams(i3, f2, i10, i11);
        return acquire;
    }

    private void setMapZoomer(GLMapState gLMapState) {
        gLMapState.setMapZoomer(gLMapState.getMapZoomer() + this.scaleDelta);
        gLMapState.recalculate();
    }

    private void setParams(int i3, float f2, int i10, int i11) {
        setState(i3);
        this.scaleDelta = f2;
        this.pivotX = i10;
        this.pivotY = i11;
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 1;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        IPoint obtain;
        IPoint obtain2;
        if (this.isUseAnchor) {
            setMapZoomer(gLMapState);
            return;
        }
        int i3 = this.pivotX;
        int i10 = this.pivotY;
        if (this.isGestureScaleByMapCenter) {
            i3 = this.width >> 1;
            i10 = this.height >> 1;
        }
        if (i3 > 0 || i10 > 0) {
            obtain = IPoint.obtain();
            obtain2 = IPoint.obtain();
            win2geo(gLMapState, i3, i10, obtain);
            gLMapState.setMapGeoCenter(((Point) obtain).x, ((Point) obtain).y);
        } else {
            obtain = null;
            obtain2 = null;
        }
        setMapZoomer(gLMapState);
        if (i3 > 0 || i10 > 0) {
            win2geo(gLMapState, i3, i10, obtain2);
            if (obtain != null) {
                gLMapState.setMapGeoCenter((((Point) obtain).x * 2) - ((Point) obtain2).x, (((Point) obtain).y * 2) - ((Point) obtain2).y);
            }
            gLMapState.recalculate();
        }
        if (obtain != null) {
            obtain.recycle();
        }
        if (obtain2 != null) {
            obtain2.recycle();
        }
    }
}
