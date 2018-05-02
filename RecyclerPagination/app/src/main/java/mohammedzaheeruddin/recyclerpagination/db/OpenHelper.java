package mohammedzaheeruddin.recyclerpagination.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by mohammedzaheeruddin on 25-Mar-18.
 */
public class OpenHelper extends SQLiteOpenHelper {

    public OpenHelper(Context context) {
        super(context,
                DaoUtils.DATABASE_NAME,
                null,
                DaoUtils.DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        // Creating User Details Table ..  .
        ArrayList<String> lColumns = DaoUtils.getUserTableColumns();

        StringBuffer lUserDetailsTable = new StringBuffer();
        lUserDetailsTable.append("CREATE TABLE ");
        lUserDetailsTable.append(DaoUtils.DATABASE_USER_DETAILS_TABLE_NAME);
        lUserDetailsTable.append(" (id INTEGER PRIMARY KEY");

        for (int i = 0; i < lColumns.size(); i++) {
            lUserDetailsTable.append(", ");
            lUserDetailsTable.append(lColumns.get(i));
            lUserDetailsTable.append(" TEXT");

        }
        lUserDetailsTable.append(")");
        db.execSQL(lUserDetailsTable.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {
        // TODO Auto-generated method stub

    }
}
