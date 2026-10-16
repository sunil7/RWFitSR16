package com.google.common.collect;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.internal.mlkit_vision_barcode.jb;
import com.google.android.gms.internal.mlkit_vision_barcode.kb;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    static final int UNSET = -1;

    /* renamed from: a, reason: collision with root package name */
    public transient int[] f11002a;

    /* renamed from: b, reason: collision with root package name */
    public transient long[] f11003b;

    /* renamed from: c, reason: collision with root package name */
    public transient int f11004c;

    /* renamed from: d, reason: collision with root package name */
    public transient int f11005d;

    @MonotonicNonNullDecl
    transient Object[] elements;
    transient float loadFactor;
    transient int modCount;

    public CompactHashSet() {
        init(3, 1.0f);
    }

    public static int access$100(long j4) {
        return (int) (j4 >>> 32);
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int i3) {
        return new CompactHashSet<>(i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(3, 1.0f);
        int readInt = objectInputStream.readInt();
        while (true) {
            readInt--;
            if (readInt < 0) {
                return;
            } else {
                add(objectInputStream.readObject());
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f11005d);
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    public final boolean a(int i3, Object obj) {
        int[] iArr = this.f11002a;
        int length = (iArr.length - 1) & i3;
        int i10 = iArr[length];
        if (i10 == -1) {
            return false;
        }
        int i11 = -1;
        while (true) {
            if (((int) (this.f11003b[i10] >>> 32)) == i3 && jb.a(obj, this.elements[i10])) {
                if (i11 == -1) {
                    this.f11002a[length] = (int) this.f11003b[i10];
                } else {
                    long[] jArr = this.f11003b;
                    jArr[i11] = (jArr[i11] & (-4294967296L)) | (4294967295L & ((int) jArr[i10]));
                }
                moveEntry(i10);
                this.f11005d--;
                this.modCount++;
                return true;
            }
            int i12 = (int) this.f11003b[i10];
            if (i12 == -1) {
                return false;
            }
            i11 = i10;
            i10 = i12;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean add(@NullableDecl E e) {
        long[] jArr = this.f11003b;
        Object[] objArr = this.elements;
        int o3 = h.o(e);
        int[] iArr = this.f11002a;
        int length = (iArr.length - 1) & o3;
        int i3 = this.f11005d;
        int i10 = iArr[length];
        if (i10 == -1) {
            iArr[length] = i3;
        } else {
            while (true) {
                long j4 = jArr[i10];
                if (((int) (j4 >>> 32)) == o3 && jb.a(e, objArr[i10])) {
                    return false;
                }
                int i11 = (int) j4;
                if (i11 == -1) {
                    jArr[i10] = (j4 & (-4294967296L)) | (4294967295L & i3);
                    break;
                }
                i10 = i11;
            }
        }
        int i12 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        if (i3 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i13 = i3 + 1;
        int length2 = this.f11003b.length;
        if (i13 > length2) {
            int max = Math.max(1, length2 >>> 1) + length2;
            if (max >= 0) {
                i12 = max;
            }
            if (i12 != length2) {
                resizeEntries(i12);
            }
        }
        insertEntry(i3, e, o3);
        this.f11005d = i13;
        if (i3 >= this.f11004c) {
            c(this.f11002a.length * 2);
        }
        this.modCount++;
        return true;
    }

    public int adjustAfterRemove(int i3, int i10) {
        return i3 - 1;
    }

    public final void c(int i3) {
        if (this.f11002a.length >= 1073741824) {
            this.f11004c = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            return;
        }
        int i10 = ((int) (i3 * this.loadFactor)) + 1;
        int[] iArr = new int[i3];
        Arrays.fill(iArr, -1);
        long[] jArr = this.f11003b;
        int i11 = i3 - 1;
        for (int i12 = 0; i12 < this.f11005d; i12++) {
            int i13 = (int) (jArr[i12] >>> 32);
            int i14 = i13 & i11;
            int i15 = iArr[i14];
            iArr[i14] = i12;
            jArr[i12] = (i13 << 32) | (i15 & 4294967295L);
        }
        this.f11004c = i10;
        this.f11002a = iArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.modCount++;
        Arrays.fill(this.elements, 0, this.f11005d, (Object) null);
        Arrays.fill(this.f11002a, -1);
        Arrays.fill(this.f11003b, -1L);
        this.f11005d = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        int o3 = h.o(obj);
        int[] iArr = this.f11002a;
        int i3 = iArr[(iArr.length - 1) & o3];
        while (i3 != -1) {
            long j4 = this.f11003b[i3];
            if (((int) (j4 >>> 32)) == o3 && jb.a(obj, this.elements[i3])) {
                return true;
            }
            i3 = (int) j4;
        }
        return false;
    }

    public int firstEntryIndex() {
        return isEmpty() ? -1 : 0;
    }

    public int getSuccessor(int i3) {
        int i10 = i3 + 1;
        if (i10 < this.f11005d) {
            return i10;
        }
        return -1;
    }

    public void init(int i3, float f2) {
        kb.c("Initial capacity must be non-negative", i3 >= 0);
        kb.c("Illegal load factor", f2 > 0.0f);
        int f10 = h.f(i3, f2);
        int[] iArr = new int[f10];
        Arrays.fill(iArr, -1);
        this.f11002a = iArr;
        this.loadFactor = f2;
        this.elements = new Object[i3];
        long[] jArr = new long[i3];
        Arrays.fill(jArr, -1L);
        this.f11003b = jArr;
        this.f11004c = Math.max(1, (int) (f10 * f2));
    }

    public void insertEntry(int i3, E e, int i10) {
        this.f11003b[i3] = (i10 << 32) | 4294967295L;
        this.elements[i3] = e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f11005d == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new m(this);
    }

    public void moveEntry(int i3) {
        int size = size() - 1;
        if (i3 >= size) {
            this.elements[i3] = null;
            this.f11003b[i3] = -1;
            return;
        }
        Object[] objArr = this.elements;
        objArr[i3] = objArr[size];
        objArr[size] = null;
        long[] jArr = this.f11003b;
        long j4 = jArr[size];
        jArr[i3] = j4;
        jArr[size] = -1;
        int[] iArr = this.f11002a;
        int length = ((int) (j4 >>> 32)) & (iArr.length - 1);
        int i10 = iArr[length];
        if (i10 == size) {
            iArr[length] = i3;
            return;
        }
        while (true) {
            long[] jArr2 = this.f11003b;
            long j10 = jArr2[i10];
            int i11 = (int) j10;
            if (i11 == size) {
                jArr2[i10] = (j10 & (-4294967296L)) | (4294967295L & i3);
                return;
            }
            i10 = i11;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj) {
        return a(h.o(obj), obj);
    }

    public void resizeEntries(int i3) {
        this.elements = Arrays.copyOf(this.elements, i3);
        long[] jArr = this.f11003b;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i3);
        if (i3 > length) {
            Arrays.fill(copyOf, length, i3, -1L);
        }
        this.f11003b = copyOf;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f11005d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return Arrays.copyOf(this.elements, this.f11005d);
    }

    public void trimToSize() {
        int i3 = this.f11005d;
        if (i3 < this.f11003b.length) {
            resizeEntries(i3);
        }
        int max = Math.max(1, Integer.highestOneBit((int) (i3 / this.loadFactor)));
        if (max < 1073741824 && i3 / max > this.loadFactor) {
            max <<= 1;
        }
        if (max < this.f11002a.length) {
            c(max);
        }
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        Object[] objArr = this.elements;
        int i3 = this.f11005d;
        kb.f(0, i3, objArr.length);
        if (tArr.length < i3) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3));
        } else if (tArr.length > i3) {
            tArr[i3] = null;
        }
        System.arraycopy(objArr, 0, tArr, 0, i3);
        return tArr;
    }

    public CompactHashSet(int i3) {
        init(i3, 1.0f);
    }

    public static <E> CompactHashSet<E> create(E... eArr) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }
}
