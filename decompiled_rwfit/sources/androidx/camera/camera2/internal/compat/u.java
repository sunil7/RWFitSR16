package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.ArrayMap;
import com.example.test.utils.y;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final ef.i f1223a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayMap f1224b = new ArrayMap(4);

    public u(ef.i iVar) {
        this.f1223a = iVar;
    }

    public static u a(Context context, Handler handler) {
        int i3 = Build.VERSION.SDK_INT;
        return new u(i3 >= 30 ? new x(context, null) : i3 >= 29 ? new w(context, null) : i3 >= 28 ? new v(context, null) : new ef.i(context, new y(handler)));
    }

    public final n b(String str) {
        n nVar;
        synchronized (this.f1224b) {
            nVar = (n) this.f1224b.get(str);
            if (nVar == null) {
                try {
                    n nVar2 = new n(this.f1223a.t(str), str);
                    this.f1224b.put(str, nVar2);
                    nVar = nVar2;
                } catch (AssertionError e) {
                    throw new CameraAccessExceptionCompat(10002, e.getMessage(), e);
                }
            }
        }
        return nVar;
    }
}
