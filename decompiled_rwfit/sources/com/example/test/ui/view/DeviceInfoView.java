package com.example.test.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.ui.device.model.DeviceInfoModel;

/* loaded from: classes.dex */
public final class DeviceInfoView extends LinearLayout {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f8381k = 0;

    /* renamed from: a, reason: collision with root package name */
    public final TextView f8382a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f8383b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f8384c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f8385d;
    public final TextView e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f8386f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f8387g;

    /* renamed from: h, reason: collision with root package name */
    public final PowerView f8388h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f8389i;

    /* renamed from: j, reason: collision with root package name */
    public final PointView f8390j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeviceInfoView(Context context) {
        this(context, null, 6, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public final void setBindClickListener(View.OnClickListener onClickListener) {
        kotlin.jvm.internal.e.f(onClickListener, "onClickListener");
        Button button = this.f8383b;
        if (button != null) {
            button.setOnClickListener(onClickListener);
        } else {
            kotlin.jvm.internal.e.m("btnBindBt");
            throw null;
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void setBindModel(DeviceInfoModel deviceInfoModel) {
        kotlin.jvm.internal.e.f(deviceInfoModel, "deviceInfoModel");
        if (deviceInfoModel.getBindStatus() == 1) {
            Button button = this.f8383b;
            if (button == null) {
                kotlin.jvm.internal.e.m("btnBindBt");
                throw null;
            }
            button.setVisibility(8);
            LinearLayout linearLayout = this.f8384c;
            if (linearLayout == null) {
                kotlin.jvm.internal.e.m("llBindLL");
                throw null;
            }
            linearLayout.setVisibility(0);
            String showUrl = deviceInfoModel.getShowUrl();
            if (showUrl != null && showUrl.length() != 0) {
                Context context = getContext();
                kotlin.jvm.internal.e.e(context, "getContext(...)");
                ImageView imageView = this.f8385d;
                if (imageView == null) {
                    kotlin.jvm.internal.e.m("deviceIconIv");
                    throw null;
                }
                String showUrl2 = deviceInfoModel.getShowUrl();
                kotlin.jvm.internal.e.e(showUrl2, "getShowUrl(...)");
                ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(context).n(showUrl2).o(true)).d(z3.h.f20239b)).x(imageView);
            }
        } else {
            Button button2 = this.f8383b;
            if (button2 == null) {
                kotlin.jvm.internal.e.m("btnBindBt");
                throw null;
            }
            button2.setVisibility(0);
            LinearLayout linearLayout2 = this.f8384c;
            if (linearLayout2 == null) {
                kotlin.jvm.internal.e.m("llBindLL");
                throw null;
            }
            linearLayout2.setVisibility(8);
            ImageView imageView2 = this.f8385d;
            if (imageView2 == null) {
                kotlin.jvm.internal.e.m("deviceIconIv");
                throw null;
            }
            imageView2.setImageResource(R$mipmap.ic_normal_dial);
        }
        TextView textView = this.e;
        if (textView == null) {
            kotlin.jvm.internal.e.m("macTv");
            throw null;
        }
        textView.setText("MAC:" + deviceInfoModel.getMac());
        String version = deviceInfoModel.getVersion();
        if (version != null && version.length() != 0) {
            TextView textView2 = this.f8386f;
            if (textView2 == null) {
                kotlin.jvm.internal.e.m("firmwareVersionTv");
                throw null;
            }
            textView2.setText(getContext().getString(R$string.str_firmware_version) + " V" + deviceInfoModel.getVersion());
        }
        TextView textView3 = this.f8387g;
        if (textView3 == null) {
            kotlin.jvm.internal.e.m("powerTv");
            throw null;
        }
        textView3.setText(deviceInfoModel.getPower() + "%");
        PowerView powerView = this.f8388h;
        if (powerView == null) {
            kotlin.jvm.internal.e.m("powerView");
            throw null;
        }
        powerView.f8518p = deviceInfoModel.isPowering();
        powerView.invalidate();
        PowerView powerView2 = this.f8388h;
        if (powerView2 == null) {
            kotlin.jvm.internal.e.m("powerView");
            throw null;
        }
        powerView2.setCurrentPower(deviceInfoModel.getPower());
        PowerView powerView3 = this.f8388h;
        if (powerView3 == null) {
            kotlin.jvm.internal.e.m("powerView");
            throw null;
        }
        powerView3.f8519q = deviceInfoModel.isLowPower();
        powerView3.invalidate();
        TextView textView4 = this.f8389i;
        if (textView4 == null) {
            kotlin.jvm.internal.e.m("nameTv");
            throw null;
        }
        textView4.setText(deviceInfoModel.getDeviceName());
        PointView pointView = this.f8390j;
        if (pointView != null) {
            pointView.setVisibility(deviceInfoModel.isHasNew() ? 0 : 8);
        } else {
            kotlin.jvm.internal.e.m("pointView");
            throw null;
        }
    }

    public final void setOnViewClickListener(View.OnClickListener onClickListener) {
        kotlin.jvm.internal.e.f(onClickListener, "onClickListener");
        TextView textView = this.f8382a;
        if (textView != null) {
            textView.setOnClickListener(new d(onClickListener, 0));
        } else {
            kotlin.jvm.internal.e.m("tvOtaTv");
            throw null;
        }
    }

    public final void setOtaStatus(boolean z5) {
        TextView textView = this.f8382a;
        if (textView != null) {
            textView.setVisibility(z5 ? 0 : 8);
        } else {
            kotlin.jvm.internal.e.m("tvOtaTv");
            throw null;
        }
    }

    public final void setOtaText(String text) {
        kotlin.jvm.internal.e.f(text, "text");
        TextView textView = this.f8382a;
        if (textView != null) {
            textView.setText(text);
        } else {
            kotlin.jvm.internal.e.m("tvOtaTv");
            throw null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeviceInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public /* synthetic */ DeviceInfoView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceInfoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        kotlin.jvm.internal.e.f(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_device_info, this);
        View findViewById = findViewById(R$id.tv_ota);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.f8382a = (TextView) findViewById;
        View findViewById2 = findViewById(R$id.btnBind);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.f8383b = (Button) findViewById2;
        View findViewById3 = findViewById(R$id.llBind);
        kotlin.jvm.internal.e.e(findViewById3, "findViewById(...)");
        this.f8384c = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R$id.deviceIcon);
        kotlin.jvm.internal.e.e(findViewById4, "findViewById(...)");
        this.f8385d = (ImageView) findViewById4;
        View findViewById5 = findViewById(R$id.mac);
        kotlin.jvm.internal.e.e(findViewById5, "findViewById(...)");
        this.e = (TextView) findViewById5;
        View findViewById6 = findViewById(R$id.firmwareVersion);
        kotlin.jvm.internal.e.e(findViewById6, "findViewById(...)");
        this.f8386f = (TextView) findViewById6;
        View findViewById7 = findViewById(R$id.powerTv);
        kotlin.jvm.internal.e.e(findViewById7, "findViewById(...)");
        this.f8387g = (TextView) findViewById7;
        View findViewById8 = findViewById(R$id.powerView);
        kotlin.jvm.internal.e.e(findViewById8, "findViewById(...)");
        this.f8388h = (PowerView) findViewById8;
        View findViewById9 = findViewById(R$id.name);
        kotlin.jvm.internal.e.e(findViewById9, "findViewById(...)");
        this.f8389i = (TextView) findViewById9;
        View findViewById10 = findViewById(R$id.point);
        kotlin.jvm.internal.e.e(findViewById10, "findViewById(...)");
        this.f8390j = (PointView) findViewById10;
    }
}
