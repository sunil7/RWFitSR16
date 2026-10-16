package com.example.test.ui.device.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.blesdk.bean.function.PowerBean;
import com.example.database.table.Devices;
import com.example.network.bean.FirmwareInfoBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.presenter.device.y0;
import com.example.test.presenter.device.z0;
import com.example.test.service.p0;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.ProgressButtonView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.m1;
import f6.a1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes.dex */
public final class OtaActivity extends XXBaseActivity<z0, a1> implements f7.u, View.OnClickListener {
    public static final /* synthetic */ int J = 0;
    public boolean E;
    public boolean F;
    public PowerBean G;
    public FirmwareInfoBean H;
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.OtaActivity$powerTipsDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.r invoke() {
            com.example.test.ui.dialog.r rVar = new com.example.test.ui.dialog.r(OtaActivity.this);
            rVar.b(R$string.str_firmware_tips);
            rVar.a();
            return rVar;
        }
    });

    public OtaActivity() {
        kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.OtaActivity$updateType$2
            {
                super(0);
            }

            @Override // oh.a
            public final Integer invoke() {
                Intent intent = OtaActivity.this.getIntent();
                return Integer.valueOf(intent != null ? intent.getIntExtra("update_type", 0) : 1001);
            }
        });
    }

    public final void E(final float f2) {
        final String concat = String.format("%s: %.2f", Arrays.copyOf(new Object[]{getString(R$string.str_installing), Float.valueOf(f2)}, 2)).concat("%");
        runOnUiThread(new Runnable() { // from class: com.example.test.ui.device.activity.x
            @Override // java.lang.Runnable
            public final void run() {
                int i3 = OtaActivity.J;
                OtaActivity this$0 = OtaActivity.this;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                String progressStr = concat;
                kotlin.jvm.internal.e.f(progressStr, "$progressStr");
                eh.b bVar = this$0.f7247z;
                ((a1) bVar.getValue()).f12681b.setProgress(f2);
                ((a1) bVar.getValue()).f12681b.setText(progressStr);
            }
        });
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new z0(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((a1) this.f7247z.getValue()).f12680a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_ota, (ViewGroup) null, false);
        int i3 = R$id.progressBtn;
        ProgressButtonView progressButtonView = (ProgressButtonView) he.a(i3, inflate);
        if (progressButtonView != null) {
            i3 = R$id.titleView;
            TitleView titleView = (TitleView) he.a(i3, inflate);
            if (titleView != null) {
                i3 = R$id.tv_current_version;
                TextView textView = (TextView) he.a(i3, inflate);
                if (textView != null) {
                    i3 = R$id.tv_firmware_content;
                    TextView textView2 = (TextView) he.a(i3, inflate);
                    if (textView2 != null) {
                        i3 = R$id.tv_firmware_size;
                        TextView textView3 = (TextView) he.a(i3, inflate);
                        if (textView3 != null) {
                            i3 = R$id.tv_firmware_version;
                            TextView textView4 = (TextView) he.a(i3, inflate);
                            if (textView4 != null) {
                                i3 = R$id.updateNotice;
                                TextView textView5 = (TextView) he.a(i3, inflate);
                                if (textView5 != null) {
                                    return new a1((LinearLayout) inflate, progressButtonView, titleView, textView, textView2, textView3, textView4, textView5);
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
        ((z0) I0()).w();
        if (!y5.d.f20005b || y5.d.f20006c) {
            return;
        }
        z0 z0Var = (z0) I0();
        z0Var.getClass();
        XXApplication xXApplication = XXApplication.f7400h;
        k6.b bVar = new k6.b(j1.a());
        z0Var.f7499d = bVar;
        y0 y0Var = new y0(z0Var, 0);
        ArrayList arrayList = (ArrayList) bVar.e.f36a;
        if (arrayList.contains(y0Var)) {
            return;
        }
        arrayList.add(y0Var);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        Object obj = p0.f7741g;
        FirmwareInfoBean d5 = m1.a().d();
        this.H = d5;
        if (d5 == null) {
            kotlin.jvm.internal.e.m("bean");
            throw null;
        }
        Log.e("qob", "initView " + d5.getDownloadUrl());
        String string = getString(R$string.str_ota);
        kotlin.jvm.internal.e.e(string, "getString(...)");
        String string2 = getString(R$string.str_notes_ota);
        kotlin.jvm.internal.e.e(string2, "getString(...)");
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        Integer valueOf = kVar != null ? Integer.valueOf(kVar.x()) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            string2 = getString(R$string.str_notes_ota_ring);
            kotlin.jvm.internal.e.e(string2, "getString(...)");
        }
        FirmwareInfoBean firmwareInfoBean = this.H;
        if (firmwareInfoBean == null) {
            kotlin.jvm.internal.e.m("bean");
            throw null;
        }
        String downloadUrl = firmwareInfoBean.getDownloadUrl();
        if (downloadUrl == null || downloadUrl.length() == 0) {
            finish();
            return;
        }
        ((a1) this.f7247z.getValue()).f12682c.setOnTitleListener(new androidx.appcompat.app.t(this, 24));
        ((a1) this.f7247z.getValue()).f12682c.setTitle(string);
        ((a1) this.f7247z.getValue()).f12686h.setText(string2);
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
        Devices c9 = kVar2 != null ? kVar2.c() : null;
        TextView textView = ((a1) this.f7247z.getValue()).f12683d;
        Locale locale = Locale.ENGLISH;
        String string3 = getString(R$string.str_ota_current_version);
        String deviceVer = c9 != null ? c9.getDeviceVer() : null;
        if (deviceVer == null) {
            deviceVer = "1.0.0";
        }
        textView.setText(String.format(locale, "%sV%s", Arrays.copyOf(new Object[]{string3, deviceVer}, 2)));
        TextView textView2 = ((a1) this.f7247z.getValue()).f12685g;
        String string4 = getString(R$string.str_ota_version);
        FirmwareInfoBean firmwareInfoBean2 = this.H;
        if (firmwareInfoBean2 == null) {
            kotlin.jvm.internal.e.m("bean");
            throw null;
        }
        String toVersion = firmwareInfoBean2.getToVersion();
        if (toVersion == null) {
            toVersion = "1.0.1";
        }
        textView2.setText(String.format(locale, "%sV%s", Arrays.copyOf(new Object[]{string4, toVersion}, 2)));
        TextView textView3 = ((a1) this.f7247z.getValue()).f12684f;
        String string5 = getString(R$string.str_ota_filesize);
        FirmwareInfoBean firmwareInfoBean3 = this.H;
        if (firmwareInfoBean3 == null) {
            kotlin.jvm.internal.e.m("bean");
            throw null;
        }
        textView3.setText(String.format(locale, "%s%dKB", Arrays.copyOf(new Object[]{string5, Integer.valueOf(firmwareInfoBean3.getSize() / 1024)}, 2)));
        TextView textView4 = ((a1) this.f7247z.getValue()).e;
        String string6 = getString(R$string.str_ota_update_message);
        FirmwareInfoBean firmwareInfoBean4 = this.H;
        if (firmwareInfoBean4 == null) {
            kotlin.jvm.internal.e.m("bean");
            throw null;
        }
        textView4.setText(String.format(locale, "%s\n%s", Arrays.copyOf(new Object[]{string6, firmwareInfoBean4.getSummary()}, 2)));
        ((a1) this.f7247z.getValue()).f12681b.setText(getString(R$string.str_install));
        ((a1) this.f7247z.getValue()).f12681b.setEnable(true);
        ((a1) this.f7247z.getValue()).f12681b.setOnClickListener(this);
    }

    public final void R0(float f2) {
        String concat = String.format("%s: %.2f", Arrays.copyOf(new Object[]{getString(R$string.str_ota_check_file), Float.valueOf(((double) f2) > 99.8d ? 100.0f : f2)}, 2)).concat("%");
        eh.b bVar = this.f7247z;
        ((a1) bVar.getValue()).f12681b.setProgress(f2);
        ((a1) bVar.getValue()).f12681b.setText(concat);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.E) {
            w0(R$string.str_installing);
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PowerBean powerBean;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.progressBtn;
        if (valueOf != null && valueOf.intValue() == i3) {
            PowerBean powerBean2 = this.G;
            if (powerBean2 != null && ((powerBean2 == null || powerBean2.isLowPower()) && ((powerBean = this.G) == null || powerBean.getPowerStatus() != 1))) {
                ((com.example.test.ui.dialog.r) this.I.getValue()).show();
                return;
            }
            this.F = false;
            this.E = true;
            String concat = String.format("%s: %d", Arrays.copyOf(new Object[]{getString(R$string.str_downloading), 0}, 2)).concat("%");
            eh.b bVar = this.f7247z;
            ((a1) bVar.getValue()).f12681b.setProgress(0.0f);
            ((a1) bVar.getValue()).f12681b.setText(concat);
            com.example.test.utils.y.u().y(true);
            com.example.test.utils.y.u().A();
            z0 z0Var = (z0) I0();
            FirmwareInfoBean firmwareInfoBean = this.H;
            if (firmwareInfoBean == null) {
                kotlin.jvm.internal.e.m("bean");
                throw null;
            }
            String downloadUrl = firmwareInfoBean.getDownloadUrl();
            kotlin.jvm.internal.e.e(downloadUrl, "getDownloadUrl(...)");
            z0Var.getClass();
            z0Var.v(downloadUrl);
        }
    }
}
