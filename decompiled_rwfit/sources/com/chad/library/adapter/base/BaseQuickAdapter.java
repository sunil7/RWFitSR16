package com.chad.library.adapter.base;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.c0;
import androidx.recyclerview.widget.e2;
import androidx.recyclerview.widget.i1;
import androidx.recyclerview.widget.j1;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.p;
import androidx.recyclerview.widget.z0;
import androidx.recyclerview.widget.z1;
import com.chad.library.adapter.base.BaseQuickAdapterModuleImp;
import com.chad.library.adapter.base.animation.AlphaInAnimation;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.chad.library.adapter.base.animation.ScaleInAnimation;
import com.chad.library.adapter.base.animation.SlideInBottomAnimation;
import com.chad.library.adapter.base.animation.SlideInLeftAnimation;
import com.chad.library.adapter.base.animation.SlideInRightAnimation;
import com.chad.library.adapter.base.diff.BrvahAsyncDiffer;
import com.chad.library.adapter.base.diff.BrvahAsyncDifferConfig;
import com.chad.library.adapter.base.diff.BrvahListUpdateCallback;
import com.chad.library.adapter.base.listener.BaseListenerImp;
import com.chad.library.adapter.base.listener.GridSpanSizeLookup;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemChildLongClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.chad.library.adapter.base.module.BaseDraggableModule;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.chad.library.adapter.base.module.BaseUpFetchModule;
import com.chad.library.adapter.base.module.DraggableModule;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.module.UpFetchModule;
import com.chad.library.adapter.base.util.AdapterUtilsKt;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.i;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public abstract class BaseQuickAdapter<T, VH extends BaseViewHolder> extends z0 implements BaseQuickAdapterModuleImp, BaseListenerImp {
    public static final Companion Companion = new Companion(null);
    public static final int EMPTY_VIEW = 268436821;
    public static final int FOOTER_VIEW = 268436275;
    public static final int HEADER_VIEW = 268435729;
    public static final int LOAD_MORE_VIEW = 268436002;
    private BaseAnimation adapterAnimation;
    private boolean animationEnable;
    private final LinkedHashSet<Integer> childClickViewIds;
    private final LinkedHashSet<Integer> childLongClickViewIds;
    private Context context;
    private List<T> data;
    private boolean footerViewAsFlow;
    private boolean footerWithEmptyEnable;
    private boolean headerViewAsFlow;
    private boolean headerWithEmptyEnable;
    private boolean isAnimationFirstOnly;
    private boolean isUseEmpty;
    private final int layoutResId;
    private BrvahAsyncDiffer<T> mDiffHelper;
    private BaseDraggableModule mDraggableModule;
    private FrameLayout mEmptyLayout;
    private LinearLayout mFooterLayout;
    private LinearLayout mHeaderLayout;
    private int mLastPosition;
    private BaseLoadMoreModule mLoadMoreModule;
    private OnItemChildClickListener mOnItemChildClickListener;
    private OnItemChildLongClickListener mOnItemChildLongClickListener;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;
    private RecyclerView mRecyclerView;
    private GridSpanSizeLookup mSpanSizeLookup;
    private BaseUpFetchModule mUpFetchModule;
    public WeakReference<RecyclerView> weakRecyclerView;

    public enum AnimationType {
        AlphaIn,
        ScaleIn,
        SlideInBottom,
        SlideInLeft,
        SlideInRight
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(c cVar) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnimationType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[AnimationType.AlphaIn.ordinal()] = 1;
            iArr[AnimationType.ScaleIn.ordinal()] = 2;
            iArr[AnimationType.SlideInBottom.ordinal()] = 3;
            iArr[AnimationType.SlideInLeft.ordinal()] = 4;
            iArr[AnimationType.SlideInRight.ordinal()] = 5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseQuickAdapter(int i3) {
        this(i3, null, 2, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ FrameLayout access$getMEmptyLayout$p(BaseQuickAdapter baseQuickAdapter) {
        FrameLayout frameLayout = baseQuickAdapter.mEmptyLayout;
        if (frameLayout != null) {
            return frameLayout;
        }
        e.m("mEmptyLayout");
        throw null;
    }

    public static final /* synthetic */ LinearLayout access$getMFooterLayout$p(BaseQuickAdapter baseQuickAdapter) {
        LinearLayout linearLayout = baseQuickAdapter.mFooterLayout;
        if (linearLayout != null) {
            return linearLayout;
        }
        e.m("mFooterLayout");
        throw null;
    }

    public static final /* synthetic */ LinearLayout access$getMHeaderLayout$p(BaseQuickAdapter baseQuickAdapter) {
        LinearLayout linearLayout = baseQuickAdapter.mHeaderLayout;
        if (linearLayout != null) {
            return linearLayout;
        }
        e.m("mHeaderLayout");
        throw null;
    }

    private final void addAnimation(z1 z1Var) {
        if (this.animationEnable) {
            if (!this.isAnimationFirstOnly || z1Var.getLayoutPosition() > this.mLastPosition) {
                BaseAnimation baseAnimation = this.adapterAnimation;
                if (baseAnimation == null) {
                    baseAnimation = new AlphaInAnimation(0.0f, 1, null);
                }
                View view = z1Var.itemView;
                e.b(view, "holder.itemView");
                for (Animator animator : baseAnimation.animators(view)) {
                    startAnim(animator, z1Var.getLayoutPosition());
                }
                this.mLastPosition = z1Var.getLayoutPosition();
            }
        }
    }

    public static /* synthetic */ int addFooterView$default(BaseQuickAdapter baseQuickAdapter, View view, int i3, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addFooterView");
        }
        if ((i11 & 2) != 0) {
            i3 = -1;
        }
        if ((i11 & 4) != 0) {
            i10 = 1;
        }
        return baseQuickAdapter.addFooterView(view, i3, i10);
    }

    public static /* synthetic */ int addHeaderView$default(BaseQuickAdapter baseQuickAdapter, View view, int i3, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addHeaderView");
        }
        if ((i11 & 2) != 0) {
            i3 = -1;
        }
        if ((i11 & 4) != 0) {
            i10 = 1;
        }
        return baseQuickAdapter.addHeaderView(view, i3, i10);
    }

    private final void checkModule() {
        if (this instanceof LoadMoreModule) {
            this.mLoadMoreModule = addLoadMoreModule(this);
        }
        if (this instanceof UpFetchModule) {
            this.mUpFetchModule = addUpFetchModule(this);
        }
        if (this instanceof DraggableModule) {
            this.mDraggableModule = addDraggableModule(this);
        }
    }

    private final VH createBaseGenericKInstance(Class<?> cls, View view) {
        try {
            if (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(View.class);
                e.b(declaredConstructor, "z.getDeclaredConstructor(View::class.java)");
                declaredConstructor.setAccessible(true);
                Object newInstance = declaredConstructor.newInstance(view);
                if (newInstance != null) {
                    return (VH) newInstance;
                }
                throw new TypeCastException("null cannot be cast to non-null type VH");
            }
            Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(getClass(), View.class);
            e.b(declaredConstructor2, "z.getDeclaredConstructor…aClass, View::class.java)");
            declaredConstructor2.setAccessible(true);
            Object newInstance2 = declaredConstructor2.newInstance(this, view);
            if (newInstance2 != null) {
                return (VH) newInstance2;
            }
            throw new TypeCastException("null cannot be cast to non-null type VH");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e10) {
            e10.printStackTrace();
            return null;
        } catch (NoSuchMethodException e11) {
            e11.printStackTrace();
            return null;
        } catch (InvocationTargetException e12) {
            e12.printStackTrace();
            return null;
        }
    }

    private final Class<?> getInstancedGenericKClass(Class<?> cls) {
        try {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                return null;
            }
            for (Type type : ((ParameterizedType) genericSuperclass).getActualTypeArguments()) {
                if (type instanceof Class) {
                    if (BaseViewHolder.class.isAssignableFrom((Class) type)) {
                        return (Class) type;
                    }
                } else if (type instanceof ParameterizedType) {
                    Type rawType = ((ParameterizedType) type).getRawType();
                    if ((rawType instanceof Class) && BaseViewHolder.class.isAssignableFrom((Class) rawType)) {
                        return (Class) rawType;
                    }
                } else {
                    continue;
                }
            }
            return null;
        } catch (TypeNotPresentException e) {
            e.printStackTrace();
            return null;
        } catch (GenericSignatureFormatError e10) {
            e10.printStackTrace();
            return null;
        } catch (MalformedParameterizedTypeException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ int setFooterView$default(BaseQuickAdapter baseQuickAdapter, View view, int i3, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFooterView");
        }
        if ((i11 & 2) != 0) {
            i3 = 0;
        }
        if ((i11 & 4) != 0) {
            i10 = 1;
        }
        return baseQuickAdapter.setFooterView(view, i3, i10);
    }

    public static /* synthetic */ int setHeaderView$default(BaseQuickAdapter baseQuickAdapter, View view, int i3, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHeaderView");
        }
        if ((i11 & 2) != 0) {
            i3 = 0;
        }
        if ((i11 & 4) != 0) {
            i10 = 1;
        }
        return baseQuickAdapter.setHeaderView(view, i3, i10);
    }

    public static /* synthetic */ void weakRecyclerView$annotations() {
    }

    public final void addChildClickViewIds(int... viewIds) {
        e.g(viewIds, "viewIds");
        for (int i3 : viewIds) {
            this.childClickViewIds.add(Integer.valueOf(i3));
        }
    }

    public final void addChildLongClickViewIds(int... viewIds) {
        e.g(viewIds, "viewIds");
        for (int i3 : viewIds) {
            this.childLongClickViewIds.add(Integer.valueOf(i3));
        }
    }

    public void addData(int i3, T t8) {
        this.data.add(i3, t8);
        notifyItemInserted(getHeaderLayoutCount() + i3);
        compatibilityDataSizeChanged(1);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapterModuleImp
    public BaseDraggableModule addDraggableModule(BaseQuickAdapter<?, ?> baseQuickAdapter) {
        e.g(baseQuickAdapter, "baseQuickAdapter");
        return BaseQuickAdapterModuleImp.DefaultImpls.addDraggableModule(this, baseQuickAdapter);
    }

    public final int addFooterView(View view) {
        return addFooterView$default(this, view, 0, 0, 6, null);
    }

    public final int addHeaderView(View view) {
        return addHeaderView$default(this, view, 0, 0, 6, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapterModuleImp
    public BaseLoadMoreModule addLoadMoreModule(BaseQuickAdapter<?, ?> baseQuickAdapter) {
        e.g(baseQuickAdapter, "baseQuickAdapter");
        return BaseQuickAdapterModuleImp.DefaultImpls.addLoadMoreModule(this, baseQuickAdapter);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapterModuleImp
    public BaseUpFetchModule addUpFetchModule(BaseQuickAdapter<?, ?> baseQuickAdapter) {
        e.g(baseQuickAdapter, "baseQuickAdapter");
        return BaseQuickAdapterModuleImp.DefaultImpls.addUpFetchModule(this, baseQuickAdapter);
    }

    public void bindViewClickListener(final VH viewHolder, int i3) {
        e.g(viewHolder, "viewHolder");
        if (this.mOnItemClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View v6) {
                    int adapterPosition = viewHolder.getAdapterPosition();
                    if (adapterPosition == -1) {
                        return;
                    }
                    int headerLayoutCount = adapterPosition - BaseQuickAdapter.this.getHeaderLayoutCount();
                    BaseQuickAdapter baseQuickAdapter = BaseQuickAdapter.this;
                    e.b(v6, "v");
                    baseQuickAdapter.setOnItemClick(v6, headerLayoutCount);
                }
            });
        }
        if (this.mOnItemLongClickListener != null) {
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$2
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View v6) {
                    int adapterPosition = viewHolder.getAdapterPosition();
                    if (adapterPosition == -1) {
                        return false;
                    }
                    int headerLayoutCount = adapterPosition - BaseQuickAdapter.this.getHeaderLayoutCount();
                    BaseQuickAdapter baseQuickAdapter = BaseQuickAdapter.this;
                    e.b(v6, "v");
                    return baseQuickAdapter.setOnItemLongClick(v6, headerLayoutCount);
                }
            });
        }
        if (this.mOnItemChildClickListener != null) {
            Iterator<Integer> it = getChildClickViewIds().iterator();
            while (it.hasNext()) {
                Integer id2 = it.next();
                View view = viewHolder.itemView;
                e.b(id2, "id");
                View findViewById = view.findViewById(id2.intValue());
                if (findViewById != null) {
                    if (!findViewById.isClickable()) {
                        findViewById.setClickable(true);
                    }
                    findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View v6) {
                            int adapterPosition = viewHolder.getAdapterPosition();
                            if (adapterPosition == -1) {
                                return;
                            }
                            int headerLayoutCount = adapterPosition - BaseQuickAdapter.this.getHeaderLayoutCount();
                            BaseQuickAdapter baseQuickAdapter = BaseQuickAdapter.this;
                            e.b(v6, "v");
                            baseQuickAdapter.setOnItemChildClick(v6, headerLayoutCount);
                        }
                    });
                }
            }
        }
        if (this.mOnItemChildLongClickListener != null) {
            Iterator<Integer> it2 = getChildLongClickViewIds().iterator();
            while (it2.hasNext()) {
                Integer id3 = it2.next();
                View view2 = viewHolder.itemView;
                e.b(id3, "id");
                View findViewById2 = view2.findViewById(id3.intValue());
                if (findViewById2 != null) {
                    if (!findViewById2.isLongClickable()) {
                        findViewById2.setLongClickable(true);
                    }
                    findViewById2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$4
                        @Override // android.view.View.OnLongClickListener
                        public final boolean onLongClick(View v6) {
                            int adapterPosition = viewHolder.getAdapterPosition();
                            if (adapterPosition == -1) {
                                return false;
                            }
                            int headerLayoutCount = adapterPosition - BaseQuickAdapter.this.getHeaderLayoutCount();
                            BaseQuickAdapter baseQuickAdapter = BaseQuickAdapter.this;
                            e.b(v6, "v");
                            return baseQuickAdapter.setOnItemChildLongClick(v6, headerLayoutCount);
                        }
                    });
                }
            }
        }
    }

    public final void compatibilityDataSizeChanged(int i3) {
        if (this.data.size() == i3) {
            notifyDataSetChanged();
        }
    }

    public abstract void convert(VH vh2, T t8);

    public void convert(VH holder, T t8, List<? extends Object> payloads) {
        e.g(holder, "holder");
        e.g(payloads, "payloads");
    }

    public VH createBaseViewHolder(ViewGroup parent, int i3) {
        e.g(parent, "parent");
        return createBaseViewHolder(AdapterUtilsKt.getItemView(parent, i3));
    }

    public final BaseAnimation getAdapterAnimation() {
        return this.adapterAnimation;
    }

    public final boolean getAnimationEnable() {
        return this.animationEnable;
    }

    public final LinkedHashSet<Integer> getChildClickViewIds() {
        return this.childClickViewIds;
    }

    public final LinkedHashSet<Integer> getChildLongClickViewIds() {
        return this.childLongClickViewIds;
    }

    public final Context getContext() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        e.m("context");
        throw null;
    }

    public final List<T> getData() {
        return this.data;
    }

    public int getDefItemCount() {
        return this.data.size();
    }

    public int getDefItemViewType(int i3) {
        return 0;
    }

    public final BrvahAsyncDiffer<T> getDiffHelper() {
        return getDiffer();
    }

    public final BrvahAsyncDiffer<T> getDiffer() {
        BrvahAsyncDiffer<T> brvahAsyncDiffer = this.mDiffHelper;
        if (brvahAsyncDiffer == null) {
            throw new IllegalStateException("Please use setDiffCallback() or setDiffConfig() first!");
        }
        if (brvahAsyncDiffer != null) {
            return brvahAsyncDiffer;
        }
        e.l();
        throw null;
    }

    public final BaseDraggableModule getDraggableModule() {
        BaseDraggableModule baseDraggableModule = this.mDraggableModule;
        if (baseDraggableModule == null) {
            throw new IllegalStateException("Please first implements DraggableModule");
        }
        if (baseDraggableModule != null) {
            return baseDraggableModule;
        }
        e.l();
        throw null;
    }

    public final FrameLayout getEmptyLayout() {
        FrameLayout frameLayout = this.mEmptyLayout;
        if (frameLayout == null) {
            return null;
        }
        if (frameLayout != null) {
            return frameLayout;
        }
        e.m("mEmptyLayout");
        throw null;
    }

    public final LinearLayout getFooterLayout() {
        LinearLayout linearLayout = this.mFooterLayout;
        if (linearLayout == null) {
            return null;
        }
        if (linearLayout != null) {
            return linearLayout;
        }
        e.m("mFooterLayout");
        throw null;
    }

    public final int getFooterLayoutCount() {
        return hasFooterLayout() ? 1 : 0;
    }

    public final boolean getFooterViewAsFlow() {
        return this.footerViewAsFlow;
    }

    public final int getFooterViewPosition() {
        if (!hasEmptyView()) {
            return this.data.size() + getHeaderLayoutCount();
        }
        int i3 = (this.headerWithEmptyEnable && hasHeaderLayout()) ? 2 : 1;
        if (this.footerWithEmptyEnable) {
            return i3;
        }
        return -1;
    }

    public final boolean getFooterWithEmptyEnable() {
        return this.footerWithEmptyEnable;
    }

    public final LinearLayout getHeaderLayout() {
        LinearLayout linearLayout = this.mHeaderLayout;
        if (linearLayout == null) {
            return null;
        }
        if (linearLayout != null) {
            return linearLayout;
        }
        e.m("mHeaderLayout");
        throw null;
    }

    public final int getHeaderLayoutCount() {
        return hasHeaderLayout() ? 1 : 0;
    }

    public final boolean getHeaderViewAsFlow() {
        return this.headerViewAsFlow;
    }

    public final int getHeaderViewPosition() {
        return (!hasEmptyView() || this.headerWithEmptyEnable) ? 0 : -1;
    }

    public final boolean getHeaderWithEmptyEnable() {
        return this.headerWithEmptyEnable;
    }

    public T getItem(int i3) {
        return this.data.get(i3);
    }

    @Override // androidx.recyclerview.widget.z0
    public int getItemCount() {
        if (hasEmptyView()) {
            int i3 = (this.headerWithEmptyEnable && hasHeaderLayout()) ? 2 : 1;
            return (this.footerWithEmptyEnable && hasFooterLayout()) ? i3 + 1 : i3;
        }
        BaseLoadMoreModule baseLoadMoreModule = this.mLoadMoreModule;
        return getFooterLayoutCount() + getDefItemCount() + getHeaderLayoutCount() + ((baseLoadMoreModule == null || !baseLoadMoreModule.hasLoadMoreView()) ? 0 : 1);
    }

    @Override // androidx.recyclerview.widget.z0
    public long getItemId(int i3) {
        return i3;
    }

    public T getItemOrNull(int i3) {
        List<T> list = this.data;
        e.f(list, "<this>");
        if (i3 < 0 || i3 > i.c(list)) {
            return null;
        }
        return list.get(i3);
    }

    public int getItemPosition(T t8) {
        if (t8 == null || this.data.isEmpty()) {
            return -1;
        }
        return this.data.indexOf(t8);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    @Override // androidx.recyclerview.widget.z0
    public int getItemViewType(int i3) {
        if (hasEmptyView()) {
            boolean z5 = this.headerWithEmptyEnable && hasHeaderLayout();
            return i3 != 0 ? i3 != 1 ? i3 != 2 ? EMPTY_VIEW : FOOTER_VIEW : z5 ? EMPTY_VIEW : FOOTER_VIEW : z5 ? HEADER_VIEW : EMPTY_VIEW;
        }
        boolean hasHeaderLayout = hasHeaderLayout();
        if (hasHeaderLayout && i3 == 0) {
            return HEADER_VIEW;
        }
        if (hasHeaderLayout) {
            i3--;
        }
        int size = this.data.size();
        return i3 < size ? getDefItemViewType(i3) : i3 - size < hasFooterLayout() ? FOOTER_VIEW : LOAD_MORE_VIEW;
    }

    public final BaseLoadMoreModule getLoadMoreModule() {
        BaseLoadMoreModule baseLoadMoreModule = this.mLoadMoreModule;
        if (baseLoadMoreModule == null) {
            throw new IllegalStateException("Please first implements LoadMoreModule");
        }
        if (baseLoadMoreModule != null) {
            return baseLoadMoreModule;
        }
        e.l();
        throw null;
    }

    public final BaseLoadMoreModule getMLoadMoreModule$com_github_CymChad_brvah() {
        return this.mLoadMoreModule;
    }

    public final RecyclerView getMRecyclerView$com_github_CymChad_brvah() {
        return this.mRecyclerView;
    }

    public final OnItemChildClickListener getOnItemChildClickListener() {
        return this.mOnItemChildClickListener;
    }

    public final OnItemChildLongClickListener getOnItemChildLongClickListener() {
        return this.mOnItemChildLongClickListener;
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public final OnItemLongClickListener getOnItemLongClickListener() {
        return this.mOnItemLongClickListener;
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            throw new IllegalStateException("Please get it after onAttachedToRecyclerView()");
        }
        if (recyclerView != null) {
            return recyclerView;
        }
        e.l();
        throw null;
    }

    public final BaseUpFetchModule getUpFetchModule() {
        BaseUpFetchModule baseUpFetchModule = this.mUpFetchModule;
        if (baseUpFetchModule == null) {
            throw new IllegalStateException("Please first implements UpFetchModule");
        }
        if (baseUpFetchModule != null) {
            return baseUpFetchModule;
        }
        e.l();
        throw null;
    }

    public final View getViewByPosition(int i3, int i10) {
        BaseViewHolder baseViewHolder;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (baseViewHolder = (BaseViewHolder) recyclerView.G(i3, false)) == null) {
            return null;
        }
        return baseViewHolder.getViewOrNull(i10);
    }

    public final WeakReference<RecyclerView> getWeakRecyclerView() {
        WeakReference<RecyclerView> weakReference = this.weakRecyclerView;
        if (weakReference != null) {
            return weakReference;
        }
        e.m("weakRecyclerView");
        throw null;
    }

    public final boolean hasEmptyView() {
        FrameLayout frameLayout = this.mEmptyLayout;
        if (frameLayout != null) {
            if (frameLayout == null) {
                e.m("mEmptyLayout");
                throw null;
            }
            if (frameLayout.getChildCount() != 0 && this.isUseEmpty) {
                return this.data.isEmpty();
            }
            return false;
        }
        return false;
    }

    public final boolean hasFooterLayout() {
        LinearLayout linearLayout = this.mFooterLayout;
        if (linearLayout == null) {
            return false;
        }
        if (linearLayout != null) {
            return linearLayout.getChildCount() > 0;
        }
        e.m("mFooterLayout");
        throw null;
    }

    public final boolean hasHeaderLayout() {
        LinearLayout linearLayout = this.mHeaderLayout;
        if (linearLayout == null) {
            return false;
        }
        if (linearLayout != null) {
            return linearLayout.getChildCount() > 0;
        }
        e.m("mHeaderLayout");
        throw null;
    }

    public final boolean isAnimationFirstOnly() {
        return this.isAnimationFirstOnly;
    }

    public boolean isFixedViewType(int i3) {
        return i3 == 268436821 || i3 == 268435729 || i3 == 268436275 || i3 == 268436002;
    }

    public final boolean isUseEmpty() {
        return this.isUseEmpty;
    }

    @Override // androidx.recyclerview.widget.z0
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        e.g(recyclerView, "recyclerView");
        this.weakRecyclerView = new WeakReference<>(recyclerView);
        this.mRecyclerView = recyclerView;
        Context context = recyclerView.getContext();
        e.b(context, "recyclerView.context");
        this.context = context;
        BaseDraggableModule baseDraggableModule = this.mDraggableModule;
        if (baseDraggableModule != null) {
            baseDraggableModule.attachToRecyclerView(recyclerView);
        }
        final i1 layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            final c0 c0Var = gridLayoutManager.K;
            gridLayoutManager.K = new c0() { // from class: com.chad.library.adapter.base.BaseQuickAdapter$onAttachedToRecyclerView$1
                @Override // androidx.recyclerview.widget.c0
                public int getSpanSize(int i3) {
                    GridSpanSizeLookup gridSpanSizeLookup;
                    GridSpanSizeLookup gridSpanSizeLookup2;
                    int itemViewType = BaseQuickAdapter.this.getItemViewType(i3);
                    if (itemViewType == 268435729 && BaseQuickAdapter.this.getHeaderViewAsFlow()) {
                        return 1;
                    }
                    if (itemViewType == 268436275 && BaseQuickAdapter.this.getFooterViewAsFlow()) {
                        return 1;
                    }
                    gridSpanSizeLookup = BaseQuickAdapter.this.mSpanSizeLookup;
                    if (gridSpanSizeLookup == null) {
                        return BaseQuickAdapter.this.isFixedViewType(itemViewType) ? ((GridLayoutManager) layoutManager).F : c0Var.getSpanSize(i3);
                    }
                    if (BaseQuickAdapter.this.isFixedViewType(itemViewType)) {
                        return ((GridLayoutManager) layoutManager).F;
                    }
                    gridSpanSizeLookup2 = BaseQuickAdapter.this.mSpanSizeLookup;
                    if (gridSpanSizeLookup2 != null) {
                        return gridSpanSizeLookup2.getSpanSize((GridLayoutManager) layoutManager, itemViewType, i3 - BaseQuickAdapter.this.getHeaderLayoutCount());
                    }
                    e.l();
                    throw null;
                }
            };
        }
    }

    public VH onCreateDefViewHolder(ViewGroup parent, int i3) {
        e.g(parent, "parent");
        return createBaseViewHolder(parent, this.layoutResId);
    }

    @Override // androidx.recyclerview.widget.z0
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        e.g(recyclerView, "recyclerView");
        this.mRecyclerView = null;
    }

    public void onItemViewHolderCreated(VH viewHolder, int i3) {
        e.g(viewHolder, "viewHolder");
    }

    public void remove(int i3) {
        removeAt(i3);
    }

    public final void removeAllFooterView() {
        if (hasFooterLayout()) {
            LinearLayout linearLayout = this.mFooterLayout;
            if (linearLayout == null) {
                e.m("mFooterLayout");
                throw null;
            }
            linearLayout.removeAllViews();
            int footerViewPosition = getFooterViewPosition();
            if (footerViewPosition != -1) {
                notifyItemRemoved(footerViewPosition);
            }
        }
    }

    public final void removeAllHeaderView() {
        if (hasHeaderLayout()) {
            LinearLayout linearLayout = this.mHeaderLayout;
            if (linearLayout == null) {
                e.m("mHeaderLayout");
                throw null;
            }
            linearLayout.removeAllViews();
            int headerViewPosition = getHeaderViewPosition();
            if (headerViewPosition != -1) {
                notifyItemRemoved(headerViewPosition);
            }
        }
    }

    public void removeAt(int i3) {
        if (i3 >= this.data.size()) {
            return;
        }
        this.data.remove(i3);
        int headerLayoutCount = getHeaderLayoutCount() + i3;
        notifyItemRemoved(headerLayoutCount);
        compatibilityDataSizeChanged(0);
        notifyItemRangeChanged(headerLayoutCount, this.data.size() - headerLayoutCount);
    }

    public final void removeEmptyView() {
        FrameLayout frameLayout = this.mEmptyLayout;
        if (frameLayout != null) {
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            } else {
                e.m("mEmptyLayout");
                throw null;
            }
        }
    }

    public final void removeFooterView(View footer) {
        int footerViewPosition;
        e.g(footer, "footer");
        if (hasFooterLayout()) {
            LinearLayout linearLayout = this.mFooterLayout;
            if (linearLayout == null) {
                e.m("mFooterLayout");
                throw null;
            }
            linearLayout.removeView(footer);
            LinearLayout linearLayout2 = this.mFooterLayout;
            if (linearLayout2 == null) {
                e.m("mFooterLayout");
                throw null;
            }
            if (linearLayout2.getChildCount() != 0 || (footerViewPosition = getFooterViewPosition()) == -1) {
                return;
            }
            notifyItemRemoved(footerViewPosition);
        }
    }

    public final void removeHeaderView(View header) {
        int headerViewPosition;
        e.g(header, "header");
        if (hasHeaderLayout()) {
            LinearLayout linearLayout = this.mHeaderLayout;
            if (linearLayout == null) {
                e.m("mHeaderLayout");
                throw null;
            }
            linearLayout.removeView(header);
            LinearLayout linearLayout2 = this.mHeaderLayout;
            if (linearLayout2 == null) {
                e.m("mHeaderLayout");
                throw null;
            }
            if (linearLayout2.getChildCount() != 0 || (headerViewPosition = getHeaderViewPosition()) == -1) {
                return;
            }
            notifyItemRemoved(headerViewPosition);
        }
    }

    public void replaceData(Collection<? extends T> newData) {
        e.g(newData, "newData");
        setList(newData);
    }

    public final void setAdapterAnimation(BaseAnimation baseAnimation) {
        this.animationEnable = true;
        this.adapterAnimation = baseAnimation;
    }

    public final void setAnimationEnable(boolean z5) {
        this.animationEnable = z5;
    }

    public final void setAnimationFirstOnly(boolean z5) {
        this.isAnimationFirstOnly = z5;
    }

    public final void setAnimationWithDefault(AnimationType animationType) {
        BaseAnimation alphaInAnimation;
        e.g(animationType, "animationType");
        int i3 = WhenMappings.$EnumSwitchMapping$0[animationType.ordinal()];
        if (i3 == 1) {
            alphaInAnimation = new AlphaInAnimation(0.0f, 1, null);
        } else if (i3 == 2) {
            alphaInAnimation = new ScaleInAnimation(0.0f, 1, null);
        } else if (i3 == 3) {
            alphaInAnimation = new SlideInBottomAnimation();
        } else if (i3 == 4) {
            alphaInAnimation = new SlideInLeftAnimation();
        } else {
            if (i3 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            alphaInAnimation = new SlideInRightAnimation();
        }
        setAdapterAnimation(alphaInAnimation);
    }

    public void setData(int i3, T t8) {
        if (i3 >= this.data.size()) {
            return;
        }
        this.data.set(i3, t8);
        notifyItemChanged(getHeaderLayoutCount() + i3);
    }

    public final void setData$com_github_CymChad_brvah(List<T> list) {
        e.g(list, "<set-?>");
        this.data = list;
    }

    public final void setDiffCallback(p diffCallback) {
        e.g(diffCallback, "diffCallback");
        setDiffConfig(new BrvahAsyncDifferConfig.Builder(diffCallback).build());
    }

    public final void setDiffConfig(BrvahAsyncDifferConfig<T> config) {
        e.g(config, "config");
        this.mDiffHelper = new BrvahAsyncDiffer<>(this, config);
    }

    public void setDiffNewData(List<T> list) {
        if (hasEmptyView()) {
            setNewInstance(list);
            return;
        }
        BrvahAsyncDiffer<T> brvahAsyncDiffer = this.mDiffHelper;
        if (brvahAsyncDiffer != null) {
            BrvahAsyncDiffer.submitList$default(brvahAsyncDiffer, list, null, 2, null);
        }
    }

    public final void setEmptyView(View emptyView) {
        boolean z5;
        e.g(emptyView, "emptyView");
        int itemCount = getItemCount();
        if (this.mEmptyLayout == null) {
            FrameLayout frameLayout = new FrameLayout(emptyView.getContext());
            this.mEmptyLayout = frameLayout;
            ViewGroup.LayoutParams layoutParams = emptyView.getLayoutParams();
            frameLayout.setLayoutParams(layoutParams != null ? new ViewGroup.LayoutParams(layoutParams.width, layoutParams.height) : new ViewGroup.LayoutParams(-1, -1));
            z5 = true;
        } else {
            ViewGroup.LayoutParams layoutParams2 = emptyView.getLayoutParams();
            if (layoutParams2 != null) {
                FrameLayout frameLayout2 = this.mEmptyLayout;
                if (frameLayout2 == null) {
                    e.m("mEmptyLayout");
                    throw null;
                }
                ViewGroup.LayoutParams layoutParams3 = frameLayout2.getLayoutParams();
                layoutParams3.width = layoutParams2.width;
                layoutParams3.height = layoutParams2.height;
                FrameLayout frameLayout3 = this.mEmptyLayout;
                if (frameLayout3 == null) {
                    e.m("mEmptyLayout");
                    throw null;
                }
                frameLayout3.setLayoutParams(layoutParams3);
            }
            z5 = false;
        }
        FrameLayout frameLayout4 = this.mEmptyLayout;
        if (frameLayout4 == null) {
            e.m("mEmptyLayout");
            throw null;
        }
        frameLayout4.removeAllViews();
        FrameLayout frameLayout5 = this.mEmptyLayout;
        if (frameLayout5 == null) {
            e.m("mEmptyLayout");
            throw null;
        }
        frameLayout5.addView(emptyView);
        this.isUseEmpty = true;
        if (z5 && hasEmptyView()) {
            int i3 = (this.headerWithEmptyEnable && hasHeaderLayout()) ? 1 : 0;
            if (getItemCount() > itemCount) {
                notifyItemInserted(i3);
            } else {
                notifyDataSetChanged();
            }
        }
    }

    public final int setFooterView(View view) {
        return setFooterView$default(this, view, 0, 0, 6, null);
    }

    public final void setFooterViewAsFlow(boolean z5) {
        this.footerViewAsFlow = z5;
    }

    public final void setFooterWithEmptyEnable(boolean z5) {
        this.footerWithEmptyEnable = z5;
    }

    public void setFullSpan(z1 holder) {
        e.g(holder, "holder");
        View view = holder.itemView;
        e.b(view, "holder.itemView");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof e2) {
            ((e2) layoutParams).f2556f = true;
        }
    }

    @Override // com.chad.library.adapter.base.listener.BaseListenerImp
    public void setGridSpanSizeLookup(GridSpanSizeLookup gridSpanSizeLookup) {
        this.mSpanSizeLookup = gridSpanSizeLookup;
    }

    public final int setHeaderView(View view) {
        return setHeaderView$default(this, view, 0, 0, 6, null);
    }

    public final void setHeaderViewAsFlow(boolean z5) {
        this.headerViewAsFlow = z5;
    }

    public final void setHeaderWithEmptyEnable(boolean z5) {
        this.headerWithEmptyEnable = z5;
    }

    public void setList(Collection<? extends T> collection) {
        List<T> list = this.data;
        if (collection != list) {
            list.clear();
            if (collection != null && !collection.isEmpty()) {
                this.data.addAll(collection);
            }
        } else if (collection == null || collection.isEmpty()) {
            this.data.clear();
        } else {
            ArrayList arrayList = new ArrayList(collection);
            this.data.clear();
            this.data.addAll(arrayList);
        }
        BaseLoadMoreModule baseLoadMoreModule = this.mLoadMoreModule;
        if (baseLoadMoreModule != null) {
            baseLoadMoreModule.reset$com_github_CymChad_brvah();
        }
        this.mLastPosition = -1;
        notifyDataSetChanged();
        BaseLoadMoreModule baseLoadMoreModule2 = this.mLoadMoreModule;
        if (baseLoadMoreModule2 != null) {
            baseLoadMoreModule2.checkDisableLoadMoreIfNotFullPage();
        }
    }

    public final void setMLoadMoreModule$com_github_CymChad_brvah(BaseLoadMoreModule baseLoadMoreModule) {
        this.mLoadMoreModule = baseLoadMoreModule;
    }

    public final void setMRecyclerView$com_github_CymChad_brvah(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    public void setNewData(List<T> list) {
        setNewInstance(list);
    }

    public void setNewInstance(List<T> list) {
        if (list == this.data) {
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        this.data = list;
        BaseLoadMoreModule baseLoadMoreModule = this.mLoadMoreModule;
        if (baseLoadMoreModule != null) {
            baseLoadMoreModule.reset$com_github_CymChad_brvah();
        }
        this.mLastPosition = -1;
        notifyDataSetChanged();
        BaseLoadMoreModule baseLoadMoreModule2 = this.mLoadMoreModule;
        if (baseLoadMoreModule2 != null) {
            baseLoadMoreModule2.checkDisableLoadMoreIfNotFullPage();
        }
    }

    public void setOnItemChildClick(View v6, int i3) {
        e.g(v6, "v");
        OnItemChildClickListener onItemChildClickListener = this.mOnItemChildClickListener;
        if (onItemChildClickListener != null) {
            onItemChildClickListener.onItemChildClick(this, v6, i3);
        }
    }

    @Override // com.chad.library.adapter.base.listener.BaseListenerImp
    public void setOnItemChildClickListener(OnItemChildClickListener onItemChildClickListener) {
        this.mOnItemChildClickListener = onItemChildClickListener;
    }

    public boolean setOnItemChildLongClick(View v6, int i3) {
        e.g(v6, "v");
        OnItemChildLongClickListener onItemChildLongClickListener = this.mOnItemChildLongClickListener;
        if (onItemChildLongClickListener != null) {
            return onItemChildLongClickListener.onItemChildLongClick(this, v6, i3);
        }
        return false;
    }

    @Override // com.chad.library.adapter.base.listener.BaseListenerImp
    public void setOnItemChildLongClickListener(OnItemChildLongClickListener onItemChildLongClickListener) {
        this.mOnItemChildLongClickListener = onItemChildLongClickListener;
    }

    public void setOnItemClick(View v6, int i3) {
        e.g(v6, "v");
        OnItemClickListener onItemClickListener = this.mOnItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(this, v6, i3);
        }
    }

    @Override // com.chad.library.adapter.base.listener.BaseListenerImp
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public boolean setOnItemLongClick(View v6, int i3) {
        e.g(v6, "v");
        OnItemLongClickListener onItemLongClickListener = this.mOnItemLongClickListener;
        if (onItemLongClickListener != null) {
            return onItemLongClickListener.onItemLongClick(this, v6, i3);
        }
        return false;
    }

    @Override // com.chad.library.adapter.base.listener.BaseListenerImp
    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    public final void setRecyclerView(RecyclerView value) {
        e.g(value, "value");
        this.mRecyclerView = value;
    }

    public final void setUseEmpty(boolean z5) {
        this.isUseEmpty = z5;
    }

    public final void setWeakRecyclerView(WeakReference<RecyclerView> weakReference) {
        e.g(weakReference, "<set-?>");
        this.weakRecyclerView = weakReference;
    }

    public void startAnim(Animator anim, int i3) {
        e.g(anim, "anim");
        anim.start();
    }

    public /* synthetic */ BaseQuickAdapter(int i3, List list, int i10, c cVar) {
        this(i3, (i10 & 2) != 0 ? null : list);
    }

    public final int addFooterView(View view, int i3) {
        return addFooterView$default(this, view, i3, 0, 4, null);
    }

    public final int addHeaderView(View view, int i3) {
        return addHeaderView$default(this, view, i3, 0, 4, null);
    }

    public VH createBaseViewHolder(View view) {
        e.g(view, "view");
        Class<?> cls = null;
        for (Class<?> cls2 = getClass(); cls == null && cls2 != null; cls2 = cls2.getSuperclass()) {
            cls = getInstancedGenericKClass(cls2);
        }
        VH createBaseGenericKInstance = cls == null ? (VH) new BaseViewHolder(view) : createBaseGenericKInstance(cls, view);
        return createBaseGenericKInstance != null ? createBaseGenericKInstance : (VH) new BaseViewHolder(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.z0
    public /* bridge */ /* synthetic */ void onBindViewHolder(z1 z1Var, int i3, List list) {
        onBindViewHolder((BaseQuickAdapter<T, VH>) z1Var, i3, (List<Object>) list);
    }

    @Override // androidx.recyclerview.widget.z0
    public VH onCreateViewHolder(ViewGroup parent, int i3) {
        e.g(parent, "parent");
        switch (i3) {
            case HEADER_VIEW /* 268435729 */:
                LinearLayout linearLayout = this.mHeaderLayout;
                if (linearLayout == null) {
                    e.m("mHeaderLayout");
                    throw null;
                }
                ViewParent parent2 = linearLayout.getParent();
                if (parent2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent2;
                    LinearLayout linearLayout2 = this.mHeaderLayout;
                    if (linearLayout2 == null) {
                        e.m("mHeaderLayout");
                        throw null;
                    }
                    viewGroup.removeView(linearLayout2);
                }
                LinearLayout linearLayout3 = this.mHeaderLayout;
                if (linearLayout3 != null) {
                    return createBaseViewHolder(linearLayout3);
                }
                e.m("mHeaderLayout");
                throw null;
            case LOAD_MORE_VIEW /* 268436002 */:
                BaseLoadMoreModule baseLoadMoreModule = this.mLoadMoreModule;
                if (baseLoadMoreModule == null) {
                    e.l();
                    throw null;
                }
                VH createBaseViewHolder = createBaseViewHolder(baseLoadMoreModule.getLoadMoreView().getRootView(parent));
                BaseLoadMoreModule baseLoadMoreModule2 = this.mLoadMoreModule;
                if (baseLoadMoreModule2 != null) {
                    baseLoadMoreModule2.setupViewHolder$com_github_CymChad_brvah(createBaseViewHolder);
                    return createBaseViewHolder;
                }
                e.l();
                throw null;
            case FOOTER_VIEW /* 268436275 */:
                LinearLayout linearLayout4 = this.mFooterLayout;
                if (linearLayout4 == null) {
                    e.m("mFooterLayout");
                    throw null;
                }
                ViewParent parent3 = linearLayout4.getParent();
                if (parent3 instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) parent3;
                    LinearLayout linearLayout5 = this.mFooterLayout;
                    if (linearLayout5 == null) {
                        e.m("mFooterLayout");
                        throw null;
                    }
                    viewGroup2.removeView(linearLayout5);
                }
                LinearLayout linearLayout6 = this.mFooterLayout;
                if (linearLayout6 != null) {
                    return createBaseViewHolder(linearLayout6);
                }
                e.m("mFooterLayout");
                throw null;
            case EMPTY_VIEW /* 268436821 */:
                FrameLayout frameLayout = this.mEmptyLayout;
                if (frameLayout == null) {
                    e.m("mEmptyLayout");
                    throw null;
                }
                ViewParent parent4 = frameLayout.getParent();
                if (parent4 instanceof ViewGroup) {
                    ViewGroup viewGroup3 = (ViewGroup) parent4;
                    FrameLayout frameLayout2 = this.mEmptyLayout;
                    if (frameLayout2 == null) {
                        e.m("mEmptyLayout");
                        throw null;
                    }
                    viewGroup3.removeView(frameLayout2);
                }
                FrameLayout frameLayout3 = this.mEmptyLayout;
                if (frameLayout3 != null) {
                    return createBaseViewHolder(frameLayout3);
                }
                e.m("mEmptyLayout");
                throw null;
            default:
                VH onCreateDefViewHolder = onCreateDefViewHolder(parent, i3);
                bindViewClickListener(onCreateDefViewHolder, i3);
                BaseDraggableModule baseDraggableModule = this.mDraggableModule;
                if (baseDraggableModule != null) {
                    baseDraggableModule.initView$com_github_CymChad_brvah(onCreateDefViewHolder);
                }
                onItemViewHolderCreated(onCreateDefViewHolder, i3);
                return onCreateDefViewHolder;
        }
    }

    @Override // androidx.recyclerview.widget.z0
    public void onViewAttachedToWindow(VH holder) {
        e.g(holder, "holder");
        if (isFixedViewType(holder.getItemViewType())) {
            setFullSpan(holder);
        } else {
            addAnimation(holder);
        }
    }

    public void remove(T t8) {
        int indexOf = this.data.indexOf(t8);
        if (indexOf == -1) {
            return;
        }
        removeAt(indexOf);
    }

    public final int setFooterView(View view, int i3) {
        return setFooterView$default(this, view, i3, 0, 4, null);
    }

    public final int setHeaderView(View view, int i3) {
        return setHeaderView$default(this, view, i3, 0, 4, null);
    }

    public BaseQuickAdapter(int i3, List<T> list) {
        this.layoutResId = i3;
        this.data = list == null ? new ArrayList<>() : list;
        this.isUseEmpty = true;
        this.isAnimationFirstOnly = true;
        this.mLastPosition = -1;
        checkModule();
        this.childClickViewIds = new LinkedHashSet<>();
        this.childLongClickViewIds = new LinkedHashSet<>();
    }

    public final int addFooterView(View view, int i3, int i10) {
        int footerViewPosition;
        j1 j1Var;
        e.g(view, "view");
        if (this.mFooterLayout == null) {
            LinearLayout linearLayout = new LinearLayout(view.getContext());
            this.mFooterLayout = linearLayout;
            linearLayout.setOrientation(i10);
            LinearLayout linearLayout2 = this.mFooterLayout;
            if (linearLayout2 == null) {
                e.m("mFooterLayout");
                throw null;
            }
            if (i10 == 1) {
                j1Var = new j1(-1, -2);
            } else {
                j1Var = new j1(-2, -1);
            }
            linearLayout2.setLayoutParams(j1Var);
        }
        LinearLayout linearLayout3 = this.mFooterLayout;
        if (linearLayout3 != null) {
            int childCount = linearLayout3.getChildCount();
            if (i3 < 0 || i3 > childCount) {
                i3 = childCount;
            }
            LinearLayout linearLayout4 = this.mFooterLayout;
            if (linearLayout4 != null) {
                linearLayout4.addView(view, i3);
                LinearLayout linearLayout5 = this.mFooterLayout;
                if (linearLayout5 == null) {
                    e.m("mFooterLayout");
                    throw null;
                }
                if (linearLayout5.getChildCount() == 1 && (footerViewPosition = getFooterViewPosition()) != -1) {
                    notifyItemInserted(footerViewPosition);
                }
                return i3;
            }
            e.m("mFooterLayout");
            throw null;
        }
        e.m("mFooterLayout");
        throw null;
    }

    public final int addHeaderView(View view, int i3, int i10) {
        int headerViewPosition;
        j1 j1Var;
        e.g(view, "view");
        if (this.mHeaderLayout == null) {
            LinearLayout linearLayout = new LinearLayout(view.getContext());
            this.mHeaderLayout = linearLayout;
            linearLayout.setOrientation(i10);
            LinearLayout linearLayout2 = this.mHeaderLayout;
            if (linearLayout2 == null) {
                e.m("mHeaderLayout");
                throw null;
            }
            if (i10 == 1) {
                j1Var = new j1(-1, -2);
            } else {
                j1Var = new j1(-2, -1);
            }
            linearLayout2.setLayoutParams(j1Var);
        }
        LinearLayout linearLayout3 = this.mHeaderLayout;
        if (linearLayout3 != null) {
            int childCount = linearLayout3.getChildCount();
            if (i3 < 0 || i3 > childCount) {
                i3 = childCount;
            }
            LinearLayout linearLayout4 = this.mHeaderLayout;
            if (linearLayout4 != null) {
                linearLayout4.addView(view, i3);
                LinearLayout linearLayout5 = this.mHeaderLayout;
                if (linearLayout5 == null) {
                    e.m("mHeaderLayout");
                    throw null;
                }
                if (linearLayout5.getChildCount() == 1 && (headerViewPosition = getHeaderViewPosition()) != -1) {
                    notifyItemInserted(headerViewPosition);
                }
                return i3;
            }
            e.m("mHeaderLayout");
            throw null;
        }
        e.m("mHeaderLayout");
        throw null;
    }

    @Override // androidx.recyclerview.widget.z0
    public void onBindViewHolder(VH holder, int i3) {
        e.g(holder, "holder");
        BaseUpFetchModule baseUpFetchModule = this.mUpFetchModule;
        if (baseUpFetchModule != null) {
            baseUpFetchModule.autoUpFetch$com_github_CymChad_brvah(i3);
        }
        BaseLoadMoreModule baseLoadMoreModule = this.mLoadMoreModule;
        if (baseLoadMoreModule != null) {
            baseLoadMoreModule.autoLoadMore$com_github_CymChad_brvah(i3);
        }
        switch (holder.getItemViewType()) {
            case HEADER_VIEW /* 268435729 */:
            case FOOTER_VIEW /* 268436275 */:
            case EMPTY_VIEW /* 268436821 */:
                break;
            case LOAD_MORE_VIEW /* 268436002 */:
                BaseLoadMoreModule baseLoadMoreModule2 = this.mLoadMoreModule;
                if (baseLoadMoreModule2 != null) {
                    baseLoadMoreModule2.getLoadMoreView().convert(holder, i3, baseLoadMoreModule2.getLoadMoreStatus());
                    break;
                }
                break;
            default:
                convert(holder, getItem(i3 - getHeaderLayoutCount()));
                break;
        }
    }

    public final int setFooterView(View view, int i3, int i10) {
        e.g(view, "view");
        LinearLayout linearLayout = this.mFooterLayout;
        if (linearLayout != null) {
            if (linearLayout == null) {
                e.m("mFooterLayout");
                throw null;
            }
            if (linearLayout.getChildCount() > i3) {
                LinearLayout linearLayout2 = this.mFooterLayout;
                if (linearLayout2 != null) {
                    linearLayout2.removeViewAt(i3);
                    LinearLayout linearLayout3 = this.mFooterLayout;
                    if (linearLayout3 != null) {
                        linearLayout3.addView(view, i3);
                        return i3;
                    }
                    e.m("mFooterLayout");
                    throw null;
                }
                e.m("mFooterLayout");
                throw null;
            }
        }
        return addFooterView(view, i3, i10);
    }

    public final int setHeaderView(View view, int i3, int i10) {
        e.g(view, "view");
        LinearLayout linearLayout = this.mHeaderLayout;
        if (linearLayout != null) {
            if (linearLayout == null) {
                e.m("mHeaderLayout");
                throw null;
            }
            if (linearLayout.getChildCount() > i3) {
                LinearLayout linearLayout2 = this.mHeaderLayout;
                if (linearLayout2 != null) {
                    linearLayout2.removeViewAt(i3);
                    LinearLayout linearLayout3 = this.mHeaderLayout;
                    if (linearLayout3 != null) {
                        linearLayout3.addView(view, i3);
                        return i3;
                    }
                    e.m("mHeaderLayout");
                    throw null;
                }
                e.m("mHeaderLayout");
                throw null;
            }
        }
        return addHeaderView(view, i3, i10);
    }

    public void addData(T t8) {
        this.data.add(t8);
        notifyItemInserted(getHeaderLayoutCount() + this.data.size());
        compatibilityDataSizeChanged(1);
    }

    public void setDiffNewData(o diffResult, List<T> list) {
        e.g(diffResult, "diffResult");
        e.g(list, "list");
        if (hasEmptyView()) {
            setNewInstance(list);
        } else {
            diffResult.a(new BrvahListUpdateCallback(this));
            this.data = list;
        }
    }

    public void addData(int i3, Collection<? extends T> newData) {
        e.g(newData, "newData");
        this.data.addAll(i3, newData);
        notifyItemRangeInserted(getHeaderLayoutCount() + i3, newData.size());
        compatibilityDataSizeChanged(newData.size());
    }

    public void onBindViewHolder(VH holder, int i3, List<Object> payloads) {
        e.g(holder, "holder");
        e.g(payloads, "payloads");
        if (payloads.isEmpty()) {
            onBindViewHolder((BaseQuickAdapter<T, VH>) holder, i3);
        }
        BaseUpFetchModule baseUpFetchModule = this.mUpFetchModule;
        if (baseUpFetchModule != null) {
            baseUpFetchModule.autoUpFetch$com_github_CymChad_brvah(i3);
        }
        BaseLoadMoreModule baseLoadMoreModule = this.mLoadMoreModule;
        if (baseLoadMoreModule != null) {
            baseLoadMoreModule.autoLoadMore$com_github_CymChad_brvah(i3);
        }
        switch (holder.getItemViewType()) {
            case HEADER_VIEW /* 268435729 */:
            case FOOTER_VIEW /* 268436275 */:
            case EMPTY_VIEW /* 268436821 */:
                break;
            case LOAD_MORE_VIEW /* 268436002 */:
                BaseLoadMoreModule baseLoadMoreModule2 = this.mLoadMoreModule;
                if (baseLoadMoreModule2 != null) {
                    baseLoadMoreModule2.getLoadMoreView().convert(holder, i3, baseLoadMoreModule2.getLoadMoreStatus());
                    break;
                }
                break;
            default:
                convert(holder, getItem(i3 - getHeaderLayoutCount()), payloads);
                break;
        }
    }

    public void addData(Collection<? extends T> newData) {
        e.g(newData, "newData");
        this.data.addAll(newData);
        notifyItemRangeInserted(getHeaderLayoutCount() + (this.data.size() - newData.size()), newData.size());
        compatibilityDataSizeChanged(newData.size());
    }

    public final void setEmptyView(int i3) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            View view = LayoutInflater.from(recyclerView.getContext()).inflate(i3, (ViewGroup) recyclerView, false);
            e.b(view, "view");
            setEmptyView(view);
        }
    }
}
