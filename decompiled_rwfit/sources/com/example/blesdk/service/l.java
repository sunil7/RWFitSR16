package com.example.blesdk.service;

import android.os.Message;
import com.example.blesdk.bean.sync.HealthSyncBean;
import com.example.test.service.s1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyThreadSafetyMode;

/* loaded from: classes.dex */
public final class l implements o5.a {

    /* renamed from: q, reason: collision with root package name */
    public static final Object f7311q = kotlin.a.a(LazyThreadSafetyMode.NONE, new oh.a() { // from class: com.example.blesdk.service.SyncDataService$Companion$service$2
        @Override // oh.a
        public final l invoke() {
            return new l();
        }
    });

    /* renamed from: a, reason: collision with root package name */
    public int f7312a;

    /* renamed from: b, reason: collision with root package name */
    public int f7313b;

    /* renamed from: m, reason: collision with root package name */
    public HealthSyncBean f7323m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f7324n;

    /* renamed from: p, reason: collision with root package name */
    public int f7326p;

    /* renamed from: c, reason: collision with root package name */
    public final eh.b f7314c = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncDataService$weakHandler$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.baselibrary.utils.e invoke() {
            return new com.example.baselibrary.utils.e(l.this);
        }
    });

    /* renamed from: d, reason: collision with root package name */
    public final eh.b f7315d = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncDataService$dataCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final f invoke() {
            return new f(l.this);
        }
    });
    public final eh.b e = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncDataService$stepCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final j invoke() {
            return new j(l.this);
        }
    });

    /* renamed from: f, reason: collision with root package name */
    public final eh.b f7316f = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncDataService$sleepCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final h invoke() {
            return new h(l.this);
        }
    });

    /* renamed from: g, reason: collision with root package name */
    public final eh.b f7317g = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncDataService$hrCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final g invoke() {
            return new g(l.this);
        }
    });

    /* renamed from: h, reason: collision with root package name */
    public final eh.b f7318h = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncDataService$bpCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final d invoke() {
            return new d(l.this);
        }
    });

    /* renamed from: i, reason: collision with root package name */
    public final eh.b f7319i = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncDataService$boCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final c invoke() {
            return new c(l.this);
        }
    });

    /* renamed from: j, reason: collision with root package name */
    public final eh.b f7320j = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncDataService$tempCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final k invoke() {
            return new k(l.this);
        }
    });

    /* renamed from: k, reason: collision with root package name */
    public final eh.b f7321k = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncDataService$breathCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final e invoke() {
            return new e(l.this);
        }
    });

    /* renamed from: l, reason: collision with root package name */
    public final eh.b f7322l = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncDataService$sportCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final i invoke() {
            return new i(l.this);
        }
    });

    /* renamed from: o, reason: collision with root package name */
    public final eh.b f7325o = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncDataService$callbacks$2
        @Override // oh.a
        public final List<u5.h> invoke() {
            return new ArrayList();
        }
    });

    public static final void a(l lVar, int i3) {
        lVar.f7324n = true;
        Iterator it = lVar.b().iterator();
        while (it.hasNext()) {
            ((s1) ((u5.h) it.next())).e(i3);
        }
    }

    public final List b() {
        return (List) this.f7325o.getValue();
    }

    public final void c() {
        if (!this.f7324n) {
            this.f7313b = 100;
            return;
        }
        ((com.example.baselibrary.utils.e) this.f7314c.getValue()).removeCallbacksAndMessages(null);
        Iterator it = b().iterator();
        while (it.hasNext()) {
            s1 s1Var = (s1) ((u5.h) it.next());
            s1Var.m(100);
            s1Var.f();
        }
    }

    public final void d() {
        HealthSyncBean healthSyncBean = this.f7323m;
        if (healthSyncBean != null) {
            if (!healthSyncBean.isHasBloodOxyData()) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "没有需要同步的血氧数据...");
                g();
                return;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "开始同步血氧数据");
            c bleDataCallback = (c) this.f7319i.getValue();
            kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
            x5.b I0 = x5.b.I0();
            u5.e eVar = new u5.e();
            eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
            eVar.f18884b = bleDataCallback;
            I0.K0(eVar);
            this.f7313b = 60;
            if (r5.b.k().f18054c) {
                x5.d.c().j((byte) -91, new byte[0]);
            } else {
                x5.b.I0().F0((byte) -91);
            }
        }
    }

    public final void e() {
        HealthSyncBean healthSyncBean = this.f7323m;
        if (healthSyncBean != null) {
            if (!healthSyncBean.isHasBloodPressData()) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "没有需要同步的血压数据...");
                d();
                return;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "开始同步血压数据");
            d bleDataCallback = (d) this.f7318h.getValue();
            kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
            x5.b I0 = x5.b.I0();
            u5.e eVar = new u5.e();
            eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
            eVar.f18884b = bleDataCallback;
            I0.K0(eVar);
            this.f7313b = 50;
            if (r5.b.k().f18054c) {
                x5.d.c().j((byte) -92, new byte[0]);
            } else {
                x5.b.I0().F0((byte) -92);
            }
        }
    }

    public final void f() {
        HealthSyncBean healthSyncBean = this.f7323m;
        if (healthSyncBean != null) {
            if (!healthSyncBean.isHasBreatheData()) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "没有需要同步的呼吸数据...");
                j();
                return;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "开始同步呼吸数据");
            e bleDataCallback = (e) this.f7321k.getValue();
            kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
            x5.b I0 = x5.b.I0();
            u5.e eVar = new u5.e();
            eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
            eVar.f18884b = bleDataCallback;
            I0.K0(eVar);
            this.f7313b = 80;
            if (r5.b.k().f18054c) {
                x5.d.c().j((byte) -89, new byte[0]);
            } else {
                x5.b.I0().F0((byte) -89);
            }
        }
    }

    public final void g() {
        HealthSyncBean healthSyncBean = this.f7323m;
        if (healthSyncBean != null) {
            if (!healthSyncBean.isHasBodyTempData()) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "没有需要同步的体温数据...");
                f();
                return;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "开始同步体温数据");
            k bleDataCallback = (k) this.f7320j.getValue();
            kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
            x5.b I0 = x5.b.I0();
            u5.e eVar = new u5.e();
            eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
            eVar.f18884b = bleDataCallback;
            I0.K0(eVar);
            this.f7313b = 70;
            if (r5.b.k().f18054c) {
                x5.d.c().j((byte) -90, new byte[0]);
            } else {
                x5.b.I0().F0((byte) -90);
            }
        }
    }

    public final void h() {
        HealthSyncBean healthSyncBean = this.f7323m;
        if (healthSyncBean != null) {
            if (!healthSyncBean.isHasHrData()) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "没有需要同步的心率数据...");
                e();
                return;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "开始同步心率数据");
            g bleDataCallback = (g) this.f7317g.getValue();
            kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
            x5.b I0 = x5.b.I0();
            u5.e eVar = new u5.e();
            eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
            eVar.f18884b = bleDataCallback;
            I0.K0(eVar);
            this.f7313b = 40;
            if (r5.b.k().f18054c) {
                x5.d.c().j((byte) -93, new byte[0]);
            } else {
                x5.b.I0().F0((byte) -93);
            }
        }
    }

    public final void i() {
        HealthSyncBean healthSyncBean = this.f7323m;
        if (healthSyncBean != null) {
            if (!healthSyncBean.isHasSleepData()) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "没有需要同步的睡眠数据...");
                h();
                return;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "开始同步睡眠数据");
            h bleDataCallback = (h) this.f7316f.getValue();
            kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
            x5.b I0 = x5.b.I0();
            u5.e eVar = new u5.e();
            eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
            eVar.f18884b = bleDataCallback;
            I0.K0(eVar);
            this.f7313b = 30;
            if (r5.b.k().f18054c) {
                x5.d.c().j((byte) -94, new byte[0]);
            } else {
                x5.b.I0().F0((byte) -94);
            }
        }
    }

    public final void j() {
        HealthSyncBean healthSyncBean = this.f7323m;
        if (healthSyncBean != null) {
            if (!healthSyncBean.isHasSportData()) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "没有需要同步的运动数据，结束同步");
                c();
                return;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncDataService", "开始同步运动数据");
            i bleDataCallback = (i) this.f7322l.getValue();
            kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
            x5.b I0 = x5.b.I0();
            u5.e eVar = new u5.e();
            eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
            eVar.f18884b = bleDataCallback;
            I0.K0(eVar);
            this.f7313b = 99;
            if (r5.b.k().f18054c) {
                x5.d.c().j((byte) -88, new byte[0]);
            } else {
                x5.b.I0().F0((byte) -88);
            }
        }
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
        if (message.what == 0) {
            int i3 = this.f7312a;
            if (i3 < this.f7313b) {
                this.f7312a = i3 + 1;
            }
            if (!this.f7324n) {
                for (u5.h hVar : b()) {
                    int i10 = this.f7312a;
                    if (i10 > this.f7326p) {
                        ((s1) hVar).m(i10);
                        this.f7326p = this.f7312a;
                    }
                }
            }
            int i11 = this.f7313b;
            eh.b bVar = this.f7314c;
            if (i11 == 100) {
                ((com.example.baselibrary.utils.e) bVar.getValue()).sendEmptyMessageDelayed(0, 40L);
            } else {
                ((com.example.baselibrary.utils.e) bVar.getValue()).sendEmptyMessageDelayed(0, 100L);
            }
            if (this.f7312a == 100) {
                this.f7312a = 0;
                this.f7326p = 0;
                ((com.example.baselibrary.utils.e) bVar.getValue()).removeCallbacksAndMessages(null);
                Iterator it = b().iterator();
                while (it.hasNext()) {
                    ((s1) ((u5.h) it.next())).f();
                }
            }
        }
    }
}
