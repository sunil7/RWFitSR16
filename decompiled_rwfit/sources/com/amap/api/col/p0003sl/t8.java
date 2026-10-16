package com.amap.api.col.p0003sl;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class t8<T, V> extends b4 {

    /* renamed from: m, reason: collision with root package name */
    protected T f5093m;

    /* renamed from: o, reason: collision with root package name */
    protected Context f5095o;

    /* renamed from: p, reason: collision with root package name */
    protected String f5096p;

    /* renamed from: n, reason: collision with root package name */
    protected int f5094n = 1;

    /* renamed from: q, reason: collision with root package name */
    protected boolean f5097q = false;

    public t8(Context context, T t8) {
        a(context, t8);
    }

    private V d() throws s8 {
        V v6 = null;
        int i3 = 0;
        while (i3 < this.f5094n) {
            try {
                setProxy(e9.d(this.f5095o));
                v6 = this.f5097q ? a(makeHttpRequestNeedHeader()) : a(makeHttpRequest());
                i3 = this.f5094n;
            } catch (a9 e) {
                i3++;
                if (i3 >= this.f5094n) {
                    e();
                    if ("http连接失败 - ConnectionException".equals(e.getMessage()) || "socket 连接异常 - SocketException".equals(e.getMessage()) || "未知的错误".equals(e.d()) || "服务器连接失败 - UnknownServiceException".equals(e.getMessage())) {
                        throw new s8(s8.A);
                    }
                    throw new s8(e.d());
                }
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                    if ("http连接失败 - ConnectionException".equals(e.getMessage()) || "socket 连接异常 - SocketException".equals(e.getMessage()) || "服务器连接失败 - UnknownServiceException".equals(e.getMessage())) {
                        throw new s8(s8.A);
                    }
                    throw new s8(e.d());
                }
            } catch (s8 e10) {
                i3++;
                if (i3 >= this.f5094n) {
                    throw new s8(e10.a());
                }
            }
        }
        return v6;
    }

    public V a(qb qbVar) throws s8 {
        return null;
    }

    public abstract V b(String str) throws s8;

    public V c() throws s8 {
        if (this.f5093m == null) {
            return null;
        }
        try {
            return d();
        } catch (s8 e) {
            v4.a(e);
            throw e;
        }
    }

    public V e() {
        return null;
    }

    @Override // com.amap.api.col.p0003sl.pb
    public Map<String, String> getRequestHead() {
        m9 b3 = v4.b();
        String e = b3 != null ? b3.e() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", v0.f5168c);
        hashtable.put("Accept-Encoding", "gzip");
        Locale locale = Locale.US;
        hashtable.put("platinfo", "platform=Android&sdkversion=" + e + "&product=3dmap");
        hashtable.put("X-INFO", e9.b(this.f5095o));
        hashtable.put("key", b9.e(this.f5095o));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    private void a(Context context, T t8) {
        this.f5095o = context;
        this.f5093m = t8;
        this.f5094n = 1;
        setSoTimeout(Const.I_LOC_JUMP_DELAY);
        setConnectionTimeout(Const.I_LOC_JUMP_DELAY);
    }

    public V a(byte[] bArr) throws s8 {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        if (str == null || "".equals(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                v8.a(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
            } else if (jSONObject.has(FileDownloadModel.STATUS) && jSONObject.has("infocode")) {
                String string = jSONObject.getString(FileDownloadModel.STATUS);
                int i3 = jSONObject.getInt("infocode");
                if (!"1".equals(string)) {
                    String string2 = jSONObject.getString("info");
                    if ("0".equals(string)) {
                        v8.a(i3, string2);
                    }
                }
            }
            return b(str);
        } catch (JSONException unused) {
            throw new s8(s8.f5032w);
        }
    }
}
