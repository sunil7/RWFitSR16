package o;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n.t;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final p f16636a;

    public q(ArrayList arrayList, androidx.camera.core.impl.utils.executor.b bVar, t tVar) {
        if (Build.VERSION.SDK_INT < 28) {
            this.f16636a = new o(arrayList, bVar, tVar);
        } else {
            this.f16636a = new n(arrayList, bVar, tVar);
        }
    }

    public static ArrayList a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((OutputConfiguration) ((h) it.next()).f16623a.a());
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        return this.f16636a.equals(((q) obj).f16636a);
    }

    public final int hashCode() {
        return this.f16636a.hashCode();
    }
}
