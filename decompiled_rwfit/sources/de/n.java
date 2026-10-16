package de;

import androidx.recyclerview.widget.n0;
import androidx.recyclerview.widget.x;
import com.google.android.gms.internal.mlkit_vision_common.i0;

/* loaded from: classes.dex */
public final class n implements rd.b {

    /* renamed from: a, reason: collision with root package name */
    public final k6.b f12375a;

    public n(k6.b bVar, int i3) {
        switch (i3) {
            case 1:
                this.f12375a = bVar;
                return;
            default:
                if (bVar == null) {
                    throw new NullPointerException("BluetoothOTAManager can not be null.");
                }
                this.f12375a = bVar;
                return;
        }
    }

    @Override // rd.b
    public void a(x xVar) {
        this.f12375a.p("upgradeStep05", xVar);
    }

    public void b(rd.b bVar) {
        zd.e eVar = new zd.e(-1);
        eVar.e = (byte) 0;
        this.f12375a.i(new xd.k(eVar), new ef.i(16, bVar, new hc.a(9)));
    }

    @Override // rd.b
    public void onSuccess(Object obj) {
        x a3;
        Integer num = (Integer) obj;
        ee.c.e(this.f12375a.f17897a, "upgradeStep05", "Step05.询问升级状态, 结果码: " + num);
        boolean z5 = false;
        if (num.intValue() == 0) {
            this.f12375a.E = false;
            k6.b bVar = this.f12375a;
            n0 n0Var = bVar.f17902g;
            bVar.M.removeMessages(4672);
            this.f12375a.M.sendEmptyMessageDelayed(4672, 500L);
            n nVar = this.f12375a.f15524z;
            n6.a aVar = new n6.a(this, 9);
            nVar.getClass();
            nVar.f12375a.i(new xd.p(new ae.b(0, 2)), new f(aVar));
            return;
        }
        if (num.intValue() == 128) {
            this.f12375a.getClass();
            k6.b bVar2 = this.f12375a;
            bVar2.K = 0;
            bVar2.J = 0;
            be.j A = bVar2.A();
            if (A != null && A.A) {
                z5 = true;
            }
            ee.c.e(this.f12375a.f17897a, "upgradeStep05", "download resource finish. isSupportDoubleBackup : " + z5);
            if (z5) {
                this.f12375a.W();
                return;
            } else {
                k6.b bVar3 = this.f12375a;
                bVar3.G(bVar3.g());
                return;
            }
        }
        switch (num.intValue()) {
            case 1:
                a3 = i0.a(16389);
                break;
            case 2:
                a3 = i0.c(16385, "Device return update failed.");
                break;
            case 3:
                a3 = i0.a(16390);
                break;
            case 4:
                a3 = i0.a(16387);
                break;
            case 5:
                a3 = i0.a(16391);
                break;
            case 6:
                a3 = i0.a(16393);
                break;
            case 7:
                a3 = i0.a(16394);
                break;
            case 8:
                a3 = i0.a(16395);
                break;
            case 9:
                a3 = i0.a(16399);
                break;
            default:
                a3 = i0.b(16400, num.intValue(), "Device returned to an unknown code : " + num);
                break;
        }
        a(a3);
    }
}
