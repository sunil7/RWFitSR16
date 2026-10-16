package com.chad.library.adapter.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.z1;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import eh.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.a;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public abstract class BaseProviderMultiAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    private final b mItemProviders$delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseProviderMultiAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SparseArray<BaseItemProvider<T>> getMItemProviders() {
        return (SparseArray) this.mItemProviders$delegate.getValue();
    }

    public void addItemProvider(BaseItemProvider<T> provider) {
        e.g(provider, "provider");
        provider.setAdapter$com_github_CymChad_brvah(this);
        getMItemProviders().put(provider.getItemViewType(), provider);
    }

    public void bindChildClick(final BaseViewHolder viewHolder, int i3) {
        final BaseItemProvider<T> itemProvider;
        e.g(viewHolder, "viewHolder");
        int i10 = 0;
        if (getOnItemChildClickListener() == null) {
            final BaseItemProvider<T> itemProvider2 = getItemProvider(i3);
            if (itemProvider2 == null) {
                return;
            }
            ArrayList<Integer> childClickViewIds = itemProvider2.getChildClickViewIds();
            int size = childClickViewIds.size();
            int i11 = 0;
            while (i11 < size) {
                Integer num = childClickViewIds.get(i11);
                i11++;
                View findViewById = viewHolder.itemView.findViewById(num.intValue());
                if (findViewById != null) {
                    if (!findViewById.isClickable()) {
                        findViewById.setClickable(true);
                    }
                    findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.BaseProviderMultiAdapter$bindChildClick$$inlined$forEach$lambda$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View v6) {
                            int adapterPosition = viewHolder.getAdapterPosition();
                            if (adapterPosition == -1) {
                                return;
                            }
                            int headerLayoutCount = adapterPosition - BaseProviderMultiAdapter.this.getHeaderLayoutCount();
                            BaseItemProvider baseItemProvider = itemProvider2;
                            BaseViewHolder baseViewHolder = viewHolder;
                            e.b(v6, "v");
                            baseItemProvider.onChildClick(baseViewHolder, v6, BaseProviderMultiAdapter.this.getData().get(headerLayoutCount), headerLayoutCount);
                        }
                    });
                }
            }
        }
        if (getOnItemChildLongClickListener() != null || (itemProvider = getItemProvider(i3)) == null) {
            return;
        }
        ArrayList<Integer> childLongClickViewIds = itemProvider.getChildLongClickViewIds();
        int size2 = childLongClickViewIds.size();
        while (i10 < size2) {
            Integer num2 = childLongClickViewIds.get(i10);
            i10++;
            View findViewById2 = viewHolder.itemView.findViewById(num2.intValue());
            if (findViewById2 != null) {
                if (!findViewById2.isLongClickable()) {
                    findViewById2.setLongClickable(true);
                }
                findViewById2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.BaseProviderMultiAdapter$bindChildClick$$inlined$forEach$lambda$2
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View v6) {
                        int adapterPosition = viewHolder.getAdapterPosition();
                        if (adapterPosition == -1) {
                            return false;
                        }
                        int headerLayoutCount = adapterPosition - BaseProviderMultiAdapter.this.getHeaderLayoutCount();
                        BaseItemProvider baseItemProvider = itemProvider;
                        BaseViewHolder baseViewHolder = viewHolder;
                        e.b(v6, "v");
                        return baseItemProvider.onChildLongClick(baseViewHolder, v6, BaseProviderMultiAdapter.this.getData().get(headerLayoutCount), headerLayoutCount);
                    }
                });
            }
        }
    }

    public void bindClick(final BaseViewHolder viewHolder) {
        e.g(viewHolder, "viewHolder");
        if (getOnItemClickListener() == null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.BaseProviderMultiAdapter$bindClick$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    SparseArray mItemProviders;
                    int adapterPosition = viewHolder.getAdapterPosition();
                    if (adapterPosition == -1) {
                        return;
                    }
                    int headerLayoutCount = adapterPosition - BaseProviderMultiAdapter.this.getHeaderLayoutCount();
                    int itemViewType = viewHolder.getItemViewType();
                    mItemProviders = BaseProviderMultiAdapter.this.getMItemProviders();
                    BaseItemProvider baseItemProvider = (BaseItemProvider) mItemProviders.get(itemViewType);
                    BaseViewHolder baseViewHolder = viewHolder;
                    e.b(it, "it");
                    baseItemProvider.onClick(baseViewHolder, it, BaseProviderMultiAdapter.this.getData().get(headerLayoutCount), headerLayoutCount);
                }
            });
        }
        if (getOnItemLongClickListener() == null) {
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.BaseProviderMultiAdapter$bindClick$2
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View it) {
                    SparseArray mItemProviders;
                    int adapterPosition = viewHolder.getAdapterPosition();
                    if (adapterPosition == -1) {
                        return false;
                    }
                    int headerLayoutCount = adapterPosition - BaseProviderMultiAdapter.this.getHeaderLayoutCount();
                    int itemViewType = viewHolder.getItemViewType();
                    mItemProviders = BaseProviderMultiAdapter.this.getMItemProviders();
                    BaseItemProvider baseItemProvider = (BaseItemProvider) mItemProviders.get(itemViewType);
                    BaseViewHolder baseViewHolder = viewHolder;
                    e.b(it, "it");
                    return baseItemProvider.onLongClick(baseViewHolder, it, BaseProviderMultiAdapter.this.getData().get(headerLayoutCount), headerLayoutCount);
                }
            });
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void bindViewClickListener(BaseViewHolder viewHolder, int i3) {
        e.g(viewHolder, "viewHolder");
        super.bindViewClickListener(viewHolder, i3);
        bindClick(viewHolder);
        bindChildClick(viewHolder, i3);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, T t8) {
        e.g(holder, "holder");
        BaseItemProvider<T> itemProvider = getItemProvider(holder.getItemViewType());
        if (itemProvider != null) {
            itemProvider.convert(holder, t8);
        } else {
            e.l();
            throw null;
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int i3) {
        return getItemType(getData(), i3);
    }

    public BaseItemProvider<T> getItemProvider(int i3) {
        return getMItemProviders().get(i3);
    }

    public abstract int getItemType(List<? extends T> list, int i3);

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int i3) {
        e.g(parent, "parent");
        BaseItemProvider<T> itemProvider = getItemProvider(i3);
        if (itemProvider == null) {
            throw new IllegalStateException(l0.k(i3, "ViewType: ", " no such provider found，please use addItemProvider() first!").toString());
        }
        Context context = parent.getContext();
        e.b(context, "parent.context");
        itemProvider.setContext(context);
        BaseViewHolder onCreateViewHolder = itemProvider.onCreateViewHolder(parent, i3);
        itemProvider.onViewHolderCreated(onCreateViewHolder, i3);
        return onCreateViewHolder;
    }

    public /* synthetic */ BaseProviderMultiAdapter(List list, int i3, c cVar) {
        this((i3 & 1) != 0 ? null : list);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, T t8, List<? extends Object> payloads) {
        e.g(holder, "holder");
        e.g(payloads, "payloads");
        BaseItemProvider<T> itemProvider = getItemProvider(holder.getItemViewType());
        if (itemProvider != null) {
            itemProvider.convert(holder, t8, payloads);
        } else {
            e.l();
            throw null;
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.z0
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        e.g(holder, "holder");
        super.onViewAttachedToWindow((BaseProviderMultiAdapter<T>) holder);
        BaseItemProvider<T> itemProvider = getItemProvider(holder.getItemViewType());
        if (itemProvider != null) {
            itemProvider.onViewAttachedToWindow(holder);
        }
    }

    @Override // androidx.recyclerview.widget.z0
    public void onViewDetachedFromWindow(BaseViewHolder holder) {
        e.g(holder, "holder");
        super.onViewDetachedFromWindow((z1) holder);
        BaseItemProvider<T> itemProvider = getItemProvider(holder.getItemViewType());
        if (itemProvider != null) {
            itemProvider.onViewDetachedFromWindow(holder);
        }
    }

    public BaseProviderMultiAdapter(List<T> list) {
        super(0, list);
        this.mItemProviders$delegate = a.a(LazyThreadSafetyMode.NONE, new oh.a() { // from class: com.chad.library.adapter.base.BaseProviderMultiAdapter$mItemProviders$2
            @Override // oh.a
            public final SparseArray<BaseItemProvider<T>> invoke() {
                return new SparseArray<>();
            }
        });
    }
}
