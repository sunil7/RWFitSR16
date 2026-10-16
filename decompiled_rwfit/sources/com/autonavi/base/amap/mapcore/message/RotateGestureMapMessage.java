package com.autonavi.base.amap.mapcore.message;

import android.graphics.Point;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* loaded from: classes.dex */
public class RotateGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<RotateGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(256);
    public float angleDelta;
    public int pivotX;
    public int pivotY;

    public RotateGestureMapMessage(int i3, float f2, int i10, int i11) {
        super(i3);
        this.pivotX = 0;
        this.pivotY = 0;
        this.angleDelta = 0.0f;
        setParams(i3, f2, i10, i11);
        this.angleDelta = f2;
        this.pivotX = i10;
        this.pivotY = i11;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static RotateGestureMapMessage obtain(int i3, float f2, int i10, int i11) {
        RotateGestureMapMessage acquire = M_POOL.acquire();
        if (acquire == null) {
            return new RotateGestureMapMessage(i3, f2, i10, i11);
        }
        acquire.reset();
        acquire.setParams(i3, f2, i10, i11);
        return acquire;
    }

    private void setParams(int i3, float f2, int i10, int i11) {
        setState(i3);
        this.angleDelta = f2;
        this.pivotX = i10;
        this.pivotY = i11;
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 2;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        IPoint obtain;
        IPoint obtain2;
        float mapAngle = gLMapState.getMapAngle() + this.angleDelta;
        if (this.isGestureScaleByMapCenter) {
            gLMapState.setMapAngle(mapAngle);
            gLMapState.recalculate();
            return;
        }
        int i3 = this.pivotX;
        int i10 = this.pivotY;
        if (this.isUseAnchor) {
            i3 = this.anchorX;
            i10 = this.anchorY;
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
        gLMapState.setMapAngle(mapAngle);
        gLMapState.recalculate();
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
