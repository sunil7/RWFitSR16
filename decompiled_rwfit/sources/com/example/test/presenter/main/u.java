package com.example.test.presenter.main;

import android.util.Log;
import com.example.blesdk.bean.function.VideoHidBean;
import com.example.test.ui.XXBaseFragment;
import com.example.test.ui.main.fragment.DeviceFragment;

/* loaded from: classes.dex */
public final class u implements v5.l0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f7567a;

    public u(h0 h0Var) {
        this.f7567a = h0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        Log.d("tong", "set VideoHidCallback fail");
        ((XXBaseFragment) ((g7.k) this.f7567a.f7255a)).b0();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DevicePresenter", "VideoHidCallback errorCode " + i3);
    }

    @Override // u5.g
    public final void c() {
        Log.d("tong", "set VideoHidCallback success");
        this.f7567a.getClass();
    }

    @Override // u5.g
    public final void e(Object obj) {
        VideoHidBean videoHidBean = (VideoHidBean) obj;
        Log.d("tong", "VideoHidCallback onResult");
        if (videoHidBean != null) {
            Log.d("tong", " onResult is not null");
            ((DeviceFragment) ((g7.k) this.f7567a.f7255a)).getClass();
        }
    }
}
