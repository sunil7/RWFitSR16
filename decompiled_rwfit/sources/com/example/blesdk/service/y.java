package com.example.blesdk.service;

import android.os.Message;
import android.util.Log;
import com.example.blesdk.bean.sync.JLSleepSyncBean;
import com.example.blesdk.bean.sync.JLStepSyncBean;
import com.example.blesdk.bean.sync.StepItemBean;
import com.example.blesdk.bean.sync.StepSyncBean;
import com.example.test.service.s1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyThreadSafetyMode;

/* loaded from: classes.dex */
public final class y implements o5.a {

    /* renamed from: y, reason: collision with root package name */
    public static final Object f7339y = kotlin.a.a(LazyThreadSafetyMode.NONE, new oh.a() { // from class: com.example.blesdk.service.SyncJLDataService$Companion$service$2
        @Override // oh.a
        public final y invoke() {
            return new y();
        }
    });

    /* renamed from: a, reason: collision with root package name */
    public int f7340a;

    /* renamed from: b, reason: collision with root package name */
    public int f7341b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7342c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7343d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7344f;

    /* renamed from: g, reason: collision with root package name */
    public final eh.b f7345g = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncJLDataService$weakHandler$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.baselibrary.utils.e invoke() {
            return new com.example.baselibrary.utils.e(y.this);
        }
    });

    /* renamed from: h, reason: collision with root package name */
    public final eh.b f7346h = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncJLDataService$mAllSleepData$2
        @Override // oh.a
        public final List<JLSleepSyncBean> invoke() {
            return new ArrayList();
        }
    });

    /* renamed from: i, reason: collision with root package name */
    public final eh.b f7347i = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncJLDataService$mAllStepData$2
        @Override // oh.a
        public final List<StepSyncBean> invoke() {
            return new ArrayList();
        }
    });

    /* renamed from: j, reason: collision with root package name */
    public final eh.b f7348j = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncJLDataService$mAllHistoryStepData$2
        @Override // oh.a
        public final List<JLStepSyncBean> invoke() {
            return new ArrayList();
        }
    });

    /* renamed from: k, reason: collision with root package name */
    public final eh.b f7349k = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncJLDataService$stepJL2Callback$2
        {
            super(0);
        }

        @Override // oh.a
        public final w invoke() {
            return new w(y.this);
        }
    });

    /* renamed from: l, reason: collision with root package name */
    public final eh.b f7350l = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncJLDataService$stepCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final v invoke() {
            return new v(y.this);
        }
    });

    /* renamed from: m, reason: collision with root package name */
    public final eh.b f7351m = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncJLDataService$sleepCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final t invoke() {
            return new t(y.this);
        }
    });

    /* renamed from: n, reason: collision with root package name */
    public final eh.b f7352n = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncJLDataService$hrCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final p invoke() {
            return new p(y.this);
        }
    });

    /* renamed from: o, reason: collision with root package name */
    public final eh.b f7353o = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncJLDataService$bpCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final o invoke() {
            return new o(y.this);
        }
    });

    /* renamed from: p, reason: collision with root package name */
    public final eh.b f7354p = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncJLDataService$boCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final n invoke() {
            return new n(y.this);
        }
    });

    /* renamed from: q, reason: collision with root package name */
    public final eh.b f7355q = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncJLDataService$muslimCountCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final r invoke() {
            return new r(y.this);
        }
    });
    public final eh.b r;

    /* renamed from: s, reason: collision with root package name */
    public final eh.b f7356s;

    /* renamed from: t, reason: collision with root package name */
    public final eh.b f7357t;

    /* renamed from: u, reason: collision with root package name */
    public final eh.b f7358u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f7359v;

    /* renamed from: w, reason: collision with root package name */
    public final eh.b f7360w;

    /* renamed from: x, reason: collision with root package name */
    public int f7361x;

    public y() {
        kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncJLDataService$tempCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final x invoke() {
                return new x(y.this);
            }
        });
        this.r = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncJLDataService$bloodSugarCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final m invoke() {
                return new m(y.this);
            }
        });
        this.f7356s = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncJLDataService$pressureCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final s invoke() {
                return new s(y.this);
            }
        });
        this.f7357t = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncJLDataService$hrvCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final q invoke() {
                return new q(y.this);
            }
        });
        this.f7358u = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncJLDataService$sportCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final u invoke() {
                return new u(y.this);
            }
        });
        this.f7360w = kotlin.a.b(new oh.a() { // from class: com.example.blesdk.service.SyncJLDataService$callbacks$2
            @Override // oh.a
            public final List<u5.h> invoke() {
                return new ArrayList();
            }
        });
    }

    public static final ArrayList a(y yVar, List list) {
        yVar.getClass();
        StringBuilder sb2 = new StringBuilder("handleJLStepToJL2Step ");
        sb2.append(list != null ? Integer.valueOf(list.size()) : null);
        Log.e("qob", sb2.toString());
        ArrayList arrayList = new ArrayList();
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            StepSyncBean stepSyncBean = new StepSyncBean();
            stepSyncBean.setTime(((JLStepSyncBean) list.get(0)).getTime());
            String date = ((JLStepSyncBean) list.get(0)).getDate();
            ArrayList arrayList2 = new ArrayList();
            int steps = ((JLStepSyncBean) list.get(0)).getSteps();
            int calorie = ((JLStepSyncBean) list.get(0)).getCalorie();
            int distance = ((JLStepSyncBean) list.get(0)).getDistance();
            int size = list.size();
            for (int i3 = 1; i3 < size; i3++) {
                JLStepSyncBean jLStepSyncBean = (JLStepSyncBean) list.get(i3);
                if (kotlin.jvm.internal.e.a(jLStepSyncBean.getDate(), date)) {
                    StepItemBean stepItemBean = new StepItemBean();
                    String hour = jLStepSyncBean.getHour();
                    kotlin.jvm.internal.e.e(hour, "getHour(...)");
                    stepItemBean.setIndex(Integer.parseInt(hour));
                    stepItemBean.setSteps(jLStepSyncBean.getSteps());
                    stepItemBean.setCalorie(jLStepSyncBean.getCalorie());
                    stepItemBean.setDistance(jLStepSyncBean.getDistance());
                    arrayList2.add(stepItemBean);
                    int steps2 = jLStepSyncBean.getSteps() + steps;
                    int calorie2 = jLStepSyncBean.getCalorie() + calorie;
                    distance = jLStepSyncBean.getDistance() + distance;
                    calorie = calorie2;
                    steps = steps2;
                } else {
                    date = jLStepSyncBean.getDate();
                    stepSyncBean.setTotalSteps(steps);
                    stepSyncBean.setTotalCalorie(calorie);
                    stepSyncBean.setTotalDistance(distance);
                    stepSyncBean.setItems(arrayList2);
                    stepSyncBean.setItemCount(arrayList2.size());
                    arrayList.add(stepSyncBean);
                    stepSyncBean = new StepSyncBean();
                    stepSyncBean.setDate(date);
                    stepSyncBean.setTime(jLStepSyncBean.getTime());
                    ArrayList arrayList3 = new ArrayList();
                    StepItemBean stepItemBean2 = new StepItemBean();
                    String hour2 = jLStepSyncBean.getHour();
                    kotlin.jvm.internal.e.e(hour2, "getHour(...)");
                    stepItemBean2.setIndex(Integer.parseInt(hour2));
                    stepItemBean2.setSteps(jLStepSyncBean.getSteps());
                    stepItemBean2.setCalorie(jLStepSyncBean.getCalorie());
                    stepItemBean2.setDistance(jLStepSyncBean.getDistance());
                    arrayList3.add(stepItemBean2);
                    int steps3 = jLStepSyncBean.getSteps();
                    int calorie3 = jLStepSyncBean.getCalorie();
                    arrayList2 = arrayList3;
                    distance = jLStepSyncBean.getDistance();
                    calorie = calorie3;
                    steps = steps3;
                }
            }
            stepSyncBean.setTotalSteps(steps);
            stepSyncBean.setTotalCalorie(calorie);
            stepSyncBean.setTotalDistance(distance);
            stepSyncBean.setItems(arrayList2);
            stepSyncBean.setItemCount(arrayList2.size());
            arrayList.add(stepSyncBean);
        }
        return arrayList;
    }

    public static final void b(y yVar, int i3) {
        yVar.f7359v = true;
        Iterator it = yVar.m().iterator();
        while (it.hasNext()) {
            ((s1) ((u5.h) it.next())).e(i3);
        }
    }

    public static final void c(y yVar) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "onFinish " + yVar.f7359v + " currentMaxPro " + yVar.f7341b);
        if (!yVar.f7359v) {
            yVar.f7341b = 100;
            return;
        }
        yVar.p().removeCallbacksAndMessages(null);
        Iterator it = yVar.m().iterator();
        while (it.hasNext()) {
            s1 s1Var = (s1) ((u5.h) it.next());
            s1Var.m(100);
            s1Var.f();
        }
    }

    public static final void d(y yVar) {
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "开始同步血糖数据");
        m bleDataCallback = (m) yVar.r.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        yVar.f7341b = 70;
        if (r5.b.k().f18054c) {
            x5.c.b().g((byte) -112, new byte[]{5, 16, 16}, new boolean[0]);
        } else {
            x5.b.I0().F0((byte) -112);
        }
    }

    public static final void e(y yVar) {
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "开始同步血氧数据");
        com.google.android.gms.internal.mlkit_vision_common.p.U((n) yVar.f7354p.getValue());
        yVar.f7341b = 60;
        com.google.android.gms.internal.mlkit_vision_common.p.W();
    }

    public static final void f(y yVar) {
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "开始同步血压数据");
        o bleDataCallback = (o) yVar.f7353o.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        yVar.f7341b = 50;
        if (r5.b.k().f18054c) {
            x5.c.b().g((byte) -64, new byte[]{5, 4, 16}, new boolean[0]);
        } else {
            x5.b.I0().F0((byte) -64);
        }
    }

    public static final void g(y yVar) {
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "开始同步心率数据");
        p bleDataCallback = (p) yVar.f7352n.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        yVar.f7341b = 40;
        if (r5.b.k().f18054c) {
            x5.c.b().g((byte) -62, new byte[]{5, 3, 16}, new boolean[0]);
        } else {
            x5.b.I0().F0((byte) -62);
        }
    }

    public static final void h(y yVar) {
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "开始同步HRV数据");
        q bleDataCallback = (q) yVar.f7357t.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        yVar.f7341b = 80;
        if (r5.b.k().f18054c) {
            x5.c.b().g((byte) -72, new byte[]{5, 10, 16}, new boolean[0]);
        } else {
            x5.b.I0().F0((byte) -72);
        }
    }

    public static final void i(y yVar) {
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "开始同步Muslim计数数据");
        r bleDataCallback = (r) yVar.f7355q.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        yVar.f7341b = 90;
        if (r5.b.k().f18054c) {
            x5.c.b().g((byte) -110, new byte[]{5, 23, 16}, new boolean[0]);
        } else {
            x5.b.I0().F0((byte) -110);
        }
    }

    public static final void j(y yVar) {
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "开始同步压力数据");
        s bleDataCallback = (s) yVar.f7356s.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        yVar.f7341b = 80;
        if (r5.b.k().f18054c) {
            x5.c.b().g((byte) -74, new byte[]{5, 13, 16}, new boolean[0]);
        } else {
            x5.b.I0().F0((byte) -74);
        }
    }

    public static final void k(y yVar) {
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "开始同步睡眠数据");
        yVar.n().clear();
        t bleDataCallback = (t) yVar.f7351m.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        yVar.f7341b = 30;
        if (r5.b.k().f18054c) {
            x5.c.b().g((byte) -66, new byte[]{5, 5, 16}, new boolean[0]);
        } else {
            x5.b.I0().F0((byte) -66);
        }
    }

    public static final void l(y yVar) {
        yVar.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "开始同步运动数据");
        u bleDataCallback = (u) yVar.f7358u.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        yVar.f7341b = 99;
        if (r5.b.k().f18054c) {
            x5.c.b().g((byte) -83, new byte[]{5, 14, 16}, new boolean[0]);
        } else {
            x5.b.I0().F0((byte) -83);
        }
    }

    public final List m() {
        return (List) this.f7360w.getValue();
    }

    public final List n() {
        return (List) this.f7346h.getValue();
    }

    public final List o() {
        return (List) this.f7347i.getValue();
    }

    public final com.example.baselibrary.utils.e p() {
        return (com.example.baselibrary.utils.e) this.f7345g.getValue();
    }

    public final void q() {
        boolean z5 = this.f7342c;
        eh.b bVar = this.f7350l;
        if (z5) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "开始同步步数数据 isActivityDataStaticTran2");
            v bleDataCallback = (v) bVar.getValue();
            kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
            x5.b I0 = x5.b.I0();
            u5.e eVar = new u5.e();
            eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
            eVar.f18884b = bleDataCallback;
            I0.K0(eVar);
            this.f7341b = 20;
            if (r5.b.k().f18054c) {
                x5.c.b().g((byte) -60, new byte[]{5, 2, 16}, new boolean[0]);
                return;
            } else {
                x5.b.I0().F0((byte) -60);
                return;
            }
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "开始同步步数数据");
        v bleDataCallback2 = (v) bVar.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback2, "bleDataCallback");
        x5.b I02 = x5.b.I0();
        u5.e eVar2 = new u5.e();
        eVar2.f18883a = new com.example.baselibrary.utils.e(eVar2);
        eVar2.f18884b = bleDataCallback2;
        I02.K0(eVar2);
        p().sendEmptyMessage(0);
        this.f7341b = 20;
        this.f7361x = 0;
        this.f7340a = 0;
        this.f7359v = false;
        if (r5.b.k().f18054c) {
            x5.c.b().g((byte) -60, new byte[]{5, 2, 16}, new boolean[0]);
        } else {
            x5.b.I0().F0((byte) -60);
        }
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
        Log.e("qob", "SyncJLDataService " + message);
        if (message.what == 0) {
            int i3 = this.f7340a;
            if (i3 < this.f7341b) {
                this.f7340a = i3 + 1;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "onSyncProgressChange " + this.f7340a);
            if (!this.f7359v) {
                for (u5.h hVar : m()) {
                    int i10 = this.f7340a;
                    if (i10 > this.f7361x) {
                        ((s1) hVar).m(i10);
                        this.f7361x = this.f7340a;
                    }
                }
            }
            if (this.f7341b == 100) {
                p().sendEmptyMessageDelayed(0, 40L);
            } else {
                p().sendEmptyMessageDelayed(0, 100L);
            }
            if (this.f7340a == 100) {
                this.f7340a = 0;
                this.f7361x = 0;
                p().removeCallbacksAndMessages(null);
                Iterator it = m().iterator();
                while (it.hasNext()) {
                    ((s1) ((u5.h) it.next())).f();
                }
            }
        }
    }
}
