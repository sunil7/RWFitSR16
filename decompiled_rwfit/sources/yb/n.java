package yb;

/* loaded from: classes.dex */
public final class n implements com.google.gson.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f20082a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f20083b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.gson.k f20084c;

    public n(Class cls, Class cls2, com.google.gson.k kVar) {
        this.f20082a = cls;
        this.f20083b = cls2;
        this.f20084c = kVar;
    }

    @Override // com.google.gson.l
    public final com.google.gson.k a(com.google.gson.e eVar, bc.a aVar) {
        Class cls = this.f20082a;
        Class cls2 = aVar.f3203a;
        if (cls2 == cls || cls2 == this.f20083b) {
            return this.f20084c;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.f20083b.getName() + "+" + this.f20082a.getName() + ",adapter=" + this.f20084c + "]";
    }
}
