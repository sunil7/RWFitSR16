package q9;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: g, reason: collision with root package name */
    public static final Object f17852g = new Object();

    /* renamed from: h, reason: collision with root package name */
    public static x f17853h;

    /* renamed from: i, reason: collision with root package name */
    public static HandlerThread f17854i;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f17855a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Context f17856b;

    /* renamed from: c, reason: collision with root package name */
    public volatile c5.b f17857c;

    /* renamed from: d, reason: collision with root package name */
    public final y9.a f17858d;
    public final long e;

    /* renamed from: f, reason: collision with root package name */
    public final long f17859f;

    public x(Looper looper, Context context) {
        w wVar = new w(this);
        this.f17856b = context.getApplicationContext();
        c5.b bVar = new c5.b(looper, wVar, 3);
        Looper.getMainLooper();
        this.f17857c = bVar;
        if (y9.a.f20040b == null) {
            synchronized (y9.a.f20039a) {
                try {
                    if (y9.a.f20040b == null) {
                        y9.a aVar = new y9.a();
                        new ConcurrentHashMap();
                        y9.a.f20040b = aVar;
                    }
                } finally {
                }
            }
        }
        y9.a aVar2 = y9.a.f20040b;
        n.e(aVar2);
        this.f17858d = aVar2;
        this.e = 5000L;
        this.f17859f = Const.L_GPS_REBOOT_INTERVAL;
    }

    public final void a(String str, ServiceConnection serviceConnection, boolean z5) {
        u uVar = new u(str, z5);
        n.f(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f17855a) {
            try {
                v vVar = (v) this.f17855a.get(uVar);
                if (vVar == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: ".concat(uVar.toString()));
                }
                if (!vVar.f17845a.containsKey(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=".concat(uVar.toString()));
                }
                vVar.f17845a.remove(serviceConnection);
                if (vVar.f17845a.isEmpty()) {
                    this.f17857c.sendMessageDelayed(this.f17857c.obtainMessage(0, uVar), this.e);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean b(u uVar, r rVar, String str) {
        boolean z5;
        synchronized (this.f17855a) {
            try {
                v vVar = (v) this.f17855a.get(uVar);
                if (vVar == null) {
                    vVar = new v(this, uVar);
                    vVar.f17845a.put(rVar, rVar);
                    vVar.a(str, null);
                    this.f17855a.put(uVar, vVar);
                } else {
                    this.f17857c.removeMessages(0, uVar);
                    if (vVar.f17845a.containsKey(rVar)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=".concat(uVar.toString()));
                    }
                    vVar.f17845a.put(rVar, rVar);
                    int i3 = vVar.f17846b;
                    if (i3 == 1) {
                        rVar.onServiceConnected(vVar.f17849f, vVar.f17848d);
                    } else if (i3 == 2) {
                        vVar.a(str, null);
                    }
                }
                z5 = vVar.f17847c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z5;
    }
}
