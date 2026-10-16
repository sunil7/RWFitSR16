package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements NavigableSet<E>, b2 {
    final transient Comparator<? super E> comparator;

    @LazyInit
    transient ImmutableSortedSet<E> descendingSet;

    public static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> comparator;
        final Object[] elements;

        public SerializedForm(Comparator<? super E> comparator, Object[] objArr) {
            this.comparator = comparator;
            this.elements = objArr;
        }

        public Object readResolve() {
            l0 l0Var = new l0(this.comparator);
            Object[] objArr = this.elements;
            if (l0Var.f11079d != null) {
                for (Object obj : objArr) {
                    l0Var.t(obj);
                }
            } else {
                h.b(objArr.length, objArr);
                l0Var.s(l0Var.f11119b + objArr.length);
                System.arraycopy(objArr, 0, l0Var.f11118a, l0Var.f11119b, objArr.length);
                l0Var.f11119b += objArr.length;
            }
            return l0Var.u();
        }
    }

    public ImmutableSortedSet(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> ImmutableSortedSet<E> construct(Comparator<? super E> comparator, int i3, E... eArr) {
        if (i3 == 0) {
            return emptySet(comparator);
        }
        h.b(i3, eArr);
        Arrays.sort(eArr, 0, i3, comparator);
        int i10 = 1;
        for (int i11 = 1; i11 < i3; i11++) {
            a1.g gVar = (Object) eArr[i11];
            if (comparator.compare(gVar, (Object) eArr[i10 - 1]) != 0) {
                eArr[i10] = gVar;
                i10++;
            }
        }
        Arrays.fill(eArr, i10, i3, (Object) null);
        if (i10 < eArr.length / 2) {
            eArr = (E[]) Arrays.copyOf(eArr, i10);
        }
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(eArr, i10), comparator);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet copyOf(Comparable[] comparableArr) {
        return construct(z1.natural(), comparableArr.length, (Object[]) comparableArr.clone());
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        if (comparator == null) {
            comparator = z1.natural();
        }
        ImmutableList copyOf = ImmutableList.copyOf((Collection) sortedSet);
        return copyOf.isEmpty() ? emptySet(comparator) : new RegularImmutableSortedSet(copyOf, comparator);
    }

    public static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> comparator) {
        return z1.natural().equals(comparator) ? (RegularImmutableSortedSet<E>) RegularImmutableSortedSet.NATURAL_EMPTY_SET : new RegularImmutableSortedSet<>(ImmutableList.of(), comparator);
    }

    public static <E extends Comparable<?>> l0 naturalOrder() {
        return new l0(z1.natural());
    }

    public static <E> ImmutableSortedSet<E> of() {
        return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    }

    public static <E> l0 orderedBy(Comparator<E> comparator) {
        return new l0(comparator);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> l0 reverseOrder() {
        return new l0(Collections.reverseOrder());
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e) {
        return (E) h.k(tailSet((ImmutableSortedSet<E>) e, true).iterator(), null);
    }

    @Override // java.util.SortedSet, com.google.common.collect.b2
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public abstract ImmutableSortedSet<E> createDescendingSet();

    @Override // java.util.NavigableSet
    public abstract d2 descendingIterator();

    @Override // java.util.SortedSet
    public E first() {
        return (E) iterator().next();
    }

    @Override // java.util.NavigableSet
    public E floor(E e) {
        return (E) h.k(headSet((ImmutableSortedSet<E>) e, true).descendingIterator(), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet headSet(Object obj, boolean z5) {
        return headSet((ImmutableSortedSet<E>) obj, z5);
    }

    public abstract ImmutableSortedSet<E> headSetImpl(E e, boolean z5);

    @Override // java.util.NavigableSet
    public E higher(E e) {
        return (E) h.k(tailSet((ImmutableSortedSet<E>) e, false).iterator(), null);
    }

    public abstract int indexOf(@NullableDecl Object obj);

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract d2 iterator();

    @Override // java.util.SortedSet
    public E last() {
        return (E) descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    public E lower(E e) {
        return (E) h.k(headSet((ImmutableSortedSet<E>) e, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @CanIgnoreReturnValue
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @CanIgnoreReturnValue
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet subSet(Object obj, boolean z5, Object obj2, boolean z6) {
        return subSet((boolean) obj, z5, (boolean) obj2, z6);
    }

    public abstract ImmutableSortedSet<E> subSetImpl(E e, boolean z5, E e10, boolean z6);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    public /* bridge */ /* synthetic */ NavigableSet tailSet(Object obj, boolean z5) {
        return tailSet((ImmutableSortedSet<E>) obj, z5);
    }

    public abstract ImmutableSortedSet<E> tailSetImpl(E e, boolean z5);

    public int unsafeCompare(Object obj, Object obj2) {
        return unsafeCompare(this.comparator, obj, obj2);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this.comparator, toArray());
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(z1.natural(), iterable);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable) {
        return new RegularImmutableSortedSet(ImmutableList.of(comparable), z1.natural());
    }

    public static int unsafeCompare(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.descendingSet;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        ImmutableSortedSet<E> createDescendingSet = createDescendingSet();
        this.descendingSet = createDescendingSet;
        createDescendingSet.descendingSet = this;
        return createDescendingSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return headSet((ImmutableSortedSet<E>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet((ImmutableSortedSet<E>) obj);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2) {
        return construct(z1.natural(), 2, comparable, comparable2);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> headSet(E e) {
        return headSet((ImmutableSortedSet<E>) e, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> subSet(E e, E e10) {
        return subSet((boolean) e, true, (boolean) e10, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> tailSet(E e) {
        return tailSet((ImmutableSortedSet<E>) e, true);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> collection) {
        return copyOf((Comparator) z1.natural(), (Collection) collection);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return construct(z1.natural(), 3, comparable, comparable2, comparable3);
    }

    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> headSet(E e, boolean z5) {
        e.getClass();
        return headSetImpl(e, z5);
    }

    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> subSet(E e, boolean z5, E e10, boolean z6) {
        e.getClass();
        e10.getClass();
        if (this.comparator.compare(e, e10) <= 0) {
            return subSetImpl(e, z5, e10, z6);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> tailSet(E e, boolean z5) {
        e.getClass();
        return tailSetImpl(e, z5);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return construct(z1.natural(), 4, comparable, comparable2, comparable3, comparable4);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> it) {
        return copyOf(z1.natural(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return construct(z1.natural(), 5, comparable, comparable2, comparable3, comparable4, comparable5);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        int length = comparableArr.length + 6;
        Comparable[] comparableArr2 = new Comparable[length];
        comparableArr2[0] = comparable;
        comparableArr2[1] = comparable2;
        comparableArr2[2] = comparable3;
        comparableArr2[3] = comparable4;
        comparableArr2[4] = comparable5;
        comparableArr2[5] = comparable6;
        System.arraycopy(comparableArr, 0, comparableArr2, 6, comparableArr.length);
        return construct(z1.natural(), length, comparableArr2);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        l0 l0Var = new l0(comparator);
        it.getClass();
        while (it.hasNext()) {
            l0Var.t(it.next());
        }
        return l0Var.u();
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return copyOf((Comparator) comparator, (Iterable) collection);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        Collection collection;
        comparator.getClass();
        if (h.l(comparator, iterable) && (iterable instanceof ImmutableSortedSet)) {
            ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet) iterable;
            if (!immutableSortedSet.isPartialView()) {
                return immutableSortedSet;
            }
        }
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            Iterator<? extends E> it = iterable.iterator();
            ArrayList arrayList = new ArrayList();
            h.a(arrayList, it);
            collection = arrayList;
        }
        Object[] array = collection.toArray();
        return construct(comparator, array.length, array);
    }
}
