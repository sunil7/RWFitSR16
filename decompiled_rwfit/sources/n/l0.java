package n;

import android.hardware.camera2.CameraCaptureSession;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final /* synthetic */ class l0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16248a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n0 f16249b;

    public /* synthetic */ l0(n0 n0Var, int i3) {
        this.f16248a = i3;
        this.f16249b = n0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16248a) {
            case 0:
                n0 n0Var = this.f16249b;
                n0Var.g(n0Var);
                return;
            default:
                n0 n0Var2 = this.f16249b;
                n0Var2.l("Session call super.close()");
                pd.e(n0Var2.f16262g, "Need to call openCaptureSession before using this API.");
                g0 g0Var = n0Var2.f16258b;
                synchronized (g0Var.f16175b) {
                    ((LinkedHashSet) g0Var.f16177d).add(n0Var2);
                }
                ((CameraCaptureSession) ((ef.i) n0Var2.f16262g.f19953b).f12629b).close();
                n0Var2.f16260d.execute(new l0(n0Var2, 0));
                return;
        }
    }
}
