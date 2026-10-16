package androidx.core.content;

import a1.k;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public final k f1913a = new k(this);

    public abstract void a();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f1913a;
    }
}
