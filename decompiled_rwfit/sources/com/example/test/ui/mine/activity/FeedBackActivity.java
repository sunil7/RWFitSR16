package com.example.test.ui.mine.activity;

import android.content.Context;
import android.text.Editable;
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
import f6.f0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class FeedBackActivity extends XXBaseActivity<com.example.test.presenter.mine.h, f0> implements h7.d, View.OnClickListener {
    public static final /* synthetic */ int G = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.FeedBackActivity$data$2
        @Override // oh.a
        public final List<String> invoke() {
            ArrayList arrayList = new ArrayList();
            arrayList.add("");
            return arrayList;
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.FeedBackActivity$imageAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final ImagePickAdapter invoke() {
            FeedBackActivity feedBackActivity = FeedBackActivity.this;
            int i3 = FeedBackActivity.G;
            ImagePickAdapter imagePickAdapter = new ImagePickAdapter(feedBackActivity.R0());
            imagePickAdapter.setOnItemClickListener(new c0.b(4, FeedBackActivity.this, imagePickAdapter));
            return imagePickAdapter;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.mine.h(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f0) this.f7247z.getValue()).f12841a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_feedback, (ViewGroup) null, false);
        int i3 = R$id.commit;
        Button button = (Button) he.a(i3, inflate);
        if (button != null) {
            i3 = R$id.contactEt;
            EditText editText = (EditText) he.a(i3, inflate);
            if (editText != null) {
                i3 = R$id.deviceModelEt;
                EditText editText2 = (EditText) he.a(i3, inflate);
                if (editText2 != null) {
                    i3 = R$id.feedbackContent;
                    EditText editText3 = (EditText) he.a(i3, inflate);
                    if (editText3 != null) {
                        i3 = R$id.imageList;
                        RecyclerView recyclerView = (RecyclerView) he.a(i3, inflate);
                        if (recyclerView != null) {
                            i3 = R$id.limitLenTv;
                            TextView textView = (TextView) he.a(i3, inflate);
                            if (textView != null) {
                                i3 = R$id.titleView;
                                TitleView titleView = (TitleView) he.a(i3, inflate);
                                if (titleView != null) {
                                    return new f0((LinearLayout) inflate, button, editText, editText2, editText3, recyclerView, textView, titleView);
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
        eh.b bVar = this.f7247z;
        ((f0) bVar.getValue()).f12847h.setOnTitleListener(new o(this, 5));
        ((f0) bVar.getValue()).f12845f.setLayoutManager(new GridLayoutManager(3));
        RecyclerView recyclerView = ((f0) bVar.getValue()).f12845f;
        eh.b bVar2 = this.F;
        recyclerView.setAdapter((ImagePickAdapter) bVar2.getValue());
        ((ImagePickAdapter) bVar2.getValue()).addChildClickViewIds(R$id.clearIv);
        ((ImagePickAdapter) bVar2.getValue()).setOnItemChildClickListener(new b(this, 1));
        ((f0) bVar.getValue()).e.addTextChangedListener(new g(this, 0));
        ((f0) bVar.getValue()).e.setOnTouchListener(new e(0));
        ((f0) bVar.getValue()).f12842b.setOnClickListener(this);
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
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.commit;
        if (valueOf != null && valueOf.intValue() == i3) {
            eh.b bVar = this.f7247z;
            Editable text = ((f0) bVar.getValue()).e.getText();
            if (text == null || text.length() == 0) {
                w0(R$string.str_your_question);
                return;
            }
            Editable text2 = ((f0) bVar.getValue()).f12843c.getText();
            if (text2 == null || text2.length() == 0) {
                w0(R$string.str_phone_email);
                return;
            }
            com.example.test.presenter.mine.h hVar = (com.example.test.presenter.mine.h) I0();
            String obj = ((f0) bVar.getValue()).e.getText().toString();
            Editable text3 = ((f0) bVar.getValue()).f12843c.getText();
            if (text3 == null || (str = text3.toString()) == null) {
                str = "";
            }
            Editable text4 = ((f0) bVar.getValue()).f12844d.getText();
            if (text4 == null || (str2 = text4.toString()) == null) {
                str2 = "";
            }
            hVar.k(obj, str, str2, "");
        }
    }
}
