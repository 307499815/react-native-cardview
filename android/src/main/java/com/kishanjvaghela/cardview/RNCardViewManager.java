package com.kishanjvaghela.cardview;

import android.view.View;

import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;
import com.meetsl.scardview.SCardView;

/**
 * Created by kishan on 26/4/17.
 */

public class RNCardViewManager extends ViewGroupManager<SCardView> {

    @Override
    public String getName() {
        return "RNCardView";
    }

    @Override
    public SCardView createViewInstance(ThemedReactContext reactContext) {
        SCardView cardView = new SCardView(reactContext);
        ReactViewGroup reactViewGroup = new ReactViewGroup(reactContext);
        cardView.addView(reactViewGroup);
        return cardView;
    }

    @ReactProp(name = "cornerRadius", defaultFloat = 0f)
    public void setCornerRadius(SCardView view, float cornerRadius) {
        view.setRadius(PixelUtil.toPixelFromDIP(cornerRadius));
    }

    @ReactProp(name = "cardElevation", defaultFloat = 0f)
    public void setCardElevation(SCardView view, float elevation) {
        view.setCardElevation(elevation);
    }

    @ReactProp(name = "cardMaxElevation", defaultFloat = 0f)
    public void setCardMaxElevation(SCardView view, float elevation) {
        view.setMaxCardElevation(elevation);
    }

    @ReactProp(name = "cornerOverlap")
    public void setPreventCornerOverlap(SCardView view, boolean overlap) {
        view.setPreventCornerOverlap(overlap);
    }

    @ReactProp(name = "useCompatPadding")
    public void setUseCompatPadding(SCardView view, boolean padding) {
        view.setUseCompatPadding(padding);
    }

    @ReactProp(name = "backgroundColor")
    public void setCardBackgroundColor(SCardView view, int color) {
        view.setCardBackgroundColor(color);
    }

    @ReactProp(name = "shadowColor")
    public void setCardShadowColor(SCardView view, int color) {
        view.setCardShadowColor(color, color);
    }

    @Override
    public View getChildAt(SCardView parent, int index) {
        View content = parent.getChildAt(0);
        if (content != null && content instanceof ReactViewGroup) {
            return ((ReactViewGroup) content).getChildAt(index);
        }
        return null;
    }

    @Override
    public int getChildCount(SCardView parent) {
        View content = parent.getChildAt(0);
        if (content != null && content instanceof ReactViewGroup) {
            return ((ReactViewGroup) content).getChildCount();
        }
        return 0;
    }

    @Override
    public void addView(SCardView parent, View child, int index) {
        View content = parent.getChildAt(0);
        if (content != null && content instanceof ReactViewGroup) {
            ((ReactViewGroup) content).addView(child, index);
        }
    }

    @Override
    public void removeViewAt(SCardView parent, int index) {
        View content = parent.getChildAt(0);
        if (content != null && content instanceof ReactViewGroup) {
            ((ReactViewGroup) content).removeViewAt(index);
        }
    }

    @Override
    public void removeAllViews(SCardView parent) {
        View content = parent.getChildAt(0);
        if (content != null && content instanceof ReactViewGroup) {
            ((ReactViewGroup) content).removeAllViews();
        }
    }
}
