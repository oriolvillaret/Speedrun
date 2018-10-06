package oriolvillaret.com.speedrun.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import oriolvillaret.com.components.ItemGameView;
import oriolvillaret.com.speedrun.R;
import oriolvillaret.com.speedrun.models.Game;
import oriolvillaret.com.speedrun.models.Record;
import oriolvillaret.com.speedrun.presenters.DetailPresenter;
import oriolvillaret.com.speedrun.utils.DateUtils;


public class DetailFragment extends BaseFragment implements DetailPresenter.DetailInterface {

    public static String PARAM_SAVED_INSTANCE_STATE_GAME = "PARAM_GAME";
    public static String PARAM_SAVED_INSTANCE_STATE_RECORD = "PARAM_RECORD";

    public static String GAME_PARAM = "game_param";
    private DetailPresenter mPresenter;
    private Game mGame;
    private Record mRecord;

    @BindView(R.id.fragment_detail_game)
    ItemGameView fragment_detail_game;
    @BindView(R.id.fragment_detail_record_user)
    TextView fragment_detail_record_user;
    @BindView(R.id.fragment_detail_record_time)
    TextView fragment_detail_record_time;
    @BindView(R.id.fragment_detail_video)
    View fragment_detail_video;
    @BindView(R.id.fragment_detail_loading)
    View fragment_detail_loading;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter == null) {
            this.mPresenter = new DetailPresenter();
        }
        if (savedInstanceState == null) {
            this.mPresenter.attachView(this);
        }

        mLayoutId = R.layout.fragment_detail;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(GAME_PARAM)) {
            mGame = (Game) getArguments().getParcelable(GAME_PARAM);
        }

        ButterKnife.bind(this, view);
        if (savedInstanceState != null) {
            // Restore last state
            mGame = savedInstanceState.getParcelable(PARAM_SAVED_INSTANCE_STATE_GAME);
            if (savedInstanceState.containsKey(PARAM_SAVED_INSTANCE_STATE_RECORD)) {
                mRecord = savedInstanceState.getParcelable(PARAM_SAVED_INSTANCE_STATE_RECORD);
            }
        }
        enableActionBarHomeButton(true);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(PARAM_SAVED_INSTANCE_STATE_GAME, mGame);
        if (mRecord != null) {
            outState.putParcelable(PARAM_SAVED_INSTANCE_STATE_RECORD, mRecord);
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
        if (mGame != null) {
            if (mRecord == null) {
                mPresenter.getRecord(mGame.getId());
            } else {
                setData(mRecord);
            }
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.destroy();
    }

    @Override
    public void setData(Record record) {
        mRecord = record;

        //fragment_detail_game_image
        setActionBarTitle(mGame.getName());
        fragment_detail_game.setData(mGame.getLogoURL(), mGame.getName());
        fragment_detail_record_user.setText(getText(R.string.record_user) + record.getUserFistPlace().getName());
        fragment_detail_record_time.setText(getText(R.string.record_time) + DateUtils.formatTime(getContext(), record.getTime()));
        if (record.getVideoURL() != null) {
            fragment_detail_video.setVisibility(View.VISIBLE);
        } else {
            fragment_detail_video.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.fragment_detail_video)
    public void onVideoClick() {
        mPresenter.navigationGoToExternalUrl(mRecord.getVideoURL());
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                mPresenter.navigationBack(fragment_detail_game);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showLoading() {
        fragment_detail_loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        fragment_detail_loading.setVisibility(View.GONE);
    }

    @Override
    public void showGenericError() {
        showToastError(getString(R.string.generic_error));
    }
}
