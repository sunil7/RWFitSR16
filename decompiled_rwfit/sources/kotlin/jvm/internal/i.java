package kotlin.jvm.internal;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import oh.l;
import oh.p;
import oh.q;
import oh.r;

/* loaded from: classes2.dex */
public abstract class i {
    public static Collection a(LinkedList linkedList) {
        if (!(linkedList instanceof ph.a) || (linkedList instanceof ph.b)) {
            return linkedList;
        }
        d(linkedList, "kotlin.collections.MutableCollection");
        throw null;
    }

    public static List b(Object obj) {
        if ((obj instanceof ph.a) && !(obj instanceof ph.b)) {
            d(obj, "kotlin.collections.MutableList");
            throw null;
        }
        try {
            return (List) obj;
        } catch (ClassCastException e) {
            e.j(e, i.class.getName());
            throw e;
        }
    }

    public static void c(Object obj) {
        if (obj != null) {
            if (obj instanceof eh.a) {
                if ((obj instanceof d ? ((d) obj).getArity() : obj instanceof oh.a ? 0 : obj instanceof l ? 1 : obj instanceof p ? 2 : obj instanceof q ? 3 : obj instanceof r ? 4 : -1) == 2) {
                    return;
                }
            }
            d(obj, "kotlin.jvm.functions.Function2");
            throw null;
        }
    }

    public static void d(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(r5.a.c(obj == null ? "null" : obj.getClass().getName(), " cannot be cast to ", str));
        e.j(classCastException, i.class.getName());
        throw classCastException;
    }
}
