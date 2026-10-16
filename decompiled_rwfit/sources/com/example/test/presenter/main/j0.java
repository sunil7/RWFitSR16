package com.example.test.presenter.main;

import com.example.network.base.HttpModel;
import com.example.test.R$string;
import com.example.test.ui.testui.TRingFamilyActivity;

/* loaded from: classes.dex */
public final class j0 extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7524d;
    public final /* synthetic */ l0 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j0(l0 l0Var, TRingFamilyActivity tRingFamilyActivity, com.example.test.utils.w0 w0Var, int i3) {
        super(tRingFamilyActivity, w0Var);
        this.f7524d = i3;
        this.e = l0Var;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        switch (this.f7524d) {
            case 0:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                TRingFamilyActivity tRingFamilyActivity = (TRingFamilyActivity) ((g7.n) this.e.f7255a);
                tRingFamilyActivity.getClass();
                String string = tRingFamilyActivity.getString(R$string.str_network_error);
                if (string == null) {
                    string = "";
                }
                tRingFamilyActivity.S0(i3, string);
                break;
            case 1:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                TRingFamilyActivity tRingFamilyActivity2 = (TRingFamilyActivity) ((g7.n) this.e.f7255a);
                tRingFamilyActivity2.getClass();
                String string2 = tRingFamilyActivity2.getString(R$string.str_network_error);
                if (string2 == null) {
                    string2 = "";
                }
                tRingFamilyActivity2.S0(i3, string2);
                break;
            case 2:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                TRingFamilyActivity tRingFamilyActivity3 = (TRingFamilyActivity) ((g7.n) this.e.f7255a);
                tRingFamilyActivity3.getClass();
                String string3 = tRingFamilyActivity3.getString(R$string.str_network_error);
                if (string3 == null) {
                    string3 = "";
                }
                tRingFamilyActivity3.S0(i3, string3);
                break;
            default:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                TRingFamilyActivity tRingFamilyActivity4 = (TRingFamilyActivity) ((g7.n) this.e.f7255a);
                tRingFamilyActivity4.getClass();
                String string4 = tRingFamilyActivity4.getString(R$string.str_network_error);
                if (string4 == null) {
                    string4 = "";
                }
                tRingFamilyActivity4.S0(i3, string4);
                break;
        }
    }

    @Override // d6.b
    public final void b(Object obj) {
        switch (this.f7524d) {
            case 0:
                HttpModel httpModel = (HttpModel) obj;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("register ->", com.example.baselibrary.utils.b.z(httpModel)));
                boolean a3 = httpModel != null ? kotlin.jvm.internal.e.a(httpModel.isSuccess(), Boolean.TRUE) : false;
                l0 l0Var = this.e;
                if (!a3) {
                    g7.n nVar = (g7.n) l0Var.f7255a;
                    int code = httpModel != null ? httpModel.getCode() : -1;
                    String msg = httpModel != null ? httpModel.getMsg() : null;
                    if (msg == null) {
                        msg = "";
                    }
                    ((TRingFamilyActivity) nVar).S0(code, msg);
                    break;
                } else {
                    ((TRingFamilyActivity) ((g7.n) l0Var.f7255a)).R0();
                    g7.n nVar2 = (g7.n) l0Var.f7255a;
                    int i3 = R$string.str_family_friend_has_accepted;
                    TRingFamilyActivity tRingFamilyActivity = (TRingFamilyActivity) nVar2;
                    tRingFamilyActivity.b0();
                    tRingFamilyActivity.w0(i3);
                    break;
                }
            case 1:
                HttpModel httpModel2 = (HttpModel) obj;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("register ->", com.example.baselibrary.utils.b.z(httpModel2)));
                boolean a10 = httpModel2 != null ? kotlin.jvm.internal.e.a(httpModel2.isSuccess(), Boolean.TRUE) : false;
                l0 l0Var2 = this.e;
                if (!a10) {
                    g7.n nVar3 = (g7.n) l0Var2.f7255a;
                    int code2 = httpModel2 != null ? httpModel2.getCode() : -1;
                    String msg2 = httpModel2 != null ? httpModel2.getMsg() : null;
                    if (msg2 == null) {
                        msg2 = "";
                    }
                    ((TRingFamilyActivity) nVar3).S0(code2, msg2);
                    break;
                } else {
                    ((TRingFamilyActivity) ((g7.n) l0Var2.f7255a)).R0();
                    g7.n nVar4 = (g7.n) l0Var2.f7255a;
                    int i10 = R$string.str_family_friend_has_declined;
                    TRingFamilyActivity tRingFamilyActivity2 = (TRingFamilyActivity) nVar4;
                    tRingFamilyActivity2.b0();
                    tRingFamilyActivity2.w0(i10);
                    break;
                }
            case 2:
                HttpModel httpModel3 = (HttpModel) obj;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("register ->", com.example.baselibrary.utils.b.z(httpModel3)));
                boolean a11 = httpModel3 != null ? kotlin.jvm.internal.e.a(httpModel3.isSuccess(), Boolean.TRUE) : false;
                l0 l0Var3 = this.e;
                if (!a11) {
                    g7.n nVar5 = (g7.n) l0Var3.f7255a;
                    int code3 = httpModel3 != null ? httpModel3.getCode() : -1;
                    String msg3 = httpModel3 != null ? httpModel3.getMsg() : null;
                    if (msg3 == null) {
                        msg3 = "";
                    }
                    ((TRingFamilyActivity) nVar5).S0(code3, msg3);
                    break;
                } else {
                    ((TRingFamilyActivity) ((g7.n) l0Var3.f7255a)).R0();
                    g7.n nVar6 = (g7.n) l0Var3.f7255a;
                    int i11 = R$string.str_family_friend_delete_success;
                    TRingFamilyActivity tRingFamilyActivity3 = (TRingFamilyActivity) nVar6;
                    tRingFamilyActivity3.b0();
                    tRingFamilyActivity3.w0(i11);
                    break;
                }
            default:
                HttpModel httpModel4 = (HttpModel) obj;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("register ->", com.example.baselibrary.utils.b.z(httpModel4)));
                boolean a12 = httpModel4 != null ? kotlin.jvm.internal.e.a(httpModel4.isSuccess(), Boolean.TRUE) : false;
                l0 l0Var4 = this.e;
                if (!a12) {
                    g7.n nVar7 = (g7.n) l0Var4.f7255a;
                    int code4 = httpModel4 != null ? httpModel4.getCode() : -1;
                    String msg4 = httpModel4 != null ? httpModel4.getMsg() : null;
                    if (msg4 == null) {
                        msg4 = "";
                    }
                    ((TRingFamilyActivity) nVar7).S0(code4, msg4);
                    break;
                } else {
                    ((TRingFamilyActivity) ((g7.n) l0Var4.f7255a)).R0();
                    g7.n nVar8 = (g7.n) l0Var4.f7255a;
                    int i12 = R$string.str_family_friend_edit_success;
                    TRingFamilyActivity tRingFamilyActivity4 = (TRingFamilyActivity) nVar8;
                    tRingFamilyActivity4.b0();
                    tRingFamilyActivity4.w0(i12);
                    break;
                }
        }
    }
}
