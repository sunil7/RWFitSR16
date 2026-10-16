package yb;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class i extends com.google.gson.k {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.gson.internal.i f20066a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f20067b;

    public i(com.google.gson.internal.i iVar, LinkedHashMap linkedHashMap) {
        this.f20066a = iVar;
        this.f20067b = linkedHashMap;
    }

    @Override // com.google.gson.k
    public final Object a(cc.a aVar) {
        if (aVar.b0() == JsonToken.NULL) {
            aVar.X();
            return null;
        }
        Object t8 = this.f20066a.t();
        try {
            aVar.c();
            while (aVar.j()) {
                h hVar = (h) this.f20067b.get(aVar.O());
                if (hVar != null && hVar.f20060c) {
                    Object a3 = hVar.f20062f.a(aVar);
                    if (a3 != null || !hVar.f20065i) {
                        hVar.f20061d.set(t8, a3);
                    }
                }
                aVar.g0();
            }
            aVar.h();
            return t8;
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (IllegalStateException e10) {
            throw new JsonSyntaxException(e10);
        }
    }

    @Override // com.google.gson.k
    public final void b(cc.b bVar, Object obj) {
        if (obj == null) {
            bVar.k();
            return;
        }
        bVar.e();
        try {
            for (h hVar : this.f20067b.values()) {
                boolean z5 = hVar.f20059b;
                Field field = hVar.f20061d;
                if (z5 && field.get(obj) != obj) {
                    bVar.i(hVar.f20058a);
                    Object obj2 = field.get(obj);
                    boolean z6 = hVar.e;
                    com.google.gson.k kVar = hVar.f20062f;
                    if (!z6) {
                        kVar = new l(hVar.f20063g, kVar, hVar.f20064h.f3204b);
                    }
                    kVar.b(bVar, obj2);
                }
            }
            bVar.h();
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
