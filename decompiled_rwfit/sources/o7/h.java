package o7;

import com.github.mikephil.charting.components.YAxis$AxisDependency;
import com.github.mikephil.charting.data.DataSet$Rounding;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public float f16826a;

    /* renamed from: b, reason: collision with root package name */
    public float f16827b;

    /* renamed from: c, reason: collision with root package name */
    public float f16828c;

    /* renamed from: d, reason: collision with root package name */
    public float f16829d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public float f16830f;

    /* renamed from: g, reason: collision with root package name */
    public float f16831g;

    /* renamed from: h, reason: collision with root package name */
    public float f16832h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f16833i;

    public final void a() {
        d dVar;
        d dVar2;
        ArrayList arrayList = this.f16833i;
        if (arrayList == null) {
            return;
        }
        this.f16826a = -3.4028235E38f;
        this.f16827b = Float.MAX_VALUE;
        this.f16828c = -3.4028235E38f;
        this.f16829d = Float.MAX_VALUE;
        int size = arrayList.size();
        int i3 = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            d dVar3 = (d) obj;
            float f2 = this.f16826a;
            float f10 = dVar3.f16821p;
            if (f2 < f10) {
                this.f16826a = f10;
            }
            float f11 = this.f16827b;
            float f12 = dVar3.f16822q;
            if (f11 > f12) {
                this.f16827b = f12;
            }
            float f13 = this.f16828c;
            float f14 = dVar3.r;
            if (f13 < f14) {
                this.f16828c = f14;
            }
            float f15 = this.f16829d;
            float f16 = dVar3.f16823s;
            if (f15 > f16) {
                this.f16829d = f16;
            }
            if (dVar3.f16810d == YAxis$AxisDependency.LEFT) {
                if (this.e < f10) {
                    this.e = f10;
                }
                if (this.f16830f > f12) {
                    this.f16830f = f12;
                }
            } else {
                if (this.f16831g < f10) {
                    this.f16831g = f10;
                }
                if (this.f16832h > f12) {
                    this.f16832h = f12;
                }
            }
        }
        this.e = -3.4028235E38f;
        this.f16830f = Float.MAX_VALUE;
        this.f16831g = -3.4028235E38f;
        this.f16832h = Float.MAX_VALUE;
        int size2 = arrayList.size();
        int i11 = 0;
        while (true) {
            dVar = null;
            if (i11 >= size2) {
                dVar2 = null;
                break;
            }
            Object obj2 = arrayList.get(i11);
            i11++;
            dVar2 = (d) obj2;
            if (dVar2.f16810d == YAxis$AxisDependency.LEFT) {
                break;
            }
        }
        if (dVar2 != null) {
            this.e = dVar2.f16821p;
            this.f16830f = dVar2.f16822q;
            int size3 = arrayList.size();
            int i12 = 0;
            while (i12 < size3) {
                Object obj3 = arrayList.get(i12);
                i12++;
                d dVar4 = (d) obj3;
                if (dVar4.f16810d == YAxis$AxisDependency.LEFT) {
                    float f17 = dVar4.f16822q;
                    if (f17 < this.f16830f) {
                        this.f16830f = f17;
                    }
                    float f18 = dVar4.f16821p;
                    if (f18 > this.e) {
                        this.e = f18;
                    }
                }
            }
        }
        int size4 = arrayList.size();
        int i13 = 0;
        while (true) {
            if (i13 >= size4) {
                break;
            }
            Object obj4 = arrayList.get(i13);
            i13++;
            d dVar5 = (d) obj4;
            if (dVar5.f16810d == YAxis$AxisDependency.RIGHT) {
                dVar = dVar5;
                break;
            }
        }
        if (dVar != null) {
            this.f16831g = dVar.f16821p;
            this.f16832h = dVar.f16822q;
            int size5 = arrayList.size();
            while (i3 < size5) {
                Object obj5 = arrayList.get(i3);
                i3++;
                d dVar6 = (d) obj5;
                if (dVar6.f16810d == YAxis$AxisDependency.RIGHT) {
                    float f19 = dVar6.f16822q;
                    if (f19 < this.f16832h) {
                        this.f16832h = f19;
                    }
                    float f20 = dVar6.f16821p;
                    if (f20 > this.f16831g) {
                        this.f16831g = f20;
                    }
                }
            }
        }
    }

    public final d b(int i3) {
        ArrayList arrayList = this.f16833i;
        if (arrayList == null || i3 < 0 || i3 >= arrayList.size()) {
            return null;
        }
        return (d) arrayList.get(i3);
    }

    public final int c() {
        ArrayList arrayList = this.f16833i;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final int d() {
        ArrayList arrayList = this.f16833i;
        int size = arrayList.size();
        int i3 = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            i3 += ((d) obj).f16820o.size();
        }
        return i3;
    }

    public Entry e(q7.c cVar) {
        int i3 = cVar.f17801f;
        ArrayList arrayList = this.f16833i;
        if (i3 >= arrayList.size()) {
            return null;
        }
        return ((d) arrayList.get(cVar.f17801f)).h(cVar.f17797a, cVar.f17798b, DataSet$Rounding.CLOSEST);
    }

    public final float f(YAxis$AxisDependency yAxis$AxisDependency) {
        if (yAxis$AxisDependency == YAxis$AxisDependency.LEFT) {
            float f2 = this.e;
            return f2 == -3.4028235E38f ? this.f16831g : f2;
        }
        float f10 = this.f16831g;
        return f10 == -3.4028235E38f ? this.e : f10;
    }

    public final float g(YAxis$AxisDependency yAxis$AxisDependency) {
        if (yAxis$AxisDependency == YAxis$AxisDependency.LEFT) {
            float f2 = this.f16830f;
            return f2 == Float.MAX_VALUE ? this.f16832h : f2;
        }
        float f10 = this.f16832h;
        return f10 == Float.MAX_VALUE ? this.f16830f : f10;
    }

    public final void h(d dVar) {
        if (dVar != null && this.f16833i.remove(dVar)) {
            a();
        }
    }

    public final void i() {
        ArrayList arrayList = this.f16833i;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((d) obj).f16815j = false;
        }
    }

    public final void j() {
        ArrayList arrayList = this.f16833i;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            d dVar = (d) obj;
            dVar.getClass();
            dVar.f16818m = v7.h.c(9.0f);
        }
    }
}
