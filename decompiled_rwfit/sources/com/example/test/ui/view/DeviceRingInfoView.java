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
public final class DeviceRingInfoView extends LinearLayout {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f8391k = 0;

    /* renamed from: a, reason: collision with root package name */
    public final TextView f8392a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f8393b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f8394c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f8395d;
    public final TextView e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f8396f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f8397g;

    /* renamed from: h, reason: collision with root package name */
    public final PowerView f8398h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f8399i;

    /* renamed from: j, reason: collision with root package name */
    public final PowerView f8400j;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeviceRingInfoView(Context context) {
        this(context, null, 6, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public final void setBindClickListener(View.OnClickListener onClickListener) {
        kotlin.jvm.internal.e.f(onClickListener, "onClickListener");
        Button button = this.f8393b;
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
        deviceInfoModel.setBindStatus(1);
        if (deviceInfoModel.getBindStatus() == 1) {
            Button button = this.f8393b;
            if (button == null) {
                kotlin.jvm.internal.e.m("btnBindBt");
                throw null;
            }
            button.setVisibility(8);
            LinearLayout linearLayout = this.f8394c;
            if (linearLayout == null) {
                kotlin.jvm.internal.e.m("llBindLL");
                throw null;
            }
            linearLayout.setVisibility(0);
            String showUrl = deviceInfoModel.getShowUrl();
            if (showUrl != null && showUrl.length() != 0) {
                Context context = getContext();
                kotlin.jvm.internal.e.e(context, "getContext(...)");
                ImageView imageView = this.f8395d;
                if (imageView == null) {
                    kotlin.jvm.internal.e.m("deviceIconIv");
                    throw null;
                }
                String showUrl2 = deviceInfoModel.getShowUrl();
                kotlin.jvm.internal.e.e(showUrl2, "getShowUrl(...)");
                ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(context).n(showUrl2).o(true)).d(z3.h.f20239b)).x(imageView);
            }
        } else {
            Button button2 = this.f8393b;
            if (button2 == null) {
                kotlin.jvm.internal.e.m("btnBindBt");
                throw null;
            }
            button2.setVisibility(0);
            LinearLayout linearLayout2 = this.f8394c;
            if (linearLayout2 == null) {
                kotlin.jvm.internal.e.m("llBindLL");
                throw null;
            }
            linearLayout2.setVisibility(8);
            ImageView imageView2 = this.f8395d;
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
            TextView textView2 = this.f8396f;
            if (textView2 == null) {
                kotlin.jvm.internal.e.m("firmwareVersionTv");
                throw null;
            }
            textView2.setText(getContext().getString(R$string.str_firmware_version) + " V" + deviceInfoModel.getVersion());
        }
        TextView textView3 = this.f8397g;
        if (textView3 == null) {
            kotlin.jvm.internal.e.m("powerTv");
            throw null;
        }
        textView3.setText(deviceInfoModel.getPower() + "%");
        PowerView powerView = this.f8398h;
        if (powerView == null) {
            kotlin.jvm.internal.e.m("powerView");
            throw null;
        }
        powerView.f8518p = deviceInfoModel.isPowering();
        powerView.invalidate();
        PowerView powerView2 = this.f8398h;
        if (powerView2 == null) {
            kotlin.jvm.internal.e.m("powerView");
            throw null;
        }
        powerView2.setCurrentPower(deviceInfoModel.getPower());
        PowerView powerView3 = this.f8398h;
        if (powerView3 == null) {
            kotlin.jvm.internal.e.m("powerView");
            throw null;
        }
        powerView3.f8519q = deviceInfoModel.isLowPower();
        powerView3.invalidate();
        TextView textView4 = this.f8399i;
        if (textView4 == null) {
            kotlin.jvm.internal.e.m("nameTv");
            throw null;
        }
        textView4.setText(deviceInfoModel.getDeviceName());
        PowerView powerView4 = this.f8400j;
        if (powerView4 != null) {
            powerView4.setVisibility(deviceInfoModel.isHasNew() ? 0 : 8);
        } else {
            kotlin.jvm.internal.e.m("pointView");
            throw null;
        }
    }

    public final void setOnViewClickListener(View.OnClickListener onClickListener) {
        kotlin.jvm.internal.e.f(onClickListener, "onClickListener");
        TextView textView = this.f8392a;
        if (textView != null) {
            textView.setOnClickListener(new d(onClickListener, 1));
        } else {
            kotlin.jvm.internal.e.m("tvOtaTv");
            throw null;
        }
    }

    public final void setOtaStatus(boolean z5) {
        TextView textView = this.f8392a;
        if (textView != null) {
            textView.setVisibility(z5 ? 0 : 8);
        } else {
            kotlin.jvm.internal.e.m("tvOtaTv");
            throw null;
        }
    }

    public final void setOtaText(String text) {
        kotlin.jvm.internal.e.f(text, "text");
        TextView textView = this.f8392a;
        if (textView != null) {
            textView.setText(text);
        } else {
            kotlin.jvm.internal.e.m("tvOtaTv");
            throw null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeviceRingInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public /* synthetic */ DeviceRingInfoView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceRingInfoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        kotlin.jvm.internal.e.f(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_device_ring_info, this);
        View findViewById = findViewById(R$id.tv_ota);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.f8392a = (TextView) findViewById;
        View findViewById2 = findViewById(R$id.btnBind);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.f8393b = (Button) findViewById2;
        View findViewById3 = findViewById(R$id.llBind);
        kotlin.jvm.internal.e.e(findViewById3, "findViewById(...)");
        this.f8394c = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R$id.deviceIcon);
        kotlin.jvm.internal.e.e(findViewById4, "findViewById(...)");
        this.f8395d = (ImageView) findViewById4;
        View findViewById5 = findViewById(R$id.mac);
        kotlin.jvm.internal.e.e(findViewById5, "findViewById(...)");
        this.e = (TextView) findViewById5;
        View findViewById6 = findViewById(R$id.firmwareVersion);
        kotlin.jvm.internal.e.e(findViewById6, "findViewById(...)");
        this.f8396f = (TextView) findViewById6;
        View findViewById7 = findViewById(R$id.powerTv);
        kotlin.jvm.internal.e.e(findViewById7, "findViewById(...)");
        this.f8397g = (TextView) findViewById7;
        View findViewById8 = findViewById(R$id.powerView);
        kotlin.jvm.internal.e.e(findViewById8, "findViewById(...)");
        this.f8398h = (PowerView) findViewById8;
        View findViewById9 = findViewById(R$id.name);
        kotlin.jvm.internal.e.e(findViewById9, "findViewById(...)");
        this.f8399i = (TextView) findViewById9;
        View findViewById10 = findViewById(R$id.point);
        kotlin.jvm.internal.e.e(findViewById10, "findViewById(...)");
        this.f8400j = (PowerView) findViewById10;
    }
}
