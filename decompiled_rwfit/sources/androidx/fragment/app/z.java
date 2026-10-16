package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;

/* loaded from: classes.dex */
public final class z implements e2.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f2324a;

    public z(FragmentActivity fragmentActivity) {
        this.f2324a = fragmentActivity;
    }

    @Override // e2.c
    public final Bundle a() {
        Bundle bundle = new Bundle();
        FragmentActivity fragmentActivity = this.f2324a;
        while (FragmentActivity.D0(fragmentActivity.C0(), Lifecycle$State.CREATED)) {
        }
        fragmentActivity.f2091t.e(Lifecycle$Event.ON_STOP);
        Parcelable L = ((b0) fragmentActivity.f2090s.f2264b).f2184d.L();
        if (L != null) {
            bundle.putParcelable("android:support:fragments", L);
        }
        return bundle;
    }
}
