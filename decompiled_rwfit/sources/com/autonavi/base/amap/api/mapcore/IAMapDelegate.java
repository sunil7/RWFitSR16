package com.autonavi.base.amap.api.mapcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.location.Location;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.col.p0003sl.a0;
import com.amap.api.col.p0003sl.w1;
import com.amap.api.maps.AMap;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.extra.b;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
public interface IAMapDelegate extends IAMap {
    void addGestureMapMessage(int i3, AbstractGestureMapMessage abstractGestureMapMessage);

    void addOverlayTexture(int i3, GLTextureProperty gLTextureProperty);

    void animateCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException;

    void animateCameraWithDurationAndCallback(AbstractCameraUpdateMessage abstractCameraUpdateMessage, long j4, AMap.CancelableCallback cancelableCallback);

    boolean canShowIndoorSwitch();

    void changeGLOverlayIndex();

    void changeLogoIconStyle(String str, boolean z5, int i3);

    void changeMapLogo(int i3, boolean z5);

    void changeSize(int i3, int i10);

    void changeSurface(int i3, GL10 gl10, int i10, int i11);

    float checkZoomLevel(float f2) throws RemoteException;

    void clearTileCache();

    String createId(String str);

    int createOverlayTexture(int i3, Bitmap bitmap);

    void createSurface(int i3, GL10 gl10, EGLConfig eGLConfig);

    void geo2Latlng(int i3, int i10, DPoint dPoint);

    void geo2Map(int i3, int i10, FPoint fPoint);

    b getAMapExtraInterfaceManager();

    float getCameraDegree(int i3);

    CameraPosition getCameraPositionPrj(boolean z5);

    Context getContext();

    a0 getCustomStyleManager();

    int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo);

    float[] getFinalMatrix();

    GLMapEngine getGLMapEngine();

    View getGLMapView();

    void getGeoCenter(int i3, IPoint iPoint);

    IGlOverlayLayer getGlOverlayLayer();

    w1 getInfoWindowDelegate();

    void getLatLng2Map(double d5, double d8, FPoint fPoint);

    void getLatLng2Pixel(double d5, double d8, IPoint iPoint);

    float getLogoMarginRate(int i3);

    int getLogoPosition();

    float getMapAngle(int i3);

    LatLngBounds getMapBounds(LatLng latLng, float f2, float f10, float f11);

    MapConfig getMapConfig();

    GLMapState getMapProjection();

    float getMapZoomScale();

    int getMaskLayerType();

    AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException;

    void getPixel2Geo(int i3, int i10, IPoint iPoint);

    void getPixel2LatLng(int i3, int i10, DPoint dPoint);

    float getPreciseLevel(int i3);

    IProjectionDelegate getProjection() throws RemoteException;

    Rect getRect();

    IUiSettingsDelegate getUiSettings();

    float getUnitLengthByZoom(int i3);

    Point getWaterMarkerPositon();

    float getZoomLevel();

    void hideInfoWindow();

    boolean isLockMapAngle(int i3);

    boolean isLockMapCameraDegree(int i3);

    boolean isOverseaAuthed();

    boolean isUseAnchor();

    boolean isUseGLTF();

    boolean isUseMVT();

    void latlon2Geo(double d5, double d8, IPoint iPoint);

    void map2Geo(float f2, float f10, IPoint iPoint);

    void moveCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException;

    void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam);

    boolean onDoubleTap(int i3, MotionEvent motionEvent);

    void onLongPress(int i3, MotionEvent motionEvent);

    void onPause();

    void onResume();

    boolean onSingleTapConfirmed(int i3, MotionEvent motionEvent);

    void pixel2Map(int i3, int i10, PointF pointF);

    void post(Runnable runnable);

    void redrawInfoWindow();

    void redrawNativeOverlays();

    void refreshLogo();

    void reloadMapCustomStyle();

    void removeEngineGLOverlay(BaseMapOverlay baseMapOverlay);

    boolean removeGLModel(String str);

    void removeGLOverlay(String str) throws RemoteException;

    void resetRenderTimeLongLong();

    void setCustomMapStyle(boolean z5, byte[] bArr);

    void setGestureStatus(int i3, int i10);

    void setHideLogoEnble(boolean z5);

    void setLanguageAuth(boolean z5);

    void setLogoBottomMargin(int i3);

    void setLogoLeftMargin(int i3);

    void setLogoMarginRate(int i3, float f2);

    void setLogoPosition(int i3);

    void setMapCustomEnable(boolean z5, boolean z6);

    void setMapEnable(boolean z5);

    void setMapWidgetListener(AMapWidgetListener aMapWidgetListener);

    void setOverseaAuth(boolean z5);

    void setTerrainAuth(boolean z5);

    void setZoomPosition(int i3);

    void showCompassEnabled(boolean z5);

    void showIndoorSwitchControlsEnabled(boolean z5);

    void showInfoWindow(BaseOverlay baseOverlay) throws RemoteException;

    void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException;

    void showLogoEnabled(boolean z5);

    void showMyLocationButtonEnabled(boolean z5);

    void showMyLocationOverlay(Location location) throws RemoteException;

    void showScaleEnabled(boolean z5);

    void showZoomControlsEnabled(boolean z5);

    float toMapLenWithWin(int i3);

    void zoomOut(int i3);
}
