package g0;

import androidx.camera.core.impl.SessionConfig$SessionError;
import androidx.camera.core.impl.a2;
import androidx.camera.core.impl.p1;
import androidx.camera.core.impl.s1;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import java.util.Iterator;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements p1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f13747a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f13748b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f13749c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a2 f13750d;
    public final /* synthetic */ androidx.camera.core.impl.h e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ androidx.camera.core.impl.h f13751f;

    public /* synthetic */ b(c cVar, String str, String str2, a2 a2Var, androidx.camera.core.impl.h hVar, androidx.camera.core.impl.h hVar2) {
        this.f13747a = cVar;
        this.f13748b = str;
        this.f13749c = str2;
        this.f13750d = a2Var;
        this.e = hVar;
        this.f13751f = hVar2;
    }

    @Override // androidx.camera.core.impl.p1
    public final void a(s1 s1Var, SessionConfig$SessionError sessionConfig$SessionError) {
        c cVar = this.f13747a;
        if (cVar.b() == null) {
            return;
        }
        cVar.C();
        cVar.B(cVar.D(this.f13748b, this.f13749c, this.f13750d, this.e, this.f13751f));
        cVar.o();
        h hVar = cVar.f13753p;
        hVar.getClass();
        y5.a();
        Iterator it = hVar.f13773a.iterator();
        while (it.hasNext()) {
            hVar.i((androidx.camera.core.f) it.next());
        }
    }
}
