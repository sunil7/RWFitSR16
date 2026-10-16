package com.google.common.collect;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: classes.dex */
public abstract class h {
    public static boolean a(Collection collection, Iterator it) {
        collection.getClass();
        it.getClass();
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= collection.add(it.next());
        }
        return z5;
    }

    public static void b(int i3, Object[] objArr) {
        for (int i10 = 0; i10 < i3; i10++) {
            if (objArr[i10] == null) {
                throw new NullPointerException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i10, "at index "));
            }
        }
    }

    public static void c(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    public static void d(int i3, String str) {
        if (i3 >= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i3);
    }

    public static void e(boolean z5) {
        if (!z5) {
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
    }

    public static int f(int i3, double d5) {
        int max = Math.max(i3, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (d5 * highestOneBit))) {
            return highestOneBit;
        }
        int i10 = highestOneBit << 1;
        if (i10 > 0) {
            return i10;
        }
        return 1073741824;
    }

    public static boolean g(Iterator it, Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean h(s1 s1Var, Object obj) {
        if (obj == s1Var) {
            return true;
        }
        if (!(obj instanceof s1)) {
            return false;
        }
        s1 s1Var2 = (s1) obj;
        if (s1Var.size() != s1Var2.size() || s1Var.entrySet().size() != s1Var2.entrySet().size()) {
            return false;
        }
        for (r1 r1Var : s1Var2.entrySet()) {
            if (s1Var.count(r1Var.getElement()) != r1Var.getCount()) {
                return false;
            }
        }
        return true;
    }

    public static int i(int i3, int i10) {
        if (i10 < 0) {
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
        int i11 = i3 + (i3 >> 1) + 1;
        if (i11 < i10) {
            i11 = Integer.highestOneBit(i10 - 1) << 1;
        }
        return i11 < 0 ? SubsamplingScaleImageView.TILE_SIZE_AUTO : i11;
    }

    public static com.example.test.ui.device.activity.i0 j(String str, Class cls) {
        try {
            return new com.example.test.ui.device.activity.i0(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e) {
            throw new AssertionError(e);
        }
    }

    public static Object k(Iterator it, String str) {
        return it.hasNext() ? it.next() : str;
    }

    public static boolean l(Comparator comparator, Iterable iterable) {
        Comparator comparator2;
        comparator.getClass();
        iterable.getClass();
        if (iterable instanceof SortedSet) {
            comparator2 = ((SortedSet) iterable).comparator();
            if (comparator2 == null) {
                comparator2 = z1.natural();
            }
        } else {
            if (!(iterable instanceof b2)) {
                return false;
            }
            comparator2 = ((b2) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }

    public static int m(Set set) {
        Iterator it = set.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i3 = ~(~(i3 + (next != null ? next.hashCode() : 0)));
        }
        return i3;
    }

    public static int n(int i3) {
        return (int) (Integer.rotateLeft((int) (i3 * (-862048943)), 15) * 461845907);
    }

    public static int o(Object obj) {
        return n(obj == null ? 0 : obj.hashCode());
    }

    public static String p(Map map) {
        int size = map.size();
        d(size, "size");
        StringBuilder sb2 = new StringBuilder((int) Math.min(size * 8, 1073741824L));
        sb2.append('{');
        boolean z5 = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!z5) {
                sb2.append(", ");
            }
            sb2.append(entry.getKey());
            sb2.append('=');
            sb2.append(entry.getValue());
            z5 = false;
        }
        sb2.append('}');
        return sb2.toString();
    }

    public static void q(ImmutableMultimap immutableMultimap, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(immutableMultimap.asMap().size());
        for (Map.Entry entry : immutableMultimap.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(((Collection) entry.getValue()).size());
            Iterator it = ((Collection) entry.getValue()).iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }
}
