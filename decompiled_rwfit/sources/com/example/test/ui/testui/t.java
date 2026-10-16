package com.example.test.ui.testui;

/* loaded from: classes.dex */
public final class t implements t6.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8312a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TRingDeviceScanActivity f8313b;

    public /* synthetic */ t(TRingDeviceScanActivity tRingDeviceScanActivity, int i3) {
        this.f8312a = i3;
        this.f8313b = tRingDeviceScanActivity;
    }

    private final void a() {
    }

    private final void b() {
    }

    private final void c() {
    }

    @Override // t6.b
    public final void onCancel() {
        int i3 = this.f8312a;
    }

    @Override // t6.b
    public final void s() {
        switch (this.f8312a) {
            case 0:
                TRingDeviceScanActivity tRingDeviceScanActivity = this.f8313b;
                tRingDeviceScanActivity.getClass();
                v2.h hVar = new v2.h(tRingDeviceScanActivity);
                hVar.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                hVar.p(new b9.a(20));
                break;
            case 1:
                TRingDeviceScanActivity tRingDeviceScanActivity2 = this.f8313b;
                tRingDeviceScanActivity2.getClass();
                com.example.test.utils.t.b(tRingDeviceScanActivity2);
                break;
            default:
                TRingDeviceScanActivity tRingDeviceScanActivity3 = this.f8313b;
                int i3 = tRingDeviceScanActivity3.H;
                if (i3 == 1) {
                    v2.h hVar2 = new v2.h(tRingDeviceScanActivity3);
                    hVar2.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                    hVar2.p(new s(tRingDeviceScanActivity3, 0));
                    break;
                } else if (i3 == 2) {
                    v2.h hVar3 = new v2.h(tRingDeviceScanActivity3);
                    hVar3.o("android.permission.CAMERA");
                    hVar3.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                    hVar3.p(new s(tRingDeviceScanActivity3, 1));
                    break;
                } else if (i3 == 3) {
                    v2.h hVar4 = new v2.h(tRingDeviceScanActivity3);
                    hVar4.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                    hVar4.p(new s(tRingDeviceScanActivity3, 2));
                    break;
                }
                break;
        }
    }
}
