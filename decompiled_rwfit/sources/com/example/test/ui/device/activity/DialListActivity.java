package com.example.test.ui.device.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.blesdk.bean.function.DialInfoBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.adapter.DialListAdapter;
import com.example.test.ui.device.model.DialModel;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class DialListActivity extends XXBaseActivity<com.example.test.presenter.device.z, f6.y> implements f7.h, o5.a {
    public static final /* synthetic */ int L = 0;
    public DialInfoBean E;
    public int F = 1;
    public final int G = 18;
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.DialListActivity$dialType$2
        {
            super(0);
        }

        @Override // oh.a
        public final String invoke() {
            String stringExtra;
            Intent intent = DialListActivity.this.getIntent();
            return (intent == null || (stringExtra = intent.getStringExtra("dial_type")) == null) ? DialListActivity.this.getString(R$string.str_dialo_hot) : stringExtra;
        }
    });
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.DialListActivity$typeId$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Intent intent = DialListActivity.this.getIntent();
            return Integer.valueOf(intent != null ? intent.getIntExtra("type_id", -1) : -1);
        }
    });
    public final eh.b J;
    public final eh.b K;

    public DialListActivity() {
        kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.DialListActivity$weakHandler$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.baselibrary.utils.e invoke() {
                return new com.example.baselibrary.utils.e(DialListActivity.this);
            }
        });
        this.J = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.DialListActivity$items$2
            @Override // oh.a
            public final List<DialModel> invoke() {
                return new ArrayList();
            }
        });
        this.K = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.DialListActivity$dialAdapter$2
            {
                super(0);
            }

            @Override // oh.a
            public final DialListAdapter invoke() {
                DialListActivity dialListActivity = DialListActivity.this;
                int i3 = DialListActivity.L;
                return new DialListAdapter(dialListActivity.R0());
            }
        });
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.z(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.y) this.f7247z.getValue()).f13451a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_dial_list, (ViewGroup) null, false);
        int i3 = R$id.dialList;
        RecyclerView recyclerView = (RecyclerView) he.a(i3, inflate);
        if (recyclerView != null) {
            i3 = R$id.refreshLayout;
            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) he.a(i3, inflate);
            if (smartRefreshLayout != null) {
                i3 = R$id.titleView;
                TitleView titleView = (TitleView) he.a(i3, inflate);
                if (titleView != null) {
                    return new f6.y((LinearLayout) inflate, recyclerView, smartRefreshLayout, titleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((com.example.test.presenter.device.z) I0()).l();
        ((com.example.test.presenter.device.z) I0()).k(((Number) this.I.getValue()).intValue(), this.F, this.G);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        TitleView titleView = ((f6.y) bVar.getValue()).f13454d;
        String str = (String) this.H.getValue();
        kotlin.jvm.internal.e.e(str, "<get-dialType>(...)");
        titleView.setTitle(str);
        ((f6.y) bVar.getValue()).f13454d.setOnTitleListener(new y2.f(this, 15));
        boolean z5 = true;
        ((f6.y) bVar.getValue()).f13453c.B = true;
        SmartRefreshLayout smartRefreshLayout = ((f6.y) bVar.getValue()).f13453c;
        smartRefreshLayout.V = true;
        smartRefreshLayout.C = true;
        SmartRefreshLayout smartRefreshLayout2 = ((f6.y) bVar.getValue()).f13453c;
        com.example.test.ui.view.n nVar = new com.example.test.ui.view.n();
        new Handler(Looper.getMainLooper());
        nVar.f8701a = this;
        View inflate = LayoutInflater.from(this).inflate(R$layout.layout_refresh_head, (ViewGroup) null);
        nVar.f8703c = inflate;
        nVar.f8704d = (ImageView) inflate.findViewById(R$id.headRefreshImageView);
        nVar.e = (TextView) inflate.findViewById(R$id.headContentTv);
        nVar.f8702b = (ProgressBar) inflate.findViewById(R$id.headProgressBar);
        smartRefreshLayout2.y(nVar);
        SmartRefreshLayout smartRefreshLayout3 = ((f6.y) bVar.getValue()).f13453c;
        com.example.test.ui.view.h hVar = new com.example.test.ui.view.h();
        View inflate2 = LayoutInflater.from(this).inflate(R$layout.layout_refresh_foot, (ViewGroup) null);
        hVar.f8692a = inflate2;
        hVar.f8693b = (TextView) inflate2.findViewById(R$id.headContentTv);
        hVar.f8694c = (ProgressBar) inflate2.findViewById(R$id.headProgressBar);
        smartRefreshLayout3.x(hVar);
        ((f6.y) bVar.getValue()).f13453c.W = new m(this);
        SmartRefreshLayout smartRefreshLayout4 = ((f6.y) bVar.getValue()).f13453c;
        smartRefreshLayout4.f11637a0 = new m(this);
        if (!smartRefreshLayout4.C && smartRefreshLayout4.V) {
            z5 = false;
        }
        smartRefreshLayout4.C = z5;
        ((f6.y) bVar.getValue()).f13452b.setLayoutManager(new GridLayoutManager(3));
        y6.c cVar = new y6.c(com.example.baselibrary.utils.b.f(this, 20.0f));
        cVar.f20012c = 0;
        ((f6.y) bVar.getValue()).f13452b.g(cVar);
        ((f6.y) bVar.getValue()).f13452b.setAdapter((DialListAdapter) this.K.getValue());
    }

    public final List R0() {
        return (List) this.J.getValue();
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
        eh.b bVar = this.f7247z;
        ((f6.y) bVar.getValue()).f13453c.o();
        SmartRefreshLayout smartRefreshLayout = ((f6.y) bVar.getValue()).f13453c;
        smartRefreshLayout.n(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - smartRefreshLayout.f11659i1))), 300) << 16, false);
    }
}
