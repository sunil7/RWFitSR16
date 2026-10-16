package g4;

import android.os.ParcelFileDescriptor;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class e implements x3.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13818a;

    /* renamed from: b, reason: collision with root package name */
    public final o f13819b;

    public /* synthetic */ e(o oVar, int i3) {
        this.f13818a = i3;
        this.f13819b = oVar;
    }

    @Override // x3.g
    public final boolean a(Object obj, x3.f fVar) {
        switch (this.f13818a) {
            case 0:
                break;
            default:
                break;
        }
        return true;
    }

    @Override // x3.g
    public final z3.s b(Object obj, int i3, int i10, x3.f fVar) {
        switch (this.f13818a) {
            case 0:
                AtomicReference atomicReference = t4.b.f18505a;
                t4.a aVar = new t4.a((ByteBuffer) obj);
                gc.b bVar = o.f13839j;
                o oVar = this.f13819b;
                return oVar.a(new de.o(oVar.f13843c, aVar, oVar.f13844d), i3, i10, fVar, bVar);
            default:
                o oVar2 = this.f13819b;
                return oVar2.a(new de.o((ParcelFileDescriptor) obj, oVar2.f13844d, oVar2.f13843c), i3, i10, fVar, o.f13839j);
        }
    }
}
