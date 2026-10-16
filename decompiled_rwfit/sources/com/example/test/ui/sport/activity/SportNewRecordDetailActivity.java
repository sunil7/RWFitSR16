package com.example.test.ui.sport.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.os.Message;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.MyLocationStyle;
import com.example.blesdk.bean.function.DialInfoBean;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.MyMarkerView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis$XAxisPosition;
import com.github.mikephil.charting.components.YAxis$YAxisLabelPosition;
import com.github.mikephil.charting.data.Entry;
import com.google.android.gms.internal.mlkit_vision_barcode.aa;
import com.google.android.gms.internal.mlkit_vision_barcode.c2;
import f6.f2;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class SportNewRecordDetailActivity extends XXBaseActivity<com.example.test.presenter.sport.o, f2> implements i7.e, View.OnClickListener, AMap.OnMapScreenShotListener, t7.d, o5.a {
    public static final /* synthetic */ int M = 0;
    public AMap F;
    public h6.b G;
    public boolean J;
    public boolean L;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportNewRecordDetailActivity$weakHandler$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.baselibrary.utils.e invoke() {
            return new com.example.baselibrary.utils.e(SportNewRecordDetailActivity.this);
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportNewRecordDetailActivity$sportId$2
        {
            super(0);
        }

        @Override // oh.a
        public final Long invoke() {
            Intent intent = SportNewRecordDetailActivity.this.getIntent();
            return Long.valueOf(intent != null ? intent.getLongExtra("sport_id", 0L) : 0L);
        }
    });
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportNewRecordDetailActivity$sportStatus$2
        {
            super(0);
        }

        @Override // oh.a
        public final Boolean invoke() {
            Intent intent = SportNewRecordDetailActivity.this.getIntent();
            return Boolean.valueOf(intent != null ? intent.getBooleanExtra("sport_status", false) : false);
        }
    });
    public final eh.b K = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.sport.activity.SportNewRecordDetailActivity$syncDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.h invoke() {
            SportNewRecordDetailActivity sportNewRecordDetailActivity = SportNewRecordDetailActivity.this;
            sportNewRecordDetailActivity.getClass();
            com.example.test.ui.dialog.h hVar = new com.example.test.ui.dialog.h(sportNewRecordDetailActivity);
            hVar.setCancelable(false);
            return hVar;
        }
    });

    @Override // t7.d
    public final void A() {
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.sport.o(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f2) this.f7247z.getValue()).f12854a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        return f2.a(getLayoutInflater());
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((com.example.test.presenter.sport.o) I0()).k(((Number) this.H.getValue()).longValue());
    }

    @Override // com.example.test.ui.XXBaseActivity, com.example.baselibrary.base.activity.BaseActivity
    public final void L0(Bundle bundle) {
        ((f2) this.f7247z.getValue()).f12866n.onCreate(bundle);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((f2) bVar.getValue()).f12877z.setOnTitleListener(new m(this, 0));
        this.F = ((f2) bVar.getValue()).f12866n.getMap();
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.interval(2000L);
        myLocationStyle.strokeColor(R.color.transparent);
        myLocationStyle.radiusFillColor(R.color.transparent);
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R$mipmap.ic_location_icon));
        AMap aMap = this.F;
        UiSettings uiSettings = aMap != null ? aMap.getUiSettings() : null;
        if (uiSettings != null) {
            uiSettings.setZoomControlsEnabled(false);
        }
        AMap aMap2 = this.F;
        if (aMap2 != null) {
            aMap2.moveCamera(CameraUpdateFactory.zoomTo(16.0f));
        }
        ((f2) bVar.getValue()).f12865m.setScrollView(((f2) bVar.getValue()).f12858f);
        LineChart lineChart = ((f2) bVar.getValue()).f12862j;
        lineChart.setOnChartValueSelectedListener(this);
        lineChart.setDrawGridBackground(false);
        lineChart.getDescription().f16406a = false;
        lineChart.setTouchEnabled(true);
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(false);
        lineChart.setPinchZoom(false);
        MyMarkerView myMarkerView = new MyMarkerView(this, R$layout.custom_marker_view);
        myMarkerView.setChartView(((f2) bVar.getValue()).f12862j);
        lineChart.setMarker(myMarkerView);
        lineChart.getXAxis().I = XAxis$XAxisPosition.BOTTOM;
        lineChart.getXAxis().g();
        lineChart.getXAxis().e = -16777216;
        lineChart.getAxisLeft().getClass();
        lineChart.getAxisLeft().f(0.0f);
        lineChart.getAxisRight().f16406a = false;
        lineChart.getAxisLeft().h(6, false);
        lineChart.getAxisLeft().e = -16777216;
        lineChart.getAxisLeft().J = YAxis$YAxisLabelPosition.OUTSIDE_CHART;
        lineChart.getAxisLeft().B = 30.0f;
        lineChart.setNoDataText(getString(R$string.str_no_data));
        lineChart.setNoDataTextColor(-16777216);
        lineChart.getLegend().f16406a = false;
        lineChart.d(1000);
        lineChart.invalidate();
    }

    public final com.example.test.ui.dialog.h R0() {
        return (com.example.test.ui.dialog.h) this.K.getValue();
    }

    public final void S0() {
        com.example.baselibrary.utils.b.x("", new oh.l() { // from class: com.example.test.ui.sport.activity.SportNewRecordDetailActivity$onTransferFileFail$1
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return eh.g.f12633a;
            }

            public final void invoke(String it) {
                File[] listFiles;
                kotlin.jvm.internal.e.f(it, "it");
                File file = new File(android.support.v4.media.session.e.j(SportNewRecordDetailActivity.this.getFilesDir(), "/img"));
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        kotlin.jvm.internal.e.c(file2);
                        com.example.baselibrary.utils.b.e(file2);
                    }
                }
            }
        }, new oh.l() { // from class: com.example.test.ui.sport.activity.SportNewRecordDetailActivity$onTransferFileFail$2
            public final void invoke(eh.g it) {
                kotlin.jvm.internal.e.f(it, "it");
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((eh.g) obj);
                return eh.g.f12633a;
            }
        });
        R0().dismiss();
        w0(R$string.str_syncing_fail);
        this.J = false;
    }

    public final void T0() {
        com.example.baselibrary.utils.b.x("", new oh.l() { // from class: com.example.test.ui.sport.activity.SportNewRecordDetailActivity$onTransferFileSuccess$1
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return eh.g.f12633a;
            }

            public final void invoke(String it) {
                File[] listFiles;
                kotlin.jvm.internal.e.f(it, "it");
                File file = new File(android.support.v4.media.session.e.j(SportNewRecordDetailActivity.this.getFilesDir(), "/img"));
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        kotlin.jvm.internal.e.c(file2);
                        com.example.baselibrary.utils.b.e(file2);
                    }
                }
            }
        }, new oh.l() { // from class: com.example.test.ui.sport.activity.SportNewRecordDetailActivity$onTransferFileSuccess$2
            public final void invoke(eh.g it) {
                kotlin.jvm.internal.e.f(it, "it");
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((eh.g) obj);
                return eh.g.f12633a;
            }
        });
        R0().dismiss();
        w0(R$string.str_sync_success);
        this.J = false;
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            view.getId();
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        eh.b bVar = this.f7247z;
        try {
            if (((f2) bVar.getValue()).f12866n.getVisibility() == 0) {
                ((f2) bVar.getValue()).f12866n.onDestroy();
            }
        } catch (Error unused) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportRecordDetailActivity", "地图销毁报错");
        }
    }

    @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
    public final void onMapScreenShot(Bitmap bitmap) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        ((f2) this.f7247z.getValue()).f12866n.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        ((f2) this.f7247z.getValue()).f12866n.onResume();
    }

    @Override // android.app.Activity
    public final void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        kotlin.jvm.internal.e.f(outState, "outState");
        kotlin.jvm.internal.e.f(outPersistentState, "outPersistentState");
        super.onSaveInstanceState(outState, outPersistentState);
        ((f2) this.f7247z.getValue()).f12866n.onSaveInstanceState(outState);
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
        int i3 = message.what;
        if (i3 == 1) {
            this.J = true;
            com.example.baselibrary.utils.b.x("", new oh.l() { // from class: com.example.test.ui.sport.activity.SportNewRecordDetailActivity$onMessage$1
                {
                    super(1);
                }

                @Override // oh.l
                public final Boolean invoke(String it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    SportNewRecordDetailActivity sportNewRecordDetailActivity = SportNewRecordDetailActivity.this;
                    AMap aMap = sportNewRecordDetailActivity.F;
                    if (aMap != null) {
                        aMap.getMapScreenShot(sportNewRecordDetailActivity);
                    }
                    SportNewRecordDetailActivity sportNewRecordDetailActivity2 = SportNewRecordDetailActivity.this;
                    sportNewRecordDetailActivity2.L = false;
                    return Boolean.valueOf(((com.example.baselibrary.utils.e) sportNewRecordDetailActivity2.E.getValue()).sendEmptyMessageDelayed(2, 50000L));
                }
            }, new oh.l() { // from class: com.example.test.ui.sport.activity.SportNewRecordDetailActivity$onMessage$2
                public final void invoke(boolean z5) {
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return eh.g.f12633a;
                }
            });
        } else {
            if (i3 != 2) {
                return;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportRecord", "截图超时");
            b0();
            this.L = true;
            this.J = false;
            w0(R$string.str_map_shot_time_out);
        }
    }

    @Override // t7.d
    public final void x(Entry entry) {
    }

    @Override // com.amap.api.maps.AMap.OnMapScreenShotListener
    public final void onMapScreenShot(Bitmap bitmap, int i3) {
        if (this.L) {
            return;
        }
        ((com.example.baselibrary.utils.e) this.E.getValue()).removeMessages(2);
        if (i3 != 0) {
            if (!this.J) {
                b0();
                if (bitmap != null) {
                    com.example.baselibrary.utils.b.x(bitmap, new oh.l() { // from class: com.example.test.ui.sport.activity.SportNewRecordDetailActivity$onMapScreenShot$2$1
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public final Bitmap invoke(Bitmap it) {
                            kotlin.jvm.internal.e.f(it, "it");
                            SportNewRecordDetailActivity sportNewRecordDetailActivity = SportNewRecordDetailActivity.this;
                            int i10 = SportNewRecordDetailActivity.M;
                            NestedScrollView nestedScrollView = ((f2) sportNewRecordDetailActivity.f7247z.getValue()).f12858f;
                            int childCount = nestedScrollView.getChildCount();
                            int i11 = 0;
                            for (int i12 = 0; i12 < childCount; i12++) {
                                i11 += nestedScrollView.getChildAt(i12).getHeight();
                            }
                            if (i11 <= 0) {
                                return null;
                            }
                            Bitmap createBitmap = Bitmap.createBitmap(nestedScrollView.getWidth(), i11, Bitmap.Config.RGB_565);
                            kotlin.jvm.internal.e.e(createBitmap, "createBitmap(...)");
                            Canvas canvas = new Canvas(createBitmap);
                            nestedScrollView.draw(canvas);
                            canvas.drawBitmap(it, 0.0f, 0.0f, (Paint) null);
                            return createBitmap;
                        }
                    }, new oh.l() { // from class: com.example.test.ui.sport.activity.SportNewRecordDetailActivity$onMapScreenShot$2$2
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((Bitmap) obj);
                            return eh.g.f12633a;
                        }

                        public final void invoke(Bitmap bitmap2) {
                            if (bitmap2 != null) {
                                SportNewRecordDetailActivity sportNewRecordDetailActivity = SportNewRecordDetailActivity.this;
                                Object obj = com.example.test.utils.l.f8733a;
                                aa.a(sportNewRecordDetailActivity, c2.a().b(sportNewRecordDetailActivity, bitmap2, System.currentTimeMillis() + ".jpg"));
                            }
                        }
                    });
                    return;
                }
                return;
            }
            if (bitmap != null) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportRecord", "截图成功");
                com.example.baselibrary.utils.b.x(bitmap, new oh.l() { // from class: com.example.test.ui.sport.activity.SportNewRecordDetailActivity$onMapScreenShot$1$1
                    {
                        super(1);
                    }

                    @Override // oh.l
                    public final String invoke(Bitmap bitmap2) {
                        kotlin.jvm.internal.e.f(bitmap2, "bitmap");
                        if (com.example.test.utils.k.f8731b == null) {
                            synchronized (com.example.test.utils.k.class) {
                                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                            }
                        }
                        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                        DialInfoBean n4 = kVar != null ? kVar.n() : null;
                        Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(bitmap2, (n4 != null ? Float.valueOf(n4.getWidth() * 0.8f) : 192).intValue(), (n4 != null ? Float.valueOf(n4.getHeight() * 0.8f) : 224).intValue(), 2);
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SportRecord", r5.a.d("压缩图片 ", extractThumbnail == null));
                        if (n4 != null && n4.getDialType() == 1) {
                            kotlin.jvm.internal.e.c(extractThumbnail);
                            extractThumbnail = y5.d.b(extractThumbnail);
                        }
                        File file = new File(android.support.v4.media.session.e.j(SportNewRecordDetailActivity.this.getFilesDir(), "/img"));
                        if (!file.exists()) {
                            file.mkdir();
                        }
                        String str = file.getAbsolutePath() + "/img_" + System.currentTimeMillis() + ".img";
                        kotlin.jvm.internal.e.c(extractThumbnail);
                        y5.d.g(extractThumbnail, str);
                        return str;
                    }
                }, new oh.l() { // from class: com.example.test.ui.sport.activity.SportNewRecordDetailActivity$onMapScreenShot$1$2
                    {
                        super(1);
                    }

                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return eh.g.f12633a;
                    }

                    public final void invoke(String path) {
                        kotlin.jvm.internal.e.f(path, "path");
                        SportNewRecordDetailActivity.this.b0();
                        com.example.test.presenter.sport.o oVar = (com.example.test.presenter.sport.o) SportNewRecordDetailActivity.this.I0();
                        oVar.getClass();
                        com.example.test.presenter.sport.n fileTransferCallback = (com.example.test.presenter.sport.n) oVar.f7622c.getValue();
                        kotlin.jvm.internal.e.f(fileTransferCallback, "fileTransferCallback");
                        r5.c h4 = r5.c.h();
                        CopyOnWriteArrayList copyOnWriteArrayList = h4.f18079f;
                        copyOnWriteArrayList.size();
                        if (!h4.k(fileTransferCallback)) {
                            copyOnWriteArrayList.add(new WeakReference(fileTransferCallback));
                        }
                        com.google.android.gms.internal.mlkit_vision_common.p.S(path);
                    }
                });
            }
        }
    }
}
