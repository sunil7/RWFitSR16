package com.example.test.presenter.device;

import com.example.blesdk.bean.function.VideoHidBean;
import com.example.database.db.SettingImpl;
import com.example.database.table.DataSetting;
import com.example.database.table.User;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.VideoHidActivity;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class k1 extends d implements v5.l0 {

    /* renamed from: b, reason: collision with root package name */
    public VideoHidBean f7453b;

    @Override // u5.g
    public final void a(int i3) {
        ((XXBaseActivity) ((f7.b0) this.f7255a)).b0();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ScreenLightPresenter", "errorCode = " + i3);
        k(i3);
    }

    @Override // u5.g
    public final void c() {
        VideoHidBean videoHidBean = this.f7453b;
        if (videoHidBean != null) {
            com.example.baselibrary.preseneter.b.j(videoHidBean, new oh.l() { // from class: com.example.test.presenter.device.VideoHidPresenter$saveDB$1$1
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
            }, new oh.l() { // from class: com.example.test.presenter.device.VideoHidPresenter$saveDB$1$2
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return eh.g.f12633a;
                }

                public final void invoke(long j4) {
                    ((XXBaseActivity) ((f7.b0) k1.this.f7255a)).b0();
                    if (j4 <= 0) {
                        ((VideoHidActivity) ((f7.b0) k1.this.f7255a)).getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
                    } else {
                        VideoHidActivity videoHidActivity = (VideoHidActivity) ((f7.b0) k1.this.f7255a);
                        videoHidActivity.getClass();
                        com.example.baselibrary.utils.d.a(R$string.str_save_success);
                        videoHidActivity.onBackPressed();
                    }
                }
            });
        }
    }

    @Override // u5.g
    public final void e(Object obj) {
        VideoHidBean videoHidBean = (VideoHidBean) obj;
        if (videoHidBean != null) {
            VideoHidActivity videoHidActivity = (VideoHidActivity) ((f7.b0) this.f7255a);
            videoHidActivity.getClass();
            videoHidActivity.S0().setOpen(videoHidBean.isOpen());
            videoHidActivity.S0().setDefaultOpen(videoHidBean.isDefaultOpen());
            videoHidActivity.R0();
        }
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
        u5.c cVar;
        x5.b I0 = x5.b.I0();
        if (I0.J0(this)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it.next();
                if (cVar != null && cVar.g() == this) {
                    break;
                }
            }
            if (cVar == null) {
                return;
            }
            linkedList.remove(cVar);
        }
    }

    public final void l() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.VideoHidPresenter$initData$1
            @Override // oh.l
            public final DataSetting invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                if (d5 == null) {
                    return null;
                }
                SettingImpl settingImpl = SettingImpl.INSTANCE;
                String userId = d5.getUserId();
                String str = android.support.v4.media.session.e.y(userId, "getUserId(...)").f18212c;
                kotlin.jvm.internal.e.e(str, "getBleMac(...)");
                return settingImpl.getData(userId, str, "setting_video_hid");
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.VideoHidPresenter$initData$2

            public static final class a extends bc.a<VideoHidBean> {
            }

            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DataSetting) obj);
                return eh.g.f12633a;
            }

            public final void invoke(DataSetting dataSetting) {
                if (dataSetting != null) {
                    k1 k1Var = k1.this;
                    Object g10 = com.example.baselibrary.utils.b.g(dataSetting.getDataValue(), new a().f3204b);
                    kotlin.jvm.internal.e.e(g10, "fromJson(...)");
                    VideoHidBean videoHidBean = (VideoHidBean) g10;
                    VideoHidActivity videoHidActivity = (VideoHidActivity) ((f7.b0) k1Var.f7255a);
                    videoHidActivity.getClass();
                    videoHidActivity.S0().setOpen(videoHidBean.isOpen());
                    videoHidActivity.S0().setDefaultOpen(videoHidBean.isDefaultOpen());
                    videoHidActivity.R0();
                }
            }
        });
        com.google.android.gms.internal.mlkit_vision_common.p.U(this);
        com.google.android.gms.internal.mlkit_vision_common.p.q();
    }
}
