package u;

import androidx.camera.core.impl.n0;
import com.example.test.utils.s0;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import java.util.Objects;
import n.y0;
import t.w;
import t.z0;
import x.i;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final n0 f18658a;

    /* renamed from: b, reason: collision with root package name */
    public final c f18659b;

    /* renamed from: c, reason: collision with root package name */
    public final s0 f18660c;

    /* renamed from: d, reason: collision with root package name */
    public final a f18661d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0170  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(androidx.camera.core.impl.n0 r19, android.util.Size r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.d.<init>(androidx.camera.core.impl.n0, android.util.Size, boolean):void");
    }

    public final void a() {
        y5.a();
        c cVar = this.f18659b;
        cVar.getClass();
        y5.a();
        a aVar = cVar.f18657b;
        Objects.requireNonNull(aVar);
        z0 z0Var = cVar.f18656a;
        Objects.requireNonNull(z0Var);
        androidx.camera.core.impl.s0 s0Var = aVar.f18649a;
        Objects.requireNonNull(s0Var);
        s0Var.a();
        androidx.camera.core.impl.s0 s0Var2 = aVar.f18649a;
        Objects.requireNonNull(s0Var2);
        i.d(s0Var2.e).a(new y0(z0Var, 1), a6.d());
        androidx.camera.core.impl.s0 s0Var3 = aVar.f18650b;
        if (s0Var3 != null) {
            s0Var3.a();
            i.d(aVar.f18650b.e).a(new y0(null, 2), a6.d());
        }
        this.f18660c.getClass();
    }

    public void setOnImageCloseListener(w wVar) {
        y5.a();
        this.f18659b.setOnImageCloseListener(wVar);
    }
}
