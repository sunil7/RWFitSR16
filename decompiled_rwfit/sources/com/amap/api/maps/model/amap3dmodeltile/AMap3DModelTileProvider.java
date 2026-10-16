package com.amap.api.maps.model.amap3dmodeltile;

import com.amap.api.col.p0003sl.a1;
import com.amap.api.col.p0003sl.b9;
import com.amap.api.col.p0003sl.e4;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import r5.a;

/* loaded from: classes.dex */
public final class AMap3DModelTileProvider implements TileProvider {
    private static final String DEFAULT_URL = "https://lbs-3dtiles-service.amap.com/basemap/tiles/staging?compose=building@1669011850923&compose=tree@1668678765481&z=%d&x=%d&y=%d";
    private int tileSize = 256;
    private String url;

    public static class AMap3DModelRequest extends e4 {
        private String baseQueryStr;
        private String baseUrl;

        public AMap3DModelRequest(String str) {
            this.baseUrl = "";
            this.baseQueryStr = "";
            this.isPostFlag = false;
            if (!str.contains("?")) {
                this.baseUrl = str.concat("?");
                return;
            }
            String[] split = str.split("\\?");
            if (split.length > 1) {
                this.baseUrl = a.f(new StringBuilder(), split[0], "?");
                this.baseQueryStr = split[1];
            }
        }

        @Override // com.amap.api.col.p0003sl.pb
        public String getURL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.baseQueryStr);
            stringBuffer.append("&key=");
            stringBuffer.append(b9.e(a1.f3562f));
            return this.baseUrl + appendTsScode(stringBuffer.toString());
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public Tile getTile(int i3, int i10, int i11) {
        byte[] bArr;
        String str = this.url;
        if (str == null) {
            str = DEFAULT_URL;
        }
        try {
            bArr = new AMap3DModelRequest(String.format(str, Integer.valueOf(i11), Integer.valueOf(i3), Integer.valueOf(i10))).makeHttpRequestWithInterrupted();
        } catch (Exception e) {
            e.printStackTrace();
            bArr = null;
        }
        if (bArr == null) {
            return TileProvider.NO_TILE;
        }
        int i12 = this.tileSize;
        return new Tile(i12, i12, bArr, false);
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return this.tileSize;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return this.tileSize;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
