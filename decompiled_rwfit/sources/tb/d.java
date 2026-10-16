package tb;

import java.util.Date;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class d implements sb.a {
    public static final c e = new c();

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f18600a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f18601b;

    /* renamed from: c, reason: collision with root package name */
    public final a f18602c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f18603d;

    public d() {
        HashMap hashMap = new HashMap();
        this.f18600a = hashMap;
        HashMap hashMap2 = new HashMap();
        this.f18601b = hashMap2;
        this.f18602c = a.f18595a;
        this.f18603d = false;
        hashMap2.put(String.class, b.f18596b);
        hashMap.remove(String.class);
        hashMap2.put(Boolean.class, b.f18597c);
        hashMap.remove(Boolean.class);
        hashMap2.put(Date.class, e);
        hashMap.remove(Date.class);
    }

    @Override // sb.a
    public final sb.a a(Class cls, rb.c cVar) {
        this.f18600a.put(cls, cVar);
        this.f18601b.remove(cls);
        return this;
    }
}
