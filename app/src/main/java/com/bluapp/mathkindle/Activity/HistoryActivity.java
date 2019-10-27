package com.bluapp.mathkindle.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.bluapp.mathkindle.Database.AppDAO;
import com.bluapp.mathkindle.Database.AppDatabase;
import com.bluapp.mathkindle.R;
import com.bluapp.mathkindle.Utils.AppConstants;
import com.bluapp.mathkindle.Utils.CustomDividerItemDecoration;
import com.bluapp.mathkindle.Utils.History;
import com.bluapp.mathkindle.Utils.HistoryListAdapter;
import com.bluapp.mathkindle.Utils.HistoryListModel;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AppDAO appDAO;
    private ItemAdapter<HistoryListAdapter> historyitemAdapter;
    public FastAdapter<HistoryListAdapter> historyfastAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        recyclerView = (RecyclerView) findViewById(R.id.list);
        appDAO = (AppDAO) AppDatabase.getInstance(getApplicationContext()).appDAO();
        initRecyclerView();
        getHistoryList();
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new CustomDividerItemDecoration(HistoryActivity.this));
    }

    public void getHistoryList() {
        List<HistoryListAdapter> dataSource = new ArrayList<>();
        historyitemAdapter = new ItemAdapter<>();
        historyfastAdapter = FastAdapter.with(historyitemAdapter);
        recyclerView.setAdapter(historyfastAdapter);
        appDAO.getAllHistory().observe(this, (List<History> history) -> {
            if(dataSource.size() > 0){
                dataSource.clear();
                historyitemAdapter.clear();
            }
            for (int i = 0; i < history.size(); i++) {
                int id = history.get(i).getId();
                String attemptname = history.get(i).getAttemptname();
                String totalquestion = history.get(i).getTotalquestion();
                String correctquestion = history.get(i).getCorrectquestion();
                String wrongquestion = history.get(i).getWrongquestion();
                String attempteddate = history.get(i).getAttempteddate();
                String arithmeticoperator = history.get(i).getArithmeticoperator();
                String skippedquestion = history.get(i).getSkippedquestion();
                dataSource.add(new HistoryListAdapter(new HistoryListModel(id, attemptname, totalquestion, correctquestion, wrongquestion, attempteddate, arithmeticoperator,skippedquestion)));
            }
            historyitemAdapter.add(dataSource);
        });
        historyfastAdapter.withOnClickListener((v, adapter, item, position) -> {
            Intent intent = new Intent(HistoryActivity.this, SummaryActivity.class);
            intent.putExtra(AppConstants.TOTALQUESTION, item.getHistoryListModel().getTotalquestion());
            intent.putExtra(AppConstants.CORRECTQUESTION, item.getHistoryListModel().getCorrectquestion());
            intent.putExtra(AppConstants.WRONGQUESTION, item.getHistoryListModel().getWrongquestion());
            intent.putExtra(AppConstants.ATTEMPTEDDATE, item.getHistoryListModel().getAttempteddate());
            intent.putExtra(AppConstants.ARITHMETIC_OPERATOR, item.getHistoryListModel().getArithmeticoperator());
            intent.putExtra(AppConstants.SKIPPEDQUESTION, item.getHistoryListModel().getSkippedquestion());
            startActivity(intent);
         return false;
         });
    }

}
