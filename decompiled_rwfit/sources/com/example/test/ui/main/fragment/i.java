package com.example.test.ui.main.fragment;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.baselibrary.base.fragment.BaseFragment;
import com.example.test.R$string;
import com.example.test.presenter.device.u;
import com.example.test.ui.device.activity.ScanQrMlActivity;
import com.example.test.ui.device.model.BleDeviceModel;
import com.google.android.gms.internal.mlkit_vision_barcode.tb;

/* loaded from: classes.dex */
public final /* synthetic */ class i implements OnItemClickListener, nd.b, t6.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8108a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseFragment f8109b;

    public /* synthetic */ i(BaseFragment baseFragment, int i3) {
        this.f8108a = i3;
        this.f8109b = baseFragment;
    }

    @Override // t6.e
    public void a(int i3, int i10) {
        int i11;
        HeadsetFragment this$0 = (HeadsetFragment) this.f8109b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        if (i3 == 1) {
            if (i10 == 1) {
                i11 = 16;
            }
            i11 = 3;
        } else {
            if (i10 == 1) {
                i11 = 1;
            }
            i11 = 3;
        }
        xd.a a3 = tb.a(new byte[]{90, -91, 56, 5, (byte) i11});
        k6.b bVar = this$0.f8070c;
        if (bVar != null) {
            bVar.i(a3, null);
        }
    }

    @Override // nd.b
    public void h(boolean z5) {
        switch (this.f8108a) {
            case 1:
                DeviceScanFragment this$0 = (DeviceScanFragment) this.f8109b;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (!z5) {
                    com.example.baselibrary.utils.d.a(R$string.str_blue_permission_tips);
                    break;
                } else {
                    ((ObjectAnimator) this$0.e.getValue()).start();
                    ((u) this$0.X()).getClass();
                    u.l();
                    break;
                }
            case 2:
                DeviceScanFragment this$02 = (DeviceScanFragment) this.f8109b;
                kotlin.jvm.internal.e.f(this$02, "this$0");
                if (z5) {
                    this$02.startActivity(new Intent(this$02.getActivity(), (Class<?>) ScanQrMlActivity.class));
                    break;
                }
                break;
            default:
                DeviceScanFragment this$03 = (DeviceScanFragment) this.f8109b;
                kotlin.jvm.internal.e.f(this$03, "this$0");
                if (!z5) {
                    com.example.baselibrary.utils.d.a(R$string.str_blue_permission_tips);
                    break;
                } else {
                    ((ObjectAnimator) this$03.e.getValue()).start();
                    ((u) this$03.X()).getClass();
                    u.l();
                    break;
                }
        }
    }

    @Override // com.chad.library.adapter.base.listener.OnItemClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
        DeviceScanFragment this$0 = (DeviceScanFragment) this.f8109b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
        kotlin.jvm.internal.e.f(view, "<anonymous parameter 1>");
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceScanFragment", "setOnItemClickListener " + i3);
        ((u) this$0.X()).getClass();
        u.m();
        this$0.C0(R$string.str_device_connecting);
        s5.a aVar = new s5.a();
        aVar.f18210a = ((BleDeviceModel) this$0.z0().get(i3)).getName();
        aVar.f18212c = ((BleDeviceModel) this$0.z0().get(i3)).getMac();
        aVar.f18214f = ((BleDeviceModel) this$0.z0().get(i3)).getRawDataFlag();
        com.example.test.service.e.h().c(aVar);
    }
}
