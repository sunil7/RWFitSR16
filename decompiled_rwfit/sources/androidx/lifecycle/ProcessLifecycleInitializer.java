package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements h2.b {
    @Override // h2.b
    public final Object create(Context context) {
        if (!h2.a.c(context).f14258b.contains(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name='androidx.lifecycle.ProcessLifecycleInitializer' \n    android:value='androidx.startup' /> \nunder InitializationProvider in your AndroidManifest.xml");
        }
        if (!p.f2385a.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new o());
        }
        f0 f0Var = f0.f2349i;
        f0Var.getClass();
        f0Var.e = new Handler();
        f0Var.f2354f.e(Lifecycle$Event.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new e0(f0Var));
        return f0Var;
    }

    @Override // h2.b
    public final List dependencies() {
        return Collections.EMPTY_LIST;
    }
}
