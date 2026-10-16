package a2;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class m extends AbstractList {

    /* renamed from: j, reason: collision with root package name */
    public static final ArrayList f62j = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public int f63a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f64b;

    /* renamed from: c, reason: collision with root package name */
    public int f65c;

    /* renamed from: d, reason: collision with root package name */
    public int f66d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f67f;

    /* renamed from: g, reason: collision with root package name */
    public int f68g;

    /* renamed from: h, reason: collision with root package name */
    public int f69h;

    /* renamed from: i, reason: collision with root package name */
    public int f70i;

    public m() {
        this.f63a = 0;
        this.f64b = new ArrayList();
        this.f65c = 0;
        this.f66d = 0;
        this.e = 0;
        this.f67f = 0;
        this.f68g = 1;
        this.f69h = 0;
        this.f70i = 0;
    }

    public final int a() {
        int i3 = this.f63a;
        ArrayList arrayList = this.f64b;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            List list = (List) arrayList.get(i10);
            if (list != null && list != f62j) {
                break;
            }
            i3 += this.f68g;
        }
        return i3;
    }

    public final int c() {
        int i3 = this.f65c;
        ArrayList arrayList = this.f64b;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            List list = (List) arrayList.get(size);
            if (list != null && list != f62j) {
                break;
            }
            i3 += this.f68g;
        }
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i3) {
        int i10;
        if (i3 < 0 || i3 >= size()) {
            StringBuilder q5 = android.support.v4.media.session.e.q(i3, "Index: ", ", Size: ");
            q5.append(size());
            throw new IndexOutOfBoundsException(q5.toString());
        }
        int i11 = i3 - this.f63a;
        if (i11 >= 0 && i11 < this.f67f) {
            int i12 = this.f68g;
            ArrayList arrayList = this.f64b;
            if (i12 > 0) {
                i10 = i11 / i12;
                i11 %= i12;
            } else {
                int size = arrayList.size();
                i10 = 0;
                while (i10 < size) {
                    int size2 = ((List) arrayList.get(i10)).size();
                    if (size2 > i11) {
                        break;
                    }
                    i11 -= size2;
                    i10++;
                }
            }
            List list = (List) arrayList.get(i10);
            if (list != null && list.size() != 0) {
                return list.get(i11);
            }
        }
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f63a + this.f67f + this.f65c;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        StringBuilder sb2 = new StringBuilder("leading " + this.f63a + ", storage " + this.f67f + ", trailing " + this.f65c);
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f64b;
            if (i3 >= arrayList.size()) {
                return sb2.toString();
            }
            sb2.append(" ");
            sb2.append(arrayList.get(i3));
            i3++;
        }
    }

    public m(m mVar) {
        this.f63a = mVar.f63a;
        this.f64b = new ArrayList(mVar.f64b);
        this.f65c = mVar.f65c;
        this.f66d = mVar.f66d;
        this.e = mVar.e;
        this.f67f = mVar.f67f;
        this.f68g = mVar.f68g;
        this.f69h = mVar.f69h;
        this.f70i = mVar.f70i;
    }
}
