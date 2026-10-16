package com.example.test.ui.device.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.example.test.ui.device.model.AlarmModel;
import java.util.List;
import r6.a;
import r6.c;
import s6.b;

/* loaded from: classes.dex */
public class AlarmAdapter extends BaseProviderMultiAdapter<AlarmModel> {

    /* renamed from: a, reason: collision with root package name */
    public final c f7901a;

    public AlarmAdapter(List list) {
        super(list);
        c cVar = new c();
        this.f7901a = cVar;
        addItemProvider(cVar);
        addItemProvider(new a(0));
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public final int getItemType(List<? extends AlarmModel> list, int i3) {
        return list.get(i3).isAdd() ? 1 : 0;
    }

    public void setOnSwitchItemStatusListener(b bVar) {
        this.f7901a.setOnSwitchItemStatusListener(bVar);
    }
}
