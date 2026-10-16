package u2;

import android.os.Build;
import androidx.work.NetworkType;
import x2.h;

/* loaded from: classes.dex */
public final class a extends b {
    public final /* synthetic */ int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(v2.d dVar, int i3) {
        super(dVar);
        this.e = i3;
    }

    @Override // u2.b
    public final boolean a(h hVar) {
        switch (this.e) {
            case 0:
                return hVar.f19757j.f16700b;
            case 1:
                return hVar.f19757j.f16702d;
            case 2:
                return hVar.f19757j.f16699a == NetworkType.CONNECTED;
            case 3:
                NetworkType networkType = hVar.f19757j.f16699a;
                return networkType == NetworkType.UNMETERED || (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED);
            default:
                return hVar.f19757j.e;
        }
    }

    @Override // u2.b
    public final boolean b(Object obj) {
        switch (this.e) {
            case 2:
                t2.a aVar = (t2.a) obj;
                if (!aVar.f18486a || !aVar.f18487b) {
                }
                break;
            case 3:
                t2.a aVar2 = (t2.a) obj;
                if (!aVar2.f18486a || aVar2.f18488c) {
                }
                break;
        }
        return !((Boolean) obj).booleanValue();
    }
}
