package com.example.test.presenter.main;

import com.example.network.api.UserApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.MemberFriendApplyBean;
import com.example.network.bean.MemberFriendBean;
import com.example.test.ui.testui.TRingFamilyActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: classes.dex */
public final class l0 extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.util.ArrayList] */
    public final void k() {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = new ArrayList();
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        ref$ObjectRef2.element = new ArrayList();
        c6.d dVar = c6.d.f3392c;
        rg.l<HttpModel<List<MemberFriendApplyBean>>> memberFriendGetDoApplyList = ((UserApi) dVar.f113a).memberFriendGetDoApplyList();
        kotlin.jvm.internal.e.e(memberFriendGetDoApplyList, "memberFriendGetDoApplyList(...)");
        rg.l u10 = com.example.baselibrary.utils.b.u(memberFriendGetDoApplyList);
        TRingFamilyActivity tRingFamilyActivity = (TRingFamilyActivity) ((g7.n) this.f7255a);
        tRingFamilyActivity.getClass();
        u10.blockingSubscribe(new k0(this, ref$ObjectRef, tRingFamilyActivity, com.example.test.utils.w0.d(), 0));
        rg.l<HttpModel<List<MemberFriendBean>>> memberFriendGetList = ((UserApi) dVar.f113a).memberFriendGetList();
        kotlin.jvm.internal.e.e(memberFriendGetList, "memberFriendGetList(...)");
        rg.l u11 = com.example.baselibrary.utils.b.u(memberFriendGetList);
        tRingFamilyActivity.getClass();
        u11.blockingSubscribe(new k0(this, ref$ObjectRef2, tRingFamilyActivity, com.example.test.utils.w0.d(), 1));
        List applyBeans = (List) ref$ObjectRef.element;
        List friendBeans = (List) ref$ObjectRef2.element;
        tRingFamilyActivity.getClass();
        kotlin.jvm.internal.e.f(applyBeans, "applyBeans");
        kotlin.jvm.internal.e.f(friendBeans, "friendBeans");
        ArrayList arrayList = tRingFamilyActivity.E;
        arrayList.clear();
        if (!applyBeans.isEmpty()) {
            arrayList.add(1);
            arrayList.addAll(applyBeans);
        }
        if (!friendBeans.isEmpty()) {
            arrayList.add(2);
            arrayList.addAll(friendBeans);
        }
        boolean isEmpty = arrayList.isEmpty();
        eh.b bVar = tRingFamilyActivity.f7247z;
        if (isEmpty) {
            ((f6.d0) bVar.getValue()).f12776b.setVisibility(0);
            ((f6.d0) bVar.getValue()).f12777c.setVisibility(0);
        } else {
            ((f6.d0) bVar.getValue()).f12776b.setVisibility(8);
            ((f6.d0) bVar.getValue()).f12777c.setVisibility(8);
        }
    }
}
