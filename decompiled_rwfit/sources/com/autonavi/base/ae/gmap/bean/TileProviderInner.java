package com.autonavi.base.ae.gmap.bean;

import android.text.TextUtils;
import com.amap.api.col.p0003sl.rc;
import com.amap.api.col.p0003sl.u4;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileOverlaySource;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

@JBindingInclude
/* loaded from: classes.dex */
public class TileProviderInner {

    @JBindingExclude
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;

    @JBindingInclude
    private List<TileOverlaySource> mTileSource;

    @JBindingExclude
    private String overlayName;

    @JBindingExclude
    private final HashMap<String, rc> reqTaskHandleHashMap = new HashMap<>();

    @JBindingExclude
    private final TileProvider tileProvider;

    @JBindingExclude
    public TileProviderInner(TileProvider tileProvider) {
        this.tileProvider = tileProvider;
    }

    @JBindingExclude
    private Object callNativeFunction(String str, Object[] objArr) {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return null;
            }
            return iGlOverlayLayer.getNativeProperties(this.overlayName, str, objArr);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    @JBindingExclude
    private String createKey(int i3, int i10, int i11, long j4) {
        return i3 + " " + i10 + " " + i11 + "-" + j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishDownload(Tile tile, TileReqTaskHandle tileReqTaskHandle, String str) {
        boolean z5;
        if (this.glOverlayLayerRef.get() == null) {
            return;
        }
        synchronized (this.reqTaskHandleHashMap) {
            try {
                if (this.reqTaskHandleHashMap.containsKey(str)) {
                    if (this.reqTaskHandleHashMap.containsKey(str)) {
                        this.reqTaskHandleHashMap.remove(str);
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (z5) {
                        tileReqTaskHandle.finish(tile);
                        callNativeFunction("finishTileReqTask", new Object[]{tileReqTaskHandle});
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @JBindingInclude
    public void cancelTile(TileSourceReq tileSourceReq, TileReqTaskHandle tileReqTaskHandle) {
        String createKey = createKey(tileSourceReq.f6843x, tileSourceReq.f6844y, tileSourceReq.zoom, tileReqTaskHandle.nativeObj);
        synchronized (this.reqTaskHandleHashMap) {
            try {
                if (this.reqTaskHandleHashMap.containsKey(createKey)) {
                    rc rcVar = this.reqTaskHandleHashMap.get(createKey);
                    if (rcVar != null) {
                        u4.b().getClass();
                        try {
                            rcVar.cancelTask();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    tileReqTaskHandle.status = 1;
                    finishDownload(TileProvider.NO_TILE, tileReqTaskHandle, createKey);
                    try {
                        TileProvider tileProvider = this.tileProvider;
                        if (tileProvider instanceof TileSourceProvider) {
                            ((TileSourceProvider) tileProvider).cancel(tileSourceReq);
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    @JBindingInclude
    public void getTile(final TileSourceReq tileSourceReq, final TileReqTaskHandle tileReqTaskHandle) {
        final String createKey = createKey(tileSourceReq.f6843x, tileSourceReq.f6844y, tileSourceReq.zoom, tileReqTaskHandle.nativeObj);
        rc rcVar = new rc() { // from class: com.autonavi.base.ae.gmap.bean.TileProviderInner.1
            @Override // com.amap.api.col.p0003sl.rc
            public void runTask() {
                try {
                    synchronized (TileProviderInner.this.reqTaskHandleHashMap) {
                        try {
                            if (TileProviderInner.this.reqTaskHandleHashMap.containsKey(createKey)) {
                                if (TileProviderInner.this.tileProvider != null) {
                                    Tile tile = TileProvider.NO_TILE;
                                    try {
                                        if (TileProviderInner.this.tileProvider instanceof TileSourceProvider) {
                                            tile = ((TileSourceProvider) TileProviderInner.this.tileProvider).getTile(tileSourceReq);
                                        } else {
                                            TileProvider tileProvider = TileProviderInner.this.tileProvider;
                                            TileSourceReq tileSourceReq2 = tileSourceReq;
                                            tile = tileProvider.getTile(tileSourceReq2.f6843x, tileSourceReq2.f6844y, tileSourceReq2.zoom);
                                        }
                                    } catch (Throwable unused) {
                                    }
                                    TileProviderInner.this.finishDownload(tile, tileReqTaskHandle, createKey);
                                }
                            }
                        } finally {
                        }
                    }
                } catch (Throwable th2) {
                    TileProviderInner.this.finishDownload(TileProvider.NO_TILE, tileReqTaskHandle, createKey);
                    th2.printStackTrace();
                }
            }
        };
        synchronized (this.reqTaskHandleHashMap) {
            try {
                if (this.reqTaskHandleHashMap.containsKey(createKey)) {
                    return;
                }
                this.reqTaskHandleHashMap.put(createKey, rcVar);
                u4.b().a(rcVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @JBindingInclude
    public int getTileHeight() {
        TileProvider tileProvider = this.tileProvider;
        if (tileProvider != null) {
            return tileProvider.getTileHeight();
        }
        return 0;
    }

    @JBindingInclude
    public int getTileWidth() {
        TileProvider tileProvider = this.tileProvider;
        if (tileProvider != null) {
            return tileProvider.getTileWidth();
        }
        return 0;
    }

    @JBindingExclude
    public void init(IGlOverlayLayer iGlOverlayLayer, String str) {
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.overlayName = str;
    }

    public void setTileSource(List<TileOverlaySource> list) {
        this.mTileSource = list;
    }
}
