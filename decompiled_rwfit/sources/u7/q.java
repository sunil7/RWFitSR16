package u7;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.github.mikephil.charting.charts.PieChart;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class q extends h {

    /* renamed from: f, reason: collision with root package name */
    public PieChart f18976f;

    /* renamed from: g, reason: collision with root package name */
    public Paint f18977g;

    /* renamed from: h, reason: collision with root package name */
    public Paint f18978h;

    /* renamed from: i, reason: collision with root package name */
    public TextPaint f18979i;

    /* renamed from: j, reason: collision with root package name */
    public Paint f18980j;

    /* renamed from: k, reason: collision with root package name */
    public StaticLayout f18981k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f18982l;

    /* renamed from: m, reason: collision with root package name */
    public RectF f18983m;

    /* renamed from: n, reason: collision with root package name */
    public RectF[] f18984n;

    /* renamed from: o, reason: collision with root package name */
    public WeakReference f18985o;

    /* renamed from: p, reason: collision with root package name */
    public Canvas f18986p;

    /* renamed from: q, reason: collision with root package name */
    public Path f18987q;
    public Path r;

    /* renamed from: s, reason: collision with root package name */
    public RectF f18988s;

    @Override // u7.h
    public final void k(Canvas canvas) {
        v7.i iVar = (v7.i) this.f78a;
        int i3 = (int) iVar.f19203c;
        int i10 = (int) iVar.f19204d;
        WeakReference weakReference = this.f18985o;
        Bitmap bitmap = weakReference == null ? null : (Bitmap) weakReference.get();
        if (bitmap == null || bitmap.getWidth() != i3 || bitmap.getHeight() != i10) {
            if (i3 <= 0 || i10 <= 0) {
                return;
            }
            bitmap = Bitmap.createBitmap(i3, i10, Bitmap.Config.ARGB_4444);
            this.f18985o = new WeakReference(bitmap);
            this.f18986p = new Canvas(bitmap);
        }
        bitmap.eraseColor(0);
        this.f18976f.getData().getClass();
        throw new ClassCastException();
    }

    @Override // u7.h
    public final void l(Canvas canvas) {
        float radius;
        RectF rectF;
        PieChart pieChart = this.f18976f;
        if (pieChart.M && this.f18986p != null) {
            float radius2 = pieChart.getRadius();
            float holeRadius = (pieChart.getHoleRadius() / 100.0f) * radius2;
            v7.d centerCircleBox = pieChart.getCenterCircleBox();
            Paint paint = this.f18977g;
            if (Color.alpha(paint.getColor()) > 0) {
                this.f18986p.drawCircle(centerCircleBox.f19182b, centerCircleBox.f19183c, holeRadius, paint);
            }
            Paint paint2 = this.f18978h;
            if (Color.alpha(paint2.getColor()) > 0 && pieChart.getTransparentCircleRadius() > pieChart.getHoleRadius()) {
                int alpha = paint2.getAlpha();
                float transparentCircleRadius = (pieChart.getTransparentCircleRadius() / 100.0f) * radius2;
                this.f18948b.getClass();
                paint2.setAlpha((int) (alpha * 1.0f * 1.0f));
                Path path = this.f18987q;
                path.reset();
                path.addCircle(centerCircleBox.f19182b, centerCircleBox.f19183c, transparentCircleRadius, Path.Direction.CW);
                path.addCircle(centerCircleBox.f19182b, centerCircleBox.f19183c, holeRadius, Path.Direction.CCW);
                this.f18986p.drawPath(path, paint2);
                paint2.setAlpha(alpha);
            }
            v7.d.c(centerCircleBox);
        }
        canvas.drawBitmap((Bitmap) this.f18985o.get(), 0.0f, 0.0f, (Paint) null);
        CharSequence centerText = pieChart.getCenterText();
        if (!pieChart.T || centerText == null) {
            return;
        }
        v7.d centerCircleBox2 = pieChart.getCenterCircleBox();
        v7.d centerTextOffset = pieChart.getCenterTextOffset();
        float f2 = centerCircleBox2.f19182b + centerTextOffset.f19182b;
        float f10 = centerCircleBox2.f19183c + centerTextOffset.f19183c;
        if (!pieChart.M || pieChart.N) {
            radius = pieChart.getRadius();
        } else {
            radius = (pieChart.getHoleRadius() / 100.0f) * pieChart.getRadius();
        }
        RectF[] rectFArr = this.f18984n;
        RectF rectF2 = rectFArr[0];
        rectF2.left = f2 - radius;
        rectF2.top = f10 - radius;
        rectF2.right = f2 + radius;
        rectF2.bottom = f10 + radius;
        RectF rectF3 = rectFArr[1];
        rectF3.set(rectF2);
        float centerTextRadiusPercent = pieChart.getCenterTextRadiusPercent() / 100.0f;
        if (centerTextRadiusPercent > 0.0d) {
            rectF3.inset((rectF3.width() - (rectF3.width() * centerTextRadiusPercent)) / 2.0f, (rectF3.height() - (rectF3.height() * centerTextRadiusPercent)) / 2.0f);
        }
        boolean equals = centerText.equals(this.f18982l);
        RectF rectF4 = this.f18983m;
        if (equals && rectF3.equals(rectF4)) {
            rectF = rectF2;
        } else {
            rectF4.set(rectF3);
            this.f18982l = centerText;
            float width = rectF4.width();
            rectF = rectF2;
            this.f18981k = new StaticLayout(centerText, 0, centerText.length(), this.f18979i, (int) Math.max(Math.ceil(width), 1.0d), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        }
        float height = this.f18981k.getHeight();
        canvas.save();
        Path path2 = this.r;
        path2.reset();
        path2.addOval(rectF, Path.Direction.CW);
        canvas.clipPath(path2);
        canvas.translate(rectF3.left, ((rectF3.height() - height) / 2.0f) + rectF3.top);
        this.f18981k.draw(canvas);
        canvas.restore();
        v7.d.c(centerCircleBox2);
        v7.d.c(centerTextOffset);
    }

    @Override // u7.h
    public final void m(Canvas canvas, q7.c[] cVarArr) {
        PieChart pieChart = this.f18976f;
        boolean z5 = pieChart.M && !pieChart.N;
        if (z5 && pieChart.O) {
            return;
        }
        this.f18948b.getClass();
        pieChart.getRotationAngle();
        float[] drawAngles = pieChart.getDrawAngles();
        pieChart.getAbsoluteAngles();
        v7.d centerCircleBox = pieChart.getCenterCircleBox();
        pieChart.getRadius();
        if (z5) {
            pieChart.getHoleRadius();
        }
        this.f18988s.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int i3 = 0; i3 < cVarArr.length; i3++) {
            if (((int) cVarArr[i3].f17797a) < drawAngles.length) {
                if (pieChart.getData() != 0) {
                    throw new ClassCastException();
                }
                int i10 = cVarArr[i3].f17801f;
                throw null;
            }
        }
        v7.d.c(centerCircleBox);
    }

    @Override // u7.h
    public final void o(Canvas canvas) {
        PieChart pieChart = this.f18976f;
        pieChart.getCenterCircleBox();
        pieChart.getRadius();
        pieChart.getRotationAngle();
        pieChart.getDrawAngles();
        pieChart.getAbsoluteAngles();
        this.f18948b.getClass();
        pieChart.getHoleRadius();
        pieChart.getHoleRadius();
        if (pieChart.M && !pieChart.N) {
            boolean z5 = pieChart.O;
        }
        pieChart.getData().getClass();
        throw new ClassCastException();
    }

    @Override // u7.h
    public final void p() {
    }
}
