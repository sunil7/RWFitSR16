package u7;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.github.mikephil.charting.charts.RadarChart;

/* loaded from: classes.dex */
public final class r extends o {

    /* renamed from: h, reason: collision with root package name */
    public RadarChart f18989h;

    /* renamed from: i, reason: collision with root package name */
    public Paint f18990i;

    @Override // u7.h
    public final void k(Canvas canvas) {
        this.f18989h.getData().getClass();
        throw new ClassCastException();
    }

    @Override // u7.h
    public final void l(Canvas canvas) {
        RadarChart radarChart = this.f18989h;
        radarChart.getSliceAngle();
        radarChart.getFactor();
        radarChart.getRotationAngle();
        radarChart.getCenterOffsets();
        Paint paint = this.f18990i;
        paint.setStrokeWidth(radarChart.getWebLineWidth());
        paint.setColor(radarChart.getWebColor());
        paint.setAlpha(radarChart.getWebAlpha());
        radarChart.getSkipWebLineCount();
        radarChart.getData().getClass();
        throw new ClassCastException();
    }

    @Override // u7.h
    public final void m(Canvas canvas, q7.c[] cVarArr) {
        RadarChart radarChart = this.f18989h;
        radarChart.getSliceAngle();
        radarChart.getFactor();
        v7.d centerOffsets = radarChart.getCenterOffsets();
        v7.d b3 = v7.d.b(0.0f, 0.0f);
        if (radarChart.getData() != 0) {
            throw new ClassCastException();
        }
        if (cVarArr.length > 0) {
            int i3 = cVarArr[0].f17801f;
            throw null;
        }
        v7.d.c(centerOffsets);
        v7.d.c(b3);
    }

    @Override // u7.h
    public final void o(Canvas canvas) {
        this.f18948b.getClass();
        RadarChart radarChart = this.f18989h;
        radarChart.getSliceAngle();
        radarChart.getFactor();
        radarChart.getCenterOffsets();
        v7.d.b(0.0f, 0.0f);
        v7.d.b(0.0f, 0.0f);
        v7.h.c(5.0f);
        radarChart.getData().getClass();
        throw new ClassCastException();
    }

    @Override // u7.h
    public final void p() {
    }
}
