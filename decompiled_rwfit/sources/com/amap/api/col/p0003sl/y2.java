package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.c9;
import com.amap.api.maps.AMapException;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class y2<T, V> {

    /* renamed from: a, reason: collision with root package name */
    protected T f5453a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f5454b;

    public y2(Context context, T t8) {
        a(context, t8);
    }

    private void a(Context context, T t8) {
        this.f5454b = context;
        this.f5453a = t8;
    }

    public abstract V a(JSONObject jSONObject) throws AMapException;

    public abstract JSONObject a(c9.c cVar);

    public abstract Map<String, String> b();

    public abstract String c();

    public V a() throws AMapException {
        String str;
        AMapException aMapException;
        if (this.f5453a == null) {
            return null;
        }
        int i3 = 0;
        V v6 = null;
        c9.c cVar = null;
        while (true) {
            if (i3 >= 3) {
                return v6;
            }
            try {
                cVar = c9.a(this.f5454b, v4.b(), c(), b());
                v6 = a(a(cVar));
                i3 = 3;
            } finally {
                if (i3 < r4) {
                    continue;
                }
            }
        }
    }
}
