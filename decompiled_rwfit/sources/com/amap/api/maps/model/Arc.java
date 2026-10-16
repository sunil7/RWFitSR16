package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class Arc extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private ArcOptions options;

    public Arc(IGlOverlayLayer iGlOverlayLayer, ArcOptions arcOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = arcOptions;
    }

    private void updateOption() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        } catch (Throwable unused) {
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Arc)) {
            try {
                if (super.equals(obj)) {
                    return true;
                }
                return ((Arc) obj).getId() == getId();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return false;
    }

    public String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public int getStrokeColor() {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.getStrokeColor();
            }
            return 0;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public float getStrokeWidth() {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.getStrokeWidth();
            }
            return 0.0f;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0.0f;
        }
    }

    public float getZIndex() {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.getZIndex();
            }
            return 0.0f;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0.0f;
        }
    }

    public int hashCode() {
        try {
            return super.hashCode();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public boolean isVisible() {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                return arcOptions.isVisible();
            }
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
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

    public void setStrokeColor(int i3) {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                arcOptions.strokeColor(i3);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setStrokeWidth(float f2) {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                arcOptions.strokeWidth(f2);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setVisible(boolean z5) {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                arcOptions.visible(z5);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setZIndex(float f2) {
        try {
            ArcOptions arcOptions = this.options;
            if (arcOptions != null) {
                arcOptions.zIndex(f2);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
