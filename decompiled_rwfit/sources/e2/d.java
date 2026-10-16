package e2;

import android.os.Bundle;
import androidx.appcompat.app.k;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public boolean f12438b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f12439c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12440d;
    public k e;

    /* renamed from: a, reason: collision with root package name */
    public final j.f f12437a = new j.f();

    /* renamed from: f, reason: collision with root package name */
    public boolean f12441f = true;

    public final Bundle a(String str) {
        if (!this.f12440d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f12439c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        Bundle bundle3 = this.f12439c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f12439c;
        if (bundle4 != null && !bundle4.isEmpty()) {
            return bundle2;
        }
        this.f12439c = null;
        return bundle2;
    }

    public final c b() {
        String str;
        c cVar;
        Iterator it = this.f12437a.iterator();
        do {
            j.b bVar = (j.b) it;
            if (!bVar.hasNext()) {
                return null;
            }
            Map.Entry components = (Map.Entry) bVar.next();
            kotlin.jvm.internal.e.e(components, "components");
            str = (String) components.getKey();
            cVar = (c) components.getValue();
        } while (!kotlin.jvm.internal.e.a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return cVar;
    }

    public final void c(String str, c provider) {
        kotlin.jvm.internal.e.f(provider, "provider");
        if (((c) this.f12437a.c(str, provider)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void d() {
        if (!this.f12441f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        k kVar = this.e;
        if (kVar == null) {
            kVar = new k(this);
        }
        this.e = kVar;
        try {
            androidx.lifecycle.k.class.getDeclaredConstructor(null);
            k kVar2 = this.e;
            if (kVar2 != null) {
                ((LinkedHashSet) kVar2.f516b).add(androidx.lifecycle.k.class.getName());
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + androidx.lifecycle.k.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }
}
