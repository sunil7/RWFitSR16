package g3;

/* loaded from: classes.dex */
public final class d implements a {

    /* renamed from: a, reason: collision with root package name */
    public final int f13803a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13804b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13805c;

    public d(int i3, int i10, int i11) {
        this.f13803a = i3;
        this.f13804b = i10;
        this.f13805c = i11;
    }

    @Override // g3.a
    public final int a() {
        return this.f13805c;
    }

    @Override // g3.a
    public final long getId() {
        return f.b(this.f13803a, this.f13804b);
    }
}
