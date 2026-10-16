package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class je {
    public static void a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        int read = inputStream.read(bArr);
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
    }
}
