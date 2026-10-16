package pe;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.internal.mlkit_vision_common.n6;
import com.google.android.gms.internal.mlkit_vision_common.o6;
import java.io.File;

/* loaded from: classes2.dex */
public final class t implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    public static File f17587d;

    /* renamed from: a, reason: collision with root package name */
    public HandlerThread f17588a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f17589b;

    /* renamed from: c, reason: collision with root package name */
    public final te.d f17590c;

    public t(te.d dVar) {
        this.f17590c = dVar;
    }

    public static void a() {
        File b3 = b();
        if (b3.exists()) {
            o6.a(3, t.class, null, "delete marker file " + b3.delete(), new Object[0]);
        }
    }

    public static File b() {
        if (f17587d == null) {
            Context context = n6.f10047a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(context.getCacheDir());
            f17587d = new File(r5.a.f(sb2, File.separator, ".filedownloader_pause_all_marker.b"));
        }
        return f17587d;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        try {
            if (b().exists()) {
                try {
                    this.f17590c.w();
                } catch (RemoteException e) {
                    o6.a(6, this, e, "pause all failed", new Object[0]);
                }
            }
            this.f17589b.sendEmptyMessageDelayed(0, 1000L);
            return true;
        } finally {
            a();
        }
    }
}
