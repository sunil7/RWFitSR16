package com.dh.imagepick;

import android.app.Activity;
import android.app.FragmentManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.a;
import androidx.fragment.app.t0;
import androidx.fragment.app.u0;
import com.dh.imagepick.exception.ActivityStatusException;
import com.dh.imagepick.work.c;
import kotlin.jvm.internal.e;
import z4.b;

/* loaded from: classes.dex */
public final class ImagePickClient {
    public static final ImagePickClient INSTANCE = new ImagePickClient();

    private ImagePickClient() {
    }

    private final void checkStatusFirst(Activity activity) {
        if (!Utils.INSTANCE.isActivityAvailable$imagepick_release(activity)) {
            throw new ActivityStatusException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.app.FragmentTransaction] */
    /* JADX WARN: Type inference failed for: r1v5, types: [androidx.fragment.app.a] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.app.Fragment, z4.a] */
    /* JADX WARN: Type inference failed for: r2v5, types: [z4.c] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [androidx.fragment.app.Fragment, z4.b] */
    /* JADX WARN: Type inference failed for: r5v7, types: [androidx.fragment.app.t0] */
    public static final c with(Activity activity) {
        ?? r22;
        e.f(activity, "activity");
        INSTANCE.checkStatusFirst(activity);
        if (activity instanceof FragmentActivity) {
            u0 C0 = ((FragmentActivity) activity).C0();
            Fragment w8 = C0.w("AcceptResultFragment");
            r22 = w8 instanceof b ? (b) w8 : 0;
            if (r22 == 0) {
                r22 = new b();
                ?? aVar = new a(C0);
                aVar.e(0, r22, "AcceptResultFragment", 1);
                if (aVar.f2131g) {
                    throw new IllegalStateException("This transaction is already being added to the back stack");
                }
                aVar.f2140p.t(aVar, true);
            }
        } else {
            FragmentManager fragmentManager = activity.getFragmentManager();
            android.app.Fragment findFragmentByTag = fragmentManager.findFragmentByTag("AcceptResultFragment");
            r22 = findFragmentByTag instanceof z4.a ? (z4.a) findFragmentByTag : 0;
            if (r22 == 0) {
                r22 = new z4.a();
                fragmentManager.beginTransaction().add(r22, "AcceptResultFragment").commitAllowingStateLoss();
                fragmentManager.executePendingTransactions();
            }
        }
        return new c(r22);
    }

    public static final c with(Fragment fragment) {
        e.f(fragment, "fragment");
        INSTANCE.checkStatusFirst(fragment.getActivity());
        Fragment w8 = fragment.getChildFragmentManager().w("AcceptResultFragment");
        b bVar = w8 instanceof b ? (b) w8 : null;
        if (bVar == null) {
            t0 childFragmentManager = fragment.getChildFragmentManager();
            e.e(childFragmentManager, "getChildFragmentManager(...)");
            bVar = new b();
            a aVar = new a(childFragmentManager);
            aVar.e(0, bVar, "AcceptResultFragment", 1);
            if (!aVar.f2131g) {
                aVar.f2140p.t(aVar, true);
            } else {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
        }
        return new c(bVar);
    }

    public static final c with(android.app.Fragment fragment) {
        e.f(fragment, "fragment");
        INSTANCE.checkStatusFirst(fragment.getActivity());
        FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        android.app.Fragment findFragmentByTag = childFragmentManager.findFragmentByTag("AcceptResultFragment");
        z4.a aVar = findFragmentByTag instanceof z4.a ? (z4.a) findFragmentByTag : null;
        if (aVar == null) {
            aVar = new z4.a();
            childFragmentManager.beginTransaction().add(aVar, "AcceptResultFragment").commitAllowingStateLoss();
            childFragmentManager.executePendingTransactions();
        }
        return new c(aVar);
    }
}
