package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements h2.b {
    @Override // h2.b
    public final Object create(Context context) {
        Object obj;
        q qVar = new q(new a8.c(context, 1));
        qVar.f2029a = 1;
        if (k.f2036j == null) {
            synchronized (k.f2035i) {
                try {
                    if (k.f2036j == null) {
                        k.f2036j = new k(qVar);
                    }
                } finally {
                }
            }
        }
        h2.a c9 = h2.a.c(context);
        c9.getClass();
        synchronized (h2.a.e) {
            try {
                obj = c9.f14257a.get(ProcessLifecycleInitializer.class);
                if (obj == null) {
                    obj = c9.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } finally {
            }
        }
        final androidx.lifecycle.n lifecycle = ((androidx.lifecycle.s) obj).getLifecycle();
        lifecycle.a(new androidx.lifecycle.f(this) { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.f
            public final void onResume(androidx.lifecycle.s sVar) {
                (Build.VERSION.SDK_INT >= 28 ? b.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new m(0), 500L);
                lifecycle.b(this);
            }
        });
        return Boolean.TRUE;
    }

    @Override // h2.b
    public final List dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
