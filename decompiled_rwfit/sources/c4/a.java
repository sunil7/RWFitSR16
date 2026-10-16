package c4;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;

/* loaded from: classes.dex */
public final class a extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f3375a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar, Runnable runnable, String str) {
        super(runnable, str);
        this.f3375a = bVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(9);
        if (this.f3375a.f3377b) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
        }
        try {
            super.run();
        } catch (Throwable th2) {
            if (Log.isLoggable("GlideExecutor", 6)) {
                Log.e("GlideExecutor", "Request threw uncaught throwable", th2);
            }
        }
    }
}
