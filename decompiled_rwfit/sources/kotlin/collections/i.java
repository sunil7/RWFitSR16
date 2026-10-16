package kotlin.collections;

import com.google.android.gms.internal.mlkit_vision_barcode.wd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class i extends wd {
    public static ArrayList b(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new f(objArr, true));
    }

    public static int c(List list) {
        kotlin.jvm.internal.e.f(list, "<this>");
        return list.size() - 1;
    }

    public static List d(Object... elements) {
        kotlin.jvm.internal.e.f(elements, "elements");
        if (elements.length <= 0) {
            return EmptyList.INSTANCE;
        }
        List asList = Arrays.asList(elements);
        kotlin.jvm.internal.e.e(asList, "asList(this)");
        return asList;
    }

    public static ArrayList e(Object... elements) {
        kotlin.jvm.internal.e.f(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new f(elements, true));
    }

    public static void f() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
