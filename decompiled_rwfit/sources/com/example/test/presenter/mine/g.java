package com.example.test.presenter.mine;

import android.content.Context;
import com.example.database.table.User;
import com.example.network.base.HttpModel;
import com.example.network.bean.FileBean;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.utils.w0;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public final class g extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7592d;
    public final /* synthetic */ com.example.baselibrary.preseneter.b e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(com.example.baselibrary.preseneter.b bVar, Context context, w0 w0Var, int i3) {
        super(context, w0Var);
        this.f7592d = i3;
        this.e = bVar;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        switch (this.f7592d) {
            case 0:
                h hVar = (h) this.e;
                ((XXBaseActivity) ((h7.d) hVar.f7255a)).b0();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, l0.n("onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                Context f02 = ((h7.d) hVar.f7255a).f0();
                if (f02 != null) {
                    h7.d dVar = (h7.d) hVar.f7255a;
                    String string = f02.getString(R$string.str_network_error);
                    kotlin.jvm.internal.e.e(string, "getString(...)");
                    dVar.S(string);
                    break;
                }
                break;
            case 1:
                th2.toString();
                ((h7.h) ((m) this.e).f7255a).p();
                break;
            default:
                th2.toString();
                ((h7.h) ((n) this.e).f7255a).p();
                break;
        }
    }

    @Override // d6.b
    public final void b(Object obj) {
        switch (this.f7592d) {
            case 0:
                HttpModel httpModel = (HttpModel) obj;
                h hVar = (h) this.e;
                ((XXBaseActivity) ((h7.d) hVar.f7255a)).b0();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, l0.n("onSuccess ->", com.example.baselibrary.utils.b.z(httpModel)));
                boolean a3 = httpModel != null ? kotlin.jvm.internal.e.a(httpModel.isSuccess(), Boolean.TRUE) : false;
                p5.a aVar = hVar.f7255a;
                if (!a3) {
                    h7.d dVar = (h7.d) aVar;
                    Context f02 = dVar.f0();
                    if (f02 != null) {
                        String msg = httpModel != null ? httpModel.getMsg() : null;
                        if (msg == null) {
                            msg = f02.getString(R$string.str_network_error);
                            kotlin.jvm.internal.e.e(msg, "getString(...)");
                        }
                        dVar.S(msg);
                        break;
                    }
                } else {
                    ((h7.d) aVar).Q();
                    break;
                }
                break;
            case 1:
                HttpModel httpModel2 = (HttpModel) obj;
                com.example.baselibrary.utils.b.z(httpModel2);
                boolean a10 = httpModel2 != null ? kotlin.jvm.internal.e.a(httpModel2.isSuccess(), Boolean.TRUE) : false;
                m mVar = (m) this.e;
                if (!a10) {
                    ((h7.h) mVar.f7255a).p();
                    break;
                } else {
                    User user = mVar.f7596b;
                    if (user != null) {
                        user.setAvatar(((FileBean) httpModel2.getResults()).getUrl());
                    }
                    mVar.l();
                    break;
                }
            default:
                HttpModel httpModel3 = (HttpModel) obj;
                com.example.baselibrary.utils.b.z(httpModel3);
                boolean a11 = httpModel3 != null ? kotlin.jvm.internal.e.a(httpModel3.isSuccess(), Boolean.TRUE) : false;
                n nVar = (n) this.e;
                if (!a11) {
                    ((h7.h) nVar.f7255a).p();
                    break;
                } else {
                    User user2 = nVar.f7598b;
                    if (user2 != null) {
                        user2.setAvatar(((FileBean) httpModel3.getResults()).getUrl());
                    }
                    nVar.m();
                    break;
                }
        }
    }
}
