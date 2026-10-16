package wf;

/* loaded from: classes2.dex */
public final class d implements g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f19629a;

    public d(float f2) {
        this.f19629a = f2;
    }

    @Override // wf.g
    public final boolean a(b bVar) {
        float c9 = a.a(bVar.f19627a, bVar.f19628b).c();
        float f2 = this.f19629a;
        return c9 >= f2 - 0.0f && c9 <= f2 + 0.0f;
    }
}
