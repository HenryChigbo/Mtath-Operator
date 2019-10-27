package com.bluapp.mathkindle.Utils;

import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;

import com.bluapp.mathkindle.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import java.util.List;


public class HistoryListAdapter extends AbstractItem<HistoryListAdapter, HistoryListAdapter.ViewHolder> {

    private final int VIEW_TYPE = 2222;
    private HistoryListModel historyListModel;

    public HistoryListAdapter(HistoryListModel historyListModel) {
        this.historyListModel = historyListModel;
    }

    public HistoryListModel getHistoryListModel() {
        return historyListModel;
    }

    @NonNull
    @Override
    public ViewHolder getViewHolder(@NonNull View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return VIEW_TYPE;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.history_list;
    }


    public class ViewHolder extends FastAdapter.ViewHolder<HistoryListAdapter> {
        private AppCompatTextView attemptnameTxt;
        private AppCompatTextView dateTime;


        private ViewHolder(View itemView) {
            super(itemView);
            attemptnameTxt = (AppCompatTextView) itemView.findViewById(R.id.attemptnameTxt);
            dateTime = (AppCompatTextView) itemView.findViewById(R.id.dateTime);
        }

        @Override
        public void bindView(@NonNull HistoryListAdapter item, @NonNull List<Object> payloads) {
            String attemptname = item.getHistoryListModel().getAttemptname();
            attemptnameTxt.setText(attemptname.substring(0, 1).toUpperCase()+attemptname.substring(1));
            dateTime.setText(item.getHistoryListModel().getAttempteddate());
        }


        @Override
        public void unbindView(@NonNull HistoryListAdapter item) {
            attemptnameTxt.setText(null);
            dateTime.setText(null);
        }

    }

}
