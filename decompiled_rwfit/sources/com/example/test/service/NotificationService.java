package com.example.test.service;

import android.content.ComponentName;
import android.media.session.MediaSessionManager;
import android.service.notification.NotificationListenerService;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class NotificationService extends NotificationListenerService {

    /* renamed from: a, reason: collision with root package name */
    public HashMap f7642a;

    public final void a() {
        Iterator it = this.f7642a.entrySet().iterator();
        while (it.hasNext()) {
            String str = (String) ((Map.Entry) it.next()).getValue();
            if (str != null) {
                if ((str.length() == 0 || "null".equalsIgnoreCase(str)) ? false : true) {
                    String[] split = str.split("@#1@2#@");
                    if (split.length >= 2) {
                        if (System.currentTimeMillis() - Long.parseLong(split[1]) > 500) {
                            it.remove();
                        }
                    }
                }
            }
        }
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        com.example.test.utils.x.a().c(getApplication());
        this.f7642a = new HashMap(1);
        Log.e("qob", "NotificationService onCreate");
        h0 h0Var = g0.f7705a;
        h0Var.f7712b = this;
        if (!((HashSet) y0.r.a(this)).contains(getPackageName())) {
            Log.e("musicControll", "isNotificationListenerEnabled false");
            return;
        }
        Log.e("musicControll", "isNotificationListenerEnabled true");
        Object systemService = getSystemService("media_session");
        if (systemService instanceof MediaSessionManager) {
            MediaSessionManager mediaSessionManager = (MediaSessionManager) systemService;
            ComponentName componentName = new ComponentName(this, (Class<?>) NotificationService.class);
            mediaSessionManager.addOnActiveSessionsChangedListener(new e0(h0Var), componentName);
            synchronized (h0Var) {
                h0Var.f7711a = mediaSessionManager.getActiveSessions(componentName);
                h0Var.c();
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:0|1|2|3|(3:5|(1:7)(1:99)|(1:9)(3:10|11|(12:18|(2:26|27)|28|29|30|31|32|(1:36)|37|(1:41)|42|(2:48|(7:50|51|(2:57|(2:59|(2:65|(2:69|70))(2:63|64)))|71|(1:92)(4:75|(1:77)|78|(3:80|(1:82)(1:90)|(3:84|(1:86)|87))(1:91))|88|89)(1:93))(2:46|47))(2:15|16)))|100|11|(1:13)|18|(4:20|23|26|27)|28|29|30|31|32|(2:34|36)|37|(2:39|41)|42|(1:44)|48|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x00f5, code lost:
    
        r11 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00f4, code lost:
    
        r10 = "";
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00fc A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:3:0x001d, B:5:0x0028, B:11:0x004a, B:13:0x0054, B:15:0x005e, B:18:0x0079, B:20:0x00cf, B:23:0x00d6, B:26:0x00df, B:29:0x00eb, B:31:0x00ef, B:32:0x00f6, B:34:0x00fc, B:36:0x0102, B:37:0x010a, B:39:0x0110, B:41:0x0116, B:42:0x011e, B:44:0x0124, B:46:0x012a, B:48:0x0137, B:50:0x013d, B:53:0x0179, B:55:0x0183, B:57:0x0189, B:59:0x0191, B:61:0x01a8, B:63:0x01b9, B:65:0x01c6, B:67:0x01e3, B:69:0x01ee, B:71:0x01fb, B:73:0x0238, B:75:0x0244, B:78:0x0265, B:80:0x0286, B:82:0x029c, B:84:0x02a4, B:86:0x02ae, B:87:0x02b1, B:88:0x02dd, B:91:0x02b5, B:92:0x02c0, B:99:0x0032, B:100:0x003d), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0110 A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:3:0x001d, B:5:0x0028, B:11:0x004a, B:13:0x0054, B:15:0x005e, B:18:0x0079, B:20:0x00cf, B:23:0x00d6, B:26:0x00df, B:29:0x00eb, B:31:0x00ef, B:32:0x00f6, B:34:0x00fc, B:36:0x0102, B:37:0x010a, B:39:0x0110, B:41:0x0116, B:42:0x011e, B:44:0x0124, B:46:0x012a, B:48:0x0137, B:50:0x013d, B:53:0x0179, B:55:0x0183, B:57:0x0189, B:59:0x0191, B:61:0x01a8, B:63:0x01b9, B:65:0x01c6, B:67:0x01e3, B:69:0x01ee, B:71:0x01fb, B:73:0x0238, B:75:0x0244, B:78:0x0265, B:80:0x0286, B:82:0x029c, B:84:0x02a4, B:86:0x02ae, B:87:0x02b1, B:88:0x02dd, B:91:0x02b5, B:92:0x02c0, B:99:0x0032, B:100:0x003d), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0124 A[Catch: all -> 0x003a, TryCatch #0 {all -> 0x003a, blocks: (B:3:0x001d, B:5:0x0028, B:11:0x004a, B:13:0x0054, B:15:0x005e, B:18:0x0079, B:20:0x00cf, B:23:0x00d6, B:26:0x00df, B:29:0x00eb, B:31:0x00ef, B:32:0x00f6, B:34:0x00fc, B:36:0x0102, B:37:0x010a, B:39:0x0110, B:41:0x0116, B:42:0x011e, B:44:0x0124, B:46:0x012a, B:48:0x0137, B:50:0x013d, B:53:0x0179, B:55:0x0183, B:57:0x0189, B:59:0x0191, B:61:0x01a8, B:63:0x01b9, B:65:0x01c6, B:67:0x01e3, B:69:0x01ee, B:71:0x01fb, B:73:0x0238, B:75:0x0244, B:78:0x0265, B:80:0x0286, B:82:0x029c, B:84:0x02a4, B:86:0x02ae, B:87:0x02b1, B:88:0x02dd, B:91:0x02b5, B:92:0x02c0, B:99:0x0032, B:100:0x003d), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013d A[Catch: all -> 0x003a, TRY_LEAVE, TryCatch #0 {all -> 0x003a, blocks: (B:3:0x001d, B:5:0x0028, B:11:0x004a, B:13:0x0054, B:15:0x005e, B:18:0x0079, B:20:0x00cf, B:23:0x00d6, B:26:0x00df, B:29:0x00eb, B:31:0x00ef, B:32:0x00f6, B:34:0x00fc, B:36:0x0102, B:37:0x010a, B:39:0x0110, B:41:0x0116, B:42:0x011e, B:44:0x0124, B:46:0x012a, B:48:0x0137, B:50:0x013d, B:53:0x0179, B:55:0x0183, B:57:0x0189, B:59:0x0191, B:61:0x01a8, B:63:0x01b9, B:65:0x01c6, B:67:0x01e3, B:69:0x01ee, B:71:0x01fb, B:73:0x0238, B:75:0x0244, B:78:0x0265, B:80:0x0286, B:82:0x029c, B:84:0x02a4, B:86:0x02ae, B:87:0x02b1, B:88:0x02dd, B:91:0x02b5, B:92:0x02c0, B:99:0x0032, B:100:0x003d), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    @Override // android.service.notification.NotificationListenerService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onNotificationPosted(android.service.notification.StatusBarNotification r17, android.service.notification.NotificationListenerService.RankingMap r18) {
        /*
            Method dump skipped, instructions count: 758
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.service.NotificationService.onNotificationPosted(android.service.notification.StatusBarNotification, android.service.notification.NotificationListenerService$RankingMap):void");
    }
}
