package q9;

import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes.dex */
public final class t extends k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f17840g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(com.google.android.gms.common.internal.a aVar, int i3) {
        super(aVar, i3, null);
        this.f17840g = aVar;
    }

    @Override // q9.k
    public final void a(ConnectionResult connectionResult) {
        com.google.android.gms.common.internal.a aVar = this.f17840g;
        aVar.getClass();
        aVar.f9120i.a(connectionResult);
        System.currentTimeMillis();
    }

    @Override // q9.k
    public final boolean b() {
        this.f17840g.f9120i.a(ConnectionResult.RESULT_SUCCESS);
        return true;
    }
}
