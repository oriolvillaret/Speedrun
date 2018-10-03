package oriolvillaret.com.speedrun.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import oriolvillaret.com.components.ItemGameView;
import oriolvillaret.com.speedrun.R;
import oriolvillaret.com.speedrun.model.Game;


public class DetailFragment extends Fragment {

    public static final String GAME_PARAM = "game_param";

    @BindView(R.id.item)
    ItemGameView item;

    Game mGame;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public DetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        if (getArguments()!=null && getArguments().containsKey(GAME_PARAM)) {
            mGame = (Game) getArguments().getSerializable(GAME_PARAM);
        }
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);






    }
}
