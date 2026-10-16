package com.tencent.connect.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.c;
import com.tencent.open.utils.d;
import com.tencent.open.utils.g;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class QQShare extends BaseApi {
    public static final int QQ_SHARE_SUMMARY_MAX_LENGTH = 512;
    public static final int QQ_SHARE_TITLE_MAX_LENGTH = 128;
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_ARK_INFO = "share_to_qq_ark_info";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final int SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN = 1;
    public static final int SHARE_TO_QQ_FLAG_QZONE_ITEM_HIDE = 2;
    public static final String SHARE_TO_QQ_GAME_MESSAGE_EXT = "game_message_ext";
    public static final String SHARE_TO_QQ_GAME_TAG_NAME = "game_tag_name";
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QQ_MINI_PROGRAM = 7;
    public static final String SHARE_TO_QQ_MINI_PROGRAM_APPID = "mini_program_appid";
    public static final String SHARE_TO_QQ_MINI_PROGRAM_PATH = "mini_program_path";
    public static final String SHARE_TO_QQ_MINI_PROGRAM_TYPE = "mini_program_type";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final int SHARE_TO_QQ_TYPE_AUDIO = 2;
    public static final int SHARE_TO_QQ_TYPE_DEFAULT = 1;
    public static final int SHARE_TO_QQ_TYPE_IMAGE = 5;
    public String mViaShareQQType;

    public QQShare(Context context, QQToken qQToken) {
        super(qQToken);
        this.mViaShareQQType = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Activity activity, Bundle bundle, IUiListener iUiListener) {
        int i3;
        int i10;
        SLog.i("openSDK_LOG.QQShare", "doShareToQQ() -- start");
        StringBuffer stringBuffer = new StringBuffer("mqqapi://share/to_fri?src_type=app&version=1&file_type=news");
        String string = bundle.getString("imageUrl");
        String string2 = bundle.getString("title");
        String string3 = bundle.getString("summary");
        String string4 = bundle.getString("targetUrl");
        String string5 = bundle.getString("audio_url");
        int i11 = bundle.getInt("req_type", 1);
        String string6 = bundle.getString(SHARE_TO_QQ_ARK_INFO);
        String string7 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_APPID);
        String string8 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_PATH);
        String string9 = bundle.getString(SHARE_TO_QQ_MINI_PROGRAM_TYPE);
        int i12 = bundle.getInt("cflag", 0);
        String string10 = bundle.getString("share_qq_ext_str");
        String a3 = m.a(activity);
        if (a3 == null) {
            a3 = bundle.getString("appName");
        }
        String str = a3;
        String string11 = bundle.getString("imageLocalUrl");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("imageLocalUrlArray");
        String appId = this.f11836c.getAppId();
        String openIdWithCache = this.f11836c.getOpenIdWithCache();
        SLog.i("openSDK_LOG.QQShare", "doShareToQQ -- openid: " + openIdWithCache + ",appName=" + str);
        if (stringArrayList != null && stringArrayList.size() >= 2) {
            String str2 = stringArrayList.get(0);
            if (str2 == null) {
                str2 = "";
            }
            l0.C(str2, 2, new StringBuilder("&file_data="), stringBuffer);
            String str3 = stringArrayList.get(1);
            if (i11 == 7 && !TextUtils.isEmpty(str3) && k.c(activity, "8.3.3") < 0) {
                SLog.e("openSDK_LOG.QQShare", "doShareToQQ() share to mini program set file uri empty");
                str3 = null;
            }
            Uri a10 = m.a(activity, appId, str3);
            if (a10 != null) {
                stringBuffer.append("&file_uri=");
                stringBuffer.append(Base64.encodeToString(m.j(a10.toString()), 2));
            }
        } else if (!TextUtils.isEmpty(string11)) {
            l0.C(string11, 2, new StringBuilder("&file_data="), stringBuffer);
        }
        if (!TextUtils.isEmpty(string)) {
            l0.C(string, 2, new StringBuilder("&image_url="), stringBuffer);
        }
        if (!TextUtils.isEmpty(string2)) {
            l0.C(string2, 2, new StringBuilder("&title="), stringBuffer);
        }
        if (!TextUtils.isEmpty(string3)) {
            l0.C(string3, 2, new StringBuilder("&description="), stringBuffer);
        }
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!TextUtils.isEmpty(string4)) {
            l0.C(string4, 2, new StringBuilder("&url="), stringBuffer);
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 20) {
                str = str.substring(0, 20) + "...";
            }
            l0.C(str, 2, new StringBuilder("&app_name="), stringBuffer);
        }
        if (!TextUtils.isEmpty(openIdWithCache)) {
            l0.C(openIdWithCache, 2, new StringBuilder("&open_id="), stringBuffer);
        }
        if (!TextUtils.isEmpty(string5)) {
            l0.C(string5, 2, new StringBuilder("&audioUrl="), stringBuffer);
        }
        stringBuffer.append("&req_type=" + Base64.encodeToString(m.j(String.valueOf(i11)), 2));
        if (!TextUtils.isEmpty(string7)) {
            stringBuffer.append("&mini_program_appid=" + Base64.encodeToString(m.j(String.valueOf(string7)), 2));
        }
        if (!TextUtils.isEmpty(string8)) {
            stringBuffer.append("&mini_program_path=" + Base64.encodeToString(m.j(String.valueOf(string8)), 2));
        }
        if (!TextUtils.isEmpty(string9)) {
            stringBuffer.append("&mini_program_type=" + Base64.encodeToString(m.j(String.valueOf(string9)), 2));
        }
        if (!TextUtils.isEmpty(string6)) {
            l0.C(string6, 2, new StringBuilder("&share_to_qq_ark_info="), stringBuffer);
        }
        if (!TextUtils.isEmpty(string10)) {
            l0.C(string10, 2, new StringBuilder("&share_qq_ext_str="), stringBuffer);
        }
        stringBuffer.append("&cflag=" + Base64.encodeToString(m.j(String.valueOf(i12)), 2));
        stringBuffer.append("&third_sd=" + Base64.encodeToString(m.j(String.valueOf(m.c())), 2));
        SLog.v("openSDK_LOG.QQShare", "doShareToQQ -- url: " + stringBuffer.toString());
        com.tencent.connect.a.a.a(g.a(), this.f11836c, "requireApi", "shareToNativeQQ");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.putExtra(Constants.PARAM_PKG_NAME, activity.getPackageName());
        boolean a11 = a(intent);
        SLog.i("openSDK_LOG.QQShare", "doShareToQQ hasActivityForIntent? " + a11);
        if (m.f(activity, "4.6.0")) {
            SLog.i("openSDK_LOG.QQShare", "doShareToQQ, qqver below 4.6.");
            if (a11) {
                UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_OLD_SHARE, iUiListener);
                a(activity, intent, Constants.REQUEST_OLD_SHARE);
            }
            i10 = i12;
            i3 = 1;
        } else {
            SLog.i("openSDK_LOG.QQShare", "doShareToQQ, qqver greater than 4.6.");
            if (UIListenerManager.getInstance().setListnerWithAction("shareToQQ", iUiListener) != null) {
                SLog.i("openSDK_LOG.QQShare", "doShareToQQ, last listener is not null, cancel it.");
            }
            if (a11) {
                i3 = 1;
                a(activity, Constants.REQUEST_QQ_SHARE, intent, true);
            } else {
                i3 = 1;
            }
            i10 = i12;
        }
        String str4 = i10 == i3 ? Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE : Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        if (a11) {
            e.a().a(this.f11836c.getOpenId(), this.f11836c.getAppId(), Constants.VIA_SHARE_TO_QQ, str4, "3", "0", this.mViaShareQQType, "0", "1", "0");
            e.a().a(0, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f11836c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
        } else {
            e.a().a(this.f11836c.getOpenId(), this.f11836c.getAppId(), Constants.VIA_SHARE_TO_QQ, str4, "3", "1", this.mViaShareQQType, "0", "1", "0");
            e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, this.f11836c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
        }
        SLog.i("openSDK_LOG.QQShare", "doShareToQQ() --end");
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void shareToQQ(android.app.Activity r25, android.os.Bundle r26, com.tencent.tauth.IUiListener r27) {
        /*
            Method dump skipped, instructions count: 725
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QQShare.shareToQQ(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }

    private void b(final Activity activity, final Bundle bundle, final IUiListener iUiListener) {
        SLog.i("openSDK_LOG.QQShare", "shareToMobileQQ() -- start.");
        String string = bundle.getString("imageUrl");
        final String string2 = bundle.getString("title");
        final String string3 = bundle.getString("summary");
        SLog.v("openSDK_LOG.QQShare", "shareToMobileQQ -- imageUrl: " + string);
        if (TextUtils.isEmpty(string)) {
            if (bundle.getInt("req_type", 1) == 5) {
                c(activity, bundle, iUiListener);
            } else {
                d(activity, bundle, iUiListener);
            }
        } else if (!m.h(string)) {
            bundle.putString("imageUrl", null);
            if (m.f(activity, "4.3.0")) {
                SLog.d("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is < 4.3.0 ");
                d(activity, bundle, iUiListener);
            } else {
                SLog.d("openSDK_LOG.QQShare", "shareToMobileQQ -- QQ Version is > 4.3.0:isAppSpecificDir=" + m.m(string) + ",hasSDPermission:" + m.c());
                a.a(activity, string, new d() { // from class: com.tencent.connect.share.QQShare.2
                    @Override // com.tencent.open.utils.d
                    public void a(int i3, String str) {
                        if (i3 == 0) {
                            bundle.putString("imageLocalUrl", str);
                        } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
                            IUiListener iUiListener2 = iUiListener;
                            if (iUiListener2 != null) {
                                l0.A(-6, Constants.MSG_SHARE_GETIMG_ERROR, null, iUiListener2);
                                SLog.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                            }
                            e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, ((BaseApi) QQShare.this).f11836c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                            return;
                        }
                        QQShare.this.d(activity, bundle, iUiListener);
                    }

                    @Override // com.tencent.open.utils.d
                    public void a(int i3, ArrayList<String> arrayList) {
                        if (i3 == 0) {
                            bundle.putStringArrayList("imageLocalUrlArray", arrayList);
                        } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
                            IUiListener iUiListener2 = iUiListener;
                            if (iUiListener2 != null) {
                                l0.A(-6, Constants.MSG_SHARE_GETIMG_ERROR, null, iUiListener2);
                                SLog.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                            }
                            e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, ((BaseApi) QQShare.this).f11836c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                            return;
                        }
                        QQShare.this.d(activity, bundle, iUiListener);
                    }
                });
            }
        } else if (m.f(activity, "4.3.0")) {
            new c(activity).a(string, new d() { // from class: com.tencent.connect.share.QQShare.1
                @Override // com.tencent.open.utils.d
                public void a(int i3, ArrayList<String> arrayList) {
                }

                @Override // com.tencent.open.utils.d
                public void a(int i3, String str) {
                    if (i3 == 0) {
                        bundle.putString("imageLocalUrl", str);
                    } else if (TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
                        IUiListener iUiListener2 = iUiListener;
                        if (iUiListener2 != null) {
                            l0.A(-6, Constants.MSG_SHARE_GETIMG_ERROR, null, iUiListener2);
                            SLog.e("openSDK_LOG.QQShare", "shareToMobileQQ -- error: 获取分享图片失败!");
                        }
                        e.a().a(1, "SHARE_CHECK_SDK", Constants.DEFAULT_UIN, ((BaseApi) QQShare.this).f11836c.getAppId(), String.valueOf(0), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, Constants.MSG_SHARE_GETIMG_ERROR);
                        return;
                    }
                    QQShare.this.d(activity, bundle, iUiListener);
                }
            });
        } else {
            d(activity, bundle, iUiListener);
        }
        SLog.i("openSDK_LOG.QQShare", "shareToMobileQQ() -- end");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00bc, code lost:
    
        if (r2 != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(android.app.Activity r9, android.os.Bundle r10, com.tencent.tauth.IUiListener r11) {
        /*
            r8 = this;
            java.lang.String r0 = "imageLocalUrl"
            java.lang.String r0 = r10.getString(r0)
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            long r1 = r1.length()
            r3 = 5242880(0x500000, double:2.590327E-317)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 0
            java.lang.String r3 = "openSDK_LOG.QQShare"
            if (r1 < 0) goto L28
            if (r11 == 0) goto L22
            r9 = -16
            java.lang.String r10 = "图片太大，请压缩到5M内再分享!"
            com.google.android.gms.internal.mlkit_vision_barcode.l0.A(r9, r10, r2, r11)
        L22:
            java.lang.String r9 = "doShareImageToQQ -- error: 图片太大，请压缩到5M内再分享!"
            com.tencent.open.log.SLog.e(r3, r9)
            return
        L28:
            java.lang.String r1 = "Images"
            java.io.File r1 = com.tencent.open.utils.g.a(r1)
            if (r1 == 0) goto L4b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r1 = r1.getAbsolutePath()
            r2.append(r1)
            java.lang.String r1 = java.io.File.separator
            r2.append(r1)
            java.lang.String r1 = com.tencent.connect.common.Constants.QQ_SHARE_TEMP_DIR
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            goto L50
        L4b:
            java.lang.String r1 = "doShareImageToQQ() getExternalFilesDir return null"
            com.tencent.open.log.SLog.i(r3, r1)
        L50:
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            java.lang.String r0 = r1.getAbsolutePath()
            java.lang.String r1 = r1.getName()
            boolean r4 = com.tencent.open.utils.m.m(r0)
            boolean r5 = com.tencent.open.utils.m.c()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "doShareImageToQQ() check file: isAppSpecificDir="
            r6.<init>(r7)
            r6.append(r4)
            java.lang.String r7 = ",hasSDPermission="
            r6.append(r7)
            r6.append(r5)
            java.lang.String r5 = ",fileDir="
            r6.append(r5)
            r6.append(r0)
            java.lang.String r5 = r6.toString()
            com.tencent.open.log.SLog.i(r3, r5)
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 2
            r5.<init>(r6)
            if (r4 == 0) goto L8f
            goto Lbf
        L8f:
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto Lbf
            java.lang.StringBuilder r2 = com.google.android.gms.internal.mlkit_vision_barcode.l0.t(r2)
            java.lang.String r4 = java.io.File.separator
            java.lang.String r1 = r5.a.f(r2, r4, r1)
            boolean r2 = com.tencent.open.utils.m.a(r9, r0, r1)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "doShareImageToQQ() sd permission not denied. copy to app specific:"
            r4.<init>(r6)
            r4.append(r1)
            java.lang.String r6 = ",isSuccess="
            r4.append(r6)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            com.tencent.open.log.SLog.i(r3, r4)
            if (r2 == 0) goto Lbf
            goto Lc0
        Lbf:
            r1 = r0
        Lc0:
            r5.add(r0)
            r5.add(r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "doShareImageToQQ() destFilePaths=["
            r0.<init>(r1)
            r1 = 0
            java.lang.Object r1 = r5.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            r0.append(r1)
            java.lang.String r1 = ","
            r0.append(r1)
            r1 = 1
            java.lang.Object r1 = r5.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            r0.append(r1)
            java.lang.String r1 = "]"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.tencent.open.log.SLog.i(r3, r0)
            java.lang.String r0 = "imageLocalUrlArray"
            r10.putStringArrayList(r0, r5)
            r8.d(r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QQShare.c(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }
}
