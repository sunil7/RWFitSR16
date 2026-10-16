package androidx.fragment.app;

import android.util.Log;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class a implements q0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2126a;

    /* renamed from: b, reason: collision with root package name */
    public int f2127b;

    /* renamed from: c, reason: collision with root package name */
    public int f2128c;

    /* renamed from: d, reason: collision with root package name */
    public int f2129d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f2130f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2131g;

    /* renamed from: h, reason: collision with root package name */
    public String f2132h;

    /* renamed from: i, reason: collision with root package name */
    public int f2133i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f2134j;

    /* renamed from: k, reason: collision with root package name */
    public int f2135k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f2136l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f2137m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f2138n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2139o;

    /* renamed from: p, reason: collision with root package name */
    public final t0 f2140p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2141q;
    public int r;

    public a(t0 t0Var) {
        t0Var.y();
        g0 g0Var = t0Var.f2283o;
        if (g0Var != null) {
            g0Var.f2182b.getClassLoader();
        }
        this.f2126a = new ArrayList();
        this.f2139o = false;
        this.r = -1;
        this.f2140p = t0Var;
    }

    @Override // androidx.fragment.app.q0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (t0.B(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f2131g) {
            return true;
        }
        t0 t0Var = this.f2140p;
        if (t0Var.f2273d == null) {
            t0Var.f2273d = new ArrayList();
        }
        t0Var.f2273d.add(this);
        return true;
    }

    public final void b(d1 d1Var) {
        this.f2126a.add(d1Var);
        d1Var.f2163c = this.f2127b;
        d1Var.f2164d = this.f2128c;
        d1Var.e = this.f2129d;
        d1Var.f2165f = this.e;
    }

    public final void c(int i3) {
        if (this.f2131g) {
            if (t0.B(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i3);
            }
            ArrayList arrayList = this.f2126a;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                d1 d1Var = (d1) arrayList.get(i10);
                Fragment fragment = d1Var.f2162b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i3;
                    if (t0.B(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + d1Var.f2162b + " to " + d1Var.f2162b.mBackStackNesting);
                    }
                }
            }
        }
    }

    public final int d(boolean z5) {
        if (this.f2141q) {
            throw new IllegalStateException("commit already called");
        }
        if (t0.B(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new m1());
            f("  ", printWriter, true);
            printWriter.close();
        }
        this.f2141q = true;
        boolean z6 = this.f2131g;
        t0 t0Var = this.f2140p;
        if (z6) {
            this.r = t0Var.f2277i.getAndIncrement();
        } else {
            this.r = -1;
        }
        t0Var.q(this, z5);
        return this.r;
    }

    public final void e(int i3, Fragment fragment, String str, int i10) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.mTag;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i3 != 0) {
            if (i3 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i11 = fragment.mFragmentId;
            if (i11 != 0 && i11 != i3) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i3);
            }
            fragment.mFragmentId = i3;
            fragment.mContainerId = i3;
        }
        b(new d1(fragment, i10));
        fragment.mFragmentManager = this.f2140p;
    }

    public final void f(String str, PrintWriter printWriter, boolean z5) {
        String str2;
        if (z5) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f2132h);
            printWriter.print(" mIndex=");
            printWriter.print(this.r);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f2141q);
            if (this.f2130f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f2130f));
            }
            if (this.f2127b != 0 || this.f2128c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2127b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f2128c));
            }
            if (this.f2129d != 0 || this.e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f2129d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.e));
            }
            if (this.f2133i != 0 || this.f2134j != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2133i));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f2134j);
            }
            if (this.f2135k != 0 || this.f2136l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f2135k));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f2136l);
            }
        }
        ArrayList arrayList = this.f2126a;
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            d1 d1Var = (d1) arrayList.get(i3);
            switch (d1Var.f2161a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + d1Var.f2161a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i3);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(d1Var.f2162b);
            if (z5) {
                if (d1Var.f2163c != 0 || d1Var.f2164d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(d1Var.f2163c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(d1Var.f2164d));
                }
                if (d1Var.e != 0 || d1Var.f2165f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(d1Var.e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(d1Var.f2165f));
                }
            }
        }
    }

    public final void g(Fragment fragment) {
        t0 t0Var = fragment.mFragmentManager;
        if (t0Var == null || t0Var == this.f2140p) {
            b(new d1(fragment, 3));
            return;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void setOnStartPostponedListener(x xVar) {
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f2126a;
            if (i3 >= arrayList.size()) {
                return;
            }
            d1 d1Var = (d1) arrayList.get(i3);
            Fragment fragment = d1Var.f2162b;
            if (fragment != null && fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed()) {
                d1Var.f2162b.setOnStartEnterTransitionListener(xVar);
            }
            i3++;
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.r >= 0) {
            sb2.append(" #");
            sb2.append(this.r);
        }
        if (this.f2132h != null) {
            sb2.append(" ");
            sb2.append(this.f2132h);
        }
        sb2.append("}");
        return sb2.toString();
    }
}
