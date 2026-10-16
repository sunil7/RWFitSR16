package q7;

import a2.h;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.charts.RadarChart;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class f extends h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f17806c;

    public f(PieRadarChartBase pieRadarChartBase, int i3) {
        this.f17806c = i3;
        this.f37b = new ArrayList();
        this.f36a = pieRadarChartBase;
    }

    @Override // a2.h
    public final c y() {
        switch (this.f17806c) {
            case 0:
                ((PieChart) ((PieRadarChartBase) this.f36a)).getData().getClass();
                throw new ClassCastException();
            default:
                ((ArrayList) this.f37b).clear();
                RadarChart radarChart = (RadarChart) ((PieRadarChartBase) this.f36a);
                radarChart.getAnimator().getClass();
                radarChart.getAnimator().getClass();
                radarChart.getSliceAngle();
                radarChart.getFactor();
                v7.d.b(0.0f, 0.0f);
                radarChart.getData().getClass();
                throw new ClassCastException();
        }
    }
}
