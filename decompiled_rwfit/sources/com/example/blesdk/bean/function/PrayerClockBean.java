package com.example.blesdk.bean.function;

import android.support.v4.media.session.e;
import java.util.List;

/* loaded from: classes.dex */
public class PrayerClockBean {
    private int count;
    private List<PrayerClockData> list;

    public static class PrayerClockData {
        private int clockType;
        private boolean isSwitch;
        private int hour = 0;
        private int minute = 0;

        public int getClockType() {
            return this.clockType;
        }

        public int getHour() {
            return this.hour;
        }

        public int getMinute() {
            return this.minute;
        }

        public boolean isSwitch() {
            return this.isSwitch;
        }

        public void setClockType(int i3) {
            this.clockType = i3;
        }

        public void setHour(int i3) {
            if (i3 < 24) {
                this.hour = i3;
            }
        }

        public void setMinute(int i3) {
            if (i3 < 60) {
                this.minute = i3;
            }
        }

        public void setSwitch(boolean z5) {
            this.isSwitch = z5;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("PrayerClockData{clockType=");
            sb2.append(this.clockType);
            sb2.append(", isSwitch=");
            sb2.append(this.isSwitch);
            sb2.append(", hour=");
            sb2.append(this.hour);
            sb2.append(", minute=");
            return e.m(sb2, this.minute, '}');
        }
    }

    public int getCount() {
        return this.count;
    }

    public List<PrayerClockData> getList() {
        return this.list;
    }

    public void setCount(int i3) {
        this.count = i3;
    }

    public void setList(List<PrayerClockData> list) {
        this.list = list;
    }

    public String toString() {
        return "PrayerClockBean{count=" + this.count + ", list=" + this.list.toString() + '}';
    }
}
