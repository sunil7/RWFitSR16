package com.example.test.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.test.R$color;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.ui.device.model.DeviceInfoModel;

/* loaded from: classes.dex */
public final class TRingDeviceInfoView extends LinearLayout {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f8602m = 0;

    /* renamed from: a, reason: collision with root package name */
    public final TextView f8603a;

    /* renamed from: b, reason: collision with root package name */
    public final Button f8604b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f8605c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f8606d;
    public final TextView e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f8607f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f8608g;

    /* renamed from: h, reason: collision with root package name */
    public final TRingPowerView f8609h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f8610i;

    /* renamed from: j, reason: collision with root package name */
    public final PointView f8611j;

    /* renamed from: k, reason: collision with root package name */
    public final RelativeLayout f8612k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f8613l;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TRingDeviceInfoView(Context context) {
        this(context, null, 6, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public final void a() {
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        Integer valueOf = kVar != null ? Integer.valueOf(kVar.D()) : null;
        if (valueOf != null && valueOf.intValue() == 15) {
            RelativeLayout relativeLayout = this.f8612k;
            if (relativeLayout == null) {
                kotlin.jvm.internal.e.m("parent");
                throw null;
            }
            relativeLayout.setBackgroundResource(R$drawable.bg_ring_grey_item);
            TextView textView = this.f8610i;
            if (textView == null) {
                kotlin.jvm.internal.e.m("nameTv");
                throw null;
            }
            textView.setTextColor(a1.d.a(getContext(), R$color.color_white));
            TextView textView2 = this.f8613l;
            if (textView2 == null) {
                kotlin.jvm.internal.e.m("linkedStatus");
                throw null;
            }
            textView2.setTextColor(a1.d.a(getContext(), R$color.color_white));
            TextView textView3 = this.f8607f;
            if (textView3 == null) {
                kotlin.jvm.internal.e.m("firmwareVersionTv");
                throw null;
            }
            textView3.setTextColor(a1.d.a(getContext(), R$color.color_white));
            TextView textView4 = this.e;
            if (textView4 == null) {
                kotlin.jvm.internal.e.m("macTv");
                throw null;
            }
            textView4.setTextColor(a1.d.a(getContext(), R$color.color_white));
            TextView textView5 = this.f8608g;
            if (textView5 != null) {
                textView5.setTextColor(a1.d.a(getContext(), R$color.color_white));
                return;
            } else {
                kotlin.jvm.internal.e.m("powerTv");
                throw null;
            }
        }
        if (valueOf != null && valueOf.intValue() == 0) {
            RelativeLayout relativeLayout2 = this.f8612k;
            if (relativeLayout2 == null) {
                kotlin.jvm.internal.e.m("parent");
                throw null;
            }
            relativeLayout2.setBackgroundResource(R$drawable.bg_ring_grey_item);
            TextView textView6 = this.f8610i;
            if (textView6 == null) {
                kotlin.jvm.internal.e.m("nameTv");
                throw null;
            }
            textView6.setTextColor(a1.d.a(getContext(), R$color.color_white));
            TextView textView7 = this.f8613l;
            if (textView7 == null) {
                kotlin.jvm.internal.e.m("linkedStatus");
                throw null;
            }
            textView7.setTextColor(a1.d.a(getContext(), R$color.color_white));
            TextView textView8 = this.f8607f;
            if (textView8 == null) {
                kotlin.jvm.internal.e.m("firmwareVersionTv");
                throw null;
            }
            textView8.setTextColor(a1.d.a(getContext(), R$color.color_white));
            TextView textView9 = this.e;
            if (textView9 == null) {
                kotlin.jvm.internal.e.m("macTv");
                throw null;
            }
            textView9.setTextColor(a1.d.a(getContext(), R$color.color_white));
            TextView textView10 = this.f8608g;
            if (textView10 != null) {
                textView10.setTextColor(a1.d.a(getContext(), R$color.color_white));
                return;
            } else {
                kotlin.jvm.internal.e.m("powerTv");
                throw null;
            }
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            RelativeLayout relativeLayout3 = this.f8612k;
            if (relativeLayout3 == null) {
                kotlin.jvm.internal.e.m("parent");
                throw null;
            }
            relativeLayout3.setBackgroundResource(R$drawable.bg_ring_white_item);
            TextView textView11 = this.f8610i;
            if (textView11 == null) {
                kotlin.jvm.internal.e.m("nameTv");
                throw null;
            }
            textView11.setTextColor(a1.d.a(getContext(), R$color.color_black));
            TextView textView12 = this.f8613l;
            if (textView12 == null) {
                kotlin.jvm.internal.e.m("linkedStatus");
                throw null;
            }
            textView12.setTextColor(a1.d.a(getContext(), R$color.color_black));
            TextView textView13 = this.f8607f;
            if (textView13 == null) {
                kotlin.jvm.internal.e.m("firmwareVersionTv");
                throw null;
            }
            textView13.setTextColor(a1.d.a(getContext(), R$color.color_black));
            TextView textView14 = this.e;
            if (textView14 == null) {
                kotlin.jvm.internal.e.m("macTv");
                throw null;
            }
            textView14.setTextColor(a1.d.a(getContext(), R$color.color_black));
            TextView textView15 = this.f8608g;
            if (textView15 != null) {
                textView15.setTextColor(a1.d.a(getContext(), R$color.color_black));
                return;
            } else {
                kotlin.jvm.internal.e.m("powerTv");
                throw null;
            }
        }
        if (valueOf != null && valueOf.intValue() == 2) {
            RelativeLayout relativeLayout4 = this.f8612k;
            if (relativeLayout4 == null) {
                kotlin.jvm.internal.e.m("parent");
                throw null;
            }
            relativeLayout4.setBackgroundResource(R$drawable.bg_ring_white_item);
            TextView textView16 = this.f8610i;
            if (textView16 == null) {
                kotlin.jvm.internal.e.m("nameTv");
                throw null;
            }
            textView16.setTextColor(a1.d.a(getContext(), R$color.color_black));
            TextView textView17 = this.f8613l;
            if (textView17 == null) {
                kotlin.jvm.internal.e.m("linkedStatus");
                throw null;
            }
            textView17.setTextColor(a1.d.a(getContext(), R$color.color_black));
            TextView textView18 = this.f8607f;
            if (textView18 == null) {
                kotlin.jvm.internal.e.m("firmwareVersionTv");
                throw null;
            }
            textView18.setTextColor(a1.d.a(getContext(), R$color.color_black));
            TextView textView19 = this.e;
            if (textView19 == null) {
                kotlin.jvm.internal.e.m("macTv");
                throw null;
            }
            textView19.setTextColor(a1.d.a(getContext(), R$color.color_black));
            TextView textView20 = this.f8608g;
            if (textView20 != null) {
                textView20.setTextColor(a1.d.a(getContext(), R$color.color_black));
            } else {
                kotlin.jvm.internal.e.m("powerTv");
                throw null;
            }
        }
    }

    public final void setBindClickListener(View.OnClickListener onClickListener) {
        kotlin.jvm.internal.e.f(onClickListener, "onClickListener");
        Button button = this.f8604b;
        if (button != null) {
            button.setOnClickListener(onClickListener);
        } else {
            kotlin.jvm.internal.e.m("btnBindBt");
            throw null;
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void setBindModel(DeviceInfoModel deviceInfoModel) {
        Drawable b3;
        kotlin.jvm.internal.e.f(deviceInfoModel, "deviceInfoModel");
        if (deviceInfoModel.getBindStatus() == 1) {
            Button button = this.f8604b;
            if (button == null) {
                kotlin.jvm.internal.e.m("btnBindBt");
                throw null;
            }
            button.setVisibility(8);
            LinearLayout linearLayout = this.f8605c;
            if (linearLayout == null) {
                kotlin.jvm.internal.e.m("llBindLL");
                throw null;
            }
            linearLayout.setVisibility(0);
            String showUrl = deviceInfoModel.getShowUrl();
            if (showUrl != null && showUrl.length() != 0) {
                Context context = getContext();
                kotlin.jvm.internal.e.e(context, "getContext(...)");
                ImageView imageView = this.f8606d;
                if (imageView == null) {
                    kotlin.jvm.internal.e.m("deviceIconIv");
                    throw null;
                }
                String showUrl2 = deviceInfoModel.getShowUrl();
                kotlin.jvm.internal.e.e(showUrl2, "getShowUrl(...)");
                ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(context).n(showUrl2).o(false)).d(z3.h.f20239b)).x(imageView);
            }
        } else {
            Button button2 = this.f8604b;
            if (button2 == null) {
                kotlin.jvm.internal.e.m("btnBindBt");
                throw null;
            }
            button2.setVisibility(0);
            LinearLayout linearLayout2 = this.f8605c;
            if (linearLayout2 == null) {
                kotlin.jvm.internal.e.m("llBindLL");
                throw null;
            }
            linearLayout2.setVisibility(8);
            ImageView imageView2 = this.f8606d;
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
            TextView textView2 = this.f8607f;
            if (textView2 == null) {
                kotlin.jvm.internal.e.m("firmwareVersionTv");
                throw null;
            }
            textView2.setText(getContext().getString(R$string.str_firmware_version) + " V" + deviceInfoModel.getVersion());
        }
        TextView textView3 = this.f8608g;
        if (textView3 == null) {
            kotlin.jvm.internal.e.m("powerTv");
            throw null;
        }
        textView3.setText(deviceInfoModel.getPower() + "%");
        TRingPowerView tRingPowerView = this.f8609h;
        if (tRingPowerView == null) {
            kotlin.jvm.internal.e.m("powerView");
            throw null;
        }
        deviceInfoModel.isPowering();
        tRingPowerView.invalidate();
        a1.c.b(getContext(), R$drawable.svg_nopower_30);
        if (deviceInfoModel.getPower() >= 100) {
            b3 = a1.c.b(getContext(), R$drawable.svg_nopower_100);
        } else {
            int power = deviceInfoModel.getPower();
            if (90 > power || power >= 100) {
                int power2 = deviceInfoModel.getPower();
                if (80 > power2 || power2 >= 90) {
                    int power3 = deviceInfoModel.getPower();
                    if (70 > power3 || power3 >= 80) {
                        int power4 = deviceInfoModel.getPower();
                        if (60 > power4 || power4 >= 70) {
                            int power5 = deviceInfoModel.getPower();
                            if (50 > power5 || power5 >= 60) {
                                int power6 = deviceInfoModel.getPower();
                                if (40 > power6 || power6 >= 50) {
                                    int power7 = deviceInfoModel.getPower();
                                    if (30 > power7 || power7 >= 40) {
                                        int power8 = deviceInfoModel.getPower();
                                        b3 = (20 > power8 || power8 >= 30) ? a1.c.b(getContext(), R$drawable.svg_nopower_10) : a1.c.b(getContext(), R$drawable.svg_nopower_20);
                                    } else {
                                        b3 = a1.c.b(getContext(), R$drawable.svg_nopower_30);
                                    }
                                } else {
                                    b3 = a1.c.b(getContext(), R$drawable.svg_nopower_40);
                                }
                            } else {
                                b3 = a1.c.b(getContext(), R$drawable.svg_nopower_50);
                            }
                        } else {
                            b3 = a1.c.b(getContext(), R$drawable.svg_nopower_60);
                        }
                    } else {
                        b3 = a1.c.b(getContext(), R$drawable.svg_nopower_70);
                    }
                } else {
                    b3 = a1.c.b(getContext(), R$drawable.svg_nopower_80);
                }
            } else {
                b3 = a1.c.b(getContext(), R$drawable.svg_nopower_90);
            }
        }
        kotlin.jvm.internal.e.c(b3);
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        Integer valueOf = kVar != null ? Integer.valueOf(kVar.D()) : null;
        if (valueOf != null && valueOf.intValue() == 15) {
            d1.b.g(b3, getContext().getColor(R$color.color_white));
        } else if (valueOf != null && valueOf.intValue() == 0) {
            d1.b.g(b3, getContext().getColor(R$color.color_white));
        } else if (valueOf != null && valueOf.intValue() == 1) {
            d1.b.g(b3, getContext().getColor(R$color.color_black));
        } else if (valueOf != null && valueOf.intValue() == 2) {
            d1.b.g(b3, getContext().getColor(R$color.color_black));
        }
        TRingPowerView tRingPowerView2 = this.f8609h;
        if (tRingPowerView2 == null) {
            kotlin.jvm.internal.e.m("powerView");
            throw null;
        }
        tRingPowerView2.setBackground(b3);
        TRingPowerView tRingPowerView3 = this.f8609h;
        if (tRingPowerView3 == null) {
            kotlin.jvm.internal.e.m("powerView");
            throw null;
        }
        deviceInfoModel.isLowPower();
        tRingPowerView3.invalidate();
        TextView textView4 = this.f8610i;
        if (textView4 == null) {
            kotlin.jvm.internal.e.m("nameTv");
            throw null;
        }
        textView4.setText(deviceInfoModel.getDeviceName());
        PointView pointView = this.f8611j;
        if (pointView != null) {
            pointView.setVisibility(deviceInfoModel.isHasNew() ? 0 : 8);
        } else {
            kotlin.jvm.internal.e.m("pointView");
            throw null;
        }
    }

    public final void setLinkedStatus(int i3) {
        if (i3 == 0) {
            TextView textView = this.f8613l;
            if (textView != null) {
                textView.setText(getContext().getString(R$string.str_disconnected));
                return;
            } else {
                kotlin.jvm.internal.e.m("linkedStatus");
                throw null;
            }
        }
        if (i3 != 1) {
            TextView textView2 = this.f8613l;
            if (textView2 != null) {
                textView2.setText(getContext().getString(R$string.str_device_connecting));
                return;
            } else {
                kotlin.jvm.internal.e.m("linkedStatus");
                throw null;
            }
        }
        TextView textView3 = this.f8613l;
        if (textView3 != null) {
            textView3.setText(getContext().getString(R$string.str_connected));
        } else {
            kotlin.jvm.internal.e.m("linkedStatus");
            throw null;
        }
    }

    public final void setOnViewClickListener(View.OnClickListener onClickListener) {
        kotlin.jvm.internal.e.f(onClickListener, "onClickListener");
        TextView textView = this.f8603a;
        if (textView != null) {
            textView.setOnClickListener(new d(onClickListener, 2));
        } else {
            kotlin.jvm.internal.e.m("tvOtaTv");
            throw null;
        }
    }

    public final void setOtaStatus(boolean z5) {
        TextView textView = this.f8603a;
        if (textView != null) {
            textView.setVisibility(z5 ? 0 : 8);
        } else {
            kotlin.jvm.internal.e.m("tvOtaTv");
            throw null;
        }
    }

    public final void setOtaText(String text) {
        kotlin.jvm.internal.e.f(text, "text");
        TextView textView = this.f8603a;
        if (textView != null) {
            textView.setText(text);
        } else {
            kotlin.jvm.internal.e.m("tvOtaTv");
            throw null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TRingDeviceInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public /* synthetic */ TRingDeviceInfoView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TRingDeviceInfoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        kotlin.jvm.internal.e.f(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_ring_device_info, this);
        View findViewById = findViewById(R$id.parent);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.f8612k = (RelativeLayout) findViewById;
        View findViewById2 = findViewById(R$id.linkedstatue);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.f8613l = (TextView) findViewById2;
        View findViewById3 = findViewById(R$id.tv_ota);
        kotlin.jvm.internal.e.e(findViewById3, "findViewById(...)");
        this.f8603a = (TextView) findViewById3;
        View findViewById4 = findViewById(R$id.btnBind);
        kotlin.jvm.internal.e.e(findViewById4, "findViewById(...)");
        this.f8604b = (Button) findViewById4;
        View findViewById5 = findViewById(R$id.llBind);
        kotlin.jvm.internal.e.e(findViewById5, "findViewById(...)");
        this.f8605c = (LinearLayout) findViewById5;
        View findViewById6 = findViewById(R$id.deviceIcon);
        kotlin.jvm.internal.e.e(findViewById6, "findViewById(...)");
        this.f8606d = (ImageView) findViewById6;
        View findViewById7 = findViewById(R$id.mac);
        kotlin.jvm.internal.e.e(findViewById7, "findViewById(...)");
        this.e = (TextView) findViewById7;
        View findViewById8 = findViewById(R$id.firmwareVersion);
        kotlin.jvm.internal.e.e(findViewById8, "findViewById(...)");
        this.f8607f = (TextView) findViewById8;
        View findViewById9 = findViewById(R$id.powerTv);
        kotlin.jvm.internal.e.e(findViewById9, "findViewById(...)");
        this.f8608g = (TextView) findViewById9;
        View findViewById10 = findViewById(R$id.powerView);
        kotlin.jvm.internal.e.e(findViewById10, "findViewById(...)");
        this.f8609h = (TRingPowerView) findViewById10;
        View findViewById11 = findViewById(R$id.name);
        kotlin.jvm.internal.e.e(findViewById11, "findViewById(...)");
        this.f8610i = (TextView) findViewById11;
        View findViewById12 = findViewById(R$id.point);
        kotlin.jvm.internal.e.e(findViewById12, "findViewById(...)");
        this.f8611j = (PointView) findViewById12;
        a();
    }
}
