package u7;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.YAxis$AxisDependency;
import com.github.mikephil.charting.components.YAxis$YAxisLabelPosition;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class v extends a {

    /* renamed from: h, reason: collision with root package name */
    public final n7.i f18999h;

    /* renamed from: i, reason: collision with root package name */
    public final Path f19000i;

    /* renamed from: j, reason: collision with root package name */
    public final RectF f19001j;

    /* renamed from: k, reason: collision with root package name */
    public float[] f19002k;

    /* renamed from: l, reason: collision with root package name */
    public final Path f19003l;

    /* renamed from: m, reason: collision with root package name */
    public final float[] f19004m;

    public v(v7.i iVar, n7.i iVar2, de.i iVar3) {
        super(iVar, iVar3, iVar2);
        this.f19000i = new Path();
        this.f19001j = new RectF();
        this.f19002k = new float[2];
        new Path();
        new RectF();
        this.f19003l = new Path();
        this.f19004m = new float[2];
        new RectF();
        this.f18999h = iVar2;
        if (iVar != null) {
            this.e.setColor(-16777216);
            this.e.setTextSize(v7.h.c(10.0f));
            Paint paint = new Paint(1);
            paint.setColor(-7829368);
            paint.setStrokeWidth(1.0f);
            paint.setStyle(Paint.Style.STROKE);
        }
    }

    public void l(Canvas canvas, float f2, float[] fArr, float f10) {
        n7.i iVar = this.f18999h;
        int i3 = iVar.G ? iVar.f16392l : iVar.f16392l - 1;
        float f11 = iVar.K;
        for (int i10 = !iVar.F ? 1 : 0; i10 < i3; i10++) {
            canvas.drawText(iVar.c(i10), f2 + f11, fArr[(i10 * 2) + 1] + f10, this.e);
        }
    }

    public RectF m() {
        RectF rectF = this.f19001j;
        rectF.set(((v7.i) this.f78a).f19202b);
        rectF.inset(0.0f, -this.f18930b.f16388h);
        return rectF;
    }

    public float[] n() {
        int length = this.f19002k.length;
        n7.i iVar = this.f18999h;
        int i3 = iVar.f16392l;
        if (length != i3 * 2) {
            this.f19002k = new float[i3 * 2];
        }
        float[] fArr = this.f19002k;
        for (int i10 = 0; i10 < fArr.length; i10 += 2) {
            fArr[i10 + 1] = iVar.f16391k[i10 / 2];
        }
        this.f18931c.p(fArr);
        return fArr;
    }

    public Path o(Path path, int i3, float[] fArr) {
        v7.i iVar = (v7.i) this.f78a;
        int i10 = i3 + 1;
        path.moveTo(iVar.f19202b.left, fArr[i10]);
        path.lineTo(iVar.f19202b.right, fArr[i10]);
        return path;
    }

    public void p(Canvas canvas) {
        float f2;
        float f10;
        float f11;
        n7.i iVar = this.f18999h;
        if (iVar.f16406a && iVar.f16399t) {
            float[] n4 = n();
            Paint paint = this.e;
            paint.setTypeface(null);
            paint.setTextSize(iVar.f16409d);
            paint.setColor(iVar.e);
            float f12 = iVar.f16407b;
            float a3 = (v7.h.a(paint, "A") / 2.5f) + iVar.f16408c;
            YAxis$AxisDependency yAxis$AxisDependency = iVar.L;
            YAxis$YAxisLabelPosition yAxis$YAxisLabelPosition = iVar.J;
            YAxis$AxisDependency yAxis$AxisDependency2 = YAxis$AxisDependency.LEFT;
            v7.i iVar2 = (v7.i) this.f78a;
            if (yAxis$AxisDependency == yAxis$AxisDependency2) {
                if (yAxis$YAxisLabelPosition == YAxis$YAxisLabelPosition.OUTSIDE_CHART) {
                    paint.setTextAlign(Paint.Align.RIGHT);
                    f2 = iVar2.f19202b.left;
                    f11 = f2 - f12;
                } else {
                    paint.setTextAlign(Paint.Align.LEFT);
                    f10 = iVar2.f19202b.left;
                    f11 = f10 + f12;
                }
            } else if (yAxis$YAxisLabelPosition == YAxis$YAxisLabelPosition.OUTSIDE_CHART) {
                paint.setTextAlign(Paint.Align.LEFT);
                f10 = iVar2.f19202b.right;
                f11 = f10 + f12;
            } else {
                paint.setTextAlign(Paint.Align.RIGHT);
                f2 = iVar2.f19202b.right;
                f11 = f2 - f12;
            }
            l(canvas, f11, n4, a3);
        }
    }

    public void q(Canvas canvas) {
        n7.i iVar = this.f18999h;
        if (iVar.f16406a && iVar.f16398s) {
            Paint paint = this.f18933f;
            paint.setColor(iVar.f16389i);
            paint.setStrokeWidth(iVar.f16390j);
            YAxis$AxisDependency yAxis$AxisDependency = iVar.L;
            YAxis$AxisDependency yAxis$AxisDependency2 = YAxis$AxisDependency.LEFT;
            v7.i iVar2 = (v7.i) this.f78a;
            if (yAxis$AxisDependency == yAxis$AxisDependency2) {
                RectF rectF = iVar2.f19202b;
                float f2 = rectF.left;
                canvas.drawLine(f2, rectF.top, f2, rectF.bottom, paint);
            } else {
                RectF rectF2 = iVar2.f19202b;
                float f10 = rectF2.right;
                canvas.drawLine(f10, rectF2.top, f10, rectF2.bottom, paint);
            }
        }
    }

    public final void r(Canvas canvas) {
        n7.i iVar = this.f18999h;
        if (iVar.f16406a && iVar.r) {
            int save = canvas.save();
            canvas.clipRect(m());
            float[] n4 = n();
            Paint paint = this.f18932d;
            paint.setColor(iVar.f16387g);
            paint.setStrokeWidth(iVar.f16388h);
            paint.setPathEffect(iVar.f16400u);
            Path path = this.f19000i;
            path.reset();
            for (int i3 = 0; i3 < n4.length; i3 += 2) {
                canvas.drawPath(o(path, i3, n4), paint);
                path.reset();
            }
            canvas.restoreToCount(save);
        }
    }

    public void s() {
        ArrayList arrayList = this.f18999h.f16401v;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        float[] fArr = this.f19004m;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        this.f19003l.reset();
        if (arrayList.size() > 0) {
            throw android.support.v4.media.session.e.c(0, arrayList);
        }
    }
}
