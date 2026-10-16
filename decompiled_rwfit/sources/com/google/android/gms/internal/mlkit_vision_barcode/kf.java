package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public abstract class kf {
    public static void a(Status status, Object obj, ia.g gVar) {
        if (status.l()) {
            gVar.f14382a.j(obj);
        } else {
            gVar.b(status.k() ? new ResolvableApiException(status) : new ApiException(status));
        }
    }
}
