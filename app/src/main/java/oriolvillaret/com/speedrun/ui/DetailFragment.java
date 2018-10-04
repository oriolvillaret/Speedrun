package oriolvillaret.com.speedrun.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import oriolvillaret.com.components.ItemGameView;
import oriolvillaret.com.speedrun.R;
import oriolvillaret.com.speedrun.models.Game;
import oriolvillaret.com.speedrun.models.Record;
import oriolvillaret.com.speedrun.presenters.DetailPresenter;


public class DetailFragment extends BaseFragment implements DetailPresenter.DetailInterface {

    public static String GAME_PARAM = "game_param";
    private DetailPresenter mPresenter;
    private Game mGame;
    private Record mRecord;

    @BindView(R.id.fragment_detail_game)
    ItemGameView fragment_detail_game;
    @BindView(R.id.fragment_detail_record)
    TextView fragment_detail_record;
    @BindView(R.id.fragment_detail_video)
    Button fragment_detail_video;
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
        return view;
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
            mPresenter.getRecord(mGame.getId());
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
        fragment_detail_game.setData(mGame.getLogoURL(), mGame.getName());
        fragment_detail_record.setText(record.getUserFistPlace().getName() + " - " + record.getTime() + " s");
        if (record.getVideoURL() != null) {
            fragment_detail_video.setVisibility(View.VISIBLE);
        } else {
            fragment_detail_video.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.fragment_detail_video)
    public void onVideoClick() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mRecord.getVideoURL()));
        startActivity(browserIntent);
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
