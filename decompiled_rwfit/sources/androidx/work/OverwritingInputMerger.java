package androidx.work;

import d4.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import o2.f;
import o2.h;

/* loaded from: classes.dex */
public final class OverwritingInputMerger extends h {
    @Override // o2.h
    public final f a(ArrayList arrayList) {
        t tVar = new t(2);
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            hashMap.putAll(Collections.unmodifiableMap(((f) obj).f16711a));
        }
        tVar.b(hashMap);
        f fVar = new f(tVar.f12284a);
        f.b(fVar);
        return fVar;
    }
}
