package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class b1 implements h1.c {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2148a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2149b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2150c;

    public b1() {
        this.f2148a = new ArrayList();
        this.f2149b = new HashMap();
    }

    public void a(Fragment fragment) {
        if (((ArrayList) this.f2148a).contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (((ArrayList) this.f2148a)) {
            ((ArrayList) this.f2148a).add(fragment);
        }
        fragment.mAdded = true;
    }

    public Fragment b(String str) {
        a1 a1Var = (a1) ((HashMap) this.f2149b).get(str);
        if (a1Var != null) {
            return a1Var.f2145c;
        }
        return null;
    }

    public Fragment c(String str) {
        Fragment findFragmentByWho;
        for (a1 a1Var : ((HashMap) this.f2149b).values()) {
            if (a1Var != null && (findFragmentByWho = a1Var.f2145c.findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public ArrayList d() {
        ArrayList arrayList = new ArrayList();
        for (a1 a1Var : ((HashMap) this.f2149b).values()) {
            if (a1Var != null) {
                arrayList.add(a1Var);
            }
        }
        return arrayList;
    }

    public List e() {
        ArrayList arrayList;
        if (((ArrayList) this.f2148a).isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (((ArrayList) this.f2148a)) {
            arrayList = new ArrayList((ArrayList) this.f2148a);
        }
        return arrayList;
    }

    public void f(a1 a1Var) {
        Fragment fragment = a1Var.f2145c;
        String str = fragment.mWho;
        HashMap hashMap = (HashMap) this.f2149b;
        if (hashMap.get(str) != null) {
            return;
        }
        hashMap.put(fragment.mWho, a1Var);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            if (fragment.mRetainInstance) {
                ((v0) this.f2150c).b(fragment);
            } else {
                ((v0) this.f2150c).c(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        if (t0.B(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    public void g(a1 a1Var) {
        Fragment fragment = a1Var.f2145c;
        if (fragment.mRetainInstance) {
            ((v0) this.f2150c).c(fragment);
        }
        if (((a1) ((HashMap) this.f2149b).put(fragment.mWho, null)) != null && t0.B(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
    }

    @Override // h1.c
    public void onCancel() {
        View view = (View) this.f2148a;
        view.clearAnimation();
        ((ViewGroup) this.f2149b).endViewTransition(view);
        ((i) this.f2150c).a();
    }

    public b1(View view, ViewGroup viewGroup, i iVar) {
        this.f2148a = view;
        this.f2149b = viewGroup;
        this.f2150c = iVar;
    }
}
