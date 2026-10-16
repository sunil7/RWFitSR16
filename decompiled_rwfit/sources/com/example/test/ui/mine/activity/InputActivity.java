package com.example.test.ui.mine.activity;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.o0;

/* loaded from: classes.dex */
public final class InputActivity extends XXBaseActivity<com.example.test.presenter.mine.i, o0> implements h7.e {
    public static final /* synthetic */ int H = 0;
    public int E = 20;
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.InputActivity$data$2
        {
            super(0);
        }

        @Override // oh.a
        public final String invoke() {
            String stringExtra;
            Intent intent = InputActivity.this.getIntent();
            return (intent == null || (stringExtra = intent.getStringExtra(AeUtil.ROOT_DATA_PATH_OLD_NAME)) == null) ? "" : stringExtra;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.InputActivity$dataType$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Intent intent = InputActivity.this.getIntent();
            if (intent != null) {
                return Integer.valueOf(intent.getIntExtra("data_type", 0));
            }
            return null;
        }
    });

    public static final o0 R0(InputActivity inputActivity) {
        return (o0) inputActivity.f7247z.getValue();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        com.example.test.presenter.mine.i iVar = new com.example.test.presenter.mine.i(this);
        iVar.f7594c = 0;
        return iVar;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((o0) this.f7247z.getValue()).f13160a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_input, (ViewGroup) null, false);
        int i3 = R$id.editEt;
        EditText editText = (EditText) he.a(i3, inflate);
        if (editText != null) {
            i3 = R$id.limitTv;
            TextView textView = (TextView) he.a(i3, inflate);
            if (textView != null) {
                i3 = R$id.sureBtn;
                if (((Button) he.a(i3, inflate)) != null) {
                    i3 = R$id.titleView;
                    TitleView titleView = (TitleView) he.a(i3, inflate);
                    if (titleView != null) {
                        i3 = R$id.tv_btname_tip;
                        TextView textView2 = (TextView) he.a(i3, inflate);
                        if (textView2 != null) {
                            return new o0((LinearLayout) inflate, editText, textView, titleView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        Integer S0 = S0();
        if (S0 != null && S0.intValue() == 3) {
            ((com.example.test.presenter.mine.i) I0()).k();
        }
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((o0) bVar.getValue()).f13163d.setOnTitleListener(new h(this));
        Integer S0 = S0();
        if (S0 != null && S0.intValue() == 0) {
            ((o0) bVar.getValue()).f13163d.setTitle(R$string.str_nick);
            ((o0) bVar.getValue()).f13161b.setHint(R$string.str_nick);
            this.E = 20;
            ((o0) bVar.getValue()).f13161b.setMaxWidth(this.E);
        } else {
            Integer S02 = S0();
            if (S02 != null && S02.intValue() == 1) {
                ((o0) bVar.getValue()).f13163d.setTitle(R$string.str_alarm);
                ((o0) bVar.getValue()).f13161b.setHint(R$string.str_alarm);
                this.E = 20;
                ((o0) bVar.getValue()).f13161b.setMaxWidth(this.E);
            } else {
                Integer S03 = S0();
                if (S03 != null && S03.intValue() == 2) {
                    ((o0) bVar.getValue()).f13163d.setTitle(R$string.str_schedule_title);
                    ((o0) bVar.getValue()).f13161b.setHint(R$string.str_schedule_title);
                    this.E = 32;
                    ((o0) bVar.getValue()).f13161b.setMaxWidth(this.E);
                } else {
                    Integer S04 = S0();
                    if (S04 != null && S04.intValue() == 3) {
                        ((o0) bVar.getValue()).e.setVisibility(0);
                        ((o0) bVar.getValue()).f13163d.setTitle(R$string.str_ring_modfiy_name);
                        ((o0) bVar.getValue()).f13161b.setHint(R$string.str_ring_modfiy_name);
                        this.E = 10;
                        ((o0) bVar.getValue()).f13161b.setMaxWidth(this.E);
                    }
                }
            }
        }
        ((o0) bVar.getValue()).f13161b.addTextChangedListener(new g(this, 1));
        ((o0) bVar.getValue()).f13161b.setText((String) this.F.getValue());
    }

    public final Integer S0() {
        return (Integer) this.G.getValue();
    }
}
