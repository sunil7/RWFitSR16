package com.amap.api.col.p0003sl;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.amap.api.map3d.R;
import com.amap.api.maps.offlinemap.DownLoadExpandListView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.amap.api.services.core.AMapException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class z5 extends com.amap.api.offlineservice.a implements OfflineMapManager.OfflineMapDownloadListener, OfflineMapManager.OfflineLoadedListener, View.OnTouchListener, TextWatcher, AbsListView.OnScrollListener {
    private v5 A;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f5543b;

    /* renamed from: c, reason: collision with root package name */
    private RelativeLayout f5544c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f5545d;
    private DownLoadExpandListView e;

    /* renamed from: f, reason: collision with root package name */
    private ListView f5546f;

    /* renamed from: g, reason: collision with root package name */
    private ExpandableListView f5547g;

    /* renamed from: h, reason: collision with root package name */
    private TextView f5548h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f5549i;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f5550j;

    /* renamed from: k, reason: collision with root package name */
    private AutoCompleteTextView f5551k;

    /* renamed from: l, reason: collision with root package name */
    private RelativeLayout f5552l;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f5553m;

    /* renamed from: n, reason: collision with root package name */
    private ImageView f5554n;

    /* renamed from: o, reason: collision with root package name */
    private ImageView f5555o;

    /* renamed from: p, reason: collision with root package name */
    private RelativeLayout f5556p;

    /* renamed from: q, reason: collision with root package name */
    private TextView f5557q;

    /* renamed from: s, reason: collision with root package name */
    private t5 f5558s;

    /* renamed from: u, reason: collision with root package name */
    private s5 f5560u;

    /* renamed from: v, reason: collision with root package name */
    private u5 f5561v;
    private List<OfflineMapProvince> r = new ArrayList();

    /* renamed from: t, reason: collision with root package name */
    private OfflineMapManager f5559t = null;

    /* renamed from: w, reason: collision with root package name */
    private boolean f5562w = true;

    /* renamed from: x, reason: collision with root package name */
    private boolean f5563x = true;

    /* renamed from: y, reason: collision with root package name */
    private int f5564y = -1;

    /* renamed from: z, reason: collision with root package name */
    private long f5565z = 0;
    private boolean B = true;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                z5.this.f5551k.setText("");
                z5.this.f5554n.setVisibility(8);
                z5.this.a(false);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) z5.this.f5555o.getLayoutParams();
                layoutParams.leftMargin = z5.this.a(95.0f);
                z5.this.f5555o.setLayoutParams(layoutParams);
                z5.this.f5551k.setPadding(z5.this.a(105.0f), 0, 0, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class b implements Comparator<OfflineMapCity> {
        public b(z5 z5Var) {
        }

        @Override // java.util.Comparator
        public int compare(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
            char[] charArray = offlineMapCity.getJianpin().toCharArray();
            char[] charArray2 = offlineMapCity2.getJianpin().toCharArray();
            return (charArray[0] >= charArray2[0] && charArray[1] >= charArray2[1]) ? 0 : 1;
        }
    }

    private void f() {
        ArrayList<OfflineMapProvince> offlineMapProvinceList = this.f5559t.getOfflineMapProvinceList();
        this.r.clear();
        this.r.add(null);
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList2 = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList3 = new ArrayList<>();
        for (int i3 = 0; i3 < offlineMapProvinceList.size(); i3++) {
            OfflineMapProvince offlineMapProvince = offlineMapProvinceList.get(i3);
            if (offlineMapProvince.getCityList().size() != 1) {
                this.r.add(i3 + 1, offlineMapProvince);
            } else {
                String provinceName = offlineMapProvince.getProvinceName();
                if (provinceName.contains(n1.a(R.string.O105492_72))) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains(n1.a(R.string.O105492_73))) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains("全国概要图")) {
                    arrayList3.addAll(0, offlineMapProvince.getCityList());
                } else {
                    arrayList3.addAll(offlineMapProvince.getCityList());
                }
            }
        }
        OfflineMapProvince offlineMapProvince2 = new OfflineMapProvince();
        offlineMapProvince2.setProvinceName(n1.a(R.string.O105492_17));
        offlineMapProvince2.setCityList(arrayList3);
        this.r.set(0, offlineMapProvince2);
        OfflineMapProvince offlineMapProvince3 = new OfflineMapProvince();
        offlineMapProvince3.setProvinceName(n1.a(R.string.O105492_71));
        offlineMapProvince3.setCityList(arrayList);
        OfflineMapProvince offlineMapProvince4 = new OfflineMapProvince();
        offlineMapProvince4.setProvinceName(n1.a(R.string.O105492_74));
        offlineMapProvince4.setCityList(arrayList2);
        this.r.add(offlineMapProvince4);
        OfflineMapProvince offlineMapProvince5 = new OfflineMapProvince();
        offlineMapProvince5.setProvinceName(n1.a(R.string.O105492_19));
        ArrayList<OfflineMapCity> arrayList4 = new ArrayList<>();
        OfflineMapCity offlineMapCity = new OfflineMapCity();
        offlineMapCity.setCity(n1.a(R.string.O105492_21));
        arrayList4.add(offlineMapCity);
        offlineMapProvince5.setCityList(arrayList4);
        this.r.add(offlineMapProvince5);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i10, int i11) {
    }

    @Override // com.amap.api.offlineservice.a
    public void d() {
        this.f5559t.destroy();
    }

    @Override // com.amap.api.offlineservice.a
    public void e() {
        View a3 = a6.a(this.f5835a, R.layout.amap_map3d_expand_header, null);
        DownLoadExpandListView downLoadExpandListView = (DownLoadExpandListView) a3.findViewById(R.id.amap_map3d_download_listview);
        this.e = downLoadExpandListView;
        downLoadExpandListView.setOnTouchListener(this);
        this.f5552l = (RelativeLayout) a3.findViewById(R.id.amap_map3d_download_header);
        this.f5549i = (ImageView) a3.findViewById(R.id.amap_map3d_download_header_image);
        this.f5552l.setOnClickListener(this.f5835a);
        this.f5553m = (RelativeLayout) a3.findViewById(R.id.amap_map3d_city_header);
        TextView textView = (TextView) a3.findViewById(R.id.amap_map3d_city_header_text);
        this.f5548h = textView;
        textView.setText(n1.a(R.string.O105492_16));
        this.f5550j = (ImageView) a3.findViewById(R.id.amap_map3d_city_header_image);
        this.f5553m.setOnClickListener(this.f5835a);
        this.f5556p = (RelativeLayout) a3.findViewById(R.id.amap_map3d_divider1);
        TextView textView2 = (TextView) a3.findViewById(R.id.amap_map3d_download_header_text);
        this.f5557q = textView2;
        textView2.setText(n1.a(R.string.O105492_15));
        ((TextView) a3.findViewById(R.id.amap_map3d_download_header_text)).setText(n1.a(R.string.O105492_224));
        ImageView imageView = (ImageView) this.f5544c.findViewById(R.id.amap_map3d_download_title_back);
        this.f5543b = imageView;
        imageView.setOnClickListener(this.f5835a);
        TextView textView3 = (TextView) this.f5544c.findViewById(R.id.amap_map3d_download_title_text);
        this.f5545d = textView3;
        textView3.setText(n1.a(R.string.O105492_20));
        this.f5555o = (ImageView) this.f5544c.findViewById(R.id.amap_map3d_search_input_searchimg);
        ImageView imageView2 = (ImageView) this.f5544c.findViewById(R.id.amap_map3d_search_input_clean);
        this.f5554n = imageView2;
        imageView2.setOnClickListener(new a());
        this.f5544c.findViewById(R.id.amap_map3d_footer).setOnTouchListener(this);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.f5544c.findViewById(R.id.amap_map3d_search_input);
        this.f5551k = autoCompleteTextView;
        autoCompleteTextView.addTextChangedListener(this);
        this.f5551k.setOnTouchListener(this);
        this.f5546f = (ListView) this.f5544c.findViewById(R.id.amap_map3d_search_listview);
        ExpandableListView expandableListView = (ExpandableListView) this.f5544c.findViewById(R.id.amap_map3d_city_listview);
        this.f5547g = expandableListView;
        expandableListView.addHeaderView(a3);
        this.f5547g.setOnTouchListener(this);
        this.f5547g.setOnScrollListener(this);
        try {
            OfflineMapManager offlineMapManager = new OfflineMapManager(this.f5835a, this);
            this.f5559t = offlineMapManager;
            offlineMapManager.setOnOfflineLoadedListener(this);
        } catch (Exception e) {
            Log.e("OfflineMapPage", "e=" + e);
        }
        f();
        t5 t5Var = new t5(this.r, this.f5559t, this.f5835a);
        this.f5558s = t5Var;
        this.f5547g.setAdapter(t5Var);
        this.f5547g.setOnGroupCollapseListener(this.f5558s);
        this.f5547g.setOnGroupExpandListener(this.f5558s);
        this.f5547g.setGroupIndicator(null);
        if (this.f5562w) {
            this.f5550j.setBackgroundResource(R.drawable.amap_map3d_collapse);
            this.f5547g.setVisibility(0);
        } else {
            this.f5550j.setBackgroundResource(R.drawable.amap_map3d_expand);
            this.f5547g.setVisibility(8);
        }
        if (this.f5563x) {
            this.f5549i.setBackgroundResource(R.drawable.amap_map3d_collapse);
            this.e.setVisibility(0);
        } else {
            this.f5549i.setBackgroundResource(R.drawable.amap_map3d_expand);
            this.e.setVisibility(8);
        }
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public void onCheckUpdate(boolean z5, String str) {
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public void onDownload(int i3, int i10, String str) {
        if (i3 == 101) {
            try {
                Toast.makeText(this.f5835a, n1.a(R.string.O105492_288), 0).show();
                this.f5559t.pause();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (i3 == 2) {
            this.f5560u.b();
        }
        if (this.f5564y == i3) {
            if (System.currentTimeMillis() - this.f5565z > AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS) {
                if (this.B) {
                    this.f5560u.notifyDataSetChanged();
                }
                this.f5565z = System.currentTimeMillis();
                return;
            }
            return;
        }
        t5 t5Var = this.f5558s;
        if (t5Var != null) {
            t5Var.notifyDataSetChanged();
        }
        s5 s5Var = this.f5560u;
        if (s5Var != null) {
            s5Var.notifyDataSetChanged();
        }
        u5 u5Var = this.f5561v;
        if (u5Var != null) {
            u5Var.notifyDataSetChanged();
        }
        this.f5564y = i3;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public void onRemove(boolean z5, String str, String str2) {
        s5 s5Var = this.f5560u;
        if (s5Var != null) {
            s5Var.a();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i10, int i11) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        if (i3 == 2) {
            this.B = false;
        } else {
            this.B = true;
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i10, int i11) {
        if (TextUtils.isEmpty(charSequence)) {
            a(false);
            this.f5554n.setVisibility(8);
            return;
        }
        this.f5554n.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        List<OfflineMapProvince> list = this.r;
        if (list != null && list.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<OfflineMapProvince> it = this.r.iterator();
            while (it.hasNext()) {
                arrayList2.addAll(it.next().getCityList());
            }
            int size = arrayList2.size();
            int i12 = 0;
            while (i12 < size) {
                Object obj = arrayList2.get(i12);
                i12++;
                OfflineMapCity offlineMapCity = (OfflineMapCity) obj;
                String city = offlineMapCity.getCity();
                String pinyin = offlineMapCity.getPinyin();
                String jianpin = offlineMapCity.getJianpin();
                if (charSequence.length() == 1) {
                    if (jianpin.startsWith(String.valueOf(charSequence))) {
                        arrayList.add(offlineMapCity);
                    }
                } else if (jianpin.startsWith(String.valueOf(charSequence)) || pinyin.startsWith(String.valueOf(charSequence)) || city.startsWith(String.valueOf(charSequence))) {
                    arrayList.add(offlineMapCity);
                }
            }
        }
        if (arrayList.size() <= 0) {
            Toast.makeText(this.f5835a, n1.a(R.string.O105492_287), 0).show();
            return;
        }
        a(true);
        Collections.sort(arrayList, new b(this));
        u5 u5Var = this.f5561v;
        if (u5Var != null) {
            u5Var.a(arrayList);
            this.f5561v.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        AutoCompleteTextView autoCompleteTextView = this.f5551k;
        if (autoCompleteTextView != null && autoCompleteTextView.isFocused()) {
            this.f5551k.clearFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.f5835a.getSystemService("input_method");
            if (inputMethodManager != null ? inputMethodManager.isActive() : false) {
                inputMethodManager.hideSoftInputFromWindow(this.f5551k.getWindowToken(), 2);
            }
        }
        if (view.getId() == R.id.amap_map3d_search_input) {
            try {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f5555o.getLayoutParams();
                layoutParams.leftMargin = a(18.0f);
                this.f5555o.setLayoutParams(layoutParams);
                this.f5551k.setPadding(a(30.0f), 0, 0, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineLoadedListener
    public void onVerifyComplete() {
        f();
        u5 u5Var = new u5(this.f5559t, this.f5835a);
        this.f5561v = u5Var;
        this.f5546f.setAdapter((ListAdapter) u5Var);
        s5 s5Var = new s5(this.f5835a, this, this.f5559t, this.r);
        this.f5560u = s5Var;
        this.e.setAdapter(s5Var);
        this.f5560u.notifyDataSetChanged();
    }

    @Override // com.amap.api.offlineservice.a
    public void a(View view) {
        try {
            int id2 = view.getId();
            if (id2 == R.id.amap_map3d_download_title_back) {
                this.f5835a.closeScr();
                return;
            }
            if (id2 == R.id.amap_map3d_download_header) {
                if (this.f5563x) {
                    this.e.setVisibility(8);
                    this.f5549i.setBackgroundResource(R.drawable.amap_map3d_expand);
                    this.f5563x = false;
                    return;
                } else {
                    this.e.setVisibility(0);
                    this.f5549i.setBackgroundResource(R.drawable.amap_map3d_collapse);
                    this.f5563x = true;
                    return;
                }
            }
            if (id2 == R.id.amap_map3d_city_header) {
                if (this.f5562w) {
                    this.f5558s.a();
                    this.f5550j.setBackgroundResource(R.drawable.amap_map3d_expand);
                    this.f5562w = false;
                } else {
                    this.f5558s.b();
                    this.f5550j.setBackgroundResource(R.drawable.amap_map3d_collapse);
                    this.f5562w = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.offlineservice.a
    public RelativeLayout b() {
        if (this.f5544c == null) {
            this.f5544c = (RelativeLayout) a6.a(this.f5835a, R.layout.amap_map3d_service_offlinemap_layout, null);
        }
        return this.f5544c;
    }

    public void a(OfflineMapCity offlineMapCity) {
        try {
            if (this.A == null) {
                this.A = new v5(this.f5835a, this.f5559t);
            }
            this.A.a(offlineMapCity.getState(), offlineMapCity.getCity());
            this.A.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.offlineservice.a
    public boolean a() {
        try {
            if (this.f5546f.getVisibility() != 0) {
                return true;
            }
            this.f5551k.setText("");
            this.f5554n.setVisibility(8);
            a(false);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public void a(boolean z5) {
        if (z5) {
            this.f5552l.setVisibility(8);
            this.f5553m.setVisibility(8);
            this.e.setVisibility(8);
            this.f5547g.setVisibility(8);
            this.f5556p.setVisibility(8);
            this.f5546f.setVisibility(0);
            return;
        }
        this.f5552l.setVisibility(0);
        this.f5553m.setVisibility(0);
        this.f5556p.setVisibility(0);
        this.e.setVisibility(this.f5563x ? 0 : 8);
        this.f5547g.setVisibility(this.f5562w ? 0 : 8);
        this.f5546f.setVisibility(8);
    }
}
