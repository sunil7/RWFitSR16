package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: classes2.dex */
public class a extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private static final String f12003a = "com.tencent.open.c.a";

    /* renamed from: b, reason: collision with root package name */
    private Rect f12004b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f12005c;

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC0018a f12006d;

    /* renamed from: com.tencent.open.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0018a {
        void a();

        void a(int i3);
    }

    public a(Context context) {
        super(context);
        this.f12004b = null;
        this.f12005c = false;
        this.f12006d = null;
        this.f12004b = new Rect();
    }

    public void a(InterfaceC0018a interfaceC0018a) {
        this.f12006d = interfaceC0018a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i3, int i10) {
        int size = View.MeasureSpec.getSize(i10);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f12004b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f12004b.top) - size;
        InterfaceC0018a interfaceC0018a = this.f12006d;
        if (interfaceC0018a != null && size != 0) {
            if (height > 100) {
                interfaceC0018a.a((Math.abs(this.f12004b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0018a.a();
            }
        }
        super.onMeasure(i3, i10);
    }
}
