package com.example.test.ui.device.fragment;

import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.blesdk.bean.function.DialInfoBean;
import com.example.network.bean.DialBean;
import com.example.test.R$dimen;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.presenter.device.b0;
import com.example.test.ui.XXBaseFragment;
import com.example.test.ui.device.adapter.DialTypeAdapter;
import com.example.test.ui.device.model.DialModel;
import com.example.test.ui.device.model.DialTypeModel;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import eh.b;
import f6.j3;
import f7.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.e;
import n.g0;
import org.greenrobot.eventbus.ThreadMode;
import yh.d;
import yh.k;

/* loaded from: classes.dex */
public final class DialRecommendFragment extends XXBaseFragment<b0, j3> implements j {

    /* renamed from: d, reason: collision with root package name */
    public DialInfoBean f7906d;
    public final b e = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.fragment.DialRecommendFragment$dialTypes$2
        @Override // oh.a
        public final List<DialTypeModel> invoke() {
            return new ArrayList();
        }
    });

    /* renamed from: f, reason: collision with root package name */
    public final b f7907f = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.fragment.DialRecommendFragment$dialTypeAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final DialTypeAdapter invoke() {
            DialTypeAdapter dialTypeAdapter = new DialTypeAdapter(R$layout.item_dial_type, DialRecommendFragment.this.q0());
            dialTypeAdapter.getChildClickViewIds().add(Integer.valueOf(R$id.moreTv));
            dialTypeAdapter.setOnItemChildClickListener(new af.a(DialRecommendFragment.this, 5));
            return dialTypeAdapter;
        }
    });

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final com.example.baselibrary.preseneter.b I() {
        return new b0(this);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        j3 j3Var = (j3) this.f7251b;
        if (j3Var != null) {
            return j3Var.f13021a;
        }
        return null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R$layout.fragment_dial_recommend, viewGroup, false);
        int i3 = R$id.dialType;
        RecyclerView recyclerView = (RecyclerView) he.a(i3, inflate);
        if (recyclerView != null) {
            return new j3((NestedScrollView) inflate, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void e0() {
    }

    @Override // p5.a
    public final Context f0() {
        FragmentActivity activity = getActivity();
        e.d(activity, "null cannot be cast to non-null type android.content.Context");
        return activity;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void h0() {
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void m0() {
        d.b().e(this);
        ((b0) X()).l();
        ((b0) X()).k();
        j3 j3Var = (j3) this.f7251b;
        if (j3Var != null) {
            RecyclerView recyclerView = j3Var.f13022b;
            f0();
            recyclerView.setLayoutManager(new LinearLayoutManager(1));
            g0 g0Var = new g0(f0());
            g0Var.e(recyclerView.getResources().getColor(R.color.transparent));
            g0Var.o(R$dimen.qb_px_10);
            recyclerView.g(g0Var.d());
            recyclerView.setAdapter((DialTypeAdapter) this.f7907f.getValue());
            recyclerView.setItemAnimator(null);
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @k(threadMode = ThreadMode.MAIN)
    public final void onHomeDialRefreshEvent(EventBusBeans.HomeDialEvent homeDialEvent) {
        Object obj;
        e.f(homeDialEvent, "homeDialEvent");
        Iterator it = q0().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            List<DialModel> dials = ((DialTypeModel) next).getDials();
            if (dials != null) {
                Iterator<T> it2 = dials.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next2 = it2.next();
                    DialBean dialBean = ((DialModel) next2).getDialBean();
                    if (dialBean != null && dialBean.getId() == homeDialEvent.getDialId()) {
                        obj = next2;
                        break;
                    }
                }
                obj = (DialModel) obj;
            }
            if (obj != null) {
                obj = next;
                break;
            }
        }
        if (((DialTypeModel) obj) != null) {
            ((b0) X()).k();
        }
    }

    public final List q0() {
        return (List) this.e.getValue();
    }
}
