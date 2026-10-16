package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class n extends m {
    public static void i(Collection collection, Iterable elements) {
        kotlin.jvm.internal.e.f(collection, "<this>");
        kotlin.jvm.internal.e.f(elements, "elements");
        if (elements instanceof Collection) {
            collection.addAll((Collection) elements);
            return;
        }
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }
}
