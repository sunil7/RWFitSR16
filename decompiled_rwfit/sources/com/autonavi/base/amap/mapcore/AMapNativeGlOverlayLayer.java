package com.autonavi.base.amap.mapcore;

import android.graphics.Rect;
import android.util.Log;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.ImageOptions;
import com.amap.api.maps.model.LatLng;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.amap.mapcore.annotations.ParameterIsClass;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@JBindingInclude
/* loaded from: classes.dex */
public class AMapNativeGlOverlayLayer extends NativeBase {
    private NativeFunCallListener nativeFunCallListener;

    @JBindingInclude
    protected long mNative = 0;

    @JBindingInclude
    private int mEngineId = 0;
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public interface NativeFunCallListener {
        void getAMapResource(AMapAppRequestParam aMapAppRequestParam);

        BitmapDescriptor getBuildInImageData(int i3);

        BitmapDescriptor getCustomImageData(ImageOptions imageOptions);

        BitmapDescriptor getInfoContents(String str);

        BitmapDescriptor getInfoWindow(String str);

        BitmapDescriptor getInfoWindowClick(String str);

        long getInfoWindowUpdateOffsetTime(String str);

        BitmapDescriptor getOverturnInfoWindow(String str);

        BitmapDescriptor getOverturnInfoWindowClick(String str);

        void onRedrawInfowindow();

        void onSetRunLowFrame(boolean z5);
    }

    @JBindingInclude
    private void getAMapResource(AMapAppRequestParam aMapAppRequestParam) {
        NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener == null) {
            return;
        }
        nativeFunCallListener.getAMapResource(aMapAppRequestParam);
    }

    @JBindingInclude
    private BitmapDescriptor getBuildInImageData(int i3) {
        NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener != null) {
            return nativeFunCallListener.getBuildInImageData(i3);
        }
        return null;
    }

    @JBindingInclude
    private BitmapDescriptor getImagedData(ImageOptions imageOptions) {
        NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener != null) {
            return nativeFunCallListener.getCustomImageData(imageOptions);
        }
        return null;
    }

    @JBindingInclude
    private BitmapDescriptor getInfoContents(String str) {
        NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener != null) {
            return nativeFunCallListener.getInfoContents(str);
        }
        return null;
    }

    @JBindingInclude
    private BitmapDescriptor getInfoWindow(String str) {
        NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener != null) {
            return nativeFunCallListener.getInfoWindow(str);
        }
        return null;
    }

    @JBindingInclude
    private BitmapDescriptor getInfoWindowClick(String str) {
        NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener != null) {
            return nativeFunCallListener.getInfoWindowClick(str);
        }
        return null;
    }

    @JBindingInclude
    private long getInfoWindowUpdateOffsetTime(String str) {
        NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener != null) {
            return nativeFunCallListener.getInfoWindowUpdateOffsetTime(str);
        }
        return 0L;
    }

    @JBindingInclude
    private BitmapDescriptor getOverturnInfoWindow(String str) {
        NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener != null) {
            return nativeFunCallListener.getOverturnInfoWindow(str);
        }
        return null;
    }

    @JBindingInclude
    private BitmapDescriptor getOverturnInfoWindowClick(String str) {
        NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener != null) {
            return nativeFunCallListener.getOverturnInfoWindowClick(str);
        }
        return null;
    }

    private native void nativeClear(String[] strArr);

    private native String nativeContain(Object obj, int i3);

    private native void nativeCreate(long j4);

    private native void nativeCreateOverlay(String str, Object obj);

    private native void nativeDestroy();

    private native void nativeFinalize();

    private native int nativeGetCurrentParticleNum(String str);

    private native Object nativeGetNativeOverlayProperties(String str, String str2, Object[] objArr);

    private native void nativeGetOverlayBoundRect(String str, Object obj);

    private native void nativeRemoveOverlay(String str);

    private native void nativeRender(int i3, int i10, boolean z5);

    private native void nativeSetAMapEngine(long j4);

    private native void nativeUpdateOptions(String str, Object obj);

    @JBindingInclude
    private void redrawInfoWindow() {
        NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener != null) {
            nativeFunCallListener.onRedrawInfowindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JBindingInclude
    public void setRunLowFrame(boolean z5) {
        NativeFunCallListener nativeFunCallListener = this.nativeFunCallListener;
        if (nativeFunCallListener != null) {
            nativeFunCallListener.onSetRunLowFrame(z5);
        }
    }

    @ParameterIsClass
    public void clear(final String... strArr) {
        if (!isReady()) {
            storeUncallFunctionArray(this, new Runnable() { // from class: com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.3
                @Override // java.lang.Runnable
                public void run() {
                    AMapNativeGlOverlayLayer.this.clear(strArr);
                }
            }, (String[]) strArr.clone(), NativeFunctionRunnable.CLEAR_OVERLAY_FUNC, strArr);
            return;
        }
        callAllFunction();
        try {
            this.readWriteLock.readLock().lock();
            nativeClear(strArr);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    public String contain(LatLng latLng, int i3) {
        if (!isReady()) {
            return "";
        }
        callAllFunction();
        try {
            this.readWriteLock.readLock().lock();
            return nativeContain(latLng, i3);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.NativeBase
    public void createNative() {
    }

    public void createOverlay(final String str, final BaseOptions baseOptions) {
        if (!isReady()) {
            storeUncallFunction(this, new Runnable() { // from class: com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.1
                @Override // java.lang.Runnable
                public void run() {
                    AMapNativeGlOverlayLayer.this.createOverlay(str, baseOptions);
                }
            }, str, NativeFunctionRunnable.CREATE_OVERLAY_FUNC, baseOptions);
            return;
        }
        callAllFunction();
        try {
            this.readWriteLock.readLock().lock();
            nativeCreateOverlay(str, baseOptions);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.NativeBase
    public void destroy() {
        try {
            super.destroy();
            this.readWriteLock.writeLock().lock();
            nativeDestroy();
        } finally {
            this.readWriteLock.writeLock().unlock();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.NativeBase
    public void finalizeNative() {
        nativeFinalize();
    }

    public int getCurrentParticleNum(String str) {
        if (!isReady()) {
            return 0;
        }
        callAllFunction();
        try {
            this.readWriteLock.readLock().lock();
            return nativeGetCurrentParticleNum(str);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    @JBindingInclude
    public int getEngineId() {
        return this.mEngineId;
    }

    @Override // com.autonavi.base.amap.mapcore.NativeBase
    public long getNative() {
        return this.mNative;
    }

    public Object getNativeProperties(final String str, final String str2, final Object[] objArr) {
        if (!isReady() || str == null) {
            storeUncallFunction(this, new Runnable() { // from class: com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.5
                @Override // java.lang.Runnable
                public void run() {
                    AMapNativeGlOverlayLayer.this.getNativeProperties(str, str2, objArr);
                }
            }, str, str2, objArr);
            return null;
        }
        try {
            this.readWriteLock.readLock().lock();
            if (this.destroy) {
                return null;
            }
            return nativeGetNativeOverlayProperties(str, str2, objArr);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    public Rect getOverlayBoundRect(final String str) {
        if (!isReady() || str == null) {
            storeUncallFunction(this, new Runnable() { // from class: com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.6
                @Override // java.lang.Runnable
                public void run() {
                    AMapNativeGlOverlayLayer.this.getOverlayBoundRect(str);
                }
            }, str, NativeFunctionRunnable.GET_OVERLAY_BOUND_RECT, new Object[0]);
            return null;
        }
        try {
            this.readWriteLock.readLock().lock();
            if (this.destroy) {
                return null;
            }
            Rect rect = new Rect();
            nativeGetOverlayBoundRect(str, rect);
            return rect;
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    @ParameterIsClass
    public void removeOverlay(final String str) {
        if (!isReady()) {
            storeUncallFunction(this, new Runnable() { // from class: com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.2
                @Override // java.lang.Runnable
                public void run() {
                    AMapNativeGlOverlayLayer.this.removeOverlay(str);
                }
            }, str, NativeFunctionRunnable.REMOVE_OVERLAY_FUNC, new Object[0]);
            return;
        }
        callAllFunction();
        try {
            this.readWriteLock.readLock().lock();
            nativeRemoveOverlay(str);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    public void render(int i3, int i10, boolean z5) {
        callAllFunction();
        try {
            this.readWriteLock.readLock().lock();
            nativeRender(i3, i10, z5);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    public void setAMapEngine(long j4) {
        try {
            this.readWriteLock.readLock().lock();
            nativeSetAMapEngine(j4);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    @JBindingInclude
    public void setEngineId(int i3) {
        this.mEngineId = i3;
    }

    public void setNativeFunCallListener(NativeFunCallListener nativeFunCallListener) {
        this.nativeFunCallListener = nativeFunCallListener;
    }

    @ParameterIsClass
    public void updateOptions(final String str, final BaseOptions baseOptions) {
        try {
            try {
                if (!isReady()) {
                    storeUncallFunction(this, new Runnable() { // from class: com.autonavi.base.amap.mapcore.AMapNativeGlOverlayLayer.4
                        @Override // java.lang.Runnable
                        public void run() {
                            AMapNativeGlOverlayLayer.this.updateOptions(str, baseOptions);
                            BaseOptions baseOptions2 = baseOptions;
                            if (baseOptions2 != null) {
                                baseOptions2.resetUpdateFlags();
                            }
                            AMapNativeGlOverlayLayer.this.setRunLowFrame(false);
                        }
                    }, str, NativeFunctionRunnable.UPDATE_OPTIONS_FUNC, baseOptions);
                    return;
                }
                callAllFunction();
                try {
                    this.readWriteLock.readLock().lock();
                    nativeUpdateOptions(str, baseOptions);
                    if (baseOptions != null) {
                        baseOptions.resetUpdateFlags();
                    }
                    this.readWriteLock.readLock().unlock();
                } catch (Throwable th2) {
                    this.readWriteLock.readLock().unlock();
                    throw th2;
                }
            } catch (Throwable th3) {
                th = th3;
                Throwable th4 = th;
                th4.printStackTrace();
                Log.d("amapApi", "AMapNativeGlOverlayLayer updateOptions error:" + th4.getMessage());
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public void createNative(long j4) {
        ReentrantReadWriteLock reentrantReadWriteLock;
        try {
            if (this.mNative == 0) {
                try {
                    ReentrantReadWriteLock reentrantReadWriteLock2 = this.readWriteLock;
                    if (reentrantReadWriteLock2 != null) {
                        reentrantReadWriteLock2.writeLock().lock();
                    }
                    nativeCreate(j4);
                    reentrantReadWriteLock = this.readWriteLock;
                } catch (Throwable unused) {
                    reentrantReadWriteLock = this.readWriteLock;
                    if (reentrantReadWriteLock == null) {
                        return;
                    }
                }
                if (reentrantReadWriteLock != null) {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
        } catch (UnsatisfiedLinkError e) {
            e.toString();
        }
    }
}
