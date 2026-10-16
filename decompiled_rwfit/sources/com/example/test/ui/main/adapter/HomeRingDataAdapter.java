package com.example.test.ui.main.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.example.test.ui.main.model.BaseDataModel;
import java.util.List;

/* loaded from: classes.dex */
public class HomeRingDataAdapter extends BaseProviderMultiAdapter<BaseDataModel> {
    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public final int getItemType(List<? extends BaseDataModel> list, int i3) {
        return list.get(i3).getType();
    }
}
