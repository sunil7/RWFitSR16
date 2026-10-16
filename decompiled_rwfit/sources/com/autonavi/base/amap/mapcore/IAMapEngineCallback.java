package com.autonavi.base.amap.mapcore;

import com.amap.api.maps.model.BitmapDescriptor;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.MapPoi;
import com.autonavi.base.ae.gmap.bean.InitStorageParam;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import java.util.List;

/* loaded from: classes.dex */
public interface IAMapEngineCallback {
    void OnIndoorBuildingActivity(int i3, byte[] bArr);

    void cancelRequireMapData(Object obj);

    int generateRequestId();

    BitmapDescriptor getDefaultTerrainImage();

    List<BitmapDescriptor> getSkyBoxImages();

    InitStorageParam getStorageInitParam();

    TileProviderInner getTerrainTileProvider();

    void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam);

    void onMapBlandClick(double d5, double d8);

    void onMapPOIClick(MapPoi mapPoi);

    void onMapRender(int i3, int i10);

    void reloadMapResource(int i3, String str, int i10);

    byte[] requireCharBitmap(int i3, int i10, int i11);

    byte[] requireCharsWidths(int i3, int[] iArr, int i10, int i11);

    void requireMapRender(int i3, int i10, int i11);

    byte[] requireMapResource(int i3, String str);
}
