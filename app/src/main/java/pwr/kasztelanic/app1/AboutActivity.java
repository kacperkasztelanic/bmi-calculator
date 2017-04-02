package pwr.kasztelanic.app1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class AboutActivity extends Activity
{
    @InjectView(R.id.about_version)
    TextView versionTV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        //noinspection ConstantConditions
        getActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.inject(this);
        versionTV.setText(getString(R.string.about_version, BuildConfig.VERSION_NAME));
    }
}
