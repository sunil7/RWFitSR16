package o;

import android.hardware.camera2.params.DynamicRangeProfiles;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import t.t;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f16616a;

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f16617b;

    static {
        t tVar;
        HashMap hashMap = new HashMap();
        f16616a = hashMap;
        HashMap hashMap2 = new HashMap();
        f16617b = hashMap2;
        t tVar2 = t.f18406d;
        hashMap.put(1L, tVar2);
        hashMap2.put(tVar2, Collections.singletonList(1L));
        hashMap.put(2L, t.e);
        hashMap2.put((t) hashMap.get(2L), Collections.singletonList(2L));
        t tVar3 = t.f18407f;
        hashMap.put(4L, tVar3);
        hashMap2.put(tVar3, Collections.singletonList(4L));
        t tVar4 = t.f18408g;
        hashMap.put(8L, tVar4);
        hashMap2.put(tVar4, Collections.singletonList(8L));
        List asList = Arrays.asList(64L, 128L, 16L, 32L);
        Iterator it = asList.iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            tVar = t.f18409h;
            if (!hasNext) {
                break;
            }
            f16616a.put((Long) it.next(), tVar);
        }
        f16617b.put(tVar, asList);
        List asList2 = Arrays.asList(1024L, 2048L, 256L, 512L);
        Iterator it2 = asList2.iterator();
        while (true) {
            boolean hasNext2 = it2.hasNext();
            t tVar5 = t.f18410i;
            if (!hasNext2) {
                f16617b.put(tVar5, asList2);
                return;
            } else {
                f16616a.put((Long) it2.next(), tVar5);
            }
        }
    }

    public static Long a(t tVar, DynamicRangeProfiles dynamicRangeProfiles) {
        Set supportedProfiles;
        List<Long> list = (List) f16617b.get(tVar);
        if (list == null) {
            return null;
        }
        supportedProfiles = dynamicRangeProfiles.getSupportedProfiles();
        for (Long l3 : list) {
            if (supportedProfiles.contains(l3)) {
                return l3;
            }
        }
        return null;
    }
}
