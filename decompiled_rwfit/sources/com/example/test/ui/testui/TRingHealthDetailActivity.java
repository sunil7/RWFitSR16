package com.example.test.ui.testui;

import android.R;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.R$dimen;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.presenter.main.s1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.adapter.TRingHealthDetailAdapter;
import com.example.test.ui.model.TRingHealthItemModel;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class TRingHealthDetailActivity extends XXBaseActivity<s1, f6.h0> implements y {
    public String E = "2024/03/27";
    public int F;

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new s1(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.h0) this.f7247z.getValue()).f12944a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_health_detail, (ViewGroup) null, false);
        int i3 = R$id.healthDataList;
        RecyclerView recyclerView = (RecyclerView) he.a(i3, inflate);
        if (recyclerView != null) {
            i3 = R$id.iv_health_nodata;
            if (((ImageView) he.a(i3, inflate)) != null) {
                i3 = R$id.ll_health_nodata;
                RelativeLayout relativeLayout = (RelativeLayout) he.a(i3, inflate);
                if (relativeLayout != null) {
                    i3 = R$id.toolbar;
                    TRingToolBarView tRingToolBarView = (TRingToolBarView) he.a(i3, inflate);
                    if (tRingToolBarView != null) {
                        i3 = R$id.tv_healthdata_date;
                        TextView textView = (TextView) he.a(i3, inflate);
                        if (textView != null) {
                            return new f6.h0((LinearLayout) inflate, recyclerView, relativeLayout, tRingToolBarView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        int i3 = this.F;
        if (i3 == 0) {
            ((s1) I0()).n(this.E);
            return;
        }
        if (i3 == 1) {
            ((s1) I0()).l(this.E);
            return;
        }
        if (i3 == 3) {
            ((s1) I0()).p(this.E);
            return;
        }
        if (i3 == 4) {
            Log.d("tong", "getDayBloodSugarHealthDetail");
            ((s1) I0()).k(this.E);
        } else if (i3 == 5) {
            ((s1) I0()).m(this.E);
        } else {
            ((s1) I0()).o(this.E);
        }
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((f6.h0) bVar.getValue()).f12946c.setVisibility(8);
        String stringExtra = getIntent().getStringExtra("healthDate");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.E = stringExtra;
        this.F = getIntent().getIntExtra("healthDataType", 0);
        ((f6.h0) bVar.getValue()).e.setText(this.E);
        Log.e("qob", "mHealthDateStr " + this.E + " mHealthDataType " + this.F);
        ((f6.h0) bVar.getValue()).f12947d.setOnViewChildListener(new a1(this, 4));
    }

    public final void R0() {
        ((f6.h0) this.f7247z.getValue()).f12946c.setVisibility(0);
    }

    public final void S0(List list) {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : list) {
            int i10 = i3 + 1;
            if (i3 < 0) {
                kotlin.collections.i.f();
                throw null;
            }
            TRingHealthItemModel tRingHealthItemModel = (TRingHealthItemModel) obj;
            if (i3 == 0 || tRingHealthItemModel.getHealthTime() != ((TRingHealthItemModel) list.get(i3 - 1)).getHealthTime()) {
                arrayList.add(obj);
            }
            i3 = i10;
        }
        eh.b bVar = this.f7247z;
        ((f6.h0) bVar.getValue()).f12945b.setLayoutManager(new LinearLayoutManager(1));
        RecyclerView recyclerView = ((f6.h0) bVar.getValue()).f12945b;
        n.g0 g0Var = new n.g0(this);
        g0Var.e(getResources().getColor(R.color.transparent));
        g0Var.o(R$dimen.qb_px_10);
        recyclerView.g(g0Var.d());
        ((f6.h0) bVar.getValue()).f12945b.setAdapter(new TRingHealthDetailAdapter(arrayList));
        ((f6.h0) bVar.getValue()).f12945b.setItemAnimator(null);
        ((f6.h0) bVar.getValue()).f12946c.setVisibility(8);
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }
}
