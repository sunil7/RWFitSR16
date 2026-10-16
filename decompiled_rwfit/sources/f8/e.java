package f8;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.appcompat.widget.b0;
import com.example.test.ui.device.activity.i0;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final g f13511a;

    /* renamed from: b, reason: collision with root package name */
    public final a8.b f13512b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13513c;

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f13514d;

    public e(g gVar, a8.b bVar, int i3, Runnable runnable) {
        this.f13511a = gVar;
        this.f13512b = bVar;
        this.f13513c = i3;
        this.f13514d = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g gVar = this.f13511a;
        a8.b bVar = this.f13512b;
        int i3 = this.f13513c;
        Runnable runnable = this.f13514d;
        try {
            try {
                h8.b bVar2 = gVar.f13524f;
                g8.c cVar = gVar.f13522c;
                cVar.getClass();
                ((g8.g) bVar2).f(new i0(cVar, 15));
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) gVar.f13520a.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    ((g8.g) gVar.f13524f).f(new b0(i3, gVar, bVar));
                } else {
                    gVar.a(bVar, i3);
                }
                runnable.run();
            } catch (SynchronizationException unused) {
                gVar.f13523d.a(bVar, i3 + 1, false);
                runnable.run();
            }
        } catch (Throwable th2) {
            runnable.run();
            throw th2;
        }
    }
}
