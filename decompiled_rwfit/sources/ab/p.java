package ab;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.google.android.gms.internal.mlkit_vision_common.x;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;

/* loaded from: classes.dex */
public final class p extends m {

    /* renamed from: c, reason: collision with root package name */
    public float f199c;

    /* renamed from: d, reason: collision with root package name */
    public float f200d;
    public float e;

    public p(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.f199c = 300.0f;
    }

    public static void f(Canvas canvas, Paint paint, float f2, float f10, float f11, boolean z5, RectF rectF) {
        canvas.save();
        canvas.translate(f11, 0.0f);
        if (!z5) {
            canvas.rotate(180.0f);
        }
        float f12 = ((-f2) / 2.0f) + f10;
        float f13 = (f2 / 2.0f) - f10;
        canvas.drawRect(-f10, f12, 0.0f, f13, paint);
        canvas.save();
        canvas.translate(0.0f, f12);
        canvas.drawArc(rectF, 180.0f, 90.0f, true, paint);
        canvas.restore();
        canvas.translate(0.0f, f13);
        canvas.drawArc(rectF, 180.0f, -90.0f, true, paint);
        canvas.restore();
    }

    @Override // ab.m
    public final void a(Canvas canvas, float f2) {
        Rect clipBounds = canvas.getClipBounds();
        this.f199c = clipBounds.width();
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) this.f192a;
        float f10 = linearProgressIndicatorSpec.f151a;
        canvas.translate((clipBounds.width() / 2.0f) + clipBounds.left, Math.max(0.0f, (clipBounds.height() - linearProgressIndicatorSpec.f151a) / 2.0f) + (clipBounds.height() / 2.0f) + clipBounds.top);
        if (linearProgressIndicatorSpec.f10723i) {
            canvas.scale(-1.0f, 1.0f);
        }
        if ((this.f193b.d() && linearProgressIndicatorSpec.e == 1) || (this.f193b.c() && linearProgressIndicatorSpec.f155f == 2)) {
            canvas.scale(1.0f, -1.0f);
        }
        if (this.f193b.d() || this.f193b.c()) {
            canvas.translate(0.0f, ((f2 - 1.0f) * linearProgressIndicatorSpec.f151a) / 2.0f);
        }
        float f11 = this.f199c;
        canvas.clipRect((-f11) / 2.0f, (-f10) / 2.0f, f11 / 2.0f, f10 / 2.0f);
        this.f200d = linearProgressIndicatorSpec.f151a * f2;
        this.e = linearProgressIndicatorSpec.f152b * f2;
    }

    @Override // ab.m
    public final void b(Canvas canvas, Paint paint, float f2, float f10, int i3) {
        if (f2 == f10) {
            return;
        }
        float f11 = this.f199c;
        float f12 = this.e;
        float f13 = ((-f11) / 2.0f) + f12;
        float f14 = f11 - (f12 * 2.0f);
        float f15 = (f14 * f2) + f13;
        float f16 = (f14 * f10) + f13;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(i3);
        float f17 = this.f200d;
        canvas.drawRect(f15, (-f17) / 2.0f, f16, f17 / 2.0f, paint);
        float f18 = this.e;
        float f19 = -f18;
        RectF rectF = new RectF(f19, f19, f18, f18);
        f(canvas, paint, this.f200d, this.e, f15, true, rectF);
        f(canvas, paint, this.f200d, this.e, f16, false, rectF);
    }

    @Override // ab.m
    public final void c(Canvas canvas, Paint paint) {
        int a3 = x.a(((LinearProgressIndicatorSpec) this.f192a).f154d, this.f193b.f191j);
        float f2 = ((-this.f199c) / 2.0f) + this.e;
        float f10 = -f2;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(a3);
        float f11 = this.f200d;
        canvas.drawRect(f2, (-f11) / 2.0f, f10, f11 / 2.0f, paint);
        float f12 = this.e;
        float f13 = -f12;
        RectF rectF = new RectF(f13, f13, f12, f12);
        f(canvas, paint, this.f200d, this.e, f2, true, rectF);
        f(canvas, paint, this.f200d, this.e, f10, false, rectF);
    }

    @Override // ab.m
    public final int d() {
        return ((LinearProgressIndicatorSpec) this.f192a).f151a;
    }

    @Override // ab.m
    public final int e() {
        return -1;
    }
}
