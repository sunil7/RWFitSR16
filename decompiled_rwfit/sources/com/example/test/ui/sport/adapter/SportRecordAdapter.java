package com.example.test.ui.sport.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.example.test.ui.sport.model.SportRecordModel;
import java.util.List;

/* loaded from: classes.dex */
public class SportRecordAdapter extends BaseProviderMultiAdapter<SportRecordModel> {
    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public final int getItemType(List<? extends SportRecordModel> list, int i3) {
        return list.get(i3).getType();
    }
}
