package com.example.test.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.example.test.XXApplication;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.LazyThreadSafetyMode;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f8733a = kotlin.a.a(LazyThreadSafetyMode.NONE, new oh.a() { // from class: com.example.test.utils.FileUtils$Companion$fileUtils$2
        @Override // oh.a
        public final l invoke() {
            return new l();
        }
    });

    public static void a(XXApplication xXApplication) {
        File file = new File(android.support.v4.media.session.e.l(xXApplication.getFilesDir().getAbsolutePath(), "/image/"));
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public final String b(Context context, Bitmap bitmap, String fileName) {
        kotlin.jvm.internal.e.f(context, "context");
        kotlin.jvm.internal.e.f(fileName, "fileName");
        File file = new File(r5.a.c(context.getFilesDir().getAbsolutePath(), "/image/", fileName));
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        try {
            fileOutputStream.flush();
            fileOutputStream.close();
            String absolutePath = file.getAbsolutePath();
            kotlin.jvm.internal.e.c(absolutePath);
            return absolutePath;
        } catch (IOException e) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "FileUtils", com.google.android.gms.internal.mlkit_vision_barcode.l0.p("保存图片失败：", fileName, " ", e.getMessage()));
            return "";
        }
    }
}
