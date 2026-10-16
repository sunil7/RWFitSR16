package com.example.test.ui.main.fragment;

import com.example.test.R$id;
import com.example.test.R$string;
import com.example.test.presenter.main.h0;
import com.example.test.presenter.main.x;
import com.example.test.ui.XXBaseFragment;
import com.example.test.utils.t;
import com.google.android.gms.internal.mlkit_vision_barcode.x1;
import com.google.android.gms.internal.mlkit_vision_common.p;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class f implements t6.b, a7.f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8105a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DeviceFragment f8106b;

    public /* synthetic */ f(DeviceFragment deviceFragment, int i3) {
        this.f8105a = i3;
        this.f8106b = deviceFragment;
    }

    private final void a() {
    }

    private final void b() {
    }

    private final void c() {
    }

    private final void d() {
    }

    private final void e() {
    }

    private final void f() {
    }

    private final void g() {
    }

    private final void h() {
    }

    private final void i() {
    }

    private final void k() {
    }

    private final void l() {
    }

    @Override // a7.f
    public void j(int i3) {
        if (System.currentTimeMillis() - x1.f9659a >= 1200 || System.currentTimeMillis() < x1.f9659a) {
            x1.f9659a = System.currentTimeMillis();
            DeviceFragment deviceFragment = this.f8106b;
            if (deviceFragment.f8042d) {
                if (com.example.test.service.e.h().i()) {
                    deviceFragment.A0().b(R$string.str_device_unbind_tips);
                } else {
                    deviceFragment.A0().b(R$string.str_disconnect_unbinding_tips);
                }
                if (i3 == R$id.option1) {
                    deviceFragment.A0().setOnDialogListener(new f(deviceFragment, 7));
                } else if (i3 == R$id.option2) {
                    deviceFragment.A0().setOnDialogListener(new f(deviceFragment, 8));
                } else if (i3 == R$id.barStatusIv) {
                    deviceFragment.A0().setOnDialogListener(new f(deviceFragment, 9));
                }
                deviceFragment.A0().show();
                return;
            }
            int i10 = R$id.option1;
            eh.b bVar = deviceFragment.f8056t;
            if (i3 != i10) {
                if (deviceFragment.q0()) {
                    if (nd.c.j(deviceFragment.f0(), android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"))) {
                        deviceFragment.H0(deviceFragment.f8054q);
                        return;
                    } else {
                        deviceFragment.f8055s = 3;
                        ((com.example.test.ui.dialog.i) bVar.getValue()).show();
                        return;
                    }
                }
                return;
            }
            if (deviceFragment.q0()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("android.permission.CAMERA");
                arrayList.addAll(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                if (nd.c.j(deviceFragment.f0(), arrayList)) {
                    deviceFragment.H0(deviceFragment.f8053p);
                } else {
                    deviceFragment.f8055s = 2;
                    ((com.example.test.ui.dialog.i) bVar.getValue()).show();
                }
            }
        }
    }

    @Override // t6.b
    public void onCancel() {
        int i3 = this.f8105a;
    }

    @Override // t6.b
    public void s() {
        switch (this.f8105a) {
            case 0:
                v2.h hVar = new v2.h(this.f8106b.f0());
                hVar.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                hVar.p(new b9.a(14));
                break;
            case 1:
                t.b(this.f8106b.f0());
                break;
            case 2:
                DeviceFragment deviceFragment = this.f8106b;
                deviceFragment.V();
                if (!com.example.test.service.e.h().i()) {
                    ((h0) deviceFragment.X()).o();
                    break;
                } else {
                    deviceFragment.f8050m = deviceFragment.f8052o;
                    ((h0) deviceFragment.X()).n();
                    break;
                }
            case 3:
                DeviceFragment deviceFragment2 = this.f8106b;
                deviceFragment2.f8050m = deviceFragment2.f8051n;
                h0 h0Var = (h0) deviceFragment2.X();
                h0Var.f7518j = 2;
                ((XXBaseFragment) ((g7.k) h0Var.f7255a)).V();
                p.U((x) h0Var.f7516h.getValue());
                if (!y5.d.f20005b) {
                    p.b(2);
                    break;
                } else {
                    p.y(2);
                    break;
                }
            case 4:
                DeviceFragment deviceFragment3 = this.f8106b;
                deviceFragment3.f8050m = deviceFragment3.f8052o;
                ((h0) deviceFragment3.X()).n();
                break;
            case 5:
                h0 h0Var2 = (h0) this.f8106b.X();
                h0Var2.f7518j = 0;
                ((XXBaseFragment) ((g7.k) h0Var2.f7255a)).V();
                p.U((x) h0Var2.f7516h.getValue());
                p.b(0);
                break;
            case 6:
                h0 h0Var3 = (h0) this.f8106b.X();
                h0Var3.f7518j = 1;
                ((XXBaseFragment) ((g7.k) h0Var3.f7255a)).V();
                p.U((x) h0Var3.f7516h.getValue());
                if (!y5.d.f20005b) {
                    p.b(1);
                    break;
                } else {
                    p.y(1);
                    break;
                }
            case 7:
                DeviceFragment deviceFragment4 = this.f8106b;
                if (deviceFragment4.q0()) {
                    v2.h hVar2 = new v2.h(deviceFragment4.f0());
                    hVar2.o("android.permission.CAMERA");
                    hVar2.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                    hVar2.p(new e(deviceFragment4, 10));
                    break;
                }
                break;
            case 8:
                DeviceFragment deviceFragment5 = this.f8106b;
                if (deviceFragment5.q0()) {
                    v2.h hVar3 = new v2.h(deviceFragment5.f0());
                    hVar3.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                    hVar3.p(new e(deviceFragment5, 11));
                    break;
                }
                break;
            case 9:
                DeviceFragment deviceFragment6 = this.f8106b;
                deviceFragment6.V();
                if (!com.example.test.service.e.h().i()) {
                    ((h0) deviceFragment6.X()).o();
                    break;
                } else {
                    deviceFragment6.f8050m = deviceFragment6.f8052o;
                    ((h0) deviceFragment6.X()).n();
                    break;
                }
            default:
                DeviceFragment deviceFragment7 = this.f8106b;
                int i3 = deviceFragment7.f8055s;
                if (i3 == 1) {
                    v2.h hVar4 = new v2.h(deviceFragment7.f0());
                    hVar4.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                    hVar4.p(new e(deviceFragment7, 1));
                    break;
                } else if (i3 == 2) {
                    v2.h hVar5 = new v2.h(deviceFragment7.f0());
                    hVar5.o("android.permission.CAMERA");
                    hVar5.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                    hVar5.p(new e(deviceFragment7, 4));
                    break;
                } else if (i3 == 3) {
                    v2.h hVar6 = new v2.h(deviceFragment7.f0());
                    hVar6.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                    hVar6.p(new e(deviceFragment7, 5));
                    break;
                }
                break;
        }
    }
}
