package com.example.test.presenter.device;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.example.blesdk.bean.function.DialInfoBean;
import com.example.blesdk.bean.function.FirmVersionBean;
import com.example.database.table.Devices;
import com.example.network.base.HttpModel;
import com.example.network.bean.AppVersionBean;
import com.example.network.bean.DialBean;
import com.example.network.bean.DialListBean;
import com.example.network.bean.DialPageBean;
import com.example.test.R$string;
import com.example.test.presenter.main.r1;
import com.example.test.service.u1;
import com.example.test.ui.RingBaseActivity;
import com.example.test.ui.device.activity.DialListActivity;
import com.example.test.ui.device.activity.ScanQrFamilyActivity;
import com.example.test.ui.device.adapter.DialListAdapter;
import com.example.test.ui.device.adapter.DialTypeAdapter;
import com.example.test.ui.device.fragment.DialRecommendFragment;
import com.example.test.ui.device.model.DialModel;
import com.example.test.ui.device.model.DialTypeModel;
import com.example.test.ui.main.fragment.MineFragment;
import com.example.test.ui.testui.TRingFamilyActivity;
import com.example.test.ui.testui.TRingFamilyAddFriendActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.p1;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import f6.n3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class y extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f7496d;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(Object obj, Context context, com.example.test.utils.w0 w0Var, int i3) {
        super(context, w0Var);
        this.f7496d = i3;
        this.e = obj;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        switch (this.f7496d) {
            case 0:
                th2.getMessage();
                break;
            case 1:
                th2.getMessage();
                break;
            case 2:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                TRingFamilyAddFriendActivity tRingFamilyAddFriendActivity = (TRingFamilyAddFriendActivity) ((g7.l) ((com.example.test.presenter.main.i0) this.e).f7255a);
                tRingFamilyAddFriendActivity.getClass();
                String string = tRingFamilyAddFriendActivity.getString(R$string.str_network_error);
                if (string == null) {
                    string = "";
                }
                tRingFamilyAddFriendActivity.R0(i3, string);
                break;
            case 3:
                th2.getMessage();
                break;
            case 4:
                ((RingBaseActivity) ((e7.b) ((com.example.test.presenter.main.z0) this.e).f7255a)).b0();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                break;
            case 5:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                break;
            case 6:
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("onServeError error ->", com.example.baselibrary.utils.b.z(th2)));
                ScanQrFamilyActivity scanQrFamilyActivity = (ScanQrFamilyActivity) ((y2.f) this.e).f19953b;
                String string2 = scanQrFamilyActivity.getString(R$string.str_network_error);
                if (string2 == null) {
                    string2 = "";
                }
                scanQrFamilyActivity.L0(i3, string2);
                break;
            case 7:
                th2.getMessage();
                break;
            default:
                ((u1) this.e).getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("上传设备功能支持信息失败: ", th2.getMessage()));
                break;
        }
    }

    @Override // d6.b
    public final void b(Object obj) {
        List<DialBean> rows;
        Collection collection;
        int code;
        String msg;
        Devices c9;
        switch (this.f7496d) {
            case 0:
                HttpModel httpModel = (HttpModel) obj;
                if (httpModel != null) {
                    Boolean isSuccess = httpModel.isSuccess();
                    kotlin.jvm.internal.e.e(isSuccess, "isSuccess(...)");
                    if (!isSuccess.booleanValue() || httpModel.getResults() == null || (rows = ((DialPageBean) httpModel.getResults()).getRows()) == null || rows.isEmpty()) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    List<DialBean> rows2 = ((DialPageBean) httpModel.getResults()).getRows();
                    if (rows2 != null) {
                        for (DialBean dialBean : rows2) {
                            DialModel dialModel = new DialModel();
                            dialModel.setDialBean(dialBean);
                            arrayList.add(dialModel);
                        }
                    }
                    DialListActivity dialListActivity = (DialListActivity) ((f7.h) ((z) this.e).f7255a);
                    dialListActivity.getClass();
                    int i3 = dialListActivity.F;
                    eh.b bVar = dialListActivity.f7247z;
                    if (i3 == 1) {
                        dialListActivity.R0().clear();
                        ((f6.y) bVar.getValue()).f13453c.o();
                    } else {
                        SmartRefreshLayout smartRefreshLayout = ((f6.y) bVar.getValue()).f13453c;
                        smartRefreshLayout.n(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - smartRefreshLayout.f11659i1))), 300) << 16, false);
                    }
                    kotlin.collections.n.i(dialListActivity.R0(), arrayList);
                    if (dialListActivity.E != null) {
                        Iterator it = dialListActivity.R0().iterator();
                        while (it.hasNext()) {
                            ((DialModel) it.next()).setDialInfoBean(dialListActivity.E);
                        }
                    }
                    if (arrayList.size() < dialListActivity.G) {
                        ((f6.y) bVar.getValue()).f13453c.w(true);
                        dialListActivity.R0().size();
                    }
                    ((DialListAdapter) dialListActivity.K.getValue()).notifyDataSetChanged();
                    return;
                }
                return;
            case 1:
                HttpModel httpModel2 = (HttpModel) obj;
                if (httpModel2 != null) {
                    Boolean isSuccess2 = httpModel2.isSuccess();
                    kotlin.jvm.internal.e.e(isSuccess2, "isSuccess(...)");
                    if (!isSuccess2.booleanValue() || (collection = (Collection) httpModel2.getResults()) == null || collection.isEmpty()) {
                        return;
                    }
                    ArrayList arrayList2 = new ArrayList();
                    Object results = httpModel2.getResults();
                    kotlin.jvm.internal.e.e(results, "getResults(...)");
                    for (DialListBean dialListBean : (Iterable) results) {
                        List<DialBean> dials = dialListBean.getDials();
                        if (dials != null && !dials.isEmpty()) {
                            DialTypeModel dialTypeModel = new DialTypeModel();
                            dialTypeModel.setClassifyId(dialListBean.getClassifyId());
                            dialTypeModel.setType(dialListBean.getClassifyName());
                            ArrayList arrayList3 = new ArrayList();
                            List<DialBean> dials2 = dialListBean.getDials();
                            kotlin.jvm.internal.e.e(dials2, "getDials(...)");
                            for (DialBean dialBean2 : dials2) {
                                DialModel dialModel2 = new DialModel();
                                dialModel2.setDialBean(dialBean2);
                                arrayList3.add(dialModel2);
                            }
                            dialTypeModel.setDials(arrayList3);
                            arrayList2.add(dialTypeModel);
                        }
                    }
                    DialRecommendFragment dialRecommendFragment = (DialRecommendFragment) ((f7.j) ((b0) this.e).f7255a);
                    dialRecommendFragment.getClass();
                    dialRecommendFragment.q0().clear();
                    kotlin.collections.n.i(dialRecommendFragment.q0(), arrayList2);
                    DialInfoBean dialInfoBean = dialRecommendFragment.f7906d;
                    if (dialInfoBean != null) {
                        Iterator it2 = dialRecommendFragment.q0().iterator();
                        while (it2.hasNext()) {
                            List<DialModel> dials3 = ((DialTypeModel) it2.next()).getDials();
                            if (dials3 != null) {
                                Iterator<T> it3 = dials3.iterator();
                                while (it3.hasNext()) {
                                    ((DialModel) it3.next()).setDialInfoBean(dialInfoBean);
                                }
                            }
                        }
                    }
                    ((DialTypeAdapter) dialRecommendFragment.f7907f.getValue()).notifyItemRangeChanged(0, dialRecommendFragment.q0().size());
                    return;
                }
                return;
            case 2:
                HttpModel httpModel3 = (HttpModel) obj;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("register ->", com.example.baselibrary.utils.b.z(httpModel3)));
                boolean a3 = httpModel3 != null ? kotlin.jvm.internal.e.a(httpModel3.isSuccess(), Boolean.TRUE) : false;
                com.example.test.presenter.main.i0 i0Var = (com.example.test.presenter.main.i0) this.e;
                if (a3) {
                    TRingFamilyAddFriendActivity tRingFamilyAddFriendActivity = (TRingFamilyAddFriendActivity) ((g7.l) i0Var.f7255a);
                    tRingFamilyAddFriendActivity.b0();
                    tRingFamilyAddFriendActivity.w0(R$string.str_please_input_legal_friend_apply_success);
                    tRingFamilyAddFriendActivity.startActivity(new Intent(tRingFamilyAddFriendActivity, (Class<?>) TRingFamilyActivity.class));
                    return;
                }
                g7.l lVar = (g7.l) i0Var.f7255a;
                code = httpModel3 != null ? httpModel3.getCode() : -1;
                msg = httpModel3 != null ? httpModel3.getMsg() : null;
                if (msg == null) {
                    msg = "";
                }
                ((TRingFamilyAddFriendActivity) lVar).R0(code, msg);
                return;
            case 3:
                com.example.baselibrary.utils.b.z((HttpModel) obj);
                com.example.test.service.e.h().f7688h = false;
                FirmVersionBean firmVersionBean = new FirmVersionBean();
                firmVersionBean.setDeviceNo(((com.example.test.presenter.main.p0) this.e).e);
                firmVersionBean.setDeviceClazz(((com.example.test.presenter.main.p0) this.e).f7545f);
                Object obj2 = com.example.test.service.p0.f7741g;
                com.example.test.service.p0 a10 = com.google.android.gms.internal.mlkit_vision_barcode.m1.a();
                a10.f7746f = false;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "OTAService", "获取耳机固件版本成功 " + firmVersionBean);
                a10.d().setFromVersion(firmVersionBean.getDeviceNo());
                kotlin.jvm.internal.e.e(a10.d().getFromVersion(), "getFromVersion(...)");
                Iterator it4 = ((List) a10.f7744c.getValue()).iterator();
                if (it4.hasNext()) {
                    throw android.support.v4.media.session.e.d(it4);
                }
                a10.e();
                yh.d.b().e(firmVersionBean);
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar == null || (c9 = kVar.c()) == null) {
                    return;
                }
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "OTAService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("耳机固件版本信息：", firmVersionBean.getDeviceNo()));
                c9.setDeviceVer(firmVersionBean.getDeviceNo());
                return;
            case 4:
                HttpModel httpModel4 = (HttpModel) obj;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("onSuccess ->", com.example.baselibrary.utils.b.z(httpModel4)));
                ((RingBaseActivity) ((e7.b) ((com.example.test.presenter.main.z0) this.e).f7255a)).b0();
                if (httpModel4 != null ? kotlin.jvm.internal.e.a(httpModel4.isSuccess(), Boolean.TRUE) : false) {
                    Collection collection2 = (Collection) httpModel4.getResults();
                    if ((collection2 == null || collection2.isEmpty()) || ((List) httpModel4.getResults()).size() < 3) {
                        return;
                    }
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                    if (kVar2 != null) {
                        Object results2 = httpModel4.getResults();
                        kotlin.jvm.internal.e.e(results2, "getResults(...)");
                        kVar2.X((List) results2);
                    }
                    Object obj3 = com.example.test.service.g1.e;
                    p1.a().o(true);
                    return;
                }
                return;
            case 5:
                HttpModel httpModel5 = (HttpModel) obj;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("onSuccess ->", com.example.baselibrary.utils.b.z(httpModel5)));
                if (httpModel5 != null) {
                    AppVersionBean appVersionBean = (AppVersionBean) httpModel5.getResults();
                    com.example.test.presenter.main.a1 a1Var = (com.example.test.presenter.main.a1) this.e;
                    if (appVersionBean == null) {
                        MineFragment mineFragment = (MineFragment) ((g7.r) a1Var.f7255a);
                        Object obj4 = mineFragment.f7251b;
                        kotlin.jvm.internal.e.c(obj4);
                        String string = mineFragment.getString(R$string.str_current_laster);
                        kotlin.jvm.internal.e.e(string, "getString(...)");
                        ((n3) obj4).f13148d.setHintStr(string);
                        return;
                    }
                    g7.r rVar = (g7.r) a1Var.f7255a;
                    String version = appVersionBean.getVersion();
                    kotlin.jvm.internal.e.e(version, "getVersion(...)");
                    MineFragment mineFragment2 = (MineFragment) rVar;
                    mineFragment2.getClass();
                    if (version.length() > 0) {
                        Object obj5 = mineFragment2.f7251b;
                        kotlin.jvm.internal.e.c(obj5);
                        ((n3) obj5).f13148d.setHighTips(true);
                        Object obj6 = mineFragment2.f7251b;
                        kotlin.jvm.internal.e.c(obj6);
                        ((n3) obj6).f13148d.setHintStr(version);
                        return;
                    }
                    return;
                }
                return;
            case 6:
                HttpModel httpModel6 = (HttpModel) obj;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, com.google.android.gms.internal.mlkit_vision_barcode.l0.n("register ->", com.example.baselibrary.utils.b.z(httpModel6)));
                boolean a11 = httpModel6 != null ? kotlin.jvm.internal.e.a(httpModel6.isSuccess(), Boolean.TRUE) : false;
                y2.f fVar = (y2.f) this.e;
                if (a11) {
                    Toast.makeText((ScanQrFamilyActivity) fVar.f19953b, R$string.str_please_input_legal_friend_apply_success, 0).show();
                    return;
                }
                ScanQrFamilyActivity scanQrFamilyActivity = (ScanQrFamilyActivity) fVar.f19953b;
                code = httpModel6 != null ? httpModel6.getCode() : -1;
                msg = httpModel6 != null ? httpModel6.getMsg() : null;
                if (msg == null) {
                    msg = "";
                }
                scanQrFamilyActivity.L0(code, msg);
                return;
            case 7:
                com.example.baselibrary.utils.b.z((HttpModel) obj);
                com.example.test.service.e.h().f7688h = false;
                ((r1) this.e).getClass();
                return;
            default:
                ((u1) this.e).getClass();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "上传设备功能支持信息成功");
                return;
        }
    }
}
