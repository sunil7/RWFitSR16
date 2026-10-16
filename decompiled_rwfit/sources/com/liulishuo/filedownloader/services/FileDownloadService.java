package com.liulishuo.filedownloader.services;

import android.R;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import com.google.android.gms.internal.mlkit_vision_common.n6;
import com.liulishuo.filedownloader.R$string;
import de.i;
import java.lang.ref.WeakReference;
import n.m0;
import pe.t;
import te.d;
import we.b;
import ye.c;
import ye.e;

@SuppressLint({"Registered"})
/* loaded from: classes2.dex */
public class FileDownloadService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public d f11469a;

    /* renamed from: b, reason: collision with root package name */
    public t f11470b;

    public static class SeparateProcessService extends FileDownloadService {
    }

    public static class SharedMainProcessService extends FileDownloadService {
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [te.d, we.e] */
    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f11469a.m();
    }

    @Override // android.app.Service
    public final void onCreate() {
        ye.d dVar;
        int i3;
        super.onCreate();
        n6.f10047a = this;
        try {
            dVar = c.f20115a;
            i3 = dVar.f20116a;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (!e.f(n6.f10047a)) {
            throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
        }
        e.f20123a = i3;
        long j4 = dVar.f20117b;
        if (!e.f(n6.f10047a)) {
            throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
        }
        e.f20124b = j4;
        o4.c cVar = new o4.c(11);
        if (c.f20115a.f20119d) {
            this.f11469a = new we.d(new WeakReference(this), cVar);
        } else {
            this.f11469a = new b(new WeakReference(this), cVar);
        }
        t.a();
        t tVar = new t(this.f11469a);
        this.f11470b = tVar;
        HandlerThread handlerThread = new HandlerThread("PauseAllChecker");
        tVar.f17588a = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(tVar.f17588a.getLooper(), tVar);
        tVar.f17589b = handler;
        handler.sendEmptyMessageDelayed(0, 1000L);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        t tVar = this.f11470b;
        tVar.f17589b.removeMessages(0);
        tVar.f17588a.quit();
        stopForeground(true);
        super.onDestroy();
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [te.d, we.e] */
    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i10) {
        m0 m0Var;
        this.f11469a.k();
        if (intent == null || !intent.getBooleanExtra("is_foreground", false)) {
            return 1;
        }
        i iVar = com.liulishuo.filedownloader.download.c.f11405a;
        m0 m0Var2 = (m0) iVar.f12362h;
        if (m0Var2 == null) {
            synchronized (iVar) {
                try {
                    if (((m0) iVar.f12362h) == null) {
                        if (((eb.e) iVar.f().f16381b) == null) {
                            m0Var = new m0(26, false);
                            m0Var.f16254b = null;
                        } else {
                            m0Var = new m0(26, false);
                            m0Var.f16254b = null;
                        }
                        iVar.f12362h = m0Var;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            m0Var2 = (m0) iVar.f12362h;
        }
        m0Var2.getClass();
        NotificationChannel notificationChannel = new NotificationChannel("filedownloader_channel", "Filedownloader", 2);
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (notificationManager == null) {
            return 1;
        }
        notificationManager.createNotificationChannel(notificationChannel);
        if (((Notification) m0Var2.f16254b) == null) {
            String string = getString(R$string.default_filedownloader_notification_title);
            String string2 = getString(R$string.default_filedownloader_notification_content);
            Notification.Builder builder = new Notification.Builder(this, "filedownloader_channel");
            builder.setContentTitle(string).setContentText(string2).setSmallIcon(R.drawable.arrow_down_float);
            m0Var2.f16254b = builder.build();
        }
        startForeground(R.drawable.arrow_down_float, (Notification) m0Var2.f16254b);
        return 1;
    }
}
