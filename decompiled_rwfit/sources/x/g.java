package x;

import com.google.android.gms.internal.mlkit_vision_common.a6;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements n0.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19702a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ob.a f19703b;

    public /* synthetic */ g(ob.a aVar, int i3) {
        this.f19702a = i3;
        this.f19703b = aVar;
    }

    @Override // n0.g
    public final Object b(androidx.concurrent.futures.b bVar) {
        switch (this.f19702a) {
            case 0:
                m5.a aVar = new m5.a(bVar, 16);
                w.a a3 = a6.a();
                ob.a aVar2 = this.f19703b;
                aVar2.a(aVar, a3);
                return "transformVoidFuture [" + aVar2 + "]";
            default:
                w.a a10 = a6.a();
                ob.a aVar3 = this.f19703b;
                i.e(false, aVar3, bVar, a10);
                return "nonCancellationPropagating[" + aVar3 + "]";
        }
    }
}
