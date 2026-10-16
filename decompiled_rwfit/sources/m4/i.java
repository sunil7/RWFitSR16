package m4;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import com.example.test.ui.device.activity.f0;
import java.util.HashSet;

/* loaded from: classes.dex */
public class i extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    public final a f15953a;

    /* renamed from: b, reason: collision with root package name */
    public final f0 f15954b;

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f15955c;

    /* renamed from: d, reason: collision with root package name */
    public com.bumptech.glide.j f15956d;
    public i e;

    public i() {
        a aVar = new a();
        this.f15954b = new f0(this, 25);
        this.f15955c = new HashSet();
        this.f15953a = aVar;
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            i iVar = this.e;
            if (iVar != null) {
                iVar.f15955c.remove(this);
                this.e = null;
            }
            j jVar = com.bumptech.glide.b.b(activity).f6912f;
            jVar.getClass();
            i d5 = jVar.d(activity.getFragmentManager());
            this.e = d5;
            if (equals(d5)) {
                return;
            }
            this.e.f15955c.add(this);
        } catch (IllegalStateException e) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f15953a.a();
        i iVar = this.e;
        if (iVar != null) {
            iVar.f15955c.remove(this);
            this.e = null;
        }
    }

    @Override // android.app.Fragment
    public final void onDetach() {
        super.onDetach();
        i iVar = this.e;
        if (iVar != null) {
            iVar.f15955c.remove(this);
            this.e = null;
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f15953a.c();
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f15953a.d();
    }

    @Override // android.app.Fragment
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
