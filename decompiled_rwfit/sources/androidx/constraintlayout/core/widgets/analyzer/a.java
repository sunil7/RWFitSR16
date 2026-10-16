package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class a implements r0.d {

    /* renamed from: d, reason: collision with root package name */
    public final h f1617d;

    /* renamed from: f, reason: collision with root package name */
    public int f1618f;

    /* renamed from: g, reason: collision with root package name */
    public int f1619g;

    /* renamed from: a, reason: collision with root package name */
    public h f1614a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1615b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1616c = false;
    public DependencyNode$Type e = DependencyNode$Type.UNKNOWN;

    /* renamed from: h, reason: collision with root package name */
    public int f1620h = 1;

    /* renamed from: i, reason: collision with root package name */
    public b f1621i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1622j = false;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f1623k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f1624l = new ArrayList();

    public a(h hVar) {
        this.f1617d = hVar;
    }

    @Override // r0.d
    public final void a(r0.d dVar) {
        ArrayList arrayList = this.f1624l;
        int size = arrayList.size();
        int i3 = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            if (!((a) obj).f1622j) {
                return;
            }
        }
        this.f1616c = true;
        h hVar = this.f1614a;
        if (hVar != null) {
            hVar.a(this);
        }
        if (this.f1615b) {
            this.f1617d.a(this);
            return;
        }
        int size2 = arrayList.size();
        a aVar = null;
        int i11 = 0;
        while (i11 < size2) {
            Object obj2 = arrayList.get(i11);
            i11++;
            a aVar2 = (a) obj2;
            if (!(aVar2 instanceof b)) {
                i3++;
                aVar = aVar2;
            }
        }
        if (aVar != null && i3 == 1 && aVar.f1622j) {
            b bVar = this.f1621i;
            if (bVar != null) {
                if (!bVar.f1622j) {
                    return;
                } else {
                    this.f1618f = this.f1620h * bVar.f1619g;
                }
            }
            d(aVar.f1619g + this.f1618f);
        }
        h hVar2 = this.f1614a;
        if (hVar2 != null) {
            hVar2.a(this);
        }
    }

    public final void b(h hVar) {
        this.f1623k.add(hVar);
        if (this.f1622j) {
            hVar.a(hVar);
        }
    }

    public final void c() {
        this.f1624l.clear();
        this.f1623k.clear();
        this.f1622j = false;
        this.f1619g = 0;
        this.f1616c = false;
        this.f1615b = false;
    }

    public void d(int i3) {
        if (this.f1622j) {
            return;
        }
        this.f1622j = true;
        this.f1619g = i3;
        ArrayList arrayList = this.f1623k;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            r0.d dVar = (r0.d) obj;
            dVar.a(dVar);
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f1617d.f1632b.i0);
        sb2.append(":");
        sb2.append(this.e);
        sb2.append("(");
        sb2.append(this.f1622j ? Integer.valueOf(this.f1619g) : "unresolved");
        sb2.append(") <t=");
        sb2.append(this.f1624l.size());
        sb2.append(":d=");
        sb2.append(this.f1623k.size());
        sb2.append(">");
        return sb2.toString();
    }
}
