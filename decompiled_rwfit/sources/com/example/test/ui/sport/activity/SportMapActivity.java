package com.example.test.ui.sport.activity;

import android.R;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.PolylineOptions;
import com.example.blesdk.bean.function.SportTargetBean;
import com.example.database.table.User;
import com.example.test.R$id;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.service.r0;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.SportDataView;
import com.example.test.utils.y;
import com.google.android.gms.internal.mlkit_vision_barcode.n1;
import com.google.android.gms.internal.mlkit_vision_barcode.v1;
import f6.c2;
import java.util.List;

/* loaded from: classes.dex */
public final class SportMapActivity extends XXBaseActivity<com.example.test.presenter.sport.e, c2> implements p5.a, View.OnClickListener, e6.b {
    public static final /* synthetic */ int H = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportMapActivity$aMap$2
        {
            super(0);
        }

        @Override // oh.a
        public final AMap invoke() {
            SportMapActivity sportMapActivity = SportMapActivity.this;
            int i3 = SportMapActivity.H;
            return ((c2) sportMapActivity.f7247z.getValue()).f12765d.getMap();
        }
    });
    public boolean F = true;
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportMapActivity$sportTargetBean$2
        @Override // oh.a
        public final SportTargetBean invoke() {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null) {
                return kVar.B();
            }
            return null;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.sport.e(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        ConstraintLayout constraintLayout = ((c2) this.f7247z.getValue()).f12762a;
        kotlin.jvm.internal.e.e(constraintLayout, "getRoot(...)");
        return constraintLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        return c2.a(getLayoutInflater());
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        Object obj = r0.M;
        n1.a().k(this);
    }

    @Override // com.example.test.ui.XXBaseActivity, com.example.baselibrary.base.activity.BaseActivity
    public final void L0(Bundle bundle) {
        ((c2) this.f7247z.getValue()).f12765d.onCreate(bundle);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        SportTargetBean sportTargetBean;
        y u10 = y.u();
        eh.b bVar = this.G;
        u10.y(((SportTargetBean) bVar.getValue()) == null || ((sportTargetBean = (SportTargetBean) bVar.getValue()) != null && sportTargetBean.isScreenLight() == 1));
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationType(5);
        myLocationStyle.interval(2000L);
        myLocationStyle.strokeColor(R.color.transparent);
        myLocationStyle.radiusFillColor(R.color.transparent);
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R$mipmap.ic_location_icon));
        R0().setMyLocationStyle(myLocationStyle);
        R0().getUiSettings().setZoomControlsEnabled(false);
        R0().setMyLocationEnabled(true);
        R0().moveCamera(CameraUpdateFactory.zoomTo(19.0f));
        R0().setOnMapTouchListener(new e(this, 0));
        R0().setOnMyLocationChangeListener(new f(this, 0));
        eh.b bVar2 = this.f7247z;
        ((c2) bVar2.getValue()).f12764c.setOnClickListener(this);
        ((c2) bVar2.getValue()).f12763b.setOnClickListener(this);
    }

    public final AMap R0() {
        return (AMap) this.E.getValue();
    }

    @Override // e6.b
    public final void W() {
    }

    @Override // e6.b
    public final void X(long j4, double d5, double d8, long j10, long j11) {
        SportDataView sportDataView = ((c2) this.f7247z.getValue()).e;
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        User d10 = kVar != null ? kVar.d() : null;
        if (d10 != null) {
            if (d10.getMeterUnit() == 0) {
                TextView textView = sportDataView.f8585b;
                if (textView == null) {
                    kotlin.jvm.internal.e.m("distanceTv");
                    throw null;
                }
                android.support.v4.media.session.e.A(new Object[]{Float.valueOf(((int) (((float) (d8 / 1000)) * 100)) / 100.0f)}, 1, "%.2f", textView);
                TextView textView2 = sportDataView.f8584a;
                if (textView2 == null) {
                    kotlin.jvm.internal.e.m("distanceUnitTv");
                    throw null;
                }
                textView2.setText(sportDataView.getContext().getString(R$string.str_km));
                TextView textView3 = sportDataView.f8586c;
                if (textView3 == null) {
                    kotlin.jvm.internal.e.m("currentPaceTv");
                    throw null;
                }
                long j12 = 60;
                android.support.v4.media.session.e.A(new Object[]{Long.valueOf(j10 / j12), Long.valueOf(j10 % j12)}, 2, "%d'%02d''", textView3);
            } else {
                TextView textView4 = sportDataView.f8585b;
                if (textView4 == null) {
                    kotlin.jvm.internal.e.m("distanceTv");
                    throw null;
                }
                android.support.v4.media.session.e.A(new Object[]{Float.valueOf(((int) (v1.b((float) d8) * 100)) / 100.0f)}, 1, "%.2f", textView4);
                TextView textView5 = sportDataView.f8584a;
                if (textView5 == null) {
                    kotlin.jvm.internal.e.m("distanceUnitTv");
                    throw null;
                }
                textView5.setText(sportDataView.getContext().getString(R$string.str_mile));
                TextView textView6 = sportDataView.f8586c;
                if (textView6 == null) {
                    kotlin.jvm.internal.e.m("currentPaceTv");
                    throw null;
                }
                long j13 = 60;
                android.support.v4.media.session.e.A(new Object[]{Long.valueOf(j11 / j13), Long.valueOf(j11 % j13)}, 2, "%d'%02d''", textView6);
            }
        }
        TextView textView7 = sportDataView.f8587d;
        if (textView7 == null) {
            kotlin.jvm.internal.e.m("caloriesTv");
            throw null;
        }
        android.support.v4.media.session.e.A(new Object[]{Float.valueOf(((int) (((float) d5) * 100)) / 100.0f)}, 1, "%.2f", textView7);
        long j14 = 3600;
        long j15 = j4 / j14;
        long j16 = j4 % j14;
        long j17 = 60;
        long j18 = j16 / j17;
        long j19 = j16 % j17;
        TextView textView8 = sportDataView.e;
        if (textView8 != null) {
            android.support.v4.media.session.e.A(new Object[]{Long.valueOf(j15), Long.valueOf(j18), Long.valueOf(j19)}, 3, "%02d:%02d:%02d", textView8);
        } else {
            kotlin.jvm.internal.e.m("totalTimeTv");
            throw null;
        }
    }

    @Override // e6.b
    public final void j(boolean z5) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.mapLocationIv;
        if (valueOf != null && valueOf.intValue() == i3) {
            Object obj = r0.M;
            if (n1.a().h().size() > 0) {
                R0().moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition((LatLng) n1.a().h().get(n1.a().h().size() - 1), 19.0f, 0.0f, 0.0f)));
            }
            R0().moveCamera(CameraUpdateFactory.zoomTo(19.0f));
            this.F = true;
            return;
        }
        int i10 = R$id.mapBackIv;
        if (valueOf != null && valueOf.intValue() == i10) {
            finish();
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        try {
            ((c2) this.f7247z.getValue()).f12765d.onDestroy();
        } catch (Error unused) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportMapActivity", "地图销毁报错");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        ((c2) this.f7247z.getValue()).f12765d.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        ((c2) this.f7247z.getValue()).f12765d.onResume();
        y.u().A();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.e.f(outState, "outState");
        super.onSaveInstanceState(outState);
        ((c2) this.f7247z.getValue()).f12765d.onSaveInstanceState(outState);
    }

    @Override // e6.b
    public final void q0(h6.b bVar) {
    }

    @Override // e6.b
    public final void u(int i3) {
        ((c2) this.f7247z.getValue()).e.setSingle(i3);
    }

    @Override // e6.b
    public final void y(List list) {
        R0().addPolyline(new PolylineOptions().addAll(list).width(10.0f).color(Color.argb(235, 1, 180, 247)));
    }
}
