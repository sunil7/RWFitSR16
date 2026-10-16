package androidx.appcompat.app;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class k implements e2.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f515a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f516b;

    public k(e2.d registry) {
        kotlin.jvm.internal.e.f(registry, "registry");
        this.f516b = new LinkedHashSet();
        registry.c("androidx.savedstate.Restarter", this);
    }

    @Override // e2.c
    public final Bundle a() {
        switch (this.f515a) {
            case 0:
                Bundle bundle = new Bundle();
                ((AppCompatActivity) this.f516b).E0().getClass();
                return bundle;
            default:
                Bundle bundle2 = new Bundle();
                bundle2.putStringArrayList("classes_to_restore", new ArrayList<>((LinkedHashSet) this.f516b));
                return bundle2;
        }
    }

    public k(AppCompatActivity appCompatActivity) {
        this.f516b = appCompatActivity;
    }
}
