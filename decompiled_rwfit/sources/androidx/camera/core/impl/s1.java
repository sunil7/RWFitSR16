package androidx.camera.core.impl;

import android.hardware.camera2.params.InputConfiguration;
import android.util.ArrayMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class s1 {

    /* renamed from: i, reason: collision with root package name */
    public static final List f1484i = Arrays.asList(1, 5, 3);

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1485a;

    /* renamed from: b, reason: collision with root package name */
    public final f f1486b;

    /* renamed from: c, reason: collision with root package name */
    public final List f1487c;

    /* renamed from: d, reason: collision with root package name */
    public final List f1488d;
    public final List e;

    /* renamed from: f, reason: collision with root package name */
    public final p1 f1489f;

    /* renamed from: g, reason: collision with root package name */
    public final d0 f1490g;

    /* renamed from: h, reason: collision with root package name */
    public final InputConfiguration f1491h;

    public s1(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, d0 d0Var, p1 p1Var, InputConfiguration inputConfiguration, f fVar) {
        this.f1485a = arrayList;
        this.f1487c = Collections.unmodifiableList(arrayList2);
        this.f1488d = Collections.unmodifiableList(arrayList3);
        this.e = Collections.unmodifiableList(arrayList4);
        this.f1489f = p1Var;
        this.f1490g = d0Var;
        this.f1491h = inputConfiguration;
        this.f1486b = fVar;
    }

    public static s1 a() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(0);
        ArrayList arrayList3 = new ArrayList(0);
        ArrayList arrayList4 = new ArrayList(0);
        HashSet hashSet = new HashSet();
        x0 f2 = x0.f();
        ArrayList arrayList5 = new ArrayList();
        z0 a3 = z0.a();
        ArrayList arrayList6 = new ArrayList(hashSet);
        d1 a10 = d1.a(f2);
        ArrayList arrayList7 = new ArrayList(arrayList5);
        w1 w1Var = w1.f1513b;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = a3.f1514a;
        for (String str : arrayMap2.keySet()) {
            arrayMap.put(str, arrayMap2.get(str));
        }
        return new s1(arrayList, arrayList2, arrayList3, arrayList4, new d0(arrayList6, a10, -1, arrayList7, false, new w1(arrayMap), null), null, null, null);
    }

    public final List b() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f1485a;
        int size = arrayList2.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList2.get(i3);
            i3++;
            f fVar = (f) obj;
            arrayList.add(fVar.f1382a);
            Iterator it = fVar.f1383b.iterator();
            while (it.hasNext()) {
                arrayList.add((g0) it.next());
            }
        }
        return Collections.unmodifiableList(arrayList);
    }
}
