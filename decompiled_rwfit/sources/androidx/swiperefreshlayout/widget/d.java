package androidx.swiperefreshlayout.widget;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final RectF f2860a = new RectF();

    /* renamed from: b, reason: collision with root package name */
    public final Paint f2861b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f2862c;

    /* renamed from: d, reason: collision with root package name */
    public final Paint f2863d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public float f2864f;

    /* renamed from: g, reason: collision with root package name */
    public float f2865g;

    /* renamed from: h, reason: collision with root package name */
    public float f2866h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f2867i;

    /* renamed from: j, reason: collision with root package name */
    public int f2868j;

    /* renamed from: k, reason: collision with root package name */
    public float f2869k;

    /* renamed from: l, reason: collision with root package name */
    public float f2870l;

    /* renamed from: m, reason: collision with root package name */
    public float f2871m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2872n;

    /* renamed from: o, reason: collision with root package name */
    public Path f2873o;

    /* renamed from: p, reason: collision with root package name */
    public float f2874p;

    /* renamed from: q, reason: collision with root package name */
    public float f2875q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f2876s;

    /* renamed from: t, reason: collision with root package name */
    public int f2877t;

    /* renamed from: u, reason: collision with root package name */
    public int f2878u;

    public d() {
        Paint paint = new Paint();
        this.f2861b = paint;
        Paint paint2 = new Paint();
        this.f2862c = paint2;
        Paint paint3 = new Paint();
        this.f2863d = paint3;
        this.e = 0.0f;
        this.f2864f = 0.0f;
        this.f2865g = 0.0f;
        this.f2866h = 5.0f;
        this.f2874p = 1.0f;
        this.f2877t = 255;
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint3.setColor(0);
    }

    public final void a(int i3) {
        this.f2868j = i3;
        this.f2878u = this.f2867i[i3];
    }
}
