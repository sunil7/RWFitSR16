package z3;

import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final n.l f20285a;

    /* renamed from: b, reason: collision with root package name */
    public final List f20286b;

    /* renamed from: c, reason: collision with root package name */
    public final String f20287c;

    public q(Class cls, Class cls2, Class cls3, List list, n.l lVar) {
        this.f20285a = lVar;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.f20286b = list;
        this.f20287c = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final s a(int i3, int i10, com.bumptech.glide.load.data.g gVar, o4.c cVar, x3.f fVar) {
        n.l lVar = this.f20285a;
        List list = (List) lVar.c();
        try {
            List list2 = this.f20286b;
            int size = list2.size();
            s sVar = null;
            for (int i11 = 0; i11 < size; i11++) {
                try {
                    sVar = ((g) list2.get(i11)).a(i3, i10, gVar, cVar, fVar);
                } catch (GlideException e) {
                    list.add(e);
                }
                if (sVar != null) {
                    break;
                }
            }
            if (sVar != null) {
                return sVar;
            }
            throw new GlideException(this.f20287c, new ArrayList(list));
        } finally {
            lVar.q(list);
        }
    }

    public final String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f20286b.toArray()) + '}';
    }
}
