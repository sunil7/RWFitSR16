package com.example.test.ui.device.adapter;

import android.content.Context;
import android.text.format.DateFormat;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.baselibrary.utils.b;
import com.example.test.R$id;
import com.example.test.ui.device.model.ScheduleModel;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class ScheduleAdapter extends BaseQuickAdapter<ScheduleModel, BaseViewHolder> {
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder holder, ScheduleModel scheduleModel) {
        ScheduleModel item = scheduleModel;
        e.f(holder, "holder");
        e.f(item, "item");
        Context context = getContext();
        e.f(context, "context");
        String str = null;
        if (DateFormat.is24HourFormat(context)) {
            try {
                str = new SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.ENGLISH).format(Long.valueOf(item.getTime()));
            } catch (Exception e) {
                b.o(b.f7264b, l0.n("date translate error ", e.getMessage()));
            }
            if (str != null) {
                holder.setText(R$id.tvTime, str);
            }
            holder.setText(R$id.tv_am_pm, "");
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(item.getTime());
            int i3 = R$id.tvTime;
            long timeInMillis = calendar.getTimeInMillis();
            try {
                str = new SimpleDateFormat("yyyy/MM/dd hh:mm", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
            } catch (Exception e10) {
                b.o(b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e10.getMessage()));
            }
            holder.setText(i3, str);
            holder.setText(R$id.tv_am_pm, calendar.get(9) == 0 ? "AM" : "PM");
        }
        holder.setText(R$id.tv_schedule_title, item.getScheduleTitle());
    }
}
