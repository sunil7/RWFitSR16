package com.chad.library.adapter.base;

import android.widget.LinearLayout;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.g;
import uh.d;

/* loaded from: classes.dex */
final /* synthetic */ class BaseQuickAdapter$hasHeaderLayout$1 extends MutablePropertyReference0 {
    public BaseQuickAdapter$hasHeaderLayout$1(BaseQuickAdapter baseQuickAdapter) {
        super(baseQuickAdapter);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0
    public Object get() {
        return BaseQuickAdapter.access$getMHeaderLayout$p((BaseQuickAdapter) this.receiver);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getName() {
        return "mHeaderLayout";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public d getOwner() {
        return g.a(BaseQuickAdapter.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public String getSignature() {
        return "getMHeaderLayout()Landroid/widget/LinearLayout;";
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0
    public void set(Object obj) {
        ((BaseQuickAdapter) this.receiver).mHeaderLayout = (LinearLayout) obj;
    }
}
