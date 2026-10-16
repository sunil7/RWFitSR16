package com.chad.library.adapter.base.module;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.z1;
import com.chad.library.R$id;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.dragswipe.DragAndSwipeCallback;
import com.chad.library.adapter.base.listener.DraggableListenerImp;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.Collections;
import kotlin.TypeCastException;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public class BaseDraggableModule implements DraggableListenerImp {
    public static final Companion Companion = new Companion(null);
    private static final int NO_TOGGLE_VIEW = 0;
    private final BaseQuickAdapter<?, ?> baseQuickAdapter;
    private boolean isDragEnabled;
    private boolean isDragOnLongPressEnabled;
    private boolean isSwipeEnabled;
    public j0 itemTouchHelper;
    public DragAndSwipeCallback itemTouchHelperCallback;
    private OnItemDragListener mOnItemDragListener;
    private OnItemSwipeListener mOnItemSwipeListener;
    private View.OnLongClickListener mOnToggleViewLongClickListener;
    private View.OnTouchListener mOnToggleViewTouchListener;
    private int toggleViewId;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public BaseDraggableModule(BaseQuickAdapter<?, ?> baseQuickAdapter) {
        e.g(baseQuickAdapter, "baseQuickAdapter");
        this.baseQuickAdapter = baseQuickAdapter;
        initItemTouch();
        this.isDragOnLongPressEnabled = true;
    }

    private final boolean inRange(int i3) {
        return i3 >= 0 && i3 < this.baseQuickAdapter.getData().size();
    }

    private final void initItemTouch() {
        DragAndSwipeCallback dragAndSwipeCallback = new DragAndSwipeCallback(this);
        this.itemTouchHelperCallback = dragAndSwipeCallback;
        this.itemTouchHelper = new j0(dragAndSwipeCallback);
    }

    public final void attachToRecyclerView(RecyclerView recyclerView) {
        e.g(recyclerView, "recyclerView");
        j0 j0Var = this.itemTouchHelper;
        if (j0Var != null) {
            j0Var.h(recyclerView);
        } else {
            e.m("itemTouchHelper");
            throw null;
        }
    }

    public final j0 getItemTouchHelper() {
        j0 j0Var = this.itemTouchHelper;
        if (j0Var != null) {
            return j0Var;
        }
        e.m("itemTouchHelper");
        throw null;
    }

    public final DragAndSwipeCallback getItemTouchHelperCallback() {
        DragAndSwipeCallback dragAndSwipeCallback = this.itemTouchHelperCallback;
        if (dragAndSwipeCallback != null) {
            return dragAndSwipeCallback;
        }
        e.m("itemTouchHelperCallback");
        throw null;
    }

    public final OnItemDragListener getMOnItemDragListener() {
        return this.mOnItemDragListener;
    }

    public final OnItemSwipeListener getMOnItemSwipeListener() {
        return this.mOnItemSwipeListener;
    }

    public final View.OnLongClickListener getMOnToggleViewLongClickListener() {
        return this.mOnToggleViewLongClickListener;
    }

    public final View.OnTouchListener getMOnToggleViewTouchListener() {
        return this.mOnToggleViewTouchListener;
    }

    public final int getToggleViewId() {
        return this.toggleViewId;
    }

    public final int getViewHolderPosition(z1 viewHolder) {
        e.g(viewHolder, "viewHolder");
        return viewHolder.getAdapterPosition() - this.baseQuickAdapter.getHeaderLayoutCount();
    }

    public boolean hasToggleView() {
        return this.toggleViewId != 0;
    }

    public final void initView$com_github_CymChad_brvah(BaseViewHolder holder) {
        View findViewById;
        e.g(holder, "holder");
        if (this.isDragEnabled && hasToggleView() && (findViewById = holder.itemView.findViewById(this.toggleViewId)) != null) {
            findViewById.setTag(R$id.BaseQuickAdapter_viewholder_support, holder);
            if (isDragOnLongPressEnabled()) {
                findViewById.setOnLongClickListener(this.mOnToggleViewLongClickListener);
            } else {
                findViewById.setOnTouchListener(this.mOnToggleViewTouchListener);
            }
        }
    }

    public final boolean isDragEnabled() {
        return this.isDragEnabled;
    }

    public boolean isDragOnLongPressEnabled() {
        return this.isDragOnLongPressEnabled;
    }

    public final boolean isSwipeEnabled() {
        return this.isSwipeEnabled;
    }

    public void onItemDragEnd(z1 viewHolder) {
        e.g(viewHolder, "viewHolder");
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener != null) {
            onItemDragListener.onItemDragEnd(viewHolder, getViewHolderPosition(viewHolder));
        }
    }

    public void onItemDragMoving(z1 source, z1 target) {
        e.g(source, "source");
        e.g(target, "target");
        int viewHolderPosition = getViewHolderPosition(source);
        int viewHolderPosition2 = getViewHolderPosition(target);
        if (inRange(viewHolderPosition) && inRange(viewHolderPosition2)) {
            if (viewHolderPosition < viewHolderPosition2) {
                int i3 = viewHolderPosition;
                while (i3 < viewHolderPosition2) {
                    int i10 = i3 + 1;
                    Collections.swap(this.baseQuickAdapter.getData(), i3, i10);
                    i3 = i10;
                }
            } else {
                int i11 = viewHolderPosition2 + 1;
                if (viewHolderPosition >= i11) {
                    int i12 = viewHolderPosition;
                    while (true) {
                        Collections.swap(this.baseQuickAdapter.getData(), i12, i12 - 1);
                        if (i12 == i11) {
                            break;
                        } else {
                            i12--;
                        }
                    }
                }
            }
            this.baseQuickAdapter.notifyItemMoved(source.getAdapterPosition(), target.getAdapterPosition());
        }
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener != null) {
            onItemDragListener.onItemDragMoving(source, viewHolderPosition, target, viewHolderPosition2);
        }
    }

    public void onItemDragStart(z1 viewHolder) {
        e.g(viewHolder, "viewHolder");
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener != null) {
            onItemDragListener.onItemDragStart(viewHolder, getViewHolderPosition(viewHolder));
        }
    }

    public void onItemSwipeClear(z1 viewHolder) {
        OnItemSwipeListener onItemSwipeListener;
        e.g(viewHolder, "viewHolder");
        if (!this.isSwipeEnabled || (onItemSwipeListener = this.mOnItemSwipeListener) == null) {
            return;
        }
        onItemSwipeListener.clearView(viewHolder, getViewHolderPosition(viewHolder));
    }

    public void onItemSwipeStart(z1 viewHolder) {
        OnItemSwipeListener onItemSwipeListener;
        e.g(viewHolder, "viewHolder");
        if (!this.isSwipeEnabled || (onItemSwipeListener = this.mOnItemSwipeListener) == null) {
            return;
        }
        onItemSwipeListener.onItemSwipeStart(viewHolder, getViewHolderPosition(viewHolder));
    }

    public void onItemSwiped(z1 viewHolder) {
        OnItemSwipeListener onItemSwipeListener;
        e.g(viewHolder, "viewHolder");
        int viewHolderPosition = getViewHolderPosition(viewHolder);
        if (inRange(viewHolderPosition)) {
            this.baseQuickAdapter.getData().remove(viewHolderPosition);
            this.baseQuickAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            if (!this.isSwipeEnabled || (onItemSwipeListener = this.mOnItemSwipeListener) == null) {
                return;
            }
            onItemSwipeListener.onItemSwiped(viewHolder, viewHolderPosition);
        }
    }

    public void onItemSwiping(Canvas canvas, z1 z1Var, float f2, float f10, boolean z5) {
        OnItemSwipeListener onItemSwipeListener;
        if (!this.isSwipeEnabled || (onItemSwipeListener = this.mOnItemSwipeListener) == null) {
            return;
        }
        onItemSwipeListener.onItemSwipeMoving(canvas, z1Var, f2, f10, z5);
    }

    public final void setDragEnabled(boolean z5) {
        this.isDragEnabled = z5;
    }

    public void setDragOnLongPressEnabled(boolean z5) {
        this.isDragOnLongPressEnabled = z5;
        if (z5) {
            this.mOnToggleViewTouchListener = null;
            this.mOnToggleViewLongClickListener = new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.module.BaseDraggableModule$isDragOnLongPressEnabled$1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    if (!BaseDraggableModule.this.isDragEnabled()) {
                        return true;
                    }
                    j0 itemTouchHelper = BaseDraggableModule.this.getItemTouchHelper();
                    Object tag = view.getTag(R$id.BaseQuickAdapter_viewholder_support);
                    if (tag == null) {
                        throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.ViewHolder");
                    }
                    itemTouchHelper.s((z1) tag);
                    return true;
                }
            };
        } else {
            this.mOnToggleViewTouchListener = new View.OnTouchListener() { // from class: com.chad.library.adapter.base.module.BaseDraggableModule$isDragOnLongPressEnabled$2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent event) {
                    e.b(event, "event");
                    if (event.getAction() != 0 || BaseDraggableModule.this.isDragOnLongPressEnabled()) {
                        return false;
                    }
                    if (!BaseDraggableModule.this.isDragEnabled()) {
                        return true;
                    }
                    j0 itemTouchHelper = BaseDraggableModule.this.getItemTouchHelper();
                    Object tag = view.getTag(R$id.BaseQuickAdapter_viewholder_support);
                    if (tag == null) {
                        throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.ViewHolder");
                    }
                    itemTouchHelper.s((z1) tag);
                    return true;
                }
            };
            this.mOnToggleViewLongClickListener = null;
        }
    }

    public final void setItemTouchHelper(j0 j0Var) {
        e.g(j0Var, "<set-?>");
        this.itemTouchHelper = j0Var;
    }

    public final void setItemTouchHelperCallback(DragAndSwipeCallback dragAndSwipeCallback) {
        e.g(dragAndSwipeCallback, "<set-?>");
        this.itemTouchHelperCallback = dragAndSwipeCallback;
    }

    public final void setMOnItemDragListener(OnItemDragListener onItemDragListener) {
        this.mOnItemDragListener = onItemDragListener;
    }

    public final void setMOnItemSwipeListener(OnItemSwipeListener onItemSwipeListener) {
        this.mOnItemSwipeListener = onItemSwipeListener;
    }

    public final void setMOnToggleViewLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnToggleViewLongClickListener = onLongClickListener;
    }

    public final void setMOnToggleViewTouchListener(View.OnTouchListener onTouchListener) {
        this.mOnToggleViewTouchListener = onTouchListener;
    }

    @Override // com.chad.library.adapter.base.listener.DraggableListenerImp
    public void setOnItemDragListener(OnItemDragListener onItemDragListener) {
        this.mOnItemDragListener = onItemDragListener;
    }

    @Override // com.chad.library.adapter.base.listener.DraggableListenerImp
    public void setOnItemSwipeListener(OnItemSwipeListener onItemSwipeListener) {
        this.mOnItemSwipeListener = onItemSwipeListener;
    }

    public final void setSwipeEnabled(boolean z5) {
        this.isSwipeEnabled = z5;
    }

    public final void setToggleViewId(int i3) {
        this.toggleViewId = i3;
    }
}
