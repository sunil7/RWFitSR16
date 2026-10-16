package h1;

import android.os.Bundle;
import android.os.IBinder;

/* loaded from: classes.dex */
public abstract class a {
    public static final void a(Bundle bundle, String key, IBinder iBinder) {
        kotlin.jvm.internal.e.f(bundle, "bundle");
        kotlin.jvm.internal.e.f(key, "key");
        bundle.putBinder(key, iBinder);
    }
}
