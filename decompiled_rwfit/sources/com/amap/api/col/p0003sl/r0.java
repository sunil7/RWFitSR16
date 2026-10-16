package com.amap.api.col.p0003sl;

import android.content.Context;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.connect.common.Constants;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class r0 extends t8<String, a> {
    private boolean r;

    /* renamed from: s, reason: collision with root package name */
    private int[] f4932s;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f4933a = false;
    }

    public r0(Context context, String str) {
        super(context, str);
        this.f4932s = new int[]{10000, 0, 10018, 10019, 10020, 10021, 10022, 10023};
        this.f5096p = "/feedback";
        this.isPostFlag = false;
        this.r = true;
    }

    @Override // com.amap.api.col.p0003sl.t8
    public a b(String str) throws s8 {
        int i3;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                i3 = jSONObject.optInt("errcode");
                jSONObject.optString("errmsg");
                jSONObject.optString("errdetail");
            } else {
                i3 = -1;
            }
            a aVar = new a();
            aVar.f4933a = false;
            for (int i10 : this.f4932s) {
                if (i10 == i3) {
                    aVar.f4933a = true;
                    return aVar;
                }
            }
            return aVar;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getIPV6URL() {
        return v4.a(getURL(), this.f5095o);
    }

    @Override // com.amap.api.col.p0003sl.b4, com.amap.api.col.p0003sl.pb
    public Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", b9.e(this.f5095o));
        if (this.r) {
            hashtable.put("pname", "3dmap");
        }
        String c9 = e9.c();
        String a3 = e9.a(this.f5095o, c9, n9.a(hashtable));
        hashtable.put(Constants.TS, c9);
        hashtable.put("scode", a3);
        return hashtable;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getURL() {
        StringBuilder u10 = l0.u("http://" + g9.b(this.f5095o).a(41), "/v4");
        u10.append(this.f5096p);
        return u10.toString();
    }

    @Override // com.amap.api.col.p0003sl.pb
    public boolean isSupportIPV6() {
        return true;
    }
}
