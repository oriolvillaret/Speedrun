package oriolvillaret.com.speedrun.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import oriolvillaret.com.components.ItemGameView;
import oriolvillaret.com.speedrun.R;
import oriolvillaret.com.speedrun.models.Game;

public class GameRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Game> mDataset;
    private OnItemClickListener onItemClickListener;
    private final int VIEW_TYPE_ITEM = 1;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ItemGameView gameView;

        public ViewHolder(View v) {
            super(v);
            gameView = v.findViewById(R.id.item_game);
        }
    }

    public GameRecyclerViewAdapter(List<Game> items, GameRecyclerViewAdapter.OnItemClickListener onItemClickListener) {
        this.mDataset = items;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_master_list_item, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public int getItemCount() {
        return mDataset == null ? 0 : mDataset.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return VIEW_TYPE_ITEM;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof GameRecyclerViewAdapter.ViewHolder) {
            final int pos = position;
            Game game = mDataset.get(pos);

            ((GameRecyclerViewAdapter.ViewHolder) holder).gameView.setData(game.getLogoURL(), game.getName());
            ((GameRecyclerViewAdapter.ViewHolder) holder).gameView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(v, mDataset.get(pos));
                    }
                }
            });
        }
    }


    public interface OnItemClickListener {
        void onItemClick(View view, Game item);
    }
}
