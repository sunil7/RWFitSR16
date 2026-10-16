package androidx.fragment.app;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class v0 extends androidx.lifecycle.m0 {

    /* renamed from: g, reason: collision with root package name */
    public static final l0 f2314g = new l0();

    /* renamed from: d, reason: collision with root package name */
    public final boolean f2318d;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f2315a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f2316b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f2317c = new HashMap();
    public boolean e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2319f = false;

    public v0(boolean z5) {
        this.f2318d = z5;
    }

    public final void b(Fragment fragment) {
        if (this.f2319f) {
            if (t0.B(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
                return;
            }
            return;
        }
        HashMap hashMap = this.f2315a;
        if (hashMap.containsKey(fragment.mWho)) {
            return;
        }
        hashMap.put(fragment.mWho, fragment);
        if (t0.B(2)) {
            Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
        }
    }

    public final void c(Fragment fragment) {
        if (this.f2319f) {
            if (t0.B(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f2315a.remove(fragment.mWho) == null || !t0.B(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && v0.class == obj.getClass()) {
            v0 v0Var = (v0) obj;
            if (this.f2315a.equals(v0Var.f2315a) && this.f2316b.equals(v0Var.f2316b) && this.f2317c.equals(v0Var.f2317c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2317c.hashCode() + ((this.f2316b.hashCode() + (this.f2315a.hashCode() * 31)) * 31);
    }

    @Override // androidx.lifecycle.m0
    public final void onCleared() {
        if (t0.B(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.e = true;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator it = this.f2315a.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator it2 = this.f2316b.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append((String) it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator it3 = this.f2317c.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append((String) it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}
