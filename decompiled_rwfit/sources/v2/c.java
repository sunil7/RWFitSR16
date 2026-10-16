package v2;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.appcompat.app.y;
import de.o;
import o2.m;

/* loaded from: classes.dex */
public abstract class c extends d {

    /* renamed from: h, reason: collision with root package name */
    public static final String f19132h = m.i("BrdcstRcvrCnstrntTrckr");

    /* renamed from: g, reason: collision with root package name */
    public final y f19133g;

    public c(Context context, o oVar) {
        super(context, oVar);
        this.f19133g = new y(this, 7);
    }

    @Override // v2.d
    public final void d() {
        m.g().d(f19132h, getClass().getSimpleName().concat(": registering receiver"), new Throwable[0]);
        this.f19136b.registerReceiver(this.f19133g, f());
    }

    @Override // v2.d
    public final void e() {
        m.g().d(f19132h, getClass().getSimpleName().concat(": unregistering receiver"), new Throwable[0]);
        this.f19136b.unregisterReceiver(this.f19133g);
    }

    public abstract IntentFilter f();

    public abstract void g(Intent intent);
}
