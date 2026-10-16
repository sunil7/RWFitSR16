package com.example.test.presenter.main;

import android.content.Context;
import com.example.network.base.HttpModel;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.testui.TRingFamilyActivity;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: classes.dex */
public final class k0 extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7529d;
    public final /* synthetic */ l0 e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Ref$ObjectRef f7530f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k0(l0 l0Var, Ref$ObjectRef ref$ObjectRef, Context context, com.example.test.utils.w0 w0Var, int i3) {
        super(context, w0Var);
        this.f7529d = i3;
        this.e = l0Var;
        this.f7530f = ref$ObjectRef;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        switch (this.f7529d) {
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
            default:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                TRingFamilyActivity tRingFamilyActivity2 = (TRingFamilyActivity) ((g7.n) this.e.f7255a);
                tRingFamilyActivity2.getClass();
                String string2 = tRingFamilyActivity2.getString(R$string.str_network_error);
                if (string2 == null) {
                    string2 = "";
                }
                tRingFamilyActivity2.S0(i3, string2);
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r4v14, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v7, types: [T, java.lang.Object] */
    @Override // d6.b
    public final void b(Object obj) {
        switch (this.f7529d) {
            case 0:
                HttpModel httpModel = (HttpModel) obj;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("onSuccess ->", com.example.baselibrary.utils.b.z(httpModel)));
                l0 l0Var = this.e;
                ((XXBaseActivity) ((g7.n) l0Var.f7255a)).b0();
                if (!(httpModel != null ? kotlin.jvm.internal.e.a(httpModel.isSuccess(), Boolean.TRUE) : false)) {
                    g7.n nVar = (g7.n) l0Var.f7255a;
                    int code = httpModel != null ? httpModel.getCode() : -1;
                    String msg = httpModel != null ? httpModel.getMsg() : null;
                    if (msg == null) {
                        msg = "";
                    }
                    ((TRingFamilyActivity) nVar).S0(code, msg);
                    break;
                } else {
                    ?? results = httpModel.getResults();
                    kotlin.jvm.internal.e.e(results, "getResults(...)");
                    this.f7530f.element = results;
                    break;
                }
            default:
                HttpModel httpModel2 = (HttpModel) obj;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("onSuccess ->", com.example.baselibrary.utils.b.z(httpModel2)));
                l0 l0Var2 = this.e;
                ((XXBaseActivity) ((g7.n) l0Var2.f7255a)).b0();
                if (!(httpModel2 != null ? kotlin.jvm.internal.e.a(httpModel2.isSuccess(), Boolean.TRUE) : false)) {
                    g7.n nVar2 = (g7.n) l0Var2.f7255a;
                    int code2 = httpModel2 != null ? httpModel2.getCode() : -1;
                    String msg2 = httpModel2 != null ? httpModel2.getMsg() : null;
                    if (msg2 == null) {
                        msg2 = "";
                    }
                    ((TRingFamilyActivity) nVar2).S0(code2, msg2);
                    break;
                } else {
                    ?? results2 = httpModel2.getResults();
                    kotlin.jvm.internal.e.e(results2, "getResults(...)");
                    this.f7530f.element = results2;
                    break;
                }
        }
    }
}
