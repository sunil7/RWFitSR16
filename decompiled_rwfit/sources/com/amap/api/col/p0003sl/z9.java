package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.f9;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class z9 implements f9.d {

    /* renamed from: a, reason: collision with root package name */
    private aa f5570a = new aa();

    @Override // com.amap.api.col.3sl.f9.d
    public final pb a(byte[] bArr, Map<String, String> map) {
        return new hb(bArr, map);
    }

    @Override // com.amap.api.col.3sl.f9.d
    public final Map<String, String> b() {
        return this.f5570a.a();
    }

    @Override // com.amap.api.col.3sl.f9.d
    public final String a() {
        int i3 = aa.f3618h;
        return null;
    }

    @Override // com.amap.api.col.3sl.f9.d
    public final String a(String str, String str2, String str3, String str4) {
        return this.f5570a.a(str, str2, str3, str4);
    }

    @Override // com.amap.api.col.3sl.f9.d
    public final String a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(n9.b("UY29kZQ")) != 1) {
                return "";
            }
            String optString = new JSONObject(jSONObject.optString(n9.b("FZGF0YQ"))).optString(n9.b("FYWRpdQ"));
            if (TextUtils.isEmpty(optString)) {
                return "";
            }
            v9.a(context).a(optString);
            return optString;
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
