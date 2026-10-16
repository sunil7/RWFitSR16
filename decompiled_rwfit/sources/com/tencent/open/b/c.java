package com.tencent.open.b;

import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class c implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f11981a;

    public c(Bundle bundle) {
        this.f11981a = new HashMap<>();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                this.f11981a.put(str, bundle.getString(str));
            }
        }
    }

    public String toString() {
        return "BaseData{time=" + this.f11981a.get(Const.JSON_KEY_TIME) + ", name=" + this.f11981a.get("interface_name") + '}';
    }

    public c(HashMap<String, String> hashMap) {
        this.f11981a = new HashMap<>(hashMap);
    }
}
