package com.chad.library.adapter.base.binder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseBinderAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import eh.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.a;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public abstract class BaseItemBinder<T, VH extends BaseViewHolder> {
    private BaseBinderAdapter _adapter;
    private Context _context;
    private final b clickViewIds$delegate;
    private final b longClickViewIds$delegate;

    public BaseItemBinder() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.clickViewIds$delegate = a.a(lazyThreadSafetyMode, new oh.a() { // from class: com.chad.library.adapter.base.binder.BaseItemBinder$clickViewIds$2
            @Override // oh.a
            public final ArrayList<Integer> invoke() {
                return new ArrayList<>();
            }
        });
        this.longClickViewIds$delegate = a.a(lazyThreadSafetyMode, new oh.a() { // from class: com.chad.library.adapter.base.binder.BaseItemBinder$longClickViewIds$2
            @Override // oh.a
            public final ArrayList<Integer> invoke() {
                return new ArrayList<>();
            }
        });
    }

    private final ArrayList<Integer> getClickViewIds() {
        return (ArrayList) this.clickViewIds$delegate.getValue();
    }

    private final ArrayList<Integer> getLongClickViewIds() {
        return (ArrayList) this.longClickViewIds$delegate.getValue();
    }

    public final void addChildClickViewIds(int... ids) {
        e.g(ids, "ids");
        for (int i3 : ids) {
            getClickViewIds().add(Integer.valueOf(i3));
        }
    }

    public final void addChildLongClickViewIds(int... ids) {
        e.g(ids, "ids");
        for (int i3 : ids) {
            getLongClickViewIds().add(Integer.valueOf(i3));
        }
    }

    public abstract void convert(VH vh2, T t8);

    public void convert(VH holder, T t8, List<? extends Object> payloads) {
        e.g(holder, "holder");
        e.g(payloads, "payloads");
    }

    public final BaseBinderAdapter getAdapter() {
        BaseBinderAdapter baseBinderAdapter = this._adapter;
        if (baseBinderAdapter != null) {
            if (baseBinderAdapter != null) {
                return baseBinderAdapter;
            }
            e.l();
            throw null;
        }
        throw new IllegalStateException(("This " + this + " has not been attached to BaseBinderAdapter yet.\n                    You should not call the method before addItemBinder().").toString());
    }

    public final ArrayList<Integer> getChildClickViewIds() {
        return getClickViewIds();
    }

    public final ArrayList<Integer> getChildLongClickViewIds() {
        return getLongClickViewIds();
    }

    public final Context getContext() {
        Context context = this._context;
        if (context != null) {
            if (context != null) {
                return context;
            }
            e.l();
            throw null;
        }
        throw new IllegalStateException(("This " + this + " has not been attached to BaseBinderAdapter yet.\n                    You should not call the method before onCreateViewHolder().").toString());
    }

    public final List<Object> getData() {
        return getAdapter().getData();
    }

    public final BaseBinderAdapter get_adapter$com_github_CymChad_brvah() {
        return this._adapter;
    }

    public final Context get_context$com_github_CymChad_brvah() {
        return this._context;
    }

    public void onChildClick(VH holder, View view, T t8, int i3) {
        e.g(holder, "holder");
        e.g(view, "view");
    }

    public boolean onChildLongClick(VH holder, View view, T t8, int i3) {
        e.g(holder, "holder");
        e.g(view, "view");
        return false;
    }

    public void onClick(VH holder, View view, T t8, int i3) {
        e.g(holder, "holder");
        e.g(view, "view");
    }

    public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i3);

    public boolean onFailedToRecycleView(VH holder) {
        e.g(holder, "holder");
        return false;
    }

    public boolean onLongClick(VH holder, View view, T t8, int i3) {
        e.g(holder, "holder");
        e.g(view, "view");
        return false;
    }

    public void onViewAttachedToWindow(VH holder) {
        e.g(holder, "holder");
    }

    public void onViewDetachedFromWindow(VH holder) {
        e.g(holder, "holder");
    }

    public final void set_adapter$com_github_CymChad_brvah(BaseBinderAdapter baseBinderAdapter) {
        this._adapter = baseBinderAdapter;
    }

    public final void set_context$com_github_CymChad_brvah(Context context) {
        this._context = context;
    }
}
