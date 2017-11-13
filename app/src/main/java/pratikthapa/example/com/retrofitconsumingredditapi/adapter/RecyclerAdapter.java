package pratikthapa.example.com.retrofitconsumingredditapi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import pratikthapa.example.com.retrofitconsumingredditapi.R;
import pratikthapa.example.com.retrofitconsumingredditapi.model.Feed;
import pratikthapa.example.com.retrofitconsumingredditapi.model.children.Children;
import pratikthapa.example.com.retrofitconsumingredditapi.model.children.Data;
import pratikthapa.example.com.retrofitconsumingredditapi.model.children.Images;

/**
 * Created by pratikthapa on 11/9/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.RecyclerViewHolder>{

private ArrayList<Children> childrenArrayList;
private Context context;





    public RecyclerAdapter(ArrayList<Children> childrenArrayList,Context context ){
        this.childrenArrayList = childrenArrayList;
        this.context = context;



    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);

        RecyclerViewHolder recyclerViewHolder= new RecyclerViewHolder(view);

        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        try {
//            Picasso.with(context).load(childrenArrayList.get(position).getData().getPreview().getImages().get(0).getSource().getUrl()).into(holder.imageView);

            Glide.with(context).load(childrenArrayList.get(position).getData().getPreview().getImages().get(0).getSource().getUrl()).into(holder.imageView);

        } catch (Exception ex) {
        }


        holder.textView.setText(childrenArrayList.get(position).getData().getAuthor());
        holder.textView2.setText(childrenArrayList.get(position).getData().getContest_mode());
        holder.textView3.setText(childrenArrayList.get(position).getData().getSubreddit());
    }

    @Override
    public int getItemCount() {
        return childrenArrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView textView,textView2,textView3;
        ImageView imageView;

        public RecyclerViewHolder(View view){

            super(view);

            textView = view.findViewById(R.id.text_view);
            textView2 = view.findViewById(R.id.text_view2);
            textView3 = view.findViewById(R.id.text_view3);

            imageView = view.findViewById(R.id.imageView);
        }
    }
}
