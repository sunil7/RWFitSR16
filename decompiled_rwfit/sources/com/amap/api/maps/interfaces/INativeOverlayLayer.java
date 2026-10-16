package com.amap.api.maps.interfaces;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.base.amap.mapcore.FPoint;
import java.util.List;

/* loaded from: classes.dex */
public interface INativeOverlayLayer {
    void addNativeOverlay(Marker marker, MarkerOptions markerOptions);

    boolean checkInBounds(String str);

    void clear();

    BaseOverlay getHitOverlay(DPoint dPoint, int i3);

    List<Marker> getMapScreenMarkers();

    void getMarkerInfoWindowOffset(String str, FPoint fPoint);

    Rect getOverlayBoundRect(String str);

    void getOverlayScreenPos(String str, FPoint fPoint);

    void hideInfoWindow(String str);

    boolean isInfoWindowShown(String str);

    void redrawOverlays();

    void removeNativeOverlay(String str);

    void screenShotOverlays(Canvas canvas);

    void set2Top(String str);

    void showInfoWindow(String str);

    void updateOverlayOption(String str, MarkerOptions markerOptions);

    void updateOverlaysPosition();
}
