package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.R$id;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class i3 extends o1.b implements View.OnClickListener {

    /* renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f930x = 0;

    /* renamed from: h, reason: collision with root package name */
    public final int f931h;

    /* renamed from: i, reason: collision with root package name */
    public final int f932i;

    /* renamed from: j, reason: collision with root package name */
    public final LayoutInflater f933j;

    /* renamed from: k, reason: collision with root package name */
    public final SearchView f934k;

    /* renamed from: l, reason: collision with root package name */
    public final SearchableInfo f935l;

    /* renamed from: m, reason: collision with root package name */
    public final Context f936m;

    /* renamed from: n, reason: collision with root package name */
    public final WeakHashMap f937n;

    /* renamed from: o, reason: collision with root package name */
    public final int f938o;

    /* renamed from: p, reason: collision with root package name */
    public int f939p;

    /* renamed from: q, reason: collision with root package name */
    public ColorStateList f940q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f941s;

    /* renamed from: t, reason: collision with root package name */
    public int f942t;

    /* renamed from: u, reason: collision with root package name */
    public int f943u;

    /* renamed from: v, reason: collision with root package name */
    public int f944v;

    /* renamed from: w, reason: collision with root package name */
    public int f945w;

    public i3(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        int suggestionRowLayout = searchView.getSuggestionRowLayout();
        this.f16683b = true;
        this.f16684c = null;
        this.f16682a = false;
        this.f16685d = -1;
        this.e = new o1.a(this);
        this.f16686f = new d2(this, 3);
        this.f932i = suggestionRowLayout;
        this.f931h = suggestionRowLayout;
        this.f933j = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f939p = 1;
        this.r = -1;
        this.f941s = -1;
        this.f942t = -1;
        this.f943u = -1;
        this.f944v = -1;
        this.f945w = -1;
        this.f934k = searchView;
        this.f935l = searchableInfo;
        this.f938o = searchView.getSuggestionCommitIconResId();
        this.f936m = context;
        this.f937n = weakHashMap;
    }

    public static String h(Cursor cursor, int i3) {
        if (i3 == -1) {
            return null;
        }
        try {
            return cursor.getString(i3);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0130  */
    @Override // o1.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.view.View r21, android.database.Cursor r22) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i3.a(android.view.View, android.database.Cursor):void");
    }

    @Override // o1.b
    public final void b(Cursor cursor) {
        try {
            super.b(cursor);
            if (cursor != null) {
                this.r = cursor.getColumnIndex("suggest_text_1");
                this.f941s = cursor.getColumnIndex("suggest_text_2");
                this.f942t = cursor.getColumnIndex("suggest_text_2_url");
                this.f943u = cursor.getColumnIndex("suggest_icon_1");
                this.f944v = cursor.getColumnIndex("suggest_icon_2");
                this.f945w = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // o1.b
    public final String c(Cursor cursor) {
        String h4;
        String h10;
        if (cursor == null) {
            return null;
        }
        String h11 = h(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (h11 != null) {
            return h11;
        }
        SearchableInfo searchableInfo = this.f935l;
        if (searchableInfo.shouldRewriteQueryFromData() && (h10 = h(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
            return h10;
        }
        if (!searchableInfo.shouldRewriteQueryFromText() || (h4 = h(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
            return null;
        }
        return h4;
    }

    @Override // o1.b
    public final View d(ViewGroup viewGroup) {
        View inflate = this.f933j.inflate(this.f931h, viewGroup, false);
        inflate.setTag(new h3(inflate));
        ((ImageView) inflate.findViewById(R$id.edit_query)).setImageResource(this.f938o);
        return inflate;
    }

    public final Drawable e(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f936m.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    parseInt = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (parseInt != 0) {
                return resourcesForApplication.getDrawable(parseInt);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable f(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.i3.f(java.lang.String):android.graphics.drawable.Drawable");
    }

    public final Cursor g(SearchableInfo searchableInfo, String str) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        fragment.appendQueryParameter("limit", String.valueOf(50));
        return this.f936m.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }

    @Override // o1.b, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i3, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i3, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View inflate = this.f933j.inflate(this.f932i, viewGroup, false);
            if (inflate != null) {
                ((h3) inflate.getTag()).f924a.setText(e.toString());
            }
            return inflate;
        }
    }

    @Override // o1.b, android.widget.Adapter
    public final View getView(int i3, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i3, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View d5 = d(viewGroup);
            ((h3) d5.getTag()).f924a.setText(e.toString());
            return d5;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Cursor cursor = this.f16684c;
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        Cursor cursor = this.f16684c;
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f934k.r((CharSequence) tag);
        }
    }
}
