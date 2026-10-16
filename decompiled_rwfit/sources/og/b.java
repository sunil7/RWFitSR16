package og;

import android.view.View;
import androidx.recyclerview.widget.z1;

/* loaded from: classes2.dex */
public final class b implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z1 f16929a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f16930b;

    public b(e eVar, z1 z1Var) {
        this.f16930b = eVar;
        this.f16929a = z1Var;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        ((o4.e) this.f16930b.f16941h).i(this.f16929a.getAdapterPosition(), view);
        return true;
    }
}
