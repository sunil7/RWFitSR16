package i;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.mlkit_vision_barcode.kc;
import ef.e;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class b extends kc {

    /* renamed from: a, reason: collision with root package name */
    public final Object f14330a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f14331b = Executors.newFixedThreadPool(4, new e(1));

    /* renamed from: c, reason: collision with root package name */
    public volatile Handler f14332c;

    public static Handler a(Looper looper) {
        Handler createAsync;
        if (Build.VERSION.SDK_INT >= 28) {
            createAsync = Handler.createAsync(looper);
            return createAsync;
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }
}
