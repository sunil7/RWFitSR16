package com.chad.library.adapter.base.diff;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.s0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class BrvahAsyncDiffer<T> implements DifferImp<T> {
    private final BaseQuickAdapter<T, ?> adapter;
    private final BrvahAsyncDifferConfig<T> config;
    private final List<ListChangeListener<T>> mListeners;
    private Executor mMainThreadExecutor;
    private int mMaxScheduledGeneration;
    private final s0 mUpdateCallback;
    private final Executor sMainThreadExecutor;

    public static final class MainThreadExecutor implements Executor {
        private final Handler mHandler = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            e.g(command, "command");
            this.mHandler.post(command);
        }

        public final Handler getMHandler() {
            return this.mHandler;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.concurrent.Executor] */
    public BrvahAsyncDiffer(BaseQuickAdapter<T, ?> adapter, BrvahAsyncDifferConfig<T> config) {
        e.g(adapter, "adapter");
        e.g(config, "config");
        this.adapter = adapter;
        this.config = config;
        this.mUpdateCallback = new BrvahListUpdateCallback(adapter);
        MainThreadExecutor mainThreadExecutor = new MainThreadExecutor();
        this.sMainThreadExecutor = mainThreadExecutor;
        ?? mainThreadExecutor2 = config.getMainThreadExecutor();
        this.mMainThreadExecutor = mainThreadExecutor2 != 0 ? mainThreadExecutor2 : mainThreadExecutor;
        this.mListeners = new CopyOnWriteArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void latchList(List<T> list, o oVar, Runnable runnable) {
        List<? extends T> data = this.adapter.getData();
        this.adapter.setData$com_github_CymChad_brvah(list);
        oVar.a(this.mUpdateCallback);
        onCurrentListChanged(data, runnable);
    }

    private final void onCurrentListChanged(List<? extends T> list, Runnable runnable) {
        Iterator<ListChangeListener<T>> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onCurrentListChanged(list, this.adapter.getData());
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public static /* synthetic */ void submitList$default(BrvahAsyncDiffer brvahAsyncDiffer, List list, Runnable runnable, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            runnable = null;
        }
        brvahAsyncDiffer.submitList(list, runnable);
    }

    public final void addData(int i3, T t8) {
        List<? extends T> data = this.adapter.getData();
        this.adapter.getData().add(i3, t8);
        this.mUpdateCallback.onInserted(i3, 1);
        onCurrentListChanged(data, null);
    }

    public final void addList(List<? extends T> list) {
        if (list == null) {
            return;
        }
        List<? extends T> data = this.adapter.getData();
        this.adapter.getData().addAll(list);
        this.mUpdateCallback.onInserted(data.size(), list.size());
        onCurrentListChanged(data, null);
    }

    @Override // com.chad.library.adapter.base.diff.DifferImp
    public void addListListener(ListChangeListener<T> listener) {
        e.g(listener, "listener");
        this.mListeners.add(listener);
    }

    public final void changeData(int i3, T t8, T t10) {
        List<? extends T> data = this.adapter.getData();
        this.adapter.getData().set(i3, t8);
        this.mUpdateCallback.onChanged(i3, 1, t10);
        onCurrentListChanged(data, null);
    }

    public final void clearAllListListener() {
        this.mListeners.clear();
    }

    public final void remove(T t8) {
        List<? extends T> data = this.adapter.getData();
        int indexOf = this.adapter.getData().indexOf(t8);
        if (indexOf == -1) {
            return;
        }
        this.adapter.getData().remove(indexOf);
        this.mUpdateCallback.onRemoved(indexOf, 1);
        onCurrentListChanged(data, null);
    }

    public final void removeAt(int i3) {
        List<? extends T> data = this.adapter.getData();
        this.adapter.getData().remove(i3);
        this.mUpdateCallback.onRemoved(i3, 1);
        onCurrentListChanged(data, null);
    }

    public final void removeListListener(ListChangeListener<T> listener) {
        e.g(listener, "listener");
        this.mListeners.remove(listener);
    }

    public final void submitList(List<T> list) {
        submitList$default(this, list, null, 2, null);
    }

    public final void submitList(List<T> list, Runnable runnable) {
        int i3 = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = i3;
        if (list == this.adapter.getData()) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        List<? extends T> data = this.adapter.getData();
        if (list == null) {
            int size = this.adapter.getData().size();
            this.adapter.setData$com_github_CymChad_brvah(new ArrayList());
            this.mUpdateCallback.onRemoved(0, size);
            onCurrentListChanged(data, runnable);
            return;
        }
        if (!this.adapter.getData().isEmpty()) {
            this.config.getBackgroundThreadExecutor().execute(new BrvahAsyncDiffer$submitList$1(this, data, list, i3, runnable));
            return;
        }
        this.adapter.setData$com_github_CymChad_brvah(list);
        this.mUpdateCallback.onInserted(0, list.size());
        onCurrentListChanged(data, runnable);
    }

    public final void addData(T t8) {
        List<? extends T> data = this.adapter.getData();
        this.adapter.getData().add(t8);
        this.mUpdateCallback.onInserted(data.size(), 1);
        onCurrentListChanged(data, null);
    }
}
