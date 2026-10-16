package com.google.common.collect;

import com.google.android.gms.internal.mlkit_vision_barcode.jb;
import com.google.android.gms.internal.mlkit_vision_barcode.kb;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    public static final v f11007b = new v(RegularImmutableList.EMPTY, 0);

    public static class ReverseImmutableList<E> extends ImmutableList<E> {

        /* renamed from: c, reason: collision with root package name */
        public final transient ImmutableList f11008c;

        public ReverseImmutableList(ImmutableList<E> immutableList) {
            this.f11008c = immutableList;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            return this.f11008c.contains(obj);
        }

        @Override // java.util.List
        public E get(int i3) {
            kb.d(i3, size());
            return this.f11008c.get((size() - 1) - i3);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@NullableDecl Object obj) {
            int lastIndexOf = this.f11008c.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return (size() - 1) - lastIndexOf;
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.f11008c.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@NullableDecl Object obj) {
            int indexOf = this.f11008c.indexOf(obj);
            if (indexOf >= 0) {
                return (size() - 1) - indexOf;
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            return this.f11008c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f11008c.size();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i3) {
            return super.listIterator(i3);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i3, int i10) {
            kb.f(i3, i10, size());
            return this.f11008c.subList(size() - i10, size() - i3).reverse();
        }
    }

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return ImmutableList.copyOf(this.elements);
        }
    }

    public class SubList extends ImmutableList<E> {
        final transient int length;
        final transient int offset;

        public SubList(int i3, int i10) {
            this.offset = i3;
            this.length = i10;
        }

        @Override // java.util.List
        public E get(int i3) {
            kb.d(i3, this.length);
            return ImmutableList.this.get(i3 + this.offset);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public Object[] internalArray() {
            return ImmutableList.this.internalArray();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int internalArrayEnd() {
            return ImmutableList.this.internalArrayStart() + this.offset + this.length;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public int internalArrayStart() {
            return ImmutableList.this.internalArrayStart() + this.offset;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.length;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i3) {
            return super.listIterator(i3);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i3, int i10) {
            kb.f(i3, i10, this.length);
            ImmutableList immutableList = ImmutableList.this;
            int i11 = this.offset;
            return immutableList.subList(i3 + i11, i10 + i11);
        }
    }

    public static <E> ImmutableList<E> asImmutableList(Object[] objArr) {
        return asImmutableList(objArr, objArr.length);
    }

    public static <E> u builder() {
        return new u(4);
    }

    public static <E> u builderWithExpectedSize(int i3) {
        h.d(i3, "expectedSize");
        return new u(i3);
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> collection) {
        if (collection instanceof ImmutableCollection) {
            ImmutableList<E> asList = ((ImmutableCollection) collection).asList();
            return asList.isPartialView() ? asImmutableList(asList.toArray()) : asList;
        }
        Object[] array = collection.toArray();
        h.b(array.length, array);
        return asImmutableList(array);
    }

    public static <E> ImmutableList<E> of() {
        return (ImmutableList<E>) RegularImmutableList.EMPTY;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<? super E>> ImmutableList<E> sortedCopyOf(Iterable<? extends E> iterable) {
        Collection collection;
        Comparable[] comparableArr = new Comparable[0];
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            Iterator<? extends E> it = iterable.iterator();
            ArrayList arrayList = new ArrayList();
            h.a(arrayList, it);
            collection = arrayList;
        }
        Comparable[] comparableArr2 = (Comparable[]) collection.toArray(comparableArr);
        h.b(comparableArr2.length, comparableArr2);
        Arrays.sort(comparableArr2);
        return asImmutableList(comparableArr2);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i3, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(int i3, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final ImmutableList<E> asList() {
        return this;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i3) {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            objArr[i3 + i10] = get(i10);
        }
        return i3 + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        if (obj != this) {
            if (obj instanceof List) {
                List list = (List) obj;
                int size = size();
                if (size == list.size()) {
                    if (!(list instanceof RandomAccess)) {
                        Iterator<E> it = iterator();
                        Iterator<E> it2 = list.iterator();
                        while (it.hasNext()) {
                            if (it2.hasNext() && jb.a(it.next(), it2.next())) {
                            }
                        }
                        return !it2.hasNext();
                    }
                    for (int i3 = 0; i3 < size; i3++) {
                        if (jb.a(get(i3), list.get(i3))) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i3 = 1;
        for (int i10 = 0; i10 < size; i10++) {
            i3 = ~(~(get(i10).hashCode() + (i3 * 31)));
        }
        return i3;
    }

    @Override // java.util.List
    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (obj.equals(get(i3))) {
                return i3;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final E remove(int i3) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> reverse() {
        return size() <= 1 ? this : new ReverseImmutableList(this);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final E set(int i3, E e) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> subListUnchecked(int i3, int i10) {
        return new SubList(i3, i10 - i3);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableList<E> asImmutableList(Object[] objArr, int i3) {
        return i3 == 0 ? of() : new RegularImmutableList(objArr, i3);
    }

    public static <E> ImmutableList<E> of(E e) {
        Object[] objArr = {e};
        h.b(1, objArr);
        return asImmutableList(objArr);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public d2 iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int i3, int i10) {
        kb.f(i3, i10, size());
        int i11 = i10 - i3;
        return i11 == size() ? this : i11 == 0 ? of() : subListUnchecked(i3, i10);
    }

    @Override // java.util.List
    public e2 listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public e2 listIterator(int i3) {
        kb.e(i3, size());
        if (isEmpty()) {
            return f11007b;
        }
        return new v(this, i3);
    }

    public static <E> ImmutableList<E> of(E e, E e10) {
        Object[] objArr = {e, e10};
        h.b(2, objArr);
        return asImmutableList(objArr);
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        u uVar = new u(4);
        uVar.r(next);
        while (it.hasNext()) {
            uVar.r(it.next());
        }
        return uVar.t();
    }

    public static <E> ImmutableList<E> of(E e, E e10, E e11) {
        Object[] objArr = {e, e10, e11};
        h.b(3, objArr);
        return asImmutableList(objArr);
    }

    public static <E> ImmutableList<E> of(E e, E e10, E e11, E e12) {
        Object[] objArr = {e, e10, e11, e12};
        h.b(4, objArr);
        return asImmutableList(objArr);
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        Collection collection;
        comparator.getClass();
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            Iterator<? extends E> it = iterable.iterator();
            ArrayList arrayList = new ArrayList();
            h.a(arrayList, it);
            collection = arrayList;
        }
        Object[] array = collection.toArray();
        h.b(array.length, array);
        Arrays.sort(array, comparator);
        return asImmutableList(array);
    }

    public static <E> ImmutableList<E> of(E e, E e10, E e11, E e12, E e13) {
        Object[] objArr = {e, e10, e11, e12, e13};
        h.b(5, objArr);
        return asImmutableList(objArr);
    }

    public static <E> ImmutableList<E> of(E e, E e10, E e11, E e12, E e13, E e14) {
        Object[] objArr = {e, e10, e11, e12, e13, e14};
        h.b(6, objArr);
        return asImmutableList(objArr);
    }

    public static <E> ImmutableList<E> copyOf(E[] eArr) {
        if (eArr.length == 0) {
            return of();
        }
        Object[] objArr = (Object[]) eArr.clone();
        h.b(objArr.length, objArr);
        return asImmutableList(objArr);
    }

    public static <E> ImmutableList<E> of(E e, E e10, E e11, E e12, E e13, E e14, E e15) {
        Object[] objArr = {e, e10, e11, e12, e13, e14, e15};
        h.b(7, objArr);
        return asImmutableList(objArr);
    }

    public static <E> ImmutableList<E> of(E e, E e10, E e11, E e12, E e13, E e14, E e15, E e16) {
        Object[] objArr = {e, e10, e11, e12, e13, e14, e15, e16};
        h.b(8, objArr);
        return asImmutableList(objArr);
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableList<E> of(E e, E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17) {
        Object[] objArr = {e, e10, e11, e12, e13, e14, e15, e16, e17};
        h.b(9, objArr);
        return asImmutableList(objArr);
    }

    public static <E> ImmutableList<E> of(E e, E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18) {
        Object[] objArr = {e, e10, e11, e12, e13, e14, e15, e16, e17, e18};
        h.b(10, objArr);
        return asImmutableList(objArr);
    }

    public static <E> ImmutableList<E> of(E e, E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18, E e19) {
        Object[] objArr = {e, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19};
        h.b(11, objArr);
        return asImmutableList(objArr);
    }

    @SafeVarargs
    public static <E> ImmutableList<E> of(E e, E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18, E e19, E e20, E... eArr) {
        kb.c("the total number of elements must fit in an int", eArr.length <= 2147483635);
        int length = eArr.length + 12;
        Object[] objArr = new Object[length];
        objArr[0] = e;
        objArr[1] = e10;
        objArr[2] = e11;
        objArr[3] = e12;
        objArr[4] = e13;
        objArr[5] = e14;
        objArr[6] = e15;
        objArr[7] = e16;
        objArr[8] = e17;
        objArr[9] = e18;
        objArr[10] = e19;
        objArr[11] = e20;
        System.arraycopy(eArr, 0, objArr, 12, eArr.length);
        h.b(length, objArr);
        return asImmutableList(objArr);
    }
}
