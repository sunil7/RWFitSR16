package com.google.mlkit.vision.barcode.internal;

import androidx.appcompat.widget.b0;
import com.google.android.gms.common.Feature;
import com.google.android.gms.internal.mlkit_vision_barcode.ac;
import com.google.android.gms.internal.mlkit_vision_barcode.ag;
import com.google.android.gms.internal.mlkit_vision_barcode.u0;
import com.google.android.gms.internal.mlkit_vision_barcode.wf;
import com.google.android.gms.internal.mlkit_vision_barcode.zzra;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrc;
import com.google.mlkit.vision.common.internal.MobileVisionBase;
import gc.g;
import ic.a;
import ic.b;
import java.util.concurrent.Executor;
import mc.e;
import n.g0;

/* loaded from: classes.dex */
public final class zzh extends MobileVisionBase implements a {

    /* renamed from: f, reason: collision with root package name */
    public final boolean f11204f;

    public zzh(b bVar, e eVar, Executor executor, ag agVar) {
        super(eVar, executor);
        boolean c9 = mc.a.c();
        this.f11204f = c9;
        u0 u0Var = new u0();
        u0Var.f9539c = mc.a.a(bVar);
        ac acVar = new ac(u0Var);
        g0 g0Var = new g0();
        g0Var.f16176c = c9 ? zzra.TYPE_THICK : zzra.TYPE_THIN;
        g0Var.f16177d = acVar;
        com.google.mlkit.common.sdkinternal.a.c().execute(new wf((Object) agVar, (Object) new b0(g0Var, 1), (Enum) zzrc.ON_DEVICE_BARCODE_CREATE, agVar.c(), 0));
    }

    @Override // com.google.android.gms.common.api.j
    public final Feature[] b() {
        return this.f11204f ? g.f14033a : new Feature[]{g.f14034b};
    }

    @Override // com.google.mlkit.vision.common.internal.MobileVisionBase, java.io.Closeable, java.lang.AutoCloseable, ic.a
    public final synchronized void close() {
        super.close();
    }
}
