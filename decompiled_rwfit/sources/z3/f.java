package z3;

import com.bumptech.glide.Priority;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f20219a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f20220b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public com.bumptech.glide.f f20221c;

    /* renamed from: d, reason: collision with root package name */
    public Object f20222d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f20223f;

    /* renamed from: g, reason: collision with root package name */
    public Class f20224g;

    /* renamed from: h, reason: collision with root package name */
    public i f20225h;

    /* renamed from: i, reason: collision with root package name */
    public x3.f f20226i;

    /* renamed from: j, reason: collision with root package name */
    public t4.c f20227j;

    /* renamed from: k, reason: collision with root package name */
    public Class f20228k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f20229l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f20230m;

    /* renamed from: n, reason: collision with root package name */
    public x3.c f20231n;

    /* renamed from: o, reason: collision with root package name */
    public Priority f20232o;

    /* renamed from: p, reason: collision with root package name */
    public h f20233p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f20234q;
    public boolean r;

    public final ArrayList a() {
        boolean z5 = this.f20230m;
        ArrayList arrayList = this.f20220b;
        if (!z5) {
            this.f20230m = true;
            arrayList.clear();
            ArrayList b3 = b();
            int size = b3.size();
            for (int i3 = 0; i3 < size; i3++) {
                d4.p pVar = (d4.p) b3.get(i3);
                if (!arrayList.contains(pVar.f12280a)) {
                    arrayList.add(pVar.f12280a);
                }
                int i10 = 0;
                while (true) {
                    List list = pVar.f12281b;
                    if (i10 < list.size()) {
                        if (!arrayList.contains(list.get(i10))) {
                            arrayList.add(list.get(i10));
                        }
                        i10++;
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList b() {
        boolean z5 = this.f20229l;
        ArrayList arrayList = this.f20219a;
        if (!z5) {
            this.f20229l = true;
            arrayList.clear();
            List f2 = this.f20221c.f6917b.f(this.f20222d);
            int size = f2.size();
            for (int i3 = 0; i3 < size; i3++) {
                d4.p a3 = ((d4.q) f2.get(i3)).a(this.f20222d, this.e, this.f20223f, this.f20226i);
                if (a3 != null) {
                    arrayList.add(a3);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final q c(Class cls) {
        q qVar;
        Class cls2;
        Class cls3;
        Class cls4;
        q qVar2;
        ArrayList arrayList;
        ArrayList arrayList2;
        l4.a aVar;
        Class cls5 = cls;
        com.bumptech.glide.g gVar = this.f20221c.f6917b;
        Class cls6 = this.f20224g;
        Class cls7 = this.f20228k;
        o4.b bVar = gVar.f6932i;
        t4.j jVar = (t4.j) bVar.f16731b.getAndSet(null);
        if (jVar == null) {
            jVar = new t4.j();
        }
        jVar.f18519a = cls5;
        jVar.f18520b = cls6;
        jVar.f18521c = cls7;
        synchronized (bVar.f16730a) {
            qVar = (q) bVar.f16730a.getOrDefault(jVar, null);
        }
        bVar.f16731b.set(jVar);
        gVar.f6932i.getClass();
        if (o4.b.f16729c.equals(qVar)) {
            return null;
        }
        if (qVar != null) {
            return qVar;
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList f2 = gVar.f6927c.f(cls5, cls6);
        int size = f2.size();
        int i3 = 0;
        while (i3 < size) {
            int i10 = i3 + 1;
            Class<?> cls8 = (Class) f2.get(i3);
            ArrayList b3 = gVar.f6929f.b(cls8, cls7);
            int size2 = b3.size();
            int i11 = 0;
            while (i11 < size2) {
                int i12 = i11 + 1;
                Class cls9 = (Class) b3.get(i11);
                o4.e eVar = gVar.f6927c;
                synchronized (eVar) {
                    arrayList = new ArrayList();
                    ArrayList arrayList4 = (ArrayList) eVar.f16737a;
                    int size3 = arrayList4.size();
                    int i13 = 0;
                    while (i13 < size3) {
                        Object obj = arrayList4.get(i13);
                        int i14 = i13 + 1;
                        String str = (String) obj;
                        ArrayList arrayList5 = b3;
                        List list = (List) ((HashMap) eVar.f16738b).get(str);
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                o4.d dVar = (o4.d) it.next();
                                Iterator it2 = it;
                                if (dVar.f16734a.isAssignableFrom(cls5) && cls8.isAssignableFrom(dVar.f16735b)) {
                                    arrayList.add(dVar.f16736c);
                                }
                                it = it2;
                            }
                        }
                        b3 = arrayList5;
                        i13 = i14;
                    }
                    arrayList2 = b3;
                }
                l4.c cVar = gVar.f6929f;
                synchronized (cVar) {
                    if (!cls9.isAssignableFrom(cls8)) {
                        ArrayList arrayList6 = cVar.f15766a;
                        int size4 = arrayList6.size();
                        int i15 = 0;
                        while (i15 < size4) {
                            Object obj2 = arrayList6.get(i15);
                            i15++;
                            l4.b bVar2 = (l4.b) obj2;
                            ArrayList arrayList7 = arrayList6;
                            if (bVar2.f15763a.isAssignableFrom(cls8) && cls9.isAssignableFrom(bVar2.f15764b)) {
                                aVar = bVar2.f15765c;
                            } else {
                                cls5 = cls;
                                arrayList6 = arrayList7;
                            }
                        }
                        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls8 + " to " + cls9);
                    }
                    aVar = l4.d.f15767b;
                }
                arrayList3.add(new g(cls5, cls8, cls9, arrayList, aVar, gVar.f6933j));
                cls5 = cls;
                size2 = size2;
                i11 = i12;
                b3 = arrayList2;
            }
            cls5 = cls;
            i3 = i10;
        }
        if (arrayList3.isEmpty()) {
            cls2 = cls;
            cls3 = cls6;
            cls4 = cls7;
            qVar2 = null;
        } else {
            cls2 = cls;
            cls3 = cls6;
            cls4 = cls7;
            qVar2 = new q(cls2, cls3, cls4, arrayList3, gVar.f6933j);
        }
        o4.b bVar3 = gVar.f6932i;
        synchronized (bVar3.f16730a) {
            bVar3.f16730a.put(new t4.j(cls2, cls3, cls4), qVar2 != null ? qVar2 : o4.b.f16729c);
        }
        return qVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
    
        r1 = r5.f16728b;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final x3.a d(java.lang.Object r8) {
        /*
            r7 = this;
            com.bumptech.glide.f r0 = r7.f20221c
            com.bumptech.glide.g r0 = r0.f6917b
            n.m0 r0 = r0.f6926b
            java.lang.Class r1 = r8.getClass()
            monitor-enter(r0)
            java.lang.Object r2 = r0.f16254b     // Catch: java.lang.Throwable -> L2a
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch: java.lang.Throwable -> L2a
            int r3 = r2.size()     // Catch: java.lang.Throwable -> L2a
            r4 = 0
        L14:
            if (r4 >= r3) goto L2c
            java.lang.Object r5 = r2.get(r4)     // Catch: java.lang.Throwable -> L2a
            int r4 = r4 + 1
            o4.a r5 = (o4.a) r5     // Catch: java.lang.Throwable -> L2a
            java.lang.Class r6 = r5.f16727a     // Catch: java.lang.Throwable -> L2a
            boolean r6 = r6.isAssignableFrom(r1)     // Catch: java.lang.Throwable -> L2a
            if (r6 == 0) goto L14
            x3.a r1 = r5.f16728b     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r0)
            goto L2e
        L2a:
            r8 = move-exception
            goto L3b
        L2c:
            monitor-exit(r0)
            r1 = 0
        L2e:
            if (r1 == 0) goto L31
            return r1
        L31:
            com.bumptech.glide.Registry$NoSourceEncoderAvailableException r0 = new com.bumptech.glide.Registry$NoSourceEncoderAvailableException
            java.lang.Class r8 = r8.getClass()
            r0.<init>(r8)
            throw r0
        L3b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: z3.f.d(java.lang.Object):x3.a");
    }

    public final x3.i e(Class cls) {
        x3.i iVar = (x3.i) this.f20227j.getOrDefault(cls, null);
        if (iVar == null) {
            Iterator it = ((m0.h) this.f20227j.entrySet()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    iVar = (x3.i) entry.getValue();
                    break;
                }
            }
        }
        if (iVar != null) {
            return iVar;
        }
        if (!this.f20227j.isEmpty() || !this.f20234q) {
            return f4.c.f12663b;
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }
}
