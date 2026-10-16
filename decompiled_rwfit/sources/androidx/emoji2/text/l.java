package androidx.emoji2.text;

import com.google.android.gms.internal.mlkit_vision_barcode.q0;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public final class l extends q0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q0 f2044a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f2045b;

    public l(q0 q0Var, ThreadPoolExecutor threadPoolExecutor) {
        this.f2044a = q0Var;
        this.f2045b = threadPoolExecutor;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.q0
    public final void a(Throwable th2) {
        ThreadPoolExecutor threadPoolExecutor = this.f2045b;
        try {
            this.f2044a.a(th2);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.q0
    public final void b(v2.h hVar) {
        ThreadPoolExecutor threadPoolExecutor = this.f2045b;
        try {
            this.f2044a.b(hVar);
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
