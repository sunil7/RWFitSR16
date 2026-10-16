package z3;

import android.util.Log;
import com.bumptech.glide.Registry$MissingComponentException;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.GlideException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final Class f20235a;

    /* renamed from: b, reason: collision with root package name */
    public final List f20236b;

    /* renamed from: c, reason: collision with root package name */
    public final l4.a f20237c;

    /* renamed from: d, reason: collision with root package name */
    public final n.l f20238d;
    public final String e;

    public g(Class cls, Class cls2, Class cls3, List list, l4.a aVar, n.l lVar) {
        this.f20235a = cls;
        this.f20236b = list;
        this.f20237c = aVar;
        this.f20238d = lVar;
        this.e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final s a(int i3, int i10, com.bumptech.glide.load.data.g gVar, o4.c cVar, x3.f fVar) {
        s sVar;
        x3.i iVar;
        EncodeStrategy encodeStrategy;
        boolean z5;
        boolean z6;
        boolean z8;
        x3.c cVar2;
        n.l lVar = this.f20238d;
        List list = (List) lVar.c();
        try {
            s b3 = b(gVar, i3, i10, fVar, list);
            lVar.q(list);
            com.bumptech.glide.load.engine.b bVar = (com.bumptech.glide.load.engine.b) cVar.f16733b;
            bVar.getClass();
            Class<?> cls = b3.get().getClass();
            DataSource dataSource = DataSource.RESOURCE_DISK_CACHE;
            DataSource dataSource2 = (DataSource) cVar.f16732a;
            f fVar2 = bVar.f6986a;
            x3.h hVar = null;
            if (dataSource2 != dataSource) {
                x3.i e = fVar2.e(cls);
                iVar = e;
                sVar = e.a(bVar.f6992h, b3, bVar.f6996l, bVar.f6997m);
            } else {
                sVar = b3;
                iVar = null;
            }
            if (!b3.equals(sVar)) {
                b3.recycle();
            }
            if (fVar2.f20221c.f6917b.f6928d.g(sVar.d()) != null) {
                com.bumptech.glide.g gVar2 = fVar2.f20221c.f6917b;
                gVar2.getClass();
                hVar = gVar2.f6928d.g(sVar.d());
                if (hVar == null) {
                    final Class d5 = sVar.d();
                    throw new Registry$MissingComponentException(d5) { // from class: com.bumptech.glide.Registry$NoResultEncoderAvailableException
                        {
                            super("Failed to find result encoder for resource class: " + d5 + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
                        }
                    };
                }
                encodeStrategy = hVar.o(bVar.f6999o);
            } else {
                encodeStrategy = EncodeStrategy.NONE;
            }
            x3.h hVar2 = hVar;
            x3.c cVar3 = bVar.f7006w;
            ArrayList b10 = fVar2.b();
            int size = b10.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    z5 = false;
                    break;
                }
                if (((d4.p) b10.get(i11)).f12280a.equals(cVar3)) {
                    z5 = true;
                    break;
                }
                i11++;
            }
            switch (bVar.f6998n.f20242a) {
                default:
                    if (((!z5 && dataSource2 == DataSource.DATA_DISK_CACHE) || dataSource2 == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED) {
                        z6 = true;
                        break;
                    }
                    break;
                case 0:
                case 1:
                    z6 = false;
                    break;
            }
            if (z6) {
                if (hVar2 == null) {
                    final Class<?> cls2 = sVar.get().getClass();
                    throw new Registry$MissingComponentException(cls2) { // from class: com.bumptech.glide.Registry$NoResultEncoderAvailableException
                        {
                            super("Failed to find result encoder for resource class: " + cls2 + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
                        }
                    };
                }
                int i12 = com.bumptech.glide.load.engine.a.f6985c[encodeStrategy.ordinal()];
                if (i12 == 1) {
                    z8 = true;
                    cVar2 = new c(bVar.f7006w, bVar.f6993i);
                } else {
                    if (i12 != 2) {
                        throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
                    }
                    z8 = true;
                    cVar2 = new u(fVar2.f20221c.f6916a, bVar.f7006w, bVar.f6993i, bVar.f6996l, bVar.f6997m, iVar, cls, bVar.f6999o);
                }
                r rVar = (r) r.e.c();
                rVar.f20291d = false;
                rVar.f20290c = z8;
                rVar.f20289b = sVar;
                n.l lVar2 = bVar.f6990f;
                lVar2.f16245b = cVar2;
                lVar2.f16246c = hVar2;
                lVar2.f16247d = rVar;
                sVar = rVar;
            }
            return this.f20237c.d(sVar, fVar);
        } catch (Throwable th2) {
            lVar.q(list);
            throw th2;
        }
    }

    public final s b(com.bumptech.glide.load.data.g gVar, int i3, int i10, x3.f fVar, List list) {
        List list2 = this.f20236b;
        int size = list2.size();
        s sVar = null;
        for (int i11 = 0; i11 < size; i11++) {
            x3.g gVar2 = (x3.g) list2.get(i11);
            try {
                if (gVar2.a(gVar.m(), fVar)) {
                    sVar = gVar2.b(gVar.m(), i3, i10, fVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + gVar2, e);
                }
                list.add(e);
            }
            if (sVar != null) {
                break;
            }
        }
        if (sVar != null) {
            return sVar;
        }
        throw new GlideException(this.e, new ArrayList(list));
    }

    public final String toString() {
        return "DecodePath{ dataClass=" + this.f20235a + ", decoders=" + this.f20236b + ", transcoder=" + this.f20237c + '}';
    }
}
