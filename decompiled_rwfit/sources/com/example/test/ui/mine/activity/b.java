package com.example.test.ui.mine.activity;

import android.content.Intent;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.test.R$id;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.mine.adapter.ImagePickAdapter;
import com.example.test.utils.u0;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements u0, OnItemChildClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8118a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XXBaseActivity f8119b;

    public /* synthetic */ b(XXBaseActivity xXBaseActivity, int i3) {
        this.f8118a = i3;
        this.f8119b = xXBaseActivity;
    }

    @Override // com.example.test.utils.u0
    public void a(int i3) {
        int i10 = AccountValidateActivity.I;
        AccountValidateActivity this$0 = (AccountValidateActivity) this.f8119b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        if (i3 == 0) {
            String string = this$0.getString(R$string.str_user_protocol);
            kotlin.jvm.internal.e.e(string, "getString(...)");
            String str = this$0.E;
            if (str == null) {
                kotlin.jvm.internal.e.m("userPro");
                throw null;
            }
            Intent intent = new Intent(this$0, (Class<?>) WebContentActivity.class);
            intent.putExtra("title", string);
            intent.putExtra("url", str);
            this$0.startActivity(intent);
            return;
        }
        if (i3 != 1) {
            return;
        }
        String string2 = this$0.getString(R$string.str_privacy_policy);
        kotlin.jvm.internal.e.e(string2, "getString(...)");
        String str2 = this$0.F;
        if (str2 == null) {
            kotlin.jvm.internal.e.m("priPro");
            throw null;
        }
        Intent intent2 = new Intent(this$0, (Class<?>) WebContentActivity.class);
        intent2.putExtra("title", string2);
        intent2.putExtra("url", str2);
        this$0.startActivity(intent2);
    }

    @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
        XXBaseActivity xXBaseActivity = this.f8119b;
        switch (this.f8118a) {
            case 1:
                int i10 = FeedBackActivity.G;
                FeedBackActivity this$0 = (FeedBackActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
                kotlin.jvm.internal.e.f(view, "view");
                if (view.getId() == R$id.clearIv) {
                    this$0.R0().remove(i3);
                    eh.b bVar = this$0.F;
                    ((ImagePickAdapter) bVar.getValue()).notifyItemRemoved(i3);
                    if (this$0.R0().size() < 3 && !kotlin.jvm.internal.e.a(this$0.R0().get(this$0.R0().size() - 1), "")) {
                        this$0.R0().add("");
                    }
                    ((ImagePickAdapter) bVar.getValue()).notifyItemRangeChanged(0, this$0.R0().size());
                    break;
                }
                break;
            default:
                int i11 = RingFeedBackActivity.I;
                RingFeedBackActivity this$02 = (RingFeedBackActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$02, "this$0");
                kotlin.jvm.internal.e.f(baseQuickAdapter, "<anonymous parameter 0>");
                kotlin.jvm.internal.e.f(view, "view");
                if (view.getId() == R$id.clearIv) {
                    this$02.R0().remove(i3);
                    eh.b bVar2 = this$02.F;
                    ((ImagePickAdapter) bVar2.getValue()).notifyItemRemoved(i3);
                    if (this$02.R0().size() < 3 && !kotlin.jvm.internal.e.a(this$02.R0().get(this$02.R0().size() - 1), "")) {
                        this$02.R0().add("");
                    }
                    ((ImagePickAdapter) bVar2.getValue()).notifyItemRangeChanged(0, this$02.R0().size());
                    break;
                }
                break;
        }
    }
}
