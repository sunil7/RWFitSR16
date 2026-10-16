package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.activity.e;
import androidx.annotation.Keep;
import androidx.work.impl.utils.futures.b;
import o2.k;

/* loaded from: classes.dex */
public abstract class Worker extends ListenableWorker {

    /* renamed from: f, reason: collision with root package name */
    public b f3000f;

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.ListenableWorker
    public final b d() {
        this.f3000f = new b();
        this.f2993b.f3003c.execute(new e(this, 23));
        return this.f3000f;
    }

    public abstract k g();
}
