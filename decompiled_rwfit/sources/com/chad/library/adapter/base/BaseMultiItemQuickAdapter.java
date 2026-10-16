package com.chad.library.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import eh.b;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.a;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public abstract class BaseMultiItemQuickAdapter<T extends MultiItemEntity, VH extends BaseViewHolder> extends BaseQuickAdapter<T, VH> {
    private final b layouts$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseMultiItemQuickAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final SparseIntArray getLayouts() {
        return (SparseIntArray) this.layouts$delegate.getValue();
    }

    public final void addItemType(int i3, int i10) {
        getLayouts().put(i3, i10);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int i3) {
        return ((MultiItemEntity) getData().get(i3)).getItemType();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public VH onCreateDefViewHolder(ViewGroup parent, int i3) {
        e.g(parent, "parent");
        int i10 = getLayouts().get(i3);
        if (i10 != 0) {
            return createBaseViewHolder(parent, i10);
        }
        throw new IllegalArgumentException(l0.k(i3, "ViewType: ", " found layoutResId，please use addItemType() first!").toString());
    }

    public /* synthetic */ BaseMultiItemQuickAdapter(List list, int i3, c cVar) {
        this((i3 & 1) != 0 ? null : list);
    }

    public BaseMultiItemQuickAdapter(List<T> list) {
        super(0, list);
        this.layouts$delegate = a.a(LazyThreadSafetyMode.NONE, new oh.a() { // from class: com.chad.library.adapter.base.BaseMultiItemQuickAdapter$layouts$2
            @Override // oh.a
            public final SparseIntArray invoke() {
                return new SparseIntArray();
            }
        });
    }
}
