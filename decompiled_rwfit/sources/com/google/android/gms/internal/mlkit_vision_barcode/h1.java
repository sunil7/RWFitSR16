package com.google.android.gms.internal.mlkit_vision_barcode;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.dh.imagepick.preview.ImageViewerDialogFragment;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class h1 {
    public static androidx.lifecycle.m0 a(View view) {
        androidx.fragment.app.u0 C0;
        List e;
        Object obj;
        kotlin.jvm.internal.e.f(view, "view");
        Activity b3 = g1.b(view.getContext());
        FragmentActivity fragmentActivity = b3 instanceof FragmentActivity ? (FragmentActivity) b3 : null;
        if (fragmentActivity != null && (C0 = fragmentActivity.C0()) != null && (e = C0.f2272c.e()) != null) {
            Iterator it = e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((Fragment) obj) instanceof ImageViewerDialogFragment) {
                    break;
                }
            }
            Fragment fragment = (Fragment) obj;
            if (fragment != null) {
                return new de.o(fragment).q(com.dh.imagepick.preview.g.class);
            }
        }
        return null;
    }
}
