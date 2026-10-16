package com.autonavi.base.ae.gmap.gloverlay;

import android.graphics.Rect;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* loaded from: classes.dex */
public class GLCrossVector extends GLOverlay {
    private long mDiceNativeInstance;

    public GLCrossVector(final int i3, final IAMapDelegate iAMapDelegate, int i10) {
        super(i3, iAMapDelegate, i10);
        this.mDiceNativeInstance = 0L;
        if (iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null) {
            return;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.1
            @Override // java.lang.Runnable
            public void run() {
                GLCrossVector.this.mNativeInstance = iAMapDelegate.getGLMapEngine().createOverlay(i3, GLOverlay.EAMapOverlayTpye.AMAPOVERLAY_VECTOR.getId());
            }
        });
    }

    private static native void nativeAddVectorCar(long j4, int i3, int i10, int i11);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int nativeAddVectorData(long j4, int[] iArr, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeInitTextureCallback(long j4, Object obj, boolean z5);

    private static native void nativeSetArrowResId(long j4, boolean z5, int i3);

    private static native void nativeSetBackgroundResId(long j4, int i3);

    private static native void nativeSetCarResId(long j4, int i3);

    public int addVectorItem(AVectorCrossAttr aVectorCrossAttr, final byte[] bArr, int i3) {
        if (aVectorCrossAttr == null || bArr == null || i3 == 0) {
            return -1;
        }
        Rect rect = aVectorCrossAttr.stAreaRect;
        final int[] iArr = {rect.left, rect.top, rect.right, rect.bottom, aVectorCrossAttr.stAreaColor, aVectorCrossAttr.fArrowBorderWidth, aVectorCrossAttr.stArrowBorderColor, aVectorCrossAttr.fArrowLineWidth, aVectorCrossAttr.stArrowLineColor, aVectorCrossAttr.dayMode};
        IAMapDelegate iAMapDelegate = this.mGLMapView;
        if (iAMapDelegate == null) {
            return 0;
        }
        iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.2
            @Override // java.lang.Runnable
            public void run() {
                GLCrossVector.nativeAddVectorData(GLCrossVector.this.mNativeInstance, iArr, bArr);
            }
        });
        return 0;
    }

    public void initTextureCallback(final CrossVectorOverlay crossVectorOverlay, final boolean z5) {
        IAMapDelegate iAMapDelegate = this.mGLMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.queueEvent(new Runnable() { // from class: com.autonavi.base.ae.gmap.gloverlay.GLCrossVector.3
                @Override // java.lang.Runnable
                public void run() {
                    GLCrossVector.nativeInitTextureCallback(GLCrossVector.this.mNativeInstance, crossVectorOverlay, z5);
                }
            });
        }
    }

    @Override // com.autonavi.base.ae.gmap.gloverlay.GLOverlay
    public void releaseInstance() {
        long j4 = this.mNativeInstance;
        this.mNativeInstance = 0L;
        this.mGLMapView.getGLMapEngine().destroyOverlay(this.mEngineID, j4);
        super.releaseInstance();
    }

    public void setArrowResId(boolean z5, int i3) {
        nativeSetArrowResId(this.mNativeInstance, z5, i3);
    }

    public void setBackgroundResId(int i3) {
        nativeSetBackgroundResId(this.mNativeInstance, i3);
    }

    public void setCarResId(int i3) {
        nativeSetCarResId(this.mNativeInstance, i3);
    }
}
