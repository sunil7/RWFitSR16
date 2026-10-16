package com.amap.api.maps.model;

import android.os.RemoteException;
import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class TileOverlay extends BaseOverlay {
    protected WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    protected TileOverlayOptions options;

    public TileOverlay(IGlOverlayLayer iGlOverlayLayer, TileOverlayOptions tileOverlayOptions, String str) {
        super(str);
        TileProviderInner tileProviderInner;
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = tileOverlayOptions;
        if (tileOverlayOptions == null || (tileProviderInner = tileOverlayOptions.getTileProviderInner()) == null) {
            return;
        }
        tileProviderInner.init(iGlOverlayLayer, str);
    }

    public Object callNativeFunction(String str, Object[] objArr) {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return null;
            }
            return iGlOverlayLayer.getNativeProperties(this.overlayName, str, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void clearTileCache() {
        callNativeFunction("clearTileCache", null);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof TileOverlay)) {
            try {
                TileOverlayOptions tileOverlayOptions = this.options;
                if (tileOverlayOptions != null && tileOverlayOptions.equals(((TileOverlay) obj).options)) {
                    if (this.overlayName.equals(((TileOverlay) obj).overlayName)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return false;
    }

    public String getId() {
        return this.overlayName;
    }

    public float getZIndex() {
        return this.options.getZIndex();
    }

    public int hashCode() {
        if (this.options == null) {
            return super.hashCode();
        }
        String str = this.overlayName;
        return this.options.hashCode() + (((str == null ? 0 : str.hashCode()) + 31) * 31);
    }

    public boolean isVisible() {
        return this.options.isVisible();
    }

    public void remove() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setVisible(boolean z5) {
        this.options.visible(z5);
        updateOption();
    }

    public void setZIndex(float f2) {
        this.options.zIndex(f2);
        updateOption();
    }

    public void updateOption() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        } catch (Throwable unused) {
        }
    }
}
