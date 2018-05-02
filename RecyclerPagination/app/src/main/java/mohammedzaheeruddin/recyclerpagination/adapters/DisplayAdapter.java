package mohammedzaheeruddin.recyclerpagination.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import mohammedzaheeruddin.recyclerpagination.R;
import mohammedzaheeruddin.recyclerpagination.entity.DisplayItem;

/**
 * Created by mohammedzaheeruddin on 25-Mar-18.
 */
public class DisplayAdapter extends RecyclerView.Adapter{

    private Context context;
    private final int ITEM_VIEW_TYPE_BASIC = 0;
    private final int ITEM_VIEW_TYPE_FOOTER = 1;

    private List<DisplayItem> displayItem,temporaryList;
    boolean value;

    public DisplayAdapter(Context c, List<DisplayItem> cardItem) {
        this.context = c;
        this.displayItem = cardItem;
        this.temporaryList = new ArrayList<>();
        temporaryList.addAll(cardItem);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        if (viewType == ITEM_VIEW_TYPE_BASIC) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_display, parent, false);
            vh = new CardViewHolder(v);
        }else{
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.prograss_bar, parent, false);
            vh = new ProgressViewHolder(v);
        }
        return vh;
    }

    public void refreshAdapter(Context c, boolean value, List<DisplayItem> tempCardItem){
        this.context = c;
        this.value = value;
        this.displayItem = tempCardItem;
        this.temporaryList = new ArrayList<>();
        temporaryList.addAll(tempCardItem);
        notifyDataSetChanged();
    }

    public void filter(String charText,ArrayList<DisplayItem> item) {
        temporaryList.clear();
        temporaryList = new ArrayList<>();
        temporaryList.addAll(item);
        displayItem.clear();
        if(charText.length() > 0){
            for(int i=0; i < temporaryList.size(); i++){
                if(null != temporaryList.get(i)){
                    if(temporaryList.get(i).getUserName().toLowerCase(Locale.getDefault()).contains(charText)){
                        displayItem.add(temporaryList.get(i));
                    }
                }
            }
        }else{
            displayItem.addAll(temporaryList);
        }

        notifyDataSetChanged();

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CardViewHolder) {
            DisplayItem item = (DisplayItem) displayItem.get(position);

            Glide.with(context).load(item.getProfileImageUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(((CardViewHolder) holder).img_profile);
            ((CardViewHolder) holder).txt_name.setText(item.getUserName());
            ((CardViewHolder) holder).txt_reputation.setText(String.valueOf(item.getReputation()));

        }else {
            if (!value) {
                ((ProgressViewHolder) holder).progressBar.setVisibility(View.VISIBLE);
                ((ProgressViewHolder) holder).progressBar.setIndeterminate(true);
            } else ((ProgressViewHolder) holder).progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return displayItem.get(position) != null ? ITEM_VIEW_TYPE_BASIC : ITEM_VIEW_TYPE_FOOTER;
    }

    @Override
    public int getItemCount() {
        return displayItem == null ? 0: displayItem.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        public TextView txt_name,txt_reputation;
        public ImageView img_profile;

        public CardViewHolder(View v) {
            super(v);
            img_profile = (ImageView) v.findViewById(R.id.img_profile);
            txt_name = (TextView) v.findViewById(R.id.txt_name);
            txt_reputation = (TextView) v.findViewById(R.id.txt_reputation);
        }
    }

    public static class ProgressViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar progressBar;
        public ProgressViewHolder(View v) {
            super(v);
            progressBar = (ProgressBar) v.findViewById(R.id.progress_bar);
        }
    }
}
