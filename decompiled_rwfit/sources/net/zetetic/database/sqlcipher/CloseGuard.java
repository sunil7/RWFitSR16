package net.zetetic.database.sqlcipher;

/* loaded from: classes2.dex */
public final class CloseGuard {

    /* renamed from: b, reason: collision with root package name */
    public static final CloseGuard f16471b = new CloseGuard();

    /* renamed from: c, reason: collision with root package name */
    public static volatile Reporter f16472c;

    /* renamed from: a, reason: collision with root package name */
    public Throwable f16473a;

    public static final class DefaultReporter implements Reporter {
    }

    public interface Reporter {
    }

    public final void a() {
        if (this != f16471b) {
            this.f16473a = new Throwable("Explicit termination method 'close' not called");
        }
    }
}
