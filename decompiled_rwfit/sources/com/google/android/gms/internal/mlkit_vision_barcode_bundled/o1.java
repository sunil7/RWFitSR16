package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class o1 extends AbstractMap {

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f9807g = 0;

    /* renamed from: a, reason: collision with root package name */
    public Object[] f9808a;

    /* renamed from: b, reason: collision with root package name */
    public int f9809b;

    /* renamed from: c, reason: collision with root package name */
    public Map f9810c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f9811d;
    public volatile r1 e;

    /* renamed from: f, reason: collision with root package name */
    public Map f9812f;

    public o1() {
        Map map = Collections.EMPTY_MAP;
        this.f9810c = map;
        this.f9812f = map;
    }

    public final Set a() {
        return this.f9810c.isEmpty() ? Collections.EMPTY_SET : this.f9810c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        g();
        int d5 = d(comparable);
        if (d5 >= 0) {
            return ((p1) this.f9808a[d5]).setValue(obj);
        }
        g();
        if (this.f9808a == null) {
            this.f9808a = new Object[16];
        }
        int i3 = -(d5 + 1);
        if (i3 >= 16) {
            return f().put(comparable, obj);
        }
        if (this.f9809b == 16) {
            p1 p1Var = (p1) this.f9808a[15];
            this.f9809b = 15;
            f().put(p1Var.f9813a, p1Var.f9814b);
        }
        Object[] objArr = this.f9808a;
        int length = objArr.length;
        System.arraycopy(objArr, i3, objArr, i3 + 1, 15 - i3);
        this.f9808a[i3] = new p1(this, comparable, obj);
        this.f9809b++;
        return null;
    }

    public final p1 c(int i3) {
        if (i3 < this.f9809b) {
            return (p1) this.f9808a[i3];
        }
        throw new ArrayIndexOutOfBoundsException(i3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        g();
        if (this.f9809b != 0) {
            this.f9808a = null;
            this.f9809b = 0;
        }
        if (this.f9810c.isEmpty()) {
            return;
        }
        this.f9810c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return d(comparable) >= 0 || this.f9810c.containsKey(comparable);
    }

    public final int d(Comparable comparable) {
        int i3 = this.f9809b;
        int i10 = i3 - 1;
        int i11 = 0;
        if (i10 >= 0) {
            int compareTo = comparable.compareTo(((p1) this.f9808a[i10]).f9813a);
            if (compareTo > 0) {
                return -(i3 + 1);
            }
            if (compareTo == 0) {
                return i10;
            }
        }
        while (i11 <= i10) {
            int i12 = (i11 + i10) / 2;
            int compareTo2 = comparable.compareTo(((p1) this.f9808a[i12]).f9813a);
            if (compareTo2 < 0) {
                i10 = i12 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i12;
                }
                i11 = i12 + 1;
            }
        }
        return -(i11 + 1);
    }

    public final Object e(int i3) {
        g();
        Object[] objArr = this.f9808a;
        Object obj = ((p1) objArr[i3]).f9814b;
        System.arraycopy(objArr, i3 + 1, objArr, i3, (this.f9809b - i3) - 1);
        this.f9809b--;
        if (!this.f9810c.isEmpty()) {
            Iterator it = f().entrySet().iterator();
            Object[] objArr2 = this.f9808a;
            int i10 = this.f9809b;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i10] = new p1(this, (Comparable) entry.getKey(), entry.getValue());
            this.f9809b++;
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.e == null) {
            this.e = new r1(this);
        }
        return this.e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o1)) {
            return super.equals(obj);
        }
        o1 o1Var = (o1) obj;
        int size = size();
        if (size == o1Var.size()) {
            int i3 = this.f9809b;
            if (i3 != o1Var.f9809b) {
                return entrySet().equals(o1Var.entrySet());
            }
            for (int i10 = 0; i10 < i3; i10++) {
                if (c(i10).equals(o1Var.c(i10))) {
                }
            }
            if (i3 != size) {
                return this.f9810c.equals(o1Var.f9810c);
            }
            return true;
        }
        return false;
    }

    public final SortedMap f() {
        g();
        if (this.f9810c.isEmpty() && !(this.f9810c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f9810c = treeMap;
            this.f9812f = treeMap.descendingMap();
        }
        return (SortedMap) this.f9810c;
    }

    public final void g() {
        if (this.f9811d) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int d5 = d(comparable);
        return d5 >= 0 ? ((p1) this.f9808a[d5]).f9814b : this.f9810c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i3 = this.f9809b;
        int i10 = 0;
        for (int i11 = 0; i11 < i3; i11++) {
            i10 += this.f9808a[i11].hashCode();
        }
        return this.f9810c.size() > 0 ? this.f9810c.hashCode() + i10 : i10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int d5 = d(comparable);
        if (d5 >= 0) {
            return e(d5);
        }
        if (this.f9810c.isEmpty()) {
            return null;
        }
        return this.f9810c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f9810c.size() + this.f9809b;
    }
}
