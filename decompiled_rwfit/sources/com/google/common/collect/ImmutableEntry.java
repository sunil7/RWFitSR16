package com.google.common.collect;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
class ImmutableEntry<K, V> extends d implements Serializable {
    private static final long serialVersionUID = 0;

    @NullableDecl
    final K key;

    @NullableDecl
    final V value;

    public ImmutableEntry(@NullableDecl K k10, @NullableDecl V v6) {
        this.key = k10;
        this.value = v6;
    }

    @Override // java.util.Map.Entry
    @NullableDecl
    public final K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    @NullableDecl
    public final V getValue() {
        return this.value;
    }

    @Override // com.google.common.collect.d, java.util.Map.Entry
    public final V setValue(V v6) {
        throw new UnsupportedOperationException();
    }
}
