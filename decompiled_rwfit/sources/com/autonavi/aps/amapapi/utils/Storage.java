package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.support.v4.media.session.e;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import r5.a;

/* loaded from: classes.dex */
public class Storage {

    /* renamed from: a, reason: collision with root package name */
    private static Storage f6835a;

    /* renamed from: b, reason: collision with root package name */
    static Byte[] f6836b = new Byte[0];

    private Storage() {
    }

    public static Storage getInstance() {
        synchronized (f6836b) {
            try {
                if (f6835a == null) {
                    f6835a = new Storage();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f6835a;
    }

    public void writeLog(String str) {
    }

    public void writeLog(String str, String str2) {
        if (Utils.extMemAvl()) {
            StringBuilder sb2 = new StringBuilder();
            if (str.contains(Const.STR_KML)) {
                StringBuilder t8 = l0.t(Const.STR_KML + File.separator);
                t8.append(Utils.formatUTC(0L, "yyyyMMdd"));
                t8.append(".");
                str = e.l(t8.toString(), Const.STR_KML);
            }
            sb2.append(DebugUtils.getWPath());
            sb2.append(str);
            String sb3 = sb2.toString();
            File file = new File(sb3);
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                try {
                    sb2.delete(0, sb2.length());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                if (file.exists() || file.createNewFile()) {
                    if (!str.contains(Const.STR_KML)) {
                        sb2.append(Utils.formatUTC(0L, null));
                        sb2.append(Const.STR_MART_WELL);
                        sb2.append(CoreUtil.strAppname);
                        sb2.append(Const.STR_MART_WELL);
                    }
                    sb2.append(str2);
                    sb2.append("\r\n");
                    String sb4 = sb2.toString();
                    FileOutputStream fileOutputStream = new FileOutputStream(sb3, true);
                    DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
                    dataOutputStream.write(sb4.getBytes("UTF-8"));
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    sb2.delete(0, sb2.length());
                }
            }
        }
    }

    public void writeLog(Context context, String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(context.getExternalFilesDir("debug").getAbsolutePath());
        String f2 = a.f(sb2, File.separator, str);
        File file = new File(f2);
        File parentFile = file.getParentFile();
        if (parentFile.exists() || parentFile.mkdirs()) {
            try {
                sb2.delete(0, sb2.length());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            if (file.exists() || file.createNewFile()) {
                if (!str.contains(Const.STR_KML)) {
                    sb2.append(Utils.formatUTC(0L, null));
                    sb2.append(Const.STR_MART_WELL);
                    sb2.append(CoreUtil.strAppname);
                    sb2.append(Const.STR_MART_WELL);
                }
                sb2.append(str2);
                sb2.append("\r\n");
                String sb3 = sb2.toString();
                FileOutputStream fileOutputStream = new FileOutputStream(f2, true);
                DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
                dataOutputStream.write(sb3.getBytes("UTF-8"));
                dataOutputStream.flush();
                dataOutputStream.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                sb2.delete(0, sb2.length());
            }
        }
    }
}
