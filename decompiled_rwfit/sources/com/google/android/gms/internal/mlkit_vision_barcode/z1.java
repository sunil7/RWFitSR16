package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.math.BigDecimal;

/* loaded from: classes.dex */
public abstract class z1 {
    public static boolean a(File file) {
        if (file != null && file.isDirectory()) {
            for (String str : file.list()) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static long b(File file) {
        long j4 = 0;
        try {
            File[] listFiles = file.listFiles();
            for (int i3 = 0; i3 < listFiles.length; i3++) {
                j4 += listFiles[i3].isDirectory() ? b(listFiles[i3]) : listFiles[i3].length();
            }
            return j4;
        } catch (Exception e) {
            e.printStackTrace();
            return j4;
        }
    }

    public static String c(Context context) {
        long b3 = b(context.getCacheDir());
        if (Environment.getExternalStorageState().equals("mounted")) {
            b3 += b(context.getExternalCacheDir());
        }
        double d5 = b3;
        if (d5 == 0.0d) {
            return "";
        }
        double d8 = d5 / 1024.0d;
        if (d8 < 1.0d) {
            return "0K";
        }
        double d10 = d8 / 1024.0d;
        if (d10 < 1.0d) {
            return new BigDecimal(Double.toString(d8)).setScale(2, 4).toPlainString() + "K";
        }
        double d11 = d10 / 1024.0d;
        if (d11 < 1.0d) {
            return new BigDecimal(Double.toString(d10)).setScale(2, 4).toPlainString() + "M";
        }
        double d12 = d11 / 1024.0d;
        if (d12 < 1.0d) {
            return new BigDecimal(Double.toString(d11)).setScale(2, 4).toPlainString() + "GB";
        }
        return new BigDecimal(d12).setScale(2, 4).toPlainString() + "TB";
    }
}
