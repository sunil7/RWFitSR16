package o2;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final String f16726a = m.i("WorkerFactory");

    public static ListenableWorker a(Context context, String str, WorkerParameters workerParameters) {
        Class cls;
        String str2 = f16726a;
        ListenableWorker listenableWorker = null;
        try {
            cls = Class.forName(str).asSubclass(ListenableWorker.class);
        } catch (Throwable th2) {
            m.g().f(str2, l0.n("Invalid class: ", str), th2);
            cls = null;
        }
        if (cls != null) {
            try {
                listenableWorker = (ListenableWorker) cls.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
            } catch (Throwable th3) {
                m.g().f(str2, l0.n("Could not instantiate ", str), th3);
            }
        }
        if (listenableWorker == null || !listenableWorker.f2995d) {
            return listenableWorker;
        }
        throw new IllegalStateException(l0.q("WorkerFactory (", v.class.getName(), ") returned an instance of a ListenableWorker (", str, ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker."));
    }
}
