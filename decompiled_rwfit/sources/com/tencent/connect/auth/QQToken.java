package com.tencent.connect.auth;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.open.web.security.JniInterface;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;

    /* renamed from: g, reason: collision with root package name */
    private static SharedPreferences f11727g;

    /* renamed from: a, reason: collision with root package name */
    private String f11728a;

    /* renamed from: b, reason: collision with root package name */
    private String f11729b;

    /* renamed from: c, reason: collision with root package name */
    private String f11730c;

    /* renamed from: d, reason: collision with root package name */
    private int f11731d = 1;
    private long e = -1;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.open.utils.a f11732f;

    public QQToken(String str) {
        this.f11728a = str;
    }

    @TargetApi(11)
    private static synchronized SharedPreferences a() {
        SharedPreferences sharedPreferences;
        synchronized (QQToken.class) {
            try {
                if (f11727g == null) {
                    f11727g = g.a().getSharedPreferences("token_info_file", 0);
                }
                sharedPreferences = f11727g;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return sharedPreferences;
    }

    @Deprecated
    private static String b(String str) {
        return Base64.encodeToString(m.j(str), 2);
    }

    @Deprecated
    private static String c(String str) {
        return Base64.encodeToString(m.j(str), 2) + "_spkey";
    }

    public String getAccessToken() {
        return this.f11729b;
    }

    public String getAppId() {
        return this.f11728a;
    }

    public int getAuthSource() {
        return this.f11731d;
    }

    public long getExpireTimeInSecond() {
        return this.e;
    }

    public String getOpenId() {
        return this.f11730c;
    }

    public String getOpenIdWithCache() {
        String openId = getOpenId();
        try {
            if (!TextUtils.isEmpty(openId)) {
                SLog.i("QQToken", "getOpenId from field openId = " + openId + " appId = " + this.f11728a);
                return openId;
            }
            JSONObject loadSession = loadSession(this.f11728a);
            if (loadSession != null) {
                openId = loadSession.getString("openid");
                if (!TextUtils.isEmpty(openId)) {
                    setOpenId(openId);
                }
            }
            SLog.i("QQToken", "getOpenId from Session openId = " + openId + " appId = " + this.f11728a);
            return openId;
        } catch (Exception e) {
            SLog.i("QQToken", "getLocalOpenIdByAppId " + e.toString());
            return openId;
        }
    }

    public boolean isSessionValid() {
        return this.f11729b != null && System.currentTimeMillis() < this.e;
    }

    public JSONObject loadSession(String str) {
        try {
            if (this.f11732f == null) {
                this.f11732f = new com.tencent.open.utils.a(g.a());
            }
            return a(str, this.f11732f);
        } catch (Exception e) {
            SLog.i("QQToken", "login loadSession" + e.toString());
            return null;
        }
    }

    public void removeSession(String str) {
        SharedPreferences.Editor edit = a().edit();
        edit.remove(c(str));
        edit.remove(c(str));
        edit.remove(a(str));
        edit.apply();
        SLog.i("QQToken", "removeSession sucess");
    }

    public boolean saveSession(JSONObject jSONObject) {
        try {
            if (this.f11732f == null) {
                this.f11732f = new com.tencent.open.utils.a(g.a());
            }
            return a(this.f11728a, jSONObject, this.f11732f);
        } catch (Exception e) {
            SLog.i("QQToken", "login saveSession" + e.toString());
            return false;
        }
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        this.f11729b = str;
        this.e = 0L;
        if (str2 != null) {
            this.e = (Long.parseLong(str2) * 1000) + System.currentTimeMillis();
        }
    }

    public void setAppId(String str) {
        this.f11728a = str;
    }

    public void setAuthSource(int i3) {
        this.f11731d = i3;
    }

    public void setOpenId(String str) {
        this.f11730c = str;
        com.tencent.open.b.b.a().a(str);
    }

    private static synchronized JSONObject a(String str, com.tencent.open.utils.a aVar) {
        String b3;
        synchronized (QQToken.class) {
            if (g.a() == null) {
                SLog.i("QQToken", "loadJsonPreference context null");
                return null;
            }
            if (str == null) {
                SLog.i("QQToken", "loadJsonPreference prefKey is null");
                return null;
            }
            String string = a().getString(a(str), "");
            if (TextUtils.isEmpty(string)) {
                if (!JniInterface.isJniOk) {
                    k.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                    JniInterface.loadSo();
                }
                if (!JniInterface.isJniOk) {
                    SLog.i("QQToken", "loadJsonPreference jni load fail SECURE_LIB_VERSION=5");
                    return null;
                }
                String c9 = c(str);
                String string2 = a().getString(c9, "");
                try {
                    if (TextUtils.isEmpty(string2)) {
                        String b10 = b(str);
                        String string3 = a().getString(b10, "");
                        try {
                            if (TextUtils.isEmpty(string3)) {
                                SLog.i("QQToken", "loadJsonPreference oldDesValue null");
                                return null;
                            }
                            try {
                                b3 = JniInterface.d1(string3);
                                if (TextUtils.isEmpty(b3)) {
                                    SLog.i("QQToken", "loadJsonPreference decodeResult d1 empty");
                                    return null;
                                }
                                a(str, new JSONObject(b3), aVar);
                            } catch (Exception e) {
                                SLog.e("QQToken", "Catch Exception", e);
                                return null;
                            }
                        } finally {
                            a().edit().remove(b10).apply();
                        }
                    } else {
                        try {
                            b3 = JniInterface.d2(string2);
                            a(str, new JSONObject(b3), aVar);
                        } catch (Exception e10) {
                            SLog.e("QQToken", "Catch Exception", e10);
                            return null;
                        }
                    }
                } finally {
                    a().edit().remove(c9).apply();
                }
            } else {
                b3 = aVar.b(string);
            }
            try {
                JSONObject jSONObject = new JSONObject(b3);
                SLog.i("QQToken", "loadJsonPreference sucess");
                return jSONObject;
            } catch (Exception e11) {
                SLog.i("QQToken", "loadJsonPreference decode " + e11.toString());
                return null;
            }
        }
    }

    private static synchronized boolean a(String str, JSONObject jSONObject, com.tencent.open.utils.a aVar) {
        synchronized (QQToken.class) {
            if (g.a() == null) {
                SLog.i("QQToken", "saveJsonPreference context null");
                return false;
            }
            if (str != null && jSONObject != null) {
                try {
                    String string = jSONObject.getString(Constants.PARAM_EXPIRES_IN);
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put(Constants.PARAM_EXPIRES_TIME, (Long.parseLong(string) * 1000) + System.currentTimeMillis());
                        String a3 = a(str);
                        String a10 = aVar.a(jSONObject.toString());
                        if (a3.length() > 6 && a10 != null) {
                            a().edit().putString(a3, a10).commit();
                            SLog.i("QQToken", "saveJsonPreference sucess");
                            return true;
                        }
                        SLog.i("QQToken", "saveJsonPreference keyEncode or josnEncode null");
                        return false;
                    }
                    SLog.i("QQToken", "expires is null");
                    return false;
                } catch (Exception e) {
                    SLog.e("QQToken", "saveJsonPreference exception:" + e.toString());
                    return false;
                }
            }
            SLog.i("QQToken", "saveJsonPreference prefKey or jsonObject null");
            return false;
        }
    }

    private static String a(String str) {
        return Base64.encodeToString(m.j(str), 2) + "_aes_google";
    }
}
