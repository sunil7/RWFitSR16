package com.example.test.presenter.device;

import com.example.test.R$string;

/* loaded from: classes.dex */
public abstract class d extends com.example.baselibrary.preseneter.b {
    public final void k(int i3) {
        int i10 = R$string.str_error_seting;
        switch (i3) {
            case 2:
                i10 = R$string.str_error_device;
                break;
            case 3:
                i10 = R$string.str_error_device_un_support;
                break;
            case 4:
                i10 = R$string.str_error_device_data;
                break;
            case 5:
                i10 = R$string.str_error_cmd_time_out;
                break;
            case 6:
                i10 = R$string.str_error_data_time_out;
                break;
            case 7:
                i10 = R$string.str_device_disconnected;
                break;
        }
        this.f7255a.w0(i10);
    }
}
