package com.amap.api.col.p0003sl;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class wb {

    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5244a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f5245b;

        public a(String str, Context context) {
            this.f5244a = str;
            this.f5245b = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (wb.class) {
                try {
                    String a3 = e9.a(n9.e(this.f5244a));
                    ub a10 = vb.a((WeakReference<ub>) null);
                    Context context = this.f5245b;
                    int i3 = ha.f4272c;
                    vb.a(context, a10, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, 50, 102400, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
                    if (a10.e == null) {
                        a10.e = new ab(new db(new cb()));
                    }
                    vb.a(a3, n9.e(" \"timestamp\":\"" + n9.a(System.currentTimeMillis(), "yyyyMMdd HH:mm:ss") + "\",\"details\":" + this.f5244a), a10);
                } finally {
                }
            }
        }
    }

    public static void a(String str, Context context) {
        ka.b().submit(new a(str, context));
    }
}
