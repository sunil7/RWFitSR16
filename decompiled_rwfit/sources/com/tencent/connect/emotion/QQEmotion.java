package com.tencent.connect.emotion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.tencent.connect.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class QQEmotion extends BaseApi {

    /* renamed from: a, reason: collision with root package name */
    private IUiListener f11845a;

    public QQEmotion(QQToken qQToken) {
        super(qQToken);
    }

    private boolean a(Context context, ArrayList<Uri> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        if (arrayList.size() > 9) {
            SLog.i("QQEMOTION", "isLegality -->illegal, file count > 9, count = " + arrayList.size());
            return false;
        }
        long j4 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            long a3 = m.a(context, arrayList.get(i3));
            if (a3 > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                SLog.i("QQEMOTION", "isLegality -->illegal, fileSize: " + a3);
                return false;
            }
            j4 += a3;
        }
        if (j4 > 3145728) {
            SLog.i("QQEMOTION", "isLegality -->illegal, totalSize: " + j4);
            return false;
        }
        SLog.i("QQEMOTION", "isLegality -->legal, totalSize: " + j4);
        return true;
    }

    public void setEmotions(Activity activity, ArrayList<Uri> arrayList, IUiListener iUiListener) {
        if (a.a("QQEmotion", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f11845a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f11845a = iUiListener;
        if (!k.b(activity)) {
            Toast.makeText(activity.getApplicationContext(), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            return;
        }
        if (k.c(activity, "8.0.0") < 0) {
            Toast.makeText(activity.getApplicationContext(), "当前手机QQ版本过低，不支持设置表情功能。", 1).show();
            return;
        }
        if (!a(activity.getApplicationContext(), arrayList)) {
            Toast.makeText(activity.getApplicationContext(), "图片不符合要求，不支持设置表情功能。", 1).show();
            return;
        }
        String a3 = m.a(activity);
        StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_face_collection?");
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(a3)) {
            if (a3.length() > 20) {
                a3 = a3.substring(0, 20) + "...";
            }
            sb2.append(a3);
            l0.C(a3, 2, new StringBuilder("&app_name="), stringBuffer);
        }
        String appId = this.f11836c.getAppId();
        String openId = this.f11836c.getOpenId();
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
            sb2.append(appId);
        }
        if (!TextUtils.isEmpty(openId)) {
            sb2.append(openId);
            l0.C(openId, 2, new StringBuilder("&open_id="), stringBuffer);
        }
        l0.C(Constants.SDK_VERSION, 2, new StringBuilder("&sdk_version="), stringBuffer);
        sb2.append(Constants.SDK_VERSION);
        String a10 = a(activity, arrayList);
        if (TextUtils.isEmpty(a10)) {
            l0.A(-6, Constants.MSG_UNKNOWN_ERROR, "picPathList is null", iUiListener);
            return;
        }
        sb2.append(a10);
        stringBuffer.append("&set_uri_list=" + Base64.encodeToString(m.j(a10), 2));
        stringBuffer.append("&ppsts=");
        stringBuffer.append(k.a(activity, sb2.toString()));
        SLog.v("QQEMOTION", "-->set avatar, url: " + stringBuffer.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.setPackage("com.tencent.mobileqq");
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        if (a(intent)) {
            UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_EDIT_EMOTION, iUiListener);
            a(activity, Constants.REQUEST_EDIT_EMOTION, intent, false);
        }
    }

    private String a(Activity activity, ArrayList<Uri> arrayList) {
        StringBuilder sb2 = new StringBuilder();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Uri uri = arrayList.get(i3);
            i3++;
            Uri a3 = m.a(activity, this.f11836c.getAppId(), m.b(activity, uri));
            if (a3 == null) {
                SLog.e("QQEmotion", "getFilePathListJson: grantedUri = null");
            } else {
                sb2.append(a3);
                sb2.append(Const.STR_MART_SEMICOLON);
            }
        }
        String sb3 = sb2.toString();
        SLog.i("QQEmotion", "-->getFilePathListJson listStr : " + sb3);
        return sb3;
    }
}
