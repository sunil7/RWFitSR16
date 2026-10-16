package com.example.test.ui.device.activity;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.test.R$dimen;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.adapter.ContactAdapter;
import com.example.test.ui.device.model.ContactModel;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class ContactJLActivity extends XXBaseActivity<com.example.test.presenter.device.p, f6.r> implements f7.d {
    public static final /* synthetic */ int I = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ContactJLActivity$data$2
        @Override // oh.a
        public final List<ContactModel> invoke() {
            return new ArrayList();
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ContactJLActivity$contactAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final ContactAdapter invoke() {
            ContactJLActivity contactJLActivity = ContactJLActivity.this;
            int i3 = ContactJLActivity.I;
            return new ContactAdapter(contactJLActivity.S0());
        }
    });
    public final int G = 20;
    public androidx.activity.result.c H;

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.p(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        ConstraintLayout constraintLayout = ((f6.r) this.f7247z.getValue()).f13267a;
        kotlin.jvm.internal.e.e(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        return f6.r.a(getLayoutInflater());
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((com.example.test.presenter.device.p) I0()).l();
    }

    @Override // com.example.test.ui.XXBaseActivity, com.example.baselibrary.base.activity.BaseActivity
    public final void L0(Bundle bundle) {
        this.H = this.f338j.c("activity_rq#" + this.f337i.getAndIncrement(), this, new androidx.fragment.app.o0(2), new h(this));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((f6.r) bVar.getValue()).f13270d.setOnTitleListener(new a2.d(this, 12));
        ((f6.r) bVar.getValue()).f13269c.setLayoutManager(new LinearLayoutManager(1));
        ((f6.r) bVar.getValue()).f13269c.setSwipeMenuCreator(new h(this));
        ((f6.r) bVar.getValue()).f13269c.setOnItemMenuClickListener(new h(this));
        ((f6.r) bVar.getValue()).f13269c.setAdapter(R0());
        SwipeRecyclerView swipeRecyclerView = ((f6.r) bVar.getValue()).f13269c;
        n.g0 g0Var = new n.g0(this);
        g0Var.e(getResources().getColor(R.color.transparent));
        g0Var.o(R$dimen.qb_px_10);
        swipeRecyclerView.g(g0Var.d());
        R0().setOnItemClickListener(new h(this));
        ((f6.r) bVar.getValue()).f13268b.setOnClickListener(new f(this, 1));
    }

    public final ContactAdapter R0() {
        return (ContactAdapter) this.F.getValue();
    }

    public final List S0() {
        return (List) this.E.getValue();
    }

    @Override // f7.d
    public final void a() {
        com.example.baselibrary.utils.d.a(R$string.str_save_success);
        onBackPressed();
    }

    @Override // f7.d
    public final void b() {
        com.example.baselibrary.utils.d.a(R$string.str_save_fail);
    }

    @Override // f7.d
    public final void d(List list) {
        S0().clear();
        kotlin.collections.n.i(S0(), list);
        R0().notifyDataSetChanged();
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onContactEvent(EventBusBeans.ContactEvent contactEvent) {
        Object obj;
        String r;
        kotlin.jvm.internal.e.f(contactEvent, "contactEvent");
        if (contactEvent.getPosition() > -1) {
            Iterator it = S0().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                ContactModel contactModel = (ContactModel) obj;
                String contactType = contactModel.getContactType();
                kotlin.jvm.internal.e.e(contactType, "getContactType(...)");
                String str = "";
                if (contactType.length() == 0) {
                    r = "";
                } else {
                    String contactType2 = contactModel.getContactType();
                    kotlin.jvm.internal.e.e(contactType2, "getContactType(...)");
                    r = kotlin.text.m.r(contactType2, " ", "");
                }
                String contactType3 = contactEvent.getContactModel().getContactType();
                kotlin.jvm.internal.e.e(contactType3, "getContactType(...)");
                if (contactType3.length() != 0) {
                    String contactType4 = contactEvent.getContactModel().getContactType();
                    kotlin.jvm.internal.e.e(contactType4, "getContactType(...)");
                    str = kotlin.text.m.r(contactType4, " ", "");
                }
                if (r.equals(str) && kotlin.jvm.internal.e.a(contactModel.getContactName(), contactEvent.getContactModel().getContactName())) {
                    break;
                }
            }
            if (((ContactModel) obj) != null) {
                w0(R$string.str_contact_already_exists);
                return;
            }
            List S0 = S0();
            int position = contactEvent.getPosition();
            ContactModel contactModel2 = contactEvent.getContactModel();
            kotlin.jvm.internal.e.e(contactModel2, "getContactModel(...)");
            S0.set(position, contactModel2);
            R0().notifyItemChanged(contactEvent.getPosition());
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }
}
