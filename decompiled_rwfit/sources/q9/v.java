package q9;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class v implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f17845a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public int f17846b = 2;

    /* renamed from: c, reason: collision with root package name */
    public boolean f17847c;

    /* renamed from: d, reason: collision with root package name */
    public IBinder f17848d;
    public final u e;

    /* renamed from: f, reason: collision with root package name */
    public ComponentName f17849f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ x f17850g;

    public v(x xVar, u uVar) {
        this.f17850g = xVar;
        this.e = uVar;
    }

    public final void a(String str, Executor executor) {
        StrictMode.VmPolicy.Builder permitUnsafeIntentLaunch;
        this.f17846b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (Build.VERSION.SDK_INT >= 31) {
            permitUnsafeIntentLaunch = new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch();
            StrictMode.setVmPolicy(permitUnsafeIntentLaunch.build());
        }
        try {
            x xVar = this.f17850g;
            y9.a aVar = xVar.f17858d;
            Context context = xVar.f17856b;
            try {
                boolean b3 = aVar.b(context, str, this.e.a(context), this, executor);
                this.f17847c = b3;
                if (b3) {
                    this.f17850g.f17857c.sendMessageDelayed(this.f17850g.f17857c.obtainMessage(1, this.e), this.f17850g.f17859f);
                } else {
                    this.f17846b = 2;
                    try {
                        x xVar2 = this.f17850g;
                        xVar2.f17858d.a(xVar2.f17856b, this);
                    } catch (IllegalArgumentException unused) {
                    }
                }
                StrictMode.setVmPolicy(vmPolicy);
            } catch (Throwable th2) {
                th = th2;
                Throwable th3 = th;
                StrictMode.setVmPolicy(vmPolicy);
                throw th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f17850g.f17855a) {
            try {
                this.f17850g.f17857c.removeMessages(1, this.e);
                this.f17848d = iBinder;
                this.f17849f = componentName;
                Iterator it = this.f17845a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f17846b = 1;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f17850g.f17855a) {
            try {
                this.f17850g.f17857c.removeMessages(1, this.e);
                this.f17848d = null;
                this.f17849f = componentName;
                Iterator it = this.f17845a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f17846b = 2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
