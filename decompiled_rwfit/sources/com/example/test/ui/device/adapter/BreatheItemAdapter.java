package com.example.test.ui.device.adapter;

import android.support.v4.media.session.e;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.baselibrary.utils.b;
import com.example.blesdk.bean.sync.BreatheItemBean;
import com.example.test.R$id;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public class BreatheItemAdapter extends BaseQuickAdapter<BreatheItemBean, BaseViewHolder> {
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder baseViewHolder, BreatheItemBean breatheItemBean) {
        String str;
        BreatheItemBean breatheItemBean2 = breatheItemBean;
        long timeMills = breatheItemBean2.getTimeMills() * 1000;
        try {
            str = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH).format(Long.valueOf(timeMills));
        } catch (Exception e) {
            b.o(b.f7264b, e.h(timeMills, " date translate error ", e.getMessage()));
            str = null;
        }
        baseViewHolder.setText(R$id.time, str);
        int i3 = R$id.content;
        Locale locale = Locale.ENGLISH;
        baseViewHolder.setText(i3, breatheItemBean2.getTimeLen() + " min");
    }
}
