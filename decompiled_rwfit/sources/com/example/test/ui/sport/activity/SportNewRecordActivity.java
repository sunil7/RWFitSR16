package com.example.test.ui.sport.activity;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.R$dimen;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.sport.adapter.SportNewRecordAdapter;
import com.example.test.ui.sport.model.SportRecordModel;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import f6.e2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import n.g0;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class SportNewRecordActivity extends XXBaseActivity<com.example.test.presenter.sport.r, e2> implements i7.f {
    public static final /* synthetic */ int J = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportNewRecordActivity$dataCache$2
        @Override // oh.a
        public final HashMap<String, List<SportRecordModel>> invoke() {
            return new HashMap<>();
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportNewRecordActivity$dataSport$2
        @Override // oh.a
        public final List<SportRecordModel> invoke() {
            return new ArrayList();
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportNewRecordActivity$sportRecordAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final SportNewRecordAdapter invoke() {
            SportNewRecordActivity sportNewRecordActivity = SportNewRecordActivity.this;
            int i3 = SportNewRecordActivity.J;
            List R0 = sportNewRecordActivity.R0();
            boolean z5 = y5.d.f20005b;
            SportNewRecordAdapter sportNewRecordAdapter = new SportNewRecordAdapter(R0);
            if (!z5) {
                sportNewRecordAdapter.addItemProvider(new r6.a(5));
            }
            sportNewRecordAdapter.addItemProvider(new r6.a(6));
            return sportNewRecordAdapter;
        }
    });
    public int H = -1;
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportNewRecordActivity$delTipsDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(SportNewRecordActivity.this);
            rVar.b(R$string.str_del_sport_tips);
            rVar.setOnDialogListener(new k(SportNewRecordActivity.this));
            return rVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.sport.r(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((e2) this.f7247z.getValue()).f12824a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        return e2.a(getLayoutInflater());
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        V();
        ((com.example.test.presenter.sport.r) I0()).m();
        ((com.example.test.presenter.sport.r) I0()).l();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((e2) bVar.getValue()).f12827d.setOnTitleListener(new k(this));
        ((e2) bVar.getValue()).f12826c.setLayoutManager(new LinearLayoutManager(1));
        RecyclerView recyclerView = ((e2) bVar.getValue()).f12826c;
        g0 g0Var = new g0(this);
        g0Var.e(getResources().getColor(R.color.transparent));
        g0Var.o(R$dimen.qb_px_10);
        recyclerView.g(g0Var.d());
        ((e2) bVar.getValue()).f12826c.setAdapter(S0());
        S0().setOnItemClickListener(new j(this));
        S0().setOnItemLongClickListener(new j(this));
    }

    public final List R0() {
        return (List) this.F.getValue();
    }

    public final SportNewRecordAdapter S0() {
        return (SportNewRecordAdapter) this.G.getValue();
    }

    public final void T0(int i3) {
        this.H = -1;
        ((com.example.test.ui.dialog.r) this.I.getValue()).dismiss();
        ((com.example.test.presenter.sport.r) I0()).l();
        if (i3 <= 2) {
            yh.d.b().e(new EventBusBeans.UnitEvent(0));
        }
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        ((com.example.test.presenter.sport.r) I0()).k();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSyncSport(EventBusBeans.SyncEvent syncSport) {
        kotlin.jvm.internal.e.f(syncSport, "syncSport");
        if (syncSport.getSyncType() == 8) {
            ((com.example.test.presenter.sport.r) I0()).l();
        }
    }
}
