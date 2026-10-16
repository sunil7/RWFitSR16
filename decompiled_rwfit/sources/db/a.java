package db;

import android.graphics.Paint;
import android.graphics.Path;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f12315i = new int[3];

    /* renamed from: j, reason: collision with root package name */
    public static final float[] f12316j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f12317k = new int[4];

    /* renamed from: l, reason: collision with root package name */
    public static final float[] f12318l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public final Paint f12319a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f12320b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f12321c;

    /* renamed from: d, reason: collision with root package name */
    public int f12322d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f12323f;

    /* renamed from: g, reason: collision with root package name */
    public final Path f12324g = new Path();

    /* renamed from: h, reason: collision with root package name */
    public final Paint f12325h;

    public a() {
        Paint paint = new Paint();
        this.f12325h = paint;
        this.f12319a = new Paint();
        a(-16777216);
        paint.setColor(0);
        Paint paint2 = new Paint(4);
        this.f12320b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f12321c = new Paint(paint2);
    }

    public final void a(int i3) {
        this.f12322d = c1.a.e(i3, 68);
        this.e = c1.a.e(i3, 20);
        this.f12323f = c1.a.e(i3, 0);
        this.f12319a.setColor(this.f12322d);
    }
}
