package g9;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;

/* loaded from: classes.dex */
public final class g0 {
    public int A;
    public int B;
    public int C;
    public int D;
    public StaticLayout E;
    public StaticLayout F;
    public int G;
    public int H;
    public int I;
    public Rect J;

    /* renamed from: a, reason: collision with root package name */
    public final float f13951a;

    /* renamed from: b, reason: collision with root package name */
    public final float f13952b;

    /* renamed from: c, reason: collision with root package name */
    public final float f13953c;

    /* renamed from: d, reason: collision with root package name */
    public final float f13954d;
    public final float e;

    /* renamed from: f, reason: collision with root package name */
    public final TextPaint f13955f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f13956g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f13957h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f13958i;

    /* renamed from: j, reason: collision with root package name */
    public Layout.Alignment f13959j;

    /* renamed from: k, reason: collision with root package name */
    public Bitmap f13960k;

    /* renamed from: l, reason: collision with root package name */
    public float f13961l;

    /* renamed from: m, reason: collision with root package name */
    public int f13962m;

    /* renamed from: n, reason: collision with root package name */
    public int f13963n;

    /* renamed from: o, reason: collision with root package name */
    public float f13964o;

    /* renamed from: p, reason: collision with root package name */
    public int f13965p;

    /* renamed from: q, reason: collision with root package name */
    public float f13966q;
    public float r;

    /* renamed from: s, reason: collision with root package name */
    public int f13967s;

    /* renamed from: t, reason: collision with root package name */
    public int f13968t;

    /* renamed from: u, reason: collision with root package name */
    public int f13969u;

    /* renamed from: v, reason: collision with root package name */
    public int f13970v;

    /* renamed from: w, reason: collision with root package name */
    public int f13971w;

    /* renamed from: x, reason: collision with root package name */
    public float f13972x;

    /* renamed from: y, reason: collision with root package name */
    public float f13973y;

    /* renamed from: z, reason: collision with root package name */
    public float f13974z;

    public g0(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.e = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f13954d = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f13951a = round;
        this.f13952b = round;
        this.f13953c = round;
        TextPaint textPaint = new TextPaint();
        this.f13955f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f13956g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f13957h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    public final void a(Canvas canvas, boolean z5) {
        Canvas canvas2;
        if (!z5) {
            this.J.getClass();
            this.f13960k.getClass();
            canvas.drawBitmap(this.f13960k, (Rect) null, this.J, this.f13957h);
            return;
        }
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.f13969u) > 0) {
            Paint paint = this.f13956g;
            paint.setColor(this.f13969u);
            canvas2 = canvas;
            canvas2.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), paint);
        } else {
            canvas2 = canvas;
        }
        int i3 = this.f13971w;
        TextPaint textPaint = this.f13955f;
        if (i3 == 1) {
            textPaint.setStrokeJoin(Paint.Join.ROUND);
            textPaint.setStrokeWidth(this.f13951a);
            textPaint.setColor(this.f13970v);
            textPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas2);
        } else {
            float f2 = this.f13952b;
            if (i3 == 2) {
                float f10 = this.f13953c;
                textPaint.setShadowLayer(f2, f10, f10, this.f13970v);
            } else if (i3 == 3 || i3 == 4) {
                boolean z6 = i3 == 3;
                int i10 = z6 ? -1 : this.f13970v;
                int i11 = z6 ? this.f13970v : -1;
                float f11 = f2 / 2.0f;
                textPaint.setColor(this.f13967s);
                textPaint.setStyle(Paint.Style.FILL);
                float f12 = -f11;
                textPaint.setShadowLayer(f2, f12, f12, i10);
                staticLayout2.draw(canvas2);
                textPaint.setShadowLayer(f2, f11, f11, i11);
            }
        }
        textPaint.setColor(this.f13967s);
        textPaint.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas2);
        textPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas2.restoreToCount(save);
    }
}
