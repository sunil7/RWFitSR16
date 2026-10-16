package com.tencent.open.web.security;

import com.tencent.open.b;
import com.tencent.open.log.SLog;

/* loaded from: classes2.dex */
public class SecureJsInterface extends b.C0017b {
    public static boolean isPWDEdit = false;

    /* renamed from: a, reason: collision with root package name */
    private String f12127a;

    public void clearAllEdit() {
        SLog.i("openSDK_LOG.SecureJsInterface", "-->clear all edit.");
        try {
            JniInterface.clearAllPWD();
        } catch (Exception e) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->clear all edit exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void curPosFromJS(String str) {
        int i3;
        SLog.d("openSDK_LOG.SecureJsInterface", "-->curPosFromJS: " + str);
        try {
            i3 = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->curPosFromJS number format exception.", e);
            i3 = -1;
        }
        if (i3 < 0) {
            throw new RuntimeException("position is illegal.");
        }
        boolean z5 = a.f12129b;
        if (z5) {
            if (JniInterface.BackSpaceChar(z5, i3)) {
                a.f12129b = false;
            }
        } else {
            String str2 = a.f12128a;
            this.f12127a = str2;
            JniInterface.insetTextToArray(i3, str2, str2.length());
            SLog.v("openSDK_LOG.SecureJsInterface", "curPosFromJS mKey: " + this.f12127a);
        }
    }

    @Override // com.tencent.open.b.C0017b
    public boolean customCallback() {
        return true;
    }

    public String getMD5FromNative() {
        SLog.i("openSDK_LOG.SecureJsInterface", "-->get md5 form native");
        try {
            String pWDKeyToMD5 = JniInterface.getPWDKeyToMD5(null);
            SLog.v("openSDK_LOG.SecureJsInterface", "-->getMD5FromNative, MD5= " + pWDKeyToMD5);
            return pWDKeyToMD5;
        } catch (Exception e) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->get md5 form native exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void isPasswordEdit(String str) {
        int i3;
        SLog.i("openSDK_LOG.SecureJsInterface", "-->is pswd edit, flag: " + str);
        try {
            i3 = Integer.parseInt(str);
        } catch (Exception e) {
            SLog.e("openSDK_LOG.SecureJsInterface", "-->is pswd edit exception: " + e.getMessage());
            i3 = -1;
        }
        if (i3 != 0 && i3 != 1) {
            throw new RuntimeException("is pswd edit flag is illegal.");
        }
        if (i3 == 0) {
            isPWDEdit = false;
        } else if (i3 == 1) {
            isPWDEdit = true;
        }
    }
}
