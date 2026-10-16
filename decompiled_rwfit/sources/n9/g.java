package n9;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class g extends c5.b {

    /* renamed from: b, reason: collision with root package name */
    public final Context f16448b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f16449c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(b bVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper(), 2);
        this.f16449c = bVar;
        this.f16448b = context.getApplicationContext();
    }

    @Override // c5.b, android.os.Handler
    public final void handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i3);
            return;
        }
        int i10 = c.f16439a;
        b bVar = this.f16449c;
        Context context = this.f16448b;
        int c9 = bVar.c(context, i10);
        AtomicBoolean atomicBoolean = d.f16441a;
        if (c9 == 1 || c9 == 2 || c9 == 3 || c9 == 9) {
            Intent b3 = bVar.b(context, c9, "n");
            bVar.g(context, c9, b3 == null ? null : PendingIntent.getActivity(context, 0, b3, 201326592));
        }
    }
}
