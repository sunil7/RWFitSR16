package com.tencent.open.web.security;

import android.content.Context;
import com.tencent.connect.auth.AuthAgent;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import java.io.File;

/* loaded from: classes2.dex */
public class JniInterface {
    public static boolean isJniOk = false;

    public static native boolean BackSpaceChar(boolean z5, int i3);

    public static native boolean clearAllPWD();

    public static native String d1(String str);

    public static native String d2(String str);

    public static native String getPWDKeyToMD5(String str);

    public static native boolean insetTextToArray(int i3, String str, int i10);

    public static void loadSo() {
        if (isJniOk) {
            return;
        }
        try {
            Context a3 = g.a();
            if (a3 == null) {
                SLog.i("openSDK_LOG.JniInterface", "-->load lib fail, because context is null:" + AuthAgent.SECURE_LIB_NAME);
                return;
            }
            if (!new File(a3.getFilesDir().toString() + "/" + AuthAgent.SECURE_LIB_NAME).exists()) {
                SLog.i("openSDK_LOG.JniInterface", "-->fail, because so is not exists:" + AuthAgent.SECURE_LIB_NAME);
                return;
            }
            System.load(a3.getFilesDir().toString() + "/" + AuthAgent.SECURE_LIB_NAME);
            isJniOk = true;
            StringBuilder sb2 = new StringBuilder("-->load lib success:");
            sb2.append(AuthAgent.SECURE_LIB_NAME);
            SLog.i("openSDK_LOG.JniInterface", sb2.toString());
        } catch (Throwable th2) {
            SLog.e("openSDK_LOG.JniInterface", "-->load lib error:" + AuthAgent.SECURE_LIB_NAME, th2);
        }
    }
}
