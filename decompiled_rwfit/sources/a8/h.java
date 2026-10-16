package a8;

import com.google.android.datatransport.Priority;
import de.o;
import java.util.HashMap;
import n.g0;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final b f133a;

    /* renamed from: b, reason: collision with root package name */
    public final x7.b f134b;

    /* renamed from: c, reason: collision with root package name */
    public final x7.c f135c;

    /* renamed from: d, reason: collision with root package name */
    public final i f136d;

    public h(b bVar, x7.b bVar2, x7.c cVar, i iVar) {
        this.f133a = bVar;
        this.f134b = bVar2;
        this.f135c = cVar;
        this.f136d = iVar;
    }

    public final void a(x7.a aVar) {
        b bVar = this.f133a;
        x7.c cVar = this.f135c;
        x7.b bVar2 = this.f134b;
        i iVar = this.f136d;
        o a3 = b.a();
        String str = bVar.f120a;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        a3.f12377b = str;
        Priority priority = aVar.f19819b;
        if (priority == null) {
            throw new NullPointerException("Null priority");
        }
        a3.f12378c = priority;
        a3.f12379d = bVar.f121b;
        b i3 = a3.i();
        g0 g0Var = new g0();
        g0Var.f16178f = new HashMap();
        g0Var.f16177d = Long.valueOf(iVar.f137a.c());
        g0Var.e = Long.valueOf(iVar.f138b.c());
        g0Var.f16174a = "FIREBASE_ML_SDK";
        g0Var.f16176c = new e(bVar2, (byte[]) cVar.apply(aVar.f19818a));
        g0Var.f16175b = null;
        a c9 = g0Var.c();
        e8.b bVar3 = (e8.b) iVar.f139c;
        bVar3.getClass();
        bVar3.f12479b.execute(new e8.a(bVar3, 0, i3, c9));
    }
}
