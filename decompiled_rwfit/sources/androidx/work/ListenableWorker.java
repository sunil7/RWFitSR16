package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.impl.utils.futures.b;

/* loaded from: classes.dex */
public abstract class ListenableWorker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2992a;

    /* renamed from: b, reason: collision with root package name */
    public final WorkerParameters f2993b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f2994c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2995d;
    public boolean e;

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.f2992a = context;
        this.f2993b = workerParameters;
    }

    public boolean a() {
        return this.e;
    }

    public void b() {
    }

    public abstract b d();

    public final void f() {
        this.f2994c = true;
        b();
    }
}
