package androidx.camera.lifecycle;

import android.content.Context;
import android.os.Trace;
import androidx.activity.ComponentActivity;
import androidx.camera.core.impl.j0;
import androidx.camera.core.impl.l1;
import androidx.camera.core.impl.q;
import androidx.camera.core.impl.r;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.v;
import androidx.camera.core.impl.z;
import com.google.android.gms.internal.mlkit_vision_barcode.lc;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import com.google.android.gms.internal.mlkit_vision_common.k0;
import com.google.android.gms.internal.mlkit_vision_common.y5;
import f8.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;
import n.s;
import n0.g;
import n0.i;
import oh.l;
import t.p;
import x.h;
import x.k;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: g, reason: collision with root package name */
    public static final e f1560g = new e();

    /* renamed from: b, reason: collision with root package name */
    public i f1562b;

    /* renamed from: d, reason: collision with root package name */
    public androidx.camera.core.b f1564d;
    public Context e;

    /* renamed from: a, reason: collision with root package name */
    public final Object f1561a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final b f1563c = new b();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f1565f = new HashMap();

    public static final q a(e eVar, t.q qVar) {
        eVar.getClass();
        Iterator it = qVar.f18376a.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            kotlin.jvm.internal.e.e(next, "cameraSelector.cameraFilterSet");
            androidx.camera.core.impl.d dVar = p.f18373a;
            if (!kotlin.jvm.internal.e.a(dVar, dVar)) {
                synchronized (j0.f1428a) {
                }
                kotlin.jvm.internal.e.c(eVar.e);
            }
        }
        return r.f1477a;
    }

    public static final void b(e eVar, int i3) {
        androidx.camera.core.b bVar = eVar.f1564d;
        if (bVar == null) {
            return;
        }
        n.i iVar = bVar.f1299f;
        if (iVar == null) {
            throw new IllegalStateException("CameraX not initialized yet.");
        }
        f fVar = iVar.f16204b;
        if (i3 != fVar.f13516b) {
            ArrayList arrayList = (ArrayList) fVar.f13517c;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                z zVar = (z) obj;
                int i11 = fVar.f13516b;
                synchronized (zVar.f1535b) {
                    boolean z5 = true;
                    zVar.f1536c = i3 == 2 ? 2 : 1;
                    boolean z6 = i11 != 2 && i3 == 2;
                    if (i11 != 2 || i3 == 2) {
                        z5 = false;
                    }
                    if (z6 || z5) {
                        zVar.b();
                    }
                }
            }
        }
        if (fVar.f13516b == 2 && i3 != 2) {
            ((ArrayList) fVar.e).clear();
        }
        fVar.f13516b = i3;
    }

    public static final x.b f(final ComponentActivity componentActivity) {
        i iVar;
        final e eVar = f1560g;
        synchronized (eVar.f1561a) {
            iVar = eVar.f1562b;
            if (iVar == null) {
                final androidx.camera.core.b bVar = new androidx.camera.core.b(componentActivity);
                iVar = ve.a(new g() { // from class: androidx.camera.lifecycle.c
                    @Override // n0.g
                    public final Object b(androidx.concurrent.futures.b bVar2) {
                        e this$0 = e.this;
                        final androidx.camera.core.b bVar3 = bVar;
                        kotlin.jvm.internal.e.f(this$0, "this$0");
                        synchronized (this$0.f1561a) {
                            x.d b3 = x.d.b(k.f19707c);
                            d dVar = new d(new l() { // from class: androidx.camera.lifecycle.ProcessCameraProvider$getOrCreateCameraXInstance$1$1$1$future$1
                                {
                                    super(1);
                                }

                                @Override // oh.l
                                public final ob.a invoke(Void r12) {
                                    return androidx.camera.core.b.this.f1303j;
                                }
                            }, 0);
                            w.a a3 = a6.a();
                            b3.getClass();
                            x.b f2 = x.i.f(b3, dVar, a3);
                            ef.i iVar2 = new ef.i(5, bVar2, bVar3);
                            f2.a(new h(0, f2, iVar2), a6.a());
                        }
                        return "ProcessCameraProvider-initializeCameraX";
                    }
                });
                eVar.f1562b = iVar;
            }
        }
        d dVar = new d(new l() { // from class: androidx.camera.lifecycle.ProcessCameraProvider$Companion$getInstance$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // oh.l
            public final e invoke(androidx.camera.core.b cameraX) {
                e eVar2 = e.f1560g;
                kotlin.jvm.internal.e.e(cameraX, "cameraX");
                eVar2.f1564d = cameraX;
                Context a3 = k0.a(componentActivity);
                kotlin.jvm.internal.e.e(a3, "getApplicationContext(context)");
                eVar2.e = a3;
                return eVar2;
            }
        }, 1);
        return x.i.f(iVar, new n6.a(dVar, 23), a6.a());
    }

    public final LifecycleCamera c(ComponentActivity componentActivity, t.q qVar, androidx.camera.core.f... fVarArr) {
        int i3;
        Trace.beginSection(lc.d("CX:bindToLifecycle"));
        try {
            androidx.camera.core.b bVar = this.f1564d;
            if (bVar == null) {
                i3 = 0;
            } else {
                n.i iVar = bVar.f1299f;
                if (iVar == null) {
                    throw new IllegalStateException("CameraX not initialized yet.");
                }
                i3 = iVar.f16204b.f13516b;
            }
            if (i3 == 2) {
                throw new UnsupportedOperationException("bindToLifecycle for single camera is not supported in concurrent camera mode, call unbindAll() first");
            }
            b(this, 1);
            return d(componentActivity, qVar, EmptyList.INSTANCE, (androidx.camera.core.f[]) Arrays.copyOf(fVarArr, fVarArr.length));
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Type inference failed for: r18v1, types: [androidx.camera.core.impl.l1, androidx.camera.core.impl.v] */
    public final LifecycleCamera d(ComponentActivity componentActivity, t.q qVar, EmptyList effects, androidx.camera.core.f... useCases) {
        LifecycleCamera lifecycleCamera;
        Collection unmodifiableCollection;
        boolean contains;
        kotlin.jvm.internal.e.f(effects, "effects");
        kotlin.jvm.internal.e.f(useCases, "useCases");
        Trace.beginSection(lc.d("CX:bindToLifecycle-internal"));
        try {
            y5.a();
            androidx.camera.core.b bVar = this.f1564d;
            kotlin.jvm.internal.e.c(bVar);
            v c9 = qVar.c(bVar.f1295a.t());
            kotlin.jvm.internal.e.e(c9, "primaryCameraSelector.se…cameraRepository.cameras)");
            c9.g(true);
            l1 e = e(qVar);
            b bVar2 = this.f1563c;
            Object obj = null;
            y.a s7 = y.e.s(e, null);
            synchronized (bVar2.f1552a) {
                lifecycleCamera = (LifecycleCamera) bVar2.f1553b.get(new a(componentActivity, s7));
            }
            b bVar3 = this.f1563c;
            synchronized (bVar3.f1552a) {
                unmodifiableCollection = Collections.unmodifiableCollection(bVar3.f1553b.values());
            }
            ArrayList e10 = kotlin.collections.g.e(useCases);
            int size = e10.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2 = e10.get(i3);
                i3++;
                androidx.camera.core.f fVar = (androidx.camera.core.f) obj2;
                for (Object lifecycleCameras : unmodifiableCollection) {
                    Object obj3 = obj;
                    kotlin.jvm.internal.e.e(lifecycleCameras, "lifecycleCameras");
                    LifecycleCamera lifecycleCamera2 = (LifecycleCamera) lifecycleCameras;
                    synchronized (lifecycleCamera2.f1544a) {
                        contains = ((ArrayList) lifecycleCamera2.f1546c.v()).contains(fVar);
                    }
                    if (contains && !lifecycleCamera2.equals(lifecycleCamera)) {
                        throw new IllegalStateException(String.format("Use case %s already bound to a different lifecycle.", Arrays.copyOf(new Object[]{fVar}, 1)));
                    }
                    obj = obj3;
                }
            }
            ?? r18 = obj;
            if (lifecycleCamera == null) {
                b bVar4 = this.f1563c;
                androidx.camera.core.b bVar5 = this.f1564d;
                kotlin.jvm.internal.e.c(bVar5);
                n.i iVar = bVar5.f1299f;
                if (iVar == null) {
                    throw new IllegalStateException("CameraX not initialized yet.");
                }
                f fVar2 = iVar.f16204b;
                androidx.camera.core.b bVar6 = this.f1564d;
                kotlin.jvm.internal.e.c(bVar6);
                ef.i iVar2 = bVar6.f1300g;
                if (iVar2 == null) {
                    throw new IllegalStateException("CameraX not initialized yet.");
                }
                androidx.camera.core.b bVar7 = this.f1564d;
                kotlin.jvm.internal.e.c(bVar7);
                s sVar = bVar7.f1301h;
                if (sVar == null) {
                    throw new IllegalStateException("CameraX not initialized yet.");
                }
                lifecycleCamera = bVar4.b(componentActivity, new y.e(c9, r18, e, r18, fVar2, iVar2, sVar));
            }
            if (useCases.length != 0) {
                b bVar8 = this.f1563c;
                List d5 = kotlin.collections.i.d(Arrays.copyOf(useCases, useCases.length));
                androidx.camera.core.b bVar9 = this.f1564d;
                kotlin.jvm.internal.e.c(bVar9);
                n.i iVar3 = bVar9.f1299f;
                if (iVar3 == null) {
                    throw new IllegalStateException("CameraX not initialized yet.");
                }
                bVar8.a(lifecycleCamera, effects, d5, iVar3.f16204b);
            }
            return lifecycleCamera;
        } finally {
            Trace.endSection();
        }
    }

    public final l1 e(t.q cameraSelector) {
        Object obj;
        kotlin.jvm.internal.e.f(cameraSelector, "cameraSelector");
        Trace.beginSection(lc.d("CX:getCameraInfo"));
        try {
            androidx.camera.core.b bVar = this.f1564d;
            kotlin.jvm.internal.e.c(bVar);
            u h4 = cameraSelector.c(bVar.f1295a.t()).h();
            kotlin.jvm.internal.e.e(h4, "cameraSelector.select(mC…meras).cameraInfoInternal");
            q a3 = a(this, cameraSelector);
            y.a aVar = new y.a(h4.c(), a3.f1474a);
            synchronized (this.f1561a) {
                obj = this.f1565f.get(aVar);
                if (obj == null) {
                    obj = new l1(h4, a3);
                    this.f1565f.put(aVar, obj);
                }
            }
            return (l1) obj;
        } finally {
            Trace.endSection();
        }
    }

    public final void g() {
        Trace.beginSection(lc.d("CX:unbindAll"));
        try {
            y5.a();
            b(this, 0);
            this.f1563c.i();
        } finally {
            Trace.endSection();
        }
    }
}
