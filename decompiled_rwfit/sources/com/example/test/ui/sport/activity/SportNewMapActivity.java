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
import com.example.blesdk.bean.sync.SportDataPushBean;
import com.example.database.table.User;
import com.example.test.R$id;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.service.s0;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.SportNewDataView;
import com.example.test.utils.y;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.o1;
import com.google.android.gms.internal.mlkit_vision_barcode.v1;
import f6.c2;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class SportNewMapActivity extends XXBaseActivity<com.example.test.presenter.sport.e, c2> implements p5.a, View.OnClickListener, e6.b {
    public static final /* synthetic */ int H = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportNewMapActivity$aMap$2
        {
            super(0);
        }

        @Override // oh.a
        public final AMap invoke() {
            SportNewMapActivity sportNewMapActivity = SportNewMapActivity.this;
            int i3 = SportNewMapActivity.H;
            return ((c2) sportNewMapActivity.f7247z.getValue()).f12765d.getMap();
        }
    });
    public boolean F = true;
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportNewMapActivity$sportTargetBean$2
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
        Object obj = s0.N;
        s0 a3 = o1.a();
        if (a3.g().contains(this)) {
            return;
        }
        a3.g().add(this);
    }

    @Override // com.example.test.ui.XXBaseActivity, com.example.baselibrary.base.activity.BaseActivity
    public final void L0(Bundle bundle) {
        ((c2) this.f7247z.getValue()).f12765d.onCreate(bundle);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        SportTargetBean sportTargetBean;
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((c2) bVar.getValue()).e.setVisibility(8);
        ((c2) bVar.getValue()).f12766f.setVisibility(0);
        y u10 = y.u();
        eh.b bVar2 = this.G;
        u10.y(((SportTargetBean) bVar2.getValue()) == null || ((sportTargetBean = (SportTargetBean) bVar2.getValue()) != null && sportTargetBean.isScreenLight() == 1));
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
        R0().setOnMapTouchListener(new e(this, 1));
        R0().setOnMyLocationChangeListener(new f(this, 1));
        ((c2) bVar.getValue()).f12764c.setOnClickListener(this);
        ((c2) bVar.getValue()).f12763b.setOnClickListener(this);
    }

    public final AMap R0() {
        return (AMap) this.E.getValue();
    }

    @Override // e6.b
    public final void W() {
    }

    @Override // e6.b
    public final void X(long j4, double d5, double d8, long j10, long j11) {
    }

    @Override // e6.b
    public final void j(boolean z5) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.mapLocationIv;
        if (valueOf != null && valueOf.intValue() == i3) {
            Object obj = s0.N;
            if (o1.a().h().size() > 0) {
                R0().moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition((LatLng) o1.a().h().get(o1.a().h().size() - 1), 19.0f, 0.0f, 0.0f)));
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

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSportDataPushEvent(EventBusBeans.SportMapDataPushEvent sportDataPushEvent) {
        Throwable th2;
        kotlin.jvm.internal.e.f(sportDataPushEvent, "sportDataPushEvent");
        SportDataPushBean sportDataPushBean = sportDataPushEvent.getSportDataPushBean();
        SportNewDataView sportNewDataView = ((c2) this.f7247z.getValue()).f12766f;
        long intValue = sportDataPushBean.gettActivityTime().intValue();
        Integer num = sportDataPushBean.gettActivityCalorie();
        kotlin.jvm.internal.e.e(num, "gettActivityCalorie(...)");
        int intValue2 = num.intValue();
        double intValue3 = sportDataPushBean.gettActivityDistance().intValue();
        long intValue4 = sportDataPushBean.gettActivityHr().intValue();
        sportDataPushBean.gettActivitySteps().getClass();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        User d5 = kVar != null ? kVar.d() : null;
        if (d5 != null) {
            if (d5.getMeterUnit() == 0) {
                TextView textView = sportNewDataView.f8590b;
                if (textView == null) {
                    kotlin.jvm.internal.e.m("distanceTv");
                    throw null;
                }
                th2 = null;
                android.support.v4.media.session.e.A(new Object[]{Float.valueOf(((int) (((float) (intValue3 / 1000)) * 100)) / 100.0f)}, 1, "%.2f", textView);
                TextView textView2 = sportNewDataView.f8589a;
                if (textView2 == null) {
                    kotlin.jvm.internal.e.m("distanceUnitTv");
                    throw null;
                }
                textView2.setText(sportNewDataView.getContext().getString(R$string.str_km));
            } else {
                th2 = null;
                TextView textView3 = sportNewDataView.f8590b;
                if (textView3 == null) {
                    kotlin.jvm.internal.e.m("distanceTv");
                    throw null;
                }
                android.support.v4.media.session.e.A(new Object[]{Float.valueOf(((int) (v1.b((float) intValue3) * 100)) / 100.0f)}, 1, "%.2f", textView3);
                TextView textView4 = sportNewDataView.f8589a;
                if (textView4 == null) {
                    kotlin.jvm.internal.e.m("distanceUnitTv");
                    throw null;
                }
                textView4.setText(sportNewDataView.getContext().getString(R$string.str_mile));
            }
            TextView textView5 = sportNewDataView.f8591c;
            if (textView5 == null) {
                kotlin.jvm.internal.e.m("currentPaceTv");
                throw th2;
            }
            textView5.setText(String.valueOf(intValue4));
        } else {
            th2 = null;
        }
        TextView textView6 = sportNewDataView.f8592d;
        if (textView6 == null) {
            kotlin.jvm.internal.e.m("caloriesTv");
            throw th2;
        }
        android.support.v4.media.session.e.A(new Object[]{Float.valueOf(((int) ((intValue2 / 10000.0f) * 10)) / 10.0f)}, 1, "%.1f", textView6);
        long j4 = 3600;
        long j10 = intValue / j4;
        long j11 = intValue % j4;
        long j12 = 60;
        long j13 = j11 / j12;
        long j14 = j11 % j12;
        TextView textView7 = sportNewDataView.e;
        if (textView7 != null) {
            android.support.v4.media.session.e.A(new Object[]{Long.valueOf(j10), Long.valueOf(j13), Long.valueOf(j14)}, 3, "%02d:%02d:%02d", textView7);
        } else {
            kotlin.jvm.internal.e.m("totalTimeTv");
            throw th2;
        }
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSportEvent(EventBusBeans.SyncSportEvent syncEvent) {
        kotlin.jvm.internal.e.f(syncEvent, "syncEvent");
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        new Thread(new androidx.activity.b(this, 20)).start();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        ((com.example.test.presenter.sport.e) I0()).k(0);
        super.onStop();
    }

    @Override // e6.b
    public final void q0(h6.b bVar) {
    }

    @Override // e6.b
    public final void u(int i3) {
        ((c2) this.f7247z.getValue()).f12766f.setSingle(i3);
    }

    @Override // e6.b
    public final void y(List list) {
        R0().addPolyline(new PolylineOptions().addAll(list).width(10.0f).color(Color.argb(235, 1, 180, 247)));
    }
}
