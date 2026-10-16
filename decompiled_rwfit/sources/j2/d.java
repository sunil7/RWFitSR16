package j2;

import android.view.ViewGroup;
import com.google.android.gms.internal.mlkit_vision_barcode.kd;

/* loaded from: classes.dex */
public final class d extends g0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f15188a = false;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f15189b;

    public d(ViewGroup viewGroup) {
        this.f15189b = viewGroup;
    }

    @Override // j2.g0, j2.e0
    public final void b() {
        kd.a(this.f15189b, false);
    }

    @Override // j2.g0, j2.e0
    public final void c() {
        kd.a(this.f15189b, true);
    }

    @Override // j2.g0, j2.e0
    public final void d() {
        kd.a(this.f15189b, false);
        this.f15188a = true;
    }

    @Override // j2.e0
    public final void e(f0 f0Var) {
        if (!this.f15188a) {
            kd.a(this.f15189b, false);
        }
        f0Var.w(this);
    }
}
