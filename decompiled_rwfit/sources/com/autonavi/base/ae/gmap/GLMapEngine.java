package com.autonavi.base.ae.gmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.amap.api.col.p0003sl.g9;
import com.amap.api.col.p0003sl.ka;
import com.amap.api.col.p0003sl.u4;
import com.amap.api.col.p0003sl.v4;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.PoiFilter;
import com.autonavi.amap.api.mapcore.IGLMapEngine;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.base.ae.gmap.bean.InitStorageParam;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFling;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimFlingP20;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimGroup;
import com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.autonavi.base.amap.mapcore.IAMapEngineCallback;
import com.autonavi.base.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.autonavi.base.amap.mapcore.maploader.AMapLoader;
import com.autonavi.base.amap.mapcore.maploader.NetworkState;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;
import com.autonavi.base.amap.mapcore.tools.TextTextureGenerator;
import java.io.File;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@JBindingInclude
/* loaded from: classes.dex */
public class GLMapEngine implements IAMapEngineCallback, IGLMapEngine {
    private static NetworkProxyManager sNetworkProxyManager;
    private Context context;
    private int mEngineID;
    private IAMapDelegate mGlMapView;
    private IAMapListener mMapListener;
    boolean mRequestDestroy;
    private TextTextureGenerator mTextTextureGenerator;
    private AdglMapAnimationMgr mapAnimationMgr;
    GLMapState state;
    private TerrainOverlayProvider terrainTileProvider;
    private long mNativeMapengineInstance = 0;
    private final List<AbstractCameraUpdateMessage> mStateMessageList = new Vector();
    private final List<AbstractGestureMapMessage> mGestureMessageList = new Vector();
    private List<AbstractGestureMapMessage> mGestureEndMessageList = new Vector();
    private final List<AbstractCameraUpdateMessage> mAnimateStateMessageList = new Vector();
    boolean isMoveCameraStep = false;
    boolean isGestureStep = false;
    private int mapGestureCount = 0;
    private GLMapState copyGLMapState = null;
    private Lock mLock = new ReentrantLock();
    private Object mutLock = new Object();
    private NetworkState mNetworkState = null;
    GLOverlayBundle<BaseMapOverlay<?, ?>> bundle = null;
    private boolean isEngineRenderComplete = false;
    boolean isNetworkConnected = false;
    private AtomicInteger mRequestID = new AtomicInteger(1);

    public static class InitParam {
        public String mRootPath = "";
        public String mConfigPath = "";
        public String mConfigContent = "";
        public String mOnlineMapDataPath = "";
        public String mOfflineDataPath = "";
        public String mP3dCrossPath = "";
        public String mIntersectionResPath = "";
    }

    public static class MapViewInitParam {
        public int engineId;
        public int height;
        public float mapZoomScale;
        public int screenHeight;
        public float screenScale;
        public int screenWidth;
        public int taskThreadCount = 8;
        public float textScale;
        public int width;

        /* renamed from: x, reason: collision with root package name */
        public int f6840x;

        /* renamed from: y, reason: collision with root package name */
        public int f6841y;
    }

    public GLMapEngine(Context context, IAMapDelegate iAMapDelegate) {
        this.mGlMapView = null;
        this.mapAnimationMgr = null;
        this.mRequestDestroy = false;
        this.terrainTileProvider = null;
        this.mRequestDestroy = false;
        if (context == null) {
            return;
        }
        this.context = context.getApplicationContext();
        this.mGlMapView = iAMapDelegate;
        this.mTextTextureGenerator = new TextTextureGenerator();
        AdglMapAnimationMgr adglMapAnimationMgr = new AdglMapAnimationMgr();
        this.mapAnimationMgr = adglMapAnimationMgr;
        adglMapAnimationMgr.setMapAnimationListener(new AdglMapAnimationMgr.MapAnimationListener() { // from class: com.autonavi.base.ae.gmap.GLMapEngine.3
            @Override // com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr.MapAnimationListener
            public void onMapAnimationFinish(AMap.CancelableCallback cancelableCallback) {
                GLMapEngine.this.doMapAnimationFinishCallback(cancelableCallback);
            }
        });
        this.terrainTileProvider = new TerrainOverlayProvider(iAMapDelegate.getGlOverlayLayer(), this.context);
        this.mEngineID = GLEngineIDController.getController().generate();
        if (sNetworkProxyManager == null) {
            sNetworkProxyManager = new NetworkProxyManager();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:12|(2:13|14)|(2:16|17)|18|19|(4:24|(1:26)|27|(1:31)(2:29|30))(1:23)) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006b, code lost:
    
        r8.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006f, code lost:
    
        r8.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0074 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private float adapterDpiScale(android.util.DisplayMetrics r8, int r9, int r10, int r11) {
        /*
            r7 = this;
            java.lang.Class<android.util.DisplayMetrics> r0 = android.util.DisplayMetrics.class
            java.lang.String r1 = getEMUI()
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L88
            boolean r3 = r1.isEmpty()
            if (r3 != 0) goto L88
            java.lang.String r3 = "EmotionUI_8"
            int r3 = r1.indexOf(r3)
            r4 = -1
            if (r3 != r4) goto L21
            java.lang.String r3 = "EmotionUI_9"
            int r1 = r1.indexOf(r3)
            if (r1 == r4) goto L88
        L21:
            if (r11 <= 0) goto L88
            r1 = 1
            r3 = 0
            java.lang.String r4 = "noncompatWidthPixels"
            java.lang.reflect.Field r4 = r0.getDeclaredField(r4)     // Catch: java.lang.IllegalAccessException -> L33 java.lang.NoSuchFieldException -> L35
            r4.setAccessible(r1)     // Catch: java.lang.IllegalAccessException -> L33 java.lang.NoSuchFieldException -> L35
            int r4 = r4.getInt(r8)     // Catch: java.lang.IllegalAccessException -> L33 java.lang.NoSuchFieldException -> L35
            goto L3f
        L33:
            r4 = move-exception
            goto L37
        L35:
            r4 = move-exception
            goto L3b
        L37:
            r4.printStackTrace()
            goto L3e
        L3b:
            r4.printStackTrace()
        L3e:
            r4 = r3
        L3f:
            java.lang.String r5 = "noncompatHeightPixels"
            java.lang.reflect.Field r5 = r0.getDeclaredField(r5)     // Catch: java.lang.IllegalAccessException -> L4d java.lang.NoSuchFieldException -> L4f
            r5.setAccessible(r1)     // Catch: java.lang.IllegalAccessException -> L4d java.lang.NoSuchFieldException -> L4f
            int r5 = r5.getInt(r8)     // Catch: java.lang.IllegalAccessException -> L4d java.lang.NoSuchFieldException -> L4f
            goto L59
        L4d:
            r5 = move-exception
            goto L51
        L4f:
            r5 = move-exception
            goto L55
        L51:
            r5.printStackTrace()
            goto L58
        L55:
            r5.printStackTrace()
        L58:
            r5 = r3
        L59:
            java.lang.String r6 = "noncompatDensityDpi"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r6)     // Catch: java.lang.IllegalAccessException -> L67 java.lang.NoSuchFieldException -> L69
            r0.setAccessible(r1)     // Catch: java.lang.IllegalAccessException -> L67 java.lang.NoSuchFieldException -> L69
            int r3 = r0.getInt(r8)     // Catch: java.lang.IllegalAccessException -> L67 java.lang.NoSuchFieldException -> L69
            goto L72
        L67:
            r8 = move-exception
            goto L6b
        L69:
            r8 = move-exception
            goto L6f
        L6b:
            r8.printStackTrace()
            goto L72
        L6f:
            r8.printStackTrace()
        L72:
            if (r3 > r11) goto L78
            if (r4 > r9) goto L78
            if (r5 <= r10) goto L88
        L78:
            float r8 = (float) r3
            float r9 = (float) r11
            float r8 = r8 / r9
            r9 = 1073741824(0x40000000, float:2.0)
            int r10 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r10 <= 0) goto L82
            r8 = r9
        L82:
            int r9 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r9 >= 0) goto L87
            goto L88
        L87:
            r2 = r8
        L88:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.GLMapEngine.adapterDpiScale(android.util.DisplayMetrics, int, int, int):float");
    }

    private void doMapAnimationCancelCallback(final AMap.CancelableCallback cancelableCallback) {
        IAMapDelegate iAMapDelegate;
        if (cancelableCallback == null || (iAMapDelegate = this.mGlMapView) == null) {
            return;
        }
        iAMapDelegate.getMainHandler().post(new Runnable() { // from class: com.autonavi.base.ae.gmap.GLMapEngine.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cancelableCallback.onCancel();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doMapAnimationFinishCallback(final AMap.CancelableCallback cancelableCallback) {
        IAMapDelegate iAMapDelegate;
        IAMapListener iAMapListener = this.mMapListener;
        if (iAMapListener != null) {
            iAMapListener.afterAnimation();
        }
        if (cancelableCallback == null || (iAMapDelegate = this.mGlMapView) == null) {
            return;
        }
        iAMapDelegate.getMainHandler().post(new Runnable() { // from class: com.autonavi.base.ae.gmap.GLMapEngine.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cancelableCallback.onFinish();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
    }

    private void gestureBegin() {
        this.mapGestureCount++;
    }

    private void gestureEnd() {
        int i3 = this.mapGestureCount - 1;
        this.mapGestureCount = i3;
        if (i3 == 0) {
            recycleMessage();
        }
    }

    private static String getEMUI() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void initAnimation() {
        AbstractCameraUpdateMessage remove;
        if (this.mStateMessageList.size() > 0) {
            return;
        }
        synchronized (this.mAnimateStateMessageList) {
            try {
                remove = this.mAnimateStateMessageList.size() > 0 ? this.mAnimateStateMessageList.remove(0) : null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (remove != null) {
            remove.generateMapAnimation(this);
        }
    }

    public static native void nativeAddGestureSingleTapMessage(int i3, long j4, float f2, float f10);

    public static native String nativeAddNativeOverlay(int i3, long j4, int i10, int i11);

    private static native boolean nativeAddOverlayTexture(int i3, long j4, int i10, int i11, float f2, float f10, Bitmap bitmap, boolean z5, boolean z6);

    private static native void nativeAddPoiFilter(int i3, long j4, PoiFilter poiFilter);

    private static native void nativeCancelDownLoad(long j4);

    private static native boolean nativeCheckCustomStyleData(int i3, long j4, byte[] bArr);

    private static native void nativeClearPoiFilter(int i3, long j4);

    private static native void nativeCreateAMapEngineWithFrame(long j4, int i3, int i10, int i11, int i12, int i13, int i14, int i15, float f2, float f10, float f11, int i16);

    private static native long nativeCreateAMapInstance(float f2, float f10, float f11, int i3, boolean z5);

    public static native long nativeCreateOverlay(int i3, long j4, int i10);

    private static native int nativeCreateTextureFromImage(int i3, long j4, Bitmap bitmap);

    private static native void nativeDestroy(long j4);

    private static native void nativeDestroyCurrentState(long j4, long j10);

    public static native void nativeDestroyOverlay(int i3, long j4);

    private static native void nativeFailedDownLoad(long j4, int i3);

    private static native void nativeFinishDownLoad(long j4);

    private static native void nativeGetCurTileIDs(int i3, long j4, int[] iArr, int i10);

    private static native long nativeGetCurrentMapState(int i3, long j4);

    private static native long nativeGetGlOverlayMgrPtr(int i3, long j4);

    public static native String nativeGetMapEngineVersion(int i3);

    private static native int[] nativeGetMapModeState(int i3, long j4, boolean z5);

    public static native String nativeGetMapSDKDeps();

    public static native String nativeGetMapSDKVersion();

    public static native long nativeGetNativeMapController(int i3, long j4);

    public static native int[] nativeGetScreenShot(int i3, long j4, int i10, int i11, int i12, int i13);

    private static native boolean nativeGetSrvViewStateBoolValue(int i3, long j4, int i10);

    public static native int nativeHideBuildings(int i3, long j4, LatLng[] latLngArr);

    private static native void nativeInitAMapEngineCallback(long j4, Object obj);

    private static native void nativeInitContourLineOptions(long j4, boolean z5);

    private static native void nativeInitOpenLayer(int i3, long j4, byte[] bArr);

    private static native void nativeInitParam(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i3, int i10);

    private static native boolean nativeIsEngineCreated(long j4, int i3);

    public static native void nativeMainThreadTrigger(int i3, long j4);

    private static native void nativePopRenderState(int i3, long j4);

    private static native void nativePostRenderAMap(long j4, int i3);

    private static native void nativePushRendererState(int i3, long j4);

    private static native void nativeReceiveNetData(byte[] bArr, long j4, int i3);

    public static native void nativeRemoveNativeAllOverlay(int i3, long j4);

    public static native void nativeRemoveNativeOverlay(int i3, long j4, String str);

    private static native void nativeRemovePoiFilter(int i3, long j4, String str);

    private static native void nativeRenderAMap(long j4, int i3);

    private static native void nativeSetAllContentEnable(int i3, long j4, boolean z5);

    private static native void nativeSetBuildingEnable(int i3, long j4, boolean z5);

    private static native void nativeSetBuildingTextureEnable(int i3, long j4, boolean z5);

    public static native void nativeSetCurrentLocation(int i3, long j4, LatLng latLng);

    private static native void nativeSetCustomStyleData(int i3, long j4, byte[] bArr, byte[] bArr2);

    private static native void nativeSetCustomStyleTexture(int i3, long j4, byte[] bArr);

    private static native void nativeSetCustomThirdLayerStyle(int i3, long j4, String str);

    private static native void nativeSetHighlightSubwayEnable(int i3, long j4, boolean z5);

    private static native void nativeSetIndoorBuildingToBeActive(int i3, long j4, String str, int i10, String str2);

    private static native void nativeSetIndoorEnable(int i3, long j4, boolean z5);

    private static native void nativeSetLabelEnable(int i3, long j4, boolean z5);

    private static native boolean nativeSetMapModeAndStyle(int i3, long j4, int[] iArr);

    private static native void nativeSetMapOptRecordState(int i3, long j4, boolean z5);

    private static native void nativeSetNaviLabelEnable(int i3, long j4, boolean z5, int i10, int i11);

    private static native void nativeSetNetStatus(long j4, int i3);

    private static native void nativeSetOfflineDataEnable(int i3, long j4, boolean z5);

    private static native void nativeSetOpenLayerEnable(int i3, long j4, boolean z5);

    private static native void nativeSetParameter(int i3, long j4, int i10, int i11, int i12, int i13, int i14);

    private static native void nativeSetProjectionCenter(int i3, long j4, float f2, float f10);

    public static native void nativeSetRenderFlags(int i3, long j4, boolean z5);

    private static native void nativeSetRenderListenerStatus(int i3, long j4);

    private static native void nativeSetRoadArrowEnable(int i3, long j4, boolean z5);

    private static native void nativeSetServiceViewRect(int i3, long j4, int i10, int i11, int i12, int i13, int i14, int i15);

    private static native void nativeSetSetBackgroundTexture(int i3, long j4, byte[] bArr);

    private static native void nativeSetSimple3DEnable(int i3, long j4, boolean z5);

    private static native void nativeSetSkyTexture(int i3, long j4, byte[] bArr);

    private static native void nativeSetSrvViewStateBoolValue(int i3, long j4, int i10, boolean z5);

    private static native void nativeSetStyleChangeGradualEnable(int i3, long j4, boolean z5);

    public static native void nativeSetTerrainAuth(int i3, long j4, boolean z5);

    private static native void nativeSetTrafficEnable(int i3, long j4, boolean z5);

    private static native void nativeSetTrafficTexture(int i3, long j4, byte[] bArr, long j10, int i10, int i11, int i12, int i13, int i14);

    private static native void nativeSetTrafficTextureAllInOne(int i3, long j4, byte[] bArr);

    public static native void nativeSetVectorOverlayPath(int i3, long j4, String str);

    public static native void nativeShowHideBuildings(int i3, long j4, int i10);

    public static native void nativeSwitchLanguage(int i3, long j4, String str);

    public static native void nativeUpdateNativeArrowOverlay(int i3, long j4, String str, int[] iArr, int[] iArr2, int i10, int i11, int i12, float f2, boolean z5, int i13, int i14, int i15);

    private boolean processAnimations(GLMapState gLMapState) {
        try {
            if (this.mapAnimationMgr.getAnimationsCount() <= 0) {
                return false;
            }
            gLMapState.recalculate();
            this.mapAnimationMgr.doAnimations(gLMapState);
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        if (r3.width != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
    
        r3.width = r5.mGlMapView.getMapWidth();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
    
        if (r3.height != 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
    
        r3.height = r5.mGlMapView.getMapHeight();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
    
        r2 = r3.getMapGestureState();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        if (r2 != 100) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        gestureBegin();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0063, code lost:
    
        if (r2 != 101) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
    
        r3.runCameraUpdate(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006b, code lost:
    
        if (r2 != 102) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006d, code lost:
    
        gestureEnd();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean processGestureMessage(com.autonavi.base.ae.gmap.GLMapState r6) {
        /*
            r5 = this;
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r0 = r5.mGestureMessageList
            int r0 = r0.size()
            r1 = 0
            if (r0 > 0) goto L10
            boolean r6 = r5.isGestureStep
            if (r6 == 0) goto Lf
            r5.isGestureStep = r1
        Lf:
            return r1
        L10:
            r0 = 1
            r5.isGestureStep = r0
            if (r6 != 0) goto L16
            return r1
        L16:
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r2 = r5.mGestureMessageList
            monitor-enter(r2)
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r3 = r5.mGestureMessageList     // Catch: java.lang.Throwable -> L2a
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L2a
            if (r3 <= 0) goto L2c
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r3 = r5.mGestureMessageList     // Catch: java.lang.Throwable -> L2a
            java.lang.Object r3 = r3.remove(r1)     // Catch: java.lang.Throwable -> L2a
            com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage r3 = (com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage) r3     // Catch: java.lang.Throwable -> L2a
            goto L2d
        L2a:
            r6 = move-exception
            goto L76
        L2c:
            r3 = 0
        L2d:
            if (r3 != 0) goto L3c
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r6 = r5.mGestureEndMessageList
            int r6 = r6.size()
            if (r6 < r0) goto L3b
            r5.recycleMessage()
        L3b:
            return r0
        L3c:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
            int r2 = r3.width
            if (r2 != 0) goto L49
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r2 = r5.mGlMapView
            int r2 = r2.getMapWidth()
            r3.width = r2
        L49:
            int r2 = r3.height
            if (r2 != 0) goto L55
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r2 = r5.mGlMapView
            int r2 = r2.getMapHeight()
            r3.height = r2
        L55:
            int r2 = r3.getMapGestureState()
            r4 = 100
            if (r2 != r4) goto L61
            r5.gestureBegin()
            goto L70
        L61:
            r4 = 101(0x65, float:1.42E-43)
            if (r2 != r4) goto L69
            r3.runCameraUpdate(r6)
            goto L70
        L69:
            r4 = 102(0x66, float:1.43E-43)
            if (r2 != r4) goto L70
            r5.gestureEnd()
        L70:
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r2 = r5.mGestureEndMessageList
            r2.add(r3)
            goto L16
        L76:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.GLMapEngine.processGestureMessage(com.autonavi.base.ae.gmap.GLMapState):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
    
        r1.setCameraDegree(com.amap.api.col.p0003sl.v4.a(r6.mGlMapView.getMapConfig(), r1.getCameraDegree(), r1.getMapZoomer()));
        setMapState(r6.mEngineID, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean processMessage() {
        /*
            r6 = this;
            r0 = 0
            int r1 = r6.mEngineID     // Catch: java.lang.Exception -> L21
            com.autonavi.amap.api.mapcore.IGLMapState r1 = r6.getNewMapState(r1)     // Catch: java.lang.Exception -> L21
            com.autonavi.base.ae.gmap.GLMapState r1 = (com.autonavi.base.ae.gmap.GLMapState) r1     // Catch: java.lang.Exception -> L21
            boolean r2 = r6.processGestureMessage(r1)     // Catch: java.lang.Exception -> L21
            java.util.List<com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage> r3 = r6.mGestureMessageList     // Catch: java.lang.Exception -> L21
            int r3 = r3.size()     // Catch: java.lang.Exception -> L21
            r4 = 1
            if (r3 > 0) goto L25
            if (r2 != 0) goto L23
            boolean r2 = r6.processStateMapMessage(r1)     // Catch: java.lang.Exception -> L21
            if (r2 == 0) goto L1f
            goto L23
        L1f:
            r2 = r0
            goto L39
        L21:
            r1 = move-exception
            goto L65
        L23:
            r2 = r4
            goto L39
        L25:
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r3 = r6.mStateMessageList     // Catch: java.lang.Exception -> L21
            monitor-enter(r3)     // Catch: java.lang.Exception -> L21
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r5 = r6.mStateMessageList     // Catch: java.lang.Throwable -> L36
            int r5 = r5.size()     // Catch: java.lang.Throwable -> L36
            if (r5 <= 0) goto L38
            java.util.List<com.autonavi.amap.mapcore.AbstractCameraUpdateMessage> r5 = r6.mStateMessageList     // Catch: java.lang.Throwable -> L36
            r5.clear()     // Catch: java.lang.Throwable -> L36
            goto L38
        L36:
            r1 = move-exception
            goto L63
        L38:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L36
        L39:
            if (r2 != 0) goto L43
            boolean r2 = r6.processAnimations(r1)     // Catch: java.lang.Exception -> L21
            if (r2 == 0) goto L42
            goto L43
        L42:
            r4 = r0
        L43:
            if (r4 == 0) goto L5f
            float r2 = r1.getCameraDegree()     // Catch: java.lang.Exception -> L21
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r3 = r6.mGlMapView     // Catch: java.lang.Exception -> L21
            com.autonavi.base.amap.mapcore.MapConfig r3 = r3.getMapConfig()     // Catch: java.lang.Exception -> L21
            float r5 = r1.getMapZoomer()     // Catch: java.lang.Exception -> L21
            float r2 = com.amap.api.col.p0003sl.v4.a(r3, r2, r5)     // Catch: java.lang.Exception -> L21
            r1.setCameraDegree(r2)     // Catch: java.lang.Exception -> L21
            int r2 = r6.mEngineID     // Catch: java.lang.Exception -> L21
            r6.setMapState(r2, r1)     // Catch: java.lang.Exception -> L21
        L5f:
            r1.recycle()     // Catch: java.lang.Exception -> L21
            return r4
        L63:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L36
            throw r1     // Catch: java.lang.Exception -> L21
        L65:
            r1.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.GLMapEngine.processMessage():boolean");
    }

    private boolean processStateMapMessage(GLMapState gLMapState) {
        AbstractCameraUpdateMessage remove;
        if (this.mStateMessageList.size() <= 0) {
            if (this.isMoveCameraStep) {
                this.isMoveCameraStep = false;
            }
            return false;
        }
        this.isMoveCameraStep = true;
        if (gLMapState == null) {
            return false;
        }
        while (true) {
            synchronized (this.mStateMessageList) {
                try {
                    remove = this.mStateMessageList.size() > 0 ? this.mStateMessageList.remove(0) : null;
                    if (remove == null) {
                        return true;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (remove.width == 0) {
                remove.width = this.mGlMapView.getMapWidth();
            }
            if (remove.height == 0) {
                remove.height = this.mGlMapView.getMapHeight();
            }
            gLMapState.recalculate();
            remove.runCameraUpdate(gLMapState);
        }
    }

    private void recycleMessage() {
        AbstractGestureMapMessage remove;
        while (this.mGestureEndMessageList.size() > 0 && (remove = this.mGestureEndMessageList.remove(0)) != null) {
            if (remove instanceof MoveGestureMapMessage) {
                ((MoveGestureMapMessage) remove).recycle();
            } else if (remove instanceof HoverGestureMapMessage) {
                ((HoverGestureMapMessage) remove).recycle();
            } else if (remove instanceof RotateGestureMapMessage) {
                ((RotateGestureMapMessage) remove).recycle();
            } else if (remove instanceof ScaleGestureMapMessage) {
                ((ScaleGestureMapMessage) remove).recycle();
            }
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void OnIndoorBuildingActivity(int i3, byte[] bArr) {
        IAMapDelegate iAMapDelegate = this.mGlMapView;
        if (iAMapDelegate != null) {
            try {
                iAMapDelegate.onIndoorBuildingActivity(i3, bArr);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public void addGestureMessage(int i3, AbstractGestureMapMessage abstractGestureMapMessage, boolean z5, int i10, int i11) {
        if (abstractGestureMapMessage == null) {
            return;
        }
        abstractGestureMapMessage.isGestureScaleByMapCenter = z5;
        synchronized (this.mGestureMessageList) {
            this.mGestureMessageList.add(abstractGestureMapMessage);
        }
    }

    public void addGestureSingleTapMessage(float f2, float f10) {
        nativeAddGestureSingleTapMessage(this.mEngineID, this.mNativeMapengineInstance, f2, f10);
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapEngine
    public void addGroupAnimation(int i3, int i10, float f2, int i11, int i12, int i13, int i14, AMap.CancelableCallback cancelableCallback) {
        AdglMapAnimGroup adglMapAnimGroup = new AdglMapAnimGroup(i10);
        adglMapAnimGroup.setToCameraDegree(i12, 0);
        adglMapAnimGroup.setToMapAngle(i11, 0);
        adglMapAnimGroup.setToMapLevel(f2, 0);
        adglMapAnimGroup.setToMapCenterGeo(i13, i14, 0);
        if (this.mapAnimationMgr == null || !adglMapAnimGroup.isValid()) {
            return;
        }
        this.mapAnimationMgr.addAnimation(adglMapAnimGroup, cancelableCallback);
    }

    public void addMessage(AbstractCameraUpdateMessage abstractCameraUpdateMessage, boolean z5) {
        if (!z5) {
            synchronized (this.mStateMessageList) {
                this.mStateMessageList.add(abstractCameraUpdateMessage);
            }
        } else {
            synchronized (this.mAnimateStateMessageList) {
                this.mAnimateStateMessageList.clear();
                this.mAnimateStateMessageList.add(abstractCameraUpdateMessage);
            }
        }
    }

    public String addNativeOverlay(int i3, int i10, int i11) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return null;
        }
        String nativeAddNativeOverlay = nativeAddNativeOverlay(i3, j4, i10, i11);
        if (TextUtils.isEmpty(nativeAddNativeOverlay)) {
            return null;
        }
        return nativeAddNativeOverlay;
    }

    public void addOverlayTexture(int i3, GLTextureProperty gLTextureProperty) {
        Bitmap bitmap;
        if (this.mNativeMapengineInstance == 0 || gLTextureProperty == null || (bitmap = gLTextureProperty.mBitmap) == null || bitmap.isRecycled()) {
            return;
        }
        nativeAddOverlayTexture(i3, this.mNativeMapengineInstance, gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap, gLTextureProperty.isGenMimps, gLTextureProperty.isRepeat);
    }

    public void addPoiFilter(PoiFilter poiFilter) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return;
        }
        nativeAddPoiFilter(this.mEngineID, j4, poiFilter);
    }

    public boolean canStopMapRender(int i3) {
        return this.isEngineRenderComplete;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void cancelRequireMapData(Object obj) {
        if (obj == null || !(obj instanceof AMapLoader)) {
            return;
        }
        ((AMapLoader) obj).doCancel();
    }

    public void changeSurface(int i3, int i10) {
    }

    public boolean checkCustomStyleData(int i3, byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return false;
        }
        return nativeCheckCustomStyleData(i3, j4, bArr);
    }

    public void clearAllMessages(int i3) {
    }

    public void clearAnimations(int i3, boolean z5) {
        this.mapAnimationMgr.clearAnimations();
    }

    public void clearPoiFilter() {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return;
        }
        nativeClearPoiFilter(this.mEngineID, j4);
    }

    public void createAMapEngineWithFrame(MapViewInitParam mapViewInitParam) {
        if (this.mNativeMapengineInstance != 0) {
            synchronized (GLMapEngine.class) {
                nativeCreateAMapEngineWithFrame(this.mNativeMapengineInstance, mapViewInitParam.engineId, mapViewInitParam.f6840x, mapViewInitParam.f6841y, mapViewInitParam.width, mapViewInitParam.height, mapViewInitParam.screenWidth, mapViewInitParam.screenHeight, mapViewInitParam.screenScale, mapViewInitParam.textScale, mapViewInitParam.mapZoomScale, mapViewInitParam.taskThreadCount);
            }
            if (this.mGlMapView.getMapConfig().isTerrainEnable()) {
                setCustomStyleData(mapViewInitParam.engineId, FileUtil.uncompressToByteArray(FileUtil.readFileContentsFromAssets(this.context, "map_assets/style_1_17_for_terrain.data")), null);
            }
        }
    }

    public boolean createAMapInstance(InitParam initParam, float f2) {
        if (initParam == null) {
            return false;
        }
        synchronized (GLMapEngine.class) {
            try {
                g9 b3 = g9.b(this.context);
                String str = "http://" + b3.a(21) + "/";
                String str2 = "http://" + b3.a(23);
                String str3 = "http://" + b3.a(20) + "/";
                String str4 = "http://" + b3.a(24) + "/";
                String str5 = "http://" + b3.a(25) + "/";
                DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
                int i3 = displayMetrics.densityDpi;
                float f10 = displayMetrics.density;
                float adapterDpiScale = adapterDpiScale(displayMetrics, displayMetrics.widthPixels, displayMetrics.heightPixels, i3);
                this.mGlMapView.getMapConfig().setTerrainEnable(MapsInitializer.isTerrainEnable());
                boolean isTerrainEnable = MapsInitializer.isTerrainEnable();
                nativeInitParam(initParam.mRootPath, initParam.mConfigContent, initParam.mOnlineMapDataPath, initParam.mOfflineDataPath, initParam.mP3dCrossPath, str, str2, str3, str4, str5, i3, MapsInitializer.getRegionLanguageType());
                InitStorageParam.Holder.initPath(initParam.mP3dCrossPath);
                if (f2 != 0.0f) {
                    this.mNativeMapengineInstance = nativeCreateAMapInstance((int) (160.0f * f2), f2, adapterDpiScale, isTerrainEnable ? 1 : 0, this.mGlMapView.isUseForNavi());
                } else {
                    this.mNativeMapengineInstance = nativeCreateAMapInstance(i3, f10, adapterDpiScale, isTerrainEnable ? 1 : 0, this.mGlMapView.isUseForNavi());
                }
                if (this.mNativeMapengineInstance == 0) {
                    return false;
                }
                if (MapsInitializer.isTerrainEnable()) {
                    nativeInitContourLineOptions(this.mNativeMapengineInstance, MapsInitializer.isContourLineEnable());
                }
                nativeInitAMapEngineCallback(this.mNativeMapengineInstance, this);
                if (!sNetworkProxyManager.isReady()) {
                    sNetworkProxyManager.initContext(this.context);
                    sNetworkProxyManager.init();
                }
                sNetworkProxyManager.notifyMapEngineCreated(this.mEngineID, this, this.mGlMapView);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public long createOverlay(int i3, int i10) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            return nativeCreateOverlay(i3, j4, i10);
        }
        return 0L;
    }

    public int createOverlayTexture(int i3, Bitmap bitmap) {
        if (this.mNativeMapengineInstance == 0 || bitmap == null || bitmap.isRecycled()) {
            return -1;
        }
        return nativeCreateTextureFromImage(i3, this.mNativeMapengineInstance, bitmap);
    }

    public void destroyAMapEngine() {
        try {
            this.mRequestDestroy = true;
            synchronized (this.mutLock) {
                try {
                    if (this.mNativeMapengineInstance != 0) {
                        this.mLock.lock();
                        try {
                            GLMapState gLMapState = this.copyGLMapState;
                            if (gLMapState != null) {
                                gLMapState.recycle();
                            }
                            this.mLock.unlock();
                            nativeDestroyCurrentState(this.mNativeMapengineInstance, this.state.getNativeInstance());
                            nativeDestroy(this.mNativeMapengineInstance);
                        } catch (Throwable th2) {
                            this.mLock.unlock();
                            throw th2;
                        }
                    }
                    this.mNativeMapengineInstance = 0L;
                    sNetworkProxyManager.notifyMapEngineDestroyed(this.mEngineID);
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            this.mGlMapView = null;
            synchronized (this.mStateMessageList) {
                this.mStateMessageList.clear();
            }
            synchronized (this.mAnimateStateMessageList) {
                this.mAnimateStateMessageList.clear();
            }
            synchronized (this.mGestureMessageList) {
                this.mGestureMessageList.clear();
            }
            this.mGestureEndMessageList.clear();
            this.mMapListener = null;
            this.bundle = null;
            u4.a();
        } catch (Throwable th4) {
            th4.printStackTrace();
            v4.a(th4);
        }
    }

    public void destroyOverlay(int i3, long j4) {
        synchronized (GLMapEngine.class) {
            nativeDestroyOverlay(i3, j4);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public int generateRequestId() {
        return this.mRequestID.incrementAndGet();
    }

    public int getAnimateionsCount() {
        if (this.mNativeMapengineInstance != 0) {
            return this.mapAnimationMgr.getAnimationsCount();
        }
        return 0;
    }

    public GLMapState getCloneMapState() {
        this.mLock.lock();
        try {
            long j4 = this.mNativeMapengineInstance;
            if (j4 != 0) {
                if (this.copyGLMapState == null) {
                    this.copyGLMapState = new GLMapState(this.mEngineID, j4);
                }
                this.copyGLMapState.setMapZoomer(this.mGlMapView.getMapConfig().getSZ());
                this.copyGLMapState.setCameraDegree(this.mGlMapView.getMapConfig().getSC());
                this.copyGLMapState.setMapAngle(this.mGlMapView.getMapConfig().getSR());
                this.copyGLMapState.setMapGeoCenter(this.mGlMapView.getMapConfig().getSX(), this.mGlMapView.getMapConfig().getSY());
            }
            this.mLock.unlock();
            return this.copyGLMapState;
        } catch (Throwable th2) {
            this.mLock.unlock();
            throw th2;
        }
    }

    public Context getContext() {
        return this.context;
    }

    public void getCurTileIDs(int i3, int[] iArr) {
        if (iArr != null) {
            for (int i10 = 0; i10 < iArr.length; i10++) {
                iArr[i10] = 0;
            }
            nativeGetCurTileIDs(i3, this.mNativeMapengineInstance, iArr, iArr.length);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public BitmapDescriptor getDefaultTerrainImage() {
        return this.terrainTileProvider.getDefaultTerrain();
    }

    public int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        return this.mEngineID;
    }

    public int getEngineIDWithType(int i3) {
        return this.mEngineID;
    }

    public long getGlOverlayMgrPtr(int i3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            return nativeGetGlOverlayMgrPtr(i3, j4);
        }
        return 0L;
    }

    public boolean getIsProcessBuildingMark(int i3) {
        return false;
    }

    public int[] getMapModeState(int i3, boolean z5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return null;
        }
        nativeGetMapModeState(i3, j4, z5);
        return null;
    }

    public GLMapState getMapState(int i3) {
        this.mLock.lock();
        try {
            long j4 = this.mNativeMapengineInstance;
            if (j4 != 0 && this.state == null) {
                long nativeGetCurrentMapState = nativeGetCurrentMapState(i3, j4);
                if (nativeGetCurrentMapState != 0) {
                    this.state = new GLMapState(i3, this.mNativeMapengineInstance, nativeGetCurrentMapState);
                }
            }
            this.mLock.unlock();
            return this.state;
        } catch (Throwable th2) {
            this.mLock.unlock();
            throw th2;
        }
    }

    public long getMapStateInstance(int i3) {
        return 0L;
    }

    public long getNativeInstance() {
        return this.mNativeMapengineInstance;
    }

    public long getNativeMapController(int i3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            return nativeGetNativeMapController(i3, j4);
        }
        return 0L;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapEngine
    public IGLMapState getNewMapState(int i3) {
        this.mLock.lock();
        try {
            long j4 = this.mNativeMapengineInstance;
            if (j4 != 0) {
                return new GLMapState(i3, j4);
            }
            this.mLock.unlock();
            return null;
        } finally {
            this.mLock.unlock();
        }
    }

    public GLOverlayBundle getOverlayBundle(int i3) {
        return this.bundle;
    }

    public Bitmap getScreenShot(int i3, int i10, int i11, int i12, int i13) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            return v4.a(nativeGetScreenShot(i3, j4, i10, i11, i12, i13), i12 - i10, i13 - i11, true);
        }
        return null;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public List<BitmapDescriptor> getSkyBoxImages() {
        return this.terrainTileProvider.getSkyBoxImages();
    }

    public boolean getSrvViewStateBoolValue(int i3, int i10) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            return nativeGetSrvViewStateBoolValue(i3, j4, i10);
        }
        return false;
    }

    public AbstractCameraUpdateMessage getStateMessage() {
        synchronized (this.mStateMessageList) {
            try {
                if (this.mStateMessageList.size() == 0) {
                    return null;
                }
                return this.mStateMessageList.remove(0);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int getStateMessageCount() {
        return this.mStateMessageList.size();
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public InitStorageParam getStorageInitParam() {
        return InitStorageParam.obtain();
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public TileProviderInner getTerrainTileProvider() {
        return this.terrainTileProvider.getTileProvider();
    }

    public int hideBuildings(List<LatLng> list) {
        if (this.mNativeMapengineInstance == 0) {
            return -1;
        }
        LatLng[] latLngArr = new LatLng[list.size()];
        list.toArray(latLngArr);
        return nativeHideBuildings(this.mEngineID, this.mNativeMapengineInstance, latLngArr);
    }

    public void initMapOpenLayer(String str) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0 || str == null) {
            return;
        }
        nativeInitOpenLayer(this.mEngineID, j4, str.getBytes());
    }

    public void initNativeTexture(int i3) {
        try {
            BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_inner.png");
            Bitmap bitmap = fromAsset != null ? fromAsset.getBitmap() : null;
            BitmapDescriptor fromAsset2 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_outer.png");
            Bitmap bitmap2 = fromAsset2 != null ? fromAsset2.getBitmap() : null;
            BitmapDescriptor fromAsset3 = BitmapDescriptorFactory.fromAsset("arrow/arrow_line_shadow.png");
            Bitmap bitmap3 = fromAsset3 != null ? fromAsset3.getBitmap() : null;
            addOverlayTexture(i3, bitmap, AMapEngineUtils.ARROW_LINE_INNER_TEXTURE_ID, 4);
            addOverlayTexture(i3, bitmap2, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 4);
            addOverlayTexture(i3, bitmap3, AMapEngineUtils.ARROW_LINE_SHADOW_TEXTURE_ID, 4);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void interruptAnimation() {
        if (isInMapAnimation(this.mEngineID)) {
            try {
                doMapAnimationCancelCallback(this.mapAnimationMgr.getCancelCallback());
                clearAnimations(this.mEngineID, false);
            } catch (Throwable th2) {
                ka.a(th2, getClass().getName(), "CancelableCallback.onCancel");
                th2.printStackTrace();
            }
        }
    }

    public boolean isEngineCreated(int i3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            return nativeIsEngineCreated(j4, i3);
        }
        return false;
    }

    public boolean isInMapAction(int i3) {
        return false;
    }

    public boolean isInMapAnimation(int i3) {
        return getAnimateionsCount() > 0;
    }

    public boolean isNetworkConnected() {
        return this.isNetworkConnected;
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam) {
        IAMapDelegate iAMapDelegate = this.mGlMapView;
        if (iAMapDelegate != null) {
            iAMapDelegate.onAMapAppResourceRequest(aMapAppRequestParam);
        }
    }

    public void onClearCache(int i3) {
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onMapBlandClick(double d5, double d8) {
        IAMapListener iAMapListener = this.mMapListener;
        if (iAMapListener != null) {
            iAMapListener.onMapBlankClick(d5, d8);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onMapPOIClick(MapPoi mapPoi) {
        IAMapListener iAMapListener = this.mMapListener;
        if (iAMapListener != null) {
            iAMapListener.onMapPOIClick(mapPoi);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public void onMapRender(int i3, int i10) {
        IAMapListener iAMapListener;
        try {
            if (i10 == 13) {
                this.isEngineRenderComplete = true;
                return;
            }
            if (i10 == 5) {
                IAMapListener iAMapListener2 = this.mMapListener;
                if (iAMapListener2 != null) {
                    iAMapListener2.beforeDrawLabel(i3, getMapState(i3));
                    return;
                }
                return;
            }
            if (i10 != 6) {
                if (i10 == 7 && (iAMapListener = this.mMapListener) != null) {
                    iAMapListener.afterRendererOver(i3, getMapState(i3));
                    return;
                }
                return;
            }
            IAMapListener iAMapListener3 = this.mMapListener;
            if (iAMapListener3 != null) {
                iAMapListener3.afterDrawLabel(i3, getMapState(i3));
            }
        } catch (Throwable unused) {
        }
    }

    public void popRendererState() {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativePopRenderState(this.mEngineID, j4);
        }
    }

    public void pushRendererState() {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativePushRendererState(this.mEngineID, j4);
        }
    }

    public void putResourceData(int i3, byte[] bArr) {
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void reloadMapResource(int i3, String str, int i10) {
    }

    public void removeNativeAllOverlay(int i3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeRemoveNativeAllOverlay(i3, j4);
        }
    }

    public void removeNativeOverlay(int i3, String str) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0 || str == null) {
            return;
        }
        nativeRemoveNativeOverlay(i3, j4, str);
    }

    public void removePoiFilter(String str) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return;
        }
        nativeRemovePoiFilter(this.mEngineID, j4, str);
    }

    public void renderAMap() {
        if (this.mNativeMapengineInstance != 0) {
            boolean processMessage = processMessage();
            synchronized (GLMapEngine.class) {
                nativeRenderAMap(this.mNativeMapengineInstance, this.mEngineID);
                nativePostRenderAMap(this.mNativeMapengineInstance, this.mEngineID);
            }
            initAnimation();
            if (processMessage) {
                startCheckEngineRenderComplete();
            }
            if (this.isEngineRenderComplete) {
                return;
            }
            nativeSetRenderListenerStatus(this.mEngineID, this.mNativeMapengineInstance);
        }
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public byte[] requireCharBitmap(int i3, int i10, int i11) {
        return this.mTextTextureGenerator.getTextPixelBuffer(i10, i11);
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @JBindingInclude
    public byte[] requireCharsWidths(int i3, int[] iArr, int i10, int i11) {
        return this.mTextTextureGenerator.getCharsWidths(iArr);
    }

    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    public void requireMapRender(int i3, int i10, int i11) {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0074 A[RETURN] */
    @Override // com.autonavi.base.amap.mapcore.IAMapEngineCallback
    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public byte[] requireMapResource(int r5, java.lang.String r6) {
        /*
            r4 = this;
            r5 = 0
            if (r6 != 0) goto L4
            return r5
        L4:
            java.lang.String r0 = "map_assets/"
            java.lang.String r0 = r0.concat(r6)
            java.lang.String r1 = "icons_5"
            java.lang.String r2 = "bktile"
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r3 = r4.mGlMapView     // Catch: java.lang.Throwable -> L2f
            com.autonavi.base.amap.mapcore.MapConfig r3 = r3.getMapConfig()     // Catch: java.lang.Throwable -> L2f
            boolean r3 = r3.isCustomStyleEnable()     // Catch: java.lang.Throwable -> L2f
            if (r3 == 0) goto L75
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r3 = r4.mGlMapView     // Catch: java.lang.Throwable -> L2f
            com.amap.api.col.3sl.a0 r3 = r3.getCustomStyleManager()     // Catch: java.lang.Throwable -> L2f
            if (r3 == 0) goto L31
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r3 = r4.mGlMapView     // Catch: java.lang.Throwable -> L2f
            com.amap.api.col.3sl.a0 r3 = r3.getCustomStyleManager()     // Catch: java.lang.Throwable -> L2f
            byte[] r3 = r3.b(r6)     // Catch: java.lang.Throwable -> L2f
            if (r3 == 0) goto L32
            return r3
        L2f:
            r6 = move-exception
            goto L7c
        L31:
            r3 = r5
        L32:
            boolean r1 = r6.startsWith(r1)     // Catch: java.lang.Throwable -> L2f
            if (r1 == 0) goto L54
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r6 = r4.mGlMapView     // Catch: java.lang.Throwable -> L2f
            com.autonavi.base.amap.mapcore.MapConfig r6 = r6.getMapConfig()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r6 = r6.getCustomTextureResourcePath()     // Catch: java.lang.Throwable -> L2f
            if (r6 == 0) goto L72
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r6 = r4.mGlMapView     // Catch: java.lang.Throwable -> L2f
            com.autonavi.base.amap.mapcore.MapConfig r6 = r6.getMapConfig()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r6 = r6.getCustomTextureResourcePath()     // Catch: java.lang.Throwable -> L2f
            byte[] r6 = com.autonavi.base.amap.mapcore.FileUtil.readFileContents(r6)     // Catch: java.lang.Throwable -> L2f
        L52:
            r3 = r6
            goto L72
        L54:
            boolean r6 = r6.startsWith(r2)     // Catch: java.lang.Throwable -> L2f
            if (r6 == 0) goto L72
            android.content.Context r6 = r4.context     // Catch: java.lang.Throwable -> L2f
            byte[] r3 = com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssets(r6, r0)     // Catch: java.lang.Throwable -> L2f
            com.autonavi.base.amap.api.mapcore.IAMapDelegate r6 = r4.mGlMapView     // Catch: java.lang.Throwable -> L2f
            com.autonavi.base.amap.mapcore.MapConfig r6 = r6.getMapConfig()     // Catch: java.lang.Throwable -> L2f
            int r6 = r6.getCustomBackgroundColor()     // Catch: java.lang.Throwable -> L2f
            if (r6 == 0) goto L72
            r1 = 1
            byte[] r6 = com.amap.api.col.p0003sl.v4.a(r3, r6, r6, r1)     // Catch: java.lang.Throwable -> L2f
            goto L52
        L72:
            if (r3 == 0) goto L75
            return r3
        L75:
            android.content.Context r6 = r4.context     // Catch: java.lang.Throwable -> L2f
            byte[] r5 = com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssets(r6, r0)     // Catch: java.lang.Throwable -> L2f
            return r5
        L7c:
            com.amap.api.col.p0003sl.v4.a(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.GLMapEngine.requireMapResource(int, java.lang.String):byte[]");
    }

    public void setAllContentEnable(int i3, boolean z5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            if (z5) {
                nativeSetAllContentEnable(i3, j4, true);
            } else {
                nativeSetAllContentEnable(i3, j4, false);
            }
            setSimple3DEnable(i3, false);
        }
    }

    public void setBackgroundTexture(int i3, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetSetBackgroundTexture(i3, j4, bArr);
        }
    }

    public void setBuildingEnable(int i3, boolean z5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetBuildingEnable(i3, j4, z5);
        }
    }

    public void setBuildingTextureEnable(int i3, boolean z5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetBuildingTextureEnable(i3, j4, z5);
        }
    }

    public void setCurrentLocation(LatLng latLng) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetCurrentLocation(this.mEngineID, j4, latLng);
    }

    public void setCustomStyleData(int i3, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return;
        }
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetCustomStyleData(i3, j4, bArr, bArr2);
        }
    }

    public void setCustomStyleTexture(int i3, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetCustomStyleTexture(i3, j4, bArr);
        }
    }

    public void setCustomThirdLayerStyle(int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetCustomThirdLayerStyle(this.mEngineID, j4, str);
        }
    }

    public void setHighlightSubwayEnable(int i3, boolean z5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetHighlightSubwayEnable(i3, j4, z5);
        }
    }

    public void setIndoorBuildingToBeActive(int i3, String str, int i10, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetIndoorBuildingToBeActive(i3, j4, str, i10, str2);
        }
    }

    public void setIndoorEnable(int i3, boolean z5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetIndoorEnable(i3, j4, z5);
        }
    }

    public void setLabelEnable(int i3, boolean z5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetLabelEnable(i3, j4, z5);
        }
    }

    public void setLocationOversea(boolean z5) {
        NetworkProxyManager networkProxyManager = sNetworkProxyManager;
        if (networkProxyManager == null) {
            return;
        }
        networkProxyManager.setLocationOversea(z5);
    }

    public void setMapListener(IAMapListener iAMapListener) {
        this.mMapListener = iAMapListener;
    }

    public boolean setMapModeAndStyle(int i3, int i10, int i11, boolean z5, StyleItem[] styleItemArr) {
        if (this.mNativeMapengineInstance == 0) {
            return false;
        }
        boolean nativeMapModeAndStyle = setNativeMapModeAndStyle(i3, i10, i11);
        if (styleItemArr != null && z5) {
            int customBackgroundColor = this.mGlMapView.getMapConfig().getCustomBackgroundColor();
            if (customBackgroundColor != 0) {
                setBackgroundTexture(i3, v4.a(FileUtil.readFileContentsFromAssets(this.context, AMapEngineUtils.MAP_CUSTOM_ASSETS_NAME + File.separator + AMapEngineUtils.MAP_MAP_ASSETS_CUSTOM_BACKGROUND_NAME), customBackgroundColor, customBackgroundColor, true));
            }
            String customTextureResourcePath = this.mGlMapView.getMapConfig().getCustomTextureResourcePath();
            if (this.mGlMapView.getMapConfig().isProFunctionAuthEnable() && !TextUtils.isEmpty(customTextureResourcePath)) {
                this.mGlMapView.getMapConfig().setUseProFunction(true);
                setCustomStyleTexture(i3, FileUtil.readFileContents(customTextureResourcePath));
                return nativeMapModeAndStyle;
            }
        } else if (i10 == 0 && i11 == 0) {
            Context context = this.context;
            StringBuilder sb2 = new StringBuilder(AMapEngineUtils.MAP_MAP_ASSETS_NAME);
            String str = File.separator;
            sb2.append(str);
            sb2.append(AMapEngineUtils.MAP_MAP_ASSETS_BACKGROUND_NAME);
            setBackgroundTexture(i3, FileUtil.readFileContentsFromAssets(context, sb2.toString()));
            setCustomStyleTexture(i3, FileUtil.readFileContentsFromAssets(this.context, AMapEngineUtils.MAP_MAP_ASSETS_NAME + str + AMapEngineUtils.MAP_MAP_ASSETS_ICON_5_NAME));
        }
        return nativeMapModeAndStyle;
    }

    public void setMapOpenLayerEnable(boolean z5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetOpenLayerEnable(this.mEngineID, j4, z5);
        }
    }

    public void setMapOptRecordState(boolean z5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetMapOptRecordState(this.mEngineID, j4, z5);
    }

    public void setMapState(int i3, GLMapState gLMapState) {
        setMapState(i3, gLMapState, true);
    }

    public boolean setNativeMapModeAndStyle(int i3, int i10, int i11) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return false;
        }
        return nativeSetMapModeAndStyle(i3, j4, new int[]{i10, i11});
    }

    public void setNaviLabelEnable(int i3, boolean z5, int i10, int i11) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetNaviLabelEnable(i3, j4, z5, i10, i11);
        }
    }

    public void setNetStatus(boolean z5) {
        if (this.mRequestDestroy) {
            return;
        }
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetNetStatus(j4, z5 ? 1 : 0);
    }

    public void setOfflineDataEnable(int i3, boolean z5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetOfflineDataEnable(i3, j4, z5);
        }
    }

    public void setOvelayBundle(int i3, GLOverlayBundle<BaseMapOverlay<?, ?>> gLOverlayBundle) {
        this.bundle = gLOverlayBundle;
    }

    public void setOverseaAuth(boolean z5) {
        NetworkProxyManager networkProxyManager = sNetworkProxyManager;
        if (networkProxyManager == null) {
            return;
        }
        networkProxyManager.setOverseaEnable(z5);
    }

    public void setParamater(int i3, int i10, int i11, int i12, int i13, int i14) {
        this.mLock.lock();
        try {
            long j4 = this.mNativeMapengineInstance;
            if (j4 != 0) {
                nativeSetParameter(i3, j4, i10, i11, i12, i13, i14);
            }
            this.mLock.unlock();
        } catch (Throwable th2) {
            this.mLock.unlock();
            throw th2;
        }
    }

    public void setProjectionCenter(int i3, int i10, int i11) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetProjectionCenter(i3, j4, i10, i11);
        }
    }

    public void setRenderFlags(boolean z5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetRenderFlags(this.mEngineID, j4, z5);
    }

    public void setRoadArrowEnable(int i3, boolean z5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetRoadArrowEnable(i3, j4, z5);
        }
    }

    public void setServiceViewRect(int i3, int i10, int i11, int i12, int i13, int i14, int i15) {
        nativeSetServiceViewRect(i3, this.mNativeMapengineInstance, i10, i11, i12, i13, i14, i15);
    }

    public void setSimple3DEnable(int i3, boolean z5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetSimple3DEnable(i3, j4, z5);
        }
    }

    public void setSkyTexture(int i3, byte[] bArr) {
        if (bArr == null) {
            return;
        }
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetSkyTexture(i3, j4, bArr);
        }
    }

    public void setSrvViewStateBoolValue(int i3, int i10, boolean z5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetSrvViewStateBoolValue(i3, j4, i10, z5);
        }
    }

    public void setStyleChangeGradualEnable(int i3, boolean z5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetStyleChangeGradualEnable(i3, j4, z5);
        }
    }

    public void setTerrainAuth(boolean z5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetTerrainAuth(this.mEngineID, j4, z5);
    }

    public void setTrafficEnable(int i3, boolean z5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 != 0) {
            nativeSetTrafficEnable(i3, j4, z5);
        }
    }

    public void setTrafficStyleWithTexture(int i3, byte[] bArr, MyTrafficStyle myTrafficStyle) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0 || myTrafficStyle == null) {
            return;
        }
        nativeSetTrafficTexture(i3, j4, bArr, bArr.length, myTrafficStyle.getExtremelySmoothColor(), myTrafficStyle.getSmoothColor(), myTrafficStyle.getSlowColor(), myTrafficStyle.getCongestedColor(), myTrafficStyle.getSeriousCongestedColor());
    }

    public void setTrafficStyleWithTextureData(int i3, byte[] bArr) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0 || bArr == null) {
            return;
        }
        nativeSetTrafficTextureAllInOne(i3, j4, bArr);
    }

    public void setVectorOverlayPath(String str) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return;
        }
        nativeSetVectorOverlayPath(this.mEngineID, j4, str);
    }

    public void showHideBuildings(int i3) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return;
        }
        nativeShowHideBuildings(this.mEngineID, j4, i3);
    }

    public void startCheckEngineRenderComplete() {
        this.isEngineRenderComplete = false;
    }

    public void startMapSlidAnim(int i3, Point point, float f2, float f10) {
        if (point == null) {
            return;
        }
        try {
            clearAnimations(i3, true);
            GLMapState cloneMapState = getCloneMapState();
            cloneMapState.reset();
            cloneMapState.recalculate();
            float abs = Math.abs(f2);
            float abs2 = Math.abs(f10);
            float f11 = 12000;
            if ((abs > abs2 ? abs : abs2) > f11) {
                if (abs > abs2) {
                    f2 = f2 > 0.0f ? f11 : -12000;
                    f10 *= f11 / abs;
                } else {
                    f2 *= f11 / abs2;
                    f10 = f10 > 0.0f ? f11 : -12000;
                }
            }
            if (this.mGlMapView.getMapConfig().isTerrainEnable()) {
                AdglMapAnimFlingP20 adglMapAnimFlingP20 = new AdglMapAnimFlingP20(500);
                adglMapAnimFlingP20.setPositionAndVelocity(f2, f10);
                adglMapAnimFlingP20.commitAnimation(cloneMapState);
                this.mapAnimationMgr.addAnimation(adglMapAnimFlingP20, null);
                return;
            }
            int mapWidth = this.mGlMapView.getMapWidth() >> 1;
            int mapHeight = this.mGlMapView.getMapHeight() >> 1;
            if (this.mGlMapView.isUseAnchor()) {
                mapWidth = this.mGlMapView.getMapConfig().getAnchorX();
                mapHeight = this.mGlMapView.getMapConfig().getAnchorY();
            }
            AdglMapAnimFling adglMapAnimFling = new AdglMapAnimFling(500, mapWidth, mapHeight);
            adglMapAnimFling.setPositionAndVelocity(f2, f10);
            adglMapAnimFling.commitAnimation(cloneMapState);
            this.mapAnimationMgr.addAnimation(adglMapAnimFling, null);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void startPivotZoomRotateAnim(int i3, Point point, float f2, int i10, int i11) {
    }

    public void switchLanguage(String str) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0) {
            return;
        }
        nativeSwitchLanguage(this.mEngineID, j4, str);
    }

    public void triggerMainThread() {
        nativeMainThreadTrigger(this.mEngineID, this.mNativeMapengineInstance);
    }

    public void updateNativeArrowOverlay(int i3, String str, int[] iArr, int[] iArr2, int i10, int i11, int i12, float f2, int i13, int i14, int i15, boolean z5) {
        long j4 = this.mNativeMapengineInstance;
        if (j4 == 0 || str == null) {
            return;
        }
        nativeUpdateNativeArrowOverlay(i3, j4, str, iArr, iArr2, i10, i11, i12, f2, z5, i13, i14, i15);
    }

    public void clearAnimations(int i3, boolean z5, int i10) {
        this.mapAnimationMgr.clearAnimations();
    }

    public void setMapState(int i3, GLMapState gLMapState, boolean z5) {
        IAMapDelegate iAMapDelegate;
        if (this.mNativeMapengineInstance != 0) {
            if (z5 && (iAMapDelegate = this.mGlMapView) != null && iAMapDelegate.getMapConfig() != null) {
                this.mGlMapView.checkMapState(gLMapState);
            }
            this.mLock.lock();
            try {
                gLMapState.setNativeMapengineState(i3, this.mNativeMapengineInstance);
            } finally {
                this.mLock.unlock();
            }
        }
    }

    public void addOverlayTexture(int i3, Bitmap bitmap, int i10, int i11) {
        GLTextureProperty gLTextureProperty = new GLTextureProperty();
        gLTextureProperty.mId = i10;
        gLTextureProperty.mAnchor = i11;
        gLTextureProperty.mBitmap = bitmap;
        gLTextureProperty.mXRatio = 0.0f;
        gLTextureProperty.mYRatio = 0.0f;
        gLTextureProperty.isGenMimps = true;
        addOverlayTexture(i3, gLTextureProperty);
    }
}
