package com.dh.imagepick.preview.utils;

import android.R;
import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.s;
import com.google.android.gms.internal.mlkit_vision_barcode.g1;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final m0.b f7147a = new m0.b();

    public static final void a(Collection collection) {
        m0.b bVar = f7147a;
        if (collection == null) {
            return;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if ((fragment != null ? fragment.getView() : null) != null) {
                bVar.put(fragment.getView(), fragment);
                a(fragment.getChildFragmentManager().f2272c.e());
            }
        }
    }

    public static final s b(View view) {
        s viewLifecycleOwner;
        Activity b3 = g1.b(view.getContext());
        FragmentActivity fragmentActivity = b3 instanceof FragmentActivity ? (FragmentActivity) b3 : null;
        if (fragmentActivity == null) {
            return null;
        }
        m0.b bVar = f7147a;
        bVar.clear();
        a(fragmentActivity.C0().f2272c.e());
        View findViewById = fragmentActivity.findViewById(R.id.content);
        Fragment fragment = null;
        while (!view.equals(findViewById) && (fragment = (Fragment) bVar.getOrDefault(view, null)) == null && (view.getParent() instanceof View)) {
            Object parent = view.getParent();
            kotlin.jvm.internal.e.d(parent, "null cannot be cast to non-null type android.view.View");
            view = (View) parent;
        }
        bVar.clear();
        return (fragment == null || (viewLifecycleOwner = fragment.getViewLifecycleOwner()) == null) ? fragmentActivity : viewLifecycleOwner;
    }
}
