package y1;

import android.os.IBinder;
import android.os.Messenger;
import androidx.media.MediaBrowserServiceCompat;

/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19932a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ mc.g f19933b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ xg.b f19934c;

    public /* synthetic */ f(xg.b bVar, mc.g gVar, int i3) {
        this.f19932a = i3;
        this.f19934c = bVar;
        this.f19933b = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f19932a) {
            case 0:
                a aVar = (a) ((MediaBrowserServiceCompat) this.f19934c.f19825a).f2426d.remove(((Messenger) this.f19933b.f16022b).getBinder());
                if (aVar != null) {
                    ((Messenger) aVar.f19917d.f16022b).getBinder().unlinkToDeath(aVar, 0);
                    break;
                }
                break;
            default:
                IBinder binder = ((Messenger) this.f19933b.f16022b).getBinder();
                a aVar2 = (a) ((MediaBrowserServiceCompat) this.f19934c.f19825a).f2426d.remove(binder);
                if (aVar2 != null) {
                    binder.unlinkToDeath(aVar2, 0);
                    break;
                }
                break;
        }
    }
}
