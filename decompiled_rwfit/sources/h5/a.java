package h5;

import a2.c;
import a2.k;
import a2.l;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.z0;
import androidx.recyclerview.widget.z1;
import com.dh.imagepick.preview.e;
import com.example.test.ui.device.activity.i0;

/* loaded from: classes.dex */
public final class a extends z0 {

    /* renamed from: a, reason: collision with root package name */
    public final c f14260a;

    /* renamed from: b, reason: collision with root package name */
    public e f14261b;

    /* renamed from: c, reason: collision with root package name */
    public final i0 f14262c;

    public a(long j4) {
        l lVar = new l(this);
        c cVar = new c(this);
        this.f14260a = cVar;
        cVar.f16c.add(lVar);
        this.f14262c = new i0(this, 21);
    }

    public final Object getItem(int i3) {
        c cVar = this.f14260a;
        k kVar = cVar.e;
        if (kVar != null) {
            kVar.i(i3);
            return cVar.e.get(i3);
        }
        k kVar2 = cVar.f18f;
        if (kVar2 != null) {
            return kVar2.get(i3);
        }
        throw new IndexOutOfBoundsException("Item count is zero, getItem() call is invalid");
    }

    @Override // androidx.recyclerview.widget.z0
    public final int getItemCount() {
        c cVar = this.f14260a;
        k kVar = cVar.e;
        if (kVar != null) {
            return kVar.f55d.size();
        }
        k kVar2 = cVar.f18f;
        if (kVar2 == null) {
            return 0;
        }
        return kVar2.f55d.size();
    }

    @Override // androidx.recyclerview.widget.z0
    public final long getItemId(int i3) {
        try {
            if (getItem(i3) == null) {
                return -1L;
            }
            throw new ClassCastException();
        } catch (Exception unused) {
            return -1L;
        }
    }

    @Override // androidx.recyclerview.widget.z0
    public final int getItemViewType(int i3) {
        try {
            if (getItem(i3) == null) {
                return -1;
            }
            throw new ClassCastException();
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // androidx.recyclerview.widget.z0
    public final void onBindViewHolder(z1 z1Var, int i3) {
        Log.i("viewer", "onBindViewHolder " + i3);
        if (getItem(i3) != null) {
            throw new ClassCastException();
        }
        if ((z1Var instanceof k5.a) || (z1Var instanceof k5.b)) {
            return;
        }
        boolean z5 = z1Var instanceof k5.e;
    }

    @Override // androidx.recyclerview.widget.z0
    public final z1 onCreateViewHolder(ViewGroup parent, int i3) {
        kotlin.jvm.internal.e.f(parent, "parent");
        i0 i0Var = this.f14262c;
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? new k5.c(new View(parent.getContext())) : new k5.e(parent, i0Var) : new k5.b(parent, i0Var) : new k5.a(parent, i0Var);
    }
}
