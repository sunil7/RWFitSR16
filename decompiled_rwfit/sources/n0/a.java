package n0;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f16336b;

    /* renamed from: c, reason: collision with root package name */
    public static final a f16337c;

    /* renamed from: a, reason: collision with root package name */
    public final CancellationException f16338a;

    static {
        if (f.f16350d) {
            f16337c = null;
            f16336b = null;
        } else {
            f16337c = new a(false, null);
            f16336b = new a(true, null);
        }
    }

    public a(boolean z5, CancellationException cancellationException) {
        this.f16338a = cancellationException;
    }
}
