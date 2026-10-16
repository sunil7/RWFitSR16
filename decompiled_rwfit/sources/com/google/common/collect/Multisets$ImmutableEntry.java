package com.google.common.collect;

import com.autonavi.aps.amapapi.config.Const;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
class Multisets$ImmutableEntry<E> extends t1 implements Serializable {
    private static final long serialVersionUID = 0;
    private final int count;

    @NullableDecl
    private final E element;

    public Multisets$ImmutableEntry(@NullableDecl E e, int i3) {
        this.element = e;
        this.count = i3;
        h.d(i3, Const.SP_KEY_CALL_LOC_COUNT);
    }

    @Override // com.google.common.collect.r1
    public final int getCount() {
        return this.count;
    }

    @Override // com.google.common.collect.r1
    @NullableDecl
    public final E getElement() {
        return this.element;
    }

    public Multisets$ImmutableEntry<E> nextInBucket() {
        return null;
    }
}
