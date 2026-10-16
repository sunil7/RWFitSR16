package com.dh.keeplive.ext;

import android.app.ActivityManager;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import androidx.appcompat.app.i0;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.dh.keeplive.entity.DefaultConfig;
import com.dh.keeplive.entity.KeepLiveConfig;
import com.dh.keeplive.entity.KeepLiveConstant;
import com.dh.keeplive.receiver.StopReceiver;
import com.dh.keeplive.service.KeepLiveJobService;
import com.dh.keeplive.service.LocalService;
import com.dh.keeplive.service.RemoteService;
import com.dh.keeplive.workmanager.KeepLiveWorker;
import com.google.android.gms.internal.mlkit_vision_barcode.af;
import com.google.android.gms.internal.mlkit_vision_barcode.bf;
import eh.b;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.e;
import m5.c;
import p2.l;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static WeakReference f7209a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f7210b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f7211c;

    /* renamed from: d, reason: collision with root package name */
    public static final b f7212d = kotlin.a.b(new oh.a() { // from class: com.dh.keeplive.ext.KeepLiveExtKt$sMainHandler$2
        @Override // oh.a
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });
    public static int e;

    /* renamed from: f, reason: collision with root package name */
    public static int f7213f;

    /* renamed from: g, reason: collision with root package name */
    public static KeepLiveConfig f7214g;

    /* renamed from: h, reason: collision with root package name */
    public static c f7215h;

    public static final String a(String str) {
        return "com.xj.keeplive." + str + "." + (Process.myUid() <= 0 ? Process.myPid() : Process.myUid());
    }

    public static final Handler b() {
        return (Handler) f7212d.getValue();
    }

    public static final boolean c(Context context) {
        boolean z5;
        e.f(context, "<this>");
        String name = LocalService.class.getName();
        Object systemService = context.getSystemService(Const.STR_PROCESS_TAG);
        e.d(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) systemService).getRunningServices(SubsamplingScaleImageView.TILE_SIZE_AUTO);
        boolean z6 = false;
        if (runningServices != null) {
            Iterator<ActivityManager.RunningServiceInfo> it = runningServices.iterator();
            while (it.hasNext()) {
                if (name.equals(it.next().service.getClassName())) {
                    z5 = true;
                    break;
                }
            }
        }
        z5 = false;
        Object systemService2 = context.getSystemService(Const.STR_PROCESS_TAG);
        e.d(systemService2, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService2).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<T> it2 = runningAppProcesses.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (e.a(((ActivityManager.RunningAppProcessInfo) it2.next()).processName, context.getPackageName() + ":keepLiveRemoteService")) {
                    z6 = true;
                    break;
                }
            }
        }
        return z5 & z6;
    }

    public static final void d(String msg) {
        DefaultConfig defaultConfig;
        e.f(msg, "msg");
        KeepLiveConfig keepLiveConfig = f7214g;
        if (keepLiveConfig == null || (defaultConfig = keepLiveConfig.getDefaultConfig()) == null) {
            Log.v(KeepLiveConstant.KEEP_LIVE_TAG, msg);
        } else if (defaultConfig.getDebug()) {
            Log.e(KeepLiveConstant.KEEP_LIVE_TAG, msg);
        }
    }

    public static final void e(Context context, KeepLiveConfig keepLiveConfig) {
        e.f(context, "<this>");
        d("Context.registe " + bf.a(context) + " mAppBackgroundCallback " + f7215h);
        if (bf.a(context)) {
            try {
                if (f7211c && c(context)) {
                    d("keeplive is running，Please stop keeplive before registering!!");
                    return;
                }
                f7213f++;
                f7211c = true;
                DefaultConfig defaultConfig = keepLiveConfig.getDefaultConfig();
                if (defaultConfig.getCrashRestartEnabled()) {
                    defaultConfig.setRestartIntent(context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()));
                    Intent restartIntent = defaultConfig.getRestartIntent();
                    if (restartIntent != null) {
                        restartIntent.addFlags(536870912);
                        restartIntent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
                    }
                } else {
                    defaultConfig.setRestartIntent(null);
                }
                af.b(context, keepLiveConfig);
                Intent intent = new Intent(context, (Class<?>) KeepLiveJobService.class);
                intent.putExtra(KeepLiveConstant.KEEP_LIVE_CONFIG, keepLiveConfig);
                context.startForegroundService(intent);
                if ((context instanceof Application) && f7215h == null) {
                    c cVar = new c();
                    cVar.f15978f = context;
                    cVar.f15977d = true;
                    cVar.e = true;
                    b().postDelayed(new m5.a(cVar, 0), 1000L);
                    f7215h = cVar;
                    ((Application) context).registerActivityLifecycleCallbacks(cVar);
                }
                c cVar2 = f7215h;
                if (cVar2 != null) {
                    cVar2.e = true;
                }
            } catch (Exception unused) {
                d("Unable to open cactus service!!");
            }
        }
    }

    public static final void f(KeepLiveJobService keepLiveJobService, KeepLiveConfig keepLiveConfig) {
        e.f(keepLiveConfig, "keepLiveConfig");
        Intent intent = new Intent(keepLiveJobService, (Class<?>) LocalService.class);
        intent.putExtra(KeepLiveConstant.KEEP_LIVE_CONFIG, keepLiveConfig);
        keepLiveJobService.startForegroundService(intent);
        b().postDelayed(new i0(29, keepLiveConfig, keepLiveJobService), 5000L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(Context context, oh.a aVar) {
        new StopReceiver(context).f7217b = (Lambda) aVar;
    }

    public static final boolean h(Service service, Class cls, ServiceConnection serviceConnection, KeepLiveConfig keepLiveConfig, boolean z5) {
        Intent intent = new Intent(service, (Class<?>) cls);
        intent.putExtra(KeepLiveConstant.KEEP_LIVE_CONFIG, keepLiveConfig);
        if (z5) {
            try {
                e.f(service, "<this>");
                service.startForegroundService(intent);
            } catch (Exception e10) {
                Log.e("qob", "startInternService " + e10);
            }
        }
        return service.bindService(intent, serviceConnection, 64);
    }

    public static final boolean i(Service service, ServiceConnection serviceConnection, KeepLiveConfig keepLiveConfig) {
        e.f(service, "<this>");
        e.f(serviceConnection, "serviceConnection");
        e.f(keepLiveConfig, "keepLiveConfig");
        return h(service, RemoteService.class, serviceConnection, keepLiveConfig, true);
    }

    public static final void j(Service service) {
        e.f(service, "<this>");
        b().postDelayed(new m5.a(service, 7), 1000L);
    }

    public static final void k(IBinder.DeathRecipient deathRecipient, IInterface iInterface, oh.a aVar) {
        IBinder asBinder;
        if (iInterface != null && (asBinder = iInterface.asBinder()) != null) {
            asBinder.unlinkToDeath(deathRecipient, 0);
        }
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public static final void l(ContextWrapper contextWrapper) {
        l a3 = l.a(contextWrapper);
        y2.b bVar = new y2.b(a3, KeepLiveWorker.class.getName(), true);
        a3.f17428d.p(bVar);
        e.e(bVar.f19944a, "cancelUniqueWork(...)");
    }
}
