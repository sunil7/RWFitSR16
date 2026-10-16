package androidx.swiperefreshlayout.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public final class e extends Drawable implements Animatable {

    /* renamed from: g, reason: collision with root package name */
    public static final LinearInterpolator f2879g = new LinearInterpolator();

    /* renamed from: h, reason: collision with root package name */
    public static final v1.a f2880h = new v1.a();

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f2881i = {-16777216};

    /* renamed from: a, reason: collision with root package name */
    public final d f2882a;

    /* renamed from: b, reason: collision with root package name */
    public float f2883b;

    /* renamed from: c, reason: collision with root package name */
    public final Resources f2884c;

    /* renamed from: d, reason: collision with root package name */
    public final ValueAnimator f2885d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2886f;

    public e(Context context) {
        context.getClass();
        this.f2884c = context.getResources();
        d dVar = new d();
        this.f2882a = dVar;
        dVar.f2867i = f2881i;
        dVar.a(0);
        dVar.f2866h = 2.5f;
        dVar.f2861b.setStrokeWidth(2.5f);
        invalidateSelf();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b(this, dVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f2879g);
        ofFloat.addListener(new c(this, dVar));
        this.f2885d = ofFloat;
    }

    public static void d(float f2, d dVar) {
        if (f2 <= 0.75f) {
            dVar.f2878u = dVar.f2867i[dVar.f2868j];
            return;
        }
        float f10 = (f2 - 0.75f) / 0.25f;
        int[] iArr = dVar.f2867i;
        int i3 = dVar.f2868j;
        int i10 = iArr[i3];
        int i11 = iArr[(i3 + 1) % iArr.length];
        dVar.f2878u = ((((i10 >> 24) & 255) + ((int) ((((i11 >> 24) & 255) - r1) * f10))) << 24) | ((((i10 >> 16) & 255) + ((int) ((((i11 >> 16) & 255) - r3) * f10))) << 16) | ((((i10 >> 8) & 255) + ((int) ((((i11 >> 8) & 255) - r4) * f10))) << 8) | ((i10 & 255) + ((int) (f10 * ((i11 & 255) - r2))));
    }

    public final void a(float f2, d dVar, boolean z5) {
        float interpolation;
        float f10;
        if (this.f2886f) {
            d(f2, dVar);
            float floor = (float) (Math.floor(dVar.f2871m / 0.8f) + 1.0d);
            float f11 = dVar.f2869k;
            float f12 = dVar.f2870l;
            dVar.e = (((f12 - 0.01f) - f11) * f2) + f11;
            dVar.f2864f = f12;
            float f13 = dVar.f2871m;
            dVar.f2865g = l0.a(floor, f13, f2, f13);
            return;
        }
        if (f2 != 1.0f || z5) {
            float f14 = dVar.f2871m;
            v1.a aVar = f2880h;
            if (f2 < 0.5f) {
                interpolation = dVar.f2869k;
                f10 = (aVar.getInterpolation(f2 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float f15 = dVar.f2869k + 0.79f;
                interpolation = f15 - (((1.0f - aVar.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f10 = f15;
            }
            float f16 = (0.20999998f * f2) + f14;
            float f17 = (f2 + this.e) * 216.0f;
            dVar.e = interpolation;
            dVar.f2864f = f10;
            dVar.f2865g = f16;
            this.f2883b = f17;
        }
    }

    public final void b(float f2, float f10, float f11, float f12) {
        float f13 = this.f2884c.getDisplayMetrics().density;
        float f14 = f10 * f13;
        d dVar = this.f2882a;
        dVar.f2866h = f14;
        dVar.f2861b.setStrokeWidth(f14);
        dVar.f2875q = f2 * f13;
        dVar.a(0);
        dVar.r = (int) (f11 * f13);
        dVar.f2876s = (int) (f12 * f13);
    }

    public final void c(int i3) {
        if (i3 == 0) {
            b(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            b(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f2883b, bounds.exactCenterX(), bounds.exactCenterY());
        d dVar = this.f2882a;
        RectF rectF = dVar.f2860a;
        float f2 = dVar.f2875q;
        float f10 = (dVar.f2866h / 2.0f) + f2;
        if (f2 <= 0.0f) {
            f10 = (Math.min(bounds.width(), bounds.height()) / 2.0f) - Math.max((dVar.r * dVar.f2874p) / 2.0f, dVar.f2866h / 2.0f);
        }
        rectF.set(bounds.centerX() - f10, bounds.centerY() - f10, bounds.centerX() + f10, bounds.centerY() + f10);
        float f11 = dVar.e;
        float f12 = dVar.f2865g;
        float f13 = (f11 + f12) * 360.0f;
        float f14 = ((dVar.f2864f + f12) * 360.0f) - f13;
        Paint paint = dVar.f2861b;
        paint.setColor(dVar.f2878u);
        paint.setAlpha(dVar.f2877t);
        float f15 = dVar.f2866h / 2.0f;
        rectF.inset(f15, f15);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, dVar.f2863d);
        float f16 = -f15;
        rectF.inset(f16, f16);
        canvas.drawArc(rectF, f13, f14, false, paint);
        if (dVar.f2872n) {
            Path path = dVar.f2873o;
            if (path == null) {
                Path path2 = new Path();
                dVar.f2873o = path2;
                path2.setFillType(Path.FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
            float f17 = (dVar.r * dVar.f2874p) / 2.0f;
            dVar.f2873o.moveTo(0.0f, 0.0f);
            dVar.f2873o.lineTo(dVar.r * dVar.f2874p, 0.0f);
            Path path3 = dVar.f2873o;
            float f18 = dVar.r;
            float f19 = dVar.f2874p;
            path3.lineTo((f18 * f19) / 2.0f, dVar.f2876s * f19);
            dVar.f2873o.offset((rectF.centerX() + min) - f17, (dVar.f2866h / 2.0f) + rectF.centerY());
            dVar.f2873o.close();
            Paint paint2 = dVar.f2862c;
            paint2.setColor(dVar.f2878u);
            paint2.setAlpha(dVar.f2877t);
            canvas.save();
            canvas.rotate(f13 + f14, rectF.centerX(), rectF.centerY());
            canvas.drawPath(dVar.f2873o, paint2);
            canvas.restore();
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f2882a.f2877t;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f2885d.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i3) {
        this.f2882a.f2877t = i3;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f2882a.f2861b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        this.f2885d.cancel();
        d dVar = this.f2882a;
        float f2 = dVar.e;
        dVar.f2869k = f2;
        float f10 = dVar.f2864f;
        dVar.f2870l = f10;
        dVar.f2871m = dVar.f2865g;
        if (f10 != f2) {
            this.f2886f = true;
            this.f2885d.setDuration(666L);
            this.f2885d.start();
            return;
        }
        dVar.a(0);
        dVar.f2869k = 0.0f;
        dVar.f2870l = 0.0f;
        dVar.f2871m = 0.0f;
        dVar.e = 0.0f;
        dVar.f2864f = 0.0f;
        dVar.f2865g = 0.0f;
        this.f2885d.setDuration(1332L);
        this.f2885d.start();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f2885d.cancel();
        this.f2883b = 0.0f;
        d dVar = this.f2882a;
        if (dVar.f2872n) {
            dVar.f2872n = false;
        }
        dVar.a(0);
        dVar.f2869k = 0.0f;
        dVar.f2870l = 0.0f;
        dVar.f2871m = 0.0f;
        dVar.e = 0.0f;
        dVar.f2864f = 0.0f;
        dVar.f2865g = 0.0f;
        invalidateSelf();
    }
}
