package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;

/* loaded from: classes.dex */
public class i9 {

    /* renamed from: a, reason: collision with root package name */
    private volatile b f4299a = new b(0);

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static i9 f4300a = new i9();
    }

    public i9() {
        e9.c(TextUtils.isDigitsOnly("HttpsDecisionUtil") ? "SPUtil" : "HttpsDecisionUtil");
    }

    public static i9 a() {
        return a.f4300a;
    }

    public void b(boolean z5) {
        if (this.f4299a == null) {
            this.f4299a = new b((byte) 0);
        }
        this.f4299a.a(z5);
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f4301a;

        /* renamed from: b, reason: collision with root package name */
        protected boolean f4302b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f4303c;

        private b() {
            this.f4301a = 0;
            this.f4302b = true;
            this.f4303c = false;
        }

        public final void a(Context context) {
            if (context != null && this.f4301a <= 0) {
                this.f4301a = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public final void a(boolean z5) {
            this.f4303c = z5;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x002d A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean a() {
            /*
                r5 = this;
                boolean r0 = r5.f4303c
                r1 = 1
                if (r0 != 0) goto L2e
                int r0 = android.os.Build.VERSION.SDK_INT
                r2 = 28
                r3 = 0
                if (r0 < r2) goto Le
                r0 = r1
                goto Lf
            Le:
                r0 = r3
            Lf:
                boolean r4 = r5.f4302b
                if (r4 == 0) goto L22
                int r4 = r5.f4301a
                if (r4 > 0) goto L18
                r4 = r2
            L18:
                if (r4 < r2) goto L1c
                r2 = r1
                goto L1d
            L1c:
                r2 = r3
            L1d:
                if (r2 == 0) goto L20
                goto L22
            L20:
                r2 = r3
                goto L23
            L22:
                r2 = r1
            L23:
                if (r0 == 0) goto L29
                if (r2 == 0) goto L29
                r0 = r1
                goto L2a
            L29:
                r0 = r3
            L2a:
                if (r0 == 0) goto L2d
                goto L2e
            L2d:
                return r3
            L2e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.3sl.i9.b.a():boolean");
        }

        public /* synthetic */ b(byte b3) {
            this();
        }
    }

    public void a(Context context) {
        if (this.f4299a == null) {
            this.f4299a = new b((byte) 0);
        }
        this.f4299a.f4302b = xa.a(context, "open_common", SdCardDbCreator.FIELD_LASTLOC_TIME, true);
        this.f4299a.a(context);
        v9.a(context).a();
    }

    public boolean b() {
        if (this.f4299a == null) {
            this.f4299a = new b((byte) 0);
        }
        return this.f4299a.a();
    }

    public final void a(Context context, boolean z5) {
        if (this.f4299a == null) {
            this.f4299a = new b((byte) 0);
        }
        SharedPreferences.Editor a3 = xa.a(context, "open_common");
        xa.a(a3, SdCardDbCreator.FIELD_LASTLOC_TIME, z5);
        xa.a(a3);
        this.f4299a.f4302b = z5;
    }

    public boolean a(boolean z5) {
        if (z5) {
            return true;
        }
        byte b3 = 0;
        if (this.f4299a == null) {
            this.f4299a = new b(b3);
        }
        return this.f4299a.a();
    }
}
