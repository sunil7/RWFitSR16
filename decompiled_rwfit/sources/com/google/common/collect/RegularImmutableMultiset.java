package com.google.common.collect;

import com.google.android.gms.internal.mlkit_vision_barcode.df;
import com.google.android.gms.internal.mlkit_vision_barcode.kb;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    static final RegularImmutableMultiset<Object> EMPTY;
    final transient w1 contents;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f11035d;
    public transient ImmutableSet e;

    public final class ElementSet extends IndexedImmutableSet<E> {
        public ElementSet(a2 a2Var) {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            return RegularImmutableMultiset.this.contains(obj);
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public E get(int i3) {
            w1 w1Var = RegularImmutableMultiset.this.contents;
            kb.d(i3, w1Var.f11141c);
            return (E) w1Var.f11139a[i3];
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return RegularImmutableMultiset.this.contents.f11141c;
        }
    }

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        public SerializedForm(s1 s1Var) {
            int size = s1Var.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i3 = 0;
            for (r1 r1Var : s1Var.entrySet()) {
                this.elements[i3] = r1Var.getElement();
                this.counts[i3] = r1Var.getCount();
                i3++;
            }
        }

        public Object readResolve() {
            int length = this.elements.length;
            w1 w1Var = new w1();
            w1Var.e(length);
            int i3 = 0;
            while (true) {
                Object[] objArr = this.elements;
                if (i3 >= objArr.length) {
                    break;
                }
                Object obj = objArr[i3];
                int i10 = this.counts[i3];
                if (i10 != 0) {
                    obj.getClass();
                    w1Var.f(w1Var.b(obj) + i10, obj);
                }
                i3++;
            }
            return w1Var.f11141c == 0 ? ImmutableMultiset.of() : new RegularImmutableMultiset(w1Var);
        }
    }

    static {
        w1 w1Var = new w1();
        w1Var.e(3);
        EMPTY = new RegularImmutableMultiset<>(w1Var);
    }

    public RegularImmutableMultiset(w1 w1Var) {
        this.contents = w1Var;
        long j4 = 0;
        for (int i3 = 0; i3 < w1Var.f11141c; i3++) {
            j4 += w1Var.c(i3);
        }
        this.f11035d = df.a(j4);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.s1
    public int count(@NullableDecl Object obj) {
        return this.contents.b(obj);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public r1 getEntry(int i3) {
        w1 w1Var = this.contents;
        kb.d(i3, w1Var.f11141c);
        return new v1(w1Var, i3);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f11035d;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.s1
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.e;
        if (immutableSet != null) {
            return immutableSet;
        }
        ElementSet elementSet = new ElementSet(null);
        this.e = elementSet;
        return elementSet;
    }
}
