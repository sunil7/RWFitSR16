package com.example.test.presenter.main;

import android.util.Log;
import com.example.blesdk.bean.function.VideoHidBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.ui.XXBaseFragment;
import com.example.test.ui.testui.TRingDeviceFragment;

/* loaded from: classes.dex */
public final class i1 implements v5.l0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r1 f7522a;

    public i1(r1 r1Var) {
        this.f7522a = r1Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        ((XXBaseFragment) ((g7.z) this.f7522a.f7255a)).b0();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DevicePresenter", "VideoHidCallback errorCode " + i3);
    }

    @Override // u5.g
    public final void c() {
        final r1 r1Var = this.f7522a;
        VideoHidBean videoHidBean = r1Var.f7560i;
        if (videoHidBean != null) {
            com.example.baselibrary.preseneter.b.j(videoHidBean, new oh.l() { // from class: com.example.test.presenter.main.TRingDevicePresenter$saveVCDB$1$1
                @Override // oh.l
                public final Long invoke(VideoHidBean it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    DataSetting dataSetting = new DataSetting();
                    dataSetting.setMac(com.example.test.service.e.h().g().f18212c);
                    dataSetting.setDataKey("setting_video_hid");
                    dataSetting.setDataValue(com.example.baselibrary.utils.b.z(it));
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                    User d5 = kVar != null ? kVar.d() : null;
                    if (d5 != null) {
                        dataSetting.setUserId(d5.getUserId());
                    }
                    return Long.valueOf(SettingImpl.INSTANCE.saveData(dataSetting));
                }
            }, new oh.l() { // from class: com.example.test.presenter.main.TRingDevicePresenter$saveVCDB$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ((XXBaseFragment) ((g7.z) r1.this.f7255a)).b0();
                    if (j4 > 0) {
                        ((TRingDeviceFragment) ((g7.z) r1.this.f7255a)).getClass();
                        Log.d("tong", " onSaveDataSuccess");
                        com.example.baselibrary.utils.d.a(R$string.str_save_success);
                    } else {
                        ((TRingDeviceFragment) ((g7.z) r1.this.f7255a)).getClass();
                        Log.d("tong", " onSaveDataFail");
                        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
                    }
                }
            });
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        VideoHidBean videoHidBean = (VideoHidBean) obj;
        if (videoHidBean != null) {
            ((TRingDeviceFragment) ((g7.z) this.f7522a.f7255a)).K0(videoHidBean);
        }
    }
}
