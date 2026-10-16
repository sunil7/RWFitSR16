package u;

import android.util.Log;
import androidx.camera.core.ImageCaptureException;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import t.r0;
import t.w;
import t.x;
import t.z0;

/* loaded from: classes.dex */
public final class e implements w {

    /* renamed from: b, reason: collision with root package name */
    public d f18663b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f18664c;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque f18662a = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    public boolean f18665d = false;

    public e(r0 r0Var) {
        y5.a();
        this.f18664c = new ArrayList();
    }

    @Override // t.w
    public final void a(x xVar) {
        a6.d().execute(new m5.a(this, 14));
    }

    public final void b() {
        y5.a();
        new ImageCaptureException(3, "Camera is closed.", null);
        ArrayDeque arrayDeque = this.f18662a;
        Iterator it = arrayDeque.iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.session.e.d(it);
        }
        arrayDeque.clear();
        ArrayList arrayList = new ArrayList(this.f18664c);
        if (arrayList.size() <= 0) {
            return;
        }
        r5.a.i(arrayList.get(0));
        throw null;
    }

    public final void c() {
        int q5;
        y5.a();
        Log.d("TakePictureManager", "Issue the next TakePictureRequest.");
        if (this.f18665d) {
            Log.d("TakePictureManager", "The class is paused.");
            return;
        }
        d dVar = this.f18663b;
        dVar.getClass();
        y5.a();
        c cVar = dVar.f18659b;
        cVar.getClass();
        y5.a();
        pd.f("The ImageReader is not initialized.", cVar.f18656a != null);
        z0 z0Var = cVar.f18656a;
        synchronized (z0Var.f18432a) {
            q5 = z0Var.f18435d.q() - z0Var.f18433b;
        }
        if (q5 == 0) {
            Log.d("TakePictureManager", "Too many acquire images. Close image to be able to process next.");
        } else {
            if (this.f18662a.poll() != null) {
                throw new ClassCastException();
            }
            Log.d("TakePictureManager", "No new request.");
        }
    }
}
