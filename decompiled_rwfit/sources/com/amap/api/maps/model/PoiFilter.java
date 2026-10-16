package com.amap.api.maps.model;

import android.graphics.Point;
import com.amap.api.maps.AMap;
import com.amap.api.maps.Projection;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

@JBindingInclude
/* loaded from: classes.dex */
public class PoiFilter {

    @JBindingExclude
    public static final int FilterTypeAll = -1;

    @JBindingExclude
    public static final int FilterTypeLabel3rd = 8;

    @JBindingExclude
    public static final int FilterTypePoi = 1;

    @JBindingExclude
    public static final int FilterTypeRoadName = 2;

    @JBindingExclude
    public static final int FilterTypeRoadShield = 4;
    public int mFilterType;
    public String mKeyName;
    public List<LatLng> mPosition = new ArrayList();

    public static PoiFilter createPoiFilterByCenter(AMap aMap, LatLng latLng, int i3, String str, int i10, int i11) {
        Projection projection;
        if (aMap == null || (projection = aMap.getProjection()) == null) {
            return null;
        }
        PoiFilter poiFilter = new PoiFilter();
        poiFilter.mFilterType = i3;
        poiFilter.mKeyName = str;
        Point screenLocation = aMap.getProjection().toScreenLocation(latLng);
        Point point = new Point();
        int i12 = i10 / 2;
        point.x = screenLocation.x - i12;
        int i13 = i11 / 2;
        point.y = screenLocation.y - i13;
        Point point2 = new Point();
        point2.x = screenLocation.x + i12;
        point2.y = screenLocation.y - i13;
        Point point3 = new Point();
        point3.x = screenLocation.x - i12;
        point3.y = screenLocation.y + i13;
        Point point4 = new Point();
        point4.x = screenLocation.x + i12;
        point4.y = screenLocation.y + i13;
        poiFilter.mPosition.add(projection.fromScreenLocation(point));
        poiFilter.mPosition.add(projection.fromScreenLocation(point2));
        poiFilter.mPosition.add(projection.fromScreenLocation(point4));
        poiFilter.mPosition.add(projection.fromScreenLocation(point3));
        return poiFilter;
    }
}
