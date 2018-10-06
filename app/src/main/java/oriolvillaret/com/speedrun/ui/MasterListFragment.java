package oriolvillaret.com.speedrun.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import oriolvillaret.com.speedrun.R;
import oriolvillaret.com.speedrun.models.Game;
import oriolvillaret.com.speedrun.presenters.MasterListPresenter;
import oriolvillaret.com.speedrun.ui.adapters.GameRecyclerViewAdapter;


public class MasterListFragment extends BaseFragment implements MasterListPresenter.MasterListInterface, GameRecyclerViewAdapter.OnItemClickListener {

    private static final String PARAM_SAVED_INSTANCE_STATE_GAMES = "PARAM_GAMES";

    private MasterListPresenter mPresenter;
    GameRecyclerViewAdapter adapter;
    ArrayList<Game> mGames;

    @BindView(R.id.fragment_master_list_recycler)
    RecyclerView fragment_master_list_recycler;

    @BindView(R.id.fragment_master_list_loading)
    View fragment_master_list_loading;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter == null) {
            this.mPresenter = new MasterListPresenter();
        }
        if (savedInstanceState == null) {
            this.mPresenter.attachView(this);
        }

        mLayoutId = R.layout.fragment_master_list;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, view);

        if (savedInstanceState != null) {
            // Restore last state
            mGames = savedInstanceState.getParcelableArrayList(PARAM_SAVED_INSTANCE_STATE_GAMES);
        }

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mGames != null) {
            outState.putParcelableArrayList(PARAM_SAVED_INSTANCE_STATE_GAMES, mGames);
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        mPresenter.start();

        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        fragment_master_list_recycler.setLayoutManager(mLayoutManager);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();

        enableActionBarHomeButton(false);
        setActionBarTitle(getString(R.string.app_name));
        if (mGames != null) {
            drawList();
        }else{
            mPresenter.getData();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.destroy();
    }

    @Override
    public void setData(ArrayList<Game> games) {
        mGames = games;
        drawList();
    }

    private void drawList() {
        if (adapter == null) {
            adapter = new GameRecyclerViewAdapter(mGames, this);
            fragment_master_list_recycler.setAdapter(adapter);
        } else {
            adapter.setData(mGames);
            if (fragment_master_list_recycler.getAdapter()==null){
                fragment_master_list_recycler.setAdapter(adapter);
            }else{
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void showLoading() {
        fragment_master_list_loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        fragment_master_list_loading.setVisibility(View.GONE);
    }

    @Override
    public void showGenericError() {
        showToastError(getString(R.string.generic_error));
    }

    @Override
    public void onItemClick(View view, Game item) {
        mPresenter.navigationDetail(view, item);
    }

}
