package com.example.test;

import a2.d;
import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import com.dh.keeplive.entity.KeepLiveConfig;
import com.dh.keeplive.entity.KeepLiveConstant;
import com.dh.keeplive.entity.NotificationConfig;
import com.example.database.api.DBManger;
import com.example.database.table.User;
import com.example.test.service.BluetoothBroadcastReceiver;
import com.example.test.service.LangService;
import com.example.test.service.NotificationService;
import com.example.test.service.PhoneReceiver;
import com.example.test.service.VolumeKeyReceiver;
import com.example.test.service.e;
import com.example.test.service.g0;
import com.example.test.utils.k;
import com.google.android.gms.internal.mlkit_vision_barcode.c2;
import com.google.android.gms.internal.mlkit_vision_barcode.ee;
import com.google.android.gms.internal.mlkit_vision_barcode.l1;
import com.google.android.gms.internal.mlkit_vision_barcode.u1;
import com.google.android.gms.internal.mlkit_vision_common.n6;
import com.liulishuo.filedownloader.download.c;
import com.tencent.mmkv.MMKV;
import de.i;
import eh.g;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Stack;
import kotlin.text.m;
import oh.l;

/* loaded from: classes.dex */
public final class XXApplication extends Application {

    /* renamed from: h, reason: collision with root package name */
    public static XXApplication f7400h;

    /* renamed from: b, reason: collision with root package name */
    public Activity f7402b;

    /* renamed from: d, reason: collision with root package name */
    public int f7404d;
    public boolean e;

    /* renamed from: a, reason: collision with root package name */
    public boolean f7401a = true;

    /* renamed from: c, reason: collision with root package name */
    public final Stack f7403c = new Stack();

    /* renamed from: f, reason: collision with root package name */
    public final a f7405f = new a(this);

    /* renamed from: g, reason: collision with root package name */
    public final b f7406g = new b();

    public final void a() {
        Log.e("qob", "clearActivity 1111");
        Iterator it = this.f7403c.iterator();
        while (it.hasNext()) {
            ((Activity) it.next()).finish();
        }
    }

    public final void b(String str) {
        Log.e("qob", "clearActivity 2222");
        for (Activity activity : this.f7403c) {
            if (!activity.getClass().getName().equals(str)) {
                activity.finish();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0018, code lost:
    
        if (r0.isDestroyed() != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.app.Activity c() {
        /*
            r2 = this;
            android.app.Activity r0 = r2.f7402b
            if (r0 == 0) goto L1e
            if (r0 == 0) goto L1b
            kotlin.jvm.internal.e.c(r0)
            boolean r0 = r0.isFinishing()
            if (r0 != 0) goto L1e
            android.app.Activity r0 = r2.f7402b
            kotlin.jvm.internal.e.c(r0)
            boolean r0 = r0.isDestroyed()
            if (r0 == 0) goto L1b
            goto L1e
        L1b:
            android.app.Activity r0 = r2.f7402b
            return r0
        L1e:
            java.util.Stack r0 = r2.f7403c
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L28
            r0 = 0
            return r0
        L28:
            java.lang.Object r0 = r0.lastElement()
            android.app.Activity r0 = (android.app.Activity) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.XXApplication.c():android.app.Activity");
    }

    public final void d() {
        if (u1.b(this)) {
            e.h();
            try {
                g();
            } catch (Exception e) {
                Log.e("qob", "toggleNotificationListenerService " + e);
            }
            try {
                PhoneReceiver.a(this);
                d.b().t();
            } catch (Exception e10) {
                Log.e("qob", "PhoneReceiver " + e10);
            }
            int i3 = BluetoothBroadcastReceiver.f7640a;
            registerReceiver(new BluetoothBroadcastReceiver(), new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        }
    }

    public final void e() {
        n6.f10047a = getApplicationContext();
        eb.e eVar = new eb.e(22);
        i iVar = c.f11405a;
        synchronized (iVar) {
            iVar.f12357b = new n6.a(eVar, 22);
            iVar.f12359d = null;
            iVar.e = null;
            iVar.f12360f = null;
            iVar.f12361g = null;
        }
    }

    public final void f() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BaseApplication", "XXApplication initKeepLive");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", getPackageName(), null));
        final PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 67108864);
        l lVar = new l() { // from class: com.example.test.XXApplication$initKeepLive$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((com.dh.keeplive.a) obj);
                return g.f12633a;
            }

            public final void invoke(com.dh.keeplive.a keepLive) {
                kotlin.jvm.internal.e.f(keepLive, "$this$keepLive");
                PendingIntent pendingIntent = activity;
                kotlin.jvm.internal.e.e(pendingIntent, "$pendingIntent");
                NotificationConfig notificationConfig = keepLive.f7205a;
                notificationConfig.setPendingIntent(pendingIntent);
                String string = this.getString(R$string.app_name);
                kotlin.jvm.internal.e.e(string, "getString(...)");
                notificationConfig.setChannelId(string);
                String string2 = this.getString(R$string.app_name);
                kotlin.jvm.internal.e.e(string2, "getString(...)");
                notificationConfig.setChannelName(string2);
                String string3 = this.getString(R$string.str_running);
                kotlin.jvm.internal.e.e(string3, "getString(...)");
                notificationConfig.setTitle(string3);
                String string4 = this.getString(R$string.str_click_learn);
                kotlin.jvm.internal.e.e(string4, "getString(...)");
                notificationConfig.setContent(string4);
                notificationConfig.setSmallIcon(R$mipmap.ic_launcher);
                b keepLiveCallback = this.f7406g;
                kotlin.jvm.internal.e.f(keepLiveCallback, "keepLiveCallback");
                KeepLiveConstant.INSTANCE.getCALLBACKS$keeplive_release().add(keepLiveCallback);
            }
        };
        WeakReference weakReference = com.dh.keeplive.ext.a.f7209a;
        String str = com.dh.keeplive.a.f7201c;
        com.dh.keeplive.a a3 = ee.a();
        lVar.invoke(a3);
        a3.getClass();
        com.dh.keeplive.ext.a.e(this, new KeepLiveConfig(a3.f7205a, a3.f7206b));
    }

    public final void g() {
        PackageManager packageManager = getPackageManager();
        kotlin.jvm.internal.e.e(packageManager, "getPackageManager(...)");
        packageManager.setComponentEnabledSetting(new ComponentName(this, (Class<?>) NotificationService.class), 2, 1);
        packageManager.setComponentEnabledSetting(new ComponentName(this, (Class<?>) NotificationService.class), 1, 1);
    }

    @Override // android.app.Application
    public final void onCreate() {
        Boolean bool;
        super.onCreate();
        f7400h = this;
        if (k.f8731b == null) {
            synchronized (k.class) {
                k.f8731b = new k();
            }
        }
        k kVar = k.f8731b;
        if (kVar != null) {
            MMKV.p(this);
            kVar.f8732a = MMKV.h();
            String str = (String) kVar.i("user_login_token", String.class);
            if (str == null) {
                str = "";
            }
            if (d6.a.f12304c == null) {
                synchronized (d6.a.class) {
                    d6.a.f12304c = new d6.a();
                }
            }
            d6.a aVar = d6.a.f12304c;
            if (aVar != null) {
                aVar.f12306b = str;
            }
            User d5 = kVar.d();
            if (d5 != null) {
                if (d6.a.f12304c == null) {
                    synchronized (d6.a.class) {
                        d6.a.f12304c = new d6.a();
                    }
                }
                d6.a aVar2 = d6.a.f12304c;
                if (aVar2 != null) {
                    aVar2.f12305a = d5.getPlatform();
                }
            }
        }
        if (k.f8731b == null) {
            synchronized (k.class) {
                k.f8731b = new k();
            }
        }
        k kVar2 = k.f8731b;
        if (!((kVar2 == null || (bool = (Boolean) kVar2.i("is_init_launcher", Boolean.TYPE)) == null) ? false : bool.booleanValue())) {
            com.example.baselibrary.utils.b.m(this);
            y5.c.a();
            Object obj = com.example.test.utils.l.f8733a;
            c2.a().getClass();
            com.example.test.utils.l.a(this);
            com.example.baselibrary.utils.d.f7269b = this;
            com.example.baselibrary.utils.d.f7271d = Toast.makeText(this, "", 0);
            DBManger.getInstance().init(this);
            g0.f7705a.f7712b = this;
            VolumeKeyReceiver volumeKeyReceiver = new VolumeKeyReceiver();
            IntentFilter intentFilter = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");
            intentFilter.setPriority(1000);
            registerReceiver(volumeKeyReceiver, intentFilter);
            int i3 = LangService.f7641a;
            l1.a(this);
            e();
            com.example.baselibrary.utils.b.y(new l() { // from class: com.example.test.XXApplication$clearLogger$1
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((String) obj2);
                    return g.f12633a;
                }

                public final void invoke(String it) {
                    File[] listFiles;
                    File[] listFiles2;
                    Date date;
                    kotlin.jvm.internal.e.f(it, "it");
                    File file = new File(android.support.v4.media.session.e.j(XXApplication.this.getFilesDir(), "/logger"));
                    if (!file.exists() || (listFiles = file.listFiles()) == null) {
                        return;
                    }
                    for (File file2 : listFiles) {
                        if (file2.isDirectory() && (listFiles2 = file2.listFiles()) != null) {
                            for (File file3 : listFiles2) {
                                if (file3.isFile()) {
                                    String name = file3.getName();
                                    kotlin.jvm.internal.e.e(name, "getName(...)");
                                    List u10 = m.u(name, new String[]{"."});
                                    if (!u10.isEmpty()) {
                                        String date2 = (String) u10.get(0);
                                        kotlin.jvm.internal.e.f(date2, "date");
                                        try {
                                            date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(date2);
                                        } catch (Exception unused) {
                                            date = null;
                                        }
                                        if (date != null) {
                                            Calendar u11 = android.support.v4.media.session.e.u(11, 0, 12, 0);
                                            u11.set(13, 0);
                                            u11.set(14, 0);
                                            if (u11.getTimeInMillis() - date.getTime() >= 604800000) {
                                                file3.delete();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }, new l() { // from class: com.example.test.XXApplication$clearLogger$2
                public final void invoke(g it) {
                    kotlin.jvm.internal.e.f(it, "it");
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((g) obj2);
                    return g.f12633a;
                }
            });
            registerActivityLifecycleCallbacks(this.f7405f);
            return;
        }
        if (u1.b(this)) {
            com.example.baselibrary.utils.b.m(this);
            y5.c.a();
            Object obj2 = com.example.test.utils.l.f8733a;
            c2.a().getClass();
            com.example.test.utils.l.a(this);
            com.example.baselibrary.utils.d.f7269b = this;
            com.example.baselibrary.utils.d.f7271d = Toast.makeText(this, "", 0);
            d();
            DBManger.getInstance().init(this);
            g0.f7705a.f7712b = this;
            VolumeKeyReceiver volumeKeyReceiver2 = new VolumeKeyReceiver();
            IntentFilter intentFilter2 = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");
            intentFilter2.setPriority(1000);
            registerReceiver(volumeKeyReceiver2, intentFilter2);
            int i10 = LangService.f7641a;
            l1.a(this);
            e();
            com.example.baselibrary.utils.b.y(new l() { // from class: com.example.test.XXApplication$clearLogger$1
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj22) {
                    invoke((String) obj22);
                    return g.f12633a;
                }

                public final void invoke(String it) {
                    File[] listFiles;
                    File[] listFiles2;
                    Date date;
                    kotlin.jvm.internal.e.f(it, "it");
                    File file = new File(android.support.v4.media.session.e.j(XXApplication.this.getFilesDir(), "/logger"));
                    if (!file.exists() || (listFiles = file.listFiles()) == null) {
                        return;
                    }
                    for (File file2 : listFiles) {
                        if (file2.isDirectory() && (listFiles2 = file2.listFiles()) != null) {
                            for (File file3 : listFiles2) {
                                if (file3.isFile()) {
                                    String name = file3.getName();
                                    kotlin.jvm.internal.e.e(name, "getName(...)");
                                    List u10 = m.u(name, new String[]{"."});
                                    if (!u10.isEmpty()) {
                                        String date2 = (String) u10.get(0);
                                        kotlin.jvm.internal.e.f(date2, "date");
                                        try {
                                            date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(date2);
                                        } catch (Exception unused) {
                                            date = null;
                                        }
                                        if (date != null) {
                                            Calendar u11 = android.support.v4.media.session.e.u(11, 0, 12, 0);
                                            u11.set(13, 0);
                                            u11.set(14, 0);
                                            if (u11.getTimeInMillis() - date.getTime() >= 604800000) {
                                                file3.delete();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }, new l() { // from class: com.example.test.XXApplication$clearLogger$2
                public final void invoke(g it) {
                    kotlin.jvm.internal.e.f(it, "it");
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj22) {
                    invoke((g) obj22);
                    return g.f12633a;
                }
            });
            registerActivityLifecycleCallbacks(this.f7405f);
        }
    }
}
