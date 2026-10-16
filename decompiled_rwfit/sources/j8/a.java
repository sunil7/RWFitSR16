package j8;

import android.util.SparseArray;
import com.google.android.datatransport.Priority;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray f15369a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f15370b;

    static {
        HashMap hashMap = new HashMap();
        f15370b = hashMap;
        hashMap.put(Priority.DEFAULT, 0);
        hashMap.put(Priority.VERY_LOW, 1);
        hashMap.put(Priority.HIGHEST, 2);
        for (Priority priority : hashMap.keySet()) {
            f15369a.append(((Integer) f15370b.get(priority)).intValue(), priority);
        }
    }

    public static int a(Priority priority) {
        Integer num = (Integer) f15370b.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    public static Priority b(int i3) {
        Priority priority = (Priority) f15369a.get(i3);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException(l0.j(i3, "Unknown Priority for value "));
    }
}
