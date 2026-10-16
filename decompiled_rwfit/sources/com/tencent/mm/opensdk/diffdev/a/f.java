package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* loaded from: classes2.dex */
final class f extends AsyncTask<Void, Void, a> {

    /* renamed from: l, reason: collision with root package name */
    private OAuthListener f11887l;

    /* renamed from: o, reason: collision with root package name */
    private String f11888o;

    /* renamed from: u, reason: collision with root package name */
    private int f11889u;
    private String url;

    public static class a {

        /* renamed from: n, reason: collision with root package name */
        public OAuthErrCode f11890n;

        /* renamed from: v, reason: collision with root package name */
        public String f11891v;

        /* renamed from: w, reason: collision with root package name */
        public int f11892w;

        public static a b(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String message;
            StringBuilder sb2;
            OAuthErrCode oAuthErrCode2;
            a aVar = new a();
            if (bArr != null && bArr.length != 0) {
                try {
                } catch (Exception e) {
                    message = e.getMessage();
                    sb2 = new StringBuilder("parse fail, build String fail, ex = ");
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                    int i3 = jSONObject.getInt("wx_errcode");
                    aVar.f11892w = i3;
                    Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", Integer.valueOf(i3)));
                    int i10 = aVar.f11892w;
                    if (i10 == 408) {
                        oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_OK;
                    } else if (i10 != 500) {
                        switch (i10) {
                            case 402:
                                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_Timeout;
                                break;
                            case 403:
                                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_Cancel;
                                break;
                            case 404:
                                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_OK;
                                break;
                            case 405:
                                aVar.f11890n = OAuthErrCode.WechatAuth_Err_OK;
                                aVar.f11891v = jSONObject.getString("wx_code");
                                return aVar;
                            default:
                                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                                break;
                        }
                    } else {
                        oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                    }
                    aVar.f11890n = oAuthErrCode2;
                    return aVar;
                } catch (Exception e10) {
                    message = e10.getMessage();
                    sb2 = new StringBuilder("parse json fail, ex = ");
                    sb2.append(message);
                    Log.e("MicroMsg.SDK.NoopingResult", sb2.toString());
                    oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                    aVar.f11890n = oAuthErrCode;
                    return aVar;
                }
            }
            Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            aVar.f11890n = oAuthErrCode;
            return aVar;
        }
    }

    public f(String str, OAuthListener oAuthListener) {
        this.f11888o = str;
        this.f11887l = oAuthListener;
        this.url = l0.n("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=", str);
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ a doInBackground(Void[] voidArr) {
        a aVar;
        OAuthErrCode oAuthErrCode;
        String str;
        String str2 = this.f11888o;
        if (str2 == null || str2.length() == 0) {
            Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
        } else {
            while (!isCancelled()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.url);
                if (this.f11889u == 0) {
                    str = "";
                } else {
                    str = "&last=" + this.f11889u;
                }
                sb2.append(str);
                String sb3 = sb2.toString();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] a3 = e.a(sb3);
                long currentTimeMillis2 = System.currentTimeMillis();
                a b3 = a.b(a3);
                Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb3, b3.f11890n.toString(), Integer.valueOf(b3.f11892w), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                OAuthErrCode oAuthErrCode2 = b3.f11890n;
                if (oAuthErrCode2 != OAuthErrCode.WechatAuth_Err_OK) {
                    Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", oAuthErrCode2.toString(), Integer.valueOf(b3.f11892w)));
                    return b3;
                }
                int i3 = b3.f11892w;
                this.f11889u = i3;
                if (i3 == g.UUID_SCANED.getCode()) {
                    this.f11887l.onQrcodeScanned();
                } else if (b3.f11892w != g.UUID_KEEP_CONNECT.getCode() && b3.f11892w == g.UUID_CONFIRM.getCode()) {
                    String str3 = b3.f11891v;
                    if (str3 != null && str3.length() != 0) {
                        return b3;
                    }
                    Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                    b3.f11890n = OAuthErrCode.WechatAuth_Err_NormalErr;
                    return b3;
                }
            }
            Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        }
        aVar.f11890n = oAuthErrCode;
        return aVar;
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.f11887l.onAuthFinish(aVar2.f11890n, aVar2.f11891v);
    }
}
