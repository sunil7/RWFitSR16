package com.amap.api.maps.utils.overlay;

import android.graphics.Point;
import com.amap.api.col.p0003sl.qc;
import com.amap.api.col.p0003sl.rc;
import com.amap.api.col.p0003sl.x;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class MovingPointOverlay {
    private BasePointOverlay baseOverlay;
    private AMap mAMap;
    private qc mThreadPools;
    private MoveListener moveListener;
    private long pauseMillis;
    private long duration = 10000;
    private long mStepDuration = 20;
    private LinkedList<LatLng> points = new LinkedList<>();
    private LinkedList<Double> eachDistance = new LinkedList<>();
    private double totalDistance = 0.0d;
    private double remainDistance = 0.0d;
    private Object mLock = new Object();
    private int index = 0;
    private boolean useDefaultDescriptor = false;
    AtomicBoolean exitFlag = new AtomicBoolean(false);
    private b STATUS = b.ACTION_UNKNOWN;
    private long mAnimationBeginTime = System.currentTimeMillis();

    public interface MoveListener {
        void move(double d5);
    }

    public enum b {
        ACTION_UNKNOWN,
        ACTION_START,
        ACTION_RUNNING,
        ACTION_PAUSE,
        ACTION_STOP
    }

    public class c extends rc {
        private c() {
        }

        @Override // com.amap.api.col.p0003sl.rc
        public void runTask() {
            try {
                MovingPointOverlay.this.mAnimationBeginTime = System.currentTimeMillis();
                MovingPointOverlay.this.STATUS = b.ACTION_START;
                MovingPointOverlay.this.exitFlag.set(false);
                while (!MovingPointOverlay.this.exitFlag.get() && MovingPointOverlay.this.index <= MovingPointOverlay.this.points.size() - 1) {
                    synchronized (MovingPointOverlay.this.mLock) {
                        try {
                            if (MovingPointOverlay.this.exitFlag.get()) {
                                return;
                            }
                            if (MovingPointOverlay.this.STATUS != b.ACTION_PAUSE) {
                                MovingPointOverlay.this.baseOverlay.setGeoPoint(MovingPointOverlay.this.getCurPosition(System.currentTimeMillis() - MovingPointOverlay.this.mAnimationBeginTime));
                                MovingPointOverlay.this.STATUS = b.ACTION_RUNNING;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    Thread.sleep(MovingPointOverlay.this.mStepDuration);
                }
                MovingPointOverlay.this.STATUS = b.ACTION_STOP;
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    }

    public MovingPointOverlay(AMap aMap, BasePointOverlay basePointOverlay) {
        this.baseOverlay = null;
        if (aMap == null || basePointOverlay == null) {
            return;
        }
        this.mAMap = aMap;
        this.mThreadPools = x.b("AMapMoveSmoothThread");
        this.baseOverlay = basePointOverlay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IPoint getCurPosition(long j4) {
        double d5;
        CameraPosition cameraPosition;
        MoveListener moveListener;
        long j10 = this.duration;
        int i3 = 0;
        if (j4 > j10) {
            this.exitFlag.set(true);
            IPoint iPoint = new IPoint();
            int size = this.points.size() - 1;
            this.index = size;
            LatLng latLng = this.points.get(size);
            int i10 = this.index - 1;
            this.index = i10;
            this.index = Math.max(i10, 0);
            this.remainDistance = 0.0d;
            MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
            MoveListener moveListener2 = this.moveListener;
            if (moveListener2 != null) {
                moveListener2.move(this.remainDistance);
            }
            return iPoint;
        }
        double d8 = this.totalDistance;
        double d10 = (j4 * d8) / j10;
        this.remainDistance = d8 - d10;
        int i11 = 0;
        while (true) {
            if (i11 >= this.eachDistance.size()) {
                break;
            }
            double doubleValue = this.eachDistance.get(i11).doubleValue();
            if (d10 > doubleValue) {
                d10 -= doubleValue;
                i11++;
            } else {
                d5 = doubleValue > 0.0d ? d10 / doubleValue : 1.0d;
                i3 = i11;
            }
        }
        if (i3 != this.index && (moveListener = this.moveListener) != null) {
            moveListener.move(this.remainDistance);
        }
        this.index = i3;
        LatLng latLng2 = this.points.get(i3);
        LatLng latLng3 = this.points.get(i3 + 1);
        IPoint iPoint2 = new IPoint();
        MapProjection.lonlat2Geo(latLng2.longitude, latLng2.latitude, iPoint2);
        IPoint iPoint3 = new IPoint();
        MapProjection.lonlat2Geo(latLng3.longitude, latLng3.latitude, iPoint3);
        int i12 = ((Point) iPoint3).x - ((Point) iPoint2).x;
        int i13 = ((Point) iPoint3).y - ((Point) iPoint2).y;
        if (AMapUtils.calculateLineDistance(latLng2, latLng3) > 1.0f) {
            float rotate = getRotate(iPoint2, iPoint3);
            AMap aMap = this.mAMap;
            if (aMap != null && (cameraPosition = aMap.getCameraPosition()) != null) {
                this.baseOverlay.setRotateAngle((360.0f - rotate) + cameraPosition.bearing);
            }
        }
        return new IPoint((int) ((i12 * d5) + ((Point) iPoint2).x), (int) ((i13 * d5) + ((Point) iPoint2).y));
    }

    private float getRotate(IPoint iPoint, IPoint iPoint2) {
        if (iPoint == null || iPoint2 == null) {
            return 0.0f;
        }
        double d5 = ((Point) iPoint2).y;
        return (float) ((Math.atan2(((Point) iPoint2).x - ((Point) iPoint).x, ((Point) iPoint).y - d5) / 3.141592653589793d) * 180.0d);
    }

    private void reset() {
        try {
            b bVar = this.STATUS;
            if (bVar != b.ACTION_RUNNING && bVar != b.ACTION_PAUSE) {
                return;
            }
            this.exitFlag.set(true);
            this.mThreadPools.a(this.mStepDuration + 20, TimeUnit.MILLISECONDS);
            this.baseOverlay.setAnimation(null);
            this.STATUS = b.ACTION_UNKNOWN;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            removeMarker();
            this.mThreadPools.a();
            synchronized (this.mLock) {
                this.points.clear();
                this.eachDistance.clear();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public int getIndex() {
        return this.index;
    }

    public BasePointOverlay getObject() {
        return this.baseOverlay;
    }

    public LatLng getPosition() {
        BasePointOverlay basePointOverlay = this.baseOverlay;
        if (basePointOverlay != null) {
            return basePointOverlay.getPosition();
        }
        return null;
    }

    public void removeMarker() {
        try {
            reset();
            BasePointOverlay basePointOverlay = this.baseOverlay;
            if (basePointOverlay != null) {
                basePointOverlay.remove();
                this.baseOverlay = null;
            }
            this.points.clear();
            this.eachDistance.clear();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void resetIndex() {
        this.index = 0;
    }

    public void setMoveListener(MoveListener moveListener) {
        this.moveListener = moveListener;
    }

    public void setPoints(List<LatLng> list) {
        synchronized (this.mLock) {
            try {
            } catch (Throwable th2) {
                th2.printStackTrace();
            } finally {
            }
            if (list != null) {
                if (list.size() >= 2) {
                    stopMove();
                    this.points.clear();
                    for (LatLng latLng : list) {
                        if (latLng != null) {
                            this.points.add(latLng);
                        }
                    }
                    this.eachDistance.clear();
                    this.totalDistance = 0.0d;
                    int i3 = 0;
                    while (i3 < this.points.size() - 1) {
                        LatLng latLng2 = this.points.get(i3);
                        i3++;
                        double calculateLineDistance = AMapUtils.calculateLineDistance(latLng2, this.points.get(i3));
                        this.eachDistance.add(Double.valueOf(calculateLineDistance));
                        this.totalDistance += calculateLineDistance;
                    }
                    this.remainDistance = this.totalDistance;
                    this.baseOverlay.setPosition(this.points.get(0));
                    reset();
                }
            }
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            BasePointOverlay basePointOverlay = this.baseOverlay;
            if (basePointOverlay != null) {
                basePointOverlay.setPosition(latLng);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRotate(float f2) {
        AMap aMap;
        CameraPosition cameraPosition;
        try {
            if (this.baseOverlay == null || (aMap = this.mAMap) == null || (cameraPosition = aMap.getCameraPosition()) == null) {
                return;
            }
            this.baseOverlay.setRotateAngle((360.0f - f2) + cameraPosition.bearing);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTotalDuration(int i3) {
        this.duration = i3 * 1000;
    }

    public void setVisible(boolean z5) {
        try {
            BasePointOverlay basePointOverlay = this.baseOverlay;
            if (basePointOverlay != null) {
                basePointOverlay.setVisible(z5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startSmoothMove() {
        b bVar = this.STATUS;
        if (bVar == b.ACTION_PAUSE) {
            this.STATUS = b.ACTION_RUNNING;
            this.mAnimationBeginTime += System.currentTimeMillis() - this.pauseMillis;
        } else if ((bVar == b.ACTION_UNKNOWN || bVar == b.ACTION_STOP) && this.points.size() >= 1) {
            this.index = 0;
            try {
                this.mThreadPools.b(new c());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public void stopMove() {
        synchronized (this.mLock) {
            try {
                if (this.STATUS == b.ACTION_RUNNING) {
                    this.STATUS = b.ACTION_PAUSE;
                    this.pauseMillis = System.currentTimeMillis();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
