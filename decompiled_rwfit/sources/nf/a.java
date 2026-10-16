package nf;

import com.google.android.gms.internal.mlkit_vision_barcode.xc;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class a implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16594a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f16595b;

    public /* synthetic */ a(Runnable runnable, int i3) {
        this.f16594a = i3;
        this.f16595b = runnable;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f16594a) {
            case 0:
                this.f16595b.run();
                return xc.c(null);
            default:
                this.f16595b.run();
                return null;
        }
    }
}
