package y0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class q implements Handler.Callback, ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final Context f19905a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f19906b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f19907c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public Set f19908d = new HashSet();

    public q(Context context) {
        this.f19905a = context;
        HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
        handlerThread.start();
        this.f19906b = new Handler(handlerThread.getLooper(), this);
    }

    public final void a(p pVar) {
        boolean z5;
        ArrayDeque arrayDeque;
        boolean isLoggable = Log.isLoggable("NotifManCompat", 3);
        ComponentName componentName = pVar.f19901a;
        if (isLoggable) {
            Log.d("NotifManCompat", "Processing component " + componentName + ", " + pVar.f19904d.size() + " queued tasks");
        }
        if (pVar.f19904d.isEmpty()) {
            return;
        }
        if (pVar.f19902b) {
            z5 = true;
        } else {
            Intent component = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(componentName);
            Context context = this.f19905a;
            boolean bindService = context.bindService(component, this, 33);
            pVar.f19902b = bindService;
            if (bindService) {
                pVar.e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + componentName);
                context.unbindService(this);
            }
            z5 = pVar.f19902b;
        }
        if (!z5 || pVar.f19903c == null) {
            b(pVar);
            return;
        }
        while (true) {
            arrayDeque = pVar.f19904d;
            n nVar = (n) arrayDeque.peek();
            if (nVar == null) {
                break;
            }
            try {
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Sending task " + nVar);
                }
                ((a.a) pVar.f19903c).g(nVar.f19896a, nVar.f19897b, nVar.f19898c);
                arrayDeque.remove();
            } catch (DeadObjectException unused) {
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Remote service has died: " + componentName);
                }
            } catch (RemoteException e) {
                Log.w("NotifManCompat", "RemoteException communicating with " + componentName, e);
            }
        }
        if (arrayDeque.isEmpty()) {
            return;
        }
        b(pVar);
    }

    public final void b(p pVar) {
        Handler handler = this.f19906b;
        ComponentName componentName = pVar.f19901a;
        if (handler.hasMessages(3, componentName)) {
            return;
        }
        int i3 = pVar.e;
        int i10 = i3 + 1;
        pVar.e = i10;
        if (i10 <= 6) {
            int i11 = (1 << i3) * 1000;
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Scheduling retry for " + i11 + " ms");
            }
            handler.sendMessageDelayed(handler.obtainMessage(3, componentName), i11);
            return;
        }
        StringBuilder sb2 = new StringBuilder("Giving up on delivering ");
        ArrayDeque arrayDeque = pVar.f19904d;
        sb2.append(arrayDeque.size());
        sb2.append(" tasks to ");
        sb2.append(componentName);
        sb2.append(" after ");
        sb2.append(pVar.e);
        sb2.append(" retries");
        Log.w("NotifManCompat", sb2.toString());
        arrayDeque.clear();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i3 = message.what;
        HashMap hashMap = this.f19907c;
        a.b bVar = null;
        Context context = this.f19905a;
        if (i3 == 0) {
            n nVar = (n) message.obj;
            Set a3 = r.a(context);
            if (!a3.equals(this.f19908d)) {
                this.f19908d = a3;
                List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                HashSet hashSet = new HashSet();
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (((HashSet) a3).contains(resolveInfo.serviceInfo.packageName)) {
                        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                        ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                        if (resolveInfo.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ComponentName componentName2 = (ComponentName) it.next();
                    if (!hashMap.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        hashMap.put(componentName2, new p(componentName2));
                    }
                }
                Iterator it2 = hashMap.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    if (!hashSet.contains(entry.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                        }
                        p pVar = (p) entry.getValue();
                        if (pVar.f19902b) {
                            context.unbindService(this);
                            pVar.f19902b = false;
                        }
                        pVar.f19903c = null;
                        it2.remove();
                    }
                }
            }
            for (p pVar2 : hashMap.values()) {
                pVar2.f19904d.add(nVar);
                a(pVar2);
            }
        } else if (i3 == 1) {
            o oVar = (o) message.obj;
            p pVar3 = (p) hashMap.get(oVar.f19899a);
            if (pVar3 != null) {
                int i10 = m.f19895a;
                IBinder iBinder = oVar.f19900b;
                if (iBinder != null) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof a.b)) {
                        a.a aVar = new a.a();
                        aVar.f1a = iBinder;
                        bVar = aVar;
                    } else {
                        bVar = (a.b) queryLocalInterface;
                    }
                }
                pVar3.f19903c = bVar;
                pVar3.e = 0;
                a(pVar3);
                return true;
            }
        } else if (i3 == 2) {
            p pVar4 = (p) hashMap.get((ComponentName) message.obj);
            if (pVar4 != null) {
                if (pVar4.f19902b) {
                    context.unbindService(this);
                    pVar4.f19902b = false;
                }
                pVar4.f19903c = null;
                return true;
            }
        } else {
            if (i3 != 3) {
                return false;
            }
            p pVar5 = (p) hashMap.get((ComponentName) message.obj);
            if (pVar5 != null) {
                a(pVar5);
                return true;
            }
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Connected to service " + componentName);
        }
        this.f19906b.obtainMessage(1, new o(componentName, iBinder)).sendToTarget();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("NotifManCompat", 3)) {
            Log.d("NotifManCompat", "Disconnected from service " + componentName);
        }
        this.f19906b.obtainMessage(2, componentName).sendToTarget();
    }
}
