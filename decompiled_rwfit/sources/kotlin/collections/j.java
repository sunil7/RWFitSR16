package kotlin.collections;

import java.util.Collection;

/* loaded from: classes2.dex */
public abstract class j extends i {
    public static int g(Iterable iterable) {
        kotlin.jvm.internal.e.f(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return 10;
    }
}
