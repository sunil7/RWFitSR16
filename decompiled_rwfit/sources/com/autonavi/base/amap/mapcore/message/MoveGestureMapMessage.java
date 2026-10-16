package com.autonavi.base.amap.mapcore.message;

import android.graphics.Point;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* loaded from: classes.dex */
public class MoveGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<MoveGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(1024);
    static int newCount;
    public float touchDeltaX;
    public float touchDeltaY;
    public int touchX;
    public int touchY;

    public MoveGestureMapMessage(int i3, float f2, float f10) {
        super(i3);
        this.touchX = 0;
        this.touchY = 0;
        this.touchDeltaX = f2;
        this.touchDeltaY = f10;
        newCount++;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static synchronized MoveGestureMapMessage obtain(int i3, float f2, float f10, float f11, float f12) {
        MoveGestureMapMessage acquire;
        synchronized (MoveGestureMapMessage.class) {
            try {
                acquire = M_POOL.acquire();
                if (acquire == null) {
                    acquire = new MoveGestureMapMessage(i3, f2, f10);
                } else {
                    acquire.reset();
                    acquire.setParams(i3, f2, f10);
                }
                acquire.touchX = (int) f11;
                acquire.touchY = (int) f12;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return acquire;
    }

    private void setParams(int i3, float f2, float f10) {
        setState(i3);
        this.touchDeltaX = f2;
        this.touchDeltaY = f10;
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 0;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        int i3 = (int) this.touchDeltaX;
        int i10 = (int) this.touchDeltaY;
        int i11 = this.touchX - i3;
        int i12 = this.touchY - i10;
        IPoint obtain = IPoint.obtain();
        win2geo(gLMapState, this.touchX, this.touchY, obtain);
        IPoint obtain2 = IPoint.obtain();
        win2geo(gLMapState, i11, i12, obtain2);
        IPoint obtain3 = IPoint.obtain();
        gLMapState.getMapGeoCenter(obtain3);
        gLMapState.setMapGeoCenter((((Point) obtain2).x - ((Point) obtain).x) + ((Point) obtain3).x, (((Point) obtain2).y - ((Point) obtain).y) + ((Point) obtain3).y);
        gLMapState.recalculate();
        obtain3.recycle();
        obtain.recycle();
        obtain2.recycle();
    }
}
