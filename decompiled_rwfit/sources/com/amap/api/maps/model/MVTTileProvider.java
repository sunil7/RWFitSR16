package com.amap.api.maps.model;

import com.amap.api.col.p0003sl.e4;

/* loaded from: classes.dex */
public final class MVTTileProvider implements TileProvider {

    /* renamed from: id, reason: collision with root package name */
    private String f5735id;
    private String key;
    private int tileSize = 256;
    private String url;

    public class a extends e4 {

        /* renamed from: m, reason: collision with root package name */
        String f5736m;

        public a(MVTTileProvider mVTTileProvider, String str) {
            this.isPostFlag = false;
            this.f5736m = str;
        }

        @Override // com.amap.api.col.p0003sl.pb
        public String getURL() {
            return this.f5736m;
        }
    }

    public MVTTileProvider(String str, String str2, String str3) {
        this.url = str;
        this.key = str2;
        this.f5735id = str3;
    }

    public String getId() {
        return this.f5735id;
    }

    public String getKey() {
        return this.key;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public Tile getTile(int i3, int i10, int i11) {
        byte[] bArr;
        try {
            bArr = new a(this, String.format(this.url + "?z=%d&x=%d&y=%d&size=%d&key=" + this.key + "&id=" + this.f5735id, Integer.valueOf(i11), Integer.valueOf(i3), Integer.valueOf(i10), Integer.valueOf(this.tileSize))).makeHttpRequestWithInterrupted();
        } catch (Exception unused) {
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
}
