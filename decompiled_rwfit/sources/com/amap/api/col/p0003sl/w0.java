package com.amap.api.col.p0003sl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class w0 {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Boolean> f5205a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f5206b;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static w0 f5207a = new w0();
    }

    private void a() {
        this.f5205a.put("feature_mvt", Boolean.TRUE);
        Map<String, Boolean> map = this.f5205a;
        Boolean bool = Boolean.FALSE;
        map.put("feature_gltf", bool);
        this.f5205a.put("feature_terrain", bool);
    }

    public boolean b() {
        return this.f5206b.get();
    }

    private w0() {
        this.f5205a = new ConcurrentHashMap();
        this.f5206b = new AtomicBoolean(false);
        a();
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("mvt_able");
        c9.a(optString, true);
        this.f5205a.put("feature_mvt", Boolean.valueOf(c9.a(optString, true)));
        this.f5205a.put("feature_gltf", Boolean.valueOf(c9.a(jSONObject.optString("gltf_able"), false)));
        this.f5205a.put("feature_terrain", Boolean.valueOf(c9.a(jSONObject.optString("terrain_able"), false)));
        this.f5206b.set(true);
    }

    public boolean a(String str) {
        if (this.f5205a.containsKey(str)) {
            return this.f5205a.get(str).booleanValue();
        }
        return false;
    }
}
