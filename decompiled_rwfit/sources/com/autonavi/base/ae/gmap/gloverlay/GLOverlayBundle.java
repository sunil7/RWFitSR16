package com.autonavi.base.ae.gmap.gloverlay;

import android.util.SparseArray;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class GLOverlayBundle<E extends BaseMapOverlay<?, ?>> {
    private int mEngineID;
    private long mNativeInstance;
    private final List<E> mOverlayList = new ArrayList();
    private SparseArray<GLOverlayTexture> mTextureCaches = new SparseArray<>();

    public static class GLAmapFocusHits {
        public long mOverlayHashCode = 0;
        public long mHitedIndex = 0;
        public long mHitedTimes = 1000;
    }

    public GLOverlayBundle(int i3, IAMapDelegate iAMapDelegate) {
        this.mNativeInstance = 0L;
        this.mEngineID = i3;
        if (iAMapDelegate != null) {
            try {
                this.mNativeInstance = iAMapDelegate.getGLMapEngine().getGlOverlayMgrPtr(this.mEngineID);
            } catch (Throwable unused) {
            }
        }
    }

    private int getOverlyExType(E e) {
        return 0;
    }

    public static void intClr2PVRClr(float[] fArr, int i3) {
        fArr[2] = (i3 & 255) / 255.0f;
        fArr[1] = ((i3 >> 8) & 255) / 255.0f;
        fArr[0] = ((i3 >> 16) & 255) / 255.0f;
        fArr[3] = ((i3 >> 24) & 255) / 255.0f;
    }

    private static native void nativeAddGLOverlay(long j4, long j10, long j11);

    private static native void nativeAddGLOverlayEx(long j4, long j10, long j11, int i3);

    private static native void nativeClearAllGLOverlay(long j4, boolean z5);

    private static native boolean nativeOnSingleTapLineOverlay(long j4, int i3, int i10, long[] jArr);

    private static native boolean nativeOnSingleTapPointOverlay(long j4, int i3, int i10, long[] jArr);

    private static native void nativeRemoveGLOverlay(long j4, long j10);

    private static native void nativeRemoveGLOverlayEx(long j4, long j10, int i3);

    private static native void nativeSortAllGLOverlay(long j4);

    public void addOverlay(E e) {
        if (e == null) {
            return;
        }
        nativeAddGLOverlay(this.mNativeInstance, e.getGLOverlay().getNativeInstatnce(), e.getGLOverlay().getCode());
        e.getGLOverlay().mIsInBundle = true;
        synchronized (this.mOverlayList) {
            this.mOverlayList.add(e);
        }
    }

    public boolean addOverlayTextureItem(int i3, int i10, int i11, int i12) {
        GLOverlayTexture gLOverlayTexture = new GLOverlayTexture(i3, i10, i11, i12);
        synchronized (this.mTextureCaches) {
            this.mTextureCaches.put(i3, gLOverlayTexture);
        }
        return true;
    }

    public long checkSingleTapOnLine(int i3, int i10) {
        long[] jArr = new long[3];
        if (nativeOnSingleTapLineOverlay(this.mNativeInstance, i3, i10, jArr)) {
            return jArr[0];
        }
        return -1L;
    }

    public long checkSingleTapOnPoint(int i3, int i10) {
        long[] jArr = new long[3];
        if (nativeOnSingleTapPointOverlay(this.mNativeInstance, i3, i10, jArr)) {
            return jArr[0];
        }
        return -1L;
    }

    public void clearFocus() {
        List<E> list = this.mOverlayList;
        if (list != null) {
            synchronized (list) {
                for (int i3 = 0; i3 < this.mOverlayList.size(); i3++) {
                    try {
                        E e = this.mOverlayList.get(i3);
                        if (e != null) {
                            e.clearFocus();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }

    public void clearOverlayTexture() {
        synchronized (this.mTextureCaches) {
            this.mTextureCaches.clear();
        }
    }

    public boolean cotainsOverlay(E e) {
        boolean contains;
        if (e == null) {
            return false;
        }
        synchronized (this.mOverlayList) {
            contains = this.mOverlayList.contains(e);
        }
        return contains;
    }

    public E getOverlay(int i3) {
        synchronized (this.mOverlayList) {
            if (i3 >= 0) {
                try {
                    if (i3 <= this.mOverlayList.size() - 1) {
                        return this.mOverlayList.get(i3);
                    }
                } finally {
                }
            }
            return null;
        }
    }

    public int getOverlayCount() {
        int size;
        synchronized (this.mOverlayList) {
            size = this.mOverlayList.size();
        }
        return size;
    }

    public GLOverlayTexture getOverlayTextureItem(int i3) {
        GLOverlayTexture gLOverlayTexture;
        synchronized (this.mTextureCaches) {
            gLOverlayTexture = this.mTextureCaches.get(i3);
        }
        return gLOverlayTexture;
    }

    public boolean onSingleTap(int i3, int i10, int i11, int i12) {
        boolean onSingleTapPoints = (i12 & 1) == 1 ? onSingleTapPoints(i3, i10, i11) : false;
        if (onSingleTapPoints) {
            return true;
        }
        if ((i12 & 2) == 2) {
            onSingleTapPoints = onSingleTapLines(i3, i10, i11);
        }
        return onSingleTapPoints;
    }

    public boolean onSingleTapLines(int i3, int i10, int i11) {
        return false;
    }

    public boolean onSingleTapPoints(int i3, int i10, int i11) {
        return false;
    }

    public void reculateRouteBoard(IAMapDelegate iAMapDelegate) {
    }

    public void removeAll(boolean z5) {
        nativeClearAllGLOverlay(this.mNativeInstance, z5);
        synchronized (this.mOverlayList) {
            for (int i3 = 0; i3 < this.mOverlayList.size(); i3++) {
                try {
                    E e = this.mOverlayList.get(i3);
                    if (e != null) {
                        e.getGLOverlay().mIsInBundle = false;
                        e.getGLOverlay().releaseInstance();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            this.mOverlayList.clear();
        }
    }

    public void removeOverlay(E e) {
        if (e == null) {
            return;
        }
        nativeRemoveGLOverlay(this.mNativeInstance, e.getGLOverlay().getNativeInstatnce());
        e.getGLOverlay().mIsInBundle = false;
        synchronized (this.mOverlayList) {
            this.mOverlayList.remove(e);
        }
    }

    public void sortOverlay() {
        nativeSortAllGLOverlay(this.mNativeInstance);
    }

    public boolean addOverlayTextureItem(int i3, int i10, float f2, float f10, int i11, int i12) {
        GLOverlayTexture gLOverlayTexture = new GLOverlayTexture(i3, i10, f2, f10, i11, i12);
        synchronized (this.mTextureCaches) {
            this.mTextureCaches.put(i3, gLOverlayTexture);
        }
        return true;
    }
}
