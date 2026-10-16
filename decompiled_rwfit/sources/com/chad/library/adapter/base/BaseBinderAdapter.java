package com.chad.library.adapter.base;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.p;
import androidx.recyclerview.widget.z1;
import com.chad.library.adapter.base.binder.BaseItemBinder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public class BaseBinderAdapter extends BaseQuickAdapter<Object, BaseViewHolder> {
    private final HashMap<Class<?>, p> classDiffMap;
    private final SparseArray<BaseItemBinder<Object, ?>> mBinderArray;
    private final HashMap<Class<?>, Integer> mTypeMap;

    public final class ItemCallback extends p {
        public ItemCallback() {
        }

        @Override // androidx.recyclerview.widget.p
        @SuppressLint({"DiffUtilEquals"})
        public boolean areContentsTheSame(Object oldItem, Object newItem) {
            p pVar;
            e.g(oldItem, "oldItem");
            e.g(newItem, "newItem");
            if (!oldItem.getClass().equals(newItem.getClass()) || (pVar = (p) BaseBinderAdapter.this.classDiffMap.get(oldItem.getClass())) == null) {
                return true;
            }
            return pVar.areContentsTheSame(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.p
        public boolean areItemsTheSame(Object oldItem, Object newItem) {
            p pVar;
            e.g(oldItem, "oldItem");
            e.g(newItem, "newItem");
            return (!oldItem.getClass().equals(newItem.getClass()) || (pVar = (p) BaseBinderAdapter.this.classDiffMap.get(oldItem.getClass())) == null) ? oldItem.equals(newItem) : pVar.areItemsTheSame(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.p
        public Object getChangePayload(Object oldItem, Object newItem) {
            p pVar;
            e.g(oldItem, "oldItem");
            e.g(newItem, "newItem");
            if (!oldItem.getClass().equals(newItem.getClass()) || (pVar = (p) BaseBinderAdapter.this.classDiffMap.get(oldItem.getClass())) == null) {
                return null;
            }
            return pVar.getChangePayload(oldItem, newItem);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseBinderAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BaseBinderAdapter addItemBinder$default(BaseBinderAdapter baseBinderAdapter, Class cls, BaseItemBinder baseItemBinder, p pVar, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addItemBinder");
        }
        if ((i3 & 4) != 0) {
            pVar = null;
        }
        return baseBinderAdapter.addItemBinder(cls, baseItemBinder, pVar);
    }

    public final <T> BaseBinderAdapter addItemBinder(Class<? extends T> cls, BaseItemBinder<T, ?> baseItemBinder) {
        return addItemBinder$default(this, cls, baseItemBinder, null, 4, null);
    }

    public void bindChildClick(final BaseViewHolder viewHolder, int i3) {
        e.g(viewHolder, "viewHolder");
        int i10 = 0;
        if (getOnItemChildClickListener() == null) {
            final BaseItemBinder<Object, BaseViewHolder> itemBinder = getItemBinder(i3);
            ArrayList<Integer> childClickViewIds = itemBinder.getChildClickViewIds();
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
                    findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.BaseBinderAdapter$bindChildClick$$inlined$forEach$lambda$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View v6) {
                            int adapterPosition = viewHolder.getAdapterPosition();
                            if (adapterPosition == -1) {
                                return;
                            }
                            int headerLayoutCount = adapterPosition - BaseBinderAdapter.this.getHeaderLayoutCount();
                            BaseItemBinder baseItemBinder = itemBinder;
                            BaseViewHolder baseViewHolder = viewHolder;
                            e.b(v6, "v");
                            baseItemBinder.onChildClick(baseViewHolder, v6, BaseBinderAdapter.this.getData().get(headerLayoutCount), headerLayoutCount);
                        }
                    });
                }
            }
        }
        if (getOnItemChildLongClickListener() == null) {
            final BaseItemBinder<Object, BaseViewHolder> itemBinder2 = getItemBinder(i3);
            ArrayList<Integer> childLongClickViewIds = itemBinder2.getChildLongClickViewIds();
            int size2 = childLongClickViewIds.size();
            while (i10 < size2) {
                Integer num2 = childLongClickViewIds.get(i10);
                i10++;
                View findViewById2 = viewHolder.itemView.findViewById(num2.intValue());
                if (findViewById2 != null) {
                    if (!findViewById2.isLongClickable()) {
                        findViewById2.setLongClickable(true);
                    }
                    findViewById2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.BaseBinderAdapter$bindChildClick$$inlined$forEach$lambda$2
                        @Override // android.view.View.OnLongClickListener
                        public final boolean onLongClick(View v6) {
                            int adapterPosition = viewHolder.getAdapterPosition();
                            if (adapterPosition == -1) {
                                return false;
                            }
                            int headerLayoutCount = adapterPosition - BaseBinderAdapter.this.getHeaderLayoutCount();
                            BaseItemBinder baseItemBinder = itemBinder2;
                            BaseViewHolder baseViewHolder = viewHolder;
                            e.b(v6, "v");
                            return baseItemBinder.onChildLongClick(baseViewHolder, v6, BaseBinderAdapter.this.getData().get(headerLayoutCount), headerLayoutCount);
                        }
                    });
                }
            }
        }
    }

    public void bindClick(final BaseViewHolder viewHolder) {
        e.g(viewHolder, "viewHolder");
        if (getOnItemClickListener() == null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.BaseBinderAdapter$bindClick$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    int adapterPosition = viewHolder.getAdapterPosition();
                    if (adapterPosition == -1) {
                        return;
                    }
                    int headerLayoutCount = adapterPosition - BaseBinderAdapter.this.getHeaderLayoutCount();
                    BaseItemBinder<Object, BaseViewHolder> itemBinder = BaseBinderAdapter.this.getItemBinder(viewHolder.getItemViewType());
                    BaseViewHolder baseViewHolder = viewHolder;
                    e.b(it, "it");
                    itemBinder.onClick(baseViewHolder, it, BaseBinderAdapter.this.getData().get(headerLayoutCount), headerLayoutCount);
                }
            });
        }
        if (getOnItemLongClickListener() == null) {
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.BaseBinderAdapter$bindClick$2
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View it) {
                    int adapterPosition = viewHolder.getAdapterPosition();
                    if (adapterPosition == -1) {
                        return false;
                    }
                    int headerLayoutCount = adapterPosition - BaseBinderAdapter.this.getHeaderLayoutCount();
                    BaseItemBinder<Object, BaseViewHolder> itemBinder = BaseBinderAdapter.this.getItemBinder(viewHolder.getItemViewType());
                    BaseViewHolder baseViewHolder = viewHolder;
                    e.b(it, "it");
                    return itemBinder.onLongClick(baseViewHolder, it, BaseBinderAdapter.this.getData().get(headerLayoutCount), headerLayoutCount);
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
    public void convert(BaseViewHolder holder, Object item) {
        e.g(holder, "holder");
        e.g(item, "item");
        getItemBinder(holder.getItemViewType()).convert(holder, item);
    }

    public final int findViewType(Class<?> clazz) {
        e.g(clazz, "clazz");
        Integer num = this.mTypeMap.get(clazz);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException(("findViewType: ViewType: " + clazz + " Not Find!").toString());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int i3) {
        return findViewType(getData().get(i3).getClass());
    }

    public BaseItemBinder<Object, BaseViewHolder> getItemBinder(int i3) {
        BaseItemBinder<Object, BaseViewHolder> baseItemBinder = (BaseItemBinder) this.mBinderArray.get(i3);
        if (baseItemBinder != null) {
            return baseItemBinder;
        }
        throw new IllegalStateException(l0.k(i3, "getItemBinder: viewType '", "' no such Binder found，please use addItemBinder() first!").toString());
    }

    public BaseItemBinder<Object, BaseViewHolder> getItemBinderOrNull(int i3) {
        BaseItemBinder<Object, BaseViewHolder> baseItemBinder = (BaseItemBinder) this.mBinderArray.get(i3);
        if (baseItemBinder == null) {
            return null;
        }
        return baseItemBinder;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public BaseViewHolder onCreateDefViewHolder(ViewGroup parent, int i3) {
        e.g(parent, "parent");
        BaseItemBinder<Object, BaseViewHolder> itemBinder = getItemBinder(i3);
        itemBinder.set_context$com_github_CymChad_brvah(getContext());
        return itemBinder.onCreateViewHolder(parent, i3);
    }

    public BaseBinderAdapter(List<Object> list) {
        super(0, list);
        this.classDiffMap = new HashMap<>();
        this.mTypeMap = new HashMap<>();
        this.mBinderArray = new SparseArray<>();
        setDiffCallback(new ItemCallback());
    }

    public final <T> BaseBinderAdapter addItemBinder(Class<? extends T> clazz, BaseItemBinder<T, ?> baseItemBinder, p pVar) {
        e.g(clazz, "clazz");
        e.g(baseItemBinder, "baseItemBinder");
        int size = this.mTypeMap.size() + 1;
        this.mTypeMap.put(clazz, Integer.valueOf(size));
        this.mBinderArray.append(size, baseItemBinder);
        baseItemBinder.set_adapter$com_github_CymChad_brvah(this);
        if (pVar != null) {
            this.classDiffMap.put(clazz, pVar);
        }
        return this;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(BaseViewHolder holder, Object item, List<? extends Object> payloads) {
        e.g(holder, "holder");
        e.g(item, "item");
        e.g(payloads, "payloads");
        getItemBinder(holder.getItemViewType()).convert(holder, item, payloads);
    }

    @Override // androidx.recyclerview.widget.z0
    public boolean onFailedToRecycleView(BaseViewHolder holder) {
        e.g(holder, "holder");
        BaseItemBinder<Object, BaseViewHolder> itemBinderOrNull = getItemBinderOrNull(holder.getItemViewType());
        if (itemBinderOrNull != null) {
            return itemBinderOrNull.onFailedToRecycleView(holder);
        }
        return false;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.z0
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        e.g(holder, "holder");
        super.onViewAttachedToWindow((BaseBinderAdapter) holder);
        BaseItemBinder<Object, BaseViewHolder> itemBinderOrNull = getItemBinderOrNull(holder.getItemViewType());
        if (itemBinderOrNull != null) {
            itemBinderOrNull.onViewAttachedToWindow(holder);
        }
    }

    @Override // androidx.recyclerview.widget.z0
    public void onViewDetachedFromWindow(BaseViewHolder holder) {
        e.g(holder, "holder");
        super.onViewDetachedFromWindow((z1) holder);
        BaseItemBinder<Object, BaseViewHolder> itemBinderOrNull = getItemBinderOrNull(holder.getItemViewType());
        if (itemBinderOrNull != null) {
            itemBinderOrNull.onViewDetachedFromWindow(holder);
        }
    }

    public static BaseBinderAdapter addItemBinder$default(BaseBinderAdapter baseBinderAdapter, BaseItemBinder baseItemBinder, p pVar, int i3, Object obj) {
        if (obj == null) {
            e.g(baseItemBinder, "baseItemBinder");
            throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addItemBinder");
    }

    public /* synthetic */ BaseBinderAdapter(List list, int i3, c cVar) {
        this((i3 & 1) != 0 ? null : list);
    }

    public final <T> BaseBinderAdapter addItemBinder(BaseItemBinder<T, ?> baseItemBinder, p pVar) {
        e.g(baseItemBinder, "baseItemBinder");
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }
}
