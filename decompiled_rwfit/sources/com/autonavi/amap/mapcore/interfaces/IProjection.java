package com.autonavi.amap.mapcore.interfaces;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;

/* loaded from: classes.dex */
public interface IProjection {
    float calculateMapZoomer(LatLng latLng, int i3);

    TileProjection fromBoundsToTile(LatLngBounds latLngBounds, int i3, int i10) throws RemoteException;

    LatLng fromScreenLocation(Point point) throws RemoteException;

    AMapCameraInfo getCameraInfo();

    LatLngBounds getMapBounds(LatLng latLng, float f2) throws RemoteException;

    VisibleRegion getVisibleRegion() throws RemoteException;

    float toMapLenWithWin(int i3) throws RemoteException;

    PointF toMapLocation(LatLng latLng) throws RemoteException;

    Point toScreenLocation(LatLng latLng) throws RemoteException;
}
