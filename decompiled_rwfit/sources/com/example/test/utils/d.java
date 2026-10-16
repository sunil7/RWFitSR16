package com.example.test.utils;

import android.util.Log;
import com.example.test.ui.model.dial.Element;
import com.google.android.gms.internal.mlkit_vision_barcode.le;
import com.jieli.bmp_convert.ConvertResult;
import com.jieli.bmp_convert.OnConvertListener;
import java.io.File;

/* loaded from: classes.dex */
public final class d implements OnConvertListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Element f8721a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ androidx.camera.core.impl.e f8722b;

    public d(Element element, androidx.camera.core.impl.e eVar) {
        this.f8721a = element;
        this.f8722b = eVar;
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
        boolean isConvertSuccess = result.isConvertSuccess();
        Element element = this.f8721a;
        if (isConvertSuccess) {
            byte[] a3 = le.a(new File(outFilePath));
            int length = a3.length;
            int i3 = (4 - (length % 4)) % 4;
            Log.e("qob", "bitmapConvert bg currentLength " + length + " paddingSize " + i3);
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
        this.f8722b.k(result.isConvertSuccess(), element);
    }
}
