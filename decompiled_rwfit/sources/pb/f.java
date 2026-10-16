package pb;

import android.util.Log;
import com.google.android.gms.internal.mlkit_vision_barcode.dg;
import com.google.firebase.components.InvalidRegistrarException;
import com.google.firebase.components.MissingDependencyException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class f extends dg {
    public final j e;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f17507b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f17508c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f17509d = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReference f17510f = new AtomicReference();

    public f(ArrayList arrayList, ArrayList arrayList2) {
        j jVar = new j();
        new HashMap();
        jVar.f17519a = new ArrayDeque();
        this.e = jVar;
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(a.b(jVar, j.class, ub.b.class, ub.a.class));
        int i3 = 0;
        arrayList3.add(a.b(this, f.class, new Class[0]));
        int size = arrayList2.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList2.get(i10);
            i10++;
            a aVar = (a) obj;
            if (aVar != null) {
                arrayList3.add(aVar);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        int size2 = arrayList.size();
        int i11 = 0;
        while (i11 < size2) {
            Object obj2 = arrayList.get(i11);
            i11++;
            arrayList4.add(obj2);
        }
        ArrayList arrayList5 = new ArrayList();
        synchronized (this) {
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                try {
                    c cVar = (c) ((vb.a) it.next()).get();
                    if (cVar != null) {
                        arrayList3.addAll(cVar.a());
                        it.remove();
                    }
                } catch (InvalidRegistrarException e) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e);
                }
            }
            if (this.f17507b.isEmpty()) {
                com.google.android.gms.internal.mlkit_vision_common.i.a(arrayList3);
            } else {
                ArrayList arrayList6 = new ArrayList(this.f17507b.keySet());
                arrayList6.addAll(arrayList3);
                com.google.android.gms.internal.mlkit_vision_common.i.a(arrayList6);
            }
            int size3 = arrayList3.size();
            int i12 = 0;
            while (i12 < size3) {
                Object obj3 = arrayList3.get(i12);
                i12++;
                final a aVar2 = (a) obj3;
                this.f17507b.put(aVar2, new k(new vb.a(this, aVar2) { // from class: pb.d

                    /* renamed from: a, reason: collision with root package name */
                    public final f f17502a;

                    /* renamed from: b, reason: collision with root package name */
                    public final a f17503b;

                    {
                        this.f17502a = this;
                        this.f17503b = aVar2;
                    }

                    @Override // vb.a
                    public final Object get() {
                        a aVar3 = this.f17503b;
                        return aVar3.f17501d.i(new p(aVar3, this.f17502a));
                    }
                }));
            }
            arrayList5.addAll(h(arrayList3));
            arrayList5.addAll(i());
            g();
        }
        int size4 = arrayList5.size();
        while (i3 < size4) {
            Object obj4 = arrayList5.get(i3);
            i3++;
            ((Runnable) obj4).run();
        }
        Boolean bool = (Boolean) this.f17510f.get();
        if (bool != null) {
            f(this.f17507b, bool.booleanValue());
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.dg
    public final synchronized vb.a b(Class cls) {
        return (vb.a) this.f17508c.get(cls);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.dg
    public final synchronized vb.a d(Class cls) {
        l lVar = (l) this.f17509d.get(cls);
        if (lVar != null) {
            return lVar;
        }
        return e.f17504b;
    }

    public final void f(HashMap hashMap, boolean z5) {
        ArrayDeque arrayDeque;
        for (Map.Entry entry : hashMap.entrySet()) {
            a aVar = (a) entry.getKey();
            aVar.getClass();
        }
        j jVar = this.e;
        synchronized (jVar) {
            arrayDeque = jVar.f17519a;
            if (arrayDeque != null) {
                jVar.f17519a = null;
            } else {
                arrayDeque = null;
            }
        }
        if (arrayDeque != null) {
            Iterator it = arrayDeque.iterator();
            if (it.hasNext()) {
                throw android.support.v4.media.session.e.d(it);
            }
        }
    }

    public final void g() {
        for (a aVar : this.f17507b.keySet()) {
            for (i iVar : aVar.f17499b) {
                if (iVar.f17517b == 2 && !this.f17509d.containsKey(iVar.f17516a)) {
                    HashMap hashMap = this.f17509d;
                    Class cls = iVar.f17516a;
                    Set set = Collections.EMPTY_SET;
                    l lVar = new l();
                    lVar.f17524b = null;
                    lVar.f17523a = Collections.newSetFromMap(new ConcurrentHashMap());
                    lVar.f17523a.addAll(set);
                    hashMap.put(cls, lVar);
                } else if (this.f17508c.containsKey(iVar.f17516a)) {
                    continue;
                } else {
                    int i3 = iVar.f17517b;
                    if (i3 == 1) {
                        throw new MissingDependencyException("Unsatisfied dependency for component " + aVar + ": " + iVar.f17516a);
                    }
                    if (i3 != 2) {
                        HashMap hashMap2 = this.f17508c;
                        Class cls2 = iVar.f17516a;
                        m mVar = m.f17525a;
                        e eVar = e.f17505c;
                        n nVar = new n();
                        nVar.f17526a = mVar;
                        nVar.f17527b = eVar;
                        hashMap2.put(cls2, nVar);
                    }
                }
            }
        }
    }

    public final ArrayList h(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            a aVar = (a) obj;
            if (aVar.f17500c == 0) {
                vb.a aVar2 = (vb.a) this.f17507b.get(aVar);
                for (Class cls : aVar.f17498a) {
                    HashMap hashMap = this.f17508c;
                    if (hashMap.containsKey(cls)) {
                        arrayList2.add(new ia.j((n) ((vb.a) hashMap.get(cls)), 13, aVar2, false));
                    } else {
                        hashMap.put(cls, aVar2);
                    }
                }
            }
        }
        return arrayList2;
    }

    public final ArrayList i() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : this.f17507b.entrySet()) {
            a aVar = (a) entry.getKey();
            if (aVar.f17500c != 0) {
                vb.a aVar2 = (vb.a) entry.getValue();
                for (Class cls : aVar.f17498a) {
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, new HashSet());
                    }
                    ((Set) hashMap.get(cls)).add(aVar2);
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            Object key = entry2.getKey();
            HashMap hashMap2 = this.f17509d;
            if (hashMap2.containsKey(key)) {
                l lVar = (l) hashMap2.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new ia.j(lVar, 14, (vb.a) it.next(), false));
                }
            } else {
                Class cls2 = (Class) entry2.getKey();
                Set set = (Set) ((Collection) entry2.getValue());
                l lVar2 = new l();
                lVar2.f17524b = null;
                lVar2.f17523a = Collections.newSetFromMap(new ConcurrentHashMap());
                lVar2.f17523a.addAll(set);
                hashMap2.put(cls2, lVar2);
            }
        }
        return arrayList;
    }
}
