package u7;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis$XAxisPosition;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class u extends t {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f18997m;

    /* renamed from: n, reason: collision with root package name */
    public Object f18998n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(v7.i iVar, n7.h hVar, de.i iVar2, int i3) {
        super(iVar, hVar, iVar2);
        this.f18997m = i3;
    }

    private final void u() {
    }

    @Override // u7.t, u7.a
    public void j(float f2, float f10) {
        switch (this.f18997m) {
            case 0:
                v7.i iVar = (v7.i) this.f78a;
                if (iVar.f19202b.width() > 10.0f && !iVar.b()) {
                    RectF rectF = iVar.f19202b;
                    float f11 = rectF.left;
                    float f12 = rectF.bottom;
                    de.i iVar2 = this.f18931c;
                    v7.c j4 = iVar2.j(f11, f12);
                    RectF rectF2 = iVar.f19202b;
                    v7.c j10 = iVar2.j(rectF2.left, rectF2.top);
                    float f13 = (float) j4.f19180c;
                    float f14 = (float) j10.f19180c;
                    v7.c.c(j4);
                    v7.c.c(j10);
                    f2 = f13;
                    f10 = f14;
                }
                k(f2, f10);
                break;
            default:
                super.j(f2, f10);
                break;
        }
    }

    @Override // u7.t
    public void l() {
        switch (this.f18997m) {
            case 0:
                Paint paint = this.e;
                n7.h hVar = this.f18992h;
                hVar.getClass();
                paint.setTypeface(null);
                paint.setTextSize(hVar.f16409d);
                v7.a b3 = v7.h.b(paint, hVar.d());
                float f2 = b3.f19176b;
                float f10 = (int) ((hVar.f16407b * 3.5f) + f2);
                float f11 = b3.f19177c;
                v7.a f12 = v7.h.f(f2, f11);
                Math.round(f10);
                Math.round(f11);
                hVar.F = (int) ((hVar.f16407b * 3.5f) + f12.f19176b);
                hVar.G = Math.round(f12.f19177c);
                v7.a.f19175d.c(f12);
                break;
            default:
                super.l();
                break;
        }
    }

    @Override // u7.t
    public void m(Canvas canvas, float f2, float f10, Path path) {
        switch (this.f18997m) {
            case 0:
                v7.i iVar = (v7.i) this.f78a;
                path.moveTo(iVar.f19202b.right, f10);
                path.lineTo(iVar.f19202b.left, f10);
                canvas.drawPath(path, this.f18932d);
                path.reset();
                break;
            default:
                super.m(canvas, f2, f10, path);
                break;
        }
    }

    @Override // u7.t
    public void o(Canvas canvas, float f2, v7.d dVar) {
        Canvas canvas2;
        float f10;
        v7.d dVar2;
        switch (this.f18997m) {
            case 0:
                n7.a aVar = this.f18992h;
                aVar.getClass();
                int i3 = aVar.f16392l * 2;
                float[] fArr = new float[i3];
                int i10 = 0;
                for (int i11 = 0; i11 < i3; i11 += 2) {
                    fArr[i11 + 1] = aVar.f16391k[i11 / 2];
                }
                this.f18931c.p(fArr);
                while (i10 < i3) {
                    float f11 = fArr[i10 + 1];
                    if (((v7.i) this.f78a).h(f11)) {
                        canvas2 = canvas;
                        f10 = f2;
                        dVar2 = dVar;
                        n(canvas2, aVar.e().getFormattedValue(aVar.f16391k[i10 / 2], aVar), f10, f11, dVar2);
                    } else {
                        canvas2 = canvas;
                        f10 = f2;
                        dVar2 = dVar;
                    }
                    i10 += 2;
                    canvas = canvas2;
                    f2 = f10;
                    dVar = dVar2;
                }
                break;
            default:
                super.o(canvas, f2, dVar);
                break;
        }
    }

    @Override // u7.t
    public RectF p() {
        switch (this.f18997m) {
            case 0:
                RectF rectF = this.f18995k;
                rectF.set(((v7.i) this.f78a).f19202b);
                rectF.inset(0.0f, -this.f18930b.f16388h);
                return rectF;
            default:
                return super.p();
        }
    }

    @Override // u7.t
    public final void q(Canvas canvas) {
        switch (this.f18997m) {
            case 0:
                n7.h hVar = this.f18992h;
                if (hVar.f16406a && hVar.f16399t) {
                    float f2 = hVar.f16407b;
                    Paint paint = this.e;
                    paint.setTypeface(null);
                    paint.setTextSize(hVar.f16409d);
                    paint.setColor(hVar.e);
                    v7.d b3 = v7.d.b(0.0f, 0.0f);
                    XAxis$XAxisPosition xAxis$XAxisPosition = hVar.I;
                    XAxis$XAxisPosition xAxis$XAxisPosition2 = XAxis$XAxisPosition.TOP;
                    v7.i iVar = (v7.i) this.f78a;
                    if (xAxis$XAxisPosition == xAxis$XAxisPosition2) {
                        b3.f19182b = 0.0f;
                        b3.f19183c = 0.5f;
                        o(canvas, iVar.f19202b.right + f2, b3);
                    } else if (xAxis$XAxisPosition == XAxis$XAxisPosition.TOP_INSIDE) {
                        b3.f19182b = 1.0f;
                        b3.f19183c = 0.5f;
                        o(canvas, iVar.f19202b.right - f2, b3);
                    } else if (xAxis$XAxisPosition == XAxis$XAxisPosition.BOTTOM) {
                        b3.f19182b = 1.0f;
                        b3.f19183c = 0.5f;
                        o(canvas, iVar.f19202b.left - f2, b3);
                    } else if (xAxis$XAxisPosition == XAxis$XAxisPosition.BOTTOM_INSIDE) {
                        b3.f19182b = 1.0f;
                        b3.f19183c = 0.5f;
                        o(canvas, iVar.f19202b.left + f2, b3);
                    } else {
                        b3.f19182b = 0.0f;
                        b3.f19183c = 0.5f;
                        o(canvas, iVar.f19202b.right + f2, b3);
                        b3.f19182b = 1.0f;
                        b3.f19183c = 0.5f;
                        o(canvas, iVar.f19202b.left - f2, b3);
                    }
                    v7.d.c(b3);
                    return;
                }
                return;
            default:
                n7.h hVar2 = this.f18992h;
                if (hVar2.f16406a && hVar2.f16399t) {
                    v7.d.b(0.5f, 0.25f);
                    Paint paint2 = this.e;
                    paint2.setTypeface(null);
                    paint2.setTextSize(hVar2.f16409d);
                    paint2.setColor(hVar2.e);
                    RadarChart radarChart = (RadarChart) this.f18998n;
                    radarChart.getSliceAngle();
                    radarChart.getFactor();
                    radarChart.getCenterOffsets();
                    v7.d.b(0.0f, 0.0f);
                    radarChart.getData().getClass();
                    throw new ClassCastException();
                }
                return;
        }
    }

    @Override // u7.t
    public void r(Canvas canvas) {
        Canvas canvas2;
        switch (this.f18997m) {
            case 0:
                n7.h hVar = this.f18992h;
                if (hVar.f16398s && hVar.f16406a) {
                    Paint paint = this.f18933f;
                    paint.setColor(hVar.f16389i);
                    paint.setStrokeWidth(hVar.f16390j);
                    XAxis$XAxisPosition xAxis$XAxisPosition = hVar.I;
                    XAxis$XAxisPosition xAxis$XAxisPosition2 = XAxis$XAxisPosition.TOP;
                    v7.i iVar = (v7.i) this.f78a;
                    if (xAxis$XAxisPosition == xAxis$XAxisPosition2 || xAxis$XAxisPosition == XAxis$XAxisPosition.TOP_INSIDE || xAxis$XAxisPosition == XAxis$XAxisPosition.BOTH_SIDED) {
                        RectF rectF = iVar.f19202b;
                        float f2 = rectF.right;
                        canvas2 = canvas;
                        canvas2.drawLine(f2, rectF.top, f2, rectF.bottom, paint);
                    } else {
                        canvas2 = canvas;
                    }
                    XAxis$XAxisPosition xAxis$XAxisPosition3 = hVar.I;
                    if (xAxis$XAxisPosition3 == XAxis$XAxisPosition.BOTTOM || xAxis$XAxisPosition3 == XAxis$XAxisPosition.BOTTOM_INSIDE || xAxis$XAxisPosition3 == XAxis$XAxisPosition.BOTH_SIDED) {
                        RectF rectF2 = iVar.f19202b;
                        float f10 = rectF2.left;
                        canvas2.drawLine(f10, rectF2.top, f10, rectF2.bottom, paint);
                        break;
                    }
                }
                break;
            default:
                super.r(canvas);
                break;
        }
    }

    @Override // u7.t
    public final void t() {
        switch (this.f18997m) {
            case 0:
                ArrayList arrayList = this.f18992h.f16401v;
                if (arrayList == null || arrayList.size() <= 0) {
                    return;
                }
                float[] fArr = this.f18996l;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                ((Path) this.f18998n).reset();
                if (arrayList.size() > 0) {
                    throw android.support.v4.media.session.e.c(0, arrayList);
                }
                return;
            default:
                return;
        }
    }
}
