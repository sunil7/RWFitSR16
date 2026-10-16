package e4;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.google.android.gms.internal.mlkit_vision_common.k6;
import d4.p;
import d4.q;
import x3.f;

/* loaded from: classes.dex */
public final class d implements q {

    /* renamed from: a, reason: collision with root package name */
    public final Context f12459a;

    /* renamed from: b, reason: collision with root package name */
    public final q f12460b;

    /* renamed from: c, reason: collision with root package name */
    public final q f12461c;

    /* renamed from: d, reason: collision with root package name */
    public final Class f12462d;

    public d(Context context, q qVar, q qVar2, Class cls) {
        this.f12459a = context.getApplicationContext();
        this.f12460b = qVar;
        this.f12461c = qVar2;
        this.f12462d = cls;
    }

    @Override // d4.q
    public final p a(Object obj, int i3, int i10, f fVar) {
        Uri uri = (Uri) obj;
        return new p(new s4.d(uri), new c(this.f12459a, this.f12460b, this.f12461c, uri, i3, i10, fVar, this.f12462d));
    }

    @Override // d4.q
    public final boolean b(Object obj) {
        return Build.VERSION.SDK_INT >= 29 && k6.a((Uri) obj);
    }
}
