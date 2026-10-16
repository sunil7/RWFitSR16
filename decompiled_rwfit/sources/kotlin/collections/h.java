package kotlin.collections;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.wd;
import com.google.android.gms.internal.mlkit_vision_barcode.yd;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public abstract class h extends n {
    public static final int j(int i3, List list) {
        if (new th.c(0, i.c(list), 1).a(i3)) {
            return i.c(list) - i3;
        }
        StringBuilder q5 = android.support.v4.media.session.e.q(i3, "Element index ", " must be in range [");
        q5.append(new th.c(0, i.c(list), 1));
        q5.append("].");
        throw new IndexOutOfBoundsException(q5.toString());
    }

    public static final int k(int i3, List list) {
        if (new th.c(0, list.size(), 1).a(i3)) {
            return list.size() - i3;
        }
        StringBuilder q5 = android.support.v4.media.session.e.q(i3, "Position index ", " must be in range [");
        q5.append(new th.c(0, list.size(), 1));
        q5.append("].");
        throw new IndexOutOfBoundsException(q5.toString());
    }

    public static s l(List list) {
        kotlin.jvm.internal.e.f(list, "<this>");
        return new s(list);
    }

    public static boolean m(LinkedList linkedList, e6.b bVar) {
        kotlin.jvm.internal.e.f(linkedList, "<this>");
        return linkedList.contains(bVar);
    }

    public static Object n(List list) {
        kotlin.jvm.internal.e.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static final void o(Collection collection, StringBuilder sb2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, oh.l lVar) {
        sb2.append(charSequence2);
        int i3 = 0;
        for (Object obj : collection) {
            i3++;
            if (i3 > 1) {
                sb2.append(charSequence);
            }
            yd.a(sb2, obj, lVar);
        }
        sb2.append(charSequence3);
    }

    public static String p(Collection collection, String str, oh.l lVar, int i3) {
        String str2 = (i3 & 2) != 0 ? "" : "[";
        String str3 = (i3 & 4) == 0 ? "]" : "";
        if ((i3 & 32) != 0) {
            lVar = null;
        }
        StringBuilder sb2 = new StringBuilder();
        o(collection, sb2, str, str2, str3, "...", lVar);
        String sb3 = sb2.toString();
        kotlin.jvm.internal.e.e(sb3, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb3;
    }

    public static Object q(List list) {
        kotlin.jvm.internal.e.f(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(i.c(list));
    }

    public static ArrayList r(Collection collection, Serializable serializable) {
        kotlin.jvm.internal.e.f(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(serializable);
        return arrayList;
    }

    public static ArrayList s(Collection collection, Iterable elements) {
        kotlin.jvm.internal.e.f(collection, "<this>");
        kotlin.jvm.internal.e.f(elements, "elements");
        if (!(elements instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            n.i(arrayList, elements);
            return arrayList;
        }
        Collection collection2 = (Collection) elements;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static List t(Iterable iterable, int i3) {
        Object next;
        if (i3 < 0) {
            throw new IllegalArgumentException(l0.k(i3, "Requested element count ", " is less than zero.").toString());
        }
        if (i3 == 0) {
            return EmptyList.INSTANCE;
        }
        if (iterable instanceof Collection) {
            if (i3 >= ((Collection) iterable).size()) {
                return v(iterable);
            }
            if (i3 == 1) {
                if (iterable instanceof List) {
                    next = n((List) iterable);
                } else {
                    Iterator it = iterable.iterator();
                    if (!it.hasNext()) {
                        throw new NoSuchElementException("Collection is empty.");
                    }
                    next = it.next();
                }
                return wd.a(next);
            }
        }
        ArrayList arrayList = new ArrayList(i3);
        Iterator it2 = iterable.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            arrayList.add(it2.next());
            i10++;
            if (i10 == i3) {
                break;
            }
        }
        int size = arrayList.size();
        return size != 0 ? size != 1 ? arrayList : wd.a(arrayList.get(0)) : EmptyList.INSTANCE;
    }

    public static final void u(Iterable iterable, java.util.AbstractCollection abstractCollection) {
        kotlin.jvm.internal.e.f(iterable, "<this>");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static List v(Iterable iterable) {
        ArrayList arrayList;
        kotlin.jvm.internal.e.f(iterable, "<this>");
        boolean z5 = iterable instanceof Collection;
        if (z5) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return EmptyList.INSTANCE;
            }
            if (size != 1) {
                return w(collection);
            }
            return wd.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        if (z5) {
            arrayList = w((Collection) iterable);
        } else {
            ArrayList arrayList2 = new ArrayList();
            u(iterable, arrayList2);
            arrayList = arrayList2;
        }
        int size2 = arrayList.size();
        return size2 != 0 ? size2 != 1 ? arrayList : wd.a(arrayList.get(0)) : EmptyList.INSTANCE;
    }

    public static ArrayList w(Collection collection) {
        kotlin.jvm.internal.e.f(collection, "<this>");
        return new ArrayList(collection);
    }
}
