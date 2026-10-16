package com.bingoogolapple.qrcode.zxing;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import com.bingoogolapple.qrcode.core.BarcodeType;
import com.bingoogolapple.qrcode.core.QRCodeView;
import com.google.zxing.c;
import t3.e;
import u3.a;

/* loaded from: classes.dex */
public class ZXingView extends QRCodeView {

    /* renamed from: p, reason: collision with root package name */
    public c f6903p;

    public ZXingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.bingoogolapple.qrcode.core.QRCodeView
    public final e d(Bitmap bitmap) {
        return new e(a.a(bitmap));
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0133, code lost:
    
        if (r11 == false) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009a  */
    @Override // com.bingoogolapple.qrcode.core.QRCodeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final t3.e e(int r19, int r20, byte[] r21) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bingoogolapple.qrcode.zxing.ZXingView.e(int, int, byte[]):t3.e");
    }

    @Override // com.bingoogolapple.qrcode.core.QRCodeView
    public final void f() {
        c cVar = new c();
        this.f6903p = cVar;
        BarcodeType barcodeType = this.f6868j;
        if (barcodeType == BarcodeType.ONE_DIMENSION) {
            cVar.d(a.f18876b);
            return;
        }
        if (barcodeType == BarcodeType.TWO_DIMENSION) {
            cVar.d(a.f18877c);
            return;
        }
        if (barcodeType == BarcodeType.ONLY_QR_CODE) {
            cVar.d(a.f18878d);
            return;
        }
        if (barcodeType == BarcodeType.ONLY_CODE_128) {
            cVar.d(a.e);
            return;
        }
        if (barcodeType == BarcodeType.ONLY_EAN_13) {
            cVar.d(a.f18879f);
            return;
        }
        if (barcodeType == BarcodeType.HIGH_FREQUENCY) {
            cVar.d(a.f18880g);
        } else if (barcodeType == BarcodeType.CUSTOM) {
            cVar.d(null);
        } else {
            cVar.d(a.f18875a);
        }
    }

    public ZXingView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
