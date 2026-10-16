package u7;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.ScatterChart;

/* loaded from: classes.dex */
public final class s extends p {

    /* renamed from: h, reason: collision with root package name */
    public ScatterChart f18991h;

    @Override // u7.h
    public final void k(Canvas canvas) {
        this.f18991h.getScatterData();
        throw null;
    }

    @Override // u7.h
    public final void l(Canvas canvas) {
    }

    @Override // u7.h
    public final void m(Canvas canvas, q7.c[] cVarArr) {
        this.f18991h.getScatterData();
        if (cVarArr.length <= 0) {
            return;
        }
        int i3 = cVarArr[0].f17801f;
        throw null;
    }

    @Override // u7.h
    public final void o(Canvas canvas) {
        ScatterChart scatterChart = this.f18991h;
        if (q(scatterChart)) {
            scatterChart.getScatterData();
            throw null;
        }
    }

    @Override // u7.h
    public final void p() {
    }
}
