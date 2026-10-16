package com.haibin.calendarview;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import md.t;

/* loaded from: classes.dex */
public final class Calendar implements Serializable, Comparable<Calendar> {
    private static final long serialVersionUID = 141315161718191143L;
    private int day;
    private String gregorianFestival;
    private boolean isCurrentDay;
    private boolean isCurrentMonth;
    private boolean isLeapYear;
    private boolean isWeekend;
    private int leapMonth;
    private String lunar;
    private Calendar lunarCalendar;
    private int month;
    private String scheme;
    private int schemeColor;
    private List<Scheme> schemes;
    private String solarTerm;
    private String traditionFestival;
    private int week;
    private int year;

    public static final class Scheme implements Serializable {
        private Object obj;
        private String other;
        private String scheme;
        private int shcemeColor;
        private int type;

        public Scheme() {
        }

        public Object getObj() {
            return this.obj;
        }

        public String getOther() {
            return this.other;
        }

        public String getScheme() {
            return this.scheme;
        }

        public int getShcemeColor() {
            return this.shcemeColor;
        }

        public int getType() {
            return this.type;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }

        public void setOther(String str) {
            this.other = str;
        }

        public void setScheme(String str) {
            this.scheme = str;
        }

        public void setShcemeColor(int i3) {
            this.shcemeColor = i3;
        }

        public void setType(int i3) {
            this.type = i3;
        }

        public Scheme(int i3, int i10, String str, String str2) {
            this.type = i3;
            this.shcemeColor = i10;
            this.scheme = str;
            this.other = str2;
        }

        public Scheme(int i3, int i10, String str) {
            this.type = i3;
            this.shcemeColor = i10;
            this.scheme = str;
        }

        public Scheme(int i3, String str) {
            this.shcemeColor = i3;
            this.scheme = str;
        }

        public Scheme(int i3, String str, String str2) {
            this.shcemeColor = i3;
            this.scheme = str;
            this.other = str2;
        }
    }

    public void addScheme(Scheme scheme) {
        if (this.schemes == null) {
            this.schemes = new ArrayList();
        }
        this.schemes.add(scheme);
    }

    public final void clearScheme() {
        setScheme("");
        setSchemeColor(0);
        setSchemes(null);
    }

    public final int differ(Calendar calendar) {
        return t.d(this, calendar);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Calendar)) {
            Calendar calendar = (Calendar) obj;
            if (calendar.getYear() == this.year && calendar.getMonth() == this.month && calendar.getDay() == this.day) {
                return true;
            }
        }
        return super.equals(obj);
    }

    public int getDay() {
        return this.day;
    }

    public String getGregorianFestival() {
        return this.gregorianFestival;
    }

    public int getLeapMonth() {
        return this.leapMonth;
    }

    public String getLunar() {
        return this.lunar;
    }

    public Calendar getLunarCalendar() {
        return this.lunarCalendar;
    }

    public int getMonth() {
        return this.month;
    }

    public String getScheme() {
        return this.scheme;
    }

    public int getSchemeColor() {
        return this.schemeColor;
    }

    public List<Scheme> getSchemes() {
        return this.schemes;
    }

    public String getSolarTerm() {
        return this.solarTerm;
    }

    public long getTimeInMillis() {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(1, this.year);
        calendar.set(2, this.month - 1);
        calendar.set(5, this.day);
        return calendar.getTimeInMillis();
    }

    public String getTraditionFestival() {
        return this.traditionFestival;
    }

    public int getWeek() {
        return this.week;
    }

    public int getYear() {
        return this.year;
    }

    public boolean hasScheme() {
        List<Scheme> list = this.schemes;
        return ((list == null || list.size() == 0) && TextUtils.isEmpty(this.scheme)) ? false : true;
    }

    public boolean isAvailable() {
        int i3 = this.year;
        boolean z5 = i3 > 0;
        int i10 = this.month;
        boolean z6 = z5 & (i10 > 0);
        int i11 = this.day;
        return z6 & (i11 > 0) & (i11 <= 31) & (i10 <= 12) & (i3 >= 1900) & (i3 <= 2099);
    }

    public boolean isCurrentDay() {
        return this.isCurrentDay;
    }

    public boolean isCurrentMonth() {
        return this.isCurrentMonth;
    }

    public boolean isLeapYear() {
        return this.isLeapYear;
    }

    public boolean isSameMonth(Calendar calendar) {
        return this.year == calendar.getYear() && this.month == calendar.getMonth();
    }

    public boolean isWeekend() {
        return this.isWeekend;
    }

    public final void mergeScheme(Calendar calendar, String str) {
        if (calendar == null) {
            return;
        }
        if (!TextUtils.isEmpty(calendar.getScheme())) {
            str = calendar.getScheme();
        }
        setScheme(str);
        setSchemeColor(calendar.getSchemeColor());
        setSchemes(calendar.getSchemes());
    }

    public void setCurrentDay(boolean z5) {
        this.isCurrentDay = z5;
    }

    public void setCurrentMonth(boolean z5) {
        this.isCurrentMonth = z5;
    }

    public void setDay(int i3) {
        this.day = i3;
    }

    public void setGregorianFestival(String str) {
        this.gregorianFestival = str;
    }

    public void setLeapMonth(int i3) {
        this.leapMonth = i3;
    }

    public void setLeapYear(boolean z5) {
        this.isLeapYear = z5;
    }

    public void setLunar(String str) {
        this.lunar = str;
    }

    public void setLunarCalendar(Calendar calendar) {
        this.lunarCalendar = calendar;
    }

    public void setMonth(int i3) {
        this.month = i3;
    }

    public void setScheme(String str) {
        this.scheme = str;
    }

    public void setSchemeColor(int i3) {
        this.schemeColor = i3;
    }

    public void setSchemes(List<Scheme> list) {
        this.schemes = list;
    }

    public void setSolarTerm(String str) {
        this.solarTerm = str;
    }

    public void setTraditionFestival(String str) {
        this.traditionFestival = str;
    }

    public void setWeek(int i3) {
        this.week = i3;
    }

    public void setWeekend(boolean z5) {
        this.isWeekend = z5;
    }

    public void setYear(int i3) {
        this.year = i3;
    }

    public String toString() {
        Object valueOf;
        Object valueOf2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.year);
        sb2.append("");
        int i3 = this.month;
        if (i3 < 10) {
            valueOf = "0" + this.month;
        } else {
            valueOf = Integer.valueOf(i3);
        }
        sb2.append(valueOf);
        sb2.append("");
        int i10 = this.day;
        if (i10 < 10) {
            valueOf2 = "0" + this.day;
        } else {
            valueOf2 = Integer.valueOf(i10);
        }
        sb2.append(valueOf2);
        return sb2.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(Calendar calendar) {
        if (calendar == null) {
            return 1;
        }
        return toString().compareTo(calendar.toString());
    }

    public void addScheme(int i3, String str) {
        if (this.schemes == null) {
            this.schemes = new ArrayList();
        }
        this.schemes.add(new Scheme(i3, str));
    }

    public void addScheme(int i3, int i10, String str) {
        if (this.schemes == null) {
            this.schemes = new ArrayList();
        }
        this.schemes.add(new Scheme(i3, i10, str));
    }

    public void addScheme(int i3, int i10, String str, String str2) {
        if (this.schemes == null) {
            this.schemes = new ArrayList();
        }
        this.schemes.add(new Scheme(i3, i10, str, str2));
    }

    public void addScheme(int i3, String str, String str2) {
        if (this.schemes == null) {
            this.schemes = new ArrayList();
        }
        this.schemes.add(new Scheme(i3, str, str2));
    }
}
