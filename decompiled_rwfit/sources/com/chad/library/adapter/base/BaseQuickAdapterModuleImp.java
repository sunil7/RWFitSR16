package com.chad.library.adapter.base;

import com.chad.library.adapter.base.module.BaseDraggableModule;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.chad.library.adapter.base.module.BaseUpFetchModule;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
interface BaseQuickAdapterModuleImp {

    public static final class DefaultImpls {
        public static BaseDraggableModule addDraggableModule(BaseQuickAdapterModuleImp baseQuickAdapterModuleImp, BaseQuickAdapter<?, ?> baseQuickAdapter) {
            e.g(baseQuickAdapter, "baseQuickAdapter");
            return new BaseDraggableModule(baseQuickAdapter);
        }

        public static BaseLoadMoreModule addLoadMoreModule(BaseQuickAdapterModuleImp baseQuickAdapterModuleImp, BaseQuickAdapter<?, ?> baseQuickAdapter) {
            e.g(baseQuickAdapter, "baseQuickAdapter");
            return new BaseLoadMoreModule(baseQuickAdapter);
        }

        public static BaseUpFetchModule addUpFetchModule(BaseQuickAdapterModuleImp baseQuickAdapterModuleImp, BaseQuickAdapter<?, ?> baseQuickAdapter) {
            e.g(baseQuickAdapter, "baseQuickAdapter");
            return new BaseUpFetchModule(baseQuickAdapter);
        }
    }

    BaseDraggableModule addDraggableModule(BaseQuickAdapter<?, ?> baseQuickAdapter);

    BaseLoadMoreModule addLoadMoreModule(BaseQuickAdapter<?, ?> baseQuickAdapter);

    BaseUpFetchModule addUpFetchModule(BaseQuickAdapter<?, ?> baseQuickAdapter);
}
