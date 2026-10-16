package com.google.android.gms.common;

import android.support.v4.media.session.e;
import com.google.android.gms.common.annotation.KeepName;
import n9.c;

@KeepName
/* loaded from: classes.dex */
public final class GooglePlayServicesIncorrectManifestValueException extends GooglePlayServicesManifestException {
    public GooglePlayServicesIncorrectManifestValueException(int i3) {
        super(i3, e.g(c.f16439a, "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ", i3, " but found ", ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />"));
    }
}
