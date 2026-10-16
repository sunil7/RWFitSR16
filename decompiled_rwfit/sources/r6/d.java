package r6;

import android.content.Context;
import android.text.format.DateFormat;
import androidx.appcompat.widget.SwitchCompat;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.device.model.AlarmModel;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
public final class d extends BaseItemProvider {

    /* renamed from: a, reason: collision with root package name */
    public s6.b f18097a;

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final void convert(BaseViewHolder baseViewHolder, Object obj) {
        String str;
        AlarmModel alarmModel = (AlarmModel) obj;
        Context context = getContext();
        kotlin.jvm.internal.e.f(context, "context");
        if (DateFormat.is24HourFormat(context)) {
            baseViewHolder.setText(R$id.tvTime, String.format(Locale.ENGLISH, "%02d:%02d", Integer.valueOf(alarmModel.getStartHour()), Integer.valueOf(alarmModel.getStartMin())));
            baseViewHolder.setText(R$id.tv_am_pm, "");
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, alarmModel.getStartHour());
            calendar.set(12, alarmModel.getStartMin());
            int i3 = R$id.tvTime;
            long timeInMillis = calendar.getTimeInMillis();
            try {
                str = new SimpleDateFormat("hh:mm", Locale.ENGLISH).format(Long.valueOf(timeInMillis));
            } catch (Exception e) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(timeInMillis, " date translate error ", e.getMessage()));
                str = null;
            }
            baseViewHolder.setText(i3, str);
            baseViewHolder.setText(R$id.tv_am_pm, calendar.get(9) == 0 ? "AM" : "PM");
        }
        baseViewHolder.setText(R$id.tv_alarm_content, ca.f(getContext(), alarmModel.getRepeatModel()));
        SwitchCompat switchCompat = (SwitchCompat) baseViewHolder.getView(R$id.alarmSwitch);
        switchCompat.setChecked(alarmModel.isOpen());
        switchCompat.setOnCheckedChangeListener(new b(this, alarmModel, 1));
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final int getItemViewType() {
        return 0;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public final int getLayoutId() {
        return R$layout.item_ring_alarm;
    }

    public void setOnSwitchItemStatusListener(s6.b bVar) {
        this.f18097a = bVar;
    }
}
