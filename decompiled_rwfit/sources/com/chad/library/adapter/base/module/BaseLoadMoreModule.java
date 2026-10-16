package com.chad.library.adapter.base.module;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.i1;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.LoadMoreListenerImp;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.loadmore.BaseLoadMoreView;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public class BaseLoadMoreModule implements LoadMoreListenerImp {
    private final BaseQuickAdapter<?, ?> baseQuickAdapter;
    private boolean enableLoadMoreEndClick;
    private boolean isAutoLoadMore;
    private boolean isEnableLoadMore;
    private boolean isEnableLoadMoreIfNotFullPage;
    private boolean isLoadEndMoreGone;
    private LoadMoreStatus loadMoreStatus;
    private BaseLoadMoreView loadMoreView;
    private OnLoadMoreListener mLoadMoreListener;
    private boolean mNextLoadEnable;
    private int preLoadNumber;

    public BaseLoadMoreModule(BaseQuickAdapter<?, ?> baseQuickAdapter) {
        e.g(baseQuickAdapter, "baseQuickAdapter");
        this.baseQuickAdapter = baseQuickAdapter;
        this.mNextLoadEnable = true;
        this.loadMoreStatus = LoadMoreStatus.Complete;
        this.loadMoreView = LoadMoreModuleConfig.getDefLoadMoreView();
        this.isAutoLoadMore = true;
        this.isEnableLoadMoreIfNotFullPage = true;
        this.preLoadNumber = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTheBiggestNumber(int[] iArr) {
        int i3 = -1;
        if (iArr != null) {
            if (iArr.length == 0) {
                return -1;
            }
            for (int i10 : iArr) {
                if (i10 > i3) {
                    i3 = i10;
                }
            }
        }
        return i3;
    }

    private final void invokeLoadMoreListener() {
        this.loadMoreStatus = LoadMoreStatus.Loading;
        RecyclerView mRecyclerView$com_github_CymChad_brvah = this.baseQuickAdapter.getMRecyclerView$com_github_CymChad_brvah();
        if (mRecyclerView$com_github_CymChad_brvah != null) {
            mRecyclerView$com_github_CymChad_brvah.post(new Runnable() { // from class: com.chad.library.adapter.base.module.BaseLoadMoreModule$invokeLoadMoreListener$$inlined$let$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    OnLoadMoreListener onLoadMoreListener;
                    onLoadMoreListener = BaseLoadMoreModule.this.mLoadMoreListener;
                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLoadMore();
                    }
                }
            });
            return;
        }
        OnLoadMoreListener onLoadMoreListener = this.mLoadMoreListener;
        if (onLoadMoreListener != null) {
            onLoadMoreListener.onLoadMore();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isFullScreen(LinearLayoutManager linearLayoutManager) {
        View S0 = linearLayoutManager.S0(linearLayoutManager.v() - 1, -1, true, false);
        if ((S0 == null ? -1 : i1.K(S0)) + 1 == this.baseQuickAdapter.getItemCount()) {
            View S02 = linearLayoutManager.S0(0, linearLayoutManager.v(), true, false);
            if ((S02 != null ? i1.K(S02) : -1) == 0) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ void loadMoreEnd$default(BaseLoadMoreModule baseLoadMoreModule, boolean z5, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadMoreEnd");
        }
        if ((i3 & 1) != 0) {
            z5 = false;
        }
        baseLoadMoreModule.loadMoreEnd(z5);
    }

    public final void autoLoadMore$com_github_CymChad_brvah(int i3) {
        LoadMoreStatus loadMoreStatus;
        if (this.isAutoLoadMore && hasLoadMoreView() && i3 >= this.baseQuickAdapter.getItemCount() - this.preLoadNumber && (loadMoreStatus = this.loadMoreStatus) == LoadMoreStatus.Complete && loadMoreStatus != LoadMoreStatus.Loading && this.mNextLoadEnable) {
            invokeLoadMoreListener();
        }
    }

    public final void checkDisableLoadMoreIfNotFullPage() {
        final i1 layoutManager;
        if (this.isEnableLoadMoreIfNotFullPage) {
            return;
        }
        this.mNextLoadEnable = false;
        RecyclerView mRecyclerView$com_github_CymChad_brvah = this.baseQuickAdapter.getMRecyclerView$com_github_CymChad_brvah();
        if (mRecyclerView$com_github_CymChad_brvah == null || (layoutManager = mRecyclerView$com_github_CymChad_brvah.getLayoutManager()) == null) {
            return;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            mRecyclerView$com_github_CymChad_brvah.postDelayed(new Runnable() { // from class: com.chad.library.adapter.base.module.BaseLoadMoreModule$checkDisableLoadMoreIfNotFullPage$1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean isFullScreen;
                    isFullScreen = BaseLoadMoreModule.this.isFullScreen((LinearLayoutManager) layoutManager);
                    if (isFullScreen) {
                        BaseLoadMoreModule.this.mNextLoadEnable = true;
                    }
                }
            }, 50L);
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            mRecyclerView$com_github_CymChad_brvah.postDelayed(new Runnable() { // from class: com.chad.library.adapter.base.module.BaseLoadMoreModule$checkDisableLoadMoreIfNotFullPage$2
                @Override // java.lang.Runnable
                public final void run() {
                    int theBiggestNumber;
                    BaseQuickAdapter baseQuickAdapter;
                    i1 i1Var = layoutManager;
                    int[] iArr = new int[((StaggeredGridLayoutManager) i1Var).f2486p];
                    ((StaggeredGridLayoutManager) i1Var).M0(iArr);
                    theBiggestNumber = BaseLoadMoreModule.this.getTheBiggestNumber(iArr);
                    int i3 = theBiggestNumber + 1;
                    baseQuickAdapter = BaseLoadMoreModule.this.baseQuickAdapter;
                    if (i3 != baseQuickAdapter.getItemCount()) {
                        BaseLoadMoreModule.this.mNextLoadEnable = true;
                    }
                }
            }, 50L);
        }
    }

    public final boolean getEnableLoadMoreEndClick() {
        return this.enableLoadMoreEndClick;
    }

    public final LoadMoreStatus getLoadMoreStatus() {
        return this.loadMoreStatus;
    }

    public final BaseLoadMoreView getLoadMoreView() {
        return this.loadMoreView;
    }

    public final int getLoadMoreViewPosition() {
        if (this.baseQuickAdapter.hasEmptyView()) {
            return -1;
        }
        BaseQuickAdapter<?, ?> baseQuickAdapter = this.baseQuickAdapter;
        return baseQuickAdapter.getFooterLayoutCount() + baseQuickAdapter.getData().size() + baseQuickAdapter.getHeaderLayoutCount();
    }

    public final int getPreLoadNumber() {
        return this.preLoadNumber;
    }

    public final boolean hasLoadMoreView() {
        if (this.mLoadMoreListener == null || !this.isEnableLoadMore) {
            return false;
        }
        if (this.loadMoreStatus == LoadMoreStatus.End && this.isLoadEndMoreGone) {
            return false;
        }
        return !this.baseQuickAdapter.getData().isEmpty();
    }

    public final boolean isAutoLoadMore() {
        return this.isAutoLoadMore;
    }

    public final boolean isEnableLoadMore() {
        return this.isEnableLoadMore;
    }

    public final boolean isEnableLoadMoreIfNotFullPage() {
        return this.isEnableLoadMoreIfNotFullPage;
    }

    public final boolean isLoadEndMoreGone() {
        return this.isLoadEndMoreGone;
    }

    public final boolean isLoading() {
        return this.loadMoreStatus == LoadMoreStatus.Loading;
    }

    public final void loadMoreComplete() {
        if (hasLoadMoreView()) {
            this.loadMoreStatus = LoadMoreStatus.Complete;
            this.baseQuickAdapter.notifyItemChanged(getLoadMoreViewPosition());
            checkDisableLoadMoreIfNotFullPage();
        }
    }

    public final void loadMoreEnd() {
        loadMoreEnd$default(this, false, 1, null);
    }

    public final void loadMoreFail() {
        if (hasLoadMoreView()) {
            this.loadMoreStatus = LoadMoreStatus.Fail;
            this.baseQuickAdapter.notifyItemChanged(getLoadMoreViewPosition());
        }
    }

    public final void loadMoreToLoading() {
        LoadMoreStatus loadMoreStatus = this.loadMoreStatus;
        LoadMoreStatus loadMoreStatus2 = LoadMoreStatus.Loading;
        if (loadMoreStatus == loadMoreStatus2) {
            return;
        }
        this.loadMoreStatus = loadMoreStatus2;
        this.baseQuickAdapter.notifyItemChanged(getLoadMoreViewPosition());
        invokeLoadMoreListener();
    }

    public final void reset$com_github_CymChad_brvah() {
        if (this.mLoadMoreListener != null) {
            setEnableLoadMore(true);
            this.loadMoreStatus = LoadMoreStatus.Complete;
        }
    }

    public final void setAutoLoadMore(boolean z5) {
        this.isAutoLoadMore = z5;
    }

    public final void setEnableLoadMore(boolean z5) {
        boolean hasLoadMoreView = hasLoadMoreView();
        this.isEnableLoadMore = z5;
        boolean hasLoadMoreView2 = hasLoadMoreView();
        if (hasLoadMoreView) {
            if (hasLoadMoreView2) {
                return;
            }
            this.baseQuickAdapter.notifyItemRemoved(getLoadMoreViewPosition());
        } else if (hasLoadMoreView2) {
            this.loadMoreStatus = LoadMoreStatus.Complete;
            this.baseQuickAdapter.notifyItemInserted(getLoadMoreViewPosition());
        }
    }

    public final void setEnableLoadMoreEndClick(boolean z5) {
        this.enableLoadMoreEndClick = z5;
    }

    public final void setEnableLoadMoreIfNotFullPage(boolean z5) {
        this.isEnableLoadMoreIfNotFullPage = z5;
    }

    public final void setLoadMoreView(BaseLoadMoreView baseLoadMoreView) {
        e.g(baseLoadMoreView, "<set-?>");
        this.loadMoreView = baseLoadMoreView;
    }

    @Override // com.chad.library.adapter.base.listener.LoadMoreListenerImp
    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.mLoadMoreListener = onLoadMoreListener;
        setEnableLoadMore(true);
    }

    public final void setPreLoadNumber(int i3) {
        if (i3 > 1) {
            this.preLoadNumber = i3;
        }
    }

    public final void setupViewHolder$com_github_CymChad_brvah(BaseViewHolder viewHolder) {
        e.g(viewHolder, "viewHolder");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.module.BaseLoadMoreModule$setupViewHolder$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (BaseLoadMoreModule.this.getLoadMoreStatus() == LoadMoreStatus.Fail) {
                    BaseLoadMoreModule.this.loadMoreToLoading();
                    return;
                }
                if (BaseLoadMoreModule.this.getLoadMoreStatus() == LoadMoreStatus.Complete) {
                    BaseLoadMoreModule.this.loadMoreToLoading();
                } else if (BaseLoadMoreModule.this.getEnableLoadMoreEndClick() && BaseLoadMoreModule.this.getLoadMoreStatus() == LoadMoreStatus.End) {
                    BaseLoadMoreModule.this.loadMoreToLoading();
                }
            }
        });
    }

    public final void loadMoreEnd(boolean z5) {
        if (hasLoadMoreView()) {
            this.isLoadEndMoreGone = z5;
            this.loadMoreStatus = LoadMoreStatus.End;
            if (z5) {
                this.baseQuickAdapter.notifyItemRemoved(getLoadMoreViewPosition());
            } else {
                this.baseQuickAdapter.notifyItemChanged(getLoadMoreViewPosition());
            }
        }
    }
}
