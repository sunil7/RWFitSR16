package com.example.test.ui.device.activity;

import com.example.test.R$string;
import com.example.test.ui.model.EventBusBeans;

/* loaded from: classes.dex */
public final class g implements a7.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ContactDetailActivity f7860a;

    public g(ContactDetailActivity contactDetailActivity) {
        this.f7860a = contactDetailActivity;
    }

    @Override // a7.e
    public final void B() {
        ContactDetailActivity contactDetailActivity = this.f7860a;
        String text = ContactDetailActivity.R0(contactDetailActivity).f13287b.getText();
        if (text != null && text.length() != 0 && !"null".equalsIgnoreCase(text)) {
            eh.b bVar = contactDetailActivity.f7247z;
            String text2 = ((f6.s) bVar.getValue()).f13288c.getText();
            if (text2 != null && text2.length() != 0 && !"null".equalsIgnoreCase(text2)) {
                contactDetailActivity.S0().setContactName(((f6.s) bVar.getValue()).f13287b.getText());
                contactDetailActivity.S0().setContactType(((f6.s) bVar.getValue()).f13288c.getText());
                yh.d.b().e(new EventBusBeans.ContactEvent(((Number) contactDetailActivity.E.getValue()).intValue(), contactDetailActivity.S0()));
                contactDetailActivity.finish();
                return;
            }
        }
        contactDetailActivity.w0(R$string.str_contact_empty);
    }

    @Override // a7.e
    public final void u0() {
        this.f7860a.onBackPressed();
    }
}
