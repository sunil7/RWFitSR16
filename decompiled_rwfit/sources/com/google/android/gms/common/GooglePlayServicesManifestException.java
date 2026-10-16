package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;
import n9.c;

@KeepName
/* loaded from: classes.dex */
public class GooglePlayServicesManifestException extends IllegalStateException {
    private final int zza;

    public GooglePlayServicesManifestException(int i3, String str) {
        super(str);
        this.zza = i3;
    }

    public int getActualVersion() {
        return this.zza;
    }

    public int getExpectedVersion() {
        return c.f16439a;
    }
}
