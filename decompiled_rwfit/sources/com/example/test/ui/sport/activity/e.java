package com.example.test.ui.sport.activity;

import android.view.MotionEvent;
import com.amap.api.maps.AMap;
import com.example.test.ui.XXBaseActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements AMap.OnMapTouchListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8166a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ XXBaseActivity f8167b;

    public /* synthetic */ e(XXBaseActivity xXBaseActivity, int i3) {
        this.f8166a = i3;
        this.f8167b = xXBaseActivity;
    }

    @Override // com.amap.api.maps.AMap.OnMapTouchListener
    public final void onTouch(MotionEvent motionEvent) {
        XXBaseActivity xXBaseActivity = this.f8167b;
        switch (this.f8166a) {
            case 0:
                int i3 = SportMapActivity.H;
                SportMapActivity this$0 = (SportMapActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (this$0.F) {
                    this$0.F = false;
                    break;
                }
                break;
            default:
                int i10 = SportNewMapActivity.H;
                SportNewMapActivity this$02 = (SportNewMapActivity) xXBaseActivity;
                kotlin.jvm.internal.e.f(this$02, "this$0");
                if (this$02.F) {
                    this$02.F = false;
                    break;
                }
                break;
        }
    }
}
