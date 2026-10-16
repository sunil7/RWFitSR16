package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Environment;
import android.util.Base64;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d extends AsyncTask<Void, Void, a> {

    /* renamed from: h, reason: collision with root package name */
    private static final String f11875h = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MicroMsg/oauth_qrcode.png";

    /* renamed from: i, reason: collision with root package name */
    private static String f11876i = "https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
    private String appId;

    /* renamed from: j, reason: collision with root package name */
    private String f11877j;

    /* renamed from: k, reason: collision with root package name */
    private String f11878k;

    /* renamed from: l, reason: collision with root package name */
    private OAuthListener f11879l;

    /* renamed from: m, reason: collision with root package name */
    private f f11880m;
    private String scope;
    private String signature;

    public static class a {

        /* renamed from: n, reason: collision with root package name */
        public OAuthErrCode f11881n;

        /* renamed from: o, reason: collision with root package name */
        public String f11882o;

        /* renamed from: p, reason: collision with root package name */
        public String f11883p;

        /* renamed from: q, reason: collision with root package name */
        public String f11884q;
        public int r;

        /* renamed from: s, reason: collision with root package name */
        public String f11885s;

        /* renamed from: t, reason: collision with root package name */
        public byte[] f11886t;

        private a() {
        }

        public static a a(byte[] bArr) {
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
                    int i3 = jSONObject.getInt("errcode");
                    if (i3 != 0) {
                        Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", Integer.valueOf(i3)));
                        aVar.f11881n = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.r = i3;
                        aVar.f11885s = jSONObject.optString("errmsg");
                        return aVar;
                    }
                    String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                    if (string != null && string.length() != 0) {
                        byte[] decode = Base64.decode(string, 0);
                        if (decode != null && decode.length != 0) {
                            aVar.f11881n = OAuthErrCode.WechatAuth_Err_OK;
                            aVar.f11886t = decode;
                            aVar.f11882o = jSONObject.getString("uuid");
                            String string2 = jSONObject.getString("appname");
                            aVar.f11883p = string2;
                            Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", aVar.f11882o, string2, Integer.valueOf(aVar.f11886t.length)));
                            return aVar;
                        }
                        Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                        oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        aVar.f11881n = oAuthErrCode2;
                        return aVar;
                    }
                    Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                    oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                    aVar.f11881n = oAuthErrCode2;
                    return aVar;
                } catch (Exception e10) {
                    message = e10.getMessage();
                    sb2 = new StringBuilder("parse json fail, ex = ");
                    sb2.append(message);
                    Log.e("MicroMsg.SDK.GetQRCodeResult", sb2.toString());
                    oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                    aVar.f11881n = oAuthErrCode;
                    return aVar;
                }
            }
            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            aVar.f11881n = oAuthErrCode;
            return aVar;
        }
    }

    public d(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.appId = str;
        this.scope = str2;
        this.f11877j = str3;
        this.f11878k = str4;
        this.signature = str5;
        this.f11879l = oAuthListener;
    }

    public final boolean a() {
        Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        f fVar = this.f11880m;
        return fVar == null ? cancel(true) : fVar.cancel(true);
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ a doInBackground(Void[] voidArr) {
        Log.i("MicroMsg.SDK.GetQRCodeTask", "external storage available = false");
        String format = String.format(f11876i, this.appId, this.f11877j, this.f11878k, this.scope, this.signature);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] a3 = e.a(format);
        Log.d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        return a.a(a3);
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(a aVar) {
        a aVar2 = aVar;
        OAuthErrCode oAuthErrCode = aVar2.f11881n;
        if (oAuthErrCode != OAuthErrCode.WechatAuth_Err_OK) {
            Log.e("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode fail, OAuthErrCode = " + oAuthErrCode);
            this.f11879l.onAuthFinish(aVar2.f11881n, null);
            return;
        }
        Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success");
        this.f11879l.onAuthGotQrcode(aVar2.f11884q, aVar2.f11886t);
        f fVar = new f(aVar2.f11882o, this.f11879l);
        this.f11880m = fVar;
        fVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
