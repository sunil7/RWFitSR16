package androidx.media;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import androidx.appcompat.app.f;
import com.google.android.gms.internal.mlkit_vision_common.j6;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import m0.b;
import y1.a;
import y1.c;
import y1.d;

/* loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {

    /* renamed from: a, reason: collision with root package name */
    public c f2423a;

    /* renamed from: b, reason: collision with root package name */
    public final a f2424b = new a(this, "android.media.session.MediaController", -1, -1, null);

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f2425c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final b f2426d = new b();
    public final f e = new f(this);

    static {
        Log.isLoggable("MBServiceCompat", 3);
    }

    public abstract j6 a();

    public abstract void b();

    @Override // android.app.Service
    public final void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f2423a.f19923b.onBind(intent);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 28) {
            this.f2423a = new d(this);
        } else {
            this.f2423a = new c(this);
        }
        c cVar = this.f2423a;
        cVar.getClass();
        y1.b bVar = new y1.b(cVar, cVar.f19926f);
        cVar.f19923b = bVar;
        bVar.onCreate();
    }
}
