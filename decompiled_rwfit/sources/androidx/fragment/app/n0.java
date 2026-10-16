package androidx.fragment.app;

/* loaded from: classes.dex */
public final class n0 implements w0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fragment f2227a;

    public n0(Fragment fragment) {
        this.f2227a = fragment;
    }

    @Override // androidx.fragment.app.w0
    public final void a(Fragment fragment) {
        this.f2227a.onAttachFragment(fragment);
    }
}
