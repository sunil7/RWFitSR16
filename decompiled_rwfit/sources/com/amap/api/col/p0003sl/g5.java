package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.amap.api.col.p0003sl.e5;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.interfaces.INativeOverlayLayer;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;

/* loaded from: classes.dex */
public class g5 extends ViewGroup implements h5 {

    /* renamed from: a, reason: collision with root package name */
    private IAMapDelegate f4169a;

    /* renamed from: b, reason: collision with root package name */
    private IGlOverlayLayer f4170b;

    /* renamed from: c, reason: collision with root package name */
    private INativeOverlayLayer f4171c;

    /* renamed from: d, reason: collision with root package name */
    private Context f4172d;
    private l5 e;

    /* renamed from: f, reason: collision with root package name */
    private f5 f4173f;

    /* renamed from: g, reason: collision with root package name */
    private d5 f4174g;

    /* renamed from: h, reason: collision with root package name */
    private j5 f4175h;

    /* renamed from: i, reason: collision with root package name */
    private c5 f4176i;

    /* renamed from: j, reason: collision with root package name */
    private e5 f4177j;

    /* renamed from: k, reason: collision with root package name */
    private m5 f4178k;

    /* renamed from: l, reason: collision with root package name */
    private View f4179l;

    /* renamed from: m, reason: collision with root package name */
    private BasePointOverlay f4180m;

    /* renamed from: n, reason: collision with root package name */
    private Drawable f4181n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f4182o;

    /* renamed from: p, reason: collision with root package name */
    private View f4183p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f4184q;
    i5 r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f4185s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f4186t;

    /* renamed from: u, reason: collision with root package name */
    w1 f4187u;

    public class a implements AMapWidgetListener {

        /* renamed from: com.amap.api.col.3sl.g5$a$a, reason: collision with other inner class name */
        public class RunnableC0004a implements Runnable {
            public RunnableC0004a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g5.this.f4175h.a();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g5.this.f4174g.a();
            }
        }

        public class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ float f4191a;

            public c(float f2) {
                this.f4191a = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                g5.this.f4178k.a(this.f4191a);
            }
        }

        public a() {
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public void invalidateCompassView() {
            if (g5.this.f4174g == null) {
                return;
            }
            g5.this.f4174g.post(new b());
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public void invalidateScaleView() {
            if (g5.this.f4175h == null) {
                return;
            }
            g5.this.f4175h.post(new RunnableC0004a());
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public void invalidateZoomController(float f2) {
            if (g5.this.f4178k == null) {
                return;
            }
            g5.this.f4178k.post(new c(f2));
        }

        @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
        public void setFrontViewVisibility(boolean z5) {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g5.this.f4179l != null) {
                g5.this.f4179l.clearFocus();
                g5 g5Var = g5.this;
                g5Var.removeView(g5Var.f4179l);
                v4.a(g5.this.f4179l.getBackground());
                v4.a(g5.this.f4181n);
                g5.a(g5.this, (View) null);
            }
        }
    }

    public static class c extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public FPoint f4194a;

        /* renamed from: b, reason: collision with root package name */
        public int f4195b;

        /* renamed from: c, reason: collision with root package name */
        public int f4196c;

        /* renamed from: d, reason: collision with root package name */
        public int f4197d;

        public c(int i3, int i10, FPoint fPoint, int i11, int i12, int i13) {
            this(i3, i10, ((PointF) fPoint).x, ((PointF) fPoint).y, i11, i12, i13);
        }

        public c(int i3, int i10, float f2, float f10, int i11, int i12, int i13) {
            super(i3, i10);
            FPoint fPoint = new FPoint();
            this.f4194a = fPoint;
            ((PointF) fPoint).x = f2;
            ((PointF) fPoint).y = f10;
            this.f4195b = i11;
            this.f4196c = i12;
            this.f4197d = i13;
        }
    }

    public g5(Context context, IAMapDelegate iAMapDelegate, IGlOverlayLayer iGlOverlayLayer, INativeOverlayLayer iNativeOverlayLayer) {
        super(context);
        this.f4181n = null;
        int i3 = 1;
        this.f4182o = true;
        this.f4185s = true;
        this.f4186t = true;
        try {
            this.f4170b = iGlOverlayLayer;
            this.f4171c = iNativeOverlayLayer;
            this.f4169a = iAMapDelegate;
            this.f4172d = context;
            this.r = new i5();
            this.f4176i = new c5(context);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (this.f4169a.getGLMapView() != null) {
                addView(this.f4169a.getGLMapView(), 0, layoutParams);
            } else {
                i3 = 0;
            }
            addView(this.f4176i, i3, layoutParams);
            addView((b1) this.f4171c, layoutParams);
            if (this.f4185s) {
                return;
            }
            a(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
            v4.a(th2);
        }
    }

    private void j() {
        j5 j5Var = this.f4175h;
        if (j5Var == null) {
            this.r.a(this, new Object[0]);
        } else if (j5Var.getVisibility() == 0) {
            this.f4175h.postInvalidate();
        }
    }

    public void f(Boolean bool) {
        if (this.f4173f == null) {
            this.r.a(this, bool);
        } else if (bool.booleanValue()) {
            this.f4173f.setVisibility(0);
        } else {
            this.f4173f.setVisibility(8);
        }
    }

    public void g(Boolean bool) {
        j5 j5Var = this.f4175h;
        if (j5Var == null) {
            this.r.a(this, bool);
        } else {
            j5Var.a(bool.booleanValue());
        }
    }

    public boolean h() {
        l5 l5Var = this.e;
        if (l5Var != null) {
            return l5Var.d();
        }
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void hideInfoWindow() {
        try {
            IAMapDelegate iAMapDelegate = this.f4169a;
            if (iAMapDelegate == null || iAMapDelegate.getMainHandler() == null) {
                return;
            }
            this.f4169a.getMainHandler().post(new b());
            BasePointOverlay basePointOverlay = this.f4180m;
            if (basePointOverlay != null) {
                this.f4170b.getNativeProperties(basePointOverlay.getId(), "setInfoWindowShown", new Object[]{Boolean.FALSE});
            }
            this.f4180m = null;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void i(Boolean bool) {
        m5 m5Var = this.f4178k;
        if (m5Var == null) {
            this.r.a(this, bool);
        } else if (bool.booleanValue()) {
            m5Var.setVisibility(0);
        } else {
            m5Var.setVisibility(8);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public boolean isInfoWindowShown() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public boolean onInfoWindowTap(MotionEvent motionEvent) {
        if (this.f4179l != null && this.f4180m != null) {
            Rect rect = new Rect(this.f4179l.getLeft(), this.f4179l.getTop(), this.f4179l.getRight(), this.f4179l.getBottom());
            int x10 = (int) motionEvent.getX();
            int y4 = (int) motionEvent.getY();
            int i3 = v4.f5181b;
            if (rect.contains(x10, y4)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        try {
            int childCount = getChildCount();
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                if (childAt != null) {
                    if (childAt.getLayoutParams() instanceof c) {
                        a(childAt, (c) childAt.getLayoutParams());
                    } else {
                        a(childAt, childAt.getLayoutParams());
                    }
                }
            }
            l5 l5Var = this.e;
            if (l5Var != null) {
                l5Var.e();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void redrawInfoWindow() {
        try {
            BasePointOverlay basePointOverlay = this.f4180m;
            boolean checkInBounds = basePointOverlay != null ? basePointOverlay instanceof Marker ? ((Marker) basePointOverlay).isIconView() ? this.f4171c.checkInBounds(this.f4180m.getId()) : this.f4170b.checkInBounds(this.f4180m.getId()) : this.f4170b.checkInBounds(basePointOverlay.getId()) : true;
            try {
                if (this.f4180m == null || !checkInBounds) {
                    View view = this.f4179l;
                    if (view == null || view.getVisibility() != 0) {
                        return;
                    }
                    this.f4179l.setVisibility(8);
                    return;
                }
                if (this.f4182o) {
                    FPoint obtain = FPoint.obtain();
                    BasePointOverlay basePointOverlay2 = this.f4180m;
                    if (!(basePointOverlay2 instanceof Marker)) {
                        this.f4170b.getMarkerInfoWindowOffset(basePointOverlay2.getId(), obtain);
                    } else if (((Marker) basePointOverlay2).isIconView()) {
                        this.f4171c.getMarkerInfoWindowOffset(this.f4180m.getId(), obtain);
                    } else {
                        this.f4170b.getMarkerInfoWindowOffset(this.f4180m.getId(), obtain);
                    }
                    int i3 = (int) ((PointF) obtain).x;
                    int i10 = (int) (((PointF) obtain).y + 2.0f);
                    obtain.recycle();
                    View a3 = a(this.f4180m);
                    if (a3 != null) {
                        FPoint obtain2 = FPoint.obtain();
                        BasePointOverlay basePointOverlay3 = this.f4180m;
                        if (!(basePointOverlay3 instanceof Marker)) {
                            this.f4170b.getOverlayScreenPos(basePointOverlay3.getId(), obtain2);
                        } else if (((Marker) basePointOverlay3).isIconView()) {
                            this.f4171c.getOverlayScreenPos(this.f4180m.getId(), obtain2);
                        } else {
                            this.f4170b.getOverlayScreenPos(this.f4180m.getId(), obtain2);
                        }
                        a(a3, (int) ((PointF) obtain2).x, (int) ((PointF) obtain2).y, i3, i10);
                        View view2 = this.f4179l;
                        if (view2 != null) {
                            c cVar = (c) view2.getLayoutParams();
                            if (cVar != null) {
                                cVar.f4194a = FPoint.obtain(((PointF) obtain2).x, ((PointF) obtain2).y);
                                cVar.f4195b = i3;
                                cVar.f4196c = i10;
                            }
                            try {
                                onLayout(false, 0, 0, 0, 0);
                                if (this.f4187u.b()) {
                                    this.f4187u.a(this.f4180m.getTitle(), this.f4180m.getSnippet());
                                }
                                if (this.f4179l.getVisibility() == 8) {
                                    this.f4179l.setVisibility(0);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                ka.a(th, "MapOverlayViewGroup", "redrawInfoWindow");
                                v4.a(th);
                                return;
                            }
                        }
                        obtain2.recycle();
                        return;
                    }
                    View view3 = this.f4179l;
                    if (view3 != null && view3.getVisibility() == 0) {
                        hideInfoWindow();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void setInfoWindowAdapterManager(w1 w1Var) {
        this.f4187u = w1Var;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void showInfoWindow(BasePointOverlay basePointOverlay) {
        if (basePointOverlay == null) {
            return;
        }
        try {
            w1 w1Var = this.f4187u;
            if ((w1Var == null || !w1Var.b() || basePointOverlay.getTitle() != null || basePointOverlay.getSnippet() != null) && basePointOverlay.isInfoWindowEnable()) {
                BasePointOverlay basePointOverlay2 = this.f4180m;
                if (basePointOverlay2 != null && !basePointOverlay2.getId().equals(basePointOverlay.getId())) {
                    hideInfoWindow();
                }
                if (this.f4187u != null) {
                    this.f4180m = basePointOverlay;
                    this.f4184q = true;
                    this.f4170b.getNativeProperties(basePointOverlay.getId(), "setInfoWindowShown", new Object[]{Boolean.TRUE});
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ View a(g5 g5Var, View view) {
        g5Var.f4179l = null;
        return null;
    }

    public void b(Integer num) {
        l5 l5Var = this.e;
        if (l5Var == null) {
            this.r.a(this, num);
        } else {
            l5Var.c(num.intValue());
            j();
        }
    }

    public void c(Boolean bool) {
        d5 d5Var = this.f4174g;
        if (d5Var == null) {
            this.r.a(this, bool);
        } else if (!bool.booleanValue()) {
            d5Var.setVisibility(8);
        } else {
            d5Var.setVisibility(0);
            d5Var.a();
        }
    }

    public void d(Boolean bool) {
        if (this.f4177j == null) {
            this.r.a(this, bool);
        } else if (bool.booleanValue() && this.f4169a.canShowIndoorSwitch()) {
            this.f4177j.a(true);
        }
    }

    public void e(Boolean bool) {
        l5 l5Var = this.e;
        if (l5Var == null) {
            this.r.a(this, bool);
        } else {
            l5Var.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    private void a(Context context) {
        l5 l5Var = new l5(context);
        this.e = l5Var;
        l5Var.d(this.f4186t);
        this.f4175h = new j5(context, this.f4169a);
        this.f4177j = new e5(context);
        this.f4178k = new m5(context, this.f4169a);
        this.f4173f = new f5(context, this.f4169a);
        this.f4174g = new d5(context, this.f4169a);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        addView(this.e, layoutParams);
        addView(this.f4175h, layoutParams);
        addView(this.f4177j, new ViewGroup.LayoutParams(-2, -2));
        addView(this.f4178k, new c(-2, -2, new FPoint(0.0f, 0.0f), 0, 0, 83));
        addView(this.f4173f, new c(-2, -2, FPoint.obtain(0.0f, 0.0f), 0, 0, 83));
        addView(this.f4174g, new c(-2, -2, FPoint.obtain(0.0f, 0.0f), 0, 0, 51));
        this.f4174g.setVisibility(8);
        this.f4169a.setMapWidgetListener(new a());
        try {
            if (this.f4169a.getUiSettings().isMyLocationButtonEnabled()) {
                return;
            }
            this.f4173f.setVisibility(8);
        } catch (Throwable th2) {
            ka.a(th2, "AMapDelegateImpGLSurfaceView", "locationView gone");
            th2.printStackTrace();
        }
    }

    public void h(Boolean bool) {
        f5 f5Var = this.f4173f;
        if (f5Var == null) {
            this.r.a(this, bool);
            return;
        }
        boolean booleanValue = bool.booleanValue();
        f5Var.f4083i = booleanValue;
        try {
            if (booleanValue) {
                f5Var.f4081g.setImageBitmap(f5Var.f4076a);
            } else {
                f5Var.f4081g.setImageBitmap(f5Var.f4078c);
            }
            f5Var.f4081g.invalidate();
        } catch (Throwable th2) {
            ka.a(th2, "LocationView", "showSelect");
            th2.printStackTrace();
        }
    }

    public void g() {
        d5 d5Var = this.f4174g;
        if (d5Var == null) {
            this.r.a(this, new Object[0]);
        } else {
            d5Var.a();
        }
    }

    public Point e() {
        l5 l5Var = this.e;
        if (l5Var == null) {
            return null;
        }
        return l5Var.c();
    }

    public void b() {
        hideInfoWindow();
        v4.a(this.f4181n);
        m5 m5Var = this.f4178k;
        if (m5Var != null) {
            m5Var.a();
        }
        j5 j5Var = this.f4175h;
        if (j5Var != null) {
            j5Var.b();
        }
        l5 l5Var = this.e;
        if (l5Var != null) {
            l5Var.b();
        }
        f5 f5Var = this.f4173f;
        if (f5Var != null) {
            try {
                f5Var.removeAllViews();
                Bitmap bitmap = f5Var.f4076a;
                if (bitmap != null) {
                    v4.a(bitmap);
                }
                Bitmap bitmap2 = f5Var.f4077b;
                if (bitmap2 != null) {
                    v4.a(bitmap2);
                }
                if (f5Var.f4077b != null) {
                    v4.a(f5Var.f4078c);
                }
                f5Var.f4076a = null;
                f5Var.f4077b = null;
                f5Var.f4078c = null;
                Bitmap bitmap3 = f5Var.f4079d;
                if (bitmap3 != null) {
                    v4.a(bitmap3);
                    f5Var.f4079d = null;
                }
                Bitmap bitmap4 = f5Var.e;
                if (bitmap4 != null) {
                    v4.a(bitmap4);
                    f5Var.e = null;
                }
                Bitmap bitmap5 = f5Var.f4080f;
                if (bitmap5 != null) {
                    v4.a(bitmap5);
                    f5Var.f4080f = null;
                }
            } catch (Throwable th2) {
                ka.a(th2, "LocationView", "destroy");
                th2.printStackTrace();
            }
        }
        d5 d5Var = this.f4174g;
        if (d5Var != null) {
            try {
                d5Var.removeAllViews();
                Bitmap bitmap6 = d5Var.f3892a;
                if (bitmap6 != null) {
                    v4.a(bitmap6);
                }
                Bitmap bitmap7 = d5Var.f3893b;
                if (bitmap7 != null) {
                    v4.a(bitmap7);
                }
                Bitmap bitmap8 = d5Var.f3894c;
                if (bitmap8 != null) {
                    v4.a(bitmap8);
                }
                Matrix matrix = d5Var.f3896f;
                if (matrix != null) {
                    matrix.reset();
                    d5Var.f3896f = null;
                }
                d5Var.f3894c = null;
                d5Var.f3892a = null;
                d5Var.f3893b = null;
            } catch (Throwable th3) {
                ka.a(th3, "CompassView", "destroy");
                th3.printStackTrace();
            }
        }
        e5 e5Var = this.f4177j;
        if (e5Var != null) {
            e5Var.a();
        }
        removeAllViews();
        this.f4183p = null;
    }

    public l5 f() {
        return this.e;
    }

    public void i() {
        l5 l5Var = this.e;
        if (l5Var == null) {
            this.r.a(this, new Object[0]);
        } else {
            l5Var.e();
        }
    }

    public void d(Integer num) {
        m5 m5Var = this.f4178k;
        if (m5Var == null) {
            this.r.a(this, num);
            return;
        }
        int intValue = num.intValue();
        try {
            c cVar = (c) m5Var.getLayoutParams();
            if (intValue == 1) {
                cVar.f4197d = 16;
            } else if (intValue == 2) {
                cVar.f4197d = 80;
            }
            m5Var.setLayoutParams(cVar);
        } catch (Throwable th2) {
            ka.a(th2, "ZoomControllerView", "setZoomPosition");
            th2.printStackTrace();
        }
    }

    public void c(Integer num) {
        l5 l5Var = this.e;
        if (l5Var == null) {
            this.r.a(this, num);
            return;
        }
        l5Var.d(num.intValue());
        this.e.postInvalidate();
        j();
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void showInfoWindow(BaseOverlayImp baseOverlayImp) {
        if (baseOverlayImp == null) {
            return;
        }
        try {
            w1 w1Var = this.f4187u;
            if ((w1Var == null || !w1Var.b() || baseOverlayImp.getTitle() != null || baseOverlayImp.getSnippet() != null) && baseOverlayImp.isInfoWindowEnable()) {
                BasePointOverlay basePointOverlay = this.f4180m;
                if (basePointOverlay != null && !basePointOverlay.getId().equals(baseOverlayImp.getId())) {
                    hideInfoWindow();
                }
                if (this.f4187u != null) {
                    baseOverlayImp.setInfoWindowShown(true);
                    this.f4184q = true;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public c5 c() {
        return this.f4176i;
    }

    public e5 d() {
        return this.f4177j;
    }

    public void a(String str, Boolean bool, Integer num) {
        if (this.e == null) {
            this.r.a(this, str, bool, num);
            return;
        }
        if (num.intValue() == 2) {
            this.e.b(bool.booleanValue());
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.e.a(str, num.intValue());
            this.e.c(bool.booleanValue());
        }
    }

    public void a(Float f2) {
        m5 m5Var = this.f4178k;
        if (m5Var == null) {
            this.r.a(this, f2);
        } else {
            m5Var.a(f2.floatValue());
        }
    }

    public void a(Integer num) {
        l5 l5Var = this.e;
        if (l5Var == null) {
            this.r.a(this, num);
        } else {
            l5Var.b(num.intValue());
            j();
        }
    }

    public float a(int i3) {
        if (this.e == null) {
            return 0.0f;
        }
        j();
        return this.e.a(i3);
    }

    public void a(Integer num, Float f2) {
        l5 l5Var = this.e;
        if (l5Var == null) {
            this.r.a(this, num, f2);
        } else {
            l5Var.a(num.intValue(), f2.floatValue());
            j();
        }
    }

    public void a(Boolean bool) {
        if (this.e == null) {
            this.r.a(this, bool);
            return;
        }
        if (bool.booleanValue()) {
            this.e.a(true);
            return;
        }
        l5 l5Var = this.e;
        if (l5Var != null) {
            l5Var.a(false);
        }
    }

    public void b(Boolean bool) {
        e5 e5Var = this.f4177j;
        if (e5Var == null) {
            this.r.a(this, bool);
        } else {
            e5Var.a(bool.booleanValue());
        }
    }

    public void a(CameraPosition cameraPosition) {
        if (this.e == null) {
            this.r.a(this, cameraPosition);
            return;
        }
        if (this.f4169a.getUiSettings().isLogoEnable()) {
            if (MapsInitializer.isLoadWorldGridMap() && cameraPosition.zoom >= 6.0f) {
                LatLng latLng = cameraPosition.target;
                if (!r4.b(latLng.latitude, latLng.longitude)) {
                    this.e.setVisibility(8);
                    return;
                }
            }
            if (this.f4169a.getMaskLayerType() == -1) {
                this.e.setVisibility(0);
            }
        }
    }

    public void a(boolean z5) {
        l5 l5Var = this.e;
        if (l5Var != null) {
            l5Var.d(z5);
        }
        this.f4186t = z5;
    }

    private void a(View view, ViewGroup.LayoutParams layoutParams) {
        int[] iArr = new int[2];
        a(view, layoutParams.width, layoutParams.height, iArr);
        if (view instanceof e5) {
            a(view, iArr[0], iArr[1], 20, (this.f4169a.getWaterMarkerPositon().y - 80) - iArr[1], 51);
        } else {
            a(view, iArr[0], iArr[1], 0, 0, 51);
        }
    }

    private void a(View view, c cVar) {
        int[] iArr = new int[2];
        a(view, ((ViewGroup.LayoutParams) cVar).width, ((ViewGroup.LayoutParams) cVar).height, iArr);
        if (view instanceof m5) {
            a(view, iArr[0], iArr[1], getWidth() - iArr[0], getHeight(), cVar.f4197d);
            return;
        }
        if (view instanceof f5) {
            a(view, iArr[0], iArr[1], getWidth() - iArr[0], iArr[1], cVar.f4197d);
            return;
        }
        if (view instanceof d5) {
            a(view, iArr[0], iArr[1], 0, 0, cVar.f4197d);
            return;
        }
        if (cVar.f4194a != null) {
            IPoint obtain = IPoint.obtain();
            MapConfig mapConfig = this.f4169a.getMapConfig();
            GLMapState mapProjection = this.f4169a.getMapProjection();
            if (mapConfig != null && mapProjection != null) {
                FPoint fPoint = cVar.f4194a;
                ((Point) obtain).x = (int) ((PointF) fPoint).x;
                ((Point) obtain).y = (int) ((PointF) fPoint).y;
            }
            int i3 = ((Point) obtain).x + cVar.f4195b;
            ((Point) obtain).x = i3;
            int i10 = ((Point) obtain).y + cVar.f4196c;
            ((Point) obtain).y = i10;
            a(view, iArr[0], iArr[1], i3, i10, cVar.f4197d);
            obtain.recycle();
        }
    }

    private View a(BasePointOverlay basePointOverlay) throws RemoteException {
        View view;
        View view2;
        View view3 = null;
        if (basePointOverlay instanceof Marker) {
            try {
                if (this.f4181n == null) {
                    this.f4181n = o4.a(this.f4172d, "infowindow_bg.9.png");
                }
            } catch (Throwable th2) {
                ka.a(th2, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th2.printStackTrace();
            }
            try {
                if (this.f4184q) {
                    view = this.f4187u.b(basePointOverlay);
                    if (view == null) {
                        try {
                            view = this.f4187u.a(basePointOverlay);
                        } catch (Throwable th3) {
                            th = th3;
                            view3 = view;
                            ka.a(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            return view3;
                        }
                    }
                    this.f4183p = view;
                    this.f4184q = false;
                } else {
                    view = this.f4183p;
                }
                if (view != null) {
                    view3 = view;
                } else {
                    if (!this.f4187u.b()) {
                        return null;
                    }
                    view3 = this.f4187u.b(basePointOverlay);
                }
                if (view3 != null && view3.getBackground() == null) {
                    view3.setBackground(this.f4181n);
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } else {
            try {
                if (this.f4181n == null) {
                    this.f4181n = o4.a(this.f4172d, "infowindow_bg.9.png");
                }
            } catch (Throwable th5) {
                ka.a(th5, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th5.printStackTrace();
            }
            try {
                if (this.f4184q) {
                    view2 = this.f4187u.b(basePointOverlay);
                    if (view2 == null) {
                        try {
                            view2 = this.f4187u.a(basePointOverlay);
                        } catch (Throwable th6) {
                            th = th6;
                            view3 = view2;
                            ka.a(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            return view3;
                        }
                    }
                    this.f4183p = view2;
                    this.f4184q = false;
                } else {
                    view2 = this.f4183p;
                }
                if (view2 != null) {
                    view3 = view2;
                } else {
                    if (!this.f4187u.b()) {
                        return null;
                    }
                    view3 = this.f4187u.b(basePointOverlay);
                }
                if (view3.getBackground() == null) {
                    view3.setBackground(this.f4181n);
                }
                return view3;
            } catch (Throwable th7) {
                th = th7;
            }
        }
        return view3;
    }

    private void a(View view, int i3, int i10, int i11, int i12) throws RemoteException {
        int i13;
        int i14;
        View view2 = this.f4179l;
        if (view2 != null) {
            if (view == view2) {
                return;
            }
            view2.clearFocus();
            removeView(this.f4179l);
        }
        this.f4179l = view;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        this.f4179l.setDrawingCacheEnabled(true);
        this.f4179l.setDrawingCacheQuality(0);
        if (layoutParams != null) {
            int i15 = layoutParams.width;
            i14 = layoutParams.height;
            i13 = i15;
        } else {
            i13 = -2;
            i14 = -2;
        }
        addView(this.f4179l, new c(i13, i14, i3, i10, i11, i12, 81));
    }

    private void a(View view, int i3, int i10, int[] iArr) {
        View view2;
        if ((view instanceof ListView) && (view2 = (View) view.getParent()) != null) {
            iArr[0] = view2.getWidth();
            iArr[1] = view2.getHeight();
        }
        if (i3 <= 0 || i10 <= 0) {
            view.measure(0, 0);
        }
        if (i3 == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i3 == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i3;
        }
        if (i10 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i10 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i10;
        }
    }

    private void a(View view, int i3, int i10, int i11, int i12, int i13) {
        int i14;
        int i15 = i13 & 7;
        int i16 = i13 & 112;
        if (i15 == 5) {
            i11 -= i3;
        } else if (i15 == 1) {
            i11 -= i3 / 2;
        }
        if (i16 == 80) {
            i12 -= i10;
        } else {
            if (i16 == 17) {
                i14 = i10 / 2;
            } else if (i16 == 16) {
                i12 /= 2;
                i14 = i10 / 2;
            }
            i12 -= i14;
        }
        view.layout(i11, i12, i11 + i3, i12 + i10);
        if (view instanceof IGLSurfaceView) {
            this.f4169a.changeSize(i3, i10);
        }
    }

    public void a(Canvas canvas) {
        Bitmap drawingCache;
        View view = this.f4179l;
        if (view == null || this.f4180m == null || (drawingCache = view.getDrawingCache(true)) == null) {
            return;
        }
        canvas.drawBitmap(drawingCache, this.f4179l.getLeft(), this.f4179l.getTop(), new Paint());
    }

    public void a(e5.d dVar) {
        e5 e5Var = this.f4177j;
        if (e5Var == null) {
            this.r.a(this, dVar);
        } else {
            e5Var.a(dVar);
        }
    }

    public void a() {
        Context context;
        if (!this.f4185s || (context = this.f4172d) == null) {
            return;
        }
        a(context);
        i5 i5Var = this.r;
        if (i5Var != null) {
            i5Var.a();
        }
    }
}
