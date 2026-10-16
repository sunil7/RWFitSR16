package com.autonavi.amap.mapcore;

import android.graphics.Point;
import com.amap.api.col.p0003sl.v4;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.api.mapcore.IGLMapEngine;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.ae.gmap.GLMapEngine;

/* loaded from: classes.dex */
public abstract class AbstractCameraUpdateMessage {
    public float amount;
    public int anchorX;
    public int anchorY;
    public LatLngBounds bounds;
    public CameraPosition cameraPosition;
    public DPoint geoPoint;
    public int height;
    public boolean isChangeFinished;
    public AMap.CancelableCallback mCallback;
    public IMapConfig mapConfig;
    public int paddingBottom;
    public int paddingLeft;
    public int paddingRight;
    public int paddingTop;
    public int width;
    public float xPixel;
    public float yPixel;
    public Type nowType = Type.none;
    public Point focus = null;
    public float zoom = Float.NaN;
    public float tilt = Float.NaN;
    public float bearing = Float.NaN;
    public boolean isUseAnchor = false;
    public long mDuration = 250;
    public float maxZoomLevel = 0.0f;
    public float minZoomLevel = 0.0f;
    public float curZoolScale = 0.0f;

    public enum Type {
        none,
        zoomIn,
        changeCenter,
        changeTilt,
        changeBearing,
        changeBearingGeoCenter,
        changeGeoCenterZoom,
        zoomOut,
        zoomTo,
        zoomBy,
        scrollBy,
        newCameraPosition,
        newLatLngBounds,
        newLatLngBoundsWithSize,
        changeGeoCenterZoomTiltBearing
    }

    public void changeCenterByAnchor(IGLMapState iGLMapState, DPoint dPoint) {
        changeCenterByAnchor(iGLMapState, dPoint, this.anchorX, this.anchorY);
    }

    public void generateMapAnimation(IGLMapEngine iGLMapEngine) {
        int engineIDWithType = ((GLMapEngine) iGLMapEngine).getEngineIDWithType(1);
        IGLMapState newMapState = iGLMapEngine.getNewMapState(engineIDWithType);
        runCameraUpdate(newMapState);
        DPoint mapGeoCenter = newMapState.getMapGeoCenter();
        iGLMapEngine.addGroupAnimation(engineIDWithType, (int) this.mDuration, newMapState.getMapZoomer(), (int) newMapState.getMapAngle(), (int) newMapState.getCameraDegree(), (int) mapGeoCenter.f6570x, (int) mapGeoCenter.f6571y, this.mCallback);
        newMapState.recycle();
    }

    public Point getAnchorGeoPoint(IGLMapState iGLMapState, int i3, int i10) {
        Point point = new Point();
        iGLMapState.screenToP20Point(i3, i10, point);
        return point;
    }

    public abstract void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage);

    public void normalChange(IGLMapState iGLMapState) {
        this.zoom = Float.isNaN(this.zoom) ? iGLMapState.getMapZoomer() : this.zoom;
        this.bearing = Float.isNaN(this.bearing) ? iGLMapState.getMapAngle() : this.bearing;
        this.tilt = Float.isNaN(this.tilt) ? iGLMapState.getCameraDegree() : this.tilt;
        float a3 = v4.a(this.mapConfig, this.zoom);
        this.zoom = a3;
        this.tilt = v4.a(this.mapConfig, this.tilt, a3);
        this.bearing = (float) (((this.bearing % 360.0d) + 360.0d) % 360.0d);
        Point point = this.focus;
        if (point != null && this.geoPoint == null) {
            Point anchorGeoPoint = getAnchorGeoPoint(iGLMapState, point.x, point.y);
            this.geoPoint = new DPoint(anchorGeoPoint.x, anchorGeoPoint.y);
        }
        if (!Float.isNaN(this.zoom)) {
            iGLMapState.setMapZoomer(this.zoom);
        }
        if (!Float.isNaN(this.bearing)) {
            iGLMapState.setMapAngle(this.bearing);
        }
        if (!Float.isNaN(this.tilt)) {
            iGLMapState.setCameraDegree(this.tilt);
        }
        Point point2 = this.focus;
        if (point2 != null) {
            changeCenterByAnchor(iGLMapState, this.geoPoint, point2.x, point2.y);
            return;
        }
        DPoint dPoint = this.geoPoint;
        if (dPoint != null) {
            double d5 = dPoint.f6570x;
            if (d5 == 0.0d && dPoint.f6571y == 0.0d) {
                return;
            }
            iGLMapState.setMapGeoCenter(d5, dPoint.f6571y);
        }
    }

    public abstract void runCameraUpdate(IGLMapState iGLMapState);

    public void changeCenterByAnchor(IGLMapState iGLMapState, DPoint dPoint, int i3, int i10) {
        iGLMapState.recalculate();
        Point anchorGeoPoint = getAnchorGeoPoint(iGLMapState, i3, i10);
        DPoint mapGeoCenter = iGLMapState.getMapGeoCenter();
        iGLMapState.setMapGeoCenter((mapGeoCenter.f6570x + dPoint.f6570x) - anchorGeoPoint.x, (mapGeoCenter.f6571y + dPoint.f6571y) - anchorGeoPoint.y);
    }
}
