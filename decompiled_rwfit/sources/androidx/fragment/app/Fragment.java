package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.IntentSenderRequest;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.runtime.R$id;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.ic;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.s, androidx.lifecycle.r0, androidx.lifecycle.j, e2.f {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    v mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    t0 mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    g0 mHost;
    boolean mInLayout;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    LayoutInflater mLayoutInflater;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    View mView;
    l1 mViewLifecycleOwner;
    int mState = -1;
    String mWho = UUID.randomUUID().toString();
    String mTargetWho = null;
    private Boolean mIsPrimaryNavigationFragment = null;
    t0 mChildFragmentManager = new u0();
    boolean mMenuVisible = true;
    boolean mUserVisibleHint = true;
    Runnable mPostponedDurationRunnable = new q(this, 0);
    Lifecycle$State mMaxState = Lifecycle$State.RESUMED;
    androidx.lifecycle.b0 mViewLifecycleOwnerLiveData = new androidx.lifecycle.b0();
    private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    private final ArrayList<w> mOnPreAttachedListeners = new ArrayList<>();
    androidx.lifecycle.u mLifecycleRegistry = new androidx.lifecycle.u(this);
    e2.e mSavedStateRegistryController = new e2.e(this);
    androidx.lifecycle.p0 mDefaultFactory = null;

    public class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    public class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new y();

        /* renamed from: a, reason: collision with root package name */
        public final Bundle f2089a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.f2089a = readBundle;
            if (classLoader == null || readBundle == null) {
                return;
            }
            readBundle.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            parcel.writeBundle(this.f2089a);
        }
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    private void registerOnPreAttachListener(w wVar) {
        if (this.mState < 0) {
            this.mOnPreAttachedListeners.add(wVar);
            return;
        }
        t tVar = (t) wVar;
        Fragment fragment = tVar.e;
        tVar.f2267b.set(((androidx.activity.result.f) tVar.f2266a.apply(null)).c(fragment.generateActivityResultKey(), fragment, tVar.f2268c, tVar.f2269d));
    }

    public final int B() {
        Lifecycle$State lifecycle$State = this.mMaxState;
        return (lifecycle$State == Lifecycle$State.INITIALIZED || this.mParentFragment == null) ? lifecycle$State.ordinal() : Math.min(lifecycle$State.ordinal(), this.mParentFragment.B());
    }

    public final u C(d.a aVar, k.a aVar2, androidx.activity.result.a aVar3) {
        if (this.mState > 1) {
            throw new IllegalStateException(android.support.v4.media.session.e.k("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
        }
        registerOnPreAttachListener(new t(this, aVar2, new AtomicReference(), aVar, aVar3));
        return new u();
    }

    public void callStartTransitionListener(boolean z5) {
        ViewGroup viewGroup;
        t0 t0Var;
        v vVar = this.mAnimationInfo;
        if (vVar != null) {
            vVar.f2312u = false;
        }
        if (this.mView == null || (viewGroup = this.mContainer) == null || (t0Var = this.mFragmentManager) == null) {
            return;
        }
        l h4 = l.h(viewGroup, t0Var.z());
        h4.j();
        if (z5) {
            this.mHost.f2183c.post(new f(h4, 4));
        } else {
            h4.d();
        }
    }

    public f0 createFragmentContainer() {
        return new r(this);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            m0.l lVar = ((x1.b) new de.o(getViewModelStore(), x1.b.f19733b).q(x1.b.class)).f19734a;
            if (lVar.f15923c > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                if (lVar.f15923c > 0) {
                    if (lVar.f15922b[0] != null) {
                        throw new ClassCastException();
                    }
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(lVar.f15921a[0]);
                    printWriter.print(": ");
                    throw null;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.p(android.support.v4.media.session.e.l(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.f2272c.c(str);
    }

    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final FragmentActivity getActivity() {
        g0 g0Var = this.mHost;
        if (g0Var == null) {
            return null;
        }
        return g0Var.f2181a;
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        v vVar = this.mAnimationInfo;
        if (vVar == null || (bool = vVar.r) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        v vVar = this.mAnimationInfo;
        if (vVar == null || (bool = vVar.f2309q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public View getAnimatingAway() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        return vVar.f2294a;
    }

    public Animator getAnimator() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        return vVar.f2295b;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final t0 getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException(android.support.v4.media.session.e.k("Fragment ", this, " has not been attached yet."));
    }

    public Context getContext() {
        g0 g0Var = this.mHost;
        if (g0Var == null) {
            return null;
        }
        return g0Var.f2182b;
    }

    @Override // androidx.lifecycle.j
    public androidx.lifecycle.p0 getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mDefaultFactory == null) {
            Context applicationContext = requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && t0.B(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.mDefaultFactory = new androidx.lifecycle.k0(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    public int getEnterAnim() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return 0;
        }
        return vVar.f2297d;
    }

    public Object getEnterTransition() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        return vVar.f2303k;
    }

    public y0.s getEnterTransitionCallback() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        vVar.getClass();
        return null;
    }

    public int getExitAnim() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return 0;
        }
        return vVar.e;
    }

    public Object getExitTransition() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        return vVar.f2305m;
    }

    public y0.s getExitTransitionCallback() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        vVar.getClass();
        return null;
    }

    public View getFocusedView() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        return vVar.f2311t;
    }

    @Deprecated
    public final t0 getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        g0 g0Var = this.mHost;
        if (g0Var == null) {
            return null;
        }
        return ((b0) g0Var).e;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // androidx.lifecycle.s
    public androidx.lifecycle.n getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public x1.a getLoaderManager() {
        return new x1.c(this, getViewModelStore());
    }

    public int getNextTransition() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return 0;
        }
        return vVar.f2300h;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final t0 getParentFragmentManager() {
        t0 t0Var = this.mFragmentManager;
        if (t0Var != null) {
            return t0Var;
        }
        throw new IllegalStateException(android.support.v4.media.session.e.k("Fragment ", this, " not associated with a fragment manager."));
    }

    public boolean getPopDirection() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return false;
        }
        return vVar.f2296c;
    }

    public int getPopEnterAnim() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return 0;
        }
        return vVar.f2298f;
    }

    public int getPopExitAnim() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return 0;
        }
        return vVar.f2299g;
    }

    public float getPostOnViewCreatedAlpha() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return 1.0f;
        }
        return vVar.f2310s;
    }

    public Object getReenterTransition() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        Object obj = vVar.f2306n;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        Object obj = vVar.f2304l;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // e2.f
    public final e2.d getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f12443b;
    }

    public Object getSharedElementEnterTransition() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        return vVar.f2307o;
    }

    public Object getSharedElementReturnTransition() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        Object obj = vVar.f2308p;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    public ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        v vVar = this.mAnimationInfo;
        return (vVar == null || (arrayList = vVar.f2301i) == null) ? new ArrayList<>() : arrayList;
    }

    public ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        v vVar = this.mAnimationInfo;
        return (vVar == null || (arrayList = vVar.f2302j) == null) ? new ArrayList<>() : arrayList;
    }

    public final String getString(int i3) {
        return getResources().getString(i3);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        String str;
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        t0 t0Var = this.mFragmentManager;
        if (t0Var == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return t0Var.f2272c.b(str);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i3) {
        return getResources().getText(i3);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public androidx.lifecycle.s getViewLifecycleOwner() {
        l1 l1Var = this.mViewLifecycleOwner;
        if (l1Var != null) {
            return l1Var;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public androidx.lifecycle.y getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.r0
    public androidx.lifecycle.q0 getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (B() == Lifecycle$State.INITIALIZED.ordinal()) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        HashMap hashMap = this.mFragmentManager.G.f2317c;
        androidx.lifecycle.q0 q0Var = (androidx.lifecycle.q0) hashMap.get(this.mWho);
        if (q0Var != null) {
            return q0Var;
        }
        androidx.lifecycle.q0 q0Var2 = new androidx.lifecycle.q0();
        hashMap.put(this.mWho, q0Var2);
        return q0Var2;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void initState() {
        this.mLifecycleRegistry = new androidx.lifecycle.u(this);
        this.mSavedStateRegistryController = new e2.e(this);
        this.mDefaultFactory = null;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new u0();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    public boolean isHideReplaced() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return false;
        }
        return vVar.f2313v;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        if (!this.mMenuVisible) {
            return false;
        }
        if (this.mFragmentManager != null) {
            Fragment fragment = this.mParentFragment;
            if (!(fragment == null ? true : fragment.isMenuVisible())) {
                return false;
            }
        }
        return true;
    }

    public boolean isPostponed() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return false;
        }
        return vVar.f2312u;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isRemovingParent() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment.isRemoving() || parentFragment.isRemovingParent();
        }
        return false;
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        t0 t0Var = this.mFragmentManager;
        if (t0Var == null) {
            return false;
        }
        return t0Var.f2293z || t0Var.A;
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.F();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i3, int i10, Intent intent) {
        if (t0.B(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i3 + " resultCode: " + i10 + " data: " + intent);
        }
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        g0 g0Var = this.mHost;
        FragmentActivity fragmentActivity = g0Var == null ? null : g0Var.f2181a;
        if (fragmentActivity != null) {
            this.mCalled = false;
            onAttach((Activity) fragmentActivity);
        }
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        t0 t0Var = this.mChildFragmentManager;
        if (t0Var.f2282n >= 1) {
            return;
        }
        t0Var.f2293z = false;
        t0Var.A = false;
        t0Var.G.f2319f = false;
        t0Var.o(1);
    }

    public Animation onCreateAnimation(int i3, boolean z5, int i10) {
        return null;
    }

    public Animator onCreateAnimator(int i3, boolean z5, int i10) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i3 = this.mContentLayoutId;
        if (i3 != 0) {
            return layoutInflater.inflate(i3, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z5) {
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        g0 g0Var = this.mHost;
        FragmentActivity fragmentActivity = g0Var == null ? null : g0Var.f2181a;
        if (fragmentActivity != null) {
            this.mCalled = false;
            onInflate((Activity) fragmentActivity, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z5) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z5) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z5) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.F();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new SuperNotCalledException(android.support.v4.media.session.e.k("Fragment ", this, " did not call through to super.onActivityCreated()"));
        }
        if (t0.B(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
        t0 t0Var = this.mChildFragmentManager;
        t0Var.f2293z = false;
        t0Var.A = false;
        t0Var.G.f2319f = false;
        t0Var.o(4);
    }

    public void performAttach() {
        ArrayList<w> arrayList = this.mOnPreAttachedListeners;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            w wVar = arrayList.get(i3);
            i3++;
            t tVar = (t) wVar;
            Fragment fragment = tVar.e;
            tVar.f2267b.set(((androidx.activity.result.f) tVar.f2266a.apply(null)).c(fragment.generateActivityResultKey(), fragment, tVar.f2268c, tVar.f2269d));
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.b(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach((Context) this.mHost.f2182b);
        if (!this.mCalled) {
            throw new SuperNotCalledException(android.support.v4.media.session.e.k("Fragment ", this, " did not call through to super.onAttach()"));
        }
        Iterator it = this.mFragmentManager.f2281m.iterator();
        while (it.hasNext()) {
            ((w0) it.next()).a(this);
        }
        t0 t0Var = this.mChildFragmentManager;
        t0Var.f2293z = false;
        t0Var.A = false;
        t0Var.G.f2319f = false;
        t0Var.o(0);
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        for (Fragment fragment : this.mChildFragmentManager.f2272c.e()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.h(menuItem);
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.F();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new androidx.lifecycle.q() { // from class: androidx.fragment.app.Fragment.5
            @Override // androidx.lifecycle.q
            public final void c(androidx.lifecycle.s sVar, Lifecycle$Event lifecycle$Event) {
                View view;
                if (lifecycle$Event != Lifecycle$Event.ON_STOP || (view = Fragment.this.mView) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        this.mSavedStateRegistryController.b(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (!this.mCalled) {
            throw new SuperNotCalledException(android.support.v4.media.session.e.k("Fragment ", this, " did not call through to super.onCreate()"));
        }
        this.mLifecycleRegistry.e(Lifecycle$Event.ON_CREATE);
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z5 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z5 = true;
        }
        return this.mChildFragmentManager.i(menu, menuInflater) | z5;
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.F();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new l1(this, getViewModelStore());
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView == null) {
            if (this.mViewLifecycleOwner.f2220d != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
            return;
        }
        this.mViewLifecycleOwner.b();
        this.mView.setTag(R$id.view_tree_lifecycle_owner, this.mViewLifecycleOwner);
        this.mView.setTag(androidx.lifecycle.viewmodel.R$id.view_tree_view_model_store_owner, this.mViewLifecycleOwner);
        View view = this.mView;
        l1 l1Var = this.mViewLifecycleOwner;
        kotlin.jvm.internal.e.f(view, "<this>");
        view.setTag(androidx.savedstate.R$id.view_tree_saved_state_registry_owner, l1Var);
        this.mViewLifecycleOwnerLiveData.k(this.mViewLifecycleOwner);
    }

    public void performDestroy() {
        this.mChildFragmentManager.j();
        this.mLifecycleRegistry.e(Lifecycle$Event.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new SuperNotCalledException(android.support.v4.media.session.e.k("Fragment ", this, " did not call through to super.onDestroy()"));
        }
    }

    public void performDestroyView() {
        this.mChildFragmentManager.o(1);
        if (this.mView != null) {
            l1 l1Var = this.mViewLifecycleOwner;
            l1Var.b();
            if (l1Var.f2220d.f2390b.isAtLeast(Lifecycle$State.CREATED)) {
                this.mViewLifecycleOwner.a(Lifecycle$Event.ON_DESTROY);
            }
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new SuperNotCalledException(android.support.v4.media.session.e.k("Fragment ", this, " did not call through to super.onDestroyView()"));
        }
        m0.l lVar = ((x1.b) new de.o(getViewModelStore(), x1.b.f19733b).q(x1.b.class)).f19734a;
        if (lVar.f15923c > 0) {
            throw com.google.android.gms.internal.mlkit_vision_barcode.l0.f(lVar.f15922b[0]);
        }
        this.mPerformedCreateView = false;
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new SuperNotCalledException(android.support.v4.media.session.e.k("Fragment ", this, " did not call through to super.onDetach()"));
        }
        t0 t0Var = this.mChildFragmentManager;
        if (t0Var.B) {
            return;
        }
        t0Var.j();
        this.mChildFragmentManager = new u0();
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
        for (Fragment fragment : this.mChildFragmentManager.f2272c.e()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public void performMultiWindowModeChanged(boolean z5) {
        onMultiWindowModeChanged(z5);
        for (Fragment fragment : this.mChildFragmentManager.f2272c.e()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z5);
            }
        }
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.k(menuItem);
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.l(menu);
    }

    public void performPause() {
        this.mChildFragmentManager.o(5);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(Lifecycle$Event.ON_PAUSE);
        }
        this.mLifecycleRegistry.e(Lifecycle$Event.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new SuperNotCalledException(android.support.v4.media.session.e.k("Fragment ", this, " did not call through to super.onPause()"));
        }
    }

    public void performPictureInPictureModeChanged(boolean z5) {
        onPictureInPictureModeChanged(z5);
        for (Fragment fragment : this.mChildFragmentManager.f2272c.e()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z5);
            }
        }
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z5 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z5 = true;
        }
        return this.mChildFragmentManager.n(menu) | z5;
    }

    public void performPrimaryNavigationFragmentChanged() {
        this.mFragmentManager.getClass();
        boolean D = t0.D(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != D) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(D);
            onPrimaryNavigationFragmentChanged(D);
            t0 t0Var = this.mChildFragmentManager;
            t0Var.T();
            t0Var.m(t0Var.r);
        }
    }

    public void performResume() {
        this.mChildFragmentManager.F();
        this.mChildFragmentManager.s(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new SuperNotCalledException(android.support.v4.media.session.e.k("Fragment ", this, " did not call through to super.onResume()"));
        }
        androidx.lifecycle.u uVar = this.mLifecycleRegistry;
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_RESUME;
        uVar.e(lifecycle$Event);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(lifecycle$Event);
        }
        t0 t0Var = this.mChildFragmentManager;
        t0Var.f2293z = false;
        t0Var.A = false;
        t0Var.G.f2319f = false;
        t0Var.o(7);
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.c(bundle);
        Parcelable L = this.mChildFragmentManager.L();
        if (L != null) {
            bundle.putParcelable("android:support:fragments", L);
        }
    }

    public void performStart() {
        this.mChildFragmentManager.F();
        this.mChildFragmentManager.s(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new SuperNotCalledException(android.support.v4.media.session.e.k("Fragment ", this, " did not call through to super.onStart()"));
        }
        androidx.lifecycle.u uVar = this.mLifecycleRegistry;
        Lifecycle$Event lifecycle$Event = Lifecycle$Event.ON_START;
        uVar.e(lifecycle$Event);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(lifecycle$Event);
        }
        t0 t0Var = this.mChildFragmentManager;
        t0Var.f2293z = false;
        t0Var.A = false;
        t0Var.G.f2319f = false;
        t0Var.o(5);
    }

    public void performStop() {
        t0 t0Var = this.mChildFragmentManager;
        t0Var.A = true;
        t0Var.G.f2319f = true;
        t0Var.o(4);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(Lifecycle$Event.ON_STOP);
        }
        this.mLifecycleRegistry.e(Lifecycle$Event.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new SuperNotCalledException(android.support.v4.media.session.e.k("Fragment ", this, " did not call through to super.onStop()"));
        }
    }

    public void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.o(2);
    }

    public void postponeEnterTransition() {
        y().f2312u = true;
    }

    public final <I, O> androidx.activity.result.b registerForActivityResult(d.a aVar, androidx.activity.result.a aVar2) {
        return C(aVar, new s(this, 0), aVar2);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i3) {
        if (this.mHost == null) {
            throw new IllegalStateException(android.support.v4.media.session.e.k("Fragment ", this, " not attached to Activity"));
        }
        t0 parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.f2290w == null) {
            parentFragmentManager.f2283o.getClass();
            return;
        }
        parentFragmentManager.f2291x.addLast(new FragmentManager$LaunchedFragmentInfo(this.mWho, i3));
        parentFragmentManager.f2290w.a(strArr);
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException(android.support.v4.media.session.e.k("Fragment ", this, " not attached to an activity."));
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException(android.support.v4.media.session.e.k("Fragment ", this, " does not have any arguments."));
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException(android.support.v4.media.session.e.k("Fragment ", this, " not attached to a context."));
    }

    @Deprecated
    public final t0 requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException(android.support.v4.media.session.e.k("Fragment ", this, " not attached to a host."));
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException(android.support.v4.media.session.e.k("Fragment ", this, " is not attached to any Fragment or host"));
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(android.support.v4.media.session.e.k("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.K(parcelable);
        t0 t0Var = this.mChildFragmentManager;
        t0Var.f2293z = false;
        t0Var.A = false;
        t0Var.G.f2319f = false;
        t0Var.o(1);
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            l1 l1Var = this.mViewLifecycleOwner;
            l1Var.e.b(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new SuperNotCalledException(android.support.v4.media.session.e.k("Fragment ", this, " did not call through to super.onViewStateRestored()"));
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(Lifecycle$Event.ON_CREATE);
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z5) {
        y().r = Boolean.valueOf(z5);
    }

    public void setAllowReturnTransitionOverlap(boolean z5) {
        y().f2309q = Boolean.valueOf(z5);
    }

    public void setAnimatingAway(View view) {
        y().f2294a = view;
    }

    public void setAnimations(int i3, int i10, int i11, int i12) {
        if (this.mAnimationInfo == null && i3 == 0 && i10 == 0 && i11 == 0 && i12 == 0) {
            return;
        }
        y().f2297d = i3;
        y().e = i10;
        y().f2298f = i11;
        y().f2299g = i12;
    }

    public void setAnimator(Animator animator) {
        y().f2295b = animator;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(y0.s sVar) {
        y().getClass();
    }

    public void setEnterTransition(Object obj) {
        y().f2303k = obj;
    }

    public void setExitSharedElementCallback(y0.s sVar) {
        y().getClass();
    }

    public void setExitTransition(Object obj) {
        y().f2305m = obj;
    }

    public void setFocusedView(View view) {
        y().f2311t = view;
    }

    public void setHasOptionsMenu(boolean z5) {
        if (this.mHasMenu != z5) {
            this.mHasMenu = z5;
            if (!isAdded() || isHidden()) {
                return;
            }
            ((b0) this.mHost).e.z0();
        }
    }

    public void setHideReplaced(boolean z5) {
        y().f2313v = z5;
    }

    public void setInitialSavedState(SavedState savedState) {
        Bundle bundle;
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (savedState == null || (bundle = savedState.f2089a) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z5) {
        if (this.mMenuVisible != z5) {
            this.mMenuVisible = z5;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                ((b0) this.mHost).e.z0();
            }
        }
    }

    public void setNextTransition(int i3) {
        if (this.mAnimationInfo == null && i3 == 0) {
            return;
        }
        y();
        this.mAnimationInfo.f2300h = i3;
    }

    public void setOnStartEnterTransitionListener(x xVar) {
        y();
        this.mAnimationInfo.getClass();
        if (xVar == null || xVar == null) {
            return;
        }
        ((s0) xVar).f2265a++;
    }

    public void setPopDirection(boolean z5) {
        if (this.mAnimationInfo == null) {
            return;
        }
        y().f2296c = z5;
    }

    public void setPostOnViewCreatedAlpha(float f2) {
        y().f2310s = f2;
    }

    public void setReenterTransition(Object obj) {
        y().f2306n = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z5) {
        this.mRetainInstance = z5;
        t0 t0Var = this.mFragmentManager;
        if (t0Var == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z5) {
            t0Var.G.b(this);
        } else {
            t0Var.G.c(this);
        }
    }

    public void setReturnTransition(Object obj) {
        y().f2304l = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        y().f2307o = obj;
    }

    public void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        y();
        v vVar = this.mAnimationInfo;
        vVar.f2301i = arrayList;
        vVar.f2302j = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        y().f2308p = obj;
    }

    @Deprecated
    public void setTargetFragment(Fragment fragment, int i3) {
        t0 t0Var = this.mFragmentManager;
        t0 t0Var2 = fragment != null ? fragment.mFragmentManager : null;
        if (t0Var != null && t0Var2 != null && t0Var != t0Var2) {
            throw new IllegalArgumentException(android.support.v4.media.session.e.k("Fragment ", fragment, " must share the same FragmentManager to be set as a target fragment"));
        }
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getTargetFragment()) {
            if (fragment2.equals(this)) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
            this.mTargetWho = null;
            this.mTarget = fragment;
        } else {
            this.mTargetWho = fragment.mWho;
            this.mTarget = null;
        }
        this.mTargetRequestCode = i3;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z5) {
        boolean z6 = false;
        if (!this.mUserVisibleHint && z5 && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            t0 t0Var = this.mFragmentManager;
            a1 f2 = t0Var.f(this);
            Fragment fragment = f2.f2145c;
            if (fragment.mDeferStart) {
                if (t0Var.f2271b) {
                    t0Var.C = true;
                } else {
                    fragment.mDeferStart = false;
                    f2.j();
                }
            }
        }
        this.mUserVisibleHint = z5;
        if (this.mState < 5 && !z5) {
            z6 = true;
        }
        this.mDeferStart = z6;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z5);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        g0 g0Var = this.mHost;
        if (g0Var == null) {
            return false;
        }
        b0 b0Var = (b0) g0Var;
        b0Var.getClass();
        if (ic.b() || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return y0.b.c(b0Var.e, str);
        }
        return false;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i3) {
        startActivityForResult(intent, i3, null);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i3, Intent intent, int i10, int i11, int i12, Bundle bundle) throws IntentSender.SendIntentException {
        if (this.mHost == null) {
            throw new IllegalStateException(android.support.v4.media.session.e.k("Fragment ", this, " not attached to Activity"));
        }
        if (t0.B(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i3 + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle);
        }
        t0 parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.f2289v == null) {
            g0 g0Var = parentFragmentManager.f2283o;
            if (i3 == -1) {
                y0.a.c(g0Var.f2181a, intentSender, i3, intent, i10, i11, i12, bundle);
                return;
            } else {
                g0Var.getClass();
                throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
            }
        }
        if (bundle != null) {
            if (intent == null) {
                intent = new Intent();
                intent.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            }
            if (t0.B(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent + " for fragment " + this);
            }
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        IntentSenderRequest intentSenderRequest = new IntentSenderRequest(intentSender, intent, i10, i11);
        parentFragmentManager.f2291x.addLast(new FragmentManager$LaunchedFragmentInfo(this.mWho, i3));
        if (t0.B(2)) {
            Log.v("FragmentManager", "Fragment " + this + "is launching an IntentSender for result ");
        }
        parentFragmentManager.f2289v.a(intentSenderRequest);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !y().f2312u) {
            return;
        }
        if (this.mHost == null) {
            y().f2312u = false;
        } else if (Looper.myLooper() != this.mHost.f2183c.getLooper()) {
            this.mHost.f2183c.postAtFrontOfQueue(new q(this, 1));
        } else {
            callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(getClass().getSimpleName());
        sb2.append(Const.STR_MART_JSON_BEGIN);
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} (");
        sb2.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb2.append(" tag=");
            sb2.append(this.mTag);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public Activity u() {
        return getActivity();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    public final v y() {
        if (this.mAnimationInfo == null) {
            v vVar = new v();
            vVar.f2303k = null;
            Object obj = USE_DEFAULT_TRANSITION;
            vVar.f2304l = obj;
            vVar.f2305m = null;
            vVar.f2306n = obj;
            vVar.f2307o = null;
            vVar.f2308p = obj;
            vVar.f2310s = 1.0f;
            vVar.f2311t = null;
            this.mAnimationInfo = vVar;
        }
        return this.mAnimationInfo;
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) m0.b(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle == null) {
                return fragment;
            }
            bundle.setClassLoader(fragment.getClass().getClassLoader());
            fragment.setArguments(bundle);
            return fragment;
        } catch (IllegalAccessException e) {
            throw new InstantiationException(com.google.android.gms.internal.mlkit_vision_barcode.l0.o("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
        } catch (java.lang.InstantiationException e10) {
            throw new InstantiationException(com.google.android.gms.internal.mlkit_vision_barcode.l0.o("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e10);
        } catch (NoSuchMethodException e11) {
            throw new InstantiationException(com.google.android.gms.internal.mlkit_vision_barcode.l0.o("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e11);
        } catch (InvocationTargetException e12) {
            throw new InstantiationException(com.google.android.gms.internal.mlkit_vision_barcode.l0.o("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e12);
        }
    }

    public final String getString(int i3, Object... objArr) {
        return getResources().getString(i3, objArr);
    }

    public final void postponeEnterTransition(long j4, TimeUnit timeUnit) {
        y().f2312u = true;
        t0 t0Var = this.mFragmentManager;
        Handler handler = t0Var != null ? t0Var.f2283o.f2183c : new Handler(Looper.getMainLooper());
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j4));
    }

    public final <I, O> androidx.activity.result.b registerForActivityResult(d.a aVar, androidx.activity.result.f fVar, androidx.activity.result.a aVar2) {
        return C(aVar, new s(fVar, 3), aVar2);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        g0 g0Var = this.mHost;
        if (g0Var == null) {
            throw new IllegalStateException(android.support.v4.media.session.e.k("Fragment ", this, " not attached to Activity"));
        }
        a1.a.b(g0Var.f2182b, intent, bundle);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i3, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException(android.support.v4.media.session.e.k("Fragment ", this, " not attached to Activity"));
        }
        t0 parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.f2288u == null) {
            g0 g0Var = parentFragmentManager.f2283o;
            if (i3 == -1) {
                a1.a.b(g0Var.f2182b, intent, bundle);
                return;
            } else {
                g0Var.getClass();
                throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
            }
        }
        parentFragmentManager.f2291x.addLast(new FragmentManager$LaunchedFragmentInfo(this.mWho, i3));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        parentFragmentManager.f2288u.a(intent);
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        g0 g0Var = this.mHost;
        if (g0Var != null) {
            FragmentActivity fragmentActivity = ((b0) g0Var).e;
            LayoutInflater cloneInContext = fragmentActivity.getLayoutInflater().cloneInContext(fragmentActivity);
            cloneInContext.setFactory2(this.mChildFragmentManager.f2274f);
            return cloneInContext;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }
}
