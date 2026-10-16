package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.IPoint;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class GL3DModel extends BasePointOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private Object object;
    private GL3DModelOptions options;

    public GL3DModel(IGlOverlayLayer iGlOverlayLayer, GL3DModelOptions gL3DModelOptions, String str) {
        super(str);
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.options = gL3DModelOptions;
    }

    private Object callNativeFunction(String str, Object[] objArr) {
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

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void destroy() {
        remove();
    }

    public double getAltitude() {
        try {
            return this.options.getAltitude();
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0d;
        }
    }

    public float getAngle() {
        try {
            return this.options.getAngle();
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getId() {
        try {
            return this.overlayName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public Object getObject() {
        return this.object;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public LatLng getPosition() {
        try {
            return this.options.getLatLng();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public float getRotateAngle() {
        try {
            return getAngle();
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getSnippet() {
        try {
            GL3DModelOptions gL3DModelOptions = this.options;
            return gL3DModelOptions != null ? gL3DModelOptions.getSnippet() : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getTitle() {
        try {
            GL3DModelOptions gL3DModelOptions = this.options;
            return gL3DModelOptions != null ? gL3DModelOptions.getTitle() : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public int getZIndex() {
        GL3DModelOptions gL3DModelOptions = this.options;
        if (gL3DModelOptions == null) {
            return 0;
        }
        return gL3DModelOptions.getZIndex();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean isInfoWindowEnable() {
        return true;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean isVisible() {
        try {
            return this.options.isVisible();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
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

    public void setAltitude(double d5) {
        try {
            this.options.setAltitude(d5);
            updateOption();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAngle(float f2) {
        try {
            this.options.angle(f2);
            updateOption();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setAnimation(Animation animation) {
        try {
            callNativeFunction("setAnimation", new Object[]{animation});
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setGeoPoint(IPoint iPoint) {
    }

    public void setModelFixedLength(int i3) {
        try {
            this.options.setModelFixedLength(i3);
            updateOption();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setObject(Object obj) {
        try {
            this.object = obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setPosition(LatLng latLng) {
        try {
            this.options.position(latLng);
            updateOption();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setRotateAngle(float f2) {
        try {
            setAngle(f2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setSnippet(String str) {
        GL3DModelOptions gL3DModelOptions = this.options;
        if (gL3DModelOptions != null) {
            gL3DModelOptions.snippet(str);
            updateOption();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setTitle(String str) {
        GL3DModelOptions gL3DModelOptions = this.options;
        if (gL3DModelOptions != null) {
            gL3DModelOptions.title(str);
            updateOption();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setVisible(boolean z5) {
        try {
            this.options.setVisible(z5);
            updateOption();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setZIndex(int i3) {
        GL3DModelOptions gL3DModelOptions = this.options;
        if (gL3DModelOptions != null) {
            gL3DModelOptions.setzIndex(i3);
            updateOption();
        }
    }

    public void setZoomLimit(float f2) {
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void showInfoWindow() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.showInfoWindow(this.overlayName);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean startAnimation() {
        Object callNativeFunction = callNativeFunction("startAnimation", null);
        if (callNativeFunction instanceof Boolean) {
            return ((Boolean) callNativeFunction).booleanValue();
        }
        return false;
    }
}
