package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: a, reason: collision with root package name */
    public static final androidx.viewpager2.widget.a f11169a = new androidx.viewpager2.widget.a(6);
    Comparator<? super K> comparator;
    private f entrySet;
    final h header;
    private g keySet;
    int modCount;
    h root;
    int size;

    public LinkedTreeMap() {
        this(f11169a);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public final void a(h hVar, boolean z5) {
        while (hVar != null) {
            h hVar2 = hVar.f11187b;
            h hVar3 = hVar.f11188c;
            int i3 = hVar2 != null ? hVar2.f11192h : 0;
            int i10 = hVar3 != null ? hVar3.f11192h : 0;
            int i11 = i3 - i10;
            if (i11 == -2) {
                h hVar4 = hVar3.f11187b;
                h hVar5 = hVar3.f11188c;
                int i12 = (hVar4 != null ? hVar4.f11192h : 0) - (hVar5 != null ? hVar5.f11192h : 0);
                if (i12 == -1 || (i12 == 0 && !z5)) {
                    c(hVar);
                } else {
                    d(hVar3);
                    c(hVar);
                }
                if (z5) {
                    return;
                }
            } else if (i11 == 2) {
                h hVar6 = hVar2.f11187b;
                h hVar7 = hVar2.f11188c;
                int i13 = (hVar6 != null ? hVar6.f11192h : 0) - (hVar7 != null ? hVar7.f11192h : 0);
                if (i13 == 1 || (i13 == 0 && !z5)) {
                    d(hVar);
                } else {
                    c(hVar2);
                    d(hVar);
                }
                if (z5) {
                    return;
                }
            } else if (i11 == 0) {
                hVar.f11192h = i3 + 1;
                if (z5) {
                    return;
                }
            } else {
                hVar.f11192h = Math.max(i3, i10) + 1;
                if (!z5) {
                    return;
                }
            }
            hVar = hVar.f11186a;
        }
    }

    public final void b(h hVar, h hVar2) {
        h hVar3 = hVar.f11186a;
        hVar.f11186a = null;
        if (hVar2 != null) {
            hVar2.f11186a = hVar3;
        }
        if (hVar3 == null) {
            this.root = hVar2;
        } else if (hVar3.f11187b == hVar) {
            hVar3.f11187b = hVar2;
        } else {
            hVar3.f11188c = hVar2;
        }
    }

    public final void c(h hVar) {
        h hVar2 = hVar.f11187b;
        h hVar3 = hVar.f11188c;
        h hVar4 = hVar3.f11187b;
        h hVar5 = hVar3.f11188c;
        hVar.f11188c = hVar4;
        if (hVar4 != null) {
            hVar4.f11186a = hVar;
        }
        b(hVar, hVar3);
        hVar3.f11187b = hVar;
        hVar.f11186a = hVar3;
        int max = Math.max(hVar2 != null ? hVar2.f11192h : 0, hVar4 != null ? hVar4.f11192h : 0) + 1;
        hVar.f11192h = max;
        hVar3.f11192h = Math.max(max, hVar5 != null ? hVar5.f11192h : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        h hVar = this.header;
        hVar.e = hVar;
        hVar.f11189d = hVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    public final void d(h hVar) {
        h hVar2 = hVar.f11187b;
        h hVar3 = hVar.f11188c;
        h hVar4 = hVar2.f11187b;
        h hVar5 = hVar2.f11188c;
        hVar.f11187b = hVar5;
        if (hVar5 != null) {
            hVar5.f11186a = hVar;
        }
        b(hVar, hVar2);
        hVar2.f11188c = hVar;
        hVar.f11186a = hVar2;
        int max = Math.max(hVar3 != null ? hVar3.f11192h : 0, hVar5 != null ? hVar5.f11192h : 0) + 1;
        hVar.f11192h = max;
        hVar2.f11192h = Math.max(max, hVar4 != null ? hVar4.f11192h : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        f fVar = this.entrySet;
        if (fVar != null) {
            return fVar;
        }
        f fVar2 = new f(this);
        this.entrySet = fVar2;
        return fVar2;
    }

    public h find(K k10, boolean z5) {
        int i3;
        h hVar;
        Comparator<? super K> comparator = this.comparator;
        h hVar2 = this.root;
        androidx.viewpager2.widget.a aVar = f11169a;
        if (hVar2 != null) {
            Comparable comparable = comparator == aVar ? (Comparable) k10 : null;
            while (true) {
                a1.g gVar = (Object) hVar2.f11190f;
                i3 = comparable != null ? comparable.compareTo(gVar) : comparator.compare(k10, gVar);
                if (i3 == 0) {
                    return hVar2;
                }
                h hVar3 = i3 < 0 ? hVar2.f11187b : hVar2.f11188c;
                if (hVar3 == null) {
                    break;
                }
                hVar2 = hVar3;
            }
        } else {
            i3 = 0;
        }
        if (!z5) {
            return null;
        }
        h hVar4 = this.header;
        if (hVar2 != null) {
            hVar = new h(hVar2, k10, hVar4, hVar4.e);
            if (i3 < 0) {
                hVar2.f11187b = hVar;
            } else {
                hVar2.f11188c = hVar;
            }
            a(hVar2, true);
        } else {
            if (comparator == aVar && !(k10 instanceof Comparable)) {
                throw new ClassCastException(k10.getClass().getName().concat(" is not Comparable"));
            }
            hVar = new h(hVar2, k10, hVar4, hVar4.e);
            this.root = hVar;
        }
        this.size++;
        this.modCount++;
        return hVar;
    }

    public h findByEntry(Map.Entry<?, ?> entry) {
        h findByObject = findByObject(entry.getKey());
        if (findByObject == null) {
            return null;
        }
        Object obj = findByObject.f11191g;
        Object value = entry.getValue();
        if (obj == value || (obj != null && obj.equals(value))) {
            return findByObject;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h findByObject(Object obj) {
        if (obj != 0) {
            try {
                return find(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        h findByObject = findByObject(obj);
        if (findByObject != null) {
            return (V) findByObject.f11191g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        g gVar = this.keySet;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this);
        this.keySet = gVar2;
        return gVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v6) {
        if (k10 == null) {
            throw new NullPointerException("key == null");
        }
        h find = find(k10, true);
        V v9 = (V) find.f11191g;
        find.f11191g = v6;
        return v9;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        h removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return (V) removeInternalByKey.f11191g;
        }
        return null;
    }

    public void removeInternal(h hVar, boolean z5) {
        h hVar2;
        h hVar3;
        int i3;
        if (z5) {
            h hVar4 = hVar.e;
            hVar4.f11189d = hVar.f11189d;
            hVar.f11189d.e = hVar4;
        }
        h hVar5 = hVar.f11187b;
        h hVar6 = hVar.f11188c;
        h hVar7 = hVar.f11186a;
        int i10 = 0;
        if (hVar5 == null || hVar6 == null) {
            if (hVar5 != null) {
                b(hVar, hVar5);
                hVar.f11187b = null;
            } else if (hVar6 != null) {
                b(hVar, hVar6);
                hVar.f11188c = null;
            } else {
                b(hVar, null);
            }
            a(hVar7, false);
            this.size--;
            this.modCount++;
            return;
        }
        if (hVar5.f11192h > hVar6.f11192h) {
            h hVar8 = hVar5.f11188c;
            while (true) {
                h hVar9 = hVar8;
                hVar3 = hVar5;
                hVar5 = hVar9;
                if (hVar5 == null) {
                    break;
                } else {
                    hVar8 = hVar5.f11188c;
                }
            }
        } else {
            h hVar10 = hVar6.f11187b;
            while (true) {
                hVar2 = hVar6;
                hVar6 = hVar10;
                if (hVar6 == null) {
                    break;
                } else {
                    hVar10 = hVar6.f11187b;
                }
            }
            hVar3 = hVar2;
        }
        removeInternal(hVar3, false);
        h hVar11 = hVar.f11187b;
        if (hVar11 != null) {
            i3 = hVar11.f11192h;
            hVar3.f11187b = hVar11;
            hVar11.f11186a = hVar3;
            hVar.f11187b = null;
        } else {
            i3 = 0;
        }
        h hVar12 = hVar.f11188c;
        if (hVar12 != null) {
            i10 = hVar12.f11192h;
            hVar3.f11188c = hVar12;
            hVar12.f11186a = hVar3;
            hVar.f11188c = null;
        }
        hVar3.f11192h = Math.max(i3, i10) + 1;
        b(hVar, hVar3);
    }

    public h removeInternalByKey(Object obj) {
        h findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new h();
        this.comparator = comparator == null ? f11169a : comparator;
    }
}
