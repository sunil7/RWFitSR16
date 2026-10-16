package i1;

import android.content.Context;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class c implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14334a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f14335b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f14336c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ androidx.camera.core.impl.e f14337d;
    public final /* synthetic */ int e;

    public /* synthetic */ c(String str, Context context, androidx.camera.core.impl.e eVar, int i3, int i10) {
        this.f14334a = i10;
        this.f14335b = str;
        this.f14336c = context;
        this.f14337d = eVar;
        this.e = i3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f14334a) {
            case 0:
                return e.a(this.f14335b, this.f14336c, this.f14337d, this.e);
            default:
                try {
                    return e.a(this.f14335b, this.f14336c, this.f14337d, this.e);
                } catch (Throwable unused) {
                    return new d(-3);
                }
        }
    }
}
