package og;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.e2;
import androidx.recyclerview.widget.i1;
import androidx.recyclerview.widget.z0;
import androidx.recyclerview.widget.z1;
import com.example.baselibrary.R$id;
import com.example.baselibrary.R$layout;
import com.yanzhenjie.recyclerview.SwipeMenuLayout;
import com.yanzhenjie.recyclerview.SwipeMenuView;
import java.lang.reflect.Field;
import java.util.List;

/* loaded from: classes2.dex */
public final class e extends z0 {

    /* renamed from: a, reason: collision with root package name */
    public m0.l f16935a;

    /* renamed from: b, reason: collision with root package name */
    public m0.l f16936b;

    /* renamed from: c, reason: collision with root package name */
    public z0 f16937c;

    /* renamed from: d, reason: collision with root package name */
    public LayoutInflater f16938d;
    public n e;

    /* renamed from: f, reason: collision with root package name */
    public k f16939f;

    /* renamed from: g, reason: collision with root package name */
    public i f16940g;

    /* renamed from: h, reason: collision with root package name */
    public j f16941h;

    public static Class a(Class cls) {
        Class superclass = cls.getSuperclass();
        return (superclass == null || superclass.equals(Object.class)) ? cls : a(superclass);
    }

    public final boolean b(int i3) {
        return i3 >= this.f16937c.getItemCount() + this.f16935a.f15923c;
    }

    public final boolean c(z1 z1Var) {
        if (z1Var instanceof d) {
            return true;
        }
        int adapterPosition = z1Var.getAdapterPosition();
        return (adapterPosition >= 0 && adapterPosition < this.f16935a.f15923c) || b(adapterPosition);
    }

    @Override // androidx.recyclerview.widget.z0
    public final int getItemCount() {
        return this.f16936b.f15923c + this.f16937c.getItemCount() + this.f16935a.f15923c;
    }

    @Override // androidx.recyclerview.widget.z0
    public final long getItemId(int i3) {
        if ((i3 >= 0 && i3 < this.f16935a.f15923c) || b(i3)) {
            return (-i3) - 1;
        }
        return this.f16937c.getItemId(i3 - this.f16935a.f15923c);
    }

    @Override // androidx.recyclerview.widget.z0
    public final int getItemViewType(int i3) {
        boolean z5 = i3 >= 0 && i3 < this.f16935a.f15923c;
        m0.l lVar = this.f16935a;
        if (z5) {
            return lVar.f15921a[i3];
        }
        boolean b3 = b(i3);
        z0 z0Var = this.f16937c;
        if (b3) {
            return this.f16936b.f15921a[(i3 - lVar.f15923c) - z0Var.getItemCount()];
        }
        return z0Var.getItemViewType(i3 - lVar.f15923c);
    }

    @Override // androidx.recyclerview.widget.z0
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        this.f16937c.onAttachedToRecyclerView(recyclerView);
        i1 layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.K = new c(this, gridLayoutManager, gridLayoutManager.K, 0);
        }
    }

    @Override // androidx.recyclerview.widget.z0
    public final void onBindViewHolder(z1 z1Var, int i3) {
    }

    @Override // androidx.recyclerview.widget.z0
    public final z1 onCreateViewHolder(ViewGroup viewGroup, int i3) {
        View view = (View) this.f16935a.b(i3, null);
        if (view != null) {
            return new d(view);
        }
        View view2 = (View) this.f16936b.b(i3, null);
        if (view2 != null) {
            return new d(view2);
        }
        z1 onCreateViewHolder = this.f16937c.onCreateViewHolder(viewGroup, i3);
        if (this.f16940g != null) {
            onCreateViewHolder.itemView.setOnClickListener(new a(this, onCreateViewHolder));
        }
        if (this.f16941h != null) {
            onCreateViewHolder.itemView.setOnLongClickListener(new b(this, onCreateViewHolder));
        }
        if (this.e == null) {
            return onCreateViewHolder;
        }
        View inflate = this.f16938d.inflate(R$layout.x_recycler_view_item, viewGroup, false);
        ((ViewGroup) inflate.findViewById(R$id.swipe_content)).addView(onCreateViewHolder.itemView);
        try {
            Field declaredField = a(onCreateViewHolder.getClass()).getDeclaredField("itemView");
            if (!declaredField.isAccessible()) {
                declaredField.setAccessible(true);
            }
            declaredField.set(onCreateViewHolder, inflate);
        } catch (Exception unused) {
        }
        return onCreateViewHolder;
    }

    @Override // androidx.recyclerview.widget.z0
    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.f16937c.onDetachedFromRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.z0
    public final boolean onFailedToRecycleView(z1 z1Var) {
        if (c(z1Var)) {
            return false;
        }
        return this.f16937c.onFailedToRecycleView(z1Var);
    }

    @Override // androidx.recyclerview.widget.z0
    public final void onViewAttachedToWindow(z1 z1Var) {
        if (!c(z1Var)) {
            this.f16937c.onViewAttachedToWindow(z1Var);
            return;
        }
        ViewGroup.LayoutParams layoutParams = z1Var.itemView.getLayoutParams();
        if (layoutParams instanceof e2) {
            ((e2) layoutParams).f2556f = true;
        }
    }

    @Override // androidx.recyclerview.widget.z0
    public final void onViewDetachedFromWindow(z1 z1Var) {
        if (c(z1Var)) {
            return;
        }
        this.f16937c.onViewDetachedFromWindow(z1Var);
    }

    @Override // androidx.recyclerview.widget.z0
    public final void onViewRecycled(z1 z1Var) {
        if (c(z1Var)) {
            return;
        }
        this.f16937c.onViewRecycled(z1Var);
    }

    public void setOnItemClickListener(i iVar) {
        this.f16940g = iVar;
    }

    public void setOnItemLongClickListener(j jVar) {
        this.f16941h = jVar;
    }

    public void setOnItemMenuClickListener(k kVar) {
        this.f16939f = kVar;
    }

    @Override // androidx.recyclerview.widget.z0
    public final void onBindViewHolder(z1 z1Var, int i3, List list) {
        if (c(z1Var)) {
            return;
        }
        View view = z1Var.itemView;
        int i10 = i3 - this.f16935a.f15923c;
        if ((view instanceof SwipeMenuLayout) && this.e != null) {
            SwipeMenuLayout swipeMenuLayout = (SwipeMenuLayout) view;
            androidx.camera.core.impl.i1 i1Var = new androidx.camera.core.impl.i1(2);
            androidx.camera.core.impl.i1 i1Var2 = new androidx.camera.core.impl.i1(2);
            this.e.a(i1Var, i1Var2);
            SwipeMenuView swipeMenuView = (SwipeMenuView) swipeMenuLayout.getChildAt(0);
            if (!i1Var.f1421a.isEmpty()) {
                swipeMenuView.setOrientation(0);
                swipeMenuView.a(z1Var, i1Var, swipeMenuLayout, this.f16939f);
            } else if (swipeMenuView.getChildCount() > 0) {
                swipeMenuView.removeAllViews();
            }
            SwipeMenuView swipeMenuView2 = (SwipeMenuView) swipeMenuLayout.getChildAt(2);
            if (!i1Var2.f1421a.isEmpty()) {
                swipeMenuView2.setOrientation(0);
                swipeMenuView2.a(z1Var, i1Var2, swipeMenuLayout, this.f16939f);
            } else if (swipeMenuView2.getChildCount() > 0) {
                swipeMenuView2.removeAllViews();
            }
        }
        this.f16937c.onBindViewHolder(z1Var, i10, list);
    }
}
