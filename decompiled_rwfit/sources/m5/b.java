package m5;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15970a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f15971b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f15972c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f15973d;

    public /* synthetic */ b(c cVar, Context context, c cVar2, int i3) {
        this.f15970a = i3;
        this.f15971b = cVar;
        this.f15972c = context;
        this.f15973d = cVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f15970a) {
            case 0:
                this.f15972c.sendBroadcast(new Intent().setAction(com.dh.keeplive.a.e));
                this.f15973d.getClass();
                this.f15971b.f15977d = false;
                break;
            default:
                this.f15972c.sendBroadcast(new Intent().setAction(com.dh.keeplive.a.f7203f));
                this.f15973d.getClass();
                this.f15971b.f15977d = false;
                break;
        }
    }
}
