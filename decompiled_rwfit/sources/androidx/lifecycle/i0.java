package androidx.lifecycle;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import java.util.Map;

/* loaded from: classes.dex */
public final class i0 implements e2.c {

    /* renamed from: a, reason: collision with root package name */
    public final e2.d f2365a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2366b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f2367c;

    /* renamed from: d, reason: collision with root package name */
    public final eh.b f2368d;

    public i0(e2.d savedStateRegistry, final ComponentActivity componentActivity) {
        kotlin.jvm.internal.e.f(savedStateRegistry, "savedStateRegistry");
        this.f2365a = savedStateRegistry;
        this.f2368d = kotlin.a.b(new oh.a() { // from class: androidx.lifecycle.SavedStateHandlesProvider$viewModel$2
            {
                super(0);
            }

            @Override // oh.a
            public final j0 invoke() {
                return l.d(r0.this);
            }
        });
    }

    @Override // e2.c
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f2367c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : ((j0) this.f2368d.getValue()).f2369a.entrySet()) {
            String str = (String) entry.getKey();
            Bundle a3 = ((h0) entry.getValue()).e.a();
            if (!kotlin.jvm.internal.e.a(a3, Bundle.EMPTY)) {
                bundle.putBundle(str, a3);
            }
        }
        this.f2366b = false;
        return bundle;
    }
}
