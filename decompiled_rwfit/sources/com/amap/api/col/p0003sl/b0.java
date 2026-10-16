package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.amap.api.col.p0003sl.a0;
import com.amap.api.col.p0003sl.e5;
import com.amap.api.col.p0003sl.k9;
import com.amap.api.col.p0003sl.u3;
import com.amap.api.col.p0003sl.w0;
import com.amap.api.map3d.R;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.InfoWindowAnimationManager;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BaseOptions;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BuildingOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.amap.api.maps.model.CustomMapStyleOptions;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.GL3DModelOptions;
import com.amap.api.maps.model.GLTFOverlay;
import com.amap.api.maps.model.GLTFOverlayOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.HeatMapGridLayer;
import com.amap.api.maps.model.HeatMapGridLayerOptions;
import com.amap.api.maps.model.HeatMapLayer;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.HeatmapTileProvider;
import com.amap.api.maps.model.IndoorBuildingInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.MVTTileOverlay;
import com.amap.api.maps.model.MVTTileOverlayOptions;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.PoiFilter;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.RouteOverlay;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.TileProvider;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlay;
import com.amap.api.maps.model.amap3dmodeltile.AMap3DModelTileOverlayOptions;
import com.amap.api.maps.model.particle.ParticleOverlay;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.ae.gmap.AMapAppRequestParam;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.MapPoi;
import com.autonavi.base.ae.gmap.bean.NativeTextGenerate;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.base.ae.gmap.gloverlay.CrossVectorOverlay;
import com.autonavi.base.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.base.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.base.ae.gmap.gloverlay.RouteOverlayInner;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.ae.gmap.style.StyleItem;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.api.mapcore.IProjectionDelegate;
import com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import com.autonavi.base.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.base.amap.mapcore.message.AbstractGestureMapMessage;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
public class b0 implements IAMapDelegate, IAMapListener, u3.a, a0.a {
    private GLTFOverlay A;
    private long A0;
    private boolean B;
    boolean B0;
    private boolean C;
    private boolean C0;
    private int D;
    private boolean D0;
    private boolean E;
    protected final Handler E0;
    private Handler F;
    private p0 F0;
    private boolean G;
    private p0 G0;
    private Rect H;
    private p0 H0;
    private int I;
    private p0 I0;
    private Thread J;
    private p0 J0;
    private Thread K;
    private p0 K0;
    private u0 L;
    private p0 L0;
    private com.amap.api.col.p0003sl.o0 M;
    private p0 M0;
    private com.amap.api.col.p0003sl.p0 N;
    private p0 N0;
    private boolean O;
    private p0 O0;
    private boolean P;
    private p0 P0;
    private int Q;
    private p0 Q0;
    private CustomRenderer R;
    private p0 R0;
    private int S;
    private Runnable S0;
    private int T;
    private p0 T0;
    private boolean U;
    private com.autonavi.extra.b U0;
    private List<d1> V;
    private String V0;
    private s3 W;
    private String W0;
    private u3 X;
    private boolean X0;
    p4 Y;
    private boolean Y0;
    private long Z;
    private int Z0;

    /* renamed from: a, reason: collision with root package name */
    private com.amap.api.col.p0003sl.m0 f3627a;

    /* renamed from: a0, reason: collision with root package name */
    private float f3628a0;

    /* renamed from: a1, reason: collision with root package name */
    private EAMapPlatformGestureInfo f3629a1;

    /* renamed from: b, reason: collision with root package name */
    private com.amap.api.col.p0003sl.n0 f3630b;

    /* renamed from: b0, reason: collision with root package name */
    protected Context f3631b0;

    /* renamed from: b1, reason: collision with root package name */
    Point f3632b1;

    /* renamed from: c, reason: collision with root package name */
    private AMapGestureListener f3633c;

    /* renamed from: c0, reason: collision with root package name */
    protected GLMapEngine f3634c0;

    /* renamed from: c1, reason: collision with root package name */
    private long f3635c1;

    /* renamed from: d, reason: collision with root package name */
    private w1 f3636d;

    /* renamed from: d0, reason: collision with root package name */
    private GLMapRender f3637d0;

    /* renamed from: d1, reason: collision with root package name */
    private v1 f3638d1;
    private UiSettings e;

    /* renamed from: e0, reason: collision with root package name */
    private y0 f3639e0;

    /* renamed from: e1, reason: collision with root package name */
    private AMap.OnCustomMapStyleListener f3640e1;

    /* renamed from: f, reason: collision with root package name */
    private IProjectionDelegate f3641f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f3642f0;
    float[] f1;

    /* renamed from: g, reason: collision with root package name */
    private final h1 f3643g;

    /* renamed from: g0, reason: collision with root package name */
    public int f3644g0;

    /* renamed from: g1, reason: collision with root package name */
    float[] f3645g1;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f3646h;

    /* renamed from: h0, reason: collision with root package name */
    public int f3647h0;

    /* renamed from: h1, reason: collision with root package name */
    float[] f3648h1;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3649i;
    private float i0;

    /* renamed from: j, reason: collision with root package name */
    private final IGLSurfaceView f3650j;

    /* renamed from: j0, reason: collision with root package name */
    private float f3651j0;

    /* renamed from: k, reason: collision with root package name */
    private h5 f3652k;

    /* renamed from: k0, reason: collision with root package name */
    private float f3653k0;

    /* renamed from: l, reason: collision with root package name */
    private b1 f3654l;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f3655l0;

    /* renamed from: m, reason: collision with root package name */
    private final IGlOverlayLayer f3656m;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f3657m0;

    /* renamed from: n, reason: collision with root package name */
    private boolean f3658n;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f3659n0;

    /* renamed from: o, reason: collision with root package name */
    private int f3660o;

    /* renamed from: o0, reason: collision with root package name */
    private volatile boolean f3661o0;

    /* renamed from: p, reason: collision with root package name */
    private AtomicBoolean f3662p;

    /* renamed from: p0, reason: collision with root package name */
    private volatile boolean f3663p0;

    /* renamed from: q, reason: collision with root package name */
    private boolean f3664q;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f3665q0;
    protected MapConfig r;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f3666r0;

    /* renamed from: s, reason: collision with root package name */
    private boolean f3667s;

    /* renamed from: s0, reason: collision with root package name */
    private Lock f3668s0;

    /* renamed from: t, reason: collision with root package name */
    private boolean f3669t;

    /* renamed from: t0, reason: collision with root package name */
    private int f3670t0;

    /* renamed from: u, reason: collision with root package name */
    protected v1 f3671u;

    /* renamed from: u0, reason: collision with root package name */
    private int f3672u0;

    /* renamed from: v, reason: collision with root package name */
    private m3 f3673v;

    /* renamed from: v0, reason: collision with root package name */
    private int f3674v0;

    /* renamed from: w, reason: collision with root package name */
    private LocationSource f3675w;

    /* renamed from: w0, reason: collision with root package name */
    private q0 f3676w0;

    /* renamed from: x, reason: collision with root package name */
    private boolean f3677x;

    /* renamed from: x0, reason: collision with root package name */
    private q3 f3678x0;

    /* renamed from: y, reason: collision with root package name */
    private boolean f3679y;

    /* renamed from: y0, reason: collision with root package name */
    private AMap.OnMultiPointClickListener f3680y0;

    /* renamed from: z, reason: collision with root package name */
    private Marker f3681z;

    /* renamed from: z0, reason: collision with root package name */
    private com.amap.api.col.p0003sl.a0 f3682z0;

    public class a extends Handler {

        /* renamed from: com.amap.api.col.3sl.b0$a$a, reason: collision with other inner class name */
        public class RunnableC0001a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bitmap f3684a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f3685b;

            public RunnableC0001a(Bitmap bitmap, int i3) {
                this.f3684a = bitmap;
                this.f3685b = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                b0.a(b0.this, this.f3684a, this.f3685b);
            }
        }

        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f3687a;

            public b(int i3) {
                this.f3687a = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                b0.a(b0.this, (Bitmap) null, this.f3687a);
            }
        }

        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3;
            l5 f2;
            IInfoWindowAction a3;
            if (message == null || b0.this.f3662p.get()) {
                return;
            }
            try {
                i3 = message.what;
            } catch (Throwable th2) {
                ka.a(th2, "AMapDelegateImp", "handleMessage");
                th2.printStackTrace();
            }
            if (i3 == 2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(n1.a(R.string.O105492_70));
                Object obj = message.obj;
                if (obj != null) {
                    sb2.append(obj);
                } else {
                    sb2.append(c9.f3818b);
                }
                sb2.append("]");
                Log.w("amapsdk", sb2.toString());
                return;
            }
            if (i3 == 30) {
                GLMapEngine gLMapEngine = b0.this.f3634c0;
                if (gLMapEngine != null) {
                    gLMapEngine.triggerMainThread();
                    return;
                }
                return;
            }
            if (i3 == 40) {
                if (b0.this.f3654l != null) {
                    b0.this.f3654l.redrawOverlays();
                    return;
                }
                return;
            }
            if (i3 == 41) {
                b0.q(b0.this);
                return;
            }
            int i10 = 0;
            switch (i3) {
                case 10:
                    CameraPosition cameraPosition = (CameraPosition) message.obj;
                    try {
                        List a10 = b0.this.f3630b.a(AMap.OnCameraChangeListener.class.hashCode());
                        if (cameraPosition != null && a10 != null && a10.size() > 0) {
                            synchronized (a10) {
                                try {
                                    Iterator it = a10.iterator();
                                    while (it.hasNext()) {
                                        ((AMap.OnCameraChangeListener) it.next()).onCameraChange(cameraPosition);
                                    }
                                } finally {
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        v4.a(th3);
                    }
                    b0.this.r.addChangedCounter();
                    return;
                case 11:
                    try {
                        CameraPosition cameraPosition2 = b0.this.getCameraPosition();
                        if (cameraPosition2 != null && b0.this.f3652k != null) {
                            ((g5) b0.this.f3652k).a(cameraPosition2);
                        }
                        b0.this.b(cameraPosition2);
                        if (MapsInitializer.isLoadWorldVectorMap()) {
                            if (b0.this.N == null) {
                                b0 b0Var = b0.this;
                                b0Var.N = new com.amap.api.col.p0003sl.p0(b0Var.f3631b0, b0Var);
                            }
                            if (b0.this.N.b() == 0) {
                                if (b0.this.a(cameraPosition2, false)) {
                                    b0.this.f3634c0.setLocationOversea(true);
                                    b0.this.N.a(0L);
                                } else {
                                    b0.this.f3634c0.setLocationOversea(false);
                                }
                            }
                        }
                        if (b0.this.f3659n0) {
                            b0.this.f3659n0 = false;
                            if (b0.this.f3656m != null) {
                                b0.this.f3656m.setFlingState(false);
                            }
                            b0.this.b(true);
                        }
                        if (b0.this.C) {
                            b0.this.redrawInfoWindow();
                            b0.this.C = false;
                        }
                        b0.this.a(cameraPosition2);
                        return;
                    } catch (Throwable th4) {
                        ka.a(th4, "AMapDelegateImp", "CameraUpdateFinish");
                        v4.a(th4);
                        return;
                    }
                case 12:
                    if (b0.this.f3652k != null) {
                        ((g5) b0.this.f3652k).a(Float.valueOf(b0.this.d()));
                        return;
                    }
                    return;
                case 13:
                    if (b0.this.f3652k != null) {
                        ((g5) b0.this.f3652k).g();
                        return;
                    }
                    return;
                case 14:
                    try {
                        List a11 = b0.this.f3630b.a(AMap.OnMapTouchListener.class.hashCode());
                        if (a11 == null || a11.size() <= 0) {
                            return;
                        }
                        synchronized (a11) {
                            try {
                                Iterator it2 = a11.iterator();
                                while (it2.hasNext()) {
                                    ((AMap.OnMapTouchListener) it2.next()).onTouch((MotionEvent) message.obj);
                                }
                            } finally {
                            }
                        }
                        return;
                    } catch (Throwable th5) {
                        ka.a(th5, "AMapDelegateImp", "onTouchHandler");
                        th5.printStackTrace();
                        return;
                    }
                case 15:
                    Bitmap bitmap = (Bitmap) message.obj;
                    int i11 = message.arg1;
                    if (bitmap == null || b0.this.f3652k == null) {
                        if (b0.this.F != null) {
                            b0.this.F.post(new b(i11));
                            return;
                        } else {
                            b0.a(b0.this, (Bitmap) null, i11);
                            return;
                        }
                    }
                    Canvas canvas = new Canvas(bitmap);
                    if (b0.this.E && (f2 = ((g5) b0.this.f3652k).f()) != null) {
                        f2.onDraw(canvas);
                    }
                    b0.this.f3654l.screenShotOverlays(canvas);
                    ((g5) b0.this.f3652k).a(canvas);
                    if (b0.this.F != null) {
                        b0.this.F.post(new RunnableC0001a(bitmap, i11));
                        return;
                    } else {
                        b0.a(b0.this, bitmap, i11);
                        return;
                    }
                case 16:
                    try {
                        List a12 = b0.this.f3630b.a(AMap.OnMapLoadedListener.class.hashCode());
                        if (a12 != null) {
                            synchronized (a12) {
                                while (i10 < a12.size()) {
                                    try {
                                        ((AMap.OnMapLoadedListener) a12.get(i10)).onMapLoaded();
                                        i10++;
                                    } finally {
                                    }
                                }
                            }
                        }
                    } catch (Throwable th6) {
                        ka.a(th6, "AMapDelegateImp", "onMapLoaded");
                        th6.printStackTrace();
                        v4.a(th6);
                    }
                    if (b0.this.f3652k != null) {
                        ((g5) b0.this.f3652k).a();
                    }
                    b0.q(b0.this);
                    b0.this.redrawInfoWindow();
                    return;
                case 17:
                    b0 b0Var2 = b0.this;
                    if (!b0Var2.f3634c0.isInMapAnimation(b0Var2.f3660o) || b0.this.f3656m == null) {
                        return;
                    }
                    b0.this.f3656m.setFlingState(false);
                    return;
                case 18:
                    if (b0.this.f3636d == null || (a3 = b0.this.f3636d.a()) == null) {
                        return;
                    }
                    a3.redrawInfoWindow();
                    return;
                case 19:
                    List a13 = b0.this.f3630b.a(AMap.OnMapClickListener.class.hashCode());
                    if (a13 != null) {
                        DPoint obtain = DPoint.obtain();
                        b0.this.getPixel2LatLng(message.arg1, message.arg2, obtain);
                        try {
                            synchronized (a13) {
                                try {
                                    Iterator it3 = a13.iterator();
                                    while (it3.hasNext()) {
                                        ((AMap.OnMapClickListener) it3.next()).onMapClick(new LatLng(obtain.f6571y, obtain.f6570x));
                                    }
                                } finally {
                                }
                            }
                            obtain.recycle();
                            return;
                        } catch (Throwable th7) {
                            ka.a(th7, "AMapDelegateImp", "OnMapClickListener.onMapClick");
                            th7.printStackTrace();
                            return;
                        }
                    }
                    return;
                case 20:
                    try {
                        List a14 = b0.this.f3630b.a(AMap.OnPOIClickListener.class.hashCode());
                        if (a14 == null || a14.size() <= 0) {
                            return;
                        }
                        synchronized (a14) {
                            while (i10 < a14.size()) {
                                try {
                                    ((AMap.OnPOIClickListener) a14.get(i10)).onPOIClick((Poi) message.obj);
                                    i10++;
                                } catch (Throwable th8) {
                                    throw th8;
                                }
                            }
                        }
                        return;
                    } catch (Throwable th9) {
                        ka.a(th9, "AMapDelegateImp", "OnPOIClickListener.onPOIClick");
                        th9.printStackTrace();
                        return;
                    }
                default:
                    return;
            }
            ka.a(th2, "AMapDelegateImp", "handleMessage");
            th2.printStackTrace();
        }
    }

    public class a0 implements Runnable {
        public a0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b0 b0Var = b0.this;
            GLMapEngine gLMapEngine = b0Var.f3634c0;
            if (gLMapEngine != null) {
                int i3 = b0Var.f3660o;
                v1 v1Var = b0.this.f3671u;
                gLMapEngine.setIndoorBuildingToBeActive(i3, v1Var.activeFloorName, v1Var.activeFloorIndex, v1Var.poiid);
            }
        }
    }

    public class b extends p0 {
        public b() {
            super(null);
        }

        @Override // com.amap.api.col.3sl.b0.p0, java.lang.Runnable
        public void run() {
            this.f3737a = false;
            try {
                b0.this.setConstructingRoadEnable(this.f3738b);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* renamed from: com.amap.api.col.3sl.b0$b0, reason: collision with other inner class name */
    public class RunnableC0002b0 implements Runnable {
        public RunnableC0002b0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List a3;
            List a10;
            v1 v1Var;
            v1 v1Var2;
            int[] iArr;
            String[] strArr;
            if (b0.this.f3676w0 != null) {
                q0 q0Var = b0.this.f3676w0;
                v1 v1Var3 = b0.this.f3638d1;
                MapConfig mapConfig = b0.this.r;
                if (mapConfig == null || !mapConfig.isIndoorEnable()) {
                    return;
                }
                e5 d5 = ((g5) b0.this.f3652k).d();
                if (v1Var3 == null) {
                    try {
                        List a11 = b0.this.f3630b.a(AMap.OnIndoorBuildingActiveListener.class.hashCode());
                        if (a11 != null && a11.size() > 0) {
                            synchronized (a11) {
                                for (int i3 = 0; i3 < a11.size(); i3++) {
                                    try {
                                        ((AMap.OnIndoorBuildingActiveListener) a11.get(i3)).OnIndoorBuilding(v1Var3);
                                    } finally {
                                    }
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    v1 v1Var4 = b0.this.f3671u;
                    if (v1Var4 != null) {
                        v1Var4.e = null;
                    }
                    if (d5.b()) {
                        b0.this.E0.post(new com.amap.api.col.p0003sl.h0(q0Var, d5));
                    }
                    MapConfig mapConfig2 = b0.this.r;
                    mapConfig2.maxZoomLevel = mapConfig2.isSetLimitZoomLevel() ? b0.this.r.getMaxZoomLevel() : 20.0f;
                    try {
                        if (!b0.this.f3643g.isZoomControlsEnabled() || (a3 = b0.this.f3630b.a(AMapWidgetListener.class.hashCode())) == null || a3.size() <= 0) {
                            return;
                        }
                        synchronized (a3) {
                            for (int i10 = 0; i10 < a3.size(); i10++) {
                                try {
                                    ((AMapWidgetListener) a3.get(i10)).invalidateZoomController(b0.this.r.getSZ());
                                } finally {
                                }
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
                if (v1Var3 != null && (iArr = v1Var3.floor_indexs) != null && (strArr = v1Var3.floor_names) != null && iArr.length == strArr.length) {
                    int i11 = 0;
                    while (true) {
                        int[] iArr2 = v1Var3.floor_indexs;
                        if (i11 >= iArr2.length) {
                            break;
                        }
                        if (v1Var3.activeFloorIndex == iArr2[i11]) {
                            v1Var3.activeFloorName = v1Var3.floor_names[i11];
                            break;
                        }
                        i11++;
                    }
                }
                if (v1Var3 == null || (v1Var2 = b0.this.f3671u) == null || v1Var2.activeFloorIndex == v1Var3.activeFloorIndex || !d5.b()) {
                    if (v1Var3 != null && ((v1Var = b0.this.f3671u) == null || !v1Var.poiid.equals(v1Var3.poiid) || b0.this.f3671u.e == null)) {
                        b0 b0Var = b0.this;
                        b0Var.f3671u = v1Var3;
                        if (b0Var.r != null) {
                            if (v1Var3.e == null) {
                                v1Var3.e = new Point();
                            }
                            DPoint mapGeoCenter = b0.this.r.getMapGeoCenter();
                            if (mapGeoCenter != null) {
                                Point point = b0.this.f3671u.e;
                                point.x = (int) mapGeoCenter.f6570x;
                                point.y = (int) mapGeoCenter.f6571y;
                            }
                        }
                    }
                    try {
                        List a12 = b0.this.f3630b.a(AMap.OnIndoorBuildingActiveListener.class.hashCode());
                        if (a12 != null && a12.size() > 0) {
                            synchronized (a12) {
                                for (int i12 = 0; i12 < a12.size(); i12++) {
                                    try {
                                        ((AMap.OnIndoorBuildingActiveListener) a12.get(i12)).OnIndoorBuilding(v1Var3);
                                    } finally {
                                    }
                                }
                            }
                        }
                        MapConfig mapConfig3 = b0.this.r;
                        mapConfig3.maxZoomLevel = mapConfig3.isSetLimitZoomLevel() ? b0.this.r.getMaxZoomLevel() : 20.0f;
                        if (b0.this.f3643g.isZoomControlsEnabled() && (a10 = b0.this.f3630b.a(AMapWidgetListener.class.hashCode())) != null && a10.size() > 0) {
                            synchronized (a10) {
                                for (int i13 = 0; i13 < a10.size(); i13++) {
                                    try {
                                        ((AMapWidgetListener) a10.get(i13)).invalidateZoomController(b0.this.r.getSZ());
                                    } finally {
                                    }
                                }
                            }
                        }
                        if (b0.this.f3643g.isIndoorSwitchEnabled()) {
                            if (!d5.b()) {
                                b0.this.f3643g.setIndoorSwitchEnabled(true);
                            }
                            b0.this.E0.post(new com.amap.api.col.p0003sl.i0(q0Var, d5));
                        } else {
                            if (b0.this.f3643g.isIndoorSwitchEnabled() || !d5.b()) {
                                return;
                            }
                            b0.this.f3643g.setIndoorSwitchEnabled(false);
                        }
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            }
        }
    }

    public class c extends p0 {
        public c() {
            super(null);
        }

        @Override // com.amap.api.col.3sl.b0.p0, java.lang.Runnable
        public void run() {
            this.f3737a = false;
            try {
                b0.this.setTrafficStyleWithTextureData(this.f3743h);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class c0 implements Runnable {
        public c0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (b0.this.f3656m != null) {
                    b0.this.f3656m.destroy();
                }
                b0 b0Var = b0.this;
                b0Var.destroySurface(b0Var.f3660o);
            } catch (Throwable th2) {
                th2.printStackTrace();
                v4.a(th2);
            }
        }
    }

    public class d extends p0 {
        public d() {
            super(null);
        }

        @Override // com.amap.api.col.3sl.b0.p0, java.lang.Runnable
        public void run() {
            this.f3737a = false;
            try {
                b0.this.setTrafficStyleWithTexture(this.f3743h, this.f3744i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class d0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CrossVectorOverlay f3695a;

        public d0(CrossVectorOverlay crossVectorOverlay) {
            this.f3695a = crossVectorOverlay;
        }

        @Override // java.lang.Runnable
        public void run() {
            GLOverlayBundle overlayBundle;
            b0 b0Var = b0.this;
            GLMapEngine gLMapEngine = b0Var.f3634c0;
            if (gLMapEngine == null || (overlayBundle = gLMapEngine.getOverlayBundle(b0Var.f3660o)) == null) {
                return;
            }
            overlayBundle.addOverlay(this.f3695a);
        }
    }

    public class e extends p0 {
        public e() {
            super(null);
        }

        @Override // com.amap.api.col.3sl.b0.p0, java.lang.Runnable
        public void run() {
            this.f3737a = false;
            b0.this.a(this.e, this.f3738b);
        }
    }

    public class e0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RouteOverlayInner f3698a;

        public e0(RouteOverlayInner routeOverlayInner) {
            this.f3698a = routeOverlayInner;
        }

        @Override // java.lang.Runnable
        public void run() {
            GLOverlayBundle overlayBundle;
            b0 b0Var = b0.this;
            GLMapEngine gLMapEngine = b0Var.f3634c0;
            if (gLMapEngine == null || (overlayBundle = gLMapEngine.getOverlayBundle(b0Var.f3660o)) == null) {
                return;
            }
            overlayBundle.addOverlay(this.f3698a);
        }
    }

    public class f extends p0 {
        public f() {
            super(null);
        }

        @Override // com.amap.api.col.3sl.b0.p0, java.lang.Runnable
        public void run() {
            this.f3737a = false;
            try {
                b0.this.setIndoorEnabled(this.f3738b);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class f0 implements AMap.OnCacheRemoveListener {
        public f0() {
        }

        @Override // com.amap.api.maps.AMap.OnCacheRemoveListener
        public void onRemoveCacheFinish(boolean z5) {
            b0.this.f3634c0.switchLanguage("zh-Hans");
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l5 f2;
            if (b0.this.f3652k == null || (f2 = ((g5) b0.this.f3652k).f()) == null) {
                return;
            }
            f2.e();
        }
    }

    public class g0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseMapOverlay f3703a;

        public g0(BaseMapOverlay baseMapOverlay) {
            this.f3703a = baseMapOverlay;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0 b0Var = b0.this;
            b0Var.f3634c0.getOverlayBundle(b0Var.f3660o).removeOverlay(this.f3703a);
        }
    }

    public class h extends p0 {
        public h() {
            super(null);
        }

        @Override // com.amap.api.col.3sl.b0.p0, java.lang.Runnable
        public void run() {
            this.f3737a = false;
            b0.this.b(this.e, this.f3738b);
        }
    }

    public class h0 implements Callable<Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f3706a;

        public h0(List list) {
            this.f3706a = list;
        }

        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            return Integer.valueOf(b0.this.f3634c0.hideBuildings(this.f3706a));
        }
    }

    public class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f3708a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3709b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3710c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f3711d;
        final /* synthetic */ StyleItem[] e;

        public i(int i3, int i10, int i11, boolean z5, StyleItem[] styleItemArr) {
            this.f3708a = i3;
            this.f3709b = i10;
            this.f3710c = i11;
            this.f3711d = z5;
            this.e = styleItemArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b0.this.f3634c0.setMapModeAndStyle(this.f3708a, this.f3709b, this.f3710c, this.f3711d, this.e);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class i0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f3713a;

        public i0(int i3) {
            this.f3713a = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0.this.f3634c0.showHideBuildings(this.f3713a);
        }
    }

    public class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f3715a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f3716b;

        public j(int i3, boolean z5) {
            this.f3715a = i3;
            this.f3716b = z5;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b0.this.f3634c0.setBuildingEnable(this.f3715a, this.f3716b);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class j0 extends p0 {
        public j0() {
            super(null);
        }

        @Override // com.amap.api.col.3sl.b0.p0, java.lang.Runnable
        public void run() {
            this.f3737a = false;
            b0.this.a(this.e, this.f3739c, this.f3740d);
        }
    }

    public class k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3719a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3720b;

        public k(boolean z5, int i3) {
            this.f3719a = z5;
            this.f3720b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            GLMapEngine gLMapEngine = b0.this.f3634c0;
            if (gLMapEngine != null) {
                if (this.f3719a) {
                    gLMapEngine.setAllContentEnable(this.f3720b, true);
                } else {
                    gLMapEngine.setAllContentEnable(this.f3720b, false);
                }
                b0.this.f3634c0.setSimple3DEnable(this.f3720b, false);
            }
        }
    }

    public class k0 extends p0 {
        public k0() {
            super(null);
        }

        @Override // com.amap.api.col.3sl.b0.p0, java.lang.Runnable
        public void run() {
            this.f3737a = false;
            b0.this.setMapCustomEnable(this.f3738b);
        }
    }

    public class l implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3723a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3724b;

        public l(boolean z5, int i3) {
            this.f3723a = z5;
            this.f3724b = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f3723a) {
                    b0.this.f3634c0.setBuildingTextureEnable(this.f3724b, true);
                } else {
                    b0.this.f3634c0.setBuildingTextureEnable(this.f3724b, false);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class l0 extends p0 {
        public l0() {
            super(null);
        }

        @Override // com.amap.api.col.3sl.b0.p0, java.lang.Runnable
        public void run() {
            this.f3737a = false;
            b0.this.c(this.e, this.f3738b);
        }
    }

    public class m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LatLngBounds.Builder f3727a;

        public m(LatLngBounds.Builder builder) {
            this.f3727a = builder;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b0 b0Var = b0.this;
                LatLngBounds build = this.f3727a.build();
                i1 i1Var = new i1();
                i1Var.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
                i1Var.bounds = build;
                i1Var.paddingLeft = 50;
                i1Var.paddingRight = 50;
                i1Var.paddingTop = 50;
                i1Var.paddingBottom = 50;
                b0Var.moveCamera(i1Var);
            } catch (Throwable unused) {
            }
        }
    }

    public class m0 extends p0 {
        public m0() {
            super(null);
        }

        @Override // com.amap.api.col.3sl.b0.p0, java.lang.Runnable
        public void run() {
            this.f3737a = false;
            try {
                b0.this.setMapTextEnable(this.f3738b);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b0 b0Var = b0.this;
            if (b0Var.f3634c0 == null || b0Var.f3662p.get()) {
                return;
            }
            b0 b0Var2 = b0.this;
            b0Var2.f3634c0.removeNativeAllOverlay(b0Var2.f3660o);
        }
    }

    public class n0 extends p0 {
        public n0() {
            super(null);
        }

        @Override // com.amap.api.col.3sl.b0.p0, java.lang.Runnable
        public void run() {
            this.f3737a = false;
            try {
                b0.this.setRoadArrowEnable(this.f3738b);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class o extends p0 {
        public o() {
            super(null);
        }

        @Override // com.amap.api.col.3sl.b0.p0, java.lang.Runnable
        public void run() {
            this.f3737a = false;
            try {
                b0.this.setTrafficEnabled(this.f3738b);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class o0 extends p0 {
        public o0() {
            super(null);
        }

        @Override // com.amap.api.col.3sl.b0.p0, java.lang.Runnable
        public void run() {
            this.f3737a = false;
            try {
                b0.this.setNaviLabelEnable(this.f3738b, this.f3741f, this.f3742g);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class p implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3734a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f3735b;

        public p(boolean z5, boolean z6) {
            this.f3734a = z5;
            this.f3735b = z6;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (b0.this.r.isTrafficEnabled() != this.f3734a) {
                    b0.this.r.setTrafficEnabled(this.f3735b);
                    b0.this.f3637d0.setTrafficMode(this.f3734a);
                    b0 b0Var = b0.this;
                    b0Var.f3634c0.setTrafficEnable(b0Var.f3660o, this.f3734a);
                    b0.this.resetRenderTime();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                v4.a(th2);
            }
        }
    }

    public class q implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3745a;

        public q(boolean z5) {
            this.f3745a = z5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3745a) {
                b0.this.showIndoorSwitchControlsEnabled(true);
            } else if (b0.this.f3652k != null) {
                ((g5) b0.this.f3652k).b(Boolean.FALSE);
            }
        }
    }

    public class q0 {
        public q0() {
        }
    }

    public class r implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3748a;

        public r(boolean z5) {
            this.f3748a = z5;
        }

        @Override // java.lang.Runnable
        public void run() {
            b0 b0Var = b0.this;
            GLMapEngine gLMapEngine = b0Var.f3634c0;
            if (gLMapEngine != null) {
                gLMapEngine.setOfflineDataEnable(b0Var.f3660o, this.f3748a);
            }
        }
    }

    public class r0 implements e5.d {
        private r0() {
        }

        @Override // com.amap.api.col.3sl.e5.d
        public void a(int i3) {
            b0 b0Var = b0.this;
            v1 v1Var = b0Var.f3671u;
            if (v1Var != null) {
                v1Var.activeFloorIndex = v1Var.floor_indexs[i3];
                v1Var.activeFloorName = v1Var.floor_names[i3];
                try {
                    b0Var.setIndoorBuildingInfo(v1Var);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        public /* synthetic */ r0(b0 b0Var, a aVar) {
            this();
        }
    }

    public class s implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3751a;

        public s(boolean z5) {
            this.f3751a = z5;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b0 b0Var = b0.this;
                b0Var.f3634c0.setLabelEnable(b0Var.f3660o, this.f3751a);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class s0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Context f3753a;

        /* renamed from: b, reason: collision with root package name */
        private AMap.OnCacheRemoveListener f3754b;

        public s0(Context context, AMap.OnCacheRemoveListener onCacheRemoveListener) {
            this.f3753a = context;
            this.f3754b = onCacheRemoveListener;
        }

        public boolean equals(Object obj) {
            return obj instanceof s0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
        
            if ((!r4.exists() ? true : com.autonavi.base.amap.mapcore.FileUtil.deleteFile(r4)) != false) goto L26;
         */
        /* JADX WARN: Removed duplicated region for block: B:11:0x003c A[Catch: all -> 0x0036, TryCatch #5 {all -> 0x0036, blocks: (B:66:0x0029, B:11:0x003c, B:33:0x004d), top: B:65:0x0029 }] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x005d A[Catch: all -> 0x0025, TRY_LEAVE, TryCatch #3 {all -> 0x0025, blocks: (B:3:0x0002, B:5:0x001b, B:15:0x0055, B:17:0x005d), top: B:2:0x0002 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r6 = this;
                r0 = 0
                r1 = 1
                android.content.Context r2 = r6.f3753a     // Catch: java.lang.Throwable -> L25
                android.content.Context r2 = r2.getApplicationContext()     // Catch: java.lang.Throwable -> L25
                java.lang.String r3 = com.amap.api.col.p0003sl.v4.a(r2)     // Catch: java.lang.Throwable -> L25
                java.lang.String r4 = com.amap.api.col.p0003sl.v4.c(r2)     // Catch: java.lang.Throwable -> L25
                java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L25
                r5.<init>(r3)     // Catch: java.lang.Throwable -> L25
                boolean r3 = r5.exists()     // Catch: java.lang.Throwable -> L25
                if (r3 == 0) goto L21
                boolean r3 = com.autonavi.base.amap.mapcore.FileUtil.deleteFile(r5)     // Catch: java.lang.Throwable -> L25
                if (r3 == 0) goto L23
            L21:
                r3 = r1
                goto L27
            L23:
                r3 = r0
                goto L27
            L25:
                r2 = move-exception
                goto L79
            L27:
                if (r3 == 0) goto L39
                java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L36
                r5.<init>(r4)     // Catch: java.lang.Throwable -> L36
                boolean r3 = com.autonavi.base.amap.mapcore.FileUtil.deleteFile(r5)     // Catch: java.lang.Throwable -> L36
                if (r3 == 0) goto L39
                r3 = r1
                goto L3a
            L36:
                r2 = move-exception
                r1 = r3
                goto L79
            L39:
                r3 = r0
            L3a:
                if (r3 == 0) goto L54
                java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L36
                java.lang.String r2 = com.amap.api.col.p0003sl.v4.b(r2)     // Catch: java.lang.Throwable -> L36
                r4.<init>(r2)     // Catch: java.lang.Throwable -> L36
                boolean r2 = r4.exists()     // Catch: java.lang.Throwable -> L36
                if (r2 != 0) goto L4d
                r2 = r1
                goto L51
            L4d:
                boolean r2 = com.autonavi.base.amap.mapcore.FileUtil.deleteFile(r4)     // Catch: java.lang.Throwable -> L36
            L51:
                if (r2 == 0) goto L54
                goto L55
            L54:
                r1 = r0
            L55:
                com.amap.api.col.3sl.b0 r2 = com.amap.api.col.p0003sl.b0.this     // Catch: java.lang.Throwable -> L25
                com.amap.api.maps.interfaces.IGlOverlayLayer r2 = com.amap.api.col.p0003sl.b0.d(r2)     // Catch: java.lang.Throwable -> L25
                if (r2 == 0) goto L66
                com.amap.api.col.3sl.b0 r2 = com.amap.api.col.p0003sl.b0.this     // Catch: java.lang.Throwable -> L25
                com.amap.api.maps.interfaces.IGlOverlayLayer r2 = com.amap.api.col.p0003sl.b0.d(r2)     // Catch: java.lang.Throwable -> L25
                r2.clearTileCache()     // Catch: java.lang.Throwable -> L25
            L66:
                com.amap.api.col.3sl.b0 r0 = com.amap.api.col.p0003sl.b0.this     // Catch: java.lang.Throwable -> L74
                com.autonavi.base.ae.gmap.GLMapEngine r0 = r0.f3634c0     // Catch: java.lang.Throwable -> L74
                if (r0 == 0) goto L95
                com.amap.api.maps.AMap$OnCacheRemoveListener r0 = r6.f3754b     // Catch: java.lang.Throwable -> L74
                if (r0 == 0) goto L95
                r0.onRemoveCacheFinish(r1)     // Catch: java.lang.Throwable -> L74
                return
            L74:
                r0 = move-exception
                r0.printStackTrace()
                goto L95
            L79:
                com.amap.api.col.p0003sl.v4.a(r2)     // Catch: java.lang.Throwable -> L96
                java.lang.String r3 = "AMapDelegateImp"
                java.lang.String r4 = "RemoveCacheRunnable"
                com.amap.api.col.p0003sl.ka.a(r2, r3, r4)     // Catch: java.lang.Throwable -> L96
                com.amap.api.col.3sl.b0 r1 = com.amap.api.col.p0003sl.b0.this     // Catch: java.lang.Throwable -> L91
                com.autonavi.base.ae.gmap.GLMapEngine r1 = r1.f3634c0     // Catch: java.lang.Throwable -> L91
                if (r1 == 0) goto L95
                com.amap.api.maps.AMap$OnCacheRemoveListener r1 = r6.f3754b     // Catch: java.lang.Throwable -> L91
                if (r1 == 0) goto L95
                r1.onRemoveCacheFinish(r0)     // Catch: java.lang.Throwable -> L91
                goto L95
            L91:
                r0 = move-exception
                r0.printStackTrace()
            L95:
                return
            L96:
                r0 = move-exception
                com.amap.api.col.3sl.b0 r2 = com.amap.api.col.p0003sl.b0.this     // Catch: java.lang.Throwable -> La5
                com.autonavi.base.ae.gmap.GLMapEngine r2 = r2.f3634c0     // Catch: java.lang.Throwable -> La5
                if (r2 == 0) goto La9
                com.amap.api.maps.AMap$OnCacheRemoveListener r2 = r6.f3754b     // Catch: java.lang.Throwable -> La5
                if (r2 == 0) goto La9
                r2.onRemoveCacheFinish(r1)     // Catch: java.lang.Throwable -> La5
                goto La9
            La5:
                r1 = move-exception
                r1.printStackTrace()
            La9:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.3sl.b0.s0.run():void");
        }
    }

    public class t implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3756a;

        public t(boolean z5) {
            this.f3756a = z5;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b0 b0Var = b0.this;
                b0Var.f3634c0.setRoadArrowEnable(b0Var.f3660o, this.f3756a);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class u implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3758a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3759b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f3760c;

        public u(boolean z5, int i3, int i10) {
            this.f3758a = z5;
            this.f3759b = i3;
            this.f3760c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b0 b0Var = b0.this;
                b0Var.f3634c0.setNaviLabelEnable(b0Var.f3660o, this.f3758a, this.f3759b, this.f3760c);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class v implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f3762a;

        public v(boolean z5) {
            this.f3762a = z5;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b0.this.f3634c0.setMapOpenLayerEnable(this.f3762a);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class w implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f3764a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MyTrafficStyle f3765b;

        public w(byte[] bArr, MyTrafficStyle myTrafficStyle) {
            this.f3764a = bArr;
            this.f3765b = myTrafficStyle;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b0 b0Var = b0.this;
                b0Var.f3634c0.setTrafficStyleWithTexture(b0Var.f3660o, this.f3764a, this.f3765b);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class x implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f3767a;

        public x(byte[] bArr) {
            this.f3767a = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b0 b0Var = b0.this;
                b0Var.f3634c0.setTrafficStyleWithTextureData(b0Var.f3660o, this.f3767a);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class y implements Runnable {
        public y() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b0 b0Var = b0.this;
                b0Var.r.setAnchorX(Math.max(0, Math.min(b0Var.f3672u0, b0.this.f3644g0)));
                b0 b0Var2 = b0.this;
                b0Var2.r.setAnchorY(Math.max(0, Math.min(b0Var2.f3674v0, b0.this.f3647h0)));
                b0 b0Var3 = b0.this;
                b0Var3.f3634c0.setProjectionCenter(b0Var3.f3660o, b0.this.r.getAnchorX(), b0.this.r.getAnchorY());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class z extends p0 {
        public z() {
            super(null);
        }

        @Override // com.amap.api.col.3sl.b0.p0, java.lang.Runnable
        public void run() {
            this.f3737a = false;
            try {
                b0 b0Var = b0.this;
                b0Var.setCenterToPixel(b0Var.f3672u0, b0.this.f3674v0);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public b0(IGLSurfaceView iGLSurfaceView, Context context, AttributeSet attributeSet) {
        this(iGLSurfaceView, context, false);
    }

    public static void a(b0 b0Var, Bitmap bitmap, int i3) {
        b0Var.getClass();
        try {
            List a3 = b0Var.f3630b.a(AMap.onMapPrintScreenListener.class.hashCode());
            ArrayList arrayList = a3 != null ? new ArrayList(a3) : null;
            List a10 = b0Var.f3630b.a(AMap.OnMapScreenShotListener.class.hashCode());
            ArrayList arrayList2 = a10 != null ? new ArrayList(a10) : null;
            b0Var.f3630b.a(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()));
            b0Var.f3630b.a(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()));
            if (arrayList != null && arrayList.size() > 0) {
                synchronized (arrayList) {
                    for (int i10 = 0; i10 < arrayList.size(); i10++) {
                        try {
                            ((AMap.onMapPrintScreenListener) arrayList.get(i10)).onMapPrint(bitmap != null ? new BitmapDrawable(b0Var.f3631b0.getResources(), bitmap) : null);
                        } finally {
                        }
                    }
                }
            }
            if (arrayList2 == null || arrayList2.size() <= 0) {
                return;
            }
            synchronized (arrayList2) {
                for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                    try {
                        ((AMap.OnMapScreenShotListener) arrayList2.get(i11)).onMapScreenShot(bitmap);
                        ((AMap.OnMapScreenShotListener) arrayList2.get(i11)).onMapScreenShot(bitmap, i3);
                    } finally {
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void q(b0 b0Var) {
        b1 b1Var = b0Var.f3654l;
        if (b1Var != null) {
            b1Var.updateOverlaysPosition();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void accelerateNetworkInChinese(boolean z5) {
        com.autonavi.extra.b bVar = this.U0;
        if (bVar != null) {
            bVar.a("accelerateNetworkInChinese", Boolean.valueOf(z5));
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public AMap3DModelTileOverlay add3DModelTileOverlay(AMap3DModelTileOverlayOptions aMap3DModelTileOverlayOptions) throws RemoteException {
        try {
            resetRenderTime();
            String createId = this.f3656m.createId("AMAP3DMODELTILE");
            AMap3DModelTileOverlay aMap3DModelTileOverlay = new AMap3DModelTileOverlay(this.f3656m, aMap3DModelTileOverlayOptions, createId);
            this.f3656m.addOverlayObject(createId, aMap3DModelTileOverlay, aMap3DModelTileOverlayOptions);
            return aMap3DModelTileOverlay;
        } catch (Throwable th2) {
            v4.a(th2);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addAMapAppResourceListener(AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(Integer.valueOf(AMap.AMapAppResourceRequestListener.class.hashCode()), (Integer) aMapAppResourceRequestListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Arc addArc(ArcOptions arcOptions) throws RemoteException {
        if (arcOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            ArcOptions m5clone = arcOptions.m5clone();
            String createId = this.f3656m.createId("ARC");
            Arc arc = new Arc(this.f3656m, m5clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f3656m;
            return iGlOverlayLayer != null ? (Arc) iGlOverlayLayer.addOverlayObject(createId, arc, m5clone) : arc;
        } catch (Throwable th2) {
            v4.a(th2);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public BuildingOverlay addBuildingOverlay() {
        try {
            t4.a(this.f3631b0);
            String createId = this.f3656m.createId("BUILDINGOVERLAY");
            BuildingOverlay buildingOverlay = new BuildingOverlay(this.f3656m, createId);
            Field declaredField = BuildingOverlay.class.getDeclaredField("buildingOverlayTotalOptions");
            if (declaredField == null) {
                return null;
            }
            resetRenderTime();
            declaredField.setAccessible(true);
            Object obj = declaredField.get(buildingOverlay);
            IGlOverlayLayer iGlOverlayLayer = this.f3656m;
            return (iGlOverlayLayer == null || !(obj instanceof BaseOptions)) ? buildingOverlay : (BuildingOverlay) iGlOverlayLayer.addOverlayObject(createId, buildingOverlay, (BaseOptions) obj);
        } catch (Exception e10) {
            e10.printStackTrace();
            v4.a(e10);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Circle addCircle(CircleOptions circleOptions) throws RemoteException {
        if (circleOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            CircleOptions m7clone = circleOptions.m7clone();
            String createId = this.f3656m.createId("CIRCLE");
            Circle circle = new Circle(this.f3656m, m7clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f3656m;
            return iGlOverlayLayer != null ? (Circle) iGlOverlayLayer.addOverlayObject(createId, circle, m7clone) : circle;
        } catch (Throwable th2) {
            v4.a(th2);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public p5 addContourLineOverlay(o5 o5Var) {
        try {
            String createId = this.f3656m.createId("CONTOURLINE");
            p5 p5Var = new p5(this.f3656m, o5Var, createId);
            this.f3656m.addOverlayObject(createId, p5Var, o5Var);
            return p5Var;
        } catch (Exception e10) {
            v4.a(e10);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public CrossOverlay addCrossVector(CrossOverlayOptions crossOverlayOptions) {
        if (crossOverlayOptions == null || crossOverlayOptions.getRes() == null) {
            return null;
        }
        CrossVectorOverlay crossVectorOverlay = new CrossVectorOverlay(this.f3660o, this.f3631b0, this);
        crossVectorOverlay.setAttribute(crossOverlayOptions.getAttribute());
        queueEvent(new d0(crossVectorOverlay));
        crossVectorOverlay.resumeMarker(crossOverlayOptions.getRes());
        return new CrossOverlay(crossOverlayOptions, crossVectorOverlay);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public GL3DModel addGLModel(GL3DModelOptions gL3DModelOptions) {
        resetRenderTime();
        String createId = this.f3656m.createId("GL3DMODEL");
        GL3DModel gL3DModel = new GL3DModel(this.f3656m, gL3DModelOptions, createId);
        this.f3656m.addOverlayObject(createId, gL3DModel, gL3DModelOptions);
        return gL3DModel;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public GLTFOverlay addGLTFOverlay(GLTFOverlayOptions gLTFOverlayOptions) throws RemoteException {
        w0 w0Var;
        w0 w0Var2;
        try {
            this.C0 = true;
            w0Var = w0.b.f5207a;
            if (w0Var.b()) {
                w0Var2 = w0.b.f5207a;
                if (!w0Var2.a("feature_gltf")) {
                    v4.a(new AMapException(AMapException.FEATURE_GLTF_NOT_SUPPORT));
                    return null;
                }
            }
            resetRenderTime();
            GLTFOverlayOptions m8clone = gLTFOverlayOptions.m8clone();
            String createId = this.f3656m.createId("GLTFOVERLAY");
            GLTFOverlay gLTFOverlay = new GLTFOverlay(this.f3656m, m8clone, createId);
            this.f3656m.addOverlayObject(createId, gLTFOverlay, m8clone);
            return gLTFOverlay;
        } catch (Throwable th2) {
            v4.a(th2);
            return null;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void addGestureMapMessage(int i3, AbstractGestureMapMessage abstractGestureMapMessage) {
        if (!this.f3661o0 || this.f3634c0 == null) {
            return;
        }
        try {
            abstractGestureMapMessage.isUseAnchor = this.f3667s;
            abstractGestureMapMessage.anchorX = this.r.getAnchorX();
            abstractGestureMapMessage.anchorY = this.r.getAnchorY();
            this.f3634c0.addGestureMessage(i3, abstractGestureMapMessage, this.f3643g.isGestureScaleByMapCenter(), this.r.getAnchorX(), this.r.getAnchorY());
        } catch (RemoteException unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        if (groundOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            GroundOverlayOptions m9clone = groundOverlayOptions.m9clone();
            String createId = this.f3656m.createId("GROUNDOVERLAY");
            GroundOverlay groundOverlay = new GroundOverlay(this.f3656m, m9clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f3656m;
            return iGlOverlayLayer != null ? (GroundOverlay) iGlOverlayLayer.addOverlayObject(createId, groundOverlay, m9clone) : groundOverlay;
        } catch (Throwable th2) {
            v4.a(th2);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public HeatMapGridLayer addHeatMapGridLayer(HeatMapGridLayerOptions heatMapGridLayerOptions) throws RemoteException {
        try {
            resetRenderTime();
            if (heatMapGridLayerOptions == null) {
                return null;
            }
            String createId = this.f3656m.createId("HEATMAPGRIDLAYER");
            return (HeatMapGridLayer) this.f3656m.addOverlayObject(createId, new HeatMapGridLayer(this.f3656m, heatMapGridLayerOptions, createId), heatMapGridLayerOptions);
        } catch (Throwable th2) {
            v4.a(th2);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public HeatMapLayer addHeatMapLayer(HeatMapLayerOptions heatMapLayerOptions) throws RemoteException {
        try {
            resetRenderTime();
            if (heatMapLayerOptions == null) {
                return null;
            }
            String createId = this.f3656m.createId("HEATMAPLAYER");
            return (HeatMapLayer) this.f3656m.addOverlayObject(createId, new HeatMapLayer(this.f3656m, heatMapLayerOptions, createId), heatMapLayerOptions);
        } catch (Throwable th2) {
            v4.a(th2);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public MVTTileOverlay addMVTTileOverlay(MVTTileOverlayOptions mVTTileOverlayOptions) throws RemoteException {
        w0 w0Var;
        w0 w0Var2;
        try {
            this.D0 = true;
            w0Var = w0.b.f5207a;
            if (w0Var.b()) {
                w0Var2 = w0.b.f5207a;
                if (!w0Var2.a("feature_mvt")) {
                    v4.a(new AMapException(AMapException.FEATURE_MVT_NOT_SUPPORT));
                    return null;
                }
            }
            String createId = this.f3656m.createId("MVTTILEOVERLAY");
            MVTTileOverlay mVTTileOverlay = new MVTTileOverlay(this.f3656m, mVTTileOverlayOptions, createId);
            this.f3656m.addOverlayObject(createId, mVTTileOverlay, mVTTileOverlayOptions);
            return mVTTileOverlay;
        } catch (Throwable th2) {
            v4.a(th2);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Marker addMarker(MarkerOptions markerOptions) throws RemoteException {
        try {
            resetRenderTime();
            MarkerOptions m11clone = markerOptions.m11clone();
            String createId = this.f3656m.createId("MARKER");
            Marker marker = new Marker(this.f3656m, this.f3654l, m11clone, createId);
            if (m11clone != null ? marker.isIconView() : false) {
                this.f3654l.addNativeOverlay(marker, m11clone);
                return marker;
            }
            this.f3656m.addOverlayObject(createId, marker, m11clone);
            return marker;
        } catch (Throwable th2) {
            v4.a(th2);
            y4.a("[map][overlay]", "addMarker failed " + th2.getMessage(), markerOptions);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z5) throws RemoteException {
        int i3 = 0;
        try {
            resetRenderTime();
            ArrayList<Marker> arrayList2 = new ArrayList<>();
            LatLngBounds.Builder builder = LatLngBounds.builder();
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                MarkerOptions markerOptions = arrayList.get(i10);
                if (arrayList.get(i10) != null) {
                    arrayList2.add(addMarker(markerOptions));
                    if (markerOptions.getPosition() != null) {
                        builder.include(markerOptions.getPosition());
                    }
                }
            }
            if (z5 && arrayList2.size() > 0) {
                this.E0.postDelayed(new m(builder), 50L);
            }
            return arrayList2;
        } catch (Throwable th2) {
            v4.a(th2);
            String p8 = android.support.v4.media.session.e.p(th2, new StringBuilder("addMarkers failed "));
            int i11 = y4.f5460c;
            if (arrayList == null) {
                return null;
            }
            int size = arrayList.size();
            while (i3 < size) {
                MarkerOptions markerOptions2 = arrayList.get(i3);
                i3++;
                y4.a("[map][overlay]", p8, markerOptions2);
            }
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions multiPointOverlayOptions) throws RemoteException {
        if (multiPointOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            MultiPointOverlayOptions m12clone = multiPointOverlayOptions.m12clone();
            String createId = this.f3656m.createId("MULTIOVERLAY");
            MultiPointOverlay multiPointOverlay = new MultiPointOverlay(this.f3656m, m12clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f3656m;
            return iGlOverlayLayer != null ? (MultiPointOverlay) iGlOverlayLayer.addOverlayObject(createId, multiPointOverlay, m12clone) : multiPointOverlay;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public RouteOverlay addNaviRouteOverlay() {
        RouteOverlayInner routeOverlayInner = new RouteOverlayInner(this.f3660o, this.f3631b0, this);
        queueEvent(new e0(routeOverlayInner));
        return new RouteOverlay(routeOverlayInner);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) throws RemoteException {
        if (navigateArrowOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            NavigateArrowOptions m13clone = navigateArrowOptions.m13clone();
            String createId = this.f3656m.createId("NAVIGATEARROW");
            NavigateArrow navigateArrow = new NavigateArrow(this.f3656m, m13clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f3656m;
            return iGlOverlayLayer != null ? (NavigateArrow) iGlOverlayLayer.addOverlayObject(createId, navigateArrow, m13clone) : navigateArrow;
        } catch (Throwable th2) {
            v4.a(th2);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(Integer.valueOf(AMap.OnCameraChangeListener.class.hashCode()), (Integer) onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(Integer.valueOf(AMap.OnIndoorBuildingActiveListener.class.hashCode()), (Integer) onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(Integer.valueOf(AMap.OnInfoWindowClickListener.class.hashCode()), (Integer) onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(Integer.valueOf(AMap.OnMapClickListener.class.hashCode()), (Integer) onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(Integer.valueOf(AMap.OnMapLoadedListener.class.hashCode()), (Integer) onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(Integer.valueOf(AMap.OnMapLongClickListener.class.hashCode()), (Integer) onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(Integer.valueOf(AMap.OnMapTouchListener.class.hashCode()), (Integer) onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(Integer.valueOf(AMap.OnMarkerClickListener.class.hashCode()), (Integer) onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(Integer.valueOf(AMap.OnMarkerDragListener.class.hashCode()), (Integer) onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(Integer.valueOf(AMap.OnMyLocationChangeListener.class.hashCode()), (Integer) onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(Integer.valueOf(AMap.OnPOIClickListener.class.hashCode()), (Integer) onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(Integer.valueOf(AMap.OnPolylineClickListener.class.hashCode()), (Integer) onPolylineClickListener);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void addOverlayTexture(int i3, GLTextureProperty gLTextureProperty) {
        GLOverlayBundle overlayBundle;
        try {
            GLMapEngine gLMapEngine = this.f3634c0;
            if (gLMapEngine != null && (overlayBundle = gLMapEngine.getOverlayBundle(i3)) != null && gLTextureProperty.mBitmap != null) {
                this.f3634c0.addOverlayTexture(i3, gLTextureProperty);
                overlayBundle.addOverlayTextureItem(gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap.getWidth(), gLTextureProperty.mBitmap.getHeight());
            }
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public ParticleOverlay addParticleOverlay(ParticleOverlayOptions particleOverlayOptions) {
        if (particleOverlayOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            t4.e(this.f3631b0);
            String createId = this.f3656m.createId("PARTICLEOVERLAY");
            return (ParticleOverlay) this.f3656m.addOverlayObject(createId, new ParticleOverlay(this.f3656m, particleOverlayOptions, createId), particleOverlayOptions);
        } catch (Throwable th2) {
            v4.a(th2);
            th2.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addPoiFilter(PoiFilter poiFilter) {
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine == null) {
            return;
        }
        gLMapEngine.addPoiFilter(poiFilter);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Polygon addPolygon(PolygonOptions polygonOptions) throws RemoteException {
        if (polygonOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            PolygonOptions m14clone = polygonOptions.m14clone();
            String createId = this.f3656m.createId("POLYGON");
            Polygon polygon = new Polygon(this.f3656m, m14clone, createId);
            IGlOverlayLayer iGlOverlayLayer = this.f3656m;
            return iGlOverlayLayer != null ? (Polygon) iGlOverlayLayer.addOverlayObject(createId, polygon, m14clone) : polygon;
        } catch (Throwable th2) {
            v4.a(th2);
            String p8 = android.support.v4.media.session.e.p(th2, new StringBuilder("addPolygon failed "));
            int i3 = y4.f5460c;
            StringBuilder sb2 = new StringBuilder();
            List<LatLng> points = polygonOptions.getPoints();
            if (points != null) {
                sb2.append("points size =");
                sb2.append(points.size());
            }
            sb2.append(";width=");
            sb2.append(polygonOptions.getStrokeWidth());
            sb2.append(";fillColor=");
            sb2.append(polygonOptions.getFillColor());
            sb2.append(";strokeColor=");
            sb2.append(polygonOptions.getStrokeColor());
            sb2.append(";visible=");
            sb2.append(polygonOptions.isVisible());
            y4.c("[map][overlay]", p8 + " " + sb2.toString());
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Polyline addPolyline(PolylineOptions polylineOptions) throws RemoteException {
        if (polylineOptions == null) {
            return null;
        }
        try {
            resetRenderTime();
            String createId = this.f3656m.createId("POLYLINE");
            Polyline polyline = (Polyline) this.f3656m.addOverlayObject(createId, new Polyline(this.f3656m, polylineOptions, createId), polylineOptions);
            y4.d("[map][overlay]", "addPolyline " + createId);
            return polyline;
        } catch (Throwable th2) {
            v4.a(th2);
            String p8 = android.support.v4.media.session.e.p(th2, new StringBuilder("addPolyline failed "));
            int i3 = y4.f5460c;
            StringBuilder sb2 = new StringBuilder();
            List<LatLng> points = polylineOptions.getPoints();
            if (points != null) {
                sb2.append("points size =");
                sb2.append(points.size());
            }
            sb2.append(";width=");
            sb2.append(polylineOptions.getWidth());
            sb2.append(";color=");
            sb2.append(polylineOptions.getColor());
            sb2.append(";visible=");
            sb2.append(polylineOptions.isVisible());
            y4.c("[map][overlay]", p8 + " " + sb2.toString());
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void addSignleClickInterceptorListener(AMap.SignleClickInterceptorListener signleClickInterceptorListener) {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(Integer.valueOf(AMap.SignleClickInterceptorListener.class.hashCode()), (Integer) signleClickInterceptorListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Text addText(TextOptions textOptions) throws RemoteException {
        try {
            resetRenderTime();
            String createId = this.f3656m.createId("TEXT");
            TextOptions m15clone = textOptions.m15clone();
            MarkerOptions b3 = p3.b(m15clone);
            Marker marker = new Marker(this.f3656m, null, b3, createId);
            marker.setObject(m15clone.getObject());
            this.f3656m.addOverlayObject(createId, marker, b3);
            return new Text(marker, m15clone);
        } catch (Throwable th2) {
            v4.a(th2);
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        try {
            TileProvider tileProvider = tileOverlayOptions.getTileProvider();
            if (tileProvider != null && (tileProvider instanceof HeatmapTileProvider)) {
                t4.b(this.f3631b0);
            }
            String createId = this.f3656m.createId("TILEOVERLAY");
            TileOverlay tileOverlay = new TileOverlay(this.f3656m, tileOverlayOptions, createId);
            this.f3656m.addOverlayObject(createId, tileOverlay, tileOverlayOptions);
            return tileOverlay;
        } catch (Throwable th2) {
            v4.a(th2);
            return null;
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public void afterAnimation() {
        redrawInfoWindow();
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public void afterDrawFrame(int i3, GLMapState gLMapState) {
        float mapZoomer = gLMapState.getMapZoomer();
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine == null || (!gLMapEngine.isInMapAction(i3) && !this.f3634c0.isInMapAnimation(i3))) {
            int i10 = this.T;
            if (i10 != -1) {
                this.f3637d0.setRenderFps(i10);
            } else {
                this.f3637d0.setRenderFps(15.0f);
            }
            if (this.i0 != mapZoomer) {
                this.i0 = mapZoomer;
            }
        }
        if (this.f3666r0) {
            return;
        }
        this.f3666r0 = true;
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public void afterDrawLabel(int i3, GLMapState gLMapState) {
        g();
        com.autonavi.extra.b bVar = this.U0;
        if (bVar != null) {
            bVar.a(gLMapState, this.r);
        }
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.Z0 = this.f3656m.draw(1, this.Q, this.B0) ? this.Z0 : this.Z0 + 1;
        GLMapEngine gLMapEngine2 = this.f3634c0;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public void afterRendererOver(int i3, GLMapState gLMapState) {
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.f3656m.draw(2, this.Q, this.B0);
        GLMapEngine gLMapEngine2 = this.f3634c0;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
        CustomRenderer customRenderer = this.R;
        if (customRenderer != null) {
            customRenderer.onDrawFrame(null);
        }
        this.E0.sendEmptyMessage(41);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void animateCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        animateCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void animateCameraWithCallback(CameraUpdate cameraUpdate, AMap.CancelableCallback cancelableCallback) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        animateCameraWithDurationAndCallback(cameraUpdate.getCameraUpdateFactoryDelegate(), 250L, cancelableCallback);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, long j4, AMap.CancelableCallback cancelableCallback) {
        if (cameraUpdate == null) {
            return;
        }
        animateCameraWithDurationAndCallback(cameraUpdate.getCameraUpdateFactoryDelegate(), j4, cancelableCallback);
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public void beforeDrawLabel(int i3, GLMapState gLMapState) {
        g();
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine != null) {
            gLMapEngine.pushRendererState();
        }
        this.Z0 = this.f3656m.draw(0, this.Q, this.B0) ? this.Z0 : this.Z0 + 1;
        GLMapEngine gLMapEngine2 = this.f3634c0;
        if (gLMapEngine2 != null) {
            gLMapEngine2.popRendererState();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Pair<Float, LatLng> calculateZoomToSpanLevel(int i3, int i10, int i11, int i12, LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null && i3 == i10 && i10 == i11 && i11 == i12 && latLng.latitude == latLng2.latitude && latLng.longitude == latLng2.longitude) {
            return new Pair<>(Float.valueOf(getMaxZoomLevel()), latLng);
        }
        MapConfig mapConfig = this.r;
        if (latLng == null || latLng2 == null || !this.f3661o0 || this.f3662p.get()) {
            DPoint obtain = DPoint.obtain();
            GLMapState.geo2LonLat((int) mapConfig.getSX(), (int) mapConfig.getSY(), obtain);
            Pair<Float, LatLng> pair = new Pair<>(Float.valueOf(mapConfig.getSZ()), new LatLng(obtain.f6571y, obtain.f6570x));
            obtain.recycle();
            return pair;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng);
        builder.include(latLng2);
        GLMapState gLMapState = new GLMapState(this.f3660o, this.f3634c0.getNativeInstance());
        Pair<Float, IPoint> a3 = v4.a(mapConfig, i3, i10, i11, i12, builder.build(), this.f3644g0, this.f3647h0);
        gLMapState.recycle();
        if (a3 == null) {
            return null;
        }
        DPoint obtain2 = DPoint.obtain();
        IPoint iPoint = (IPoint) a3.second;
        GLMapState.geo2LonLat(((Point) iPoint).x, ((Point) iPoint).y, obtain2);
        Pair<Float, LatLng> pair2 = new Pair<>(a3.first, new LatLng(obtain2.f6571y, obtain2.f6570x));
        obtain2.recycle();
        return pair2;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean canShowIndoorSwitch() {
        v1 v1Var;
        if (d() < 17 || (v1Var = this.f3671u) == null || v1Var.e == null) {
            return false;
        }
        FPoint obtain = FPoint.obtain();
        Point point = this.f3671u.e;
        a(point.x, point.y, obtain);
        return this.H.contains((int) ((PointF) obtain).x, (int) ((PointF) obtain).y);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean canStopMapRender() {
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine == null) {
            return true;
        }
        gLMapEngine.canStopMapRender(this.f3660o);
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void changeGLOverlayIndex() {
        this.f3656m.changeOverlayIndex();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void changeLogoIconStyle(String str, boolean z5, int i3) {
        h5 h5Var = this.f3652k;
        if (h5Var != null) {
            ((g5) h5Var).a(str, Boolean.valueOf(z5), Integer.valueOf(i3));
        }
        h1 h1Var = this.f3643g;
        if (h1Var != null) {
            h1Var.f4256p.obtainMessage(6).sendToTarget();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void changeMapLogo(int i3, boolean z5) {
        if (this.f3662p.get()) {
            return;
        }
        try {
            List a3 = this.f3630b.a(AMapWidgetListener.class.hashCode());
            if (a3 == null || a3.size() <= 0) {
                return;
            }
            ((g5) this.f3652k).a(Boolean.valueOf(!z5));
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void changeSize(int i3, int i10) {
        MapConfig mapConfig = this.r;
        if (mapConfig != null) {
            this.f3644g0 = i3;
            this.f3647h0 = i10;
            mapConfig.setMapWidth(i3);
            this.r.setMapHeight(i10);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void changeSurface(int i3, GL10 gl10, int i10, int i11) {
        int i12;
        int i13;
        WindowManager windowManager;
        y4.b("[map][lifecycle]", "changeSurface " + i10 + " " + i11);
        this.f3666r0 = false;
        if (!this.f3661o0) {
            createSurface(i3, gl10, null);
        }
        y0 y0Var = this.f3639e0;
        if (y0Var != null && this.f3631b0 != null && ((this.f3644g0 != y0Var.b() || this.f3647h0 != this.f3639e0.a()) && (windowManager = (WindowManager) this.f3631b0.getSystemService("window")) != null)) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (defaultDisplay != null) {
                defaultDisplay.getRealMetrics(displayMetrics);
                this.f3639e0.a(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            if (this.f3673v != null && defaultDisplay != null) {
                this.f3673v.a(defaultDisplay.getRotation());
            }
        }
        this.f3644g0 = i10;
        this.f3647h0 = i11;
        this.H = new Rect(0, 0, i10, i11);
        Rect rect = new Rect(0, 0, this.f3644g0, this.f3647h0);
        int i14 = this.f3644g0;
        int i15 = this.f3647h0;
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine == null || i3 < 0) {
            i12 = 0;
        } else {
            int engineIDWithType = gLMapEngine.getEngineIDWithType(i3);
            if (this.f3634c0.isEngineCreated(engineIDWithType)) {
                int i16 = rect.left;
                int i17 = rect.top;
                int width = rect.width();
                int height = rect.height();
                i13 = engineIDWithType;
                a(i13, i16, i17, width, height, i14, i15);
            } else {
                int i18 = this.f3631b0.getResources().getDisplayMetrics().densityDpi;
                float f2 = this.f3631b0.getResources().getDisplayMetrics().density;
                NativeTextGenerate.getInstance().setDensity(f2);
                GLMapEngine.MapViewInitParam mapViewInitParam = new GLMapEngine.MapViewInitParam();
                mapViewInitParam.engineId = engineIDWithType;
                mapViewInitParam.f6840x = rect.left;
                mapViewInitParam.f6841y = rect.top;
                mapViewInitParam.width = rect.width();
                mapViewInitParam.height = rect.height();
                mapViewInitParam.screenWidth = i14;
                mapViewInitParam.screenHeight = i15;
                mapViewInitParam.screenScale = f2;
                mapViewInitParam.textScale = this.f3653k0 * f2;
                mapViewInitParam.mapZoomScale = this.f3651j0;
                mapViewInitParam.taskThreadCount = 3;
                this.f3634c0.createAMapEngineWithFrame(mapViewInitParam);
                GLMapState mapState = this.f3634c0.getMapState(engineIDWithType);
                mapState.setMapZoomer(this.r.getSZ());
                mapState.setCameraDegree(this.r.getSC());
                mapState.setMapAngle(this.r.getSR());
                mapState.setMapGeoCenter(this.r.getSX(), this.r.getSY());
                this.f3634c0.setMapState(engineIDWithType, mapState);
                this.f3651j0 = mapState.calMapZoomScalefactor(i14, i15, i18);
                this.f3634c0.setOvelayBundle(engineIDWithType, new GLOverlayBundle<>(engineIDWithType, this));
                i13 = engineIDWithType;
            }
            i12 = i13;
        }
        this.f3662p.set(false);
        this.f3660o = i12;
        y4.b("[map][lifecycle]", "create engine with frame complete");
        if (!this.f3663p0) {
            MapConfig mapConfig = this.r;
            if (mapConfig != null) {
                mapConfig.setMapZoomScale(this.f3651j0);
                this.r.setMapWidth(i10);
                this.r.setMapHeight(i11);
            }
            this.f3634c0.setIndoorEnable(this.f3660o, false);
            this.f3634c0.setSimple3DEnable(this.f3660o, false);
            this.f3634c0.setStyleChangeGradualEnable(this.f3660o, false);
            this.f3634c0.initMapOpenLayer("{\"bounds\" : [{\"x2\" : 235405312,\"x1\" : 188874751,\"y2\" : 85065727,\"y1\" : 122421247}],\"sublyr\" : [{\"type\" : 4,\"sid\" : 9000006,\"zlevel\" : 2}],\"id\" : 9006,\"minzoom\" : 6,\"update_period\" : 90,\"maxzoom\" : 20,\"cachemode\" : 2,\"url\" : \"http://mpsapi.amap.com/ws/mps/lyrdata/ugc/\"}".replace("mpsapi.amap.com", g9.b(this.f3631b0).a(21)));
            GLMapEngine.InitParam initParam = new GLMapEngine.InitParam();
            AeUtil.initIntersectionRes(this.f3631b0, initParam);
            this.f3634c0.setVectorOverlayPath(initParam.mIntersectionResPath);
            GLMapEngine gLMapEngine2 = this.f3634c0;
            if (gLMapEngine2 != null) {
                gLMapEngine2.setRenderFlags(true);
            }
        }
        synchronized (this) {
            this.f3663p0 = true;
        }
        if (this.f3667s) {
            this.r.setAnchorX(Math.max(1, Math.min(this.f3672u0, i10 - 1)));
            this.r.setAnchorY(Math.max(1, Math.min(this.f3674v0, i11 - 1)));
        } else {
            this.r.setAnchorX(i10 >> 1);
            this.r.setAnchorY(i11 >> 1);
        }
        this.f3634c0.setProjectionCenter(this.f3660o, this.r.getAnchorX(), this.r.getAnchorY());
        this.f3646h = true;
        p0 p0Var = this.Q0;
        if (p0Var.f3737a) {
            p0Var.run();
        }
        p0 p0Var2 = this.H0;
        if (p0Var2.f3737a) {
            p0Var2.run();
        }
        p0 p0Var3 = this.I0;
        if (p0Var3.f3737a) {
            p0Var3.run();
        }
        p0 p0Var4 = this.F0;
        if (p0Var4.f3737a) {
            p0Var4.run();
        }
        p0 p0Var5 = this.J0;
        if (p0Var5.f3737a) {
            p0Var5.run();
        }
        p0 p0Var6 = this.T0;
        if (p0Var6.f3737a) {
            p0Var6.run();
        }
        p0 p0Var7 = this.K0;
        if (p0Var7.f3737a) {
            p0Var7.run();
        }
        p0 p0Var8 = this.L0;
        if (p0Var8.f3737a) {
            p0Var8.run();
        }
        p0 p0Var9 = this.M0;
        if (p0Var9.f3737a) {
            p0Var9.run();
        }
        p0 p0Var10 = this.R0;
        if (p0Var10.f3737a) {
            p0Var10.run();
        }
        p0 p0Var11 = this.G0;
        if (p0Var11.f3737a) {
            p0Var11.run();
        }
        p0 p0Var12 = this.N0;
        if (p0Var12.f3737a) {
            p0Var12.run();
        }
        p0 p0Var13 = this.O0;
        if (p0Var13 != null) {
            p0Var13.run();
        }
        p0 p0Var14 = this.P0;
        if (p0Var14 != null) {
            p0Var14.run();
        }
        CustomRenderer customRenderer = this.R;
        if (customRenderer != null) {
            customRenderer.onSurfaceChanged(gl10, i10, i11);
        }
        com.autonavi.extra.b bVar = this.U0;
        if (bVar != null) {
            bVar.a(gl10, i10, i11);
        }
        Handler handler = this.E0;
        if (handler != null) {
            handler.post(this.S0);
        }
        redrawInfoWindow();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void checkMapState(IGLMapState iGLMapState) {
        char c9;
        char c10;
        if (this.r == null || this.f3662p.get()) {
            return;
        }
        LatLngBounds limitLatLngBounds = this.r.getLimitLatLngBounds();
        try {
            if (limitLatLngBounds == null) {
                if (this.r.isSetLimitZoomLevel()) {
                    iGLMapState.setMapZoomer(Math.max(this.r.getMinZoomLevel(), Math.min(iGLMapState.getMapZoomer(), this.r.getMaxZoomLevel())));
                    return;
                }
                return;
            }
            IPoint[] limitIPoints = this.r.getLimitIPoints();
            if (limitIPoints == null) {
                IPoint obtain = IPoint.obtain();
                LatLng latLng = limitLatLngBounds.northeast;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                IPoint obtain2 = IPoint.obtain();
                LatLng latLng2 = limitLatLngBounds.southwest;
                GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, obtain2);
                limitIPoints = new IPoint[]{obtain, obtain2};
                this.r.setLimitIPoints(limitIPoints);
            }
            MapConfig mapConfig = this.r;
            IPoint iPoint = limitIPoints[0];
            int i3 = ((Point) iPoint).x;
            int i10 = ((Point) iPoint).y;
            IPoint iPoint2 = limitIPoints[1];
            int i11 = ((Point) iPoint2).x;
            int i12 = ((Point) iPoint2).y;
            int i13 = this.f3644g0;
            int i14 = this.f3647h0;
            int i15 = v4.f5181b;
            float sz = mapConfig.getSZ();
            if (i3 == i11 || i10 == i12) {
                c9 = 0;
                c10 = 1;
            } else {
                c9 = 0;
                c10 = 1;
                sz = Math.max((float) v4.a(mapConfig.getMapZoomScale(), i13, Math.abs(i11 - i3)), (float) v4.a(mapConfig.getMapZoomScale(), i14, Math.abs(i12 - i10)));
            }
            float mapZoomer = iGLMapState.getMapZoomer();
            if (this.r.isSetLimitZoomLevel()) {
                float maxZoomLevel = this.r.getMaxZoomLevel();
                float minZoomLevel = this.r.getMinZoomLevel();
                sz = sz > maxZoomLevel ? maxZoomLevel : Math.max(sz, Math.min(mapZoomer, maxZoomLevel));
                if (sz < minZoomLevel) {
                    sz = minZoomLevel;
                }
            } else if (sz <= 0.0f || mapZoomer >= sz) {
                sz = mapZoomer;
            }
            iGLMapState.setMapZoomer(sz);
            IPoint obtain3 = IPoint.obtain();
            iGLMapState.getMapGeoCenter(obtain3);
            int i16 = ((Point) obtain3).x;
            int i17 = ((Point) obtain3).y;
            IPoint iPoint3 = limitIPoints[c9];
            IPoint[] iPointArr = limitIPoints;
            int i18 = ((Point) iPoint3).x;
            int i19 = ((Point) iPoint3).y;
            IPoint iPoint4 = iPointArr[c10];
            int[] a3 = v4.a(i18, i19, ((Point) iPoint4).x, ((Point) iPoint4).y, this.r, iGLMapState, i16, i17);
            if (a3.length == 2) {
                i16 = a3[c9];
                i17 = a3[c10];
            }
            iGLMapState.setMapGeoCenter(i16, i17);
            obtain3.recycle();
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float checkZoomLevel(float f2) throws RemoteException {
        return v4.a(this.r, f2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void clear() throws RemoteException {
        try {
            clear(false);
        } catch (Throwable th2) {
            ka.a(th2, "AMapDelegateImp", "clear");
            v4.a(th2);
            th2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void clearPoiFilter() {
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine == null) {
            return;
        }
        gLMapEngine.clearPoiFilter();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void clearTileCache() {
        this.f3656m.clearTileCache();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public long createGLOverlay(int i3) {
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine != null) {
            return gLMapEngine.createOverlay(this.f3660o, i3);
        }
        return 0L;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public String createId(String str) {
        IGlOverlayLayer iGlOverlayLayer = this.f3656m;
        if (iGlOverlayLayer != null) {
            return iGlOverlayLayer.createId(str);
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public int createOverlayTexture(int i3, Bitmap bitmap) {
        try {
            GLMapEngine gLMapEngine = this.f3634c0;
            if (gLMapEngine == null || bitmap == null) {
                return -1;
            }
            return gLMapEngine.createOverlayTexture(i3, bitmap);
        } catch (Throwable th2) {
            v4.a(th2);
        }
        return -1;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:3|4|(7:9|10|11|12|13|(1:15)|(3:17|18|19)(23:21|22|23|24|25|26|(1:30)|31|32|33|(2:35|36)|37|38|(2:42|43)|47|(1:51)|52|(1:54)|55|(1:57)|58|59|60))|64|10|11|12|13|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x005e, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c9, code lost:
    
        com.amap.api.col.p0003sl.v4.a(r2);
        com.amap.api.col.p0003sl.ka.a(r2, "AMapDElegateImp", "createSurface");
        com.amap.api.col.p0003sl.y4.a("[map][lifecycle]", "createSurface failed " + r2.getMessage());
        com.amap.api.col.p0003sl.t4.b(r5.f3631b0, "init failed:" + r2.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057 A[Catch: all -> 0x005e, TryCatch #2 {all -> 0x005e, blocks: (B:13:0x004f, B:15:0x0057, B:17:0x0062, B:22:0x0070, B:24:0x0082, B:26:0x0090, B:28:0x009b, B:30:0x009f, B:31:0x00a8, B:33:0x00b1, B:36:0x00bc, B:37:0x00c1), top: B:12:0x004f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0062 A[Catch: all -> 0x005e, TRY_LEAVE, TryCatch #2 {all -> 0x005e, blocks: (B:13:0x004f, B:15:0x0057, B:17:0x0062, B:22:0x0070, B:24:0x0082, B:26:0x0090, B:28:0x009b, B:30:0x009f, B:31:0x00a8, B:33:0x00b1, B:36:0x00bc, B:37:0x00c1), top: B:12:0x004f, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006e  */
    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void createSurface(int r6, javax.microedition.khronos.opengles.GL10 r7, javax.microedition.khronos.egl.EGLConfig r8) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.b0.createSurface(int, javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.egl.EGLConfig):void");
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void destroy() {
        this.f3662p.set(true);
        y4.b("[map][lifecycle]", "destroy map");
        try {
            LocationSource locationSource = this.f3675w;
            if (locationSource != null) {
                locationSource.deactivate();
            }
            this.f3675w = null;
            this.f3676w0 = null;
            GLMapRender gLMapRender = this.f3637d0;
            if (gLMapRender != null) {
                gLMapRender.renderPause();
            }
            b();
            Thread thread = this.J;
            if (thread != null) {
                thread.interrupt();
                this.J = null;
            }
            Thread thread2 = this.K;
            if (thread2 != null) {
                thread2.interrupt();
                this.K = null;
            }
            u0 u0Var = this.L;
            if (u0Var != null) {
                u0Var.a();
                this.L = null;
            }
            com.amap.api.col.p0003sl.p0 p0Var = this.N;
            if (p0Var != null) {
                p0Var.a();
                this.N = null;
            }
            s3 s3Var = this.W;
            if (s3Var != null) {
                s3Var.a();
                this.W = null;
            }
            u3 u3Var = this.X;
            if (u3Var != null) {
                u3Var.a(null);
                this.X.a();
                this.X = null;
            }
            n4.a();
            GLMapEngine gLMapEngine = this.f3634c0;
            if (gLMapEngine != null) {
                gLMapEngine.setMapListener(null);
                queueEvent(new c0());
                int i3 = 0;
                while (this.f3634c0 != null) {
                    int i10 = i3 + 1;
                    if (i3 >= 50) {
                        break;
                    }
                    try {
                        Thread.sleep(20L);
                    } catch (InterruptedException e10) {
                        v4.a(e10);
                    }
                    i3 = i10;
                }
            }
            IGLSurfaceView iGLSurfaceView = this.f3650j;
            if (iGLSurfaceView != null) {
                try {
                    iGLSurfaceView.onDetachedGLThread();
                } catch (Exception e11) {
                    e11.printStackTrace();
                    v4.a(e11);
                }
            }
            h5 h5Var = this.f3652k;
            if (h5Var != null) {
                ((g5) h5Var).b();
                this.f3652k = null;
            }
            m3 m3Var = this.f3673v;
            if (m3Var != null) {
                m3Var.g();
                this.f3673v = null;
            }
            this.f3675w = null;
            this.f3627a = null;
            com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
            if (n0Var != null) {
                n0Var.a();
            }
            y4.a();
            ka.c();
        } catch (Throwable th2) {
            ka.a(th2, "AMapDelegateImp", "destroy");
            v4.a(th2);
            th2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void destroySurface(int i3) {
        this.f3668s0.lock();
        try {
            if (this.f3661o0) {
                if (EGL14.eglGetCurrentContext() == EGL14.EGL_NO_CONTEXT || !(this.f3650j instanceof com.amap.api.col.p0003sl.l0)) {
                    q3 q3Var = this.f3678x0;
                    if (q3Var != null) {
                        synchronized (q3Var) {
                        }
                        this.f3678x0 = null;
                    }
                } else {
                    q3 q3Var2 = this.f3678x0;
                    if (q3Var2 != null) {
                        synchronized (q3Var2) {
                        }
                        this.f3678x0 = null;
                    }
                }
                GLMapEngine gLMapEngine = this.f3634c0;
                if (gLMapEngine != null) {
                    if (gLMapEngine.getOverlayBundle(this.f3660o) != null) {
                        this.f3634c0.getOverlayBundle(this.f3660o).removeAll(true);
                    }
                    this.f3634c0.destroyAMapEngine();
                    this.f3634c0 = null;
                    int i10 = this.Z0;
                    if (i10 > 0) {
                        t4.a(this.f3631b0, i10);
                    }
                    y4.b("[map][lifecycle]", "destroy engine complete");
                }
                com.autonavi.extra.b bVar = this.U0;
                if (bVar != null) {
                    bVar.b();
                }
            }
            this.f3661o0 = false;
            this.f3663p0 = false;
            this.f3666r0 = false;
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void drawFrame(GL10 gl10) {
        if (this.f3662p.get() || this.f3634c0 == null || EGL14.eglGetCurrentContext() == EGL14.EGL_NO_CONTEXT) {
            return;
        }
        MapConfig mapConfig = this.r;
        if (mapConfig != null && !mapConfig.isMapEnable()) {
            GLES20.glClear(16640);
            return;
        }
        int i3 = this.f3660o;
        int i10 = this.T;
        if (i10 != -1) {
            this.f3637d0.setRenderFps(i10);
            resetRenderTime();
        } else if (this.f3634c0.isInMapAction(i3) || this.f3657m0) {
            this.f3637d0.setRenderFps(40.0f);
        } else if (this.f3634c0.isInMapAnimation(i3)) {
            this.f3637d0.setRenderFps(30.0f);
            this.f3637d0.resetTickCount(15);
        } else if (this.f3656m.isGLTFAnimated()) {
            this.f3637d0.setRenderFps(30.0f);
            this.f3637d0.resetTickCount(15);
        } else {
            this.f3637d0.setRenderFps(15.0f);
        }
        if (this.r.isWorldMapEnable() != MapsInitializer.isLoadWorldGridMap()) {
            b(true);
            this.r.setWorldMapEnable(MapsInitializer.isLoadWorldGridMap());
        }
        this.f3634c0.renderAMap();
        this.f3634c0.pushRendererState();
        this.E0.sendEmptyMessage(30);
        com.amap.api.col.p0003sl.a0 a0Var = this.f3682z0;
        if (a0Var != null) {
            a0Var.i();
        }
        if (this.D > 0) {
            boolean canStopMapRender = this.f3634c0.canStopMapRender(this.f3660o);
            if (!canStopMapRender) {
                int i11 = this.D - 1;
                this.D = i11;
                if (i11 > 0) {
                    this.f3634c0.renderAMap();
                }
            }
            this.D = 0;
            Message obtainMessage = this.E0.obtainMessage(15, this.f3634c0.getScreenShot(this.f3660o, 0, 0, this.f3644g0, this.f3647h0));
            obtainMessage.arg1 = canStopMapRender ? 1 : 0;
            obtainMessage.sendToTarget();
        }
        if (!this.f3669t) {
            this.E0.sendEmptyMessage(16);
            this.f3669t = true;
            b(true);
        }
        long j4 = this.f3635c1;
        if (j4 < 2) {
            this.f3635c1 = j4 + 1;
        } else {
            c5 c9 = ((g5) this.f3652k).c();
            if (c9 != null && c9.getVisibility() != 8) {
                t4.a(this.f3631b0, System.currentTimeMillis() - this.A0);
                this.E0.post(new com.amap.api.col.p0003sl.e0(this, c9));
                this.f3634c0.setStyleChangeGradualEnable(this.f3660o, true);
            }
        }
        if (!this.f3665q0) {
            this.f3665q0 = true;
        }
        this.f3634c0.popRendererState();
        if (p4.b()) {
            try {
                if (this.f3650j instanceof com.amap.api.col.p0003sl.l0) {
                    if (this.Y == null) {
                        this.Y = new p4();
                    }
                    this.Y.f();
                    if (!this.Y.e() || this.Y.a()) {
                        return;
                    }
                    if (this.Y.a(((com.amap.api.col.p0003sl.l0) this.f3650j).getBitmap())) {
                        if (p4.c()) {
                            removecache(null);
                        }
                        if (p4.d()) {
                            this.Y.getClass();
                            ka.a(new Exception("BlackScreen"), "PureScreenCheckTool", "uploadInfo");
                        }
                        y4.a("[map][function][other]", "pure screen: found pure check");
                    }
                }
            } catch (Throwable th2) {
                ka.a(th2, "AMapDelegateImp", "PureScreenCheckTool.checkBlackScreen");
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void geo2Latlng(int i3, int i10, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(i3, i10, 20);
        dPoint.f6570x = pixelsToLatLong.f6570x;
        dPoint.f6571y = pixelsToLatLong.f6571y;
        pixelsToLatLong.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void geo2Map(int i3, int i10, FPoint fPoint) {
        ((PointF) fPoint).x = (int) (i3 - this.r.getSX());
        ((PointF) fPoint).y = (int) (i10 - this.r.getSY());
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public com.autonavi.extra.b getAMapExtraInterfaceManager() {
        return this.U0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Projection getAMapProjection() throws RemoteException {
        return new Projection(this.f3641f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public UiSettings getAMapUiSettings() throws RemoteException {
        if (this.e == null) {
            this.e = new UiSettings(this.f3643g);
        }
        return this.e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public AMapCameraInfo getCamerInfo() {
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getCameraAngle() {
        return getCameraDegree(this.f3660o);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getCameraDegree(int i3) {
        MapConfig mapConfig = this.r;
        if (mapConfig != null) {
            return mapConfig.getSC();
        }
        return 0.0f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public CameraPosition getCameraPosition() throws RemoteException {
        LatLng latLng;
        boolean z5 = this.f3667s;
        try {
            if (this.r == null) {
                return null;
            }
            if (!this.f3661o0 || this.f3664q || this.f3634c0 == null) {
                DPoint obtain = DPoint.obtain();
                DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((int) this.r.getSX(), (int) this.r.getSY(), 20);
                obtain.f6570x = pixelsToLatLong.f6570x;
                obtain.f6571y = pixelsToLatLong.f6571y;
                pixelsToLatLong.recycle();
                LatLng latLng2 = new LatLng(obtain.f6571y, obtain.f6570x);
                obtain.recycle();
                return CameraPosition.builder().target(latLng2).bearing(this.r.getSR()).tilt(this.r.getSC()).zoom(this.r.getSZ()).build();
            }
            if (z5) {
                DPoint obtain2 = DPoint.obtain();
                getPixel2LatLng(this.r.getAnchorX(), this.r.getAnchorY(), obtain2);
                latLng = new LatLng(obtain2.f6571y, obtain2.f6570x, false);
                obtain2.recycle();
            } else {
                MapConfig mapConfig = this.r;
                if (mapConfig != null) {
                    DPoint pixelsToLatLong2 = VirtualEarthProjection.pixelsToLatLong(mapConfig.getSX(), this.r.getSY(), 20);
                    LatLng latLng3 = new LatLng(pixelsToLatLong2.f6571y, pixelsToLatLong2.f6570x, false);
                    pixelsToLatLong2.recycle();
                    latLng = latLng3;
                } else {
                    latLng = null;
                }
            }
            return CameraPosition.builder().target(latLng).bearing(this.r.getSR()).tilt(this.r.getSC()).zoom(this.r.getSZ()).build();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public CameraPosition getCameraPositionPrj(boolean z5) {
        LatLng latLng;
        try {
            if (this.r == null) {
                return null;
            }
            if (!this.f3661o0 || this.f3664q || this.f3634c0 == null) {
                DPoint obtain = DPoint.obtain();
                DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((int) this.r.getSX(), (int) this.r.getSY(), 20);
                obtain.f6570x = pixelsToLatLong.f6570x;
                obtain.f6571y = pixelsToLatLong.f6571y;
                pixelsToLatLong.recycle();
                LatLng latLng2 = new LatLng(obtain.f6571y, obtain.f6570x);
                obtain.recycle();
                return CameraPosition.builder().target(latLng2).bearing(this.r.getSR()).tilt(this.r.getSC()).zoom(this.r.getSZ()).build();
            }
            if (z5) {
                DPoint obtain2 = DPoint.obtain();
                getPixel2LatLng(this.r.getAnchorX(), this.r.getAnchorY(), obtain2);
                latLng = new LatLng(obtain2.f6571y, obtain2.f6570x, false);
                obtain2.recycle();
            } else {
                MapConfig mapConfig = this.r;
                if (mapConfig != null) {
                    DPoint pixelsToLatLong2 = VirtualEarthProjection.pixelsToLatLong(mapConfig.getSX(), this.r.getSY(), 20);
                    LatLng latLng3 = new LatLng(pixelsToLatLong2.f6571y, pixelsToLatLong2.f6570x, false);
                    pixelsToLatLong2.recycle();
                    latLng = latLng3;
                } else {
                    latLng = null;
                }
            }
            return CameraPosition.builder().target(latLng).bearing(this.r.getSR()).tilt(this.r.getSC()).zoom(this.r.getSZ()).build();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public Context getContext() {
        return this.f3631b0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public String getCurrentWorldVectorMapStyle() {
        try {
            com.autonavi.extra.b bVar = this.U0;
            if (bVar == null) {
                return "";
            }
            Object a3 = bVar.a("getCurMapStyleKey");
            return a3 instanceof String ? (String) a3 : "";
        } catch (Throwable th2) {
            v4.a(th2);
            return "";
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public com.amap.api.col.p0003sl.a0 getCustomStyleManager() {
        return this.f3682z0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public int getEngineIDWithGestureInfo(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        GLMapEngine gLMapEngine = this.f3634c0;
        return gLMapEngine != null ? gLMapEngine.getEngineIDWithGestureInfo(eAMapPlatformGestureInfo) : this.f3660o;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float[] getFinalMatrix() {
        MapConfig mapConfig = this.r;
        return mapConfig != null ? mapConfig.getMvpMatrix() : this.f1;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public GLMapEngine getGLMapEngine() {
        return this.f3634c0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public View getGLMapView() {
        Object obj = this.f3650j;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void getGeoCenter(int i3, IPoint iPoint) {
        MapConfig mapConfig = this.r;
        if (mapConfig != null) {
            ((Point) iPoint).x = (int) mapConfig.getSX();
            ((Point) iPoint).y = (int) this.r.getSY();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public IGlOverlayLayer getGlOverlayLayer() {
        return this.f3656m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public long getGlOverlayMgrPtr() {
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine != null) {
            return gLMapEngine.getGlOverlayMgrPtr(this.f3660o);
        }
        return 0L;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public w1 getInfoWindowDelegate() {
        return this.f3636d;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void getLatLng2Map(double d5, double d8, FPoint fPoint) {
        IPoint obtain = IPoint.obtain();
        latlon2Geo(d5, d8, obtain);
        int i3 = ((Point) obtain).x;
        int i10 = ((Point) obtain).y;
        ((PointF) fPoint).x = (int) (i3 - this.r.getSX());
        ((PointF) fPoint).y = (int) (i10 - this.r.getSY());
        obtain.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void getLatLng2Pixel(double d5, double d8, IPoint iPoint) {
        if (this.f3662p.get() || !this.f3661o0 || this.f3634c0 == null) {
            return;
        }
        try {
            Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d5, d8, 20);
            FPoint obtain = FPoint.obtain();
            a(latLongToPixels.x, latLongToPixels.y, obtain);
            float f2 = -10000;
            if (((PointF) obtain).x == f2 && ((PointF) obtain).y == f2) {
                GLMapState gLMapState = (GLMapState) this.f3634c0.getNewMapState(this.f3660o);
                gLMapState.setCameraDegree(0.0f);
                gLMapState.recalculate();
                gLMapState.p20ToScreenPoint(latLongToPixels.x, latLongToPixels.y, obtain);
                gLMapState.recycle();
            }
            ((Point) iPoint).x = (int) ((PointF) obtain).x;
            ((Point) iPoint).y = (int) ((PointF) obtain).y;
            obtain.recycle();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void getLatLngRect(DPoint[] dPointArr) {
        try {
            Rectangle geoRectangle = this.r.getGeoRectangle();
            if (geoRectangle != null) {
                IPoint[] clipRect = geoRectangle.getClipRect();
                for (int i3 = 0; i3 < 4; i3++) {
                    IPoint iPoint = clipRect[i3];
                    GLMapState.geo2LonLat(((Point) iPoint).x, ((Point) iPoint).y, dPointArr[i3]);
                }
            }
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getLogoMarginRate(int i3) {
        h5 h5Var = this.f3652k;
        if (h5Var != null) {
            return ((g5) h5Var).a(i3);
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public int getLogoPosition() {
        try {
            return this.f3643g.getLogoPosition();
        } catch (RemoteException e10) {
            ka.a(e10, "AMapDelegateImp", "getLogoPosition");
            e10.printStackTrace();
            return 0;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Handler getMainHandler() {
        return this.E0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getMapAngle(int i3) {
        MapConfig mapConfig = this.r;
        if (mapConfig != null) {
            return mapConfig.getSR();
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public LatLngBounds getMapBounds(LatLng latLng, float f2, float f10, float f11) {
        int i3 = this.f3644g0;
        int i10 = this.f3647h0;
        if (i3 <= 0 || i10 <= 0 || this.f3662p.get()) {
            return null;
        }
        float a3 = v4.a(this.r, f2);
        GLMapState gLMapState = new GLMapState(this.f3660o, this.f3634c0.getNativeInstance());
        IPoint obtain = IPoint.obtain();
        latlon2Geo(latLng.latitude, latLng.longitude, obtain);
        gLMapState.setCameraDegree(f11);
        gLMapState.setMapAngle(f10);
        gLMapState.setMapGeoCenter(((Point) obtain).x, ((Point) obtain).y);
        gLMapState.setMapZoomer(a3);
        gLMapState.recalculate();
        obtain.recycle();
        DPoint obtain2 = DPoint.obtain();
        a(gLMapState, 0, 0, obtain2);
        LatLng latLng2 = new LatLng(obtain2.f6571y, obtain2.f6570x, false);
        a(gLMapState, i3, i10, obtain2);
        LatLng latLng3 = new LatLng(obtain2.f6571y, obtain2.f6570x, false);
        obtain2.recycle();
        gLMapState.recycle();
        return LatLngBounds.builder().include(latLng3).include(latLng2).build();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public MapConfig getMapConfig() {
        return this.r;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public String getMapContentApprovalNumber() {
        MapConfig mapConfig = this.r;
        if (mapConfig == null || mapConfig.isCustomStyleEnable()) {
            return null;
        }
        t4.c(this.f3631b0);
        String a3 = o4.a(this.f3631b0, "approval_number", "mc", "");
        return !TextUtils.isEmpty(a3) ? a3 : "GS（2024）2108号 | GS（2023）2175号";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getMapHeight() {
        return this.f3647h0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void getMapPrintScreen(AMap.onMapPrintScreenListener onmapprintscreenlistener) {
        try {
            this.f3630b.a(Integer.valueOf(AMap.onMapPrintScreenListener.class.hashCode()), (Integer) onmapprintscreenlistener);
            this.D = 20;
            this.E = true;
            resetRenderTime();
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public GLMapState getMapProjection() {
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine != null) {
            return gLMapEngine.getMapState(this.f3660o);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public List<Marker> getMapScreenMarkers() throws RemoteException {
        int i3 = this.f3644g0;
        int i10 = this.f3647h0;
        int i11 = v4.f5181b;
        if (i3 <= 0 || i10 <= 0) {
            Log.w("3dmap", "the map must have a size");
            return new ArrayList();
        }
        if (this.f3662p.get()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        List<Marker> mapScreenMarkers = this.f3656m.getMapScreenMarkers();
        if (mapScreenMarkers != null && !mapScreenMarkers.isEmpty()) {
            arrayList.addAll(mapScreenMarkers);
        }
        List<Marker> mapScreenMarkers2 = this.f3654l.getMapScreenMarkers();
        if (!((ArrayList) mapScreenMarkers2).isEmpty()) {
            arrayList.addAll(mapScreenMarkers2);
        }
        return arrayList;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void getMapScreenShot(AMap.OnMapScreenShotListener onMapScreenShotListener, boolean z5) {
        try {
            this.f3630b.a(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()), (Integer) onMapScreenShotListener);
            this.D = 20;
            this.E = z5;
            resetRenderTime();
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getMapTextZIndex() throws RemoteException {
        return this.Q;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getMapType() throws RemoteException {
        return this.I;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getMapWidth() {
        return this.f3644g0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getMapZoomScale() {
        return this.f3651j0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public int getMaskLayerType() {
        return this.S;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getMaxZoomLevel() {
        try {
            MapConfig mapConfig = this.r;
            if (mapConfig != null) {
                return mapConfig.getMaxZoomLevel();
            }
            return 20.0f;
        } catch (Throwable th2) {
            v4.a(th2);
            return 20.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getMinZoomLevel() {
        try {
            MapConfig mapConfig = this.r;
            if (mapConfig != null) {
                return mapConfig.getMinZoomLevel();
            }
            return 3.0f;
        } catch (Throwable th2) {
            v4.a(th2);
            return 3.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public Location getMyLocation() throws RemoteException {
        if (this.f3675w != null) {
            return this.f3627a.f4527b;
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public MyLocationStyle getMyLocationStyle() throws RemoteException {
        m3 m3Var = this.f3673v;
        if (m3Var != null) {
            return m3Var.d();
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getNativeEngineID() {
        return this.f3660o;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public long getNativeMapController() {
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine != null) {
            return gLMapEngine.getNativeMapController(this.f3660o);
        }
        return 0L;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public AMap.OnCameraChangeListener getOnCameraChangeListener() throws RemoteException {
        try {
            List a3 = this.f3630b.a(AMap.OnCameraChangeListener.class.hashCode());
            if (a3 == null && a3.size() != 0) {
                return (AMap.OnCameraChangeListener) a3.get(0);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public LatLngBounds getOverlayBoundRect(String str) {
        if (this.f3656m.isGLOverlay(str)) {
            Rect overlayBoundRect = this.f3656m.getOverlayBoundRect(str);
            DPoint obtain = DPoint.obtain();
            DPoint obtain2 = DPoint.obtain();
            MapProjection.geo2LonLat(overlayBoundRect.left, overlayBoundRect.bottom, obtain2);
            MapProjection.geo2LonLat(overlayBoundRect.right, overlayBoundRect.top, obtain);
            LatLng latLng = new LatLng(obtain.f6571y, obtain.f6570x);
            LatLng latLng2 = new LatLng(obtain2.f6571y, obtain2.f6570x);
            new LatLng(obtain2.f6571y, obtain.f6570x);
            new LatLng(obtain.f6571y, obtain2.f6570x);
            obtain2.recycle();
            obtain.recycle();
            return new LatLngBounds(latLng2, latLng);
        }
        Rect overlayBoundRect2 = this.f3654l.getOverlayBoundRect(str);
        DPoint obtain3 = DPoint.obtain();
        DPoint obtain4 = DPoint.obtain();
        getPixel2LatLng(overlayBoundRect2.left, overlayBoundRect2.bottom, obtain4);
        getPixel2LatLng(overlayBoundRect2.right, overlayBoundRect2.top, obtain3);
        LatLng latLng3 = new LatLng(obtain3.f6571y, obtain3.f6570x);
        LatLng latLng4 = new LatLng(obtain4.f6571y, obtain4.f6570x);
        new LatLng(obtain4.f6571y, obtain3.f6570x);
        new LatLng(obtain3.f6571y, obtain4.f6570x);
        obtain4.recycle();
        obtain3.recycle();
        return new LatLngBounds(latLng4, latLng3);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void getPixel2Geo(int i3, int i10, IPoint iPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.f3662p.get() || !this.f3661o0 || (gLMapEngine = this.f3634c0) == null || (mapState = gLMapEngine.getMapState(this.f3660o)) == null) {
            return;
        }
        mapState.screenToP20Point(i3, i10, iPoint);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void getPixel2LatLng(int i3, int i10, DPoint dPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.f3662p.get() || !this.f3661o0 || (gLMapEngine = this.f3634c0) == null || (mapState = gLMapEngine.getMapState(this.f3660o)) == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        mapState.screenToP20Point(i3, i10, obtain);
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(((Point) obtain).x, ((Point) obtain).y, 20);
        dPoint.f6570x = pixelsToLatLong.f6570x;
        dPoint.f6571y = pixelsToLatLong.f6571y;
        obtain.recycle();
        pixelsToLatLong.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getPreciseLevel(int i3) {
        MapConfig mapConfig = this.r;
        if (mapConfig != null) {
            return mapConfig.getSZ();
        }
        return 0.0f;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public IProjectionDelegate getProjection() throws RemoteException {
        return this.f3641f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float[] getProjectionMatrix() {
        MapConfig mapConfig = this.r;
        return mapConfig != null ? mapConfig.getProjectionMatrix() : this.f3648h1;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public Rect getRect() {
        return this.H;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getRenderMode() {
        return this.f3650j.getRenderMode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getSX() {
        MapConfig mapConfig = this.r;
        if (mapConfig != null) {
            return (int) mapConfig.getSX();
        }
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int getSY() {
        MapConfig mapConfig = this.r;
        if (mapConfig != null) {
            return (int) mapConfig.getSY();
        }
        return -1;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public String getSatelliteImageApprovalNumber() {
        t4.f(this.f3631b0);
        String a3 = o4.a(this.f3631b0, "approval_number", "si", "");
        return !TextUtils.isEmpty(a3) ? a3 : "GS（2025）0817号";
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getScalePerPixel() throws RemoteException {
        try {
            return ((float) ((((Math.cos((getCameraPosition().target.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, d()) * 256.0d))) * this.f3651j0;
        } catch (Throwable th2) {
            ka.a(th2, "AMapDelegateImp", "getScalePerPixel");
            v4.a(th2);
            th2.printStackTrace();
            return 0.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getSkyHeight() {
        return this.r.getSkyHeight();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public String getTerrainApprovalNumber() {
        t4.h(this.f3631b0);
        String a3 = o4.a(this.f3631b0, "approval_number", "te", "");
        return !TextUtils.isEmpty(a3) ? a3 : "GS(2021)6352号";
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public IUiSettingsDelegate getUiSettings() {
        return this.f3643g;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getUnitLengthByZoom(int i3) {
        GLMapState gLMapState = new GLMapState(this.f3660o, this.f3634c0.getNativeInstance());
        gLMapState.setMapZoomer(i3);
        gLMapState.recalculate();
        float gLUnitWithWin = gLMapState.getGLUnitWithWin(1);
        gLMapState.recycle();
        return gLUnitWithWin;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public View getView() throws RemoteException {
        h5 h5Var = this.f3652k;
        if (h5Var != null) {
            return (g5) h5Var;
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float[] getViewMatrix() {
        MapConfig mapConfig = this.r;
        return mapConfig != null ? mapConfig.getViewMatrix() : this.f3645g1;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public Point getWaterMarkerPositon() {
        h5 h5Var = this.f3652k;
        return h5Var != null ? ((g5) h5Var).e() : new Point();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public String getWorldVectorMapLanguage() {
        return this.V0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public String getWorldVectorMapStyle() {
        return this.W0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float getZoomLevel() {
        return d();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        try {
            MapConfig mapConfig = this.r;
            if (latLng == null || latLng2 == null || !this.f3661o0 || this.f3662p.get()) {
                return mapConfig.getSZ();
            }
            Pair<Float, IPoint> a3 = v4.a(mapConfig, 0, 0, 0, 0, new LatLngBounds.Builder().include(latLng).include(latLng2).build(), this.f3644g0, this.f3647h0);
            if (a3 != null) {
                return ((Float) a3.first).floatValue();
            }
            GLMapState gLMapState = new GLMapState(this.f3660o, this.f3634c0.getNativeInstance());
            float mapZoomer = gLMapState.getMapZoomer();
            gLMapState.recycle();
            return mapZoomer;
        } catch (Throwable th2) {
            v4.a(th2);
            return 0.0f;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public int hideBuildings(List<LatLng> list) {
        if (this.f3634c0 == null) {
            return -1;
        }
        FutureTask futureTask = new FutureTask(new h0(list));
        queueEvent(futureTask);
        try {
            return ((Integer) futureTask.get()).intValue();
        } catch (InterruptedException e10) {
            e10.printStackTrace();
            return -1;
        } catch (ExecutionException e11) {
            e11.printStackTrace();
            return -1;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void hideInfoWindow() {
        IInfoWindowAction a3;
        w1 w1Var = this.f3636d;
        if (w1Var == null || (a3 = w1Var.a()) == null) {
            return;
        }
        a3.hideInfoWindow();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isIndoorEnabled() throws RemoteException {
        return this.r.isIndoorEnable();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean isLockMapAngle(int i3) {
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine != null) {
            return gLMapEngine.getSrvViewStateBoolValue(i3, 7);
        }
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean isLockMapCameraDegree(int i3) {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isMaploaded() {
        return this.f3669t;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isMyLocationEnabled() throws RemoteException {
        return this.f3658n;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean isOverseaAuthed() {
        com.amap.api.col.p0003sl.p0 p0Var = this.N;
        return p0Var != null && p0Var.b() == 2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isTouchPoiEnable() {
        MapConfig mapConfig = this.r;
        if (mapConfig != null) {
            return mapConfig.isTouchPoiEnable();
        }
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isTrafficEnabled() throws RemoteException {
        return this.r.isTrafficEnabled();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean isUseAnchor() {
        return this.f3667s;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean isUseForNavi() {
        return this.U;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean isUseGLTF() {
        return this.C0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean isUseMVT() {
        return this.D0;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void latlon2Geo(double d5, double d8, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d5, d8, 20);
        ((Point) iPoint).x = latLongToPixels.x;
        ((Point) iPoint).y = latLongToPixels.y;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void loadWorldVectorMap(boolean z5) {
        MapConfig mapConfig = this.r;
        if (mapConfig != null) {
            mapConfig.setAbroadEnable(z5);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void map2Geo(float f2, float f10, IPoint iPoint) {
        ((Point) iPoint).x = (int) (this.r.getSX() + f2);
        ((Point) iPoint).y = (int) (this.r.getSY() + f10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void moveCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate == null) {
            return;
        }
        try {
            moveCamera(cameraUpdate.getCameraUpdateFactoryDelegate());
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void onAMapAppResourceRequest(AMapAppRequestParam aMapAppRequestParam) {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var == null) {
            return;
        }
        for (AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener : n0Var.a(AMap.AMapAppResourceRequestListener.class.hashCode())) {
            if (aMapAppResourceRequestListener != null) {
                aMapAppResourceRequestListener.onRequest(aMapAppRequestParam);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void onActivityPause() {
        this.f3664q = true;
        b(this.f3660o);
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine != null) {
            gLMapEngine.setRenderFlags(false);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void onActivityResume() {
        GLMapEngine gLMapEngine;
        this.f3664q = false;
        queueEvent(new com.amap.api.col.p0003sl.g0(this, this.f3660o));
        GLMapRender gLMapRender = this.f3637d0;
        if (gLMapRender != null) {
            gLMapRender.renderResume();
        }
        if (!this.f3661o0 || (gLMapEngine = this.f3634c0) == null) {
            return;
        }
        gLMapEngine.setRenderFlags(true);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void onChangeFinish() {
        Message obtainMessage = this.E0.obtainMessage();
        obtainMessage.what = 11;
        this.E0.sendMessage(obtainMessage);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean onDoubleTap(int i3, MotionEvent motionEvent) {
        AbstractCameraUpdateMessage a3;
        if (!this.f3661o0) {
            return false;
        }
        int x10 = (int) motionEvent.getX();
        int y4 = (int) motionEvent.getY();
        if (this.f3661o0 && ((int) d()) < this.r.getMaxZoomLevel()) {
            try {
                if (this.f3667s) {
                    a3 = com.amap.api.col.p0003sl.x.a(1.0f, (Point) null);
                } else if (this.f3643g.isZoomInByScreenCenter()) {
                    a3 = com.amap.api.col.p0003sl.x.a(1.0f, (Point) null);
                } else {
                    Point point = this.f3632b1;
                    point.x = x10;
                    point.y = y4;
                    a3 = com.amap.api.col.p0003sl.x.a(1.0f, point);
                }
                animateCameraWithDurationAndCallback(a3, 250L, (AMap.CancelableCallback) null);
            } catch (Throwable th2) {
                ka.a(th2, "AMapDelegateImp", "onDoubleTap");
                th2.printStackTrace();
            }
            resetRenderTime();
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void onFling() {
        IGlOverlayLayer iGlOverlayLayer = this.f3656m;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.setFlingState(true);
        }
        this.C = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x00c0 A[Catch: all -> 0x007f, TRY_LEAVE, TryCatch #0 {all -> 0x007f, blocks: (B:16:0x0004, B:18:0x0007, B:19:0x0060, B:21:0x0064, B:23:0x0074, B:24:0x0081, B:26:0x0087, B:28:0x0091, B:31:0x0095, B:33:0x009f, B:34:0x00a3, B:36:0x00a7, B:4:0x00b5, B:6:0x00c0), top: B:15:0x0004 }] */
    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onIndoorBuildingActivity(int r8, byte[] r9) {
        /*
            r7 = this;
            java.lang.String r8 = "utf-8"
            if (r9 == 0) goto Lb4
            int r0 = r9.length     // Catch: java.lang.Throwable -> L7f
            if (r0 <= 0) goto Lb4
            com.amap.api.col.3sl.v1 r0 = new com.amap.api.col.3sl.v1     // Catch: java.lang.Throwable -> L7f
            r0.<init>()     // Catch: java.lang.Throwable -> L7f
            r1 = 0
            r2 = r9[r1]     // Catch: java.lang.Throwable -> L7f
            java.lang.String r3 = new java.lang.String     // Catch: java.lang.Throwable -> L7f
            r4 = 1
            r3.<init>(r9, r4, r2, r8)     // Catch: java.lang.Throwable -> L7f
            int r3 = r2 + 1
            int r2 = r2 + 2
            r3 = r9[r3]     // Catch: java.lang.Throwable -> L7f
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> L7f
            r4.<init>(r9, r2, r3, r8)     // Catch: java.lang.Throwable -> L7f
            int r2 = r2 + r3
            int r3 = r2 + 1
            r2 = r9[r2]     // Catch: java.lang.Throwable -> L7f
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> L7f
            r4.<init>(r9, r3, r2, r8)     // Catch: java.lang.Throwable -> L7f
            r0.activeFloorName = r4     // Catch: java.lang.Throwable -> L7f
            int r3 = r3 + r2
            int r2 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(r9, r3)     // Catch: java.lang.Throwable -> L7f
            r0.activeFloorIndex = r2     // Catch: java.lang.Throwable -> L7f
            int r2 = r3 + 4
            int r3 = r3 + 5
            r2 = r9[r2]     // Catch: java.lang.Throwable -> L7f
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> L7f
            r4.<init>(r9, r3, r2, r8)     // Catch: java.lang.Throwable -> L7f
            r0.poiid = r4     // Catch: java.lang.Throwable -> L7f
            int r3 = r3 + r2
            int r2 = r3 + 1
            r3 = r9[r3]     // Catch: java.lang.Throwable -> L7f
            java.lang.String r4 = new java.lang.String     // Catch: java.lang.Throwable -> L7f
            r4.<init>(r9, r2, r3, r8)     // Catch: java.lang.Throwable -> L7f
            int r2 = r2 + r3
            int r3 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(r9, r2)     // Catch: java.lang.Throwable -> L7f
            r0.f5170a = r3     // Catch: java.lang.Throwable -> L7f
            int r2 = r2 + 4
            int[] r4 = new int[r3]     // Catch: java.lang.Throwable -> L7f
            r0.floor_indexs = r4     // Catch: java.lang.Throwable -> L7f
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L7f
            r0.floor_names = r4     // Catch: java.lang.Throwable -> L7f
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L7f
            r0.f5171b = r3     // Catch: java.lang.Throwable -> L7f
            r3 = r1
        L60:
            int r4 = r0.f5170a     // Catch: java.lang.Throwable -> L7f
            if (r3 >= r4) goto L95
            int[] r4 = r0.floor_indexs     // Catch: java.lang.Throwable -> L7f
            int r5 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(r9, r2)     // Catch: java.lang.Throwable -> L7f
            r4[r3] = r5     // Catch: java.lang.Throwable -> L7f
            int r4 = r2 + 4
            int r2 = r2 + 5
            r4 = r9[r4]     // Catch: java.lang.Throwable -> L7f
            if (r4 <= 0) goto L81
            java.lang.String[] r5 = r0.floor_names     // Catch: java.lang.Throwable -> L7f
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Throwable -> L7f
            r6.<init>(r9, r2, r4, r8)     // Catch: java.lang.Throwable -> L7f
            r5[r3] = r6     // Catch: java.lang.Throwable -> L7f
            int r2 = r2 + r4
            goto L81
        L7f:
            r8 = move-exception
            goto Lc4
        L81:
            int r4 = r2 + 1
            r2 = r9[r2]     // Catch: java.lang.Throwable -> L7f
            if (r2 <= 0) goto L91
            java.lang.String[] r5 = r0.f5171b     // Catch: java.lang.Throwable -> L7f
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Throwable -> L7f
            r6.<init>(r9, r4, r2, r8)     // Catch: java.lang.Throwable -> L7f
            r5[r3] = r6     // Catch: java.lang.Throwable -> L7f
            int r4 = r4 + r2
        L91:
            r2 = r4
            int r3 = r3 + 1
            goto L60
        L95:
            int r8 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(r9, r2)     // Catch: java.lang.Throwable -> L7f
            r0.f5172c = r8     // Catch: java.lang.Throwable -> L7f
            int r2 = r2 + 4
            if (r8 <= 0) goto Lb5
            int[] r8 = new int[r8]     // Catch: java.lang.Throwable -> L7f
            r0.f5173d = r8     // Catch: java.lang.Throwable -> L7f
        La3:
            int r8 = r0.f5172c     // Catch: java.lang.Throwable -> L7f
            if (r1 >= r8) goto Lb5
            int[] r8 = r0.f5173d     // Catch: java.lang.Throwable -> L7f
            int r3 = com.autonavi.base.amap.mapcore.tools.GLConvertUtil.getInt(r9, r2)     // Catch: java.lang.Throwable -> L7f
            r8[r1] = r3     // Catch: java.lang.Throwable -> L7f
            int r2 = r2 + 4
            int r1 = r1 + 1
            goto La3
        Lb4:
            r0 = 0
        Lb5:
            r7.f3638d1 = r0     // Catch: java.lang.Throwable -> L7f
            com.amap.api.col.3sl.b0$b0 r8 = new com.amap.api.col.3sl.b0$b0     // Catch: java.lang.Throwable -> L7f
            r8.<init>()     // Catch: java.lang.Throwable -> L7f
            com.autonavi.base.amap.api.mapcore.IGLSurfaceView r9 = r7.f3650j     // Catch: java.lang.Throwable -> L7f
            if (r9 == 0) goto Lca
            r9.post(r8)     // Catch: java.lang.Throwable -> L7f
            return
        Lc4:
            com.amap.api.col.p0003sl.v4.a(r8)
            r8.printStackTrace()
        Lca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.b0.onIndoorBuildingActivity(int, byte[]):void");
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void onLongPress(int i3, MotionEvent motionEvent) {
        boolean z5;
        try {
            queueEvent(new com.amap.api.col.p0003sl.f0(this, i3));
            BaseOverlay hitBaseOverlay = this.f3656m.getHitBaseOverlay(motionEvent, 1);
            if (hitBaseOverlay instanceof Marker) {
                this.f3681z = (Marker) hitBaseOverlay;
            }
            DPoint obtain = DPoint.obtain();
            obtain.f6570x = motionEvent.getX();
            obtain.f6571y = motionEvent.getY();
            BaseOverlay hitOverlay = this.f3654l.getHitOverlay(obtain, 1);
            int i10 = 0;
            if (hitOverlay instanceof Marker) {
                this.f3681z = (Marker) hitOverlay;
                z5 = true;
            } else {
                z5 = false;
            }
            obtain.recycle();
            BaseOverlay hitBaseOverlay2 = this.f3656m.getHitBaseOverlay(motionEvent, 3);
            if (hitBaseOverlay2 instanceof GLTFOverlay) {
                this.A = (GLTFOverlay) hitBaseOverlay2;
            }
            Marker marker = this.f3681z;
            if (marker == null || !marker.isDraggable()) {
                GLTFOverlay gLTFOverlay = this.A;
                if (gLTFOverlay == null || !gLTFOverlay.isDraggable()) {
                    List a3 = this.f3630b.a(AMap.OnMapLongClickListener.class.hashCode());
                    if (a3 != null && a3.size() > 0) {
                        DPoint obtain2 = DPoint.obtain();
                        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain2);
                        synchronized (a3) {
                            while (i10 < a3.size()) {
                                try {
                                    ((AMap.OnMapLongClickListener) a3.get(i10)).onMapLongClick(new LatLng(obtain2.f6571y, obtain2.f6570x));
                                    i10++;
                                } finally {
                                }
                            }
                        }
                        this.B = true;
                        obtain2.recycle();
                    }
                } else {
                    LatLng latlng = this.A.getLatlng();
                    if (latlng != null) {
                        IPoint obtain3 = IPoint.obtain();
                        getLatLng2Pixel(latlng.latitude, latlng.longitude, obtain3);
                        ((Point) obtain3).y -= 60;
                        DPoint obtain4 = DPoint.obtain();
                        getPixel2LatLng(((Point) obtain3).x, ((Point) obtain3).y, obtain4);
                        this.A.setLatLng(new LatLng(obtain4.f6571y, obtain4.f6570x));
                        this.f3656m.set2Top(this.A.getId());
                        this.f3679y = true;
                        obtain3.recycle();
                        obtain4.recycle();
                    }
                }
            } else {
                LatLng position = this.f3681z.getPosition();
                if (position != null) {
                    IPoint obtain5 = IPoint.obtain();
                    getLatLng2Pixel(position.latitude, position.longitude, obtain5);
                    ((Point) obtain5).y -= 60;
                    DPoint obtain6 = DPoint.obtain();
                    getPixel2LatLng(((Point) obtain5).x, ((Point) obtain5).y, obtain6);
                    this.f3681z.setPosition(new LatLng(obtain6.f6571y, obtain6.f6570x));
                    if (z5) {
                        this.f3654l.set2Top(this.f3681z.getId());
                    } else {
                        this.f3656m.set2Top(this.f3681z.getId());
                    }
                    try {
                        List a10 = this.f3630b.a(AMap.OnMarkerDragListener.class.hashCode());
                        if (a10 != null && a10.size() > 0) {
                            synchronized (a10) {
                                while (i10 < a10.size()) {
                                    try {
                                        ((AMap.OnMarkerDragListener) a10.get(i10)).onMarkerDragStart(this.f3681z);
                                        i10++;
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        ka.a(th3, "AMapDelegateImp", "onMarkerDragStart");
                        th3.printStackTrace();
                    }
                    this.f3677x = true;
                    obtain5.recycle();
                    obtain6.recycle();
                }
            }
            this.f3637d0.resetTickCount(30);
        } catch (Throwable th4) {
            ka.a(th4, "AMapDelegateImp", "onLongPress");
            th4.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public void onMapBlankClick(double d5, double d8) {
        this.E0.post(new com.amap.api.col.p0003sl.d0(this, d5, d8));
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAMapListener
    public void onMapPOIClick(MapPoi mapPoi) {
        List a3;
        MapConfig mapConfig = this.r;
        if (mapConfig == null || !mapConfig.isTouchPoiEnable() || (a3 = this.f3630b.a(AMap.OnPOIClickListener.class.hashCode())) == null || a3.size() <= 0 || mapPoi == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 20;
        obtain.obj = new Poi(mapPoi.getName(), new LatLng(mapPoi.getLatitude(), mapPoi.getLongitude()), mapPoi.getPoiid());
        this.E0.sendMessage(obtain);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void onPause() {
        GLMapState gLMapState;
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine != null && (gLMapState = (GLMapState) gLMapEngine.getNewMapState(this.f3660o)) != null) {
            IPoint obtain = IPoint.obtain();
            gLMapState.recalculate();
            gLMapState.getMapGeoCenter(obtain);
            this.r.setSX(((Point) obtain).x);
            this.r.setSY(((Point) obtain).y);
            this.r.setSZ(gLMapState.getMapZoomer());
            this.r.setSC(gLMapState.getCameraDegree());
            this.r.setSR(gLMapState.getMapAngle());
            gLMapState.recycle();
            obtain.recycle();
        }
        IGlOverlayLayer iGlOverlayLayer = this.f3656m;
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.setFlingState(false);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void onResume() {
        try {
            this.f3637d0.setRenderFps(15.0f);
            this.f3650j.setRenderMode(0);
            IGlOverlayLayer iGlOverlayLayer = this.f3656m;
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.setFlingState(true);
            }
            m3 m3Var = this.f3673v;
            if (m3Var != null) {
                m3Var.f();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean onSingleTapConfirmed(int i3, MotionEvent motionEvent) {
        if (!this.f3661o0) {
            return false;
        }
        try {
            queueEvent(new com.amap.api.col.p0003sl.f0(this, i3));
            if (d(motionEvent) || e(motionEvent) || g(motionEvent) || f(motionEvent) || h(motionEvent) || c(motionEvent)) {
                return true;
            }
            queueEvent(new com.amap.api.col.p0003sl.c0(this, motionEvent));
            return true;
        } catch (Throwable th2) {
            ka.a(th2, "AMapDelegateImp", "onSingleTapUp");
            th2.printStackTrace();
            return true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f3664q || !this.f3661o0 || !this.f3655l0) {
            return false;
        }
        EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f3629a1;
        eAMapPlatformGestureInfo.mGestureState = 3;
        eAMapPlatformGestureInfo.mGestureType = 8;
        eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
        getEngineIDWithGestureInfo(this.f3629a1);
        GLMapRender gLMapRender = this.f3637d0;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            f();
            if (this.f3661o0) {
                this.f3639e0.c();
                this.f3642f0 = true;
                this.f3657m0 = true;
                try {
                    GLMapEngine gLMapEngine = this.f3634c0;
                    if (gLMapEngine != null) {
                        gLMapEngine.interruptAnimation();
                    }
                    resetRenderTime();
                } catch (Throwable th2) {
                    try {
                        v4.a(th2);
                    } catch (RemoteException unused) {
                    }
                }
            }
        } else if (action == 1) {
            this.f3642f0 = true;
            this.f3657m0 = false;
            if (this.B) {
                this.B = false;
            }
            try {
                if (this.f3677x) {
                    List a3 = this.f3630b.a(AMap.OnMarkerDragListener.class.hashCode());
                    if (a3 != null && a3.size() > 0 && this.f3681z != null) {
                        synchronized (a3) {
                            for (int i3 = 0; i3 < a3.size(); i3++) {
                                try {
                                    ((AMap.OnMarkerDragListener) a3.get(i3)).onMarkerDragEnd(this.f3681z);
                                } finally {
                                }
                            }
                        }
                    }
                    this.f3681z = null;
                    this.f3677x = false;
                }
            } catch (Throwable th3) {
                ka.a(th3, "AMapDelegateImp", "OnMarkerDragListener.onMarkerDragEnd");
                th3.printStackTrace();
            }
            if (this.f3679y) {
                if (this.A != null) {
                    this.A = null;
                }
                this.f3679y = false;
            }
        }
        if (motionEvent.getAction() == 2 && this.f3677x) {
            try {
                b(motionEvent);
            } catch (Throwable th4) {
                ka.a(th4, "AMapDelegateImp", "onDragMarker");
                th4.printStackTrace();
            }
            return true;
        }
        if (motionEvent.getAction() == 2 && this.f3679y) {
            try {
                a(motionEvent);
            } catch (Throwable th5) {
                ka.a(th5, "AMapDelegateImp", "onDragGLTF");
                th5.printStackTrace();
            }
            return true;
        }
        if (this.f3642f0) {
            try {
                List a10 = this.f3630b.a(AMap.SignleClickInterceptorListener.class.hashCode());
                if (a10 == null || a10.size() <= 0) {
                    this.f3639e0.a(motionEvent);
                } else if (!((AMap.SignleClickInterceptorListener) a10.get(0)).isInterceptorSignleClick(motionEvent)) {
                    this.f3639e0.a(motionEvent);
                }
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
        }
        try {
            List a11 = this.f3630b.a(AMap.OnMapTouchListener.class.hashCode());
            if (a11 != null && a11.size() > 0) {
                this.E0.removeMessages(14);
                Message obtainMessage = this.E0.obtainMessage();
                obtainMessage.what = 14;
                obtainMessage.obj = MotionEvent.obtain(motionEvent);
                obtainMessage.sendToTarget();
            }
        } catch (Throwable unused2) {
        }
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void pixel2Map(int i3, int i10, PointF pointF) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (!this.f3661o0 || this.f3664q || this.f3634c0 == null) {
            return;
        }
        IPoint obtain = IPoint.obtain();
        if (!this.f3662p.get() && this.f3661o0 && (gLMapEngine = this.f3634c0) != null && (mapState = gLMapEngine.getMapState(this.f3660o)) != null) {
            mapState.screenToP20Point(i3, i10, obtain);
        }
        pointF.x = ((Point) obtain).x - ((float) this.r.getSX());
        pointF.y = ((Point) obtain).y - ((float) this.r.getSY());
        obtain.recycle();
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void post(Runnable runnable) {
        IGLSurfaceView iGLSurfaceView = this.f3650j;
        if (iGLSurfaceView != null) {
            iGLSurfaceView.post(runnable);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void queueEvent(Runnable runnable) {
        long j4;
        try {
            try {
                j4 = Thread.currentThread().getId();
            } catch (Throwable th2) {
                v4.a(th2);
                ka.a(th2, "AMapdelegateImp", "queueEvent");
                j4 = -1;
            }
            if (j4 != -1 && j4 == this.Z) {
                runnable.run();
            } else if (this.f3634c0 != null) {
                this.f3650j.queueEvent(runnable);
            }
        } catch (Throwable th3) {
            v4.a(th3);
            ka.a(th3, "AMapdelegateImp", "queueEvent");
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void redrawInfoWindow() {
        if (!this.f3662p.get() && this.f3661o0) {
            this.E0.sendEmptyMessage(18);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void redrawNativeOverlays() {
        this.E0.sendEmptyMessage(40);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void refreshLogo() {
        h5 h5Var = this.f3652k;
        if (h5Var != null) {
            ((g5) h5Var).i();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void reloadMap() {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void reloadMapCustomStyle() {
        com.amap.api.col.p0003sl.a0 a0Var = this.f3682z0;
        if (a0Var != null) {
            a0Var.c();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeAMapAppResourceListener(AMap.AMapAppResourceRequestListener aMapAppResourceRequestListener) {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.b(Integer.valueOf(AMap.AMapAppResourceRequestListener.class.hashCode()), aMapAppResourceRequestListener);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void removeEngineGLOverlay(BaseMapOverlay baseMapOverlay) {
        if (this.f3634c0 != null) {
            queueEvent(new g0(baseMapOverlay));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public boolean removeGLModel(String str) {
        try {
            this.f3656m.removeOverlay(str);
            return false;
        } catch (Throwable th2) {
            ka.a(th2, "AMapDelegateImp", "removeGLModel");
            th2.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void removeGLOverlay(String str) throws RemoteException {
        resetRenderTime();
        this.f3656m.removeOverlay(str);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.b(Integer.valueOf(AMap.OnCameraChangeListener.class.hashCode()), onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.b(Integer.valueOf(AMap.OnIndoorBuildingActiveListener.class.hashCode()), onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.b(Integer.valueOf(AMap.OnInfoWindowClickListener.class.hashCode()), onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.b(Integer.valueOf(AMap.OnMapClickListener.class.hashCode()), onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMapLoadedListener(AMap.OnMapLoadedListener onMapLoadedListener) {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.b(Integer.valueOf(AMap.OnMapLoadedListener.class.hashCode()), onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.b(Integer.valueOf(AMap.OnMapLongClickListener.class.hashCode()), onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.b(Integer.valueOf(AMap.OnMapTouchListener.class.hashCode()), onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.b(Integer.valueOf(AMap.OnMarkerClickListener.class.hashCode()), onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.b(Integer.valueOf(AMap.OnMarkerDragListener.class.hashCode()), onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.b(Integer.valueOf(AMap.OnMyLocationChangeListener.class.hashCode()), onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.b(Integer.valueOf(AMap.OnPOIClickListener.class.hashCode()), onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.b(Integer.valueOf(AMap.OnPolylineClickListener.class.hashCode()), onPolylineClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removePoiFilter(String str) {
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine == null) {
            return;
        }
        gLMapEngine.removePoiFilter(str);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removeSignleClickInterceptorListener(AMap.SignleClickInterceptorListener signleClickInterceptorListener) {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.b(Integer.valueOf(AMap.SignleClickInterceptorListener.class.hashCode()), signleClickInterceptorListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removecache() throws RemoteException {
        removecache(null);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void renderSurface(GL10 gl10) {
        drawFrame(gl10);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void requestRender() {
        GLMapRender gLMapRender = this.f3637d0;
        if (gLMapRender == null || gLMapRender.isRenderPause()) {
            return;
        }
        this.f3650j.requestRender();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void resetMinMaxZoomPreference() {
        List a3;
        this.r.resetMinMaxZoomPreference();
        try {
            if (!this.f3643g.isZoomControlsEnabled() || !this.r.isNeedUpdateZoomControllerState() || (a3 = this.f3630b.a(AMapWidgetListener.class.hashCode())) == null || a3.size() <= 0) {
                return;
            }
            synchronized (a3) {
                for (int i3 = 0; i3 < a3.size(); i3++) {
                    try {
                        ((AMapWidgetListener) a3.get(i3)).invalidateZoomController(this.r.getSZ());
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            v4.a(th3);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void resetRenderTime() {
        GLMapRender gLMapRender = this.f3637d0;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void resetRenderTimeLongLong() {
        GLMapRender gLMapRender = this.f3637d0;
        if (gLMapRender != null) {
            gLMapRender.resetTickCount(30);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void set3DBuildingEnabled(boolean z5) throws RemoteException {
        try {
            b(this.f3660o);
            c(this.f3660o, z5);
            queueEvent(new com.amap.api.col.p0003sl.g0(this, this.f3660o));
            GLMapRender gLMapRender = this.f3637d0;
            if (gLMapRender != null) {
                gLMapRender.renderResume();
            }
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setAMapGestureListener(AMapGestureListener aMapGestureListener) {
        y0 y0Var = this.f3639e0;
        if (y0Var != null) {
            this.f3633c = aMapGestureListener;
            y0Var.f5429s = aMapGestureListener;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCenterToPixel(int i3, int i10) throws RemoteException {
        this.f3667s = true;
        this.f3672u0 = i3;
        this.f3674v0 = i10;
        if (this.f3663p0 && this.f3661o0) {
            if (this.r.getAnchorX() == this.f3672u0 && this.r.getAnchorY() == this.f3674v0) {
                return;
            }
            this.r.setAnchorX(this.f3672u0);
            this.r.setAnchorY(this.f3674v0);
            queueEvent(new y());
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setConstructingRoadEnable(boolean z5) {
        try {
            if (this.f3661o0 && this.f3663p0) {
                resetRenderTime();
                queueEvent(new v(z5));
            } else {
                p0 p0Var = this.N0;
                p0Var.f3738b = z5;
                p0Var.f3737a = true;
                p0Var.e = this.f3660o;
            }
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCurrentLocation(LatLng latLng) {
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine == null) {
            return;
        }
        gLMapEngine.setCurrentLocation(latLng);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCustomMapStyle(CustomMapStyleOptions customMapStyleOptions) {
        setCustomMapStyle(customMapStyleOptions, (AMap.OnCustomMapStyleListener) null);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCustomMapStyleID(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.r.getCustomStyleID())) {
            return;
        }
        this.r.setCustomStyleID(str);
        this.f3649i = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCustomMapStylePath(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.r.getCustomStylePath())) {
            return;
        }
        this.r.setCustomStylePath(str);
        this.f3649i = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCustomRenderer(CustomRenderer customRenderer) throws RemoteException {
        this.R = customRenderer;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCustomScreenDensity(float f2) {
        this.f3628a0 = f2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCustomTextureResourcePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.r.setCustomTextureResourcePath(str);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setGestureStatus(int i3, int i10) {
        if (this.f3670t0 == 0 || i10 != 5) {
            this.f3670t0 = i10;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setHideLogoEnble(boolean z5) {
        MapConfig mapConfig = this.r;
        if (mapConfig != null) {
            mapConfig.setHideLogoEnble(z5);
            if (this.r.isCustomStyleEnable()) {
                this.f3643g.setLogoEnable(!z5);
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setIndoorBuildingInfo(IndoorBuildingInfo indoorBuildingInfo) throws RemoteException {
        if (this.f3662p.get() || indoorBuildingInfo == null || indoorBuildingInfo.activeFloorName == null || indoorBuildingInfo.poiid == null) {
            return;
        }
        this.f3671u = (v1) indoorBuildingInfo;
        resetRenderTime();
        queueEvent(new a0());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setIndoorEnabled(boolean z5) throws RemoteException {
        List a3;
        try {
            if (!this.f3661o0 || this.f3662p.get()) {
                p0 p0Var = this.R0;
                p0Var.f3738b = z5;
                p0Var.f3737a = true;
                p0Var.e = this.f3660o;
                return;
            }
            this.r.setIndoorEnable(z5);
            resetRenderTime();
            if (z5) {
                GLMapEngine gLMapEngine = this.f3634c0;
                if (gLMapEngine != null) {
                    gLMapEngine.setIndoorEnable(this.f3660o, true);
                }
            } else {
                GLMapEngine gLMapEngine2 = this.f3634c0;
                if (gLMapEngine2 != null) {
                    gLMapEngine2.setIndoorEnable(this.f3660o, false);
                }
                MapConfig mapConfig = this.r;
                mapConfig.maxZoomLevel = mapConfig.isSetLimitZoomLevel() ? this.r.getMaxZoomLevel() : 20.0f;
                try {
                    if (this.f3643g.isZoomControlsEnabled() && (a3 = this.f3630b.a(AMapWidgetListener.class.hashCode())) != null && a3.size() > 0) {
                        synchronized (a3) {
                            for (int i3 = 0; i3 < a3.size(); i3++) {
                                try {
                                    ((AMapWidgetListener) a3.get(i3)).invalidateZoomController(this.r.getSZ());
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            t4.c(this.f3631b0, z5);
            if (this.f3643g.isIndoorSwitchEnabled()) {
                this.E0.post(new q(z5));
            }
        } catch (Throwable th3) {
            v4.a(th3);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setInfoWindowAdapter(AMap.InfoWindowAdapter infoWindowAdapter) throws RemoteException {
        w1 w1Var;
        if (this.f3662p.get() || (w1Var = this.f3636d) == null) {
            return;
        }
        w1Var.a(infoWindowAdapter);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setLanguageAuth(boolean z5) {
        if (this.f3662p.get() || this.f3634c0 == null || z5) {
            return;
        }
        v4.a(new AMapException(AMapException.ERROR_LANGUAGE_AUTH));
        try {
            removecache(new f0());
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setLoadOfflineData(boolean z5) throws RemoteException {
        queueEvent(new r(z5));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setLocationSource(LocationSource locationSource) throws RemoteException {
        try {
            if (this.f3662p.get()) {
                return;
            }
            LocationSource locationSource2 = this.f3675w;
            if (locationSource2 != null && (locationSource2 instanceof x1)) {
                locationSource2.deactivate();
            }
            this.f3675w = locationSource;
            if (locationSource != null) {
                ((g5) this.f3652k).h(Boolean.TRUE);
            } else {
                ((g5) this.f3652k).h(Boolean.FALSE);
            }
        } catch (Throwable th2) {
            ka.a(th2, "AMapDelegateImp", "setLocationSource");
            th2.printStackTrace();
            v4.a(th2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setLogoBottomMargin(int i3) {
        h5 h5Var = this.f3652k;
        if (h5Var != null) {
            ((g5) h5Var).a(Integer.valueOf(i3));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setLogoLeftMargin(int i3) {
        h5 h5Var = this.f3652k;
        if (h5Var != null) {
            ((g5) h5Var).b(Integer.valueOf(i3));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setLogoMarginRate(int i3, float f2) {
        h5 h5Var = this.f3652k;
        if (h5Var != null) {
            ((g5) h5Var).a(Integer.valueOf(i3), Float.valueOf(f2));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setLogoPosition(int i3) {
        h5 h5Var = this.f3652k;
        if (h5Var != null) {
            ((g5) h5Var).c(Integer.valueOf(i3));
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setMapCustomEnable(boolean z5, boolean z6) {
        s3 s3Var;
        if (!this.f3661o0 || this.f3662p.get()) {
            p0 p0Var = this.I0;
            p0Var.f3737a = true;
            p0Var.f3738b = z5;
            return;
        }
        boolean z8 = z6 ? z6 : false;
        if (TextUtils.isEmpty(this.r.getCustomStylePath()) && TextUtils.isEmpty(this.r.getCustomStyleID())) {
            return;
        }
        if (z5) {
            try {
                if (this.r.isProFunctionAuthEnable() && !TextUtils.isEmpty(this.r.getCustomStyleID()) && (s3Var = this.W) != null) {
                    s3Var.b(this.r.getCustomStyleID());
                    s3 s3Var2 = this.W;
                    s3Var2.getClass();
                    u4.b().a(s3Var2);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
                v4.a(th2);
                return;
            }
        }
        if (z6 || this.f3649i || (this.r.isCustomStyleEnable() ^ z5)) {
            a(z5, (byte[]) null, z8);
        }
        this.f3649i = false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setMapEnable(boolean z5) {
        MapConfig mapConfig = this.r;
        if (mapConfig != null) {
            mapConfig.setMapEnable(z5);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapLanguage(String str) {
        MapConfig mapConfig;
        if (TextUtils.isEmpty(str) || (mapConfig = this.r) == null || mapConfig.isCustomStyleEnable() || this.r.getMapLanguage().equals(str)) {
            return;
        }
        if (str.equals("en")) {
            if (this.I != 1) {
                try {
                    setMapType(1);
                } catch (Throwable th2) {
                    v4.a(th2);
                    th2.printStackTrace();
                }
            }
            this.r.setMapLanguage("en");
            this.Q = -10000;
        } else {
            this.r.setMapLanguage("zh_cn");
            this.Q = 0;
        }
        try {
            b(getCameraPosition());
        } catch (Throwable th3) {
            v4.a(th3);
            th3.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapOptRecordState(boolean z5) {
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine == null) {
            return;
        }
        gLMapEngine.setMapOptRecordState(z5);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapStatusLimits(LatLngBounds latLngBounds) {
        try {
            this.r.setLimitLatLngBounds(latLngBounds);
            a();
        } catch (Throwable th2) {
            th2.printStackTrace();
            v4.a(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapTextEnable(boolean z5) throws RemoteException {
        try {
            if (this.f3661o0 && this.f3663p0) {
                resetRenderTime();
                queueEvent(new s(z5));
            } else {
                p0 p0Var = this.K0;
                p0Var.f3738b = z5;
                p0Var.f3737a = true;
                p0Var.e = this.f3660o;
            }
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapTextZIndex(int i3) throws RemoteException {
        this.Q = i3;
        this.B0 = false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapType(int i3) throws RemoteException {
        MapConfig mapConfig;
        if (i3 != this.I || ((mapConfig = this.r) != null && mapConfig.isCustomStyleEnable())) {
            this.I = i3;
            a(i3);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setMapWidgetListener(AMapWidgetListener aMapWidgetListener) {
        try {
            com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
            if (n0Var != null) {
                n0Var.a(AMapWidgetListener.class.hashCode(), (int) aMapWidgetListener);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMaskLayerParams(int i3, int i10, int i11, int i12, int i13, long j4) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMaxZoomLevel(float f2) {
        this.r.setMaxZoomLevel(f2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMinZoomLevel(float f2) {
        this.r.setMinZoomLevel(f2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMyLocationEnabled(boolean z5) throws RemoteException {
        if (this.f3662p.get()) {
            return;
        }
        try {
            h5 h5Var = this.f3652k;
            if (h5Var != null) {
                LocationSource locationSource = this.f3675w;
                if (locationSource == null) {
                    ((g5) h5Var).h(Boolean.FALSE);
                } else if (z5) {
                    locationSource.activate(this.f3627a);
                    ((g5) this.f3652k).h(Boolean.TRUE);
                    if (this.f3673v == null) {
                        this.f3673v = new m3(this, this.f3631b0);
                    }
                } else {
                    m3 m3Var = this.f3673v;
                    if (m3Var != null) {
                        m3Var.g();
                        this.f3673v = null;
                    }
                    this.f3675w.deactivate();
                }
            }
            if (!z5) {
                this.f3643g.setMyLocationButtonEnabled(z5);
            }
            this.f3658n = z5;
            resetRenderTime();
        } catch (Throwable th2) {
            ka.a(th2, "AMapDelegateImp", "setMyLocationEnabled");
            th2.printStackTrace();
            v4.a(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMyLocationRotateAngle(float f2) throws RemoteException {
        try {
            m3 m3Var = this.f3673v;
            if (m3Var != null) {
                m3Var.b(f2);
            }
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMyLocationStyle(MyLocationStyle myLocationStyle) throws RemoteException {
        if (this.f3662p.get()) {
            return;
        }
        try {
            if (this.f3673v == null) {
                this.f3673v = new m3(this, this.f3631b0);
            }
            if (this.f3673v != null) {
                long j4 = 1000;
                if (myLocationStyle.getInterval() < j4) {
                    myLocationStyle.interval(j4);
                }
                LocationSource locationSource = this.f3675w;
                if (locationSource != null && (locationSource instanceof x1)) {
                    ((x1) locationSource).a(myLocationStyle.getInterval());
                    ((x1) this.f3675w).a(myLocationStyle.getMyLocationType());
                }
                this.f3673v.a(myLocationStyle);
            }
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMyLocationType(int i3) throws RemoteException {
        try {
            m3 m3Var = this.f3673v;
            if (m3Var == null || m3Var.d() == null) {
                return;
            }
            this.f3673v.d().myLocationType(i3);
            setMyLocationStyle(this.f3673v.d());
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setNaviLabelEnable(boolean z5, int i3, int i10) throws RemoteException {
        try {
            if (this.f3661o0 && this.f3663p0) {
                resetRenderTime();
                queueEvent(new u(z5, i3, i10));
                return;
            }
            p0 p0Var = this.M0;
            p0Var.f3738b = z5;
            p0Var.f3741f = i3;
            p0Var.f3742g = i10;
            p0Var.f3737a = true;
            p0Var.e = this.f3660o;
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(AMap.OnCameraChangeListener.class.hashCode(), (int) onCameraChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(AMap.OnIndoorBuildingActiveListener.class.hashCode(), (int) onIndoorBuildingActiveListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(AMap.OnInfoWindowClickListener.class.hashCode(), (int) onInfoWindowClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(AMap.OnMapClickListener.class.hashCode(), (int) onMapClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(AMap.OnMapLongClickListener.class.hashCode(), (int) onMapLongClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(AMap.OnMapTouchListener.class.hashCode(), (int) onMapTouchListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMaploadedListener(AMap.OnMapLoadedListener onMapLoadedListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(AMap.OnMapLoadedListener.class.hashCode(), (int) onMapLoadedListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(AMap.OnMarkerClickListener.class.hashCode(), (int) onMarkerClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(AMap.OnMarkerDragListener.class.hashCode(), (int) onMarkerDragListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMultiPointClickListener(AMap.OnMultiPointClickListener onMultiPointClickListener) {
        this.f3680y0 = onMultiPointClickListener;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(AMap.OnMyLocationChangeListener.class.hashCode(), (int) onMyLocationChangeListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(AMap.OnPOIClickListener.class.hashCode(), (int) onPOIClickListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        com.amap.api.col.p0003sl.n0 n0Var = this.f3630b;
        if (n0Var != null) {
            n0Var.a(AMap.OnPolylineClickListener.class.hashCode(), (int) onPolylineClickListener);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setOverseaAuth(boolean z5) {
        if (this.f3662p.get()) {
            return;
        }
        this.f3634c0.setOverseaAuth(z5);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setRenderFps(int i3) {
        try {
            if (i3 == -1) {
                this.T = i3;
            } else {
                this.T = Math.max(10, Math.min(i3, 120));
            }
            t4.g(this.f3631b0);
        } catch (Throwable th2) {
            v4.a(th2);
            th2.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setRenderMode(int i3) {
        try {
            IGLSurfaceView iGLSurfaceView = this.f3650j;
            if (iGLSurfaceView != null) {
                iGLSurfaceView.setRenderMode(i3);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setRoadArrowEnable(boolean z5) throws RemoteException {
        try {
            if (this.f3661o0 && this.f3663p0) {
                resetRenderTime();
                queueEvent(new t(z5));
            } else {
                p0 p0Var = this.L0;
                p0Var.f3738b = z5;
                p0Var.f3737a = true;
                p0Var.e = this.f3660o;
            }
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setRunLowFrame(boolean z5) {
        if (z5) {
            return;
        }
        try {
            if (this.T != -1) {
                return;
            }
            f();
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setTerrainAuth(boolean z5) {
        GLMapEngine gLMapEngine;
        if (this.f3662p.get() || (gLMapEngine = this.f3634c0) == null) {
            return;
        }
        gLMapEngine.setTerrainAuth(z5);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setTouchPoiEnable(boolean z5) {
        MapConfig mapConfig = this.r;
        if (mapConfig != null) {
            mapConfig.setTouchPoiEnable(z5);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setTrafficEnabled(boolean z5) throws RemoteException {
        try {
            if (this.f3661o0 && !this.f3662p.get()) {
                queueEvent(new p(z5, z5));
                return;
            }
            p0 p0Var = this.F0;
            p0Var.f3738b = z5;
            p0Var.f3737a = true;
            p0Var.e = this.f3660o;
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setTrafficStyleWithTexture(byte[] bArr, MyTrafficStyle myTrafficStyle) {
        if (this.f3662p.get()) {
            return;
        }
        try {
            if (this.f3661o0 && this.f3663p0 && bArr != null && myTrafficStyle != null) {
                resetRenderTime();
                queueEvent(new w(bArr, myTrafficStyle));
                return;
            }
            p0 p0Var = this.P0;
            p0Var.f3743h = bArr;
            p0Var.f3744i = myTrafficStyle;
            p0Var.f3737a = true;
            p0Var.e = this.f3660o;
        } catch (Exception e10) {
            v4.a(e10);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setTrafficStyleWithTextureData(byte[] bArr) {
        if (this.f3662p.get()) {
            return;
        }
        try {
            if (this.f3661o0 && this.f3663p0 && bArr != null) {
                resetRenderTime();
                queueEvent(new x(bArr));
            } else {
                p0 p0Var = this.O0;
                p0Var.f3743h = bArr;
                p0Var.f3737a = true;
                p0Var.e = this.f3660o;
            }
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setUseForNavi(boolean z5) {
        this.U = z5;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setVisibilityEx(int i3) {
        IGLSurfaceView iGLSurfaceView = this.f3650j;
        if (iGLSurfaceView != null) {
            try {
                iGLSurfaceView.setVisibility(i3);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setWorldVectorMapStyle(String str) {
        if (a(false, true) || TextUtils.isEmpty(str) || this.r == null || this.W0.equals(str)) {
            return;
        }
        this.W0 = str;
        com.autonavi.extra.b bVar = this.U0;
        if (bVar != null) {
            bVar.a("setWorldVectorMapStyle", str);
        }
        resetRenderTime();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setZOrderOnTop(boolean z5) throws RemoteException {
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setZoomPosition(int i3) {
        h5 h5Var;
        if (this.f3662p.get() || (h5Var = this.f3652k) == null) {
            return;
        }
        ((g5) h5Var).d(Integer.valueOf(i3));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setZoomScaleParam(float f2) {
        this.f3651j0 = f2;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showCompassEnabled(boolean z5) {
        h5 h5Var;
        if (this.f3662p.get() || (h5Var = this.f3652k) == null) {
            return;
        }
        ((g5) h5Var).c(Boolean.valueOf(z5));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void showHideBuildings(int i3) {
        if (this.f3634c0 == null) {
            return;
        }
        queueEvent(new i0(i3));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showIndoorSwitchControlsEnabled(boolean z5) {
        h5 h5Var;
        if (this.f3662p.get() || (h5Var = this.f3652k) == null) {
            return;
        }
        ((g5) h5Var).d(Boolean.valueOf(z5));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException {
        w1 w1Var;
        if (baseOverlayImp == null || (w1Var = this.f3636d) == null) {
            return;
        }
        try {
            IInfoWindowAction a3 = w1Var.a();
            if (a3 != null) {
                a3.showInfoWindow(baseOverlayImp);
            }
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showLogoEnabled(boolean z5) {
        if (this.f3662p.get()) {
            return;
        }
        ((g5) this.f3652k).e(Boolean.valueOf(z5));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showMyLocationButtonEnabled(boolean z5) {
        h5 h5Var;
        if (this.f3662p.get() || (h5Var = this.f3652k) == null) {
            return;
        }
        ((g5) h5Var).f(Boolean.valueOf(z5));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showMyLocationOverlay(Location location) throws RemoteException {
        if (location == null) {
            return;
        }
        try {
            if (this.f3658n && this.f3675w != null) {
                if (this.f3673v == null) {
                    this.f3673v = new m3(this, this.f3631b0);
                }
                if (location.getLongitude() != 0.0d && location.getLatitude() != 0.0d) {
                    this.f3673v.a(location);
                }
                List a3 = this.f3630b.a(AMap.OnMyLocationChangeListener.class.hashCode());
                if (a3 != null && a3.size() > 0) {
                    synchronized (a3) {
                        for (int i3 = 0; i3 < a3.size(); i3++) {
                            try {
                                ((AMap.OnMyLocationChangeListener) a3.get(i3)).onMyLocationChange(location);
                            } finally {
                            }
                        }
                    }
                }
                resetRenderTime();
                return;
            }
            m3 m3Var = this.f3673v;
            if (m3Var != null) {
                m3Var.g();
            }
            this.f3673v = null;
        } catch (Throwable th2) {
            ka.a(th2, "AMapDelegateImp", "showMyLocationOverlay");
            th2.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showScaleEnabled(boolean z5) {
        h5 h5Var;
        if (this.f3662p.get() || (h5Var = this.f3652k) == null) {
            return;
        }
        ((g5) h5Var).g(Boolean.valueOf(z5));
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showZoomControlsEnabled(boolean z5) {
        h5 h5Var;
        if (this.f3662p.get() || (h5Var = this.f3652k) == null) {
            return;
        }
        ((g5) h5Var).i(Boolean.valueOf(z5));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void stopAnimation() throws RemoteException {
        try {
            GLMapEngine gLMapEngine = this.f3634c0;
            if (gLMapEngine != null) {
                gLMapEngine.interruptAnimation();
            }
            resetRenderTime();
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void switchLanguage(String str) {
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine == null) {
            return;
        }
        gLMapEngine.switchLanguage(str);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public float toMapLenWithWin(int i3) {
        GLMapEngine gLMapEngine;
        if (!this.f3661o0 || this.f3664q || (gLMapEngine = this.f3634c0) == null) {
            return 0.0f;
        }
        return gLMapEngine.getMapState(this.f3660o).getGLUnitWithWin(i3);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void zoomOut(int i3) {
        if (this.f3661o0 && ((int) d()) > this.r.getMinZoomLevel()) {
            try {
                animateCameraWithDurationAndCallback(com.amap.api.col.p0003sl.x.a(), 250L, (AMap.CancelableCallback) null);
            } catch (Throwable th2) {
                ka.a(th2, "AMapDelegateImp", "onDoubleTap");
                th2.printStackTrace();
            }
            resetRenderTime();
        }
    }

    public b0(IGLSurfaceView iGLSurfaceView, Context context, boolean z5) {
        a aVar = null;
        this.f3627a = null;
        this.f3630b = new com.amap.api.col.p0003sl.n0();
        this.f3646h = false;
        this.f3649i = false;
        this.f3658n = false;
        this.f3662p = new AtomicBoolean(false);
        this.f3664q = false;
        this.r = new MapConfig(true);
        this.f3667s = false;
        this.f3669t = false;
        this.f3677x = false;
        this.f3679y = false;
        this.f3681z = null;
        this.A = null;
        this.B = false;
        this.C = false;
        this.D = 0;
        this.E = true;
        this.G = true;
        this.H = new Rect();
        this.I = 1;
        this.O = false;
        this.P = false;
        this.Q = 0;
        this.S = -1;
        this.T = -1;
        this.U = false;
        this.V = new ArrayList();
        this.Y = null;
        this.Z = -1L;
        this.f3628a0 = 0.0f;
        this.f3642f0 = false;
        this.i0 = 0.0f;
        this.f3651j0 = 1.0f;
        this.f3653k0 = 1.0f;
        this.f3655l0 = true;
        this.f3657m0 = false;
        this.f3659n0 = false;
        this.f3661o0 = false;
        this.f3663p0 = false;
        this.f3665q0 = false;
        this.f3666r0 = false;
        this.f3668s0 = new ReentrantLock();
        this.f3670t0 = 0;
        this.B0 = true;
        this.C0 = false;
        this.D0 = false;
        this.E0 = new a(Looper.getMainLooper());
        this.F0 = new o();
        this.G0 = new z();
        this.H0 = new j0();
        this.I0 = new k0();
        this.J0 = new l0();
        this.K0 = new m0();
        this.L0 = new n0();
        this.M0 = new o0();
        this.N0 = new b();
        this.O0 = new c();
        this.P0 = new d();
        this.Q0 = new e();
        this.R0 = new f();
        this.S0 = new g();
        this.T0 = new h();
        this.V0 = "";
        this.W0 = "";
        this.X0 = false;
        this.Y0 = false;
        this.Z0 = 0;
        this.f3629a1 = new EAMapPlatformGestureInfo();
        this.f3632b1 = new Point();
        this.f3635c1 = 0L;
        this.f3638d1 = null;
        this.f1 = new float[16];
        this.f3645g1 = new float[16];
        this.f3648h1 = new float[16];
        this.f3631b0 = context;
        b9.a(false);
        a6.a(this.f3631b0);
        n1.a(this.f3631b0);
        l9 a3 = k9.a(this.f3631b0, v4.b());
        k9.e eVar = a3.f4490a;
        k9.e eVar2 = k9.e.SuccessCode;
        if (eVar == eVar2) {
            y4.a(context);
            y4.b("[map][lifecycle]", "init map delegate");
        }
        com.autonavi.extra.b bVar = new com.autonavi.extra.b();
        this.U0 = bVar;
        bVar.a((com.autonavi.extra.a) null);
        this.U0.a(this.f3631b0, this, z5);
        ka.a(this.f3631b0);
        n4.b().a(this.f3631b0);
        b9.f(context);
        this.f3639e0 = new y0(this);
        GLMapRender gLMapRender = new GLMapRender(this);
        this.f3637d0 = gLMapRender;
        this.f3650j = iGLSurfaceView;
        iGLSurfaceView.setRenderer(gLMapRender);
        z0 z0Var = new z0(this, this.f3631b0);
        this.f3656m = z0Var;
        this.f3634c0 = new GLMapEngine(this.f3631b0, this);
        this.f3654l = new b1(this.f3631b0, this);
        this.f3652k = new g5(this.f3631b0, this, z0Var, this.f3654l);
        this.f3643g = new h1(this);
        ((g5) this.f3652k).a(new r0(this, aVar));
        this.f3676w0 = new q0();
        iGLSurfaceView.setRenderMode(0);
        this.f3637d0.setRenderFps(15.0f);
        this.f3634c0.setMapListener(this);
        this.f3641f = new e1(this);
        this.f3627a = new com.amap.api.col.p0003sl.m0(this);
        w1 w1Var = new w1(this.f3631b0);
        this.f3636d = w1Var;
        w1Var.b(this.f3652k);
        this.f3636d.a(new o3(z0Var, context));
        this.J = new com.amap.api.col.p0003sl.s0(this.f3631b0, this);
        this.f3675w = new x1(this.f3631b0);
        this.W = new s3(this.f3631b0, this);
        u3 u3Var = new u3(this.f3631b0);
        this.X = u3Var;
        u3Var.a(this);
        a(z5);
        MapConfig mapConfig = this.r;
        com.amap.api.col.p0003sl.a0 a0Var = new com.amap.api.col.p0003sl.a0(this, this.f3631b0, mapConfig != null ? mapConfig.isAbroadEnable() : false);
        this.f3682z0 = a0Var;
        a0Var.a(this);
        if (a3.f4490a != eVar2) {
            this.r.setMapEnable(false);
        }
        this.f3660o = this.f3634c0.getEngineIDWithType(1);
    }

    private boolean e() {
        boolean z5 = false;
        try {
            GLMapState mapState = this.f3634c0.getMapState(this.f3660o);
            if (mapState != null) {
                IPoint obtain = IPoint.obtain();
                mapState.screenToP20Point(0, 0, obtain);
                IPoint obtain2 = IPoint.obtain();
                mapState.screenToP20Point(this.r.getMapWidth(), 0, obtain2);
                IPoint obtain3 = IPoint.obtain();
                mapState.screenToP20Point(this.r.getMapWidth(), this.r.getMapHeight(), obtain3);
                IPoint obtain4 = IPoint.obtain();
                mapState.screenToP20Point(0, this.r.getMapHeight(), obtain4);
                IPoint[] iPointArr = {obtain, obtain2, obtain3, obtain4};
                int i3 = r4.f4948a;
                int i10 = 0;
                while (true) {
                    if (i10 >= 4) {
                        z5 = true;
                        break;
                    }
                    IPoint iPoint = iPointArr[i10];
                    DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(((Point) iPoint).x, ((Point) iPoint).y, 20);
                    if (pixelsToLatLong != null && !r4.b(pixelsToLatLong.f6571y, pixelsToLatLong.f6570x)) {
                        break;
                    }
                    i10++;
                }
                return true ^ z5;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
            v4.a(th2);
        }
        return false;
    }

    private boolean f(MotionEvent motionEvent) {
        if (this.f3656m != null && this.f3680y0 != null) {
            DPoint obtain = DPoint.obtain();
            if (this.f3634c0 != null) {
                getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                MultiPointItem multiPointItem = this.f3656m.getMultiPointItem(new LatLng(obtain.f6571y, obtain.f6570x));
                if (multiPointItem == null) {
                    return false;
                }
                boolean onPointClick = this.f3680y0.onPointClick(multiPointItem);
                obtain.recycle();
                return onPointClick;
            }
        }
        return false;
    }

    private boolean g(MotionEvent motionEvent) {
        Throwable th2;
        LatLng position;
        DPoint obtain = DPoint.obtain();
        obtain.f6570x = motionEvent.getX();
        obtain.f6571y = motionEvent.getY();
        boolean z5 = true;
        BaseOverlay hitOverlay = this.f3654l.getHitOverlay(obtain, 1);
        obtain.recycle();
        if ((hitOverlay instanceof Marker) && ((Marker) hitOverlay).getId().contains("MARKER")) {
            try {
                Marker marker = (Marker) hitOverlay;
                this.f3654l.set2Top(marker.getId());
                List a3 = this.f3630b.a(AMap.OnMarkerClickListener.class.hashCode());
                if (a3 != null) {
                    try {
                        if (a3.size() > 0) {
                            synchronized (a3) {
                                try {
                                    if (a3.size() == 1) {
                                        boolean onMarkerClick = ((AMap.OnMarkerClickListener) a3.get(0)).onMarkerClick(marker);
                                        if (onMarkerClick) {
                                            return true;
                                        }
                                        z5 = onMarkerClick;
                                    } else {
                                        Iterator it = a3.iterator();
                                        boolean z6 = false;
                                        while (it.hasNext()) {
                                            z6 |= ((AMap.OnMarkerClickListener) it.next()).onMarkerClick(marker);
                                        }
                                        if (z6) {
                                            return true;
                                        }
                                        z5 = z6;
                                    }
                                } finally {
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        ka.a(th2, "AMapDelegateImp", "onMarkerTap");
                        th2.printStackTrace();
                        return false;
                    }
                }
                this.f3654l.showInfoWindow(marker.getId());
                if (marker.isViewMode() || (position = marker.getPosition()) == null) {
                    return z5;
                }
                IPoint obtain2 = IPoint.obtain();
                try {
                    latlon2Geo(position.latitude, position.longitude, obtain2);
                    moveCamera(com.amap.api.col.p0003sl.x.a(obtain2));
                    return z5;
                } catch (Throwable th4) {
                    th = th4;
                    th2 = th;
                    ka.a(th2, "AMapDelegateImp", "onMarkerTap");
                    th2.printStackTrace();
                    return false;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
        return false;
    }

    private boolean h(MotionEvent motionEvent) {
        try {
            List a3 = this.f3630b.a(AMap.OnPolylineClickListener.class.hashCode());
            if (a3 != null && a3.size() > 0) {
                DPoint obtain = DPoint.obtain();
                getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
                LatLng latLng = new LatLng(obtain.f6571y, obtain.f6570x);
                obtain.recycle();
                Polyline hitOverlay = this.f3656m.getHitOverlay(latLng, 2);
                if (hitOverlay != null) {
                    synchronized (a3) {
                        try {
                            Iterator it = a3.iterator();
                            while (it.hasNext()) {
                                ((AMap.OnPolylineClickListener) it.next()).onPolylineClick(hitOverlay);
                            }
                        } finally {
                        }
                    }
                    return false;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void animateCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        animateCameraWithDurationAndCallback(abstractCameraUpdateMessage, 250L, (AMap.CancelableCallback) null);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void animateCameraWithDurationAndCallback(AbstractCameraUpdateMessage abstractCameraUpdateMessage, long j4, AMap.CancelableCallback cancelableCallback) {
        GLMapEngine gLMapEngine;
        if (abstractCameraUpdateMessage == null || this.f3662p.get() || (gLMapEngine = this.f3634c0) == null) {
            return;
        }
        abstractCameraUpdateMessage.mCallback = cancelableCallback;
        abstractCameraUpdateMessage.mDuration = j4;
        if (!this.f3664q && this.f3647h0 != 0 && this.f3644g0 != 0) {
            try {
                gLMapEngine.interruptAnimation();
                resetRenderTime();
                a(abstractCameraUpdateMessage);
                this.f3634c0.addMessage(abstractCameraUpdateMessage, true);
                return;
            } catch (Throwable th2) {
                v4.a(th2);
                th2.printStackTrace();
                return;
            }
        }
        try {
            moveCamera(abstractCameraUpdateMessage);
            AMap.CancelableCallback cancelableCallback2 = abstractCameraUpdateMessage.mCallback;
            if (cancelableCallback2 != null) {
                cancelableCallback2.onFinish();
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
            v4.a(th3);
        }
    }

    public boolean c(MotionEvent motionEvent) {
        DPoint obtain = DPoint.obtain();
        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
        LatLng latLng = new LatLng(obtain.f6571y, obtain.f6570x);
        obtain.recycle();
        BaseOverlay hitBaseOverlay = this.f3656m.getHitBaseOverlay(latLng, 3);
        if (!(hitBaseOverlay instanceof GLTFOverlay)) {
            return false;
        }
        GLTFOverlay gLTFOverlay = (GLTFOverlay) hitBaseOverlay;
        if (!gLTFOverlay.isClickable()) {
            return false;
        }
        try {
            this.f3656m.set2Top(gLTFOverlay.getId());
            gLTFOverlay.tapClick();
            return true;
        } catch (Throwable th2) {
            ka.a(th2, "AMapDelegateImp", "onGLTFTap");
            th2.printStackTrace();
            return false;
        }
    }

    public float d() {
        MapConfig mapConfig = this.r;
        if (mapConfig != null) {
            return mapConfig.getSZ();
        }
        return 0.0f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void removecache(AMap.OnCacheRemoveListener onCacheRemoveListener) throws RemoteException {
        Handler handler = this.E0;
        if (handler == null || this.f3634c0 == null) {
            return;
        }
        try {
            s0 s0Var = new s0(this.f3631b0, onCacheRemoveListener);
            handler.removeCallbacks(s0Var);
            this.E0.post(s0Var);
        } catch (Throwable th2) {
            ka.a(th2, "AMapDelegateImp", "removecache");
            th2.printStackTrace();
            v4.a(th2);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setCustomMapStyle(CustomMapStyleOptions customMapStyleOptions, AMap.OnCustomMapStyleListener onCustomMapStyleListener) {
        this.f3640e1 = onCustomMapStyleListener;
        if (customMapStyleOptions != null) {
            try {
                if (a(true, false)) {
                    return;
                }
                if (customMapStyleOptions.isEnable()) {
                    if (customMapStyleOptions.getStyleId() == null) {
                        if (customMapStyleOptions.getStyleTexturePath() == null) {
                            if (customMapStyleOptions.getStyleTextureData() == null) {
                                if (customMapStyleOptions.getStyleResDataPath() == null) {
                                    if (customMapStyleOptions.getStyleResData() != null) {
                                    }
                                }
                            }
                        }
                    }
                    c();
                }
                this.f3682z0.a();
                this.f3682z0.a(customMapStyleOptions, this.f3640e1);
                com.autonavi.extra.b bVar = this.U0;
                if (bVar != null) {
                    bVar.a("setCustomMapStyle", customMapStyleOptions);
                }
            } catch (Throwable th2) {
                v4.a(th2);
                return;
            }
        }
        resetRenderTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(CameraPosition cameraPosition) {
        if (this.r.getMapLanguage().equals("en")) {
            boolean a3 = a(cameraPosition, true);
            if (a3 != this.G) {
                this.G = a3;
                a(this.f3660o, a3);
                return;
            }
            return;
        }
        if (this.G) {
            return;
        }
        this.G = true;
        a(this.f3660o, true);
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void moveCamera(AbstractCameraUpdateMessage abstractCameraUpdateMessage) throws RemoteException {
        if (this.f3634c0 == null || this.f3662p.get()) {
            return;
        }
        try {
            if (this.f3664q && this.f3634c0.getStateMessageCount() > 0) {
                j1 j1Var = new j1();
                j1Var.nowType = AbstractCameraUpdateMessage.Type.changeGeoCenterZoomTiltBearing;
                j1Var.geoPoint = new DPoint(this.r.getSX(), this.r.getSY());
                j1Var.zoom = this.r.getSZ();
                j1Var.bearing = this.r.getSR();
                j1Var.tilt = this.r.getSC();
                this.f3634c0.addMessage(abstractCameraUpdateMessage, false);
                while (this.f3634c0.getStateMessageCount() > 0) {
                    AbstractCameraUpdateMessage stateMessage = this.f3634c0.getStateMessage();
                    if (stateMessage != null) {
                        stateMessage.mergeCameraUpdateDelegate(j1Var);
                    }
                }
                abstractCameraUpdateMessage = j1Var;
            }
        } catch (Throwable th2) {
            v4.a(th2);
        }
        resetRenderTime();
        this.f3634c0.clearAnimations(this.f3660o, false);
        abstractCameraUpdateMessage.isChangeFinished = true;
        a(abstractCameraUpdateMessage);
        this.f3634c0.addMessage(abstractCameraUpdateMessage, false);
    }

    private boolean d(MotionEvent motionEvent) throws RemoteException {
        try {
            List a3 = this.f3630b.a(AMap.OnInfoWindowClickListener.class.hashCode());
            BaseOverlay a10 = this.f3636d.a(motionEvent);
            if (a10 != null && (a10 instanceof Marker)) {
                synchronized (a3) {
                    for (int i3 = 0; i3 < a3.size(); i3++) {
                        try {
                            ((AMap.OnInfoWindowClickListener) a3.get(i3)).onInfoWindowClick((Marker) a10);
                        } finally {
                        }
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setInfoWindowAdapter(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) throws RemoteException {
        w1 w1Var;
        if (this.f3662p.get() || (w1Var = this.f3636d) == null) {
            return;
        }
        w1Var.a(commonInfoWindowAdapter);
    }

    public static abstract class p0 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        boolean f3737a;

        /* renamed from: b, reason: collision with root package name */
        boolean f3738b;

        /* renamed from: c, reason: collision with root package name */
        int f3739c;

        /* renamed from: d, reason: collision with root package name */
        int f3740d;
        int e;

        /* renamed from: f, reason: collision with root package name */
        int f3741f;

        /* renamed from: g, reason: collision with root package name */
        int f3742g;

        /* renamed from: h, reason: collision with root package name */
        byte[] f3743h;

        /* renamed from: i, reason: collision with root package name */
        MyTrafficStyle f3744i;

        private p0() {
            this.f3737a = false;
            this.f3738b = false;
            this.f3741f = 0;
            this.f3742g = 0;
        }

        @Override // java.lang.Runnable
        public abstract void run();

        public /* synthetic */ p0(a aVar) {
            this();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0029 A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:2:0x0000, B:5:0x0009, B:6:0x001c, B:8:0x0029, B:9:0x002b, B:13:0x0016), top: B:1:0x0000 }] */
    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void clear(boolean r3) throws android.os.RemoteException {
        /*
            r2 = this;
            r2.hideInfoWindow()     // Catch: java.lang.Throwable -> L14
            com.amap.api.col.3sl.m3 r0 = r2.f3673v     // Catch: java.lang.Throwable -> L14
            if (r0 == 0) goto L19
            if (r3 == 0) goto L16
            java.lang.String r3 = r0.c()     // Catch: java.lang.Throwable -> L14
            com.amap.api.col.3sl.m3 r0 = r2.f3673v     // Catch: java.lang.Throwable -> L14
            java.lang.String r0 = r0.b()     // Catch: java.lang.Throwable -> L14
            goto L1c
        L14:
            r3 = move-exception
            goto L3c
        L16:
            r0.h()     // Catch: java.lang.Throwable -> L14
        L19:
            r3 = 0
            java.lang.String r0 = ""
        L1c:
            com.amap.api.maps.interfaces.IGlOverlayLayer r1 = r2.f3656m     // Catch: java.lang.Throwable -> L14
            java.lang.String[] r3 = new java.lang.String[]{r3, r0}     // Catch: java.lang.Throwable -> L14
            r1.clear(r3)     // Catch: java.lang.Throwable -> L14
            com.amap.api.col.3sl.h5 r3 = r2.f3652k     // Catch: java.lang.Throwable -> L14
            if (r3 == 0) goto L2b
            com.amap.api.col.3sl.g5 r3 = (com.amap.api.col.p0003sl.g5) r3     // Catch: java.lang.Throwable -> L14
        L2b:
            com.amap.api.col.3sl.b0$n r3 = new com.amap.api.col.3sl.b0$n     // Catch: java.lang.Throwable -> L14
            r3.<init>()     // Catch: java.lang.Throwable -> L14
            r2.queueEvent(r3)     // Catch: java.lang.Throwable -> L14
            com.amap.api.col.3sl.b1 r3 = r2.f3654l     // Catch: java.lang.Throwable -> L14
            r3.clear()     // Catch: java.lang.Throwable -> L14
            r2.resetRenderTime()     // Catch: java.lang.Throwable -> L14
            return
        L3c:
            java.lang.String r0 = "AMapDelegateImp"
            java.lang.String r1 = "clear"
            com.amap.api.col.p0003sl.ka.a(r3, r0, r1)
            com.amap.api.col.p0003sl.v4.a(r3)
            r3.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.b0.clear(boolean):void");
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void showInfoWindow(BaseOverlay baseOverlay) throws RemoteException {
        w1 w1Var;
        if (baseOverlay == null || (w1Var = this.f3636d) == null) {
            return;
        }
        try {
            w1Var.a(baseOverlay);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void getMapScreenShot(AMap.OnMapScreenShotListener onMapScreenShotListener, boolean z5, Handler handler) {
        try {
            this.f3630b.a(Integer.valueOf(AMap.OnMapScreenShotListener.class.hashCode()), (Integer) onMapScreenShotListener);
            this.D = 20;
            this.E = z5;
            this.F = handler;
            resetRenderTime();
        } catch (Throwable th2) {
            v4.a(th2);
        }
    }

    public void f() {
        GLMapRender gLMapRender;
        GLMapRender gLMapRender2;
        if (!this.f3661o0 || (gLMapRender = this.f3637d0) == null || gLMapRender.isRenderPause() || (gLMapRender2 = this.f3637d0) == null || gLMapRender2.isRenderPause()) {
            return;
        }
        this.f3650j.requestRender();
    }

    private void b(MotionEvent motionEvent) throws RemoteException {
        if (!this.f3677x || this.f3681z == null) {
            return;
        }
        int x10 = (int) motionEvent.getX();
        int y4 = (int) (motionEvent.getY() - 60.0f);
        if (this.f3681z.getPosition() != null) {
            DPoint obtain = DPoint.obtain();
            getPixel2LatLng(x10, y4, obtain);
            LatLng latLng = new LatLng(obtain.f6571y, obtain.f6570x);
            obtain.recycle();
            this.f3681z.setPosition(latLng);
            try {
                List a3 = this.f3630b.a(AMap.OnMarkerDragListener.class.hashCode());
                if (a3 == null || a3.size() <= 0) {
                    return;
                }
                synchronized (a3) {
                    for (int i3 = 0; i3 < a3.size(); i3++) {
                        try {
                            ((AMap.OnMarkerDragListener) a3.get(i3)).onMarkerDrag(this.f3681z);
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void c() {
        if (this.P) {
            return;
        }
        try {
            if (this.K == null) {
                this.K = new com.amap.api.col.p0003sl.q0(this.f3631b0, this);
            }
            this.K.setName("AuthProThread");
            this.K.start();
            this.P = true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            v4.a(th2);
        }
    }

    private boolean e(MotionEvent motionEvent) throws RemoteException {
        Throwable th2;
        LatLng position;
        DPoint obtain = DPoint.obtain();
        getPixel2LatLng((int) motionEvent.getX(), (int) motionEvent.getY(), obtain);
        LatLng latLng = new LatLng(obtain.f6571y, obtain.f6570x);
        obtain.recycle();
        boolean z5 = true;
        BaseOverlay hitBaseOverlay = this.f3656m.getHitBaseOverlay(latLng, 1);
        if ((hitBaseOverlay instanceof Marker) && ((Marker) hitBaseOverlay).getId().contains("MARKER")) {
            try {
                Marker marker = (Marker) hitBaseOverlay;
                this.f3656m.set2Top(marker.getId());
                List a3 = this.f3630b.a(AMap.OnMarkerClickListener.class.hashCode());
                if (a3 != null) {
                    try {
                        if (a3.size() > 0) {
                            synchronized (a3) {
                                try {
                                    if (a3.size() == 1) {
                                        boolean onMarkerClick = ((AMap.OnMarkerClickListener) a3.get(0)).onMarkerClick(marker);
                                        if (onMarkerClick) {
                                            return true;
                                        }
                                        z5 = onMarkerClick;
                                    } else {
                                        Iterator it = a3.iterator();
                                        boolean z6 = false;
                                        while (it.hasNext()) {
                                            z6 |= ((AMap.OnMarkerClickListener) it.next()).onMarkerClick(marker);
                                        }
                                        if (z6) {
                                            return true;
                                        }
                                        z5 = z6;
                                    }
                                } finally {
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        ka.a(th2, "AMapDelegateImp", "onMarkerTap");
                        th2.printStackTrace();
                        return false;
                    }
                }
                this.f3656m.showInfoWindow(marker.getId());
                if (marker.isViewMode() || (position = marker.getPosition()) == null) {
                    return z5;
                }
                IPoint obtain2 = IPoint.obtain();
                try {
                    latlon2Geo(position.latitude, position.longitude, obtain2);
                    moveCamera(com.amap.api.col.p0003sl.x.a(obtain2));
                    return z5;
                } catch (Throwable th4) {
                    th = th4;
                    th2 = th;
                    ka.a(th2, "AMapDelegateImp", "onMarkerTap");
                    th2.printStackTrace();
                    return false;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.IAMapDelegate
    public void setCustomMapStyle(boolean z5, byte[] bArr) {
        a(z5, bArr, false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void setMapCustomEnable(boolean z5) {
        if (z5) {
            c();
        }
        setMapCustomEnable(z5, false);
    }

    public void c(int i3, boolean z5) {
        if (this.f3661o0 && this.f3663p0) {
            resetRenderTime();
            queueEvent(new j(i3, z5));
        } else {
            p0 p0Var = this.J0;
            p0Var.f3738b = z5;
            p0Var.f3737a = true;
            p0Var.e = i3;
        }
    }

    private synchronized void b() {
        synchronized (this.V) {
            if (this.V.size() <= 0) {
                this.V.clear();
            } else {
                this.V.get(0).getClass();
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(CameraPosition cameraPosition, boolean z5) {
        if (z5 && cameraPosition.zoom < 6.0f) {
            return false;
        }
        if (cameraPosition.isAbroad) {
            return true;
        }
        if (this.r != null) {
            return e();
        }
        return false;
    }

    public void g() {
        GLMapState mapState;
        List a3;
        List a10;
        List a11;
        if (this.f3662p.get() || (mapState = this.f3634c0.getMapState(this.f3660o)) == null) {
            return;
        }
        mapState.getViewMatrix(this.r.getViewMatrix());
        mapState.getProjectionMatrix(this.r.getProjectionMatrix());
        this.r.updateFinalMatrix();
        DPoint mapGeoCenter = mapState.getMapGeoCenter();
        this.r.setSX(mapGeoCenter.f6570x);
        this.r.setSY(mapGeoCenter.f6571y);
        this.r.setSZ(mapState.getMapZoomer());
        this.r.setSC(mapState.getCameraDegree());
        this.r.setSR(mapState.getMapAngle());
        this.r.setSkyHeight(mapState.getSkyHeight());
        if (this.r.isMapStateChange()) {
            DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(mapGeoCenter.f6570x, mapGeoCenter.f6571y, 20);
            CameraPosition cameraPosition = new CameraPosition(new LatLng(pixelsToLatLong.f6571y, pixelsToLatLong.f6570x, false), this.r.getSZ(), this.r.getSC(), this.r.getSR());
            pixelsToLatLong.recycle();
            Message obtainMessage = this.E0.obtainMessage();
            obtainMessage.what = 10;
            obtainMessage.obj = cameraPosition;
            this.E0.sendMessage(obtainMessage);
            this.f3659n0 = true;
            redrawInfoWindow();
            try {
                if (this.f3643g.isZoomControlsEnabled() && this.r.isNeedUpdateZoomControllerState() && (a11 = this.f3630b.a(AMapWidgetListener.class.hashCode())) != null && a11.size() > 0) {
                    synchronized (a11) {
                        for (int i3 = 0; i3 < a11.size(); i3++) {
                            try {
                                ((AMapWidgetListener) a11.get(i3)).invalidateZoomController(this.r.getSZ());
                            } finally {
                            }
                        }
                    }
                }
                if (this.r.getChangeGridRatio() != 1.0d) {
                    b(true);
                }
                if (this.f3643g.isCompassEnabled() && ((this.r.isTiltChanged() || this.r.isBearingChanged()) && (a10 = this.f3630b.a(AMapWidgetListener.class.hashCode())) != null && a10.size() > 0)) {
                    synchronized (a10) {
                        for (int i10 = 0; i10 < a10.size(); i10++) {
                            try {
                                ((AMapWidgetListener) a10.get(i10)).invalidateCompassView();
                            } finally {
                            }
                        }
                    }
                }
                if (!this.f3643g.isScaleControlsEnabled() || (a3 = this.f3630b.a(AMapWidgetListener.class.hashCode())) == null || a3.size() <= 0) {
                    return;
                }
                synchronized (a3) {
                    for (int i11 = 0; i11 < a3.size(); i11++) {
                        try {
                            ((AMapWidgetListener) a3.get(i11)).invalidateScaleView();
                        } finally {
                        }
                    }
                }
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                return;
            }
        }
        if (!this.f3657m0 && this.f3634c0.getAnimateionsCount() == 0 && this.f3634c0.getStateMessageCount() == 0) {
            Message obtainMessage2 = this.E0.obtainMessage();
            obtainMessage2.what = 11;
            this.E0.sendMessage(obtainMessage2);
        }
    }

    private void a(boolean z5) {
        com.autonavi.extra.b bVar = this.U0;
        if (bVar != null) {
            Object a3 = bVar.a("getAbroadEnable");
            if (a3 != null && (a3 instanceof Boolean)) {
                MapConfig mapConfig = this.r;
                if (mapConfig != null) {
                    mapConfig.setAbroadEnable(z5 && ((Boolean) a3).booleanValue());
                }
                if (z5 && ((Boolean) a3).booleanValue()) {
                    MapsInitializer.setSupportRecycleView(false);
                }
            }
            Object a10 = this.U0.a("getLogoEnable");
            if (a10 != null && (a10 instanceof Boolean)) {
                ((g5) this.f3652k).a(((Boolean) a10).booleanValue());
            }
            Object a11 = this.U0.a("getMapZindex");
            if (a10 == null || !(a10 instanceof Integer)) {
                return;
            }
            this.Q = ((Integer) a11).intValue();
        }
    }

    public void b(boolean z5) {
        this.E0.obtainMessage(17, z5 ? 1 : 0, 0).sendToTarget();
    }

    public void b(int i3) {
        if (this.f3657m0) {
            this.f3657m0 = false;
        }
        GLMapRender gLMapRender = this.f3637d0;
        if (gLMapRender != null) {
            gLMapRender.renderPause();
        }
        queueEvent(new com.amap.api.col.p0003sl.g0(this, i3));
    }

    public void b(int i3, boolean z5) {
        if (this.f3661o0 && this.f3663p0) {
            resetRenderTime();
            queueEvent(new l(z5, i3));
        } else {
            p0 p0Var = this.T0;
            p0Var.f3738b = z5;
            p0Var.f3737a = true;
            p0Var.e = i3;
        }
    }

    private void a(MotionEvent motionEvent) {
        if (!this.f3679y || this.A == null) {
            return;
        }
        int x10 = (int) motionEvent.getX();
        int y4 = (int) (motionEvent.getY() - 60.0f);
        if (this.A.getLatlng() != null) {
            DPoint obtain = DPoint.obtain();
            getPixel2LatLng(x10, y4, obtain);
            LatLng latLng = new LatLng(obtain.f6571y, obtain.f6570x);
            obtain.recycle();
            this.A.setLatLng(latLng);
        }
    }

    public Size b(Size size) {
        Size size2 = new Size(this.f3644g0, this.f3647h0);
        a(this.f3660o, 0, 0, size.getWidth(), size.getHeight(), size.getWidth(), size.getHeight());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(size.getWidth(), size.getHeight());
        getGLMapView().setLayoutParams(layoutParams);
        ((g5) this.f3652k).f().setLayoutParams(layoutParams);
        changeSize(size.getWidth(), size.getHeight());
        this.f3655l0 = false;
        return size2;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void createSurface(GL10 gl10, EGLConfig eGLConfig) {
        try {
            this.Z = Thread.currentThread().getId();
        } catch (Throwable th2) {
            th2.printStackTrace();
            v4.a(th2);
        }
        try {
            createSurface(1, gl10, eGLConfig);
        } catch (Throwable th3) {
            th3.printStackTrace();
            v4.a(th3);
        }
    }

    public void a(GLMapState gLMapState, int i3, int i10, DPoint dPoint) {
        if (!this.f3661o0 || this.f3634c0 == null) {
            return;
        }
        gLMapState.screenToP20Point(i3, i10, new Point());
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(r0.x, r0.y, 20);
        dPoint.f6570x = pixelsToLatLong.f6570x;
        dPoint.f6571y = pixelsToLatLong.f6571y;
        pixelsToLatLong.recycle();
    }

    public void a(int i3, int i10, FPoint fPoint) {
        GLMapEngine gLMapEngine;
        GLMapState mapState;
        if (this.f3662p.get() || !this.f3661o0 || (gLMapEngine = this.f3634c0) == null || (mapState = gLMapEngine.getMapState(this.f3660o)) == null) {
            return;
        }
        mapState.p20ToScreenPoint(i3, i10, fPoint);
    }

    public synchronized void a(int i3, int i10, int i11) {
        a(i3, i10, i11, false, null);
    }

    public synchronized void a(int i3, int i10, int i11, boolean z5, StyleItem[] styleItemArr) {
        Throwable th2;
        try {
            try {
                if (this.f3663p0 && this.f3661o0 && this.f3646h) {
                    h5 h5Var = this.f3652k;
                    if (h5Var != null) {
                        try {
                            if (i11 == 0) {
                                if (((g5) h5Var).h()) {
                                    ((g5) this.f3652k).a(Boolean.FALSE);
                                    ((g5) this.f3652k).i();
                                }
                            } else if (!((g5) h5Var).h()) {
                                ((g5) this.f3652k).a(Boolean.TRUE);
                                ((g5) this.f3652k).i();
                            }
                        } catch (Throwable th3) {
                            th2 = th3;
                            throw th2;
                        }
                    }
                    queueEvent(new i(i3, i10, i11, z5, styleItemArr));
                } else {
                    p0 p0Var = this.H0;
                    p0Var.e = i3;
                    p0Var.f3739c = i10;
                    p0Var.f3740d = i11;
                    p0Var.f3737a = true;
                }
            } catch (Throwable th4) {
                th = th4;
                th2 = th;
                throw th2;
            }
        } catch (Throwable th5) {
            th = th5;
            th2 = th;
            throw th2;
        }
    }

    public void a(int i3, boolean z5) {
        if (this.f3661o0 && this.f3663p0) {
            resetRenderTime();
            queueEvent(new k(z5, i3));
        } else {
            p0 p0Var = this.Q0;
            p0Var.f3738b = z5;
            p0Var.f3737a = true;
            p0Var.e = i3;
        }
    }

    public void a(int i3, int i10, int i11, int i12, int i13, int i14, int i15) {
        GLMapEngine gLMapEngine = this.f3634c0;
        if (gLMapEngine != null) {
            gLMapEngine.setServiceViewRect(i3, i10, i11, i12, i13, i14, i15);
        }
    }

    private void a(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        boolean z5 = this.f3667s;
        abstractCameraUpdateMessage.isUseAnchor = z5;
        if (z5) {
            abstractCameraUpdateMessage.anchorX = this.r.getAnchorX();
            abstractCameraUpdateMessage.anchorY = this.r.getAnchorY();
        }
        if (abstractCameraUpdateMessage.width == 0) {
            abstractCameraUpdateMessage.width = this.f3644g0;
        }
        if (abstractCameraUpdateMessage.height == 0) {
            abstractCameraUpdateMessage.height = this.f3647h0;
        }
        abstractCameraUpdateMessage.mapConfig = this.r;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005a A[Catch: all -> 0x0048, TryCatch #0 {all -> 0x0048, blocks: (B:6:0x0026, B:8:0x0038, B:10:0x003c, B:12:0x0042, B:13:0x0054, B:14:0x0072, B:22:0x004a, B:23:0x005a, B:25:0x0068, B:26:0x006d, B:40:0x0022), top: B:39:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0038 A[Catch: all -> 0x0048, TryCatch #0 {all -> 0x0048, blocks: (B:6:0x0026, B:8:0x0038, B:10:0x003c, B:12:0x0042, B:13:0x0054, B:14:0x0072, B:22:0x004a, B:23:0x005a, B:25:0x0068, B:26:0x006d, B:40:0x0022), top: B:39:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(int r6) {
        /*
            r5 = this;
            r5.I = r6
            r0 = 0
            r1 = 1
            if (r6 != r1) goto L7
            goto L24
        L7:
            r2 = 2
            if (r6 != r2) goto Ld
            r6 = r0
            r2 = r1
            goto L26
        Ld:
            r3 = 3
            if (r6 != r3) goto L13
            r2 = r0
        L11:
            r6 = r1
            goto L26
        L13:
            r4 = 4
            if (r6 != r4) goto L18
            r6 = r0
            goto L26
        L18:
            r4 = 6
            if (r6 != r4) goto L1c
            goto L11
        L1c:
            r2 = 5
            if (r6 != r2) goto L22
            r6 = r0
            r2 = r3
            goto L26
        L22:
            r5.I = r1     // Catch: java.lang.Throwable -> L48
        L24:
            r6 = r0
            r2 = r6
        L26:
            com.autonavi.base.amap.mapcore.MapConfig r3 = r5.r     // Catch: java.lang.Throwable -> L48
            r3.setMapStyleMode(r2)     // Catch: java.lang.Throwable -> L48
            com.autonavi.base.amap.mapcore.MapConfig r3 = r5.r     // Catch: java.lang.Throwable -> L48
            r3.setMapStyleTime(r6)     // Catch: java.lang.Throwable -> L48
            com.autonavi.base.amap.mapcore.MapConfig r3 = r5.r     // Catch: java.lang.Throwable -> L48
            boolean r3 = r3.isCustomStyleEnable()     // Catch: java.lang.Throwable -> L48
            if (r3 == 0) goto L5a
            com.amap.api.col.3sl.a0 r3 = r5.f3682z0     // Catch: java.lang.Throwable -> L48
            if (r3 == 0) goto L4a
            boolean r3 = r3.b()     // Catch: java.lang.Throwable -> L48
            if (r3 == 0) goto L4a
            com.amap.api.col.3sl.a0 r6 = r5.f3682z0     // Catch: java.lang.Throwable -> L48
            r6.d()     // Catch: java.lang.Throwable -> L48
            goto L54
        L48:
            r6 = move-exception
            goto L76
        L4a:
            int r3 = r5.f3660o     // Catch: java.lang.Throwable -> L48
            r5.a(r3, r2, r6)     // Catch: java.lang.Throwable -> L48
            com.autonavi.base.amap.mapcore.MapConfig r6 = r5.r     // Catch: java.lang.Throwable -> L48
            r6.setCustomStyleEnable(r0)     // Catch: java.lang.Throwable -> L48
        L54:
            com.amap.api.col.3sl.h1 r6 = r5.f3643g     // Catch: java.lang.Throwable -> L48
            r6.setLogoEnable(r1)     // Catch: java.lang.Throwable -> L48
            goto L72
        L5a:
            com.autonavi.base.amap.mapcore.MapConfig r0 = r5.r     // Catch: java.lang.Throwable -> L48
            java.lang.String r0 = r0.getMapLanguage()     // Catch: java.lang.Throwable -> L48
            java.lang.String r1 = "en"
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L48
            if (r0 == 0) goto L6d
            java.lang.String r0 = "zh_cn"
            r5.setMapLanguage(r0)     // Catch: java.lang.Throwable -> L48
        L6d:
            int r0 = r5.f3660o     // Catch: java.lang.Throwable -> L48
            r5.a(r0, r2, r6)     // Catch: java.lang.Throwable -> L48
        L72:
            r5.resetRenderTime()     // Catch: java.lang.Throwable -> L48
            return
        L76:
            java.lang.String r0 = "AMapDelegateImp"
            java.lang.String r1 = "setMaptype"
            com.amap.api.col.p0003sl.ka.a(r6, r0, r1)
            r6.printStackTrace()
            com.amap.api.col.p0003sl.v4.a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.b0.a(int):void");
    }

    private void a() {
        try {
            LatLngBounds limitLatLngBounds = this.r.getLimitLatLngBounds();
            GLMapEngine gLMapEngine = this.f3634c0;
            if (gLMapEngine != null && limitLatLngBounds != null && limitLatLngBounds.northeast != null && limitLatLngBounds.southwest != null) {
                GLMapState gLMapState = new GLMapState(this.f3660o, gLMapEngine.getNativeInstance());
                IPoint obtain = IPoint.obtain();
                LatLng latLng = limitLatLngBounds.northeast;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                IPoint obtain2 = IPoint.obtain();
                LatLng latLng2 = limitLatLngBounds.southwest;
                GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, obtain2);
                this.r.setLimitIPoints(new IPoint[]{obtain, obtain2});
                gLMapState.recycle();
                return;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.r.setLimitIPoints(null);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IAMap
    public void changeSurface(GL10 gl10, int i3, int i10) {
        try {
            changeSurface(1, gl10, i3, i10);
        } catch (Throwable th2) {
            th2.printStackTrace();
            v4.a(th2);
        }
    }

    public void a(CameraPosition cameraPosition) {
        MapConfig mapConfig = this.r;
        if (mapConfig == null || mapConfig.getChangedCounter() == 0) {
            return;
        }
        try {
            if (!this.f3657m0 && this.f3634c0.getAnimateionsCount() == 0 && this.f3634c0.getStateMessageCount() == 0) {
                AMapGestureListener aMapGestureListener = this.f3633c;
                if (aMapGestureListener != null) {
                    aMapGestureListener.onMapStable();
                }
                if (this.f3650j.isEnabled()) {
                    try {
                        List a3 = this.f3630b.a(AMap.OnCameraChangeListener.class.hashCode());
                        if (a3 != null && a3.size() != 0) {
                            if (cameraPosition == null) {
                                try {
                                    cameraPosition = getCameraPosition();
                                } catch (Throwable th2) {
                                    ka.a(th2, "AMapDelegateImp", "cameraChangeFinish");
                                    th2.printStackTrace();
                                }
                            }
                            synchronized (a3) {
                                try {
                                    Iterator it = a3.iterator();
                                    while (it.hasNext()) {
                                        ((AMap.OnCameraChangeListener) it.next()).onCameraChangeFinish(cameraPosition);
                                    }
                                } finally {
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    this.r.resetChangedCounter();
                }
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
            v4.a(th3);
        }
    }

    public void a(String str, a4 a4Var) {
        if (!TextUtils.isEmpty(str)) {
            this.r.setCustomTextureResourcePath(str);
        }
        if (!this.r.isCustomStyleEnable() || a4Var == null) {
            return;
        }
        a(a4Var.b(), false);
    }

    public void a(byte[] bArr) {
        com.autonavi.extra.b bVar = this.U0;
        if (bVar != null) {
            bVar.a("onAbroadStyleComplete", bArr);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0058 A[Catch: all -> 0x0015, TryCatch #1 {all -> 0x0015, blocks: (B:2:0x0000, B:4:0x000d, B:7:0x001b, B:9:0x002e, B:14:0x003e, B:18:0x0049, B:20:0x004f, B:22:0x0058, B:24:0x0060, B:30:0x0073, B:32:0x0078, B:33:0x007c, B:35:0x0082, B:36:0x008b, B:39:0x0043, B:41:0x008f, B:27:0x0069), top: B:1:0x0000, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0082 A[Catch: all -> 0x0015, TryCatch #1 {all -> 0x0015, blocks: (B:2:0x0000, B:4:0x000d, B:7:0x001b, B:9:0x002e, B:14:0x003e, B:18:0x0049, B:20:0x004f, B:22:0x0058, B:24:0x0060, B:30:0x0073, B:32:0x0078, B:33:0x007c, B:35:0x0082, B:36:0x008b, B:39:0x0043, B:41:0x008f, B:27:0x0069), top: B:1:0x0000, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r5, byte[] r6, boolean r7) {
        /*
            r4 = this;
            com.autonavi.base.amap.mapcore.MapConfig r0 = r4.r     // Catch: java.lang.Throwable -> L15
            r0.setCustomStyleEnable(r5)     // Catch: java.lang.Throwable -> L15
            com.autonavi.base.amap.mapcore.MapConfig r0 = r4.r     // Catch: java.lang.Throwable -> L15
            boolean r0 = r0.isHideLogoEnable()     // Catch: java.lang.Throwable -> L15
            if (r0 == 0) goto L18
            com.amap.api.col.3sl.h1 r0 = r4.f3643g     // Catch: java.lang.Throwable -> L15
            r1 = r5 ^ 1
            r0.setLogoEnable(r1)     // Catch: java.lang.Throwable -> L15
            goto L18
        L15:
            r5 = move-exception
            goto La6
        L18:
            r0 = 0
            if (r5 == 0) goto L8f
            int r5 = r4.f3660o     // Catch: java.lang.Throwable -> L15
            r1 = 1
            r4.b(r5, r1)     // Catch: java.lang.Throwable -> L15
            com.amap.api.col.3sl.z3 r5 = new com.amap.api.col.3sl.z3     // Catch: java.lang.Throwable -> L15
            r5.<init>()     // Catch: java.lang.Throwable -> L15
            com.autonavi.base.amap.mapcore.MapConfig r2 = r4.r     // Catch: java.lang.Throwable -> L15
            boolean r2 = r2.isProFunctionAuthEnable()     // Catch: java.lang.Throwable -> L15
            if (r2 == 0) goto L3b
            com.autonavi.base.amap.mapcore.MapConfig r2 = r4.r     // Catch: java.lang.Throwable -> L15
            java.lang.String r2 = r2.getCustomTextureResourcePath()     // Catch: java.lang.Throwable -> L15
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L15
            if (r2 != 0) goto L3b
            r0 = r1
        L3b:
            r2 = 0
            if (r6 == 0) goto L55
            int r3 = r6.length     // Catch: java.lang.Throwable -> L15
            if (r3 != 0) goto L43
            r6 = r2
            goto L47
        L43:
            com.amap.api.col.3sl.a4 r6 = r5.a(r6, r0)     // Catch: java.lang.Throwable -> L15
        L47:
            if (r6 == 0) goto L55
            com.autonavi.base.ae.gmap.style.StyleItem[] r6 = r6.b()     // Catch: java.lang.Throwable -> L15
            if (r6 == 0) goto L56
            com.autonavi.base.amap.mapcore.MapConfig r3 = r4.r     // Catch: java.lang.Throwable -> L15
            r3.setUseProFunction(r1)     // Catch: java.lang.Throwable -> L15
            goto L56
        L55:
            r6 = r2
        L56:
            if (r6 != 0) goto L7c
            com.autonavi.base.amap.mapcore.MapConfig r1 = r4.r     // Catch: java.lang.Throwable -> L15
            java.lang.String r1 = r1.getCustomStylePath()     // Catch: java.lang.Throwable -> L15
            if (r1 == 0) goto L76
            java.lang.String r3 = ""
            boolean r3 = r3.equals(r1)     // Catch: java.lang.Throwable -> L15
            if (r3 == 0) goto L69
            goto L76
        L69:
            byte[] r1 = com.autonavi.base.amap.mapcore.FileUtil.readFileContents(r1)     // Catch: java.lang.Throwable -> L72
            com.amap.api.col.3sl.a4 r2 = r5.a(r1, r0)     // Catch: java.lang.Throwable -> L72
            goto L76
        L72:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L15
        L76:
            if (r2 == 0) goto L7c
            com.autonavi.base.ae.gmap.style.StyleItem[] r6 = r2.b()     // Catch: java.lang.Throwable -> L15
        L7c:
            int r0 = r5.a()     // Catch: java.lang.Throwable -> L15
            if (r0 == 0) goto L8b
            com.autonavi.base.amap.mapcore.MapConfig r0 = r4.r     // Catch: java.lang.Throwable -> L15
            int r5 = r5.a()     // Catch: java.lang.Throwable -> L15
            r0.setCustomBackgroundColor(r5)     // Catch: java.lang.Throwable -> L15
        L8b:
            r4.a(r6, r7)     // Catch: java.lang.Throwable -> L15
            goto La9
        L8f:
            int r5 = r4.f3660o     // Catch: java.lang.Throwable -> L15
            r4.b(r5, r0)     // Catch: java.lang.Throwable -> L15
            int r5 = r4.f3660o     // Catch: java.lang.Throwable -> L15
            com.autonavi.base.amap.mapcore.MapConfig r6 = r4.r     // Catch: java.lang.Throwable -> L15
            int r6 = r6.getMapStyleMode()     // Catch: java.lang.Throwable -> L15
            com.autonavi.base.amap.mapcore.MapConfig r7 = r4.r     // Catch: java.lang.Throwable -> L15
            int r7 = r7.getMapStyleTime()     // Catch: java.lang.Throwable -> L15
            r4.a(r5, r6, r7)     // Catch: java.lang.Throwable -> L15
            return
        La6:
            com.amap.api.col.p0003sl.v4.a(r5)
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.b0.a(boolean, byte[], boolean):void");
    }

    public void a(StyleItem[] styleItemArr, boolean z5) {
        if (!z5 && (styleItemArr == null || styleItemArr.length <= 0)) {
            t4.a(this.f3631b0, false);
        } else {
            a(this.f3660o, 0, 0, true, styleItemArr);
            t4.a(this.f3631b0, true);
        }
    }

    public void a(Size size) {
        a(this.f3660o, 0, 0, size.getWidth(), size.getHeight(), size.getWidth(), size.getHeight());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        getGLMapView().setLayoutParams(layoutParams);
        ((g5) this.f3652k).f().setLayoutParams(layoutParams);
        changeSize(size.getWidth(), size.getHeight());
        this.f3655l0 = true;
    }

    private boolean a(boolean z5, boolean z6) {
        if (z5) {
            if (this.Y0) {
                c4.a("setCustomMapStyle 和 setWorldVectorMapStyle 不能同时使用，setCustomMapStyle将不会生效");
                return true;
            }
            this.X0 = true;
        }
        if (!z6) {
            return false;
        }
        if (this.X0) {
            c4.a("setCustomMapStyle 和 setWorldVectorMapStyle 不能同时使用，setWorldVectorMapStyle将不会生效");
            return true;
        }
        this.Y0 = true;
        return false;
    }
}
