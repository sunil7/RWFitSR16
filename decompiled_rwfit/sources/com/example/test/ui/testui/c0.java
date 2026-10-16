package com.example.test.ui.testui;

import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.database.db.MuslimCountImpl;
import com.example.database.table.DataMuslimCount;
import com.example.database.table.User;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.ui.main.model.BaseDataModel;
import com.example.test.ui.main.model.HomeMuslinModel;
import com.example.test.ui.view.HalfCircle;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public final class c0 extends com.example.test.ui.view.e implements u5.g {

    /* renamed from: b, reason: collision with root package name */
    public HalfCircle f8266b;

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.d.a(R$string.ring_clean_Failed);
    }

    @Override // com.example.test.ui.view.e
    public final void b() {
        getContext().startActivity(new Intent(getContext(), (Class<?>) TRingMuslinStatisticsActivity.class));
    }

    @Override // u5.g
    public final void c() {
        Date date;
        String str;
        Log.e("qob", "clean onSuccess");
        HalfCircle halfCircle = this.f8266b;
        if (halfCircle != null) {
            halfCircle.setText("--");
            this.f8266b.setProgress(Float.valueOf(0.0f));
        }
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        kotlin.jvm.internal.e.f(time, "time");
        try {
            date = new SimpleDateFormat("yyyy/MM/dd", Locale.ENGLISH).parse(time);
        } catch (Exception unused) {
            date = null;
        }
        if (date != null) {
            long time2 = date.getTime();
            try {
                str = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(Long.valueOf(time2));
            } catch (Exception e) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(time2, " date translate error ", e.getMessage()));
                str = null;
            }
            if (str != null) {
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                User d5 = kVar != null ? kVar.d() : null;
                if (d5 != null) {
                    MuslimCountImpl muslimCountImpl = MuslimCountImpl.INSTANCE;
                    if (com.example.test.utils.k.f8731b == null) {
                        synchronized (com.example.test.utils.k.class) {
                            com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                        }
                    }
                    com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
                    String g10 = kVar2 != null ? kVar2.g() : null;
                    String userId = d5.getUserId();
                    kotlin.jvm.internal.e.e(userId, "getUserId(...)");
                    DataMuslimCount dataByDate = muslimCountImpl.getDataByDate(g10, userId, str);
                    if (dataByDate != null) {
                        muslimCountImpl.deleteAday(dataByDate);
                    }
                }
            }
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final void convert(BaseViewHolder baseViewHolder, Object obj) {
        BaseDataModel baseDataModel = (BaseDataModel) obj;
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        int D = com.example.test.utils.k.f8731b.D();
        if (D == 1) {
            baseViewHolder.setBackgroundResource(R$id.muslin_content, R$mipmap.homepage_muslim_bg_1);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_white);
        } else if (D == 2) {
            baseViewHolder.setBackgroundResource(R$id.muslin_content, R$mipmap.homepage_muslim_bg_2);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ring_home_more_pink);
        } else {
            baseViewHolder.setBackgroundResource(R$id.muslin_content, R$mipmap.homepage_muslim_bg);
            baseViewHolder.setBackgroundResource(R$id.iv_more, R$mipmap.ic_homepage_more);
        }
        baseViewHolder.setText(R$id.tv_date, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        HomeMuslinModel homeMuslinModel = (HomeMuslinModel) baseDataModel;
        this.f8266b = (HalfCircle) baseViewHolder.getView(R$id.pcycle_progress);
        ((TextView) baseViewHolder.getView(R$id.tv_desc)).setText("/" + homeMuslinModel.getGoalCount() + getContext().getString(R$string.str_count));
        if (homeMuslinModel.getTotalCount() > 0) {
            this.f8266b.setText(homeMuslinModel.getTotalCount() + "");
            this.f8266b.setMaxProgress(100.0f);
            this.f8266b.setProgress(Float.valueOf(homeMuslinModel.getTargetPerCent() * 100.0f));
        } else {
            this.f8266b.setText("--");
            this.f8266b.setProgress(Float.valueOf(0.0f));
        }
        f(baseViewHolder.getView(R$id.muslin_content));
        i(baseViewHolder.getView(R$id.rl_period));
    }

    @Override // u5.g
    public final /* bridge */ /* synthetic */ void e(Object obj) {
    }

    @Override // com.example.test.ui.view.e
    public final void g() {
        com.google.android.gms.internal.mlkit_vision_common.p.d(this);
        com.google.android.gms.internal.mlkit_vision_common.p.U(this);
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 44);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getMuslimCleanCmdJL");
        b3.g((byte) 44, new byte[]{2, 111, 0, 0}, new boolean[0]);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final int getItemViewType() {
        return 10;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final int getLayoutId() {
        return R$layout.item_ring_muslin;
    }
}
