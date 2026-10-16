package com.amap.api.col.p0003sl;

import android.support.v4.media.session.e;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;

/* loaded from: classes.dex */
public class d4 implements TileProvider {

    /* renamed from: a, reason: collision with root package name */
    private MapConfig f3886a;

    public class a extends e4 {

        /* renamed from: m, reason: collision with root package name */
        private int f3887m;

        /* renamed from: n, reason: collision with root package name */
        private int f3888n;

        /* renamed from: o, reason: collision with root package name */
        private int f3889o;

        /* renamed from: p, reason: collision with root package name */
        private String f3890p;

        /* renamed from: q, reason: collision with root package name */
        private String f3891q;
        Random r = new Random();

        public a(d4 d4Var, int i3, int i10, int i11, String str) {
            this.f3891q = "";
            this.f3887m = i3;
            this.f3888n = i10;
            this.f3889o = i11;
            this.f3890p = str;
            this.f3891q = c();
        }

        private String c() {
            if (!r4.a(this.f3887m, this.f3888n, this.f3889o) && this.f3889o >= 6) {
                if (!MapsInitializer.isLoadWorldGridMap()) {
                    return null;
                }
                return e.l("http://" + g9.b(a1.f3562f).a(41), "/v4/gridmap?");
            }
            int nextInt = this.r.nextInt(100000) % 4;
            return String.format(Locale.US, "http://" + g9.b(a1.f3562f).a(22) + "/appmaptile?", Integer.valueOf(nextInt + 1));
        }

        @Override // com.amap.api.col.p0003sl.pb
        public String getURL() {
            StringBuffer stringBuffer = new StringBuffer("key=");
            stringBuffer.append(b9.e(a1.f3562f));
            stringBuffer.append("&channel=amapapi");
            if (r4.a(this.f3887m, this.f3888n, this.f3889o) || this.f3889o < 6) {
                stringBuffer.append("&z=");
                stringBuffer.append(this.f3889o);
                stringBuffer.append("&x=");
                stringBuffer.append(this.f3887m);
                stringBuffer.append("&y=");
                stringBuffer.append(this.f3888n);
                stringBuffer.append("&lang=en&size=1&scale=1&style=7");
            } else if (MapsInitializer.isLoadWorldGridMap()) {
                stringBuffer.append("&x=");
                stringBuffer.append(this.f3887m);
                stringBuffer.append("&y=");
                stringBuffer.append(this.f3888n);
                stringBuffer.append("&z=");
                stringBuffer.append(this.f3889o);
                stringBuffer.append("&ds=0&dpitype=webrd&lang=");
                stringBuffer.append(this.f3890p);
                stringBuffer.append("&scale=2");
            }
            return this.f3891q + appendTsScode(stringBuffer.toString());
        }
    }

    public d4(int i3, int i10, MapConfig mapConfig, boolean z5) {
        this.f3886a = mapConfig;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public final Tile getTile(int i3, int i10, int i11) {
        byte[] bArr;
        try {
            if (this.f3886a.getMapLanguage().equals("zh_cn")) {
                if (!MapsInitializer.isLoadWorldGridMap()) {
                    return TileProvider.NO_TILE;
                }
                if (i11 < 6 || r4.a(i3, i10, i11)) {
                    return TileProvider.NO_TILE;
                }
            } else if (!MapsInitializer.isLoadWorldGridMap() && i11 >= 6 && !r4.a(i3, i10, i11)) {
                return TileProvider.NO_TILE;
            }
            MapConfig mapConfig = this.f3886a;
            try {
                bArr = new a(this, i3, i10, i11, mapConfig != null ? mapConfig.getMapLanguage() : "zh_cn").makeHttpRequestWithInterrupted();
            } catch (Throwable unused) {
                bArr = null;
            }
            return bArr == null ? TileProvider.NO_TILE : Tile.obtain(256, 256, bArr);
        } catch (IOException unused2) {
            return TileProvider.NO_TILE;
        }
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileHeight() {
        return 256;
    }

    @Override // com.amap.api.maps.model.TileProvider
    public int getTileWidth() {
        return 256;
    }
}
