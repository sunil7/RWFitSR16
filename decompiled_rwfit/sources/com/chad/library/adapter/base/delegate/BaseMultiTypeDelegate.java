package com.chad.library.adapter.base.delegate;

import android.util.SparseIntArray;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.List;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public abstract class BaseMultiTypeDelegate<T> {
    private boolean autoMode;
    private SparseIntArray layouts;
    private boolean selfMode;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseMultiTypeDelegate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void checkMode(boolean z5) {
        if (z5) {
            throw new IllegalArgumentException("Don't mess two register mode");
        }
    }

    private final void registerItemType(int i3, int i10) {
        this.layouts.put(i3, i10);
    }

    public final BaseMultiTypeDelegate<T> addItemType(int i3, int i10) {
        this.selfMode = true;
        checkMode(this.autoMode);
        registerItemType(i3, i10);
        return this;
    }

    public final BaseMultiTypeDelegate<T> addItemTypeAutoIncrease(int... layoutResIds) {
        e.g(layoutResIds, "layoutResIds");
        this.autoMode = true;
        checkMode(this.selfMode);
        int length = layoutResIds.length;
        for (int i3 = 0; i3 < length; i3++) {
            registerItemType(i3, layoutResIds[i3]);
        }
        return this;
    }

    public abstract int getItemType(List<? extends T> list, int i3);

    public final int getLayoutId(int i3) {
        int i10 = this.layouts.get(i3);
        if (i10 != 0) {
            return i10;
        }
        throw new IllegalArgumentException(l0.k(i3, "ViewType: ", " found layoutResId，please use registerItemType() first!").toString());
    }

    public BaseMultiTypeDelegate(SparseIntArray layouts) {
        e.g(layouts, "layouts");
        this.layouts = layouts;
    }

    public /* synthetic */ BaseMultiTypeDelegate(SparseIntArray sparseIntArray, int i3, c cVar) {
        this((i3 & 1) != 0 ? new SparseIntArray() : sparseIntArray);
    }
}
