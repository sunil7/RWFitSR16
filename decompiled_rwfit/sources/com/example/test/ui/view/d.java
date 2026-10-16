package com.example.test.ui.view;

import android.view.View;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8683a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f8684b;

    public /* synthetic */ d(View.OnClickListener onClickListener, int i3) {
        this.f8683a = i3;
        this.f8684b = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View.OnClickListener onClickListener = this.f8684b;
        switch (this.f8683a) {
            case 0:
                int i3 = DeviceInfoView.f8381k;
                kotlin.jvm.internal.e.f(onClickListener, "$onClickListener");
                onClickListener.onClick(view);
                break;
            case 1:
                int i10 = DeviceRingInfoView.f8391k;
                kotlin.jvm.internal.e.f(onClickListener, "$onClickListener");
                onClickListener.onClick(view);
                break;
            default:
                int i11 = TRingDeviceInfoView.f8602m;
                kotlin.jvm.internal.e.f(onClickListener, "$onClickListener");
                onClickListener.onClick(view);
                break;
        }
    }
}
