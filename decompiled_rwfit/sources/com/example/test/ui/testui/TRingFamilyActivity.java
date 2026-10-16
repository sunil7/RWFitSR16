package com.example.test.ui.testui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.FamilyFriendRecyclerView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class TRingFamilyActivity extends XXBaseActivity<com.example.test.presenter.main.l0, f6.d0> implements g7.n, View.OnClickListener {
    public static final /* synthetic */ int J = 0;
    public FamilyFriendRecyclerView F;
    public SwipeRefreshLayout G;
    public u6.k H;
    public final ArrayList E = new ArrayList();
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingFamilyActivity$deleteTipsDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(TRingFamilyActivity.this);
            rVar.b(R$string.str_family_friend_delete_tips);
            return rVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.main.l0(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.d0) this.f7247z.getValue()).f12775a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_family, (ViewGroup) null, false);
        int i3 = R$id.imageView;
        if (((ImageView) he.a(i3, inflate)) != null) {
            i3 = R$id.no_friend;
            if (((RelativeLayout) he.a(i3, inflate)) != null) {
                i3 = R$id.no_friend_linear;
                LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
                if (linearLayout != null) {
                    i3 = R$id.no_friend_text;
                    TextView textView = (TextView) he.a(i3, inflate);
                    if (textView != null) {
                        i3 = R$id.recyclerView;
                        if (((FamilyFriendRecyclerView) he.a(i3, inflate)) != null) {
                            i3 = R$id.srl_refresh;
                            if (((SwipeRefreshLayout) he.a(i3, inflate)) != null) {
                                i3 = R$id.titleView;
                                TitleView titleView = (TitleView) he.a(i3, inflate);
                                if (titleView != null) {
                                    return new f6.d0((LinearLayout) inflate, linearLayout, textView, titleView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        ((f6.d0) this.f7247z.getValue()).f12778d.setOnTitleListener(new w(this));
        View findViewById = findViewById(R$id.recyclerView);
        kotlin.jvm.internal.e.d(findViewById, "null cannot be cast to non-null type com.example.test.ui.view.FamilyFriendRecyclerView");
        this.F = (FamilyFriendRecyclerView) findViewById;
        View findViewById2 = findViewById(R$id.srl_refresh);
        kotlin.jvm.internal.e.d(findViewById2, "null cannot be cast to non-null type androidx.swiperefreshlayout.widget.SwipeRefreshLayout");
        this.G = (SwipeRefreshLayout) findViewById2;
        ((com.example.test.presenter.main.l0) I0()).k();
        ArrayList arrayList = this.E;
        u6.k kVar = new u6.k();
        kVar.f18905a = this;
        LayoutInflater.from(this);
        kVar.f18906b = arrayList;
        this.H = kVar;
        FamilyFriendRecyclerView familyFriendRecyclerView = this.F;
        kotlin.jvm.internal.e.c(familyFriendRecyclerView);
        familyFriendRecyclerView.setLayoutManager(new LinearLayoutManager(1));
        FamilyFriendRecyclerView familyFriendRecyclerView2 = this.F;
        kotlin.jvm.internal.e.c(familyFriendRecyclerView2);
        familyFriendRecyclerView2.setAdapter(this.H);
        w wVar = new w(this);
        FamilyFriendRecyclerView familyFriendRecyclerView3 = this.F;
        kotlin.jvm.internal.e.c(familyFriendRecyclerView3);
        familyFriendRecyclerView3.setOnItemClickListener(wVar);
        u6.k kVar2 = this.H;
        kotlin.jvm.internal.e.c(kVar2);
        kVar2.setOnItemClickListener(wVar);
        SwipeRefreshLayout swipeRefreshLayout = this.G;
        kotlin.jvm.internal.e.c(swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new af.a(this, 10));
    }

    public final void R0() {
        ((com.example.test.presenter.main.l0) I0()).k();
        u6.k kVar = this.H;
        kotlin.jvm.internal.e.c(kVar);
        kVar.notifyDataSetChanged();
    }

    public final void S0(int i3, String str) {
        b0();
        if (i3 == -1) {
            w0(R$string.str_network_error);
            return;
        }
        com.example.test.utils.w0.d().getClass();
        int c9 = com.example.test.utils.w0.c(i3);
        if (c9 != 0) {
            w0(c9);
        } else if (str.length() > 0) {
            com.example.baselibrary.utils.d.b(str);
        } else {
            w0(R$string.str_network_error);
        }
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
