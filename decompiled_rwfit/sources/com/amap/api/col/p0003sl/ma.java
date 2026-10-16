package com.amap.api.col.p0003sl;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ma {

    /* renamed from: a, reason: collision with root package name */
    private m9 f4606a;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static Map<String, ma> f4607a = new HashMap();
    }

    private ma(m9 m9Var) {
        this.f4606a = m9Var;
    }

    public static ma a(m9 m9Var) {
        if (a.f4607a.get(m9Var.d()) == null) {
            a.f4607a.put(m9Var.d(), new ma(m9Var));
        }
        return a.f4607a.get(m9Var.d());
    }

    public void a(Context context, boolean z5, boolean z6) {
        pa.a(context, this.f4606a, "sckey", "" + z5);
        if (z5) {
            pa.a(context, this.f4606a, "scisf", "" + z6);
        }
    }
}
