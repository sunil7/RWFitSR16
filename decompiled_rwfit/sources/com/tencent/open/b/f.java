package com.tencent.open.b;

import com.tencent.open.utils.i;

/* loaded from: classes2.dex */
public class f {
    public static int a(String str) {
        int a3;
        if (com.tencent.open.utils.g.a() == null || (a3 = i.a(com.tencent.open.utils.g.a(), str).a("Common_BusinessReportFrequency")) == 0) {
            return 100;
        }
        return a3;
    }

    public static int a() {
        int a3 = i.a(com.tencent.open.utils.g.a(), (String) null).a("Common_HttpRetryCount");
        if (a3 == 0) {
            return 2;
        }
        return a3;
    }
}
