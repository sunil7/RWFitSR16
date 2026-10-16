package androidx.fragment.app;

import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$id;
import androidx.lifecycle.Lifecycle$State;
import com.autonavi.aps.amapapi.config.Const;
import com.king.logx.logger.Logger;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class t0 {
    public boolean A;
    public boolean B;
    public boolean C;
    public ArrayList D;
    public ArrayList E;
    public ArrayList F;
    public v0 G;
    public final f H;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2271b;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f2273d;
    public ArrayList e;

    /* renamed from: g, reason: collision with root package name */
    public androidx.activity.o f2275g;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f2279k;

    /* renamed from: l, reason: collision with root package name */
    public final c0 f2280l;

    /* renamed from: m, reason: collision with root package name */
    public final CopyOnWriteArrayList f2281m;

    /* renamed from: n, reason: collision with root package name */
    public int f2282n;

    /* renamed from: o, reason: collision with root package name */
    public g0 f2283o;

    /* renamed from: p, reason: collision with root package name */
    public f0 f2284p;

    /* renamed from: q, reason: collision with root package name */
    public Fragment f2285q;
    public Fragment r;

    /* renamed from: s, reason: collision with root package name */
    public final m0 f2286s;

    /* renamed from: t, reason: collision with root package name */
    public final l0 f2287t;

    /* renamed from: u, reason: collision with root package name */
    public androidx.activity.result.c f2288u;

    /* renamed from: v, reason: collision with root package name */
    public androidx.activity.result.c f2289v;

    /* renamed from: w, reason: collision with root package name */
    public androidx.activity.result.c f2290w;

    /* renamed from: x, reason: collision with root package name */
    public ArrayDeque f2291x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f2292y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f2293z;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2270a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final b1 f2272c = new b1();

    /* renamed from: f, reason: collision with root package name */
    public final i0 f2274f = new i0(this);

    /* renamed from: h, reason: collision with root package name */
    public final k0 f2276h = new k0(this);

    /* renamed from: i, reason: collision with root package name */
    public final AtomicInteger f2277i = new AtomicInteger();

    /* renamed from: j, reason: collision with root package name */
    public final Map f2278j = Collections.synchronizedMap(new HashMap());

    public t0() {
        Collections.synchronizedMap(new HashMap());
        Collections.synchronizedMap(new HashMap());
        this.f2280l = new c0(this);
        this.f2281m = new CopyOnWriteArrayList();
        this.f2282n = -1;
        this.f2286s = new m0(this);
        this.f2287t = new l0();
        this.f2291x = new ArrayDeque();
        this.H = new f(this, 5);
    }

    public static boolean B(int i3) {
        return Log.isLoggable("FragmentManager", i3);
    }

    public static boolean C(Fragment fragment) {
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            return true;
        }
        b1 b1Var = fragment.mChildFragmentManager.f2272c;
        b1Var.getClass();
        ArrayList arrayList = new ArrayList();
        for (a1 a1Var : ((HashMap) b1Var.f2149b).values()) {
            if (a1Var != null) {
                arrayList.add(a1Var.f2145c);
            } else {
                arrayList.add(null);
            }
        }
        int size = arrayList.size();
        boolean z5 = false;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Fragment fragment2 = (Fragment) obj;
            if (fragment2 != null) {
                z5 = C(fragment2);
            }
            if (z5) {
                return true;
            }
        }
        return false;
    }

    public static boolean D(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        t0 t0Var = fragment.mFragmentManager;
        return fragment.equals(t0Var.r) && D(t0Var.f2285q);
    }

    public static void R(Fragment fragment) {
        if (B(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public final void A(Fragment fragment) {
        if (B(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
        Q(fragment);
    }

    public final void E(int i3, boolean z5) {
        HashMap hashMap;
        g0 g0Var;
        if (this.f2283o == null && i3 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z5 || i3 != this.f2282n) {
            this.f2282n = i3;
            b1 b1Var = this.f2272c;
            ArrayList arrayList = (ArrayList) b1Var.f2148a;
            int size = arrayList.size();
            int i10 = 0;
            while (true) {
                hashMap = (HashMap) b1Var.f2149b;
                if (i10 >= size) {
                    break;
                }
                Object obj = arrayList.get(i10);
                i10++;
                a1 a1Var = (a1) hashMap.get(((Fragment) obj).mWho);
                if (a1Var != null) {
                    a1Var.j();
                }
            }
            for (a1 a1Var2 : hashMap.values()) {
                if (a1Var2 != null) {
                    a1Var2.j();
                    Fragment fragment = a1Var2.f2145c;
                    if (fragment.mRemoving && !fragment.isInBackStack()) {
                        b1Var.g(a1Var2);
                    }
                }
            }
            S();
            if (this.f2292y && (g0Var = this.f2283o) != null && this.f2282n == 7) {
                ((b0) g0Var).e.z0();
                this.f2292y = false;
            }
        }
    }

    public final void F() {
        if (this.f2283o == null) {
            return;
        }
        this.f2293z = false;
        this.A = false;
        this.G.f2319f = false;
        for (Fragment fragment : this.f2272c.e()) {
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    public final boolean G() {
        s(false);
        r(true);
        Fragment fragment = this.r;
        if (fragment != null && fragment.getChildFragmentManager().G()) {
            return true;
        }
        boolean H = H(this.D, this.E, -1, 0);
        if (H) {
            this.f2271b = true;
            try {
                J(this.D, this.E);
            } finally {
                d();
            }
        }
        T();
        if (this.C) {
            this.C = false;
            S();
        }
        ((HashMap) this.f2272c.f2149b).values().removeAll(Collections.singleton(null));
        return H;
    }

    public final boolean H(ArrayList arrayList, ArrayList arrayList2, int i3, int i10) {
        int i11;
        a aVar;
        ArrayList arrayList3 = this.f2273d;
        if (arrayList3 == null) {
            return false;
        }
        if (i3 < 0 && (i10 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f2273d.remove(size));
            arrayList2.add(Boolean.TRUE);
            return true;
        }
        if (i3 >= 0) {
            i11 = arrayList3.size() - 1;
            while (i11 >= 0) {
                a aVar2 = (a) this.f2273d.get(i11);
                if (i3 >= 0 && i3 == aVar2.r) {
                    break;
                }
                i11--;
            }
            if (i11 < 0) {
                return false;
            }
            if ((i10 & 1) != 0) {
                do {
                    i11--;
                    if (i11 < 0) {
                        break;
                    }
                    aVar = (a) this.f2273d.get(i11);
                    if (i3 < 0) {
                        break;
                    }
                } while (i3 == aVar.r);
            }
        } else {
            i11 = -1;
        }
        if (i11 == this.f2273d.size() - 1) {
            return false;
        }
        for (int size2 = this.f2273d.size() - 1; size2 > i11; size2--) {
            arrayList.add(this.f2273d.remove(size2));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void I(Fragment fragment) {
        if (B(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean isInBackStack = fragment.isInBackStack();
        if (fragment.mDetached && isInBackStack) {
            return;
        }
        b1 b1Var = this.f2272c;
        synchronized (((ArrayList) b1Var.f2148a)) {
            ((ArrayList) b1Var.f2148a).remove(fragment);
        }
        fragment.mAdded = false;
        if (C(fragment)) {
            this.f2292y = true;
        }
        fragment.mRemoving = true;
        Q(fragment);
    }

    public final void J(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i3 = 0;
        int i10 = 0;
        while (i3 < size) {
            if (!((a) arrayList.get(i3)).f2139o) {
                if (i10 != i3) {
                    u(arrayList, arrayList2, i10, i3);
                }
                i10 = i3 + 1;
                if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                    while (i10 < size && ((Boolean) arrayList2.get(i10)).booleanValue() && !((a) arrayList.get(i10)).f2139o) {
                        i10++;
                    }
                }
                u(arrayList, arrayList2, i3, i10);
                i3 = i10 - 1;
            }
            i3++;
        }
        if (i10 != size) {
            u(arrayList, arrayList2, i10, size);
        }
    }

    public final void K(Parcelable parcelable) {
        int i3;
        c0 c0Var;
        int i10;
        a1 a1Var;
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.f2101a == null) {
            return;
        }
        b1 b1Var = this.f2272c;
        ((HashMap) b1Var.f2149b).clear();
        ArrayList arrayList = fragmentManagerState.f2101a;
        int size = arrayList.size();
        int i11 = 0;
        while (true) {
            i3 = 2;
            c0Var = this.f2280l;
            if (i11 >= size) {
                break;
            }
            Object obj = arrayList.get(i11);
            i11++;
            FragmentState fragmentState = (FragmentState) obj;
            if (fragmentState != null) {
                Fragment fragment = (Fragment) this.G.f2315a.get(fragmentState.f2109b);
                if (fragment != null) {
                    if (B(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
                    }
                    a1Var = new a1(c0Var, b1Var, fragment, fragmentState);
                } else {
                    a1Var = new a1(this.f2280l, this.f2272c, this.f2283o.f2182b.getClassLoader(), y(), fragmentState);
                }
                Fragment fragment2 = a1Var.f2145c;
                fragment2.mFragmentManager = this;
                if (B(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + fragment2.mWho + "): " + fragment2);
                }
                a1Var.k(this.f2283o.f2182b.getClassLoader());
                b1Var.f(a1Var);
                a1Var.e = this.f2282n;
            }
        }
        v0 v0Var = this.G;
        v0Var.getClass();
        ArrayList arrayList2 = new ArrayList(v0Var.f2315a.values());
        int size2 = arrayList2.size();
        int i12 = 0;
        while (i12 < size2) {
            Object obj2 = arrayList2.get(i12);
            i12++;
            Fragment fragment3 = (Fragment) obj2;
            if (!(((HashMap) b1Var.f2149b).get(fragment3.mWho) != null)) {
                if (B(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment3 + " that was not found in the set of active Fragments " + fragmentManagerState.f2101a);
                }
                this.G.c(fragment3);
                fragment3.mFragmentManager = this;
                a1 a1Var2 = new a1(c0Var, b1Var, fragment3);
                a1Var2.e = 1;
                a1Var2.j();
                fragment3.mRemoving = true;
                a1Var2.j();
            }
        }
        ArrayList arrayList3 = fragmentManagerState.f2102b;
        ((ArrayList) b1Var.f2148a).clear();
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            int i13 = 0;
            while (i13 < size3) {
                Object obj3 = arrayList3.get(i13);
                i13++;
                String str = (String) obj3;
                Fragment b3 = b1Var.b(str);
                if (b3 == null) {
                    throw new IllegalStateException(com.google.android.gms.internal.mlkit_vision_barcode.l0.o("No instantiated fragment for (", str, ")"));
                }
                if (B(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + b3);
                }
                b1Var.a(b3);
            }
        }
        Fragment fragment4 = null;
        if (fragmentManagerState.f2103c != null) {
            this.f2273d = new ArrayList(fragmentManagerState.f2103c.length);
            int i14 = 0;
            while (true) {
                BackStackState[] backStackStateArr = fragmentManagerState.f2103c;
                if (i14 >= backStackStateArr.length) {
                    break;
                }
                BackStackState backStackState = backStackStateArr[i14];
                backStackState.getClass();
                a aVar = new a(this);
                int i15 = 0;
                int i16 = 0;
                while (true) {
                    int[] iArr = backStackState.f2075a;
                    if (i15 >= iArr.length) {
                        break;
                    }
                    d1 d1Var = new d1();
                    int i17 = i15 + 1;
                    int i18 = i3;
                    d1Var.f2161a = iArr[i15];
                    if (B(i18)) {
                        Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i16 + " base fragment #" + iArr[i17]);
                    }
                    String str2 = (String) backStackState.f2076b.get(i16);
                    if (str2 != null) {
                        d1Var.f2162b = b1Var.b(str2);
                    } else {
                        d1Var.f2162b = fragment4;
                    }
                    d1Var.f2166g = Lifecycle$State.values()[backStackState.f2077c[i16]];
                    d1Var.f2167h = Lifecycle$State.values()[backStackState.f2078d[i16]];
                    int i19 = iArr[i17];
                    d1Var.f2163c = i19;
                    int i20 = iArr[i15 + 2];
                    d1Var.f2164d = i20;
                    int i21 = i15 + 4;
                    int i22 = iArr[i15 + 3];
                    d1Var.e = i22;
                    i15 += 5;
                    int i23 = iArr[i21];
                    d1Var.f2165f = i23;
                    aVar.f2127b = i19;
                    aVar.f2128c = i20;
                    aVar.f2129d = i22;
                    aVar.e = i23;
                    aVar.b(d1Var);
                    i16++;
                    i3 = i18;
                    fragment4 = null;
                }
                int i24 = i3;
                aVar.f2130f = backStackState.e;
                aVar.f2132h = backStackState.f2079f;
                aVar.r = backStackState.f2080g;
                aVar.f2131g = true;
                aVar.f2133i = backStackState.f2081h;
                aVar.f2134j = backStackState.f2082i;
                aVar.f2135k = backStackState.f2083j;
                aVar.f2136l = backStackState.f2084k;
                aVar.f2137m = backStackState.f2085l;
                aVar.f2138n = backStackState.f2086m;
                aVar.f2139o = backStackState.f2087n;
                aVar.c(1);
                if (B(i24)) {
                    StringBuilder q5 = android.support.v4.media.session.e.q(i14, "restoreAllState: back stack #", " (index ");
                    q5.append(aVar.r);
                    q5.append("): ");
                    q5.append(aVar);
                    Log.v("FragmentManager", q5.toString());
                    PrintWriter printWriter = new PrintWriter(new m1());
                    aVar.f("  ", printWriter, false);
                    printWriter.close();
                }
                this.f2273d.add(aVar);
                i14++;
                i3 = i24;
                fragment4 = null;
            }
            i10 = 0;
        } else {
            i10 = 0;
            this.f2273d = null;
        }
        this.f2277i.set(fragmentManagerState.f2104d);
        String str3 = fragmentManagerState.e;
        if (str3 != null) {
            Fragment b10 = b1Var.b(str3);
            this.r = b10;
            m(b10);
        }
        ArrayList arrayList4 = fragmentManagerState.f2105f;
        if (arrayList4 != null) {
            for (int i25 = i10; i25 < arrayList4.size(); i25++) {
                Bundle bundle = (Bundle) fragmentManagerState.f2106g.get(i25);
                bundle.setClassLoader(this.f2283o.f2182b.getClassLoader());
                this.f2278j.put(arrayList4.get(i25), bundle);
            }
        }
        this.f2291x = new ArrayDeque(fragmentManagerState.f2107h);
    }

    public final Parcelable L() {
        int i3;
        ArrayList arrayList;
        BackStackState[] backStackStateArr;
        int size;
        Iterator it = e().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            l lVar = (l) it.next();
            if (lVar.e) {
                lVar.e = false;
                lVar.d();
            }
        }
        Iterator it2 = e().iterator();
        while (it2.hasNext()) {
            ((l) it2.next()).g();
        }
        s(true);
        this.f2293z = true;
        this.G.f2319f = true;
        b1 b1Var = this.f2272c;
        b1Var.getClass();
        HashMap hashMap = (HashMap) b1Var.f2149b;
        ArrayList arrayList2 = new ArrayList(hashMap.size());
        Iterator it3 = hashMap.values().iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            a1 a1Var = (a1) it3.next();
            if (a1Var != null) {
                Fragment fragment = a1Var.f2145c;
                FragmentState fragmentState = new FragmentState(fragment);
                if (fragment.mState <= -1 || fragmentState.f2119m != null) {
                    fragmentState.f2119m = fragment.mSavedFragmentState;
                } else {
                    Bundle bundle = new Bundle();
                    fragment.performSaveInstanceState(bundle);
                    a1Var.f2143a.j(false);
                    Bundle bundle2 = bundle.isEmpty() ? null : bundle;
                    if (fragment.mView != null) {
                        a1Var.m();
                    }
                    if (fragment.mSavedViewState != null) {
                        if (bundle2 == null) {
                            bundle2 = new Bundle();
                        }
                        bundle2.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
                    }
                    if (fragment.mSavedViewRegistryState != null) {
                        if (bundle2 == null) {
                            bundle2 = new Bundle();
                        }
                        bundle2.putBundle("android:view_registry_state", fragment.mSavedViewRegistryState);
                    }
                    if (!fragment.mUserVisibleHint) {
                        if (bundle2 == null) {
                            bundle2 = new Bundle();
                        }
                        bundle2.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
                    }
                    fragmentState.f2119m = bundle2;
                    if (fragment.mTargetWho != null) {
                        if (bundle2 == null) {
                            fragmentState.f2119m = new Bundle();
                        }
                        fragmentState.f2119m.putString("android:target_state", fragment.mTargetWho);
                        int i10 = fragment.mTargetRequestCode;
                        if (i10 != 0) {
                            fragmentState.f2119m.putInt("android:target_req_state", i10);
                        }
                    }
                }
                arrayList2.add(fragmentState);
                if (B(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.f2119m);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            if (B(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        b1 b1Var2 = this.f2272c;
        synchronized (((ArrayList) b1Var2.f2148a)) {
            try {
                if (((ArrayList) b1Var2.f2148a).isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(((ArrayList) b1Var2.f2148a).size());
                    ArrayList arrayList3 = (ArrayList) b1Var2.f2148a;
                    int size2 = arrayList3.size();
                    int i11 = 0;
                    while (i11 < size2) {
                        Object obj = arrayList3.get(i11);
                        i11++;
                        Fragment fragment2 = (Fragment) obj;
                        arrayList.add(fragment2.mWho);
                        if (B(2)) {
                            Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment2.mWho + "): " + fragment2);
                        }
                    }
                }
            } finally {
            }
        }
        ArrayList arrayList4 = this.f2273d;
        if (arrayList4 == null || (size = arrayList4.size()) <= 0) {
            backStackStateArr = null;
        } else {
            backStackStateArr = new BackStackState[size];
            for (i3 = 0; i3 < size; i3++) {
                backStackStateArr[i3] = new BackStackState((a) this.f2273d.get(i3));
                if (B(2)) {
                    StringBuilder q5 = android.support.v4.media.session.e.q(i3, "saveAllState: adding back stack #", ": ");
                    q5.append(this.f2273d.get(i3));
                    Log.v("FragmentManager", q5.toString());
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.e = null;
        ArrayList arrayList5 = new ArrayList();
        fragmentManagerState.f2105f = arrayList5;
        ArrayList arrayList6 = new ArrayList();
        fragmentManagerState.f2106g = arrayList6;
        fragmentManagerState.f2101a = arrayList2;
        fragmentManagerState.f2102b = arrayList;
        fragmentManagerState.f2103c = backStackStateArr;
        fragmentManagerState.f2104d = this.f2277i.get();
        Fragment fragment3 = this.r;
        if (fragment3 != null) {
            fragmentManagerState.e = fragment3.mWho;
        }
        arrayList5.addAll(this.f2278j.keySet());
        arrayList6.addAll(this.f2278j.values());
        fragmentManagerState.f2107h = new ArrayList(this.f2291x);
        return fragmentManagerState;
    }

    public final void M() {
        synchronized (this.f2270a) {
            try {
                if (this.f2270a.size() == 1) {
                    this.f2283o.f2183c.removeCallbacks(this.H);
                    this.f2283o.f2183c.post(this.H);
                    T();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void N(Fragment fragment, boolean z5) {
        ViewGroup x10 = x(fragment);
        if (x10 == null || !(x10 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) x10).setDrawDisappearingViewsLast(!z5);
    }

    public final void O(Fragment fragment, Lifecycle$State lifecycle$State) {
        if (fragment.equals(this.f2272c.b(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this)) {
            fragment.mMaxState = lifecycle$State;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public final void P(Fragment fragment) {
        if (fragment != null) {
            if (!fragment.equals(this.f2272c.b(fragment.mWho)) || (fragment.mHost != null && fragment.mFragmentManager != this)) {
                throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
            }
        }
        Fragment fragment2 = this.r;
        this.r = fragment;
        m(fragment2);
        m(this.r);
    }

    public final void Q(Fragment fragment) {
        ViewGroup x10 = x(fragment);
        if (x10 != null) {
            if (fragment.getPopExitAnim() + fragment.getPopEnterAnim() + fragment.getExitAnim() + fragment.getEnterAnim() > 0) {
                if (x10.getTag(R$id.visible_removing_fragment_view_tag) == null) {
                    x10.setTag(R$id.visible_removing_fragment_view_tag, fragment);
                }
                ((Fragment) x10.getTag(R$id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
            }
        }
    }

    public final void S() {
        ArrayList d5 = this.f2272c.d();
        int size = d5.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = d5.get(i3);
            i3++;
            a1 a1Var = (a1) obj;
            Fragment fragment = a1Var.f2145c;
            if (fragment.mDeferStart) {
                if (this.f2271b) {
                    this.C = true;
                } else {
                    fragment.mDeferStart = false;
                    a1Var.j();
                }
            }
        }
    }

    public final void T() {
        synchronized (this.f2270a) {
            try {
                if (!this.f2270a.isEmpty()) {
                    k0 k0Var = this.f2276h;
                    k0Var.f2209a = true;
                    androidx.activity.k kVar = k0Var.f2211c;
                    if (kVar != null) {
                        kVar.f(Boolean.TRUE);
                    }
                    return;
                }
                k0 k0Var2 = this.f2276h;
                ArrayList arrayList = this.f2273d;
                boolean z5 = (arrayList != null ? arrayList.size() : 0) > 0 && D(this.f2285q);
                k0Var2.f2209a = z5;
                androidx.activity.k kVar2 = k0Var2.f2211c;
                if (kVar2 != null) {
                    kVar2.f(Boolean.valueOf(z5));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final a1 a(Fragment fragment) {
        if (B(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        a1 f2 = f(fragment);
        fragment.mFragmentManager = this;
        b1 b1Var = this.f2272c;
        b1Var.f(f2);
        if (!fragment.mDetached) {
            b1Var.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (C(fragment)) {
                this.f2292y = true;
            }
        }
        return f2;
    }

    public void addFragmentOnAttachListener(w0 w0Var) {
        this.f2281m.add(w0Var);
    }

    public void addOnBackStackChangedListener(p0 p0Var) {
        if (this.f2279k == null) {
            this.f2279k = new ArrayList();
        }
        this.f2279k.add(p0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(g0 g0Var, f0 f0Var, Fragment fragment) {
        if (this.f2283o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f2283o = g0Var;
        this.f2284p = f0Var;
        this.f2285q = fragment;
        if (fragment != null) {
            addFragmentOnAttachListener(new n0(fragment));
        } else if (g0Var instanceof w0) {
            addFragmentOnAttachListener((w0) g0Var);
        }
        if (this.f2285q != null) {
            T();
        }
        if (g0Var instanceof androidx.activity.p) {
            androidx.activity.p pVar = (androidx.activity.p) g0Var;
            androidx.activity.o l3 = pVar.l();
            this.f2275g = l3;
            androidx.lifecycle.s sVar = pVar;
            if (fragment != null) {
                sVar = fragment;
            }
            l3.a(sVar, this.f2276h);
        }
        if (fragment != null) {
            v0 v0Var = fragment.mFragmentManager.G;
            HashMap hashMap = v0Var.f2316b;
            v0 v0Var2 = (v0) hashMap.get(fragment.mWho);
            if (v0Var2 == null) {
                v0Var2 = new v0(v0Var.f2318d);
                hashMap.put(fragment.mWho, v0Var2);
            }
            this.G = v0Var2;
        } else if (g0Var instanceof androidx.lifecycle.r0) {
            this.G = (v0) new de.o(((androidx.lifecycle.r0) g0Var).getViewModelStore(), v0.f2314g).q(v0.class);
        } else {
            this.G = new v0(false);
        }
        v0 v0Var3 = this.G;
        v0Var3.f2319f = this.f2293z || this.A;
        this.f2272c.f2150c = v0Var3;
        Object obj = this.f2283o;
        if (obj instanceof androidx.activity.result.g) {
            androidx.activity.result.f Z = ((androidx.activity.result.g) obj).Z();
            String n4 = com.google.android.gms.internal.mlkit_vision_barcode.l0.n("FragmentManager:", fragment != null ? r5.a.f(new StringBuilder(), fragment.mWho, ":") : "");
            this.f2288u = Z.d(android.support.v4.media.session.e.l(n4, "StartActivityForResult"), new o0(2), new j0(this, 2));
            this.f2289v = Z.d(android.support.v4.media.session.e.l(n4, "StartIntentSenderForResult"), new o0(0), new j0(this, 0));
            this.f2290w = Z.d(android.support.v4.media.session.e.l(n4, "RequestPermissions"), new o0(1), new j0(this, 1));
        }
    }

    public final void c(Fragment fragment) {
        if (B(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            this.f2272c.a(fragment);
            if (B(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (C(fragment)) {
                this.f2292y = true;
            }
        }
    }

    public final void d() {
        this.f2271b = false;
        this.E.clear();
        this.D.clear();
    }

    public final HashSet e() {
        HashSet hashSet = new HashSet();
        ArrayList d5 = this.f2272c.d();
        int size = d5.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = d5.get(i3);
            i3++;
            ViewGroup viewGroup = ((a1) obj).f2145c.mContainer;
            if (viewGroup != null) {
                hashSet.add(l.h(viewGroup, z()));
            }
        }
        return hashSet;
    }

    public final a1 f(Fragment fragment) {
        String str = fragment.mWho;
        b1 b1Var = this.f2272c;
        a1 a1Var = (a1) ((HashMap) b1Var.f2149b).get(str);
        if (a1Var != null) {
            return a1Var;
        }
        a1 a1Var2 = new a1(this.f2280l, b1Var, fragment);
        a1Var2.k(this.f2283o.f2182b.getClassLoader());
        a1Var2.e = this.f2282n;
        return a1Var2;
    }

    public final void g(Fragment fragment) {
        if (B(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (B(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            b1 b1Var = this.f2272c;
            synchronized (((ArrayList) b1Var.f2148a)) {
                ((ArrayList) b1Var.f2148a).remove(fragment);
            }
            fragment.mAdded = false;
            if (C(fragment)) {
                this.f2292y = true;
            }
            Q(fragment);
        }
    }

    public final boolean h(MenuItem menuItem) {
        if (this.f2282n < 1) {
            return false;
        }
        for (Fragment fragment : this.f2272c.e()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean i(Menu menu, MenuInflater menuInflater) {
        if (this.f2282n < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z5 = false;
        for (Fragment fragment : this.f2272c.e()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z5 = true;
            }
        }
        if (this.e != null) {
            for (int i3 = 0; i3 < this.e.size(); i3++) {
                Fragment fragment2 = (Fragment) this.e.get(i3);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.e = arrayList;
        return z5;
    }

    public final void j() {
        this.B = true;
        s(true);
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((l) it.next()).g();
        }
        o(-1);
        this.f2283o = null;
        this.f2284p = null;
        this.f2285q = null;
        if (this.f2275g != null) {
            Iterator it2 = this.f2276h.f2210b.iterator();
            while (it2.hasNext()) {
                ((androidx.activity.a) it2.next()).cancel();
            }
            this.f2275g = null;
        }
        androidx.activity.result.c cVar = this.f2288u;
        if (cVar != null) {
            cVar.b();
            this.f2289v.b();
            this.f2290w.b();
        }
    }

    public final boolean k(MenuItem menuItem) {
        if (this.f2282n < 1) {
            return false;
        }
        for (Fragment fragment : this.f2272c.e()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void l(Menu menu) {
        if (this.f2282n < 1) {
            return;
        }
        for (Fragment fragment : this.f2272c.e()) {
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public final void m(Fragment fragment) {
        if (fragment != null) {
            if (fragment.equals(this.f2272c.b(fragment.mWho))) {
                fragment.performPrimaryNavigationFragmentChanged();
            }
        }
    }

    public final boolean n(Menu menu) {
        boolean z5 = false;
        if (this.f2282n < 1) {
            return false;
        }
        for (Fragment fragment : this.f2272c.e()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performPrepareOptionsMenu(menu)) {
                z5 = true;
            }
        }
        return z5;
    }

    public final void o(int i3) {
        try {
            this.f2271b = true;
            for (a1 a1Var : ((HashMap) this.f2272c.f2149b).values()) {
                if (a1Var != null) {
                    a1Var.e = i3;
                }
            }
            E(i3, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((l) it.next()).g();
            }
            this.f2271b = false;
            s(true);
        } catch (Throwable th2) {
            this.f2271b = false;
            throw th2;
        }
    }

    public final void p(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String l3 = android.support.v4.media.session.e.l(str, Logger.INDENT);
        b1 b1Var = this.f2272c;
        b1Var.getClass();
        String str2 = str + Logger.INDENT;
        HashMap hashMap = (HashMap) b1Var.f2149b;
        if (!hashMap.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (a1 a1Var : hashMap.values()) {
                printWriter.print(str);
                if (a1Var != null) {
                    Fragment fragment = a1Var.f2145c;
                    printWriter.println(fragment);
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        ArrayList arrayList = (ArrayList) b1Var.f2148a;
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i3 = 0; i3 < size3; i3++) {
                Fragment fragment2 = (Fragment) arrayList.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList arrayList2 = this.e;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size2; i10++) {
                Fragment fragment3 = (Fragment) this.e.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        ArrayList arrayList3 = this.f2273d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size; i11++) {
                a aVar = (a) this.f2273d.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.f(l3, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f2277i.get());
        synchronized (this.f2270a) {
            try {
                int size4 = this.f2270a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i12 = 0; i12 < size4; i12++) {
                        Object obj = (q0) this.f2270a.get(i12);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i12);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f2283o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f2284p);
        if (this.f2285q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f2285q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f2282n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f2293z);
        printWriter.print(" mStopped=");
        printWriter.print(this.A);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.B);
        if (this.f2292y) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f2292y);
        }
    }

    public final void q(q0 q0Var, boolean z5) {
        if (!z5) {
            if (this.f2283o == null) {
                if (!this.B) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (this.f2293z || this.A) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f2270a) {
            try {
                if (this.f2283o == null) {
                    if (!z5) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f2270a.add(q0Var);
                    M();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void r(boolean z5) {
        if (this.f2271b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f2283o == null) {
            if (!this.B) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f2283o.f2183c.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z5 && (this.f2293z || this.A)) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.D == null) {
            this.D = new ArrayList();
            this.E = new ArrayList();
        }
        this.f2271b = false;
    }

    public void removeFragmentOnAttachListener(w0 w0Var) {
        this.f2281m.remove(w0Var);
    }

    public void removeOnBackStackChangedListener(p0 p0Var) {
        ArrayList arrayList = this.f2279k;
        if (arrayList != null) {
            arrayList.remove(p0Var);
        }
    }

    public final boolean s(boolean z5) {
        boolean z6;
        r(z5);
        boolean z8 = false;
        while (true) {
            ArrayList arrayList = this.D;
            ArrayList arrayList2 = this.E;
            synchronized (this.f2270a) {
                try {
                    if (this.f2270a.isEmpty()) {
                        z6 = false;
                    } else {
                        int size = this.f2270a.size();
                        z6 = false;
                        for (int i3 = 0; i3 < size; i3++) {
                            z6 |= ((q0) this.f2270a.get(i3)).a(arrayList, arrayList2);
                        }
                        this.f2270a.clear();
                        this.f2283o.f2183c.removeCallbacks(this.H);
                    }
                } finally {
                }
            }
            if (!z6) {
                break;
            }
            z8 = true;
            this.f2271b = true;
            try {
                J(this.D, this.E);
            } finally {
                d();
            }
        }
        T();
        if (this.C) {
            this.C = false;
            S();
        }
        ((HashMap) this.f2272c.f2149b).values().removeAll(Collections.singleton(null));
        return z8;
    }

    public final void t(a aVar, boolean z5) {
        if (z5 && (this.f2283o == null || this.B)) {
            return;
        }
        r(z5);
        aVar.a(this.D, this.E);
        this.f2271b = true;
        try {
            J(this.D, this.E);
            d();
            T();
            if (this.C) {
                this.C = false;
                S();
            }
            ((HashMap) this.f2272c.f2149b).values().removeAll(Collections.singleton(null));
        } catch (Throwable th2) {
            d();
            throw th2;
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        Fragment fragment = this.f2285q;
        if (fragment != null) {
            sb2.append(fragment.getClass().getSimpleName());
            sb2.append(Const.STR_MART_JSON_BEGIN);
            sb2.append(Integer.toHexString(System.identityHashCode(this.f2285q)));
            sb2.append("}");
        } else {
            g0 g0Var = this.f2283o;
            if (g0Var != null) {
                sb2.append(g0Var.getClass().getSimpleName());
                sb2.append(Const.STR_MART_JSON_BEGIN);
                sb2.append(Integer.toHexString(System.identityHashCode(this.f2283o)));
                sb2.append("}");
            } else {
                sb2.append("null");
            }
        }
        sb2.append("}}");
        return sb2.toString();
    }

    public final void u(ArrayList arrayList, ArrayList arrayList2, int i3, int i10) {
        ArrayList arrayList3;
        ViewGroup viewGroup;
        boolean z5;
        int i11;
        boolean z6;
        int i12;
        int i13;
        boolean z8 = ((a) arrayList.get(i3)).f2139o;
        ArrayList arrayList4 = this.F;
        if (arrayList4 == null) {
            this.F = new ArrayList();
        } else {
            arrayList4.clear();
        }
        ArrayList arrayList5 = this.F;
        b1 b1Var = this.f2272c;
        arrayList5.addAll(b1Var.e());
        Fragment fragment = this.r;
        int i14 = i3;
        boolean z10 = false;
        while (true) {
            int i15 = 1;
            if (i14 >= i10) {
                boolean z11 = z8;
                this.F.clear();
                if (!z11 && this.f2282n >= 1) {
                    for (int i16 = i3; i16 < i10; i16++) {
                        ArrayList arrayList6 = ((a) arrayList.get(i16)).f2126a;
                        int size = arrayList6.size();
                        int i17 = 0;
                        while (i17 < size) {
                            Object obj = arrayList6.get(i17);
                            i17++;
                            Fragment fragment2 = ((d1) obj).f2162b;
                            if (fragment2 != null && fragment2.mFragmentManager != null) {
                                b1Var.f(f(fragment2));
                            }
                        }
                    }
                }
                for (int i18 = i3; i18 < i10; i18++) {
                    a aVar = (a) arrayList.get(i18);
                    if (((Boolean) arrayList2.get(i18)).booleanValue()) {
                        aVar.c(-1);
                        ArrayList arrayList7 = aVar.f2126a;
                        for (int size2 = arrayList7.size() - 1; size2 >= 0; size2--) {
                            d1 d1Var = (d1) arrayList7.get(size2);
                            Fragment fragment3 = d1Var.f2162b;
                            if (fragment3 != null) {
                                fragment3.setPopDirection(true);
                                int i19 = aVar.f2130f;
                                fragment3.setNextTransition(i19 != 4097 ? i19 != 4099 ? i19 != 8194 ? 0 : 4097 : 4099 : 8194);
                                fragment3.setSharedElementNames(aVar.f2138n, aVar.f2137m);
                            }
                            int i20 = d1Var.f2161a;
                            t0 t0Var = aVar.f2140p;
                            switch (i20) {
                                case 1:
                                    fragment3.setAnimations(d1Var.f2163c, d1Var.f2164d, d1Var.e, d1Var.f2165f);
                                    t0Var.N(fragment3, true);
                                    t0Var.I(fragment3);
                                    break;
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + d1Var.f2161a);
                                case 3:
                                    fragment3.setAnimations(d1Var.f2163c, d1Var.f2164d, d1Var.e, d1Var.f2165f);
                                    t0Var.a(fragment3);
                                    break;
                                case 4:
                                    fragment3.setAnimations(d1Var.f2163c, d1Var.f2164d, d1Var.e, d1Var.f2165f);
                                    t0Var.getClass();
                                    R(fragment3);
                                    break;
                                case 5:
                                    fragment3.setAnimations(d1Var.f2163c, d1Var.f2164d, d1Var.e, d1Var.f2165f);
                                    t0Var.N(fragment3, true);
                                    t0Var.A(fragment3);
                                    break;
                                case 6:
                                    fragment3.setAnimations(d1Var.f2163c, d1Var.f2164d, d1Var.e, d1Var.f2165f);
                                    t0Var.c(fragment3);
                                    break;
                                case 7:
                                    fragment3.setAnimations(d1Var.f2163c, d1Var.f2164d, d1Var.e, d1Var.f2165f);
                                    t0Var.N(fragment3, true);
                                    t0Var.g(fragment3);
                                    break;
                                case 8:
                                    t0Var.P(null);
                                    break;
                                case 9:
                                    t0Var.P(fragment3);
                                    break;
                                case 10:
                                    t0Var.O(fragment3, d1Var.f2166g);
                                    break;
                            }
                        }
                    } else {
                        aVar.c(1);
                        ArrayList arrayList8 = aVar.f2126a;
                        int size3 = arrayList8.size();
                        boolean z12 = false;
                        for (int i21 = 0; i21 < size3; i21++) {
                            d1 d1Var2 = (d1) arrayList8.get(i21);
                            Fragment fragment4 = d1Var2.f2162b;
                            if (fragment4 != null) {
                                fragment4.setPopDirection(z12);
                                fragment4.setNextTransition(aVar.f2130f);
                                fragment4.setSharedElementNames(aVar.f2137m, aVar.f2138n);
                            }
                            int i22 = d1Var2.f2161a;
                            t0 t0Var2 = aVar.f2140p;
                            switch (i22) {
                                case 1:
                                    fragment4.setAnimations(d1Var2.f2163c, d1Var2.f2164d, d1Var2.e, d1Var2.f2165f);
                                    z12 = false;
                                    t0Var2.N(fragment4, false);
                                    t0Var2.a(fragment4);
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + d1Var2.f2161a);
                                case 3:
                                    fragment4.setAnimations(d1Var2.f2163c, d1Var2.f2164d, d1Var2.e, d1Var2.f2165f);
                                    t0Var2.I(fragment4);
                                    z12 = false;
                                case 4:
                                    fragment4.setAnimations(d1Var2.f2163c, d1Var2.f2164d, d1Var2.e, d1Var2.f2165f);
                                    t0Var2.A(fragment4);
                                    z12 = false;
                                case 5:
                                    fragment4.setAnimations(d1Var2.f2163c, d1Var2.f2164d, d1Var2.e, d1Var2.f2165f);
                                    t0Var2.N(fragment4, false);
                                    R(fragment4);
                                    z12 = false;
                                case 6:
                                    fragment4.setAnimations(d1Var2.f2163c, d1Var2.f2164d, d1Var2.e, d1Var2.f2165f);
                                    t0Var2.g(fragment4);
                                    z12 = false;
                                case 7:
                                    fragment4.setAnimations(d1Var2.f2163c, d1Var2.f2164d, d1Var2.e, d1Var2.f2165f);
                                    t0Var2.N(fragment4, false);
                                    t0Var2.c(fragment4);
                                    z12 = false;
                                case 8:
                                    t0Var2.P(fragment4);
                                case 9:
                                    t0Var2.P(null);
                                case 10:
                                    t0Var2.O(fragment4, d1Var2.f2167h);
                            }
                        }
                    }
                }
                boolean booleanValue = ((Boolean) arrayList2.get(i10 - 1)).booleanValue();
                for (int i23 = i3; i23 < i10; i23++) {
                    a aVar2 = (a) arrayList.get(i23);
                    if (booleanValue) {
                        for (int size4 = aVar2.f2126a.size() - 1; size4 >= 0; size4--) {
                            Fragment fragment5 = ((d1) aVar2.f2126a.get(size4)).f2162b;
                            if (fragment5 != null) {
                                f(fragment5).j();
                            }
                        }
                    } else {
                        ArrayList arrayList9 = aVar2.f2126a;
                        int size5 = arrayList9.size();
                        int i24 = 0;
                        while (i24 < size5) {
                            Object obj2 = arrayList9.get(i24);
                            i24++;
                            Fragment fragment6 = ((d1) obj2).f2162b;
                            if (fragment6 != null) {
                                f(fragment6).j();
                            }
                        }
                    }
                }
                E(this.f2282n, true);
                HashSet hashSet = new HashSet();
                for (int i25 = i3; i25 < i10; i25++) {
                    ArrayList arrayList10 = ((a) arrayList.get(i25)).f2126a;
                    int size6 = arrayList10.size();
                    int i26 = 0;
                    while (i26 < size6) {
                        Object obj3 = arrayList10.get(i26);
                        i26++;
                        Fragment fragment7 = ((d1) obj3).f2162b;
                        if (fragment7 != null && (viewGroup = fragment7.mContainer) != null) {
                            hashSet.add(l.h(viewGroup, z()));
                        }
                    }
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    l lVar = (l) it.next();
                    lVar.f2216d = booleanValue;
                    lVar.j();
                    lVar.d();
                }
                for (int i27 = i3; i27 < i10; i27++) {
                    a aVar3 = (a) arrayList.get(i27);
                    if (((Boolean) arrayList2.get(i27)).booleanValue() && aVar3.r >= 0) {
                        aVar3.r = -1;
                    }
                    aVar3.getClass();
                }
                if (z10 && (arrayList3 = this.f2279k) != null && arrayList3.size() > 0) {
                    throw android.support.v4.media.session.e.c(0, this.f2279k);
                }
                return;
            }
            a aVar4 = (a) arrayList.get(i14);
            if (((Boolean) arrayList2.get(i14)).booleanValue()) {
                z5 = z8;
                i11 = i14;
                int i28 = 1;
                ArrayList arrayList11 = this.F;
                ArrayList arrayList12 = aVar4.f2126a;
                int size7 = arrayList12.size() - 1;
                while (size7 >= 0) {
                    d1 d1Var3 = (d1) arrayList12.get(size7);
                    int i29 = d1Var3.f2161a;
                    if (i29 != i28) {
                        if (i29 != 3) {
                            switch (i29) {
                                case 8:
                                    fragment = null;
                                    break;
                                case 9:
                                    fragment = d1Var3.f2162b;
                                    break;
                                case 10:
                                    d1Var3.f2167h = d1Var3.f2166g;
                                    break;
                            }
                            size7--;
                            i28 = 1;
                        }
                        arrayList11.add(d1Var3.f2162b);
                        size7--;
                        i28 = 1;
                    }
                    arrayList11.remove(d1Var3.f2162b);
                    size7--;
                    i28 = 1;
                }
            } else {
                ArrayList arrayList13 = this.F;
                int i30 = 0;
                while (true) {
                    ArrayList arrayList14 = aVar4.f2126a;
                    if (i30 < arrayList14.size()) {
                        d1 d1Var4 = (d1) arrayList14.get(i30);
                        int i31 = d1Var4.f2161a;
                        if (i31 != i15) {
                            int i32 = i15;
                            z6 = z8;
                            if (i31 != 2) {
                                if (i31 == 3 || i31 == 6) {
                                    arrayList13.remove(d1Var4.f2162b);
                                    Fragment fragment8 = d1Var4.f2162b;
                                    if (fragment8 == fragment) {
                                        arrayList14.add(i30, new d1(fragment8, 9));
                                        i30++;
                                        i13 = i14;
                                        i12 = i32;
                                        fragment = null;
                                        i30 += i12;
                                        i15 = i12;
                                        z8 = z6;
                                        i14 = i13;
                                    }
                                } else if (i31 == 7) {
                                    i12 = i32;
                                } else if (i31 == 8) {
                                    arrayList14.add(i30, new d1(fragment, 9));
                                    i30++;
                                    fragment = d1Var4.f2162b;
                                }
                                i13 = i14;
                                i12 = i32;
                                i30 += i12;
                                i15 = i12;
                                z8 = z6;
                                i14 = i13;
                            } else {
                                Fragment fragment9 = d1Var4.f2162b;
                                int i33 = fragment9.mContainerId;
                                int size8 = arrayList13.size() - 1;
                                int i34 = 0;
                                while (size8 >= 0) {
                                    int i35 = size8;
                                    Fragment fragment10 = (Fragment) arrayList13.get(size8);
                                    int i36 = i14;
                                    if (fragment10.mContainerId == i33) {
                                        if (fragment10 == fragment9) {
                                            i34 = i32;
                                        } else {
                                            if (fragment10 == fragment) {
                                                arrayList14.add(i30, new d1(fragment10, 9));
                                                i30++;
                                                fragment = null;
                                            }
                                            d1 d1Var5 = new d1(fragment10, 3);
                                            d1Var5.f2163c = d1Var4.f2163c;
                                            d1Var5.e = d1Var4.e;
                                            d1Var5.f2164d = d1Var4.f2164d;
                                            d1Var5.f2165f = d1Var4.f2165f;
                                            arrayList14.add(i30, d1Var5);
                                            arrayList13.remove(fragment10);
                                            i30++;
                                            fragment = fragment;
                                        }
                                    }
                                    size8 = i35 - 1;
                                    i14 = i36;
                                }
                                i13 = i14;
                                if (i34 != 0) {
                                    arrayList14.remove(i30);
                                    i30--;
                                    i12 = i32;
                                    i30 += i12;
                                    i15 = i12;
                                    z8 = z6;
                                    i14 = i13;
                                } else {
                                    i12 = i32;
                                    d1Var4.f2161a = i12;
                                    arrayList13.add(fragment9);
                                    i30 += i12;
                                    i15 = i12;
                                    z8 = z6;
                                    i14 = i13;
                                }
                            }
                        } else {
                            z6 = z8;
                            i12 = i15;
                        }
                        i13 = i14;
                        arrayList13.add(d1Var4.f2162b);
                        i30 += i12;
                        i15 = i12;
                        z8 = z6;
                        i14 = i13;
                    } else {
                        z5 = z8;
                        i11 = i14;
                    }
                }
            }
            z10 = z10 || aVar4.f2131g;
            i14 = i11 + 1;
            z8 = z5;
        }
    }

    public final Fragment v(int i3) {
        b1 b1Var = this.f2272c;
        ArrayList arrayList = (ArrayList) b1Var.f2148a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) arrayList.get(size);
            if (fragment != null && fragment.mFragmentId == i3) {
                return fragment;
            }
        }
        for (a1 a1Var : ((HashMap) b1Var.f2149b).values()) {
            if (a1Var != null) {
                Fragment fragment2 = a1Var.f2145c;
                if (fragment2.mFragmentId == i3) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final Fragment w(String str) {
        b1 b1Var = this.f2272c;
        if (str != null) {
            ArrayList arrayList = (ArrayList) b1Var.f2148a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) arrayList.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            b1Var.getClass();
            return null;
        }
        for (a1 a1Var : ((HashMap) b1Var.f2149b).values()) {
            if (a1Var != null) {
                Fragment fragment2 = a1Var.f2145c;
                if (str.equals(fragment2.mTag)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final ViewGroup x(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId <= 0 || !this.f2284p.c()) {
            return null;
        }
        View b3 = this.f2284p.b(fragment.mContainerId);
        if (b3 instanceof ViewGroup) {
            return (ViewGroup) b3;
        }
        return null;
    }

    public final m0 y() {
        Fragment fragment = this.f2285q;
        return fragment != null ? fragment.mFragmentManager.y() : this.f2286s;
    }

    public final l0 z() {
        Fragment fragment = this.f2285q;
        return fragment != null ? fragment.mFragmentManager.z() : this.f2287t;
    }
}
