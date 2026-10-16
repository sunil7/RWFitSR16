package u7;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.CandleStickChart;

/* loaded from: classes.dex */
public final class e extends p {

    /* renamed from: h, reason: collision with root package name */
    public CandleStickChart f18943h;

    @Override // u7.h
    public final void k(Canvas canvas) {
        this.f18943h.getCandleData();
        throw null;
    }

    @Override // u7.h
    public final void l(Canvas canvas) {
    }

    @Override // u7.h
    public final void m(Canvas canvas, q7.c[] cVarArr) {
        this.f18943h.getCandleData();
        if (cVarArr.length <= 0) {
            return;
        }
        int i3 = cVarArr[0].f17801f;
        throw null;
    }

    @Override // u7.h
    public final void o(Canvas canvas) {
        CandleStickChart candleStickChart = this.f18943h;
        if (q(candleStickChart)) {
            candleStickChart.getCandleData();
            throw null;
        }
    }

    @Override // u7.h
    public final void p() {
    }
}
