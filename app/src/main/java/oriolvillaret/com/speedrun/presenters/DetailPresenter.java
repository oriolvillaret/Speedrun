package oriolvillaret.com.speedrun.presenters;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import androidx.navigation.Navigation;
import oriolvillaret.com.speedrun.interactors.SpeedrunInteractor;
import oriolvillaret.com.speedrun.models.Record;
import oriolvillaret.com.speedrun.models.User;

public class DetailPresenter extends BasePresenter<DetailPresenter.DetailInterface> {

    private Record record;

    public DetailPresenter() {
        mBus = EventBus.getDefault();
    }

    public void getRecord(String gameId) {
        if (getView() != null) {
            getView().showLoading();
        }
        SpeedrunInteractor.getInstance().getRecords(gameId);
    }

    public void getUser(String userId) {
        if (getView() != null) {
            getView().showLoading();
        }
        SpeedrunInteractor.getInstance().getUser(userId);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetGames(List<Record> data) {
        EventBus.getDefault().removeStickyEvent(data);
        if (getView() != null) {
            if (data != null && !data.isEmpty()) {
                //find only first not null record if its possible
                for (int x = 0; record == null && x < data.size(); x++) {
                    record = data.get(x);
                }
                if (record != null) {
                    getUser(record.getUserFistPlace().getId());
                } else {
                    getView().hideLoading();
                    getView().setData(null);
                }
            } else {
                getView().hideLoading();
                getView().setData(null);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetUser(User data) {
        EventBus.getDefault().removeStickyEvent(data);
        if (getView() != null) {
            getView().hideLoading();
            record.setUserFistPlace(data);
            getView().setData(record);
        }
    }

    public void navigationGoToExternalUrl(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        getView().startActivity(browserIntent);
    }

    public void navigationBack(View view) {
        Navigation.findNavController(view).navigateUp();
    }

    public interface DetailInterface extends BasePresenter.BaseFragmentInterface {
        void setData(Record record);
        void startActivity(Intent i);
    }
}
