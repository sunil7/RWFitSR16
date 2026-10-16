package a2;

import com.example.test.ui.device.activity.e0;
import java.io.Serializable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public Object f38a;

    /* renamed from: b, reason: collision with root package name */
    public Object f39b;

    /* renamed from: c, reason: collision with root package name */
    public Object f40c;

    /* renamed from: d, reason: collision with root package name */
    public Serializable f41d;
    public Serializable e;

    /* renamed from: f, reason: collision with root package name */
    public Object f42f;

    /* renamed from: g, reason: collision with root package name */
    public Object f43g;

    /* renamed from: h, reason: collision with root package name */
    public Object f44h;

    /* renamed from: i, reason: collision with root package name */
    public Object f45i;

    /* renamed from: j, reason: collision with root package name */
    public Object f46j;

    /* renamed from: k, reason: collision with root package name */
    public Object f47k;

    public f a() {
        f fVar;
        f fVar2 = (f) this.f43g;
        if (fVar2 != null) {
            fVar2.e();
        }
        do {
            h5.b bVar = (h5.b) this.f44h;
            com.google.android.gms.internal.mlkit_common.o oVar = (com.google.android.gms.internal.mlkit_common.o) this.f45i;
            if (bVar != null) {
                ((CopyOnWriteArrayList) bVar.f37b).remove(oVar);
            }
            h5.b bVar2 = new h5.b((com.dh.imagepick.preview.adapter.a) ((e0) this.f46j).f7855b);
            this.f44h = bVar2;
            ((CopyOnWriteArrayList) bVar2.f37b).add(oVar);
            h5.b bVar3 = (h5.b) this.f44h;
            if (bVar3 == null) {
                throw new IllegalArgumentException("DataSource may not be null");
            }
            o2.m mVar = (o2.m) this.f47k;
            Executor executor = (Executor) this.f39b;
            int i3 = k.f51k;
            fVar = new f(bVar3, executor, mVar);
            this.f43g = fVar;
        } while (fVar.f59i.get());
        return (f) this.f43g;
    }
}
