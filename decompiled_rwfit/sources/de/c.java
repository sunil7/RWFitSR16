package de;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12348a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f12349b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f12350c;

    public /* synthetic */ c(int i3, boolean z5, boolean z6) {
        this.f12348a = i3;
        this.f12349b = z5;
        this.f12350c = z6;
    }

    @Override // de.l
    public final void k(Object obj) {
        rd.c cVar = (rd.c) obj;
        switch (this.f12348a) {
            case 0:
                cVar.q(this.f12349b, this.f12350c);
                break;
            default:
                cVar.o(this.f12349b, this.f12350c);
                break;
        }
    }
}
