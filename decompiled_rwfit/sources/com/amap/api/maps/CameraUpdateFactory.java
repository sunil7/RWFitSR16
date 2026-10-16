package com.amap.api.maps;

import android.graphics.Point;
import android.util.Log;
import com.amap.api.col.p0003sl.i1;
import com.amap.api.col.p0003sl.j1;
import com.amap.api.col.p0003sl.k1;
import com.amap.api.col.p0003sl.l1;
import com.amap.api.col.p0003sl.x;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;

/* loaded from: classes.dex */
public final class CameraUpdateFactory {
    private static final String CLASSNAME = "CameraUpdateFactory";

    public static CameraUpdate changeBearing(float f2) {
        return new CameraUpdate(x.a(f2 % 360.0f));
    }

    public static CameraUpdate changeBearingGeoCenter(float f2, IPoint iPoint) {
        if (iPoint == null) {
            Log.w(CLASSNAME, "geoPoint is null");
            return new CameraUpdate(new j1());
        }
        Point point = new Point(((Point) iPoint).x, ((Point) iPoint).y);
        j1 j1Var = new j1();
        j1Var.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        j1Var.geoPoint = new DPoint(point.x, point.y);
        j1Var.bearing = f2 % 360.0f;
        return new CameraUpdate(j1Var);
    }

    public static CameraUpdate changeLatLng(LatLng latLng) {
        if (latLng != null) {
            return new CameraUpdate(x.a(VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20)));
        }
        Log.w(CLASSNAME, "target is null");
        return new CameraUpdate(new j1());
    }

    public static CameraUpdate changeTilt(float f2) {
        j1 j1Var = new j1();
        j1Var.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        j1Var.tilt = f2;
        return new CameraUpdate(j1Var);
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        if (cameraPosition != null) {
            return new CameraUpdate(x.a(cameraPosition));
        }
        Log.w(CLASSNAME, "cameraPosition is null");
        return new CameraUpdate(new j1());
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        if (latLng != null) {
            return new CameraUpdate(x.a(CameraPosition.builder().target(latLng).zoom(Float.NaN).bearing(Float.NaN).tilt(Float.NaN).build()));
        }
        Log.w(CLASSNAME, "latLng is null");
        return new CameraUpdate(new j1());
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i3) {
        if (latLngBounds == null) {
            Log.w(CLASSNAME, "bounds is null");
            return new CameraUpdate(new j1());
        }
        i1 i1Var = new i1();
        i1Var.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        i1Var.bounds = latLngBounds;
        i1Var.paddingLeft = i3;
        i1Var.paddingRight = i3;
        i1Var.paddingTop = i3;
        i1Var.paddingBottom = i3;
        return new CameraUpdate(i1Var);
    }

    public static CameraUpdate newLatLngBoundsRect(LatLngBounds latLngBounds, int i3, int i10, int i11, int i12) {
        if (latLngBounds == null) {
            Log.w(CLASSNAME, "bounds is null");
            return new CameraUpdate(new j1());
        }
        i1 i1Var = new i1();
        i1Var.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        i1Var.bounds = latLngBounds;
        i1Var.paddingLeft = i3;
        i1Var.paddingRight = i10;
        i1Var.paddingTop = i11;
        i1Var.paddingBottom = i12;
        return new CameraUpdate(i1Var);
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f2) {
        if (latLng != null) {
            return new CameraUpdate(x.a(CameraPosition.builder().target(latLng).zoom(f2).bearing(Float.NaN).tilt(Float.NaN).build()));
        }
        Log.w(CLASSNAME, "target is null");
        return new CameraUpdate(new j1());
    }

    public static CameraUpdate scrollBy(float f2, float f10) {
        k1 k1Var = new k1();
        k1Var.nowType = AbstractCameraUpdateMessage.Type.scrollBy;
        k1Var.xPixel = f2;
        k1Var.yPixel = f10;
        return new CameraUpdate(k1Var);
    }

    public static CameraUpdate zoomBy(float f2) {
        return new CameraUpdate(x.a(f2, (Point) null));
    }

    public static CameraUpdate zoomIn() {
        l1 l1Var = new l1();
        l1Var.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        l1Var.amount = 1.0f;
        return new CameraUpdate(l1Var);
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(x.a());
    }

    public static CameraUpdate zoomTo(float f2) {
        j1 j1Var = new j1();
        j1Var.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        j1Var.zoom = f2;
        return new CameraUpdate(j1Var);
    }

    public static CameraUpdate zoomBy(float f2, Point point) {
        return new CameraUpdate(x.a(f2, point));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i3, int i10, int i11) {
        if (latLngBounds == null) {
            Log.w(CLASSNAME, "bounds is null");
            return new CameraUpdate(new j1());
        }
        i1 i1Var = new i1();
        i1Var.nowType = AbstractCameraUpdateMessage.Type.newLatLngBoundsWithSize;
        i1Var.bounds = latLngBounds;
        i1Var.paddingLeft = i11;
        i1Var.paddingRight = i11;
        i1Var.paddingTop = i11;
        i1Var.paddingBottom = i11;
        i1Var.width = i3;
        i1Var.height = i10;
        return new CameraUpdate(i1Var);
    }
}
