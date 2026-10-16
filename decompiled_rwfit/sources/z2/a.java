package z2;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f20183c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f20184d;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f20185a;

    /* renamed from: b, reason: collision with root package name */
    public final CancellationException f20186b;

    static {
        if (g.f20200d) {
            f20184d = null;
            f20183c = null;
        } else {
            f20184d = new a(false, null);
            f20183c = new a(true, null);
        }
    }

    public a(boolean z5, CancellationException cancellationException) {
        this.f20185a = z5;
        this.f20186b = cancellationException;
    }
}
