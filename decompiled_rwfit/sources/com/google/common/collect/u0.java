package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public abstract class u0 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f11123a;

    /* renamed from: b, reason: collision with root package name */
    public int f11124b = -1;

    /* renamed from: c, reason: collision with root package name */
    public MapMakerInternalMap.Segment f11125c;

    /* renamed from: d, reason: collision with root package name */
    public AtomicReferenceArray f11126d;
    public v0 e;

    /* renamed from: f, reason: collision with root package name */
    public n1 f11127f;

    /* renamed from: g, reason: collision with root package name */
    public n1 f11128g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ MapMakerInternalMap f11129h;

    public u0(MapMakerInternalMap mapMakerInternalMap) {
        this.f11129h = mapMakerInternalMap;
        this.f11123a = mapMakerInternalMap.segments.length - 1;
        a();
    }

    public final void a() {
        this.f11127f = null;
        if (d() || e()) {
            return;
        }
        while (true) {
            int i3 = this.f11123a;
            if (i3 < 0) {
                return;
            }
            MapMakerInternalMap.Segment[] segmentArr = this.f11129h.segments;
            this.f11123a = i3 - 1;
            MapMakerInternalMap.Segment segment = segmentArr[i3];
            this.f11125c = segment;
            if (segment.count != 0) {
                this.f11126d = this.f11125c.table;
                this.f11124b = r0.length() - 1;
                if (e()) {
                    return;
                }
            }
        }
    }

    public final boolean b(v0 v0Var) {
        MapMakerInternalMap mapMakerInternalMap = this.f11129h;
        try {
            Object key = v0Var.getKey();
            Object liveValue = mapMakerInternalMap.getLiveValue(v0Var);
            if (liveValue == null) {
                this.f11125c.postReadCleanup();
                return false;
            }
            this.f11127f = new n1(mapMakerInternalMap, key, liveValue);
            this.f11125c.postReadCleanup();
            return true;
        } catch (Throwable th2) {
            this.f11125c.postReadCleanup();
            throw th2;
        }
    }

    public final n1 c() {
        n1 n1Var = this.f11127f;
        if (n1Var == null) {
            throw new NoSuchElementException();
        }
        this.f11128g = n1Var;
        a();
        return this.f11128g;
    }

    public final boolean d() {
        v0 v0Var = this.e;
        if (v0Var == null) {
            return false;
        }
        while (true) {
            this.e = v0Var.b();
            v0 v0Var2 = this.e;
            if (v0Var2 == null) {
                return false;
            }
            if (b(v0Var2)) {
                return true;
            }
            v0Var = this.e;
        }
    }

    public final boolean e() {
        while (true) {
            int i3 = this.f11124b;
            if (i3 < 0) {
                return false;
            }
            AtomicReferenceArray atomicReferenceArray = this.f11126d;
            this.f11124b = i3 - 1;
            v0 v0Var = (v0) atomicReferenceArray.get(i3);
            this.e = v0Var;
            if (v0Var != null && (b(v0Var) || d())) {
                return true;
            }
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11127f != null;
    }

    @Override // java.util.Iterator
    public Object next() {
        return c();
    }

    @Override // java.util.Iterator
    public final void remove() {
        h.e(this.f11128g != null);
        this.f11129h.remove(this.f11128g.f11100a);
        this.f11128g = null;
    }
}
