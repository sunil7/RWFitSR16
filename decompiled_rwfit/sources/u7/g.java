package u7;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.charts.CombinedChart;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class g extends h {

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f18945f;

    /* renamed from: g, reason: collision with root package name */
    public WeakReference f18946g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f18947h;

    @Override // u7.h
    public final void k(Canvas canvas) {
        ArrayList arrayList = this.f18945f;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((h) obj).k(canvas);
        }
    }

    @Override // u7.h
    public final void l(Canvas canvas) {
        ArrayList arrayList = this.f18945f;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((h) obj).l(canvas);
        }
    }

    /* JADX WARN: Type inference failed for: r6v17, types: [com.github.mikephil.charting.charts.BarLineChartBase, r7.g] */
    /* JADX WARN: Type inference failed for: r6v25, types: [com.github.mikephil.charting.charts.BarLineChartBase, r7.a] */
    @Override // u7.h
    public final void m(Canvas canvas, q7.c[] cVarArr) {
        o7.h hVar;
        Chart chart = (Chart) this.f18946g.get();
        if (chart == null) {
            return;
        }
        ArrayList arrayList = this.f18945f;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            h hVar2 = (h) obj;
            if (hVar2 instanceof b) {
                hVar = ((b) hVar2).f18935g.getBarData();
            } else if (hVar2 instanceof n) {
                hVar = ((n) hVar2).f18965h.getLineData();
            } else {
                if (hVar2 instanceof e) {
                    ((e) hVar2).f18943h.getCandleData();
                } else if (hVar2 instanceof s) {
                    ((s) hVar2).f18991h.getScatterData();
                } else if (hVar2 instanceof d) {
                    ((d) hVar2).f18942g.getBubbleData();
                }
                hVar = null;
            }
            if (hVar != null) {
                chart.getData().getClass();
                throw new ClassCastException();
            }
            ArrayList arrayList2 = this.f18947h;
            arrayList2.clear();
            for (q7.c cVar : cVarArr) {
                int i10 = cVar.e;
                if (i10 == -1 || i10 == -1) {
                    arrayList2.add(cVar);
                }
            }
            hVar2.m(canvas, (q7.c[]) arrayList2.toArray(new q7.c[arrayList2.size()]));
        }
    }

    @Override // u7.h
    public final void o(Canvas canvas) {
        ArrayList arrayList = this.f18945f;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((h) obj).o(canvas);
        }
    }

    @Override // u7.h
    public final void p() {
        ArrayList arrayList = this.f18945f;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((h) obj).p();
        }
    }

    public final void r() {
        ArrayList arrayList = this.f18945f;
        arrayList.clear();
        CombinedChart combinedChart = (CombinedChart) this.f18946g.get();
        if (combinedChart == null) {
            return;
        }
        for (CombinedChart.DrawOrder drawOrder : combinedChart.getDrawOrder()) {
            int i3 = f.f18944a[drawOrder.ordinal()];
            v7.i iVar = (v7.i) this.f78a;
            k7.a aVar = this.f18948b;
            if (i3 != 1) {
                if (i3 == 2) {
                    combinedChart.getBubbleData();
                } else if (i3 != 3) {
                    if (i3 == 4) {
                        combinedChart.getCandleData();
                    } else if (i3 == 5) {
                        combinedChart.getScatterData();
                    }
                } else if (combinedChart.getLineData() != null) {
                    arrayList.add(new n(combinedChart, aVar, iVar));
                }
            } else if (combinedChart.getBarData() != null) {
                arrayList.add(new b(combinedChart, aVar, iVar));
            }
        }
    }
}
