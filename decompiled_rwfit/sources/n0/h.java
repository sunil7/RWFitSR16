package n0;

/* loaded from: classes.dex */
public final class h extends f {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ i f16356h;

    public h(i iVar) {
        this.f16356h = iVar;
    }

    @Override // n0.f
    public final String g() {
        androidx.concurrent.futures.b bVar = (androidx.concurrent.futures.b) this.f16356h.f16357a.get();
        if (bVar == null) {
            return "Completer object has been garbage collected, future will fail soon";
        }
        return "tag=[" + bVar.f1605a + "]";
    }
}
