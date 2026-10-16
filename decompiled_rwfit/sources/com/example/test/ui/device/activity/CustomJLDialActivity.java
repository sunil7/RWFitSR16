package com.example.test.ui.device.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.example.blesdk.bean.function.CustomDialInfoBean;
import com.example.blesdk.bean.function.DialInfoBean;
import com.example.database.table.Devices;
import com.example.network.bean.DeviceModelInfoBean;
import com.example.test.R$dimen;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.adapter.BackgroundAdapter;
import com.example.test.ui.adapter.PlacementAdapter;
import com.example.test.ui.adapter.TextColourAdapter;
import com.example.test.ui.adapter.TextFontAdapter;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.model.dial.BackgroundSelectModel;
import com.example.test.ui.model.dial.ColorSelectModel;
import com.example.test.ui.model.dial.Element;
import com.example.test.ui.model.dial.FontSelectModel;
import com.example.test.ui.model.dial.PlacementSelectModel;
import com.example.test.ui.view.DialLineaLayout;
import com.example.test.ui.view.ProgressButtonView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.e2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class CustomJLDialActivity extends XXBaseActivity<com.example.test.presenter.device.s, f6.u> implements f7.e, View.OnClickListener {
    public static final /* synthetic */ int U = 0;
    public BackgroundSelectModel F;
    public PlacementSelectModel G;
    public FontSelectModel H;
    public HashMap J;
    public boolean K;
    public String E = "";
    public final ArrayList I = new ArrayList();
    public final eh.b L = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.CustomJLDialActivity$mColors$2
        @Override // oh.a
        public final List<ColorSelectModel> invoke() {
            ArrayList arrayList = new ArrayList();
            ArrayList b3 = kotlin.collections.i.b("#de4371", "#de4343", "#de7143", "#dba85c", "#dbcf60", "#b7c96b", "#a8e36d", "#85e36d", "#6de379", "#6de39c", "#6de3c0", "#6de3e3", "#6dc0e3", "#6d9ce3", "#6d79e3", "#856de3", "#a86de3", "#cb6de3", "#e36dd7", "#e36db4", "#ffffff", "#000000");
            int size = b3.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = b3.get(i3);
                i3++;
                ColorSelectModel colorSelectModel = new ColorSelectModel();
                colorSelectModel.setColor((String) obj);
                arrayList.add(colorSelectModel);
            }
            return arrayList;
        }
    });
    public final eh.b M = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.CustomJLDialActivity$mBackgrounds$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<BackgroundSelectModel> invoke() {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BackgroundSelectModel());
            BackgroundSelectModel backgroundSelectModel = new BackgroundSelectModel();
            backgroundSelectModel.setSelected(true);
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            DialInfoBean n4 = kVar != null ? kVar.n() : null;
            kotlin.jvm.internal.e.c(n4);
            if (n4.getDialType() == 1) {
                if (n4.getWidth() == 416) {
                    backgroundSelectModel.setResId(R$mipmap.background_416);
                } else if (n4.getWidth() == 360) {
                    backgroundSelectModel.setResId(R$mipmap.dial_background_300);
                } else {
                    backgroundSelectModel.setResId(R$mipmap.background_466);
                }
            } else if (n4.getHeight() == 296) {
                backgroundSelectModel.setResId(R$mipmap.dial_background296);
            } else if (n4.getHeight() == 320) {
                backgroundSelectModel.setResId(R$mipmap.dial_background320);
            } else {
                backgroundSelectModel.setResId(R$mipmap.background);
            }
            arrayList.add(backgroundSelectModel);
            CustomJLDialActivity.this.F = backgroundSelectModel;
            return arrayList;
        }
    });
    public final eh.b N = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.CustomJLDialActivity$mFonts$2
        {
            super(0);
        }

        @Override // oh.a
        public final List<FontSelectModel> invoke() {
            ArrayList arrayList = new ArrayList();
            ArrayList b3 = kotlin.collections.i.b(109, 110, Integer.valueOf(AMapEngineUtils.ARROW_LINE_INNER_TEXTURE_ID));
            int size = b3.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = b3.get(i3);
                i3++;
                int intValue = ((Number) obj).intValue();
                FontSelectModel fontSelectModel = new FontSelectModel();
                fontSelectModel.setSelected(false);
                fontSelectModel.setFont(intValue);
                fontSelectModel.setColor("#ffffff");
                arrayList.add(fontSelectModel);
            }
            ((FontSelectModel) arrayList.get(0)).setSelected(true);
            CustomJLDialActivity.this.H = (FontSelectModel) arrayList.get(0);
            return arrayList;
        }
    });
    public final eh.b O = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.CustomJLDialActivity$mColourAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final TextColourAdapter invoke() {
            CustomJLDialActivity customJLDialActivity = CustomJLDialActivity.this;
            int i3 = CustomJLDialActivity.U;
            return new TextColourAdapter(R$layout.item_color, customJLDialActivity.V0());
        }
    });
    public final eh.b P = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.CustomJLDialActivity$mBackgroundAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final BackgroundAdapter invoke() {
            CustomJLDialActivity customJLDialActivity = CustomJLDialActivity.this;
            int i3 = CustomJLDialActivity.U;
            return new BackgroundAdapter(R$layout.item_background, customJLDialActivity.U0());
        }
    });
    public final eh.b Q = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.CustomJLDialActivity$mTextFontAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final TextFontAdapter invoke() {
            CustomJLDialActivity customJLDialActivity = CustomJLDialActivity.this;
            int i3 = CustomJLDialActivity.U;
            TextFontAdapter textFontAdapter = new TextFontAdapter(R$layout.item_font, customJLDialActivity.W0());
            textFontAdapter.f7841a = Typeface.createFromAsset(customJLDialActivity.getAssets(), "DMSerifText-Regular.ttf");
            textFontAdapter.f7842b = Typeface.createFromAsset(customJLDialActivity.getAssets(), "Mali-Bold.ttf");
            textFontAdapter.f7843c = Typeface.createFromAsset(customJLDialActivity.getAssets(), "manrope-semibold.otf");
            return textFontAdapter;
        }
    });
    public final eh.b R = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.CustomJLDialActivity$mPlacementAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final PlacementAdapter invoke() {
            return new PlacementAdapter(R$layout.item_placement, CustomJLDialActivity.this.I);
        }
    });
    public final eh.b S = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.CustomJLDialActivity$dialInfoBean$2
        @Override // oh.a
        public final DialInfoBean invoke() {
            return new DialInfoBean();
        }
    });
    public final eh.b T = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.CustomJLDialActivity$deviceModelInfoBean$2
        @Override // oh.a
        public final DeviceModelInfoBean invoke() {
            return new DeviceModelInfoBean();
        }
    });

    public static String S0() {
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        DialInfoBean n4 = kVar != null ? kVar.n() : null;
        kotlin.jvm.internal.e.c(n4);
        return n4.getWidth() >= 460 ? "dial_base_466x466.bin" : n4.getWidth() == 416 ? "dial_base_416.bin" : n4.getWidth() >= 300 ? "dial_base_300.bin" : "dial_base_240x284.bin";
    }

    @Override // f7.e
    public final void E(float f2) {
        String concat = String.format("%s: %d", Arrays.copyOf(new Object[]{getString(R$string.str_installing), Integer.valueOf((int) f2)}, 2)).concat("%");
        eh.b bVar = this.f7247z;
        ((f6.u) bVar.getValue()).f13360f.setProgress(f2);
        ((f6.u) bVar.getValue()).f13360f.setText(concat);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.s(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.u) this.f7247z.getValue()).f13356a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // f7.e
    public final void J(String str) {
        if (str == null || str.length() == 0) {
            str = ((ColorSelectModel) V0().get(V0().size() - 1)).getColor();
            kotlin.jvm.internal.e.c(str);
        }
        this.E = str;
        int i3 = 0;
        int i10 = 0;
        for (Object obj : V0()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.i.f();
                throw null;
            }
            ColorSelectModel colorSelectModel = (ColorSelectModel) obj;
            if (kotlin.jvm.internal.e.a(colorSelectModel.getColor(), this.E)) {
                colorSelectModel.setSelected(true);
                i3 = i10;
            } else {
                colorSelectModel.setSelected(false);
            }
            i10 = i11;
        }
        ((TextColourAdapter) this.O.getValue()).notifyItemRangeChanged(0, V0().size());
        ((f6.u) this.f7247z.getValue()).f13361g.g0(i3);
        Y0(false, false, true);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View a3;
        View inflate = getLayoutInflater().inflate(R$layout.activity_custom_jl_dial, (ViewGroup) null, false);
        int i3 = R$id.background_list;
        RecyclerView recyclerView = (RecyclerView) he.a(i3, inflate);
        if (recyclerView != null) {
            i3 = R$id.content;
            if (((DialLineaLayout) he.a(i3, inflate)) != null && (a3 = he.a((i3 = R$id.line1), inflate)) != null) {
                i3 = R$id.main_dial;
                ImageView imageView = (ImageView) he.a(i3, inflate);
                if (imageView != null) {
                    i3 = R$id.pane;
                    if (((LinearLayout) he.a(i3, inflate)) != null) {
                        i3 = R$id.placement_list;
                        RecyclerView recyclerView2 = (RecyclerView) he.a(i3, inflate);
                        if (recyclerView2 != null) {
                            i3 = R$id.progressBtn;
                            ProgressButtonView progressButtonView = (ProgressButtonView) he.a(i3, inflate);
                            if (progressButtonView != null) {
                                i3 = R$id.text_colour_list;
                                RecyclerView recyclerView3 = (RecyclerView) he.a(i3, inflate);
                                if (recyclerView3 != null) {
                                    i3 = R$id.text_font_list;
                                    RecyclerView recyclerView4 = (RecyclerView) he.a(i3, inflate);
                                    if (recyclerView4 != null) {
                                        i3 = R$id.titleView;
                                        TitleView titleView = (TitleView) he.a(i3, inflate);
                                        if (titleView != null) {
                                            return new f6.u((LinearLayout) inflate, recyclerView, a3, imageView, recyclerView2, progressButtonView, recyclerView3, recyclerView4, titleView);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((com.example.test.presenter.device.s) I0()).z();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        byte[] bArr;
        int i3 = 0;
        byte b3 = 1;
        eh.b bVar = this.f7247z;
        ((f6.u) bVar.getValue()).f13363i.setOnTitleListener(new androidx.appcompat.app.t(this, 15));
        ((f6.u) bVar.getValue()).f13360f.setText(getString(R$string.str_install));
        ((f6.u) bVar.getValue()).f13360f.setEnable(true);
        ((f6.u) bVar.getValue()).f13360f.setOnClickListener(this);
        ((f6.u) bVar.getValue()).f13361g.setLayoutManager(new LinearLayoutManager(0));
        RecyclerView recyclerView = ((f6.u) bVar.getValue()).f13361g;
        eh.b bVar2 = this.O;
        recyclerView.setAdapter((TextColourAdapter) bVar2.getValue());
        ((f6.u) bVar.getValue()).f13361g.setItemAnimator(null);
        ((TextColourAdapter) bVar2.getValue()).setOnItemClickListener(new l(this, 2));
        ((f6.u) bVar.getValue()).f13357b.setLayoutManager(new LinearLayoutManager(0));
        ((f6.u) bVar.getValue()).f13357b.setAdapter(T0());
        ((f6.u) bVar.getValue()).f13357b.setItemAnimator(null);
        T0().setOnItemClickListener(new l(this, i3));
        ((f6.u) bVar.getValue()).e.setLayoutManager(new LinearLayoutManager(0));
        ((f6.u) bVar.getValue()).e.setAdapter(X0());
        ((f6.u) bVar.getValue()).e.setItemAnimator(null);
        X0().setOnItemClickListener(new l(this, 3));
        ((f6.u) bVar.getValue()).f13362h.setLayoutManager(new LinearLayoutManager(0));
        RecyclerView recyclerView2 = ((f6.u) bVar.getValue()).f13362h;
        eh.b bVar3 = this.Q;
        recyclerView2.setAdapter((TextFontAdapter) bVar3.getValue());
        ((f6.u) bVar.getValue()).f13362h.setItemAnimator(null);
        ((TextFontAdapter) bVar3.getValue()).setOnItemClickListener(new l(this, 4));
        Log.e("qob", "initPlacement " + S0() + " " + R0().getWidth());
        int i10 = com.example.test.utils.g.f8727a;
        InputStream open = getAssets().open(S0());
        kotlin.jvm.internal.e.e(open, "open(...)");
        byte[] bArr2 = new byte[2];
        byte[] bArr3 = new byte[4];
        int read = open.read();
        HashMap hashMap = new HashMap();
        int i11 = 0;
        while (i11 < read) {
            int read2 = open.read();
            Element element = new Element();
            Element element2 = new Element();
            element.setType(9);
            element2.setType(10);
            element.setFontType(read2);
            element2.setFontType(read2);
            open.read(bArr2);
            element.setWidth(com.example.test.utils.g.d(bArr2));
            element2.setWidth(com.example.test.utils.g.d(bArr2));
            open.read(bArr2);
            element.setHeight(com.example.test.utils.g.d(bArr2));
            element2.setHeight(com.example.test.utils.g.d(bArr2));
            element.setDataList(new ArrayList());
            element2.setDataList(new ArrayList());
            element.setImageCount((byte) 10);
            element2.setImageCount((byte) 10);
            int i12 = i3;
            while (i12 < 10) {
                open.read(bArr3);
                byte b10 = b3;
                byte[] bArr4 = new byte[(int) com.example.test.utils.g.c(bArr3)];
                open.read(bArr4);
                if (i12 == 0) {
                    element.setRawData(bArr4);
                } else if (i12 == 7) {
                    element2.setRawData(bArr4);
                }
                i12++;
                b3 = b10;
            }
            Element element3 = new Element();
            element3.setType(22);
            element3.setFontType(read2);
            open.read(bArr2);
            element3.setWidth(com.example.test.utils.g.d(bArr2));
            open.read(bArr2);
            element3.setHeight(com.example.test.utils.g.d(bArr2));
            open.read(bArr3);
            int c9 = (int) com.example.test.utils.g.c(bArr3);
            element3.setDataList(new ArrayList());
            element3.setImageCount(b3);
            byte[] bArr5 = new byte[c9];
            open.read(bArr5);
            element3.setRawData(bArr5);
            Element element4 = new Element();
            Element element5 = new Element();
            element4.setType(8);
            element5.setType(7);
            element4.setFontType(read2);
            element5.setFontType(read2);
            open.read(bArr2);
            element4.setWidth(com.example.test.utils.g.d(bArr2));
            element5.setWidth(com.example.test.utils.g.d(bArr2));
            open.read(bArr2);
            element4.setHeight(com.example.test.utils.g.d(bArr2));
            element5.setHeight(com.example.test.utils.g.d(bArr2));
            element4.setDataList(new ArrayList());
            element5.setDataList(new ArrayList());
            element4.setImageCount((byte) 10);
            element5.setImageCount((byte) 10);
            int i13 = 0;
            for (int i14 = 10; i13 < i14; i14 = 10) {
                open.read(bArr3);
                byte[] bArr6 = new byte[(int) com.example.test.utils.g.c(bArr3)];
                open.read(bArr6);
                if (i13 == 0) {
                    element5.setRawData(bArr6);
                } else if (i13 == 7) {
                    element4.setRawData(bArr6);
                }
                i13++;
            }
            Element element6 = new Element();
            element6.setType(22);
            element6.setFontType(read2);
            open.read(bArr2);
            element6.setWidth(com.example.test.utils.g.d(bArr2));
            open.read(bArr2);
            element6.setHeight(com.example.test.utils.g.d(bArr2));
            open.read(bArr3);
            int c10 = (int) com.example.test.utils.g.c(bArr3);
            element6.setDataList(new ArrayList());
            element6.setImageCount((byte) 1);
            byte[] bArr7 = new byte[c10];
            open.read(bArr7);
            element6.setRawData(bArr7);
            Element element7 = new Element();
            element7.setType(13);
            element7.setFontType(read2);
            open.read(bArr2);
            element7.setWidth(com.example.test.utils.g.d(bArr2));
            open.read(bArr2);
            element7.setHeight(com.example.test.utils.g.d(bArr2));
            element7.setDataList(new ArrayList());
            element7.setImageCount((byte) 7);
            int i15 = 0;
            while (i15 < 7) {
                open.read(bArr3);
                int i16 = i15;
                Element element8 = element6;
                byte[] bArr8 = new byte[(int) com.example.test.utils.g.c(bArr3)];
                open.read(bArr8);
                if (i16 == 0) {
                    element7.setRawData(bArr8);
                }
                i15 = i16 + 1;
                element6 = element8;
            }
            Element element9 = element6;
            ArrayList arrayList = new ArrayList();
            int read3 = open.read();
            int i17 = 0;
            while (true) {
                bArr = bArr3;
                if (i17 < read3) {
                    PlacementSelectModel placementSelectModel = new PlacementSelectModel();
                    int i18 = read3;
                    int read4 = open.read();
                    placementSelectModel.setFont(read2);
                    placementSelectModel.setPlacement(read4);
                    placementSelectModel.setHourData(element.getRawData());
                    placementSelectModel.setMinuteData(element2.getRawData());
                    placementSelectModel.setTimeSeparatorData(element3.getRawData());
                    placementSelectModel.setMonthData(element5.getRawData());
                    placementSelectModel.setDateSeparatorData(element9.getRawData());
                    placementSelectModel.setDayData(element4.getRawData());
                    placementSelectModel.setWeekData(element7.getRawData());
                    open.read(bArr2);
                    placementSelectModel.setHourX(com.example.test.utils.g.d(bArr2));
                    open.read(bArr2);
                    placementSelectModel.setHourY(com.example.test.utils.g.d(bArr2));
                    open.read(bArr2);
                    placementSelectModel.setTimeSeparatorX(com.example.test.utils.g.d(bArr2));
                    open.read(bArr2);
                    placementSelectModel.setTimeSeparatorY(com.example.test.utils.g.d(bArr2));
                    open.read(bArr2);
                    placementSelectModel.setMinuteX(com.example.test.utils.g.d(bArr2));
                    open.read(bArr2);
                    placementSelectModel.setMinuteY(com.example.test.utils.g.d(bArr2));
                    open.read(bArr2);
                    placementSelectModel.setDayX(com.example.test.utils.g.d(bArr2));
                    open.read(bArr2);
                    placementSelectModel.setDayY(com.example.test.utils.g.d(bArr2));
                    open.read(bArr2);
                    placementSelectModel.setDateSeparatorX(com.example.test.utils.g.d(bArr2));
                    open.read(bArr2);
                    placementSelectModel.setDateSeparatorY(com.example.test.utils.g.d(bArr2));
                    open.read(bArr2);
                    placementSelectModel.setMonthX(com.example.test.utils.g.d(bArr2));
                    open.read(bArr2);
                    placementSelectModel.setMonthY(com.example.test.utils.g.d(bArr2));
                    open.read(bArr2);
                    placementSelectModel.setWeekX(com.example.test.utils.g.d(bArr2));
                    open.read(bArr2);
                    placementSelectModel.setWeekY(com.example.test.utils.g.d(bArr2));
                    arrayList.add(placementSelectModel);
                    i17++;
                    bArr3 = bArr;
                    read3 = i18;
                }
            }
            hashMap.put(Integer.valueOf(read2), arrayList);
            i11++;
            b3 = 1;
            bArr3 = bArr;
            i3 = 0;
        }
        open.close();
        this.J = hashMap;
        List list = (List) hashMap.get(109);
        if (list != null) {
            this.G = (PlacementSelectModel) list.get(0);
            this.I.addAll(list);
        }
    }

    public final DialInfoBean R0() {
        return (DialInfoBean) this.S.getValue();
    }

    @Override // f7.e
    public final void T(CustomDialInfoBean customDialInfoBean) {
        String color;
        if (customDialInfoBean != null) {
            color = customDialInfoBean.getColor();
            kotlin.jvm.internal.e.c(color);
        } else {
            color = ((ColorSelectModel) V0().get(V0().size() - 1)).getColor();
            kotlin.jvm.internal.e.c(color);
        }
        this.E = color;
        int i3 = 0;
        int i10 = 0;
        for (Object obj : V0()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.i.f();
                throw null;
            }
            ColorSelectModel colorSelectModel = (ColorSelectModel) obj;
            if (kotlin.jvm.internal.e.a(colorSelectModel.getColor(), this.E)) {
                colorSelectModel.setSelected(true);
                i3 = i10;
            } else {
                colorSelectModel.setSelected(false);
            }
            i10 = i11;
        }
        ((TextColourAdapter) this.O.getValue()).notifyItemRangeChanged(0, V0().size());
        ((f6.u) this.f7247z.getValue()).f13361g.g0(i3);
        Y0(false, false, true);
    }

    public final BackgroundAdapter T0() {
        return (BackgroundAdapter) this.P.getValue();
    }

    public final List U0() {
        return (List) this.M.getValue();
    }

    public final List V0() {
        return (List) this.L.getValue();
    }

    public final List W0() {
        return (List) this.N.getValue();
    }

    public final PlacementAdapter X0() {
        return (PlacementAdapter) this.R.getValue();
    }

    public final void Y0(boolean z5, boolean z6, boolean z8) {
        PlacementSelectModel placementSelectModel;
        Object obj;
        List list;
        ArrayList arrayList = this.I;
        if (z5) {
            BackgroundSelectModel backgroundSelectModel = this.F;
            if (backgroundSelectModel == null) {
                kotlin.jvm.internal.e.m("mBackgroundSelectModel");
                throw null;
            }
            int resId = backgroundSelectModel.getResId();
            BackgroundSelectModel backgroundSelectModel2 = this.F;
            if (backgroundSelectModel2 == null) {
                kotlin.jvm.internal.e.m("mBackgroundSelectModel");
                throw null;
            }
            String url = backgroundSelectModel2.getUrl();
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2 = arrayList.get(i3);
                i3++;
                PlacementSelectModel placementSelectModel2 = (PlacementSelectModel) obj2;
                placementSelectModel2.setBackgroundResId(resId);
                placementSelectModel2.setBackgroundUrl(url);
            }
            X0().notifyItemRangeChanged(0, arrayList.size());
        }
        if (z6) {
            FontSelectModel fontSelectModel = this.H;
            if (fontSelectModel == null) {
                kotlin.jvm.internal.e.m("mFontSelectModel");
                throw null;
            }
            int font = fontSelectModel.getFont();
            int size2 = arrayList.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size2) {
                    i10 = 0;
                    break;
                } else if (((PlacementSelectModel) arrayList.get(i10)).isSelected()) {
                    break;
                } else {
                    i10++;
                }
            }
            HashMap hashMap = this.J;
            if (hashMap != null && (list = (List) hashMap.get(Integer.valueOf(font))) != null) {
                arrayList.clear();
                arrayList.addAll(list);
                BackgroundSelectModel backgroundSelectModel3 = this.F;
                if (backgroundSelectModel3 == null) {
                    kotlin.jvm.internal.e.m("mBackgroundSelectModel");
                    throw null;
                }
                int resId2 = backgroundSelectModel3.getResId();
                BackgroundSelectModel backgroundSelectModel4 = this.F;
                if (backgroundSelectModel4 == null) {
                    kotlin.jvm.internal.e.m("mBackgroundSelectModel");
                    throw null;
                }
                String url2 = backgroundSelectModel4.getUrl();
                int size3 = arrayList.size();
                int i11 = 0;
                while (i11 < size3) {
                    Object obj3 = arrayList.get(i11);
                    i11++;
                    PlacementSelectModel placementSelectModel3 = (PlacementSelectModel) obj3;
                    placementSelectModel3.setSelected(false);
                    if (this.E.length() > 0) {
                        placementSelectModel3.setColor(this.E);
                    }
                    placementSelectModel3.setBackgroundResId(resId2);
                    placementSelectModel3.setBackgroundUrl(url2);
                    placementSelectModel3.setDialType(R0().getDialType());
                }
                this.G = (PlacementSelectModel) arrayList.get(i10);
                ((PlacementSelectModel) arrayList.get(i10)).setSelected(true);
                X0().setNewInstance(arrayList);
                X0().notifyDataSetChanged();
            }
        }
        if (z8 && this.E.length() > 0) {
            int size4 = arrayList.size();
            int i12 = 0;
            while (i12 < size4) {
                Object obj4 = arrayList.get(i12);
                i12++;
                ((PlacementSelectModel) obj4).setColor(this.E);
            }
            X0().notifyItemRangeChanged(0, arrayList.size());
            Iterator it = W0().iterator();
            while (it.hasNext()) {
                ((FontSelectModel) it.next()).setColor(this.E);
            }
            ((TextFontAdapter) this.Q.getValue()).notifyItemRangeChanged(0, W0().size());
        }
        HashMap hashMap2 = this.J;
        if (hashMap2 != null) {
            PlacementSelectModel placementSelectModel4 = this.G;
            if (placementSelectModel4 == null) {
                kotlin.jvm.internal.e.m("mPlacementSelectModel");
                throw null;
            }
            List list2 = (List) hashMap2.get(Integer.valueOf(placementSelectModel4.getFont()));
            if (list2 != null) {
                Iterator it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    int placement = ((PlacementSelectModel) obj).getPlacement();
                    PlacementSelectModel placementSelectModel5 = this.G;
                    if (placementSelectModel5 == null) {
                        kotlin.jvm.internal.e.m("mPlacementSelectModel");
                        throw null;
                    }
                    if (placement == placementSelectModel5.getPlacement()) {
                        break;
                    }
                }
                placementSelectModel = (PlacementSelectModel) obj;
            } else {
                placementSelectModel = null;
            }
            if (placementSelectModel != null) {
                PlacementSelectModel placementSelectModel6 = this.G;
                if (placementSelectModel6 == null) {
                    kotlin.jvm.internal.e.m("mPlacementSelectModel");
                    throw null;
                }
                placementSelectModel.setBackgroundUrl(placementSelectModel6.getBackgroundUrl());
                PlacementSelectModel placementSelectModel7 = this.G;
                if (placementSelectModel7 == null) {
                    kotlin.jvm.internal.e.m("mPlacementSelectModel");
                    throw null;
                }
                placementSelectModel.setBackgroundResId(placementSelectModel7.getBackgroundResId());
                PlacementSelectModel placementSelectModel8 = this.G;
                if (placementSelectModel8 == null) {
                    kotlin.jvm.internal.e.m("mPlacementSelectModel");
                    throw null;
                }
                placementSelectModel.setColor(placementSelectModel8.getColor());
                placementSelectModel.setDialType(R0().getDialType());
                Bitmap a3 = e2.a(this, placementSelectModel);
                if (a3 != null) {
                    int dialType = R0().getDialType();
                    z3.h hVar = z3.h.f20239b;
                    eh.b bVar = this.f7247z;
                    if (dialType == 0) {
                        ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(this).l(a3).o(true)).d(hVar)).i(R$drawable.bg_dial_item)).a(p4.e.t(new g4.v(com.example.baselibrary.utils.b.f(this, 8.0f)))).e(R$drawable.bg_dial_item)).x(((f6.u) bVar.getValue()).f13359d);
                    } else {
                        ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(this).l(a3).o(true)).d(hVar)).i(R$drawable.bg_img)).a(p4.e.t(new g4.i())).e(R$drawable.bg_img)).x(((f6.u) bVar.getValue()).f13359d);
                    }
                }
            }
        }
    }

    @Override // f7.e
    public final void a0(int i3) {
        this.K = false;
        com.example.baselibrary.utils.b.x("", new oh.l() { // from class: com.example.test.ui.device.activity.CustomJLDialActivity$onInstallFail$1
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
                File file = new File(android.support.v4.media.session.e.j(CustomJLDialActivity.this.getFilesDir(), "/dial"));
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        kotlin.jvm.internal.e.c(file2);
                        com.example.baselibrary.utils.b.e(file2);
                    }
                }
            }
        }, new oh.l() { // from class: com.example.test.ui.device.activity.CustomJLDialActivity$onInstallFail$2
            public final void invoke(eh.g it) {
                kotlin.jvm.internal.e.f(it, "it");
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((eh.g) obj);
                return eh.g.f12633a;
            }
        });
        com.example.test.utils.y.u().G();
        b0();
        w0(R$string.str_save_fail);
        eh.b bVar = this.f7247z;
        ((f6.u) bVar.getValue()).f13360f.setEnable(true);
        ((f6.u) bVar.getValue()).f13360f.setText(getString(R$string.str_reinstall));
    }

    @Override // p5.a
    public final Context f0() {
        return this;
    }

    @Override // f7.e
    public final void j0(DeviceModelInfoBean deviceModelInfoBean) {
        Devices c9;
        if (deviceModelInfoBean != null) {
            ((DeviceModelInfoBean) this.T.getValue()).setDefaultCustomizeDialUrl(deviceModelInfoBean.getDefaultCustomizeDialUrl());
            ((DeviceModelInfoBean) this.T.getValue()).setCustomizeDialShowUrl(deviceModelInfoBean.getCustomizeDialShowUrl());
        }
        ((com.example.test.presenter.device.s) I0()).x();
        com.example.test.presenter.device.s sVar = (com.example.test.presenter.device.s) I0();
        sVar.getClass();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        String str = null;
        if (kVar != null && (c9 = kVar.c()) != null) {
            str = (String) kVar.i(c9.getMacAddress() + "custom_dial_color", String.class);
        }
        ((f7.e) sVar.f7255a).J(str);
    }

    @Override // f7.e
    public final void k0(String str) {
        if (str == null || str.length() == 0 || !new File(str).exists()) {
            return;
        }
        BackgroundSelectModel backgroundSelectModel = new BackgroundSelectModel();
        backgroundSelectModel.setSelected(true);
        backgroundSelectModel.setUrl(str);
        backgroundSelectModel.setDialType(R0().getDialType());
        U0().add(1, backgroundSelectModel);
        this.F = backgroundSelectModel;
        Y0(true, false, false);
    }

    @Override // f7.e
    public final void n0(DialInfoBean dialInfoBean) {
        R0().setDialType(dialInfoBean.getDialType());
        R0().setWidth(dialInfoBean.getWidth());
        R0().setHeight(dialInfoBean.getHeight());
        int dialType = dialInfoBean.getDialType();
        ArrayList arrayList = this.I;
        eh.b bVar = this.f7247z;
        if (dialType == 1) {
            int dimension = (int) getResources().getDimension(R$dimen.qb_px_190);
            int dimension2 = (int) getResources().getDimension(R$dimen.qb_px_190);
            ViewGroup.LayoutParams layoutParams = ((f6.u) bVar.getValue()).f13359d.getLayoutParams();
            layoutParams.width = dimension;
            layoutParams.height = dimension2;
            ((f6.u) bVar.getValue()).f13359d.setLayoutParams(layoutParams);
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ((PlacementSelectModel) obj).setDialType(dialInfoBean.getDialType());
            }
            Iterator it = U0().iterator();
            while (it.hasNext()) {
                ((BackgroundSelectModel) it.next()).setDialType(dialInfoBean.getDialType());
            }
            T0().notifyItemRangeChanged(0, U0().size());
            Y0(true, true, true);
        } else {
            int dimension3 = (int) getResources().getDimension(R$dimen.qb_px_160);
            int dimension4 = (int) getResources().getDimension(R$dimen.qb_px_190);
            ViewGroup.LayoutParams layoutParams2 = ((f6.u) bVar.getValue()).f13359d.getLayoutParams();
            layoutParams2.width = dimension3;
            layoutParams2.height = dimension4;
            ((f6.u) bVar.getValue()).f13359d.setLayoutParams(layoutParams2);
            int size2 = arrayList.size();
            int i10 = 0;
            while (i10 < size2) {
                Object obj2 = arrayList.get(i10);
                i10++;
                ((PlacementSelectModel) obj2).setDialType(dialInfoBean.getDialType());
            }
            Iterator it2 = U0().iterator();
            while (it2.hasNext()) {
                ((BackgroundSelectModel) it2.next()).setDialType(dialInfoBean.getDialType());
            }
            T0().notifyItemRangeChanged(0, U0().size());
            Y0(true, true, true);
        }
        ((com.example.test.presenter.device.s) I0()).y();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.K) {
            com.example.baselibrary.utils.d.a(R$string.str_installing);
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v6) {
        kotlin.jvm.internal.e.f(v6, "v");
        if (!this.K && v6.getId() == R$id.progressBtn) {
            this.K = true;
            com.example.test.utils.y.u().y(true);
            com.example.test.utils.y.u().A();
            File file = new File(android.support.v4.media.session.e.j(getFilesDir(), "/dial"));
            if (!file.exists()) {
                file.mkdir();
            }
            String S0 = S0();
            String dialFilePath = android.support.v4.media.session.e.l(file.getAbsolutePath(), "/dial_20241016.bin");
            if (S0.equals("dial_base_240x284.bin")) {
                int i3 = com.example.test.utils.g.f8727a;
                PlacementSelectModel placementSelectModel = this.G;
                if (placementSelectModel == null) {
                    kotlin.jvm.internal.e.m("mPlacementSelectModel");
                    throw null;
                }
                String backgroundUrl = placementSelectModel.getBackgroundUrl();
                PlacementSelectModel placementSelectModel2 = this.G;
                if (placementSelectModel2 == null) {
                    kotlin.jvm.internal.e.m("mPlacementSelectModel");
                    throw null;
                }
                int placement = placementSelectModel2.getPlacement();
                PlacementSelectModel placementSelectModel3 = this.G;
                if (placementSelectModel3 == null) {
                    kotlin.jvm.internal.e.m("mPlacementSelectModel");
                    throw null;
                }
                int font = placementSelectModel3.getFont();
                String color = this.E;
                ef.i iVar = new ef.i(9, this, dialFilePath);
                kotlin.jvm.internal.e.f(dialFilePath, "dialFilePath");
                kotlin.jvm.internal.e.f(color, "color");
                com.example.test.utils.g.f8727a = Color.parseColor(color);
                com.example.test.utils.g.f(this, S0, placement, font, new androidx.camera.core.impl.e(this, backgroundUrl, color, iVar, dialFilePath, 4));
                return;
            }
            int i10 = com.example.test.utils.g.f8727a;
            PlacementSelectModel placementSelectModel4 = this.G;
            if (placementSelectModel4 == null) {
                kotlin.jvm.internal.e.m("mPlacementSelectModel");
                throw null;
            }
            String backgroundUrl2 = placementSelectModel4.getBackgroundUrl();
            PlacementSelectModel placementSelectModel5 = this.G;
            if (placementSelectModel5 == null) {
                kotlin.jvm.internal.e.m("mPlacementSelectModel");
                throw null;
            }
            int placement2 = placementSelectModel5.getPlacement();
            PlacementSelectModel placementSelectModel6 = this.G;
            if (placementSelectModel6 == null) {
                kotlin.jvm.internal.e.m("mPlacementSelectModel");
                throw null;
            }
            int font2 = placementSelectModel6.getFont();
            String color2 = this.E;
            com.example.test.utils.y yVar = new com.example.test.utils.y(this, 10, dialFilePath, false);
            kotlin.jvm.internal.e.f(dialFilePath, "dialFilePath");
            kotlin.jvm.internal.e.f(color2, "color");
            com.example.test.utils.g.f8727a = Color.parseColor(color2);
            com.example.test.utils.g.f(this, S0, placement2, font2, new androidx.camera.core.impl.e(this, backgroundUrl2, color2, yVar, dialFilePath, 6));
        }
    }

    @Override // f7.e
    public final void p0(boolean z5) {
        if (z5) {
            PlacementSelectModel placementSelectModel = this.G;
            if (placementSelectModel == null) {
                kotlin.jvm.internal.e.m("mPlacementSelectModel");
                throw null;
            }
            String backgroundUrl = placementSelectModel.getBackgroundUrl();
            PlacementSelectModel placementSelectModel2 = this.G;
            if (placementSelectModel2 == null) {
                kotlin.jvm.internal.e.m("mPlacementSelectModel");
                throw null;
            }
            String backgroundUrl2 = placementSelectModel2.getBackgroundUrl();
            if (backgroundUrl2 == null || backgroundUrl2.length() == 0) {
                File file = new File(android.support.v4.media.session.e.j(getFilesDir(), "/dial"));
                if (!file.exists()) {
                    file.mkdir();
                }
                backgroundUrl = android.support.v4.media.session.e.l(file.getAbsolutePath(), "/in.png");
            }
            yh.d.b().e(new EventBusBeans.CustomDialChangeEvent(backgroundUrl));
        }
    }

    @Override // f7.e
    public final void s() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "CustomDialActivity", "-----表盘安装成功----");
        this.K = false;
        eh.b bVar = this.f7247z;
        ((f6.u) bVar.getValue()).f13360f.setProgress(100.0f);
        ((f6.u) bVar.getValue()).f13360f.setText("100%");
        PlacementSelectModel placementSelectModel = this.G;
        if (placementSelectModel == null) {
            kotlin.jvm.internal.e.m("mPlacementSelectModel");
            throw null;
        }
        String backgroundUrl = placementSelectModel.getBackgroundUrl();
        PlacementSelectModel placementSelectModel2 = this.G;
        if (placementSelectModel2 == null) {
            kotlin.jvm.internal.e.m("mPlacementSelectModel");
            throw null;
        }
        String backgroundUrl2 = placementSelectModel2.getBackgroundUrl();
        if (backgroundUrl2 == null || backgroundUrl2.length() == 0) {
            backgroundUrl = "";
        }
        com.example.test.presenter.device.s sVar = (com.example.test.presenter.device.s) I0();
        kotlin.jvm.internal.e.c(backgroundUrl);
        sVar.w(backgroundUrl);
        ((com.example.test.presenter.device.s) I0()).getClass();
        com.example.test.presenter.device.s.C(backgroundUrl);
        com.example.test.presenter.device.s sVar2 = (com.example.test.presenter.device.s) I0();
        PlacementSelectModel placementSelectModel3 = this.G;
        if (placementSelectModel3 == null) {
            kotlin.jvm.internal.e.m("mPlacementSelectModel");
            throw null;
        }
        String color = placementSelectModel3.getColor();
        kotlin.jvm.internal.e.e(color, "getColor(...)");
        sVar2.getClass();
        com.example.test.presenter.device.s.B(color);
        b0();
        w0(R$string.str_save_success);
        com.example.test.utils.y.u().G();
        onBackPressed();
    }
}
