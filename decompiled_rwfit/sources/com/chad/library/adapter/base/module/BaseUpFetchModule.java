package com.chad.library.adapter.base.module;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnUpFetchListener;
import com.chad.library.adapter.base.listener.UpFetchListenerImp;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public class BaseUpFetchModule implements UpFetchListenerImp {
    private final BaseQuickAdapter<?, ?> baseQuickAdapter;
    private boolean isUpFetchEnable;
    private boolean isUpFetching;
    private OnUpFetchListener mUpFetchListener;
    private int startUpFetchPosition;

    public BaseUpFetchModule(BaseQuickAdapter<?, ?> baseQuickAdapter) {
        e.g(baseQuickAdapter, "baseQuickAdapter");
        this.baseQuickAdapter = baseQuickAdapter;
        this.startUpFetchPosition = 1;
    }

    public final void autoUpFetch$com_github_CymChad_brvah(int i3) {
        OnUpFetchListener onUpFetchListener;
        if (!this.isUpFetchEnable || this.isUpFetching || i3 > this.startUpFetchPosition || (onUpFetchListener = this.mUpFetchListener) == null) {
            return;
        }
        onUpFetchListener.onUpFetch();
    }

    public final int getStartUpFetchPosition() {
        return this.startUpFetchPosition;
    }

    public final boolean isUpFetchEnable() {
        return this.isUpFetchEnable;
    }

    public final boolean isUpFetching() {
        return this.isUpFetching;
    }

    @Override // com.chad.library.adapter.base.listener.UpFetchListenerImp
    public void setOnUpFetchListener(OnUpFetchListener onUpFetchListener) {
        this.mUpFetchListener = onUpFetchListener;
    }

    public final void setStartUpFetchPosition(int i3) {
        this.startUpFetchPosition = i3;
    }

    public final void setUpFetchEnable(boolean z5) {
        this.isUpFetchEnable = z5;
    }

    public final void setUpFetching(boolean z5) {
        this.isUpFetching = z5;
    }
}
