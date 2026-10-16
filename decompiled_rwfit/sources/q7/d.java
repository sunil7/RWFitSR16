package q7;

import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis$AxisDependency;
import com.github.mikephil.charting.data.DataSet$Rounding;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class d extends a {
    @Override // q7.b
    public final ArrayList a(o7.d dVar, int i3, float f2, DataSet$Rounding dataSet$Rounding) {
        Entry h4;
        ArrayList arrayList = new ArrayList();
        ArrayList f10 = dVar.f(f2);
        if (f10.size() == 0 && (h4 = dVar.h(f2, Float.NaN, dataSet$Rounding)) != null) {
            f10 = dVar.f(h4.j());
        }
        if (f10.size() != 0) {
            int size = f10.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = f10.get(i10);
                i10++;
                Entry entry = (Entry) obj;
                v7.c i11 = ((BarLineChartBase) ((r7.a) this.f17795a)).s(dVar.f16810d).i(entry.d(), entry.j());
                arrayList.add(new c(entry.j(), entry.d(), (float) i11.f19179b, (float) i11.f19180c, i3, dVar.f16810d));
            }
        }
        return arrayList;
    }

    @Override // q7.a, q7.b, q7.e
    public final c b(float f2, float f10) {
        o7.a barData = ((r7.a) this.f17795a).getBarData();
        v7.c j4 = ((BarLineChartBase) this.f17795a).s(YAxis$AxisDependency.LEFT).j(f10, f2);
        c e = e((float) j4.f19180c, f10, f2);
        if (e == null) {
            return null;
        }
        o7.b bVar = (o7.b) barData.b(e.f17801f);
        if (bVar.o()) {
            return h(e, bVar, (float) j4.f19180c, (float) j4.f19179b);
        }
        v7.c.c(j4);
        return e;
    }

    @Override // q7.a, q7.b
    public final float d(float f2, float f10, float f11, float f12) {
        return Math.abs(f10 - f12);
    }
}
