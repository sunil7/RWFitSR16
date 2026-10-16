package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.customview.view.AbsSavedState;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements g.b {

    /* renamed from: g0, reason: collision with root package name */
    public static final d3 f791g0;
    public final Rect A;
    public final int[] B;
    public final int[] C;
    public final ImageView D;
    public final Drawable E;
    public final int F;
    public final int G;
    public final Intent H;
    public final Intent I;
    public final CharSequence J;
    public View.OnFocusChangeListener K;
    public View.OnClickListener L;
    public boolean M;
    public boolean N;
    public o1.b O;
    public boolean P;
    public CharSequence Q;
    public boolean R;
    public boolean S;
    public int T;
    public boolean U;
    public CharSequence V;
    public boolean W;

    /* renamed from: a0, reason: collision with root package name */
    public int f792a0;

    /* renamed from: b0, reason: collision with root package name */
    public SearchableInfo f793b0;

    /* renamed from: c0, reason: collision with root package name */
    public Bundle f794c0;

    /* renamed from: d0, reason: collision with root package name */
    public final t2 f795d0;

    /* renamed from: e0, reason: collision with root package name */
    public final t2 f796e0;

    /* renamed from: f0, reason: collision with root package name */
    public final WeakHashMap f797f0;

    /* renamed from: p, reason: collision with root package name */
    public final SearchAutoComplete f798p;

    /* renamed from: q, reason: collision with root package name */
    public final View f799q;
    public final View r;

    /* renamed from: s, reason: collision with root package name */
    public final View f800s;

    /* renamed from: t, reason: collision with root package name */
    public final ImageView f801t;

    /* renamed from: u, reason: collision with root package name */
    public final ImageView f802u;

    /* renamed from: v, reason: collision with root package name */
    public final ImageView f803v;

    /* renamed from: w, reason: collision with root package name */
    public final ImageView f804w;

    /* renamed from: x, reason: collision with root package name */
    public final View f805x;

    /* renamed from: y, reason: collision with root package name */
    public g3 f806y;

    /* renamed from: z, reason: collision with root package name */
    public final Rect f807z;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new e3();

        /* renamed from: a, reason: collision with root package name */
        public boolean f808a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f808a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public final String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f808a + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeValue(Boolean.valueOf(this.f808a));
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        public int e;

        /* renamed from: f, reason: collision with root package name */
        public SearchView f809f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f810g;

        /* renamed from: h, reason: collision with root package name */
        public final f3 f811h;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i3 = configuration.screenWidthDp;
            int i10 = configuration.screenHeightDp;
            if (i3 >= 960 && i10 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i3 >= 600) {
                return 192;
            }
            if (i3 < 640 || i10 < 480) {
                return GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL;
            }
            return 192;
        }

        public final void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                z2.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            d3 d3Var = SearchView.f791g0;
            d3Var.getClass();
            d3.a();
            Method method = d3Var.f889c;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            return this.e <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f810g) {
                f3 f3Var = this.f811h;
                removeCallbacks(f3Var);
                post(f3Var);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean z5, int i3, Rect rect) {
            super.onFocusChanged(z5, i3, rect);
            SearchView searchView = this.f809f;
            searchView.y(searchView.N);
            searchView.post(searchView.f795d0);
            if (searchView.f798p.hasFocus()) {
                searchView.n();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i3, KeyEvent keyEvent) {
            if (i3 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f809f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i3, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z5) {
            super.onWindowFocusChanged(z5);
            if (z5 && this.f809f.hasFocus() && getVisibility() == 0) {
                this.f810g = true;
                Context context = getContext();
                d3 d3Var = SearchView.f791g0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    a();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z5) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            f3 f3Var = this.f811h;
            if (!z5) {
                this.f810g = false;
                removeCallbacks(f3Var);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f810g = true;
                    return;
                }
                this.f810g = false;
                removeCallbacks(f3Var);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f809f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i3) {
            super.setThreshold(i3);
            this.e = i3;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            this.f811h = new f3(this);
            this.e = getThreshold();
        }
    }

    static {
        d3 d3Var = null;
        if (Build.VERSION.SDK_INT < 29) {
            d3 d3Var2 = new d3();
            d3Var2.f887a = null;
            d3Var2.f888b = null;
            d3Var2.f889c = null;
            d3.a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                d3Var2.f887a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                d3Var2.f888b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                d3Var2.f889c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
            d3Var = d3Var2;
        }
        f791g0 = d3Var;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R$dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        SearchAutoComplete searchAutoComplete = this.f798p;
        searchAutoComplete.setText(charSequence);
        searchAutoComplete.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    @Override // g.b
    public final void c() {
        if (this.W) {
            return;
        }
        this.W = true;
        SearchAutoComplete searchAutoComplete = this.f798p;
        int imeOptions = searchAutoComplete.getImeOptions();
        this.f792a0 = imeOptions;
        searchAutoComplete.setImeOptions(imeOptions | Const.FLAG_MUTABLE);
        searchAutoComplete.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.S = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.f798p;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.S = false;
    }

    @Override // g.b
    public final void e() {
        SearchAutoComplete searchAutoComplete = this.f798p;
        searchAutoComplete.setText("");
        searchAutoComplete.setSelection(searchAutoComplete.length());
        this.V = "";
        clearFocus();
        y(true);
        searchAutoComplete.setImeOptions(this.f792a0);
        this.W = false;
    }

    public int getImeOptions() {
        return this.f798p.getImeOptions();
    }

    public int getInputType() {
        return this.f798p.getInputType();
    }

    public int getMaxWidth() {
        return this.T;
    }

    public CharSequence getQuery() {
        return this.f798p.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.Q;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f793b0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.J : getContext().getText(this.f793b0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.G;
    }

    public int getSuggestionRowLayout() {
        return this.F;
    }

    public o1.b getSuggestionsAdapter() {
        return this.O;
    }

    public final Intent l(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.V);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f794c0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.f793b0.getSearchActivity());
        return intent;
    }

    public final Intent m(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f794c0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void n() {
        int i3 = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.f798p;
        if (i3 >= 29) {
            z2.a(searchAutoComplete);
            return;
        }
        d3 d3Var = f791g0;
        d3Var.getClass();
        d3.a();
        Method method = d3Var.f887a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, null);
            } catch (Exception unused) {
            }
        }
        d3Var.getClass();
        d3.a();
        Method method2 = d3Var.f888b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, null);
            } catch (Exception unused2) {
            }
        }
    }

    public final void o() {
        SearchAutoComplete searchAutoComplete = this.f798p;
        if (!TextUtils.isEmpty(searchAutoComplete.getText())) {
            searchAutoComplete.setText("");
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
        } else if (this.M) {
            clearFocus();
            y(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f795d0);
        post(this.f796e0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        if (z5) {
            int[] iArr = this.B;
            SearchAutoComplete searchAutoComplete = this.f798p;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.C;
            getLocationInWindow(iArr2);
            int i13 = iArr[1] - iArr2[1];
            int i14 = iArr[0] - iArr2[0];
            int width = searchAutoComplete.getWidth() + i14;
            int height = searchAutoComplete.getHeight() + i13;
            Rect rect = this.f807z;
            rect.set(i14, i13, width, height);
            int i15 = rect.left;
            int i16 = rect.right;
            int i17 = i12 - i10;
            Rect rect2 = this.A;
            rect2.set(i15, 0, i16, i17);
            g3 g3Var = this.f806y;
            if (g3Var == null) {
                g3 g3Var2 = new g3(rect2, rect, searchAutoComplete);
                this.f806y = g3Var2;
                setTouchDelegate(g3Var2);
            } else {
                g3Var.f905b.set(rect2);
                Rect rect3 = g3Var.f907d;
                rect3.set(rect2);
                int i18 = -g3Var.e;
                rect3.inset(i18, i18);
                g3Var.f906c.set(rect);
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i3, int i10) {
        int i11;
        if (this.N) {
            super.onMeasure(i3, i10);
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            int i12 = this.T;
            size = i12 > 0 ? Math.min(i12, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.T;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i11 = this.T) > 0) {
            size = Math.min(i11, size);
        }
        int mode2 = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i10);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        y(savedState.f808a);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f808a = this.N;
        return savedState;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z5) {
        super.onWindowFocusChanged(z5);
        post(this.f795d0);
    }

    public final void p(int i3) {
        int i10;
        String h4;
        Cursor cursor = this.O.f16684c;
        if (cursor != null && cursor.moveToPosition(i3)) {
            Intent intent = null;
            try {
                int i11 = i3.f930x;
                String h10 = i3.h(cursor, cursor.getColumnIndex("suggest_intent_action"));
                if (h10 == null) {
                    h10 = this.f793b0.getSuggestIntentAction();
                }
                if (h10 == null) {
                    h10 = "android.intent.action.SEARCH";
                }
                String h11 = i3.h(cursor, cursor.getColumnIndex("suggest_intent_data"));
                if (h11 == null) {
                    h11 = this.f793b0.getSuggestIntentData();
                }
                if (h11 != null && (h4 = i3.h(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                    h11 = h11 + "/" + Uri.encode(h4);
                }
                intent = l(h10, h11 == null ? null : Uri.parse(h11), i3.h(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), i3.h(cursor, cursor.getColumnIndex("suggest_intent_query")));
            } catch (RuntimeException e) {
                try {
                    i10 = cursor.getPosition();
                } catch (RuntimeException unused) {
                    i10 = -1;
                }
                Log.w("SearchView", "Search suggestions cursor at row " + i10 + " returned exception.", e);
            }
            if (intent != null) {
                try {
                    getContext().startActivity(intent);
                } catch (RuntimeException e10) {
                    Log.e("SearchView", "Failed launch activity: " + intent, e10);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.f798p;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public final void q(int i3) {
        Editable text = this.f798p.getText();
        Cursor cursor = this.O.f16684c;
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(i3)) {
            setQuery(text);
            return;
        }
        String c9 = this.O.c(cursor);
        if (c9 != null) {
            setQuery(c9);
        } else {
            setQuery(text);
        }
    }

    public final void r(CharSequence charSequence) {
        setQuery(charSequence);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i3, Rect rect) {
        if (this.S || !isFocusable()) {
            return false;
        }
        if (this.N) {
            return super.requestFocus(i3, rect);
        }
        boolean requestFocus = this.f798p.requestFocus(i3, rect);
        if (requestFocus) {
            y(false);
        }
        return requestFocus;
    }

    public final void s() {
        SearchAutoComplete searchAutoComplete = this.f798p;
        Editable text = searchAutoComplete.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f793b0 != null) {
            getContext().startActivity(l("android.intent.action.SEARCH", null, null, text.toString()));
        }
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public void setAppSearchData(Bundle bundle) {
        this.f794c0 = bundle;
    }

    public void setIconified(boolean z5) {
        if (z5) {
            o();
            return;
        }
        y(false);
        SearchAutoComplete searchAutoComplete = this.f798p;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.L;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z5) {
        if (this.M == z5) {
            return;
        }
        this.M = z5;
        y(z5);
        v();
    }

    public void setImeOptions(int i3) {
        this.f798p.setImeOptions(i3);
    }

    public void setInputType(int i3) {
        this.f798p.setInputType(i3);
    }

    public void setMaxWidth(int i3) {
        this.T = i3;
        requestLayout();
    }

    public void setOnCloseListener(a3 a3Var) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.K = onFocusChangeListener;
    }

    public void setOnQueryTextListener(b3 b3Var) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.L = onClickListener;
    }

    public void setOnSuggestionListener(c3 c3Var) {
    }

    public void setQueryHint(CharSequence charSequence) {
        this.Q = charSequence;
        v();
    }

    public void setQueryRefinementEnabled(boolean z5) {
        this.R = z5;
        o1.b bVar = this.O;
        if (bVar instanceof i3) {
            ((i3) bVar).f939p = z5 ? 2 : 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0095, code lost:
    
        if (getContext().getPackageManager().resolveActivity(r0, com.tencent.mm.opensdk.modelmsg.WXMediaMessage.THUMB_LENGTH_LIMIT) != null) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setSearchableInfo(android.app.SearchableInfo r7) {
        /*
            r6 = this;
            r6.f793b0 = r7
            r0 = 0
            r1 = 1
            androidx.appcompat.widget.SearchView$SearchAutoComplete r2 = r6.f798p
            if (r7 == 0) goto L65
            int r7 = r7.getSuggestThreshold()
            r2.setThreshold(r7)
            android.app.SearchableInfo r7 = r6.f793b0
            int r7 = r7.getImeOptions()
            r2.setImeOptions(r7)
            android.app.SearchableInfo r7 = r6.f793b0
            int r7 = r7.getInputType()
            r3 = r7 & 15
            if (r3 != r1) goto L31
            r3 = -65537(0xfffffffffffeffff, float:NaN)
            r7 = r7 & r3
            android.app.SearchableInfo r3 = r6.f793b0
            java.lang.String r3 = r3.getSuggestAuthority()
            if (r3 == 0) goto L31
            r3 = 589824(0x90000, float:8.2652E-40)
            r7 = r7 | r3
        L31:
            r2.setInputType(r7)
            o1.b r7 = r6.O
            if (r7 == 0) goto L3b
            r7.b(r0)
        L3b:
            android.app.SearchableInfo r7 = r6.f793b0
            java.lang.String r7 = r7.getSuggestAuthority()
            if (r7 == 0) goto L62
            androidx.appcompat.widget.i3 r7 = new androidx.appcompat.widget.i3
            android.content.Context r3 = r6.getContext()
            android.app.SearchableInfo r4 = r6.f793b0
            java.util.WeakHashMap r5 = r6.f797f0
            r7.<init>(r3, r6, r4, r5)
            r6.O = r7
            r2.setAdapter(r7)
            o1.b r7 = r6.O
            androidx.appcompat.widget.i3 r7 = (androidx.appcompat.widget.i3) r7
            boolean r3 = r6.R
            if (r3 == 0) goto L5f
            r3 = 2
            goto L60
        L5f:
            r3 = r1
        L60:
            r7.f939p = r3
        L62:
            r6.v()
        L65:
            android.app.SearchableInfo r7 = r6.f793b0
            r3 = 0
            if (r7 == 0) goto L98
            boolean r7 = r7.getVoiceSearchEnabled()
            if (r7 == 0) goto L98
            android.app.SearchableInfo r7 = r6.f793b0
            boolean r7 = r7.getVoiceSearchLaunchWebSearch()
            if (r7 == 0) goto L7b
            android.content.Intent r0 = r6.H
            goto L85
        L7b:
            android.app.SearchableInfo r7 = r6.f793b0
            boolean r7 = r7.getVoiceSearchLaunchRecognizer()
            if (r7 == 0) goto L85
            android.content.Intent r0 = r6.I
        L85:
            if (r0 == 0) goto L98
            android.content.Context r7 = r6.getContext()
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            r4 = 65536(0x10000, float:9.1835E-41)
            android.content.pm.ResolveInfo r7 = r7.resolveActivity(r0, r4)
            if (r7 == 0) goto L98
            goto L99
        L98:
            r1 = r3
        L99:
            r6.U = r1
            if (r1 == 0) goto La2
            java.lang.String r7 = "nm"
            r2.setPrivateImeOptions(r7)
        La2:
            boolean r7 = r6.N
            r6.y(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.setSearchableInfo(android.app.SearchableInfo):void");
    }

    public void setSubmitButtonEnabled(boolean z5) {
        this.P = z5;
        y(this.N);
    }

    public void setSuggestionsAdapter(o1.b bVar) {
        this.O = bVar;
        this.f798p.setAdapter(bVar);
    }

    public final void t() {
        boolean isEmpty = TextUtils.isEmpty(this.f798p.getText());
        int i3 = (!isEmpty || (this.M && !this.W)) ? 0 : 8;
        ImageView imageView = this.f803v;
        imageView.setVisibility(i3);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setState(!isEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public final void u() {
        int[] iArr = this.f798p.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.r.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f800s.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void v() {
        Drawable drawable;
        CharSequence queryHint = getQueryHint();
        if (queryHint == null) {
            queryHint = "";
        }
        boolean z5 = this.M;
        SearchAutoComplete searchAutoComplete = this.f798p;
        if (z5 && (drawable = this.E) != null) {
            int textSize = (int) (searchAutoComplete.getTextSize() * 1.25d);
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
            spannableStringBuilder.append(queryHint);
            queryHint = spannableStringBuilder;
        }
        searchAutoComplete.setHint(queryHint);
    }

    public final void w() {
        this.f800s.setVisibility(((this.P || this.U) && !this.N && (this.f802u.getVisibility() == 0 || this.f804w.getVisibility() == 0)) ? 0 : 8);
    }

    public final void x(boolean z5) {
        boolean z6 = this.P;
        this.f802u.setVisibility((!z6 || !(z6 || this.U) || this.N || !hasFocus() || (!z5 && this.U)) ? 8 : 0);
    }

    public final void y(boolean z5) {
        this.N = z5;
        int i3 = 8;
        int i10 = z5 ? 0 : 8;
        boolean isEmpty = TextUtils.isEmpty(this.f798p.getText());
        this.f801t.setVisibility(i10);
        x(!isEmpty);
        this.f799q.setVisibility(z5 ? 8 : 0);
        ImageView imageView = this.D;
        imageView.setVisibility((imageView.getDrawable() == null || this.M) ? 8 : 0);
        t();
        if (this.U && !this.N && isEmpty) {
            this.f802u.setVisibility(8);
            i3 = 0;
        }
        this.f804w.setVisibility(i3);
        w();
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f807z = new Rect();
        this.A = new Rect();
        this.B = new int[2];
        this.C = new int[2];
        this.f795d0 = new t2(this, 0);
        this.f796e0 = new t2(this, 1);
        this.f797f0 = new WeakHashMap();
        w2 w2Var = new w2(this);
        x2 x2Var = new x2(this);
        y2 y2Var = new y2(this);
        m0 m0Var = new m0(this, 1);
        z1 z1Var = new z1(this, 1);
        s2 s2Var = new s2(this, 0);
        de.o I = de.o.I(context, attributeSet, R$styleable.SearchView, i3);
        l1.z0.m(this, context, R$styleable.SearchView, attributeSet, (TypedArray) I.f12378c, i3);
        LayoutInflater from = LayoutInflater.from(context);
        int i10 = R$styleable.SearchView_layout;
        int i11 = R$layout.abc_search_view;
        TypedArray typedArray = (TypedArray) I.f12378c;
        from.inflate(typedArray.getResourceId(i10, i11), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R$id.search_src_text);
        this.f798p = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f799q = findViewById(R$id.search_edit_frame);
        View findViewById = findViewById(R$id.search_plate);
        this.r = findViewById;
        View findViewById2 = findViewById(R$id.submit_area);
        this.f800s = findViewById2;
        ImageView imageView = (ImageView) findViewById(R$id.search_button);
        this.f801t = imageView;
        ImageView imageView2 = (ImageView) findViewById(R$id.search_go_btn);
        this.f802u = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R$id.search_close_btn);
        this.f803v = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R$id.search_voice_btn);
        this.f804w = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R$id.search_mag_icon);
        this.D = imageView5;
        l1.h0.q(findViewById, I.w(R$styleable.SearchView_queryBackground));
        l1.h0.q(findViewById2, I.w(R$styleable.SearchView_submitBackground));
        imageView.setImageDrawable(I.w(R$styleable.SearchView_searchIcon));
        imageView2.setImageDrawable(I.w(R$styleable.SearchView_goIcon));
        imageView3.setImageDrawable(I.w(R$styleable.SearchView_closeIcon));
        imageView4.setImageDrawable(I.w(R$styleable.SearchView_voiceIcon));
        imageView5.setImageDrawable(I.w(R$styleable.SearchView_searchIcon));
        this.E = I.w(R$styleable.SearchView_searchHintIcon);
        y3.a(imageView, getResources().getString(R$string.abc_searchview_description_search));
        this.F = typedArray.getResourceId(R$styleable.SearchView_suggestionRowLayout, R$layout.abc_search_dropdown_item_icons_2line);
        this.G = typedArray.getResourceId(R$styleable.SearchView_commitIcon, 0);
        imageView.setOnClickListener(w2Var);
        imageView3.setOnClickListener(w2Var);
        imageView2.setOnClickListener(w2Var);
        imageView4.setOnClickListener(w2Var);
        searchAutoComplete.setOnClickListener(w2Var);
        searchAutoComplete.addTextChangedListener(s2Var);
        searchAutoComplete.setOnEditorActionListener(y2Var);
        searchAutoComplete.setOnItemClickListener(m0Var);
        searchAutoComplete.setOnItemSelectedListener(z1Var);
        searchAutoComplete.setOnKeyListener(x2Var);
        searchAutoComplete.setOnFocusChangeListener(new u2(this, 0));
        setIconifiedByDefault(typedArray.getBoolean(R$styleable.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R$styleable.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.J = typedArray.getText(R$styleable.SearchView_defaultQueryHint);
        this.Q = typedArray.getText(R$styleable.SearchView_queryHint);
        int i12 = typedArray.getInt(R$styleable.SearchView_android_imeOptions, -1);
        if (i12 != -1) {
            setImeOptions(i12);
        }
        int i13 = typedArray.getInt(R$styleable.SearchView_android_inputType, -1);
        if (i13 != -1) {
            setInputType(i13);
        }
        setFocusable(typedArray.getBoolean(R$styleable.SearchView_android_focusable, true));
        I.K();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.H = intent;
        intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.I = intent2;
        intent2.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f805x = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new v2(this, 0));
        }
        y(this.M);
        v();
    }
}
