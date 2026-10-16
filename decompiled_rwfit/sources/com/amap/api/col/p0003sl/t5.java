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
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.List;

/* loaded from: classes.dex */
public class t5 extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    /* renamed from: a, reason: collision with root package name */
    private boolean[] f5087a;

    /* renamed from: b, reason: collision with root package name */
    private int f5088b = -1;

    /* renamed from: c, reason: collision with root package name */
    private List<OfflineMapProvince> f5089c;

    /* renamed from: d, reason: collision with root package name */
    private OfflineMapManager f5090d;
    private Context e;

    public final class a {

        /* renamed from: a, reason: collision with root package name */
        public x5 f5091a;

        public a(t5 t5Var) {
        }
    }

    public t5(List<OfflineMapProvince> list, OfflineMapManager offlineMapManager, Context context) {
        this.f5089c = list;
        this.f5090d = offlineMapManager;
        this.e = context;
        this.f5087a = new boolean[list.size()];
    }

    public void a() {
        this.f5088b = 0;
        notifyDataSetChanged();
    }

    public void b() {
        this.f5088b = -1;
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i3, int i10) {
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i3, int i10) {
        return i10;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i10, boolean z5, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            aVar = new a(this);
            x5 x5Var = new x5(this.e, this.f5090d);
            x5Var.a(1);
            View d5 = x5Var.d();
            aVar.f5091a = x5Var;
            d5.setTag(aVar);
            view = d5;
        }
        aVar.f5091a.a(this.f5089c.get(i3).getCityList().get(i10));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        return (i3 == 0 || i3 == getGroupCount() + (-1)) ? this.f5089c.get(i3).getCityList().size() : this.f5089c.get(i3).getCityList().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i3) {
        return this.f5089c.get(i3).getProvinceName();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        int i3 = this.f5088b;
        return i3 == -1 ? this.f5089c.size() : i3;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        return i3;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z5, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (RelativeLayout) a6.a(this.e, R.layout.amap_map3d_offlinemap_group, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.amap_map3d_group_text);
        ImageView imageView = (ImageView) view.findViewById(R.id.amap_map3d_group_image);
        textView.setText(this.f5089c.get(i3).getProvinceName());
        if (this.f5087a[i3]) {
            imageView.setImageDrawable(a6.a().getDrawable(R.drawable.amap_map3d_group_collapse));
            return view;
        }
        imageView.setImageDrawable(a6.a().getDrawable(R.drawable.amap_map3d_group_expand));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i3, int i10) {
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public void onGroupCollapse(int i3) {
        this.f5087a[i3] = false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public void onGroupExpand(int i3) {
        this.f5087a[i3] = true;
    }
}
