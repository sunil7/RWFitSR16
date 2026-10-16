package com.autonavi.base.ae.gmap.gloverlay;

import android.util.Pair;
import com.amap.api.col.p0003sl.q5;
import com.amap.api.col.p0003sl.r5;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.RouteOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.util.Map;

/* loaded from: classes.dex */
public class BaseRouteOverlay extends GLOverlay implements IRouteOverlayInner {
    public BaseRouteOverlay(final int i3, IAMapDelegate iAMapDelegate, int i10) {
        super(i3, iAMapDelegate, i10);
        IAMapDelegate iAMapDelegate2 = this.mGLMapView;
        if (iAMapDelegate2 == null || iAMapDelegate2.getGLMapEngine() == null) {
            return;
        }
        this.mGLMapView.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.BaseRouteOverlay.1
            @Override // java.lang.Runnable
            public void run() {
                BaseRouteOverlay baseRouteOverlay = BaseRouteOverlay.this;
                baseRouteOverlay.mNativeInstance = baseRouteOverlay.mGLMapView.getGLMapEngine().createOverlay(i3, GLOverlay.EAMapOverlayTpye.AMAPROUTE_OVERLAY.getId());
            }
        });
    }

    private static native void nativeAddRouteItem(long j4, int i3, r5[] r5VarArr, int i10, q5 q5Var, int[] iArr);

    private static native void nativeAddRouteName(long j4);

    private static native void nativeRemoveRouteName(long j4, long j10);

    private static native void nativeSetArrow3DTexture(long j4, int i3);

    private static native void nativeSetArrowFlow(long j4, boolean z5);

    private static native void nativeSetCar2DPosition(long j4, int i3, float f2);

    private static native void nativeSetCar3DPosition(long j4, int i3, float f2);

    private static native void nativeSetHighlightParam(long j4, int[] iArr);

    private static native void nativeSetHighlightType(long j4, int i3);

    private static native void nativeSetLine2DWidth(long j4, int i3, int i10);

    private static native void nativeSetLineWidthScale(long j4, float f2);

    private static native void nativeSetRouteItemParam(long j4, r5 r5Var);

    private static native void nativeSetSelectStatus(long j4, boolean z5);

    private static native void nativeSetShowArrow(long j4, boolean z5);

    private static native void nativeSetShowNaviRouteNameCountMap(long j4, int[] iArr, int[] iArr2);

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void addRouteItem(int i3, r5[] r5VarArr, int i10, q5 q5Var, int[] iArr) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        if (r5VarArr.length <= 0) {
            nativeAddRouteItem(j4, i3, r5VarArr, i10, q5Var, iArr);
        } else if (r5VarArr[0] != null) {
            throw null;
        }
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void addRouteName() {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeAddRouteName(j4);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public Pair<Float, Float> getDisplayRange() {
        return null;
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public int getOverlayProperty() {
        return 0;
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.GLOverlay
    public void releaseInstance() {
        long j4 = this.mNativeInstance;
        this.mNativeInstance = 0L;
        this.mGLMapView.getGLMapEngine().destroyOverlay(this.mEngineID, j4);
        super.releaseInstance();
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void remove() {
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void removeRouteName() {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeRemoveRouteName(j4, this.mGLMapView.getGLMapEngine().getNativeInstance());
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setArrow3DTexture(BitmapDescriptor bitmapDescriptor) {
        int createOverlayTexture;
        if (this.mNativeInstance == 0 || bitmapDescriptor == null || bitmapDescriptor.getBitmap() == null || (createOverlayTexture = this.mGLMapView.createOverlayTexture(this.mEngineID, bitmapDescriptor.getBitmap())) < 0) {
            return;
        }
        nativeSetArrow3DTexture(this.mNativeInstance, createOverlayTexture);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setArrowFlow(boolean z5) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetArrowFlow(j4, z5);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setCar2DPosition(int i3, float f2) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetCar2DPosition(j4, i3, f2);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setCar3DPosition(int i3, float f2) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetCar3DPosition(j4, i3, f2);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setDisplayRange(float f2, float f10) {
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setHighlightParam(RouteOverlay.RouteOverlayHighLightParam routeOverlayHighLightParam) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetHighlightParam(j4, new int[]{routeOverlayHighLightParam.fillColorHightLight, routeOverlayHighLightParam.borderColorHightLight, routeOverlayHighLightParam.fillColorNormal, routeOverlayHighLightParam.borderColorNormal, routeOverlayHighLightParam.arrowColorNormal});
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setHighlightType(int i3) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetHighlightType(j4, i3);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setLine2DWidth(int i3, int i10) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetLine2DWidth(j4, i3, i10);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setLineWidthScale(float f2) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetLineWidthScale(j4, f2);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setOverlayProperty(int i3) {
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setRouteItemParam(r5 r5Var) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetRouteItemParam(j4, r5Var);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setSelectStatus(boolean z5) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetSelectStatus(j4, z5);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setShowArrow(boolean z5) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetShowArrow(j4, z5);
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.IRouteOverlayInner
    public void setShowNaviRouteNameCountMap(Map<Integer, Integer> map) {
        if (this.mNativeInstance == 0) {
            return;
        }
        int[] iArr = new int[map.size()];
        int[] iArr2 = new int[map.size()];
        int i3 = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            iArr[i3] = entry.getKey().intValue();
            iArr2[i3] = entry.getValue().intValue();
            i3++;
        }
        nativeSetShowNaviRouteNameCountMap(this.mNativeInstance, iArr, iArr2);
    }
}
