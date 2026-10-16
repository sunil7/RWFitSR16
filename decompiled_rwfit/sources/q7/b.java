package q7;

import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis$AxisDependency;
import com.github.mikephil.charting.data.DataSet$Rounding;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b implements e {

    /* renamed from: a, reason: collision with root package name */
    public final r7.b f17795a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f17796b = new ArrayList();

    public b(r7.b bVar) {
        this.f17795a = bVar;
    }

    public static float g(List list, float f2, YAxis$AxisDependency yAxis$AxisDependency) {
        float f10 = Float.MAX_VALUE;
        for (int i3 = 0; i3 < list.size(); i3++) {
            c cVar = (c) list.get(i3);
            if (cVar.f17803h == yAxis$AxisDependency) {
                float abs = Math.abs(cVar.f17800d - f2);
                if (abs < f10) {
                    f10 = abs;
                }
            }
        }
        return f10;
    }

    public ArrayList a(o7.d dVar, int i3, float f2, DataSet$Rounding dataSet$Rounding) {
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
                v7.c i11 = ((BarLineChartBase) this.f17795a).s(dVar.f16810d).i(entry.j(), entry.d());
                arrayList.add(new c(entry.j(), entry.d(), (float) i11.f19179b, (float) i11.f19180c, i3, dVar.f16810d));
            }
        }
        return arrayList;
    }

    @Override // q7.e
    public c b(float f2, float f10) {
        v7.c j4 = ((BarLineChartBase) this.f17795a).s(YAxis$AxisDependency.LEFT).j(f2, f10);
        float f11 = (float) j4.f19179b;
        v7.c.c(j4);
        return e(f11, f2, f10);
    }

    public o7.c c() {
        return this.f17795a.getData();
    }

    public float d(float f2, float f10, float f11, float f12) {
        return (float) Math.hypot(f2 - f11, f10 - f12);
    }

    public final c e(float f2, float f10, float f11) {
        List f12 = f(f2);
        c cVar = null;
        if (f12.isEmpty()) {
            return null;
        }
        YAxis$AxisDependency yAxis$AxisDependency = YAxis$AxisDependency.LEFT;
        float g10 = g(f12, f11, yAxis$AxisDependency);
        YAxis$AxisDependency yAxis$AxisDependency2 = YAxis$AxisDependency.RIGHT;
        if (g10 >= g(f12, f11, yAxis$AxisDependency2)) {
            yAxis$AxisDependency = yAxis$AxisDependency2;
        }
        float maxHighlightDistance = this.f17795a.getMaxHighlightDistance();
        for (int i3 = 0; i3 < f12.size(); i3++) {
            c cVar2 = (c) f12.get(i3);
            if (yAxis$AxisDependency == null || cVar2.f17803h == yAxis$AxisDependency) {
                float d5 = d(f10, f11, cVar2.f17799c, cVar2.f17800d);
                if (d5 < maxHighlightDistance) {
                    cVar = cVar2;
                    maxHighlightDistance = d5;
                }
            }
        }
        return cVar;
    }

    public List f(float f2) {
        ArrayList arrayList = this.f17796b;
        arrayList.clear();
        o7.c c9 = c();
        if (c9 != null) {
            int c10 = c9.c();
            for (int i3 = 0; i3 < c10; i3++) {
                o7.d b3 = c9.b(i3);
                if (b3.e) {
                    arrayList.addAll(a(b3, i3, f2, DataSet$Rounding.CLOSEST));
                }
            }
        }
        return arrayList;
    }
}
