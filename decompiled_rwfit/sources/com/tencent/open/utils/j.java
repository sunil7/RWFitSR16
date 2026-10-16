package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.log.SLog;
import java.lang.ref.WeakReference;
import java.net.URL;

/* loaded from: classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static j f12109a;

    /* renamed from: b, reason: collision with root package name */
    private volatile WeakReference<SharedPreferences> f12110b = null;

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            try {
                if (f12109a == null) {
                    f12109a = new j();
                }
                jVar = f12109a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return jVar;
    }

    public String a(Context context, String str) {
        if (this.f12110b == null || this.f12110b.get() == null) {
            this.f12110b = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            String host = new URL(str).getHost();
            if (host == null) {
                SLog.e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                return str;
            }
            String string = this.f12110b.get().getString(host, null);
            if (string != null && !host.equals(string)) {
                String replace = str.replace(host, string);
                SLog.v("openSDK_LOG.ServerSetting", "return environment url : " + replace);
                return replace;
            }
            SLog.v("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
            return str;
        } catch (Exception e) {
            StringBuilder r = android.support.v4.media.session.e.r("getEnvUrl url=", str, "error.: ");
            r.append(e.getMessage());
            SLog.e("openSDK_LOG.ServerSetting", r.toString());
            return str;
        }
    }
}
