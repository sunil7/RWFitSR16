package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.littlejerk.rvdivider.DividerHelper$DividerType;

/* loaded from: classes.dex */
public abstract class ef {
    public static DividerHelper$DividerType a(RecyclerView recyclerView) {
        androidx.recyclerview.widget.i1 layoutManager = recyclerView.getLayoutManager();
        return layoutManager instanceof GridLayoutManager ? ((GridLayoutManager) layoutManager).f2427p == 1 ? DividerHelper$DividerType.GRID_VERTICAL : DividerHelper$DividerType.GRID_HORIZONTAL : layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).f2427p == 1 ? DividerHelper$DividerType.LINEAR_VERTICAL : DividerHelper$DividerType.LINEAR_HORIZONTAL : layoutManager instanceof StaggeredGridLayoutManager ? ((StaggeredGridLayoutManager) layoutManager).f2489t == 1 ? DividerHelper$DividerType.STAGGERED_GRID_VERTICAL : DividerHelper$DividerType.STAGGERED_GRID_HORIZONTAL : DividerHelper$DividerType.UNKNOWN;
    }
}
