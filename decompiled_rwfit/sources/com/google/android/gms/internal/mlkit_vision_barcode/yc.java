package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Hashtable;

/* loaded from: classes.dex */
public abstract class yc {
    public static sc.b a(String str, BarcodeFormat barcodeFormat, int i3, int i10, Hashtable hashtable) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        }
        if (i3 < 0 || i10 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i3 + 'x' + i10);
        }
        ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
        EncodeHintType encodeHintType = EncodeHintType.ERROR_CORRECTION;
        if (hashtable.containsKey(encodeHintType)) {
            errorCorrectionLevel = ErrorCorrectionLevel.valueOf(hashtable.get(encodeHintType).toString());
        }
        EncodeHintType encodeHintType2 = EncodeHintType.MARGIN;
        int parseInt = hashtable.containsKey(encodeHintType2) ? Integer.parseInt(hashtable.get(encodeHintType2).toString()) : 4;
        i6.a aVar = (i6.a) com.google.zxing.qrcode.encoder.a.b(str, errorCorrectionLevel, hashtable).f13519f;
        if (aVar == null) {
            throw new IllegalStateException();
        }
        int i11 = parseInt * 2;
        int i12 = aVar.f14359c;
        int i13 = i12 + i11;
        int i14 = aVar.f14360d;
        int i15 = i11 + i14;
        int max = Math.max(i3, i13);
        int max2 = Math.max(i10, i15);
        int min = Math.min(max / i13, max2 / i15);
        int i16 = (max - (i12 * min)) / 2;
        int i17 = (max2 - (i14 * min)) / 2;
        sc.b bVar = new sc.b(max, max2);
        int i18 = 0;
        while (i18 < i14) {
            int i19 = 0;
            int i20 = i16;
            while (i19 < i12) {
                if (aVar.a(i19, i18) == 1) {
                    bVar.i(i20, i17, min, min);
                }
                i19++;
                i20 += min;
            }
            i18++;
            i17 += min;
        }
        return bVar;
    }
}
