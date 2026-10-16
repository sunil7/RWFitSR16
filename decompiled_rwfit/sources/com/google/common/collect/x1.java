package com.google.common.collect;

import com.google.android.gms.internal.mlkit_vision_barcode.lb;
import com.google.common.collect.MapMakerInternalMap;
import java.util.AbstractMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class x1 extends z1 {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicInteger f11148a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    public final AbstractMap f11149b;

    public x1() {
        AbstractMap create;
        o0 o0Var = new o0();
        MapMakerInternalMap.Strength strength = MapMakerInternalMap.Strength.WEAK;
        MapMakerInternalMap.Strength strength2 = o0Var.f11107d;
        if (strength2 != null) {
            throw new IllegalStateException(lb.a("Key strength was already set to %s", strength2));
        }
        strength.getClass();
        o0Var.f11107d = strength;
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            o0Var.f11104a = true;
        }
        if (o0Var.f11104a) {
            create = MapMakerInternalMap.create(o0Var);
        } else {
            int i3 = o0Var.f11105b;
            i3 = i3 == -1 ? 16 : i3;
            int i10 = o0Var.f11106c;
            create = new ConcurrentHashMap(i3, 0.75f, i10 == -1 ? 4 : i10);
        }
        this.f11149b = create;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.AbstractMap, java.util.Map, java.util.concurrent.ConcurrentMap] */
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        int identityHashCode = System.identityHashCode(obj);
        int identityHashCode2 = System.identityHashCode(obj2);
        if (identityHashCode != identityHashCode2) {
            return identityHashCode < identityHashCode2 ? -1 : 1;
        }
        ?? r02 = this.f11149b;
        Integer num = (Integer) r02.get(obj);
        AtomicInteger atomicInteger = this.f11148a;
        if (num == null) {
            num = Integer.valueOf(atomicInteger.getAndIncrement());
            Integer num2 = (Integer) r02.putIfAbsent(obj, num);
            if (num2 != null) {
                num = num2;
            }
        }
        Integer num3 = (Integer) r02.get(obj2);
        if (num3 == null) {
            num3 = Integer.valueOf(atomicInteger.getAndIncrement());
            Integer num4 = (Integer) r02.putIfAbsent(obj2, num3);
            if (num4 != null) {
                num3 = num4;
            }
        }
        int compareTo = num.compareTo(num3);
        if (compareTo != 0) {
            return compareTo;
        }
        throw new AssertionError();
    }

    public final String toString() {
        return "Ordering.arbitrary()";
    }
}
