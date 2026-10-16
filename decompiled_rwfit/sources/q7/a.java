package q7;

import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.YAxis$AxisDependency;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet$Rounding;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f17794c = 1;

    public /* synthetic */ a(r7.b bVar) {
        super(bVar);
    }

    @Override // q7.b, q7.e
    public c b(float f2, float f10) {
        switch (this.f17794c) {
            case 0:
                c b3 = super.b(f2, f10);
                if (b3 == null) {
                    return null;
                }
                v7.c j4 = ((BarLineChartBase) this.f17795a).s(YAxis$AxisDependency.LEFT).j(f2, f10);
                o7.b bVar = (o7.b) ((r7.a) this.f17795a).getBarData().b(b3.f17801f);
                if (bVar.o()) {
                    return h(b3, bVar, (float) j4.f19179b, (float) j4.f19180c);
                }
                v7.c.c(j4);
                return b3;
            default:
                return super.b(f2, f10);
        }
    }

    @Override // q7.b
    public o7.c c() {
        switch (this.f17794c) {
            case 0:
                return ((r7.a) this.f17795a).getBarData();
            default:
                return super.c();
        }
    }

    @Override // q7.b
    public float d(float f2, float f10, float f11, float f12) {
        switch (this.f17794c) {
            case 0:
                return Math.abs(f2 - f11);
            default:
                return super.d(f2, f10, f11, f12);
        }
    }

    @Override // q7.b
    public List f(float f2) {
        switch (this.f17794c) {
            case 1:
                this.f17796b.clear();
                ((r7.f) this.f17795a).getCombinedData();
                throw null;
            default:
                return super.f(f2);
        }
    }

    public c h(c cVar, o7.b bVar, float f2, float f10) {
        BarEntry barEntry = (BarEntry) bVar.h(f2, f10, DataSet$Rounding.CLOSEST);
        if (barEntry != null) {
            if (barEntry.o() == null) {
                return cVar;
            }
            g[] n4 = barEntry.n();
            if (n4.length > 0) {
                if (n4.length == 0) {
                    ((BarLineChartBase) ((r7.a) this.f17795a)).s(bVar.f16810d);
                    g gVar = n4[0];
                    throw null;
                }
                if (n4.length > 0) {
                    g gVar2 = n4[0];
                    throw null;
                }
                g gVar3 = n4[Math.max(n4.length - 1, 0)];
                throw null;
            }
        }
        return null;
    }

    public a(CombinedChart combinedChart, CombinedChart combinedChart2) {
        super(combinedChart);
        if (combinedChart2.getBarData() == null) {
            return;
        }
        new ArrayList();
    }
}
