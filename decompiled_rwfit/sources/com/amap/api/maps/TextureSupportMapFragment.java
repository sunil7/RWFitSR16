package com.amap.api.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.amap.api.col.p0003sl.a1;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;

/* loaded from: classes.dex */
public class TextureSupportMapFragment extends Fragment implements BaseMapView {
    private AMap aMap;
    private IMapFragmentDelegate mapFragmentDelegate;

    public static TextureSupportMapFragment newInstance() {
        return newInstance(new AMapOptions());
    }

    @Override // androidx.lifecycle.j
    public w1.b getDefaultViewModelCreationExtras() {
        return w1.a.f19463b;
    }

    public AMap getMap() {
        IMapFragmentDelegate mapFragmentDelegate = getMapFragmentDelegate(getActivity());
        if (mapFragmentDelegate == null) {
            return null;
        }
        try {
            IAMap map = mapFragmentDelegate.getMap();
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

    public IMapFragmentDelegate getMapFragmentDelegate(Context context) {
        IMapFragmentDelegate iMapFragmentDelegate = this.mapFragmentDelegate;
        if (iMapFragmentDelegate == null && iMapFragmentDelegate == null) {
            a1 a1Var = new a1(1);
            this.mapFragmentDelegate = a1Var;
            a1Var.setContext(context);
        }
        return this.mapFragmentDelegate;
    }

    @Override // com.amap.api.maps.BaseMapView
    public void loadWorldVectorMap(boolean z5) {
        try {
            getMapFragmentDelegate(getActivity()).loadWorldVectorMap(z5);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = getArguments();
            } catch (Throwable th2) {
                th2.printStackTrace();
                return null;
            }
        }
        return getMapFragmentDelegate(getActivity()).onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        try {
            getMapFragmentDelegate(getActivity()).onDestroy();
            this.aMap = null;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        try {
            getMapFragmentDelegate(getActivity()).onDestroyView();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        try {
            getMapFragmentDelegate(activity).onInflate(activity, new AMapOptions(), bundle);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        try {
            getMapFragmentDelegate(getActivity()).onLowMemory();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        try {
            getMapFragmentDelegate(getActivity()).onPause();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        try {
            getMapFragmentDelegate(getActivity()).onResume();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        try {
            getMapFragmentDelegate(getActivity()).onSaveInstanceState(bundle);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void setArguments(Bundle bundle) {
        try {
            super.setArguments(bundle);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z5) {
        super.setUserVisibleHint(z5);
        if (z5) {
            getMapFragmentDelegate(getActivity()).setVisibility(0);
        } else {
            getMapFragmentDelegate(getActivity()).setVisibility(8);
        }
    }

    public static TextureSupportMapFragment newInstance(AMapOptions aMapOptions) {
        TextureSupportMapFragment textureSupportMapFragment = new TextureSupportMapFragment();
        Bundle bundle = new Bundle();
        try {
            Parcel obtain = Parcel.obtain();
            aMapOptions.writeToParcel(obtain, 0);
            bundle.putByteArray("MAP_OPTIONS", obtain.marshall());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        textureSupportMapFragment.setArguments(bundle);
        return textureSupportMapFragment;
    }
}
