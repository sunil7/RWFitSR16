package com.amap.api.maps.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* loaded from: classes.dex */
public abstract class UrlTileProvider implements TileProvider {
    private final int height;
    private final int width;

    public UrlTileProvider(int i3, int i10) {
        this.width = i3;
        this.height = i10;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i3, int i10, int i11) {
        URL tileUrl = getTileUrl(i3, i10, i11);
        if (tileUrl == null) {
            return TileProvider.NO_TILE;
        }
        try {
            int i12 = this.width;
            int i13 = this.height;
            InputStream openStream = tileUrl.openStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            while (true) {
                int read = openStream.read(bArr);
                if (read == -1) {
                    return Tile.obtain(i12, i13, byteArrayOutputStream.toByteArray());
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            Tile tile = TileProvider.NO_TILE;
            e.printStackTrace();
            return tile;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return this.height;
    }

    public abstract URL getTileUrl(int i3, int i10, int i11);

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return this.width;
    }
}
