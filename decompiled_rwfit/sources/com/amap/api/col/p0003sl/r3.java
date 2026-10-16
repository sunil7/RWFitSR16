package com.amap.api.col.p0003sl;

import android.content.Context;
import com.davemorrissey.labs.subscaleview.BuildConfig;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.connect.common.Constants;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class r3 extends t8<String, a> {
    private String r;

    /* renamed from: s, reason: collision with root package name */
    private String f4940s;

    /* renamed from: t, reason: collision with root package name */
    private String f4941t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f4942u;

    /* renamed from: v, reason: collision with root package name */
    private String f4943v;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte[] f4944a;

        /* renamed from: c, reason: collision with root package name */
        public String f4946c;

        /* renamed from: b, reason: collision with root package name */
        public int f4945b = -1;

        /* renamed from: d, reason: collision with root package name */
        public String f4947d = null;
    }

    public r3(Context context, String str) {
        super(context, str);
        this.f4940s = BuildConfig.VERSION_NAME;
        this.f4941t = "0";
        this.f4942u = false;
        this.f4943v = null;
        this.f5096p = "/map/styles";
        this.f5097q = true;
    }

    @Override // com.amap.api.col.p0003sl.t8
    public /* bridge */ /* synthetic */ a b(String str) throws s8 {
        return null;
    }

    public void c(String str) {
        this.r = str;
    }

    public void d(String str) {
        this.f4941t = str;
    }

    public void e(String str) {
        this.f4943v = str;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public String getIPV6URL() {
        return v4.a(getURL(), this.f5095o);
    }

    @Override // com.amap.api.col.p0003sl.b4, com.amap.api.col.p0003sl.pb
    public Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", b9.e(this.f5095o));
        if (this.f4942u) {
            hashtable.put("sdkType", this.f4943v);
        } else {
            hashtable.put("output", "bin");
        }
        hashtable.put("styleid", this.r);
        hashtable.put("protocol", this.f4940s);
        hashtable.put("ispublic", "1");
        hashtable.put("lastModified", this.f4941t);
        String c9 = e9.c();
        String a3 = e9.a(this.f5095o, c9, n9.a(hashtable));
        hashtable.put(Constants.TS, c9);
        hashtable.put("scode", a3);
        return hashtable;
    }

    @Override // com.amap.api.col.p0003sl.t8, com.amap.api.col.p0003sl.pb
    public Map<String, String> getRequestHead() {
        m9 b3 = v4.b();
        String e = b3 != null ? b3.e() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", v0.f5168c);
        hashtable.put("Accept-Encoding", "gzip");
        Locale locale = Locale.US;
        hashtable.put("platinfo", "platform=Android&sdkversion=" + e + "&product=3dmap");
        hashtable.put("x-INFO", e9.c(this.f5095o));
        hashtable.put("key", b9.e(this.f5095o));
        hashtable.put("logversion", "2.1");
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

    @Override // com.amap.api.col.p0003sl.t8
    public a a(qb qbVar) throws s8 {
        List<String> list;
        if (qbVar == null) {
            return null;
        }
        a a3 = a(qbVar.f4927a);
        Map<String, List<String>> map = qbVar.f4928b;
        if (map != null && map.containsKey("lastModified") && (list = qbVar.f4928b.get("lastModified")) != null && list.size() > 0) {
            a3.f4947d = list.get(0);
        }
        return a3;
    }

    @Override // com.amap.api.col.p0003sl.t8
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a a(byte[] bArr) throws s8 {
        a aVar = new a();
        aVar.f4944a = bArr;
        if (this.f4942u && bArr != null) {
            if (bArr.length == 0) {
                aVar.f4944a = null;
                return aVar;
            }
            if (bArr.length <= 1024) {
                try {
                    String str = new String(bArr, "utf-8");
                    if (str.contains("errcode")) {
                        JSONObject jSONObject = new JSONObject(str);
                        aVar.f4945b = jSONObject.getInt("errcode");
                        aVar.f4946c = jSONObject.getString("errmsg");
                        aVar.f4944a = null;
                        return aVar;
                    }
                } catch (Exception e) {
                    ka.a(e, "CustomStyleRequest", "loadData");
                }
            }
        }
        return aVar;
    }

    public r3(Context context, String str, boolean z5) {
        super(context, str);
        this.f4940s = BuildConfig.VERSION_NAME;
        this.f4941t = "0";
        this.f4943v = null;
        this.f4942u = z5;
        if (z5) {
            this.f5096p = "/sdk/map/styles";
            this.isPostFlag = false;
        } else {
            this.f5096p = "/map/styles";
        }
        this.f5097q = true;
    }
}
