package ra;

import android.animation.TypeEvaluator;

/* loaded from: classes.dex */
public final class a implements TypeEvaluator {

    /* renamed from: b, reason: collision with root package name */
    public static final a f18102b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final d f18103a = new d();

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f2, Object obj, Object obj2) {
        d dVar = (d) obj;
        d dVar2 = (d) obj2;
        float f10 = dVar.f18106a;
        float f11 = 1.0f - f2;
        float f12 = (dVar2.f18106a * f2) + (f10 * f11);
        float f13 = dVar.f18107b;
        float f14 = (dVar2.f18107b * f2) + (f13 * f11);
        float f15 = dVar.f18108c;
        float f16 = (f2 * dVar2.f18108c) + (f11 * f15);
        d dVar3 = this.f18103a;
        dVar3.f18106a = f12;
        dVar3.f18107b = f14;
        dVar3.f18108c = f16;
        return dVar3;
    }
}
