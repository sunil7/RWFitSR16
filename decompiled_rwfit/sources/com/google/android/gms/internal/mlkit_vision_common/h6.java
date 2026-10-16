package com.google.android.gms.internal.mlkit_vision_common;

import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class h6 {
    public static int a(a4.g gVar, InputStream inputStream, ArrayList arrayList) {
        if (inputStream != null) {
            if (!inputStream.markSupported()) {
                inputStream = new com.bumptech.glide.load.resource.bitmap.a(inputStream, gVar);
            }
            inputStream.mark(Const.MAX_SIZE_WRAPDATA);
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                try {
                    int b3 = ((x3.b) arrayList.get(i3)).b(inputStream, gVar);
                    if (b3 != -1) {
                        return b3;
                    }
                } finally {
                    inputStream.reset();
                }
            }
        }
        return -1;
    }

    public static ImageHeaderParser$ImageType b(a4.g gVar, InputStream inputStream, ArrayList arrayList) {
        if (inputStream == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new com.bumptech.glide.load.resource.bitmap.a(inputStream, gVar);
        }
        inputStream.mark(Const.MAX_SIZE_WRAPDATA);
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            try {
                ImageHeaderParser$ImageType c9 = ((x3.b) arrayList.get(i3)).c(inputStream);
                inputStream.reset();
                if (c9 != ImageHeaderParser$ImageType.UNKNOWN) {
                    return c9;
                }
            } catch (Throwable th2) {
                inputStream.reset();
                throw th2;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }
}
