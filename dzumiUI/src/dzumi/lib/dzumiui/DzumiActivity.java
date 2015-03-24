package dzumi.lib.dzumiui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class DzumiActivity extends ActionBarActivity{

	public Spinner spinner;
	public FragmentManager fragmentManager;
	int container;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		fragmentManager = getSupportFragmentManager();
		container = R.id.container;
	}

	public void replaceFragment(Fragment fragment)
	{
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.replace(container, fragment);
		transaction.commit();
	}
	
	public void replaceFragment(Fragment fragment, boolean isAddToBackStack)
	{
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.replace(container, fragment);
		if(isAddToBackStack)
			transaction.addToBackStack("tag");
		transaction.commit();
	}

	@SuppressLint("NewApi")
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main_menu, menu);

		MenuItem spinnerItem = menu.findItem(R.id.mn_category_spinner_item);
		spinnerItem.setActionView(R.layout.spinner_action);

		spinner = (Spinner) MenuItemCompat.getActionView(spinnerItem);
		return true;
	}

	public void  setAdapter(SpinnerAdapter adapter)
	{
		spinner.setAdapter(adapter);
	}
}
