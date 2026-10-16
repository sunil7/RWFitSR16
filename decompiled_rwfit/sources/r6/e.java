package r6;

import android.view.View;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.device.model.DeviceOptionModel;
import com.example.test.ui.view.ActionItemView;

/* loaded from: classes.dex */
public final class e extends BaseItemProvider {

    /* renamed from: a, reason: collision with root package name */
    public s6.b f18098a;

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final void convert(BaseViewHolder baseViewHolder, Object obj) {
        DeviceOptionModel deviceOptionModel = (DeviceOptionModel) obj;
        ActionItemView actionItemView = (ActionItemView) baseViewHolder.getView(R$id.action_view);
        actionItemView.setItemType(deviceOptionModel.getActionType());
        actionItemView.setItemResource(deviceOptionModel.getOptionRes());
        actionItemView.setHighTips(deviceOptionModel.isHighTips());
        actionItemView.setItemName(deviceOptionModel.getOptionStr());
        String optionHint = deviceOptionModel.getOptionHint();
        if (optionHint == null || optionHint.length() == 0 || "null".equalsIgnoreCase(optionHint)) {
            actionItemView.setHintStr("");
        } else {
            actionItemView.setHintStr(deviceOptionModel.getOptionHint());
        }
        View view = baseViewHolder.getView(R$id.switch_enable_view);
        if (deviceOptionModel.getActionType() != 1) {
            view.setVisibility(8);
            return;
        }
        if (deviceOptionModel.isEnableSwitch()) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
        actionItemView.setOnSwitchStatusChangListener(new c0.b(16, this, deviceOptionModel));
        actionItemView.setItemOpen(deviceOptionModel.isChecked());
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final int getItemViewType() {
        return 10086;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final int getLayoutId() {
        return R$layout.item_device_option;
    }

    public void setOnSwitchItemStatusListener(s6.b bVar) {
        this.f18098a = bVar;
    }
}
