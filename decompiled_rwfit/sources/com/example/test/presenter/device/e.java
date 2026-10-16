package com.example.test.presenter.device;

/* loaded from: classes.dex */
public final class e implements u5.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f7420a;

    public e(g gVar) {
        this.f7420a = gVar;
    }

    @Override // u5.i
    public final void a(int i3) {
        this.f7420a.r(i3);
    }

    @Override // u5.i
    public final void b(float f2) {
        this.f7420a.s(f2 * 100);
    }

    @Override // u5.i
    public final void onFinish() {
        this.f7420a.t();
    }
}
