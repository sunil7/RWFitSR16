package com.amap.api.maps.utils.overlay;

import android.graphics.Point;
import com.amap.api.col.p0003sl.qc;
import com.amap.api.col.p0003sl.rc;
import com.amap.api.col.p0003sl.x;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class SmoothMoveMarker {
    public static final float MIN_OFFSET_DISTANCE = 5.0f;
    private BitmapDescriptor descriptor;
    private AMap mAMap;
    private MoveListener moveListener;
    private long pauseMillis;
    private long duration = 10000;
    private long mStepDuration = 20;
    private LinkedList<LatLng> points = new LinkedList<>();
    private LinkedList<Double> eachDistance = new LinkedList<>();
    private double totalDistance = 0.0d;
    private double remainDistance = 0.0d;
    private Object mLock = new Object();
    private Marker marker = null;
    private int index = 0;
    private boolean useDefaultDescriptor = false;
    AtomicBoolean exitFlag = new AtomicBoolean(false);
    private b moveStatus = b.ACTION_UNKNOWN;
    private long mAnimationBeginTime = System.currentTimeMillis();
    private qc mThreadPools = x.b("AMapSmoothMoveMarkerThread");

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
                SmoothMoveMarker.this.mAnimationBeginTime = System.currentTimeMillis();
                SmoothMoveMarker.this.moveStatus = b.ACTION_START;
                SmoothMoveMarker.this.exitFlag.set(false);
                while (!SmoothMoveMarker.this.exitFlag.get() && SmoothMoveMarker.this.index <= SmoothMoveMarker.this.points.size() - 1) {
                    synchronized (SmoothMoveMarker.this.mLock) {
                        try {
                            if (SmoothMoveMarker.this.exitFlag.get()) {
                                return;
                            }
                            if (SmoothMoveMarker.this.moveStatus != b.ACTION_PAUSE) {
                                IPoint curPosition = SmoothMoveMarker.this.getCurPosition(System.currentTimeMillis() - SmoothMoveMarker.this.mAnimationBeginTime);
                                if (SmoothMoveMarker.this.marker != null) {
                                    SmoothMoveMarker.this.marker.setGeoPoint(curPosition);
                                }
                                SmoothMoveMarker.this.moveStatus = b.ACTION_RUNNING;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    Thread.sleep(SmoothMoveMarker.this.mStepDuration);
                }
                SmoothMoveMarker.this.moveStatus = b.ACTION_STOP;
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    }

    public SmoothMoveMarker(AMap aMap) {
        this.mAMap = aMap;
    }

    private void checkMarkerIcon() {
        if (this.useDefaultDescriptor) {
            BitmapDescriptor bitmapDescriptor = this.descriptor;
            if (bitmapDescriptor == null) {
                this.useDefaultDescriptor = true;
            } else {
                this.marker.setIcon(bitmapDescriptor);
                this.useDefaultDescriptor = false;
            }
        }
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
        if (AMapUtils.calculateLineDistance(latLng2, latLng3) > 5.0f) {
            float rotate = getRotate(iPoint2, iPoint3);
            AMap aMap = this.mAMap;
            if (aMap != null && (cameraPosition = aMap.getCameraPosition()) != null) {
                this.marker.setRotateAngle((360.0f - rotate) + cameraPosition.bearing);
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
            b bVar = this.moveStatus;
            if (bVar != b.ACTION_RUNNING && bVar != b.ACTION_PAUSE) {
                return;
            }
            this.exitFlag.set(true);
            this.mThreadPools.a(this.mStepDuration + 20, TimeUnit.MILLISECONDS);
            Marker marker = this.marker;
            if (marker != null) {
                marker.setAnimation(null);
            }
            this.moveStatus = b.ACTION_UNKNOWN;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        try {
            reset();
            this.mThreadPools.a();
            BitmapDescriptor bitmapDescriptor = this.descriptor;
            if (bitmapDescriptor != null) {
                bitmapDescriptor.recycle();
            }
            Marker marker = this.marker;
            if (marker != null) {
                marker.destroy();
                this.marker = null;
            }
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

    public Marker getMarker() {
        return this.marker;
    }

    public LatLng getPosition() {
        Marker marker = this.marker;
        if (marker == null) {
            return null;
        }
        return marker.getPosition();
    }

    public void removeMarker() {
        Marker marker = this.marker;
        if (marker != null) {
            marker.remove();
            this.marker = null;
        }
        this.points.clear();
        this.eachDistance.clear();
    }

    public void resetIndex() {
        this.index = 0;
    }

    public void setDescriptor(BitmapDescriptor bitmapDescriptor) {
        BitmapDescriptor bitmapDescriptor2 = this.descriptor;
        if (bitmapDescriptor2 != null) {
            bitmapDescriptor2.recycle();
        }
        this.descriptor = bitmapDescriptor;
        Marker marker = this.marker;
        if (marker != null) {
            marker.setIcon(bitmapDescriptor);
        }
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
                    LatLng latLng3 = this.points.get(0);
                    Marker marker = this.marker;
                    if (marker != null) {
                        marker.setPosition(latLng3);
                        checkMarkerIcon();
                    } else {
                        if (this.descriptor == null) {
                            this.useDefaultDescriptor = true;
                        }
                        this.marker = this.mAMap.addMarker(new MarkerOptions().belowMaskLayer(true).position(latLng3).icon(this.descriptor).title("").anchor(0.5f, 0.5f));
                    }
                    reset();
                }
            }
        }
    }

    public void setPosition(LatLng latLng) {
        Marker marker = this.marker;
        if (marker != null) {
            marker.setPosition(latLng);
            checkMarkerIcon();
        } else {
            if (this.descriptor == null) {
                this.useDefaultDescriptor = true;
            }
            this.marker = this.mAMap.addMarker(new MarkerOptions().belowMaskLayer(true).position(latLng).icon(this.descriptor).title("").anchor(0.5f, 0.5f));
        }
    }

    public void setRotate(float f2) {
        AMap aMap;
        CameraPosition cameraPosition;
        if (this.marker == null || (aMap = this.mAMap) == null || (cameraPosition = aMap.getCameraPosition()) == null) {
            return;
        }
        this.marker.setRotateAngle((360.0f - f2) + cameraPosition.bearing);
    }

    public void setTotalDuration(int i3) {
        this.duration = i3 * 1000;
    }

    public void setVisible(boolean z5) {
        Marker marker = this.marker;
        if (marker != null) {
            marker.setVisible(z5);
        }
    }

    public void startSmoothMove() {
        b bVar = this.moveStatus;
        if (bVar == b.ACTION_PAUSE) {
            this.moveStatus = b.ACTION_RUNNING;
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
        if (this.moveStatus == b.ACTION_RUNNING) {
            this.moveStatus = b.ACTION_PAUSE;
            this.pauseMillis = System.currentTimeMillis();
        }
    }
}
