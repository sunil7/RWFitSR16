package com.example.test.presenter.main;

import com.example.network.base.HttpModel;
import com.example.network.bean.DeviceSupportBean;
import com.example.network.bean.MemberFriendDataBean;
import com.example.test.R$string;
import com.example.test.ui.testui.TRingFamilySportsActivity;

/* loaded from: classes.dex */
public final class m0 extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7534d;
    public final /* synthetic */ n0 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m0(n0 n0Var, TRingFamilySportsActivity tRingFamilySportsActivity, com.example.test.utils.w0 w0Var, int i3) {
        super(tRingFamilySportsActivity, w0Var);
        this.f7534d = i3;
        this.e = n0Var;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        switch (this.f7534d) {
            case 0:
                TRingFamilySportsActivity tRingFamilySportsActivity = (TRingFamilySportsActivity) ((g7.m) this.e.f7255a);
                tRingFamilySportsActivity.J = null;
                MemberFriendDataBean memberFriendDataBean = tRingFamilySportsActivity.I;
                if (memberFriendDataBean != null) {
                    tRingFamilySportsActivity.R0(memberFriendDataBean);
                    break;
                }
                break;
            default:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                TRingFamilySportsActivity tRingFamilySportsActivity2 = (TRingFamilySportsActivity) ((g7.m) this.e.f7255a);
                tRingFamilySportsActivity2.getClass();
                tRingFamilySportsActivity2.getString(R$string.str_network_error);
                tRingFamilySportsActivity2.getClass();
                break;
        }
    }

    @Override // d6.b
    public final void b(Object obj) {
        switch (this.f7534d) {
            case 0:
                HttpModel httpModel = (HttpModel) obj;
                boolean a3 = httpModel != null ? kotlin.jvm.internal.e.a(httpModel.isSuccess(), Boolean.TRUE) : false;
                n0 n0Var = this.e;
                if (!a3) {
                    TRingFamilySportsActivity tRingFamilySportsActivity = (TRingFamilySportsActivity) ((g7.m) n0Var.f7255a);
                    tRingFamilySportsActivity.J = null;
                    MemberFriendDataBean memberFriendDataBean = tRingFamilySportsActivity.I;
                    if (memberFriendDataBean != null) {
                        tRingFamilySportsActivity.R0(memberFriendDataBean);
                        break;
                    }
                } else {
                    TRingFamilySportsActivity tRingFamilySportsActivity2 = (TRingFamilySportsActivity) ((g7.m) n0Var.f7255a);
                    tRingFamilySportsActivity2.J = (DeviceSupportBean) httpModel.getResults();
                    MemberFriendDataBean memberFriendDataBean2 = tRingFamilySportsActivity2.I;
                    if (memberFriendDataBean2 != null) {
                        tRingFamilySportsActivity2.R0(memberFriendDataBean2);
                        break;
                    }
                }
                break;
            default:
                HttpModel httpModel2 = (HttpModel) obj;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("familyData ->", com.example.baselibrary.utils.b.z(httpModel2)));
                boolean a10 = httpModel2 != null ? kotlin.jvm.internal.e.a(httpModel2.isSuccess(), Boolean.TRUE) : false;
                n0 n0Var2 = this.e;
                if (!a10) {
                    g7.m mVar = (g7.m) n0Var2.f7255a;
                    if (httpModel2 != null) {
                        httpModel2.getCode();
                    }
                    if (httpModel2 != null) {
                        httpModel2.getMsg();
                    }
                    ((TRingFamilySportsActivity) mVar).getClass();
                    break;
                } else {
                    MemberFriendDataBean memberFriendDataBean3 = (MemberFriendDataBean) httpModel2.getResults();
                    g7.m mVar2 = (g7.m) n0Var2.f7255a;
                    kotlin.jvm.internal.e.c(memberFriendDataBean3);
                    TRingFamilySportsActivity tRingFamilySportsActivity3 = (TRingFamilySportsActivity) mVar2;
                    tRingFamilySportsActivity3.getClass();
                    tRingFamilySportsActivity3.b0();
                    tRingFamilySportsActivity3.I = memberFriendDataBean3;
                    tRingFamilySportsActivity3.R0(memberFriendDataBean3);
                    break;
                }
        }
    }
}
