package kotlin.collections;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;

/* loaded from: classes2.dex */
public abstract class p {
    public static Map a() {
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        kotlin.jvm.internal.e.d(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return emptyMap;
    }

    public static int b(int i3) {
        return i3 < 0 ? i3 : i3 < 3 ? i3 + 1 : i3 < 1073741824 ? (int) ((i3 / 0.75f) + 1.0f) : SubsamplingScaleImageView.TILE_SIZE_AUTO;
    }

    public static Map c(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return a();
        }
        if (size == 1) {
            Pair pair = (Pair) arrayList.get(0);
            kotlin.jvm.internal.e.f(pair, "pair");
            Map singletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
            kotlin.jvm.internal.e.e(singletonMap, "singletonMap(pair.first, pair.second)");
            return singletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(b(arrayList.size()));
        int size2 = arrayList.size();
        int i3 = 0;
        while (i3 < size2) {
            Object obj = arrayList.get(i3);
            i3++;
            Pair pair2 = (Pair) obj;
            linkedHashMap.put(pair2.component1(), pair2.component2());
        }
        return linkedHashMap;
    }

    public static final Map d(LinkedHashMap linkedHashMap) {
        kotlin.jvm.internal.e.f(linkedHashMap, "<this>");
        Map.Entry entry = (Map.Entry) linkedHashMap.entrySet().iterator().next();
        Map singletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        kotlin.jvm.internal.e.e(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }
}
