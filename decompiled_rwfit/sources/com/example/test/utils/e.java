package com.example.test.utils;

import android.util.Log;
import com.example.test.ui.model.dial.Element;
import com.google.android.gms.internal.mlkit_vision_barcode.le;
import com.jieli.bmp_convert.ConvertResult;
import com.jieli.bmp_convert.OnConvertListener;
import java.io.File;

/* loaded from: classes.dex */
public final class e implements OnConvertListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Element f8723a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ de.i f8724b;

    public e(Element element, de.i iVar) {
        this.f8723a = element;
        this.f8724b = iVar;
    }

    @Override // com.jieli.bmp_convert.OnConvertListener
    public final void onStart(String path) {
        kotlin.jvm.internal.e.f(path, "path");
    }

    @Override // com.jieli.bmp_convert.OnConvertListener
    public final void onStop(boolean z5, String output) {
        kotlin.jvm.internal.e.f(output, "output");
    }

    @Override // com.jieli.bmp_convert.OnConvertListener
    public final void onStop(ConvertResult result, String outFilePath) {
        kotlin.jvm.internal.e.f(result, "result");
        kotlin.jvm.internal.e.f(outFilePath, "outFilePath");
        Log.e("qob", "bitmapConvert result " + result.isConvertSuccess() + " outFilePath " + outFilePath);
        boolean isConvertSuccess = result.isConvertSuccess();
        Element element = this.f8723a;
        if (isConvertSuccess) {
            byte[] a3 = le.a(new File(outFilePath));
            int length = a3.length;
            int i3 = (4 - (length % 4)) % 4;
            Log.e("qob", "bitmapConvert preview currentLength " + length + " paddingSize " + i3);
            if (i3 > 0) {
                int i10 = i3 + length;
                byte[] bArr = new byte[i10];
                System.arraycopy(a3, 0, bArr, 0, length);
                element.setSize(i10);
                element.getDataList().add(new Element.ImageData(bArr));
            } else {
                element.setSize(a3.length);
                element.getDataList().add(new Element.ImageData(a3));
            }
        }
        this.f8724b.m(result.isConvertSuccess(), element);
    }
}
