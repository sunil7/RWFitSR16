package m4;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.t0;
import com.example.test.ui.device.activity.i0;
import java.util.HashSet;

/* loaded from: classes.dex */
public class l extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public final a f15963a;

    /* renamed from: b, reason: collision with root package name */
    public final i0 f15964b;

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f15965c;

    /* renamed from: d, reason: collision with root package name */
    public l f15966d;
    public com.bumptech.glide.j e;

    public l() {
        a aVar = new a();
        this.f15964b = new i0(this, 28);
        this.f15965c = new HashSet();
        this.f15963a = aVar;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        super.onAttach(context);
        Fragment fragment = this;
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        t0 fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
                return;
            }
            return;
        }
        try {
            Context context2 = getContext();
            l lVar = this.f15966d;
            if (lVar != null) {
                lVar.f15965c.remove(this);
                this.f15966d = null;
            }
            l e = com.bumptech.glide.b.b(context2).f6912f.e(fragmentManager);
            this.f15966d = e;
            if (equals(e)) {
                return;
            }
            this.f15966d.f15965c.add(this);
        } catch (IllegalStateException e10) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root", e10);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f15963a.a();
        l lVar = this.f15966d;
        if (lVar != null) {
            lVar.f15965c.remove(this);
            this.f15966d = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        l lVar = this.f15966d;
        if (lVar != null) {
            lVar.f15965c.remove(this);
            this.f15966d = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f15963a.c();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f15963a.d();
    }

    @Override // androidx.fragment.app.Fragment
    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("{parent=");
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            parentFragment = null;
        }
        sb2.append(parentFragment);
        sb2.append("}");
        return sb2.toString();
    }
}
