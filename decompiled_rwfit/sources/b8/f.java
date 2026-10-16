package b8;

import android.content.Context;
import com.google.android.datatransport.cct.CctBackendFactory;
import ef.i;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final i f3176a;

    /* renamed from: b, reason: collision with root package name */
    public final d f3177b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f3178c;

    public f(Context context, d dVar) {
        i iVar = new i(context);
        this.f3178c = new HashMap();
        this.f3176a = iVar;
        this.f3177b = dVar;
    }

    public final synchronized g a(String str) {
        if (this.f3178c.containsKey(str)) {
            return (g) this.f3178c.get(str);
        }
        CctBackendFactory r = this.f3176a.r(str);
        if (r == null) {
            return null;
        }
        d dVar = this.f3177b;
        g create = r.create(new b(dVar.f3171a, dVar.f3172b, dVar.f3173c, str));
        this.f3178c.put(str, create);
        return create;
    }
}
