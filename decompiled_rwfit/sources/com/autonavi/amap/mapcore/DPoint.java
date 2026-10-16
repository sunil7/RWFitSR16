package com.autonavi.amap.mapcore;

import com.autonavi.base.ae.gmap.maploader.Pools;

/* loaded from: classes.dex */
public class DPoint {
    private static final Pools.SynchronizedPool<DPoint> M_POOL = new Pools.SynchronizedPool<>(32);

    /* renamed from: x, reason: collision with root package name */
    public double f6570x;

    /* renamed from: y, reason: collision with root package name */
    public double f6571y;

    public DPoint() {
    }

    public static DPoint obtain() {
        DPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new DPoint();
        }
        acquire.set(0.0d, 0.0d);
        return acquire;
    }

    private void set(double d5, double d8) {
        this.f6570x = d5;
        this.f6571y = d8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DPoint)) {
            return false;
        }
        DPoint dPoint = (DPoint) obj;
        return Double.doubleToLongBits(this.f6570x) == Double.doubleToLongBits(dPoint.f6570x) && Double.doubleToLongBits(this.f6571y) == Double.doubleToLongBits(dPoint.f6571y);
    }

    public void recycle() {
        M_POOL.release(this);
    }

    public DPoint(double d5, double d8) {
        this.f6570x = d5;
        this.f6571y = d8;
    }

    public static DPoint obtain(double d5, double d8) {
        DPoint acquire = M_POOL.acquire();
        if (acquire == null) {
            return new DPoint(d5, d8);
        }
        acquire.set(d5, d8);
        return acquire;
    }
}
