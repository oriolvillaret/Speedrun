package oriolvillaret.com.speedrun.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;
import oriolvillaret.com.speedrun.R;
import oriolvillaret.com.speedrun.model.Game;
import oriolvillaret.com.speedrun.presenter.MasterListPresenter;
import oriolvillaret.com.speedrun.ui.adapter.GameRecyclerViewAdapter;


public class MasterListFragment extends BaseFragment implements MasterListPresenter.MasterListInterface, GameRecyclerViewAdapter.OnItemClickListener {

    private MasterListPresenter mPresenter;
    GameRecyclerViewAdapter adapter;


    @BindView(R.id.fragment_master_list_recycler)
    RecyclerView fragment_master_list_recycler;

    @BindView(R.id.activity_main_loading)
    View activity_main_loading;

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
        return view;
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
        mPresenter.getData();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.destroy();
    }

    @Override
    public void setData(List<Game> games) {
        adapter = new GameRecyclerViewAdapter(games, this);
        fragment_master_list_recycler.setAdapter(adapter);

    }

    @Override
    public void showLoading() {
        activity_main_loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        activity_main_loading.setVisibility(View.GONE);
    }

    @Override
    public void showGenericError() {
        showToastError(getString(R.string.generic_error));
    }

    @Override
    public void onItemClick(View view, Game item) {
        Bundle args = new Bundle();
        args.putSerializable(DetailFragment.GAME_PARAM, item);
        Navigation.findNavController(view).navigate(R.id.action_masterListFragment_to_detailFragment, args);
    }

}
