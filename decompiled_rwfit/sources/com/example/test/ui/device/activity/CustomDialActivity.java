package com.example.test.ui.device.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.dh.imagepick.ImagePickClient;
import com.dh.imagepick.crop.CropImageView;
import com.example.blesdk.bean.function.CustomDialInfoBean;
import com.example.blesdk.bean.function.DialInfoBean;
import com.example.network.bean.DeviceModelInfoBean;
import com.example.test.R$dimen;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.adapter.ColorAdapter;
import com.example.test.ui.device.model.ColorSelectModel;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.DialLineaLayout;
import com.example.test.ui.view.DialWidgetView;
import com.example.test.ui.view.ProgressButtonView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class CustomDialActivity extends XXBaseActivity<com.example.test.presenter.device.s, f6.t> implements f7.e, View.OnClickListener {
    public static final /* synthetic */ int U = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.CustomDialActivity$customDialInfo$2
        @Override // oh.a
        public final CustomDialInfoBean invoke() {
            return new CustomDialInfoBean();
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.CustomDialActivity$dialInfoBean$2
        @Override // oh.a
        public final DialInfoBean invoke() {
            return new DialInfoBean();
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.CustomDialActivity$deviceModelInfoBean$2
        @Override // oh.a
        public final DeviceModelInfoBean invoke() {
            return new DeviceModelInfoBean();
        }
    });
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.CustomDialActivity$colors$2
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
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.CustomDialActivity$funTypeData$2
        {
            super(0);
        }

        @Override // oh.a
        public final ArrayList<String> invoke() {
            return kotlin.collections.i.b(CustomDialActivity.this.getString(R$string.str_nothing), CustomDialActivity.this.getString(R$string.str_date), CustomDialActivity.this.getString(R$string.str_sleep_title), CustomDialActivity.this.getString(R$string.str_hr_title), CustomDialActivity.this.getString(R$string.str_step_title));
        }
    });
    public final eh.b J = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.CustomDialActivity$funTypeDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            CustomDialActivity customDialActivity = CustomDialActivity.this;
            int i3 = CustomDialActivity.U;
            com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(customDialActivity, customDialActivity.W0());
            lVar.setOnDialogDataListener(new j(CustomDialActivity.this, 0));
            return lVar;
        }
    });
    public final eh.b K = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.CustomDialActivity$timePosition$2
        {
            super(0);
        }

        @Override // oh.a
        public final ArrayList<String> invoke() {
            return kotlin.collections.i.b(CustomDialActivity.this.getString(R$string.str_time_up), CustomDialActivity.this.getString(R$string.str_time_down));
        }
    });
    public final eh.b L = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.CustomDialActivity$timePositionDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.l invoke() {
            CustomDialActivity customDialActivity = CustomDialActivity.this;
            int i3 = CustomDialActivity.U;
            com.example.test.ui.dialog.l lVar = new com.example.test.ui.dialog.l(customDialActivity, customDialActivity.X0());
            lVar.setOnDialogDataListener(new j(CustomDialActivity.this, 1));
            return lVar;
        }
    });
    public final eh.b M = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.CustomDialActivity$recoveryDialDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(CustomDialActivity.this);
            rVar.b(R$string.str_dial_restore_tips);
            rVar.setOnDialogListener(new a2.d(CustomDialActivity.this, 13));
            return rVar;
        }
    });
    public final eh.b N = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.CustomDialActivity$colorAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final ColorAdapter invoke() {
            CustomDialActivity customDialActivity = CustomDialActivity.this;
            int i3 = CustomDialActivity.U;
            return new ColorAdapter(R$layout.item_color, customDialActivity.S0());
        }
    });
    public String O = "";
    public float P;
    public int Q;
    public boolean R;
    public boolean S;
    public boolean T;

    public static final f6.t R0(CustomDialActivity customDialActivity) {
        return (f6.t) customDialActivity.f7247z.getValue();
    }

    public static void Z0(int i3, int i10, int i11, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        kotlin.jvm.internal.e.d(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        w0.e eVar = (w0.e) layoutParams;
        ((ViewGroup.MarginLayoutParams) eVar).width = i3;
        ((ViewGroup.MarginLayoutParams) eVar).height = i10;
        eVar.setMargins(0, i11, 0, 0);
        view.setLayoutParams(eVar);
    }

    @Override // f7.e
    public final void E(float f2) {
        String concat = String.format("%s:%d", Arrays.copyOf(new Object[]{getString(R$string.str_installing), Integer.valueOf((int) f2)}, 2)).concat("%");
        eh.b bVar = this.f7247z;
        ((f6.t) bVar.getValue()).f13326m.setProgress(f2);
        ((f6.t) bVar.getValue()).f13326m.setText(concat);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.s(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.t) this.f7247z.getValue()).f13315a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // f7.e
    public final void J(String str) {
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View a3;
        View a10;
        View a11;
        View inflate = getLayoutInflater().inflate(R$layout.activity_custom_dial, (ViewGroup) null, false);
        int i3 = R$id.color_list;
        RecyclerView recyclerView = (RecyclerView) he.a(i3, inflate);
        if (recyclerView != null) {
            i3 = R$id.content;
            DialLineaLayout dialLineaLayout = (DialLineaLayout) he.a(i3, inflate);
            if (dialLineaLayout != null) {
                i3 = R$id.cover_alpha_seekbar;
                AppCompatSeekBar appCompatSeekBar = (AppCompatSeekBar) he.a(i3, inflate);
                if (appCompatSeekBar != null && (a3 = he.a((i3 = R$id.dial_cover), inflate)) != null) {
                    i3 = R$id.dial_face;
                    ImageView imageView = (ImageView) he.a(i3, inflate);
                    if (imageView != null) {
                        i3 = R$id.dial_layout;
                        ConstraintLayout constraintLayout = (ConstraintLayout) he.a(i3, inflate);
                        if (constraintLayout != null) {
                            i3 = R$id.dial_widget;
                            DialWidgetView dialWidgetView = (DialWidgetView) he.a(i3, inflate);
                            if (dialWidgetView != null && (a10 = he.a((i3 = R$id.dial_widget_down), inflate)) != null && (a11 = he.a((i3 = R$id.dial_widget_up), inflate)) != null) {
                                i3 = R$id.fun_time_down;
                                LinearLayout linearLayout = (LinearLayout) he.a(i3, inflate);
                                if (linearLayout != null) {
                                    i3 = R$id.fun_time_up;
                                    LinearLayout linearLayout2 = (LinearLayout) he.a(i3, inflate);
                                    if (linearLayout2 != null) {
                                        i3 = R$id.pane;
                                        if (((LinearLayout) he.a(i3, inflate)) != null) {
                                            i3 = R$id.progressBtn;
                                            ProgressButtonView progressButtonView = (ProgressButtonView) he.a(i3, inflate);
                                            if (progressButtonView != null) {
                                                i3 = R$id.recover_normal;
                                                TextView textView = (TextView) he.a(i3, inflate);
                                                if (textView != null) {
                                                    i3 = R$id.select_pic;
                                                    TextView textView2 = (TextView) he.a(i3, inflate);
                                                    if (textView2 != null) {
                                                        i3 = R$id.time_down;
                                                        TextView textView3 = (TextView) he.a(i3, inflate);
                                                        if (textView3 != null) {
                                                            i3 = R$id.time_position;
                                                            TextView textView4 = (TextView) he.a(i3, inflate);
                                                            if (textView4 != null) {
                                                                i3 = R$id.time_position_layout;
                                                                LinearLayout linearLayout3 = (LinearLayout) he.a(i3, inflate);
                                                                if (linearLayout3 != null) {
                                                                    i3 = R$id.time_up;
                                                                    TextView textView5 = (TextView) he.a(i3, inflate);
                                                                    if (textView5 != null) {
                                                                        i3 = R$id.titleView;
                                                                        TitleView titleView = (TitleView) he.a(i3, inflate);
                                                                        if (titleView != null) {
                                                                            return new f6.t((LinearLayout) inflate, recyclerView, dialLineaLayout, appCompatSeekBar, a3, imageView, constraintLayout, dialWidgetView, a10, a11, linearLayout, linearLayout2, progressButtonView, textView, textView2, textView3, textView4, linearLayout3, textView5, titleView);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
        com.example.test.presenter.device.r bleDataCallback = (com.example.test.presenter.device.r) ((com.example.test.presenter.device.s) I0()).f7478g.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
        if (r5.b.k().f18054c) {
            x5.d.c().j((byte) 19, new byte[0]);
        } else {
            x5.b.I0().F0((byte) 19);
        }
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((f6.t) bVar.getValue()).f13328o.setSelected(true);
        ((f6.t) bVar.getValue()).f13332t.setOnTitleListener(new androidx.appcompat.app.t(this, 14));
        ((f6.t) bVar.getValue()).f13318d.setOnSeekBarChangeListener(new k(this));
        ((f6.t) bVar.getValue()).f13316b.setLayoutManager(new LinearLayoutManager(0));
        RecyclerView recyclerView = ((f6.t) bVar.getValue()).f13316b;
        eh.b bVar2 = this.N;
        recyclerView.setAdapter((ColorAdapter) bVar2.getValue());
        ((f6.t) bVar.getValue()).f13316b.setItemAnimator(null);
        ((ColorAdapter) bVar2.getValue()).setOnItemClickListener(new i(this));
        ((f6.t) bVar.getValue()).f13326m.setText(getString(R$string.str_install));
        ((f6.t) bVar.getValue()).f13326m.setEnable(true);
        ((f6.t) bVar.getValue()).f13326m.setOnClickListener(this);
        ((f6.t) bVar.getValue()).r.setOnClickListener(this);
        ((f6.t) bVar.getValue()).f13325l.setOnClickListener(this);
        ((f6.t) bVar.getValue()).f13324k.setOnClickListener(this);
        ((f6.t) bVar.getValue()).f13328o.setOnClickListener(this);
        ((f6.t) bVar.getValue()).f13327n.setOnClickListener(this);
    }

    public final List S0() {
        return (List) this.H.getValue();
    }

    @Override // f7.e
    public final void T(CustomDialInfoBean customDialInfoBean) {
        if (customDialInfoBean != null) {
            T0().setTimePosition(customDialInfoBean.getTimePosition());
            T0().setTimeUpType(customDialInfoBean.getTimeUpType());
            T0().setTimeDownType(customDialInfoBean.getTimeDownType());
            T0().setColor(customDialInfoBean.getColor());
        } else {
            ((ColorSelectModel) S0().get(S0().size() - 1)).setSelected(true);
            T0().setColor(((ColorSelectModel) S0().get(S0().size() - 1)).getColor());
        }
        Y0();
    }

    public final CustomDialInfoBean T0() {
        return (CustomDialInfoBean) this.E.getValue();
    }

    public final DeviceModelInfoBean U0() {
        return (DeviceModelInfoBean) this.G.getValue();
    }

    public final DialInfoBean V0() {
        return (DialInfoBean) this.F.getValue();
    }

    public final ArrayList W0() {
        return (ArrayList) this.I.getValue();
    }

    public final ArrayList X0() {
        return (ArrayList) this.K.getValue();
    }

    public final void Y0() {
        eh.b bVar = this.f7247z;
        ((f6.t) bVar.getValue()).f13330q.setText((CharSequence) X0().get(T0().getTimePosition()));
        b1(T0().getTimePosition());
        ((f6.t) bVar.getValue()).f13321h.setTimeUpType(T0().getTimeUpType());
        int timeUpType = T0().getTimeUpType();
        int i3 = 3;
        ((f6.t) bVar.getValue()).f13331s.setText((CharSequence) W0().get(timeUpType != 1 ? timeUpType != 2 ? timeUpType != 4 ? timeUpType != 8 ? 0 : 4 : 3 : 2 : 1));
        ((f6.t) bVar.getValue()).f13321h.setTimeDownType(T0().getTimeDownType());
        int timeDownType = T0().getTimeDownType();
        if (timeDownType == 1) {
            i3 = 1;
        } else if (timeDownType == 2) {
            i3 = 2;
        } else if (timeDownType != 4) {
            i3 = timeDownType != 8 ? 0 : 4;
        }
        ((f6.t) bVar.getValue()).f13329p.setText((CharSequence) W0().get(i3));
        int i10 = 0;
        int i11 = 0;
        for (Object obj : S0()) {
            int i12 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.i.f();
                throw null;
            }
            ColorSelectModel colorSelectModel = (ColorSelectModel) obj;
            if (kotlin.jvm.internal.e.a(colorSelectModel.getColor(), T0().getColor())) {
                colorSelectModel.setSelected(true);
                i11 = i10;
            } else {
                colorSelectModel.setSelected(false);
            }
            i10 = i12;
        }
        ((f6.t) bVar.getValue()).f13321h.setContentColor(Color.parseColor(T0().getColor()));
        if (((f6.t) bVar.getValue()).f13321h.getVisibility() == 4) {
            ((f6.t) bVar.getValue()).f13321h.setVisibility(0);
        }
        ((ColorAdapter) this.N.getValue()).notifyItemRangeChanged(0, S0().size());
        ((f6.t) bVar.getValue()).f13316b.g0(i11);
    }

    @Override // f7.e
    public final void a0(int i3) {
        this.R = false;
        eh.b bVar = this.f7247z;
        ((f6.t) bVar.getValue()).f13317c.setIntercept(false);
        com.example.baselibrary.utils.b.x("", new oh.l() { // from class: com.example.test.ui.device.activity.CustomDialActivity$onInstallFail$1
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
                File file = new File(android.support.v4.media.session.e.j(CustomDialActivity.this.getFilesDir(), "/dial"));
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        kotlin.jvm.internal.e.c(file2);
                        com.example.baselibrary.utils.b.e(file2);
                    }
                }
            }
        }, new oh.l() { // from class: com.example.test.ui.device.activity.CustomDialActivity$onInstallFail$2
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
        if (!this.S) {
            this.S = true;
            Toast.makeText(this, R$string.str_save_fail, 0).show();
        }
        ((f6.t) bVar.getValue()).f13326m.setEnable(true);
        ((f6.t) bVar.getValue()).f13326m.setText(getString(R$string.str_reinstall));
    }

    public final void a1(int i3, int i10) {
        eh.b bVar = this.f7247z;
        ViewGroup.LayoutParams layoutParams = ((f6.t) bVar.getValue()).f13320g.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i10;
        ((f6.t) bVar.getValue()).f13320g.setLayoutParams(layoutParams);
    }

    public final void b1(int i3) {
        eh.b bVar = this.f7247z;
        if (i3 == 0) {
            ((f6.t) bVar.getValue()).f13321h.setLayoutParams(((f6.t) bVar.getValue()).f13323j.getLayoutParams());
            ((f6.t) bVar.getValue()).f13330q.setText((CharSequence) X0().get(0));
            T0().setTimePosition(0);
        } else {
            ((f6.t) bVar.getValue()).f13321h.setLayoutParams(((f6.t) bVar.getValue()).f13322i.getLayoutParams());
            ((f6.t) bVar.getValue()).f13330q.setText((CharSequence) X0().get(1));
            T0().setTimePosition(1);
        }
    }

    public final void c1() {
        int dialType = V0().getDialType();
        eh.b bVar = this.f7247z;
        if (dialType == 1) {
            ((f6.t) bVar.getValue()).f13319f.setImageDrawable(getResources().getDrawable(R$drawable.bg_dial_cover_circle));
        } else if (kotlin.jvm.internal.e.a(U0().getDeviceClazz(), Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE)) {
            ((f6.t) bVar.getValue()).f13319f.setImageDrawable(getResources().getDrawable(R$drawable.bg_rectangle_black_s9));
        } else {
            ((f6.t) bVar.getValue()).f13319f.setImageDrawable(getResources().getDrawable(R$drawable.bg_rectangle_black));
        }
    }

    @Override // p5.a
    public final Context f0() {
        return this;
    }

    @Override // f7.e
    public final void j0(DeviceModelInfoBean deviceModelInfoBean) {
        if (deviceModelInfoBean != null) {
            U0().setDefaultCustomizeDialUrl(deviceModelInfoBean.getDefaultCustomizeDialUrl());
            U0().setCustomizeDialShowUrl(deviceModelInfoBean.getCustomizeDialShowUrl());
            U0().setDeviceClazz(deviceModelInfoBean.getDeviceClazz());
            String deviceClazz = deviceModelInfoBean.getDeviceClazz();
            kotlin.jvm.internal.e.e(deviceClazz, "getDeviceClazz(...)");
            int dialType = V0().getDialType();
            eh.b bVar = this.f7247z;
            if (dialType == 1) {
                if (deviceClazz.equals("7")) {
                    a1((int) getResources().getDimension(R$dimen.qb_px_123), (int) getResources().getDimension(R$dimen.qb_px_192));
                    Z0((int) getResources().getDimension(R$dimen.qb_px_102), (int) getResources().getDimension(R$dimen.qb_px_102), (int) getResources().getDimension(R$dimen.qb_px_45), ((f6.t) bVar.getValue()).f13319f);
                    Z0((int) getResources().getDimension(R$dimen.qb_px_102), (int) getResources().getDimension(R$dimen.qb_px_102), (int) getResources().getDimension(R$dimen.qb_px_45), ((f6.t) bVar.getValue()).e);
                } else if (deviceClazz.equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO)) {
                    a1((int) getResources().getDimension(R$dimen.qb_px_139), (int) getResources().getDimension(R$dimen.qb_px_190));
                    Z0((int) getResources().getDimension(R$dimen.qb_px_120), (int) getResources().getDimension(R$dimen.qb_px_120), (int) getResources().getDimension(R$dimen.qb_px_35), ((f6.t) bVar.getValue()).f13319f);
                    Z0((int) getResources().getDimension(R$dimen.qb_px_120), (int) getResources().getDimension(R$dimen.qb_px_120), (int) getResources().getDimension(R$dimen.qb_px_35), ((f6.t) bVar.getValue()).e);
                } else {
                    a1((int) getResources().getDimension(R$dimen.qb_px_125), (int) getResources().getDimension(R$dimen.qb_px_196));
                    Z0((int) getResources().getDimension(R$dimen.qb_px_106), (int) getResources().getDimension(R$dimen.qb_px_106), (int) getResources().getDimension(R$dimen.qb_px_46), ((f6.t) bVar.getValue()).f13319f);
                    Z0((int) getResources().getDimension(R$dimen.qb_px_106), (int) getResources().getDimension(R$dimen.qb_px_106), (int) getResources().getDimension(R$dimen.qb_px_46), ((f6.t) bVar.getValue()).e);
                }
                ((f6.t) bVar.getValue()).e.setBackground(getResources().getDrawable(R$drawable.bg_dial_cover_circle));
            } else {
                a1((int) getResources().getDimension(R$dimen.qb_px_129), (int) getResources().getDimension(R$dimen.qb_px_192));
                Z0((int) getResources().getDimension(R$dimen.qb_px_102), (int) getResources().getDimension(R$dimen.qb_px_119), (int) getResources().getDimension(R$dimen.qb_px_38), ((f6.t) bVar.getValue()).f13319f);
                Z0((int) getResources().getDimension(R$dimen.qb_px_102), (int) getResources().getDimension(R$dimen.qb_px_119), (int) getResources().getDimension(R$dimen.qb_px_38), ((f6.t) bVar.getValue()).e);
                if (deviceClazz.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE)) {
                    ((f6.t) bVar.getValue()).e.setBackground(getResources().getDrawable(R$drawable.bg_rectangle_black_s9));
                } else {
                    ((f6.t) bVar.getValue()).e.setBackground(getResources().getDrawable(R$drawable.bg_rectangle_black));
                }
            }
        }
        ((com.example.test.presenter.device.s) I0()).x();
    }

    @Override // f7.e
    public final void k0(String str) {
        String customizeDialShowUrl = U0().getCustomizeDialShowUrl();
        z3.h hVar = z3.h.f20239b;
        eh.b bVar = this.f7247z;
        if (customizeDialShowUrl == null || customizeDialShowUrl.length() == 0) {
            ConstraintLayout constraintLayout = ((f6.t) bVar.getValue()).f13320g;
            int i3 = R$mipmap.bg_dial_default;
            q4.g nVar = new com.example.test.utils.n(constraintLayout, 1);
            com.bumptech.glide.i iVar = (com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(this).m(Integer.valueOf(i3)).o(true)).d(hVar);
            iVar.y(nVar, iVar);
        } else {
            ConstraintLayout constraintLayout2 = ((f6.t) bVar.getValue()).f13320g;
            String customizeDialShowUrl2 = U0().getCustomizeDialShowUrl();
            kotlin.jvm.internal.e.e(customizeDialShowUrl2, "getCustomizeDialShowUrl(...)");
            q4.g nVar2 = new com.example.test.utils.n(constraintLayout2, 0);
            com.bumptech.glide.i iVar2 = (com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(this).n(customizeDialShowUrl2).o(true)).d(hVar);
            iVar2.y(nVar2, iVar2);
        }
        if (str == null || str.length() == 0) {
            c1();
            ((f6.t) bVar.getValue()).f13326m.setCanPress(false);
            return;
        }
        this.O = str;
        if (V0().getDialType() == 1) {
            ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(this).n(str).o(true)).d(hVar)).i(R$drawable.bg_img)).a(p4.e.t(new g4.i())).e(R$drawable.bg_img)).x(((f6.t) bVar.getValue()).f13319f);
        } else {
            ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(this).n(str).o(true)).d(hVar)).i(R$drawable.bg_dial_item)).a(p4.e.t(new g4.v(com.example.baselibrary.utils.b.f(this, kotlin.jvm.internal.e.a(U0().getDeviceClazz(), Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE) ? 30.0f : 16.0f)))).e(R$drawable.bg_dial_item)).x(((f6.t) bVar.getValue()).f13319f);
        }
    }

    @Override // f7.e
    public final void n0(DialInfoBean dialInfoBean) {
        V0().setDialType(dialInfoBean.getDialType());
        V0().setWidth(dialInfoBean.getWidth());
        V0().setHeight(dialInfoBean.getHeight());
        ((com.example.test.presenter.device.s) I0()).y();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.R) {
            Toast.makeText(this, R$string.str_installing, 0).show();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.R) {
            return;
        }
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.time_position_layout;
        if (valueOf != null && valueOf.intValue() == i3) {
            eh.b bVar = this.L;
            ((com.example.test.ui.dialog.l) bVar.getValue()).a(T0().getTimePosition());
            ((com.example.test.ui.dialog.l) bVar.getValue()).show();
            return;
        }
        int i10 = R$id.fun_time_up;
        eh.b bVar2 = this.J;
        int i11 = 3;
        if (valueOf != null && valueOf.intValue() == i10) {
            this.Q = 1;
            int timeUpType = T0().getTimeUpType();
            if (timeUpType == 1) {
                i11 = 1;
            } else if (timeUpType == 2) {
                i11 = 2;
            } else if (timeUpType != 4) {
                i11 = timeUpType != 8 ? 0 : 4;
            }
            ((com.example.test.ui.dialog.l) bVar2.getValue()).a(i11);
            ((com.example.test.ui.dialog.l) bVar2.getValue()).show();
            return;
        }
        int i12 = R$id.fun_time_down;
        if (valueOf != null && valueOf.intValue() == i12) {
            this.Q = 2;
            int timeDownType = T0().getTimeDownType();
            if (timeDownType == 1) {
                i11 = 1;
            } else if (timeDownType == 2) {
                i11 = 2;
            } else if (timeDownType != 4) {
                i11 = timeDownType != 8 ? 0 : 4;
            }
            ((com.example.test.ui.dialog.l) bVar2.getValue()).a(i11);
            ((com.example.test.ui.dialog.l) bVar2.getValue()).show();
            return;
        }
        int i13 = R$id.select_pic;
        if (valueOf != null && valueOf.intValue() == i13) {
            if (Build.VERSION.SDK_INT < 30) {
                v2.h hVar = new v2.h(this);
                hVar.o("android.permission.WRITE_EXTERNAL_STORAGE");
                hVar.o("android.permission.READ_EXTERNAL_STORAGE");
                hVar.p(new i(this));
                return;
            }
            int width = V0().getWidth();
            int height = V0().getHeight();
            int dialType = V0().getDialType();
            oh.l lVar = new oh.l() { // from class: com.example.test.ui.device.activity.CustomDialActivity$onClick$1
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
                    CustomDialActivity customDialActivity = CustomDialActivity.this;
                    customDialActivity.O = path;
                    ((f6.t) customDialActivity.f7247z.getValue()).f13326m.setCanPress(true);
                    int dialType2 = CustomDialActivity.this.V0().getDialType();
                    z3.h hVar2 = z3.h.f20239b;
                    if (dialType2 == 1) {
                        CustomDialActivity customDialActivity2 = CustomDialActivity.this;
                        ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(customDialActivity2).n(path).o(true)).d(hVar2)).i(R$drawable.bg_img)).a(p4.e.t(new g4.i())).e(R$drawable.bg_img)).x(CustomDialActivity.R0(customDialActivity2).f13319f);
                        return;
                    }
                    float f2 = kotlin.jvm.internal.e.a(CustomDialActivity.this.U0().getDeviceClazz(), Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE) ? 30.0f : 16.0f;
                    CustomDialActivity customDialActivity3 = CustomDialActivity.this;
                    ImageView imageView = CustomDialActivity.R0(customDialActivity3).f13319f;
                    CustomDialActivity customDialActivity4 = CustomDialActivity.this;
                    customDialActivity4.getClass();
                    ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(customDialActivity3).n(path).o(true)).d(hVar2)).i(R$drawable.bg_dial_item)).a(p4.e.t(new g4.v(com.example.baselibrary.utils.b.f(customDialActivity4, f2)))).e(R$drawable.bg_dial_item)).x(imageView);
                }
            };
            CustomDialActivity$onClick$2 errorBack = new oh.l() { // from class: com.example.test.ui.device.activity.CustomDialActivity$onClick$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return eh.g.f12633a;
                }

                public final void invoke(String error) {
                    kotlin.jvm.internal.e.f(error, "error");
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error pick ".concat(error));
                }
            };
            kotlin.jvm.internal.e.f(errorBack, "errorBack");
            CropImageView.Style style = dialType == 1 ? CropImageView.Style.CIRCLE : CropImageView.Style.RECTANGLE;
            com.dh.imagepick.work.c with = ImagePickClient.with(this);
            with.getClass();
            f5.a a3 = com.dh.imagepick.work.c.a(new f5.b(with).i());
            kotlin.jvm.internal.e.f(style, "style");
            a3.f12665c = width;
            a3.f12666d = height;
            a3.e = style;
            a3.h(new com.example.test.utils.o(errorBack, lVar, 1));
            return;
        }
        int i14 = R$id.recover_normal;
        if (valueOf != null && valueOf.intValue() == i14) {
            if (this.O.length() == 0) {
                return;
            }
            this.T = true;
            ((com.example.test.ui.dialog.r) this.M.getValue()).show();
            return;
        }
        int i15 = R$id.progressBtn;
        if (valueOf != null && valueOf.intValue() == i15) {
            this.R = true;
            this.S = false;
            eh.b bVar3 = this.f7247z;
            ((f6.t) bVar3.getValue()).f13317c.setIntercept(true);
            com.example.test.utils.y.u().y(true);
            com.example.test.utils.y.u().A();
            ((com.example.test.presenter.device.s) I0()).A(this.O, false, this.P, T0());
            String concat = String.format("%s:%d", Arrays.copyOf(new Object[]{getString(R$string.str_installing), 0}, 2)).concat("%");
            ((f6.t) bVar3.getValue()).f13326m.setProgress(0.0f);
            ((f6.t) bVar3.getValue()).f13326m.setText(concat);
        }
    }

    @Override // f7.e
    public final void p0(boolean z5) {
        if (z5) {
            yh.d.b().e(new EventBusBeans.CustomDialChangeEvent(this.O));
        }
    }

    @Override // f7.e
    public final void s() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "CustomDialActivity", "-----表盘安装成功----");
        this.R = false;
        eh.b bVar = this.f7247z;
        ((f6.t) bVar.getValue()).f13317c.setIntercept(false);
        ((f6.t) bVar.getValue()).f13326m.setProgress(100.0f);
        ((f6.t) bVar.getValue()).f13326m.setText("100%");
        if (this.O.length() > 0) {
            ((com.example.test.presenter.device.s) I0()).w(this.O);
            com.example.test.presenter.device.s sVar = (com.example.test.presenter.device.s) I0();
            String str = this.O;
            sVar.getClass();
            com.example.test.presenter.device.s.C(str);
        }
        if (this.T) {
            ((com.example.test.presenter.device.s) I0()).w("");
            ((com.example.test.presenter.device.s) I0()).getClass();
            com.example.test.presenter.device.s.C("");
        }
        com.example.baselibrary.utils.b.x("", new oh.l() { // from class: com.example.test.ui.device.activity.CustomDialActivity$onInstallSuccess$1
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
                File file = new File(android.support.v4.media.session.e.j(CustomDialActivity.this.getFilesDir(), "/dial"));
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        kotlin.jvm.internal.e.c(file2);
                        com.example.baselibrary.utils.b.e(file2);
                    }
                }
            }
        }, new oh.l() { // from class: com.example.test.ui.device.activity.CustomDialActivity$onInstallSuccess$2
            public final void invoke(eh.g it) {
                kotlin.jvm.internal.e.f(it, "it");
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((eh.g) obj);
                return eh.g.f12633a;
            }
        });
        b0();
        w0(R$string.str_save_success);
        com.example.test.utils.y.u().G();
        onBackPressed();
    }
}
