package r2;

import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import o2.m;
import y2.i;
import y2.k;

/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18038a;

    /* renamed from: b, reason: collision with root package name */
    public final g f18039b;

    public /* synthetic */ f(g gVar, int i3) {
        this.f18038a = i3;
        this.f18039b = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g gVar;
        f fVar;
        boolean isEmpty;
        boolean isEmpty2;
        switch (this.f18038a) {
            case 0:
                synchronized (this.f18039b.f18047h) {
                    g gVar2 = this.f18039b;
                    gVar2.f18048i = (Intent) gVar2.f18047h.get(0);
                }
                Intent intent = this.f18039b.f18048i;
                if (intent != null) {
                    String action = intent.getAction();
                    int intExtra = this.f18039b.f18048i.getIntExtra("KEY_START_ID", 0);
                    m g10 = m.g();
                    String str = g.f18040k;
                    g10.d(str, String.format("Processing command %s, %s", this.f18039b.f18048i, Integer.valueOf(intExtra)), new Throwable[0]);
                    PowerManager.WakeLock a3 = k.a(this.f18039b.f18041a, action + " (" + intExtra + ")");
                    try {
                        m.g().d(str, "Acquiring operation wake lock (" + action + ") " + a3, new Throwable[0]);
                        a3.acquire();
                        g gVar3 = this.f18039b;
                        gVar3.f18045f.d(gVar3.f18048i, intExtra, gVar3);
                        m.g().d(str, "Releasing operation wake lock (" + action + ") " + a3, new Throwable[0]);
                        a3.release();
                        gVar = this.f18039b;
                        fVar = new f(gVar, 1);
                    } catch (Throwable th2) {
                        try {
                            m g11 = m.g();
                            String str2 = g.f18040k;
                            g11.f(str2, "Unexpected error in onHandleIntent", th2);
                            m.g().d(str2, "Releasing operation wake lock (" + action + ") " + a3, new Throwable[0]);
                            a3.release();
                            gVar = this.f18039b;
                            fVar = new f(gVar, 1);
                        } catch (Throwable th3) {
                            m.g().d(g.f18040k, "Releasing operation wake lock (" + action + ") " + a3, new Throwable[0]);
                            a3.release();
                            g gVar4 = this.f18039b;
                            gVar4.e(new f(gVar4, 1));
                            throw th3;
                        }
                    }
                    gVar.e(fVar);
                    return;
                }
                return;
            default:
                g gVar5 = this.f18039b;
                gVar5.getClass();
                m g12 = m.g();
                String str3 = g.f18040k;
                g12.d(str3, "Checking if commands are complete.", new Throwable[0]);
                gVar5.c();
                synchronized (gVar5.f18047h) {
                    try {
                        if (gVar5.f18048i != null) {
                            m.g().d(str3, String.format("Removing command %s", gVar5.f18048i), new Throwable[0]);
                            if (!((Intent) gVar5.f18047h.remove(0)).equals(gVar5.f18048i)) {
                                throw new IllegalStateException("Dequeue-d command is not the first.");
                            }
                            gVar5.f18048i = null;
                        }
                        i iVar = (i) gVar5.f18042b.f12377b;
                        b bVar = gVar5.f18045f;
                        synchronized (bVar.f18023c) {
                            isEmpty = bVar.f18022b.isEmpty();
                        }
                        if (isEmpty && gVar5.f18047h.isEmpty()) {
                            synchronized (iVar.f19958c) {
                                isEmpty2 = iVar.f19956a.isEmpty();
                            }
                            if (isEmpty2) {
                                m.g().d(str3, "No more commands & intents.", new Throwable[0]);
                                SystemAlarmService systemAlarmService = gVar5.f18049j;
                                if (systemAlarmService != null) {
                                    systemAlarmService.a();
                                }
                            }
                        }
                        if (!gVar5.f18047h.isEmpty()) {
                            gVar5.f();
                        }
                    } catch (Throwable th4) {
                        throw th4;
                    }
                }
                return;
        }
    }
}
