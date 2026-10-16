package bb;

import android.graphics.Typeface;
import com.google.android.gms.internal.mlkit_vision_barcode.x0;

/* loaded from: classes.dex */
public final class c extends b1.b {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ x0 f3185h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ e f3186i;

    public c(e eVar, x0 x0Var) {
        this.f3186i = eVar;
        this.f3185h = x0Var;
    }

    @Override // b1.b
    public final void d(int i3) {
        this.f3186i.f3201m = true;
        this.f3185h.a(i3);
    }

    @Override // b1.b
    public final void e(Typeface typeface) {
        e eVar = this.f3186i;
        eVar.f3202n = Typeface.create(typeface, eVar.f3193d);
        eVar.f3201m = true;
        this.f3185h.b(eVar.f3202n, false);
    }
}
