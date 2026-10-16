package com.tencent.open.b;

import android.content.Context;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class g {
    public static void a(String str) {
    }

    public static List<Serializable> b(String str) {
        return Collections.synchronizedList(new ArrayList());
    }

    public static void a(String str, List<Serializable> list) {
    }

    public static void a() {
        Context a3 = com.tencent.open.utils.g.a();
        if (a3 == null) {
            return;
        }
        a3.deleteDatabase("sdk_report.db");
    }
}
