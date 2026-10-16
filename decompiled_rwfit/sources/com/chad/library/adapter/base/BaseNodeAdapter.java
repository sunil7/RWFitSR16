package com.chad.library.adapter.base;

import androidx.recyclerview.widget.o;
import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.entity.node.NodeFooterImp;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.i;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: classes.dex */
public abstract class BaseNodeAdapter extends BaseProviderMultiAdapter<BaseNode> {
    private final HashSet<Integer> fullSpanNodeTypeSet;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseNodeAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ int collapse$default(BaseNodeAdapter baseNodeAdapter, int i3, boolean z5, boolean z6, boolean z8, Object obj, int i10, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapse");
        }
        if ((i10 & 2) != 0) {
            z5 = false;
        }
        boolean z10 = z5;
        boolean z11 = (i10 & 4) != 0 ? true : z6;
        boolean z12 = (i10 & 8) != 0 ? true : z8;
        if ((i10 & 16) != 0) {
            obj = null;
        }
        return baseNodeAdapter.collapse(i3, z10, z11, z12, obj);
    }

    public static /* synthetic */ int collapseAndChild$default(BaseNodeAdapter baseNodeAdapter, int i3, boolean z5, boolean z6, Object obj, int i10, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapseAndChild");
        }
        if ((i10 & 2) != 0) {
            z5 = true;
        }
        if ((i10 & 4) != 0) {
            z6 = true;
        }
        if ((i10 & 8) != 0) {
            obj = null;
        }
        return baseNodeAdapter.collapseAndChild(i3, z5, z6, obj);
    }

    public static /* synthetic */ int expand$default(BaseNodeAdapter baseNodeAdapter, int i3, boolean z5, boolean z6, boolean z8, Object obj, int i10, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expand");
        }
        if ((i10 & 2) != 0) {
            z5 = false;
        }
        boolean z10 = z5;
        boolean z11 = (i10 & 4) != 0 ? true : z6;
        boolean z12 = (i10 & 8) != 0 ? true : z8;
        if ((i10 & 16) != 0) {
            obj = null;
        }
        return baseNodeAdapter.expand(i3, z10, z11, z12, obj);
    }

    public static /* synthetic */ int expandAndChild$default(BaseNodeAdapter baseNodeAdapter, int i3, boolean z5, boolean z6, Object obj, int i10, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandAndChild");
        }
        if ((i10 & 2) != 0) {
            z5 = true;
        }
        if ((i10 & 4) != 0) {
            z6 = true;
        }
        if ((i10 & 8) != 0) {
            obj = null;
        }
        return baseNodeAdapter.expandAndChild(i3, z5, z6, obj);
    }

    public static /* synthetic */ void expandAndCollapseOther$default(BaseNodeAdapter baseNodeAdapter, int i3, boolean z5, boolean z6, boolean z8, boolean z10, Object obj, Object obj2, int i10, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandAndCollapseOther");
        }
        baseNodeAdapter.expandAndCollapseOther(i3, (i10 & 2) != 0 ? false : z5, (i10 & 4) != 0 ? true : z6, (i10 & 8) != 0 ? true : z8, (i10 & 16) == 0 ? z10 : true, (i10 & 32) != 0 ? null : obj, (i10 & 64) != 0 ? null : obj2);
    }

    public static /* synthetic */ int expandOrCollapse$default(BaseNodeAdapter baseNodeAdapter, int i3, boolean z5, boolean z6, Object obj, int i10, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expandOrCollapse");
        }
        if ((i10 & 2) != 0) {
            z5 = true;
        }
        if ((i10 & 4) != 0) {
            z6 = true;
        }
        if ((i10 & 8) != 0) {
            obj = null;
        }
        return baseNodeAdapter.expandOrCollapse(i3, z5, z6, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<BaseNode> flatData(Collection<? extends BaseNode> collection, Boolean bool) {
        BaseNode footerNode;
        List<BaseNode> childNode;
        ArrayList arrayList = new ArrayList();
        for (BaseNode baseNode : collection) {
            arrayList.add(baseNode);
            if (baseNode instanceof BaseExpandNode) {
                if ((e.a(bool, Boolean.TRUE) || ((BaseExpandNode) baseNode).isExpanded()) && (childNode = baseNode.getChildNode()) != null && !childNode.isEmpty()) {
                    arrayList.addAll(flatData(childNode, bool));
                }
                if (bool != null) {
                    ((BaseExpandNode) baseNode).setExpanded(bool.booleanValue());
                }
            } else {
                List<BaseNode> childNode2 = baseNode.getChildNode();
                if (childNode2 != null && !childNode2.isEmpty()) {
                    arrayList.addAll(flatData(childNode2, bool));
                }
            }
            if ((baseNode instanceof NodeFooterImp) && (footerNode = ((NodeFooterImp) baseNode).getFooterNode()) != null) {
                arrayList.add(footerNode);
            }
        }
        return arrayList;
    }

    public static /* synthetic */ List flatData$default(BaseNodeAdapter baseNodeAdapter, Collection collection, Boolean bool, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flatData");
        }
        if ((i3 & 2) != 0) {
            bool = null;
        }
        return baseNodeAdapter.flatData(collection, bool);
    }

    private final int removeChildAt(int i3) {
        BaseNode baseNode;
        List<BaseNode> childNode;
        if (i3 >= getData().size() || (childNode = (baseNode = getData().get(i3)).getChildNode()) == null || childNode.isEmpty()) {
            return 0;
        }
        if (!(baseNode instanceof BaseExpandNode)) {
            List<BaseNode> childNode2 = baseNode.getChildNode();
            if (childNode2 == null) {
                e.l();
                throw null;
            }
            List flatData$default = flatData$default(this, childNode2, null, 2, null);
            getData().removeAll(flatData$default);
            return flatData$default.size();
        }
        if (!((BaseExpandNode) baseNode).isExpanded()) {
            return 0;
        }
        List<BaseNode> childNode3 = baseNode.getChildNode();
        if (childNode3 == null) {
            e.l();
            throw null;
        }
        List flatData$default2 = flatData$default(this, childNode3, null, 2, null);
        getData().removeAll(flatData$default2);
        return flatData$default2.size();
    }

    private final int removeNodesAt(int i3) {
        if (i3 >= getData().size()) {
            return 0;
        }
        int removeChildAt = removeChildAt(i3);
        getData().remove(i3);
        int i10 = removeChildAt + 1;
        Object obj = (BaseNode) getData().get(i3);
        if (!(obj instanceof NodeFooterImp) || ((NodeFooterImp) obj).getFooterNode() == null) {
            return i10;
        }
        getData().remove(i3);
        return removeChildAt + 2;
    }

    public final void addFooterNodeProvider(BaseNodeProvider provider) {
        e.g(provider, "provider");
        addFullSpanNodeProvider(provider);
    }

    public final void addFullSpanNodeProvider(BaseNodeProvider provider) {
        e.g(provider, "provider");
        this.fullSpanNodeTypeSet.add(Integer.valueOf(provider.getItemViewType()));
        addItemProvider(provider);
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public void addItemProvider(BaseItemProvider<BaseNode> provider) {
        e.g(provider, "provider");
        if (!(provider instanceof BaseNodeProvider)) {
            throw new IllegalStateException("Please add BaseNodeProvider, no BaseItemProvider!");
        }
        super.addItemProvider(provider);
    }

    public final void addNodeProvider(BaseNodeProvider provider) {
        e.g(provider, "provider");
        addItemProvider(provider);
    }

    public final int collapse(int i3) {
        return collapse$default(this, i3, false, false, null, 14, null);
    }

    public final int collapseAndChild(int i3) {
        return collapseAndChild$default(this, i3, false, false, null, 14, null);
    }

    public final int expand(int i3) {
        return expand$default(this, i3, false, false, null, 14, null);
    }

    public final int expandAndChild(int i3) {
        return expandAndChild$default(this, i3, false, false, null, 14, null);
    }

    public final void expandAndCollapseOther(int i3) {
        expandAndCollapseOther$default(this, i3, false, false, false, false, null, null, WebSocketProtocol.PAYLOAD_SHORT, null);
    }

    public final int expandOrCollapse(int i3) {
        return expandOrCollapse$default(this, i3, false, false, null, 14, null);
    }

    public final int findParentNode(BaseNode node) {
        e.g(node, "node");
        int indexOf = getData().indexOf(node);
        if (indexOf != -1 && indexOf != 0) {
            for (int i3 = indexOf - 1; i3 >= 0; i3--) {
                List<BaseNode> childNode = getData().get(i3).getChildNode();
                if (childNode != null && childNode.contains(node)) {
                    return i3;
                }
            }
        }
        return -1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public boolean isFixedViewType(int i3) {
        return super.isFixedViewType(i3) || this.fullSpanNodeTypeSet.contains(Integer.valueOf(i3));
    }

    public final void nodeAddData(BaseNode parentNode, BaseNode data) {
        e.g(parentNode, "parentNode");
        e.g(data, "data");
        List<BaseNode> childNode = parentNode.getChildNode();
        if (childNode != null) {
            childNode.add(data);
            if (!(parentNode instanceof BaseExpandNode) || ((BaseExpandNode) parentNode).isExpanded()) {
                addData(childNode.size() + getData().indexOf(parentNode), data);
            }
        }
    }

    public final void nodeRemoveData(BaseNode parentNode, int i3) {
        e.g(parentNode, "parentNode");
        List<BaseNode> childNode = parentNode.getChildNode();
        if (childNode == null || i3 >= childNode.size()) {
            return;
        }
        if ((parentNode instanceof BaseExpandNode) && !((BaseExpandNode) parentNode).isExpanded()) {
            childNode.remove(i3);
        } else {
            remove(getData().indexOf(parentNode) + 1 + i3);
            childNode.remove(i3);
        }
    }

    public final void nodeReplaceChildData(BaseNode parentNode, Collection<? extends BaseNode> newData) {
        e.g(parentNode, "parentNode");
        e.g(newData, "newData");
        List<BaseNode> childNode = parentNode.getChildNode();
        if (childNode != null) {
            if ((parentNode instanceof BaseExpandNode) && !((BaseExpandNode) parentNode).isExpanded()) {
                childNode.clear();
                childNode.addAll(newData);
                return;
            }
            int indexOf = getData().indexOf(parentNode);
            int removeChildAt = removeChildAt(indexOf);
            childNode.clear();
            childNode.addAll(newData);
            List flatData$default = flatData$default(this, newData, null, 2, null);
            int i3 = indexOf + 1;
            getData().addAll(i3, flatData$default);
            int headerLayoutCount = getHeaderLayoutCount() + i3;
            if (removeChildAt == flatData$default.size()) {
                notifyItemRangeChanged(headerLayoutCount, removeChildAt);
            } else {
                notifyItemRangeRemoved(headerLayoutCount, removeChildAt);
                notifyItemRangeInserted(headerLayoutCount, flatData$default.size());
            }
        }
    }

    public final void nodeSetData(BaseNode parentNode, int i3, BaseNode data) {
        e.g(parentNode, "parentNode");
        e.g(data, "data");
        List<BaseNode> childNode = parentNode.getChildNode();
        if (childNode == null || i3 >= childNode.size()) {
            return;
        }
        if ((parentNode instanceof BaseExpandNode) && !((BaseExpandNode) parentNode).isExpanded()) {
            childNode.set(i3, data);
        } else {
            setData(getData().indexOf(parentNode) + 1 + i3, data);
            childNode.set(i3, data);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void removeAt(int i3) {
        notifyItemRangeRemoved(getHeaderLayoutCount() + i3, removeNodesAt(i3));
        compatibilityDataSizeChanged(0);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setDiffNewData(List<BaseNode> list) {
        if (hasEmptyView()) {
            setNewInstance(list);
        } else {
            super.setDiffNewData(flatData$default(this, list != null ? list : new ArrayList(), null, 2, null));
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setList(Collection<? extends BaseNode> collection) {
        if (collection == null) {
            collection = new ArrayList<>();
        }
        super.setList(flatData$default(this, collection, null, 2, null));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewInstance(List<BaseNode> list) {
        super.setNewInstance(flatData$default(this, list != null ? list : new ArrayList(), null, 2, null));
    }

    public /* synthetic */ BaseNodeAdapter(List list, int i3, c cVar) {
        this((i3 & 1) != 0 ? null : list);
    }

    public final int collapse(int i3, boolean z5) {
        return collapse$default(this, i3, z5, false, null, 12, null);
    }

    public final int collapseAndChild(int i3, boolean z5) {
        return collapseAndChild$default(this, i3, z5, false, null, 12, null);
    }

    public final int expand(int i3, boolean z5) {
        return expand$default(this, i3, z5, false, null, 12, null);
    }

    public final int expandAndChild(int i3, boolean z5) {
        return expandAndChild$default(this, i3, z5, false, null, 12, null);
    }

    public final void expandAndCollapseOther(int i3, boolean z5) {
        expandAndCollapseOther$default(this, i3, z5, false, false, false, null, null, 124, null);
    }

    public final int expandOrCollapse(int i3, boolean z5) {
        return expandOrCollapse$default(this, i3, z5, false, null, 12, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setData(int i3, BaseNode data) {
        e.g(data, "data");
        int removeNodesAt = removeNodesAt(i3);
        List flatData$default = flatData$default(this, i.b(data), null, 2, null);
        getData().addAll(i3, flatData$default);
        if (removeNodesAt == flatData$default.size()) {
            notifyItemRangeChanged(getHeaderLayoutCount() + i3, removeNodesAt);
        } else {
            notifyItemRangeRemoved(getHeaderLayoutCount() + i3, removeNodesAt);
            notifyItemRangeInserted(getHeaderLayoutCount() + i3, flatData$default.size());
        }
    }

    public BaseNodeAdapter(List<BaseNode> list) {
        super(null);
        this.fullSpanNodeTypeSet = new HashSet<>();
        List<BaseNode> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        getData().addAll(flatData$default(this, list2, null, 2, null));
    }

    public static /* synthetic */ int collapse$default(BaseNodeAdapter baseNodeAdapter, int i3, boolean z5, boolean z6, Object obj, int i10, Object obj2) {
        if (obj2 == null) {
            if ((i10 & 2) != 0) {
                z5 = true;
            }
            if ((i10 & 4) != 0) {
                z6 = true;
            }
            if ((i10 & 8) != 0) {
                obj = null;
            }
            return baseNodeAdapter.collapse(i3, z5, z6, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapse");
    }

    public static /* synthetic */ int expand$default(BaseNodeAdapter baseNodeAdapter, int i3, boolean z5, boolean z6, Object obj, int i10, Object obj2) {
        if (obj2 == null) {
            if ((i10 & 2) != 0) {
                z5 = true;
            }
            if ((i10 & 4) != 0) {
                z6 = true;
            }
            if ((i10 & 8) != 0) {
                obj = null;
            }
            return baseNodeAdapter.expand(i3, z5, z6, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: expand");
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(int i3, BaseNode data) {
        e.g(data, "data");
        addData(i3, (Collection<? extends BaseNode>) i.b(data));
    }

    public final int collapse(int i3, boolean z5, boolean z6) {
        return collapse$default(this, i3, z5, z6, null, 8, null);
    }

    public final int collapseAndChild(int i3, boolean z5, boolean z6) {
        return collapseAndChild$default(this, i3, z5, z6, null, 8, null);
    }

    public final int expand(int i3, boolean z5, boolean z6) {
        return expand$default(this, i3, z5, z6, null, 8, null);
    }

    public final int expandAndChild(int i3, boolean z5, boolean z6) {
        return expandAndChild$default(this, i3, z5, z6, null, 8, null);
    }

    public final void expandAndCollapseOther(int i3, boolean z5, boolean z6) {
        expandAndCollapseOther$default(this, i3, z5, z6, false, false, null, null, 120, null);
    }

    public final int expandOrCollapse(int i3, boolean z5, boolean z6) {
        return expandOrCollapse$default(this, i3, z5, z6, null, 8, null);
    }

    private final int collapse(int i3, boolean z5, boolean z6, boolean z8, Object obj) {
        BaseNode baseNode = getData().get(i3);
        if (baseNode instanceof BaseExpandNode) {
            BaseExpandNode baseExpandNode = (BaseExpandNode) baseNode;
            if (baseExpandNode.isExpanded()) {
                int headerLayoutCount = getHeaderLayoutCount() + i3;
                baseExpandNode.setExpanded(false);
                List<BaseNode> childNode = baseNode.getChildNode();
                if (childNode != null && !childNode.isEmpty()) {
                    List<BaseNode> childNode2 = baseNode.getChildNode();
                    if (childNode2 != null) {
                        List<BaseNode> flatData = flatData(childNode2, z5 ? Boolean.FALSE : null);
                        int size = flatData.size();
                        getData().removeAll(flatData);
                        if (z8) {
                            if (z6) {
                                notifyItemChanged(headerLayoutCount, obj);
                                notifyItemRangeRemoved(headerLayoutCount + 1, size);
                                return size;
                            }
                            notifyDataSetChanged();
                        }
                        return size;
                    }
                    e.l();
                    throw null;
                }
                notifyItemChanged(headerLayoutCount, obj);
            }
        }
        return 0;
    }

    private final int expand(int i3, boolean z5, boolean z6, boolean z8, Object obj) {
        BaseNode baseNode = getData().get(i3);
        if (baseNode instanceof BaseExpandNode) {
            BaseExpandNode baseExpandNode = (BaseExpandNode) baseNode;
            if (!baseExpandNode.isExpanded()) {
                int headerLayoutCount = getHeaderLayoutCount() + i3;
                baseExpandNode.setExpanded(true);
                List<BaseNode> childNode = baseNode.getChildNode();
                if (childNode != null && !childNode.isEmpty()) {
                    List<BaseNode> childNode2 = baseNode.getChildNode();
                    if (childNode2 != null) {
                        List<BaseNode> flatData = flatData(childNode2, z5 ? Boolean.TRUE : null);
                        int size = flatData.size();
                        getData().addAll(i3 + 1, flatData);
                        if (z8) {
                            if (z6) {
                                notifyItemChanged(headerLayoutCount, obj);
                                notifyItemRangeInserted(headerLayoutCount + 1, size);
                                return size;
                            }
                            notifyDataSetChanged();
                        }
                        return size;
                    }
                    e.l();
                    throw null;
                }
                notifyItemChanged(headerLayoutCount, obj);
            }
        }
        return 0;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(BaseNode data) {
        e.g(data, "data");
        addData((Collection<? extends BaseNode>) i.b(data));
    }

    public final int collapseAndChild(int i3, boolean z5, boolean z6, Object obj) {
        return collapse(i3, true, z5, z6, obj);
    }

    public final int expandAndChild(int i3, boolean z5, boolean z6, Object obj) {
        return expand(i3, true, z5, z6, obj);
    }

    public final void expandAndCollapseOther(int i3, boolean z5, boolean z6, boolean z8) {
        expandAndCollapseOther$default(this, i3, z5, z6, z8, false, null, null, 112, null);
    }

    public final int expandOrCollapse(int i3, boolean z5, boolean z6, Object obj) {
        BaseNode baseNode = getData().get(i3);
        if (!(baseNode instanceof BaseExpandNode)) {
            return 0;
        }
        if (((BaseExpandNode) baseNode).isExpanded()) {
            return collapse(i3, false, z5, z6, obj);
        }
        return expand(i3, false, z5, z6, obj);
    }

    public final int findParentNode(int i3) {
        if (i3 == 0) {
            return -1;
        }
        BaseNode baseNode = getData().get(i3);
        for (int i10 = i3 - 1; i10 >= 0; i10--) {
            List<BaseNode> childNode = getData().get(i10).getChildNode();
            if (childNode != null && childNode.contains(baseNode)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setDiffNewData(o diffResult, List<BaseNode> list) {
        e.g(diffResult, "diffResult");
        e.g(list, "list");
        if (hasEmptyView()) {
            setNewInstance(list);
        } else {
            super.setDiffNewData(diffResult, flatData$default(this, list, null, 2, null));
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(int i3, Collection<? extends BaseNode> newData) {
        e.g(newData, "newData");
        super.addData(i3, (Collection) flatData$default(this, newData, null, 2, null));
    }

    public final void expandAndCollapseOther(int i3, boolean z5, boolean z6, boolean z8, boolean z10) {
        expandAndCollapseOther$default(this, i3, z5, z6, z8, z10, null, null, 96, null);
    }

    public final void expandAndCollapseOther(int i3, boolean z5, boolean z6, boolean z8, boolean z10, Object obj) {
        expandAndCollapseOther$default(this, i3, z5, z6, z8, z10, obj, null, 64, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(Collection<? extends BaseNode> newData) {
        e.g(newData, "newData");
        super.addData((Collection) flatData$default(this, newData, null, 2, null));
    }

    public final void expandAndCollapseOther(int i3, boolean z5, boolean z6, boolean z8, boolean z10, Object obj, Object obj2) {
        int size;
        int i10 = i3;
        int expand = expand(i10, z5, z8, z10, obj);
        if (expand == 0) {
            return;
        }
        int findParentNode = findParentNode(i10);
        int i11 = findParentNode == -1 ? 0 : findParentNode + 1;
        if (i10 - i11 > 0) {
            do {
                int i12 = i11;
                i11 = i12 + 1;
                i10 -= collapse(i12, z6, z8, z10, obj2);
            } while (i11 < i10);
        }
        int i13 = i10;
        if (findParentNode == -1) {
            size = getData().size() - 1;
        } else {
            List<BaseNode> childNode = getData().get(findParentNode).getChildNode();
            size = findParentNode + (childNode != null ? childNode.size() : 0) + expand;
        }
        int i14 = i13 + expand;
        if (i14 < size) {
            int i15 = size;
            int i16 = i14 + 1;
            while (i16 <= i15) {
                int collapse = collapse(i16, z6, z8, z10, obj2);
                i16++;
                i15 -= collapse;
            }
        }
    }

    public final void nodeAddData(BaseNode parentNode, int i3, BaseNode data) {
        e.g(parentNode, "parentNode");
        e.g(data, "data");
        List<BaseNode> childNode = parentNode.getChildNode();
        if (childNode != null) {
            childNode.add(i3, data);
            if (!(parentNode instanceof BaseExpandNode) || ((BaseExpandNode) parentNode).isExpanded()) {
                addData(getData().indexOf(parentNode) + 1 + i3, data);
            }
        }
    }

    public final void nodeRemoveData(BaseNode parentNode, BaseNode childNode) {
        e.g(parentNode, "parentNode");
        e.g(childNode, "childNode");
        List<BaseNode> childNode2 = parentNode.getChildNode();
        if (childNode2 != null) {
            if ((parentNode instanceof BaseExpandNode) && !((BaseExpandNode) parentNode).isExpanded()) {
                childNode2.remove(childNode);
            } else {
                remove((BaseNodeAdapter) childNode);
                childNode2.remove(childNode);
            }
        }
    }

    public final void nodeAddData(BaseNode parentNode, int i3, Collection<? extends BaseNode> newData) {
        e.g(parentNode, "parentNode");
        e.g(newData, "newData");
        List<BaseNode> childNode = parentNode.getChildNode();
        if (childNode != null) {
            childNode.addAll(i3, newData);
            if (!(parentNode instanceof BaseExpandNode) || ((BaseExpandNode) parentNode).isExpanded()) {
                addData(getData().indexOf(parentNode) + 1 + i3, newData);
            }
        }
    }

    public final int collapse(int i3, boolean z5, boolean z6, Object obj) {
        return collapse(i3, false, z5, z6, obj);
    }

    public final int expand(int i3, boolean z5, boolean z6, Object obj) {
        return expand(i3, false, z5, z6, obj);
    }
}
