package firebase.rnp.test.app.util;

import android.content.Context;

/**
 * http://stackoverflow.com/questions/19253786/how-to-copy-text-to-clip-board-in-android
 *
 * @author Farhan Khan farhan.khan@robotsandpencils.com;
 * @version 0.1
 * @since 2014-05-14
 */

public class ClipboardManager {

    @SuppressWarnings("deprecation")
    public boolean copyToClipboard(Context context, String label, String text) {
        try {
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context
                    .getSystemService(context.CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData
                    .newPlainText(label, text);
            clipboard.setPrimaryClip(clip);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
