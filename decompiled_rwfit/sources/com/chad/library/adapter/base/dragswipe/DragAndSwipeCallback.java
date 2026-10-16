package com.chad.library.adapter.base.dragswipe;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g0;
import androidx.recyclerview.widget.z1;
import com.chad.library.R$id;
import com.chad.library.adapter.base.module.BaseDraggableModule;

/* loaded from: classes.dex */
public class DragAndSwipeCallback extends g0 {
    private BaseDraggableModule mDraggableModule;
    private float mMoveThreshold = 0.1f;
    private float mSwipeThreshold = 0.7f;
    private int mDragMoveFlags = 15;
    private int mSwipeMoveFlags = 32;

    public DragAndSwipeCallback(BaseDraggableModule baseDraggableModule) {
        this.mDraggableModule = baseDraggableModule;
    }

    private boolean isViewCreateByAdapter(z1 z1Var) {
        int itemViewType = z1Var.getItemViewType();
        return itemViewType == 268435729 || itemViewType == 268436002 || itemViewType == 268436275 || itemViewType == 268436821;
    }

    @Override // androidx.recyclerview.widget.g0
    public void clearView(RecyclerView recyclerView, z1 z1Var) {
        super.clearView(recyclerView, z1Var);
        if (isViewCreateByAdapter(z1Var)) {
            return;
        }
        if (z1Var.itemView.getTag(R$id.BaseQuickAdapter_dragging_support) != null && ((Boolean) z1Var.itemView.getTag(R$id.BaseQuickAdapter_dragging_support)).booleanValue()) {
            BaseDraggableModule baseDraggableModule = this.mDraggableModule;
            if (baseDraggableModule != null) {
                baseDraggableModule.onItemDragEnd(z1Var);
            }
            z1Var.itemView.setTag(R$id.BaseQuickAdapter_dragging_support, Boolean.FALSE);
        }
        if (z1Var.itemView.getTag(R$id.BaseQuickAdapter_swiping_support) == null || !((Boolean) z1Var.itemView.getTag(R$id.BaseQuickAdapter_swiping_support)).booleanValue()) {
            return;
        }
        BaseDraggableModule baseDraggableModule2 = this.mDraggableModule;
        if (baseDraggableModule2 != null) {
            baseDraggableModule2.onItemSwipeClear(z1Var);
        }
        z1Var.itemView.setTag(R$id.BaseQuickAdapter_swiping_support, Boolean.FALSE);
    }

    @Override // androidx.recyclerview.widget.g0
    public float getMoveThreshold(z1 z1Var) {
        return this.mMoveThreshold;
    }

    @Override // androidx.recyclerview.widget.g0
    public int getMovementFlags(RecyclerView recyclerView, z1 z1Var) {
        return isViewCreateByAdapter(z1Var) ? g0.makeMovementFlags(0, 0) : g0.makeMovementFlags(this.mDragMoveFlags, this.mSwipeMoveFlags);
    }

    @Override // androidx.recyclerview.widget.g0
    public float getSwipeThreshold(z1 z1Var) {
        return this.mSwipeThreshold;
    }

    @Override // androidx.recyclerview.widget.g0
    public boolean isItemViewSwipeEnabled() {
        BaseDraggableModule baseDraggableModule = this.mDraggableModule;
        if (baseDraggableModule != null) {
            return baseDraggableModule.isSwipeEnabled();
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.g0
    public boolean isLongPressDragEnabled() {
        BaseDraggableModule baseDraggableModule = this.mDraggableModule;
        return (baseDraggableModule == null || !baseDraggableModule.isDragEnabled() || this.mDraggableModule.hasToggleView()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.g0
    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, z1 z1Var, float f2, float f10, int i3, boolean z5) {
        View view = z1Var.itemView;
        if (i3 != 1 || isViewCreateByAdapter(z1Var)) {
            return;
        }
        View view2 = z1Var.itemView;
        canvas.save();
        if (f2 > 0.0f) {
            canvas.clipRect(view2.getLeft(), view2.getTop(), view2.getLeft() + f2, view2.getBottom());
            canvas.translate(view2.getLeft(), view2.getTop());
        } else {
            canvas.clipRect(view2.getRight() + f2, view2.getTop(), view2.getRight(), view2.getBottom());
            canvas.translate(view2.getRight() + f2, view2.getTop());
        }
        BaseDraggableModule baseDraggableModule = this.mDraggableModule;
        if (baseDraggableModule != null) {
            baseDraggableModule.onItemSwiping(canvas, z1Var, f2, f10, z5);
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.g0
    public boolean onMove(RecyclerView recyclerView, z1 z1Var, z1 z1Var2) {
        return z1Var.getItemViewType() == z1Var2.getItemViewType();
    }

    @Override // androidx.recyclerview.widget.g0
    public void onMoved(RecyclerView recyclerView, z1 z1Var, int i3, z1 z1Var2, int i10, int i11, int i12) {
        super.onMoved(recyclerView, z1Var, i3, z1Var2, i10, i11, i12);
        BaseDraggableModule baseDraggableModule = this.mDraggableModule;
        if (baseDraggableModule != null) {
            baseDraggableModule.onItemDragMoving(z1Var, z1Var2);
        }
    }

    @Override // androidx.recyclerview.widget.g0
    public void onSelectedChanged(z1 z1Var, int i3) {
        if (i3 == 2 && !isViewCreateByAdapter(z1Var)) {
            BaseDraggableModule baseDraggableModule = this.mDraggableModule;
            if (baseDraggableModule != null) {
                baseDraggableModule.onItemDragStart(z1Var);
            }
            z1Var.itemView.setTag(R$id.BaseQuickAdapter_dragging_support, Boolean.TRUE);
            return;
        }
        if (i3 != 1 || isViewCreateByAdapter(z1Var)) {
            return;
        }
        BaseDraggableModule baseDraggableModule2 = this.mDraggableModule;
        if (baseDraggableModule2 != null) {
            baseDraggableModule2.onItemSwipeStart(z1Var);
        }
        z1Var.itemView.setTag(R$id.BaseQuickAdapter_swiping_support, Boolean.TRUE);
    }

    @Override // androidx.recyclerview.widget.g0
    public void onSwiped(z1 z1Var, int i3) {
        BaseDraggableModule baseDraggableModule;
        if (isViewCreateByAdapter(z1Var) || (baseDraggableModule = this.mDraggableModule) == null) {
            return;
        }
        baseDraggableModule.onItemSwiped(z1Var);
    }

    public void setDragMoveFlags(int i3) {
        this.mDragMoveFlags = i3;
    }

    public void setMoveThreshold(float f2) {
        this.mMoveThreshold = f2;
    }

    public void setSwipeMoveFlags(int i3) {
        this.mSwipeMoveFlags = i3;
    }

    public void setSwipeThreshold(float f2) {
        this.mSwipeThreshold = f2;
    }
}
