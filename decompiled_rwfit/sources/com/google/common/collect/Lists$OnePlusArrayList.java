package com.google.common.collect;

import com.google.android.gms.internal.mlkit_vision_barcode.df;
import com.google.android.gms.internal.mlkit_vision_barcode.kb;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
class Lists$OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
    private static final long serialVersionUID = 0;

    @NullableDecl
    final E first;
    final E[] rest;

    public Lists$OnePlusArrayList(@NullableDecl E e, E[] eArr) {
        this.first = e;
        eArr.getClass();
        this.rest = eArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i3) {
        kb.d(i3, size());
        return i3 == 0 ? this.first : this.rest[i3 - 1];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return df.a(this.rest.length + 1);
    }
}
