package com.autonavi.base.ae.gmap.gloverlay;

import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* loaded from: classes.dex */
public abstract class GLOverlay {
    protected int mCode;
    protected int mEngineID;
    protected IAMapDelegate mGLMapView;
    protected boolean isNightStyle = false;
    boolean mIsInBundle = false;
    protected long mNativeInstance = 0;
    protected int mItemPriority = 0;

    public enum EAMapOverlayTpye {
        AMAPOVERLAY_ARROW(4),
        AMAPOVERLAY_VECTOR(5),
        AMAPROUTE_OVERLAY(16);


        /* renamed from: id, reason: collision with root package name */
        private int f6847id;

        EAMapOverlayTpye(int i3) {
            this.f6847id = i3;
        }

        public int getId() {
            return this.f6847id;
        }
    }

    public GLOverlay(int i3, IAMapDelegate iAMapDelegate, int i10) {
        this.mEngineID = i3;
        this.mGLMapView = iAMapDelegate;
        this.mCode = i10;
    }

    private static native int nativeGetCount(long j4);

    private static native int nativeGetOverlayPriority(long j4);

    private static native int nativeGetSubType(long j4);

    private static native int nativeGetType(long j4);

    private static native boolean nativeIsClickable(long j4);

    private static native boolean nativeIsVisible(long j4);

    private static native void nativeRemoveAll(long j4);

    private static native void nativeRemoveItem(long j4, int i3);

    private static native void nativeSetClickable(long j4, boolean z5);

    private static native void nativeSetMaxDisplayLevel(long j4, float f2);

    private static native void nativeSetMinDisplayLevel(long j4, float f2);

    private static native void nativeSetOverlayOnTop(long j4, boolean z5);

    private static native void nativeSetOverlayPriority(long j4, int i3);

    private static native void nativeSetOverlayPriorityOnly(long j4, int i3);

    public static native void nativeSetVisible(long j4, boolean z5);

    public void clearFocus() {
    }

    public int getCode() {
        return this.mCode;
    }

    public boolean getIsInBundle() {
        return this.mIsInBundle;
    }

    public long getNativeInstatnce() {
        return this.mNativeInstance;
    }

    public int getOverlayPriority() {
        return nativeGetOverlayPriority(this.mNativeInstance);
    }

    public int getSize() {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return 0;
        }
        return nativeGetCount(j4);
    }

    public int getSubType() {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return -1;
        }
        return nativeGetSubType(j4);
    }

    public int getType() {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return -1;
        }
        return nativeGetType(j4);
    }

    public boolean isClickable() {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return false;
        }
        return nativeIsClickable(j4);
    }

    public boolean isVisible() {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return false;
        }
        return nativeIsVisible(j4);
    }

    public void releaseInstance() {
        if (this.mNativeInstance != 0) {
            this.mNativeInstance = 0L;
        }
    }

    public void removeAll() {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeRemoveAll(j4);
    }

    public void removeItem(int i3) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeRemoveItem(j4, i3);
    }

    public void setClickable(boolean z5) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetClickable(j4, z5);
    }

    public void setMaxDisplayLevel(float f2) {
        nativeSetMaxDisplayLevel(this.mNativeInstance, f2);
    }

    public void setMinDisplayLevel(float f2) {
        nativeSetMinDisplayLevel(this.mNativeInstance, f2);
    }

    public void setOverlayItemPriority(int i3) {
        this.mItemPriority = i3;
    }

    public void setOverlayOnTop(boolean z5) {
        nativeSetOverlayOnTop(this.mNativeInstance, z5);
    }

    public void setOverlayPriority(int i3) {
        GLOverlayBundle overlayBundle;
        nativeSetOverlayPriority(this.mNativeInstance, i3);
        IAMapDelegate iAMapDelegate = this.mGLMapView;
        if (iAMapDelegate == null || iAMapDelegate.getGLMapEngine() == null || (overlayBundle = this.mGLMapView.getGLMapEngine().getOverlayBundle(this.mEngineID)) == null) {
            return;
        }
        overlayBundle.sortOverlay();
    }

    public void setOverlayPriorityOnly(int i3) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetOverlayPriorityOnly(j4, i3);
    }

    public void setVisible(boolean z5) {
        long j4 = this.mNativeInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetVisible(j4, z5);
    }

    public void useNightStyle(boolean z5) {
        this.isNightStyle = z5;
    }
}
