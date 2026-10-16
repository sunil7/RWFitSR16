package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public abstract class q extends r implements ConcurrentMap {
    @Override // com.google.common.collect.r, com.google.common.collect.s
    public abstract ConcurrentMap delegate();

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public Object putIfAbsent(Object obj, Object obj2) {
        return delegate().putIfAbsent(obj, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean remove(Object obj, Object obj2) {
        return delegate().remove(obj, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public Object replace(Object obj, Object obj2) {
        return delegate().replace(obj, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(Object obj, Object obj2, Object obj3) {
        return delegate().replace(obj, obj2, obj3);
    }
}
