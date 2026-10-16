package com.example.test.presenter.sport;

import android.os.Message;
import com.example.blesdk.bean.sync.SportResultBean;
import com.example.test.ui.sport.activity.SportNewDetailJLActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.Timer;

/* loaded from: classes.dex */
public final class l extends com.example.baselibrary.preseneter.b implements e6.c {

    /* renamed from: b, reason: collision with root package name */
    public SportResultBean f7610b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f7611c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7612d;
    public Timer e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7613f;

    /* renamed from: g, reason: collision with root package name */
    public long f7614g;

    /* renamed from: h, reason: collision with root package name */
    public final eh.b f7615h;

    /* renamed from: i, reason: collision with root package name */
    public final eh.b f7616i;

    /* renamed from: j, reason: collision with root package name */
    public final eh.b f7617j;

    /* renamed from: k, reason: collision with root package name */
    public final eh.b f7618k;

    public l(SportNewDetailJLActivity sportNewDetailJLActivity) {
        super(sportNewDetailJLActivity);
        this.f7610b = new SportResultBean();
        this.f7611c = new ArrayList();
        this.f7615h = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.sport.SportNewDetailJLPresenter$sport3ResultCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final h invoke() {
                return new h(l.this);
            }
        });
        this.f7616i = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.sport.SportNewDetailJLPresenter$sportControlCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final i invoke() {
                return new i(l.this);
            }
        });
        this.f7617j = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.sport.SportNewDetailJLPresenter$sportGetControlCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final k invoke() {
                return new k(l.this);
            }
        });
        this.f7618k = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.sport.SportNewDetailJLPresenter$sportDataPushCallback$2
            {
                super(0);
            }

            @Override // oh.a
            public final j invoke() {
                return new j(l.this);
            }
        });
    }

    @Override // e6.c
    public final void b() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportDetailPresenter", "时间计算中");
        boolean z5 = this.f7613f;
        p5.a aVar = this.f7255a;
        if (z5) {
            SportNewDetailJLActivity sportNewDetailJLActivity = (SportNewDetailJLActivity) ((i7.d) aVar);
            sportNewDetailJLActivity.O = this.f7614g;
            sportNewDetailJLActivity.N.sendMessage(new Message());
            return;
        }
        long j4 = this.f7614g + 1;
        this.f7614g = j4;
        SportNewDetailJLActivity sportNewDetailJLActivity2 = (SportNewDetailJLActivity) ((i7.d) aVar);
        sportNewDetailJLActivity2.O = j4;
        sportNewDetailJLActivity2.N.sendMessage(new Message());
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        com.google.android.gms.internal.mlkit_vision_common.p.d((i) this.f7616i.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((k) this.f7617j.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.d((j) this.f7618k.getValue());
        Timer timer = this.e;
        if (timer != null) {
            timer.cancel();
        }
        this.e = null;
        this.f7612d = false;
    }

    public final void k(int i3) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 57);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", l0.j(i3, "进入多运动 "));
        char[] cArr = y5.b.f20001a;
        b3.g((byte) 57, new byte[]{2, 116, 0, (byte) (i3 & 255)}, new boolean[0]);
    }

    public final void l() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SportDetailPresenter syncSport", "开始同步运动数据");
        h bleDataCallback = (h) this.f7615h.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        if (r5.b.k().f18054c) {
            x5.c.b().g((byte) 113, new byte[]{5, 28, 16}, new boolean[0]);
        } else {
            x5.b.I0().F0((byte) 113);
        }
        this.f7613f = true;
    }
}
