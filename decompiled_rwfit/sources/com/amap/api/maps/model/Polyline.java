package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: classes.dex */
public class Polyline extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private PolylineOptions options;

    public Polyline(IGlOverlayLayer iGlOverlayLayer, PolylineOptions polylineOptions) {
        super("");
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = polylineOptions;
    }

    private void updateOption() {
        try {
            synchronized (this) {
                try {
                    IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
                    if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
                        iGlOverlayLayer.updateOption(this.overlayName, this.options);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Polyline)) {
            return false;
        }
        try {
            if (super.equals(obj)) {
                return true;
            }
            return ((Polyline) obj).getId() == getId();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public int getColor() {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getColor();
            }
            return 0;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public int getEraseColor() {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getEraseColor();
            }
            return 0;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    public BitmapDescriptor getEraseTexture() {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getEraseTexture();
            }
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public boolean getEraseVisible() {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getEraseVisible();
            }
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public float getFootPrintGap() {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getFootPrintGap();
            }
            return 0.0f;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0.0f;
        }
    }

    public BitmapDescriptor getFootPrintTexture() {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getFootPrintTexture();
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

    public LatLng getNearestLatLng(LatLng latLng) {
        IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (iGlOverlayLayer != null) {
            return iGlOverlayLayer.getNearestLatLng(this.options, latLng);
        }
        return null;
    }

    public PolylineOptions getOptions() {
        return this.options;
    }

    public List<LatLng> getPoints() {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getPoints();
            }
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public float getPolylineShownRangeBegin() {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getPolylineShownRangeBegin();
            }
            return 0.0f;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0.0f;
        }
    }

    public float getPolylineShownRangeEnd() {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getPolylineShownRangeEnd();
            }
            return 0.0f;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0.0f;
        }
    }

    public float getShownRatio() {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getShownRatio();
            }
            return -1.0f;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1.0f;
        }
    }

    public float getWidth() {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getWidth();
            }
            return 0.0f;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0.0f;
        }
    }

    public float getZIndex() {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.getZIndex();
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

    public boolean isDottedLine() {
        PolylineOptions polylineOptions = this.options;
        if (polylineOptions != null) {
            return polylineOptions.isDottedLine();
        }
        return false;
    }

    public boolean isGeodesic() {
        PolylineOptions polylineOptions = this.options;
        return polylineOptions != null && polylineOptions.isGeodesic();
    }

    public boolean isShowPolylineRangeEnable() {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.isShowPolylineRangeEnable();
            }
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public boolean isVisible() {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                return polylineOptions.isVisible();
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
            this.overlayName = null;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setAboveMaskLayer(boolean z5) {
        PolylineOptions polylineOptions = this.options;
        if (polylineOptions != null) {
            polylineOptions.aboveMaskLayer(z5);
            updateOption();
        }
    }

    public void setColor(int i3) {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.color(i3);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Deprecated
    public void setCustemTextureIndex(List<Integer> list) {
        setCustomTextureIndex(list);
    }

    public void setCustomTexture(BitmapDescriptor bitmapDescriptor) {
        PolylineOptions polylineOptions = this.options;
        if (polylineOptions != null) {
            polylineOptions.setCustomTexture(bitmapDescriptor);
            updateOption();
        }
    }

    public void setCustomTextureIndex(List<Integer> list) {
        synchronized (this) {
            try {
                PolylineOptions polylineOptions = this.options;
                if (polylineOptions != null) {
                    polylineOptions.setCustomTextureIndex(list);
                    updateOption();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void setCustomTextureList(List<BitmapDescriptor> list) {
        try {
            this.options.setCustomTextureList(list);
            updateOption();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setDottedLine(boolean z5) {
        PolylineOptions polylineOptions = this.options;
        if (polylineOptions != null) {
            polylineOptions.setDottedLine(z5);
            updateOption();
        }
    }

    public void setEraseColor(boolean z5, int i3) {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.setEraseColor(z5, i3);
                updateOption();
            }
        } catch (Throwable unused) {
        }
    }

    public void setEraseTexture(boolean z5, BitmapDescriptor bitmapDescriptor) {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.setEraseTexture(z5, bitmapDescriptor);
                updateOption();
            }
        } catch (Throwable unused) {
        }
    }

    public void setFootPrintGap(float f2) {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.setFootPrintGap(f2);
                updateOption();
            }
        } catch (Throwable unused) {
        }
    }

    public void setFootPrintTexture(BitmapDescriptor bitmapDescriptor) {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.setFootPrintTexture(bitmapDescriptor);
                updateOption();
            }
        } catch (Throwable unused) {
        }
    }

    public void setGeodesic(boolean z5) {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.geodesic(z5);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setOptions(PolylineOptions polylineOptions) {
        this.options = polylineOptions;
        updateOption();
    }

    public void setPoints(List<LatLng> list) {
        try {
            synchronized (this) {
                try {
                    PolylineOptions polylineOptions = this.options;
                    if (polylineOptions != null) {
                        polylineOptions.setPoints(list);
                        updateOption();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public void setPolylineShowRange(float f2, float f10) {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.setPolylineShowRange(f2, f10);
                updateOption();
            }
        } catch (Throwable unused) {
        }
    }

    public void setShownRange(float f2, float f10) {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.setShownRange(f2, f10);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setShownRatio(float f2) {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.setShownRatio(f2);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setTransparency(float f2) {
        PolylineOptions polylineOptions = this.options;
        if (polylineOptions != null) {
            polylineOptions.transparency(f2);
            updateOption();
        }
    }

    public void setVisible(boolean z5) {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.visible(z5);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setWidth(float f2) {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.width(f2);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setZIndex(float f2) {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.zIndex(f2);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void showPolylineRangeEnabled(boolean z5) {
        try {
            PolylineOptions polylineOptions = this.options;
            if (polylineOptions != null) {
                polylineOptions.showPolylineRangeEnabled(z5);
                updateOption();
            }
        } catch (Throwable unused) {
        }
    }

    public Polyline(IGlOverlayLayer iGlOverlayLayer, PolylineOptions polylineOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = polylineOptions;
    }
}
