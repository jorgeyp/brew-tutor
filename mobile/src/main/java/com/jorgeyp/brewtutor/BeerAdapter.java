package com.jorgeyp.brewtutor;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jorgeyp.brewtutor.model.Beer;

import java.util.List;

/**
 * Created by jorge on 15/4/15.
 */
public class BeerAdapter extends RecyclerView.Adapter<BeerAdapter.BeerViewHolder> {
    List<Beer> beers;

    public BeerAdapter(List<Beer> beers) {
        this.beers = beers;
    }

    @Override
    public BeerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.beer_card, viewGroup, false);
        BeerViewHolder beerViewHolder = new BeerViewHolder(v);
        return beerViewHolder;
    }

    @Override
    public void onBindViewHolder(BeerViewHolder beerViewHolder, int i) {
        Beer beer = beers.get(i);
        String timeUnits = beerViewHolder.context.getString(R.string.time_units);
        String abvUnits = beerViewHolder.context.getString(R.string.abv_units);
        String ibuUnits = beerViewHolder.context.getString(R.string.ibu_units);
        String ebcUnits = beerViewHolder.context.getString(R.string.ebc_units);
//        beerViewHolder.imageView
        beerViewHolder.nameTextView.setText(beer.getName());
        beerViewHolder.timeTextView.setText(String.valueOf(beer.getTime()) + timeUnits);
        beerViewHolder.abvTextView.setText(String.valueOf(beer.getAbv()) + abvUnits);
        beerViewHolder.ibuTextView.setText(String.valueOf(beer.getIbu()) + ibuUnits);
        beerViewHolder.ebcTextView.setText(String.valueOf(beer.getEbc()) + ebcUnits);
    }

    @Override
    public int getItemCount() {
        return beers.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class BeerViewHolder extends RecyclerView.ViewHolder {
        protected CardView cardView;
        protected ImageView imageView;
        protected TextView nameTextView;
        protected TextView timeTextView;
        protected TextView abvTextView;
        protected TextView ibuTextView;
        protected TextView ebcTextView;
        protected Context context;

        public BeerViewHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.beer_card);
            imageView = (ImageView) v.findViewById(R.id.beerImage);
            nameTextView = (TextView) v.findViewById(R.id.nameText);
            timeTextView = (TextView) v.findViewById(R.id.timeText);
            abvTextView = (TextView) v.findViewById(R.id.abvText);
            ibuTextView = (TextView) v.findViewById(R.id.ibuText);
            ebcTextView = (TextView) v.findViewById(R.id.ebcText);
            context = v.getContext();
        }
    }
}
