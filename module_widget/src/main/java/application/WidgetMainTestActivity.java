package application;

import android.os.Bundle;
import android.view.View;

import com.lvyerose.recordmoney.lib_base.base.BaseActivity;
import com.lvyerose.recordmoney.lib_widget.menu_add.MenuAddView;
import com.lvyerose.recordmoney.module_widget.R;

public class WidgetMainTestActivity extends BaseActivity {
    MenuAddView menuAddView;

    @Override
    protected int setContentLayout() {
        return R.layout.module_widget_activity_main_test_layout;
    }

    @Override
    protected void startAction(Bundle savedInstanceState) {
        menuAddView = findViewById(R.id.test_menu_add_view);
    }

    public void showTest(View view) {
        menuAddView.setShow(true);
    }

    public void hintTest(View view) {
        menuAddView.setShow(false);
    }
}
