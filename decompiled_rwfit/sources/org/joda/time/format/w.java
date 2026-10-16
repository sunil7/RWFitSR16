package org.joda.time.format;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static a0 f17259a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.util.List] */
    public static a0 a() {
        g0 g0Var;
        ArrayList arrayList;
        if (f17259a == null) {
            i0 i0Var = new i0();
            ArrayList arrayList2 = i0Var.f17190a;
            if (arrayList2 == null) {
                i0Var.f17190a = new ArrayList();
            } else {
                arrayList2.clear();
            }
            int i3 = 0;
            i0Var.f17191b = false;
            i0Var.f17192c = false;
            i0Var.f17193d = new d0[10];
            f0 f0Var = new f0("P");
            i0Var.a(f0Var, f0Var);
            i0Var.b(0);
            i0Var.c("Y");
            i0Var.b(1);
            i0Var.c("M");
            i0Var.b(2);
            i0Var.c("W");
            i0Var.b(3);
            i0Var.c("D");
            ArrayList arrayList3 = i0Var.f17190a;
            boolean z5 = false;
            if (arrayList3.size() == 0) {
                f0 f0Var2 = f0.f17176b;
                g0 g0Var2 = new g0(f0Var2, f0Var2);
                i0Var.a(g0Var2, g0Var2);
            } else {
                int size = arrayList3.size();
                while (true) {
                    int i10 = size - 1;
                    if (i10 < 0) {
                        g0Var = null;
                        arrayList = arrayList3;
                        break;
                    }
                    if (arrayList3.get(i10) instanceof g0) {
                        g0Var = (g0) arrayList3.get(i10);
                        arrayList = arrayList3.subList(size, arrayList3.size());
                        break;
                    }
                    size -= 2;
                }
                if (g0Var != null && arrayList.size() == 0) {
                    throw new IllegalStateException("Cannot have two adjacent separators");
                }
                Object[] d5 = i0.d(arrayList);
                arrayList.clear();
                g0 g0Var3 = new g0((k0) d5[0], (j0) d5[1]);
                arrayList.add(g0Var3);
                arrayList.add(g0Var3);
            }
            i0Var.b(4);
            i0Var.c("H");
            i0Var.b(5);
            i0Var.c("M");
            i0Var.b(9);
            i0Var.c("S");
            a0 e = i0.e(i0Var.f17190a, i0Var.f17191b, i0Var.f17192c);
            d0[] d0VarArr = i0Var.f17193d;
            int length = d0VarArr.length;
            int i11 = 0;
            while (i11 < length) {
                d0 d0Var = d0VarArr[i11];
                if (d0Var != null) {
                    d0[] d0VarArr2 = i0Var.f17193d;
                    HashSet hashSet = new HashSet();
                    HashSet hashSet2 = new HashSet();
                    int length2 = d0VarArr2.length;
                    for (int i12 = i3; i12 < length2; i12++) {
                        d0 d0Var2 = d0VarArr2[i12];
                        if (d0Var2 != null && !d0Var.equals(d0Var2)) {
                            hashSet.add(z5);
                            hashSet2.add(d0Var2.f17171f);
                        }
                    }
                    e0 e0Var = d0Var.f17171f;
                    if (e0Var != null && e0Var.f17172a == null) {
                        String[] b3 = e0Var.b();
                        int i13 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
                        String str = null;
                        for (String str2 : b3) {
                            if (str2.length() < i13) {
                                i13 = str2.length();
                                str = str2;
                            }
                        }
                        HashSet hashSet3 = new HashSet();
                        Iterator it = hashSet2.iterator();
                        while (it.hasNext()) {
                            e0 e0Var2 = (e0) it.next();
                            if (e0Var2 != null) {
                                for (String str3 : e0Var2.b()) {
                                    if (str3.length() > i13 || (str3.equalsIgnoreCase(str) && !str3.equals(str))) {
                                        hashSet3.add(str3);
                                    }
                                }
                            }
                        }
                        e0Var.f17172a = (String[]) hashSet3.toArray(new String[hashSet3.size()]);
                    }
                }
                i11++;
                i3 = 0;
                z5 = false;
            }
            i0Var.f17193d = (d0[]) i0Var.f17193d.clone();
            f17259a = e;
        }
        return f17259a;
    }
}
