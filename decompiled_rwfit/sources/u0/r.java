package u0;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public float[] f18743a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f18744b;

    /* renamed from: c, reason: collision with root package name */
    public final float[] f18745c;

    /* renamed from: d, reason: collision with root package name */
    public Path f18746d;
    public final Paint e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f18747f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f18748g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f18749h;

    /* renamed from: i, reason: collision with root package name */
    public final Paint f18750i;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f18751j;

    /* renamed from: k, reason: collision with root package name */
    public int f18752k;

    /* renamed from: l, reason: collision with root package name */
    public final Rect f18753l = new Rect();

    /* renamed from: m, reason: collision with root package name */
    public final int f18754m = 1;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ MotionLayout f18755n;

    public r(MotionLayout motionLayout) {
        this.f18755n = motionLayout;
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        paint.setColor(-21965);
        paint.setStrokeWidth(2.0f);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint paint2 = new Paint();
        this.f18747f = paint2;
        paint2.setAntiAlias(true);
        paint2.setColor(-2067046);
        paint2.setStrokeWidth(2.0f);
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.f18748g = paint3;
        paint3.setAntiAlias(true);
        paint3.setColor(-13391360);
        paint3.setStrokeWidth(2.0f);
        paint3.setStyle(style);
        Paint paint4 = new Paint();
        this.f18749h = paint4;
        paint4.setAntiAlias(true);
        paint4.setColor(-13391360);
        paint4.setTextSize(motionLayout.getContext().getResources().getDisplayMetrics().density * 12.0f);
        this.f18751j = new float[8];
        Paint paint5 = new Paint();
        this.f18750i = paint5;
        paint5.setAntiAlias(true);
        paint3.setPathEffect(new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f));
        this.f18745c = new float[100];
        this.f18744b = new int[50];
    }

    public final void a(Canvas canvas, int i3, int i10, n nVar) {
        Canvas canvas2;
        int i11;
        int i12;
        boolean z5;
        float f2;
        int[] iArr = this.f18744b;
        boolean z6 = false;
        int i13 = 4;
        if (i3 == 4) {
            int i14 = 0;
            boolean z8 = false;
            boolean z10 = false;
            while (i14 < this.f18752k) {
                int i15 = iArr[i14];
                boolean z11 = z8;
                if (i15 == 1) {
                    z11 = true;
                }
                if (i15 == 0) {
                    z10 = true;
                }
                i14++;
                z8 = z11;
                z10 = z10;
            }
            if (z8) {
                float[] fArr = this.f18743a;
                canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f18748g);
            }
            if (z10) {
                b(canvas);
            }
        }
        if (i3 == 2) {
            float[] fArr2 = this.f18743a;
            canvas2 = canvas;
            canvas2.drawLine(fArr2[0], fArr2[1], fArr2[fArr2.length - 2], fArr2[fArr2.length - 1], this.f18748g);
        } else {
            canvas2 = canvas;
        }
        if (i3 == 3) {
            b(canvas);
        }
        canvas2.drawLines(this.f18743a, this.e);
        View view = nVar.f18714b;
        if (view != null) {
            i11 = view.getWidth();
            i12 = nVar.f18714b.getHeight();
        } else {
            i11 = 0;
            i12 = 0;
        }
        int i16 = 1;
        while (i16 < i10 - 1) {
            if (i3 == i13 && iArr[i16 - 1] == 0) {
                z5 = z6;
            } else {
                int i17 = i16 * 2;
                float[] fArr3 = this.f18745c;
                float f10 = fArr3[i17];
                float f11 = fArr3[i17 + 1];
                this.f18746d.reset();
                z5 = z6;
                this.f18746d.moveTo(f10, f11 + 10.0f);
                this.f18746d.lineTo(f10 + 10.0f, f11);
                this.f18746d.lineTo(f10, f11 - 10.0f);
                this.f18746d.lineTo(f10 - 10.0f, f11);
                this.f18746d.close();
                int i18 = i16 - 1;
                Paint paint = this.f18750i;
                if (i3 == i13) {
                    int i19 = iArr[i18];
                    if (i19 == 1) {
                        d(canvas2, f10 - 0.0f, f11 - 0.0f);
                    } else if (i19 == 0) {
                        c(canvas2, f10 - 0.0f, f11 - 0.0f);
                    } else if (i19 == 2) {
                        f2 = f11;
                        e(canvas2, f10 - 0.0f, f2 - 0.0f, i11, i12);
                        canvas2.drawPath(this.f18746d, paint);
                    }
                    f2 = f11;
                    canvas2.drawPath(this.f18746d, paint);
                } else {
                    f2 = f11;
                }
                if (i3 == 2) {
                    d(canvas2, f10 - 0.0f, f2 - 0.0f);
                }
                if (i3 == 3) {
                    c(canvas2, f10 - 0.0f, f2 - 0.0f);
                }
                if (i3 == 6) {
                    e(canvas2, f10 - 0.0f, f2 - 0.0f, i11, i12);
                }
                canvas2.drawPath(this.f18746d, paint);
            }
            i16++;
            z6 = z5;
            i13 = 4;
        }
        boolean z12 = z6;
        float[] fArr4 = this.f18743a;
        if (fArr4.length > 1) {
            float f12 = fArr4[z12 ? 1 : 0];
            float f13 = fArr4[1];
            Paint paint2 = this.f18747f;
            canvas2.drawCircle(f12, f13, 8.0f, paint2);
            float[] fArr5 = this.f18743a;
            canvas2.drawCircle(fArr5[fArr5.length - 2], fArr5[fArr5.length - 1], 8.0f, paint2);
        }
    }

    public final void b(Canvas canvas) {
        float[] fArr = this.f18743a;
        float f2 = fArr[0];
        float f10 = fArr[1];
        float f11 = fArr[fArr.length - 2];
        float f12 = fArr[fArr.length - 1];
        float min = Math.min(f2, f11);
        float max = Math.max(f10, f12);
        float max2 = Math.max(f2, f11);
        float max3 = Math.max(f10, f12);
        Paint paint = this.f18748g;
        canvas.drawLine(min, max, max2, max3, paint);
        canvas.drawLine(Math.min(f2, f11), Math.min(f10, f12), Math.min(f2, f11), Math.max(f10, f12), paint);
    }

    public final void c(Canvas canvas, float f2, float f10) {
        float[] fArr = this.f18743a;
        float f11 = fArr[0];
        float f12 = fArr[1];
        float f13 = fArr[fArr.length - 2];
        float f14 = fArr[fArr.length - 1];
        float min = Math.min(f11, f13);
        float max = Math.max(f12, f14);
        float min2 = f2 - Math.min(f11, f13);
        float max2 = Math.max(f12, f14) - f10;
        StringBuilder sb2 = new StringBuilder(15);
        sb2.append(((int) (((min2 * 100.0f) / Math.abs(f13 - f11)) + 0.5d)) / 100.0f);
        String sb3 = sb2.toString();
        Paint paint = this.f18749h;
        paint.getTextBounds(sb3, 0, sb3.length(), this.f18753l);
        Rect rect = this.f18753l;
        canvas.drawText(sb3, ((min2 / 2.0f) - (rect.width() / 2)) + min, f10 - 20.0f, paint);
        float min3 = Math.min(f11, f13);
        Paint paint2 = this.f18748g;
        canvas.drawLine(f2, f10, min3, f10, paint2);
        StringBuilder sb4 = new StringBuilder(15);
        sb4.append(((int) (((max2 * 100.0f) / Math.abs(f14 - f12)) + 0.5d)) / 100.0f);
        String sb5 = sb4.toString();
        paint.getTextBounds(sb5, 0, sb5.length(), this.f18753l);
        canvas.drawText(sb5, f2 + 5.0f, max - ((max2 / 2.0f) - (rect.height() / 2)), paint);
        canvas.drawLine(f2, f10, f2, Math.max(f12, f14), paint2);
    }

    public final void d(Canvas canvas, float f2, float f10) {
        float[] fArr = this.f18743a;
        float f11 = fArr[0];
        float f12 = fArr[1];
        float f13 = fArr[fArr.length - 2];
        float f14 = fArr[fArr.length - 1];
        float hypot = (float) Math.hypot(f11 - f13, f12 - f14);
        float f15 = f13 - f11;
        float f16 = f14 - f12;
        float f17 = (((f10 - f12) * f16) + ((f2 - f11) * f15)) / (hypot * hypot);
        float f18 = (f15 * f17) + f11;
        float f19 = (f17 * f16) + f12;
        Path path = new Path();
        path.moveTo(f2, f10);
        path.lineTo(f18, f19);
        float hypot2 = (float) Math.hypot(f18 - f2, f19 - f10);
        StringBuilder sb2 = new StringBuilder(15);
        sb2.append(((int) ((hypot2 * 100.0f) / hypot)) / 100.0f);
        String sb3 = sb2.toString();
        Paint paint = this.f18749h;
        paint.getTextBounds(sb3, 0, sb3.length(), this.f18753l);
        canvas.drawTextOnPath(sb3, path, (hypot2 / 2.0f) - (this.f18753l.width() / 2), -20.0f, paint);
        canvas.drawLine(f2, f10, f18, f19, this.f18748g);
    }

    public final void e(Canvas canvas, float f2, float f10, int i3, int i10) {
        MotionLayout motionLayout = this.f18755n;
        StringBuilder sb2 = new StringBuilder(15);
        sb2.append(((int) ((((f2 - (i3 / 2)) * 100.0f) / (motionLayout.getWidth() - i3)) + 0.5d)) / 100.0f);
        String sb3 = sb2.toString();
        Paint paint = this.f18749h;
        paint.getTextBounds(sb3, 0, sb3.length(), this.f18753l);
        Rect rect = this.f18753l;
        canvas.drawText(sb3, ((f2 / 2.0f) - (rect.width() / 2)) + 0.0f, f10 - 20.0f, paint);
        float min = Math.min(0.0f, 1.0f);
        Paint paint2 = this.f18748g;
        canvas.drawLine(f2, f10, min, f10, paint2);
        StringBuilder sb4 = new StringBuilder(15);
        sb4.append(((int) ((((f10 - (i10 / 2)) * 100.0f) / (motionLayout.getHeight() - i10)) + 0.5d)) / 100.0f);
        String sb5 = sb4.toString();
        paint.getTextBounds(sb5, 0, sb5.length(), this.f18753l);
        canvas.drawText(sb5, f2 + 5.0f, 0.0f - ((f10 / 2.0f) - (rect.height() / 2)), paint);
        canvas.drawLine(f2, f10, f2, Math.max(0.0f, 1.0f), paint2);
    }
}
