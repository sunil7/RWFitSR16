package w;

import java.util.concurrent.Executor;
import t4.l;

/* loaded from: classes.dex */
public final class a implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f19270b;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19271a;

    public /* synthetic */ a(int i3) {
        this.f19271a = i3;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f19271a) {
            case 0:
                runnable.run();
                break;
            case 1:
                i.a.a().b(runnable);
                break;
            case 2:
                i.a.a().f14329a.f14331b.execute(runnable);
                break;
            case 3:
                runnable.run();
                break;
            case 4:
                l.e().post(runnable);
                break;
            default:
                runnable.run();
                break;
        }
    }
}
