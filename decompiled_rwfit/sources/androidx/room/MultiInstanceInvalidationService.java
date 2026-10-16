package androidx.room;

import a1.k;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import b2.f;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MultiInstanceInvalidationService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public int f2818a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f2819b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final f f2820c = new f(this);

    /* renamed from: d, reason: collision with root package name */
    public final k f2821d = new k(this);

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f2821d;
    }
}
