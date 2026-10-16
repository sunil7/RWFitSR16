package w0;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f19455a;

    public final void a(int i3, r rVar) {
        HashMap hashMap = this.f19455a;
        HashSet hashSet = (HashSet) hashMap.get(Integer.valueOf(i3));
        if (hashSet == null) {
            hashSet = new HashSet();
            hashMap.put(Integer.valueOf(i3), hashSet);
        }
        hashSet.add(new WeakReference(rVar));
    }
}
