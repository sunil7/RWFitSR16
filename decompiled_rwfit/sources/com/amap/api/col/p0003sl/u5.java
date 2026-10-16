package com.amap.api.col.p0003sl;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.map3d.R;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapActivity;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class u5 extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private List<OfflineMapCity> f5134a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private OfflineMapManager f5135b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f5136c;

    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f5137a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ OfflineMapCity f5138b;

        public a(b bVar, OfflineMapCity offlineMapCity) {
            this.f5137a = bVar;
            this.f5138b = offlineMapCity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f5137a.f5143d.setVisibility(8);
            this.f5137a.f5142c.setVisibility(0);
            this.f5137a.f5142c.setText(n1.a(R.string.O105492_29));
            try {
                u5.this.f5135b.downloadByCityName(this.f5138b.getCity());
            } catch (AMapException e) {
                e.printStackTrace();
            }
        }
    }

    public final class b {

        /* renamed from: a, reason: collision with root package name */
        public TextView f5140a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f5141b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f5142c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f5143d;

        public b(u5 u5Var) {
        }
    }

    public u5(OfflineMapManager offlineMapManager, OfflineMapActivity offlineMapActivity) {
        this.f5135b = offlineMapManager;
        this.f5136c = offlineMapActivity;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f5134a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return this.f5134a.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        b bVar;
        try {
            OfflineMapCity offlineMapCity = this.f5134a.get(i3);
            if (view == null) {
                bVar = new b(this);
                view = a6.a(this.f5136c, R.layout.amap_map3d_offlinemap_child, null);
                TextView textView = (TextView) view.findViewById(R.id.amap_map3d_name);
                bVar.f5140a = textView;
                textView.setText(n1.a(R.string.O105492_76));
                TextView textView2 = (TextView) view.findViewById(R.id.amap_map3d_name_size);
                bVar.f5141b = textView2;
                textView2.setText(n1.a(R.string.O105492_77));
                bVar.f5142c = (TextView) view.findViewById(R.id.amap_map3d_download_progress_status);
                bVar.f5143d = (ImageView) view.findViewById(R.id.amap_map3d_download_status_image);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.f5143d.setOnClickListener(new a(bVar, offlineMapCity));
            bVar.f5142c.setVisibility(0);
            bVar.f5140a.setText(offlineMapCity.getCity());
            TextView textView3 = bVar.f5141b;
            textView3.setText(String.valueOf(((int) (((offlineMapCity.getSize() / 1024.0d) / 1024.0d) * 100.0d)) / 100.0d) + " M");
            int state = offlineMapCity.getState();
            if (state == 6) {
                bVar.f5143d.setVisibility(0);
                bVar.f5142c.setVisibility(8);
                return view;
            }
            if (state != -1) {
                if (state == 0 || state == 1) {
                    bVar.f5143d.setVisibility(8);
                    bVar.f5142c.setText(n1.a(R.string.O105492_29));
                    return view;
                }
                if (state == 2) {
                    bVar.f5143d.setVisibility(8);
                    bVar.f5142c.setText("等待下载");
                    return view;
                }
                if (state == 3) {
                    bVar.f5143d.setVisibility(8);
                    bVar.f5142c.setText(n1.a(R.string.O105492_78));
                    return view;
                }
                if (state != 4) {
                    switch (state) {
                    }
                    return view;
                }
                bVar.f5143d.setVisibility(8);
                bVar.f5142c.setText(n1.a(R.string.O105492_31));
                return view;
            }
            bVar.f5143d.setVisibility(8);
            bVar.f5142c.setText(n1.a(R.string.O105492_79));
            return view;
        } catch (Exception e) {
            e.printStackTrace();
            return view;
        }
    }

    public void a(List<OfflineMapCity> list) {
        this.f5134a = list;
    }
}
