package oriolvillaret.com.speedrun.presenters;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import oriolvillaret.com.speedrun.controllers.SpeedrunController;
import oriolvillaret.com.speedrun.models.Record;
import oriolvillaret.com.speedrun.models.User;

public class DetailPresenter extends BasePresenter<DetailPresenter.DetailInterface> {

    private Record record;
    public DetailPresenter() {
        mBus = EventBus.getDefault();
    }

    public void getRecord(String gameId) {
        if (getView()!=null) {
            getView().showLoading();
        }
        SpeedrunController.getInstance().getRecords(gameId);
    }

    public void getUser(String userId){
        if(getView()!=null){
            getView().showLoading();
        }
        SpeedrunController.getInstance().getUser(userId);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetGames(List<Record> data) {
        EventBus.getDefault().removeStickyEvent(data);
        if (getView()!=null) {
            if (data != null && !data.isEmpty()){
                record = data.get(0);
                getUser(record.getUserFistPlace().getId());
            }else{
                getView().hideLoading();
                getView().setData(null);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetUser(User data) {
        EventBus.getDefault().removeStickyEvent(data);
        if (getView()!=null) {
            getView().hideLoading();
            record.setUserFistPlace(data);
            getView().setData(record);
        }
    }


    public interface DetailInterface extends BasePresenter.BaseFragmentInterface {
        void setData(Record record);
    }
}
