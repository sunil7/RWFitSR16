package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class Polygon extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private PolygonOptions options;

    public Polygon(IGlOverlayLayer iGlOverlayLayer, PolygonOptions polygonOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = polygonOptions;
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

    public boolean contains(LatLng latLng) {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                return iGlOverlayLayer.IsPolygonContainsPoint(this.options, latLng);
            }
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Polygon)) {
            try {
                if (super.equals(obj)) {
                    return true;
                }
                return ((Polygon) obj).getId() == getId();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return false;
    }

    public int getFillColor() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getFillColor();
            }
            return 0;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public List<BaseHoleOptions> getHoleOptions() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getHoleOptions();
            }
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public List<LatLng> getPoints() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getPoints();
            }
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public int getStrokeColor() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getStrokeColor();
            }
            return 0;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public float getStrokeWidth() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getStrokeWidth();
            }
            return 0.0f;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0.0f;
        }
    }

    public float getZIndex() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.getZIndex();
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
        } catch (Throwable unused) {
            return super.hashCode();
        }
    }

    public boolean isVisible() {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                return polygonOptions.isVisible();
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

    public void setFillColor(int i3) {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                polygonOptions.fillColor(i3);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setHoleOptions(List<BaseHoleOptions> list) {
        if (list == null) {
            try {
                list = new ArrayList<>();
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        this.options.setHoleOptions(list);
        updateOption();
    }

    public void setPoints(List<LatLng> list) {
        try {
            this.options.setPoints(list);
            updateOption();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setStrokeColor(int i3) {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                polygonOptions.strokeColor(i3);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setStrokeWidth(float f2) {
        try {
            this.options.strokeWidth(f2);
            updateOption();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setVisible(boolean z5) {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                polygonOptions.visible(z5);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setZIndex(float f2) {
        try {
            PolygonOptions polygonOptions = this.options;
            if (polygonOptions != null) {
                polygonOptions.zIndex(f2);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
