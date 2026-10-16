package com.amap.api.col.p0003sl;

import com.amap.api.col.p0003sl.l7;
import com.amap.api.services.core.LatLonPoint;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
class n7 extends m7 {

    /* renamed from: j, reason: collision with root package name */
    private double f4696j;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        LatLonPoint f4697a;

        /* renamed from: b, reason: collision with root package name */
        double f4698b;

        public a(double d5, double d8, double d10) {
            this.f4697a = null;
            this.f4698b = 0.0d;
            this.f4697a = new LatLonPoint(d5, d8);
            this.f4698b = d10;
        }

        public boolean a(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                LatLonPoint latLonPoint = this.f4697a;
                a aVar = (a) obj;
                if (latLonPoint == aVar.f4697a) {
                    return true;
                }
                if (latLonPoint != null && d6.a(latLonPoint, r3) <= aVar.f4698b) {
                    return true;
                }
            }
            return false;
        }
    }

    public n7(String... strArr) {
        super(strArr);
        this.f4696j = 0.0d;
    }

    @Override // com.amap.api.col.p0003sl.m7
    public boolean a(LinkedHashMap<l7.b, Object> linkedHashMap, l7.b bVar) {
        String str;
        if (linkedHashMap != null) {
            if (bVar.f4476b == null) {
                return super.a(linkedHashMap, bVar);
            }
            for (l7.b bVar2 : linkedHashMap.keySet()) {
                if (bVar2 != null && (str = bVar2.f4475a) != null && str.equals(bVar.f4475a)) {
                    Object obj = bVar2.f4476b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.f4476b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.amap.api.col.p0003sl.m7
    public Object b(LinkedHashMap<l7.b, Object> linkedHashMap, l7.b bVar) {
        String str;
        if (linkedHashMap != null) {
            if (bVar.f4476b == null) {
                return super.b(linkedHashMap, bVar);
            }
            for (l7.b bVar2 : linkedHashMap.keySet()) {
                if (bVar2 != null && (str = bVar2.f4475a) != null && str.equals(bVar.f4475a)) {
                    Object obj = bVar2.f4476b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.f4476b)) {
                        return linkedHashMap.get(bVar2);
                    }
                }
            }
        }
        return null;
    }

    @Override // com.amap.api.col.p0003sl.m7
    public Object c(LinkedHashMap<l7.b, Object> linkedHashMap, l7.b bVar) {
        l7.b bVar2;
        String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.f4476b == null) {
                return super.c(linkedHashMap, bVar);
            }
            Iterator<l7.b> it = linkedHashMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    bVar2 = null;
                    break;
                }
                bVar2 = it.next();
                if (bVar2 != null && (str = bVar2.f4475a) != null && str.equals(bVar.f4475a)) {
                    Object obj = bVar2.f4476b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.f4476b)) {
                        break;
                    }
                }
            }
            if (bVar2 != null) {
                return linkedHashMap.remove(bVar2);
            }
        }
        return null;
    }

    @Override // com.amap.api.col.p0003sl.m7
    public void a(l7.a aVar) {
        super.a(aVar);
        this.f4696j = aVar.a();
    }

    public double b() {
        return this.f4696j;
    }
}
