package gc;

import android.content.Context;
import java.util.UUID;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    public static final pb.a f14037b;

    /* renamed from: a, reason: collision with root package name */
    public final Context f14038a;

    static {
        f8.f a3 = pb.a.a(h.class);
        a3.a(new pb.i(1, 0, e.class));
        a3.a(new pb.i(1, 0, Context.class));
        a3.e = new hc.a(12);
        f14037b = a3.b();
    }

    public h(Context context) {
        this.f14038a = context;
    }

    public final synchronized String a() {
        String string = this.f14038a.getSharedPreferences("com.google.mlkit.internal", 0).getString("ml_sdk_instance_id", null);
        if (string != null) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        this.f14038a.getSharedPreferences("com.google.mlkit.internal", 0).edit().putString("ml_sdk_instance_id", uuid).apply();
        return uuid;
    }
}
