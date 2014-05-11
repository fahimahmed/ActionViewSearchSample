
package com.example.actionviewsearchsample.search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.actionviewsearchsample.MainActivity;
import com.example.actionviewsearchsample.R;

public class SearchDetailsActivity extends Activity {

   public static final String KEY_WORD = "word";

   public static final String[] ENGLISH_WORDS = {"one", "two", "three"};
   private static final String[] GERMAN_TRANSLATIONS = {"eins", "zwei", "drei"};
   
   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_detail);
		Bundle bundle = getIntent().getExtras();
		// very inefficient, but well, that's not the point of this demo...
		String englishWord =  bundle.getString(KEY_WORD);
      ((TextView)findViewById(R.id.english)).setText(englishWord);
		for (int i = 0; i < ENGLISH_WORDS.length; i++) {
		   if (ENGLISH_WORDS[i].equals(englishWord)) {
		      ((TextView)findViewById(R.id.german)).setText(GERMAN_TRANSLATIONS[i]);
		      break;
		   }
		}
      getActionBar().setDisplayHomeAsUpEnabled(true);
	}

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()) {
         case android.R.id.home:
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. Use NavUtils to allow users
            // to navigate up one level in the application structure. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            NavUtils.navigateUpTo(this,
                  new Intent(this, MainActivity.class));
            return true;
      }
      return super.onOptionsItemSelected(item);
   }	

}