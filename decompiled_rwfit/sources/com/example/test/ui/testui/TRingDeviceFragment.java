package com.example.test.ui.testui;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.blesdk.bean.function.BrightScreenLedBean;
import com.example.blesdk.bean.function.BrightVibrationBean;
import com.example.blesdk.bean.function.FirmVersionBean;
import com.example.blesdk.bean.function.PowerBean;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.blesdk.bean.function.VideoHidBean;
import com.example.database.table.Devices;
import com.example.database.table.User;
import com.example.network.api.DeviceApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.DeviceModelInfoBean;
import com.example.test.R$color;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.R$style;
import com.example.test.XXApplication;
import com.example.test.presenter.main.m1;
import com.example.test.presenter.main.o1;
import com.example.test.presenter.main.r1;
import com.example.test.ui.XXBaseFragment;
import com.example.test.ui.device.activity.DeviceScanActivity;
import com.example.test.ui.device.activity.ScanQrCodeActivity;
import com.example.test.ui.device.adapter.TRingDeviceOptionAdapter;
import com.example.test.ui.device.model.DeviceInfoModel;
import com.example.test.ui.device.model.DeviceOptionModel;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.TRingDeviceInfoView;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import f6.u3;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class TRingDeviceFragment extends XXBaseFragment<r1, u3> implements g7.z, View.OnClickListener, o5.a {
    public int A;
    public final eh.b B;
    public final eh.b C;
    public final eh.b D;
    public final eh.b E;
    public final eh.b F;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8212d;

    /* renamed from: l, reason: collision with root package name */
    public boolean f8219l;

    /* renamed from: m, reason: collision with root package name */
    public List f8220m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8221n;

    /* renamed from: w, reason: collision with root package name */
    public int f8229w;

    /* renamed from: x, reason: collision with root package name */
    public final int f8230x;

    /* renamed from: y, reason: collision with root package name */
    public final int f8231y;

    /* renamed from: z, reason: collision with root package name */
    public final int f8232z;
    public final eh.b e = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$brightLedLevelBean$2
        @Override // oh.a
        public final BrightScreenLedBean invoke() {
            return new BrightScreenLedBean();
        }
    });

    /* renamed from: f, reason: collision with root package name */
    public final eh.b f8213f = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$brightVibrationBean$2
        @Override // oh.a
        public final BrightVibrationBean invoke() {
            return new BrightVibrationBean();
        }
    });

    /* renamed from: g, reason: collision with root package name */
    public final eh.b f8214g = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$videoHidBean$2
        @Override // oh.a
        public final VideoHidBean invoke() {
            return new VideoHidBean();
        }
    });

    /* renamed from: h, reason: collision with root package name */
    public final eh.b f8215h = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$screenLightDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.k invoke() {
            com.example.test.ui.dialog.k kVar = new com.example.test.ui.dialog.k(TRingDeviceFragment.this.f0(), R$style.bottom_dialog);
            kVar.setContentView(R$layout.dialog_select_screenlight);
            Window window = kVar.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.y = 0;
                attributes.width = -1;
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setGravity(80);
                window.setBackgroundDrawableResource(R$color.transparent);
            }
            kVar.f7970b = (ImageView) kVar.findViewById(R$id.iv_stronglight);
            kVar.f7971c = (ImageView) kVar.findViewById(R$id.iv_softlight);
            kVar.f7972d = (ImageView) kVar.findViewById(R$id.iv_minlight);
            kVar.e = (ImageView) kVar.findViewById(R$id.iv_closelight);
            kVar.f7973f = (TextView) kVar.findViewById(R$id.tvTitle);
            kVar.f7974g = (TextView) kVar.findViewById(R$id.tvSubTitle);
            kVar.f7975h = (TextView) kVar.findViewById(R$id.tvStrong);
            kVar.f7976i = (TextView) kVar.findViewById(R$id.tvsoft);
            kVar.f7977j = (TextView) kVar.findViewById(R$id.tvmin);
            kVar.f7978k = (TextView) kVar.findViewById(R$id.tvclose);
            kVar.f7979l = (ConstraintLayout) kVar.findViewById(R$id.cl_screenlight_bg);
            TextView textView = (TextView) kVar.findViewById(R$id.tvCancel);
            textView.setOnClickListener(kVar);
            RelativeLayout relativeLayout = (RelativeLayout) kVar.findViewById(R$id.btn_stronglight);
            RelativeLayout relativeLayout2 = (RelativeLayout) kVar.findViewById(R$id.btn_softlight);
            RelativeLayout relativeLayout3 = (RelativeLayout) kVar.findViewById(R$id.btn_minlight);
            RelativeLayout relativeLayout4 = (RelativeLayout) kVar.findViewById(R$id.btn_close);
            textView.setOnClickListener(kVar);
            relativeLayout.setOnClickListener(kVar);
            relativeLayout2.setOnClickListener(kVar);
            relativeLayout3.setOnClickListener(kVar);
            relativeLayout4.setOnClickListener(kVar);
            kVar.setOnDialogDataListener(new q(TRingDeviceFragment.this, 9));
            return kVar;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    public final eh.b f8216i = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$appUnitDistanceDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.m invoke() {
            com.example.test.ui.dialog.m mVar = new com.example.test.ui.dialog.m(TRingDeviceFragment.this.f0(), R$style.bottom_dialog);
            mVar.setContentView(R$layout.dialog_select_unitdistance);
            Window window = mVar.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.y = 0;
                attributes.width = -1;
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setGravity(80);
                window.setBackgroundDrawableResource(R$color.transparent);
            }
            mVar.f7985b = (ImageView) mVar.findViewById(R$id.iv_lefthand);
            mVar.f7986c = (ImageView) mVar.findViewById(R$id.iv_righthand);
            mVar.f7987d = (TextView) mVar.findViewById(R$id.tvTitle);
            mVar.e = (TextView) mVar.findViewById(R$id.tvlefthand);
            mVar.f7988f = (TextView) mVar.findViewById(R$id.tvright);
            mVar.f7989g = (ConstraintLayout) mVar.findViewById(R$id.cl_unit_bg);
            TextView textView = (TextView) mVar.findViewById(R$id.tvCancel);
            textView.setOnClickListener(mVar);
            RelativeLayout relativeLayout = (RelativeLayout) mVar.findViewById(R$id.btn_lefthand);
            RelativeLayout relativeLayout2 = (RelativeLayout) mVar.findViewById(R$id.btn_righthand);
            textView.setOnClickListener(mVar);
            relativeLayout.setOnClickListener(mVar);
            relativeLayout2.setOnClickListener(mVar);
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            Integer valueOf = kVar != null ? Integer.valueOf(kVar.D()) : null;
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
            User d5 = kVar2 != null ? kVar2.d() : null;
            if (d5 == null || d5.getMeterUnit() != 0) {
                if (valueOf != null && valueOf.intValue() == 0) {
                    ImageView imageView = mVar.f7985b;
                    if (imageView != null) {
                        imageView.setImageResource(R$drawable.svg_select_no_black);
                    }
                } else {
                    ImageView imageView2 = mVar.f7985b;
                    if (imageView2 != null) {
                        imageView2.setImageResource(R$drawable.svg_select_no_white);
                    }
                }
                ImageView imageView3 = mVar.f7986c;
                if (imageView3 != null) {
                    imageView3.setImageResource(R$mipmap.select_yes);
                }
            } else {
                ImageView imageView4 = mVar.f7985b;
                if (imageView4 != null) {
                    imageView4.setImageResource(R$mipmap.select_yes);
                }
                if (valueOf != null && valueOf.intValue() == 0) {
                    ImageView imageView5 = mVar.f7986c;
                    if (imageView5 != null) {
                        imageView5.setImageResource(R$drawable.svg_select_no_black);
                    }
                } else {
                    ImageView imageView6 = mVar.f7986c;
                    if (imageView6 != null) {
                        imageView6.setImageResource(R$drawable.svg_select_no_white);
                    }
                }
            }
            mVar.setOnDialogDataListener(new q(TRingDeviceFragment.this, 0));
            return mVar;
        }
    });

    /* renamed from: j, reason: collision with root package name */
    public final eh.b f8217j = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$wearDirectDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.o invoke() {
            com.example.test.ui.dialog.o oVar = new com.example.test.ui.dialog.o(TRingDeviceFragment.this.f0(), R$style.bottom_dialog);
            oVar.setContentView(R$layout.dialog_select_waredirection);
            Window window = oVar.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.y = 0;
                attributes.width = -1;
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setGravity(80);
                window.setBackgroundDrawableResource(R$color.transparent);
            }
            oVar.f8002b = (ImageView) oVar.findViewById(R$id.iv_lefthand);
            oVar.f8003c = (ImageView) oVar.findViewById(R$id.iv_righthand);
            oVar.f8004d = (TextView) oVar.findViewById(R$id.tvTitle);
            oVar.e = (TextView) oVar.findViewById(R$id.tvlefthand);
            oVar.f8005f = (TextView) oVar.findViewById(R$id.tvright);
            oVar.f8006g = (ConstraintLayout) oVar.findViewById(R$id.cl_weardir_bg);
            TextView textView = (TextView) oVar.findViewById(R$id.tvCancel);
            textView.setOnClickListener(oVar);
            RelativeLayout relativeLayout = (RelativeLayout) oVar.findViewById(R$id.btn_lefthand);
            RelativeLayout relativeLayout2 = (RelativeLayout) oVar.findViewById(R$id.btn_righthand);
            textView.setOnClickListener(oVar);
            relativeLayout.setOnClickListener(oVar);
            relativeLayout2.setOnClickListener(oVar);
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            Integer valueOf = kVar != null ? Integer.valueOf(kVar.D()) : null;
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
            Integer valueOf2 = kVar2 != null ? Integer.valueOf(kVar2.E()) : null;
            if (valueOf2 != null && valueOf2.intValue() == 0) {
                ImageView imageView = oVar.f8002b;
                if (imageView != null) {
                    imageView.setImageResource(R$mipmap.select_yes);
                }
                if (valueOf != null && valueOf.intValue() == 0) {
                    ImageView imageView2 = oVar.f8003c;
                    if (imageView2 != null) {
                        imageView2.setImageResource(R$drawable.svg_select_no_black);
                    }
                } else {
                    ImageView imageView3 = oVar.f8003c;
                    if (imageView3 != null) {
                        imageView3.setImageResource(R$drawable.svg_select_no_white);
                    }
                }
            } else {
                if (valueOf != null && valueOf.intValue() == 0) {
                    ImageView imageView4 = oVar.f8002b;
                    if (imageView4 != null) {
                        imageView4.setImageResource(R$drawable.svg_select_no_black);
                    }
                } else {
                    ImageView imageView5 = oVar.f8002b;
                    if (imageView5 != null) {
                        imageView5.setImageResource(R$drawable.svg_select_no_white);
                    }
                }
                ImageView imageView6 = oVar.f8003c;
                if (imageView6 != null) {
                    imageView6.setImageResource(R$mipmap.select_yes);
                }
            }
            oVar.setOnDialogDataListener(new q(TRingDeviceFragment.this, 12));
            return oVar;
        }
    });

    /* renamed from: k, reason: collision with root package name */
    public final eh.b f8218k = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$videoControlDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.n invoke() {
            com.example.test.ui.dialog.n nVar = new com.example.test.ui.dialog.n(TRingDeviceFragment.this.f0(), R$style.bottom_dialog);
            nVar.setContentView(R$layout.dialog_select_videocontrol);
            Window window = nVar.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.y = 0;
                attributes.width = -1;
                attributes.height = -2;
                window.setAttributes(attributes);
                window.setGravity(80);
                window.setBackgroundDrawableResource(R$color.transparent);
            }
            nVar.f7991b = (ImageView) nVar.findViewById(R$id.iv_stronglight);
            nVar.f7992c = (ImageView) nVar.findViewById(R$id.iv_softlight);
            nVar.f7993d = (ImageView) nVar.findViewById(R$id.iv_minlight);
            nVar.e = (ImageView) nVar.findViewById(R$id.iv_closelight);
            nVar.f7994f = (TextView) nVar.findViewById(R$id.tvTitle);
            nVar.f7995g = (TextView) nVar.findViewById(R$id.tvSubTitle);
            nVar.f7996h = (TextView) nVar.findViewById(R$id.tvStrong);
            nVar.f7997i = (TextView) nVar.findViewById(R$id.tvsoft);
            nVar.f7998j = (TextView) nVar.findViewById(R$id.tvmin);
            nVar.f7999k = (TextView) nVar.findViewById(R$id.tvclose);
            TextView textView = (TextView) nVar.findViewById(R$id.tvCancel);
            if (textView != null) {
                textView.setOnClickListener(nVar);
            }
            nVar.f8000l = (ConstraintLayout) nVar.findViewById(R$id.cl_videohid_bg);
            RelativeLayout relativeLayout = (RelativeLayout) nVar.findViewById(R$id.btn_stronglight);
            RelativeLayout relativeLayout2 = (RelativeLayout) nVar.findViewById(R$id.btn_softlight);
            RelativeLayout relativeLayout3 = (RelativeLayout) nVar.findViewById(R$id.btn_minlight);
            RelativeLayout relativeLayout4 = (RelativeLayout) nVar.findViewById(R$id.btn_close);
            relativeLayout.setOnClickListener(nVar);
            relativeLayout2.setOnClickListener(nVar);
            relativeLayout3.setOnClickListener(nVar);
            relativeLayout4.setOnClickListener(nVar);
            Object obj = com.example.test.utils.m.f8734b;
            SupportMenuBean supportMenuBean = d2.a().f8735a;
            if (!(supportMenuBean != null ? supportMenuBean.isVideoHidAndroidBook() : true)) {
                relativeLayout2.setVisibility(8);
            }
            SupportMenuBean supportMenuBean2 = d2.a().f8735a;
            if (!(supportMenuBean2 != null ? supportMenuBean2.isVideoHidMusic() : true)) {
                relativeLayout3.setVisibility(8);
            }
            nVar.setOnDialogDataListener(new q(TRingDeviceFragment.this, 10));
            return nVar;
        }
    });

    /* renamed from: o, reason: collision with root package name */
    public final eh.b f8222o = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$optionAdapter$2
        {
            super(0);
        }

        @Override // oh.a
        public final TRingDeviceOptionAdapter invoke() {
            TRingDeviceFragment tRingDeviceFragment = TRingDeviceFragment.this;
            tRingDeviceFragment.f8220m = tRingDeviceFragment.E0();
            return new TRingDeviceOptionAdapter(TRingDeviceFragment.this.f8220m);
        }
    });

    /* renamed from: p, reason: collision with root package name */
    public final eh.b f8223p = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$shutdownConfirmDlg$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.t invoke() {
            com.example.test.ui.dialog.t tVar = new com.example.test.ui.dialog.t(TRingDeviceFragment.this.f0());
            int i3 = R$string.str_device_shutdown;
            TextView textView = tVar.f8034d;
            if (textView == null) {
                kotlin.jvm.internal.e.m("tvTitle");
                throw null;
            }
            textView.setText(i3);
            int i10 = R$string.str_device_shutdown_tips;
            TextView textView2 = tVar.e;
            if (textView2 != null) {
                textView2.setText(i10);
                return tVar;
            }
            kotlin.jvm.internal.e.m("tvTips");
            throw null;
        }
    });

    /* renamed from: q, reason: collision with root package name */
    public final eh.b f8224q = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$msgTipsDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(TRingDeviceFragment.this.f0());
            rVar.b(R$string.ring_str_message_powerconsumptionalert_tips);
            rVar.setOnDialogListener(new q(TRingDeviceFragment.this, 7));
            return rVar;
        }
    });
    public final eh.b r = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$restoryFactoryConfirmDlg$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.t invoke() {
            com.example.test.ui.dialog.t tVar = new com.example.test.ui.dialog.t(TRingDeviceFragment.this.f0());
            int i3 = R$string.str_recover;
            TextView textView = tVar.f8034d;
            if (textView == null) {
                kotlin.jvm.internal.e.m("tvTitle");
                throw null;
            }
            textView.setText(i3);
            int i10 = R$string.str_device_recovery_tips;
            TextView textView2 = tVar.e;
            if (textView2 != null) {
                textView2.setText(i10);
                return tVar;
            }
            kotlin.jvm.internal.e.m("tvTips");
            throw null;
        }
    });

    /* renamed from: s, reason: collision with root package name */
    public final eh.b f8225s = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$unBindConfirmDlg$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.t invoke() {
            com.example.test.ui.dialog.t tVar = new com.example.test.ui.dialog.t(TRingDeviceFragment.this.f0());
            int i3 = R$string.str_ring_unbind;
            TextView textView = tVar.f8034d;
            if (textView == null) {
                kotlin.jvm.internal.e.m("tvTitle");
                throw null;
            }
            textView.setText(i3);
            int i10 = R$string.str_device_unbind_tips;
            TextView textView2 = tVar.e;
            if (textView2 != null) {
                textView2.setText(i10);
                return tVar;
            }
            kotlin.jvm.internal.e.m("tvTips");
            throw null;
        }
    });

    /* renamed from: t, reason: collision with root package name */
    public final eh.b f8226t = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$tipsDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(TRingDeviceFragment.this.f0());
            rVar.b(R$string.str_disconnect_tips);
            return rVar;
        }
    });

    /* renamed from: u, reason: collision with root package name */
    public final eh.b f8227u = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$lowBatteryTipsDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(TRingDeviceFragment.this.f0());
            rVar.b(R$string.ring_item_lowbattery_tip);
            return rVar;
        }
    });

    /* renamed from: v, reason: collision with root package name */
    public final eh.b f8228v = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$connectDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.h invoke() {
            return new com.example.test.ui.dialog.h(TRingDeviceFragment.this.f0());
        }
    });

    public TRingDeviceFragment() {
        kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$weakHandler$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.baselibrary.utils.e invoke() {
                return new com.example.baselibrary.utils.e(TRingDeviceFragment.this);
            }
        });
        this.f8230x = 2;
        this.f8231y = 3;
        this.f8232z = 4;
        this.B = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$permissionTipDialog$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.test.ui.dialog.i invoke() {
                com.example.test.ui.dialog.i iVar = new com.example.test.ui.dialog.i(TRingDeviceFragment.this.f0(), 2);
                iVar.setOnDialogListener(new q(TRingDeviceFragment.this, 8));
                iVar.setCancelable(false);
                return iVar;
            }
        });
        this.C = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$gpsTipsDialog$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.test.ui.dialog.r invoke() {
                com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(TRingDeviceFragment.this.f0());
                rVar.b(R$string.str_gps_open);
                rVar.setOnDialogListener(new q(TRingDeviceFragment.this, 2));
                return rVar;
            }
        });
        this.D = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$bleTipsDialog$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.test.ui.dialog.r invoke() {
                com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(TRingDeviceFragment.this.f0());
                rVar.b(R$string.str_ble_open);
                rVar.setOnDialogListener(new q(TRingDeviceFragment.this, 1));
                return rVar;
            }
        });
        this.E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$warnNotifyDialog$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.test.ui.dialog.r invoke() {
                com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(TRingDeviceFragment.this.f0());
                rVar.b(R$string.str_msg_tips);
                rVar.setOnDialogListener(new q(TRingDeviceFragment.this, 11));
                return rVar;
            }
        });
        this.F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingDeviceFragment$deviceInfo$2
            @Override // oh.a
            public final DeviceInfoModel invoke() {
                Devices c9;
                DeviceInfoModel deviceInfoModel = new DeviceInfoModel(R$id.device_info, 0);
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null && (c9 = kVar.c()) != null) {
                    deviceInfoModel.setVersion(c9.getDeviceVer());
                    deviceInfoModel.setDeviceName(c9.getName());
                }
                return deviceInfoModel;
            }
        });
    }

    public final TRingDeviceOptionAdapter A0() {
        return (TRingDeviceOptionAdapter) this.f8222o.getValue();
    }

    public final com.example.test.ui.dialog.r B0() {
        return (com.example.test.ui.dialog.r) this.f8226t.getValue();
    }

    public final VideoHidBean C0() {
        return (VideoHidBean) this.f8214g.getValue();
    }

    public final void D0() {
        z0().setBindStatus(1);
        z0().setDeviceName(com.example.test.service.e.h().g().f18210a);
        z0().setMac(com.example.test.service.e.h().g().f18212c);
        u3 u3Var = (u3) this.f7251b;
        if (u3Var != null) {
            u3Var.f13380b.setBindModel(z0());
        }
        if (com.example.test.service.e.h().i()) {
            u3 u3Var2 = (u3) this.f7251b;
            if (u3Var2 != null) {
                u3Var2.f13380b.setLinkedStatus(1);
            }
        } else if (com.example.test.service.e.h().g().f18213d == 2) {
            u3 u3Var3 = (u3) this.f7251b;
            if (u3Var3 != null) {
                u3Var3.f13380b.setLinkedStatus(2);
            }
        } else {
            u3 u3Var4 = (u3) this.f7251b;
            if (u3Var4 != null) {
                u3Var4.f13380b.setLinkedStatus(0);
            }
        }
        List list = this.f8220m;
        if (list != null) {
            list.clear();
        }
        List list2 = this.f8220m;
        if (list2 != null) {
            list2.addAll(E0());
        }
        A0().notifyDataSetChanged();
    }

    public final ArrayList E0() {
        ArrayList arrayList = new ArrayList();
        DeviceOptionModel deviceOptionModel = new DeviceOptionModel(R$id.av_msg, 10086);
        deviceOptionModel.setActionType(0);
        deviceOptionModel.setOptionRes(R$mipmap.ring_dev_item_pushmsg);
        deviceOptionModel.setOptionStr(R$string.ring_str_msg_push);
        arrayList.add(deviceOptionModel);
        DeviceOptionModel deviceOptionModel2 = new DeviceOptionModel(R$id.av_screen_light, 10086);
        deviceOptionModel2.setActionType(0);
        deviceOptionModel2.setOptionRes(R$mipmap.settings_optio_screen_light);
        deviceOptionModel2.setOptionStr(R$string.str_screen_light);
        arrayList.add(deviceOptionModel2);
        DeviceOptionModel deviceOptionModel3 = new DeviceOptionModel(R$id.av_low_battery, 10086);
        deviceOptionModel3.setActionType(1);
        deviceOptionModel3.setOptionRes(R$mipmap.ring_dev_item_lowbattery);
        deviceOptionModel3.setOptionStr(R$string.ring_item_lowbattery_title);
        deviceOptionModel3.setEnableSwitch(true);
        deviceOptionModel3.setChecked(false);
        arrayList.add(deviceOptionModel3);
        com.example.test.utils.k a3 = y1.a();
        Integer valueOf = a3 != null ? Integer.valueOf(a3.y()) : null;
        if (valueOf != null) {
            if (valueOf.intValue() == 0) {
                deviceOptionModel3.setChecked(false);
            } else {
                deviceOptionModel3.setChecked(true);
            }
        }
        DeviceOptionModel deviceOptionModel4 = new DeviceOptionModel(R$id.av_remember, 10086);
        deviceOptionModel4.setActionType(1);
        deviceOptionModel4.setOptionRes(R$mipmap.ring_dev_item_remember);
        deviceOptionModel4.setOptionStr(R$string.ring_item_remember_title);
        deviceOptionModel4.setEnableSwitch(true);
        deviceOptionModel4.setChecked(false);
        arrayList.add(deviceOptionModel4);
        com.example.test.utils.k a10 = y1.a();
        Integer valueOf2 = a10 != null ? Integer.valueOf(a10.z()) : null;
        if (valueOf2 != null) {
            if (valueOf2.intValue() == 0) {
                deviceOptionModel4.setChecked(false);
            } else {
                deviceOptionModel4.setChecked(true);
            }
        }
        DeviceOptionModel deviceOptionModel5 = new DeviceOptionModel(R$id.av_take_photo, 10086);
        deviceOptionModel5.setActionType(0);
        deviceOptionModel5.setOptionRes(R$mipmap.settings_option_camera);
        deviceOptionModel5.setOptionStr(R$string.str_take_photo);
        Context f02 = f0();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("android.permission.CAMERA");
        arrayList2.add("android.permission.WRITE_EXTERNAL_STORAGE");
        arrayList2.add("android.permission.READ_EXTERNAL_STORAGE");
        deviceOptionModel5.setEnableSwitch(nd.c.j(f02, arrayList2));
        com.example.test.utils.k a11 = y1.a();
        deviceOptionModel5.setChecked(a11 != null ? a11.J(com.example.test.service.e.h().g().f18212c) : false);
        arrayList.add(deviceOptionModel5);
        DeviceOptionModel deviceOptionModel6 = new DeviceOptionModel(R$id.av_led_light, 10086);
        deviceOptionModel6.setActionType(0);
        deviceOptionModel6.setOptionRes(R$mipmap.settings_option_screen);
        deviceOptionModel6.setOptionStr(R$string.str_ring_screen_light);
        arrayList.add(deviceOptionModel6);
        DeviceOptionModel deviceOptionModel7 = new DeviceOptionModel(R$id.av_vibration, 10086);
        deviceOptionModel7.setActionType(0);
        deviceOptionModel7.setOptionRes(R$mipmap.settings_option_vibration);
        deviceOptionModel7.setOptionStr(R$string.ring_str_item_vibration);
        arrayList.add(deviceOptionModel7);
        DeviceOptionModel deviceOptionModel8 = new DeviceOptionModel(R$id.av_alarm_reminder, 10086);
        deviceOptionModel8.setActionType(0);
        deviceOptionModel8.setOptionRes(R$mipmap.alarm_reminder);
        deviceOptionModel8.setOptionStr(R$string.str_alarm);
        arrayList.add(deviceOptionModel8);
        DeviceOptionModel deviceOptionModel9 = new DeviceOptionModel(R$id.av_app_unit, 10086);
        deviceOptionModel9.setActionType(0);
        deviceOptionModel9.setOptionRes(R$mipmap.settings_option_unit);
        deviceOptionModel9.setOptionStr(R$string.ring_item_unit_title);
        arrayList.add(deviceOptionModel9);
        com.example.test.utils.k a12 = y1.a();
        User d5 = a12 != null ? a12.d() : null;
        if (d5 == null || d5.getMeterUnit() != 0) {
            deviceOptionModel9.setOptionHint(f0().getString(R$string.str_unit_imperial));
        } else {
            deviceOptionModel9.setOptionHint(f0().getString(R$string.str_unit_metric));
        }
        DeviceOptionModel deviceOptionModel10 = new DeviceOptionModel(R$id.av_wear_direction, 10086);
        deviceOptionModel10.setActionType(0);
        deviceOptionModel10.setOptionRes(R$mipmap.settings_option_wear);
        deviceOptionModel10.setOptionStr(R$string.str_ring_direction);
        arrayList.add(deviceOptionModel10);
        DeviceOptionModel deviceOptionModel11 = new DeviceOptionModel(R$id.av_health_monitor, 10086);
        deviceOptionModel11.setActionType(0);
        deviceOptionModel11.setOptionRes(R$mipmap.ring_dev_item_healthmonitor);
        deviceOptionModel11.setOptionStr(R$string.ring_item_healthmonitor_title);
        arrayList.add(deviceOptionModel11);
        DeviceOptionModel deviceOptionModel12 = new DeviceOptionModel(R$id.av_search_device, 10086);
        deviceOptionModel12.setActionType(0);
        deviceOptionModel12.setOptionRes(R$mipmap.settings_option_search);
        deviceOptionModel12.setOptionStr(R$string.str_search_device);
        arrayList.add(deviceOptionModel12);
        DeviceOptionModel deviceOptionModel13 = new DeviceOptionModel(R$id.av_video_hid, 10086);
        deviceOptionModel13.setActionType(0);
        deviceOptionModel13.setOptionRes(R$mipmap.settings_optio_video);
        deviceOptionModel13.setOptionStr(R$string.ring_item_hid_title);
        deviceOptionModel13.setEnableSwitch(false);
        arrayList.add(deviceOptionModel13);
        DeviceOptionModel deviceOptionModel14 = new DeviceOptionModel(R$id.av_restart, 10086);
        deviceOptionModel14.setActionType(0);
        deviceOptionModel14.setOptionRes(R$mipmap.settings_option_firmware);
        deviceOptionModel14.setOptionStr(R$string.str_ring_ota);
        arrayList.add(deviceOptionModel14);
        DeviceOptionModel deviceOptionModel15 = new DeviceOptionModel(R$id.av_app_feedback, 10086);
        deviceOptionModel15.setActionType(0);
        deviceOptionModel15.setOptionRes(R$mipmap.ring_dev_item_feedback);
        deviceOptionModel15.setOptionStr(R$string.ring_item_feedback_title);
        arrayList.add(deviceOptionModel15);
        DeviceOptionModel deviceOptionModel16 = new DeviceOptionModel(R$id.av_app_problem, 10086);
        deviceOptionModel16.setActionType(0);
        deviceOptionModel16.setOptionRes(R$mipmap.ring_dev_item_issue);
        deviceOptionModel16.setOptionStr(R$string.ring_item_issue_title);
        arrayList.add(deviceOptionModel16);
        DeviceOptionModel deviceOptionModel17 = new DeviceOptionModel(R$id.av_app_theme, 10086);
        deviceOptionModel17.setActionType(0);
        deviceOptionModel17.setOptionRes(R$mipmap.settings_option_theme);
        deviceOptionModel17.setOptionStr(R$string.ring_item_theme_title);
        arrayList.add(deviceOptionModel17);
        DeviceOptionModel deviceOptionModel18 = new DeviceOptionModel(R$id.av_sleep_mode, 10086);
        deviceOptionModel18.setActionType(0);
        deviceOptionModel18.setOptionRes(R$mipmap.settings_option_sleep_mode);
        deviceOptionModel18.setOptionStr(R$string.ring_str_item_sleepmode);
        arrayList.add(deviceOptionModel18);
        DeviceOptionModel deviceOptionModel19 = new DeviceOptionModel(R$id.av_recover, 10086);
        deviceOptionModel19.setActionType(0);
        deviceOptionModel19.setOptionRes(R$mipmap.settings_option_factory);
        deviceOptionModel19.setOptionStr(R$string.str_recover);
        arrayList.add(deviceOptionModel19);
        DeviceOptionModel deviceOptionModel20 = new DeviceOptionModel(R$id.av_power_off, 10086);
        deviceOptionModel20.setActionType(3);
        deviceOptionModel20.setOptionRes(R$mipmap.settings_option_shutdown);
        deviceOptionModel20.setOptionStr(R$string.str_device_shutdown);
        arrayList.add(deviceOptionModel20);
        arrayList.add(new DeviceOptionModel(10087));
        return arrayList;
    }

    public final void F0() {
        this.f8219l = false;
        z0().setBindStatus(0);
        u3 u3Var = (u3) this.f7251b;
        if (u3Var != null) {
            u3Var.f13380b.setBindModel(z0());
        }
        int a3 = A0().a(R$id.av_take_photo);
        if (a3 > -1) {
            A0().getData().get(a3).setEnableSwitch(false);
            A0().getData().get(a3).setChecked(false);
        }
        this.f8220m = A0().getData();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            kVar.Q("");
        }
    }

    public final void G0(PowerBean powerBean) {
        TRingDeviceInfoView tRingDeviceInfoView;
        kotlin.jvm.internal.e.f(powerBean, "powerBean");
        z0().setPower(powerBean.getPower());
        z0().setPowering(powerBean.getPowerStatus() != 0);
        z0().setLowPower(powerBean.isLowPower());
        u3 u3Var = (u3) this.f7251b;
        if (u3Var != null && (tRingDeviceInfoView = u3Var.f13380b) != null) {
            tRingDeviceInfoView.setBindModel(z0());
        }
        r5.a.h(powerBean.getPower(), "onAttachPowerInfo ", "qob");
    }

    public final void H0(BrightScreenLedBean data) {
        kotlin.jvm.internal.e.f(data, "data");
        u0().setOpen(data.isOpen());
        u0().setLcdLevel(data.getLcdLevel());
        int a3 = A0().a(R$id.av_led_light);
        DeviceOptionModel deviceOptionModel = A0().getData().get(a3);
        kotlin.jvm.internal.e.d(deviceOptionModel, "null cannot be cast to non-null type com.example.test.ui.device.model.DeviceOptionModel");
        DeviceOptionModel deviceOptionModel2 = deviceOptionModel;
        Log.d("tong", "get BrightScreenLedBean position = " + a3);
        if (u0().isOpen()) {
            int lcdLevel = u0().getLcdLevel();
            if (lcdLevel == 1) {
                deviceOptionModel2.setOptionHint(f0().getString(R$string.str_ring_screen_light_1));
            } else if (lcdLevel == 2) {
                deviceOptionModel2.setOptionHint(f0().getString(R$string.str_ring_screen_light_2));
            } else if (lcdLevel == 3) {
                deviceOptionModel2.setOptionHint(f0().getString(R$string.str_ring_screen_light_3));
            }
        } else {
            deviceOptionModel2.setOptionHint(f0().getString(R$string.str_ring_screen_light_0));
        }
        A0().notifyItemChanged(a3);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final com.example.baselibrary.preseneter.b I() {
        return new r1(this);
    }

    public final void I0(int i3) {
        int a3 = A0().a(R$id.av_remember);
        if (a3 == -1) {
            return;
        }
        DeviceOptionModel deviceOptionModel = A0().getData().get(a3);
        kotlin.jvm.internal.e.d(deviceOptionModel, "null cannot be cast to non-null type com.example.test.ui.device.model.DeviceOptionModel");
        deviceOptionModel.setChecked(i3 > 0);
        A0().notifyItemChanged(a3);
    }

    public final void J0() {
        b0();
        this.f8219l = false;
        F0();
        u3 u3Var = (u3) this.f7251b;
        if (u3Var != null) {
            u3Var.f13380b.setLinkedStatus(0);
        }
        ((TMainRingActivity) f0()).finish();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            kVar.Y(0);
        }
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
        if (kVar2 != null) {
            kVar2.b0();
        }
        f0().startActivity(new Intent(f0(), (Class<?>) TRingDeviceScanActivity.class));
        int i3 = this.f8229w;
        if (i3 == this.f8231y) {
            this.f8229w = 0;
        } else if (i3 == this.f8232z) {
            this.f8229w = 0;
        }
    }

    public final void K0(VideoHidBean data) {
        kotlin.jvm.internal.e.f(data, "data");
        C0().setOpen(data.isOpen());
        C0().setDefaultOpen(data.isDefaultOpen());
        C0().setHidOpen(data.getHidOpen());
        int a3 = A0().a(R$id.av_video_hid);
        if (a3 == -1) {
            return;
        }
        DeviceOptionModel deviceOptionModel = A0().getData().get(a3);
        kotlin.jvm.internal.e.d(deviceOptionModel, "null cannot be cast to non-null type com.example.test.ui.device.model.DeviceOptionModel");
        DeviceOptionModel deviceOptionModel2 = deviceOptionModel;
        if (C0().getHidOpen() == 1) {
            deviceOptionModel2.setOptionHint(f0().getString(R$string.ring_item_hid_setting_vedio));
        } else if (C0().getHidOpen() == 2) {
            deviceOptionModel2.setOptionHint(f0().getString(R$string.ring_item_hid_setting_book));
        } else if (C0().getHidOpen() == 3) {
            deviceOptionModel2.setOptionHint(f0().getString(R$string.ring_item_hid_setting_music));
        } else {
            deviceOptionModel2.setOptionHint(f0().getString(R$string.str_ring_screen_light_0));
        }
        A0().notifyItemChanged(a3);
    }

    public final void L0(int i3) {
        int a3 = A0().a(R$id.av_wear_direction);
        if (a3 == -1) {
            return;
        }
        DeviceOptionModel deviceOptionModel = A0().getData().get(a3);
        kotlin.jvm.internal.e.d(deviceOptionModel, "null cannot be cast to non-null type com.example.test.ui.device.model.DeviceOptionModel");
        DeviceOptionModel deviceOptionModel2 = deviceOptionModel;
        if (i3 == 0) {
            deviceOptionModel2.setOptionHint(f0().getString(R$string.str_ring_direction_left));
        } else {
            deviceOptionModel2.setOptionHint(f0().getString(R$string.str_ring_direction_right));
        }
        A0().notifyItemChanged(a3);
    }

    public final void M0() {
        u3 u3Var = (u3) this.f7251b;
        if (u3Var != null) {
            u3Var.f13380b.setLinkedStatus(1);
        }
        this.f8219l = true;
        Object obj = com.example.test.utils.m.f8734b;
        Log.e("qob", "refreshDeviceInfo 蓝牙已连接刷新功能表 isSupportHealthRing " + d2.a().c());
        D0();
        r1 r1Var = (r1) X();
        r1Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DevicePresenter", "======== initDeviceInfo");
        com.google.android.gms.internal.mlkit_vision_common.p.U((m1) r1Var.f7554b.getValue());
        com.google.android.gms.internal.mlkit_vision_common.p.h();
        ((r1) X()).getClass();
        ((r1) X()).k();
        u3 u3Var2 = (u3) this.f7251b;
        if (u3Var2 != null) {
            TRingDeviceInfoView tRingDeviceInfoView = u3Var2.f13380b;
            String string = getString(R$string.str_unbind);
            kotlin.jvm.internal.e.e(string, "getString(...)");
            tRingDeviceInfoView.setOtaText(string);
        }
    }

    public final void N0(int i3) {
        if (com.example.test.service.e.h().i()) {
            this.f8229w = i3;
            ((r1) X()).o();
            return;
        }
        r1 r1Var = (r1) X();
        r1Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "======== unbindLocal");
        com.example.test.service.e.h().q();
        ((TRingDeviceFragment) ((g7.z) r1Var.f7255a)).J0();
        if (i3 == this.f8231y) {
            startActivity(new Intent(f0(), (Class<?>) ScanQrCodeActivity.class));
            this.f8229w = 0;
        } else if (i3 == this.f8232z) {
            startActivity(new Intent(f0(), (Class<?>) DeviceScanActivity.class));
            this.f8229w = 0;
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        u3 u3Var = (u3) this.f7251b;
        if (u3Var != null) {
            return u3Var.f13379a;
        }
        return null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R$layout.fragment_tring_device, viewGroup, false);
        int i3 = R$id.device_info_view;
        TRingDeviceInfoView tRingDeviceInfoView = (TRingDeviceInfoView) he.a(i3, inflate);
        if (tRingDeviceInfoView != null) {
            i3 = R$id.device_option_list;
            RecyclerView recyclerView = (RecyclerView) he.a(i3, inflate);
            if (recyclerView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) inflate;
                int i10 = R$id.textView;
                if (((TextView) he.a(i10, inflate)) != null) {
                    return new u3(relativeLayout, tRingDeviceInfoView, recyclerView, relativeLayout);
                }
                i3 = i10;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void e0() {
        registerForActivityResult(new androidx.fragment.app.o0(2), new n(this, 0));
    }

    @Override // p5.a
    public final Context f0() {
        Context requireContext = requireContext();
        kotlin.jvm.internal.e.e(requireContext, "requireContext(...)");
        return requireContext;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void h0() {
        Log.d("tong", "TRingDeviceFragment ---initData");
        if (com.example.test.service.e.h().i()) {
            u3 u3Var = (u3) this.f7251b;
            if (u3Var != null) {
                u3Var.f13380b.setLinkedStatus(1);
                return;
            }
            return;
        }
        u3 u3Var2 = (u3) this.f7251b;
        if (u3Var2 != null) {
            u3Var2.f13380b.setLinkedStatus(0);
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void m0() {
        b2.a(this);
        u3 u3Var = (u3) this.f7251b;
        if (u3Var != null) {
            RecyclerView recyclerView = u3Var.f13381c;
            f0();
            recyclerView.setLayoutManager(new LinearLayoutManager(1));
            recyclerView.setAdapter(A0());
            recyclerView.setItemAnimator(null);
        }
        A0().setOnItemClickListener(new n(this, 4));
        A0().addChildClickViewIds(R$id.switch_enable_view);
        A0().setOnItemChildClickListener(new n(this, 5));
        A0().setOnSwitchItemStatusListener(new n(this, 6));
        u3 u3Var2 = (u3) this.f7251b;
        if (u3Var2 != null) {
            u3Var2.f13380b.setBindClickListener(this);
        }
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null && kVar.c() != null) {
            this.f8219l = true;
        }
        if (this.f8219l) {
            D0();
        } else {
            F0();
        }
        ((r1) X()).k();
        u3 u3Var3 = (u3) this.f7251b;
        if (u3Var3 != null) {
            u3Var3.f13380b.setOnViewClickListener(new p(this, 0));
        }
        M0();
    }

    @Override // g7.z
    @yh.k(threadMode = ThreadMode.MAIN)
    public void onAttachFirmware(FirmVersionBean firmVersionBean) {
        Devices c9;
        kotlin.jvm.internal.e.f(firmVersionBean, "firmVersionBean");
        Log.e("qob", "TRingDeviceFragment onAttachFirmware");
        z0().setVersion(firmVersionBean.getDeviceNo());
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (c9 = kVar.c()) == null) {
            return;
        }
        Log.e("qob", "onAttachFirmware " + c9.getDeviceModel());
        r1 r1Var = (r1) X();
        String deviceModel = c9.getDeviceModel();
        kotlin.jvm.internal.e.e(deviceModel, "getDeviceModel(...)");
        r1Var.getClass();
        rg.l<HttpModel<DeviceModelInfoBean>> modelInfo = ((DeviceApi) c6.b.f3390c.f113a).getModelInfo(deviceModel);
        kotlin.jvm.internal.e.e(modelInfo, "getModelInfo(...)");
        com.example.baselibrary.utils.b.w(modelInfo).subscribe(new com.example.test.presenter.main.d0(deviceModel, r1Var, ((TRingDeviceFragment) ((g7.z) r1Var.f7255a)).f0(), com.example.test.utils.w0.d(), 1));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.btnBind;
        if (valueOf != null && valueOf.intValue() == i3) {
            XXApplication xXApplication = XXApplication.f7400h;
            boolean d5 = com.example.test.utils.t.d(j1.a());
            boolean n4 = com.example.baselibrary.utils.b.n(j1.a());
            if (!n4) {
                ((com.example.test.ui.dialog.r) this.D.getValue()).show();
                d5 = n4;
            } else if (!d5) {
                ((com.example.test.ui.dialog.r) this.C.getValue()).show();
            }
            if (d5) {
                if (nd.c.j(f0(), android.support.v4.media.session.e.s("android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_ADVERTISE", "android.permission.BLUETOOTH_CONNECT", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"))) {
                    f0().startActivity(new Intent(f0(), (Class<?>) DeviceScanActivity.class));
                } else {
                    this.A = 1;
                    ((com.example.test.ui.dialog.i) this.B.getValue()).show();
                }
            }
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceFunEvent(EventBusBeans.DeviceFunEvent deviceEvent) {
        kotlin.jvm.internal.e.f(deviceEvent, "deviceEvent");
        if (deviceEvent.getDeviceFunType() == 2) {
            J0();
        } else {
            if (deviceEvent.getDeviceFunType() == 91 || deviceEvent.getDeviceFunType() != 92) {
                return;
            }
            ((r1) X()).l();
        }
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceStatusEvent(EventBusBeans.DeviceStatusEvent deviceStatusEvent) {
        kotlin.jvm.internal.e.f(deviceStatusEvent, "deviceStatusEvent");
        r5.a.h(deviceStatusEvent.getStatus(), "onDeviceStatusEvent ", "qob");
        Object obj = com.example.test.service.p0.f7741g;
        com.google.android.gms.internal.mlkit_vision_barcode.m1.a().f7742a = false;
        z0().setHasNew(false);
        int status = deviceStatusEvent.getStatus();
        if (status == 1) {
            M0();
            return;
        }
        if (status == 2) {
            u3 u3Var = (u3) this.f7251b;
            if (u3Var != null) {
                u3Var.f13380b.setLinkedStatus(2);
                return;
            }
            return;
        }
        if (status == 3) {
            u3 u3Var2 = (u3) this.f7251b;
            if (u3Var2 != null) {
                u3Var2.f13380b.setLinkedStatus(2);
                return;
            }
            return;
        }
        if (status == 6) {
            J0();
            return;
        }
        if (status == 7) {
            Log.e("qob", "DEVICE_JL_OTA_ERROR_INFO");
            if (this.f8219l) {
                return;
            }
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null) {
                kVar.V(true);
            }
            String address = r5.b.k().f18057g.getAddress();
            kotlin.jvm.internal.e.c(address);
            com.google.android.gms.internal.mlkit_vision_barcode.m1.a().g(ca.b(address));
            return;
        }
        b0();
        if (com.example.test.service.e.h().g().f18213d == 2) {
            u3 u3Var3 = (u3) this.f7251b;
            if (u3Var3 != null) {
                u3Var3.f13380b.setLinkedStatus(2);
            }
        } else if (com.example.test.service.e.h().g().f18213d == 1) {
            u3 u3Var4 = (u3) this.f7251b;
            if (u3Var4 != null) {
                u3Var4.f13380b.setLinkedStatus(1);
            }
        } else {
            u3 u3Var5 = (u3) this.f7251b;
            if (u3Var5 != null) {
                u3Var5.f13380b.setLinkedStatus(0);
            }
        }
        int a3 = A0().a(R$id.av_take_photo);
        if (a3 > -1) {
            List list = this.f8220m;
            if (list != null) {
                ((DeviceOptionModel) list.get(a3)).setEnableSwitch(false);
            }
            A0().notifyItemChanged(a3);
        }
        int a10 = A0().a(R$id.av_weather);
        if (a10 > -1) {
            List list2 = this.f8220m;
            if (list2 != null) {
                ((DeviceOptionModel) list2.get(a10)).setEnableSwitch(false);
            }
            A0().notifyItemChanged(a10);
        }
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onDeviceSupportEvent(EventBusBeans.DeviceSupportEvent deviceSupportEvent) {
        u3 u3Var;
        int a3;
        kotlin.jvm.internal.e.f(deviceSupportEvent, "deviceSupportEvent");
        Object obj = com.example.test.utils.m.f8734b;
        com.example.test.utils.m a10 = d2.a();
        SupportMenuBean supportMenuBean = deviceSupportEvent.getSupportMenuBean();
        kotlin.jvm.internal.e.e(supportMenuBean, "getSupportMenuBean(...)");
        a10.getClass();
        a10.f8735a = supportMenuBean;
        SupportMenuBean supportMenuBean2 = d2.a().f8735a;
        if (supportMenuBean2 != null ? supportMenuBean2.isBLESupport_Function_V2() : true) {
            SupportMenuBean supportMenuBean3 = d2.a().f8735a;
            if (!(supportMenuBean3 != null ? supportMenuBean3.isBLESupport_Function_V2_Get_OK() : true)) {
                return;
            }
        }
        SupportMenuBean supportMenuBean4 = d2.a().f8735a;
        if ((supportMenuBean4 != null ? supportMenuBean4.isDefaultNoViewWorkout() : false) && com.example.test.service.e.h().f7690j) {
            com.example.test.service.e.h().f7690j = false;
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            User d5 = kVar != null ? kVar.d() : null;
            if (d5 != null) {
                d5.setMeterUnit(1);
            }
            ((r1) X()).m(d5, 5);
            int a11 = A0().a(R$id.av_app_unit);
            if (a11 > 0) {
                DeviceOptionModel deviceOptionModel = A0().getData().get(a11);
                kotlin.jvm.internal.e.d(deviceOptionModel, "null cannot be cast to non-null type com.example.test.ui.device.model.DeviceOptionModel");
                deviceOptionModel.setOptionHint(f0().getString(R$string.str_unit_imperial));
                A0().notifyItemChanged(a11);
            }
        }
        SupportMenuBean supportMenuBean5 = d2.a().f8735a;
        if (supportMenuBean5 != null ? supportMenuBean5.isDefaultNoViewWorkout() : false) {
            SupportMenuBean supportMenuBean6 = d2.a().f8735a;
            if ((supportMenuBean6 != null ? supportMenuBean6.isDefaultENSYSTEM() : false) && (a3 = A0().a(R$id.av_app_feedback)) > 0) {
                DeviceOptionModel deviceOptionModel2 = A0().getData().get(a3);
                kotlin.jvm.internal.e.d(deviceOptionModel2, "null cannot be cast to non-null type com.example.test.ui.device.model.DeviceOptionModel");
                deviceOptionModel2.setOptionStr(R$string.ring_str_contact_support);
                A0().notifyItemChanged(a3);
            }
        }
        SupportMenuBean supportMenuBean7 = d2.a().f8735a;
        if (!(supportMenuBean7 != null ? supportMenuBean7.isTakePhoto() : true)) {
            A0().b(R$id.av_take_photo);
        }
        SupportMenuBean supportMenuBean8 = d2.a().f8735a;
        if (!(supportMenuBean8 != null ? supportMenuBean8.isMsgNotification() : true)) {
            A0().b(R$id.av_msg);
        }
        SupportMenuBean supportMenuBean9 = d2.a().f8735a;
        if (!(supportMenuBean9 != null ? supportMenuBean9.isLEDLight() : true)) {
            A0().b(R$id.av_led_light);
        }
        SupportMenuBean supportMenuBean10 = d2.a().f8735a;
        if (!(supportMenuBean10 != null ? supportMenuBean10.isSupportMotoVibrationLevel() : false)) {
            A0().b(R$id.av_vibration);
        }
        SupportMenuBean supportMenuBean11 = d2.a().f8735a;
        if (!(supportMenuBean11 != null ? supportMenuBean11.isWearDir() : true)) {
            A0().b(R$id.av_wear_direction);
        }
        SupportMenuBean supportMenuBean12 = d2.a().f8735a;
        if (!(supportMenuBean12 != null ? supportMenuBean12.isDrink() : true)) {
            A0().b(R$id.av_drink);
        }
        SupportMenuBean supportMenuBean13 = d2.a().f8735a;
        if (!(supportMenuBean13 != null ? supportMenuBean13.isFindDevice() : true)) {
            A0().b(R$id.av_search_device);
        }
        SupportMenuBean supportMenuBean14 = d2.a().f8735a;
        if (!(supportMenuBean14 != null ? supportMenuBean14.isRecovery() : true)) {
            A0().b(R$id.av_recover);
        }
        SupportMenuBean supportMenuBean15 = d2.a().f8735a;
        if (!(supportMenuBean15 != null ? supportMenuBean15.isPowerOff() : true)) {
            A0().b(R$id.av_power_off);
        }
        SupportMenuBean supportMenuBean16 = d2.a().f8735a;
        if (!(supportMenuBean16 != null ? supportMenuBean16.isHrMonitor() : true)) {
            A0().b(R$id.av_hr_watcher);
        }
        SupportMenuBean supportMenuBean17 = d2.a().f8735a;
        if (!(supportMenuBean17 != null ? supportMenuBean17.isDND() : true)) {
            A0().b(R$id.av_no_disturb);
        }
        SupportMenuBean supportMenuBean18 = d2.a().f8735a;
        if (!(supportMenuBean18 != null ? supportMenuBean18.isWeather() : true)) {
            A0().b(R$id.av_weather);
        }
        SupportMenuBean supportMenuBean19 = d2.a().f8735a;
        if (!(supportMenuBean19 != null ? supportMenuBean19.isAddressBook() : true)) {
            A0().b(R$id.av_address_book);
        }
        SupportMenuBean supportMenuBean20 = d2.a().f8735a;
        if (!(supportMenuBean20 != null ? supportMenuBean20.isFirmwareUpdate() : true) && (u3Var = (u3) this.f7251b) != null) {
            u3Var.f13380b.setOtaStatus(false);
        }
        SupportMenuBean supportMenuBean21 = d2.a().f8735a;
        if (!(supportMenuBean21 != null ? supportMenuBean21.isBreathe() : false)) {
            A0().b(R$id.av_breathe);
        }
        SupportMenuBean supportMenuBean22 = d2.a().f8735a;
        if (!(supportMenuBean22 != null ? supportMenuBean22.isAlarm() : true)) {
            A0().b(R$id.av_alarm_reminder);
        }
        SupportMenuBean supportMenuBean23 = d2.a().f8735a;
        if (!(supportMenuBean23 != null ? supportMenuBean23.isWomenHealth() : true)) {
            A0().b(R$id.av_women);
        }
        SupportMenuBean supportMenuBean24 = d2.a().f8735a;
        if (!(supportMenuBean24 != null ? supportMenuBean24.isQrCode() : true)) {
            A0().b(R$id.av_qr_code);
        }
        if (d2.a().c()) {
            A0().b(R$id.av_incoming_call);
        }
        SupportMenuBean supportMenuBean25 = d2.a().f8735a;
        if (!(supportMenuBean25 != null ? supportMenuBean25.isVideoHid() : true)) {
            A0().b(R$id.av_video_hid);
        }
        SupportMenuBean supportMenuBean26 = d2.a().f8735a;
        if (!(supportMenuBean26 != null ? supportMenuBean26.isLEDLight() : true)) {
            A0().b(R$id.av_led_light);
        }
        SupportMenuBean supportMenuBean27 = d2.a().f8735a;
        if (!(supportMenuBean27 != null ? supportMenuBean27.isBrightScreenTime() : true)) {
            A0().b(R$id.av_sleep_mode);
        }
        SupportMenuBean supportMenuBean28 = d2.a().f8735a;
        if (!(supportMenuBean28 != null ? supportMenuBean28.isBrightScreen() : true)) {
            A0().b(R$id.av_screen_light);
        }
        SupportMenuBean supportMenuBean29 = d2.a().f8735a;
        if (supportMenuBean29 != null ? supportMenuBean29.isRememberSwitch() : false) {
            return;
        }
        A0().b(R$id.av_remember);
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onFirmUpgradeEvent(EventBusBeans.FirmwareEvent firmwareEvent) {
        TRingDeviceInfoView tRingDeviceInfoView;
        String downloadUrl;
        kotlin.jvm.internal.e.f(firmwareEvent, "firmwareEvent");
        if (firmwareEvent.getStatus() == 11) {
            b0();
            return;
        }
        b0();
        z0().setHasNew((firmwareEvent.getFirmwareInfoBean() == null || (downloadUrl = firmwareEvent.getFirmwareInfoBean().getDownloadUrl()) == null || downloadUrl.length() == 0) ? false : true);
        u3 u3Var = (u3) this.f7251b;
        if (u3Var == null || (tRingDeviceInfoView = u3Var.f13380b) == null) {
            return;
        }
        tRingDeviceInfoView.setBindModel(z0());
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onPowerEvent(EventBusBeans.DevicePowerEvent powerEvent) {
        kotlin.jvm.internal.e.f(powerEvent, "powerEvent");
        Log.e("qob", "TRingDeviceFragment onPowerEvent " + powerEvent.getPowerBean().getPower() + " isFragmentVisible " + this.f8221n);
        PowerBean powerBean = powerEvent.getPowerBean();
        if (powerBean != null) {
            G0(powerBean);
        }
        if (powerEvent.getPowerBean().getPower() < 20 && !this.f8212d) {
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null && kVar.y() == 1 && this.f8221n) {
                this.f8212d = true;
                ((com.example.test.ui.dialog.r) this.f8227u.getValue()).show();
                return;
            }
        }
        Object obj = com.example.test.service.p0.f7741g;
        if (!com.google.android.gms.internal.mlkit_vision_barcode.m1.a().f7742a && this.f8221n && z0().isHasNew()) {
            com.google.android.gms.internal.mlkit_vision_barcode.m1.a().f7742a = true;
            if (B0().isShowing()) {
                return;
            }
            B0().b(R$string.str_new_version_found);
            B0().setOnDialogListener(new r(this));
            B0().show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Log.e("qob", "TRingDeviceFragment onResume");
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void onSyncStatusEvent(EventBusBeans.SyncStatusEvent syncStatusEvent) {
        kotlin.jvm.internal.e.f(syncStatusEvent, "syncStatusEvent");
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceFragment", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(this.f8229w, "========= onSyncStatusEvent "));
    }

    public final void q0() {
        u3 u3Var;
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        RelativeLayout relativeLayout3;
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        Integer valueOf = kVar != null ? Integer.valueOf(kVar.D()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            u3 u3Var2 = (u3) this.f7251b;
            if (u3Var2 != null && (relativeLayout3 = u3Var2.f13382d) != null) {
                relativeLayout3.setBackgroundColor(a1.d.a(f0(), R$color.color_black));
            }
        } else if (valueOf != null && valueOf.intValue() == 1) {
            u3 u3Var3 = (u3) this.f7251b;
            if (u3Var3 != null && (relativeLayout2 = u3Var3.f13382d) != null) {
                relativeLayout2.setBackgroundColor(a1.d.a(f0(), R$color.color_greywhite));
            }
        } else if (valueOf != null && valueOf.intValue() == 2 && (u3Var = (u3) this.f7251b) != null && (relativeLayout = u3Var.f13382d) != null) {
            relativeLayout.setBackgroundColor(a1.d.a(f0(), R$color.color_pink));
        }
        u3 u3Var4 = (u3) this.f7251b;
        if (u3Var4 != null) {
            u3Var4.f13380b.a();
        }
        u3 u3Var5 = (u3) this.f7251b;
        if (u3Var5 != null) {
            u3Var5.f13380b.setBindModel(z0());
        }
        A0().notifyDataSetChanged();
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            com.example.baselibrary.utils.b.x("", new oh.l() { // from class: com.example.test.ui.testui.TRingDeviceFragment$onMessage$1
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return eh.g.f12633a;
                }

                public final void invoke(String it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    com.example.baselibrary.utils.d.b("拍照");
                    new Thread(new com.example.blesdk.service.z(2)).start();
                }
            }, new oh.l() { // from class: com.example.test.ui.testui.TRingDeviceFragment$onMessage$2
                public final void invoke(eh.g it) {
                    kotlin.jvm.internal.e.f(it, "it");
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((eh.g) obj);
                    return eh.g.f12633a;
                }
            });
        } else {
            ((com.example.test.ui.dialog.h) this.f8228v.getValue()).dismiss();
            this.f8219l = true;
            D0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean z5) {
        super.setUserVisibleHint(z5);
        Log.e("qob", "TRingDeviceFragment setUserVisibleHint " + z5);
        this.f8221n = z5;
        if (z5) {
            com.google.android.gms.internal.mlkit_vision_common.p.U((o1) ((r1) X()).f7555c.getValue());
            com.google.android.gms.internal.mlkit_vision_common.p.i();
            ((r1) X()).k();
        }
    }

    public final BrightScreenLedBean u0() {
        return (BrightScreenLedBean) this.e.getValue();
    }

    public final DeviceInfoModel z0() {
        return (DeviceInfoModel) this.F.getValue();
    }
}
