package oriolvillaret.com.speedrun.presenters;

import android.os.Bundle;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import androidx.navigation.Navigation;
import oriolvillaret.com.speedrun.R;
import oriolvillaret.com.speedrun.interactors.SpeedrunInteractor;
import oriolvillaret.com.speedrun.models.Game;
import oriolvillaret.com.speedrun.ui.DetailFragment;

public class MasterListPresenter extends BasePresenter<MasterListPresenter.MasterListInterface> {

    public MasterListPresenter() {
        mBus = EventBus.getDefault();
    }

    public void getData() {
        if (getView()!=null) {
            getView().showLoading();
        }
        SpeedrunInteractor.getInstance().getGames();
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetGames(ArrayList<Game> data) {
        EventBus.getDefault().removeStickyEvent(data);
        if (getView()!=null) {
            getView().hideLoading();
            getView().setData(data);
        }
    }


    public interface MasterListInterface extends BasePresenter.BaseFragmentInterface {
        void setData(ArrayList<Game> games);
    }

    public void navigationDetail(View view, Game item) {
        Bundle args = new Bundle();
        args.putParcelable(DetailFragment.GAME_PARAM, item);
        Navigation.findNavController(view).navigate(R.id.action_masterListFragment_to_detailFragment, args);
    }
}
