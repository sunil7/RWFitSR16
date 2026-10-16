package x;

import androidx.camera.core.impl.i0;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import pe.o;

/* loaded from: classes.dex */
public abstract class i {
    public static Object a(ob.a aVar) {
        pd.f("Future was expected to be done, " + aVar, aVar.isDone());
        return b(aVar);
    }

    public static Object b(Future future) {
        Object obj;
        boolean z5 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z5 = true;
            } catch (Throwable th2) {
                if (z5) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public static k c(Object obj) {
        return obj == null ? k.f19707c : new k(obj, 0);
    }

    public static ob.a d(ob.a aVar) {
        aVar.getClass();
        return aVar.isDone() ? aVar : ve.a(new g(aVar, 1));
    }

    public static void e(boolean z5, ob.a aVar, androidx.concurrent.futures.b bVar, w.a aVar2) {
        aVar.getClass();
        bVar.getClass();
        aVar2.getClass();
        aVar.a(new h(0, aVar, new i0(bVar, 1)), aVar2);
        if (z5) {
            o oVar = new o(aVar, 11);
            w.a a3 = a6.a();
            n0.j jVar = bVar.f1607c;
            if (jVar != null) {
                jVar.a(oVar, a3);
            }
        }
    }

    public static b f(ob.a aVar, a aVar2, Executor executor) {
        b bVar = new b(aVar2, aVar);
        aVar.a(bVar, executor);
        return bVar;
    }
}
