package com.example.test.presenter.main;

import android.content.Context;
import android.content.Intent;
import com.example.blesdk.bean.sync.NewSportBean;
import com.example.test.ui.RingBaseActivity;
import com.example.test.ui.sport.activity.SportNewDetailJLActivity;
import java.util.Date;

/* loaded from: classes.dex */
public final class y0 implements v5.r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e7.b f7582a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z0 f7583b;

    public y0(e7.b bVar, z0 z0Var) {
        this.f7582a = bVar;
        this.f7583b = z0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "sportCallback", com.google.android.gms.internal.mlkit_vision_barcode.l0.k(i3, "运动同步失败[", "]"));
        ((RingBaseActivity) this.f7582a).b0();
    }

    @Override // u5.g
    public final void c() {
        ((RingBaseActivity) this.f7582a).b0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u5.g
    public final void e(Object obj) {
        Integer status;
        NewSportBean data = (NewSportBean) obj;
        kotlin.jvm.internal.e.f(data, "data");
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SportGetControlCallback", "重新定位到旧页面");
        boolean z5 = z0.e;
        e7.b bVar = this.f7582a;
        if (z5) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SportGetControlCallback", "运动因蓝牙断开中断，不恢复，通知设备退出多运动");
            if (r5.b.k().f18054c) {
                x5.c b3 = x5.c.b();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "进入多运动 0");
                char[] cArr = y5.b.f20001a;
                b3.g((byte) 57, new byte[]{2, 116, 0, (byte) 0}, new boolean[0]);
            } else {
                x5.b.I0().F0((byte) 57);
            }
            z0.e = false;
            ((RingBaseActivity) bVar).b0();
            return;
        }
        if (z0.f7585d) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "SportGetControlCallback", "运动页面已打开，忽略重复推送");
            ((RingBaseActivity) bVar).b0();
            return;
        }
        long time = new Date().getTime();
        z0 z0Var = this.f7583b;
        long j4 = (time - z0Var.f7586b) / 1000;
        if (data.getSportType() != null) {
            Integer sportType = data.getSportType();
            kotlin.jvm.internal.e.e(sportType, "getSportType(...)");
            if (sportType.intValue() > 0 && (((status = data.getStatus()) == null || status.intValue() != 4) && j4 > 5)) {
                z0.f7585d = true;
                int i3 = SportNewDetailJLActivity.Q;
                Context f02 = bVar.f0();
                kotlin.jvm.internal.e.c(f02);
                Integer sportType2 = data.getSportType();
                kotlin.jvm.internal.e.e(sportType2, "getSportType(...)");
                int intValue = sportType2.intValue();
                Integer status2 = data.getStatus();
                kotlin.jvm.internal.e.e(status2, "getStatus(...)");
                int intValue2 = status2.intValue();
                Intent intent = new Intent(f02, (Class<?>) SportNewDetailJLActivity.class);
                intent.addFlags(67108864);
                intent.putExtra("sport_type", intValue);
                intent.putExtra("sport_status", intValue2);
                SportNewDetailJLActivity.Q = 1;
                f02.startActivity(intent);
                z0Var.f7586b = new Date().getTime();
            }
        }
        ((RingBaseActivity) bVar).b0();
    }
}
