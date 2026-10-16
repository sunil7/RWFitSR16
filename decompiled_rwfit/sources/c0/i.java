package c0;

import com.google.android.gms.internal.mlkit_vision_common.a6;

/* loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3315a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f3316b;

    public /* synthetic */ i(n nVar, int i3) {
        this.f3315a = i3;
        this.f3316b = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3315a) {
            case 0:
                n nVar = this.f3316b;
                nVar.getClass();
                a6.d().execute(new i(nVar, 1));
                break;
            default:
                n nVar2 = this.f3316b;
                if (!nVar2.f3341n) {
                    nVar2.d();
                    break;
                }
                break;
        }
    }
}
