package com.chad.library.adapter.base.provider;

import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;

/* loaded from: classes.dex */
public abstract class BaseNodeProvider extends BaseItemProvider<BaseNode> {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* renamed from: getAdapter, reason: merged with bridge method [inline-methods] */
    public BaseProviderMultiAdapter<BaseNode> getAdapter2() {
        BaseProviderMultiAdapter adapter2 = super.getAdapter2();
        if (!(adapter2 instanceof BaseNodeAdapter)) {
            adapter2 = null;
        }
        return (BaseNodeAdapter) adapter2;
    }
}
