package com.amap.api.maps.model;

import android.os.RemoteException;
import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class MVTTileOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private MVTTileOverlayOptions mMVTTileOverlayOptions;

    public MVTTileOverlay(IGlOverlayLayer iGlOverlayLayer, MVTTileOverlayOptions mVTTileOverlayOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.mMVTTileOverlayOptions = mVTTileOverlayOptions;
        if (mVTTileOverlayOptions != null) {
            mVTTileOverlayOptions.getTileProviderInner().init(iGlOverlayLayer, str);
        }
    }

    public float getZIndex() {
        return this.mMVTTileOverlayOptions.getZIndex();
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
        this.mMVTTileOverlayOptions.setVisible(z5);
        updateOption();
    }

    public void setZIndex(float f2) {
        this.mMVTTileOverlayOptions.setZIndex(f2);
        updateOption();
    }

    public void updateOption() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.mMVTTileOverlayOptions);
        } catch (Throwable unused) {
        }
    }

    public boolean visible() {
        return this.mMVTTileOverlayOptions.visible();
    }
}
