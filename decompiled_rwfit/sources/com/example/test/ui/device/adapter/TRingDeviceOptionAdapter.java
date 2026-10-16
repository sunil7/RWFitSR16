package com.example.test.ui.device.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.example.test.ui.device.model.DeviceOptionModel;
import com.example.test.ui.testui.d1;
import java.util.List;
import r6.a;
import s6.b;

/* loaded from: classes.dex */
public class TRingDeviceOptionAdapter extends BaseProviderMultiAdapter<DeviceOptionModel> {

    /* renamed from: a, reason: collision with root package name */
    public final d1 f7905a;

    public TRingDeviceOptionAdapter(List list) {
        super(list);
        d1 d1Var = new d1();
        this.f7905a = d1Var;
        addItemProvider(d1Var);
        addItemProvider(new a(3));
        addItemProvider(new a(2));
    }

    public final int a(int i3) {
        List<DeviceOptionModel> data = getData();
        for (int i10 = 0; i10 < data.size(); i10++) {
            if (data.get(i10).getId() == i3) {
                return i10;
            }
        }
        return -1;
    }

    public final void b(int i3) {
        List<DeviceOptionModel> data = getData();
        for (int i10 = 0; i10 < data.size(); i10++) {
            if (data.get(i10).getId() == i3) {
                data.remove(i10);
                notifyItemRemoved(i10);
                return;
            }
        }
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public final int getItemType(List<? extends DeviceOptionModel> list, int i3) {
        return list.get(i3).getOptionType();
    }

    public void setOnSupportSwitchItemStatusListener(s6.a aVar) {
        this.f7905a.setOnSupportSwitchItemStatusListener(aVar);
    }

    public void setOnSwitchItemStatusListener(b bVar) {
        this.f7905a.setOnSwitchItemStatusListener(bVar);
    }
}
