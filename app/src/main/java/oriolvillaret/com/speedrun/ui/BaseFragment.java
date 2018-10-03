package oriolvillaret.com.speedrun.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import oriolvillaret.com.speedrun.R;

public abstract class BaseFragment extends Fragment {

    protected int mLayoutId;
    protected View mRootView;

    protected boolean portrait = true;
    protected String FRAGMENT_ID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Context contextThemeWrapper;
        contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);

        // inflate the layout using the cloned inflater, not default inflater
        mRootView = localInflater.inflate(mLayoutId, container, false);

        ButterKnife.bind(this, mRootView);
        hideLoading();

        setHasOptionsMenu(true);

        return mRootView;
    }

    public abstract void hideLoading();
    public abstract void showLoading();

    protected void showToastError(String str) {
        showToastMessage(str, mRootView, R.color.red);
    }

    protected void showToastMessage(String str) {
        showToastMessage(str, mRootView, R.color.black);
    }

    private void showToastMessage(String str, View view, int color) {

        ForegroundColorSpan whiteSpan = new ForegroundColorSpan(getResources().getColor(R.color.white));
        SpannableStringBuilder snackbarText = new SpannableStringBuilder(str);
        snackbarText.setSpan(whiteSpan, 0, snackbarText.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        Snackbar snackbar = Snackbar.make(view, snackbarText, Snackbar.LENGTH_LONG);
        if (color != 0) {
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(getActivity(), color));
        }
        snackbar.show();

    }
}
