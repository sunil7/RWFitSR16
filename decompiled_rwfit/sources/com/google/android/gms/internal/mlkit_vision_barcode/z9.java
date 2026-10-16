package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Hashtable;

/* loaded from: classes.dex */
public abstract class z9 {
    public static Bitmap a(int i3, int i10, String str, String str2) {
        if (TextUtils.isEmpty(str) || i3 < 0 || i10 < 0) {
            return null;
        }
        try {
            Hashtable hashtable = new Hashtable();
            if (!TextUtils.isEmpty("UTF-8")) {
                hashtable.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            }
            if (!TextUtils.isEmpty(str2)) {
                hashtable.put(EncodeHintType.ERROR_CORRECTION, str2);
            }
            if (!TextUtils.isEmpty("1")) {
                hashtable.put(EncodeHintType.MARGIN, "1");
            }
            sc.b a3 = yc.a(str, BarcodeFormat.QR_CODE, i3, i10, hashtable);
            int[] iArr = new int[i3 * i10];
            for (int i11 = 0; i11 < i10; i11++) {
                for (int i12 = 0; i12 < i3; i12++) {
                    if (a3.b(i12, i11)) {
                        iArr[(i11 * i3) + i12] = -16777216;
                    } else {
                        iArr[(i11 * i3) + i12] = -1;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i10, Bitmap.Config.ARGB_8888);
            kotlin.jvm.internal.e.e(createBitmap, "createBitmap(...)");
            createBitmap.setPixels(iArr, 0, i3, 0, 0, i3, i10);
            return createBitmap;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
