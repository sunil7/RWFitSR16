package com.amap.api.col.p0003sl;

import android.os.RemoteException;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* loaded from: classes.dex */
public class n3 {

    /* renamed from: a, reason: collision with root package name */
    private final IAMapDelegate f4688a;

    /* renamed from: b, reason: collision with root package name */
    private TileOverlay f4689b;

    /* renamed from: c, reason: collision with root package name */
    private TileOverlay f4690c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4691d = false;
    private boolean e = false;

    public n3(IAMapDelegate iAMapDelegate) {
        this.f4688a = iAMapDelegate;
    }

    private void b() {
        if (this.f4689b == null) {
            TileOverlayOptions tileProvider = new TileOverlayOptions().tileProvider(new d4(256, 256, this.f4688a.getMapConfig(), false));
            tileProvider.memCacheSize(10485760);
            tileProvider.diskCacheSize(20480);
            tileProvider.visible(this.f4691d);
            try {
                this.f4689b = this.f4688a.addTileOverlay(tileProvider);
                this.f4690c = this.f4688a.addTileOverlay(tileProvider);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void a() {
        IAMapDelegate iAMapDelegate = this.f4688a;
        boolean equals = iAMapDelegate == null ? false : iAMapDelegate.getMapConfig().getMapLanguage().equals("en");
        if (equals) {
            b();
        }
        if (this.f4691d != equals) {
            this.f4691d = equals;
            TileOverlay tileOverlay = this.f4689b;
            if (tileOverlay != null) {
                tileOverlay.setVisible(equals);
            }
        }
        boolean isLoadWorldGridMap = MapsInitializer.isLoadWorldGridMap();
        if (isLoadWorldGridMap) {
            b();
        }
        if (this.e != isLoadWorldGridMap) {
            this.e = isLoadWorldGridMap;
            TileOverlay tileOverlay2 = this.f4690c;
            if (tileOverlay2 != null) {
                tileOverlay2.setVisible(isLoadWorldGridMap);
            }
        }
    }
}
