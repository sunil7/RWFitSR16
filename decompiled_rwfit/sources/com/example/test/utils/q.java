package com.example.test.utils;

import android.app.Activity;
import android.content.Context;
import com.dh.imagepick.DevUtil;
import com.dh.imagepick.ImagePickClient;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes.dex */
public abstract class q {
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, z4.c] */
    public static void a(Activity context, oh.l lVar, oh.l errorBack) {
        kotlin.jvm.internal.e.f(context, "context");
        kotlin.jvm.internal.e.f(errorBack, "errorBack");
        com.dh.imagepick.work.c with = ImagePickClient.with(context);
        with.getClass();
        f5.c cVar = new f5.c(with);
        Activity u10 = with.f7198a.u();
        Context applicationContext = u10 != null ? u10.getApplicationContext() : null;
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        kotlin.jvm.internal.e.e(format, "format(...)");
        File cacheDir = applicationContext != null ? applicationContext.getCacheDir() : null;
        kotlin.jvm.internal.e.c(cacheDir);
        File file = new File(r5.a.c(cacheDir.getPath(), "/", format));
        if (!file.exists()) {
            file.mkdirs();
        }
        File createTempFile = File.createTempFile("JPEG_" + format + "_demo", ".jpg", file);
        kotlin.jvm.internal.e.e(createTempFile, "createTempFile(...)");
        DevUtil devUtil = DevUtil.INSTANCE;
        String path = createTempFile.getPath();
        if (path == null) {
            path = "originUri is null";
        }
        devUtil.d("ImagePick", "capture: saveFilePath: ".concat(path));
        cVar.f12667b = createTempFile;
        com.dh.imagepick.work.c.a(cVar.i()).h(new p(errorBack, lVar, 1));
    }
}
