package com.example.test.presenter.mine;

import android.content.Context;
import com.example.baselibrary.base.activity.BaseActivity;
import com.example.network.base.HttpModel;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.mine.activity.PrivacySafeActivity;
import com.example.test.utils.w0;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public final class o extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7600d;
    public final /* synthetic */ p e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(p pVar, Context context, w0 w0Var, int i3) {
        super(context, w0Var);
        this.f7600d = i3;
        this.e = pVar;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        switch (this.f7600d) {
            case 0:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, l0.n("onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                p pVar = this.e;
                ((XXBaseActivity) ((h7.i) pVar.f7255a)).b0();
                PrivacySafeActivity privacySafeActivity = (PrivacySafeActivity) ((h7.i) pVar.f7255a);
                privacySafeActivity.getClass();
                String string = privacySafeActivity.getString(R$string.str_network_error);
                if (string == null) {
                    string = "";
                }
                privacySafeActivity.S0(i3, string);
                break;
            default:
                p pVar2 = this.e;
                ((XXBaseActivity) ((h7.i) pVar2.f7255a)).b0();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, l0.n("onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                PrivacySafeActivity privacySafeActivity2 = (PrivacySafeActivity) ((h7.i) pVar2.f7255a);
                privacySafeActivity2.getClass();
                String string2 = privacySafeActivity2.getString(R$string.str_network_error);
                if (string2 == null) {
                    string2 = "";
                }
                privacySafeActivity2.S0(i3, string2);
                break;
        }
    }

    @Override // d6.b
    public final void b(Object obj) {
        switch (this.f7600d) {
            case 0:
                HttpModel httpModel = (HttpModel) obj;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, l0.n("onSuccess ->", com.example.baselibrary.utils.b.z(httpModel)));
                boolean a3 = httpModel != null ? kotlin.jvm.internal.e.a(httpModel.isSuccess(), Boolean.TRUE) : false;
                p pVar = this.e;
                if (a3) {
                    ((BaseActivity) ((h7.i) pVar.f7255a)).w0(R$string.str_clear_data_success);
                }
                ((XXBaseActivity) ((h7.i) pVar.f7255a)).b0();
                return;
            default:
                HttpModel httpModel2 = (HttpModel) obj;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, l0.n("onSuccess ->", com.example.baselibrary.utils.b.z(httpModel2)));
                ((XXBaseActivity) ((h7.i) this.e.f7255a)).b0();
                if (!(httpModel2 != null ? kotlin.jvm.internal.e.a(httpModel2.isSuccess(), Boolean.TRUE) : false)) {
                    h7.i iVar = (h7.i) this.e.f7255a;
                    int code = httpModel2 != null ? httpModel2.getCode() : -1;
                    String msg = httpModel2 != null ? httpModel2.getMsg() : null;
                    if (msg == null) {
                        msg = "";
                    }
                    ((PrivacySafeActivity) iVar).S0(code, msg);
                    return;
                }
                Collection collection = (Collection) httpModel2.getResults();
                if (collection == null || collection.isEmpty()) {
                    return;
                }
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    Object results = httpModel2.getResults();
                    kotlin.jvm.internal.e.e(results, "getResults(...)");
                    kVar.X((List) results);
                }
                h7.i iVar2 = (h7.i) this.e.f7255a;
                Object results2 = httpModel2.getResults();
                kotlin.jvm.internal.e.e(results2, "getResults(...)");
                ((PrivacySafeActivity) iVar2).R0((List) results2);
                return;
        }
    }
}
