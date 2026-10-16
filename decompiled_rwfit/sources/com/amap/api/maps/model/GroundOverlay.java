package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class GroundOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private float high;
    private GroundOverlayOptions options;
    private LatLng point;
    private float width;

    public GroundOverlay(IGlOverlayLayer iGlOverlayLayer, GroundOverlayOptions groundOverlayOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = groundOverlayOptions;
    }

    private void updateOption() {
        IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return;
        }
        iGlOverlayLayer.updateOption(this.overlayName, this.options);
    }

    public void destroy() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable unused) {
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof GroundOverlay)) {
            try {
                if (super.equals(obj)) {
                    return true;
                }
                return ((GroundOverlay) obj).getId() == getId();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return false;
    }

    public float getBearing() {
        try {
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getBearing();
            }
            return 0.0f;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0.0f;
        }
    }

    public LatLngBounds getBounds() {
        try {
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getBounds();
            }
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public float getHeight() {
        try {
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getHeight();
            }
            return 0.0f;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0.0f;
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

    public LatLng getPosition() {
        try {
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getLocation();
            }
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public float getTransparency() {
        try {
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getTransparency();
            }
            return 0.0f;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0.0f;
        }
    }

    public float getWidth() {
        try {
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getWidth();
            }
            return 0.0f;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0.0f;
        }
    }

    public float getZIndex() {
        try {
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.getZIndex();
            }
            return 0.0f;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0.0f;
        }
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isVisible() {
        try {
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                return groundOverlayOptions.isVisible();
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
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions == null || groundOverlayOptions.getImage() == null) {
                return;
            }
            this.options.getImage().recycle();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setBearing(float f2) {
        try {
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.bearing(f2);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setDimensions(float f2) {
        try {
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                LatLng latLng = this.point;
                if (latLng == null) {
                    latLng = groundOverlayOptions.getLocation();
                }
                if (latLng == null) {
                    this.width = f2;
                } else {
                    this.options.position(latLng, f2);
                    updateOption();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        try {
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.image(bitmapDescriptor);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions == null || latLng == null) {
                return;
            }
            float f2 = this.width;
            if (f2 <= 0.0f) {
                f2 = groundOverlayOptions.getWidth();
            }
            float f10 = this.high;
            if (f10 <= 0.0f) {
                f10 = this.options.getHeight();
            }
            if (f2 == 0.0f) {
                this.point = latLng;
                return;
            }
            if (f10 == 0.0f) {
                this.options.position(latLng, f2);
                updateOption();
            } else if (f10 > 0.0f) {
                this.options.position(latLng, f2, f10);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        try {
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions == null || latLngBounds == null) {
                return;
            }
            groundOverlayOptions.positionFromBounds(latLngBounds);
            updateOption();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setTransparency(float f2) {
        try {
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.transparency(f2);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setVisible(boolean z5) {
        try {
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.visible(z5);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setZIndex(float f2) {
        try {
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                groundOverlayOptions.zIndex(f2);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setDimensions(float f2, float f10) {
        try {
            GroundOverlayOptions groundOverlayOptions = this.options;
            if (groundOverlayOptions != null) {
                LatLng latLng = this.point;
                if (latLng == null) {
                    latLng = groundOverlayOptions.getLocation();
                }
                if (latLng == null) {
                    this.width = f2;
                    this.high = f10;
                } else {
                    GroundOverlayOptions groundOverlayOptions2 = this.options;
                    groundOverlayOptions2.position(groundOverlayOptions2.getLocation(), f2, f10);
                    updateOption();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
