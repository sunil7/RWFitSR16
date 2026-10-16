package com.gyf.immersionbar;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.a;
import androidx.fragment.app.p;
import androidx.fragment.app.t0;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
class RequestManagerRetriever implements Handler.Callback {
    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    private Handler mHandler;
    private final Map<FragmentManager, RequestManagerFragment> mPendingFragments;
    private final Map<t0, SupportRequestManagerFragment> mPendingSupportFragments;
    private String mTag;

    public static class Holder {
        private static final RequestManagerRetriever INSTANCE = new RequestManagerRetriever();

        private Holder() {
        }
    }

    private static <T> void checkNotNull(T t8, String str) {
        if (t8 == null) {
            throw new NullPointerException(str);
        }
    }

    private RequestManagerFragment getFragment(FragmentManager fragmentManager, String str) {
        return getFragment(fragmentManager, str, false);
    }

    public static RequestManagerRetriever getInstance() {
        return Holder.INSTANCE;
    }

    private SupportRequestManagerFragment getSupportFragment(t0 t0Var, String str) {
        return getSupportFragment(t0Var, str, false);
    }

    public void destroy(Fragment fragment, boolean z5) {
        String sb2;
        if (fragment == null) {
            return;
        }
        String str = this.mTag;
        if (z5) {
            StringBuilder t8 = l0.t(str);
            t8.append(fragment.getClass().getName());
            sb2 = t8.toString();
        } else {
            StringBuilder t10 = l0.t(str);
            t10.append(System.identityHashCode(fragment));
            sb2 = t10.toString();
        }
        getSupportFragment(fragment.getChildFragmentManager(), sb2, true);
    }

    public ImmersionBar get(Activity activity) {
        checkNotNull(activity, "activity is null");
        String str = this.mTag + System.identityHashCode(activity);
        return activity instanceof FragmentActivity ? getSupportFragment(((FragmentActivity) activity).C0(), str).get(activity) : getFragment(activity.getFragmentManager(), str).get(activity);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 1) {
            this.mPendingFragments.remove((FragmentManager) message.obj);
            return true;
        }
        if (i3 != 2) {
            return false;
        }
        this.mPendingSupportFragments.remove((t0) message.obj);
        return true;
    }

    private RequestManagerRetriever() {
        this.mTag = ImmersionBar.class.getName();
        this.mPendingFragments = new HashMap();
        this.mPendingSupportFragments = new HashMap();
        this.mHandler = new Handler(Looper.getMainLooper(), this);
    }

    private RequestManagerFragment getFragment(FragmentManager fragmentManager, String str, boolean z5) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag(str);
        if (requestManagerFragment == null && (requestManagerFragment = this.mPendingFragments.get(fragmentManager)) == null) {
            if (z5) {
                return null;
            }
            requestManagerFragment = new RequestManagerFragment();
            this.mPendingFragments.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add(requestManagerFragment, str).commitAllowingStateLoss();
            this.mHandler.obtainMessage(1, fragmentManager).sendToTarget();
        }
        if (!z5) {
            return requestManagerFragment;
        }
        fragmentManager.beginTransaction().remove(requestManagerFragment).commitAllowingStateLoss();
        return null;
    }

    private SupportRequestManagerFragment getSupportFragment(t0 t0Var, String str, boolean z5) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) t0Var.w(str);
        if (supportRequestManagerFragment == null && (supportRequestManagerFragment = this.mPendingSupportFragments.get(t0Var)) == null) {
            if (z5) {
                return null;
            }
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            this.mPendingSupportFragments.put(t0Var, supportRequestManagerFragment);
            a aVar = new a(t0Var);
            aVar.e(0, supportRequestManagerFragment, str, 1);
            aVar.d(true);
            this.mHandler.obtainMessage(2, t0Var).sendToTarget();
        }
        if (!z5) {
            return supportRequestManagerFragment;
        }
        a aVar2 = new a(t0Var);
        aVar2.g(supportRequestManagerFragment);
        aVar2.d(true);
        return null;
    }

    public ImmersionBar get(Fragment fragment, boolean z5) {
        String sb2;
        checkNotNull(fragment, "fragment is null");
        checkNotNull(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof p) {
            checkNotNull(((p) fragment).f2246l, "fragment.getDialog() is null");
        }
        String str = this.mTag;
        if (z5) {
            StringBuilder t8 = l0.t(str);
            t8.append(fragment.getClass().getName());
            sb2 = t8.toString();
        } else {
            StringBuilder t10 = l0.t(str);
            t10.append(System.identityHashCode(fragment));
            sb2 = t10.toString();
        }
        return getSupportFragment(fragment.getChildFragmentManager(), sb2).get(fragment);
    }

    public void destroy(Activity activity, Dialog dialog) {
        if (activity == null || dialog == null) {
            return;
        }
        String str = this.mTag + System.identityHashCode(dialog);
        if (activity instanceof FragmentActivity) {
            SupportRequestManagerFragment supportFragment = getSupportFragment(((FragmentActivity) activity).C0(), str, true);
            if (supportFragment != null) {
                supportFragment.get(activity, dialog).onDestroy();
                return;
            }
            return;
        }
        RequestManagerFragment fragment = getFragment(activity.getFragmentManager(), str, true);
        if (fragment != null) {
            fragment.get(activity, dialog).onDestroy();
        }
    }

    public ImmersionBar get(android.app.Fragment fragment, boolean z5) {
        String sb2;
        checkNotNull(fragment, "fragment is null");
        checkNotNull(fragment.getActivity(), "fragment.getActivity() is null");
        if (fragment instanceof DialogFragment) {
            checkNotNull(((DialogFragment) fragment).getDialog(), "fragment.getDialog() is null");
        }
        String str = this.mTag;
        if (z5) {
            StringBuilder t8 = l0.t(str);
            t8.append(fragment.getClass().getName());
            sb2 = t8.toString();
        } else {
            StringBuilder t10 = l0.t(str);
            t10.append(System.identityHashCode(fragment));
            sb2 = t10.toString();
        }
        return getFragment(fragment.getChildFragmentManager(), sb2).get(fragment);
    }

    public ImmersionBar get(Activity activity, Dialog dialog) {
        checkNotNull(activity, "activity is null");
        checkNotNull(dialog, "dialog is null");
        String str = this.mTag + System.identityHashCode(dialog);
        if (activity instanceof FragmentActivity) {
            return getSupportFragment(((FragmentActivity) activity).C0(), str).get(activity, dialog);
        }
        return getFragment(activity.getFragmentManager(), str).get(activity, dialog);
    }
}
