package oriolvillaret.com.speedrun.presenters;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class BasePresenter<T extends BasePresenter.BaseFragmentInterface> {


    protected EventBus mBus;
    protected boolean mRegistered;
    protected T mView;

    public void start() {
        if (!mRegistered) {
            mBus = EventBus.getDefault();
            mBus.register(this);
            mRegistered = true;
        }
    }

    public void destroy() {
        if (mRegistered) {
            mBus.unregister(this);
            mRegistered = false;
        }
    }

    public void attachView(T mView) {
        this.mView = mView;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onError(Throwable t) {
        EventBus.getDefault().removeStickyEvent(t);
        if (getView() != null) {
            getView().hideLoading();
            getView().showGenericError();
        }
    }

    public T getView() {

        return this.mView;
    }

    public interface BaseFragmentInterface {

        void showLoading();

        void hideLoading();

        void showGenericError();
    }
}
