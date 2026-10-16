package yb;

import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.Type;
import java.util.Map;

/* loaded from: classes.dex */
public final class e extends com.google.gson.k {

    /* renamed from: a, reason: collision with root package name */
    public final l f20051a;

    /* renamed from: b, reason: collision with root package name */
    public final l f20052b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.gson.internal.i f20053c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f20054d;

    public e(c cVar, com.google.gson.e eVar, Type type, com.google.gson.k kVar, Type type2, com.google.gson.k kVar2, com.google.gson.internal.i iVar) {
        this.f20054d = cVar;
        this.f20051a = new l(eVar, kVar, type);
        this.f20052b = new l(eVar, kVar2, type2);
        this.f20053c = iVar;
    }

    @Override // com.google.gson.k
    public final Object a(cc.a aVar) {
        JsonToken b02 = aVar.b0();
        if (b02 == JsonToken.NULL) {
            aVar.X();
            return null;
        }
        Map map = (Map) this.f20053c.t();
        JsonToken jsonToken = JsonToken.BEGIN_ARRAY;
        l lVar = this.f20052b;
        l lVar2 = this.f20051a;
        com.google.gson.k kVar = lVar.f20077b;
        com.google.gson.k kVar2 = lVar2.f20077b;
        if (b02 == jsonToken) {
            aVar.b();
            while (aVar.j()) {
                aVar.b();
                Object a3 = kVar2.a(aVar);
                if (map.put(a3, kVar.a(aVar)) != null) {
                    throw new JsonSyntaxException("duplicate key: " + a3);
                }
                aVar.g();
            }
            aVar.g();
            return map;
        }
        aVar.c();
        while (aVar.j()) {
            eb.e.f12485b.getClass();
            int i3 = aVar.f3433h;
            if (i3 == 0) {
                i3 = aVar.f();
            }
            if (i3 == 13) {
                aVar.f3433h = 9;
            } else if (i3 == 12) {
                aVar.f3433h = 8;
            } else {
                if (i3 != 14) {
                    throw new IllegalStateException("Expected a name but was " + aVar.b0() + aVar.l());
                }
                aVar.f3433h = 10;
            }
            Object a10 = kVar2.a(aVar);
            if (map.put(a10, kVar.a(aVar)) != null) {
                throw new JsonSyntaxException("duplicate key: " + a10);
            }
        }
        aVar.h();
        return map;
    }

    @Override // com.google.gson.k
    public final void b(cc.b bVar, Object obj) {
        Map map = (Map) obj;
        if (map == null) {
            bVar.k();
            return;
        }
        this.f20054d.getClass();
        l lVar = this.f20052b;
        bVar.e();
        for (Map.Entry entry : map.entrySet()) {
            bVar.i(String.valueOf(entry.getKey()));
            lVar.b(bVar, entry.getValue());
        }
        bVar.h();
    }
}
