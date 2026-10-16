package com.example.test.ui.device.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.ui.device.model.BleDeviceModel;
import com.example.test.ui.view.GpsSingleView;
import java.util.List;

/* loaded from: classes.dex */
public class DeviceScanAdapter extends BaseQuickAdapter<BleDeviceModel, BaseViewHolder> {
    public DeviceScanAdapter(List list) {
        super(R$layout.item_device, list);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder baseViewHolder, BleDeviceModel bleDeviceModel) {
        BleDeviceModel bleDeviceModel2 = bleDeviceModel;
        baseViewHolder.setText(R$id.ble_name, bleDeviceModel2.getName());
        baseViewHolder.setText(R$id.tv_ble_mac, bleDeviceModel2.getMac());
        if (bleDeviceModel2.getPidType() == 3) {
            baseViewHolder.setImageResource(R$id.iv_ble_type, R$mipmap.ring_icon_type2);
        } else if (bleDeviceModel2.getPidType() == 4) {
            baseViewHolder.setImageResource(R$id.iv_ble_type, R$mipmap.ring_icon_type3);
        } else {
            baseViewHolder.setImageResource(R$id.iv_ble_type, R$mipmap.ring_icon_type1);
        }
        ((GpsSingleView) baseViewHolder.getView(R$id.ble_rssi)).setLevel(bleDeviceModel2.getLevel());
    }
}
