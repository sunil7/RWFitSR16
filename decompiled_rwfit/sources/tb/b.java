package tb;

import rb.f;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements rb.e {

    /* renamed from: b, reason: collision with root package name */
    public static final b f18596b = new b(0);

    /* renamed from: c, reason: collision with root package name */
    public static final b f18597c = new b(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18598a;

    public /* synthetic */ b(int i3) {
        this.f18598a = i3;
    }

    @Override // rb.a
    public final void a(Object obj, Object obj2) {
        switch (this.f18598a) {
            case 0:
                c cVar = d.e;
                ((f) obj2).b((String) obj);
                break;
            default:
                c cVar2 = d.e;
                ((f) obj2).c(((Boolean) obj).booleanValue());
                break;
        }
    }
}
