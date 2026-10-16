package n;

import java.util.LinkedHashSet;
import java.util.Objects;

/* loaded from: classes.dex */
public final /* synthetic */ class k0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16241a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n0 f16242b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n0 f16243c;

    public /* synthetic */ k0(n0 n0Var, n0 n0Var2, int i3) {
        this.f16241a = i3;
        this.f16242b = n0Var;
        this.f16243c = n0Var2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16241a) {
            case 0:
                n0 n0Var = this.f16242b;
                Objects.requireNonNull(n0Var.f16261f);
                n0Var.f16261f.g(this.f16243c);
                return;
            default:
                n0 n0Var2 = this.f16242b;
                n0 n0Var3 = this.f16243c;
                g0 g0Var = n0Var2.f16258b;
                synchronized (g0Var.f16175b) {
                    ((LinkedHashSet) g0Var.f16176c).remove(n0Var2);
                    ((LinkedHashSet) g0Var.f16177d).remove(n0Var2);
                }
                n0Var2.g(n0Var3);
                if (n0Var2.f16262g != null) {
                    Objects.requireNonNull(n0Var2.f16261f);
                    n0Var2.f16261f.c(n0Var3);
                    return;
                } else {
                    com.google.android.gms.internal.mlkit_vision_common.a0.e("SyncCaptureSessionBase", "[" + n0Var2 + "] Cannot call onClosed() when the CameraCaptureSession is not correctly configured.");
                    return;
                }
        }
    }
}
