package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class GLTFOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private GLTFOverlayOptions mOptions;

    public GLTFOverlay(IGlOverlayLayer iGlOverlayLayer, GLTFOverlayOptions gLTFOverlayOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.mOptions = gLTFOverlayOptions;
    }

    private Object callNativeFunction(String str, Object[] objArr) {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
                return iGlOverlayLayer.getNativeProperties(this.overlayName, str, null);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private void updateOption() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.mOptions);
        } catch (Throwable unused) {
        }
    }

    public int getCurrentAnimationIndex() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            return gLTFOverlayOptions.getCurrentAnimationIndex();
        }
        return -1;
    }

    public String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public BitmapDescriptor getInfoWindowView() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            return gLTFOverlayOptions.getInfoWindowView();
        }
        return null;
    }

    public LatLng getLatlng() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            return gLTFOverlayOptions.getLatLng();
        }
        return null;
    }

    public GLTFOverlayOptions getOptions() {
        return this.mOptions.m8clone();
    }

    public float getZIndex() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            return gLTFOverlayOptions.getZIndex();
        }
        return 0.0f;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isAnimated() {
        Object callNativeFunction = callNativeFunction("isAnimated", null);
        if (callNativeFunction instanceof Boolean) {
            return ((Boolean) callNativeFunction).booleanValue();
        }
        return false;
    }

    public boolean isClickable() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            return gLTFOverlayOptions.isClickable();
        }
        return false;
    }

    public boolean isDraggable() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            return gLTFOverlayOptions.isDraggable();
        }
        return true;
    }

    public boolean isInfoWindowShow() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            return gLTFOverlayOptions.isInfoWindowShow();
        }
        return false;
    }

    public void remove() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setClickable(boolean z5) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.setClickable(z5);
        }
    }

    public void setCurrentAnimationIndex(int i3) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.setCurrentAnimationIndex(i3);
            updateOption();
        }
    }

    public void setDraggable(boolean z5) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.setDraggable(z5);
        }
    }

    public void setInfoWindowView(BitmapDescriptor bitmapDescriptor) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.infoWindowView(bitmapDescriptor);
            updateOption();
        }
    }

    public void setLatLng(LatLng latLng) {
        try {
            GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
            if (gLTFOverlayOptions != null) {
                gLTFOverlayOptions.latLng(latLng);
                updateOption();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setZIndex(float f2) {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.setZIndex(f2);
            updateOption();
        }
    }

    public void tapClick() {
        GLTFOverlayOptions gLTFOverlayOptions = this.mOptions;
        if (gLTFOverlayOptions != null) {
            gLTFOverlayOptions.tapClick();
        }
        try {
            callNativeFunction("tapClick", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
