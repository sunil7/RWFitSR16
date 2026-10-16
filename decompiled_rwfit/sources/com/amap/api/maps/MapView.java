package com.amap.api.maps;

import android.R;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.amap.api.col.p0003sl.a1;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;

/* loaded from: classes.dex */
public class MapView extends FrameLayout implements BaseMapView {
    private AMap aMap;
    private IMapFragmentDelegate mapFragmentDelegate;
    private int visibility;

    public MapView(Context context) {
        super(context);
        this.visibility = 0;
        getMapFragmentDelegate().setContext(context);
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
            this.mapFragmentDelegate = new a1(0);
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
            addView(getMapFragmentDelegate().onCreateView(null, null, bundle), new ViewGroup.LayoutParams(-1, -1));
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void onDestroy() {
        try {
            getMapFragmentDelegate().onDestroy();
            this.aMap = null;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void onLowMemory() {
        try {
            getMapFragmentDelegate().onLowMemory();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
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

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        getMapFragmentDelegate().setVisibility(i3);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.visibility = 0;
        try {
            this.visibility = attributeSet.getAttributeIntValue(R.attr.visibility, 0);
        } catch (Throwable unused) {
        }
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.visibility);
    }

    public MapView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.visibility = 0;
        try {
            this.visibility = attributeSet.getAttributeIntValue(R.attr.visibility, 0);
        } catch (Throwable unused) {
        }
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setVisibility(this.visibility);
    }

    public MapView(Context context, AMapOptions aMapOptions) {
        super(context);
        this.visibility = 0;
        getMapFragmentDelegate().setContext(context);
        getMapFragmentDelegate().setOptions(aMapOptions);
    }
}
