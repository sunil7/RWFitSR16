package com.example.test.ui.device.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.example.test.ui.device.model.AlarmModel;
import java.util.List;
import r6.d;
import s6.b;

/* loaded from: classes.dex */
public class AlarmRingAdapter extends BaseProviderMultiAdapter<AlarmModel> {

    /* renamed from: a, reason: collision with root package name */
    public final d f7902a;

    public AlarmRingAdapter(List list) {
        super(list);
        d dVar = new d();
        this.f7902a = dVar;
        addItemProvider(dVar);
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public final int getItemType(List<? extends AlarmModel> list, int i3) {
        return 0;
    }

    public void setOnSwitchItemStatusListener(b bVar) {
        this.f7902a.setOnSwitchItemStatusListener(bVar);
    }
}
