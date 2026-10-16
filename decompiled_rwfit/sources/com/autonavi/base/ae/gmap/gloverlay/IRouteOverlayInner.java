package com.autonavi.base.ae.gmap.gloverlay;

import android.util.Pair;
import com.amap.api.col.p0003sl.q5;
import com.amap.api.col.p0003sl.r5;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.RouteOverlay;
import java.util.Map;

/* loaded from: classes.dex */
public interface IRouteOverlayInner {
    void addRouteItem(int i3, r5[] r5VarArr, int i10, q5 q5Var, int[] iArr);

    void addRouteName();

    Pair<Float, Float> getDisplayRange();

    int getOverlayProperty();

    boolean isVisible();

    void remove();

    void removeRouteName();

    void setArrow3DTexture(BitmapDescriptor bitmapDescriptor);

    void setArrowFlow(boolean z5);

    void setCar2DPosition(int i3, float f2);

    void setCar3DPosition(int i3, float f2);

    void setDisplayRange(float f2, float f10);

    void setHighlightParam(RouteOverlay.RouteOverlayHighLightParam routeOverlayHighLightParam);

    void setHighlightType(int i3);

    void setLine2DWidth(int i3, int i10);

    void setLineWidthScale(float f2);

    void setOverlayProperty(int i3);

    void setRouteItemParam(r5 r5Var);

    void setSelectStatus(boolean z5);

    void setShowArrow(boolean z5);

    void setShowNaviRouteNameCountMap(Map<Integer, Integer> map);

    void setVisible(boolean z5);
}
