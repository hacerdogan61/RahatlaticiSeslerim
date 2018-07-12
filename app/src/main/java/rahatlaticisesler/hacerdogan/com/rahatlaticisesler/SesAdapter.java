package rahatlaticisesler.hacerdogan.com.rahatlaticisesler;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class SesAdapter extends RecyclerView.Adapter<SesAdapter.MyViewHolder> {
    ArrayList<Integer> sesler;
    Context context;

    public SesAdapter(ArrayList<Integer> sesler) {
        this.sesler = sesler;
    }

    @Override
    public SesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rvitem_ses, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SesAdapter.MyViewHolder holder, int position) {
        final MediaPlayer mediaPlayer = MediaPlayer.create(context,sesler.get(position));
        holder.ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });

    }

    @Override
    public int getItemCount() {
        return sesler.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       public ImageView ivPlay, ivFavCikar;
       public SeekBar seekBar;
        public MyViewHolder(View v) {
            super(v);
            ivPlay= v.findViewById(R.id.ivPlay);
            ivFavCikar = v.findViewById(R.id.ivFavCikar);
            seekBar = v.findViewById(R.id.seekBar);
        }
    }
}
