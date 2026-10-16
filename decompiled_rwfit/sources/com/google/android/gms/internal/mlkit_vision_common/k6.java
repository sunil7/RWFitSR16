package com.google.android.gms.internal.mlkit_vision_common;

import android.net.Uri;

/* loaded from: classes.dex */
public abstract class k6 {
    public static boolean a(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }
}
