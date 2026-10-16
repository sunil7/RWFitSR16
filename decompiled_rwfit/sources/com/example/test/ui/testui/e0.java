package com.example.test.ui.testui;

import android.content.Intent;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.database.table.User;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.ui.main.model.BaseDataModel;
import com.example.test.ui.main.model.HomeSportModel;
import com.example.test.ui.sport.activity.SportNewRecordActivity;
import com.example.test.ui.sport.activity.SportRecordActivity;
import com.example.test.ui.view.HalfCircle;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.v1;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/* loaded from: classes.dex */
public final class e0 extends com.example.test.ui.view.e {
    @Override // com.example.test.ui.view.e
    public final void b() {
        Object obj = com.example.test.utils.m.f8734b;
        SupportMenuBean supportMenuBean = d2.a().f8735a;
        if (supportMenuBean != null ? supportMenuBean.isNewSport() : false) {
            getContext().startActivity(new Intent(getContext(), (Class<?>) SportNewRecordActivity.class));
        } else {
            getContext().startActivity(new Intent(getContext(), (Class<?>) SportRecordActivity.class));
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final void convert(BaseViewHolder baseViewHolder, Object obj) {
        User d5;
        double b3;
        String string;
        HomeSportModel homeSportModel = (HomeSportModel) ((BaseDataModel) obj);
        int D = y1.a().D();
        if (D == 1) {
            baseViewHolder.setBackgroundResource(R$id.step_content, R$mipmap.ring_homepage_sport_bg_1);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_white);
        } else if (D == 2) {
            baseViewHolder.setBackgroundResource(R$id.step_content, R$mipmap.ring_homepage_sport_bg_2);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_pink);
        } else {
            baseViewHolder.setBackgroundResource(R$id.step_content, R$mipmap.ring_homepage_sport_bg);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ic_homepage_more);
        }
        baseViewHolder.setText(R$id.tv_date, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        HalfCircle halfCircle = (HalfCircle) baseViewHolder.getView(R$id.step_progress);
        int f2 = y1.a().f();
        if (homeSportModel == null || homeSportModel.getDataItems() == null || homeSportModel.getDataItems().isEmpty()) {
            baseViewHolder.setText(R$id.tv_desc, R$string.str_no_data);
            halfCircle.setText("--");
            halfCircle.setMaxProgress(1.0f);
            halfCircle.setProgress(Float.valueOf(0.0f));
        } else {
            h6.b bVar = homeSportModel.getDataItems().get(0);
            baseViewHolder.setText(R$id.tv_desc, "KCAL");
            Locale locale = Locale.ENGLISH;
            halfCircle.setText(String.format(locale, "%.1f", Float.valueOf(((int) ((((float) bVar.f14271g) / 1000.0f) * 10)) / 10.0f)));
            halfCircle.setMaxProgress(f2);
            halfCircle.setProgress(Float.valueOf(((float) bVar.f14271g) / 1000.0f));
            if (y1.a() != null && (d5 = y1.a().d()) != null) {
                if (d5.getMeterUnit() == 0) {
                    b3 = bVar.f14268c / 1000.0d;
                    string = this.context.getString(R$string.str_km);
                } else {
                    b3 = v1.b((float) bVar.f14268c);
                    string = this.context.getString(R$string.str_mile);
                }
                baseViewHolder.setText(R$id.tv_ring_sport_distance, String.format(locale, "%.2f%s", Float.valueOf(((int) (((float) b3) * 100)) / 100.0f), string));
            }
            baseViewHolder.setText(R$id.tv_ring_sport_time, String.format(locale, "%02d:%02d:%02d", Long.valueOf(bVar.e / 3600), Long.valueOf((bVar.e % 3600) / 60), Long.valueOf((bVar.e % 3600) % 60)));
        }
        f(baseViewHolder.getView(R$id.step_content));
        i(baseViewHolder.getView(R$id.tv_sport_gorun));
    }

    @Override // com.example.test.ui.view.e
    public final void g() {
        Object obj = com.example.test.utils.m.f8734b;
        SupportMenuBean supportMenuBean = d2.a().f8735a;
        if (supportMenuBean != null ? supportMenuBean.isNewSport() : false) {
            getContext().startActivity(new Intent(getContext(), (Class<?>) TRingSportTypeNewActivity.class));
        } else {
            getContext().startActivity(new Intent(getContext(), (Class<?>) TRingSportTypeActivity.class));
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final int getItemViewType() {
        return 8;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final int getLayoutId() {
        return R$layout.item_ring_sport;
    }
}
