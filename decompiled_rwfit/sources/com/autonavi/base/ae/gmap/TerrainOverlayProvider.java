package com.autonavi.base.ae.gmap;

import android.content.Context;
import android.support.v4.media.session.e;
import com.amap.api.col.p0003sl.g1;
import com.amap.api.col.p0003sl.g9;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.TileOverlaySource;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TerrainOverlayProvider {
    private static final int TERRAIN_OVERLAY_SOURCE_BASE_ID = 1;
    private static final int TERRAIN_OVERLAY_SOURCE_HIGH_ID = 0;
    private TileProviderInner tileProviderInner;

    public TerrainOverlayProvider(IGlOverlayLayer iGlOverlayLayer, Context context) {
        TileOverlaySource tileOverlaySource = new TileOverlaySource(0, TileOverlaySource.TILESOURCE_TYPE_IMAGE_DEM, e.l("http://" + g9.b(context).a(41), "/rest/lbs/dem/data?z=%d&x=%d&y=%d&type=2"));
        tileOverlaySource.setMinZoom(3);
        tileOverlaySource.setMaxZoom(10);
        tileOverlaySource.setCacheEnabled(true);
        int i3 = TileOverlaySource.TILESOURCE_TYPE_FBO_TEXTURE;
        TileOverlaySource tileOverlaySource2 = new TileOverlaySource(1, i3, "http://mst01.is.autonavi.com/appmaptile?z=%d&x=%d&y=%d&lang=zh_cn&size=1&scale=1&style=6");
        tileOverlaySource2.setCacheEnabled(i3 != TileOverlaySource.TILESOURCE_TYPE_FBO_TEXTURE);
        ArrayList arrayList = new ArrayList();
        arrayList.add(tileOverlaySource);
        arrayList.add(tileOverlaySource2);
        TileProviderInner tileProviderInner = new TileProviderInner(new g1(tileOverlaySource, tileOverlaySource2));
        this.tileProviderInner = tileProviderInner;
        tileProviderInner.init(iGlOverlayLayer, "TerrainTileOverlay");
        this.tileProviderInner.setTileSource(arrayList);
    }

    public BitmapDescriptor getDefaultTerrain() {
        return BitmapDescriptorFactory.fromAsset("terrainDefault.png");
    }

    public List<BitmapDescriptor> getSkyBoxImages() {
        String[] strArr = {"map_custom/skybox/right.png", "map_custom/skybox/left.png", "map_custom/skybox/front.png", "map_custom/skybox/back.png", "map_custom/skybox/top.png", "map_custom/skybox/bottom.png"};
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 6; i3++) {
            arrayList.add(BitmapDescriptorFactory.fromAsset(strArr[i3]));
        }
        return arrayList;
    }

    public TileProviderInner getTileProvider() {
        return this.tileProviderInner;
    }
}
