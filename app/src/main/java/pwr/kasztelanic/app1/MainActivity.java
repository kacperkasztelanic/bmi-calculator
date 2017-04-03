package pwr.kasztelanic.app1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.ShareActionProvider;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Locale;

import butterknife.ButterKnife;
<<<<<<< HEAD
import butterknife.BindView;
=======
import butterknife.InjectView;
>>>>>>> 1155a45db0432ac5b6b6dca40e2451fa29383c37

import pwr.kasztelanic.app1.counters.CountBMIForKgM;
import pwr.kasztelanic.app1.counters.ICountBMI;
import pwr.kasztelanic.app1.utils.ImperialMetricsUnitsConverter;
import pwr.kasztelanic.app1.utils.WeightJudge;
import pwr.kasztelanic.app1.utils.WeightStatus;

<<<<<<< HEAD
public class MainActivity extends Activity
=======
public class MainActivity extends Activity implements View.OnFocusChangeListener, TextWatcher, AdapterView.OnItemSelectedListener
>>>>>>> 1155a45db0432ac5b6b6dca40e2451fa29383c37
{
    private static final int LB_ITEM_POSITION = 1;
    private static final int FT_ITEM_POSITION = 1;
    private static final String BMI_RES_FORMAT = "%.1f";

    private static final String MASS_RES = "mass";
    private static final String MASS_RES_SP = "massSP";
    private static final String HEIGHT_RES = "height";
    private static final String HEIGHT_RES_SP = "heightSP";
    private static final String BMI_RES = "bmi";
    private static final String HEIGHT_UNIT_RES = "heightUnitRes";
    private static final String HEIGHT_UNIT_RES_SP = "heightUnitResSP";
    private static final String MASS_UNIT_RES = "massUnitRes";
    private static final String MASS_UNIT_RES_SP = "massUnitResSP";
    private static final String RESULTSHOWN_RES = "reloadRes";

    private final ICountBMI countBMI = new CountBMIForKgM();
    private ShareActionProvider shareActionProvider;

<<<<<<< HEAD
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.yourResultTV)
    TextView yourResultTV;
    @BindView(R.id.resultTV)
    TextView resultTV;
    @BindView(R.id.resultCommentTV)
    TextView resultCommentTV;
    @BindView(R.id.massET)
    EditText massET;
    @BindView(R.id.heightET)
    EditText heightET;
    @BindView(R.id.massUnitSpinner)
    Spinner massUnitSpinner;
    @BindView(R.id.heightUnitSpinner)
=======
    @InjectView(R.id.scrollView)
    ScrollView scrollView;
    @InjectView(R.id.yourResultTV)
    TextView yourResultTV;
    @InjectView(R.id.resultTV)
    TextView resultTV;
    @InjectView(R.id.resultCommentTV)
    TextView resultCommentTV;
    @InjectView(R.id.massET)
    EditText massET;
    @InjectView(R.id.heightET)
    EditText heightET;
    @InjectView(R.id.massUnitSpinner)
    Spinner massUnitSpinner;
    @InjectView(R.id.heightUnitSpinner)
>>>>>>> 1155a45db0432ac5b6b6dca40e2451fa29383c37
    Spinner heightUnitSpinner;

    private String userInputMass = null;
    private String userInputHeight = null;
    private float mass;
    private float height;
    private float bmi;
    private int massUnitSelection;
    private int heightUnitSelection;
    private boolean isResultsAreaShown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        ButterKnife.bind(this);
        massET.setOnFocusChangeListener(focusChangeListener);
        heightET.setOnFocusChangeListener(focusChangeListener);
        massET.addTextChangedListener(textWatcher);
        heightET.addTextChangedListener(textWatcher);
        massUnitSpinner.setOnItemSelectedListener(itemSelectedListener);
        heightUnitSpinner.setOnItemSelectedListener(itemSelectedListener);
=======
        ButterKnife.inject(this);
        massET.setOnFocusChangeListener(this);
        heightET.setOnFocusChangeListener(this);
        massET.addTextChangedListener(this);
        heightET.addTextChangedListener(this);
        massUnitSpinner.setOnItemSelectedListener(this);
        heightUnitSpinner.setOnItemSelectedListener(this);
>>>>>>> 1155a45db0432ac5b6b6dca40e2451fa29383c37
        setUserInputFromStrings();
        setUserUnitSelection();
        if (savedInstanceState != null)
            recoverState(savedInstanceState);
        else
            loadUserInput();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        retrieveUserInputToStrings();
        retrieveUserUnitSelection();
        outState.putString(MASS_RES, userInputMass);
        outState.putString(HEIGHT_RES, userInputHeight);
        outState.putInt(MASS_UNIT_RES, massUnitSelection);
        outState.putInt(HEIGHT_UNIT_RES, heightUnitSelection);
        outState.putBoolean(RESULTSHOWN_RES, isResultsAreaShown);
        outState.putFloat(BMI_RES, bmi);
        super.onSaveInstanceState(outState);
    }

    private void recoverState(Bundle savedInstanceState)
    {
        bmi = savedInstanceState.getFloat(BMI_RES);
        userInputMass = savedInstanceState.getString(MASS_RES);
        userInputHeight = savedInstanceState.getString(HEIGHT_RES);
        massUnitSelection = savedInstanceState.getInt(MASS_UNIT_RES);
        heightUnitSelection = savedInstanceState.getInt(HEIGHT_UNIT_RES);
        setUserInputFromStrings();
        setUserUnitSelection();
        if (massUnitSelection == LB_ITEM_POSITION)
            mass = ImperialMetricsUnitsConverter.kgToLb(mass);
        if (heightUnitSelection == FT_ITEM_POSITION)
            height = ImperialMetricsUnitsConverter.mToFt(height);
        isResultsAreaShown = savedInstanceState.getBoolean(RESULTSHOWN_RES);
        if (isResultsAreaShown)
            putResultsToScreen();
    }

    private void retrieveUserInputToStrings()
    {
        userInputMass = massET.getText().toString();
        userInputHeight = heightET.getText().toString();
    }

    private void setUserInputFromStrings()
    {
        if (userInputMass != null && userInputMass.trim().length() != 0)
            massET.setText(userInputMass);
        if (userInputHeight != null && userInputHeight.trim().length() != 0)
            heightET.setText(userInputHeight);
    }

    private void retrieveUserUnitSelection()
    {
        massUnitSelection = massUnitSpinner.getSelectedItemPosition();
        heightUnitSelection = heightUnitSpinner.getSelectedItemPosition();
    }

    private void setUserUnitSelection()
    {
        massUnitSpinner.setSelection(massUnitSelection);
        heightUnitSpinner.setSelection(heightUnitSelection);
    }

    private boolean validateUserInputAndShowWarnings()
    {
        boolean ok = true;
        if (!isMassInputCorrect())
        {
            ok = false;
            massET.setError(getString(R.string.incorrect_value));
        }
        if (!isHeightInputCorrect())
        {
            ok = false;
            heightET.setError(getString(R.string.incorrect_value));
        }
        return ok;
    }

    public void calculateOnClick(View view)
    {
        clearResultsArea();
        clearErrors();
        invalidateOptionsMenu();
        hideSoftKeyboard(view);
        retrieveUserInputToStrings();
        if (validateUserInputAndShowWarnings())
        {
            bmi = countBMI.countBMI(mass, height);
            putResultsToScreen();
        }
    }

    private void putResultsToScreen()
    {
        WeightStatus weightStatus = WeightJudge.getStatus(bmi);
        setResultsAreaTextColorAccToWeightStatus(weightStatus);
        resultTV.setText(String.format(Locale.US, BMI_RES_FORMAT, bmi));
        setWeightComment(weightStatus);
        showResultsArea();
        scrollToBottom();
        isResultsAreaShown = true;
    }

    private void clearResultsArea()
    {
        hideResultsArea();
        scrollToTop();
        isResultsAreaShown = false;
    }

    private void showResultsArea()
    {
        yourResultTV.setVisibility(View.VISIBLE);
        resultTV.setVisibility(View.VISIBLE);
        resultCommentTV.setVisibility(View.VISIBLE);
    }

    private void hideResultsArea()
    {
        yourResultTV.setVisibility(View.INVISIBLE);
        resultTV.setVisibility(View.INVISIBLE);
        resultCommentTV.setVisibility(View.INVISIBLE);
    }

    private boolean isMassInputCorrect()
    {
        if (!NumberUtils.isNumber(userInputMass))
            return false;
        ensureMassUnit();
        return countBMI.isValidMass(mass);
    }

    private boolean isHeightInputCorrect()
    {
        if (!NumberUtils.isNumber(userInputHeight))
            return false;
        ensureHeightUnit();
        return countBMI.isValidHeight(height);
    }

    private void ensureMassUnit()
    {
        massUnitSelection = massUnitSpinner.getSelectedItemPosition();
        if (massUnitSelection == LB_ITEM_POSITION)
            mass = ImperialMetricsUnitsConverter.lbToKg(Float.parseFloat(userInputMass));
        else
            mass = Float.parseFloat(userInputMass);
    }

    private void ensureHeightUnit()
    {
        heightUnitSelection = heightUnitSpinner.getSelectedItemPosition();
        if (heightUnitSelection == FT_ITEM_POSITION)
            height = ImperialMetricsUnitsConverter.ftToM(Float.parseFloat(userInputHeight));
        else
            height = Float.parseFloat(userInputHeight);
    }

    private void setWeightComment(WeightStatus weightStatus)
    {
        switch (weightStatus)
        {
            case OK:
                resultCommentTV.setText(getString(R.string.ok).toUpperCase());
                break;
            case OVERWEIGHT:
                resultCommentTV.setText(getString(R.string.overweight).toUpperCase());
                break;
            case UNDERWEIGHT:
                resultCommentTV.setText(getString(R.string.underweight).toUpperCase());
                break;
            case OBESITY:
                resultCommentTV.setText(getString(R.string.obesity).toUpperCase());
                break;
        }
    }

    private void setResultsAreaTextColorAccToWeightStatus(WeightStatus weightStatus)
    {
        setTextColorAccToWeightStatus(yourResultTV, weightStatus);
        setTextColorAccToWeightStatus(resultTV, weightStatus);
        setTextColorAccToWeightStatus(resultCommentTV, weightStatus);
    }

    private void setTextColorAccToWeightStatus(TextView tv, WeightStatus weightStatus)
    {
        switch (weightStatus)
        {
            case OK:
                tv.setTextColor(getColor(R.color.green));
                break;
            case OVERWEIGHT:
                tv.setTextColor(getColor(R.color.orange));
                break;
            case UNDERWEIGHT:
            case OBESITY:
                tv.setTextColor(getColor(R.color.red));
                break;
        }
    }

    private boolean isMassUnitChanged()
    {
        return massUnitSpinner.getSelectedItemPosition() != massUnitSelection;
    }

    private boolean isHeightUnitChanged()
    {
        return heightUnitSpinner.getSelectedItemPosition() != heightUnitSelection;
    }

    private void hideSoftKeyboard(View view)
    {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void scrollToBottom()
    {
        scrollView.post(new Runnable()
        {
            @Override
            public void run()
            {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }

    private void scrollToTop()
    {
        scrollView.post(new Runnable()
        {
            @Override
            public void run()
            {
                scrollView.fullScroll(ScrollView.FOCUS_UP);
            }
        });
    }

    @Override
<<<<<<< HEAD
=======
    public void onFocusChange(View view, boolean hasFocus)
    {
        if (!hasFocus)
            hideSoftKeyboard(view);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after)
    {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count)
    {
        boolean changedByUser = before != count;
        if (isResultsAreaShown && changedByUser)
            clearResultsArea();
    }

    @Override
    public void afterTextChanged(Editable s)
    {
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        if (isMassUnitChanged() || isHeightUnitChanged())
            clearResultsArea();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }

    @Override
>>>>>>> 1155a45db0432ac5b6b6dca40e2451fa29383c37
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.share_mi);
        shareActionProvider = (ShareActionProvider) menuItem.getActionProvider();
        menuItem.setEnabled(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        if (isResultsAreaShown)
        {
            menu.findItem(R.id.share_mi).setEnabled(true);
            shareResult();
        } else
            menu.findItem(R.id.share_mi).setEnabled(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.share_mi:
                shareResult();
                return true;
            case R.id.save_mi:
                saveUserInput();
                return true;
            case R.id.reset_mi:
                reset();
                return true;
            case R.id.about_mi:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void shareResult()
    {
        setIntent(String.format(Locale.US, getString(R.string.shareResult) + " " + BMI_RES_FORMAT + ".", bmi));
    }


    private void setIntent(String text)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    private void saveUserInput()
    {
        retrieveUserInputToStrings();
        retrieveUserUnitSelection();
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        if (validateUserInputAndShowWarnings())
        {
            editor.putString(MASS_RES_SP, userInputMass);
            editor.putString(HEIGHT_RES_SP, userInputHeight);
            editor.putInt(MASS_UNIT_RES_SP, massUnitSelection);
            editor.putInt(HEIGHT_UNIT_RES_SP, heightUnitSelection);
            editor.apply();
            Toast.makeText(this, getString(R.string.savedToast), Toast.LENGTH_SHORT).show();
        }
    }

    private void loadUserInput()
    {
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        userInputMass = sharedPref.getString(MASS_RES_SP, null);
        userInputHeight = sharedPref.getString(HEIGHT_RES_SP, null);
        massUnitSelection = sharedPref.getInt(MASS_UNIT_RES_SP, 0);
        heightUnitSelection = sharedPref.getInt(HEIGHT_UNIT_RES_SP, 0);
        setUserInputFromStrings();
        setUserUnitSelection();
    }

    private void clearErrors()
    {
        massET.setError(null);
        heightET.setError(null);
    }

    private void reset()
    {
        clearResultsArea();
        clearErrors();
        invalidateOptionsMenu();
        massET.setText(null);
        heightET.setText(null);
        getPreferences(Context.MODE_PRIVATE).edit().clear().apply();
        Toast.makeText(this, getString(R.string.reset), Toast.LENGTH_SHORT).show();
    }
<<<<<<< HEAD

    private View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener()
    {
        @Override
        public void onFocusChange(View view, boolean hasFocus)
        {
            if (!hasFocus)
                hideSoftKeyboard(view);
        }
    };

    private AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener()
    {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
        {
            if (isMassUnitChanged() || isHeightUnitChanged())
                clearResultsArea();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent)
        {

        }
    };

    private TextWatcher textWatcher = new TextWatcher()
    {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            boolean changedByUser = before != count;
            if (isResultsAreaShown && changedByUser)
                clearResultsArea();

        }

        @Override
        public void afterTextChanged(Editable s)
        {

        }
    };
=======
>>>>>>> 1155a45db0432ac5b6b6dca40e2451fa29383c37
}
