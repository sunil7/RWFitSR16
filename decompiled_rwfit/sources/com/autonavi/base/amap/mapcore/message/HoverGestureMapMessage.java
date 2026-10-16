package com.autonavi.base.amap.mapcore.message;

import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* loaded from: classes.dex */
public class HoverGestureMapMessage extends AbstractGestureMapMessage {
    private static final Pools.SynchronizedPool<HoverGestureMapMessage> M_POOL = new Pools.SynchronizedPool<>(256);
    public float angleDelta;

    public HoverGestureMapMessage(int i3, float f2) {
        super(i3);
        this.angleDelta = f2;
    }

    public static void destory() {
        M_POOL.destory();
    }

    public static HoverGestureMapMessage obtain(int i3, float f2) {
        HoverGestureMapMessage acquire = M_POOL.acquire();
        if (acquire == null) {
            acquire = new HoverGestureMapMessage(i3, f2);
        } else {
            acquire.reset();
        }
        acquire.setParams(i3, f2);
        return acquire;
    }

    private void setParams(int i3, float f2) {
        setState(i3);
        this.angleDelta = f2;
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage, com.autonavi.base.ae.gmap.AbstractMapMessage
    public int getType() {
        return 3;
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage
    public void runCameraUpdate(GLMapState gLMapState) {
        float cameraDegree = gLMapState.getCameraDegree() + this.angleDelta;
        float f2 = 0.0f;
        if (cameraDegree >= 0.0f) {
            f2 = 80.0f;
            if (cameraDegree <= 80.0f) {
                if (gLMapState.getCameraDegree() > 40.0f && cameraDegree > 40.0f && gLMapState.getCameraDegree() > cameraDegree) {
                    cameraDegree = 40.0f;
                }
                gLMapState.setCameraDegree(cameraDegree);
                gLMapState.recalculate();
            }
        }
        cameraDegree = f2;
        gLMapState.setCameraDegree(cameraDegree);
        gLMapState.recalculate();
    }
}
