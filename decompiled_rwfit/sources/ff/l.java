package ff;

import android.view.SurfaceHolder;
import com.google.android.gms.internal.mlkit_vision_common.ea;
import com.google.android.gms.internal.mlkit_vision_common.fa;
import com.google.android.gms.internal.mlkit_vision_common.ma;
import com.google.android.gms.internal.mlkit_vision_common.na;
import com.google.mlkit.vision.barcode.internal.zzh;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class l implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13624a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13625b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f13626c;

    public /* synthetic */ l(zzh zzhVar, nc.a aVar) {
        this.f13625b = zzhVar;
        this.f13626c = aVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        fa faVar;
        Object obj = this.f13625b;
        Object obj2 = this.f13626c;
        switch (this.f13624a) {
            case 0:
                wf.b bVar = ((n) obj2).f13652i;
                ((SurfaceHolder) obj).setFixedSize(bVar.f19627a, bVar.f19628b);
                return null;
            default:
                nc.a aVar = (nc.a) obj2;
                zzh zzhVar = (zzh) obj;
                zzhVar.getClass();
                HashMap hashMap = fa.f9912f;
                na.b();
                int i3 = ma.f10040a;
                na.b();
                if (Boolean.parseBoolean("")) {
                    HashMap hashMap2 = fa.f9912f;
                    if (hashMap2.get("detectorTaskWithResource#run") == null) {
                        hashMap2.put("detectorTaskWithResource#run", new fa("detectorTaskWithResource#run"));
                    }
                    faVar = (fa) hashMap2.get("detectorTaskWithResource#run");
                } else {
                    faVar = ea.f9903g;
                }
                faVar.b();
                try {
                    List b3 = zzhVar.f11206b.b(aVar);
                    faVar.close();
                    return b3;
                } catch (Throwable th2) {
                    try {
                        faVar.close();
                    } catch (Throwable th3) {
                        try {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th2, th3);
                        } catch (Exception unused) {
                        }
                    }
                    throw th2;
                }
        }
    }

    public l(n nVar, Object obj) {
        this.f13626c = nVar;
        this.f13625b = obj;
    }
}
