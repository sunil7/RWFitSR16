package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.content.Intent;
import com.example.test.ui.mine.activity.WebContentActivity;

/* loaded from: classes.dex */
public abstract class r1 {
    public static void a(Context context, String str, String url) {
        kotlin.jvm.internal.e.f(url, "url");
        Intent intent = new Intent(context, (Class<?>) WebContentActivity.class);
        intent.putExtra("title", str);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }
}
