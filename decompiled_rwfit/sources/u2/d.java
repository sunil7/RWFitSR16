package u2;

import androidx.work.NetworkType;
import o2.m;
import x2.h;

/* loaded from: classes.dex */
public final class d extends b {
    static {
        m.i("NetworkNotRoamingCtrlr");
    }

    @Override // u2.b
    public final boolean a(h hVar) {
        return hVar.f19757j.f16699a == NetworkType.NOT_ROAMING;
    }

    @Override // u2.b
    public final boolean b(Object obj) {
        t2.a aVar = (t2.a) obj;
        return (aVar.f18486a && aVar.f18489d) ? false : true;
    }
}
