package com.chad.library.adapter.base;

import androidx.recyclerview.widget.z1;
import com.chad.library.adapter.base.entity.SectionEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.List;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public abstract class BaseSectionQuickAdapter<T extends SectionEntity, VH extends BaseViewHolder> extends BaseMultiItemQuickAdapter<T, VH> {
    private final int sectionHeadResId;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseSectionQuickAdapter(int i3) {
        this(i3, null, 2, 0 == true ? 1 : 0);
    }

    public abstract void convertHeader(VH vh2, T t8);

    public void convertHeader(VH helper, T item, List<Object> payloads) {
        e.g(helper, "helper");
        e.g(item, "item");
        e.g(payloads, "payloads");
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public boolean isFixedViewType(int i3) {
        return super.isFixedViewType(i3) || i3 == -99;
    }

    public final void setNormalLayout(int i3) {
        addItemType(-100, i3);
    }

    public /* synthetic */ BaseSectionQuickAdapter(int i3, List list, int i10, c cVar) {
        this(i3, (i10 & 2) != 0 ? null : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.z0
    public /* bridge */ /* synthetic */ void onBindViewHolder(z1 z1Var, int i3, List list) {
        onBindViewHolder((BaseSectionQuickAdapter<T, VH>) z1Var, i3, (List<Object>) list);
    }

    public BaseSectionQuickAdapter(int i3, List<T> list) {
        super(list);
        this.sectionHeadResId = i3;
        addItemType(-99, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.z0
    public void onBindViewHolder(VH holder, int i3) {
        e.g(holder, "holder");
        if (holder.getItemViewType() == -99) {
            convertHeader(holder, (SectionEntity) getItem(i3 - getHeaderLayoutCount()));
        } else {
            super.onBindViewHolder((BaseSectionQuickAdapter<T, VH>) holder, i3);
        }
    }

    public BaseSectionQuickAdapter(int i3, int i10, List<T> list) {
        this(i3, list);
        setNormalLayout(i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void onBindViewHolder(VH holder, int i3, List<Object> payloads) {
        e.g(holder, "holder");
        e.g(payloads, "payloads");
        if (payloads.isEmpty()) {
            onBindViewHolder((BaseSectionQuickAdapter<T, VH>) holder, i3);
        } else if (holder.getItemViewType() == -99) {
            convertHeader(holder, (SectionEntity) getItem(i3 - getHeaderLayoutCount()), payloads);
        } else {
            super.onBindViewHolder((BaseSectionQuickAdapter<T, VH>) holder, i3, payloads);
        }
    }

    public /* synthetic */ BaseSectionQuickAdapter(int i3, int i10, List list, int i11, c cVar) {
        this(i3, i10, (i11 & 4) != 0 ? null : list);
    }
}
