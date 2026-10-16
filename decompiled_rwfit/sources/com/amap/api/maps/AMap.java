package com.amap.api.maps;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import android.util.Size;
import android.util.SizeF;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.col.p0003sl.b0;
import com.amap.api.col.p0003sl.n1;
import com.amap.api.col.p0003sl.o5;
import com.amap.api.col.p0003sl.p5;
import com.amap.api.map3d.R;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.BuildingOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.GL3DModelOptions;
import com.amap.api.maps.model.GLTFOverlay;
import com.amap.api.maps.model.GLTFOverlayOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.HeatMapGridLayer;
import com.amap.api.maps.model.HeatMapGridLayerOptions;
import com.amap.api.maps.model.HeatMapLayer;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.IndoorBuildingInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.MVTTileOverlay;
import com.amap.api.maps.model.MVTTileOverlayOptions;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.PoiFilter;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.RouteOverlay;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlay;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlayOptions;
import com.amap.api.maps.model.particle.ParticleOverlay;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.GLMapState;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class AMap {
    public static final String CHINESE = "zh_cn";
    private static final String CLASSNAME = "AMap";
    public static final String CUSTOM = "custom";
    public static final String ENGLISH = "en";
    public static final String LOCAL = "local";
    public static final int LOCATION_TYPE_LOCATE = 1;
    public static final int LOCATION_TYPE_MAP_FOLLOW = 2;
    public static final int LOCATION_TYPE_MAP_ROTATE = 3;
    public static final int MAP_TYPE_BUS = 5;
    public static final int MAP_TYPE_NAVI = 4;
    public static final int MAP_TYPE_NAVI_NIGHT = 6;
    public static final int MAP_TYPE_NIGHT = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MASK_LAYER_NONE = -1;
    public static final int MASK_LAYER_UNDER_LINE = 1;
    public static final int MASK_LAYER_UNDER_MARKER = 0;
    public static final String STYLE_CHINESE = "style_zh_cn";
    private final IAMap mapDelegate;
    private MyTrafficStyle myTrafficStyle;
    private Projection projection;
    private UiSettings uiSettings;

    public interface AMapAppResourceRequestListener {
        void onRequest(AMapAppRequestParam aMapAppRequestParam);
    }

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface CommonInfoWindowAdapter {
        InfoWindowParams getInfoWindowParams(BasePointOverlay basePointOverlay);
    }

    public interface ImageInfoWindowAdapter extends InfoWindowAdapter {
        long getInfoWindowUpdateTime();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface MultiPositionInfoWindowAdapter extends InfoWindowAdapter {
        View getInfoWindowClick(Marker marker);

        View getOverturnInfoWindow(Marker marker);

        View getOverturnInfoWindowClick(Marker marker);
    }

    public interface OnCacheRemoveListener {
        void onRemoveCacheFinish(boolean z5);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);

        void onCameraChangeFinish(CameraPosition cameraPosition);
    }

    public interface OnCustomMapStyleListener {
        void onFailure(int i3, String str);
    }

    public interface OnIndoorBuildingActiveListener {
        void OnIndoorBuilding(IndoorBuildingInfo indoorBuildingInfo);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedListener {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMapScreenShotListener {
        void onMapScreenShot(Bitmap bitmap);

        void onMapScreenShot(Bitmap bitmap, int i3);
    }

    public interface OnMapSnapshotListener {
        void onFinish();

        void onMapTile(Rect rect, Bitmap bitmap, int i3);
    }

    public interface OnMapTouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMultiPointClickListener {
        boolean onPointClick(MultiPointItem multiPointItem);
    }

    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface OnPOIClickListener {
        void onPOIClick(Poi poi);
    }

    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline polyline);
    }

    public interface SignleClickInterceptorListener {
        boolean isInterceptorSignleClick(MotionEvent motionEvent);
    }

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f5686a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ OnMapSnapshotListener f5687b;

        public a(AMap aMap, b bVar, OnMapSnapshotListener onMapSnapshotListener) {
            this.f5686a = bVar;
            this.f5687b = onMapSnapshotListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5686a.a();
            this.f5687b.onFinish();
        }
    }

    public class b {

        /* renamed from: a, reason: collision with root package name */
        private Size f5688a;

        /* renamed from: b, reason: collision with root package name */
        private CameraPosition f5689b;

        /* renamed from: c, reason: collision with root package name */
        private int f5690c;

        private b() {
        }

        public void a(Size size) {
            this.f5690c = AMap.this.getUiSettings().getLogoPosition();
            AMap.this.getUiSettings().setLogoPosition(2);
            this.f5689b = CameraPosition.builder(AMap.this.getCameraPosition()).build();
            if (AMap.this.mapDelegate instanceof b0) {
                this.f5688a = ((b0) AMap.this.mapDelegate).b(size);
            }
        }

        public /* synthetic */ b(AMap aMap, a aVar) {
            this();
        }

        public void a() {
            if (AMap.this.mapDelegate instanceof b0) {
                ((b0) AMap.this.mapDelegate).a(this.f5688a);
            }
            AMap.this.animateCamera(CameraUpdateFactory.newCameraPosition(this.f5689b));
            AMap.this.getUiSettings().setLogoPosition(this.f5690c);
        }
    }

    public interface onMapPrintScreenListener {
        void onMapPrint(Drawable drawable);
    }

    public AMap(IAMap iAMap) {
        this.mapDelegate = iAMap;
    }

    @Deprecated
    public static String getVersion() {
        return "11.1.063";
    }

    public void accelerateNetworkInChinese(boolean z5) {
        try {
            IAMap iAMap = this.mapDelegate;
            if (iAMap != null) {
                iAMap.accelerateNetworkInChinese(z5);
            }
        } catch (Throwable unused) {
        }
    }

    public AMap3DModelTileOverlay add3DModelTileOverlay(AMap3DModelTileOverlayOptions aMap3DModelTileOverlayOptions) {
        try {
            return this.mapDelegate.add3DModelTileOverlay(aMap3DModelTileOverlayOptions);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public void addAMapAppResourceListener(AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        try {
            this.mapDelegate.addAMapAppResourceListener(aMapAppResourceRequestListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final Arc addArc(ArcOptions arcOptions) {
        try {
            return this.mapDelegate.addArc(arcOptions);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final BuildingOverlay addBuildingOverlay() {
        try {
            return this.mapDelegate.addBuildingOverlay();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final Circle addCircle(CircleOptions circleOptions) {
        try {
            return this.mapDelegate.addCircle(circleOptions);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public p5 addContourLineOverlay(o5 o5Var) {
        try {
            return this.mapDelegate.addContourLineOverlay(o5Var);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public CrossOverlay addCrossOverlay(CrossOverlayOptions crossOverlayOptions) {
        try {
            return this.mapDelegate.addCrossVector(crossOverlayOptions);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public GL3DModel addGL3DModel(GL3DModelOptions gL3DModelOptions) {
        try {
            return this.mapDelegate.addGLModel(gL3DModelOptions);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final GLTFOverlay addGLTFOverlay(GLTFOverlayOptions gLTFOverlayOptions) {
        try {
            return this.mapDelegate.addGLTFOverlay(gLTFOverlayOptions);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        try {
            return this.mapDelegate.addGroundOverlay(groundOverlayOptions);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final HeatMapGridLayer addHeatMapGridLayer(HeatMapGridLayerOptions heatMapGridLayerOptions) {
        try {
            return this.mapDelegate.addHeatMapGridLayer(heatMapGridLayerOptions);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final HeatMapLayer addHeatMapLayer(HeatMapLayerOptions heatMapLayerOptions) {
        try {
            return this.mapDelegate.addHeatMapLayer(heatMapLayerOptions);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final MVTTileOverlay addMVTTileOverlay(MVTTileOverlayOptions mVTTileOverlayOptions) {
        try {
            return this.mapDelegate.addMVTTileOverlay(mVTTileOverlayOptions);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        try {
            return this.mapDelegate.addMarker(markerOptions);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z5) {
        try {
            return this.mapDelegate.addMarkers(arrayList, z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions multiPointOverlayOptions) {
        try {
            return this.mapDelegate.addMultiPointOverlay(multiPointOverlayOptions);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) {
        try {
            return this.mapDelegate.addNavigateArrow(navigateArrowOptions);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final void addOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        try {
            this.mapDelegate.addOnCameraChangeListener(onCameraChangeListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void addOnIndoorBuildingActiveListener(OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) {
        try {
            this.mapDelegate.addOnIndoorBuildingActiveListener(onIndoorBuildingActiveListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void addOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            this.mapDelegate.addOnInfoWindowClickListener(onInfoWindowClickListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void addOnMapClickListener(OnMapClickListener onMapClickListener) {
        try {
            this.mapDelegate.addOnMapClickListener(onMapClickListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void addOnMapLoadedListener(OnMapLoadedListener onMapLoadedListener) {
        try {
            this.mapDelegate.addOnMapLoadedListener(onMapLoadedListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void addOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        try {
            this.mapDelegate.addOnMapLongClickListener(onMapLongClickListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void addOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        try {
            this.mapDelegate.addOnMapTouchListener(onMapTouchListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void addOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        try {
            this.mapDelegate.addOnMarkerClickListener(onMarkerClickListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void addOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        try {
            this.mapDelegate.addOnMarkerDragListener(onMarkerDragListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void addOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            this.mapDelegate.addOnMyLocationChangeListener(onMyLocationChangeListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void addOnPOIClickListener(OnPOIClickListener onPOIClickListener) {
        try {
            this.mapDelegate.addOnPOIClickListener(onPOIClickListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void addOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        try {
            this.mapDelegate.addOnPolylineClickListener(onPolylineClickListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public ParticleOverlay addParticleOverlay(ParticleOverlayOptions particleOverlayOptions) {
        try {
            return this.mapDelegate.addParticleOverlay(particleOverlayOptions);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public void addPoiFilter(PoiFilter poiFilter) {
        try {
            this.mapDelegate.addPoiFilter(poiFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) {
        try {
            return this.mapDelegate.addPolygon(polygonOptions);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        try {
            return this.mapDelegate.addPolyline(polylineOptions);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public RouteOverlay addRouteOverlay() {
        return this.mapDelegate.addNaviRouteOverlay();
    }

    public void addSignleClickInterceptorListener(SignleClickInterceptorListener signleClickInterceptorListener) {
        try {
            this.mapDelegate.addSignleClickInterceptorListener(signleClickInterceptorListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final Text addText(TextOptions textOptions) {
        try {
            return this.mapDelegate.addText(textOptions);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        try {
            return this.mapDelegate.addTileOverlay(tileOverlayOptions);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        try {
            this.mapDelegate.animateCamera(cameraUpdate);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public Pair<Float, LatLng> calculateZoomToSpanLevel(int i3, int i10, int i11, int i12, LatLng latLng, LatLng latLng2) {
        return this.mapDelegate.calculateZoomToSpanLevel(i3, i10, i11, i12, latLng, latLng2);
    }

    public final void clear() {
        try {
            this.mapDelegate.clear();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void clearPoiFilter() {
        try {
            this.mapDelegate.clearPoiFilter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.mapDelegate.getCameraPosition();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public String getCurrentStyle() {
        try {
            IAMap iAMap = this.mapDelegate;
            return iAMap != null ? iAMap.getCurrentWorldVectorMapStyle() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public final InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return this.mapDelegate.getInfoWindowAnimationManager();
    }

    public String getMapContentApprovalNumber() {
        try {
            return this.mapDelegate.getMapContentApprovalNumber();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public void getMapPrintScreen(onMapPrintScreenListener onmapprintscreenlistener) {
        this.mapDelegate.getMapPrintScreen(onmapprintscreenlistener);
    }

    public void getMapRegionSnapshot(LatLng latLng, LatLng latLng2, Size size, OnMapSnapshotListener onMapSnapshotListener) {
        IAMap iAMap = this.mapDelegate;
        if ((iAMap instanceof b0) && ((b0) iAMap).getMapConfig().isTerrainEnable()) {
            onMapSnapshotListener.onFinish();
            return;
        }
        c cVar = new c(latLng, latLng2, size);
        b bVar = new b(this, null);
        bVar.a(cVar.c());
        a aVar = new a(this, bVar, onMapSnapshotListener);
        animateCamera(cVar.a(), new d(this, new com.amap.api.maps.c(this, onMapSnapshotListener, cVar, aVar), aVar));
    }

    public final List<Marker> getMapScreenMarkers() {
        try {
            List<Marker> mapScreenMarkers = this.mapDelegate.getMapScreenMarkers();
            return mapScreenMarkers == null ? new ArrayList() : mapScreenMarkers;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public void getMapScreenShot(OnMapScreenShotListener onMapScreenShotListener) {
        this.mapDelegate.getMapScreenShot(onMapScreenShotListener, true);
    }

    public final int getMapTextZIndex() {
        try {
            return this.mapDelegate.getMapTextZIndex();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public final int getMapType() {
        try {
            return this.mapDelegate.getMapType();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 1;
        }
    }

    public final float getMaxZoomLevel() {
        return this.mapDelegate.getMaxZoomLevel();
    }

    public final float getMinZoomLevel() {
        return this.mapDelegate.getMinZoomLevel();
    }

    public final Location getMyLocation() {
        try {
            return this.mapDelegate.getMyLocation();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final MyLocationStyle getMyLocationStyle() {
        try {
            return this.mapDelegate.getMyLocationStyle();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public MyTrafficStyle getMyTrafficStyle() {
        return this.myTrafficStyle;
    }

    public long getNativeMapController() {
        try {
            return this.mapDelegate.getNativeMapController();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0L;
        }
    }

    public int getNativeMapEngineID() {
        try {
            return this.mapDelegate.getNativeEngineID();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public LatLngBounds getOverlayBoundRect(String str) {
        try {
            return this.mapDelegate.getOverlayBoundRect(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void getP20MapCenter(IPoint iPoint) {
        if (iPoint == null) {
            try {
                iPoint = new IPoint();
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        ((Point) iPoint).x = this.mapDelegate.getSX();
        ((Point) iPoint).y = this.mapDelegate.getSY();
    }

    public final Projection getProjection() {
        try {
            if (this.projection == null) {
                this.projection = this.mapDelegate.getAMapProjection();
            }
            return this.projection;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public float[] getProjectionMatrix() {
        return this.mapDelegate.getProjectionMatrix();
    }

    public String getSatelliteImageApprovalNumber() {
        try {
            return this.mapDelegate.getSatelliteImageApprovalNumber();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public float getScalePerPixel() {
        try {
            return this.mapDelegate.getScalePerPixel();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0.0f;
        }
    }

    public String getTerrainApprovalNumber() {
        try {
            return this.mapDelegate.getTerrainApprovalNumber();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.uiSettings == null) {
                this.uiSettings = this.mapDelegate.getAMapUiSettings();
            }
            return this.uiSettings;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public float[] getViewMatrix() {
        return this.mapDelegate.getViewMatrix();
    }

    public float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        return this.mapDelegate.getZoomToSpanLevel(latLng, latLng2);
    }

    public int hideBuildings(List<LatLng> list) {
        try {
            return this.mapDelegate.hideBuildings(list);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.mapDelegate.isMyLocationEnabled();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public boolean isTouchPoiEnable() {
        try {
            return this.mapDelegate.isTouchPoiEnable();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return true;
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.mapDelegate.isTrafficEnabled();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        try {
            this.mapDelegate.moveCamera(cameraUpdate);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void reloadMap() {
        this.mapDelegate.reloadMap();
    }

    public void removeAMapAppResourceListener(AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        try {
            this.mapDelegate.removeAMapAppResourceListener(aMapAppResourceRequestListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void removeOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        try {
            this.mapDelegate.removeOnCameraChangeListener(onCameraChangeListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void removeOnIndoorBuildingActiveListener(OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) {
        try {
            this.mapDelegate.removeOnIndoorBuildingActiveListener(onIndoorBuildingActiveListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void removeOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            this.mapDelegate.removeOnInfoWindowClickListener(onInfoWindowClickListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void removeOnMapClickListener(OnMapClickListener onMapClickListener) {
        try {
            this.mapDelegate.removeOnMapClickListener(onMapClickListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void removeOnMapLoadedListener(OnMapLoadedListener onMapLoadedListener) {
        try {
            this.mapDelegate.removeOnMapLoadedListener(onMapLoadedListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void removeOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        try {
            this.mapDelegate.removeOnMapLongClickListener(onMapLongClickListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void removeOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        try {
            this.mapDelegate.removeOnMapTouchListener(onMapTouchListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void removeOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        try {
            this.mapDelegate.removeOnMarkerClickListener(onMarkerClickListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void removeOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        try {
            this.mapDelegate.removeOnMarkerDragListener(onMarkerDragListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void removeOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            this.mapDelegate.removeOnMyLocationChangeListener(onMyLocationChangeListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void removeOnPOIClickListener(OnPOIClickListener onPOIClickListener) {
        try {
            this.mapDelegate.removeOnPOIClickListener(onPOIClickListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void removeOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        try {
            this.mapDelegate.removeOnPolylineClickListener(onPolylineClickListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void removePoiFilter(String str) {
        try {
            this.mapDelegate.removePoiFilter(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeSignleClickInterceptorListener(SignleClickInterceptorListener signleClickInterceptorListener) {
        try {
            this.mapDelegate.removeSignleClickInterceptorListener(signleClickInterceptorListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removecache() {
        try {
            this.mapDelegate.removecache();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void resetMinMaxZoomPreference() {
        this.mapDelegate.resetMinMaxZoomPreference();
    }

    public void runOnDrawFrame() {
        this.mapDelegate.setRunLowFrame(false);
    }

    public void setAMapGestureListener(AMapGestureListener aMapGestureListener) {
        this.mapDelegate.setAMapGestureListener(aMapGestureListener);
    }

    public final void setCommonInfoWindowAdapter(CommonInfoWindowAdapter commonInfoWindowAdapter) {
        try {
            this.mapDelegate.setInfoWindowAdapter(commonInfoWindowAdapter);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setConstructingRoadEnable(boolean z5) {
        try {
            this.mapDelegate.setConstructingRoadEnable(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setCurrentLocation(LatLng latLng) {
        try {
            this.mapDelegate.setCurrentLocation(latLng);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCustomMapStyle(CustomMapStyleOptions customMapStyleOptions) {
        this.mapDelegate.setCustomMapStyle(customMapStyleOptions);
    }

    public void setCustomMapStyleID(String str) {
        Log.e(Const.STR_PUBLIC_TAG, n1.a(R.string.O105492_280));
    }

    public void setCustomMapStylePath(String str) {
        Log.e(Const.STR_PUBLIC_TAG, n1.a(R.string.O105492_280));
    }

    public void setCustomRenderer(CustomRenderer customRenderer) {
        try {
            this.mapDelegate.setCustomRenderer(customRenderer);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setCustomScreenDensity(float f2) {
        try {
            this.mapDelegate.setCustomScreenDensity(f2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCustomTextureResourcePath(String str) {
        Log.e(Const.STR_PUBLIC_TAG, n1.a(R.string.O105492_280));
    }

    public void setIndoorBuildingInfo(IndoorBuildingInfo indoorBuildingInfo) {
        try {
            this.mapDelegate.setIndoorBuildingInfo(indoorBuildingInfo);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        try {
            this.mapDelegate.setInfoWindowAdapter(infoWindowAdapter);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setLoadOfflineData(boolean z5) {
        try {
            this.mapDelegate.setLoadOfflineData(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setLocationSource(LocationSource locationSource) {
        try {
            this.mapDelegate.setLocationSource(locationSource);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setMapCustomEnable(boolean z5) {
        Log.e(Const.STR_PUBLIC_TAG, n1.a(R.string.O105492_280));
    }

    public void setMapLanguage(String str) {
        try {
            this.mapDelegate.setMapLanguage(str);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setMapStatusLimits(LatLngBounds latLngBounds) {
        try {
            this.mapDelegate.setMapStatusLimits(latLngBounds);
            moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 0));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setMapTextZIndex(int i3) {
        try {
            this.mapDelegate.setMapTextZIndex(i3);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setMapType(int i3) {
        try {
            this.mapDelegate.setMapType(i3);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setMaskLayerParams(int i3, int i10, int i11, int i12, int i13, long j4) {
        this.mapDelegate.setMaskLayerParams(i3, i10, i11, i12, i13, j4);
    }

    public void setMaxZoomLevel(float f2) {
        this.mapDelegate.setMaxZoomLevel(f2);
    }

    public void setMinZoomLevel(float f2) {
        this.mapDelegate.setMinZoomLevel(f2);
    }

    public final void setMyLocationEnabled(boolean z5) {
        try {
            this.mapDelegate.setMyLocationEnabled(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setMyLocationRotateAngle(float f2) {
        try {
            this.mapDelegate.setMyLocationRotateAngle(f2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setMyLocationStyle(MyLocationStyle myLocationStyle) {
        try {
            this.mapDelegate.setMyLocationStyle(myLocationStyle);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setMyLocationType(int i3) {
        try {
            this.mapDelegate.setMyLocationType(i3);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setMyTrafficStyle(MyTrafficStyle myTrafficStyle) {
        try {
            this.myTrafficStyle = myTrafficStyle;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setNaviLabelEnable(boolean z5, int i3, int i10) {
        try {
            this.mapDelegate.setNaviLabelEnable(z5, i3, i10);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        try {
            this.mapDelegate.setOnCameraChangeListener(onCameraChangeListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setOnIndoorBuildingActiveListener(OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) {
        try {
            this.mapDelegate.setOnIndoorBuildingActiveListener(onIndoorBuildingActiveListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            this.mapDelegate.setOnInfoWindowClickListener(onInfoWindowClickListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        try {
            this.mapDelegate.setOnMapClickListener(onMapClickListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setOnMapLoadedListener(OnMapLoadedListener onMapLoadedListener) {
        try {
            this.mapDelegate.setOnMaploadedListener(onMapLoadedListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        try {
            this.mapDelegate.setOnMapLongClickListener(onMapLongClickListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        try {
            this.mapDelegate.setOnMapTouchListener(onMapTouchListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        try {
            this.mapDelegate.setOnMarkerClickListener(onMarkerClickListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        try {
            this.mapDelegate.setOnMarkerDragListener(onMarkerDragListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setOnMultiPointClickListener(OnMultiPointClickListener onMultiPointClickListener) {
        try {
            this.mapDelegate.setOnMultiPointClickListener(onMultiPointClickListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            this.mapDelegate.setOnMyLocationChangeListener(onMyLocationChangeListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setOnPOIClickListener(OnPOIClickListener onPOIClickListener) {
        try {
            this.mapDelegate.setOnPOIClickListener(onPOIClickListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        try {
            this.mapDelegate.setOnPolylineClickListener(onPolylineClickListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setOptRecordState(boolean z5) {
        try {
            this.mapDelegate.setMapOptRecordState(z5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPointToCenter(int i3, int i10) {
        try {
            this.mapDelegate.setCenterToPixel(i3, i10);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setRenderFps(int i3) {
        this.mapDelegate.setRenderFps(i3);
    }

    public void setRenderMode(int i3) {
        this.mapDelegate.setRenderMode(i3);
    }

    public void setRoadArrowEnable(boolean z5) {
        try {
            this.mapDelegate.setRoadArrowEnable(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setTouchPoiEnable(boolean z5) {
        try {
            this.mapDelegate.setTouchPoiEnable(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setTrafficEnabled(boolean z5) {
        try {
            this.mapDelegate.setTrafficEnabled(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setTrafficStyleWithTexture(byte[] bArr, MyTrafficStyle myTrafficStyle) {
        if (bArr == null || myTrafficStyle == null) {
            return;
        }
        try {
            this.mapDelegate.setTrafficStyleWithTexture(bArr, myTrafficStyle);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setTrafficStyleWithTextureData(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        try {
            this.mapDelegate.setTrafficStyleWithTextureData(bArr);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setUseForNavi(boolean z5) {
        try {
            this.mapDelegate.setUseForNavi(z5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setWorldVectorMapStyle(String str) {
        try {
            this.mapDelegate.setWorldVectorMapStyle(str);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void showBuildings(boolean z5) {
        try {
            this.mapDelegate.set3DBuildingEnabled(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void showHideBuildings(int i3) {
        try {
            this.mapDelegate.showHideBuildings(i3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showIndoorMap(boolean z5) {
        try {
            this.mapDelegate.setIndoorEnabled(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void showMapText(boolean z5) {
        try {
            this.mapDelegate.setMapTextEnable(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void stopAnimation() {
        try {
            this.mapDelegate.stopAnimation();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void getMapScreenShot(OnMapScreenShotListener onMapScreenShotListener, Handler handler) {
        this.mapDelegate.getMapScreenShot(onMapScreenShotListener, true, handler);
    }

    public void setCustomMapStyle(CustomMapStyleOptions customMapStyleOptions, OnCustomMapStyleListener onCustomMapStyleListener) {
        this.mapDelegate.setCustomMapStyle(customMapStyleOptions, onCustomMapStyleListener);
    }

    public final void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        try {
            this.mapDelegate.animateCameraWithCallback(cameraUpdate, cancelableCallback);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void clear(boolean z5) {
        try {
            this.mapDelegate.clear(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void removecache(OnCacheRemoveListener onCacheRemoveListener) {
        try {
            this.mapDelegate.removecache(onCacheRemoveListener);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public class c {

        /* renamed from: a, reason: collision with root package name */
        private SizeF f5692a;

        /* renamed from: b, reason: collision with root package name */
        private RectF f5693b;

        /* renamed from: c, reason: collision with root package name */
        private double f5694c;

        /* renamed from: f, reason: collision with root package name */
        private IPoint f5696f;

        /* renamed from: g, reason: collision with root package name */
        private int f5697g;

        /* renamed from: h, reason: collision with root package name */
        private int f5698h;

        /* renamed from: d, reason: collision with root package name */
        private IPoint f5695d = new IPoint();
        private IPoint e = new IPoint();

        /* renamed from: i, reason: collision with root package name */
        private int f5699i = 0;

        public c(LatLng latLng, LatLng latLng2, Size size) {
            this.f5697g = 0;
            this.f5698h = 0;
            this.f5692a = new SizeF(size.getWidth(), size.getHeight());
            GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, this.f5695d);
            GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, this.e);
            this.f5696f = a(0.0d, this.f5692a.getHeight());
            this.f5697g = ((int) this.f5692a.getWidth()) / 4096;
            if (this.f5692a.getWidth() % 4096.0f > 0.0f) {
                this.f5697g++;
            }
            this.f5698h = ((int) this.f5692a.getHeight()) / 4096;
            if (this.f5692a.getHeight() % 4096.0f > 0.0f) {
                this.f5698h++;
            }
            this.f5693b = new RectF(0.0f, 0.0f, this.f5692a.getWidth() / this.f5697g, this.f5692a.getHeight() / this.f5698h);
            int i3 = ((Point) this.e).y;
            IPoint iPoint = this.f5695d;
            this.f5694c = Math.atan((i3 - ((Point) iPoint).y) / (((Point) r3).x - ((Point) iPoint).x));
        }

        private IPoint a(double d5, double d8) {
            double sin = Math.sin(this.f5694c);
            double cos = Math.cos(this.f5694c);
            double distance = this.f5695d.distance(this.e) / this.f5692a.getWidth();
            double d10 = ((d5 * cos) - (d8 * sin)) * distance;
            IPoint iPoint = this.f5695d;
            return new IPoint((int) (d10 + ((Point) iPoint).x), (int) ((((d5 * sin) + (cos * d8)) * distance) + ((Point) iPoint).y));
        }

        public Rect b() {
            RectF rectF = this.f5693b;
            return new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        }

        public Size c() {
            return new Size((int) this.f5693b.width(), (int) this.f5693b.height());
        }

        public boolean d() {
            return this.f5699i == (this.f5697g * this.f5698h) - 1;
        }

        public boolean e() {
            RectF rectF = this.f5693b;
            if (rectF.width() + rectF.right <= this.f5692a.getWidth()) {
                RectF rectF2 = this.f5693b;
                rectF2.offset(rectF2.width(), 0.0f);
            } else {
                RectF rectF3 = this.f5693b;
                if (rectF3.height() + rectF3.bottom > this.f5692a.getHeight()) {
                    return false;
                }
                RectF rectF4 = this.f5693b;
                rectF4.offset(-rectF4.left, rectF4.height());
            }
            this.f5699i++;
            return true;
        }

        public CameraUpdate a() {
            int i3 = this.f5699i;
            if (i3 == 0) {
                IPoint a3 = a(this.f5693b.centerX(), this.f5693b.centerY());
                DPoint dPoint = new DPoint();
                GLMapState.geo2LonLat(((Point) a3).x, ((Point) a3).y, dPoint);
                LatLng latLng = new LatLng(dPoint.f6571y, dPoint.f6570x);
                long distance = ((long) this.f5695d.distance(this.e)) / this.f5697g;
                DPoint dPoint2 = new DPoint();
                GLMapState.geo2LonLat(0L, distance, dPoint2);
                LatLng latLng2 = new LatLng(dPoint2.f6571y, dPoint2.f6570x);
                long distance2 = ((long) this.f5696f.distance(this.f5695d)) / this.f5698h;
                DPoint dPoint3 = new DPoint();
                GLMapState.geo2LonLat(distance2, 0L, dPoint3);
                return CameraUpdateFactory.newCameraPosition(new CameraPosition(latLng, AMap.this.getZoomToSpanLevel(latLng2, new LatLng(dPoint3.f6571y, dPoint3.f6570x)), 0.0f, (float) ((this.f5694c * 180.0d) / 3.141592653589793d)));
            }
            int i10 = this.f5697g;
            if ((i3 - 1) / i10 < i3 / i10) {
                return CameraUpdateFactory.scrollBy((-this.f5693b.width()) * (this.f5697g - 1), this.f5693b.height());
            }
            return CameraUpdateFactory.scrollBy(this.f5693b.width(), 0.0f);
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate, long j4, CancelableCallback cancelableCallback) {
        if (j4 <= 0) {
            try {
                Log.w(CLASSNAME, "durationMs must be positive");
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        this.mapDelegate.animateCameraWithDurationAndCallback(cameraUpdate, j4, cancelableCallback);
    }
}
