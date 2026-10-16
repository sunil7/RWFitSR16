package com.example.test.ui.testui;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.test.R$color;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.device.model.DeviceOptionModel;
import com.example.test.ui.view.TRingActionItemView;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;

/* loaded from: classes.dex */
public final class d1 extends BaseItemProvider {

    /* renamed from: a, reason: collision with root package name */
    public s6.b f8270a;

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final void convert(BaseViewHolder baseViewHolder, Object obj) {
        DeviceOptionModel deviceOptionModel = (DeviceOptionModel) obj;
        TRingActionItemView tRingActionItemView = (TRingActionItemView) baseViewHolder.getView(R$id.action_view);
        tRingActionItemView.setItemType(deviceOptionModel.getActionType());
        tRingActionItemView.setItemResource(deviceOptionModel.getOptionRes());
        tRingActionItemView.setHighTips(deviceOptionModel.isHighTips());
        tRingActionItemView.setItemName(deviceOptionModel.getOptionStr());
        String optionHint = deviceOptionModel.getOptionHint();
        if (optionHint == null || optionHint.length() == 0 || "null".equalsIgnoreCase(optionHint)) {
            tRingActionItemView.setHintStr("");
        } else {
            tRingActionItemView.setHintStr(deviceOptionModel.getOptionHint());
        }
        if (deviceOptionModel.getActionType() == 1) {
            tRingActionItemView.setOnSwitchStatusChangListener(new c0.b(6, this, deviceOptionModel));
            tRingActionItemView.setItemOpen(deviceOptionModel.isChecked());
        }
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        int D = com.example.test.utils.k.f8731b.D();
        if (D == 0) {
            if (deviceOptionModel.getId() == R$id.av_take_photo) {
                tRingActionItemView.setBackground(pb.b(getContext(), R$drawable.shape_block_top));
            } else if (deviceOptionModel.getId() == R$id.av_power_off) {
                tRingActionItemView.setBackground(pb.b(getContext(), R$drawable.shape_block_bottom));
            } else {
                tRingActionItemView.setBackground(pb.b(getContext(), R$drawable.shape_block_mid));
            }
            tRingActionItemView.setFontColor(this.context.getColor(R$color.color_white));
            return;
        }
        if (D == 1 || D == 2) {
            if (deviceOptionModel.getId() == R$id.av_take_photo) {
                tRingActionItemView.setBackground(pb.b(getContext(), R$drawable.shape_block_white_top));
            } else if (deviceOptionModel.getId() == R$id.av_power_off) {
                tRingActionItemView.setBackground(pb.b(getContext(), R$drawable.shape_block_white_bottom));
            } else {
                tRingActionItemView.setBackground(pb.b(getContext(), R$drawable.shape_block_white_mid));
            }
            tRingActionItemView.setFontColor(this.context.getColor(R$color.color_black));
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final int getItemViewType() {
        return 10086;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final int getLayoutId() {
        return R$layout.item_ring_device_option;
    }

    public void setOnSupportSwitchItemStatusListener(s6.a aVar) {
    }

    public void setOnSwitchItemStatusListener(s6.b bVar) {
        this.f8270a = bVar;
    }
}
