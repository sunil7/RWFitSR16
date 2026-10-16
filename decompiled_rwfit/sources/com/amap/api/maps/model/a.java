package com.amap.api.maps.model;

import com.amap.api.col.p0003sl.f4;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private final f4 f5747a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5748b;

    /* renamed from: c, reason: collision with root package name */
    private List<WeightedLatLng> f5749c;

    /* renamed from: d, reason: collision with root package name */
    private List<a> f5750d;

    public a(f4 f4Var) {
        this(f4Var, 0);
    }

    public void a(WeightedLatLng weightedLatLng) {
        DPoint point = weightedLatLng.getPoint();
        if (this.f5747a.a(point.f6570x, point.f6571y)) {
            a(point.f6570x, point.f6571y, weightedLatLng);
        }
    }

    private a(double d5, double d8, double d10, double d11, int i3) {
        this(new f4(d5, d8, d10, d11), i3);
    }

    private a(f4 f4Var, int i3) {
        this.f5750d = null;
        this.f5747a = f4Var;
        this.f5748b = i3;
    }

    private void a(double d5, double d8, WeightedLatLng weightedLatLng) {
        a aVar = this;
        List<a> list = aVar.f5750d;
        if (list != null) {
            f4 f4Var = aVar.f5747a;
            if (d8 < f4Var.f4075f) {
                if (d5 < f4Var.e) {
                    list.get(0).a(d5, d8, weightedLatLng);
                    return;
                } else {
                    list.get(1).a(d5, d8, weightedLatLng);
                    return;
                }
            }
            if (d5 < f4Var.e) {
                list.get(2).a(d5, d8, weightedLatLng);
                return;
            } else {
                list.get(3).a(d5, d8, weightedLatLng);
                return;
            }
        }
        if (aVar.f5749c == null) {
            aVar.f5749c = new ArrayList();
        }
        aVar.f5749c.add(weightedLatLng);
        if (aVar.f5749c.size() <= 50 || aVar.f5748b >= 40) {
            return;
        }
        ArrayList arrayList = new ArrayList(4);
        aVar.f5750d = arrayList;
        f4 f4Var2 = aVar.f5747a;
        arrayList.add(new a(f4Var2.f4071a, f4Var2.e, f4Var2.f4072b, f4Var2.f4075f, aVar.f5748b + 1));
        List<a> list2 = aVar.f5750d;
        f4 f4Var3 = aVar.f5747a;
        list2.add(new a(f4Var3.e, f4Var3.f4073c, f4Var3.f4072b, f4Var3.f4075f, aVar.f5748b + 1));
        List<a> list3 = aVar.f5750d;
        f4 f4Var4 = aVar.f5747a;
        list3.add(new a(f4Var4.f4071a, f4Var4.e, f4Var4.f4075f, f4Var4.f4074d, aVar.f5748b + 1));
        List<a> list4 = aVar.f5750d;
        f4 f4Var5 = aVar.f5747a;
        list4.add(new a(f4Var5.e, f4Var5.f4073c, f4Var5.f4075f, f4Var5.f4074d, aVar.f5748b + 1));
        List<WeightedLatLng> list5 = aVar.f5749c;
        aVar.f5749c = null;
        for (WeightedLatLng weightedLatLng2 : list5) {
            aVar.a(weightedLatLng2.getPoint().f6570x, weightedLatLng2.getPoint().f6571y, weightedLatLng2);
            aVar = this;
        }
    }

    public Collection<WeightedLatLng> a(f4 f4Var) {
        ArrayList arrayList = new ArrayList();
        a(f4Var, arrayList);
        return arrayList;
    }

    private void a(f4 f4Var, Collection<WeightedLatLng> collection) {
        if (this.f5747a.a(f4Var)) {
            List<a> list = this.f5750d;
            if (list != null) {
                Iterator<a> it = list.iterator();
                while (it.hasNext()) {
                    it.next().a(f4Var, collection);
                }
                return;
            }
            List<WeightedLatLng> list2 = this.f5749c;
            if (list2 != null) {
                f4 f4Var2 = this.f5747a;
                if (f4Var2.f4071a >= f4Var.f4071a && f4Var2.f4073c <= f4Var.f4073c && f4Var2.f4072b >= f4Var.f4072b && f4Var2.f4074d <= f4Var.f4074d) {
                    collection.addAll(list2);
                    return;
                }
                for (WeightedLatLng weightedLatLng : list2) {
                    DPoint point = weightedLatLng.getPoint();
                    if (f4Var.a(point.f6570x, point.f6571y)) {
                        collection.add(weightedLatLng);
                    }
                }
            }
        }
    }
}
