package ab;

import com.google.android.material.progressindicator.BaseProgressIndicator;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f149a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseProgressIndicator f150b;

    public /* synthetic */ c(BaseProgressIndicator baseProgressIndicator, int i3) {
        this.f149a = i3;
        this.f150b = baseProgressIndicator;
    }

    public final void a() {
        switch (this.f149a) {
            case 0:
                BaseProgressIndicator baseProgressIndicator = this.f150b;
                baseProgressIndicator.setIndeterminate(false);
                baseProgressIndicator.b(0);
                baseProgressIndicator.b(baseProgressIndicator.f10707b);
                break;
            default:
                BaseProgressIndicator baseProgressIndicator2 = this.f150b;
                if (!baseProgressIndicator2.f10710f) {
                    baseProgressIndicator2.setVisibility(baseProgressIndicator2.f10711g);
                    break;
                }
                break;
        }
    }
}
