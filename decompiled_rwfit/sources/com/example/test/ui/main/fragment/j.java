package com.example.test.ui.main.fragment;

import com.example.test.utils.t;

/* loaded from: classes.dex */
public final class j implements t6.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8110a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DeviceScanFragment f8111b;

    public /* synthetic */ j(DeviceScanFragment deviceScanFragment, int i3) {
        this.f8110a = i3;
        this.f8111b = deviceScanFragment;
    }

    private final void a() {
    }

    private final void b() {
    }

    private final void c() {
    }

    @Override // t6.b
    public final void onCancel() {
        int i3 = this.f8110a;
    }

    @Override // t6.b
    public final void s() {
        switch (this.f8110a) {
            case 0:
                v2.h hVar = new v2.h(this.f8111b.f0());
                hVar.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                hVar.p(new b9.a(15));
                break;
            case 1:
                t.b(this.f8111b.f0());
                break;
            default:
                DeviceScanFragment deviceScanFragment = this.f8111b;
                int i3 = deviceScanFragment.f8062c;
                if (i3 == 1) {
                    v2.h hVar2 = new v2.h(deviceScanFragment.f0());
                    hVar2.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                    hVar2.p(new i(deviceScanFragment, 1));
                    break;
                } else if (i3 == 2) {
                    v2.h hVar3 = new v2.h(deviceScanFragment.f0());
                    hVar3.o("android.permission.CAMERA");
                    hVar3.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                    hVar3.p(new i(deviceScanFragment, 2));
                    break;
                } else if (i3 == 3) {
                    v2.h hVar4 = new v2.h(deviceScanFragment.f0());
                    hVar4.n(android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"));
                    hVar4.p(new i(deviceScanFragment, 3));
                    break;
                }
                break;
        }
    }
}
