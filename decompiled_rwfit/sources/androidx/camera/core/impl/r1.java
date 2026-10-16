package androidx.camera.core.impl;

import android.hardware.camera2.params.InputConfiguration;
import android.media.MediaCodec;
import android.util.Range;
import androidx.camera.core.c;
import androidx.camera.core.impl.f;
import com.example.test.utils.w0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class r1 extends m1 {

    /* renamed from: i, reason: collision with root package name */
    public final com.example.test.utils.w0 f1478i = new com.example.test.utils.w0(1);

    /* renamed from: j, reason: collision with root package name */
    public boolean f1479j = true;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1480k = false;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f1481l = new ArrayList();

    public final void a(s1 s1Var) {
        Object obj;
        d0 d0Var = s1Var.f1490g;
        int i3 = d0Var.f1368c;
        c0 c0Var = this.f1442b;
        if (i3 != -1) {
            this.f1480k = true;
            int i10 = c0Var.f1356c;
            Integer valueOf = Integer.valueOf(i3);
            List list = s1.f1484i;
            if (list.indexOf(valueOf) < list.indexOf(Integer.valueOf(i10))) {
                i3 = i10;
            }
            c0Var.f1356c = i3;
        }
        c cVar = d0.f1365j;
        Object obj2 = h.f1404f;
        d1 d1Var = d0Var.f1367b;
        try {
            obj2 = d1Var.e(cVar);
        } catch (IllegalArgumentException unused) {
        }
        Range range = (Range) obj2;
        Objects.requireNonNull(range);
        Range range2 = h.f1404f;
        if (!range.equals(range2)) {
            x0 x0Var = c0Var.f1355b;
            c cVar2 = d0.f1365j;
            x0Var.getClass();
            try {
                obj = x0Var.e(cVar2);
            } catch (IllegalArgumentException unused2) {
                obj = range2;
            }
            if (((Range) obj).equals(range2)) {
                c0Var.f1355b.m(d0.f1365j, range);
            } else {
                x0 x0Var2 = c0Var.f1355b;
                c cVar3 = d0.f1365j;
                Object obj3 = h.f1404f;
                x0Var2.getClass();
                try {
                    obj3 = x0Var2.e(cVar3);
                } catch (IllegalArgumentException unused3) {
                }
                if (!((Range) obj3).equals(range)) {
                    this.f1479j = false;
                    com.google.android.gms.internal.mlkit_vision_common.a0.a("ValidatingBuilder", "Different ExpectedFrameRateRange values");
                }
            }
        }
        int a3 = d0Var.a();
        if (a3 != 0) {
            c0Var.getClass();
            if (a3 != 0) {
                c0Var.f1355b.m(a2.L0, Integer.valueOf(a3));
            }
        }
        int b3 = d0Var.b();
        if (b3 != 0) {
            c0Var.getClass();
            if (b3 != 0) {
                c0Var.f1355b.m(a2.M0, Integer.valueOf(b3));
            }
        }
        d0 d0Var2 = s1Var.f1490g;
        c0Var.f1358f.f1514a.putAll((Map) d0Var2.f1370f.f1514a);
        this.f1443c.addAll(s1Var.f1487c);
        this.f1444d.addAll(s1Var.f1488d);
        c0Var.a(d0Var2.f1369d);
        this.e.addAll(s1Var.e);
        p1 p1Var = s1Var.f1489f;
        if (p1Var != null) {
            this.f1481l.add(p1Var);
        }
        InputConfiguration inputConfiguration = s1Var.f1491h;
        if (inputConfiguration != null) {
            this.f1446g = inputConfiguration;
        }
        LinkedHashSet<f> linkedHashSet = this.f1441a;
        linkedHashSet.addAll(s1Var.f1485a);
        HashSet hashSet = c0Var.f1354a;
        hashSet.addAll(Collections.unmodifiableList(d0Var.f1366a));
        ArrayList arrayList = new ArrayList();
        for (f fVar : linkedHashSet) {
            arrayList.add(fVar.f1382a);
            Iterator it = fVar.f1383b.iterator();
            while (it.hasNext()) {
                arrayList.add((g0) it.next());
            }
        }
        if (!arrayList.containsAll(hashSet)) {
            com.google.android.gms.internal.mlkit_vision_common.a0.a("ValidatingBuilder", "Invalid configuration due to capture request surfaces are not a subset of surfaces");
            this.f1479j = false;
        }
        f fVar2 = s1Var.f1486b;
        if (fVar2 != null) {
            f fVar3 = this.f1447h;
            if (fVar3 == fVar2 || fVar3 == null) {
                this.f1447h = fVar2;
            } else {
                com.google.android.gms.internal.mlkit_vision_common.a0.a("ValidatingBuilder", "Invalid configuration due to that two different postview output configs are set");
                this.f1479j = false;
            }
        }
        c0Var.c(d1Var);
    }

    public final s1 b() {
        if (!this.f1479j) {
            throw new IllegalArgumentException("Unsupported session configuration combination");
        }
        ArrayList arrayList = new ArrayList(this.f1441a);
        final com.example.test.utils.w0 w0Var = this.f1478i;
        if (w0Var.f8766a) {
            Collections.sort(arrayList, new Comparator() { // from class: a0.a
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    f fVar = (f) obj2;
                    w0.this.getClass();
                    Class cls = ((f) obj).f1382a.f1400j;
                    int i3 = 1;
                    int i10 = cls == MediaCodec.class ? 2 : cls == c.class ? 0 : 1;
                    Class cls2 = fVar.f1382a.f1400j;
                    if (cls2 == MediaCodec.class) {
                        i3 = 2;
                    } else if (cls2 == c.class) {
                        i3 = 0;
                    }
                    return i10 - i3;
                }
            });
        }
        return new s1(arrayList, new ArrayList(this.f1443c), new ArrayList(this.f1444d), new ArrayList(this.e), this.f1442b.d(), !this.f1481l.isEmpty() ? new q1(this, 0) : null, this.f1446g, this.f1447h);
    }
}
