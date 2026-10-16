package com.amap.api.maps;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.amap.api.col.p0003sl.a1;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;

@TargetApi(20)
/* loaded from: classes.dex */
public class WearMapView extends ViewGroup implements BaseMapView {
    private static int pointX;
    private static int pointY;
    private final String TAG;
    private AMap aMap;
    private View mMapView;
    private SwipeDismissView mSwipeDismissView;
    private IMapFragmentDelegate mapFragmentDelegate;
    private int visibility;

    public interface OnDismissCallback {
        void onDismiss();

        void onNotifySwipe();
    }

    public WearMapView(Context context) {
        super(context);
        this.TAG = "WearMapView";
        this.visibility = 0;
        getMapFragmentDelegate().setContext(context);
        a(context);
        b(context);
    }

    private void a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            if (defaultDisplay != null) {
                defaultDisplay.getSize(point);
            }
            pointX = point.x;
            pointY = point.y;
        }
    }

    private void b(Context context) {
        this.mSwipeDismissView = new SwipeDismissView(context, this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams((int) ((context.getResources().getDisplayMetrics().density * 30.0f) + 0.5f), pointY);
        this.mSwipeDismissView.setBackgroundColor(Color.argb(0, 0, 0, 0));
        setBackgroundColor(Color.argb(0, 0, 0, 0));
        addView(this.mSwipeDismissView, layoutParams);
    }

    public AMap getMap() {
        try {
            IAMap map = getMapFragmentDelegate().getMap();
            if (map == null) {
                return null;
            }
            if (this.aMap == null) {
                this.aMap = new AMap(map);
            }
            return this.aMap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public IMapFragmentDelegate getMapFragmentDelegate() {
        IMapFragmentDelegate iMapFragmentDelegate = this.mapFragmentDelegate;
        if (iMapFragmentDelegate == null && iMapFragmentDelegate == null) {
            this.mapFragmentDelegate = new a1(1);
        }
        return this.mapFragmentDelegate;
    }

    @Override // com.amap.api.maps.BaseMapView
    public void loadWorldVectorMap(boolean z5) {
        try {
            getMapFragmentDelegate().loadWorldVectorMap(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void onCreate(Bundle bundle) {
        try {
            this.mMapView = getMapFragmentDelegate().onCreateView(null, null, bundle);
            addView(this.mMapView, 0, new ViewGroup.LayoutParams(-1, -1));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void onDestroy() {
        try {
            getMapFragmentDelegate().onDestroy();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void onDismiss() {
        removeAllViews();
    }

    public void onEnterAmbient(Bundle bundle) {
        onResume();
    }

    public void onExitAmbient() {
        onPause();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt == this.mMapView) {
                childAt.layout(0, 0, getWidth(), getHeight());
            } else {
                SwipeDismissView swipeDismissView = this.mSwipeDismissView;
                if (childAt == swipeDismissView) {
                    ViewGroup.LayoutParams layoutParams = swipeDismissView.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(-2, -2);
                    }
                    int i14 = layoutParams.width;
                    int makeMeasureSpec = i14 > 0 ? View.MeasureSpec.makeMeasureSpec(i14, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0);
                    int i15 = layoutParams.height;
                    swipeDismissView.measure(makeMeasureSpec, i15 > 0 ? View.MeasureSpec.makeMeasureSpec(i15, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
                    this.mSwipeDismissView.layout(0, 0, this.mSwipeDismissView.getMeasuredWidth(), i11);
                }
            }
        }
    }

    public final void onLowMemory() {
        try {
            getMapFragmentDelegate().onLowMemory();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i10) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt instanceof SwipeDismissView) {
                SwipeDismissView swipeDismissView = (SwipeDismissView) childAt;
                childAt.measure(swipeDismissView.getLayoutParams().width, swipeDismissView.getLayoutParams().height);
            } else {
                childAt.measure(i3, i10);
            }
        }
        super.onMeasure(i3, i10);
    }

    public final void onPause() {
        try {
            getMapFragmentDelegate().onPause();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void onResume() {
        try {
            getMapFragmentDelegate().onResume();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            getMapFragmentDelegate().onSaveInstanceState(bundle);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // android.view.View
    public void setLayerType(int i3, Paint paint) {
    }

    public void setOnDismissCallbackListener(OnDismissCallback onDismissCallback) {
        SwipeDismissView swipeDismissView = this.mSwipeDismissView;
        if (swipeDismissView != null) {
            swipeDismissView.setCallback(onDismissCallback);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        getMapFragmentDelegate().setVisibility(i3);
    }

    public WearMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "WearMapView";
        this.visibility = 0;
        this.visibility = attributeSet.getAttributeIntValue(R.attr.visibility, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.visibility);
        a(context);
        b(context);
    }

    public WearMapView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.TAG = "WearMapView";
        this.visibility = 0;
        this.visibility = attributeSet.getAttributeIntValue(R.attr.visibility, 0);
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.visibility);
        a(context);
        b(context);
    }

    public WearMapView(Context context, AMapOptions aMapOptions) {
        super(context);
        this.TAG = "WearMapView";
        this.visibility = 0;
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setOptions(aMapOptions);
        a(context);
        b(context);
    }
}
