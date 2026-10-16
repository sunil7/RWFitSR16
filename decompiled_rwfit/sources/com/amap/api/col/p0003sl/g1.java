package com.amap.api.col.p0003sl;

import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileOverlaySource;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.ae.gmap.bean.TileSourceProvider;
import com.autonavi.base.ae.gmap.bean.TileSourceReq;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public class g1 implements TileSourceProvider {

    /* renamed from: a, reason: collision with root package name */
    private final TileOverlaySource f4164a;

    /* renamed from: b, reason: collision with root package name */
    private final TileOverlaySource f4165b;

    public class a extends e4 {

        /* renamed from: m, reason: collision with root package name */
        private String f4166m;

        /* renamed from: n, reason: collision with root package name */
        private String f4167n;

        public a(g1 g1Var, int i3, int i10, int i11, String str) {
            this.f4166m = "";
            this.f4167n = "";
            String format = String.format(str, Integer.valueOf(i11), Integer.valueOf(i3), Integer.valueOf(i10));
            if (!format.contains("?")) {
                this.f4166m = format.concat("?");
                return;
            }
            String[] split = format.split("\\?");
            if (split.length > 1) {
                this.f4166m = r5.a.f(new StringBuilder(), split[0], "?");
                this.f4167n = split[1];
            }
        }

        @Override // com.amap.api.col.p0003sl.e4, com.amap.api.col.p0003sl.pb
        public Map<String, String> getRequestHead() {
            return super.getRequestHead();
        }

        @Override // com.amap.api.col.p0003sl.pb
        public String getURL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f4167n);
            stringBuffer.append("&key=");
            stringBuffer.append(b9.e(a1.f3562f));
            stringBuffer.append("&channel=amapapi");
            return this.f4166m + appendTsScode(stringBuffer.toString());
        }
    }

    public g1(TileOverlaySource tileOverlaySource, TileOverlaySource tileOverlaySource2) {
        this.f4164a = tileOverlaySource;
        this.f4165b = tileOverlaySource2;
    }

    private Tile a(TileSourceReq tileSourceReq) {
        String str = MapsInitializer.TERRAIN_LOCAL_DEM_SOURCE_PATH;
        try {
            int i3 = tileSourceReq.f6843x;
            if (i3 > 0) {
                i3 /= 10;
            }
            int i10 = tileSourceReq.f6844y;
            if (i10 > 0) {
                i10 /= 10;
            }
            FileInputStream fileInputStream = new FileInputStream(new File(str + tileSourceReq.zoom + "/" + i3 + "/" + i10 + "/" + tileSourceReq.f6843x + "_" + tileSourceReq.f6844y + ".png"));
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            Tile tile = new Tile(256, 256, bArr, true);
            fileInputStream.close();
            return tile;
        } catch (FileNotFoundException unused) {
            int i11 = tileSourceReq.f6843x;
            int i12 = tileSourceReq.zoom - 6;
            int i13 = i11 >> i12;
            int i14 = tileSourceReq.f6844y >> i12;
            if (i13 >= 51 && i13 <= 53 && i14 >= 28 && i14 <= 31) {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(new File(str + "default.png"));
                    byte[] bArr2 = new byte[fileInputStream2.available()];
                    fileInputStream2.read(bArr2);
                    Tile tile2 = new Tile(256, 256, bArr2, true);
                    fileInputStream2.close();
                    return tile2;
                } catch (Exception e) {
                    e.printStackTrace();
                    return TileProvider.NO_TILE;
                }
            }
            return TileProvider.NO_TILE;
        } catch (IOException unused2) {
            return TileProvider.NO_TILE;
        }
    }

    @Override // com.autonavi.base.ae.gmap.bean.TileSourceProvider
    public void cancel(TileSourceReq tileSourceReq) {
    }

    @Override // com.amap.api.maps.model.TileProvider
    public Tile getTile(int i3, int i10, int i11) {
        return null;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return 256;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return 256;
    }

    @Override // com.autonavi.base.ae.gmap.bean.TileSourceProvider
    public Tile getTile(TileSourceReq tileSourceReq) {
        byte[] bArr;
        if (tileSourceReq == null) {
            return TileProvider.NO_TILE;
        }
        Tile tile = TileProvider.NO_TILE;
        try {
            String url = tileSourceReq.sourceType == this.f4165b.getId() ? this.f4165b.getUrl() : this.f4164a.getUrl();
            if (url == null) {
                return tile;
            }
            Tile a3 = MapsInitializer.TERRAIN_LOCAL_DEM_SOURCE_PATH != null ? a(tileSourceReq) : tile;
            if (a3 != tile) {
                return a3;
            }
            try {
                bArr = new a(this, tileSourceReq.f6843x, tileSourceReq.f6844y, tileSourceReq.zoom, url).makeHttpRequestWithInterrupted();
            } catch (Throwable th2) {
                th2.printStackTrace();
                bArr = null;
            }
            return new Tile(256, 256, bArr, true);
        } catch (Exception e) {
            Tile tile2 = TileProvider.NO_TILE;
            e.printStackTrace();
            return tile2;
        }
    }
}
