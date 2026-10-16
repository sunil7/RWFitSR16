package com.example.test.ui.testui;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.example.test.ui.main.model.BaseDataModel;
import java.util.List;

/* loaded from: classes.dex */
public class TRingHomeDataAdapter extends BaseProviderMultiAdapter<BaseDataModel> {
    public final int a(int i3) {
        List<BaseDataModel> data = getData();
        for (int i10 = 0; i10 < data.size(); i10++) {
            if (data.get(i10).getType() == i3) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public final int getItemType(List<? extends BaseDataModel> list, int i3) {
        return list.get(i3).getType();
    }
}
