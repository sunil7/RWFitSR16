package com.autonavi.amap.mapcore;

import android.graphics.Point;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* loaded from: classes.dex */
public class IPoint extends Point implements Cloneable {
    private static final Pools.SynchronizedPool<IPoint> M_POOL = new Pools.SynchronizedPool<>(32);

    public IPoint() {
    }

    public static IPoint obtain() {
        IPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new IPoint();
        }
        acquire.set(0, 0);
        return acquire;
    }

    public Object clone() {
        try {
            return (IPoint) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public double distance(IPoint iPoint) {
        return Math.sqrt(Math.pow(((Point) iPoint).y - ((Point) this).y, 2.0d) + Math.pow(((Point) iPoint).x - ((Point) this).x, 2.0d));
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public IPoint(int i3, int i10) {
        ((Point) this).x = i3;
        ((Point) this).y = i10;
    }

    public static IPoint obtain(int i3, int i10) {
        IPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new IPoint(i3, i10);
        }
        acquire.set(i3, i10);
        return acquire;
    }
}
