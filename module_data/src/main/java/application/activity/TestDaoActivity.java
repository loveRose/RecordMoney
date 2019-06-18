package application.activity;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lvyerose.recordmoney.lib_base.adapter.BaseRecyclerAdapter;
import com.lvyerose.recordmoney.lib_base.adapter.BaseViewHolder;
import com.lvyerose.recordmoney.lib_base.base.BaseActivity;
import com.lvyerose.recordmoney.module_data.DatabaseHelper;
import com.lvyerose.recordmoney.module_data.R;
import com.lvyerose.recordmoney.module_data.account.AccountEntity;

import java.util.List;


public class TestDaoActivity extends BaseActivity {
    RecyclerView recyclerView;
    EditText nameEdt, descEdt;
    Button insertBtn;

    List<AccountEntity> list;

    @Override
    protected int setContentLayout() {
        return R.layout.module_data_activity_test_dao;
    }

    @Override
    protected void startAction(Bundle savedInstanceState) {
        recyclerView = findViewById(R.id.recycler_view_content);
        nameEdt = findViewById(R.id.edt_input_name);
        descEdt = findViewById(R.id.edt_input_desc);
        insertBtn = findViewById(R.id.btn_insert_data);

        insertBtn.setOnClickListener(v -> {
            String name = nameEdt.getText().toString().trim();
            String desc = descEdt.getText().toString().trim();
            AccountEntity entity = new AccountEntity();
            entity.setUserName(name);
            entity.setPassword(desc);
            DatabaseHelper.getInstance().insert(DatabaseHelper.getInstance().getDaoSession().getAccountEntityDao(), entity);
            queryData();
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        queryData();
    }

    private void queryData() {
        list = DatabaseHelper.getInstance().query(DatabaseHelper.getInstance().getDaoSession().getAccountEntityDao());
        recyclerView.setAdapter(new SimpleAdapter(this, list, R.layout.module_data_simple_list_layout));
    }


    public class SimpleAdapter extends BaseRecyclerAdapter<AccountEntity> {

        /**
         * @param context
         * @param list
         * @param itemLayoutId
         */
        public SimpleAdapter(Context context, @Nullable List<AccountEntity> list, int itemLayoutId) {
            super(context, list, itemLayoutId);
        }

        @Override
        protected void convert(BaseViewHolder holder, AccountEntity testEntity, int position, List<Object> payloads) {
            ((TextView) holder.getView(R.id.item_name)).setText(testEntity.getUserName());
            ((TextView) holder.getView(R.id.item_desc)).setText(testEntity.getPassword());
        }
    }

}
