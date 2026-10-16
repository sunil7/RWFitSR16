package o7;

import android.graphics.Color;
import com.github.mikephil.charting.components.Legend$LegendForm;
import com.github.mikephil.charting.components.YAxis$AxisDependency;
import com.github.mikephil.charting.data.DataSet$Rounding;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f16807a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f16808b;

    /* renamed from: c, reason: collision with root package name */
    public String f16809c;

    /* renamed from: f, reason: collision with root package name */
    public transient p7.d f16811f;

    /* renamed from: o, reason: collision with root package name */
    public List f16820o;

    /* renamed from: p, reason: collision with root package name */
    public float f16821p;

    /* renamed from: q, reason: collision with root package name */
    public float f16822q;
    public float r;

    /* renamed from: s, reason: collision with root package name */
    public float f16823s;

    /* renamed from: t, reason: collision with root package name */
    public int f16824t;

    /* renamed from: d, reason: collision with root package name */
    public YAxis$AxisDependency f16810d = YAxis$AxisDependency.LEFT;
    public boolean e = true;

    /* renamed from: g, reason: collision with root package name */
    public Legend$LegendForm f16812g = Legend$LegendForm.DEFAULT;

    /* renamed from: h, reason: collision with root package name */
    public float f16813h = Float.NaN;

    /* renamed from: i, reason: collision with root package name */
    public float f16814i = Float.NaN;

    /* renamed from: j, reason: collision with root package name */
    public boolean f16815j = true;

    /* renamed from: k, reason: collision with root package name */
    public boolean f16816k = true;

    /* renamed from: l, reason: collision with root package name */
    public v7.d f16817l = new v7.d();

    /* renamed from: m, reason: collision with root package name */
    public float f16818m = 17.0f;

    /* renamed from: n, reason: collision with root package name */
    public boolean f16819n = true;

    public d(String str, List list) {
        this.f16807a = null;
        this.f16808b = null;
        this.f16809c = "DataSet";
        this.f16807a = new ArrayList();
        this.f16808b = new ArrayList();
        this.f16807a.add(Integer.valueOf(Color.rgb(140, 234, 255)));
        this.f16808b.add(-16777216);
        this.f16809c = str;
        this.f16821p = -3.4028235E38f;
        this.f16822q = Float.MAX_VALUE;
        this.r = -3.4028235E38f;
        this.f16823s = Float.MAX_VALUE;
        this.f16820o = list;
        if (list == null) {
            this.f16820o = new ArrayList();
        }
        b();
        this.f16824t = Color.rgb(255, 187, 115);
    }

    public void a(Entry entry) {
        if (entry == null) {
            return;
        }
        c(entry);
        d(entry);
    }

    public final void b() {
        this.f16821p = -3.4028235E38f;
        this.f16822q = Float.MAX_VALUE;
        this.r = -3.4028235E38f;
        this.f16823s = Float.MAX_VALUE;
        List list = this.f16820o;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = this.f16820o.iterator();
        while (it.hasNext()) {
            a((Entry) it.next());
        }
    }

    public final void c(Entry entry) {
        if (entry.j() < this.f16823s) {
            this.f16823s = entry.j();
        }
        if (entry.j() > this.r) {
            this.r = entry.j();
        }
    }

    public final void d(Entry entry) {
        if (entry.d() < this.f16822q) {
            this.f16822q = entry.d();
        }
        if (entry.d() > this.f16821p) {
            this.f16821p = entry.d();
        }
    }

    public final int e() {
        return ((Integer) this.f16807a.get(0)).intValue();
    }

    public final ArrayList f(float f2) {
        ArrayList arrayList = new ArrayList();
        int size = this.f16820o.size() - 1;
        int i3 = 0;
        while (true) {
            if (i3 > size) {
                break;
            }
            int i10 = (size + i3) / 2;
            Entry entry = (Entry) this.f16820o.get(i10);
            if (f2 == entry.j()) {
                while (i10 > 0 && ((Entry) this.f16820o.get(i10 - 1)).j() == f2) {
                    i10--;
                }
                int size2 = this.f16820o.size();
                while (i10 < size2) {
                    Entry entry2 = (Entry) this.f16820o.get(i10);
                    if (entry2.j() != f2) {
                        break;
                    }
                    arrayList.add(entry2);
                    i10++;
                }
            } else if (f2 > entry.j()) {
                i3 = i10 + 1;
            } else {
                size = i10 - 1;
            }
        }
        return arrayList;
    }

    public final Entry g(int i3) {
        return (Entry) this.f16820o.get(i3);
    }

    public final Entry h(float f2, float f10, DataSet$Rounding dataSet$Rounding) {
        int i3 = i(f2, f10, dataSet$Rounding);
        if (i3 > -1) {
            return (Entry) this.f16820o.get(i3);
        }
        return null;
    }

    public final int i(float f2, float f10, DataSet$Rounding dataSet$Rounding) {
        int i3;
        Entry entry;
        List list = this.f16820o;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int size = this.f16820o.size() - 1;
        int i10 = 0;
        while (i10 < size) {
            int i11 = (i10 + size) / 2;
            float j4 = ((Entry) this.f16820o.get(i11)).j() - f2;
            int i12 = i11 + 1;
            float j10 = ((Entry) this.f16820o.get(i12)).j() - f2;
            float abs = Math.abs(j4);
            float abs2 = Math.abs(j10);
            if (abs2 >= abs) {
                if (abs >= abs2) {
                    double d5 = j4;
                    if (d5 < 0.0d) {
                        if (d5 < 0.0d) {
                        }
                    }
                }
                size = i11;
            }
            i10 = i12;
        }
        if (size != -1) {
            float j11 = ((Entry) this.f16820o.get(size)).j();
            if (dataSet$Rounding == DataSet$Rounding.UP) {
                if (j11 < f2 && size < this.f16820o.size() - 1) {
                    size++;
                }
            } else if (dataSet$Rounding == DataSet$Rounding.DOWN && j11 > f2 && size > 0) {
                size--;
            }
            if (!Float.isNaN(f10)) {
                while (size > 0 && ((Entry) this.f16820o.get(size - 1)).j() == j11) {
                    size--;
                }
                float d8 = ((Entry) this.f16820o.get(size)).d();
                loop2: while (true) {
                    i3 = size;
                    do {
                        size++;
                        if (size >= this.f16820o.size()) {
                            break loop2;
                        }
                        entry = (Entry) this.f16820o.get(size);
                        if (entry.j() != j11) {
                            break loop2;
                        }
                    } while (Math.abs(entry.d() - f10) > Math.abs(d8 - f10));
                    d8 = f10;
                }
                return i3;
            }
        }
        return size;
    }

    public final p7.d j() {
        p7.d dVar = this.f16811f;
        return dVar == null ? v7.h.f19197h : dVar;
    }

    public final int k(int i3) {
        ArrayList arrayList = this.f16808b;
        return ((Integer) arrayList.get(i3 % arrayList.size())).intValue();
    }

    public final void l(int i3) {
        if (this.f16807a == null) {
            this.f16807a = new ArrayList();
        }
        this.f16807a.clear();
        this.f16807a.add(Integer.valueOf(i3));
    }

    public final void m(List list) {
        this.f16820o = list;
        b();
    }

    public final void n() {
        this.f16808b.clear();
        this.f16808b.add(-1);
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuilder sb2 = new StringBuilder("DataSet, label: ");
        String str = this.f16809c;
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        sb2.append(", entries: ");
        sb2.append(this.f16820o.size());
        sb2.append("\n");
        stringBuffer2.append(sb2.toString());
        stringBuffer.append(stringBuffer2.toString());
        for (int i3 = 0; i3 < this.f16820o.size(); i3++) {
            stringBuffer.append(((Entry) this.f16820o.get(i3)).toString() + " ");
        }
        return stringBuffer.toString();
    }
}
