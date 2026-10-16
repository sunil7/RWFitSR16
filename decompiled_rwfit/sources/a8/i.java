package a8;

import android.content.Context;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import de.o;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public final class i {
    public static volatile d e;

    /* renamed from: a, reason: collision with root package name */
    public final i8.a f137a;

    /* renamed from: b, reason: collision with root package name */
    public final i8.a f138b;

    /* renamed from: c, reason: collision with root package name */
    public final e8.c f139c;

    /* renamed from: d, reason: collision with root package name */
    public final f8.g f140d;

    public i(i8.a aVar, i8.a aVar2, e8.c cVar, f8.g gVar, f8.h hVar) {
        this.f137a = aVar;
        this.f138b = aVar2;
        this.f139c = cVar;
        this.f140d = gVar;
        hVar.getClass();
        hVar.f13526a.execute(new androidx.activity.e(hVar, 16));
    }

    public static i a() {
        d dVar = e;
        if (dVar != null) {
            return (i) dVar.e.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void b(Context context) {
        if (e == null) {
            synchronized (i.class) {
                try {
                    if (e == null) {
                        c cVar = new c();
                        context.getClass();
                        cVar.f123a = context;
                        e = cVar.b();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final o c(y7.a aVar) {
        byte[] bytes;
        Set unmodifiableSet = aVar != null ? Collections.unmodifiableSet(y7.a.f20022d) : Collections.singleton(new x7.b("proto"));
        o a3 = b.a();
        aVar.getClass();
        a3.f12377b = "cct";
        String str = aVar.f20023a;
        String str2 = aVar.f20024b;
        if (str2 == null && str == null) {
            bytes = null;
        } else {
            if (str2 == null) {
                str2 = "";
            }
            bytes = l0.p("1$", str, "\\", str2).getBytes(Charset.forName("UTF-8"));
        }
        a3.f12379d = bytes;
        return new o(unmodifiableSet, 3, a3.i(), this);
    }
}
