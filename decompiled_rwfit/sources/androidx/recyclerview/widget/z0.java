package androidx.recyclerview.widget;

import android.view.ViewGroup;
import java.util.List;

/* loaded from: classes.dex */
public abstract class z0 {
    private final a1 mObservable = new a1();
    private boolean mHasStableIds = false;
    private RecyclerView$Adapter$StateRestorationPolicy mStateRestorationPolicy = RecyclerView$Adapter$StateRestorationPolicy.ALLOW;

    public final void bindViewHolder(z1 z1Var, int i3) {
        boolean z5 = z1Var.mBindingAdapter == null;
        if (z5) {
            z1Var.mPosition = i3;
            if (hasStableIds()) {
                z1Var.mItemId = getItemId(i3);
            }
            z1Var.setFlags(1, 519);
            int i10 = h1.l.f14255a;
            h1.k.a("RV OnBindView");
        }
        z1Var.mBindingAdapter = this;
        onBindViewHolder(z1Var, i3, z1Var.getUnmodifiedPayloads());
        if (z5) {
            z1Var.clearPayload();
            ViewGroup.LayoutParams layoutParams = z1Var.itemView.getLayoutParams();
            if (layoutParams instanceof j1) {
                ((j1) layoutParams).f2635c = true;
            }
            int i11 = h1.l.f14255a;
            h1.k.b();
        }
    }

    public boolean canRestoreState() {
        int i3 = y0.f2806a[this.mStateRestorationPolicy.ordinal()];
        if (i3 != 1) {
            return i3 != 2 || getItemCount() > 0;
        }
        return false;
    }

    public final z1 createViewHolder(ViewGroup viewGroup, int i3) {
        try {
            int i10 = h1.l.f14255a;
            h1.k.a("RV CreateView");
            z1 onCreateViewHolder = onCreateViewHolder(viewGroup, i3);
            if (onCreateViewHolder.itemView.getParent() != null) {
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            }
            onCreateViewHolder.mItemViewType = i3;
            h1.k.b();
            return onCreateViewHolder;
        } catch (Throwable th2) {
            int i11 = h1.l.f14255a;
            h1.k.b();
            throw th2;
        }
    }

    public int findRelativeAdapterPositionIn(z0 z0Var, z1 z1Var, int i3) {
        if (z0Var == this) {
            return i3;
        }
        return -1;
    }

    public abstract int getItemCount();

    public long getItemId(int i3) {
        return -1L;
    }

    public int getItemViewType(int i3) {
        return 0;
    }

    public final RecyclerView$Adapter$StateRestorationPolicy getStateRestorationPolicy() {
        return this.mStateRestorationPolicy;
    }

    public final boolean hasObservers() {
        return this.mObservable.a();
    }

    public final boolean hasStableIds() {
        return this.mHasStableIds;
    }

    public final void notifyDataSetChanged() {
        this.mObservable.b();
    }

    public final void notifyItemChanged(int i3) {
        this.mObservable.d(i3, 1, null);
    }

    public final void notifyItemInserted(int i3) {
        this.mObservable.e(i3, 1);
    }

    public final void notifyItemMoved(int i3, int i10) {
        this.mObservable.c(i3, i10);
    }

    public final void notifyItemRangeChanged(int i3, int i10) {
        this.mObservable.d(i3, i10, null);
    }

    public final void notifyItemRangeInserted(int i3, int i10) {
        this.mObservable.e(i3, i10);
    }

    public final void notifyItemRangeRemoved(int i3, int i10) {
        this.mObservable.f(i3, i10);
    }

    public final void notifyItemRemoved(int i3) {
        this.mObservable.f(i3, 1);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    }

    public abstract void onBindViewHolder(z1 z1Var, int i3);

    public void onBindViewHolder(z1 z1Var, int i3, List list) {
        onBindViewHolder(z1Var, i3);
    }

    public abstract z1 onCreateViewHolder(ViewGroup viewGroup, int i3);

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
    }

    public boolean onFailedToRecycleView(z1 z1Var) {
        return false;
    }

    public void onViewAttachedToWindow(z1 z1Var) {
    }

    public void onViewDetachedFromWindow(z1 z1Var) {
    }

    public void onViewRecycled(z1 z1Var) {
    }

    public void registerAdapterDataObserver(b1 b1Var) {
        this.mObservable.registerObserver(b1Var);
    }

    public void setHasStableIds(boolean z5) {
        if (hasObservers()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.mHasStableIds = z5;
    }

    public void setStateRestorationPolicy(RecyclerView$Adapter$StateRestorationPolicy recyclerView$Adapter$StateRestorationPolicy) {
        this.mStateRestorationPolicy = recyclerView$Adapter$StateRestorationPolicy;
        this.mObservable.g();
    }

    public void unregisterAdapterDataObserver(b1 b1Var) {
        this.mObservable.unregisterObserver(b1Var);
    }

    public final void notifyItemChanged(int i3, Object obj) {
        this.mObservable.d(i3, 1, obj);
    }

    public final void notifyItemRangeChanged(int i3, int i10, Object obj) {
        this.mObservable.d(i3, i10, obj);
    }
}
