package com.example.test.ui.device.activity;

import android.view.View;
import com.example.test.ui.XXBaseActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7856a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XXBaseActivity f7857b;

    public /* synthetic */ f(XXBaseActivity xXBaseActivity, int i3) {
        this.f7856a = i3;
        this.f7857b = xXBaseActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        XXBaseActivity xXBaseActivity = this.f7857b;
        switch (this.f7856a) {
            case 0:
                int i3 = ContactActivity.I;
                ContactActivity this$0 = (ContactActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                v2.h hVar = new v2.h(this$0);
                hVar.o("android.permission.READ_CONTACTS");
                hVar.p(new e(this$0));
                break;
            default:
                int i10 = ContactJLActivity.I;
                ContactJLActivity this$02 = (ContactJLActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$02, "this$0");
                v2.h hVar2 = new v2.h(this$02);
                hVar2.o("android.permission.READ_CONTACTS");
                hVar2.p(new h(this$02));
                break;
        }
    }
}
