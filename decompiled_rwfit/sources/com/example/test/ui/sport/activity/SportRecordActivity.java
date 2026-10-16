package com.example.test.ui.sport.activity;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.R$dimen;
import com.example.test.R$string;
import com.example.test.presenter.sport.w;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.sport.adapter.SportRecordAdapter;
import com.example.test.ui.sport.model.SportRecordModel;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import f6.e2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import n.g0;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class SportRecordActivity extends XXBaseActivity<w, e2> implements i7.h {
    public static final /* synthetic */ int J = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportRecordActivity$dataCache$2
        @Override // oh.a
        public final HashMap<String, List<SportRecordModel>> invoke() {
            return new HashMap<>();
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportRecordActivity$dataSport$2
        @Override // oh.a
        public final List<SportRecordModel> invoke() {
            return new ArrayList();
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportRecordActivity$sportRecordAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final SportRecordAdapter invoke() {
            SportRecordActivity sportRecordActivity = SportRecordActivity.this;
            int i3 = SportRecordActivity.J;
            List R0 = sportRecordActivity.R0();
            boolean z5 = y5.d.f20005b;
            SportRecordAdapter sportRecordAdapter = new SportRecordAdapter(R0);
            if (!z5) {
                sportRecordAdapter.addItemProvider(new r6.a(5));
            }
            sportRecordAdapter.addItemProvider(new r6.a(7));
            return sportRecordAdapter;
        }
    });
    public int H = -1;
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportRecordActivity$delTipsDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(SportRecordActivity.this);
            rVar.b(R$string.str_del_sport_tips);
            rVar.setOnDialogListener(new p(SportRecordActivity.this));
            return rVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new w(this);
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
        ((w) I0()).k();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((e2) bVar.getValue()).f12827d.setOnTitleListener(new p(this));
        ((e2) bVar.getValue()).f12826c.setLayoutManager(new LinearLayoutManager(1));
        RecyclerView recyclerView = ((e2) bVar.getValue()).f12826c;
        g0 g0Var = new g0(this);
        g0Var.e(getResources().getColor(R.color.transparent));
        g0Var.o(R$dimen.qb_px_10);
        recyclerView.g(g0Var.d());
        ((e2) bVar.getValue()).f12826c.setAdapter(S0());
        S0().setOnItemClickListener(new o(this));
        S0().setOnItemLongClickListener(new o(this));
    }

    public final List R0() {
        return (List) this.F.getValue();
    }

    public final SportRecordAdapter S0() {
        return (SportRecordAdapter) this.G.getValue();
    }

    public final void T0(int i3) {
        this.H = -1;
        ((com.example.test.ui.dialog.r) this.I.getValue()).dismiss();
        ((w) I0()).k();
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
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSyncSport(EventBusBeans.SyncEvent syncSport) {
        kotlin.jvm.internal.e.f(syncSport, "syncSport");
        if (syncSport.getSyncType() == 8) {
            ((w) I0()).k();
        }
    }
}
