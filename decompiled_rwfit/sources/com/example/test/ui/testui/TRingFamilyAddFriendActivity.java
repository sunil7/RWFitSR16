package com.example.test.ui.testui;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.example.network.api.UserApi;
import com.example.network.base.HttpModel;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;

/* loaded from: classes.dex */
public final class TRingFamilyAddFriendActivity extends XXBaseActivity<com.example.test.presenter.main.i0, f6.c0> implements g7.l, View.OnClickListener {
    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.main.i0(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.c0) this.f7247z.getValue()).f12754a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_family_add_friend, (ViewGroup) null, false);
        int i3 = R$id.friendSearchButton;
        Button button = (Button) he.a(i3, inflate);
        if (button != null) {
            i3 = R$id.friendSearchText;
            EditText editText = (EditText) he.a(i3, inflate);
            if (editText != null) {
                i3 = R$id.titleView;
                TitleView titleView = (TitleView) he.a(i3, inflate);
                if (titleView != null) {
                    return new f6.c0((LinearLayout) inflate, button, editText, titleView);
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
        ((f6.c0) bVar.getValue()).f12757d.setOnTitleListener(new a1(this, 3));
        ((f6.c0) bVar.getValue()).f12755b.setOnClickListener(this);
    }

    public final void R0(int i3, String str) {
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
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.friendSearchButton;
        if (valueOf != null && valueOf.intValue() == i3) {
            eh.b bVar = this.f7247z;
            Editable text = ((f6.c0) bVar.getValue()).f12756c.getText();
            if (text == null || text.length() == 0) {
                w0(R$string.str_please_input_legal_friend_id);
                return;
            }
            com.example.test.presenter.main.i0 i0Var = (com.example.test.presenter.main.i0) I0();
            int parseInt = Integer.parseInt(((f6.c0) bVar.getValue()).f12756c.getText().toString());
            Object obj = i0Var.f7255a;
            if (parseInt <= 0) {
                ((TRingFamilyAddFriendActivity) ((g7.l) obj)).w0(R$string.str_please_input_legal_friend_id);
                return;
            }
            Object obj2 = (g7.l) obj;
            ((XXBaseActivity) obj2).V();
            rg.l<HttpModel<String>> memberFriendApply = ((UserApi) c6.d.f3392c.f113a).memberFriendApply(Integer.valueOf(parseInt));
            kotlin.jvm.internal.e.e(memberFriendApply, "memberFriendApply(...)");
            rg.l w8 = com.example.baselibrary.utils.b.w(memberFriendApply);
            TRingFamilyAddFriendActivity tRingFamilyAddFriendActivity = (TRingFamilyAddFriendActivity) obj2;
            tRingFamilyAddFriendActivity.getClass();
            w8.subscribe(new com.example.test.presenter.device.y(i0Var, tRingFamilyAddFriendActivity, com.example.test.utils.w0.d(), 2));
        }
    }
}
