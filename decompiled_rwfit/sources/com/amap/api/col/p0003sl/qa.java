package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.m9;
import com.autonavi.aps.amapapi.config.Const;
import com.davemorrissey.labs.subscaleview.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class qa {

    /* renamed from: a, reason: collision with root package name */
    private m9 f4926a;

    public qa(String str) {
        this.f4926a = null;
        try {
            this.f4926a = new m9.a(str, BuildConfig.VERSION_NAME, "1.0.0").a(new String[]{"info"}).a();
        } catch (a9 unused) {
        }
    }

    public void a(Context context, m9 m9Var) {
        JSONArray jSONArray;
        ArrayList arrayList = new ArrayList();
        arrayList.add(m9Var);
        if (arrayList.size() == 0) {
            jSONArray = new JSONArray();
        } else {
            jSONArray = new JSONArray();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                m9 m9Var2 = (m9) obj;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(Const.INTENT_KEY_APIKEY, m9Var2.d());
                    jSONObject.put(Const.INTENT_KEY_PKGNAME, m9Var2.e());
                    jSONObject.put("c", m9Var2.b());
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i10 = 0; m9Var2.c() != null && i10 < m9Var2.c().length; i10++) {
                        jSONArray2.put(m9Var2.c()[i10]);
                    }
                    jSONObject.put(Const.INTENT_KEY_UMID, jSONArray2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
        }
        String jSONArray3 = jSONArray.toString();
        if (TextUtils.isEmpty(jSONArray3)) {
            return;
        }
        pa.a(context, this.f4926a, "rbck", jSONArray3);
    }

    public List<m9> a(Context context) {
        m9 m9Var;
        try {
            JSONArray jSONArray = new JSONArray(pa.a(context, this.f4926a, "rbck"));
            if (jSONArray.length() == 0) {
                return new ArrayList();
            }
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    m9Var = a(jSONArray.getJSONObject(i3));
                } catch (JSONException unused) {
                    m9Var = null;
                }
                if (m9Var != null) {
                    arrayList.add(m9Var);
                }
            }
            return arrayList;
        } catch (JSONException unused2) {
            return new ArrayList();
        }
    }

    public m9 a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString(Const.INTENT_KEY_APIKEY);
            String optString2 = jSONObject.optString(Const.INTENT_KEY_PKGNAME);
            String optString3 = jSONObject.optString("c");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray(Const.INTENT_KEY_UMID);
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                arrayList.add(optJSONArray.getString(i3));
            }
            return new m9.a(optString, optString2, optString).a(optString3).a((String[]) arrayList.toArray(new String[0])).a();
        } catch (Throwable unused) {
            return null;
        }
    }
}
