package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.c;
import androidx.recyclerview.widget.o;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class BrvahAsyncDiffer$submitList$1 implements Runnable {
    final /* synthetic */ Runnable $commitCallback;
    final /* synthetic */ List $newList;
    final /* synthetic */ List $oldList;
    final /* synthetic */ int $runGeneration;
    final /* synthetic */ BrvahAsyncDiffer this$0;

    public BrvahAsyncDiffer$submitList$1(BrvahAsyncDiffer brvahAsyncDiffer, List list, List list2, int i3, Runnable runnable) {
        this.this$0 = brvahAsyncDiffer;
        this.$oldList = list;
        this.$newList = list2;
        this.$runGeneration = i3;
        this.$commitCallback = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Executor executor;
        final o a3 = c.a(new c() { // from class: com.chad.library.adapter.base.diff.BrvahAsyncDiffer$submitList$1$result$1
            @Override // androidx.recyclerview.widget.c
            public boolean areContentsTheSame(int i3, int i10) {
                BrvahAsyncDifferConfig brvahAsyncDifferConfig;
                Object obj = BrvahAsyncDiffer$submitList$1.this.$oldList.get(i3);
                Object obj2 = BrvahAsyncDiffer$submitList$1.this.$newList.get(i10);
                if (obj != null && obj2 != null) {
                    brvahAsyncDifferConfig = BrvahAsyncDiffer$submitList$1.this.this$0.config;
                    return brvahAsyncDifferConfig.getDiffCallback().areContentsTheSame(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new AssertionError();
            }

            @Override // androidx.recyclerview.widget.c
            public boolean areItemsTheSame(int i3, int i10) {
                BrvahAsyncDifferConfig brvahAsyncDifferConfig;
                Object obj = BrvahAsyncDiffer$submitList$1.this.$oldList.get(i3);
                Object obj2 = BrvahAsyncDiffer$submitList$1.this.$newList.get(i10);
                if (obj == null || obj2 == null) {
                    return obj == null && obj2 == null;
                }
                brvahAsyncDifferConfig = BrvahAsyncDiffer$submitList$1.this.this$0.config;
                return brvahAsyncDifferConfig.getDiffCallback().areItemsTheSame(obj, obj2);
            }

            @Override // androidx.recyclerview.widget.c
            public Object getChangePayload(int i3, int i10) {
                BrvahAsyncDifferConfig brvahAsyncDifferConfig;
                Object obj = BrvahAsyncDiffer$submitList$1.this.$oldList.get(i3);
                Object obj2 = BrvahAsyncDiffer$submitList$1.this.$newList.get(i10);
                if (obj == null || obj2 == null) {
                    throw new AssertionError();
                }
                brvahAsyncDifferConfig = BrvahAsyncDiffer$submitList$1.this.this$0.config;
                return brvahAsyncDifferConfig.getDiffCallback().getChangePayload(obj, obj2);
            }

            @Override // androidx.recyclerview.widget.c
            public int getNewListSize() {
                return BrvahAsyncDiffer$submitList$1.this.$newList.size();
            }

            @Override // androidx.recyclerview.widget.c
            public int getOldListSize() {
                return BrvahAsyncDiffer$submitList$1.this.$oldList.size();
            }
        });
        executor = this.this$0.mMainThreadExecutor;
        executor.execute(new Runnable() { // from class: com.chad.library.adapter.base.diff.BrvahAsyncDiffer$submitList$1.1
            @Override // java.lang.Runnable
            public final void run() {
                int i3;
                i3 = BrvahAsyncDiffer$submitList$1.this.this$0.mMaxScheduledGeneration;
                BrvahAsyncDiffer$submitList$1 brvahAsyncDiffer$submitList$1 = BrvahAsyncDiffer$submitList$1.this;
                if (i3 == brvahAsyncDiffer$submitList$1.$runGeneration) {
                    brvahAsyncDiffer$submitList$1.this$0.latchList(brvahAsyncDiffer$submitList$1.$newList, a3, brvahAsyncDiffer$submitList$1.$commitCallback);
                }
            }
        });
    }
}
