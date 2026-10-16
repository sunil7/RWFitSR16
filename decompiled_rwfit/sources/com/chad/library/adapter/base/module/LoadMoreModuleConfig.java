package com.chad.library.adapter.base.module;

import com.chad.library.adapter.base.loadmore.BaseLoadMoreView;
import com.chad.library.adapter.base.loadmore.SimpleLoadMoreView;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class LoadMoreModuleConfig {
    public static final LoadMoreModuleConfig INSTANCE = new LoadMoreModuleConfig();
    private static BaseLoadMoreView defLoadMoreView = new SimpleLoadMoreView();

    private LoadMoreModuleConfig() {
    }

    public static /* synthetic */ void defLoadMoreView$annotations() {
    }

    public static final BaseLoadMoreView getDefLoadMoreView() {
        return defLoadMoreView;
    }

    public static final void setDefLoadMoreView(BaseLoadMoreView baseLoadMoreView) {
        e.g(baseLoadMoreView, "<set-?>");
        defLoadMoreView = baseLoadMoreView;
    }
}
