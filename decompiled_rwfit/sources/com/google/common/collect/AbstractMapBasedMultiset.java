package com.google.common.collect;

import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.df;
import com.google.android.gms.internal.mlkit_vision_barcode.kb;
import com.google.android.gms.internal.mlkit_vision_barcode.lb;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
abstract class AbstractMapBasedMultiset<E> extends f implements Serializable {
    private static final long serialVersionUID = 0;
    transient w1 backingMap;
    transient long size;

    public AbstractMapBasedMultiset(int i3) {
        init(i3);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        init(3);
        for (int i3 = 0; i3 < readInt; i3++) {
            add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(entrySet().size());
        for (r1 r1Var : entrySet()) {
            objectOutputStream.writeObject(r1Var.getElement());
            objectOutputStream.writeInt(r1Var.getCount());
        }
    }

    @Override // com.google.common.collect.s1
    @CanIgnoreReturnValue
    public final int add(@NullableDecl E e, int i3) {
        if (i3 == 0) {
            return count(e);
        }
        kb.b("occurrences cannot be negative: %s", i3, i3 > 0);
        int d5 = this.backingMap.d(e);
        if (d5 == -1) {
            this.backingMap.f(i3, e);
            this.size += i3;
            return 0;
        }
        int c9 = this.backingMap.c(d5);
        long j4 = i3;
        long j10 = c9 + j4;
        if (!(j10 <= 2147483647L)) {
            throw new IllegalArgumentException(lb.a("too many occurrences: %s", Long.valueOf(j10)));
        }
        w1 w1Var = this.backingMap;
        kb.d(d5, w1Var.f11141c);
        w1Var.f11140b[d5] = (int) j10;
        this.size += j4;
        return c9;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:6:0x0029 -> B:3:0x000a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void addTo(com.google.common.collect.s1 r5) {
        /*
            r4 = this;
            r5.getClass()
            com.google.common.collect.w1 r0 = r4.backingMap
            int r0 = r0.f11141c
            r1 = -1
            if (r0 != 0) goto Lc
        La:
            r0 = r1
            goto Ld
        Lc:
            r0 = 0
        Ld:
            if (r0 < 0) goto L2c
            com.google.common.collect.w1 r2 = r4.backingMap
            int r3 = r2.f11141c
            com.google.android.gms.internal.mlkit_vision_barcode.kb.d(r0, r3)
            java.lang.Object[] r2 = r2.f11139a
            r2 = r2[r0]
            com.google.common.collect.w1 r3 = r4.backingMap
            int r3 = r3.c(r0)
            r5.add(r2, r3)
            com.google.common.collect.w1 r2 = r4.backingMap
            int r0 = r0 + 1
            int r2 = r2.f11141c
            if (r0 >= r2) goto La
            goto Ld
        L2c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.AbstractMapBasedMultiset.addTo(com.google.common.collect.s1):void");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        w1 w1Var = this.backingMap;
        w1Var.f11142d++;
        Arrays.fill(w1Var.f11139a, 0, w1Var.f11141c, (Object) null);
        Arrays.fill(w1Var.f11140b, 0, w1Var.f11141c, 0);
        Arrays.fill(w1Var.e, -1);
        Arrays.fill(w1Var.f11143f, -1L);
        w1Var.f11141c = 0;
        this.size = 0L;
    }

    @Override // com.google.common.collect.s1
    public final int count(@NullableDecl Object obj) {
        return this.backingMap.b(obj);
    }

    @Override // com.google.common.collect.f
    public final int distinctElements() {
        return this.backingMap.f11141c;
    }

    @Override // com.google.common.collect.f
    public final Iterator<E> elementIterator() {
        return new b(this, 0);
    }

    @Override // com.google.common.collect.f
    public final Iterator<r1> entryIterator() {
        return new b(this, 1);
    }

    public abstract void init(int i3);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        return new u1(this, entrySet().iterator());
    }

    @Override // com.google.common.collect.s1
    @CanIgnoreReturnValue
    public final int remove(@NullableDecl Object obj, int i3) {
        if (i3 == 0) {
            return count(obj);
        }
        kb.b("occurrences cannot be negative: %s", i3, i3 > 0);
        int d5 = this.backingMap.d(obj);
        if (d5 == -1) {
            return 0;
        }
        int c9 = this.backingMap.c(d5);
        if (c9 > i3) {
            w1 w1Var = this.backingMap;
            kb.d(d5, w1Var.f11141c);
            w1Var.f11140b[d5] = c9 - i3;
        } else {
            this.backingMap.h(d5);
            i3 = c9;
        }
        this.size -= i3;
        return c9;
    }

    @CanIgnoreReturnValue
    public final int setCount(@NullableDecl E e, int i3) {
        int f2;
        h.d(i3, Const.SP_KEY_CALL_LOC_COUNT);
        w1 w1Var = this.backingMap;
        if (i3 == 0) {
            w1Var.getClass();
            f2 = w1Var.g(e, h.o(e));
        } else {
            f2 = w1Var.f(i3, e);
        }
        this.size += i3 - f2;
        return f2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return df.a(this.size);
    }

    @Override // com.google.common.collect.s1
    public final boolean setCount(@NullableDecl E e, int i3, int i10) {
        h.d(i3, "oldCount");
        h.d(i10, "newCount");
        int d5 = this.backingMap.d(e);
        if (d5 == -1) {
            if (i3 != 0) {
                return false;
            }
            if (i10 > 0) {
                this.backingMap.f(i10, e);
                this.size += i10;
            }
            return true;
        }
        if (this.backingMap.c(d5) != i3) {
            return false;
        }
        if (i10 == 0) {
            this.backingMap.h(d5);
            this.size -= i3;
            return true;
        }
        w1 w1Var = this.backingMap;
        kb.d(d5, w1Var.f11141c);
        w1Var.f11140b[d5] = i10;
        this.size += i10 - i3;
        return true;
    }
}
