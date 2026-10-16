package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class w9 {

    /* renamed from: c, reason: collision with root package name */
    public static final String f5235c = n9.b("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");

    /* renamed from: d, reason: collision with root package name */
    private static w9 f5236d;

    /* renamed from: a, reason: collision with root package name */
    private String f5237a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f5238b;

    public class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5239a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f5240b;

        public a(String str, int i3) {
            this.f5239a = str;
            this.f5240b = i3;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            String b3 = ba.b(this.f5239a);
            if (TextUtils.isEmpty(b3)) {
                return;
            }
            if ((this.f5240b & 1) > 0) {
                try {
                    if (Settings.System.canWrite(w9.this.f5238b)) {
                        Settings.System.putString(w9.this.f5238b.getContentResolver(), w9.this.f5237a, b3);
                    }
                } catch (Exception unused) {
                }
            }
            if ((this.f5240b & 16) > 0) {
                y9.a(w9.this.f5238b, w9.this.f5237a, b3);
            }
            if ((this.f5240b & 256) > 0) {
                SharedPreferences.Editor edit = w9.this.f5238b.getSharedPreferences(w9.f5235c, 0).edit();
                edit.putString(w9.this.f5237a, b3);
                edit.apply();
            }
        }
    }

    private w9(Context context) {
        this.f5238b = context.getApplicationContext();
        if (Looper.myLooper() == null) {
            new b(Looper.getMainLooper(), this);
        } else {
            new b(this);
        }
    }

    public static final class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<w9> f5242a;

        public b(w9 w9Var) {
            this.f5242a = new WeakReference<>(w9Var);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            w9 w9Var = this.f5242a.get();
            if (w9Var == null || message == null || (obj = message.obj) == null) {
                return;
            }
            w9Var.a((String) obj, message.what);
        }

        public b(Looper looper, w9 w9Var) {
            super(looper);
            this.f5242a = new WeakReference<>(w9Var);
        }
    }

    public final void b(String str) {
        a(str, 273);
    }

    public static w9 a(Context context) {
        if (f5236d == null) {
            synchronized (w9.class) {
                try {
                    if (f5236d == null) {
                        f5236d = new w9(context);
                    }
                } finally {
                }
            }
        }
        return f5236d;
    }

    public final void a(String str) {
        this.f5237a = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, int i3) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new a(str, i3).start();
            return;
        }
        String b3 = ba.b(str);
        if (!TextUtils.isEmpty(b3)) {
            if ((i3 & 1) > 0) {
                try {
                    Settings.System.putString(this.f5238b.getContentResolver(), this.f5237a, b3);
                } catch (Exception unused) {
                }
            }
            if ((i3 & 16) > 0) {
                y9.a(this.f5238b, this.f5237a, b3);
            }
            if ((i3 & 256) > 0) {
                SharedPreferences.Editor edit = this.f5238b.getSharedPreferences(f5235c, 0).edit();
                edit.putString(this.f5237a, b3);
                edit.apply();
            }
        }
    }
}
