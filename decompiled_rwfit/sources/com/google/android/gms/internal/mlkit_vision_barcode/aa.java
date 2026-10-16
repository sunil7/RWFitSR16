package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.content.Intent;
import androidx.core.content.FileProvider;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.example.test.R$string;
import java.io.File;

/* loaded from: classes.dex */
public abstract class aa {
    public static void a(Context context, String str) {
        kotlin.jvm.internal.e.f(context, "context");
        Intent intent = new Intent("android.intent.action.SEND");
        File file = new File(str);
        intent.setType("image/*");
        if (!file.exists()) {
            file.mkdir();
        }
        intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(context, context.getApplicationInfo().packageName + ".provider", file));
        intent.putExtra("android.intent.extra.SUBJECT", context.getResources().getString(R$string.app_name));
        intent.putExtra("android.intent.extra.TITLE", context.getResources().getString(R$string.app_name));
        intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
        context.startActivity(Intent.createChooser(intent, context.getResources().getString(R$string.app_name)));
    }
}
