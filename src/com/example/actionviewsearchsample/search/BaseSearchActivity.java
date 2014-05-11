
package com.example.actionviewsearchsample.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

import com.example.actionviewsearchsample.MainActivity;
import com.example.actionviewsearchsample.R;

public abstract class BaseSearchActivity extends FragmentActivity {

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_fragment_container);
      getActionBar().setDisplayHomeAsUpEnabled(true);
      handleIntent(getIntent());      
   }

   @Override
   protected void onNewIntent(Intent intent) {
      setIntent(intent);
      handleIntent(intent);
   }

   protected abstract void handleIntent(Intent intent);

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