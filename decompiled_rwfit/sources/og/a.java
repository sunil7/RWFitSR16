package og;

import android.view.View;
import androidx.recyclerview.widget.z1;

/* loaded from: classes2.dex */
public final class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z1 f16927a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f16928b;

    public a(e eVar, z1 z1Var) {
        this.f16928b = eVar;
        this.f16927a = z1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ((o4.c) this.f16928b.f16940g).k(this.f16927a.getAdapterPosition(), view);
    }
}
