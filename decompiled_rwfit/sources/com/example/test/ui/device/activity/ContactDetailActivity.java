package com.example.test.ui.device.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.widget.s2;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.model.ContactModel;
import com.example.test.ui.view.InputView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class ContactDetailActivity extends XXBaseActivity<com.example.test.presenter.device.n, f6.s> implements p5.a {
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ContactDetailActivity$contactPosition$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Intent intent = ContactDetailActivity.this.getIntent();
            return Integer.valueOf(intent != null ? intent.getIntExtra("contact_position", 0) : -1);
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.ContactDetailActivity$contactData$2
        {
            super(0);
        }

        @Override // oh.a
        public final ContactModel invoke() {
            Bundle extras;
            Intent intent = ContactDetailActivity.this.getIntent();
            Serializable serializable = (intent == null || (extras = intent.getExtras()) == null) ? null : extras.getSerializable(AeUtil.ROOT_DATA_PATH_OLD_NAME);
            kotlin.jvm.internal.e.d(serializable, "null cannot be cast to non-null type com.example.test.ui.device.model.ContactModel");
            return (ContactModel) serializable;
        }
    });

    public static final f6.s R0(ContactDetailActivity contactDetailActivity) {
        return (f6.s) contactDetailActivity.f7247z.getValue();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.n(this, 0);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.s) this.f7247z.getValue()).f13286a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_contact_detail, (ViewGroup) null, false);
        int i3 = R$id.nameIv;
        InputView inputView = (InputView) he.a(i3, inflate);
        if (inputView != null) {
            i3 = R$id.numberIv;
            InputView inputView2 = (InputView) he.a(i3, inflate);
            if (inputView2 != null) {
                i3 = R$id.titleView;
                TitleView titleView = (TitleView) he.a(i3, inflate);
                if (titleView != null) {
                    return new f6.s((LinearLayout) inflate, inputView, inputView2, titleView);
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
        ((f6.s) bVar.getValue()).f13289d.setOnTitleListener(new g(this));
        InputView inputView = ((f6.s) bVar.getValue()).f13287b;
        String contactName = S0().getContactName();
        kotlin.jvm.internal.e.e(contactName, "getContactName(...)");
        inputView.setText(contactName);
        InputView inputView2 = ((f6.s) bVar.getValue()).f13288c;
        String contactType = S0().getContactType();
        kotlin.jvm.internal.e.e(contactType, "getContactType(...)");
        inputView2.setText(contactType);
        ((f6.s) bVar.getValue()).f13287b.setLimit(24);
        ((f6.s) bVar.getValue()).f13288c.setLimit(24);
        InputView inputView3 = ((f6.s) bVar.getValue()).f13288c;
        s2 s2Var = new s2(this, 1);
        EditText editText = inputView3.f8453m;
        if (editText != null) {
            editText.addTextChangedListener(s2Var);
        } else {
            kotlin.jvm.internal.e.m("etInputET");
            throw null;
        }
    }

    public final ContactModel S0() {
        return (ContactModel) this.F.getValue();
    }
}
