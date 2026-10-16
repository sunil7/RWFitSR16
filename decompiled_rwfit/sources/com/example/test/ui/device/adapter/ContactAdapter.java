package com.example.test.ui.device.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.device.model.ContactModel;
import java.util.List;

/* loaded from: classes.dex */
public class ContactAdapter extends BaseQuickAdapter<ContactModel, BaseViewHolder> {
    public ContactAdapter(List list) {
        super(R$layout.item_contact, list);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder baseViewHolder, ContactModel contactModel) {
        ContactModel contactModel2 = contactModel;
        baseViewHolder.setVisible(R$id.convert, contactModel2.isConvert());
        baseViewHolder.setText(R$id.nameTv, contactModel2.getContactName());
        baseViewHolder.setText(R$id.contactTv, contactModel2.getContactType());
    }
}
