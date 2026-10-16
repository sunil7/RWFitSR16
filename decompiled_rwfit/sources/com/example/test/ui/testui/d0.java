package com.example.test.ui.testui;

import android.content.Intent;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.ui.view.HalfCircle;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/* loaded from: classes.dex */
public final class d0 extends com.example.test.ui.view.e {

    /* renamed from: b, reason: collision with root package name */
    public HalfCircle f8269b;

    @Override // com.example.test.ui.view.e
    public final void b() {
        getContext().startActivity(new Intent(getContext(), (Class<?>) TRingPCycleStatisticsActivity.class));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final void convert(BaseViewHolder baseViewHolder, Object obj) {
        int i3;
        int i10;
        int D = y1.a().D();
        if (D == 1) {
            baseViewHolder.setBackgroundResource(R$id.pcycle_content, R$mipmap.homepage_pcycle_bg_1);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_white);
        } else if (D == 2) {
            baseViewHolder.setBackgroundResource(R$id.pcycle_content, R$mipmap.homepage_pcycle_bg_2);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_pink);
        } else {
            baseViewHolder.setBackgroundResource(R$id.pcycle_content, R$mipmap.homepage_pcycle_bg);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ic_homepage_more);
        }
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        baseViewHolder.setText(R$id.tv_date, now.format(ofPattern));
        this.f8269b = (HalfCircle) baseViewHolder.getView(R$id.pcycle_progress);
        int t8 = y1.a().t();
        int u10 = y1.a().u();
        long between = ChronoUnit.DAYS.between(LocalDate.parse(y1.a().s(), ofPattern), now.toLocalDate());
        int i11 = between >= 0 ? (int) (between % t8) : -1;
        int i12 = u10 + 3;
        int i13 = u10 + 13;
        char c9 = 0;
        if (i11 < 0) {
            i10 = 0;
            i3 = 0;
            u10 = 0;
            c9 = 2;
        } else if (i11 < u10) {
            int i14 = i11 + 1;
            i10 = u10 - i11;
            c9 = i12 >= t8 ? (char) 1 : (char) 2;
            r1 = 0;
            i3 = i14;
        } else if (i11 >= i12 && i11 < i13) {
            int i15 = (i11 - i12) + 1;
            i10 = i13 - i11;
            u10 = 10;
            i3 = i15;
            c9 = 2;
            r1 = 1;
        } else if (i11 < i12) {
            int i16 = (i11 - u10) + 1;
            i10 = i12 - i11;
            u10 = i12 - u10;
            i3 = i16;
            c9 = 1;
        } else {
            i3 = (i11 - i13) + 1;
            i10 = t8 - i11;
            u10 = t8 - i13;
        }
        this.f8269b.setText(i3 + "");
        this.f8269b.setMaxProgress(100.0f);
        this.f8269b.setProgress(Float.valueOf((((float) i3) * 100.0f) / ((float) u10)));
        if (r1 == 0) {
            baseViewHolder.setText(R$id.tv_women_curtype, R$string.ring_women_jingqi);
        } else if (r1 == 1) {
            baseViewHolder.setText(R$id.tv_women_curtype, R$string.ring_women_pailuanqi);
        } else {
            baseViewHolder.setText(R$id.tv_women_curtype, R$string.ring_women_anquanqi);
        }
        String format = String.format(this.context.getString(R$string.ring_women_after_enter), Integer.valueOf(i10));
        if (c9 == 0) {
            int i17 = R$id.tv_women_nexttype;
            StringBuilder u11 = com.google.android.gms.internal.mlkit_vision_barcode.l0.u(format, " ");
            u11.append(this.context.getString(R$string.ring_women_jingqi));
            baseViewHolder.setText(i17, u11.toString());
        } else if (c9 == 1) {
            int i18 = R$id.tv_women_nexttype;
            StringBuilder u12 = com.google.android.gms.internal.mlkit_vision_barcode.l0.u(format, " ");
            u12.append(this.context.getString(R$string.ring_women_pailuanqi));
            baseViewHolder.setText(i18, u12.toString());
        } else {
            int i19 = R$id.tv_women_nexttype;
            StringBuilder u13 = com.google.android.gms.internal.mlkit_vision_barcode.l0.u(format, " ");
            u13.append(this.context.getString(R$string.ring_women_anquanqi));
            baseViewHolder.setText(i19, u13.toString());
        }
        f(baseViewHolder.getView(R$id.pcycle_content));
        i(baseViewHolder.getView(R$id.rl_period));
    }

    @Override // com.example.test.ui.view.e
    public final void g() {
        getContext().startActivity(new Intent(getContext(), (Class<?>) TRingPCycleSettingsActivity.class));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final int getItemViewType() {
        return 15;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final int getLayoutId() {
        return R$layout.item_ring_pcycle;
    }
}
