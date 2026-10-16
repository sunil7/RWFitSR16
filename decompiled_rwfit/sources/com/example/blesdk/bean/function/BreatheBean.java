package com.example.blesdk.bean.function;

import android.support.v4.media.session.e;
import com.example.baselibrary.utils.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BreatheBean {
    List<TimeItem> breatheTime;
    private boolean isOpen;
    private int times;

    public static class TimeItem {
        private int hour = 0;
        private int min = 0;

        public int getHour() {
            return this.hour;
        }

        public int getMin() {
            return this.min;
        }

        public void setHour(int i3) {
            if (i3 < 24) {
                this.hour = i3;
            }
        }

        public void setMin(int i3) {
            if (i3 < 60) {
                this.min = i3;
            }
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("TimeItem{hour=");
            sb2.append(this.hour);
            sb2.append(", min=");
            return e.m(sb2, this.min, '}');
        }
    }

    public List<TimeItem> getBreatheTime() {
        List<TimeItem> list = this.breatheTime;
        if (list == null || list.size() < 5) {
            if (this.breatheTime == null) {
                this.breatheTime = new ArrayList(1);
            }
            for (int i3 = 0; i3 < 5 - this.breatheTime.size(); i3++) {
                this.breatheTime.add(new TimeItem());
            }
        }
        return this.breatheTime;
    }

    public int getTimes() {
        return this.times;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void setBreatheTime(List<TimeItem> list) {
        this.breatheTime = list;
    }

    public void setOpen(boolean z5) {
        this.isOpen = z5;
    }

    public void setTimes(int i3) {
        this.times = i3;
    }

    public String toString() {
        return "BreatheBean{isOpen=" + this.isOpen + ", times=" + this.times + ", breatheTime=" + b.z(this.breatheTime) + '}';
    }
}
