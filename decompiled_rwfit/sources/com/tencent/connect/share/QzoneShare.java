package com.tencent.connect.share;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;

/* loaded from: classes2.dex */
public class QzoneShare extends BaseApi {
    public static final String SHARE_TO_QQ_APP_NAME = "appName";
    public static final String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final String SHARE_TO_QQ_SITE = "site";
    public static final String SHARE_TO_QQ_SUMMARY = "summary";
    public static final String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final String SHARE_TO_QQ_TITLE = "title";
    public static final String SHARE_TO_QZONE_EXTMAP = "extMap";
    public static final String SHARE_TO_QZONE_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QZONE_TYPE_IMAGE = 5;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
    public static final int SHARE_TO_QZONE_TYPE_MINI_PROGRAM = 7;
    public static final int SHARE_TO_QZONE_TYPE_NO_TYPE = 0;

    /* renamed from: a, reason: collision with root package name */
    private boolean f11862a;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11863d;
    private boolean e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f11864f;
    public String mViaShareQzoneType;

    public QzoneShare(Context context, QQToken qQToken) {
        super(qQToken);
        this.mViaShareQzoneType = "";
        this.f11862a = true;
        this.f11863d = false;
        this.e = false;
        this.f11864f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0152  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(android.app.Activity r28, android.os.Bundle r29, com.tencent.tauth.IUiListener r30) {
        /*
            Method dump skipped, instructions count: 931
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QzoneShare.b(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x036e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void shareToQzone(android.app.Activity r28, android.os.Bundle r29, com.tencent.tauth.IUiListener r30) {
        /*
            Method dump skipped, instructions count: 1031
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.share.QzoneShare.shareToQzone(android.app.Activity, android.os.Bundle, com.tencent.tauth.IUiListener):void");
    }
}
