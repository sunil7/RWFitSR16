package q9;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public Boolean f17823a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f17824b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f17825c;

    /* renamed from: d, reason: collision with root package name */
    public final int f17826d;
    public final Bundle e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f17827f;

    public k(com.google.android.gms.common.internal.a aVar, int i3, Bundle bundle) {
        this.f17827f = aVar;
        Boolean bool = Boolean.TRUE;
        this.f17825c = aVar;
        this.f17823a = bool;
        this.f17824b = false;
        this.f17826d = i3;
        this.e = bundle;
    }

    public abstract void a(ConnectionResult connectionResult);

    public abstract boolean b();

    public final void c() {
        synchronized (this) {
            this.f17823a = null;
        }
        synchronized (this.f17825c.f9122k) {
            this.f17825c.f9122k.remove(this);
        }
    }
}
