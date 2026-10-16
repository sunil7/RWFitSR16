package androidx.fragment.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.R$id;
import androidx.lifecycle.Lifecycle$State;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class a1 {

    /* renamed from: a, reason: collision with root package name */
    public final c0 f2143a;

    /* renamed from: b, reason: collision with root package name */
    public final b1 f2144b;

    /* renamed from: c, reason: collision with root package name */
    public final Fragment f2145c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2146d = false;
    public int e = -1;

    public a1(c0 c0Var, b1 b1Var, Fragment fragment) {
        this.f2143a = c0Var;
        this.f2144b = b1Var;
        this.f2145c = fragment;
    }

    public final void a() {
        View view;
        View view2;
        b1 b1Var = this.f2144b;
        b1Var.getClass();
        Fragment fragment = this.f2145c;
        ViewGroup viewGroup = fragment.mContainer;
        int i3 = -1;
        if (viewGroup != null) {
            ArrayList arrayList = (ArrayList) b1Var.f2148a;
            int indexOf = arrayList.indexOf(fragment);
            int i10 = indexOf - 1;
            while (true) {
                if (i10 < 0) {
                    while (true) {
                        indexOf++;
                        if (indexOf >= arrayList.size()) {
                            break;
                        }
                        Fragment fragment2 = (Fragment) arrayList.get(indexOf);
                        if (fragment2.mContainer == viewGroup && (view = fragment2.mView) != null) {
                            i3 = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    Fragment fragment3 = (Fragment) arrayList.get(i10);
                    if (fragment3.mContainer == viewGroup && (view2 = fragment3.mView) != null) {
                        i3 = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i10--;
                }
            }
        }
        fragment.mContainer.addView(fragment.mView, i3);
    }

    public final void b() {
        boolean B = t0.B(3);
        Fragment fragment = this.f2145c;
        if (B) {
            Log.d("FragmentManager", "moveto ATTACHED: " + fragment);
        }
        Fragment fragment2 = fragment.mTarget;
        a1 a1Var = null;
        b1 b1Var = this.f2144b;
        if (fragment2 != null) {
            a1 a1Var2 = (a1) ((HashMap) b1Var.f2149b).get(fragment2.mWho);
            if (a1Var2 == null) {
                throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTarget + " that does not belong to this FragmentManager!");
            }
            fragment.mTargetWho = fragment.mTarget.mWho;
            fragment.mTarget = null;
            a1Var = a1Var2;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (a1Var = (a1) ((HashMap) b1Var.f2149b).get(str)) == null) {
                StringBuilder sb2 = new StringBuilder("Fragment ");
                sb2.append(fragment);
                sb2.append(" declared target fragment ");
                throw new IllegalStateException(r5.a.f(sb2, fragment.mTargetWho, " that does not belong to this FragmentManager!"));
            }
        }
        if (a1Var != null) {
            a1Var.j();
        }
        t0 t0Var = fragment.mFragmentManager;
        fragment.mHost = t0Var.f2283o;
        fragment.mParentFragment = t0Var.f2285q;
        c0 c0Var = this.f2143a;
        c0Var.g(false);
        fragment.performAttach();
        c0Var.b(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v4, types: [androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact] */
    /* JADX WARN: Type inference failed for: r2v17, types: [androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact] */
    public final int c() {
        Fragment fragment = this.f2145c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int i3 = this.e;
        int i10 = z0.f2325a[fragment.mMaxState.ordinal()];
        int i11 = 0;
        if (i10 != 1) {
            i3 = i10 != 2 ? i10 != 3 ? i10 != 4 ? Math.min(i3, -1) : Math.min(i3, 0) : Math.min(i3, 1) : Math.min(i3, 5);
        }
        if (fragment.mFromLayout) {
            if (fragment.mInLayout) {
                i3 = Math.max(this.e, 2);
                View view = fragment.mView;
                if (view != null && view.getParent() == null) {
                    i3 = Math.min(i3, 2);
                }
            } else {
                i3 = this.e < 4 ? Math.min(i3, fragment.mState) : Math.min(i3, 1);
            }
        }
        if (!fragment.mAdded) {
            i3 = Math.min(i3, 1);
        }
        ViewGroup viewGroup = fragment.mContainer;
        p1 p1Var = null;
        if (viewGroup != null) {
            l i12 = l.i(viewGroup, fragment.getParentFragmentManager());
            i12.getClass();
            p1 f2 = i12.f(fragment);
            p1 p1Var2 = f2 != null ? f2.f2252b : null;
            ArrayList arrayList = i12.f2215c;
            int size = arrayList.size();
            while (true) {
                if (i11 >= size) {
                    break;
                }
                Object obj = arrayList.get(i11);
                i11++;
                p1 p1Var3 = (p1) obj;
                if (p1Var3.f2253c.equals(fragment) && !p1Var3.f2255f) {
                    p1Var = p1Var3;
                    break;
                }
            }
            p1Var = (p1Var == null || !(p1Var2 == null || p1Var2 == SpecialEffectsController$Operation$LifecycleImpact.NONE)) ? p1Var2 : p1Var.f2252b;
        }
        if (p1Var == SpecialEffectsController$Operation$LifecycleImpact.ADDING) {
            i3 = Math.min(i3, 6);
        } else if (p1Var == SpecialEffectsController$Operation$LifecycleImpact.REMOVING) {
            i3 = Math.max(i3, 3);
        } else if (fragment.mRemoving) {
            i3 = fragment.isInBackStack() ? Math.min(i3, 1) : Math.min(i3, -1);
        }
        if (fragment.mDeferStart && fragment.mState < 5) {
            i3 = Math.min(i3, 4);
        }
        if (t0.B(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i3 + " for " + fragment);
        }
        return i3;
    }

    public final void d() {
        boolean B = t0.B(3);
        Fragment fragment = this.f2145c;
        if (B) {
            Log.d("FragmentManager", "moveto CREATED: " + fragment);
        }
        if (fragment.mIsCreated) {
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            fragment.mState = 1;
        } else {
            c0 c0Var = this.f2143a;
            c0Var.h(false);
            fragment.performCreate(fragment.mSavedFragmentState);
            c0Var.c(false);
        }
    }

    public final void e() {
        String str;
        Fragment fragment = this.f2145c;
        if (fragment.mFromLayout) {
            return;
        }
        if (t0.B(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
        }
        LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            int i3 = fragment.mContainerId;
            if (i3 == 0) {
                viewGroup = null;
            } else {
                if (i3 == -1) {
                    throw new IllegalArgumentException(android.support.v4.media.session.e.k("Cannot create fragment ", fragment, " for a container view with no id"));
                }
                viewGroup = (ViewGroup) fragment.mFragmentManager.f2284p.b(i3);
                if (viewGroup == null && !fragment.mRestored) {
                    try {
                        str = fragment.getResources().getResourceName(fragment.mContainerId);
                    } catch (Resources.NotFoundException unused) {
                        str = "unknown";
                    }
                    throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + str + ") for fragment " + fragment);
                }
            }
        }
        fragment.mContainer = viewGroup;
        fragment.performCreateView(performGetLayoutInflater, viewGroup, fragment.mSavedFragmentState);
        View view = fragment.mView;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            fragment.mView.setTag(R$id.fragment_container_view_tag, fragment);
            if (viewGroup != null) {
                a();
            }
            if (fragment.mHidden) {
                fragment.mView.setVisibility(8);
            }
            View view2 = fragment.mView;
            WeakHashMap weakHashMap = l1.z0.f15748a;
            if (l1.k0.b(view2)) {
                l1.l0.c(fragment.mView);
            } else {
                View view3 = fragment.mView;
                view3.addOnAttachStateChangeListener(new y0(view3));
            }
            fragment.performViewCreated();
            this.f2143a.m(false);
            int visibility = fragment.mView.getVisibility();
            fragment.setPostOnViewCreatedAlpha(fragment.mView.getAlpha());
            if (fragment.mContainer != null && visibility == 0) {
                View findFocus = fragment.mView.findFocus();
                if (findFocus != null) {
                    fragment.setFocusedView(findFocus);
                    if (t0.B(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + fragment);
                    }
                }
                fragment.mView.setAlpha(0.0f);
            }
        }
        fragment.mState = 2;
    }

    public final void f() {
        Fragment b3;
        boolean B = t0.B(3);
        Fragment fragment = this.f2145c;
        if (B) {
            Log.d("FragmentManager", "movefrom CREATED: " + fragment);
        }
        boolean z5 = true;
        int i3 = 0;
        boolean z6 = fragment.mRemoving && !fragment.isInBackStack();
        b1 b1Var = this.f2144b;
        if (!z6) {
            v0 v0Var = (v0) b1Var.f2150c;
            if (!((v0Var.f2315a.containsKey(fragment.mWho) && v0Var.f2318d) ? v0Var.e : true)) {
                String str = fragment.mTargetWho;
                if (str != null && (b3 = b1Var.b(str)) != null && b3.mRetainInstance) {
                    fragment.mTarget = b3;
                }
                fragment.mState = 0;
                return;
            }
        }
        g0 g0Var = fragment.mHost;
        if (g0Var instanceof androidx.lifecycle.r0) {
            z5 = ((v0) b1Var.f2150c).e;
        } else {
            FragmentActivity fragmentActivity = g0Var.f2182b;
            if (fragmentActivity != null) {
                z5 = true ^ fragmentActivity.isChangingConfigurations();
            }
        }
        if (z6 || z5) {
            v0 v0Var2 = (v0) b1Var.f2150c;
            v0Var2.getClass();
            if (t0.B(3)) {
                Log.d("FragmentManager", "Clearing non-config state for " + fragment);
            }
            HashMap hashMap = v0Var2.f2316b;
            v0 v0Var3 = (v0) hashMap.get(fragment.mWho);
            if (v0Var3 != null) {
                v0Var3.onCleared();
                hashMap.remove(fragment.mWho);
            }
            HashMap hashMap2 = v0Var2.f2317c;
            androidx.lifecycle.q0 q0Var = (androidx.lifecycle.q0) hashMap2.get(fragment.mWho);
            if (q0Var != null) {
                HashMap hashMap3 = q0Var.f2386a;
                Iterator it = hashMap3.values().iterator();
                while (it.hasNext()) {
                    ((androidx.lifecycle.m0) it.next()).clear();
                }
                hashMap3.clear();
                hashMap2.remove(fragment.mWho);
            }
        }
        fragment.performDestroy();
        this.f2143a.d(false);
        ArrayList d5 = b1Var.d();
        int size = d5.size();
        while (i3 < size) {
            Object obj = d5.get(i3);
            i3++;
            a1 a1Var = (a1) obj;
            if (a1Var != null) {
                String str2 = fragment.mWho;
                Fragment fragment2 = a1Var.f2145c;
                if (str2.equals(fragment2.mTargetWho)) {
                    fragment2.mTarget = fragment;
                    fragment2.mTargetWho = null;
                }
            }
        }
        String str3 = fragment.mTargetWho;
        if (str3 != null) {
            fragment.mTarget = b1Var.b(str3);
        }
        b1Var.g(this);
    }

    public final void g() {
        View view;
        boolean B = t0.B(3);
        Fragment fragment = this.f2145c;
        if (B) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + fragment);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        fragment.performDestroyView();
        this.f2143a.n(false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.k(null);
        fragment.mInLayout = false;
    }

    public final void h() {
        boolean B = t0.B(3);
        Fragment fragment = this.f2145c;
        if (B) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + fragment);
        }
        fragment.performDetach();
        this.f2143a.e(false);
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (!fragment.mRemoving || fragment.isInBackStack()) {
            v0 v0Var = (v0) this.f2144b.f2150c;
            if (!((v0Var.f2315a.containsKey(fragment.mWho) && v0Var.f2318d) ? v0Var.e : true)) {
                return;
            }
        }
        if (t0.B(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + fragment);
        }
        fragment.initState();
    }

    public final void i() {
        Fragment fragment = this.f2145c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (t0.B(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
            }
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
            View view = fragment.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                fragment.mView.setTag(R$id.fragment_container_view_tag, fragment);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.performViewCreated();
                this.f2143a.m(false);
                fragment.mState = 2;
            }
        }
    }

    public final void j() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z5 = this.f2146d;
        Fragment fragment = this.f2145c;
        if (z5) {
            if (t0.B(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + fragment);
                return;
            }
            return;
        }
        try {
            this.f2146d = true;
            while (true) {
                int c9 = c();
                int i3 = fragment.mState;
                if (c9 == i3) {
                    if (fragment.mHiddenChanged) {
                        if (fragment.mView != null && (viewGroup = fragment.mContainer) != null) {
                            l i10 = l.i(viewGroup, fragment.getParentFragmentManager());
                            if (fragment.mHidden) {
                                i10.getClass();
                                if (t0.B(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragment);
                                }
                                i10.b(SpecialEffectsController$Operation$State.GONE, SpecialEffectsController$Operation$LifecycleImpact.NONE, this);
                            } else {
                                i10.getClass();
                                if (t0.B(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragment);
                                }
                                i10.b(SpecialEffectsController$Operation$State.VISIBLE, SpecialEffectsController$Operation$LifecycleImpact.NONE, this);
                            }
                        }
                        t0 t0Var = fragment.mFragmentManager;
                        if (t0Var != null && fragment.mAdded && t0.C(fragment)) {
                            t0Var.f2292y = true;
                        }
                        fragment.mHiddenChanged = false;
                        fragment.onHiddenChanged(fragment.mHidden);
                    }
                    this.f2146d = false;
                    return;
                }
                if (c9 <= i3) {
                    switch (i3 - 1) {
                        case -1:
                            h();
                            break;
                        case 0:
                            f();
                            break;
                        case 1:
                            g();
                            fragment.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (t0.B(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                            }
                            if (fragment.mView != null && fragment.mSavedViewState == null) {
                                m();
                            }
                            if (fragment.mView != null && (viewGroup3 = fragment.mContainer) != null) {
                                l i11 = l.i(viewGroup3, fragment.getParentFragmentManager());
                                i11.getClass();
                                if (t0.B(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragment);
                                }
                                i11.b(SpecialEffectsController$Operation$State.REMOVED, SpecialEffectsController$Operation$LifecycleImpact.REMOVING, this);
                            }
                            fragment.mState = 3;
                            break;
                        case 4:
                            boolean B = t0.B(3);
                            Fragment fragment2 = this.f2145c;
                            if (B) {
                                Log.d("FragmentManager", "movefrom STARTED: " + fragment2);
                            }
                            fragment2.performStop();
                            this.f2143a.l(false);
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            boolean B2 = t0.B(3);
                            Fragment fragment3 = this.f2145c;
                            if (B2) {
                                Log.d("FragmentManager", "movefrom RESUMED: " + fragment3);
                            }
                            fragment3.performPause();
                            this.f2143a.f(false);
                            break;
                    }
                } else {
                    switch (i3 + 1) {
                        case 0:
                            b();
                            break;
                        case 1:
                            d();
                            break;
                        case 2:
                            i();
                            e();
                            break;
                        case 3:
                            boolean B3 = t0.B(3);
                            Fragment fragment4 = this.f2145c;
                            if (B3) {
                                Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + fragment4);
                            }
                            fragment4.performActivityCreated(fragment4.mSavedFragmentState);
                            this.f2143a.a(false);
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup2 = fragment.mContainer) != null) {
                                l i12 = l.i(viewGroup2, fragment.getParentFragmentManager());
                                SpecialEffectsController$Operation$State from = SpecialEffectsController$Operation$State.from(fragment.mView.getVisibility());
                                i12.getClass();
                                if (t0.B(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragment);
                                }
                                i12.b(from, SpecialEffectsController$Operation$LifecycleImpact.ADDING, this);
                            }
                            fragment.mState = 4;
                            break;
                        case 5:
                            boolean B4 = t0.B(3);
                            Fragment fragment5 = this.f2145c;
                            if (B4) {
                                Log.d("FragmentManager", "moveto STARTED: " + fragment5);
                            }
                            fragment5.performStart();
                            this.f2143a.k(false);
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            l();
                            break;
                    }
                }
            }
        } catch (Throwable th2) {
            this.f2146d = false;
            throw th2;
        }
    }

    public final void k(ClassLoader classLoader) {
        Fragment fragment = this.f2145c;
        Bundle bundle = fragment.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        fragment.mSavedViewRegistryState = fragment.mSavedFragmentState.getBundle("android:view_registry_state");
        fragment.mTargetWho = fragment.mSavedFragmentState.getString("android:target_state");
        if (fragment.mTargetWho != null) {
            fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Boolean bool = fragment.mSavedUserVisibleHint;
        if (bool != null) {
            fragment.mUserVisibleHint = bool.booleanValue();
            fragment.mSavedUserVisibleHint = null;
        } else {
            fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        if (fragment.mUserVisibleHint) {
            return;
        }
        fragment.mDeferStart = true;
    }

    public final void l() {
        boolean B = t0.B(3);
        Fragment fragment = this.f2145c;
        if (B) {
            Log.d("FragmentManager", "moveto RESUMED: " + fragment);
        }
        View focusedView = fragment.getFocusedView();
        if (focusedView != null) {
            if (focusedView != fragment.mView) {
                for (ViewParent parent = focusedView.getParent(); parent != null; parent = parent.getParent()) {
                    if (parent != fragment.mView) {
                    }
                }
            }
            boolean requestFocus = focusedView.requestFocus();
            if (t0.B(2)) {
                StringBuilder sb2 = new StringBuilder("requestFocus: Restoring focused view ");
                sb2.append(focusedView);
                sb2.append(" ");
                sb2.append(requestFocus ? "succeeded" : "failed");
                sb2.append(" on Fragment ");
                sb2.append(fragment);
                sb2.append(" resulting in focused view ");
                sb2.append(fragment.mView.findFocus());
                Log.v("FragmentManager", sb2.toString());
            }
        }
        fragment.setFocusedView(null);
        fragment.performResume();
        this.f2143a.i(false);
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    public final void m() {
        Fragment fragment = this.f2145c;
        if (fragment.mView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        fragment.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            fragment.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        fragment.mViewLifecycleOwner.e.c(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        fragment.mSavedViewRegistryState = bundle;
    }

    public a1(c0 c0Var, b1 b1Var, ClassLoader classLoader, m0 m0Var, FragmentState fragmentState) {
        this.f2143a = c0Var;
        this.f2144b = b1Var;
        Fragment instantiate = Fragment.instantiate(m0Var.f2223a.f2283o.f2182b, fragmentState.f2108a, null);
        this.f2145c = instantiate;
        Bundle bundle = fragmentState.f2116j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        instantiate.setArguments(bundle);
        instantiate.mWho = fragmentState.f2109b;
        instantiate.mFromLayout = fragmentState.f2110c;
        instantiate.mRestored = true;
        instantiate.mFragmentId = fragmentState.f2111d;
        instantiate.mContainerId = fragmentState.e;
        instantiate.mTag = fragmentState.f2112f;
        instantiate.mRetainInstance = fragmentState.f2113g;
        instantiate.mRemoving = fragmentState.f2114h;
        instantiate.mDetached = fragmentState.f2115i;
        instantiate.mHidden = fragmentState.f2117k;
        instantiate.mMaxState = Lifecycle$State.values()[fragmentState.f2118l];
        Bundle bundle2 = fragmentState.f2119m;
        if (bundle2 != null) {
            instantiate.mSavedFragmentState = bundle2;
        } else {
            instantiate.mSavedFragmentState = new Bundle();
        }
        if (t0.B(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + instantiate);
        }
    }

    public a1(c0 c0Var, b1 b1Var, Fragment fragment, FragmentState fragmentState) {
        this.f2143a = c0Var;
        this.f2144b = b1Var;
        this.f2145c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.f2119m;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
