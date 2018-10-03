package oriolvillaret.com.speedrun.presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import oriolvillaret.com.speedrun.controller.SpeedrunController;
import oriolvillaret.com.speedrun.model.Game;

public class MasterListPresenter extends BasePresenter<MasterListPresenter.MasterListInterface> {

    public MasterListPresenter() {
        mBus = EventBus.getDefault();
    }

    public void getData() {
        if (getView()!=null) {
            getView().showLoading();
        }
        SpeedrunController.getInstance().getGames();
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetGames(List<Game> data) {
        EventBus.getDefault().removeStickyEvent(data);
        if (getView()!=null) {
            getView().hideLoading();
            getView().setData(data);
        }
    }


    public interface MasterListInterface extends BasePresenter.BaseFragmentInterface {
        void setData(List<Game> games);
    }
}
