package com.amap.api.maps;

import android.view.View;
import com.amap.api.maps.SwipeDismissTouchListener;
import com.amap.api.maps.WearMapView;

/* loaded from: classes.dex */
public class SwipeDismissCallBack implements SwipeDismissTouchListener.DismissCallbacks {

    /* renamed from: a, reason: collision with root package name */
    SwipeDismissView f5705a;

    public SwipeDismissCallBack(SwipeDismissView swipeDismissView) {
        this.f5705a = swipeDismissView;
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public boolean canDismiss(Object obj) {
        return true;
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public void onDismiss(View view, Object obj) {
        WearMapView.OnDismissCallback onDismissCallback = this.f5705a.onDismissCallback;
        if (onDismissCallback != null) {
            onDismissCallback.onDismiss();
        }
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public void onNotifySwipe() {
        WearMapView.OnDismissCallback onDismissCallback = this.f5705a.onDismissCallback;
        if (onDismissCallback != null) {
            onDismissCallback.onNotifySwipe();
        }
    }
}
