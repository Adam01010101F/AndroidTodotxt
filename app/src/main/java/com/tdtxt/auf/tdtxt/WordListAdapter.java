package com.tdtxt.auf.tdtxt;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;
        private WordViewHolder(View itemView){
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }


    private final LayoutInflater mInflator;
    private List<Word> mWords;
    WordListAdapter(Context context) {mInflator = LayoutInflater.from(context);}

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = mInflator.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position){
        if(mWords != null){
            Word current = mWords.get(position);
            holder.wordItemView.setText(current.getWord());
        } else {
            //covers the case of data not being ready
            holder.wordItemView.setText("No Word");
        }
    }

    void setWords(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }

    //getItemCount() called many times, and when it is called,
    //mWords has not been updated (without checking, it would return null)
    @Override
    public int getItemCount(){
        if(mWords != null)
            return mWords.size();
        else return 0;
    }


}
