package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> {
    private static final long serialVersionUID = 0;

    /* renamed from: d, reason: collision with root package name */
    public transient ImmutableListMultimap f11009d;

    public ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> immutableMap, int i3) {
        super(immutableMap, i3);
    }

    public static <K, V> w builder() {
        return new w();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(q1 q1Var) {
        if (q1Var.isEmpty()) {
            return of();
        }
        if (q1Var instanceof ImmutableListMultimap) {
            ImmutableListMultimap<K, V> immutableListMultimap = (ImmutableListMultimap) q1Var;
            if (!immutableListMultimap.isPartialView()) {
                return immutableListMultimap;
            }
        }
        return fromMapEntries(q1Var.asMap().entrySet(), null);
    }

    public static <K, V> ImmutableListMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, @NullableDecl Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return of();
        }
        Object[] objArr = new Object[collection.size() * 2];
        int i3 = 0;
        int i10 = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            Collection<? extends V> value = entry.getValue();
            ImmutableList copyOf = comparator == null ? ImmutableList.copyOf((Collection) value) : ImmutableList.sortedCopyOf(comparator, value);
            if (!copyOf.isEmpty()) {
                int i11 = (i10 + 1) * 2;
                if (i11 > objArr.length) {
                    objArr = Arrays.copyOf(objArr, h.i(objArr.length, i11));
                }
                h.c(key, copyOf);
                objArr[i10 * 2] = key;
                objArr[(i10 * 2) + 1] = copyOf;
                i10++;
                i3 = copyOf.size() + i3;
            }
        }
        return new ImmutableListMultimap<>(RegularImmutableMap.create(i10, objArr), i3);
    }

    public static <K, V> ImmutableListMultimap<K, V> of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt < 0) {
            throw new InvalidObjectException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(readInt, "Invalid key count "));
        }
        y builder = ImmutableMap.builder();
        int i3 = 0;
        for (int i10 = 0; i10 < readInt; i10++) {
            Object readObject = objectInputStream.readObject();
            int readInt2 = objectInputStream.readInt();
            if (readInt2 <= 0) {
                throw new InvalidObjectException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(readInt2, "Invalid value count "));
            }
            u builder2 = ImmutableList.builder();
            for (int i11 = 0; i11 < readInt2; i11++) {
                builder2.r(objectInputStream.readObject());
            }
            builder.b(readObject, builder2.t());
            i3 += readInt2;
        }
        try {
            ImmutableMap a3 = builder.a();
            com.example.test.ui.device.activity.i0 i0Var = f0.f11065a;
            i0Var.getClass();
            try {
                ((Field) i0Var.f7866b).set(this, a3);
                com.example.test.ui.device.activity.i0 i0Var2 = f0.f11066b;
                i0Var2.getClass();
                try {
                    ((Field) i0Var2.f7866b).set(this, Integer.valueOf(i3));
                } catch (IllegalAccessException e) {
                    throw new AssertionError(e);
                }
            } catch (IllegalAccessException e10) {
                throw new AssertionError(e10);
            }
        } catch (IllegalArgumentException e11) {
            throw ((InvalidObjectException) new InvalidObjectException(e11.getMessage()).initCause(e11));
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        h.q(this, objectOutputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap
    public /* bridge */ /* synthetic */ ImmutableCollection get(@NullableDecl Object obj) {
        return get((ImmutableListMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap
    @CanIgnoreReturnValue
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k10, V v6) {
        w builder = builder();
        builder.e(k10, v6);
        return builder.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap
    /* renamed from: get */
    public /* bridge */ /* synthetic */ Collection mo66get(@NullableDecl Object obj) {
        return get((ImmutableListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> immutableListMultimap = this.f11009d;
        if (immutableListMultimap != null) {
            return immutableListMultimap;
        }
        w builder = builder();
        d2 it = mo64entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.e(entry.getValue(), entry.getKey());
        }
        ImmutableListMultimap<V, K> d5 = builder.d();
        d5.f11009d = this;
        this.f11009d = d5;
        return d5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap
    @CanIgnoreReturnValue
    @Deprecated
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ Collection mo69replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap
    /* renamed from: get */
    public /* bridge */ /* synthetic */ List mo66get(@NullableDecl Object obj) {
        return get((ImmutableListMultimap<K, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap
    @CanIgnoreReturnValue
    @Deprecated
    /* renamed from: replaceValues */
    public /* bridge */ /* synthetic */ List mo69replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableList<V> get(@NullableDecl K k10) {
        ImmutableList<V> immutableList = (ImmutableList) this.map.get(k10);
        return immutableList == null ? ImmutableList.of() : immutableList;
    }

    @Override // com.google.common.collect.ImmutableMultimap
    @CanIgnoreReturnValue
    @Deprecated
    /* renamed from: removeAll */
    public ImmutableList<V> mo68removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableList<V> replaceValues(K k10, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k10, V v6, K k11, V v9) {
        w builder = builder();
        builder.e(k10, v6);
        builder.e(k11, v9);
        return builder.d();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        w wVar = new w();
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
        while (it.hasNext()) {
            wVar.c(it.next());
        }
        return wVar.d();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k10, V v6, K k11, V v9, K k12, V v10) {
        w builder = builder();
        builder.e(k10, v6);
        builder.e(k11, v9);
        builder.e(k12, v10);
        return builder.d();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k10, V v6, K k11, V v9, K k12, V v10, K k13, V v11) {
        w builder = builder();
        builder.e(k10, v6);
        builder.e(k11, v9);
        builder.e(k12, v10);
        builder.e(k13, v11);
        return builder.d();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k10, V v6, K k11, V v9, K k12, V v10, K k13, V v11, K k14, V v12) {
        w builder = builder();
        builder.e(k10, v6);
        builder.e(k11, v9);
        builder.e(k12, v10);
        builder.e(k13, v11);
        builder.e(k14, v12);
        return builder.d();
    }
}
