package com.example.test.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.example.test.R$mipmap;

/* loaded from: classes.dex */
public class GpsView extends AppCompatImageView {
    public GpsView(Context context) {
        this(context, null);
    }

    public void setLevel(int i3) {
        int i10 = R$mipmap.ic_gps_1_ring;
        if (i3 == 0) {
            i10 = R$mipmap.ic_gps_empty_ring;
        } else if (i3 != 1) {
            if (i3 == 2) {
                i10 = R$mipmap.ic_gps_2_ring;
            } else if (i3 == 3) {
                i10 = R$mipmap.ic_gps_full_ring;
            } else if (i3 == 4) {
                i10 = R$mipmap.ic_gps_full_ring;
            }
        }
        setImageResource(i10);
    }

    public GpsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GpsView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        setImageResource(R$mipmap.ic_gps_1_ring);
    }
}
