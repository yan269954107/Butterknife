package butterknife.internal;

import android.view.View;

/**
 * A {@linkplain View.OnClickListener click listener} that debounces multiple clicks posted in the
 * same frame. A click on one button disables all buttons for that frame.
 */
public abstract class DebouncingOnClickListener implements View.OnClickListener {

  static long clickTime = 0;

  @Override
  public final void onClick(View v) {
    long time = System.currentTimeMillis();
    if (time - clickTime < 500) {
      clickTime = time;
      return;
    }
    clickTime = time;
    doClick(v);
  }

  public abstract void doClick(View v);
}

