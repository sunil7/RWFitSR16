package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.amap.api.col.p0003sl.q1;
import com.amap.api.col.p0003sl.r1;
import com.amap.api.col.p0003sl.t1;
import com.amap.api.col.p0003sl.u1;
import com.amap.api.maps.model.AMapGestureListener;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;

/* loaded from: classes.dex */
public class y0 {

    /* renamed from: a, reason: collision with root package name */
    IAMapDelegate f5413a;

    /* renamed from: b, reason: collision with root package name */
    Context f5414b;

    /* renamed from: c, reason: collision with root package name */
    GestureDetector f5415c;

    /* renamed from: d, reason: collision with root package name */
    private t1 f5416d;
    private r1 e;

    /* renamed from: f, reason: collision with root package name */
    private q1 f5417f;

    /* renamed from: g, reason: collision with root package name */
    private u1 f5418g;

    /* renamed from: q, reason: collision with root package name */
    private int f5428q;
    private int r;

    /* renamed from: s, reason: collision with root package name */
    public AMapGestureListener f5429s;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5419h = false;

    /* renamed from: i, reason: collision with root package name */
    private int f5420i = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f5421j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f5422k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f5423l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f5424m = 0;

    /* renamed from: n, reason: collision with root package name */
    private boolean f5425n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f5426o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f5427p = true;

    /* renamed from: t, reason: collision with root package name */
    private Handler f5430t = new Handler(Looper.getMainLooper());

    public class b implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

        /* renamed from: a, reason: collision with root package name */
        private int f5431a;

        /* renamed from: b, reason: collision with root package name */
        float f5432b;

        /* renamed from: c, reason: collision with root package name */
        private EAMapPlatformGestureInfo f5433c;

        /* renamed from: d, reason: collision with root package name */
        long f5434d;

        private b() {
            this.f5431a = 0;
            this.f5432b = 0.0f;
            this.f5433c = new EAMapPlatformGestureInfo();
            this.f5434d = 0L;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            y0.this.f5415c.setIsLongpressEnabled(false);
            this.f5431a = motionEvent.getPointerCount();
            AMapGestureListener aMapGestureListener = y0.this.f5429s;
            if (aMapGestureListener != null) {
                aMapGestureListener.onDoubleTap(motionEvent.getX(), motionEvent.getY());
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            boolean z5 = false;
            if (this.f5431a < motionEvent.getPointerCount()) {
                this.f5431a = motionEvent.getPointerCount();
            }
            int action = motionEvent.getAction() & 255;
            if (this.f5431a == 1) {
                try {
                    if (!y0.this.f5413a.getUiSettings().isZoomGesturesEnabled()) {
                        y0.this.f5415c.setIsLongpressEnabled(true);
                        return false;
                    }
                } catch (Throwable th2) {
                    ka.a(th2, "GLMapGestrureDetector", "onDoubleTapEvent");
                    th2.printStackTrace();
                }
                if (action == 0) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f5433c;
                    eAMapPlatformGestureInfo.mGestureState = 1;
                    eAMapPlatformGestureInfo.mGestureType = 9;
                    eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                    int engineIDWithGestureInfo = y0.this.f5413a.getEngineIDWithGestureInfo(this.f5433c);
                    this.f5432b = motionEvent.getY();
                    y0.this.f5413a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, 0, 0));
                    this.f5434d = SystemClock.uptimeMillis();
                    return true;
                }
                if (action != 2) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo2 = this.f5433c;
                    eAMapPlatformGestureInfo2.mGestureState = 3;
                    eAMapPlatformGestureInfo2.mGestureType = 9;
                    eAMapPlatformGestureInfo2.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                    int engineIDWithGestureInfo2 = y0.this.f5413a.getEngineIDWithGestureInfo(this.f5433c);
                    y0.this.f5415c.setIsLongpressEnabled(true);
                    y0.this.f5413a.addGestureMapMessage(engineIDWithGestureInfo2, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
                    if (action != 1) {
                        y0.this.f5425n = false;
                        return true;
                    }
                    y0.this.f5413a.setGestureStatus(engineIDWithGestureInfo2, 3);
                    long uptimeMillis = SystemClock.uptimeMillis() - this.f5434d;
                    if (!y0.this.f5425n || uptimeMillis < 200) {
                        return y0.this.f5413a.onDoubleTap(engineIDWithGestureInfo2, motionEvent);
                    }
                    y0.this.f5425n = false;
                    return true;
                }
                y0.this.f5425n = true;
                float y4 = this.f5432b - motionEvent.getY();
                if (Math.abs(y4) >= 20) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo3 = this.f5433c;
                    eAMapPlatformGestureInfo3.mGestureState = 2;
                    eAMapPlatformGestureInfo3.mGestureType = 9;
                    eAMapPlatformGestureInfo3.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                    int engineIDWithGestureInfo3 = y0.this.f5413a.getEngineIDWithGestureInfo(this.f5433c);
                    float mapHeight = (4.0f * y4) / y0.this.f5413a.getMapHeight();
                    if (y4 > 0.0f) {
                        y0.this.f5413a.addGestureMapMessage(engineIDWithGestureInfo3, ScaleGestureMapMessage.obtain(101, mapHeight, 0, 0));
                    } else {
                        y0.this.f5413a.addGestureMapMessage(engineIDWithGestureInfo3, ScaleGestureMapMessage.obtain(101, mapHeight, 0, 0));
                    }
                    this.f5432b = motionEvent.getY();
                }
                z5 = true;
            }
            return z5;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            y0.this.f5425n = false;
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f10) {
            AMapGestureListener aMapGestureListener = y0.this.f5429s;
            if (aMapGestureListener != null) {
                aMapGestureListener.onFling(f2, f10);
            }
            try {
                if (y0.this.f5413a.getUiSettings().isScrollGesturesEnabled() && y0.this.f5423l <= 0 && y0.this.f5421j <= 0 && y0.this.f5422k == 0 && !y0.this.f5427p) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f5433c;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent2.getX(), motionEvent2.getY()};
                    int engineIDWithGestureInfo = y0.this.f5413a.getEngineIDWithGestureInfo(this.f5433c);
                    y0.this.f5413a.onFling();
                    y0.this.f5413a.getGLMapEngine().startMapSlidAnim(engineIDWithGestureInfo, new Point((int) motionEvent2.getX(), (int) motionEvent2.getY()), f2, f10);
                }
                return true;
            } catch (Throwable th2) {
                ka.a(th2, "GLMapGestrureDetector", "onFling");
                th2.printStackTrace();
                return true;
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (y0.this.f5424m == 1) {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f5433c;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                y0.this.f5413a.onLongPress(y0.this.f5413a.getEngineIDWithGestureInfo(this.f5433c), motionEvent);
                AMapGestureListener aMapGestureListener = y0.this.f5429s;
                if (aMapGestureListener != null) {
                    aMapGestureListener.onLongPress(motionEvent.getX(), motionEvent.getY());
                }
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f10) {
            AMapGestureListener aMapGestureListener = y0.this.f5429s;
            if (aMapGestureListener == null) {
                return false;
            }
            aMapGestureListener.onScroll(f2, f10);
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            try {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f5433c;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                y0.this.f5413a.getGLMapEngine().clearAnimations(y0.this.f5413a.getEngineIDWithGestureInfo(this.f5433c), false);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (y0.this.f5424m != 1) {
                return false;
            }
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f5433c;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 8;
            eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
            int engineIDWithGestureInfo = y0.this.f5413a.getEngineIDWithGestureInfo(this.f5433c);
            AMapGestureListener aMapGestureListener = y0.this.f5429s;
            if (aMapGestureListener != null) {
                try {
                    aMapGestureListener.onSingleTap(motionEvent.getX(), motionEvent.getY());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            return y0.this.f5413a.onSingleTapConfirmed(engineIDWithGestureInfo, motionEvent);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    public class c implements q1.a {

        /* renamed from: a, reason: collision with root package name */
        private EAMapPlatformGestureInfo f5435a;

        private c() {
            this.f5435a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.3sl.q1.a
        public boolean a(q1 q1Var) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f5435a;
            eAMapPlatformGestureInfo.mGestureState = 2;
            eAMapPlatformGestureInfo.mGestureType = 6;
            boolean z5 = false;
            eAMapPlatformGestureInfo.mLocation = new float[]{q1Var.a().getX(), q1Var.a().getY()};
            try {
                if (!y0.this.f5413a.getUiSettings().isTiltGesturesEnabled()) {
                    return true;
                }
                int engineIDWithGestureInfo = y0.this.f5413a.getEngineIDWithGestureInfo(this.f5435a);
                if (y0.this.f5413a.isLockMapCameraDegree(engineIDWithGestureInfo) || y0.this.f5422k > 3) {
                    return false;
                }
                float f2 = q1Var.d().x;
                float f10 = q1Var.d().y;
                if (!y0.this.f5419h) {
                    PointF a3 = q1Var.a(0);
                    PointF a10 = q1Var.a(1);
                    float f11 = a3.y;
                    if ((f11 > 10.0f && a10.y > 10.0f) || (f11 < -10.0f && a10.y < -10.0f)) {
                        z5 = true;
                    }
                    if (z5) {
                        float f12 = 10;
                        if (Math.abs(f10) > f12 && Math.abs(f2) < f12) {
                            y0.this.f5419h = true;
                        }
                    }
                }
                if (y0.this.f5419h) {
                    y0.this.f5419h = true;
                    float f13 = f10 / 6.0f;
                    if (Math.abs(f13) > 1.0f) {
                        y0.this.f5413a.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(101, f13));
                        y0.h(y0.this);
                    }
                }
                return true;
            } catch (Throwable th2) {
                ka.a(th2, "GLMapGestrureDetector", "onHove");
                th2.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.3sl.q1.a
        public void b(q1 q1Var) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f5435a;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{q1Var.a().getX(), q1Var.a().getY()};
            try {
                if (y0.this.f5413a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = y0.this.f5413a.getEngineIDWithGestureInfo(this.f5435a);
                    if (y0.this.f5413a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                        return;
                    }
                    if (y0.this.f5413a.getCameraDegree(engineIDWithGestureInfo) >= 0.0f && y0.this.f5423l > 0) {
                        y0.this.f5413a.setGestureStatus(engineIDWithGestureInfo, 7);
                    }
                    y0.this.f5419h = false;
                    IAMapDelegate iAMapDelegate = y0.this.f5413a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(102, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                }
            } catch (Throwable th2) {
                ka.a(th2, "GLMapGestrureDetector", "onHoveEnd");
                th2.printStackTrace();
            }
        }

        @Override // com.amap.api.col.3sl.q1.a
        public boolean c(q1 q1Var) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f5435a;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{q1Var.a().getX(), q1Var.a().getY()};
            try {
                if (!y0.this.f5413a.getUiSettings().isTiltGesturesEnabled()) {
                    return true;
                }
                int engineIDWithGestureInfo = y0.this.f5413a.getEngineIDWithGestureInfo(this.f5435a);
                if (y0.this.f5413a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                    return false;
                }
                IAMapDelegate iAMapDelegate = y0.this.f5413a;
                iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(100, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                return true;
            } catch (Throwable th2) {
                ka.a(th2, "GLMapGestrureDetector", "onHoveBegin");
                th2.printStackTrace();
                return true;
            }
        }
    }

    public class d implements r1.a {

        /* renamed from: a, reason: collision with root package name */
        private EAMapPlatformGestureInfo f5437a;

        private d() {
            this.f5437a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.3sl.r1.a
        public boolean a(r1 r1Var) {
            try {
                if (!y0.this.f5413a.getUiSettings().isScrollGesturesEnabled()) {
                    return true;
                }
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f5437a;
                eAMapPlatformGestureInfo.mGestureState = 1;
                eAMapPlatformGestureInfo.mGestureType = 3;
                eAMapPlatformGestureInfo.mLocation = new float[]{r1Var.a().getX(), r1Var.a().getY()};
                y0.this.f5413a.addGestureMapMessage(y0.this.f5413a.getEngineIDWithGestureInfo(this.f5437a), MoveGestureMapMessage.obtain(100, 0.0f, 0.0f, r1Var.a().getX(), r1Var.a().getY()));
                return true;
            } catch (Throwable th2) {
                ka.a(th2, "GLMapGestrureDetector", "onMoveBegin");
                th2.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.3sl.r1.a
        public boolean b(r1 r1Var) {
            if (y0.this.f5419h) {
                return true;
            }
            try {
                if (y0.this.f5413a.getUiSettings().isScrollGesturesEnabled()) {
                    if (!y0.this.f5426o) {
                        EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f5437a;
                        eAMapPlatformGestureInfo.mGestureState = 2;
                        eAMapPlatformGestureInfo.mGestureType = 3;
                        eAMapPlatformGestureInfo.mLocation = new float[]{r1Var.a().getX(), r1Var.a().getY()};
                        int engineIDWithGestureInfo = y0.this.f5413a.getEngineIDWithGestureInfo(this.f5437a);
                        PointF d5 = r1Var.d();
                        float f2 = y0.this.f5420i == 0 ? 4.0f : 1.0f;
                        if (Math.abs(d5.x) <= f2 && Math.abs(d5.y) <= f2) {
                            return false;
                        }
                        if (y0.this.f5420i == 0) {
                            y0.this.f5413a.getGLMapEngine().clearAnimations(engineIDWithGestureInfo, false);
                        }
                        y0.this.f5413a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(101, d5.x, d5.y, r1Var.a().getX(), r1Var.a().getY()));
                        y0.e(y0.this);
                        return true;
                    }
                }
                return true;
            } catch (Throwable th2) {
                ka.a(th2, "GLMapGestrureDetector", "onMove");
                th2.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.col.3sl.r1.a
        public void c(r1 r1Var) {
            try {
                if (y0.this.f5413a.getUiSettings().isScrollGesturesEnabled()) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f5437a;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{r1Var.a().getX(), r1Var.a().getY()};
                    int engineIDWithGestureInfo = y0.this.f5413a.getEngineIDWithGestureInfo(this.f5437a);
                    if (y0.this.f5420i > 0) {
                        y0.this.f5413a.setGestureStatus(engineIDWithGestureInfo, 5);
                    }
                    y0.this.f5413a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(102, 0.0f, 0.0f, r1Var.a().getX(), r1Var.a().getY()));
                }
            } catch (Throwable th2) {
                ka.a(th2, "GLMapGestrureDetector", "onMoveEnd");
                th2.printStackTrace();
            }
        }
    }

    public class e extends t1.a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f5439a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f5440b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5441c;

        /* renamed from: d, reason: collision with root package name */
        private Point f5442d;
        private float[] e;

        /* renamed from: f, reason: collision with root package name */
        private float f5443f;

        /* renamed from: g, reason: collision with root package name */
        private float[] f5444g;

        /* renamed from: h, reason: collision with root package name */
        private float f5445h;

        /* renamed from: i, reason: collision with root package name */
        private EAMapPlatformGestureInfo f5446i;

        private e() {
            this.f5439a = false;
            this.f5440b = false;
            this.f5441c = false;
            this.f5442d = new Point();
            this.e = new float[10];
            this.f5443f = 0.0f;
            this.f5444g = new float[10];
            this.f5445h = 0.0f;
            this.f5446i = new EAMapPlatformGestureInfo();
        }

        /* JADX WARN: Code restructure failed: missing block: B:85:0x00c5, code lost:
        
            if (java.lang.Math.abs(r0) < 0.02f) goto L28;
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x012b A[Catch: all -> 0x017a, TryCatch #2 {all -> 0x017a, blocks: (B:29:0x011d, B:31:0x012b, B:33:0x0135, B:35:0x0139, B:37:0x016e, B:39:0x0176, B:40:0x017e, B:42:0x0182, B:48:0x019d, B:60:0x0194), top: B:28:0x011d }] */
        @Override // com.amap.api.col.3sl.t1.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean a(com.amap.api.col.p0003sl.t1 r21) {
            /*
                Method dump skipped, instructions count: 473
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.3sl.y0.e.a(com.amap.api.col.3sl.t1):boolean");
        }

        @Override // com.amap.api.col.3sl.t1.a
        public boolean b(t1 t1Var) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f5446i;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 4;
            eAMapPlatformGestureInfo.mLocation = new float[]{t1Var.c().getX(), t1Var.c().getY()};
            int engineIDWithGestureInfo = y0.this.f5413a.getEngineIDWithGestureInfo(this.f5446i);
            int d5 = (int) t1Var.d();
            int e = (int) t1Var.e();
            this.f5441c = false;
            Point point = this.f5442d;
            point.x = d5;
            point.y = e;
            this.f5439a = false;
            this.f5440b = false;
            y0.this.f5413a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, d5, e));
            try {
                if (y0.this.f5413a.getUiSettings().isRotateGesturesEnabled() && !y0.this.f5413a.isLockMapAngle(engineIDWithGestureInfo)) {
                    IAMapDelegate iAMapDelegate = y0.this.f5413a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(100, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), d5, e));
                }
            } catch (Throwable th2) {
                ka.a(th2, "GLMapGestrureDetector", "onScaleRotateBegin");
                th2.printStackTrace();
            }
            return true;
        }

        @Override // com.amap.api.col.3sl.t1.a
        public void c(t1 t1Var) {
            float f2;
            float f10;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f5446i;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 4;
            eAMapPlatformGestureInfo.mLocation = new float[]{t1Var.c().getX(), t1Var.c().getY()};
            int engineIDWithGestureInfo = y0.this.f5413a.getEngineIDWithGestureInfo(this.f5446i);
            this.f5441c = false;
            y0.this.f5413a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
            if (y0.this.f5421j > 0) {
                int i3 = y0.this.f5421j > 10 ? 10 : y0.this.f5421j;
                float f11 = 0.0f;
                for (int i10 = 0; i10 < 10; i10++) {
                    float[] fArr = this.e;
                    f11 += fArr[i10];
                    fArr[i10] = 0.0f;
                }
                float f12 = f11 / i3;
                if (0.004f <= f12) {
                    float f13 = f12 * 300.0f;
                    if (f13 >= 1.5f) {
                        f13 = 1.5f;
                    }
                    if (this.f5443f < 0.0f) {
                        f13 = -f13;
                    }
                    f2 = y0.this.f5413a.getPreciseLevel(engineIDWithGestureInfo) + f13;
                } else {
                    f2 = -9999.0f;
                }
                this.f5443f = 0.0f;
            } else {
                f2 = -9999.0f;
            }
            if (y0.this.f5413a.isLockMapAngle(engineIDWithGestureInfo)) {
                f10 = -9999.0f;
            } else {
                try {
                    if (y0.this.f5413a.getUiSettings().isRotateGesturesEnabled()) {
                        IAMapDelegate iAMapDelegate = y0.this.f5413a;
                        iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(102, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), 0, 0));
                    }
                } catch (Throwable th2) {
                    ka.a(th2, "GLMapGestrureDetector", "onScaleRotateEnd");
                    th2.printStackTrace();
                }
                if (y0.this.f5422k > 0) {
                    y0.this.f5413a.setGestureStatus(engineIDWithGestureInfo, 6);
                    int i11 = y0.this.f5422k > 10 ? 10 : y0.this.f5422k;
                    float f14 = 0.0f;
                    for (int i12 = 0; i12 < 10; i12++) {
                        float[] fArr2 = this.f5444g;
                        f14 += fArr2[i12];
                        fArr2[i12] = 0.0f;
                    }
                    float f15 = f14 / i11;
                    if (0.1f <= f15) {
                        float f16 = f15 * 200.0f;
                        int mapAngle = ((int) y0.this.f5413a.getMapAngle(engineIDWithGestureInfo)) % 360;
                        if (f16 >= 60.0f) {
                            f16 = 60.0f;
                        }
                        if (this.f5445h < 0.0f) {
                            f16 = -f16;
                        }
                        f10 = ((int) (mapAngle + f16)) % 360;
                        this.f5443f = 0.0f;
                    }
                }
                f10 = -9999.0f;
                this.f5443f = 0.0f;
            }
            if (f2 == -9999.0f && f10 == -9999.0f) {
                return;
            }
            y0.this.f5413a.getGLMapEngine().startPivotZoomRotateAnim(engineIDWithGestureInfo, this.f5442d, f2, (int) f10, 500);
        }
    }

    public class f extends u1.b {

        /* renamed from: a, reason: collision with root package name */
        EAMapPlatformGestureInfo f5448a;

        private f() {
            this.f5448a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.col.3sl.u1.a
        public void a(u1 u1Var) {
            try {
                if (y0.this.f5413a.getUiSettings().isZoomGesturesEnabled()) {
                    float f2 = 10;
                    if (Math.abs(u1Var.d()) > f2 || Math.abs(u1Var.e()) > f2 || u1Var.b() >= 200) {
                        return;
                    }
                    y0.this.f5427p = true;
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f5448a;
                    eAMapPlatformGestureInfo.mGestureState = 2;
                    eAMapPlatformGestureInfo.mGestureType = 2;
                    eAMapPlatformGestureInfo.mLocation = new float[]{u1Var.a().getX(), u1Var.a().getY()};
                    int engineIDWithGestureInfo = y0.this.f5413a.getEngineIDWithGestureInfo(this.f5448a);
                    y0.this.f5413a.setGestureStatus(engineIDWithGestureInfo, 4);
                    y0.this.f5413a.zoomOut(engineIDWithGestureInfo);
                }
            } catch (Throwable th2) {
                ka.a(th2, "GLMapGestrureDetector", "onZoomOut");
                th2.printStackTrace();
            }
        }
    }

    public y0(IAMapDelegate iAMapDelegate) {
        this.f5414b = ((b0) iAMapDelegate).getContext();
        this.f5413a = iAMapDelegate;
        b bVar = new b();
        GestureDetector gestureDetector = new GestureDetector(this.f5414b, bVar, this.f5430t);
        this.f5415c = gestureDetector;
        gestureDetector.setOnDoubleTapListener(bVar);
        this.f5416d = new t1(this.f5414b, new e());
        this.e = new r1(this.f5414b, new d());
        this.f5417f = new q1(this.f5414b, new c());
        this.f5418g = new u1(this.f5414b, new f());
    }

    public static /* synthetic */ int e(y0 y0Var) {
        int i3 = y0Var.f5420i;
        y0Var.f5420i = i3 + 1;
        return i3;
    }

    public static /* synthetic */ int h(y0 y0Var) {
        int i3 = y0Var.f5423l;
        y0Var.f5423l = i3 + 1;
        return i3;
    }

    public static /* synthetic */ int j(y0 y0Var) {
        int i3 = y0Var.f5421j;
        y0Var.f5421j = i3 + 1;
        return i3;
    }

    public static /* synthetic */ int l(y0 y0Var) {
        int i3 = y0Var.f5422k;
        y0Var.f5422k = i3 + 1;
        return i3;
    }

    public void a(int i3, int i10) {
        this.f5428q = i3;
        this.r = i10;
        t1 t1Var = this.f5416d;
        if (t1Var != null) {
            t1Var.a(i3, i10);
        }
        r1 r1Var = this.e;
        if (r1Var != null) {
            r1Var.a(i3, i10);
        }
        q1 q1Var = this.f5417f;
        if (q1Var != null) {
            q1Var.a(i3, i10);
        }
        u1 u1Var = this.f5418g;
        if (u1Var != null) {
            u1Var.a(i3, i10);
        }
    }

    public int b() {
        return this.f5428q;
    }

    public void c() {
        this.f5420i = 0;
        this.f5422k = 0;
        this.f5421j = 0;
        this.f5423l = 0;
        this.f5424m = 0;
    }

    public int a() {
        return this.r;
    }

    public boolean a(MotionEvent motionEvent) {
        if (this.f5424m < motionEvent.getPointerCount()) {
            this.f5424m = motionEvent.getPointerCount();
        }
        if ((motionEvent.getAction() & 255) == 0) {
            this.f5426o = false;
            this.f5427p = false;
        }
        if (motionEvent.getAction() == 6 && motionEvent.getPointerCount() > 0) {
            this.f5426o = true;
        }
        if (this.f5425n && this.f5424m >= 2) {
            this.f5425n = false;
        }
        try {
            int[] iArr = {0, 0};
            IAMapDelegate iAMapDelegate = this.f5413a;
            if (iAMapDelegate != null && iAMapDelegate.getGLMapView() != null) {
                this.f5413a.getGLMapView().getLocationOnScreen(iArr);
            }
            if (this.f5429s != null) {
                if (motionEvent.getAction() == 0) {
                    this.f5429s.onDown(motionEvent.getX(), motionEvent.getY());
                } else if (motionEvent.getAction() == 1) {
                    this.f5429s.onUp(motionEvent.getX(), motionEvent.getY());
                }
            }
            this.f5415c.onTouchEvent(motionEvent);
            this.f5417f.a(motionEvent, iArr[0], iArr[1]);
            if (!this.f5419h || this.f5423l <= 0) {
                this.f5418g.a(motionEvent, iArr[0], iArr[1]);
                if (!this.f5425n) {
                    this.f5416d.a(motionEvent);
                    this.e.a(motionEvent, iArr[0], iArr[1]);
                }
            }
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }
}
