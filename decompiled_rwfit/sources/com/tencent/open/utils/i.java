package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, i> f12100a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b, reason: collision with root package name */
    private static String f12101b = null;

    /* renamed from: c, reason: collision with root package name */
    private Context f12102c;

    /* renamed from: d, reason: collision with root package name */
    private String f12103d;
    private JSONObject e = null;

    /* renamed from: f, reason: collision with root package name */
    private long f12104f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f12105g = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f12106h = true;

    private i(Context context, String str) {
        this.f12102c = null;
        this.f12103d = null;
        this.f12102c = context.getApplicationContext();
        this.f12103d = str;
        a();
        b();
    }

    private void b() {
        if (this.f12105g != 0) {
            d("update thread is running, return");
            return;
        }
        this.f12105g = 1;
        final HashMap hashMap = new HashMap();
        hashMap.put("appid", this.f12103d);
        hashMap.put("status_os", Build.VERSION.RELEASE);
        hashMap.put("status_machine", f.a().c(g.a()));
        hashMap.put("status_version", Build.VERSION.SDK);
        hashMap.put("sdkv", Constants.SDK_VERSION);
        hashMap.put("sdkp", Const.INTENT_KEY_APIKEY);
        l.a(new Runnable() { // from class: com.tencent.open.utils.i.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.tencent.open.a.g a3 = com.tencent.open.a.f.a().a("https://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", hashMap);
                    String a10 = a3.a();
                    SLog.i("openSDK_LOG.OpenConfig", "update: get config statusCode " + a3.d());
                    i.this.a(m.d(a10));
                } catch (Exception e) {
                    SLog.e("openSDK_LOG.OpenConfig", "get config error ", e);
                }
                i.this.f12105g = 0;
            }
        });
    }

    private String c(String str) {
        InputStream open;
        String str2;
        String str3 = "";
        try {
            try {
                if (this.f12103d != null) {
                    str2 = str + "." + this.f12103d;
                } else {
                    str2 = str;
                }
                open = this.f12102c.openFileInput(str2);
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        } catch (FileNotFoundException unused) {
            open = this.f12102c.getAssets().open(str);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Charset.forName("UTF-8")));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            try {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    } catch (IOException e10) {
                        e10.printStackTrace();
                        open.close();
                        bufferedReader.close();
                    }
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            } catch (Throwable th2) {
                try {
                    open.close();
                    bufferedReader.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
                throw th2;
            }
        }
        str3 = stringBuffer.toString();
        open.close();
        bufferedReader.close();
        return str3;
    }

    private void d(String str) {
        if (this.f12106h) {
            StringBuilder u10 = l0.u(str, "; appid: ");
            u10.append(this.f12103d);
            SLog.v("openSDK_LOG.OpenConfig", u10.toString());
        }
    }

    public static i a(Context context, String str) {
        i iVar;
        synchronized (f12100a) {
            try {
                SLog.v("openSDK_LOG.OpenConfig", "getInstance begin");
                if (str != null) {
                    f12101b = str;
                }
                if (str == null && (str = f12101b) == null) {
                    str = "0";
                }
                iVar = f12100a.get(str);
                if (iVar == null) {
                    iVar = new i(context, str);
                    f12100a.put(str, iVar);
                }
                SLog.v("openSDK_LOG.OpenConfig", "getInstance end");
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return iVar;
    }

    public boolean b(String str) {
        d(l0.n("get ", str));
        c();
        Object opt = this.e.opt(str);
        if (opt == null) {
            return false;
        }
        if (opt instanceof Integer) {
            return !opt.equals(0);
        }
        if (opt instanceof Boolean) {
            return ((Boolean) opt).booleanValue();
        }
        return false;
    }

    private void a() {
        try {
            this.e = new JSONObject(c("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.e = new JSONObject();
        }
    }

    private void a(String str, String str2) {
        try {
            if (this.f12103d != null) {
                str = str + "." + this.f12103d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f12102c.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void c() {
        int optInt = this.e.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f12104f >= optInt * 3600000) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        d("cgi back, do update");
        this.e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f12104f = SystemClock.elapsedRealtime();
    }

    public int a(String str) {
        d(l0.n("get ", str));
        c();
        return this.e.optInt(str);
    }
}
