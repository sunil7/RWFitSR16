package androidx.core.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.example.test.ui.view.k;
import java.util.HashMap;
import y0.i;

@Deprecated
/* loaded from: classes.dex */
public abstract class JobIntentService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public i f1906a;

    /* renamed from: b, reason: collision with root package name */
    public k f1907b;

    static {
        new HashMap();
    }

    public abstract void a();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        i iVar = this.f1906a;
        if (iVar != null) {
            return iVar.getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f1906a = new i(this);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i10) {
        return 2;
    }
}
