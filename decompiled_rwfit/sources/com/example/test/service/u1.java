package com.example.test.service;

import android.app.Activity;
import android.os.Message;
import android.util.Log;
import com.example.blesdk.bean.function.PersonBean;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.ui.main.activity.SplashSelectActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.LazyThreadSafetyMode;

/* loaded from: classes.dex */
public final class u1 implements o5.a, u5.d {

    /* renamed from: u, reason: collision with root package name */
    public static final Object f7811u = kotlin.a.a(LazyThreadSafetyMode.NONE, new oh.a() { // from class: com.example.test.service.SyncService$Companion$sInstance$2
        @Override // oh.a
        public final u1 invoke() {
            return new u1();
        }
    });

    /* renamed from: a, reason: collision with root package name */
    public com.example.test.ui.dialog.h f7812a;

    /* renamed from: b, reason: collision with root package name */
    public int f7813b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7814c;

    /* renamed from: d, reason: collision with root package name */
    public Activity f7815d;
    public final eh.b e = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SyncService$weakHandler$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.baselibrary.utils.e invoke() {
            return new com.example.baselibrary.utils.e(u1.this);
        }
    });

    /* renamed from: f, reason: collision with root package name */
    public final eh.b f7816f = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SyncService$syncCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final s1 invoke() {
            return new s1(u1.this);
        }
    });

    /* renamed from: g, reason: collision with root package name */
    public final eh.b f7817g = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SyncService$initDeviceCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final k1 invoke() {
            return new k1(u1.this);
        }
    });

    /* renamed from: h, reason: collision with root package name */
    public final eh.b f7818h = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SyncService$supportV2Callback$2
        {
            super(0);
        }

        @Override // oh.a
        public final q1 invoke() {
            return new q1(u1.this);
        }
    });

    /* renamed from: i, reason: collision with root package name */
    public final eh.b f7819i = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SyncService$supportCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final p1 invoke() {
            return new p1(u1.this);
        }
    });

    /* renamed from: j, reason: collision with root package name */
    public final eh.b f7820j = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SyncService$switchCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final r1 invoke() {
            return new r1(u1.this);
        }
    });

    /* renamed from: k, reason: collision with root package name */
    public final eh.b f7821k = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SyncService$btInfoCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final i1 invoke() {
            return new i1(u1.this);
        }
    });

    /* renamed from: l, reason: collision with root package name */
    public final eh.b f7822l = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SyncService$ringLedLightCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final m1 invoke() {
            return new m1(u1.this);
        }
    });

    /* renamed from: m, reason: collision with root package name */
    public final eh.b f7823m = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SyncService$muslimCountSwitchCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final l1 invoke() {
            return new l1(u1.this);
        }
    });

    /* renamed from: n, reason: collision with root package name */
    public final eh.b f7824n;

    /* renamed from: o, reason: collision with root package name */
    public final eh.b f7825o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f7826p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f7827q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public com.example.test.ui.dialog.r f7828s;

    /* renamed from: t, reason: collision with root package name */
    public final eh.b f7829t;

    public u1() {
        kotlin.a.b(new oh.a() { // from class: com.example.test.service.SyncService$vibrationCountCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final t1 invoke() {
                return new t1(u1.this);
            }
        });
        this.f7824n = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SyncService$ringVideoHidCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final n1 invoke() {
                return new n1(u1.this);
            }
        });
        this.f7825o = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SyncService$ringWearHandCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final o1 invoke() {
                return new o1(u1.this);
            }
        });
        this.r = true;
        this.f7829t = kotlin.a.b(new oh.a() { // from class: com.example.test.service.SyncService$deviceUnbindControlCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final j1 invoke() {
                return new j1(u1.this);
            }
        });
    }

    public static void d() {
        User d5;
        if (!e.h().i()) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化用户信息失败 设备未连接");
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "初始化用户信息");
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (d5 = kVar.d()) == null) {
            return;
        }
        PersonBean personBean = new PersonBean();
        personBean.setNickName(d5.getName());
        personBean.setGender(d5.getSex() == 1 ? 1 : 0);
        try {
            Locale.setDefault(Locale.US);
            String format = new DecimalFormat("##0.0").format(d5.getHeight());
            kotlin.jvm.internal.e.e(format, "format(...)");
            personBean.setHeight(Float.parseFloat(format));
            String format2 = new DecimalFormat("##0.0").format(d5.getWeight());
            kotlin.jvm.internal.e.e(format2, "format(...)");
            personBean.setWeight(Float.parseFloat(format2));
        } catch (Exception unused) {
        }
        personBean.setStepTarget(d5.getStepsTarget());
        Calendar calendar = Calendar.getInstance();
        String birthday = d5.getBirthday();
        if (birthday != null) {
            calendar.setTimeInMillis(Long.parseLong(birthday) * 1000);
        }
        personBean.setBirthdayYear(calendar.get(1));
        personBean.setBirthdayMonth(calendar.get(2) + 1);
        personBean.setBirthdayDay(calendar.get(5));
        personBean.setMeasureUnit(d5.getMeterUnit());
        if (y5.d.f20005b) {
            com.google.android.gms.internal.mlkit_vision_common.p.Q(personBean);
        } else {
            com.google.android.gms.internal.mlkit_vision_common.p.x(personBean);
        }
    }

    @Override // u5.d
    public final void I(s5.a aVar, int i3) {
        a();
    }

    public final void a() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", r5.a.d("deviceDisconnectJL ", this.f7814c));
        Object obj = com.example.blesdk.service.y.f7339y;
        com.example.blesdk.service.y a3 = com.google.android.gms.internal.mlkit_vision_barcode.i1.a();
        a3.p().removeCallbacksAndMessages(null);
        Iterator it = a3.m().iterator();
        while (it.hasNext()) {
            s1 s1Var = (s1) ((u5.h) it.next());
            s1Var.m(100);
            s1Var.f();
        }
        com.example.test.ui.dialog.h hVar = this.f7812a;
        if (hVar != null && hVar.isShowing()) {
            com.example.baselibrary.utils.d.a(R$string.str_syncing_fail);
            com.example.test.ui.dialog.h hVar2 = this.f7812a;
            if (hVar2 != null) {
                hVar2.dismiss();
            }
        }
        this.f7814c = true;
        this.f7826p = false;
        this.f7827q = false;
        b().removeCallbacksAndMessages(null);
    }

    public final com.example.baselibrary.utils.e b() {
        return (com.example.baselibrary.utils.e) this.e.getValue();
    }

    public final void c() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "======== initDeviceInfo");
        b().postDelayed(new h1(this, 0), 1000L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
    
        if (r0.isFinishing() == true) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
    
        if (r0.isDestroyed() == true) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008d A[Catch: all -> 0x0091, TRY_LEAVE, TryCatch #0 {all -> 0x0091, blocks: (B:30:0x0089, B:32:0x008d), top: B:29:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e() {
        /*
            r6 = this;
            r5.b r0 = r5.b.k()
            s5.a r1 = r0.e
            java.lang.String r2 = "SyncService"
            if (r1 != 0) goto Lb
            goto L24
        Lb:
            android.bluetooth.BluetoothDevice r1 = r0.f18057g
            if (r1 != 0) goto L10
            goto L24
        L10:
            int r1 = r1.getBondState()
            r3 = 12
            if (r1 == r3) goto Lb2
            android.bluetooth.BluetoothDevice r0 = r0.f18057g
            int r0 = r0.getBondState()
            r1 = 11
            if (r0 != r1) goto L24
            goto Lb2
        L24:
            com.example.test.ui.dialog.r r0 = r6.f7828s
            r1 = 0
            if (r0 != 0) goto L4d
            com.example.test.XXApplication r0 = com.example.test.XXApplication.f7400h
            com.example.test.XXApplication r0 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a()
            android.app.Activity r0 = r0.c()
            if (r0 == 0) goto L4a
            com.example.test.ui.dialog.r r3 = new com.example.test.ui.dialog.r
            r3.<init>(r0)
            int r0 = com.example.test.R$string.str_hid_tips
            r3.b(r0)
            y2.f r0 = new y2.f
            r4 = 10
            r0.<init>(r6, r4)
            r3.setOnDialogListener(r0)
            goto L4b
        L4a:
            r3 = r1
        L4b:
            r6.f7828s = r3
        L4d:
            com.example.test.ui.dialog.r r0 = r6.f7828s
            r3 = 1
            if (r0 == 0) goto L75
            com.example.test.XXApplication r0 = com.example.test.XXApplication.f7400h
            com.example.test.XXApplication r0 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a()
            android.app.Activity r0 = r0.c()
            if (r0 == 0) goto L65
            boolean r0 = r0.isFinishing()
            if (r0 != r3) goto L65
            goto L75
        L65:
            com.example.test.XXApplication r0 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a()
            android.app.Activity r0 = r0.c()
            if (r0 == 0) goto L89
            boolean r0 = r0.isDestroyed()
            if (r0 != r3) goto L89
        L75:
            java.lang.String r0 = "======== isDestroyed"
            java.lang.Object[] r0 = new java.lang.Object[]{r2, r0}
            java.lang.String r4 = com.example.baselibrary.utils.b.f7264b
            com.example.baselibrary.utils.b.o(r4, r0)
            com.example.baselibrary.utils.e r0 = r6.b()
            r4 = 500(0x1f4, double:2.47E-321)
            r0.sendEmptyMessageDelayed(r3, r4)
        L89:
            com.example.test.ui.dialog.r r0 = r6.f7828s     // Catch: java.lang.Throwable -> L91
            if (r0 == 0) goto Lb1
            r0.show()     // Catch: java.lang.Throwable -> L91
            return
        L91:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            java.lang.String r4 = "show hid dialog "
            java.lang.String r0 = com.google.android.gms.internal.mlkit_vision_barcode.l0.n(r4, r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r2, r0}
            java.lang.String r2 = com.example.baselibrary.utils.b.f7264b
            com.example.baselibrary.utils.b.o(r2, r0)
            r6.f7828s = r1
            com.example.baselibrary.utils.e r0 = r6.b()
            r0.removeMessages(r3)
            r6.e()
        Lb1:
            return
        Lb2:
            java.lang.String r0 = "设备HID已配对"
            java.lang.Object[] r0 = new java.lang.Object[]{r2, r0}
            java.lang.String r1 = com.example.baselibrary.utils.b.f7264b
            com.example.baselibrary.utils.b.o(r1, r0)
            r6.c()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.service.u1.e():void");
    }

    @Override // u5.d
    public final void e0(s5.a aVar) {
        a();
    }

    public final void f() {
        Activity activity;
        if (this.f7814c) {
            return;
        }
        XXApplication xXApplication = XXApplication.f7400h;
        if (kotlin.jvm.internal.e.a(com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c(), SplashSelectActivity.class)) {
            return;
        }
        com.example.test.ui.dialog.h hVar = null;
        if (this.f7812a == null) {
            Log.e("qob", "SyncService syncDialog == null");
            this.f7815d = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c();
            Activity c9 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c();
            if (c9 != null) {
                hVar = new com.example.test.ui.dialog.h(c9);
                hVar.f7965b = c9;
                hVar.setCancelable(false);
            }
            this.f7812a = hVar;
        } else {
            Activity c10 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c();
            com.example.test.ui.dialog.h hVar2 = this.f7812a;
            Log.e("qob", "SyncService syncDialog != null CurrentActivity " + c10 + " getMContext " + ((hVar2 == null || (activity = hVar2.f7965b) == null) ? null : activity.getClass()));
            Activity c11 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c();
            com.example.test.ui.dialog.h hVar3 = this.f7812a;
            if (!kotlin.jvm.internal.e.a(c11, hVar3 != null ? hVar3.f7965b : null)) {
                com.example.test.ui.dialog.h hVar4 = this.f7812a;
                if (hVar4 != null) {
                    hVar4.dismiss();
                }
                this.f7812a = null;
                this.f7815d = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c();
                Activity c12 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c();
                if (c12 != null) {
                    hVar = new com.example.test.ui.dialog.h(c12);
                    hVar.f7965b = c12;
                    hVar.setCancelable(false);
                }
                this.f7812a = hVar;
            }
        }
        b().postDelayed(new h1(this, 1), 0L);
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [eh.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7, types: [eh.b, java.lang.Object] */
    public final void g() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", r5.a.d("是否正在同步：", this.f7826p));
        if (!e.h().i() || this.f7826p) {
            return;
        }
        this.r = true;
        this.f7813b = 0;
        this.f7814c = false;
        this.f7826p = true;
        boolean z5 = y5.d.f20005b;
        eh.b bVar = this.f7816f;
        Object obj = null;
        if (!z5) {
            com.example.blesdk.service.l lVar = (com.example.blesdk.service.l) com.example.blesdk.service.l.f7311q.getValue();
            s1 syncCallback = (s1) bVar.getValue();
            lVar.getClass();
            kotlin.jvm.internal.e.f(syncCallback, "syncCallback");
            Iterator it = lVar.b().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (kotlin.jvm.internal.e.a((u5.h) next, syncCallback)) {
                    obj = next;
                    break;
                }
            }
            if (((u5.h) obj) == null) {
                lVar.b().add(syncCallback);
            }
            com.example.blesdk.service.l lVar2 = (com.example.blesdk.service.l) com.example.blesdk.service.l.f7311q.getValue();
            lVar2.getClass();
            com.example.blesdk.service.f bleDataCallback = (com.example.blesdk.service.f) lVar2.f7315d.getValue();
            kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
            x5.b I0 = x5.b.I0();
            u5.e eVar = new u5.e();
            eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
            eVar.f18884b = bleDataCallback;
            I0.K0(eVar);
            ((com.example.baselibrary.utils.e) lVar2.f7314c.getValue()).sendEmptyMessage(0);
            lVar2.f7313b = 10;
            lVar2.f7326p = 0;
            lVar2.f7312a = 0;
            lVar2.f7324n = false;
            if (r5.b.k().f18054c) {
                if (r5.b.k().f18054c) {
                    x5.d.c().j((byte) -96, new byte[0]);
                    return;
                } else {
                    x5.b.I0().F0((byte) -96);
                    return;
                }
            }
            return;
        }
        Object obj2 = com.example.blesdk.service.y.f7339y;
        com.example.blesdk.service.y a3 = com.google.android.gms.internal.mlkit_vision_barcode.i1.a();
        s1 syncCallback2 = (s1) bVar.getValue();
        a3.getClass();
        kotlin.jvm.internal.e.f(syncCallback2, "syncCallback");
        Iterator it2 = a3.m().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (kotlin.jvm.internal.e.a((u5.h) next2, syncCallback2)) {
                obj = next2;
                break;
            }
        }
        if (((u5.h) obj) == null) {
            a3.m().add(syncCallback2);
        }
        Object obj3 = com.example.test.utils.m.f8734b;
        Log.e("qob", "startSync isSupportStress " + d2.a().d());
        Object obj4 = com.example.blesdk.service.y.f7339y;
        com.google.android.gms.internal.mlkit_vision_barcode.i1.a().f7343d = d2.a().d();
        com.google.android.gms.internal.mlkit_vision_barcode.i1.a().e = d2.a().b();
        com.example.blesdk.service.y a10 = com.google.android.gms.internal.mlkit_vision_barcode.i1.a();
        SupportMenuBean supportMenuBean = d2.a().f8735a;
        a10.f7344f = supportMenuBean != null ? supportMenuBean.isMuslimCountData() : false;
        if (!d2.a().a()) {
            com.google.android.gms.internal.mlkit_vision_barcode.i1.a().f7342c = false;
            com.google.android.gms.internal.mlkit_vision_barcode.i1.a().q();
            return;
        }
        Log.e("SyncService", "startSyncTodayStep");
        com.example.blesdk.service.y a11 = com.google.android.gms.internal.mlkit_vision_barcode.i1.a();
        a11.f7342c = true;
        x5.b.I0().e = 0;
        a11.o().clear();
        ((List) a11.f7348j.getValue()).clear();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SyncJLDataService", "开始同步杰里2步数数据");
        com.example.blesdk.service.w bleDataCallback2 = (com.example.blesdk.service.w) a11.f7349k.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback2, "bleDataCallback");
        x5.b I02 = x5.b.I0();
        u5.e eVar2 = new u5.e();
        eVar2.f18883a = new com.example.baselibrary.utils.e(eVar2);
        eVar2.f18884b = bleDataCallback2;
        I02.K0(eVar2);
        a11.p().sendEmptyMessage(0);
        a11.f7341b = 10;
        a11.f7361x = 0;
        a11.f7340a = 0;
        a11.f7359v = false;
        if (r5.b.k().f18054c) {
            x5.c.b().g((byte) -105, new byte[]{5, 26, 16}, new boolean[0]);
        } else {
            x5.b.I0().F0((byte) -105);
        }
    }

    public final void h() {
        j1 bleDataCallback = (j1) this.f7829t.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        if (r5.b.k().f18054c) {
            x5.d.c().j((byte) 68, new byte[0]);
        } else {
            x5.b.I0().F0((byte) 68);
        }
    }

    @Override // u5.d
    public final void h0(s5.a aVar) {
    }

    @Override // u5.d
    public final void m0(s5.a aVar) {
    }

    @Override // u5.d
    public final void o() {
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 != 1) {
                return;
            }
            if (r5.b.k().f18054c && this.r) {
                e();
                return;
            } else {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "蓝牙已断开或者正在解绑中...");
                return;
            }
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(this.f7813b, "currentProgress "));
        int i10 = this.f7813b;
        if (i10 < 10) {
            this.f7813b = i10 + 1;
            f();
            b().sendEmptyMessageDelayed(0, 300L);
        }
    }

    @Override // u5.d
    public final void v(s5.a aVar) {
        a();
    }
}
