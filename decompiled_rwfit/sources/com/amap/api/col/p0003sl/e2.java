package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class e2 {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList<OfflineMapProvince> f3956a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private p2 f3957b;

    /* renamed from: c, reason: collision with root package name */
    private Context f3958c;

    public e2(Context context) {
        this.f3958c = context;
        this.f3957b = p2.b(context);
    }

    public boolean a(int i3) {
        return i3 == 0 || i3 == 2 || i3 == 3 || i3 == 1 || i3 == 102 || i3 == 101 || i3 == 103 || i3 == -1;
    }

    public ArrayList<OfflineMapProvince> b() {
        ArrayList<OfflineMapProvince> arrayList = new ArrayList<>();
        synchronized (this.f3956a) {
            try {
                ArrayList<OfflineMapProvince> arrayList2 = this.f3956a;
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    OfflineMapProvince offlineMapProvince = arrayList2.get(i3);
                    i3++;
                    arrayList.add(offlineMapProvince);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return arrayList;
    }

    public OfflineMapProvince a(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f3956a) {
            try {
                ArrayList<OfflineMapProvince> arrayList = this.f3956a;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    OfflineMapProvince offlineMapProvince = arrayList.get(i3);
                    i3++;
                    OfflineMapProvince offlineMapProvince2 = offlineMapProvince;
                    if (offlineMapProvince2.getProvinceName().trim().equalsIgnoreCase(str.trim())) {
                        return offlineMapProvince2;
                    }
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void a(z1 z1Var, OfflineMapCity offlineMapCity) {
        int e = z1Var.f5534v.e();
        if (z1Var.f5534v.equals(z1Var.f5524k)) {
            k2 s7 = z1Var.s();
            p2 p2Var = this.f3957b;
            if (p2Var != null) {
                p2Var.a(s7);
            }
        } else {
            if (z1Var.f5534v.equals(z1Var.f5529p)) {
                z1Var.getCity();
                File[] listFiles = new File(v4.a(this.f3958c)).listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (file.isFile() && file.exists() && file.getName().contains(z1Var.getAdcode()) && file.getName().endsWith(".zip.tmp.dt")) {
                            file.delete();
                        }
                    }
                }
                z1Var.s().h();
            }
            int i3 = z1Var.getcompleteCode();
            if (z1Var.f5534v.e() != 1 || i3 <= 2 || i3 >= 98) {
                k2 s8 = z1Var.s();
                p2 p2Var2 = this.f3957b;
                if (p2Var2 != null) {
                    p2Var2.b(s8);
                }
            }
        }
        offlineMapCity.setState(e);
        offlineMapCity.setCompleteCode(z1Var.getcompleteCode());
    }

    private void a(z1 z1Var, OfflineMapProvince offlineMapProvince) {
        k2 k2Var;
        int e = z1Var.f5534v.e();
        int i3 = 0;
        if (e == 6) {
            offlineMapProvince.setState(e);
            offlineMapProvince.setCompleteCode(0);
            k2 k2Var2 = new k2(offlineMapProvince, this.f3958c);
            p2 p2Var = this.f3957b;
            if (p2Var != null) {
                p2Var.a(k2Var2);
            }
            try {
                x2.a(offlineMapProvince.getProvinceCode(), this.f3958c);
                return;
            } catch (IOException e10) {
                e10.printStackTrace();
                return;
            } catch (Exception e11) {
                e11.printStackTrace();
                return;
            }
        }
        if (e == 4) {
            ArrayList<OfflineMapCity> cityList = offlineMapProvince.getCityList();
            int size = cityList.size();
            while (i3 < size) {
                OfflineMapCity offlineMapCity = cityList.get(i3);
                i3++;
                if (offlineMapCity.getState() != 4) {
                    return;
                }
            }
            if (z1Var.getPinyin().equals(offlineMapProvince.getPinyin())) {
                offlineMapProvince.setState(e);
                offlineMapProvince.setCompleteCode(z1Var.getcompleteCode());
                offlineMapProvince.setVersion(z1Var.getVersion());
                offlineMapProvince.setUrl(z1Var.getUrl());
                k2Var = new k2(offlineMapProvince, this.f3958c);
                k2Var.f(z1Var.n());
                k2Var.d(z1Var.getCode());
            } else {
                offlineMapProvince.setState(e);
                offlineMapProvince.setCompleteCode(100);
                k2Var = new k2(offlineMapProvince, this.f3958c);
            }
            k2Var.h();
            p2 p2Var2 = this.f3957b;
            if (p2Var2 != null) {
                p2Var2.b(k2Var);
            }
            k2Var.c();
        }
    }

    public void a(List<OfflineMapProvince> list) {
        OfflineMapProvince offlineMapProvince;
        OfflineMapCity offlineMapCity;
        synchronized (this.f3956a) {
            try {
                if (this.f3956a.size() > 0) {
                    for (int i3 = 0; i3 < this.f3956a.size(); i3++) {
                        OfflineMapProvince offlineMapProvince2 = this.f3956a.get(i3);
                        Iterator<OfflineMapProvince> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                offlineMapProvince = null;
                                break;
                            }
                            offlineMapProvince = it.next();
                            if (offlineMapProvince2.getPinyin().equals(offlineMapProvince.getPinyin())) {
                                break;
                            }
                            if (!offlineMapProvince2.getPinyin().equals("quanguogaiyaotu") && !offlineMapProvince2.getProvinceCode().equals("000001") && !offlineMapProvince2.getProvinceCode().equals("100000")) {
                            }
                            if (offlineMapProvince.getPinyin().equals("quanguogaiyaotu")) {
                                break;
                            }
                        }
                        if (offlineMapProvince != null) {
                            offlineMapProvince2.setUrl(offlineMapProvince.getUrl());
                            offlineMapProvince2.setVersion(offlineMapProvince.getVersion());
                            offlineMapProvince2.setSize(offlineMapProvince.getSize());
                            offlineMapProvince2.setPinyin(offlineMapProvince.getPinyin());
                            offlineMapProvince2.setJianpin(offlineMapProvince.getJianpin());
                            ArrayList<OfflineMapCity> cityList = offlineMapProvince2.getCityList();
                            ArrayList<OfflineMapCity> cityList2 = offlineMapProvince.getCityList();
                            for (int i10 = 0; i10 < cityList.size(); i10++) {
                                OfflineMapCity offlineMapCity2 = cityList.get(i10);
                                int size = cityList2.size();
                                int i11 = 0;
                                while (true) {
                                    if (i11 >= size) {
                                        offlineMapCity = null;
                                        break;
                                    }
                                    OfflineMapCity offlineMapCity3 = cityList2.get(i11);
                                    i11++;
                                    offlineMapCity = offlineMapCity3;
                                    if (offlineMapCity2.getPinyin().equals(offlineMapCity.getPinyin())) {
                                        break;
                                    }
                                }
                                if (offlineMapCity != null) {
                                    offlineMapCity2.setUrl(offlineMapCity.getUrl());
                                    offlineMapCity2.setVersion(offlineMapCity.getVersion());
                                    offlineMapCity2.setSize(offlineMapCity.getSize());
                                    offlineMapCity2.setCode(offlineMapCity.getCode());
                                    offlineMapCity2.setPinyin(offlineMapCity.getPinyin());
                                    offlineMapCity2.setJianpin(offlineMapCity.getJianpin());
                                }
                            }
                        }
                    }
                } else {
                    Iterator<OfflineMapProvince> it2 = list.iterator();
                    while (it2.hasNext()) {
                        this.f3956a.add(it2.next());
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void a(z1 z1Var) {
        String pinyin = z1Var.getPinyin();
        synchronized (this.f3956a) {
            try {
                ArrayList<OfflineMapProvince> arrayList = this.f3956a;
                int size = arrayList.size();
                int i3 = 0;
                loop0: while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    OfflineMapProvince offlineMapProvince = arrayList.get(i3);
                    i3++;
                    OfflineMapProvince offlineMapProvince2 = offlineMapProvince;
                    if (offlineMapProvince2 != null) {
                        ArrayList<OfflineMapCity> cityList = offlineMapProvince2.getCityList();
                        int size2 = cityList.size();
                        int i10 = 0;
                        while (i10 < size2) {
                            OfflineMapCity offlineMapCity = cityList.get(i10);
                            i10++;
                            OfflineMapCity offlineMapCity2 = offlineMapCity;
                            if (offlineMapCity2.getPinyin().trim().equals(pinyin.trim())) {
                                a(z1Var, offlineMapCity2);
                                a(z1Var, offlineMapProvince2);
                                break loop0;
                            }
                        }
                    }
                }
            } finally {
            }
        }
    }

    public void a() {
        ArrayList<OfflineMapProvince> arrayList = this.f3956a;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f3956a.clear();
            }
        }
        this.f3957b = null;
        this.f3958c = null;
    }
}
