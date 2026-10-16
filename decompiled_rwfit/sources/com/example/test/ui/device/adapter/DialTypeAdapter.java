package com.example.test.ui.device.adapter;

import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.baselibrary.utils.b;
import com.example.test.R$id;
import com.example.test.ui.device.model.DialTypeModel;
import y6.c;

/* loaded from: classes.dex */
public class DialTypeAdapter extends BaseQuickAdapter<DialTypeModel, BaseViewHolder> {
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder baseViewHolder, DialTypeModel dialTypeModel) {
        DialTypeModel dialTypeModel2 = dialTypeModel;
        ((TextView) baseViewHolder.getView(R$id.dialTypeTv)).setText(dialTypeModel2.getType());
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R$id.dial_list);
        getContext();
        recyclerView.setLayoutManager(new GridLayoutManager(3));
        c cVar = new c(b.f(getContext(), 8.0f));
        cVar.f20012c = 0;
        recyclerView.g(cVar);
        recyclerView.setAdapter(new DialListAdapter(dialTypeModel2.getDials()));
    }
}
