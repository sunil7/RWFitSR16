package u5;

import android.os.Message;
import com.example.blesdk.service.t;
import com.example.blesdk.service.v;
import com.example.test.presenter.device.e1;
import com.example.test.presenter.device.l1;
import com.example.test.presenter.device.m1;
import com.example.test.presenter.device.n1;
import com.example.test.presenter.device.u0;
import com.example.test.presenter.main.w;
import com.example.test.service.i1;
import com.example.test.service.m;
import com.example.test.service.o0;
import com.example.test.ui.testui.c0;
import com.example.test.utils.y0;
import v5.a0;
import v5.b0;
import v5.d0;
import v5.e0;
import v5.f0;
import v5.g0;
import v5.h0;
import v5.i0;
import v5.j0;
import v5.k;
import v5.k0;
import v5.l;
import v5.l0;
import v5.m0;
import v5.n;
import v5.o;
import v5.p;
import v5.q;
import v5.r;
import v5.s;
import v5.u;
import v5.x;
import v5.y;
import v5.z;

/* loaded from: classes.dex */
public final class e implements c, o5.a {

    /* renamed from: a, reason: collision with root package name */
    public com.example.baselibrary.utils.e f18883a;

    /* renamed from: b, reason: collision with root package name */
    public g f18884b;

    @Override // u5.c
    public final void d(int i3, int i10) {
        Message message = new Message();
        message.what = 2;
        message.obj = Integer.valueOf(i10);
        this.f18883a.sendMessage(message);
    }

    @Override // u5.c
    public final byte[] e() {
        boolean z5 = y5.d.f20005b;
        g gVar = this.f18884b;
        return z5 ? gVar instanceof com.example.test.service.c ? new byte[]{-3} : gVar instanceof v5.a ? new byte[]{-32, -33, -34, -35} : gVar instanceof e1 ? new byte[]{-79, -80, -81, -82} : gVar instanceof com.example.test.service.d ? new byte[]{-5} : gVar instanceof k0 ? new byte[]{-27, -28} : gVar instanceof v5.b ? new byte[]{-29, -30} : gVar instanceof v5.d ? new byte[]{-21, -22, 50, 51} : gVar instanceof j0 ? new byte[]{-108, -107} : gVar instanceof l0 ? new byte[]{19, 20} : gVar instanceof com.example.test.presenter.mine.i ? new byte[]{22, 23} : gVar instanceof v5.c ? new byte[]{24, 25} : gVar instanceof m0 ? new byte[]{29, 30} : gVar instanceof m1 ? new byte[]{-46, -97} : gVar instanceof v5.e ? new byte[]{-25, -26} : gVar instanceof v5.g ? new byte[]{-36, -37} : gVar instanceof g0 ? new byte[]{-43, -44} : gVar instanceof m ? new byte[]{-59, -99, -100, -101, 34, 37, 46, 117} : gVar instanceof com.example.test.presenter.device.m ? new byte[]{-47, -48} : gVar instanceof d0 ? new byte[]{-53, -54} : gVar instanceof e0 ? new byte[]{75, 74} : gVar instanceof h0 ? new byte[]{32, 33} : gVar instanceof i0 ? new byte[]{35, 36} : gVar instanceof f0 ? new byte[]{38, 39} : gVar instanceof com.example.test.presenter.device.d0 ? new byte[]{40, 41} : gVar instanceof l ? new byte[]{65, 72} : gVar instanceof u0 ? new byte[]{42, 47} : gVar instanceof c0 ? new byte[]{44, 45} : gVar instanceof l1 ? new byte[]{-55, -56} : gVar instanceof w ? new byte[]{-51, -52} : gVar instanceof v5.h ? new byte[]{-14} : gVar instanceof v5.j ? new byte[]{43} : gVar instanceof v5.m ? new byte[]{-13} : gVar instanceof o ? new byte[]{-23, -24} : gVar instanceof u ? new byte[]{-41, -90} : gVar instanceof v5.c0 ? new byte[]{-7} : gVar instanceof com.example.test.service.l ? new byte[]{-40} : gVar instanceof com.example.test.service.i ? new byte[]{-89} : gVar instanceof y0 ? new byte[]{-76, -77} : gVar instanceof com.example.test.service.u ? new byte[]{-96} : gVar instanceof w5.f ? new byte[]{-42} : gVar instanceof w5.d ? new byte[]{-57} : gVar instanceof w5.h ? new byte[]{-78} : gVar instanceof r ? new byte[]{71} : gVar instanceof w5.g ? new byte[]{31} : gVar instanceof q ? new byte[]{-58, 57} : gVar instanceof v ? new byte[]{-60} : gVar instanceof t ? new byte[]{-66} : gVar instanceof y ? new byte[]{-62} : gVar instanceof x ? new byte[]{-64} : gVar instanceof v5.w ? new byte[]{-70} : gVar instanceof b0 ? new byte[]{-68} : gVar instanceof z ? new byte[]{-72} : gVar instanceof a0 ? new byte[]{-74} : gVar instanceof v5.v ? new byte[]{-112} : gVar instanceof com.example.blesdk.service.r ? new byte[]{-110} : gVar instanceof s ? new byte[]{-83} : gVar instanceof p ? new byte[]{113} : gVar instanceof k ? new byte[]{-106} : gVar instanceof com.example.blesdk.service.w ? new byte[]{-105} : gVar instanceof com.example.blesdk.service.e ? new byte[]{-89} : gVar instanceof v5.t ? new byte[]{18} : gVar instanceof com.example.test.presenter.device.l0 ? new byte[]{66, 67} : gVar instanceof com.example.test.presenter.device.h ? new byte[]{68, 69} : gVar instanceof v5.i ? new byte[]{70} : new byte[0] : gVar instanceof com.example.test.service.c ? new byte[]{2, 32, -2} : gVar instanceof v5.a ? new byte[]{9, 101, 40} : gVar instanceof i1 ? new byte[]{14, 15} : gVar instanceof v5.b ? new byte[]{10, 102, 41} : gVar instanceof v5.d ? new byte[]{11, 103, 42} : gVar instanceof v5.f ? new byte[]{4} : gVar instanceof v5.e ? new byte[]{13, 105, 44} : gVar instanceof v5.g ? new byte[]{7, 99, 38} : gVar instanceof v5.h ? new byte[]{0} : gVar instanceof v5.j ? new byte[]{12, 104, 43} : gVar instanceof o0 ? new byte[]{17} : gVar instanceof v5.m ? new byte[]{1, 96} : gVar instanceof n ? new byte[]{8, 100, 39} : gVar instanceof o ? new byte[]{6, 98, 37} : gVar instanceof v5.t ? new byte[]{3} : gVar instanceof u ? new byte[]{5, 34, 35} : gVar instanceof v5.c0 ? new byte[]{106, 64} : gVar instanceof com.example.test.service.l ? new byte[]{107} : gVar instanceof com.example.test.service.t ? new byte[]{108} : gVar instanceof com.example.test.service.i ? new byte[]{109} : gVar instanceof w5.a ? new byte[]{45} : gVar instanceof y0 ? new byte[]{49} : gVar instanceof w5.f ? new byte[]{65} : gVar instanceof w5.d ? new byte[]{67} : gVar instanceof w5.e ? new byte[]{68} : gVar instanceof w5.h ? new byte[]{69} : gVar instanceof com.example.blesdk.service.f ? new byte[]{-96} : gVar instanceof com.example.blesdk.service.j ? new byte[]{-95} : gVar instanceof com.example.blesdk.service.h ? new byte[]{-94} : gVar instanceof y ? new byte[]{-93} : gVar instanceof x ? new byte[]{-92} : gVar instanceof v5.w ? new byte[]{-91} : gVar instanceof b0 ? new byte[]{-90} : gVar instanceof com.example.blesdk.service.e ? new byte[]{-89} : gVar instanceof com.example.blesdk.service.i ? new byte[]{-88} : gVar instanceof m ? new byte[]{97} : gVar instanceof com.example.test.presenter.device.l ? new byte[]{18} : gVar instanceof com.example.test.service.b0 ? new byte[]{111} : gVar instanceof com.example.test.presenter.device.r ? new byte[]{19} : gVar instanceof k ? new byte[]{-81} : gVar instanceof com.example.test.service.z ? new byte[]{Byte.MIN_VALUE} : gVar instanceof com.example.test.service.n ? new byte[]{112} : gVar instanceof n1 ? new byte[]{52, 20} : gVar instanceof com.example.test.service.r ? new byte[]{114} : gVar instanceof com.example.test.service.s ? new byte[]{Byte.MAX_VALUE} : gVar instanceof com.example.test.utils.r ? new byte[]{54} : new byte[0];
    }

    @Override // u5.c
    public final void f(Object obj) {
        com.example.baselibrary.utils.e eVar = this.f18883a;
        eVar.removeMessages(0);
        Message message = new Message();
        message.what = 3;
        message.obj = obj;
        eVar.sendMessage(message);
    }

    @Override // u5.c
    public final b g() {
        return this.f18884b;
    }

    @Override // u5.c
    public final void h(byte b3, byte b10) {
        if (b10 != 0) {
            char[] cArr = y5.b.f20001a;
            d(b3 & 255, b10 & 255);
            return;
        }
        boolean z5 = y5.d.f20005b;
        com.example.baselibrary.utils.e eVar = this.f18883a;
        if (z5 ? b3 == -11 || b3 == -12 || b3 == -15 || b3 == -16 || b3 == -17 || b3 == -18 || b3 == -19 || b3 == -20 || b3 == -21 || b3 == -23 || b3 == -25 || b3 == -27 || b3 == -29 || b3 == -31 || b3 == -108 || b3 == 19 || b3 == 22 || b3 == 24 || b3 == 26 || b3 == 29 || b3 == -32 || b3 == -35 || b3 == -34 || b3 == -36 || b3 == -8 || b3 == -40 || b3 == -42 || b3 == -43 || b3 == -45 || b3 == -46 || b3 == -47 || b3 == -49 || b3 == -51 || b3 == -53 || b3 == 75 || b3 == -55 || b3 == 32 || b3 == 35 || b3 == 38 || b3 == 40 || b3 == 42 || b3 == 44 || b3 == 50 || b3 == 52 || b3 == -57 || b3 == -58 || b3 == -76 || b3 == -77 || b3 == -79 || b3 == -82 || b3 == -81 || b3 == -6 || b3 == -96 || b3 == -88 || b3 == -89 || b3 == -90 || b3 == 64 || b3 == 65 || b3 == 66 || b3 == 68 || b3 == -84 : b3 >= 32 && b3 < 96) {
            eVar.sendEmptyMessage(1);
            return;
        }
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DataInfoBaseCallback", "onAnswer 等待数据返回 " + (b3 & 255));
        eVar.removeMessages(0);
        eVar.sendEmptyMessageDelayed(0, 15000L);
    }

    @Override // o5.a
    public final void r0(Message message) {
        int i3 = message.what;
        if (i3 == 0) {
            byte b3 = e()[0];
            char[] cArr = y5.b.f20001a;
            d(b3 & 255, 6);
            return;
        }
        g gVar = this.f18884b;
        if (i3 == 1) {
            if (gVar != null) {
                gVar.c();
            }
        } else if (i3 == 2) {
            if (gVar != null) {
                gVar.a(((Integer) message.obj).intValue());
            }
        } else {
            if (i3 != 3 || gVar == null) {
                return;
            }
            gVar.e(message.obj);
        }
    }
}
