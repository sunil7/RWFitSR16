package com.example.test.ui.device.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.device.model.MessageModel;
import com.example.test.ui.view.ActionItemView;
import java.util.List;
import s6.b;

/* loaded from: classes.dex */
public class MessageAdapter extends BaseQuickAdapter<MessageModel, BaseViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    public b f7904a;

    public MessageAdapter(List list) {
        super(R$layout.item_msg, list);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder baseViewHolder, MessageModel messageModel) {
        MessageModel messageModel2 = messageModel;
        ActionItemView actionItemView = (ActionItemView) baseViewHolder.getView(R$id.msg_iv);
        actionItemView.setItemResource(messageModel2.getRes());
        actionItemView.setItemName(messageModel2.getStrRes());
        actionItemView.setItemOpen(messageModel2.isSelected());
        if (messageModel2.isNext()) {
            actionItemView.setItemType(0);
        } else {
            actionItemView.setItemType(1);
        }
        actionItemView.setOnSwitchStatusChangListener(new c0.b(17, this, messageModel2));
        baseViewHolder.setVisible(R$id.notify_enable_view, !messageModel2.isEnableSwitch());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.z0
    public final int getItemViewType(int i3) {
        return i3;
    }

    public void setOnSwitchItemStatusListener(b bVar) {
        this.f7904a = bVar;
    }
}
