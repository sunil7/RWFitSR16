package c4;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public final class b implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    public final String f3376a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3377b;

    /* renamed from: c, reason: collision with root package name */
    public int f3378c;

    public b(String str, boolean z5) {
        this.f3376a = str;
        this.f3377b = z5;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final synchronized Thread newThread(Runnable runnable) {
        a aVar;
        aVar = new a(this, runnable, "glide-" + this.f3376a + "-thread-" + this.f3378c);
        this.f3378c = this.f3378c + 1;
        return aVar;
    }
}
