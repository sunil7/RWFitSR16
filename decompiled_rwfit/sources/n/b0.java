package n;

import java.util.concurrent.ScheduledFuture;

/* loaded from: classes.dex */
public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16143a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d0 f16144b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f16145c;

    public /* synthetic */ b0(d0 d0Var, long j4, int i3) {
        this.f16143a = i3;
        this.f16144b = d0Var;
        this.f16145c = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16143a) {
            case 0:
                d0 d0Var = this.f16144b;
                d0Var.getClass();
                d0Var.f16152b.execute(new b0(d0Var, this.f16145c, 3));
                break;
            case 1:
                d0 d0Var2 = this.f16144b;
                d0Var2.getClass();
                d0Var2.f16152b.execute(new b0(d0Var2, this.f16145c, 2));
                break;
            case 2:
                d0 d0Var3 = this.f16144b;
                if (this.f16145c == d0Var3.f16160k) {
                    d0Var3.a();
                    break;
                }
                break;
            default:
                d0 d0Var4 = this.f16144b;
                if (this.f16145c == d0Var4.f16160k) {
                    ScheduledFuture scheduledFuture = d0Var4.f16159j;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(true);
                        d0Var4.f16159j = null;
                    }
                    androidx.concurrent.futures.b bVar = d0Var4.r;
                    if (bVar != null) {
                        bVar.a(new t.r0());
                        d0Var4.r = null;
                        break;
                    }
                }
                break;
        }
    }
}
