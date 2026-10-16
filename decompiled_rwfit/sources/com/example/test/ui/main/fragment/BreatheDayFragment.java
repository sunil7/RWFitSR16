package com.example.test.ui.main.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.blesdk.bean.sync.BreatheItemBean;
import com.example.test.R$color;
import com.example.test.R$dimen;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.presenter.main.s;
import com.example.test.ui.XXBaseFragment;
import com.example.test.ui.device.adapter.BreatheItemAdapter;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.CircleProgressView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.tencent.connect.common.Constants;
import f6.c3;
import java.util.ArrayList;
import java.util.List;
import n.g0;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class BreatheDayFragment extends XXBaseFragment<s, c3> implements g7.i {

    /* renamed from: d, reason: collision with root package name */
    public final eh.b f8040d = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.BreatheDayFragment$items$2
        @Override // oh.a
        public final List<BreatheItemBean> invoke() {
            return new ArrayList();
        }
    });
    public final eh.b e = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.main.fragment.BreatheDayFragment$breathAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final BreatheItemAdapter invoke() {
            return new BreatheItemAdapter(R$layout.item_data_breathe, (List) BreatheDayFragment.this.f8040d.getValue());
        }
    });

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final com.example.baselibrary.preseneter.b I() {
        return new s(this);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        c3 c3Var = (c3) this.f7251b;
        if (c3Var != null) {
            return c3Var.f12767a;
        }
        return null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R$layout.fragment_breathe_day, viewGroup, false);
        int i3 = R$id.breatheItems;
        RecyclerView recyclerView = (RecyclerView) he.a(i3, inflate);
        if (recyclerView != null) {
            i3 = R$id.emptyView;
            TextView textView = (TextView) he.a(i3, inflate);
            if (textView != null) {
                i3 = R$id.progress;
                CircleProgressView circleProgressView = (CircleProgressView) he.a(i3, inflate);
                if (circleProgressView != null) {
                    i3 = R$id.tips;
                    TextView textView2 = (TextView) he.a(i3, inflate);
                    if (textView2 != null) {
                        return new c3((NestedScrollView) inflate, recyclerView, textView, circleProgressView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void e0() {
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void h0() {
        ((s) X()).k();
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void m0() {
        b2.a(this);
        c3 c3Var = (c3) this.f7251b;
        if (c3Var != null) {
            RecyclerView recyclerView = c3Var.f12768b;
            g0 g0Var = new g0(getContext());
            g0Var.e(recyclerView.getResources().getColor(R$color.color_3cfff));
            g0Var.o(R$dimen.qb_px_1);
            recyclerView.g(g0Var.d());
            getContext();
            recyclerView.setLayoutManager(new LinearLayoutManager(1));
            recyclerView.setAdapter((BreatheItemAdapter) this.e.getValue());
        }
        c3 c3Var2 = (c3) this.f7251b;
        if (c3Var2 != null) {
            c3Var2.e.setText(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ + getString(R$string.str_mins));
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSyncEvent(EventBusBeans.SyncEvent syncEvent) {
        kotlin.jvm.internal.e.f(syncEvent, "syncEvent");
        if (syncEvent.getSyncType() == 7) {
            ((s) X()).k();
        }
    }
}
