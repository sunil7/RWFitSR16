package androidx.appcompat.widget;

/* loaded from: classes.dex */
public final class g0 extends x1 {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ o0 f902j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ AppCompatSpinner f903k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(AppCompatSpinner appCompatSpinner, AppCompatSpinner appCompatSpinner2, o0 o0Var) {
        super(appCompatSpinner2);
        this.f903k = appCompatSpinner;
        this.f902j = o0Var;
    }

    @Override // androidx.appcompat.widget.x1
    public final h.b0 b() {
        return this.f902j;
    }

    @Override // androidx.appcompat.widget.x1
    public final boolean c() {
        AppCompatSpinner appCompatSpinner = this.f903k;
        if (appCompatSpinner.getInternalPopup().a()) {
            return true;
        }
        appCompatSpinner.f719f.k(i0.b(appCompatSpinner), i0.a(appCompatSpinner));
        return true;
    }
}
