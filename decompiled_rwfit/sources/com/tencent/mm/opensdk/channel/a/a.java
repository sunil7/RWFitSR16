package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a, reason: collision with other inner class name */
    public static class C0016a {

        /* renamed from: a, reason: collision with root package name */
        public String f11869a;
        public String action;

        /* renamed from: b, reason: collision with root package name */
        public long f11870b;
        public Bundle bundle;
        public String content;
    }

    public static boolean a(Context context, C0016a c0016a) {
        String str;
        if (context == null) {
            str = "send fail, invalid argument";
        } else {
            if (!d.b(c0016a.action)) {
                String f2 = !d.b(c0016a.f11869a) ? r5.a.f(new StringBuilder(), c0016a.f11869a, ".permission.MM_MESSAGE") : null;
                Intent intent = new Intent(c0016a.action);
                Bundle bundle = c0016a.bundle;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra(ConstantsAPI.SDK_VERSION, 620953856);
                intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
                intent.putExtra(ConstantsAPI.CONTENT, c0016a.content);
                intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c0016a.f11870b);
                intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(c0016a.content, 620953856, packageName));
                context.sendBroadcast(intent, f2);
                Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + f2);
                return true;
            }
            str = "send fail, action is null";
        }
        Log.e("MicroMsg.SDK.MMessage", str);
        return false;
    }
}
