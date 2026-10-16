package mc;

import android.os.SystemClock;
import androidx.appcompat.app.j0;
import androidx.appcompat.widget.b0;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.test.ui.device.activity.f0;
import com.example.test.utils.y;
import com.google.android.exoplayer2.Format;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.internal.mlkit_vision_barcode.ac;
import com.google.android.gms.internal.mlkit_vision_barcode.ag;
import com.google.android.gms.internal.mlkit_vision_barcode.eb;
import com.google.android.gms.internal.mlkit_vision_barcode.ib;
import com.google.android.gms.internal.mlkit_vision_barcode.u0;
import com.google.android.gms.internal.mlkit_vision_barcode.v0;
import com.google.android.gms.internal.mlkit_vision_barcode.zf;
import com.google.android.gms.internal.mlkit_vision_barcode.zzqi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzra;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrb;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrc;
import com.google.android.gms.internal.mlkit_vision_barcode.zzrn;
import com.google.android.gms.internal.mlkit_vision_barcode.zzro;
import com.google.mlkit.common.MlKitException;
import gc.j;
import ia.m;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import n.g0;
import q9.n;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: j, reason: collision with root package name */
    public static boolean f16012j = true;

    /* renamed from: d, reason: collision with root package name */
    public final ic.b f16016d;
    public final f e;

    /* renamed from: f, reason: collision with root package name */
    public final ag f16017f;

    /* renamed from: g, reason: collision with root package name */
    public final y f16018g;

    /* renamed from: i, reason: collision with root package name */
    public boolean f16020i;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f16014b = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f16015c = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    public final a2.g f16013a = new a2.g(2);

    /* renamed from: h, reason: collision with root package name */
    public final oc.a f16019h = new oc.a();

    public e(gc.e eVar, ic.b bVar, f fVar, ag agVar) {
        n.f(eVar, "MlKitContext can not be null");
        this.f16016d = bVar;
        this.e = fVar;
        this.f16017f = agVar;
        this.f16018g = new y(eVar.b());
    }

    public final m a(Executor executor, Callable callable, f0 f0Var) {
        if (this.f16014b.get() <= 0) {
            throw new IllegalStateException();
        }
        if (((m) f0Var.f7859b).e()) {
            m mVar = new m();
            mVar.i();
            return mVar;
        }
        f0 f0Var2 = new f0(20);
        ia.g gVar = new ia.g((f0) f0Var2.f7859b);
        j0 j0Var = new j0(executor, f0Var, f0Var2, gVar);
        this.f16013a.j(new j(this, f0Var, f0Var2, callable, gVar), j0Var);
        return gVar.f14382a;
    }

    public final List b(nc.a aVar) {
        e eVar;
        nc.a aVar2;
        synchronized (this) {
            try {
                try {
                    oc.a aVar3 = this.f16019h;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    aVar3.a(aVar);
                    try {
                        ArrayList c9 = this.e.c(aVar);
                        eVar = this;
                        aVar2 = aVar;
                        try {
                            eVar.c(zzrb.NO_ERROR, elapsedRealtime, aVar2, c9);
                            f16012j = false;
                            return c9;
                        } catch (MlKitException e) {
                            e = e;
                            MlKitException mlKitException = e;
                            eVar.c(mlKitException.getErrorCode() == 14 ? zzrb.MODEL_NOT_DOWNLOADED : zzrb.UNKNOWN_ERROR, elapsedRealtime, aVar2, null);
                            throw mlKitException;
                        }
                    } catch (MlKitException e10) {
                        e = e10;
                        eVar = this;
                        aVar2 = aVar;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public final void c(final zzrb zzrbVar, long j4, final nc.a aVar, List list) {
        final androidx.appcompat.widget.a aVar2 = new androidx.appcompat.widget.a();
        final androidx.appcompat.widget.a aVar3 = new androidx.appcompat.widget.a();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                kc.a aVar4 = (kc.a) it.next();
                int n4 = aVar4.f15602a.n();
                if (n4 > 4096 || n4 == 0) {
                    n4 = -1;
                }
                zzrn zzrnVar = (zzrn) a.f16000a.get(n4);
                if (zzrnVar == null) {
                    zzrnVar = zzrn.FORMAT_UNKNOWN;
                }
                aVar2.b(zzrnVar);
                zzro zzroVar = (zzro) a.f16001b.get(aVar4.f15602a.q());
                if (zzroVar == null) {
                    zzroVar = zzro.TYPE_UNKNOWN;
                }
                aVar3.b(zzroVar);
            }
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime() - j4;
        this.f16017f.b(new zf() { // from class: mc.d
            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zf
            public final b0 zza() {
                int limit;
                e eVar = e.this;
                long j10 = elapsedRealtime;
                zzrb zzrbVar2 = zzrbVar;
                androidx.appcompat.widget.a aVar5 = aVar2;
                androidx.appcompat.widget.a aVar6 = aVar3;
                nc.a aVar7 = aVar;
                eVar.getClass();
                u0 u0Var = new u0();
                u0 u0Var2 = new u0();
                u0Var2.f9539c = Long.valueOf(j10 & Format.OFFSET_SAMPLE_RELATIVE);
                u0Var2.f9537a = zzrbVar2;
                u0Var2.f9538b = Boolean.valueOf(e.f16012j);
                Boolean bool = Boolean.TRUE;
                u0Var2.f9540d = bool;
                u0Var2.e = bool;
                u0Var.f9537a = new ib(u0Var2);
                u0Var.f9539c = a.a(eVar.f16016d);
                u0Var.f9540d = aVar5.d();
                u0Var.e = aVar6.d();
                int i3 = aVar7.e;
                if (i3 == -1) {
                    n.e(null);
                    throw null;
                }
                if (i3 == 17 || i3 == 842094169) {
                    ByteBuffer byteBuffer = aVar7.f16459a;
                    n.e(byteBuffer);
                    limit = byteBuffer.limit();
                } else {
                    if (i3 == 35) {
                        n.e(null);
                        throw null;
                    }
                    limit = 0;
                }
                ef.i iVar = new ef.i(13, false);
                iVar.f12629b = i3 != -1 ? i3 != 35 ? i3 != 842094169 ? i3 != 16 ? i3 != 17 ? zzqi.UNKNOWN_FORMAT : zzqi.NV21 : zzqi.NV16 : zzqi.YV12 : zzqi.YUV_420_888 : zzqi.BITMAP;
                iVar.f12630c = Integer.valueOf(Integer.MAX_VALUE & limit);
                u0Var.f9538b = new eb(iVar);
                g0 g0Var = new g0();
                g0Var.f16176c = eVar.f16020i ? zzra.TYPE_THICK : zzra.TYPE_THIN;
                g0Var.f16177d = new ac(u0Var);
                return new b0(g0Var, 0);
            }
        }, zzrc.ON_DEVICE_BARCODE_DETECT);
        u0 u0Var = new u0();
        u0Var.f9537a = zzrbVar;
        u0Var.f9538b = Boolean.valueOf(f16012j);
        u0Var.f9539c = a.a(this.f16016d);
        u0Var.f9540d = aVar2.d();
        u0Var.e = aVar3.d();
        final v0 v0Var = new v0(u0Var);
        final f0 f0Var = new f0(this, 27);
        final ag agVar = this.f16017f;
        final zzrc zzrcVar = zzrc.AGGREGATED_ON_DEVICE_BARCODE_DETECTION;
        com.google.mlkit.common.sdkinternal.a.c().execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.yf
            @Override // java.lang.Runnable
            public final void run() {
                final ag agVar2 = ag.this;
                HashMap hashMap = agVar2.f9229j;
                final zzrc zzrcVar2 = zzrcVar;
                if (!hashMap.containsKey(zzrcVar2)) {
                    hashMap.put(zzrcVar2, zzbw.zzz());
                }
                ((z) hashMap.get(zzrcVar2)).zzt(v0Var, Long.valueOf(elapsedRealtime));
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                if (agVar2.d(zzrcVar2, elapsedRealtime2)) {
                    agVar2.f9228i.put(zzrcVar2, Long.valueOf(elapsedRealtime2));
                    Executor c9 = com.google.mlkit.common.sdkinternal.a.c();
                    final com.example.test.ui.device.activity.f0 f0Var2 = f0Var;
                    c9.execute(new Runnable() { // from class: com.google.android.gms.internal.mlkit_vision_barcode.xf
                        @Override // java.lang.Runnable
                        public final void run() {
                            ag agVar3 = ag.this;
                            HashMap hashMap2 = agVar3.f9229j;
                            zzrc zzrcVar3 = zzrcVar2;
                            z zVar = (z) hashMap2.get(zzrcVar3);
                            if (zVar != null) {
                                for (Object obj : zVar.zzw()) {
                                    ArrayList arrayList = new ArrayList(zVar.zze(obj));
                                    Collections.sort(arrayList);
                                    n.g0 g0Var = new n.g0();
                                    int size = arrayList.size();
                                    long j10 = 0;
                                    int i3 = 0;
                                    while (i3 < size) {
                                        Object obj2 = arrayList.get(i3);
                                        i3++;
                                        j10 += ((Long) obj2).longValue();
                                    }
                                    g0Var.f16176c = Long.valueOf((j10 / arrayList.size()) & Format.OFFSET_SAMPLE_RELATIVE);
                                    g0Var.f16174a = Long.valueOf(ag.a(arrayList, 100.0d) & Format.OFFSET_SAMPLE_RELATIVE);
                                    g0Var.f16178f = Long.valueOf(ag.a(arrayList, 75.0d) & Format.OFFSET_SAMPLE_RELATIVE);
                                    g0Var.e = Long.valueOf(ag.a(arrayList, 50.0d) & Format.OFFSET_SAMPLE_RELATIVE);
                                    g0Var.f16177d = Long.valueOf(ag.a(arrayList, 25.0d) & Format.OFFSET_SAMPLE_RELATIVE);
                                    g0Var.f16175b = Long.valueOf(ag.a(arrayList, 0.0d) & Format.OFFSET_SAMPLE_RELATIVE);
                                    ab abVar = new ab(g0Var);
                                    int size2 = arrayList.size();
                                    com.example.test.ui.device.activity.f0 f0Var3 = f0Var2;
                                    v0 v0Var2 = (v0) obj;
                                    n.g0 g0Var2 = new n.g0();
                                    g0Var2.f16176c = ((mc.e) f0Var3.f7859b).f16020i ? zzra.TYPE_THICK : zzra.TYPE_THIN;
                                    n0 n0Var = new n0();
                                    n0Var.f9442b = Integer.valueOf(size2 & SubsamplingScaleImageView.TILE_SIZE_AUTO);
                                    n0Var.f9441a = v0Var2;
                                    n0Var.f9443c = abVar;
                                    g0Var2.f16178f = new w0(n0Var);
                                    com.google.mlkit.common.sdkinternal.a.c().execute(new wf((Object) agVar3, (Object) new androidx.appcompat.widget.b0(g0Var2, 0), (Enum) zzrcVar3, agVar3.c(), 0));
                                }
                                hashMap2.remove(zzrcVar3);
                            }
                        }
                    });
                }
            }
        });
        long currentTimeMillis = System.currentTimeMillis();
        boolean z5 = this.f16020i;
        long j10 = currentTimeMillis - elapsedRealtime;
        y yVar = this.f16018g;
        int i3 = true != z5 ? 24301 : 24302;
        int zza = zzrbVar.zza();
        synchronized (yVar) {
            AtomicLong atomicLong = (AtomicLong) yVar.f8774c;
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            if (atomicLong.get() != -1 && elapsedRealtime2 - ((AtomicLong) yVar.f8774c).get() <= TimeUnit.MINUTES.toMillis(30L)) {
                return;
            }
            m c9 = ((s9.b) yVar.f8773b).c(new TelemetryData(0, Arrays.asList(new MethodInvocation(i3, zza, 0, j10, currentTimeMillis, null, null, 0, -1))));
            androidx.recyclerview.widget.e eVar = new androidx.recyclerview.widget.e(yVar, elapsedRealtime2);
            c9.getClass();
            c9.a(ia.h.f14383a, eVar);
        }
    }
}
