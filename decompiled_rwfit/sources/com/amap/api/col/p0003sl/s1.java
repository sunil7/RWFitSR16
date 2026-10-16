package com.amap.api.col.p0003sl;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.amap.api.col.p0003sl.t1;

/* loaded from: classes.dex */
public class s1 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4971a;

    /* renamed from: b, reason: collision with root package name */
    private final a f4972b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4973c;

    /* renamed from: d, reason: collision with root package name */
    private MotionEvent f4974d;
    private MotionEvent e;

    /* renamed from: f, reason: collision with root package name */
    private float f4975f;

    /* renamed from: g, reason: collision with root package name */
    private float f4976g;

    /* renamed from: h, reason: collision with root package name */
    private float f4977h;

    /* renamed from: i, reason: collision with root package name */
    private float f4978i;

    /* renamed from: j, reason: collision with root package name */
    private float f4979j;

    /* renamed from: k, reason: collision with root package name */
    private float f4980k;

    /* renamed from: l, reason: collision with root package name */
    private float f4981l;

    /* renamed from: m, reason: collision with root package name */
    private float f4982m;

    /* renamed from: n, reason: collision with root package name */
    private float f4983n;

    /* renamed from: o, reason: collision with root package name */
    private float f4984o;

    /* renamed from: p, reason: collision with root package name */
    private float f4985p;

    /* renamed from: q, reason: collision with root package name */
    private long f4986q;
    private final float r;

    /* renamed from: s, reason: collision with root package name */
    private float f4987s;

    /* renamed from: t, reason: collision with root package name */
    private float f4988t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f4989u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f4990v;

    /* renamed from: w, reason: collision with root package name */
    private int f4991w;

    /* renamed from: x, reason: collision with root package name */
    private int f4992x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f4993y;

    /* renamed from: z, reason: collision with root package name */
    private int f4994z = 0;
    private int A = 0;

    public interface a {
    }

    public s1(Context context, a aVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f4971a = context;
        this.f4972b = aVar;
        this.r = viewConfiguration.getScaledEdgeSlop();
    }

    private static float b(MotionEvent motionEvent, int i3) {
        if (i3 < 0) {
            return Float.MIN_VALUE;
        }
        if (i3 == 0) {
            return motionEvent.getRawY();
        }
        return motionEvent.getY(i3) + (motionEvent.getRawY() - motionEvent.getY());
    }

    private void j() {
        MotionEvent motionEvent = this.f4974d;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f4974d = null;
        }
        MotionEvent motionEvent2 = this.e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.e = null;
        }
        this.f4989u = false;
        this.f4973c = false;
        this.f4991w = -1;
        this.f4992x = -1;
        this.f4990v = false;
    }

    public void a(int i3, int i10) {
        this.f4994z = i3;
        this.A = i10;
    }

    public MotionEvent c() {
        return this.e;
    }

    public float d() {
        return this.f4975f;
    }

    public float e() {
        return this.f4976g;
    }

    public float f() {
        return this.f4977h;
    }

    public float g() {
        return this.f4978i;
    }

    public float h() {
        if (this.f4983n == -1.0f) {
            if (this.f4981l == -1.0f) {
                float f2 = this.f4979j;
                float f10 = this.f4980k;
                this.f4981l = (float) Math.sqrt((f10 * f10) + (f2 * f2));
            }
            float f11 = this.f4981l;
            if (this.f4982m == -1.0f) {
                float f12 = this.f4977h;
                float f13 = this.f4978i;
                this.f4982m = (float) Math.sqrt((f13 * f13) + (f12 * f12));
            }
            this.f4983n = f11 / this.f4982m;
        }
        return this.f4983n;
    }

    public long i() {
        return this.f4986q;
    }

    public boolean a(MotionEvent motionEvent) {
        int a3;
        int a10;
        int i3;
        int a11;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            j();
        }
        boolean z5 = false;
        if (this.f4990v) {
            return false;
        }
        if (this.f4973c) {
            if (action == 1) {
                j();
                return true;
            }
            if (action == 2) {
                b(motionEvent);
                if (this.f4984o / this.f4985p > 0.67f) {
                    t1.a aVar = (t1.a) this.f4972b;
                    aVar.getClass();
                    if (aVar.a((t1) this)) {
                        this.f4974d.recycle();
                        this.f4974d = MotionEvent.obtain(motionEvent);
                    }
                }
            } else {
                if (action == 3) {
                    t1.a aVar2 = (t1.a) this.f4972b;
                    aVar2.getClass();
                    aVar2.c((t1) this);
                    j();
                    return true;
                }
                if (action == 5) {
                    t1.a aVar3 = (t1.a) this.f4972b;
                    aVar3.getClass();
                    aVar3.c((t1) this);
                    int i10 = this.f4991w;
                    int i11 = this.f4992x;
                    j();
                    this.f4974d = MotionEvent.obtain(motionEvent);
                    if (!this.f4993y) {
                        i10 = i11;
                    }
                    this.f4991w = i10;
                    this.f4992x = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f4993y = false;
                    int findPointerIndex = motionEvent.findPointerIndex(this.f4991w);
                    if (findPointerIndex < 0 || this.f4991w == this.f4992x) {
                        int i12 = this.f4991w;
                        int i13 = this.f4992x;
                        this.f4991w = motionEvent.getPointerId(a(motionEvent, i12 != i13 ? i13 : -1, findPointerIndex));
                    }
                    b(motionEvent);
                    ((t1.a) this.f4972b).a(this);
                    this.f4973c = true;
                    return true;
                }
                if (action == 6) {
                    int pointerCount = motionEvent.getPointerCount();
                    int actionIndex = motionEvent.getActionIndex();
                    int pointerId = motionEvent.getPointerId(actionIndex);
                    if (pointerCount > 2) {
                        int i14 = this.f4991w;
                        if (pointerId == i14) {
                            int a12 = a(motionEvent, this.f4992x, actionIndex);
                            if (a12 >= 0) {
                                t1.a aVar4 = (t1.a) this.f4972b;
                                aVar4.getClass();
                                aVar4.c((t1) this);
                                this.f4991w = motionEvent.getPointerId(a12);
                                this.f4993y = true;
                                this.f4974d = MotionEvent.obtain(motionEvent);
                                b(motionEvent);
                                ((t1.a) this.f4972b).a(this);
                                this.f4973c = true;
                                this.f4974d.recycle();
                                this.f4974d = MotionEvent.obtain(motionEvent);
                                b(motionEvent);
                            }
                            z5 = true;
                            this.f4974d.recycle();
                            this.f4974d = MotionEvent.obtain(motionEvent);
                            b(motionEvent);
                        } else {
                            if (pointerId == this.f4992x) {
                                int a13 = a(motionEvent, i14, actionIndex);
                                if (a13 >= 0) {
                                    t1.a aVar5 = (t1.a) this.f4972b;
                                    aVar5.getClass();
                                    aVar5.c((t1) this);
                                    this.f4992x = motionEvent.getPointerId(a13);
                                    this.f4993y = false;
                                    this.f4974d = MotionEvent.obtain(motionEvent);
                                    b(motionEvent);
                                    ((t1.a) this.f4972b).a(this);
                                    this.f4973c = true;
                                }
                                z5 = true;
                            }
                            this.f4974d.recycle();
                            this.f4974d = MotionEvent.obtain(motionEvent);
                            b(motionEvent);
                        }
                    } else {
                        z5 = true;
                    }
                    if (z5) {
                        b(motionEvent);
                        int i15 = this.f4991w;
                        if (pointerId == i15) {
                            i15 = this.f4992x;
                        }
                        int findPointerIndex2 = motionEvent.findPointerIndex(i15);
                        this.f4975f = motionEvent.getX(findPointerIndex2);
                        this.f4976g = motionEvent.getY(findPointerIndex2);
                        t1.a aVar6 = (t1.a) this.f4972b;
                        aVar6.getClass();
                        aVar6.c((t1) this);
                        j();
                        this.f4991w = i15;
                        this.f4993y = true;
                        return true;
                    }
                }
            }
        } else {
            if (action == 0) {
                this.f4991w = motionEvent.getPointerId(0);
                this.f4993y = true;
                return true;
            }
            if (action == 1) {
                j();
                return true;
            }
            if (action != 2) {
                if (action != 5) {
                    if (action == 6 && this.f4989u) {
                        int pointerCount2 = motionEvent.getPointerCount();
                        int actionIndex2 = motionEvent.getActionIndex();
                        int pointerId2 = motionEvent.getPointerId(actionIndex2);
                        if (pointerCount2 > 2) {
                            int i16 = this.f4991w;
                            if (pointerId2 == i16) {
                                int a14 = a(motionEvent, this.f4992x, actionIndex2);
                                if (a14 >= 0) {
                                    this.f4991w = motionEvent.getPointerId(a14);
                                    return true;
                                }
                            } else if (pointerId2 == this.f4992x && (a11 = a(motionEvent, i16, actionIndex2)) >= 0) {
                                this.f4992x = motionEvent.getPointerId(a11);
                                return true;
                            }
                        } else {
                            int i17 = this.f4991w;
                            if (pointerId2 == i17) {
                                i17 = this.f4992x;
                            }
                            int findPointerIndex3 = motionEvent.findPointerIndex(i17);
                            if (findPointerIndex3 < 0) {
                                this.f4990v = true;
                                if (this.f4973c) {
                                    t1.a aVar7 = (t1.a) this.f4972b;
                                    aVar7.getClass();
                                    aVar7.c((t1) this);
                                }
                                return false;
                            }
                            this.f4991w = motionEvent.getPointerId(findPointerIndex3);
                            this.f4993y = true;
                            this.f4992x = -1;
                            this.f4975f = motionEvent.getX(findPointerIndex3);
                            this.f4976g = motionEvent.getY(findPointerIndex3);
                            return true;
                        }
                    }
                } else {
                    int i18 = this.f4994z;
                    if (i18 != 0 && (i3 = this.A) != 0) {
                        float f2 = this.r;
                        this.f4987s = i18 - f2;
                        this.f4988t = i3 - f2;
                    } else {
                        float f10 = this.f4971a.getResources().getDisplayMetrics().widthPixels;
                        float f11 = this.r;
                        this.f4987s = f10 - f11;
                        this.f4988t = r0.heightPixels - f11;
                    }
                    MotionEvent motionEvent2 = this.f4974d;
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    this.f4974d = MotionEvent.obtain(motionEvent);
                    this.f4986q = 0L;
                    int actionIndex3 = motionEvent.getActionIndex();
                    int findPointerIndex4 = motionEvent.findPointerIndex(this.f4991w);
                    int pointerId3 = motionEvent.getPointerId(actionIndex3);
                    this.f4992x = pointerId3;
                    if (findPointerIndex4 < 0 || findPointerIndex4 == actionIndex3) {
                        findPointerIndex4 = a(motionEvent, findPointerIndex4 != actionIndex3 ? pointerId3 : -1, findPointerIndex4);
                        this.f4991w = motionEvent.getPointerId(findPointerIndex4);
                    }
                    this.f4993y = false;
                    b(motionEvent);
                    float f12 = this.r;
                    float f13 = this.f4987s;
                    float f14 = this.f4988t;
                    float a15 = a(motionEvent, findPointerIndex4);
                    float b3 = b(motionEvent, findPointerIndex4);
                    float a16 = a(motionEvent, actionIndex3);
                    float b10 = b(motionEvent, actionIndex3);
                    boolean z6 = a15 < f12 || b3 < f12 || a15 > f13 || b3 > f14;
                    boolean z8 = a16 < f12 || b10 < f12 || a16 > f13 || b10 > f14;
                    if (z6 && z8) {
                        this.f4975f = -1.0f;
                        this.f4976g = -1.0f;
                        this.f4989u = true;
                        return true;
                    }
                    if (z6) {
                        this.f4975f = motionEvent.getX(actionIndex3);
                        this.f4976g = motionEvent.getY(actionIndex3);
                        this.f4989u = true;
                        return true;
                    }
                    if (z8) {
                        this.f4975f = motionEvent.getX(findPointerIndex4);
                        this.f4976g = motionEvent.getY(findPointerIndex4);
                        this.f4989u = true;
                        return true;
                    }
                    this.f4989u = false;
                    ((t1.a) this.f4972b).a(this);
                    this.f4973c = true;
                    return true;
                }
            } else if (this.f4989u) {
                float f15 = this.r;
                float f16 = this.f4987s;
                float f17 = this.f4988t;
                int findPointerIndex5 = motionEvent.findPointerIndex(this.f4991w);
                int findPointerIndex6 = motionEvent.findPointerIndex(this.f4992x);
                float a17 = a(motionEvent, findPointerIndex5);
                float b11 = b(motionEvent, findPointerIndex5);
                float a18 = a(motionEvent, findPointerIndex6);
                float b12 = b(motionEvent, findPointerIndex6);
                boolean z10 = a17 < f15 || b11 < f15 || a17 > f16 || b11 > f17;
                boolean z11 = a18 < f15 || b12 < f15 || a18 > f16 || b12 > f17;
                if (z10 && (a10 = a(motionEvent, this.f4992x, findPointerIndex5)) >= 0) {
                    this.f4991w = motionEvent.getPointerId(a10);
                    a(motionEvent, a10);
                    b(motionEvent, a10);
                    z10 = false;
                    findPointerIndex5 = a10;
                }
                if (z11 && (a3 = a(motionEvent, this.f4991w, findPointerIndex6)) >= 0) {
                    this.f4992x = motionEvent.getPointerId(a3);
                    a(motionEvent, a3);
                    b(motionEvent, a3);
                    z11 = false;
                    findPointerIndex6 = a3;
                }
                if (z10 && z11) {
                    this.f4975f = -1.0f;
                    this.f4976g = -1.0f;
                    return true;
                }
                if (z10) {
                    this.f4975f = motionEvent.getX(findPointerIndex6);
                    this.f4976g = motionEvent.getY(findPointerIndex6);
                    return true;
                }
                if (z11) {
                    this.f4975f = motionEvent.getX(findPointerIndex5);
                    this.f4976g = motionEvent.getY(findPointerIndex5);
                    return true;
                }
                this.f4989u = false;
                ((t1.a) this.f4972b).a(this);
                this.f4973c = true;
                return true;
            }
        }
        return true;
    }

    private void b(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.e = MotionEvent.obtain(motionEvent);
        this.f4981l = -1.0f;
        this.f4982m = -1.0f;
        this.f4983n = -1.0f;
        MotionEvent motionEvent3 = this.f4974d;
        int findPointerIndex = motionEvent3.findPointerIndex(this.f4991w);
        int findPointerIndex2 = motionEvent3.findPointerIndex(this.f4992x);
        int findPointerIndex3 = motionEvent.findPointerIndex(this.f4991w);
        int findPointerIndex4 = motionEvent.findPointerIndex(this.f4992x);
        if (findPointerIndex >= 0 && findPointerIndex2 >= 0 && findPointerIndex3 >= 0 && findPointerIndex4 >= 0) {
            float x10 = motionEvent3.getX(findPointerIndex);
            float y4 = motionEvent3.getY(findPointerIndex);
            float x11 = motionEvent3.getX(findPointerIndex2);
            float y10 = motionEvent3.getY(findPointerIndex2);
            float x12 = motionEvent.getX(findPointerIndex3);
            float y11 = motionEvent.getY(findPointerIndex3);
            float x13 = motionEvent.getX(findPointerIndex4) - x12;
            float y12 = motionEvent.getY(findPointerIndex4) - y11;
            this.f4977h = x11 - x10;
            this.f4978i = y10 - y4;
            this.f4979j = x13;
            this.f4980k = y12;
            this.f4975f = (x13 * 0.5f) + x12;
            this.f4976g = (y12 * 0.5f) + y11;
            this.f4986q = motionEvent.getEventTime() - motionEvent3.getEventTime();
            this.f4984o = motionEvent.getPressure(findPointerIndex4) + motionEvent.getPressure(findPointerIndex3);
            this.f4985p = motionEvent3.getPressure(findPointerIndex2) + motionEvent3.getPressure(findPointerIndex);
            return;
        }
        this.f4990v = true;
        if (this.f4973c) {
            t1.a aVar = (t1.a) this.f4972b;
            aVar.getClass();
            aVar.c((t1) this);
        }
    }

    public float b() {
        return this.f4980k;
    }

    private int a(MotionEvent motionEvent, int i3, int i10) {
        int pointerCount = motionEvent.getPointerCount();
        int findPointerIndex = motionEvent.findPointerIndex(i3);
        for (int i11 = 0; i11 < pointerCount; i11++) {
            if (i11 != i10 && i11 != findPointerIndex) {
                float f2 = this.r;
                float f10 = this.f4987s;
                float f11 = this.f4988t;
                float a3 = a(motionEvent, i11);
                float b3 = b(motionEvent, i11);
                if (a3 >= f2 && b3 >= f2 && a3 <= f10 && b3 <= f11) {
                    return i11;
                }
            }
        }
        return -1;
    }

    private static float a(MotionEvent motionEvent, int i3) {
        if (i3 < 0) {
            return Float.MIN_VALUE;
        }
        if (i3 == 0) {
            return motionEvent.getRawX();
        }
        return motionEvent.getX(i3) + (motionEvent.getRawX() - motionEvent.getX());
    }

    public float a() {
        return this.f4979j;
    }
}
