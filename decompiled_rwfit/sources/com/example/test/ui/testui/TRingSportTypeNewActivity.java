package com.example.test.ui.testui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.R$array;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.presenter.main.f1;
import com.example.test.ui.XXBaseActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.j2;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class TRingSportTypeNewActivity extends XXBaseActivity<f1, j2> implements p5.a, View.OnClickListener {
    public static final /* synthetic */ int G = 0;
    public u6.u E;
    public RecyclerView F;

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new f1(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((j2) this.f7247z.getValue()).f13019a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_sporttype_new, (ViewGroup) null, false);
        int i3 = R$id.sport_type_list;
        if (((RecyclerView) he.a(i3, inflate)) != null) {
            i3 = R$id.toolbar;
            TRingToolBarView tRingToolBarView = (TRingToolBarView) he.a(i3, inflate);
            if (tRingToolBarView != null) {
                return new j2((LinearLayout) inflate, tRingToolBarView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        Log.e("qob", "DeviceScanFragment initData");
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        View findViewById = findViewById(R$id.sport_type_list);
        kotlin.jvm.internal.e.d(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        this.F = (RecyclerView) findViewById;
        ((j2) this.f7247z.getValue()).f13020b.setOnViewChildListener(new x0(this));
        String[] stringArray = getResources().getStringArray(R$array.jlrunning_string_array);
        kotlin.jvm.internal.e.e(stringArray, "getStringArray(...)");
        List d5 = kotlin.collections.i.d(Arrays.copyOf(stringArray, stringArray.length));
        List subList = d5.subList(7, d5.size());
        u6.u uVar = new u6.u();
        uVar.f18925a = this;
        LayoutInflater.from(this);
        uVar.f18926b = subList;
        this.E = uVar;
        RecyclerView recyclerView = this.F;
        kotlin.jvm.internal.e.c(recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        RecyclerView recyclerView2 = this.F;
        kotlin.jvm.internal.e.c(recyclerView2);
        recyclerView2.setAdapter(this.E);
        x0 x0Var = new x0(this);
        u6.u uVar2 = this.E;
        kotlin.jvm.internal.e.c(uVar2);
        uVar2.setOnItemClickListener(x0Var);
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
