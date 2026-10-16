package fb;

import android.os.Handler;
import android.os.Looper;
import de.j;
import pb.p;

/* loaded from: classes.dex */
public final class d implements pb.b {

    /* renamed from: b, reason: collision with root package name */
    public static d f13555b;

    /* renamed from: a, reason: collision with root package name */
    public final Object f13556a;

    public d(Object obj) {
        this.f13556a = obj;
    }

    @Override // pb.b
    public Object i(p pVar) {
        return this.f13556a;
    }

    public d() {
        this.f13556a = new Object();
        new Handler(Looper.getMainLooper(), new j(this, 1));
    }
}
