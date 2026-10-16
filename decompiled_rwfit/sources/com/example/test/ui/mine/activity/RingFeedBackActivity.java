package com.example.test.ui.mine.activity;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.mine.adapter.ImagePickAdapter;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.l1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class RingFeedBackActivity extends XXBaseActivity<com.example.test.presenter.mine.h, l1> implements h7.d, View.OnClickListener {
    public static final /* synthetic */ int I = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.RingFeedBackActivity$data$2
        @Override // oh.a
        public final List<String> invoke() {
            ArrayList arrayList = new ArrayList();
            arrayList.add("");
            return arrayList;
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.RingFeedBackActivity$imageAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final ImagePickAdapter invoke() {
            RingFeedBackActivity ringFeedBackActivity = RingFeedBackActivity.this;
            int i3 = RingFeedBackActivity.I;
            ImagePickAdapter imagePickAdapter = new ImagePickAdapter(ringFeedBackActivity.R0());
            imagePickAdapter.setOnItemClickListener(new c0.b(5, RingFeedBackActivity.this, imagePickAdapter));
            return imagePickAdapter;
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.RingFeedBackActivity$caluOptions$2
        @Override // oh.a
        public final List<String> invoke() {
            ArrayList arrayList = new ArrayList();
            arrayList.add("01");
            arrayList.add("02");
            return arrayList;
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.RingFeedBackActivity$caluNumSelectDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.p invoke() {
            RingFeedBackActivity ringFeedBackActivity = RingFeedBackActivity.this;
            com.example.test.ui.dialog.p pVar = new com.example.test.ui.dialog.p(ringFeedBackActivity, (List) ringFeedBackActivity.G.getValue());
            pVar.setOnDialogDataListener(new u(RingFeedBackActivity.this));
            return pVar;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.mine.h(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((l1) this.f7247z.getValue()).f13086a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_ring_feedback, (ViewGroup) null, false);
        int i3 = R$id.commit;
        Button button = (Button) he.a(i3, inflate);
        if (button != null) {
            i3 = R$id.contactEt;
            EditText editText = (EditText) he.a(i3, inflate);
            if (editText != null) {
                i3 = R$id.deviceModelEt;
                TextView textView = (TextView) he.a(i3, inflate);
                if (textView != null) {
                    i3 = R$id.feedbackContent;
                    EditText editText2 = (EditText) he.a(i3, inflate);
                    if (editText2 != null) {
                        i3 = R$id.imageList;
                        RecyclerView recyclerView = (RecyclerView) he.a(i3, inflate);
                        if (recyclerView != null) {
                            i3 = R$id.limitLenTv;
                            TextView textView2 = (TextView) he.a(i3, inflate);
                            if (textView2 != null) {
                                i3 = R$id.orderIdEt;
                                EditText editText3 = (EditText) he.a(i3, inflate);
                                if (editText3 != null) {
                                    i3 = R$id.titleView;
                                    TitleView titleView = (TitleView) he.a(i3, inflate);
                                    if (titleView != null) {
                                        i3 = R$id.tv_orderid_title;
                                        TextView textView3 = (TextView) he.a(i3, inflate);
                                        if (textView3 != null) {
                                            return new l1((LinearLayout) inflate, button, editText, textView, editText2, recyclerView, textView2, editText3, titleView, textView3);
                                        }
                                    }
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
        String string = getString(R$string.ring_str_orderid_details);
        kotlin.jvm.internal.e.e(string, "getString(...)");
        String concat = string.concat(" *");
        SpannableString spannableString = new SpannableString(concat);
        spannableString.setSpan(new ForegroundColorSpan(-65536), string.length(), concat.length(), 33);
        eh.b bVar = this.f7247z;
        ((l1) bVar.getValue()).f13094j.setText(spannableString);
        ((l1) bVar.getValue()).f13093i.setOnTitleListener(new u(this));
        ((l1) bVar.getValue()).f13090f.setLayoutManager(new GridLayoutManager(3));
        RecyclerView recyclerView = ((l1) bVar.getValue()).f13090f;
        eh.b bVar2 = this.F;
        recyclerView.setAdapter((ImagePickAdapter) bVar2.getValue());
        ((ImagePickAdapter) bVar2.getValue()).addChildClickViewIds(R$id.clearIv);
        ((ImagePickAdapter) bVar2.getValue()).setOnItemChildClickListener(new b(this, 2));
        ((l1) bVar.getValue()).e.addTextChangedListener(new g(this, 2));
        ((l1) bVar.getValue()).e.setOnTouchListener(new e(1));
        ((l1) bVar.getValue()).f13089d.setOnClickListener(this);
        ((l1) bVar.getValue()).f13087b.setOnClickListener(this);
    }

    @Override // androidx.core.app.ComponentActivity, h7.d
    public final void Q() {
        w0(R$string.str_feedback_success);
        onBackPressed();
    }

    public final List R0() {
        return (List) this.E.getValue();
    }

    @Override // h7.d
    public final void S(String str) {
        com.example.baselibrary.utils.d.b(str);
    }

    @Override // p5.a
    public final Context f0() {
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        String obj;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.commit;
        if (valueOf == null || valueOf.intValue() != i3) {
            int i10 = R$id.deviceModelEt;
            if (valueOf != null && valueOf.intValue() == i10) {
                ((com.example.test.ui.dialog.p) this.H.getValue()).show();
                return;
            }
            return;
        }
        eh.b bVar = this.f7247z;
        Editable text = ((l1) bVar.getValue()).e.getText();
        if (text == null || text.length() == 0) {
            w0(R$string.str_your_question);
            return;
        }
        Editable text2 = ((l1) bVar.getValue()).f13088c.getText();
        if (text2 == null || text2.length() == 0) {
            w0(R$string.ring_str_please_input_email);
            return;
        }
        Editable text3 = ((l1) bVar.getValue()).f13092h.getText();
        if (text3 == null || text3.length() == 0) {
            w0(R$string.ring_str_please_orderid_dinput_details);
            return;
        }
        com.example.test.presenter.mine.h hVar = (com.example.test.presenter.mine.h) I0();
        String obj2 = ((l1) bVar.getValue()).e.getText().toString();
        Editable text4 = ((l1) bVar.getValue()).f13088c.getText();
        String str3 = "";
        if (text4 == null || (str = text4.toString()) == null) {
            str = "";
        }
        CharSequence text5 = ((l1) bVar.getValue()).f13089d.getText();
        if (text5 == null || (str2 = text5.toString()) == null) {
            str2 = "";
        }
        Editable text6 = ((l1) bVar.getValue()).f13092h.getText();
        if (text6 != null && (obj = text6.toString()) != null) {
            str3 = obj;
        }
        hVar.k(obj2, str, str2, str3);
    }
}
