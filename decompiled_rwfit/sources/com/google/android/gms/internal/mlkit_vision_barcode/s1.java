package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.content.Intent;
import com.example.test.ui.sport.activity.SportCountDownActivity;

/* loaded from: classes.dex */
public abstract class s1 {
    public static void a(Context context, int i3) {
        kotlin.jvm.internal.e.f(context, "context");
        Intent intent = new Intent(context, (Class<?>) SportCountDownActivity.class);
        intent.putExtra("sport_type", i3);
        context.startActivity(intent);
    }
}
