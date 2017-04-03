package pwr.kasztelanic.app1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutActivity extends Activity
{
    @BindView(R.id.about_version)
    TextView versionTV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        //noinspection ConstantConditions
        getActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
        versionTV.setText(getString(R.string.about_version, BuildConfig.VERSION_NAME));
    }
}
