package com.chad.library.adapter.base.provider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.util.AdapterUtilsKt;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import eh.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.a;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public abstract class BaseItemProvider<T> {
    private final b clickViewIds$delegate;
    public Context context;
    private final b longClickViewIds$delegate;
    private WeakReference<BaseProviderMultiAdapter<T>> weakAdapter;

    public BaseItemProvider() {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.clickViewIds$delegate = a.a(lazyThreadSafetyMode, new oh.a() { // from class: com.chad.library.adapter.base.provider.BaseItemProvider$clickViewIds$2
            @Override // oh.a
            public final ArrayList<Integer> invoke() {
                return new ArrayList<>();
            }
        });
        this.longClickViewIds$delegate = a.a(lazyThreadSafetyMode, new oh.a() { // from class: com.chad.library.adapter.base.provider.BaseItemProvider$longClickViewIds$2
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

    public abstract void convert(BaseViewHolder baseViewHolder, T t8);

    public void convert(BaseViewHolder helper, T t8, List<? extends Object> payloads) {
        e.g(helper, "helper");
        e.g(payloads, "payloads");
    }

    public BaseProviderMultiAdapter<T> getAdapter() {
        WeakReference<BaseProviderMultiAdapter<T>> weakReference = this.weakAdapter;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final ArrayList<Integer> getChildClickViewIds() {
        return getClickViewIds();
    }

    public final ArrayList<Integer> getChildLongClickViewIds() {
        return getLongClickViewIds();
    }

    public final Context getContext() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        e.m("context");
        throw null;
    }

    public abstract int getItemViewType();

    public abstract int getLayoutId();

    public void onChildClick(BaseViewHolder helper, View view, T t8, int i3) {
        e.g(helper, "helper");
        e.g(view, "view");
    }

    public boolean onChildLongClick(BaseViewHolder helper, View view, T t8, int i3) {
        e.g(helper, "helper");
        e.g(view, "view");
        return false;
    }

    public void onClick(BaseViewHolder helper, View view, T t8, int i3) {
        e.g(helper, "helper");
        e.g(view, "view");
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int i3) {
        e.g(parent, "parent");
        return new BaseViewHolder(AdapterUtilsKt.getItemView(parent, getLayoutId()));
    }

    public boolean onLongClick(BaseViewHolder helper, View view, T t8, int i3) {
        e.g(helper, "helper");
        e.g(view, "view");
        return false;
    }

    public void onViewAttachedToWindow(BaseViewHolder holder) {
        e.g(holder, "holder");
    }

    public void onViewDetachedFromWindow(BaseViewHolder holder) {
        e.g(holder, "holder");
    }

    public void onViewHolderCreated(BaseViewHolder viewHolder, int i3) {
        e.g(viewHolder, "viewHolder");
    }

    public final void setAdapter$com_github_CymChad_brvah(BaseProviderMultiAdapter<T> adapter) {
        e.g(adapter, "adapter");
        this.weakAdapter = new WeakReference<>(adapter);
    }

    public final void setContext(Context context) {
        e.g(context, "<set-?>");
        this.context = context;
    }
}
