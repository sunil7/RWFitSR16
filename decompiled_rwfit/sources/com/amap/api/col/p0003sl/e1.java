package com.amap.api.col.p0003sl;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IProjectionDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;

/* loaded from: classes.dex */
class e1 implements IProjectionDelegate {

    /* renamed from: a, reason: collision with root package name */
    private IAMapDelegate f3955a;

    public e1(IAMapDelegate iAMapDelegate) {
        this.f3955a = iAMapDelegate;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public float calculateMapZoomer(LatLng latLng, int i3) {
        IAMapDelegate iAMapDelegate = this.f3955a;
        if (iAMapDelegate == null || latLng == null) {
            return 3.0f;
        }
        GLMapState mapProjection = iAMapDelegate.getMapProjection();
        MapConfig mapConfig = this.f3955a.getMapConfig();
        if (mapProjection == null || mapConfig == null) {
            return 3.0f;
        }
        int sx = (int) mapConfig.getSX();
        int sy = (int) mapConfig.getSY();
        double d5 = latLng.latitude;
        double d8 = latLng.longitude;
        int i10 = v4.f5181b;
        IPoint obtain = IPoint.obtain();
        VirtualEarthProjection.latLongToPixels(d5, d8, 20, obtain);
        float calculateMapZoomer = mapProjection.calculateMapZoomer(sx, sy, ((Point) obtain).x, ((Point) obtain).y, i3);
        obtain.recycle();
        return calculateMapZoomer;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public TileProjection fromBoundsToTile(LatLngBounds latLngBounds, int i3, int i10) throws RemoteException {
        if (latLngBounds == null || i3 < 0 || i3 > 20 || i10 <= 0) {
            return null;
        }
        IPoint obtain = IPoint.obtain();
        IPoint obtain2 = IPoint.obtain();
        IAMapDelegate iAMapDelegate = this.f3955a;
        LatLng latLng = latLngBounds.southwest;
        iAMapDelegate.latlon2Geo(latLng.latitude, latLng.longitude, obtain);
        IAMapDelegate iAMapDelegate2 = this.f3955a;
        LatLng latLng2 = latLngBounds.northeast;
        iAMapDelegate2.latlon2Geo(latLng2.latitude, latLng2.longitude, obtain2);
        int i11 = ((Point) obtain).x;
        int i12 = 20 - i3;
        int i13 = (i11 >> i12) / i10;
        int i14 = (((Point) obtain).y >> i12) / i10;
        int i15 = (((Point) obtain2).x >> i12) / i10;
        int i16 = ((Point) obtain2).y;
        int i17 = (i16 >> i12) / i10;
        obtain.recycle();
        obtain2.recycle();
        return new TileProjection((i11 - ((i13 << i12) * i10)) >> i12, (i16 - ((i17 << i12) * i10)) >> i12, i13, i15, i17, i14);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public LatLng fromScreenLocation(Point point) throws RemoteException {
        if (point == null) {
            return null;
        }
        DPoint obtain = DPoint.obtain();
        this.f3955a.getPixel2LatLng(point.x, point.y, obtain);
        LatLng latLng = new LatLng(obtain.f6571y, obtain.f6570x);
        obtain.recycle();
        return latLng;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public AMapCameraInfo getCameraInfo() {
        return this.f3955a.getCamerInfo();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public LatLngBounds getMapBounds(LatLng latLng, float f2) throws RemoteException {
        IAMapDelegate iAMapDelegate = this.f3955a;
        if (iAMapDelegate == null || latLng == null) {
            return null;
        }
        return iAMapDelegate.getMapBounds(latLng, f2, 0.0f, 0.0f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public VisibleRegion getVisibleRegion() throws RemoteException {
        int mapWidth = this.f3955a.getMapWidth();
        int mapHeight = this.f3955a.getMapHeight();
        LatLng fromScreenLocation = fromScreenLocation(new Point(0, 0));
        LatLng fromScreenLocation2 = fromScreenLocation(new Point(mapWidth, 0));
        LatLng fromScreenLocation3 = fromScreenLocation(new Point(0, mapHeight));
        LatLng fromScreenLocation4 = fromScreenLocation(new Point(mapWidth, mapHeight));
        return new VisibleRegion(fromScreenLocation3, fromScreenLocation4, fromScreenLocation, fromScreenLocation2, LatLngBounds.builder().include(fromScreenLocation3).include(fromScreenLocation4).include(fromScreenLocation).include(fromScreenLocation2).build());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public float toMapLenWithWin(int i3) {
        if (i3 <= 0) {
            return 0.0f;
        }
        return this.f3955a.toMapLenWithWin(i3);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public PointF toMapLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        FPoint obtain = FPoint.obtain();
        this.f3955a.getLatLng2Map(latLng.latitude, latLng.longitude, obtain);
        PointF pointF = new PointF(((PointF) obtain).x, ((PointF) obtain).y);
        obtain.recycle();
        return pointF;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IProjection
    public Point toScreenLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        IPoint obtain = IPoint.obtain();
        this.f3955a.getLatLng2Pixel(latLng.latitude, latLng.longitude, obtain);
        Point point = new Point(((Point) obtain).x, ((Point) obtain).y);
        obtain.recycle();
        return point;
    }
}
