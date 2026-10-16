package com.example.test.presenter.main;

import com.example.blesdk.bean.function.BrightVibrationBean;
import com.example.test.R$id;
import com.example.test.R$string;
import com.example.test.ui.XXBaseFragment;
import com.example.test.ui.device.model.DeviceOptionModel;
import com.example.test.ui.testui.TRingDeviceFragment;

/* loaded from: classes.dex */
public final class p1 implements v5.k0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r1 f7546a;

    public p1(r1 r1Var) {
        this.f7546a = r1Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        ((XXBaseFragment) ((g7.z) this.f7546a.f7255a)).b0();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DevicePresenter", "VideoHidCallback errorCode " + i3);
    }

    @Override // u5.g
    public final void c() {
        this.f7546a.getClass();
    }

    @Override // u5.g
    public final void e(Object obj) {
        BrightVibrationBean brightVibrationBean = (BrightVibrationBean) obj;
        if (brightVibrationBean != null) {
            TRingDeviceFragment tRingDeviceFragment = (TRingDeviceFragment) ((g7.z) this.f7546a.f7255a);
            tRingDeviceFragment.getClass();
            eh.b bVar = tRingDeviceFragment.f8213f;
            ((BrightVibrationBean) bVar.getValue()).setLevel(brightVibrationBean.getLevel());
            int a3 = tRingDeviceFragment.A0().a(R$id.av_vibration);
            DeviceOptionModel deviceOptionModel = tRingDeviceFragment.A0().getData().get(a3);
            kotlin.jvm.internal.e.d(deviceOptionModel, "null cannot be cast to non-null type com.example.test.ui.device.model.DeviceOptionModel");
            DeviceOptionModel deviceOptionModel2 = deviceOptionModel;
            int level = ((BrightVibrationBean) bVar.getValue()).getLevel();
            if (level == 0) {
                deviceOptionModel2.setOptionHint(tRingDeviceFragment.f0().getString(R$string.str_ring_screen_light_0));
            } else if (level == 1) {
                deviceOptionModel2.setOptionHint(tRingDeviceFragment.f0().getString(R$string.str_ring_vibration_1));
            } else if (level == 2) {
                deviceOptionModel2.setOptionHint(tRingDeviceFragment.f0().getString(R$string.str_ring_vibration_2));
            } else if (level == 3) {
                deviceOptionModel2.setOptionHint(tRingDeviceFragment.f0().getString(R$string.str_ring_vibration_3));
            }
            tRingDeviceFragment.A0().notifyItemChanged(a3);
        }
    }
}
