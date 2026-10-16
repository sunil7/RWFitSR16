package com.example.test.presenter.device;

import android.content.Context;
import com.example.network.base.HttpModel;

/* loaded from: classes.dex */
public final class w extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7488d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(Context context, com.example.test.utils.w0 w0Var, int i3) {
        super(context, w0Var);
        this.f7488d = i3;
    }

    private final void c(int i3, Throwable th2) {
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        switch (this.f7488d) {
            case 0:
                break;
            default:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "logout", "errorCode " + i3 + " 错误 " + th2.toString());
                break;
        }
    }

    @Override // d6.b
    public final void b(Object obj) {
        switch (this.f7488d) {
            case 0:
                break;
            default:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "logout", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("result ", com.example.baselibrary.utils.b.z((HttpModel) obj)));
                break;
        }
    }
}
