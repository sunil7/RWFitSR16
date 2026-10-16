package androidx.emoji2.text;

import com.example.test.utils.y;
import com.google.android.gms.internal.mlkit_vision_barcode.q0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class e extends q0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f2025a;

    public e(f fVar) {
        this.f2025a = fVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.q0
    public final void a(Throwable th2) {
        this.f2025a.f2026a.d(th2);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.q0
    public final void b(v2.h hVar) {
        f fVar = this.f2025a;
        fVar.f2028c = hVar;
        fVar.f2027b = new y(fVar.f2028c, new ec.a(2), fVar.f2026a.f2043h);
        k kVar = fVar.f2026a;
        kVar.getClass();
        ArrayList arrayList = new ArrayList();
        kVar.f2037a.writeLock().lock();
        try {
            kVar.f2039c = 1;
            arrayList.addAll(kVar.f2038b);
            kVar.f2038b.clear();
            kVar.f2037a.writeLock().unlock();
            kVar.f2040d.post(new i(arrayList, kVar.f2039c, (Throwable) null));
        } catch (Throwable th2) {
            kVar.f2037a.writeLock().unlock();
            throw th2;
        }
    }
}
