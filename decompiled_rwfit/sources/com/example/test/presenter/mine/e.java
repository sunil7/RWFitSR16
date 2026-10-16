package com.example.test.presenter.mine;

import android.content.Context;
import com.example.database.table.User;
import com.example.network.base.HttpModel;
import com.example.network.bean.FileBean;
import com.example.test.utils.w0;

/* loaded from: classes.dex */
public final class e extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ User f7589d;
    public final /* synthetic */ f e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Integer f7590f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(User user, f fVar, Integer num, Context context, w0 w0Var) {
        super(context, w0Var);
        this.f7589d = user;
        this.e = fVar;
        this.f7590f = num;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        th2.toString();
        this.e.m(this.f7589d, this.f7590f);
    }

    @Override // d6.b
    public final void b(Object obj) {
        HttpModel httpModel = (HttpModel) obj;
        com.example.baselibrary.utils.b.z(httpModel);
        boolean a3 = httpModel != null ? kotlin.jvm.internal.e.a(httpModel.isSuccess(), Boolean.TRUE) : false;
        Integer num = this.f7590f;
        f fVar = this.e;
        User user = this.f7589d;
        if (!a3) {
            fVar.m(user, num);
        } else {
            user.setAvatar(((FileBean) httpModel.getResults()).getUrl());
            fVar.m(user, num);
        }
    }
}
