package b1;

import androidx.camera.core.impl.g0;
import com.dh.keeplive.service.LocalService;
import com.example.blesdk.ble.scan.ScanSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import n.n0;

/* loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3073a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3074b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3075c;

    public /* synthetic */ m(int i3, int i10, Object obj) {
        this.f3073a = i10;
        this.f3075c = obj;
        this.f3074b = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3073a) {
            case 0:
                ((b) this.f3075c).d(this.f3074b);
                return;
            case 1:
                int i3 = LocalService.f7224j;
                com.example.test.b it = (com.example.test.b) this.f3075c;
                kotlin.jvm.internal.e.f(it, "$it");
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BaseApplication", "doWork:" + this.f3074b);
                return;
            case 2:
                ((androidx.camera.core.impl.k) this.f3075c).a(this.f3074b);
                return;
            case 3:
                LinkedHashSet linkedHashSet = (LinkedHashSet) this.f3075c;
                int i10 = this.f3074b;
                Iterator it2 = linkedHashSet.iterator();
                while (it2.hasNext()) {
                    n0 n0Var = (n0) it2.next();
                    if (i10 == 5) {
                        synchronized (n0Var.f16271p) {
                            try {
                                if (n0Var.m() && n0Var.f16272q != null) {
                                    n0Var.l("Close DeferrableSurfaces for CameraDevice error.");
                                    ArrayList arrayList = n0Var.f16272q;
                                    int size = arrayList.size();
                                    int i11 = 0;
                                    while (i11 < size) {
                                        Object obj = arrayList.get(i11);
                                        i11++;
                                        ((g0) obj).a();
                                    }
                                }
                            } finally {
                            }
                        }
                    } else {
                        n0Var.getClass();
                    }
                }
                return;
            default:
                t5.d dVar = ((t5.c) this.f3075c).f18540b;
                boolean p8 = dVar.f18531g.p();
                t5.i iVar = dVar.f18532h;
                if (p8) {
                    ScanSettings scanSettings = dVar.f18531g;
                    if (scanSettings.b() != 1) {
                        scanSettings.a();
                        t5.b a3 = t5.b.a();
                        try {
                            a3.c(iVar);
                        } catch (Exception unused) {
                        }
                        try {
                            a3.b(dVar.f18530f, scanSettings, iVar, dVar.f18533i);
                            return;
                        } catch (Exception unused2) {
                            return;
                        }
                    }
                }
                iVar.b(this.f3074b);
                return;
        }
    }
}
