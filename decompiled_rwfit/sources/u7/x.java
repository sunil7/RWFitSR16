package u7;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import com.github.mikephil.charting.charts.RadarChart;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class x extends v {

    /* renamed from: n, reason: collision with root package name */
    public RadarChart f19007n;

    @Override // u7.a
    public final void k(float f2, float f10) {
        int i3;
        float f11 = f2;
        n7.a aVar = this.f18930b;
        int i10 = aVar.f16394n;
        double abs = Math.abs(f10 - f11);
        if (i10 == 0 || abs <= 0.0d || Double.isInfinite(abs)) {
            aVar.f16391k = new float[0];
            aVar.f16392l = 0;
            return;
        }
        double h4 = v7.h.h(abs / i10);
        if (aVar.f16396p) {
            double d5 = aVar.f16395o;
            if (h4 < d5) {
                h4 = d5;
            }
        }
        double h10 = v7.h.h(Math.pow(10.0d, (int) Math.log10(h4)));
        if (((int) (h4 / h10)) > 5) {
            double d8 = h10 * 10.0d;
            if (Math.floor(d8) != 0.0d) {
                h4 = Math.floor(d8);
            }
        }
        if (aVar.f16397q) {
            float f12 = ((float) abs) / (i10 - 1);
            aVar.f16392l = i10;
            if (aVar.f16391k.length < i10) {
                aVar.f16391k = new float[i10];
            }
            for (int i11 = 0; i11 < i10; i11++) {
                aVar.f16391k[i11] = f11;
                f11 += f12;
            }
        } else {
            double ceil = h4 == 0.0d ? 0.0d : Math.ceil(f11 / h4) * h4;
            double g10 = h4 == 0.0d ? 0.0d : v7.h.g(Math.floor(f10 / h4) * h4);
            if (h4 != 0.0d) {
                i3 = 0;
                for (double d10 = ceil; d10 <= g10; d10 += h4) {
                    i3++;
                }
            } else {
                i3 = 0;
            }
            i10 = i3 + 1;
            aVar.f16392l = i10;
            if (aVar.f16391k.length < i10) {
                aVar.f16391k = new float[i10];
            }
            for (int i12 = 0; i12 < i10; i12++) {
                if (ceil == 0.0d) {
                    ceil = 0.0d;
                }
                aVar.f16391k[i12] = (float) ceil;
                ceil += h4;
            }
        }
        if (h4 < 1.0d) {
            aVar.f16393m = (int) Math.ceil(-Math.log10(h4));
        } else {
            aVar.f16393m = 0;
        }
        float[] fArr = aVar.f16391k;
        float f13 = fArr[0];
        aVar.B = f13;
        float f14 = fArr[i10 - 1];
        aVar.A = f14;
        aVar.C = Math.abs(f14 - f13);
    }

    @Override // u7.v
    public final void p(Canvas canvas) {
        n7.i iVar = this.f18999h;
        if (iVar.f16406a && iVar.f16399t) {
            Paint paint = this.e;
            paint.setTypeface(null);
            paint.setTextSize(iVar.f16409d);
            paint.setColor(iVar.e);
            RadarChart radarChart = this.f19007n;
            v7.d centerOffsets = radarChart.getCenterOffsets();
            v7.d b3 = v7.d.b(0.0f, 0.0f);
            float factor = radarChart.getFactor();
            int i3 = iVar.G ? iVar.f16392l : iVar.f16392l - 1;
            float f2 = iVar.K;
            for (int i10 = !iVar.F ? 1 : 0; i10 < i3; i10++) {
                float f10 = (iVar.f16391k[i10] - iVar.B) * factor;
                float rotationAngle = radarChart.getRotationAngle();
                DisplayMetrics displayMetrics = v7.h.f19191a;
                double d5 = f10;
                double d8 = rotationAngle;
                b3.f19182b = (float) ((Math.cos(Math.toRadians(d8)) * d5) + centerOffsets.f19182b);
                b3.f19183c = (float) ((Math.sin(Math.toRadians(d8)) * d5) + centerOffsets.f19183c);
                canvas.drawText(iVar.c(i10), b3.f19182b + f2, b3.f19183c, paint);
            }
            v7.d.c(centerOffsets);
            v7.d.c(b3);
        }
    }

    @Override // u7.v
    public final void s() {
        ArrayList arrayList = this.f18999h.f16401v;
        if (arrayList == null) {
            return;
        }
        RadarChart radarChart = this.f19007n;
        radarChart.getSliceAngle();
        radarChart.getFactor();
        v7.d centerOffsets = radarChart.getCenterOffsets();
        v7.d b3 = v7.d.b(0.0f, 0.0f);
        if (arrayList.size() > 0) {
            throw android.support.v4.media.session.e.c(0, arrayList);
        }
        v7.d.c(centerOffsets);
        v7.d.c(b3);
    }
}
