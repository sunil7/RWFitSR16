package com.example.test.presenter.main;

import androidx.fragment.app.FragmentActivity;
import com.example.network.base.HttpModel;
import com.example.network.bean.DialBean;
import com.example.test.R$id;
import com.example.test.ui.device.model.DialInfoModel;
import com.example.test.ui.device.model.DialModel;
import com.example.test.ui.main.fragment.DeviceFragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class v extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7574d;
    public final /* synthetic */ h0 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(h0 h0Var, FragmentActivity fragmentActivity, com.example.test.utils.w0 w0Var, int i3) {
        super(fragmentActivity, w0Var);
        this.f7574d = i3;
        this.e = h0Var;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        switch (this.f7574d) {
            case 0:
                th2.getMessage();
                break;
            default:
                th2.getMessage();
                break;
        }
    }

    @Override // d6.b
    public final void b(Object obj) {
        Collection collection;
        List list;
        switch (this.f7574d) {
            case 0:
                com.example.baselibrary.utils.b.z((HttpModel) obj);
                com.example.test.service.e.h().f7688h = false;
                this.e.k();
                break;
            default:
                HttpModel httpModel = (HttpModel) obj;
                com.example.baselibrary.utils.b.z(httpModel);
                if (httpModel != null) {
                    Boolean isSuccess = httpModel.isSuccess();
                    kotlin.jvm.internal.e.e(isSuccess, "isSuccess(...)");
                    if (isSuccess.booleanValue() && (collection = (Collection) httpModel.getResults()) != null && !collection.isEmpty()) {
                        ArrayList arrayList = new ArrayList();
                        Object results = httpModel.getResults();
                        kotlin.jvm.internal.e.e(results, "getResults(...)");
                        for (DialBean dialBean : (Iterable) results) {
                            DialModel dialModel = new DialModel();
                            dialModel.setDialBean(dialBean);
                            arrayList.add(dialModel);
                        }
                        DeviceFragment deviceFragment = (DeviceFragment) ((g7.k) this.e.f7255a);
                        deviceFragment.getClass();
                        int a3 = deviceFragment.z0().a(R$id.dv_market);
                        com.example.baselibrary.utils.b.z(arrayList);
                        if (a3 > -1 && (list = deviceFragment.e) != null) {
                            Object obj2 = list.get(a3);
                            kotlin.jvm.internal.e.d(obj2, "null cannot be cast to non-null type com.example.test.ui.device.model.DialInfoModel");
                            DialInfoModel dialInfoModel = (DialInfoModel) obj2;
                            dialInfoModel.setDialModels(arrayList);
                            deviceFragment.f8060x = dialInfoModel;
                            deviceFragment.z0().notifyItemChanged(a3);
                            Object obj3 = list.get(a3);
                            com.example.baselibrary.utils.b.z(list.get(a3));
                            Objects.toString(obj3);
                            break;
                        }
                    }
                }
                break;
        }
    }
}
