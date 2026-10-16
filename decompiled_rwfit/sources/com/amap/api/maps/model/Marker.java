package com.amap.api.maps.model;

import android.graphics.Point;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.col.p0003sl.rc;
import com.amap.api.col.p0003sl.u4;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.interfaces.INativeOverlayLayer;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class Marker extends BasePointOverlay {
    private IPoint geoPoint;
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private boolean isClickable;
    private boolean isInfoWindowEnable;
    private boolean isRemoved;
    private boolean isUseAnimation;
    private Animation mCurAnimation;
    private Animation.AnimationListener mCurAnimationListener;
    private b mCurInnerAnimationListener;
    private WeakReference<INativeOverlayLayer> nativeOverlayLayerRef;
    private Object object;
    private MarkerOptions options;
    private LatLng viewModeLatLng;
    private DPoint viewModeLatLngDp;

    public class b implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        private final rc f5737a;

        /* renamed from: b, reason: collision with root package name */
        private final rc f5738b;

        public class a extends rc {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Animation.AnimationListener f5739a;

            public a(b bVar, Marker marker, Animation.AnimationListener animationListener) {
                this.f5739a = animationListener;
            }

            @Override // com.amap.api.col.p0003sl.rc
            public void runTask() {
                try {
                    Animation.AnimationListener animationListener = this.f5739a;
                    if (animationListener != null) {
                        animationListener.onAnimationStart();
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }

        /* renamed from: com.amap.api.maps.model.Marker$b$b, reason: collision with other inner class name */
        public class C0010b extends rc {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Animation.AnimationListener f5740a;

            public C0010b(b bVar, Marker marker, Animation.AnimationListener animationListener) {
                this.f5740a = animationListener;
            }

            @Override // com.amap.api.col.p0003sl.rc
            public void runTask() {
                try {
                    Animation.AnimationListener animationListener = this.f5740a;
                    if (animationListener != null) {
                        animationListener.onAnimationEnd();
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public void onAnimationEnd() {
            u4.b().a(this.f5738b);
        }

        @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
        public void onAnimationStart() {
            u4.b().a(this.f5737a);
        }

        private b(Marker marker, Animation.AnimationListener animationListener) {
            this.f5737a = new a(this, marker, animationListener);
            this.f5738b = new C0010b(this, marker, animationListener);
        }
    }

    public Marker(IGlOverlayLayer iGlOverlayLayer, INativeOverlayLayer iNativeOverlayLayer, MarkerOptions markerOptions, String str) {
        super(str);
        this.isRemoved = false;
        this.viewModeLatLngDp = new DPoint();
        this.viewModeLatLng = null;
        this.isUseAnimation = false;
        this.mCurAnimation = null;
        this.mCurAnimationListener = null;
        this.mCurInnerAnimationListener = null;
        this.isClickable = true;
        this.isInfoWindowEnable = true;
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.nativeOverlayLayerRef = new WeakReference<>(iNativeOverlayLayer);
        this.options = markerOptions;
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
            if (isIconView()) {
                INativeOverlayLayer iNativeOverlayLayer = this.nativeOverlayLayerRef.get();
                if (TextUtils.isEmpty(this.overlayName) || iNativeOverlayLayer == null) {
                    return;
                }
                iNativeOverlayLayer.updateOverlayOption(this.overlayName, this.options);
                return;
            }
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
        try {
            remove();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public boolean equals(Object obj) {
        MarkerOptions markerOptions;
        if (obj != null) {
            try {
                if ((obj instanceof Marker) && (markerOptions = this.options) != null && markerOptions.equals(((Marker) obj).options)) {
                    if (this.overlayName.equals(((Marker) obj).overlayName)) {
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

    public float getAlpha() {
        Object callNativeFunction;
        if (this.options != null) {
            return (!this.isUseAnimation || (callNativeFunction = callNativeFunction("getAlpha", null)) == null) ? this.options.getAlpha() : ((Double) callNativeFunction).floatValue();
        }
        return 1.0f;
    }

    public float getAltitude() {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.getAltitude();
            }
            return 0.0f;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public float getAnchorU() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.getAnchorU();
        }
        return 0.0f;
    }

    public float getAnchorV() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.getAnchorV();
        }
        return 0.0f;
    }

    public int getDisplayLevel() {
        return 5;
    }

    public IPoint getGeoPoint() {
        if (this.geoPoint == null) {
            this.geoPoint = new IPoint();
        }
        LatLng position = getPosition();
        if (position != null) {
            VirtualEarthProjection.latLongToPixels(position.latitude, position.longitude, 20, this.geoPoint);
        }
        return this.geoPoint;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        try {
            return this.options.getIcons();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getId() {
        try {
            return this.overlayName;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public Object getObject() {
        return this.object;
    }

    public MarkerOptions getOptions() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions;
        }
        return null;
    }

    public int getPeriod() {
        try {
            return this.options.getPeriod();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public LatLng getPosition() {
        Object callNativeFunction;
        try {
            if (this.options != null) {
                if (!isViewMode()) {
                    return (!this.isUseAnimation || (callNativeFunction = callNativeFunction("getPosition", null)) == null) ? this.options.getPosition() : (LatLng) callNativeFunction;
                }
                this.glOverlayLayerRef.get().getMap().getPixel2LatLng(this.options.getScreenX(), this.options.getScreenY(), this.viewModeLatLngDp);
                LatLng latLng = this.viewModeLatLng;
                if (latLng != null) {
                    double d5 = latLng.latitude;
                    DPoint dPoint = this.viewModeLatLngDp;
                    if (d5 == dPoint.f6571y && latLng.longitude == dPoint.f6570x) {
                        return latLng;
                    }
                }
                DPoint dPoint2 = this.viewModeLatLngDp;
                return new LatLng(dPoint2.f6571y, dPoint2.f6570x);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return null;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public float getRotateAngle() {
        if (this.options == null) {
            return 0.0f;
        }
        if (this.isUseAnimation) {
            Object callNativeFunction = callNativeFunction("getRotateAngle", null);
            Log.e("mapcore", "getRotateAngle " + callNativeFunction);
            if (callNativeFunction != null) {
                return ((Double) callNativeFunction).floatValue();
            }
        }
        return this.options.getRotateAngle();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getSnippet() {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.getSnippet();
            }
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public String getTitle() {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.getTitle();
            }
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public float getZIndex() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.getZIndex();
        }
        return 0.0f;
    }

    public int hashCode() {
        if (this.options == null) {
            return super.hashCode();
        }
        String str = this.overlayName;
        return this.options.hashCode() + (((str == null ? 0 : str.hashCode()) + 31) * 31);
    }

    public void hideInfoWindow() {
        try {
            if (isIconView()) {
                INativeOverlayLayer iNativeOverlayLayer = this.nativeOverlayLayerRef.get();
                if (TextUtils.isEmpty(this.overlayName) || iNativeOverlayLayer == null) {
                    return;
                }
                iNativeOverlayLayer.hideInfoWindow(this.overlayName);
                return;
            }
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.hideInfoWindow(this.overlayName);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public boolean isClickable() {
        Object callNativeFunction = callNativeFunction("isClickable", null);
        return callNativeFunction instanceof Boolean ? ((Boolean) callNativeFunction).booleanValue() : this.isClickable;
    }

    public boolean isDraggable() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isDraggable();
        }
        return false;
    }

    public boolean isFlat() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isFlat();
        }
        return false;
    }

    public boolean isIconView() {
        MarkerOptions markerOptions = this.options;
        return (markerOptions == null || markerOptions.getIconView() == null) ? false : true;
    }

    public boolean isInfoWindowAutoOverturn() {
        return false;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean isInfoWindowEnable() {
        MarkerOptions markerOptions = this.options;
        return markerOptions != null ? markerOptions.isInfoWindowEnable() : this.isInfoWindowEnable;
    }

    public boolean isInfoWindowShown() {
        if (isIconView()) {
            INativeOverlayLayer iNativeOverlayLayer = this.nativeOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iNativeOverlayLayer == null) {
                return false;
            }
            return iNativeOverlayLayer.isInfoWindowShown(this.overlayName);
        }
        IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
        if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
            return false;
        }
        Object callNativeFunction = callNativeFunction("isInfoWindowShown", null);
        if (callNativeFunction instanceof Boolean) {
            return ((Boolean) callNativeFunction).booleanValue();
        }
        return false;
    }

    public boolean isPerspective() {
        return false;
    }

    public boolean isRemoved() {
        return this.isRemoved;
    }

    public boolean isViewMode() {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            return markerOptions.isViewMode();
        }
        return false;
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public boolean isVisible() {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                return markerOptions.isVisible();
            }
            return false;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void remove() {
        try {
            if (isInfoWindowShown()) {
                hideInfoWindow();
            }
            if (isIconView()) {
                INativeOverlayLayer iNativeOverlayLayer = this.nativeOverlayLayerRef.get();
                if (iNativeOverlayLayer != null) {
                    iNativeOverlayLayer.removeNativeOverlay(this.overlayName);
                }
            } else {
                IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
                if (iGlOverlayLayer != null) {
                    iGlOverlayLayer.removeOverlay(this.overlayName);
                }
            }
            this.isRemoved = true;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setAlpha(float f2) {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.alpha(f2);
            updateOption();
        }
    }

    public void setAltitude(float f2) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.altitude(f2);
                updateOption();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setAnchor(float f2, float f10) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.anchor(f2, f10);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setAnimation(Animation animation) {
        if (animation != null) {
            try {
                Animation.AnimationListener animationListener = this.mCurAnimationListener;
                if (animationListener != null) {
                    animation.setAnimationListener(animationListener);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        this.mCurAnimation = animation;
        this.isUseAnimation = animation != null;
        callNativeFunction("setAnimation", new Object[]{animation});
        if (animation != null) {
            animation.resetUpdateFlags();
        }
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.mCurAnimationListener = animationListener;
        b bVar = new b(animationListener);
        this.mCurInnerAnimationListener = bVar;
        if (this.mCurAnimation != null) {
            callNativeFunction("setAnimationListener", new Object[]{bVar});
        }
    }

    public void setAutoOverturnInfoWindow(boolean z5) {
    }

    public void setBelowMaskLayer(boolean z5) {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.belowMaskLayer(z5);
            updateOption();
        }
    }

    public void setClickable(boolean z5) {
        this.isClickable = z5;
        callNativeFunction("setClickable", new Object[]{Boolean.valueOf(z5)});
    }

    public void setDisplayLevel(int i3) {
    }

    public void setDraggable(boolean z5) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.draggable(z5);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setFixingPointEnable(boolean z5) {
    }

    public void setFlat(boolean z5) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.setFlat(z5);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setGeoPoint(IPoint iPoint) {
        this.geoPoint = iPoint;
        if (iPoint != null) {
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(((Point) iPoint).x, ((Point) iPoint).y, 20);
            LatLng latLng = new LatLng(pixelsToLatLong.f6571y, pixelsToLatLong.f6570x, false);
            pixelsToLatLong.recycle();
            this.options.position(latLng);
            updateOption();
        }
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                MarkerOptions markerOptions = this.options;
                if (markerOptions != null) {
                    markerOptions.icon(bitmapDescriptor);
                    updateOption();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        try {
            this.options.icons(arrayList);
            updateOption();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setInfoWindowEnable(boolean z5) {
        this.isInfoWindowEnable = z5;
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.infoWindowEnable(z5);
            updateOption();
        }
    }

    public void setMarkerOptions(MarkerOptions markerOptions) {
        this.options = markerOptions;
        updateOption();
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setObject(Object obj) {
        this.object = obj;
    }

    public void setPeriod(int i3) {
        try {
            this.options.period(i3);
            updateOption();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setPerspective(boolean z5) {
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setPosition(LatLng latLng) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.position(latLng);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setPositionByPixels(int i3, int i10) {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.setScreenPosition(i3, i10);
            updateOption();
        }
    }

    public void setPositionNotUpdate(LatLng latLng) {
        setPosition(latLng);
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setRotateAngle(float f2) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.rotateAngle(f2);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setRotateAngleNotUpdate(float f2) {
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setSnippet(String str) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.snippet(str);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setTitle(String str) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.title(str);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setToTop() {
        try {
            IGlOverlayLayer iGlOverlayLayer = this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return;
            }
            iGlOverlayLayer.set2Top(this.overlayName);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void setVisible(boolean z5) {
        try {
            MarkerOptions markerOptions = this.options;
            if (markerOptions != null) {
                markerOptions.visible(z5);
                updateOption();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void setZIndex(float f2) {
        MarkerOptions markerOptions = this.options;
        if (markerOptions != null) {
            markerOptions.zIndex(f2);
            updateOption();
        }
    }

    @Override // com.amap.api.maps.model.BasePointOverlay
    public void showInfoWindow() {
        try {
            if (isIconView()) {
                INativeOverlayLayer iNativeOverlayLayer = this.nativeOverlayLayerRef.get();
                if (TextUtils.isEmpty(this.overlayName) || iNativeOverlayLayer == null) {
                    return;
                }
                iNativeOverlayLayer.showInfoWindow(this.overlayName);
                return;
            }
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
