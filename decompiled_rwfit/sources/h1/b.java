package h1;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;

/* loaded from: classes.dex */
public abstract class b {
    public static final void a(Bundle bundle, String key, Size size) {
        kotlin.jvm.internal.e.f(bundle, "bundle");
        kotlin.jvm.internal.e.f(key, "key");
        bundle.putSize(key, size);
    }

    public static final void b(Bundle bundle, String key, SizeF sizeF) {
        kotlin.jvm.internal.e.f(bundle, "bundle");
        kotlin.jvm.internal.e.f(key, "key");
        bundle.putSizeF(key, sizeF);
    }
}
