package ab;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.google.android.gms.internal.mlkit_vision_common.x;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;

/* loaded from: classes.dex */
public final class e extends m {

    /* renamed from: c, reason: collision with root package name */
    public int f156c;

    /* renamed from: d, reason: collision with root package name */
    public float f157d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public float f158f;

    public e(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.f156c = 1;
    }

    @Override // ab.m
    public final void a(Canvas canvas, float f2) {
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.f192a;
        float f10 = (circularProgressIndicatorSpec.f10717g / 2.0f) + circularProgressIndicatorSpec.f10718h;
        canvas.translate(f10, f10);
        canvas.rotate(-90.0f);
        float f11 = -f10;
        canvas.clipRect(f11, f11, f10, f10);
        this.f156c = circularProgressIndicatorSpec.f10719i == 0 ? 1 : -1;
        this.f157d = circularProgressIndicatorSpec.f151a * f2;
        this.e = circularProgressIndicatorSpec.f152b * f2;
        this.f158f = (circularProgressIndicatorSpec.f10717g - r6) / 2.0f;
        if ((this.f193b.d() && circularProgressIndicatorSpec.e == 2) || (this.f193b.c() && circularProgressIndicatorSpec.f155f == 1)) {
            this.f158f = (((1.0f - f2) * circularProgressIndicatorSpec.f151a) / 2.0f) + this.f158f;
        } else if ((this.f193b.d() && circularProgressIndicatorSpec.e == 1) || (this.f193b.c() && circularProgressIndicatorSpec.f155f == 2)) {
            this.f158f -= ((1.0f - f2) * circularProgressIndicatorSpec.f151a) / 2.0f;
        }
    }

    @Override // ab.m
    public final void b(Canvas canvas, Paint paint, float f2, float f10, int i3) {
        if (f2 == f10) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i3);
        paint.setStrokeWidth(this.f157d);
        float f11 = this.f156c;
        float f12 = f2 * 360.0f * f11;
        float f13 = (f10 >= f2 ? f10 - f2 : (1.0f + f10) - f2) * 360.0f * f11;
        float f14 = this.f158f;
        float f15 = -f14;
        canvas.drawArc(new RectF(f15, f15, f14, f14), f12, f13, false, paint);
        if (this.e <= 0.0f || Math.abs(f13) >= 360.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        float f16 = this.e;
        float f17 = -f16;
        RectF rectF = new RectF(f17, f17, f16, f16);
        f(canvas, paint, this.f157d, this.e, f12, true, rectF);
        f(canvas, paint, this.f157d, this.e, f12 + f13, false, rectF);
    }

    @Override // ab.m
    public final void c(Canvas canvas, Paint paint) {
        int a3 = x.a(((CircularProgressIndicatorSpec) this.f192a).f154d, this.f193b.f191j);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(a3);
        paint.setStrokeWidth(this.f157d);
        float f2 = this.f158f;
        float f10 = -f2;
        canvas.drawArc(new RectF(f10, f10, f2, f2), 0.0f, 360.0f, false, paint);
    }

    @Override // ab.m
    public final int d() {
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.f192a;
        return (circularProgressIndicatorSpec.f10718h * 2) + circularProgressIndicatorSpec.f10717g;
    }

    @Override // ab.m
    public final int e() {
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.f192a;
        return (circularProgressIndicatorSpec.f10718h * 2) + circularProgressIndicatorSpec.f10717g;
    }

    public final void f(Canvas canvas, Paint paint, float f2, float f10, float f11, boolean z5, RectF rectF) {
        float f12 = z5 ? -1.0f : 1.0f;
        canvas.save();
        canvas.rotate(f11);
        float f13 = f2 / 2.0f;
        float f14 = f12 * f10;
        canvas.drawRect((this.f158f - f13) + f10, Math.min(0.0f, this.f156c * f14), (this.f158f + f13) - f10, Math.max(0.0f, f14 * this.f156c), paint);
        canvas.translate((this.f158f - f13) + f10, 0.0f);
        canvas.drawArc(rectF, 180.0f, (-f12) * 90.0f * this.f156c, true, paint);
        canvas.translate(f2 - (f10 * 2.0f), 0.0f);
        canvas.drawArc(rectF, 0.0f, f12 * 90.0f * this.f156c, true, paint);
        canvas.restore();
    }
}
