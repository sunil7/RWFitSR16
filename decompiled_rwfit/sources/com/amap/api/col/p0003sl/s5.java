package com.amap.api.col.p0003sl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.map3d.R;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class s5 extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    /* renamed from: a, reason: collision with root package name */
    private boolean[] f5004a;

    /* renamed from: b, reason: collision with root package name */
    private Context f5005b;

    /* renamed from: c, reason: collision with root package name */
    private x5 f5006c;

    /* renamed from: d, reason: collision with root package name */
    private List<OfflineMapProvince> f5007d = new ArrayList();
    List<OfflineMapProvince> e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private z5 f5008f;

    /* renamed from: g, reason: collision with root package name */
    private OfflineMapManager f5009g;

    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ OfflineMapCity f5010a;

        public a(OfflineMapCity offlineMapCity) {
            this.f5010a = offlineMapCity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s5.this.f5008f.a(this.f5010a);
        }
    }

    public final class b {

        /* renamed from: a, reason: collision with root package name */
        public x5 f5012a;

        public b(s5 s5Var) {
        }
    }

    public s5(Context context, z5 z5Var, OfflineMapManager offlineMapManager, List<OfflineMapProvince> list) {
        this.f5005b = context;
        this.f5008f = z5Var;
        this.f5009g = offlineMapManager;
        if (list != null && list.size() > 0) {
            this.f5007d.clear();
            this.f5007d.addAll(list);
            for (OfflineMapProvince offlineMapProvince : this.f5007d) {
                if (offlineMapProvince != null && offlineMapProvince.getDownloadedCityList().size() > 0) {
                    this.e.add(offlineMapProvince);
                }
            }
        }
        this.f5004a = new boolean[this.e.size()];
    }

    public void b() {
        for (OfflineMapProvince offlineMapProvince : this.f5007d) {
            if (offlineMapProvince.getDownloadedCityList().size() > 0 && !this.e.contains(offlineMapProvince)) {
                this.e.add(offlineMapProvince);
            }
        }
        this.f5004a = new boolean[this.e.size()];
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i3, int i10) {
        return this.e.get(i3).getDownloadedCityList().get(i10);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i3, int i10) {
        return i10;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i10, boolean z5, View view, ViewGroup viewGroup) {
        b bVar;
        if (view != null) {
            bVar = (b) view.getTag();
        } else {
            bVar = new b(this);
            x5 x5Var = new x5(this.f5005b, this.f5009g);
            this.f5006c = x5Var;
            x5Var.a(2);
            view = this.f5006c.d();
            bVar.f5012a = this.f5006c;
            view.setTag(bVar);
        }
        OfflineMapProvince offlineMapProvince = this.e.get(i3);
        if (i10 < offlineMapProvince.getDownloadedCityList().size()) {
            OfflineMapCity offlineMapCity = offlineMapProvince.getDownloadedCityList().get(i10);
            bVar.f5012a.a(offlineMapCity);
            view.setOnClickListener(new a(offlineMapCity));
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        return this.e.get(i3).getDownloadedCityList().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i3) {
        return this.e.get(i3).getProvinceName();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.e.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        return i3;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z5, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (RelativeLayout) a6.a(this.f5005b, R.layout.amap_map3d_offlinemap_group, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.amap_map3d_group_text);
        ImageView imageView = (ImageView) view.findViewById(R.id.amap_map3d_group_image);
        textView.setText(this.e.get(i3).getProvinceName());
        if (this.f5004a[i3]) {
            imageView.setImageDrawable(a6.a().getDrawable(R.drawable.amap_map3d_group_collapse));
            return view;
        }
        imageView.setImageDrawable(a6.a().getDrawable(R.drawable.amap_map3d_group_expand));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i3, int i10) {
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public void onGroupCollapse(int i3) {
        this.f5004a[i3] = false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public void onGroupExpand(int i3) {
        this.f5004a[i3] = true;
    }

    public void a() {
        try {
            for (int size = this.e.size(); size > 0; size--) {
                OfflineMapProvince offlineMapProvince = this.e.get(size - 1);
                if (offlineMapProvince.getDownloadedCityList().size() == 0) {
                    this.e.remove(offlineMapProvince);
                }
            }
            this.f5004a = new boolean[this.e.size()];
            notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
