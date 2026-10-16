package u7;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.components.YAxis$AxisDependency;
import com.github.mikephil.charting.components.YAxis$YAxisLabelPosition;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class w extends v {

    /* renamed from: n, reason: collision with root package name */
    public final Path f19005n;

    /* renamed from: o, reason: collision with root package name */
    public final float[] f19006o;

    public w(v7.i iVar, n7.i iVar2, de.i iVar3) {
        super(iVar, iVar2, iVar3);
        new Path();
        this.f19005n = new Path();
        this.f19006o = new float[4];
        this.f18934g.setTextAlign(Paint.Align.LEFT);
    }

    @Override // u7.a
    public final void j(float f2, float f10) {
        v7.i iVar = (v7.i) this.f78a;
        if (iVar.f19202b.height() > 10.0f && !iVar.a()) {
            RectF rectF = iVar.f19202b;
            float f11 = rectF.left;
            float f12 = rectF.top;
            de.i iVar2 = this.f18931c;
            v7.c j4 = iVar2.j(f11, f12);
            RectF rectF2 = iVar.f19202b;
            v7.c j10 = iVar2.j(rectF2.right, rectF2.top);
            float f13 = (float) j4.f19179b;
            float f14 = (float) j10.f19179b;
            v7.c.c(j4);
            v7.c.c(j10);
            f2 = f13;
            f10 = f14;
        }
        k(f2, f10);
    }

    @Override // u7.v
    public final void l(Canvas canvas, float f2, float[] fArr, float f10) {
        Paint paint = this.e;
        n7.i iVar = this.f18999h;
        iVar.getClass();
        paint.setTypeface(null);
        paint.setTextSize(iVar.f16409d);
        paint.setColor(iVar.e);
        int i3 = iVar.G ? iVar.f16392l : iVar.f16392l - 1;
        float f11 = iVar.K;
        for (int i10 = !iVar.F ? 1 : 0; i10 < i3; i10++) {
            canvas.drawText(iVar.c(i10), fArr[i10 * 2], (f2 - f10) + f11, paint);
        }
    }

    @Override // u7.v
    public final RectF m() {
        RectF rectF = this.f19001j;
        rectF.set(((v7.i) this.f78a).f19202b);
        rectF.inset(-this.f18930b.f16388h, 0.0f);
        return rectF;
    }

    @Override // u7.v
    public final float[] n() {
        int length = this.f19002k.length;
        n7.i iVar = this.f18999h;
        int i3 = iVar.f16392l;
        if (length != i3 * 2) {
            this.f19002k = new float[i3 * 2];
        }
        float[] fArr = this.f19002k;
        for (int i10 = 0; i10 < fArr.length; i10 += 2) {
            fArr[i10] = iVar.f16391k[i10 / 2];
        }
        this.f18931c.p(fArr);
        return fArr;
    }

    @Override // u7.v
    public final Path o(Path path, int i3, float[] fArr) {
        float f2 = fArr[i3];
        v7.i iVar = (v7.i) this.f78a;
        path.moveTo(f2, iVar.f19202b.top);
        path.lineTo(fArr[i3], iVar.f19202b.bottom);
        return path;
    }

    @Override // u7.v
    public final void p(Canvas canvas) {
        float f2;
        n7.i iVar = this.f18999h;
        if (iVar.f16406a && iVar.f16399t) {
            float[] n4 = n();
            Paint paint = this.e;
            paint.setTypeface(null);
            paint.setTextSize(iVar.f16409d);
            paint.setColor(iVar.e);
            paint.setTextAlign(Paint.Align.CENTER);
            float c9 = v7.h.c(2.5f);
            float a3 = v7.h.a(paint, "Q");
            YAxis$AxisDependency yAxis$AxisDependency = iVar.L;
            YAxis$YAxisLabelPosition yAxis$YAxisLabelPosition = iVar.J;
            YAxis$AxisDependency yAxis$AxisDependency2 = YAxis$AxisDependency.LEFT;
            v7.i iVar2 = (v7.i) this.f78a;
            if (yAxis$AxisDependency == yAxis$AxisDependency2) {
                f2 = (yAxis$YAxisLabelPosition == YAxis$YAxisLabelPosition.OUTSIDE_CHART ? iVar2.f19202b.top : iVar2.f19202b.top) - c9;
            } else {
                f2 = (yAxis$YAxisLabelPosition == YAxis$YAxisLabelPosition.OUTSIDE_CHART ? iVar2.f19202b.bottom : iVar2.f19202b.bottom) + a3 + c9;
            }
            l(canvas, f2, n4, iVar.f16408c);
        }
    }

    @Override // u7.v
    public final void q(Canvas canvas) {
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
                float f10 = rectF.top;
                canvas.drawLine(f2, f10, rectF.right, f10, paint);
                return;
            }
            RectF rectF2 = iVar2.f19202b;
            float f11 = rectF2.left;
            float f12 = rectF2.bottom;
            canvas.drawLine(f11, f12, rectF2.right, f12, paint);
        }
    }

    @Override // u7.v
    public final void s() {
        ArrayList arrayList = this.f18999h.f16401v;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        float[] fArr = this.f19006o;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        this.f19005n.reset();
        if (arrayList.size() > 0) {
            throw android.support.v4.media.session.e.c(0, arrayList);
        }
    }
}
