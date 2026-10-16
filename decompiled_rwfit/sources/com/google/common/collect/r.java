package com.google.common.collect;

import com.google.android.gms.internal.mlkit_vision_barcode.jb;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public abstract class r extends s implements Map {
    @Override // java.util.Map
    public void clear() {
        delegate().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return delegate().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return delegate().containsValue(obj);
    }

    @Override // com.google.common.collect.s
    public abstract Map delegate();

    @Override // java.util.Map
    public Set<Map.Entry<Object, Object>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Map
    public Object get(@NullableDecl Object obj) {
        return delegate().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // java.util.Map
    public Set<Object> keySet() {
        return delegate().keySet();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    public Object put(Object obj, Object obj2) {
        return delegate().put(obj, obj2);
    }

    @Override // java.util.Map
    public void putAll(Map<Object, Object> map) {
        delegate().putAll(map);
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    public Object remove(Object obj) {
        return delegate().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return delegate().size();
    }

    public void standardClear() {
        Iterator<Map.Entry<Object, Object>> it = entrySet().iterator();
        it.getClass();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public boolean standardContainsKey(@NullableDecl Object obj) {
        return h.g(new o1(entrySet().iterator()), obj);
    }

    public boolean standardContainsValue(@NullableDecl Object obj) {
        return h.g(new p1(entrySet().iterator()), obj);
    }

    public boolean standardEquals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public int standardHashCode() {
        return h.m(entrySet());
    }

    public boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    public void standardPutAll(Map<Object, Object> map) {
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Object standardRemove(@NullableDecl Object obj) {
        Iterator<Map.Entry<Object, Object>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Object, Object> next = it.next();
            if (jb.a(next.getKey(), obj)) {
                Object value = next.getValue();
                it.remove();
                return value;
            }
        }
        return null;
    }

    public String standardToString() {
        return h.p(this);
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return delegate().values();
    }
}
