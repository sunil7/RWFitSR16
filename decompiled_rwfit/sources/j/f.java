package j;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class f implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public c f15158a;

    /* renamed from: b, reason: collision with root package name */
    public c f15159b;

    /* renamed from: c, reason: collision with root package name */
    public final WeakHashMap f15160c = new WeakHashMap();

    /* renamed from: d, reason: collision with root package name */
    public int f15161d = 0;

    public c a(Object obj) {
        c cVar = this.f15158a;
        while (cVar != null && !cVar.f15151a.equals(obj)) {
            cVar = cVar.f15153c;
        }
        return cVar;
    }

    public Object c(Object obj, Object obj2) {
        c a3 = a(obj);
        if (a3 != null) {
            return a3.f15152b;
        }
        c cVar = new c(obj, obj2);
        this.f15161d++;
        c cVar2 = this.f15159b;
        if (cVar2 == null) {
            this.f15158a = cVar;
            this.f15159b = cVar;
            return null;
        }
        cVar2.f15153c = cVar;
        cVar.f15154d = cVar2;
        this.f15159b = cVar;
        return null;
    }

    public Object d(Object obj) {
        c a3 = a(obj);
        if (a3 == null) {
            return null;
        }
        this.f15161d--;
        WeakHashMap weakHashMap = this.f15160c;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((e) it.next()).a(a3);
            }
        }
        c cVar = a3.f15154d;
        if (cVar != null) {
            cVar.f15153c = a3.f15153c;
        } else {
            this.f15158a = a3.f15153c;
        }
        c cVar2 = a3.f15153c;
        if (cVar2 != null) {
            cVar2.f15154d = cVar;
        } else {
            this.f15159b = cVar;
        }
        a3.f15153c = null;
        a3.f15154d = null;
        return a3.f15152b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0048, code lost:
    
        if (r3.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0050, code lost:
    
        if (((j.b) r7).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0052, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0053, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof j.f
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            j.f r7 = (j.f) r7
            int r1 = r6.f15161d
            int r3 = r7.f15161d
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            j.b r3 = (j.b) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            j.b r4 = (j.b) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            j.b r7 = (j.b) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            return r0
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j.f.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = iterator();
        int i3 = 0;
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return i3;
            }
            i3 += ((Map.Entry) bVar.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        b bVar = new b(this.f15158a, this.f15159b, 0);
        this.f15160c.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                sb2.append("]");
                return sb2.toString();
            }
            sb2.append(((Map.Entry) bVar.next()).toString());
            if (bVar.hasNext()) {
                sb2.append(", ");
            }
        }
    }
}
