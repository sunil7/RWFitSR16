package n;

import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import com.google.android.gms.internal.mlkit_vision_barcode.ne;
import java.util.ArrayList;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final /* synthetic */ class j implements n0.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16233a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ androidx.camera.camera2.internal.i f16234b;

    public /* synthetic */ j(androidx.camera.camera2.internal.i iVar, int i3) {
        this.f16233a = i3;
        this.f16234b = iVar;
    }

    @Override // n0.g
    public Object b(androidx.concurrent.futures.b bVar) {
        switch (this.f16233a) {
            case 0:
                androidx.camera.camera2.internal.i iVar = this.f16234b;
                iVar.getClass();
                try {
                    ArrayList arrayList = new ArrayList(iVar.f1238a.p().b().f1487c);
                    arrayList.add((com.example.test.ui.view.a) iVar.f1260y.f16178f);
                    arrayList.add(new androidx.camera.camera2.internal.compat.p(2, iVar, bVar));
                    iVar.f1239b.f1223a.H(iVar.f1246j.f16278a, iVar.f1240c, ne.a(arrayList));
                    return "configAndCloseTask";
                } catch (CameraAccessExceptionCompat | SecurityException e) {
                    iVar.s("Unable to open camera for configAndClose: " + e.getMessage(), e);
                    bVar.b(e);
                    return "configAndCloseTask";
                }
            default:
                androidx.camera.camera2.internal.i iVar2 = this.f16234b;
                iVar2.getClass();
                try {
                    iVar2.f1240c.execute(new androidx.appcompat.app.i0(26, iVar2, bVar));
                    return "isMeteringRepeatingAttached";
                } catch (RejectedExecutionException unused) {
                    bVar.b(new RuntimeException("Unable to check if MeteringRepeating is attached. Camera executor shut down."));
                    return "isMeteringRepeatingAttached";
                }
        }
    }
}
