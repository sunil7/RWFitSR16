package oc;

import android.util.Log;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import pb.p;

/* loaded from: classes.dex */
public final class c implements ia.c, pb.b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ c f16914a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ c f16915b = new c();

    @Override // pb.b
    public Object i(p pVar) {
        Set c9 = pVar.c(b.class);
        c cVar = new c();
        new HashMap();
        new HashMap();
        Iterator it = c9.iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.session.e.d(it);
        }
        return cVar;
    }

    @Override // ia.c
    public void w(Exception exc) {
        o4.c cVar = MobileVisionBase.e;
        if (Log.isLoggable((String) cVar.f16732a, 6)) {
            Log.e("MobileVisionBase", cVar.r("Error preloading model resource"), exc);
        }
    }
}
