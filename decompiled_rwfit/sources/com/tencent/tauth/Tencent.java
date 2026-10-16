package com.tencent.tauth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.connect.api.QQAuthManage;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.avatar.QQAvatar;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.commonchannel.CommonChannelApi;
import com.tencent.connect.emotion.QQEmotion;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.SocialConstants;
import com.tencent.open.SocialOperation;
import com.tencent.open.apireq.IApiCallback;
import com.tencent.open.b.b;
import com.tencent.open.im.IM;
import com.tencent.open.log.SLog;
import com.tencent.open.log.Tracer;
import com.tencent.open.miniapp.MiniApp;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class Tencent {
    public static final int REQUEST_LOGIN = 10001;
    public static boolean USE_ONE_HOUR = false;

    /* renamed from: c, reason: collision with root package name */
    private static Tencent f12135c = null;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f12136d = false;

    /* renamed from: a, reason: collision with root package name */
    private final c f12137a;

    /* renamed from: b, reason: collision with root package name */
    private String f12138b;

    private Tencent(String str, Context context) {
        this.f12137a = c.a(str, context);
        b.a().a(str, context);
        f.a().a(context);
    }

    private static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 128);
            try {
                context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 128);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
                SLog.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>");
                return false;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            SLog.e("openSDK_LOG.Tencent", "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity" + (l0.o("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent", str, "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + str + "\" />\n</intent-filter>\n</activity>"));
            return false;
        }
    }

    public static synchronized Tencent createInstance(String str, Context context, String str2) {
        Tencent createInstance;
        synchronized (Tencent.class) {
            try {
                createInstance = createInstance(str, context);
                SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str + ", authorities=" + str2);
                a("createInstance_authority", "appid", str, "authorities", str2);
                if (createInstance != null) {
                    createInstance.f12138b = str2;
                } else {
                    SLog.i("openSDK_LOG.Tencent", "null == tencent set mAuthorities fail");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return createInstance;
    }

    public static synchronized String getAuthorities(String str) {
        synchronized (Tencent.class) {
            a("getAuthorities", "appid", str);
            if (TextUtils.isEmpty(str)) {
                SLog.i("openSDK_LOG.Tencent", "TextUtils.isEmpty(appId)");
                return null;
            }
            Tencent tencent = f12135c;
            if (tencent != null) {
                return str.equals(tencent.getAppId()) ? f12135c.f12138b : "";
            }
            SLog.i("openSDK_LOG.Tencent", "sInstance == null");
            return null;
        }
    }

    public static void handleResultData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb2 = new StringBuilder("handleResultData() data = null ? ");
        sb2.append(intent == null);
        sb2.append(", listener = null ? ");
        sb2.append(iUiListener == null);
        SLog.i("openSDK_LOG.Tencent", sb2.toString());
        a("handleResultData", new Object[0]);
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public static boolean isPermissionNotGranted() {
        return !f12136d || TextUtils.isEmpty(f.a().b());
    }

    public static boolean isSupportPushToQZone(Context context) {
        boolean z5 = k.c(context, "5.9.5") >= 0;
        SLog.i("openSDK_LOG.Tencent", "isSupportPushToQZone() support=" + z5);
        a("isSupportPushToQZone", Boolean.valueOf(z5));
        return z5;
    }

    public static boolean isSupportShareToQQ(Context context) {
        SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ()");
        boolean z5 = true;
        if (m.c(context) && k.a(context, Constants.PACKAGE_QQ_PAD) != null) {
            a("isSupportShareToQQ", Boolean.TRUE);
            return true;
        }
        if (k.c(context, "4.1") < 0 && k.a(context, Constants.PACKAGE_TIM) == null) {
            z5 = false;
        }
        SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ() support=" + z5);
        a("isSupportShareToQQ", Boolean.valueOf(z5));
        return z5;
    }

    public static boolean onActivityResultData(int i3, int i10, Intent intent, IUiListener iUiListener) {
        StringBuilder s7 = l0.s(i3, "onActivityResultData() reqcode = ", i10, ", resultcode = ", ", data = null ? ");
        s7.append(intent == null);
        s7.append(", listener = null ? ");
        s7.append(iUiListener == null);
        SLog.i("openSDK_LOG.Tencent", s7.toString());
        a("onActivityResultData", "requestCode", Integer.valueOf(i3), "resultCode", Integer.valueOf(i10));
        return UIListenerManager.getInstance().onActivityResult(i3, i10, intent, iUiListener);
    }

    public static Map<String, String> parseMiniParameters(Intent intent) {
        a("parseMiniParameters", new Object[0]);
        HashMap hashMap = new HashMap();
        if (intent == null) {
            SLog.e("openSDK_LOG.Tencent", "parseMiniParameters null == intent");
            return hashMap;
        }
        try {
            String stringExtra = intent.getStringExtra("appParameter");
            if (TextUtils.isEmpty(stringExtra)) {
                Uri data = intent.getData();
                if (data == null) {
                    SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uri==null");
                    return hashMap;
                }
                String uri = data.toString();
                if (TextUtils.isEmpty(uri)) {
                    SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriStr isEmpty");
                    return hashMap;
                }
                String substring = uri.substring(uri.lastIndexOf(63) + 1);
                if (TextUtils.isEmpty(substring)) {
                    SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam is empty");
                    return hashMap;
                }
                SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam=" + substring);
                for (String str : substring.split(Const.STR_MART_ADD)) {
                    String[] split = str.split("=");
                    if (split.length == 2) {
                        hashMap.put(split[0], split[1]);
                    }
                }
            } else {
                SLog.d("openSDK_LOG.Tencent", "parseMiniParameters appParameter=" + stringExtra);
                JSONObject jSONObject = new JSONObject(stringExtra);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
            }
        } catch (Exception e) {
            SLog.e("openSDK_LOG.Tencent", "parseMiniParameters Exception", e);
        }
        return hashMap;
    }

    public static void resetQQAppInfoCache() {
        k.a("com.tencent.mobileqq");
    }

    public static void resetTargetAppInfoCache() {
        k.a();
    }

    public static void resetTimAppInfoCache() {
        k.a(Constants.PACKAGE_TIM);
    }

    public static void setCustomLogger(Tracer tracer) {
        SLog.i("openSDK_LOG.Tencent", "setCustomLogger");
        a("setCustomLogger", new Object[0]);
        SLog.getInstance().setCustomLogger(tracer);
    }

    public static void setIsPermissionGranted(boolean z5) {
        String str;
        if (z5) {
            f.a().a(g.a());
            str = f.a().b();
            if (str == null || str.isEmpty()) {
                str = Build.MODEL;
            }
        } else {
            str = "";
        }
        setIsPermissionGranted(z5, str);
    }

    public void bindQQGroup(Activity activity, String str, String str2, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "bindQQGroup()");
        a("bindQQGroup", "organizationId", str, "organizationName", str2);
        new SocialOperation(getQQToken()).bindQQGroup(activity, str, str2, iUiListener);
    }

    public void callCommonChannelApi(Activity activity, Bundle bundle, IUiListener iUiListener) {
        c cVar = this.f12137a;
        SLog.i("openSDK_LOG.Tencent", "callCommonChannelApi ret: " + new CommonChannelApi(cVar, cVar.b()).launchQQ(activity, bundle, iUiListener));
    }

    public void checkLogin(IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "checkLogin()");
        a("checkLogin", new Object[0]);
        this.f12137a.a(iUiListener);
    }

    public String getAccessToken() {
        String accessToken = this.f12137a.b().getAccessToken();
        SLog.i("openSDK_LOG.Tencent", "getAccessToken() accessToken = " + accessToken);
        a("getAccessToken", new Object[0]);
        return accessToken;
    }

    public String getAppId() {
        String appId = this.f12137a.b().getAppId();
        SLog.i("openSDK_LOG.Tencent", "getAppId() appid =" + appId);
        a("getAppId", appId);
        return appId;
    }

    public long getExpiresIn() {
        long expireTimeInSecond = this.f12137a.b().getExpireTimeInSecond();
        SLog.i("openSDK_LOG.Tencent", "getExpiresIn() expiresin= " + expireTimeInSecond);
        a("getExpiresIn", Long.valueOf(expireTimeInSecond));
        return expireTimeInSecond;
    }

    public String getOpenId() {
        String openId = this.f12137a.b().getOpenId();
        SLog.i("openSDK_LOG.Tencent", "getOpenId() openid= " + openId);
        a("getOpenId", new Object[0]);
        return openId;
    }

    public QQToken getQQToken() {
        SLog.i("openSDK_LOG.Tencent", "getQQToken()");
        a("getQQToken", new Object[0]);
        return this.f12137a.b();
    }

    @Deprecated
    public void handleLoginData(Intent intent, IUiListener iUiListener) {
        StringBuilder sb2 = new StringBuilder("handleLoginData() data = null ? ");
        sb2.append(intent == null);
        sb2.append(", listener = null ? ");
        sb2.append(iUiListener == null);
        SLog.i("openSDK_LOG.Tencent", sb2.toString());
        a("handleLoginData", new Object[0]);
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public void initSessionCache(JSONObject jSONObject) {
        a("initSessionCache", new Object[0]);
        try {
            String string = jSONObject.getString(Constants.PARAM_ACCESS_TOKEN);
            String string2 = jSONObject.getString(Constants.PARAM_EXPIRES_IN);
            String string3 = jSONObject.getString("openid");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3)) {
                setAccessToken(string, string2);
                setOpenId(string3);
            }
            SLog.i("openSDK_LOG.Tencent", "initSessionCache()");
        } catch (Exception e) {
            SLog.i("QQToken", "initSessionCache " + e.toString());
        }
    }

    public boolean isQQInstalled(Context context) {
        boolean b3 = k.b(context);
        SLog.i("openSDK_LOG.Tencent", "isQQInstalled() installed=" + b3);
        a("isQQInstalled", Boolean.valueOf(b3));
        return b3;
    }

    public boolean isReady() {
        boolean z5 = isSessionValid() && getOpenId() != null;
        SLog.i("openSDK_LOG.Tencent", "isReady() --ready=" + z5);
        a("isReady", Boolean.valueOf(z5));
        return z5;
    }

    public boolean isSessionValid() {
        boolean c9 = this.f12137a.c();
        SLog.i("openSDK_LOG.Tencent", "isSessionValid() isvalid =" + c9);
        a("isSessionValid", Boolean.valueOf(c9));
        return c9;
    }

    public boolean isSupportSSOLogin(Activity activity) {
        SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin()");
        boolean z5 = true;
        if (m.c(activity) && k.a((Context) activity, Constants.PACKAGE_QQ_PAD) != null) {
            a("isSupportSSOLogin", Boolean.TRUE);
            return true;
        }
        if (k.c(activity, "4.1") < 0 && k.d(activity, "1.1") < 0) {
            z5 = false;
        }
        SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin() support=" + z5);
        a("isSupportSSOLogin", Boolean.valueOf(z5));
        return z5;
    }

    public void joinQQGroup(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "joinQQGroup()");
        a("joinQQGroup", "organizationId", str);
        new SocialOperation(getQQToken()).joinGroup(activity, str, iUiListener);
    }

    public JSONObject loadSession(String str) {
        JSONObject loadSession = this.f12137a.b().loadSession(str);
        StringBuilder r = e.r("loadSession() appid ", str, ", length=");
        r.append(loadSession != null ? loadSession.length() : 0);
        SLog.i("openSDK_LOG.Tencent", r.toString());
        a("loadSession", "appid", str);
        return loadSession;
    }

    public int login(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        a("login_scope", Constants.PARAM_SCOPE, str);
        return this.f12137a.a(activity, str, iUiListener);
    }

    public int loginServerSide(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "loginServerSide() with activity, scope = " + str + ",server_side");
        a("loginServerSide_activity", Constants.PARAM_SCOPE, str);
        return this.f12137a.a(activity, str + ",server_side", iUiListener);
    }

    public int loginWithOEM(Activity activity, String str, IUiListener iUiListener, boolean z5, String str2, String str3, String str4) {
        SLog.i("openSDK_LOG.Tencent", "loginWithOEM() with activity, scope = " + str);
        a("loginWithOEM", Constants.PARAM_SCOPE, str, "qrcode", Boolean.valueOf(z5), "registerChannel", str2, "installChannel", str3, "businessId", str4);
        return this.f12137a.a(activity, str, iUiListener, z5, str2, str3, str4);
    }

    public void logout(Context context) {
        SLog.i("openSDK_LOG.Tencent", "logout()");
        a("logout", new Object[0]);
        this.f12137a.b().setAccessToken(null, "0");
        this.f12137a.b().setOpenId(null);
        this.f12137a.b().removeSession(this.f12137a.b().getAppId());
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "publishToQzone()");
        a("publishToQzone", new Object[0]);
        new QzonePublish(activity, this.f12137a.b()).publishToQzone(activity, bundle, iUiListener);
    }

    public int reAuth(Activity activity, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "reAuth() with activity, scope = " + str);
        a("reAuth", Constants.PARAM_SCOPE, str);
        return this.f12137a.b(activity, str, iUiListener);
    }

    public void reportDAU() {
        SLog.i("openSDK_LOG.Tencent", "reportDAU() ");
        a("reportDAU", new Object[0]);
        this.f12137a.a();
    }

    public JSONObject request(String str, Bundle bundle, String str2) throws IOException, JSONException, HttpUtils.NetworkUnavailableException, HttpUtils.HttpStatusException {
        SLog.i("openSDK_LOG.Tencent", "request()");
        a(SocialConstants.TYPE_REQUEST, "graphPath", str, "httpMethod", str2);
        return HttpUtils.request(this.f12137a.b(), g.a(), str, bundle, str2);
    }

    public void requestAsync(String str, Bundle bundle, String str2, IRequestListener iRequestListener) {
        SLog.i("openSDK_LOG.Tencent", "requestAsync()");
        a("requestAsync", "graphPath", str, "httpMethod", str2);
        HttpUtils.requestAsync(this.f12137a.b(), g.a(), str, bundle, str2, iRequestListener);
    }

    public void saveSession(JSONObject jSONObject) {
        StringBuilder sb2 = new StringBuilder("saveSession() length=");
        sb2.append(jSONObject != null ? jSONObject.length() : 0);
        SLog.i("openSDK_LOG.Tencent", sb2.toString());
        a("saveSession", new Object[0]);
        this.f12137a.b().saveSession(jSONObject);
    }

    public void setAccessToken(String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "setAccessToken(), expiresIn = " + str2 + "");
        a("setAccessToken", new Object[0]);
        this.f12137a.a(str, str2);
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "setAvatar()");
        a("setAvatar", new Object[0]);
        String string = bundle.getString("picture");
        new QQAvatar(this.f12137a.b()).setAvatar(activity, Uri.parse(string), iUiListener, bundle.getInt("exitAnim"));
    }

    public void setAvatarByQQ(Activity activity, Uri uri, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "setAvatarByQQ()");
        a("setAvatarByQQ", new Object[0]);
        new QQAvatar(this.f12137a.b()).setAvatarByQQ(activity, uri, iUiListener);
    }

    public void setDynamicAvatar(Activity activity, Uri uri, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "setDynamicAvatar()");
        a("setDynamicAvatar", new Object[0]);
        new QQAvatar(this.f12137a.b()).setDynamicAvatar(activity, uri, iUiListener);
    }

    public void setEmotions(Activity activity, ArrayList<Uri> arrayList, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "saveQQEmotions()");
        a("setEmotions", new Object[0]);
        new QQEmotion(this.f12137a.b()).setEmotions(activity, arrayList, iUiListener);
    }

    public void setOpenId(String str) {
        SLog.i("openSDK_LOG.Tencent", "setOpenId() --start");
        a("setOpenId", new Object[0]);
        this.f12137a.b(g.a(), str);
        SLog.i("openSDK_LOG.Tencent", "setOpenId() --end");
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "shareToQQ()");
        a("shareToQQ", new Object[0]);
        if (TextUtils.isEmpty(this.f12138b)) {
            iUiListener.onWarning(-19);
        }
        new QQShare(activity, this.f12137a.b()).shareToQQ(activity, bundle, iUiListener);
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "shareToQzone()");
        a("shareToQzone", new Object[0]);
        new QzoneShare(activity, this.f12137a.b()).shareToQzone(activity, bundle, iUiListener);
    }

    public void startAuthManagePage(Activity activity, IApiCallback iApiCallback) {
        SLog.i("openSDK_LOG.Tencent", "startAuthManagePage");
        new QQAuthManage(this.f12137a, getQQToken()).gotoManagePage(activity, iApiCallback);
    }

    public int startIMAio(Activity activity, String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "startIMAio()");
        a("startIMAio", "uin", str, Constants.PARAM_PKG_NAME, str2);
        return startIMConversation(activity, IM.CHAT_TYPE_AIO, str, str2);
    }

    public int startIMAudio(Activity activity, String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "startIMAudio()");
        a("startIMAudio", "uin", str, Constants.PARAM_PKG_NAME, str2);
        return startIMConversation(activity, IM.CHAT_TYPE_AUDIO_CHAT, str, str2);
    }

    public int startIMConversation(Activity activity, String str, String str2, String str3) {
        a("startIMConversation", "chatType", str, "uin", str2, Constants.PARAM_PKG_NAME, str3);
        return new IM(getQQToken()).startIMConversation(activity, str, str2, str3);
    }

    public int startIMVideo(Activity activity, String str, String str2) {
        SLog.i("openSDK_LOG.Tencent", "startIMVideo()");
        a("startIMVideo", "uin", str, Constants.PARAM_PKG_NAME, str2);
        return startIMConversation(activity, IM.CHAT_TYPE_VIDEO_CHAT, str, str2);
    }

    public int startMiniApp(Activity activity, String str, String str2, String str3) {
        SLog.i("openSDK_LOG.Tencent", "startMiniApp()");
        a("startMiniApp", "miniAppId", str, "miniAppPath", str2, "miniAppVersion", str3);
        return new MiniApp(getQQToken()).startMiniApp(activity, MiniApp.MINIAPP_TYPE_NORMAL, str, "21", str2, str3);
    }

    public void unBindQQGroup(Context context, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "unBindQQGroup()");
        a("unBindQQGroup", "organizationId", str);
        new SocialOperation(getQQToken()).unBindGroup(context, str, iUiListener);
    }

    public boolean isQQInstalled(Context context, String str) {
        boolean z5 = k.c(context, str) >= 0;
        SLog.i("openSDK_LOG.Tencent", "isQQInstalled version[" + str + "] = " + z5);
        return z5;
    }

    public int login(Activity activity, IUiListener iUiListener, Map<String, Object> map) {
        SLog.i("openSDK_LOG.Tencent", "login activity with params");
        a("login_param", new Object[0]);
        return this.f12137a.a(activity, iUiListener, map);
    }

    public int loginServerSide(Fragment fragment, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "loginServerSide() with fragment, scope = " + str + ",server_side");
        a("loginServerSide_fragment", Constants.PARAM_SCOPE, str);
        return this.f12137a.a(fragment, e.l(str, ",server_side"), iUiListener, "");
    }

    public static synchronized Tencent createInstance(String str, Context context) {
        synchronized (Tencent.class) {
            g.a(context.getApplicationContext());
            SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str);
            if (TextUtils.isEmpty(str)) {
                SLog.e("openSDK_LOG.Tencent", "appId should not be empty!");
                return null;
            }
            Tencent tencent = f12135c;
            if (tencent == null) {
                f12135c = new Tencent(str, context);
            } else if (!str.equals(tencent.getAppId())) {
                f12135c.logout(context);
                f12135c = new Tencent(str, context);
            }
            if (!a(context, str)) {
                return null;
            }
            a("createInstance", "appid", str);
            com.tencent.open.a.f.a().a(i.a(context, str));
            SLog.i("openSDK_LOG.Tencent", "createInstance()  -- end");
            return f12135c;
        }
    }

    public static void setIsPermissionGranted(boolean z5, String str) {
        if (z5) {
            if (str == null || str.trim().isEmpty()) {
                SLog.e("openSDK_LOG.Tencent", "setIsPermissionGranted error! model= [" + str + "]");
                z5 = false;
            }
            f12136d = z5;
            f.a().a(g.a(), str);
        }
        str = null;
        f12136d = z5;
        f.a().a(g.a(), str);
    }

    public int login(Activity activity, String str, IUiListener iUiListener, boolean z5) {
        SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        a("login_qrcode", Constants.PARAM_SCOPE, str, "qrcode", Boolean.valueOf(z5));
        return this.f12137a.a(activity, str, iUiListener, z5);
    }

    public void setAvatar(Activity activity, Bundle bundle, IUiListener iUiListener, int i3, int i10) {
        SLog.i("openSDK_LOG.Tencent", "setAvatar()");
        a("setAvatar_anim", new Object[0]);
        bundle.putInt("exitAnim", i10);
        activity.overridePendingTransition(i3, 0);
        setAvatar(activity, bundle, iUiListener);
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener) {
        SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        a("login_fragment_scope", Constants.PARAM_SCOPE, str);
        return this.f12137a.a(fragment, str, iUiListener, "");
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener, boolean z5) {
        SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        a("login_fragment_scope_qrcode", Constants.PARAM_SCOPE, str, "qrcode", Boolean.valueOf(z5));
        return this.f12137a.a(fragment, str, iUiListener, "", z5);
    }

    private static void a(String str, Object... objArr) {
        b.a().a(str, a(objArr));
    }

    private static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0 || objArr.length % 2 != 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int length = objArr.length;
        for (int i3 = 0; i3 < length; i3 += 2) {
            if (i3 > 0) {
                sb2.append('|');
            }
            sb2.append(objArr[i3]);
            sb2.append(':');
            sb2.append(objArr[i3 + 1]);
        }
        return sb2.toString();
    }

    private static void a(String str, Object obj) {
        b.a().a(str, obj);
    }
}
